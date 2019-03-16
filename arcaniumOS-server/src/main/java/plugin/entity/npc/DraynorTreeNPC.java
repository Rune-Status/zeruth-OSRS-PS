/*
 * Copyright (c) 2018.
 */

package plugin.entity.npc;

import org.arcanium.game.node.entity.combat.ImpactHandler;
import org.arcanium.game.node.entity.impl.Animator;
import org.arcanium.game.node.entity.npc.AbstractNPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.game.world.update.flag.context.Animation;
import org.arcanium.tools.RandomFunction;

import java.util.List;

/**
 * Represents the abstract draynor tree npc.
 *
 * @author 'Vexia
 * @version 1.0
 */
public final class DraynorTreeNPC extends AbstractNPC {

    /**
     * Represents the NPC ids of NPCs using this plugin.
     */
    private static final int[] ID = {5208, 152, 5207};

    /**
     * Represents the animation of the tree.
     */
    private static final Animation ANIMATION = new Animation(73, Animator.Priority.HIGH);

    /**
     * Represents the attack delay.
     */
    private int attackDelay;

    /**
     * Constructs a new {@code DraynorTreeNPC} {@code Object}.
     *
     * @param id       the id.
     * @param location the location.
     */
    private DraynorTreeNPC(int id, Location location) {
        super(id, location, false);
    }

    @Override
    public AbstractNPC construct(int id, Location location, Object... objects) {
        return new DraynorTreeNPC(id, location);
    }

    @Override
    public void tick() {
        final List<Player> players = RegionManager.getLocalPlayers(this, 1);
        if (players.size() != 0) {
            if (attackDelay < GameWorld.getTicks()) {
                for (Player p : players) {
                    faceTemporary(p, 2);
                    getAnimator().forceAnimation(ANIMATION);
                    int hit = RandomFunction.random(2);
                    p.getImpactHandler().manualHit(this, hit, hit > 0 ? ImpactHandler.HitsplatType.NORMAL : ImpactHandler.HitsplatType.MISS);
                    attackDelay = GameWorld.getTicks() + 3;
                    p.animate(p.getProperties().getDefenceAnimation());
                    return;
                }
            }
        }
        super.tick();
    }

    @Override
    public int[] getIds() {
        return ID;
    }

}
