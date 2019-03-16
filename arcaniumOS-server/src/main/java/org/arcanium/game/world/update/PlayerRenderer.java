package org.arcanium.game.world.update;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.info.RenderInfo;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.game.world.update.flag.player.AppearanceFlag;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerProt;

import java.util.PriorityQueue;

/**
 * Handles the player rendering.
 *
 * @author Emperor
 */
public final class PlayerRenderer {

    public static void sendUpdate(Player player) {
        player.getDetails().getSession().write(render(player));
    }

    /**
     * Handles the player rendering for a player.
     *
     * @param player The player.
     */
    public static IoBuffer render(Player player) {
        RenderInfo viewport = player.getRenderInfo();

        IoBuffer stream = new IoBuffer(ServerProt.ServerPackets.PLAYER_INFO.getPacketId(), PacketHeader.SHORT);
        IoBuffer updateBlockData = new IoBuffer();

        processLocalPlayers(stream, updateBlockData, true, viewport);
        processLocalPlayers(stream, updateBlockData, false, viewport);
        processOutsidePlayers(stream, updateBlockData, true, viewport);
        processOutsidePlayers(stream, updateBlockData, false, viewport);

        stream.put(updateBlockData);

        return stream;
    }

    private static boolean needsRemove(Player player, Player p) {
        return (!p.isActive() || !player.getLocation().withinDistance(p.getLocation(), 15));
    }

    private static boolean needsAdd(Player player, Player p) {
        player.getRenderInfo();
        return p != null && p.isActive() && player.getLocation().withinDistance(p.getLocation(), 15)
                && player.getRenderInfo().localAddedPlayers < RenderInfo.MAX_PLAYER_ADD;
    }

    private final static int getCoordinateModifierHash(final Location tile) {
        return (tile.getY() >> 13 | (tile.getX() >> 13) << 8 | tile.getZ() << 16);
    }

    private static void updateRegionHash(IoBuffer stream, Player p, int lastRegionHash, int currentRegionHash) {
        final int lastY = lastRegionHash & 0xff;
        final int lastX = lastRegionHash >> 8 & 0xff;
        final int lastPlane = lastRegionHash >> 16;

        final int currentY = currentRegionHash & 0xff;
        final int currentX = currentRegionHash >> 8 & 0xff;
        final int currentPlane = currentRegionHash >> 16;

        final int yOffset = currentY - lastY;
        final int xOffset = currentX - lastX;
        final int planeOffset = currentPlane - lastPlane;
        if (xOffset == 0 && yOffset == 0) {
            stream.putBits(2, 1);
            stream.putBits(2, planeOffset);
            return;
        }
        stream.putBits(2, 3);
        stream.putBits(18, (yOffset & 0xff) | ((xOffset & 0xff) << 8) | (planeOffset << 16));
    }

