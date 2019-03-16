package org.arcanium.game.world.update.flag.player;

import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.game.world.update.flag.context.ContextMenu;
import org.arcanium.net.packet.IoBuffer;

/**
 * The main hit update flag.
 * @author Emperor
 */
public final class ContextMenuFlag extends UpdateFlag<ContextMenu> {

    /**
     * Constructs a new {@code ContextMenuFlag} {@code Object}.
     * @param context The hit mark.
     */
    public ContextMenuFlag(ContextMenu context) {
	super(context);
    }
   
    @Override
    public void write(IoBuffer buffer) {
	buffer.putString("");
	buffer.putString("");
	buffer.putString("");
    }

    @Override
    public int data() {
	return maskData();
    }

    @Override
    public int ordinal() {
	return 10;
    }

    /**
     * Gets the mask data.
     * @return The mask data.
     */
    public static int maskData() {
	return 256;
    }

}