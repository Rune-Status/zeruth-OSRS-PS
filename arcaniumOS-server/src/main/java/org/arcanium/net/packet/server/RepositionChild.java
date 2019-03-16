package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.ChildPositionContext;

/**
 * Handles the "reposition interface child" outgoing packet.
 * @author Emperor
 */
public final class RepositionChild implements ServerPacket<ChildPositionContext> {

    @Override
    public void send(ChildPositionContext context) {
	context.getPlayer().getSession().write(new IoBuffer(64).putShort(context.getPosition().y).putInt(context.getInterfaceId() << 16 | context.getChildId()).putShort(context.getPosition().x));
    }

}