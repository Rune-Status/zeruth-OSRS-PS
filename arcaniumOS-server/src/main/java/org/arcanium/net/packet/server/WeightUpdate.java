package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.PlayerContext;

/**
 * Handles the outgoing weight update packet.
 *
 * @author Emperor
 */
public final class WeightUpdate implements ServerPacket<PlayerContext> {

    @Override
    public void send(PlayerContext context) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.UPDATE_RUNWEIGHT.getPacketId());
        buffer.putShort((int) context.getPlayer().getSettings().getWeight());
        context.getPlayer().getSession().write(buffer);
    }

}