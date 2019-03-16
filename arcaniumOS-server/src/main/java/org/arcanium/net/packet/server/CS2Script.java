package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.RunScriptContext;

/**
 * The run script outgoing packet.
 *
 * @author Emperor
 */
public class CS2Script implements ServerPacket<RunScriptContext> {

    @Override
    public void send(RunScriptContext context) {
        String string = context.getString();
        Object[] objects = context.getObjects();
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.RUNCLIENTSCRIPT.getPacketId(), PacketHeader.SHORT);
        buffer.putString(string);
        if(objects != null) {
            for (int index = objects.length - 1; index >= 0; index--) {
                if (string.charAt(index) == 's') {
                    buffer.putString((String) objects[index]);
                } else {
                    buffer.putInt((Integer) objects[index]);
                }
            }
        }
        buffer.putInt(context.getId());
        context.getPlayer().getDetails().getSession().write(buffer);
    }
}
