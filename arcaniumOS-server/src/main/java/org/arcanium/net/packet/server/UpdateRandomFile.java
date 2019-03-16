package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.PlayerContext;

/**
 * Updates the random.dat file for the player.
 * @author Emperor
 */
public final class UpdateRandomFile implements ServerPacket<PlayerContext> {

    @Override
    public void send(PlayerContext context) {
	IoBuffer buffer = new IoBuffer(211);
	buffer.putInt(1); // Let's assume this is UID.
	buffer.put(0);
	buffer.put(0);
	buffer.put(0);
	buffer.put(0);
	for (int i = 0; i < 4; i++) {
	    buffer.putInt(i + 100);
	}
	context.getPlayer().getSession().write(buffer);
    }

}