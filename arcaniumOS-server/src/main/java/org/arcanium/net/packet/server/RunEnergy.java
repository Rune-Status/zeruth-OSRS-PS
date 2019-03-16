package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.PlayerContext;

/**
 * The run energy outgoing packet.
 *
 * @author Emperor
 */
public class RunEnergy implements ServerPacket<PlayerContext> {

    @Override
    public void send(PlayerContext context) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.UPDATE_RUNENERGY.getPacketId());
        buffer.put((byte) context.getPlayer().getSettings().getRunEnergy());
        context.getPlayer().getDetails().getSession().write(buffer);
    }
}