package org.arcanium.game.world.update;

import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.combat.ImpactHandler;
import org.arcanium.game.node.entity.combat.ImpactHandler.Impact;
import org.arcanium.game.node.entity.impl.Animator;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.game.world.update.flag.context.HitMark;
import org.arcanium.game.world.update.flag.npc.NPCHitMask;
import org.arcanium.game.world.update.flag.player.AppearanceFlag;
import org.arcanium.game.world.update.flag.player.HitUpdateFlag;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Holds an entity's update masks.
 *
 * @author Emperor
 */
public final class UpdateMasks {

    /**
     * The mask data.
     */
    private int maskData = 0;

    /**
     * The appearance time stamp.
     */
    private long appearanceStamp;

    /**
     * The synced mask data.
     */
    private int syncedMask = 0;

    public int getMaskData() {
        return maskData;
    }

    /**
     * The amount of update masks.
     */
    public static final int SIZE = 11;

    /**
     * The update masks array.
     */
    private UpdateFlag<?>[] syncedMasks = new UpdateFlag[SIZE];

    /**
     * The update masks array.
     */
    public PriorityQueue<UpdateFlag> flagQueue = new PriorityQueue<UpdateFlag>();

    /**
     * A queue holding all update flags
     */
    private final List<UpdateFlag> queuedUpdates = new LinkedList<UpdateFlag>();

    /**
     * The update masks array.
     */
    private UpdateFlag<?>[] masks = new UpdateFlag[SIZE];

    public boolean isAnimating;

    /**
     * If the update masks are being updated.
     */
    private boolean updating;

    /**
     * The current animation priority.
     */
    private Animator.Priority animationPriority;

    /**
     * Registers an update flag.
     *
     * @param updateFlag The update flag.
     */
    public void register(UpdateFlag updateFlag) {
        if (updating) {
            queuedUpdates.add(updateFlag);
            return;
        }
        if ((maskData & updateFlag.data()) != 0) {
            flagQueue.remove(updateFlag);
        }
        maskData |= updateFlag.data();
        flagQueue.add(updateFlag);
    }

    /**
     * Registers an update flag.
     *
     * @param updateFlag The update flag.
     * @return {@code True} if successful.
     */
    public boolean register(UpdateFlag<?> updateFlag, boolean synced) {
        if (updating) {
            return false;
        }
        if (updateFlag instanceof AppearanceFlag) {
            appearanceStamp = System.currentTimeMillis();
            synced = true;
        }
        if (synced) {
            syncedMasks[updateFlag.ordinal()] = updateFlag;
            syncedMask |= updateFlag.data();
        }
        maskData |= updateFlag.data();
        masks[updateFlag.ordinal()] = updateFlag;
        return true;
    }

    /**
     * Prepares the outgoing packet for updating.
     *
     * @param e The entity who's using this update mask instance.
     */
    public void prepare(Entity e) {
        if (e.isPlayer()) {
            if (e.asPlayer().getAppearance() != null)
                e.asPlayer().getAppearance().prepareBodyData(e.asPlayer());
        }
        ImpactHandler handler = e.getImpactHandler();
        Impact impact = handler.getImpactQueue().peek();
        if (impact != null) {
            System.out.println("impact queue: " + impact.getAmount());
            registerHitUpdate(e, impact);
        }
        updating = true;
    }

    public void finish() {
        animationPriority = Animator.Priority.LOW;
        maskData = 0;
        flagQueue.clear();
        updating = false;
        isAnimating = false;
        for (UpdateFlag flag : queuedUpdates) {
            register(flag);
        }
        queuedUpdates.clear();
    }

    public boolean isUpdateRequired() {
        return maskData != 0;
    }

    /**
     * Registers the hit update for the given {@link Impact}.
     *
     * @param e      The entity.
     * @param impact The impact to update.
     */
    private HitMark registerHitUpdate(Entity e, Impact impact) {
        boolean player = e instanceof Player;
        HitMark mark = new HitMark(impact.getAmount(), impact.getType().ordinal(), e);
        if (player) {
            register(new HitUpdateFlag(mark));
        } else {
            register(new NPCHitMask(mark));
        }
        return mark;
    }

    /**
     * Registers the hit update for the given {@link Impact}.
     *
     * @param e         The entity.
     * @param impact    The impact to update.
     * @param secondary If the hit update is secondary.
     */
    private HitMark registerHitUpdate(Entity e, Impact impact, boolean secondary) {
        boolean player = e instanceof Player;
        HitMark mark = new HitMark(impact.getAmount(), impact.getType().ordinal(), e);
        if (player) {
            register(secondary ? new HitUpdateFlag(mark) : new HitUpdateFlag(mark));
        } else {
            register(secondary ? new NPCHitMask(mark) : new NPCHitMask(mark));
        }
        return mark;
    }
}