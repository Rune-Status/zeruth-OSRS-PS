package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.AnimateInterfaceContext;

/**
 * The animate interface outgoing packet.
 *
 * @author Emperor
 */
public class AnimateInterface implements ServerPacket<AnimateInterfaceContext> {

    @Override
    public void send(AnimateInterfaceContext context) {
        IoBuffer buffer = new IoBuffer(254);
        buffer.putIntV1((context.getInterfaceId() << 16) + context.getChildId());
        buffer.putShortLE(context.getAnimationId());
        context.getPlayer().getDetails().getSession().write(buffer);
    }
}