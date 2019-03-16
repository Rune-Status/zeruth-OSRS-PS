package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles an incoming chat settings update packet.
 * @author Emperor
 */
public final class ChatSettingsPacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	int publicSetting = buffer.getByte();
	int privateSetting = buffer.getByte();
	int tradeSetting = buffer.getByte();
	player.getSettings().updateChatSettings(publicSetting, privateSetting, tradeSetting);
    }

}