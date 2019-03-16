package org.arcanium.game.content.global.quest.impl.free;

import org.arcanium.game.content.global.quest.Quest;
import org.arcanium.game.content.global.quest.QuestState;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;

/**
 * Represents the black knights fortress quest.
 * @author 'Vexia
 * @date 28/12/2013
 */
public final class BlackKnightsFortress extends Quest {

    /**
     * Constructs a new {@code BlackKnightsFortress} {@code Object}.
     */
    public BlackKnightsFortress(final Player player) {
	super(player);
    }

    /**
     * Represents the dossier item.
     */
    public static final Item DOSSIER = new Item(9589);

    @Override
    public void update() {
	super.clear();
	switch (stage) {
	case 0:
	    player.getPacketDispatch().sendString("<col=08088A>I can start this quest by speaking to the <col=8A0808>Sir Amik Varze</col> <col=08088A>at the", 275, 4);
	    player.getPacketDispatch().sendString(getRed() + " White Knight's Castle " + getBlue() + "in " + getRed() + "Falador.", 275, 5);
	    if (player.getQuestRepository().getPoints() < 12) {
		player.getPacketDispatch().sendString(getRed() + "I must have a total of at least 12 Quest Points", 275, 6);
	    } else {
		line("<str>I have a total of at least 12 Quest Points", 6);
	    }
	    player.getPacketDispatch().sendString(getBlue() + "I would have an advantage if I could fight " + getRed() + "Level 33 Knights", 275, 7);
	    player.getPacketDispatch().sendString(getBlue() + "and if I had a smithing level of " + getRed() + "26.", 275, 8);
	    break;
	case 10:
	    line(RED + "Sir Amik Varze " + BLUE + "has asked me to investigate the " + RED + "Black", 4);
	    line(RED + "Knights' Fortress " + BLUE + "which is located on " + RED + "Ice Mountain.", 5);
	    line(BLUE + "I need to disguise myself to gain entry to the " + RED + "Black", 6);
	    line(RED + "Knights' Fortress.", 7);
	    break;
	case 20:
	    line("<str>Sir Amik Varze asked me to investigate the Black Knights'", 4);
	    line("<str>Fortress. I sneaked inside disguised as a Guard.", 5);
	    line(BLUE + "I eavesdropped on a Witch and the Black Knight Captain", 6);
	    line(BLUE + "and discovered that their invincibility potion can be", 7);
	    line(BLUE + "destroyed with a normal " + RED + "cabbage.", 8);
	    break;
	case 30:
	    line("<str>Sir Amik Varze asked me to investigate the Black Knights'", 4);
	    line("<str>Fortress. I sneaked inside disguised as a Guard.", 5);
	    line("<str>I eavesdropped on a Witch and the Black Knight Captain", 6);
	    line("<str>and discovered that their invincibility potion could be", 7);
	    line("<str>destroyed with a normal cabbage.", 8);
	    line(BLUE + "Now that I have sabotaged the witch's potion, I can claim", 9);
	    line(BLUE + "my " + RED + "reward " + BLUE + "from " + RED + "Sir Amik Varze " + BLUE + "in " + RED + "Falador Castle.", 10);
	    break;
	case 100:
	    line("<str>Sir Amik Varze asked me to investigate the Black Knights'", 4);
	    line("<str>Fortress. I sneaked inside disguised as a Guard.", 5);
	    line("<str>I eavesdropped on a Witch and the Black Knight Captain", 6);
	    line("<str>and discovered that their invincibility potion could be", 7);
	    line("<str>destroyed with a normal cabbage.", 8);
	    line("<str>I found a cabbage, and used it to a destroy the potion, then", 9);
	    line("<str>claimed my reward for a job well done.", 10);
	    line("<col=FF0000>QUEST COMPLETE!</col>", 12);
	    line(RED + "Reward:", 13);
	    line(BLUE + "3 Quest Points", 14);
	    line(BLUE + "2500gp", 15);
	    break;
	}
    }

    @Override
    public void finish() {
	super.finalize();
	player.getPacketDispatch().sendString("3 Quests Points", 277, 8);
	player.getPacketDispatch().sendString("2500 Coins", 277, 9);
	player.getPacketDispatch().sendString("You have completed Black Knights' Fortress Quest!", 277, 2);
	player.getPacketDispatch().sendItemZoomOnInterface(9591, 230, 277, 3);
    }

    @Override
    public int[] getConfig() {
	if (state == QuestState.COMPLETED) {
	    return new int[] { 130, 4 };
	} else if (state == QuestState.STARTED) {
	    return new int[] { 130, 1 };
	} else {
	    return new int[] { 130, 0 };
	}
    }

    @Override
    public int getIndex() {
	return 14;
    }

    @Override
    public String getName() {
	return "Black Knights' Fortress";
    }

    @Override
    public int getQuestPoints() {
	return 3;
    }
}
