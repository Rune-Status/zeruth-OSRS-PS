package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles an incoming client focus changed packet.
 * @author Emperor
 */
public final class ClientFocusPacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	if (player != null) {
	    player.getMonitor().setClientFocus(buffer.getByte() == 1);
	}
    }

}