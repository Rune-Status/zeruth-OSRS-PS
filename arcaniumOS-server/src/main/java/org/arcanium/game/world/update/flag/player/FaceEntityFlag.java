package org.arcanium.game.world.update.flag.player;

import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.net.packet.IoBuffer;

/**
 * The face entity update flag.
 * @author Emperor
 */
public final class FaceEntityFlag extends UpdateFlag<Entity> {

    /**
     * Constructs a new {@code FaceEntityFlag} {@code Object}.
     * @param context The entity to face.
     */
    public FaceEntityFlag(Entity context) {
	super(context);
    }

    @Override
    public void write(IoBuffer buffer) {
    	buffer.putShort128(context == null ? -1 : context.getClientIndex());
    }

    @Override
    public int data() {
	return 2;
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
	return 7;
    }

}