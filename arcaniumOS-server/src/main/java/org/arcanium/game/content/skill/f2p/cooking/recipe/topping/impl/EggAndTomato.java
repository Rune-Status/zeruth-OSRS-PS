package org.arcanium.game.content.skill.f2p.cooking.recipe.topping.impl;

import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.content.skill.f2p.cooking.recipe.Recipe;
import org.arcanium.game.interaction.NodeUsageEvent;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;

/**
 * Represents the egg and tomato recipe. This recipe consists of mixing a tomato
 * with a scrambled egg.
 * @author 'Vexia
 * @date 22/12/2013
 */
public class EggAndTomato extends Recipe {

    /**
     * Represents the egg and tomato.
     */
    private static final Item EGG_AND_TOMATO = new Item(7064);

    /**
     * Represents the scrambled egg item.
     */
    private static final Item SCRAMBLED_EGG = new Item(7078);

    /**
     * epresents the tomato item.
     */
    private static final Item TOMATO = new Item(1982);

    @Override
    public void mix(final Player player, final NodeUsageEvent event) {
	if (player.getSkills().getLevel(Skills.COOKING) < 23) {
	    player.getDialogueInterpreter().sendDialogue("You need a Cooking level of at least " + 23 + " in order to do this.");
	    return;
	}
	super.mix(player, event);
	player.getSkills().addExperience(Skills.COOKING, 50, true);
    }

    @Override
    public Item getBase() {
	return SCRAMBLED_EGG;
    }

    @Override
    public Item getProduct() {
	return EGG_AND_TOMATO;
    }

    @Override
    public Item[] getIngredients() {
	return new Item[] { TOMATO };
    }

    @Override
    public Item[] getParts() {
	return new Item[] {};
    }

    @Override
    public String getMixMessage(NodeUsageEvent event) {
	return null;
    }

    @Override
    public boolean isSingular() {
	return true;
    }

}
