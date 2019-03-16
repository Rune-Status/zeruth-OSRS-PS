package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.system.communication.CommunicationInfo;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.tools.StringUtils;

/**
 * Represents the packet used to handle all incoming packets related to
 * communication.
 * @author 'Vexia
 */
public final class CommunicationPacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	switch (buffer.opcode()) {
	case 163:
	    CommunicationInfo.add(player, buffer.getString());
	    break;
	case 242:
	    CommunicationInfo.remove(player, buffer.getString(), false);
	    break;
	case 159:
	    CommunicationInfo.block(player, buffer.getString());
	    break;
	case 79:
	    CommunicationInfo.remove(player, buffer.getString(), true);
	    break;
	case 176: 
	    buffer.getShort();
	    String name = buffer.getString();
	    int size = buffer.getSmart();
	    String message = StringUtils.decryptPlayerChat(buffer, size);
	    if (player.getDetails().getPortal().isMuted()) {
		player.getPacketDispatch().sendMessage("You have been " + (player.getDetails().getPortal().isPermMute() ? "permanently" : "temporarily") + " muted due to breaking a rule.");
		return;
	    }
	    CommunicationInfo.sendMessage(player, name, message);
	    break;
	}
    }

}
