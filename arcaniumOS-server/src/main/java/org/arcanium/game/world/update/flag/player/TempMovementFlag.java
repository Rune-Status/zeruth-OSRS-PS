package org.arcanium.game.world.update.flag.player;

import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.game.world.update.flag.context.TempMovement;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles the chat flag.
 *
 * @author Emperor
 */
public class TempMovementFlag extends UpdateFlag<TempMovement> {

    /**
     * Constructs a new {@code ChatFlag.java} {@code Object}.
     *
     * @param context The context.
     */
    public TempMovementFlag(TempMovement context) {
        super(context);
    }

    @Override
    public void write(IoBuffer buffer) {
	buffer.putByte128(context.getType());
       
    }

    @Override
    public int data() {
        return maskData();
    }

    @Override
    public int ordinal() {
        return 8;
    }

    /**
     * Gets the mask data of the chat update flag.
     *
     * @return The mask data.
     */
    public static int maskData() {
        return 2048;
    }
}