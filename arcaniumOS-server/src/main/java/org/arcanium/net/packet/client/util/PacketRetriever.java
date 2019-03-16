package org.arcanium.net.packet.client.util;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Dummy client packet
 *
 * @author trees
 */
public class PacketRetriever implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
        System.out.println("[PacketRetriever] plr=" + player.getDetails().getUsername() + " : opcode=" + opcode);
        switch (opcode) {
            default:
                break;
        }
    }
}