    private static void processOutsidePlayers(IoBuffer stream, IoBuffer updateBlockData, boolean nsn2,
                                              RenderInfo viewport) {
        stream.setBitAccess();
        int skip = 0;
        viewport.localAddedPlayers = 0;
        for (int i = 0; i < viewport.outPlayersIndexesCount; i++) {
            int playerIndex = viewport.outPlayersIndexes[i];
            if (nsn2 ? (0x1 & viewport.slotFlags[playerIndex]) == 0 : (0x1 & viewport.slotFlags[playerIndex]) != 0)
                continue;
            if (skip > 0) {
                skip--;
                viewport.slotFlags[playerIndex] = (byte) (viewport.slotFlags[playerIndex] | 2);
                continue;
            }
            Player p = Repository.getPlayers().get(playerIndex);
            if (needsAdd(viewport.player, p)) {
                stream.putBits(1, 1);
                stream.putBits(2, 0); // request aid
                int hash = getCoordinateModifierHash(p.getLocation());
                if (hash == viewport.regionHashes[playerIndex])
                    stream.putBits(1, 0);
                else {
                    stream.putBits(1, 1);
                    updateRegionHash(stream, p, viewport.regionHashes[playerIndex], hash);
                    viewport.regionHashes[playerIndex] = hash;
                }
                stream.putBits(13, p.getLocation().getX());
                stream.putBits(13, p.getLocation().getY());
                stream.putBits(1, 1);
                boolean needAppearenceUpdate = viewport.needAppearenceUpdate(p.getIndex(),
                        p.getAppearance().getMD5AppeareanceDataHash());
                appendUpdateBlock(p, updateBlockData, needAppearenceUpdate);
                viewport.localAddedPlayers++;
                viewport.localPlayers[p.getIndex()] = p;
                viewport.slotFlags[playerIndex] = (byte) (viewport.slotFlags[playerIndex] | 2);
            } else {
                int hash = p == null ? viewport.regionHashes[playerIndex] : getCoordinateModifierHash(p.getLocation());
                if (p != null && hash != viewport.regionHashes[playerIndex]) {
                    stream.putBits(1, 1);
                    updateRegionHash(stream, p, viewport.regionHashes[playerIndex], hash);
                    viewport.regionHashes[playerIndex] = hash;
                } else {
                    stream.putBits(1, 0); // no update needed
                    for (int i2 = i + 1; i2 < viewport.outPlayersIndexesCount; i2++) {
                        int p2Index = viewport.outPlayersIndexes[i2];
                        if (nsn2 ? (0x1 & viewport.slotFlags[p2Index]) == 0 : (0x1 & viewport.slotFlags[p2Index]) != 0)
                            continue;
                        Player p2 = Repository.getPlayers().get(p2Index);
                        if (needsAdd(viewport.player, p2) || (p2 != null
                                && getCoordinateModifierHash(p2.getLocation()) != viewport.regionHashes[p2Index]))
                            break;
                        skip++;
                    }
                    skipPlayers(stream, skip);
                    viewport.slotFlags[playerIndex] = (byte) (viewport.slotFlags[playerIndex] | 2);
                }
            }
        }
        stream.setByteAccess();
    }

