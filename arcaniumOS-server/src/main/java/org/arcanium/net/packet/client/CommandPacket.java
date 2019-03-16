package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.system.command.CommandSystem;
import org.arcanium.game.system.monitor.PlayerMonitor;
import org.arcanium.game.world.GameWorld;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles an incoming command packet.
 *
 * @author Emperor
 * @author 'Vexia
 */
public final class CommandPacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
        final int data = buffer.getByte();
        if (buffer.toByteBuffer().hasRemaining()) {
            final String message = ((char) data + buffer.getString()).toLowerCase();
            if (!GameWorld.getSettings().isDevMode()) {
                int last = player.getAttribute("commandLast", 0);
                if (last > GameWorld.getTicks()) {
                    return;
                }
                player.setAttribute("commandLast", GameWorld.getTicks() + 1);
            }
            if (CommandSystem.getCommandSystem().parse(player, message)) {
                player.getMonitor().log(message, PlayerMonitor.COMMAND_LOG);
            }
        }
    }

}