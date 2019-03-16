package org.arcanium.game.world.update.flag.npc;

import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.net.packet.IoBuffer;

/**
 * The switch NPC id update flag.
 * @author Emperor
 */
public final class NPCTransform extends UpdateFlag<Integer> {

    /**
     * Constructs a new {@code NPCSwitchId} {@code Object}.
     * @param context The new NPC id.
     */
    public NPCTransform(int context) {
	super(context);
    }

    @Override
    public void write(IoBuffer buffer) {
	buffer.putShort(context);
    }

    @Override
    public int data() {
	return 4;
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
	return 3;
    }

}