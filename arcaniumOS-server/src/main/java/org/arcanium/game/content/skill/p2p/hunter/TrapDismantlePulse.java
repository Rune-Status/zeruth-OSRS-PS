package org.arcanium.game.content.skill.p2p.hunter;

import org.arcanium.game.content.skill.SkillPulse;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.object.GameObject;

/**
 * Handles the dismantling of a trap.
 * @author Vexia
 */
public final class TrapDismantlePulse extends SkillPulse<GameObject> {

    /**
     * The trap wrapper.
     */
    private final TrapWrapper wrapper;

    /**
     * The trap type.
     */
    private final Traps trap;

    /**
     * The ticks passed.
     */
    private int ticks;

    /**
     * Constructs a new {@code TrapDismantlePulse} {@code Object}.
     * @param player the player.
     * @param node the node.
     * @param trap the trap.
     */
    public TrapDismantlePulse(Player player, GameObject node, final TrapWrapper wrapper) {
	super(player, node);
	this.trap = wrapper.getType();
	this.wrapper = wrapper;
    }

    @Override
    public boolean checkRequirements() {
	if (wrapper == null || !player.getHunterManager().isOwner(node)) {
	    player.sendMessage("This isn't your trap!");
	    return false;
	}
	final int itemCount = wrapper.getItems().size() + (wrapper.getType().getSettings().isObjectTrap() ? 0 : 1);
	final int difference = itemCount - player.getInventory().freeSlots();
	if (player.getInventory().freeSlots() < itemCount) {
	    player.getPacketDispatch().sendMessage("You don't have enough inventory space. You need " + difference + " more free slot" + (difference > 1 ? "s" : "") + ".");
	    return false;
	}
	return true;
    }

    @Override
    public void animate() {
	if (ticks < 1) {
	    player.getAnimator().forceAnimation(trap.getSettings().getDismantleAnimation());
	}
    }

    @Override
    public boolean reward() {
	if (++ticks % (trap.getSettings().getDismantleAnimation().getDefinition().getDurationTicks() + 1) != 0) {
	    return false;
	}
	if (wrapper.getType().getSettings().clear(wrapper, 1)) {
	    player.getHunterManager().deregister(wrapper);
	    if (wrapper.isCaught()) {
		player.getSkills().addExperience(Skills.HUNTER, wrapper.getReward().getExperience(), true);
	    }
	    player.getPacketDispatch().sendMessage("You dismantle the trap.");
	}
	return true;
    }

    @Override
    public void message(int type) {
	switch (type) {
	case 0:
	    int ticks = wrapper.getTicks() + (wrapper.getType().getSettings().getDismantleAnimation().getDefinition().getDurationTicks()) + 1;
	    wrapper.setTicks(ticks);
	    wrapper.setBusyTicks(ticks);
	    break;
	}
    }

    /**
     * Gets the trap.
     * @return The trap.
     */
    public Traps getTrap() {
	return trap;
    }

    /**
     * Gets the wrapper.
     * @return The wrapper.
     */
    public TrapWrapper getWrapper() {
	return wrapper;
    }

}
