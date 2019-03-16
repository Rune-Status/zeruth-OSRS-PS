package org.arcanium.game.content.global.quest.impl.free;

import org.arcanium.game.component.Component;
import org.arcanium.game.content.global.quest.Quest;
import org.arcanium.game.content.global.quest.QuestState;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;

/**
 * The main type for the quest.
 * @author Vexia
 */
public class RestlessGhost extends Quest {

    /**
     * The name of the quest.
     */
    public static String NAME = "The Restless Ghost";

    /**
     * The ghost speak amulet.
     */
    public static final Item AMULET = new Item(552);

    /**
     * Constructs a new {@code RestlessGhost} {@code Object}.
     * @param player The player to construct the class for.
     */
    public RestlessGhost(final Player player) {
	super(player);
    }

    @Override
    public void update() {
	for (int i = 0; i < 256; i++) {
	    player.getPacketDispatch().sendString("", 275, i);
	}
	player.getPacketDispatch().sendString("<col=8A0808>The Restless Ghost</col>", 275, 2);
	if (stage == 0) {
	    player.getPacketDispatch().sendString("<col=08088A>I can start this quest by speaking to <col=8A0808>Father Aereck</col> <col=08088A>in the", 275, 4);
	    player.getPacketDispatch().sendString("<col=8A0808>church</col> <col=08088A>next to <col=8A0808>Lumbridge Castle.<col=8A0808>", 275, 5);
	    player.getPacketDispatch().sendString("<col=08088A>I must be unafraid of a <col=8A0808>Level 13 Skeleton ", 275, 6);
	}
	if (stage == 10) {
	    player.getPacketDispatch().sendString("<str>Father Aereck asked me to help him deal with the Ghost in", 275, 4);
	    player.getPacketDispatch().sendString("<str>the graveyard next to the church.", 275, 5);
	    player.getPacketDispatch().sendString("<col=08088A>I should find <col=8A0808>Father Urhney</col><col=08088A> who is an expert on </col><col=8A0808>ghosts.</col>  ", 275, 6);
	    player.getPacketDispatch().sendString("<col=08088A>He lives in a <col=8A0808>shack</col><col=08088A> in <col=8A0808>Lumbridge Swamp.", 275, 7);

	}
	if (stage == 20) {
	    player.getPacketDispatch().sendString("<str>Father Aereck asked me to help him deal with the Ghost in", 275, 4);
	    player.getPacketDispatch().sendString("<str>the graveyard next to the church.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I should find Father Urhney who is an expert on ghosts.</str>  ", 275, 6);
	    player.getPacketDispatch().sendString("<str>He lives in a shack in Lumbridge Swamp.</str>", 275, 7);
	    player.getPacketDispatch().sendString("<col=08088A>I should talk to the</col> <col=8A0808>Ghost</col> <col=08088A>to find out why it is haunting the", 275, 8);
	    player.getPacketDispatch().sendString("<col=8A0808>graveyard crypt", 275, 9);
	}
	if (stage == 30) {
	    player.getPacketDispatch().sendString("<str>Father Aereck asked me to help him deal with the Ghost in", 275, 4);
	    player.getPacketDispatch().sendString("<str>the graveyard next to the church.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I found Father Urhney in the swamp south of Lumbridge.He</str>  ", 275, 6);
	    player.getPacketDispatch().sendString("<str>gave me an Amulet of Ghostspeak to talk to the ghost.</str>", 275, 7);
	    player.getPacketDispatch().sendString("<str>I spoke to the Ghost and he told me he could not rest in</str>", 275, 8);
	    player.getPacketDispatch().sendString("<str>peace because an evil wizard had stolen his skull.</str>", 275, 9);
	    player.getPacketDispatch().sendString("<col=08088A>I should go and search the <col=8A0808>Wizard's Tower South West of", 275, 10);
	    player.getPacketDispatch().sendString("<col=8A0808>Lumbridge</col> <col=08088A>for the <col=8A0808>Ghost's Skull.", 275, 11);
	}
	if (stage == 40) {
	    player.getPacketDispatch().sendString("<str>Father Aereck asked me to help him deal with the Ghost in", 275, 4);
	    player.getPacketDispatch().sendString("<str>the graveyard next to the church.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I found Father Urhney in the swamp south of Lumbridge.He</str>  ", 275, 6);
	    player.getPacketDispatch().sendString("<str>gave me an Amulet of Ghostspeak to talk to the ghost.</str>", 275, 7);
	    player.getPacketDispatch().sendString("<str>I spoke to the Ghost and he told me he could not rest in</str>", 275, 8);
	    player.getPacketDispatch().sendString("<str>peace because an evil wizard had stolen his skull.</str>", 275, 9);
	    player.getPacketDispatch().sendString("<str>I found the Ghost's Skull in the basement of the Wizards'", 275, 10);
	    player.getPacketDispatch().sendString("<str>Tower. It was guarded by a skeleton, but I took it anyways.</str>", 275, 11);
	    player.getPacketDispatch().sendString("<col=08088A>I should take the <col=8A0808>Skull</col> <col=08088A>back to the <col=8A0808>Ghost</col> <col=08088A>so it can rest.", 275, 12);
	}
	if (stage == 100) {
	    player.getPacketDispatch().sendString("<str>Father Aereck asked me to help him deal with the Ghost in", 275, 4);
	    player.getPacketDispatch().sendString("<str>the graveyard next to the church.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I found Father Urhney in the swamp south of Lumbridge.He</str>  ", 275, 6);
	    player.getPacketDispatch().sendString("<str>gave me an Amulet of Ghostspeak to talk to the ghost.</str>", 275, 7);
	    player.getPacketDispatch().sendString("<str>I spoke to the Ghost and he told me he could not rest in</str>", 275, 8);
	    player.getPacketDispatch().sendString("<str>peace because an evil wizard had stolen his skull.</str>", 275, 9);
	    player.getPacketDispatch().sendString("<str>I found the Ghost's Skull in the basement of the Wizards'", 275, 10);
	    player.getPacketDispatch().sendString("<str>Tower. It was guarded by a skeleton, but I took it anyways.</str>", 275, 11);
	    player.getPacketDispatch().sendString("<str>I placed the Skull in the Ghost's coffin, and allowed it to", 275, 12);
	    player.getPacketDispatch().sendString("<str>rest in peace once more, with gratitude for my help.", 275, 13);
	    player.getPacketDispatch().sendString("<col=FF0000>QUEST COMPLETE!", 275, 16);
	}
    }

