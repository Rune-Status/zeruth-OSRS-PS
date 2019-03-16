package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.AccessMaskContext;

/**
 * The access mask outgoing packet.
 *
 * @author Emperor
 */
public class AccessMask implements ServerPacket<AccessMaskContext> {

    @Override
    public void send(AccessMaskContext context) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.IF_SETEVENTS.getPacketId());
        buffer.putIntLE(context.getId());
        buffer.putShort128(context.getOffset());
        buffer.putIntV2(context.getInterfaceId() << 16 | context.getChildId());
        buffer.putShort(context.getLength());
        context.getPlayer().getSession().write(buffer);
    }
}
