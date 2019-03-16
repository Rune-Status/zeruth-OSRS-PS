package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles music-related incoming packets.
 * @author Emperor
 */
public final class MusicPacketHandler implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	int musicId = buffer.getInt();
	if (player.getMusicPlayer().isLooping()) {
	    player.getMusicPlayer().replay();
	    return;
	}
	if (player.getMusicPlayer().getCurrentMusicId() == musicId) {
	    player.getMusicPlayer().setPlaying(false);
	}
    }

}