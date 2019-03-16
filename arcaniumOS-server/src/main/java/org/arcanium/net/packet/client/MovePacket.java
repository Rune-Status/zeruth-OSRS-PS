package org.arcanium.net.packet.client;

import org.arcanium.game.interaction.MovementPulse;
import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.map.Location;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.PlayerContext;
import org.arcanium.net.packet.server.ClearMinimapFlag;

/**
 * Handles an incoming walk packet.
 * @author Emperor
 */
public final class MovePacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
    	player = getPlayer(player);
    	if (player == null) {
    	    return;
    	}
    	if (player.getLocks().isMovementLocked() || !player.getInterfaceManager().close() || !player.getInterfaceManager().closeSingleTab() || !player.getDialogueInterpreter().close()) {
    	    PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
    	    player.debug("[WalkPacket] did not handle - [locked=" + player.getLocks().isMovementLocked() + "]!");
    	    return;
    	}
    	player.getProperties().setSpell(null);
    	player.getInterfaceManager().close();
    	player.getInterfaceManager().closeChatbox();

    	int y = buffer.getShort128(); //3rd
		System.out.println("Y: " + y);
    	int x = buffer.getShort128(); //2nd
		System.out.println("x: " + x);
    	int remaining = buffer.getByte128(); //1st
		System.out.println("Remaining: " + remaining);
    	boolean teleporting = remaining == 2;
		System.out.println("teleporting: " + teleporting);
    	if (teleporting) {
    	    player.teleport(new Location(x, y, player.getLocation().getZ()));
    	    return;
    	}
    	player.face((Entity) null);
    	player.faceLocation(player.getLocation());
    	player.getWalkingQueue().reset(player.getSettings().isRunToggled());
    	player.getPulseManager().run(new MovementPulse(player, Location.create(x, y, player.getLocation().getZ()), player.getSettings().isRunToggled()) {
    	    @Override
    	    public boolean pulse() {
    		return true;
    	    }
    	}, "movement");
    }

    /**
     * Gets the player instance (used for AIP controlling).
     * @param player The player.
     * @return The player instance, or the AIP when the player is controlling an
     * AIP.
     */
    private static Player getPlayer(Player player) {
	if (player == null) {
	    return null;
	}
	return player;
    }

}