package org.arcanium.net.packet.server;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.map.Location;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.LocationContext;

/**
 * Outgoing packet used for updating a player's location solely on his own
 * client.
 * @author Emperor
 */
public final class InstancedLocationUpdate implements ServerPacket<LocationContext> {

    @Override
    public void send(LocationContext context) {
	IoBuffer buffer = new IoBuffer(110);
	Location l = context.getLocation();
	Player player = context.getPlayer();
	int flag = l.getZ() << 1;
	if (context.isTeleport()) {
	    flag |= 0x1;
	}
	buffer.put128Byte(flag);
	buffer.put(l.getSceneX(player.getPlayerFlags().getLastSceneGraph()));
	buffer.putByte128(l.getSceneY(player.getPlayerFlags().getLastSceneGraph()));
	player.getSession().write(buffer);
    }

}