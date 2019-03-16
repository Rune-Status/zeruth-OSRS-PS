package org.arcanium.game.world.update.flag.npc;

import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.net.packet.IoBuffer;

/**
 * The face entity update flag for NPCs.
 * @author Emperor
 */
public final class NPCFaceEntity extends UpdateFlag<Entity> {

    /**
     * Constructs a new {@code NPCFaceEntity} {@code Object}.
     * @param context The context.
     */
    public NPCFaceEntity(Entity context) {
	super(context);
    }

    @Override
    public void write(IoBuffer buffer) {
	buffer.putShortLE(context == null ? -1 : context.getClientIndex());
    }

    @Override
    public int data() {
	return 1;
    }

    @Override
    public int ordinal() {
	return getOrdinal();
    }

    /**
     * Gets the mask data.
     * @return The mask data.
     */
    public static int getOrdinal() {
	return 0;
    }

}