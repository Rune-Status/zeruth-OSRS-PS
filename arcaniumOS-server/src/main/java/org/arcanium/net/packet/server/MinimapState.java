package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.MinimapStateContext;

/**
 * Handles the sending of the minimap state outgoing packet.
 * @author Emperor
 */
public final class MinimapState implements ServerPacket<MinimapStateContext> {

    @Override
    public void send(MinimapStateContext context) {
	IoBuffer buffer = new IoBuffer(133).put(context.getState());
	context.getPlayer().getDetails().getSession().write(buffer);
    }

}