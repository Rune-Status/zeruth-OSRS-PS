package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.info.Rights;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles the idle packet handler.
 * @author Emperor
 */
public final class IdlePacketHandler implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	if (player.getDetails().getRights() != Rights.ADMINISTRATOR) {
	    player.getPacketDispatch().sendLogout();
	}
    }

}