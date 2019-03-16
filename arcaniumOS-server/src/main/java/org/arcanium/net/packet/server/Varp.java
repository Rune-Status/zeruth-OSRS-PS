package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.ConfigContext;

/**
 * The config outgoing packet.
 * 
 * @author Emperor
 */
public class Varp implements ServerPacket<ConfigContext> {

	@Override
	public void send(ConfigContext context) {
		IoBuffer buffer;
		if (context.getValue() < Byte.MIN_VALUE || context.getValue() > Byte.MAX_VALUE) {
			buffer = new IoBuffer(ServerProt.ServerPackets.SET_VARP_LARGE.getPacketId());
			buffer.putShort(context.getId());
			buffer.putInt(context.getValue());
		} else {
			buffer = new IoBuffer(ServerProt.ServerPackets.VARP_SMALL.getPacketId());
			buffer.put128Byte(context.getValue());
			buffer.putShort128(context.getId());
		}
		context.getPlayer().getDetails().getSession().write(buffer);
	}
}