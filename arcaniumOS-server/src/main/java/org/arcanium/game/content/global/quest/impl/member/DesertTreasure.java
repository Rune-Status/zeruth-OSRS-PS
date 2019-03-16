package org.arcanium.game.content.global.quest.impl.member;

import org.arcanium.game.content.global.quest.Quest;
import org.arcanium.game.content.global.quest.QuestState;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.node.entity.player.Player;

/**
 * The main type for the desert treasure Quest.
 * @author Aero
 * @version 1.0
 */
public final class DesertTreasure extends Quest {

    // 3174 3033 bandit camp
    // 3213 2956 mirror
    // 3233 2885 pyramid
    // 3351 3336 digsite
    // 3570 3504 haunted woods

    /**
     * The name of this quest.
     */
    public static final String NAME = "Desert Treasure";

    /**
     * The amount of completed quests that are required.
     */
    private int completedQuests = 0;

    /**
     * The requirement titles.
     */
    private static final String[] TITLES = new String[] { "Level 10 Slayer", "Level 50 Firemaking", "Level 50 Magic", "Level 53 Thieving", "The Digsite Quest", "The Tourist Trap", "The Temple of Ikov", "Priest in Peril", "Waterfall Quest", "Troll Stronghold" };

    /**
     * The quest skill requirements.
     */
    private final boolean[] skillRequirements = new boolean[] { (player.getSkills().getStaticLevelByExperience(Skills.SLAYER) > 9), (player.getSkills().getStaticLevelByExperience(Skills.FIREMAKING) > 49), (player.getSkills().getStaticLevelByExperience(Skills.MAGIC) > 49), (player.getSkills().getStaticLevelByExperience(Skills.THIEVING) > 52) };

    /**
     * The quest requirements.
     */
    private boolean[] questRequirements = new boolean[6];

    /**
     * Constructs a new {@code DesertTreasure} {@code Object}.
     * @param player The player to construct the class for.
     */
    public DesertTreasure(final Player player) {
	super(player);
    }

    @Override
    public boolean isInDevelopment() {
	return true; // TODO: Remove this when finished making the quest!
    }

    @Override
    public void update() {
	clear();
	switch (stage) {
	case 0:
	    line(BLUE + "I can start this quest by speaking to " + RED + "The Archaeologist", 4);
	    line(BLUE + "who is exploring the " + RED + "Bedabin Camp " + BLUE + "South west of the", 5);
	    line(RED + "Shantay Pass.", 6);
	    drawQuestRequirements(player);
	    break;
	case 10:
	    line(BLUE + "I have to go see the " + RED + "Archaeological Expert" + BLUE + "", 4);
	    line(BLUE + "I have been given some " + RED + "Etchings" + BLUE + " to be translated.", 5);
	    line(BLUE + "Once I have the translation I should return to the " + RED + "Archaeologist.", 6);
	    break;
	case 20:
	    line(BLUE + "I have been given the " + RED + "Translation" + BLUE + " notes by the " + RED + "Archaeological Expert", 4);
	    line(BLUE + "I should probably take these back to " + RED + "Asgarnis", 5);
	    line(BLUE + "so he can inspect the findings.", 6);
	    break;
	case 21:
	    line(BLUE + "I have shown " + RED + "Asgarnis" + BLUE + " the translation.", 4);
	    line(BLUE + "I should return to him to see what he has to say.", 5);
	    break;
	case 22:
	    line(BLUE + "I have agreed to help find the treasure of the desert.", 4);
	    line(BLUE + "I should head " + RED + "South" + BLUE + " to the " + RED + "Bedabin Camp" + BLUE + " and investigate.", 5);
	    break;
	case 23:
	    line(BLUE + "After learning about the treasure of " + RED + "Azzandra", 4);
	    line(BLUE + "And the four " + RED + "Diamonds" + BLUE + " from" + RED + " Eblis", 5);
	    line(BLUE + "He has asked me to bring him the following items:", 6);
	    line(BLUE + "6x" + RED + " Molten Glass", 7);
	    line(BLUE + "6x" + RED + " Steel Bars", 8);
	    line(BLUE + "12x" + RED + " Magic Logs", 9);
	    line(BLUE + "10x" + RED + " Ashes", 10);
	    line(BLUE + "2x" + RED + " Normal Bones", 11);
	    line(BLUE + "2x" + RED + " Charcoal", 12);
	    line(BLUE + "1x" + RED + " Blood Rune", 13);
	    break;
	}
    }

    @Override
    public void finish() {
	finalize();
	drawReward("You have completed the " + NAME + " Quest!", 2);
	drawReward("3 Quest Points", 8);
	drawReward("20,000 Magic XP", 9);
	drawReward("Ancient Magicks", 10);
	drawReward("Two Treasure Hunter Keys", 11);
	player.getPacketDispatch().sendItemZoomOnInterface(12047, 230, 277, 3);
	player.getSkills().addExperience(Skills.MAGIC, 20000);
    }

    @Override
    public int[] getConfig() {
	return new int[] { 440, getState() == QuestState.STARTED ? 2 : getState() == QuestState.COMPLETED ? 15 : 0 };
    }

    @Override
    public int getIndex() {
	return 45;
    }

    @Override
    public String getName() {
	return NAME;
    }

    @Override
    public int getQuestPoints() {
	return 3;
    }

    @Override
    public boolean hasRequirements() {
	for (boolean bool : skillRequirements) {
	    if (!bool) {
		return false;
	    }
	}
	return (completedQuests == 6);
    }

    /**
     * Draws the quest requirements onto the journal component.
     * @param player The player to draw the requirements for.
     */
    private final void drawQuestRequirements(final Player player) {
	int line = 8;
	questRequirements[0] = player.getQuestRepository().isComplete(Digsite.NAME);
	questRequirements[1] = player.getQuestRepository().isComplete(TouristTrap.NAME);
	questRequirements[2] = player.getQuestRepository().isComplete(TempleOfIkov.NAME);
	questRequirements[3] = player.getQuestRepository().isComplete(PriestInPeril.NAME);
	questRequirements[4] = player.getQuestRepository().isComplete(TrollStronghold.NAME);
	questRequirements[5] = player.getQuestRepository().isComplete(WaterFall.NAME);
	line(BLUE + "To complete this quest I will need:", 7);
	for (int i = 0; i < skillRequirements.length; i++) {
	    boolean bool = !skillRequirements[i];
	    String str = TITLES[i];
	    line((bool ? RED + str : str), line++, !bool);
	}
	line = 13;
	for (int i = 0; i < questRequirements.length; i++) {
	    boolean bool = !questRequirements[i];
	    String str = TITLES[4 + i];
	    if (!bool) {
		completedQuests++;
	    }
	    line((bool ? RED + str : str), line++, !bool);
	}
	line(BLUE + (completedQuests == 6 ? "I have completed all of the required quests:" : "I must have completed the following quests:"), 12);
    }

}