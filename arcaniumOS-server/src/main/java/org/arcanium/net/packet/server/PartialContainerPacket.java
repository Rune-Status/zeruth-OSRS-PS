package org.arcanium.net.packet.server;

import org.arcanium.game.container.ContainerEvent;
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
public final class PartialContainerPacket implements ServerPacket<ContainerContext> {

	@Override
	public void send(ContainerContext context) {
		IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.UPDATE_INV_PARTIAL.getPacketId(), PacketHeader.SHORT);
		buffer.putInt(context.getInterfaceId() << 16 | context.getChildId()).putShort(context.getType());
		if(context.getSlots() != null) {
		for (int slot : context.getSlots()) {
			Item item = context.getItems()[slot];
			
			buffer.putSmart(slot);
			if (item != null && !item.equals(ContainerEvent.NULL_ITEM)) {
				buffer.putShort(item.getId() + 1);
				int amount = item.getAmount();
				buffer.put(amount > 254 ? 255 : amount);
				if(amount > 254)
					buffer.putInt(amount);
			} else {
				buffer.putShort(0);
			}
		}
		}
		context.getPlayer().getSession().write(buffer);
	}
}