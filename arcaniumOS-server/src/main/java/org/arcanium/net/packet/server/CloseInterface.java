package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.InterfaceContext;

/**
 * Represents the outgoing packet used for closing an interface.
 *
 * @author Emperor
 */
public final class CloseInterface implements ServerPacket<InterfaceContext> {

    @Override
    public void send(InterfaceContext context) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.IF_CLOSESUB.getPacketId());
        int windowPane = context.getWindowId() == 162 ? 162 : context.getPlayer().getInterfaceManager().getWindowsPane();
        buffer.putInt(windowPane << 16 | context.getComponentId());
        context.getPlayer().getSession().write(buffer);
    }

}