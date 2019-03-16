package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.IPContext;

public class IPEncoder implements ServerPacket<IPContext> {
    @Override
    public void send(IPContext context) {
        IoBuffer buffer = new IoBuffer(0);
        buffer.putIntLE(context.getHash());
        context.getPlayer().getSession().write(buffer);
    }
}