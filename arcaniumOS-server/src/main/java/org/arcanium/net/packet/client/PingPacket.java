package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles an incoming ping packet.
 *
 * @author Emperor
 */
public final class PingPacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	int var1 = buffer.getByteC();
	int var2 = buffer.getLEInt();
	int var3 = buffer.getLEInt();
    }

}