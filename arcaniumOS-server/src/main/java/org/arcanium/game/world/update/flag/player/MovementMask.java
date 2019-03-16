package org.arcanium.game.world.update.flag.player;

import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.net.packet.IoBuffer;

public final class MovementMask extends UpdateFlag<Integer> {

    /**
     * Constructs a new {@code AnimationFlag} {@code Object}.
     *
     * @param id    The animation id.
     * @param delay The animation delay.
     */
    public MovementMask(final int type) {
        super(type);
    }

    @Override
    public void write(IoBuffer buffer) {
        buffer.putByte128(context.intValue());
    }

    @Override
    public int data() {
        return maskData();
    }

    @Override
    public int ordinal() {
        return 2;
    }

    /**
     * Gets the mask data of the animation update flag.
     *
     * @return The mask data.
     */
    public static int maskData() {
        return 4096;
    }
}
