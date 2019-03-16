package org.arcanium.net.packet.server.zone;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.world.map.Location;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.AreaPositionContext;

import static org.arcanium.net.packet.ServerProt.ServerPackets;

/**
 * Handles the update area position packet.
 *
 * @author Emperor
 */
public final class UpdateZonePartialFollows implements ServerPacket<AreaPositionContext> {

    /**
     * Gets the region chunk update buffer.
     *
     * @param player The player.
     * @param base   The base location of the chunk.
     * @return The buffer.
     */
    public static IoBuffer getChunkUpdateBuffer(Player player, Location base) {
        int x = base.getSceneX(player.getPlayerFlags().getLastSceneGraph());
        int y = base.getSceneY(player.getPlayerFlags().getLastSceneGraph());

        System.out.println("[UPDATE_ZONE_PARTIAL_FOLLOWS] [getChunkUpdateBuffer] " + x);
        System.out.println("[UPDATE_ZONE_PARTIAL_FOLLOWS] [getChunkUpdateBuffer] " + y);

        return new IoBuffer(ServerPackets.UPDATE_ZONE_PARTIAL_FOLLOWS.getPacketId()).putN(x).put128Byte(y);
    }

    /**
     * Gets the region chunk update buffer.
     *
     * @param player The player.
     * @param base   The base location of the chunk.
     * @return The buffer.
     */
    public static IoBuffer getBuffer(Player player, Location base) {
        int x = base.getSceneX(player.getPlayerFlags().getLastSceneGraph());
        int y = base.getSceneY(player.getPlayerFlags().getLastSceneGraph());

        System.out.println("[UPDATE_ZONE_PARTIAL_FOLLOWS] [getBuffer] " + x);
        System.out.println("[UPDATE_ZONE_PARTIAL_FOLLOWS] [getBuffer] " + y);

        return new IoBuffer(ServerPackets.UPDATE_ZONE_PARTIAL_FOLLOWS.getPacketId()).putN(x).put128Byte(y);
    }

    /**
     * Gets the region chunk update buffer.
     *
     * @param player The player.
     * @param base   The base location of the chunk.
     * @return The buffer.
     */
    public static IoBuffer getBuffer(GameObject object) {
        int x = object.getLocation().getChunkX();
        int y = object.getLocation().getChunkY();

        System.out.println("[UPDATE_ZONE_PARTIAL_FOLLOWS] [getBuffer] " + x);
        System.out.println("[UPDATE_ZONE_PARTIAL_FOLLOWS] [getBuffer] " + y);

        return new IoBuffer(ServerPackets.UPDATE_ZONE_PARTIAL_FOLLOWS.getPacketId()).putN(x).put128Byte(y);
    }

    @Override
    public void send(AreaPositionContext context) {
        context.getPlayer().getSession().write(getBuffer(context.getPlayer(), context.getLocation()));
    }

}