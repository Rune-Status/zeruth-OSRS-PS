package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.GameMessageContext;

/**
 * The game message outgoing packet.
 *
 * @author Emperor
 */
public class GameMessage implements ServerPacket<GameMessageContext> {

    @Override
    public void send(GameMessageContext context) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.GAME_MESSAGE.getPacketId(), PacketHeader.BYTE);
        buffer.putSmart(0);
        buffer.put(0);
        buffer.putString(context.getMessage());
        context.getPlayer().getSession().write(buffer);        
    }
}