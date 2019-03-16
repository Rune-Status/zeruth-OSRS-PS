package org.arcanium.game.world.update.flag.player;

import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.combat.ImpactHandler;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.game.world.update.flag.context.HitMark;
import org.arcanium.net.packet.IoBuffer;

/**
 * The main hit update flag.
 *
 * @author Emperor
 */
public final class HitUpdateFlag extends UpdateFlag<HitMark> {

    /**
     * Constructs a new {@code HitUpdateFlag} {@code Object}.
     *
     * @param context The hit mark.
     */
    public HitUpdateFlag(HitMark context) {
        super(context);
    }

    @Override
    public void write(IoBuffer buffer) {
        Entity e = context.getEntity();
        ImpactHandler h = e.getImpactHandler();
        buffer.putByte128(h.getImpactQueue().size());
        int hitpoints = e.getSkills().getLifepoints();
        int maxHitpoints = e.getSkills().getMaximumLifepoints();
        if(hitpoints > maxHitpoints)
            hitpoints = maxHitpoints;
        int perc = (int) ((double) hitpoints / maxHitpoints * 30);
        int hpBarPercentage = (hitpoints == 0 || maxHitpoints == 0) ? 0 : (hitpoints * 255 / maxHitpoints);
        int toPerc = hpBarPercentage - perc;
        while (!h.getImpactQueue().isEmpty()) {
            final ImpactHandler.Impact impact = h.getImpactQueue().poll();
            int type = impact.getType().ordinal();
            int damage = impact.getAmount();
            int delay = 0;
            buffer.putSmart(type);
            buffer.putSmart(damage);
            buffer.putSmart(delay);
        }
        int hitbars = 1;//amt
        buffer.putByteC(hitbars);
        buffer.putSmart(0);//hitbartype
        buffer.putSmart(0);//1,0,32767
        buffer.putSmart(0);//delay
        buffer.putByte128(perc);
    }

    @Override
    public int data() {
        return maskData();
    }

    @Override
    public int ordinal() {
        return 0;
    }

    /**
     * Gets the mask data.
     *
     * @return The mask data.
     */
    public static int maskData() {
        return 64;
    }

}