    private static void processLocalPlayers(IoBuffer stream, IoBuffer updateBlockData, boolean nsn0,
                                            RenderInfo viewport) {
        stream.setBitAccess();
        int skip = 0;
        for (int i = 0; i < viewport.localPlayersIndexesCount; i++) {
            int playerIndex = viewport.localPlayersIndexes[i];
            if (nsn0 ? (0x1 & viewport.slotFlags[playerIndex]) != 0 : (0x1 & viewport.slotFlags[playerIndex]) == 0)
                continue;
            if (skip > 0) {
                skip--;
                viewport.slotFlags[playerIndex] = (byte) (viewport.slotFlags[playerIndex] | 2);
                continue;
            }
            Player p = viewport.localPlayers[playerIndex];
            if (needsRemove(viewport.player, p)) {
                stream.putBits(1, 1); // needs update
                stream.putBits(1, 0); // no masks update needeed
                stream.putBits(2, 0); // request remove
                viewport.regionHashes[playerIndex] = p.getLastLocation() == null
                        ? getCoordinateModifierHash(p.getLocation())
                        : getCoordinateModifierHash(p.getLastLocation());
                int hash = getCoordinateModifierHash(p.getLocation());
                if (hash == viewport.regionHashes[playerIndex])
                    stream.putBits(1, 0);
                else {
                    stream.putBits(1, 1);
                    updateRegionHash(stream, p, viewport.regionHashes[playerIndex], hash);
                    viewport.regionHashes[playerIndex] = hash;
                }
                viewport.localPlayers[playerIndex] = null;
            } else {
                boolean needAppearenceUpdate = viewport.needAppearenceUpdate(p.getIndex(),
                        p.getAppearance().getMD5AppeareanceDataHash());
                boolean needUpdate = p.getUpdateMasks().isUpdateRequired() || needAppearenceUpdate;
                if (needUpdate)
                    appendUpdateBlock(p, updateBlockData, needAppearenceUpdate);
                if (p.getProperties().isTeleporting()) {
                    stream.putBits(1, 1); // needs update
                    stream.putBits(1, needUpdate ? 1 : 0);
                    stream.putBits(2, 3);
                    int xOffset = p.getLocation().getX() - p.getLastLocation().getX();
                    int yOffset = p.getLocation().getY() - p.getLastLocation().getY();
                    int planeOffset = p.getLocation().getZ() - p.getLastLocation().getZ();
                    stream.putBits(1, 1);
                    stream.putBits(30, (yOffset & 0x3fff) | ((xOffset & 0x3fff) << 14) | ((planeOffset & 0x3) << 28));
                } else if (p.getWalkingQueue().getWalkDir() != -1 || p.getWalkingQueue().getRunDir() != -1) {
                    int dx = p.getLocation().getX() - p.getLastLocation().getX();
                    int dy = p.getLocation().getY() - p.getLastLocation().getY();
                    boolean running;
                    int opcode;
                    if (p.getWalkingQueue().getRunDir() != -1) {
                        opcode = p.getWalkingQueue().getRunDir();
                        running = true;
                    } else {
                        running = false;
                        opcode = p.getWalkingQueue().getWalkDir();
                    }
                    stream.putBits(1, 1);
                    if (dx == 0 && dy == 0) {
                        stream.putBits(1, 1); // quick fix
                        stream.putBits(2, 0);
                    } else {
                        if (running) {
                            stream.putBits(1, needUpdate ? 1 : 0);
                            stream.putBits(2, 2);
                            stream.putBits(4, opcode);
                        } else {
                            stream.putBits(1, needUpdate ? 1 : 0);
                            stream.putBits(2, 1);
                            stream.putBits(3, opcode);
                        }
                    }
                } else if (needUpdate) {
                    stream.putBits(1, 1); // needs update
                    stream.putBits(1, 1);
                    stream.putBits(2, 0);
                } else { // skip
                    stream.putBits(1, 0); // no update needed
                    for (int i2 = i + 1; i2 < viewport.localPlayersIndexesCount; i2++) {
                        int p2Index = viewport.localPlayersIndexes[i2];
                        if (nsn0 ? (0x1 & viewport.slotFlags[p2Index]) != 0 : (0x1 & viewport.slotFlags[p2Index]) == 0)
                            continue;
                        Player p2 = viewport.localPlayers[p2Index];
                        if (needsRemove(viewport.player, p2) || p2.getProperties().isTeleporting()
                                || p2.getWalkingQueue().getWalkDir() != -1
                                || (p2.getUpdateMasks().isUpdateRequired() || viewport.needAppearenceUpdate(
                                p2.getIndex(), p2.getAppearance().getMD5AppeareanceDataHash())))
                            break;
                        skip++;
                    }
                    skipPlayers(stream, skip);
                    viewport.slotFlags[playerIndex] = (byte) (viewport.slotFlags[playerIndex] | 2);
                }

            }
        }
        stream.setByteAccess();
    }

    @SuppressWarnings("rawtypes")
    private static void appendUpdateBlock(Player p, IoBuffer data, boolean needAppearenceUpdate) {
        int maskData = 0;

        PriorityQueue<UpdateFlag> flags = new PriorityQueue<UpdateFlag>(p.getUpdateMasks().flagQueue);
        for (UpdateFlag flag : flags) {
            maskData |= flag.data();
        }

        if (needAppearenceUpdate && (maskData & 0x1) == 0) {
            maskData |= 0x1;
            flags.add(new AppearanceFlag(p));
        }
        if (maskData >= 0xFF)
            maskData |= 0x8;

        //System.err.println("maskData: " + maskData);
        data.put(maskData);
        if (maskData >= 0xFF)
            data.put(maskData >> 8);

        while (!flags.isEmpty()) {
            flags.poll().writeDynamic(data, p);
        }

    }

    private static void skipPlayers(IoBuffer stream, int amount) {
        if (amount == 0) {
            stream.putBits(2, 0);
        } else if (amount < 32) {
            stream.putBits(2, 1);
            stream.putBits(5, amount);
        } else if (amount < 256) {
            stream.putBits(2, 2);
            stream.putBits(8, amount);
        } else if (amount < 2048) {
            stream.putBits(2, 3);
            stream.putBits(11, amount);
        }
    }

}