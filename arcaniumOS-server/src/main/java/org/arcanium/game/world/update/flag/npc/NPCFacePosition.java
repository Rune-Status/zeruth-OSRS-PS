package org.arcanium.game.world.update.flag.npc;

import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.net.packet.IoBuffer;

/**
 * The NPC face coordinates update flag.
 * @author Emperor
 */
public final class NPCFacePosition extends UpdateFlag<Location> {

    /**
     * Constructs a new {@code NPCFaceLocation} {@code Object}.
     * @param context The location to face.
     */
    public NPCFacePosition(Location context) {
	super(context);
    }

    @Override
    public void write(IoBuffer buffer) {
	buffer.putLEShortA((context.getX() << 1) + 1).putLEShortA((context.getY() << 1) + 1);
    }

    @Override
    public int data() {
	return 64;
    }

    @Override
    public int ordinal() {
	return getOrdinal();
    }

    /**
     * Gets the mask ordinal.
     * @return The ordinal.
     */
    public static int getOrdinal() {
	return 1;
    }

}