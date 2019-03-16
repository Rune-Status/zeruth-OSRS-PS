package org.arcanium.game.content.skill.p2p.farming.tool;

import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.content.skill.p2p.farming.FarmingConstant;
import org.arcanium.game.content.skill.p2p.farming.wrapper.PatchWrapper;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.info.portal.Perks;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.world.update.flag.context.Animation;
import org.arcanium.tools.RandomFunction;

/**
 * Represents the pulse used when raking.
 * @author 'Vexia
 * @version 1.0
 */
public final class RakePulse extends ToolAction {

    /**
     * Represents the raking animation to use.
     */
    private static final Animation ANIMATION = new Animation(2273);

    /**
     * Constructs a new {@code RakePulse} {@code Object}.
     */
    public RakePulse() {
	super(null, null, null);
    }

    /**
     * Constructs a new {@code RakePulse} {@code Object}.
     * @param player the player.
     * @param wrapper the wrapper.
     * @param delay the delay.
     */
    public RakePulse(final Player player, final PatchWrapper wrapper) {
	super(player, wrapper, null);
    }

    @Override
    public ToolAction newInstance(Player player, PatchWrapper wrapper, Item item) {
	return new RakePulse(player, wrapper);
    }

    @Override
    public boolean pulse() {
	if (ticks == 0) {
	    player.animate(ANIMATION);
	}
	if (!isReward(3)) {
	    return false;
	}
	player.animate(ANIMATION);
	if (!player.hasPerk(Perks.GREEN_THUMB) && !player.getInventory().hasSpaceFor(FarmingConstant.WEEDS)) {
	    return true;
	}
	if (((RandomFunction.getRandom(3) * player.getSkills().getLevel(Skills.FARMING)) / 3) > ((player.getSkills().getLevel(Skills.FARMING) > 5 ? player.getSkills().getLevel(Skills.FARMING) - 5 : 0) / 2)) {
	    if (player.hasPerk(Perks.GREEN_THUMB) || player.getInventory().add(FarmingConstant.WEEDS)) {
		wrapper.addConfigValue(wrapper.getState() + 1);
		player.getSkills().addExperience(Skills.FARMING, 4, true);
		wrapper.getCycle().getGrowthHandler().setGrowthUpdate();
	    }
	}
	return wrapper.isEmpty() || !player.getInventory().hasSpaceFor(FarmingConstant.WEEDS);
    }

    @Override
    public void stop() {
	super.stop();
	player.getAnimator().reset();
    }

    @Override
    public boolean canInteract(String command) {
	if (!wrapper.isWeedy()) {
	    player.getPacketDispatch().sendMessage("The " + wrapper.getName() + " patch doesn't need weeding right now.");
	    return false;
	}
	if (!player.getInventory().hasSpaceFor(FarmingConstant.WEEDS)) {
	    player.getDialogueInterpreter().sendDialogue("You don't have enough inventory space.");
	    return false;
	}
	return true;
    }

}
