package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Packet received when a player's region has changed.
 * @author Emperor
 * @author 'Vexia
 */
public class RegionChangePacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	buffer.getInt();
    }

}
