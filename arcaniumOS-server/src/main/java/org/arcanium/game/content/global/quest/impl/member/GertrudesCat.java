package org.arcanium.game.content.global.quest.impl.member;

import org.arcanium.game.content.global.quest.Quest;
import org.arcanium.game.content.global.quest.QuestState;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.GroundItemManager;
import org.arcanium.game.node.item.Item;
import org.arcanium.tools.RandomFunction;

/**
 * Represents the gertrudes fortress quest.
 * @author 'Vexia
 */
public class GertrudesCat extends Quest {

    /**
     * Constructs a new {@code GertrudesCat} {@code Object}.
     * @param player The player to construct the class for.
     */
    public GertrudesCat(final Player player) {
	super(player);
    }

    @Override
    public void update() {
	super.clear();
	switch (stage) {
	case 0:
	    player.getPacketDispatch().sendString(getBlue() + "I can start this quest by speaking to " + getRed() + "Gertrude.", 275, 4);
	    player.getPacketDispatch().sendString(getBlue() + "She can be found to the " + getRed() + "west of Varrock.", 275, 5);
	    break;
	case 10:
	    player.getPacketDispatch().sendString("<str>I accepted the challenge of finding Gertrude's lost cat.", 275, 4);
	    player.getPacketDispatch().sendString(getBlue() + "I need " + getRed() + "to speak to Shilop and Wilough" + getBlue() + " at the " + getRed() + "marketplace.", 275, 6);
	    break;
	case 20:
	    player.getPacketDispatch().sendString("<str>I accepted the challenge of finding Gertrude's lost cat.", 275, 4);
	    player.getPacketDispatch().sendString("<str>I spoke to Shilop, Gertrude's Son.", 275, 5);
	    player.getPacketDispatch().sendString(getBlue() + "I need to " + getRed() + "go to their play area " + getBlue() + "and " + getRed() + "find the lost cat and", 275, 7);
	    player.getPacketDispatch().sendString(getRed() + "return it to Gertrude.", 275, 8);
	    break;
	case 30:
	    player.getPacketDispatch().sendString("<str>I accepted the challenge of finding Gertrude's lost cat.", 275, 4);
	    player.getPacketDispatch().sendString("<str>I spoke to Shilop, Gertrude's Son.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I found the lost cat but it won't come back.</str>", 275, 6);
	    player.getPacketDispatch().sendString(getRed() + "I still need to " + getRed() + "get her to follow me home.", 275, 8);
	    break;
	case 40:
	case 50:
	    player.getPacketDispatch().sendString("<str>I accepted the challenge of finding Gertrude's lost cat.", 275, 4);
	    player.getPacketDispatch().sendString("<str>I spoke to Shilop, Gertrude's Son.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I found the lost cat but it won't come back.</str>", 275, 6);
	    player.getPacketDispatch().sendString("<str>I gave the cat milk and sardines.</str>", 275, 7);
	    player.getPacketDispatch().sendString(getBlue() + "I still need " + getRed() + "get her to follow me home.", 275, 9);
	    break;
	case 60:
	    player.getPacketDispatch().sendString("<str>I accepted the challenge of finding Gertrude's lost cat.", 275, 4);
	    player.getPacketDispatch().sendString("<str>I spoke to Shilop, Gertrude's Son.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I found the lost cat but it won't come back.</str>", 275, 6);
	    player.getPacketDispatch().sendString("<str>I gave the cat milk and sardines.</str>", 275, 7);
	    player.getPacketDispatch().sendString(getBlue() + "She ran off home.", 275, 9);
	    break;
	case 100:
	    player.getPacketDispatch().sendString("<str>I helped Gertrude to find her lost cat,", 275, 4);
	    player.getPacketDispatch().sendString("<str>I fed it and returned her missing kitten,", 275, 5);
	    player.getPacketDispatch().sendString("<str>Gertrude gave me my very own pet for a reward.", 275, 6);
	    player.getPacketDispatch().sendString("<col=FF0000>QUEST COMPLETE!", 275, 8);
	    break;
	}
    }

    @Override
    public void finish() {
	super.finalize();
	final Item kitten = getKitten();
	player.getConfigManager().sendVarp(101, player.getQuestRepository().getPoints());
	player.getPacketDispatch().sendString("1 Quest Point", 277, 8);
	player.getPacketDispatch().sendString("A kitten!", 277, 9);
	player.getPacketDispatch().sendString("1525 Cooking XP", 277, 10);
	player.getPacketDispatch().sendString("A chocolate cake", 277, 11);
	player.getPacketDispatch().sendString("A bowl of stew", 277, 12);
	player.getPacketDispatch().sendString("Raise cats.", 277, 13);
	player.getSkills().addExperience(Skills.COOKING, 1525);
	player.getPacketDispatch().sendItemZoomOnInterface(kitten.getId(), 240, 277, 3);
	setStage(100);
	setState(QuestState.COMPLETED);
	player.getInventory().add(kitten);
	//player.getFamiliarManager().summon(kitten, true);
	final Item cake = new Item(1897);
	final Item stew = new Item(2003);
	if (!player.getInventory().add(cake)) {
	    GroundItemManager.create(cake, player.getLocation(), player);
	}
	if (!player.getInventory().add(stew)) {
	    GroundItemManager.create(stew, player.getLocation(), player);
	}
    }

    /**
     * Method used to get a random kitten.
     * @return the item.
     */
    public Item getKitten() {
	return new Item(RandomFunction.random(1555, 1560));
    }

    @Override
    public int[] getConfig() {
	if (state == QuestState.COMPLETED) {
	    return new int[] { 180, 100 };
	} else if (state == QuestState.STARTED) {
	    return new int[] { 180, 1 };
	} else {
	    return new int[] { 180, 0 };
	}
    }

    @Override
    public int getIndex() {
	return 67;
    }

    @Override
    public String getName() {
	return "Gertrude's Cat";
    }

    @Override
    public int getQuestPoints() {
	return 1;
    }
}
