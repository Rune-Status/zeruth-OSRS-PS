package org.arcanium.game.world.update.flag.player;

import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.impl.ForceMovement;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles the force movement player update flag.
 * @author Emperor
 */
public final class ForceMovementFlag extends UpdateFlag<ForceMovement> {

    /**
     * Constructs a new {@code ForceMovementFlag} {@code Object}.
     * @param forceMovement The force movement data.
     */
    public ForceMovementFlag(ForceMovement forceMovement) {
	super(forceMovement);
    }

    @Override
    public void write(IoBuffer buffer) {

    }

    @Override
    public void writeDynamic(IoBuffer buffer, Entity e) {
	Location l = ((Player) e).getPlayerFlags().getLastSceneGraph();
	buffer.putReversed128Byte(context.getStart().getSceneX(l));
		// Start location
	buffer.put128Byte(context.getStart().getSceneY(l));
	
	buffer.put128Byte(context.getDestination().getSceneX(l)); //questionable
		// Destination location
	buffer.putReversed128Byte(context.getDestination().getSceneY(l));
	
	buffer.putShort128(context.getCommenceSpeed() * 30);
		// speed
	buffer.putN((context.getCommenceSpeed() * 30) + (context.getPathSpeed() * 30 + 1)); 
	// Path
		// speed
	buffer.putShort(context.getDirection().toInteger());
    }

    @Override
    public int data() {
	return maskData();
    }

    @Override
    public int ordinal() {
	return 3;
    }

    /**
     * Gets the mask data.
     * @return The mask data.
     */
    public static int maskData() {
	return 1024;
    }

}