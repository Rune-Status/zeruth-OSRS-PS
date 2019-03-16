package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.InterfaceSetContext;

/**
 * Created by Chris on 7/23/2017.
 */
public class InterfaceSet implements ServerPacket<InterfaceSetContext> {

    @Override
    public void send(InterfaceSetContext context) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.IF_MOVESUB.getPacketId());
        buffer.putInt((context.getToRoot() << 16 | context.getToChild()));
        buffer.putInt((context.getFromRoot() << 16 | context.getFromChild()));
        context.getPlayer().getSession().write(buffer);
    }
}