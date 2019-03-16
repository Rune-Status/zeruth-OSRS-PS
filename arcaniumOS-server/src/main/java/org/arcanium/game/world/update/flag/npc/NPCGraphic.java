package org.arcanium.game.world.update.flag.npc;

import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.game.world.update.flag.context.Graphics;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles an NPC's graphic update flag.
 * @author Emperor
 */
public final class NPCGraphic extends UpdateFlag<Graphics> {

    /**
     * Constructs a new {@code NPCGraphic} {@code Object}.
     * @param context The graphics.
     */
    public NPCGraphic(Graphics context) {
	super(context);
    }

    @Override
    public void write(IoBuffer buffer) {
	buffer.putShortLE(context.getId()).putNewVal(context.getHeight() << 16 | context.getDelay());
    }

    @Override
    public int data() {
	return maskData();
    }

    @Override
    public int ordinal() {
	return 5;
    }

    /**
     * Gets the mask data.
     * @return The mask data.
     */
    public static int maskData() {
	return 8;
    }

}