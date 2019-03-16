package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles incoming mouse click packets.
 * @author Emperor
 */
public final class MouseClickPacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	int data = buffer.getLEInt();
	int positioning = data & 0xFFFFF;
	boolean rightClick = ((data >> 19) & 0x1) == 1;
	int delay = (data >> 20) & 0x7FF;
	int x = positioning - (((positioning / 765) & 0x7FF) * 765);
	int y = (positioning / 765) & 0x7FF;
	if (player == null) {
	    return;
	}
	player.getMonitor().handleMouseClick(x, y, delay, rightClick);
    }

}