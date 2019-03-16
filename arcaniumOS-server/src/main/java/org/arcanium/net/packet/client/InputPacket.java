package org.arcanium.net.packet.client;

import org.arcanium.ServerConstants;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.system.SystemLogger;
import org.arcanium.game.system.communication.Contact;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles an incoming input data
 *
 * @author trees
 */
public final class InputPacket implements ClientPacket {

    final int FRIENDS_ADD = 79;

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
        switch (buffer.opcode()) {
            case FRIENDS_ADD:
                String request_val = buffer.getString().substring(0);
                Player requested_plr = Repository.getPlayerFile(request_val);
                if (requested_plr != null) {
                    player.getDetails().getCommunication().getContacts().put(request_val, new Contact(requested_plr.getDetails().getUsername()));
                    player.getDetails().getCommunication().sync(player);
                }
                if (ServerConstants.DEBUG) {
                    SystemLogger.log("[InputPacket] Request friend add [index=" + requested_plr.getIndex() + "  :  val=" + request_val + "]");
                }
                break;
        }
    }
}