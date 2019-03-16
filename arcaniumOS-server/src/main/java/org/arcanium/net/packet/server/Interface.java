package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.InterfaceContext;

/**
 * The interface outgoing packet.
 *
 * @author Emperor
 */
public final class Interface implements ServerPacket<InterfaceContext> {

    @Override
    public void send(InterfaceContext context) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.IF_OPEN_SUB.getPacketId());
        int windowPane = context.getWindowId() == 162 ? 162 : context.getPlayer().getInterfaceManager().getWindowsPane();
        buffer.putByte128(context.isWalkable() ? 1 : 0);
        buffer.putIntV1(windowPane << 16 | context.getComponentId());
        buffer.putLEShortA(context.getInterfaceId());
        context.getPlayer().getDetails().getSession().write(buffer);
    }

}