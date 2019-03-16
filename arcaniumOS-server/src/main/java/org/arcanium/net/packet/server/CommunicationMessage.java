package org.arcanium.net.packet.server;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.system.communication.ClanRepository;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.MessageContext;
import org.arcanium.tools.StringUtils;

import java.util.Random;

/**
 * Handles communication message packet sending.
 *
 * @author Emperor
 */
public final class CommunicationMessage implements ServerPacket<MessageContext> {

    @Override
    public void send(MessageContext context) {
        IoBuffer buffer = new IoBuffer(context.getOpcode(), (context.getOpcode() == MessageContext.CLAN_MESSAGE ? PacketHeader.BYTE : PacketHeader.SHORT));
        String message = context.getMessage();
        Player player = context.getPlayer();
        String other = context.getOther();
        System.out.println("SENDING COMMUNICATION ~ code : " + context.getOpcode());
        switch (context.getOpcode()) {
            case MessageContext.SEND_MESSAGE:
                byte[] bytes = new byte[256];
                int length = StringUtils.encryptPlayerChat(bytes, 0, 0, message.length(), message.getBytes());
                buffer.putString(other);
                buffer.putSmart(message.length());
                buffer.putBytes(bytes, 0, length);
                break;
            case MessageContext.RECIEVE_MESSAGE:
                bytes = new byte[256];
                bytes[0] = (byte) message.length();
                length = 1 + StringUtils.encryptPlayerChat(bytes, 0, 1, message.length(), message.getBytes());
                buffer.putString(other);
                for (int i = 0; i < 5; i++)
                    buffer.put(new Random().nextInt(0xFFFF));
                buffer.put(context.getChatIcon());
                buffer.putBytes(bytes, 0, length);
                break;
            case MessageContext.CLAN_MESSAGE:
                ClanRepository clan = player.getCommunication().getClan();
                bytes = new byte[256];
                bytes[0] = (byte) context.getMessage().length();
                length = 1 + StringUtils.encryptPlayerChat(bytes, 0, 1, message.length(), message.getBytes());
                buffer.putLong(StringUtils.stringToLong(other));
                buffer.put((byte) 0);// it's just read does nothing
                buffer.putLong(StringUtils.stringToLong(clan.getName()));
                buffer.putShort(new Random().nextInt(0xFFFF));
                buffer.putTri(getMessageIndex(player));
                buffer.put((byte) context.getChatIcon()); // rights
                buffer.putBytes(bytes, 0, length);
                break;
        }
        player.getSession().write(buffer);
    }

    /**
     * Gets the message index.
     *
     * @param p The player.
     * @return The message index.
     */
    private static int getMessageIndex(Player p) {
        int count = p.getAttribute("pm_index", 0) + 1;
        p.setAttribute("pm_index", count);
        return count;
    }

}