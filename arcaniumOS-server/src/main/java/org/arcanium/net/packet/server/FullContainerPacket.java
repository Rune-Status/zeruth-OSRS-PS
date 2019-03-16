package org.arcanium.net.packet.server;

import org.arcanium.game.node.item.Item;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.ContainerContext;

/**
 * Represents the outgoing container packet.
 * 
 * @author Emperor
 */
public final class FullContainerPacket implements ServerPacket<ContainerContext> {

	@Override
	public void send(ContainerContext context) {
		
		IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.UPDATE_INV_FULL.getPacketId(), PacketHeader.SHORT);
		
		//interface
		buffer.putInt(context.getInterfaceId() << 16 | context.getChildId());
		//type
		buffer.putShort(context.getType());
		//container amt / should be split?
		buffer.putShort(context.getItems().length);
			
		for (Item item : context.getItems()) {
			int id, amt;
			if(item == null) {
				id = -1;
				amt = 0;
			} else {
				id = item.getId();
				amt = item.getAmount();
			}
			buffer.putShort(id + 1);
			buffer.put(amt > 254 ? 255 : amt);
			if(amt > 254)
				buffer.putIntV2(amt);
			
		}
		context.getPlayer().getSession().write(buffer);
	}

}
