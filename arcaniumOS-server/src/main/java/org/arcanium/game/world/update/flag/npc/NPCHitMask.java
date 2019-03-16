package org.arcanium.game.world.update.flag.npc;

import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.combat.ImpactHandler;
import org.arcanium.game.node.entity.combat.ImpactHandler.Impact;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.game.world.update.flag.context.HitMark;
import org.arcanium.net.packet.IoBuffer;

/**
 * The NPC's main hit update flag.
 *
 * @author Emperor
 */
public final class NPCHitMask extends UpdateFlag<HitMark> {

    /**
     * Constructs a new {@code NPCHitFlag} {@code Object}.
     *
     * @param context The hit mark.
     */
    public NPCHitMask(HitMark context) {
        super(context);
    }

    @Override
    public void write(IoBuffer buffer) {
        Entity e = context.getEntity();
        ImpactHandler h = e.getImpactHandler();
        buffer.putByteC(h.getImpactQueue().size());
        while (!h.getImpactQueue().isEmpty()) {
            final Impact impact = h.getImpactQueue().poll();
            buffer.putSmart(impact.getType().ordinal());//hitmark type.
            buffer.putSmart(impact.getAmount());//hit damage value.
            buffer.putSmart(0);//hit delay.
        }
        /**
         * Hitbars. Since there's no dynamic support for them in the source itself,
         * I'm going to simply write a generic one.
         */
        buffer.putByte128(1);//amount of hitbars.
        buffer.putSmart(0);//hitbar type (0 is regular, ids like 8-9 or w/e are raid ones etc.
        final int hp = e.getSkills().getLifepoints();
        final int maxHp = e.getSkills().getMaximumLifepoints();
        int perc = (int) ((double) hp / maxHp * 30);
        buffer.putSmart(0);//32767 = missed, 0/1 = unknown tbh, it's RS3 code and I think unused in OSRS.
        buffer.putSmart(0);//hitbar delay.
        buffer.put(perc);
    }

    @Override
    public int data() {
        return maskData();
    }

    @Override
    public int ordinal() {
        return 4;
    }

    /**
     * Gets the mask data.
     *
     * @return The mask data.
     */
    public static int maskData() {
        return 16;
    }

}