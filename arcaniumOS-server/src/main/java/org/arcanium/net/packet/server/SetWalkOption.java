package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.WalkOptionContext;

/**
 * Handles the sending of the "Set walk-to option" packet.
 * @author Emperor
 */
public final class SetWalkOption implements ServerPacket<WalkOptionContext> {

    @Override
    public void send(WalkOptionContext context) {
	IoBuffer buffer = new IoBuffer(10, PacketHeader.BYTE).putString(context.getOption());
	context.getPlayer().getDetails().getSession().write(buffer);
    }

}