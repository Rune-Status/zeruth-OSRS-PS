package org.arcanium.net.packet.client;

import org.arcanium.game.container.Container;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Represents the packet to handle an item slot switch.
 * @author 'Vexia
 */
public class SlotSwitchPacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	final int slot = buffer.getShort128();
	final int interfaceId = (buffer.getIntV1() >> 16);
	final int secondSlot = buffer.getShortLEA();
	final boolean insert = buffer.getByte128() == 1;
	final Container container = interfaceId == 12 ? player.getBank() : (interfaceId == 15 || interfaceId == 149 || interfaceId == 11) ? player.getInventory() : null;
	if (container == null) {
	    return;
	}
	final Item item = container.get(slot);
	final Item second = container.get(secondSlot);
	if (item == null) {
	    return;
	}
	if (!insert) {
	    container.replace(second, slot);
	    container.replace(item, secondSlot);
	    if (item != null) {
		item.setIndex(secondSlot);
	    }
	    if (second != null) {
		second.setIndex(slot);
	    }
	} else {
	    container.insert(slot, secondSlot);
	}
    }

}
