package org.arcanium.net.packet.server;

import lombok.val;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.world.map.Location;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.BuildItemContext;
import org.arcanium.net.packet.server.zone.UpdateZonePartialFollows;

/**
 * Represents the outgoing packet of constructing a ground item.
 *
 * @author Emperor
 */
public final class ConstructGroundItem implements ServerPacket<BuildItemContext> {

    /**
     * Writes the packet.
     *
     * @param buffer The buffer.
     * @param item   The item.
     */
    public static IoBuffer write(IoBuffer buffer, Item item) {
        Location l = item.getLocation();
        buffer.put(ServerProt.ServerPackets.OBJ_ADD.getPacketId());
        buffer.putShort128(item.getAmount());
        buffer.putLEShortA(item.getId());
        buffer.putByte128((l.getChunkOffsetX() & 0x7) << 4 | (l.getChunkOffsetY() & 0x7));
        return buffer;
    }

    @Override
    public void send(BuildItemContext context) {
        val player = context.getPlayer();
        val item = context.getItem();
        val buffer = UpdateZonePartialFollows.getBuffer(player, item.getLocation().getChunkBase());
        val l = item.getLocation();
        val itemBuf = new IoBuffer(ServerProt.ServerPackets.OBJ_ADD.getPacketId());
        itemBuf.putShort128(item.getAmount());
        itemBuf.putLEShortA(item.getId());
        itemBuf.putByte128((l.getChunkOffsetX() & 0x7) << 4 | (l.getChunkOffsetY() & 0x7));
        player.getDetails().getSession().write(buffer);
        player.getDetails().getSession().write(itemBuf);
    }
}
