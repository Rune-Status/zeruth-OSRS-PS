package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.WindowsPaneContext;

/**
 * Handles the windows pane outgoing packet.
 *
 * @author Emperor
 */
public final class WindowsPane implements ServerPacket<WindowsPaneContext> {

    @Override
    public void send(WindowsPaneContext context) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.IF_OPEN_TOP.getPacketId());
        buffer.putLEShortA(context.getWindowId());
        context.getPlayer().getDetails().getSession().write(buffer);
    }

}