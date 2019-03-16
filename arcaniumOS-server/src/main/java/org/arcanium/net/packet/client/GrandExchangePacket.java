package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Represents the <b>Incoming</b> packet of the grand exchange.
 * @author Emperor
 */
public class GrandExchangePacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	int itemId = buffer.getShort();
	player.getGrandExchange().constructBuy(itemId);
	player.getInterfaceManager().closeChatbox();
    }

}
