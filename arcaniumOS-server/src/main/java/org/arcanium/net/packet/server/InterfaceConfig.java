package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.InterfaceConfigContext;

/**
 * The outgoing interface configuration packet.
 *
 * @author Emperor
 */
public class InterfaceConfig implements ServerPacket<InterfaceConfigContext> {

    @Override
    public void send(InterfaceConfigContext context) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.IF_SETSCROLLPOS.getPacketId());
        buffer.putIntV2(context.getInterfaceId() << 16 | context.getChildId());
        buffer.putLEShortA(context.isHidden() ? 1 : 0);
        context.getPlayer().getSession().write(buffer);
    }
}
