package org.arcanium.game.content.global.quest.impl.member;

import org.arcanium.game.content.global.quest.Quest;
import org.arcanium.game.content.global.quest.QuestState;
import org.arcanium.game.node.entity.player.Player;

/**
 * The main type for the temple of ikov quest.
 * @author Aero
 */
public final class TempleOfIkov extends Quest {

    /**
     * The name of the quest.
     */
    public static final String NAME = "Temple of Ikov";

    /**
     * Constructs a new {@code TempleOfIkov} {@code Object}.
     * @param player The player to construct the class for.
     */
    public TempleOfIkov(final Player player) {
	super(player);
    }

    @Override
    public boolean isInDevelopment() {
	return true; // Remove this when finished making the quest!
    }

    @Override
    public void update() {
	super.clear();
    }

    @Override
    public void finish() {
	super.finalize();
    }

    @Override
    public int[] getConfig() {
	return new int[] { 26, getState() == QuestState.COMPLETED ? 80 : getState() == QuestState.NOT_STARTED ? 0 : 1 };
    }

    @Override
    public int getIndex() {
	return 121;
    }

    @Override
    public String getName() {
	return NAME;
    }

    @Override
    public int getQuestPoints() {
	return 1;
    }

}