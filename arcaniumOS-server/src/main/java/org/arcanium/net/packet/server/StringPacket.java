package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.StringContext;

/**
 * The outgoing set component string packet.
 *
 * @author Emperor
 */
public class StringPacket implements ServerPacket<StringContext> {

    @Override
    public void send(StringContext context) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.IF_SETTEXT.getPacketId(), PacketHeader.SHORT);
        buffer.putInt((context.getInterfaceId() << 16) | context.getLineId());
        buffer.putString(context.getString());
        context.getPlayer().getDetails().getSession().write(buffer);
    }
}
