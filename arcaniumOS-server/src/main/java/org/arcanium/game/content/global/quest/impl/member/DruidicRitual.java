package org.arcanium.game.content.global.quest.impl.member;

import org.arcanium.game.component.CloseEvent;
import org.arcanium.game.component.Component;
import org.arcanium.game.content.global.quest.Quest;
import org.arcanium.game.content.global.quest.QuestState;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;

/**
 * The main type for the druidic ritual quest.
 * @author 'Vexia
 * @since 05/22/13
 */
public class DruidicRitual extends Quest {

    /**
     * The name of the quest.
     */
    public static String NAME = "Drudic Ritual";

    /**
     * Constructs a new {@code DruidicRitual} {@code Object}.
     * @param player The player to construct the class for.
     */
    public DruidicRitual(final Player player) {
	super(player);
    }

    @Override
    public void update() {
	super.clear();
	player.getPacketDispatch().sendString("<col=8A0808>Druidic Ritual</col>", 275, 2);
	player.getPacketDispatch().sendString("<col=08088A>I can start this quest by speaking to the <col=8A0808>Kaqemeex</col> <col=08088A>who is at", 275, 4);
	player.getPacketDispatch().sendString("<col=08088A>the </col><col=8A0808>Druids Circle</col> <col=08088A>just <col=8A0808>North</col> <col=08088A>of</col> <col=8A0808>Taverley.<col=8A0808>", 275, 5);
	if (stage == 10) {
	    player.getPacketDispatch().sendString("<str>I told Kaqemeex I would help them prepare their ceremony.</str>", 275, 4);
	    player.getPacketDispatch().sendString("<col=08088A>I should speak to <col=8A0808>Sanfew</col> <col=08088A>in the village to the <col=8A0808>South</col>", 275, 5);
	}
	if (stage == 20) {
	    player.getPacketDispatch().sendString("", 275, 5);
	    player.getPacketDispatch().sendString("<str>I told Kaqemeex I would help them prepare their ceremony.</str>", 275, 4);
	    player.getPacketDispatch().sendString("<col=8A0808>Sanfew</col> <col=08088A>told me for the ritual they would need me to place", 275, 6);
	    player.getPacketDispatch().sendString("<col=8A0808>raw bear meat, raw chicken, raw rat meat, <col=08088A>and <col=8A0808>raw beef <col=08088A>in", 275, 7);
	    player.getPacketDispatch().sendString("<col=08088A>the <col=8A0808>Cauldron of Thunder in the <col=08088A>dungeon South of <col=8A0808>Taverley", 275, 8);
	}
	if (stage == 99) {
	    player.getPacketDispatch().sendString("<str>I told Kaqemeex I would help them prepare their ceremony.</str>", 275, 4);
	    player.getPacketDispatch().sendString("<str>The cremeony required various meats being placed in the.</str>", 275, 5);
	    player.getPacketDispatch().sendString("<str>Cauldron of Thunder. I did this and gave them to Sanfew.</str>", 275, 6);
	    player.getPacketDispatch().sendString("<col=08088A>I should speak to <col=8A0808>Kaqemeex <col=08088A>again and claim my <col=8A0808>reward", 275, 7);
	}
	if (stage == 100) {
	    player.getPacketDispatch().sendString("<str>I told Kaqemeex I would help them prepare their ceremony.</str>", 275, 4);
	    player.getPacketDispatch().sendString("<str>The cremeony required various meats being placed in the.</str>", 275, 5);
	    player.getPacketDispatch().sendString("<str>Cauldron of Thunder. I did this and gave them to Sanfew.</str>", 275, 6);
	    player.getPacketDispatch().sendString("<str>Kaqemeex then taught me the basics of the skill Herblore</str>", 275, 7);
	    player.getPacketDispatch().sendString("<col=FF0000>QUEST COMPLETE!", 275, 11);
	}
    }

    @Override
    public void finish() {
	player.getQuestRepository().update(player);
	player.getQuestRepository().incrementPoints(getQuestPoints());
	player.getConfigManager().sendVarp(101, player.getQuestRepository().getPoints());
	player.getInterfaceManager().open(new Component(277).setCloseEvent(new CloseEvent() {
	    @Override
	    public boolean close(Player player, Component c) {
		if (player != null) {
		    player.getDialogueInterpreter().open(455, NPC.create(455, player.getLocation()), true);
		}
		return true;
	    }
	}));
	for (int i = 8; i < 15; i++) {
	    player.getPacketDispatch().sendString("", 277, i);
	}
	player.getPacketDispatch().sendString("4 Quest Points", 277, 8);
	player.getPacketDispatch().sendString("250 Herblore XP", 277, 9);
	player.getPacketDispatch().sendString("Access to Herblore skill", 277, 10);
	player.getPacketDispatch().sendItemZoomOnInterface(249, 240, 277, 3);
	player.getSkills().addExperience(Skills.HERBLORE, 250);
	player.getInterfaceManager().closeChatbox();
	player.getPacketDispatch().sendString("You have completed the Druidic Ritual Quest!", 277, 2);
	setStage(100);
	setState(QuestState.COMPLETED);
	player.getPacketDispatch().sendMessage("Congratulations! Quest complete!");

    }

    @Override
    public String getName() {
	return NAME;
    }

    @Override
    public int[] getConfig() {
	if (state == QuestState.COMPLETED) {
	    return new int[] { 80, 4 };
	} else if (state == QuestState.STARTED) {
	    return new int[] { 80, 3 };
	} else {
	    return new int[] { 80, 0 };
	}
    }

    @Override
    public int getIndex() {
	return 48;
    }

    @Override
    public int getQuestPoints() {
	return 4;
    }
}
