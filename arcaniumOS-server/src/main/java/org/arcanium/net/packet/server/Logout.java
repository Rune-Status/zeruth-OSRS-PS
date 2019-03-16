package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.PlayerContext;

/**
 * The outgoing logout packet.
 * @author Emperor
 */
public class Logout implements ServerPacket<PlayerContext> {

    @Override
    public void send(PlayerContext context) {
	IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.LOGOUT_FULL.getPacketId());
	context.getPlayer().getDetails().getSession().write(buffer);
    }
}