    @Override
    public void finish() {
	player.getQuestRepository().update(player);
	player.getQuestRepository().incrementPoints(getQuestPoints());
	player.getConfigManager().sendVarp(101, player.getQuestRepository().getPoints());
	player.getInterfaceManager().open(new Component(277));
	for (int i = 8; i < 15; i++) {
	    player.getPacketDispatch().sendString("", 277, i);
	}
	player.getPacketDispatch().sendString("1 Quest Point", 277, 8);
	player.getPacketDispatch().sendString("1125 Prayer XP", 277, 9);
	player.getPacketDispatch().sendItemZoomOnInterface(964, 240, 277, 3);
	player.getSkills().addExperience(Skills.PRAYER, 1125);
	player.getInterfaceManager().closeChatbox();
	player.getPacketDispatch().sendString("You have completed The Restless Ghost Quest!", 277, 2);
	setStage(100);
	setState(QuestState.COMPLETED);
	player.getConfigManager().set(728, 31, true);
	player.getPacketDispatch().sendMessage("Congratulations! Quest complete!");
	player.getGameAttributes().removeAttribute("restless-ghost:urhney");
    }

    /**
     * Checks if the player has the amulet equipped.
     * @param player the player.
     * @return {@code True} if so.
     */
    public static boolean hasAmulet(Player player) {
	return player.getEquipment().contains(552, 1);
    }

    @Override
    public String getName() {
	return NAME;
    }

    @Override
    public int[] getConfig() {
	if (state == QuestState.COMPLETED) {
	    return new int[] { 107, 5 };
	} else if (state == QuestState.STARTED) {
	    return new int[] { 107, 4 };
	} else {
	    return new int[] { 107, 0 };
	}
    }

    @Override
    public int getIndex() {
	return 25;
    }

    @Override
    public int getQuestPoints() {
	return 1;
    }

}
