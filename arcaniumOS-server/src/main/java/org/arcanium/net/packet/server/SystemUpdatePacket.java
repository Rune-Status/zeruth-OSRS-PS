package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.SystemUpdateContext;

/**
 * Handles the system update packet.
 * @author 'Vexia
 */
public class SystemUpdatePacket implements ServerPacket<SystemUpdateContext> {

    @Override
    public void send(final SystemUpdateContext context) {
	IoBuffer buffer = new IoBuffer(174).putShort(context.getTime());
	context.getPlayer().getDetails().getSession().write(buffer);
    }

}
