package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.ContainerContext;

/**
 * Represents the outgoing container packet.
 * 
 * @author Emperor
 */
public final class ClearContainerPacket implements ServerPacket<ContainerContext> {

	@Override
	public void send(ContainerContext context) {
		IoBuffer buffer = null;
		if (context.isClear()) {
			buffer = new IoBuffer(ServerProt.ServerPackets.UPDATE_INV_CLEAR.getPacketId());
			buffer.putNewVal(context.getInterfaceId() << 16 | context.getChildId());
		}
		context.getPlayer().getSession().write(buffer);
	}

}