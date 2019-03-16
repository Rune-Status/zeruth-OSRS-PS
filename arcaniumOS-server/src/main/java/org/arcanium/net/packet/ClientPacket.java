package org.arcanium.net.packet;

import org.arcanium.game.node.entity.player.Player;

/**
 * Represents an incoming packet.
 * @author Emperor
 */
public interface ClientPacket {

    /**
     * Decodes the incoming packet.
     * @param player The player.
     * @param opcode The opcode.
     * @param buffer The buffer.
     * @return The new buffer to send in response.
     */
    public void decode(Player player, int opcode, IoBuffer buffer);

}