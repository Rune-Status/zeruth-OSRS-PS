package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.InteractionOptionContext;

/**
 * Handles the interaction option changed outgoing packet.
 *
 * @author Emperor
 */
public final class InteractionOption implements ServerPacket<InteractionOptionContext> {

    @Override
    public void send(InteractionOptionContext context) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.SET_PLAYER_OP.getPacketId(), PacketHeader.BYTE);
        buffer.putByte128(context.getIndex() == 0 ? 1 : 0)
                .putByte128(context.getIndex() + 1)
                .putString(context.getName());
        context.getPlayer().getSession().write(buffer);
    }

}