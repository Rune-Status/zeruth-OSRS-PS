package org.arcanium.game.world.update;

import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.info.RenderInfo;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerProt;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * The NPC renderer.
 *
 * @author Emperor
 */
public final class NPCRenderer {

    /**
     * Handles the NPC rendering for a player.
     *
     * @param player The player.
     */
    public static void render(Player player) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.NPC_INFO_SMALL.getPacketId(), PacketHeader.SHORT);
        IoBuffer maskBuffer = new IoBuffer(-1, -1, PacketHeader.NORMAL, ByteBuffer.allocate(1 << 16));
        RenderInfo info = player.getRenderInfo();
        List<NPC> localNpcs = info.getLocalNpcs();
        buffer.setBitAccess();
        buffer.putBits(8, localNpcs.size());
        for (Iterator<NPC> it = localNpcs.iterator(); it.hasNext(); ) {
            NPC npc = it.next();
            boolean withinDistance = player.getLocation().withinDistance(npc.getLocation(), 15);
            if (npc == null || npc.destroyed() || npc.isHidden(player) || !withinDistance || npc.getProperties().isTeleporting()) {
                buffer.putBits(1, 1).putBits(2, 3);
                it.remove();
                if (!withinDistance && npc.getAggressiveHandler() != null) {
                    npc.getAggressiveHandler().removeTolerance(player.getIndex());
                }
            } else {
                updateNPCMovement(npc, buffer);
                if (npc.getUpdateMasks().isUpdateRequired()) {
                    updateNPC(maskBuffer, npc);
                }
            }
        }
        if (localNpcs.size() < 255) {
            int added = 0;
            for (NPC npc : Repository.getNpcs()) {
                if (added >= 255 || localNpcs.size() >= 255) {
                    break;
                }
                if (npc == null || npc.destroyed() || npc.isHidden() || !player.getLocation().withinDistance(npc.getLocation(), 15)) {
                    continue;
                }
                if (localNpcs.contains(npc)) {
                    continue;
                }
                addNpc(player, npc, buffer);
                if (npc != null && npc.getUpdateMasks() != null && npc.getUpdateMasks().isUpdateRequired()) {
                    updateNPC(maskBuffer, npc);
                }
                added++;
            }
        }
        ByteBuffer masks = maskBuffer.toByteBuffer();
        masks.flip();
        if (masks.hasRemaining()) {
            buffer.putBits(15, 32767);
            buffer.setByteAccess();
            buffer.put(masks);
        } else {
            buffer.setByteAccess();
        }
        player.getSession().write(buffer);
    }

    /**
     * Adds an NPC.
     *
     * @param player The player.
     * @param npc    The npc.
     * @param buf    The outgoing packet.
     */
    private static void addNpc(Player player, NPC npc, IoBuffer buf) {
        int x = npc.getLocation().getX() - player.getLocation().getX();
        int y = npc.getLocation().getY() - player.getLocation().getY();
        if (x < 0) {
            x += 32;
        }
        if (y < 0) {
            y += 32;
        }
        buf.putBits(15, npc.getIndex());

        buf.putBits(5, x);
        buf.putBits(1, 0);// teleported.
        buf.putBits(3, npc.getDirection().toInteger());
        buf.putBits(1, npc.getUpdateMasks().isUpdateRequired() ? 1 : 0);
        buf.putBits(5, y);
        buf.putBits(14, npc.getId());
        player.getRenderInfo().getLocalNpcs().add(npc);
    }

    public static final byte[] NPC_DIRECTION_DELTA_X = new byte[]{-1, 0, 1, -1, 1, -1, 0, 1};
    public static final byte[] NPC_DIRECTION_DELTA_Y = new byte[]{1, 1, 1, 0, 0, -1, -1, -1};

    public static final int getNPCMovementDirection(final int dir) {
        final int dx = NPC_DIRECTION_DELTA_X[dir];
        final int dy = NPC_DIRECTION_DELTA_Y[dir];
        if (dx == 0 && dy == 1)
            return 6;
        else if (dx == 1 && dy == 1)
            return 7;
        else if (dx == -1 && dy == 0)
            return 3;
        else if (dx == 1 && dy == 0)
            return 4;
        else if (dx == -1 && dy == -1)
            return 8;
        else if (dx == 0 && dy == -1)
            return 1;
        else if (dx == 1 && dy == -1)
            return 2;
        else
            return 5;
    }

    /**
     * Updates an npcs movement.
     *
     * @param npc The npc.
     * @param buf The buffer.
     */
    private static void updateNPCMovement(NPC npc, IoBuffer buf) {
        if (npc.getWalkingQueue().getRunDir() == -1) {
            if (npc.getWalkingQueue().getWalkDir() == -1) {
                if (npc.getUpdateMasks().isUpdateRequired()) {
                    buf.putBits(1, 1);
                    buf.putBits(2, 0);
                } else {
                    buf.putBits(1, 0);
                }
            } else {
                buf.putBits(1, 1);
                buf.putBits(2, 1);
                buf.putBits(3, getNPCMovementDirection(npc.getWalkingQueue().getWalkDir()));
                buf.putBits(1, npc.getUpdateMasks().isUpdateRequired() ? 1 : 0);
            }
        } else {
            buf.putBits(1, 1);
            buf.putBits(2, 2);
            buf.putBits(3, npc.getWalkingQueue().getWalkDir());
            buf.putBits(3, npc.getWalkingQueue().getRunDir());
            buf.putBits(1, npc.getUpdateMasks().isUpdateRequired() ? 1 : 0);
        }
    }

    /**
     * Writes the NPC flag-based updating.
     *
     * @param packet The packet to write on.
     * @param npc    The npc.
     */
    private static void updateNPC(IoBuffer packet, NPC npc) {
        int maskdata = 0;
        PriorityQueue<UpdateFlag> flags = new PriorityQueue<UpdateFlag>(npc.getUpdateMasks().flagQueue);
        for (UpdateFlag flag : flags) {
            maskdata |= flag.data();
        }
        packet.put((byte) maskdata);
        while (!flags.isEmpty()) {
            flags.poll().write(packet);
        }
    }

}