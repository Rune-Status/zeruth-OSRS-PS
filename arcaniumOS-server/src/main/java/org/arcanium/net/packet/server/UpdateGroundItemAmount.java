package org.arcanium.net.packet.server;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.world.map.Location;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.BuildItemContext;
import org.arcanium.net.packet.server.zone.UpdateZonePartialFollows;

/**
 * Updates the ground item amount.
 *
 * @author Emperor
 */
public final class UpdateGroundItemAmount implements ServerPacket<BuildItemContext> {

    /**
     * Writes the packet.
     *
     * @param buffer The buffer.
     * @param item   The item.
     */
    public static IoBuffer write(IoBuffer buffer, Item item, int oldAmount) {
        Location l = item.getLocation();
        buffer.put(ServerProt.ServerPackets.OBJ_COUNT.getPacketId())
                .put((l.getChunkOffsetX() << 4) | (l.getChunkOffsetY() & 0x7))
                .putShort(item.getId()).putShort(oldAmount)
                .putShort(item.getAmount());
        return buffer;
    }

    @Override
    public void send(BuildItemContext context) {
        Player player = context.getPlayer();
        Item item = context.getItem();
        IoBuffer buffer = write(new UpdateZonePartialFollows().getBuffer(player, item.getLocation().getChunkBase()), item, context.getOldAmount());
        player.getDetails().getSession().write(buffer);
    }
}