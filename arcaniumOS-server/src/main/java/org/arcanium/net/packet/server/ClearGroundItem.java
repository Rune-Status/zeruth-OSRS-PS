package org.arcanium.net.packet.server;

import lombok.val;
import org.arcanium.game.node.item.Item;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.BuildItemContext;
import org.arcanium.net.packet.server.zone.UpdateZonePartialFollows;

/**
 * Represents the outgoing packet of clearing ground items.
 *
 * @author Emperor
 */
public final class ClearGroundItem implements ServerPacket<BuildItemContext> {

    /**
     * Writes the packet.
     *
     * @param buffer The buffer.
     * @param item   The item.
     */
    public static void write(IoBuffer buffer, Item item) {
        val l = item.getLocation();
        buffer.put(ServerProt.ServerPackets.OBJ_DEL.getPacketId());
        buffer.putByte128((l.getChunkOffsetX() & 0x7) << 4 | (l.getChunkOffsetY() & 0x7));
        buffer.putLEShortA(item.getId());

        System.out.println("[ClearGroundItem] " + ((l.getChunkOffsetX() & 0x7) << 4 | (l.getChunkOffsetY() & 0x7)));
        System.out.println("[ClearGroundItem] " + item.getId());
    }

    @Override
    public void send(BuildItemContext context) {
        val player = context.getPlayer();
        val item = context.getItem();
        val l = item.getLocation();
        val buffer = UpdateZonePartialFollows.getBuffer(player, item.getLocation().getChunkBase());
        val itemBuf = new IoBuffer(ServerProt.ServerPackets.OBJ_DEL.getPacketId());
        itemBuf.putByte128((l.getChunkOffsetX() & 0x7) << 4 | (l.getChunkOffsetY() & 0x7));
        itemBuf.putLEShortA(item.getId());

        System.out.println("[ClearGroundItem] " + ((l.getChunkOffsetX() << 4) | (l.getChunkOffsetY() & 0x7)));
        System.out.println("[ClearGroundItem] " + item.getId());
        player.getSession().write(buffer);
        player.getSession().write(itemBuf);
    }
}