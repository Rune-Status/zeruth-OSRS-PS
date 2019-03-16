package org.arcanium.net.packet.server;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.ContactContext;

/**
 * Handles the contact packet sending.
 *
 * @author trees
 */
public final class ContactPackets implements ServerPacket<ContactContext> {

    @Override
    public void send(ContactContext context) {
        IoBuffer buffer = null;
        Player player = context.getPlayer();
        switch (context.getType()) {
            case ContactContext.UPDATE_STATE_TYPE:
                System.out.println("[ContactPackets] UPDATE_STATE_TYPE :" + context.getType());
                //buffer = new IoBuffer(28, PacketHeader.SHORT);//.
                //buffer.put(WorldCommunicator.getState().value());
                break;
            case ContactContext.UPDATE_IGNORE_TYPE:
                System.out.println("[ContactPackets] UPDATE_IGNORE_TYPE :" + context.getType() + " name=" + context.getName() + " world=" + context.getWorldId() + " player=" + context.getPlayer());
                buffer = new IoBuffer(28, PacketHeader.SHORT);
                buffer.putByte128(1);
                buffer.putString(context.getName());
                buffer.putString("");
                buffer.putShort(context.getWorldId());
                break;
            case ContactContext.UPDATE_FRIEND_TYPE:
                System.out.println("[ContactPackets] UPDATE_FRIEND_TYPE :" + context.getType());
                buffer = new IoBuffer(38, PacketHeader.SHORT);
                for (String string : player.getCommunication().getBlocked()) {
                    buffer.put(0);
                    buffer.putString(string);
                    buffer.putString("");
                }
                break;
        }
        if (buffer != null) {
            player.getSession().write(buffer);
        }
    }

}