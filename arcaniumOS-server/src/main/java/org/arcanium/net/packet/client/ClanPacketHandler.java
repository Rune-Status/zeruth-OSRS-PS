package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.system.communication.ClanRepository;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles incoming clan packets.
 *
 * @author Emperor
 * @author trees
 */
public class ClanPacketHandler implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
        System.out.println("Clan packet recieving opcode : " + opcode);
        switch (buffer.opcode()) {
            case 86: // JOIN & LEAVE
                String name = buffer.getString();
                if (!name.equals("")) {
                    player.getPacketDispatch().sendMessage("Attempting to join channel...");
                }
                if (player.getCommunication().getClan() != null) {
                    player.getCommunication().getClan().leave(player, true);
                    player.getCommunication().setClan(null);
                    return;
                }
                ClanRepository clan = ClanRepository.get(name);
                if (clan == null || clan.getName().equals("Chat disabled")) {
                    player.getPacketDispatch().sendMessage("The channel you tried to join does not exist.");
                    break;
                }
                if (clan.enter(player)) {
                    player.getCommunication().setClan(clan);
                }
                break;
        }
    }
}