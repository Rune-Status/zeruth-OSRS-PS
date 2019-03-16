package org.arcanium.game.content.global.quest.impl.free;

import org.arcanium.game.component.Component;
import org.arcanium.game.content.global.quest.Quest;
import org.arcanium.game.content.global.quest.QuestState;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.node.entity.player.Player;

/**
 * Represents the cooks assistants ques
 * @author 'Vexia
 */
public final class CooksAssistant extends Quest {

    /**
     * Constructs a new {@code CooksAssistant} {@code Object}.
     * @param player the player.
     */
    public CooksAssistant(final Player player) {
	super(player);
    }

    @Override
    public void update() {
	for (int i = 0; i < 256; i++) {
	    player.getPacketDispatch().sendString("", 275, i);
	}
	player.getPacketDispatch().sendString("<col=8A0808>Cook's Assistant</col>", 275, 2);
	player.getPacketDispatch().sendString("<col=08088A>I can start this quest by speaking to the <col=8A0808>Cook</col> <col=08088A>in the", 275, 4);
	player.getPacketDispatch().sendString("<col=8A0808>Kitchen</col> <col=08088A>on the ground for of <col=8A0808>Lumbridge Castle.<col=8A0808>", 275, 5);
	if (stage == 10) {
	    player.getPacketDispatch().sendString("<col=08088A>It's the <col=8A0808>Duke of Lumbridge's</col> <col=08088A>birthday and I have to help", 275, 4);
	    player.getPacketDispatch().sendString("<col=08088A>his</col> <col=8A0808>Cook</col> <col=08088A>make him a <col=8A0808>birthday cake.</col><col=08088A> To do this I need to", 275, 5);
	    player.getPacketDispatch().sendString("<col=08088A>bring him the following ingredients:", 275, 6);
	    if (player.getInventory().contains(1927, 1)) {
		player.getPacketDispatch().sendString("<col=08088A>I have found a <col=8A0808>bucket of milk</col><col=08088A> to give to the cook.", 275, 7);
	    } else {
		player.getPacketDispatch().sendString("<col=08088A>I need to find a <col=8A0808>bucket of milk</col><col=08088A>.", 275, 7);
	    }
	    if (player.getInventory().contains(1933, 1)) {
		player.getPacketDispatch().sendString("<col=08088A>I have found a <col=8A0808>pot of flour</col><col=08088A> to give to the cook.", 275, 8);
	    } else {
		player.getPacketDispatch().sendString("<col=08088A>I need to find a <col=8A0808>pot of flour</col><col=08088A>.", 275, 8);
	    }
	    if (player.getInventory().contains(1944, 1)) {
		player.getPacketDispatch().sendString("<col=08088A>I have found an <col=8A0808>egg</col><col=08088A> to give to the cook.", 275, 9);
	    } else {
		player.getPacketDispatch().sendString("<col=08088A>I need to find <col=8A0808>an egg</col><col=08088A>.", 275, 9);
	    }
	    if (player.getSavedData().getQuestData().getCookAssist("milk")) {
		player.getPacketDispatch().sendString("<str>I have given the cook a bucket of milk.</str>", 275, 7);
	    }
	    if (player.getSavedData().getQuestData().getCookAssist("flour")) {
		player.getPacketDispatch().sendString("<str>I have given the cook a pot of flour.</str>", 275, 8);
	    }
	    if (player.getSavedData().getQuestData().getCookAssist("egg")) {
		player.getPacketDispatch().sendString("<str>I have given the cook an egg.</str>", 275, 9);// I
													  // need
													  // to
													  // find
													  // a
													  // pot
													  // of
													  // flour
	    }

	}
	if (stage == 100) {
	    player.getPacketDispatch().sendString("<str>It was the Duke of Lumbridge's birthday,  but his cook had", 275, 4);
	    player.getPacketDispatch().sendString("<str>forgotten to buy the ingredients he needed to make him a", 275, 5);
	    player.getPacketDispatch().sendString("<str>cake. I brought the cook an egg, some flour and some milk", 275, 6);
	    player.getPacketDispatch().sendString("<str>and then cook made a delicious looking cake with them.", 275, 7);
	    player.getPacketDispatch().sendString("<str>As a reward he now lets me use his high quality range", 275, 9);
	    player.getPacketDispatch().sendString("<str>which lets me burn things less whenever I wish to cook", 275, 10);
	    player.getPacketDispatch().sendString("<str>there.", 275, 11);
	    player.getPacketDispatch().sendString("<col=FF0000>QUEST COMPLETE!", 275, 13);
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
	player.getPacketDispatch().sendString("300 Cooking XP", 277, 9);
	player.getSkills().addExperience(Skills.COOKING, 300);
	player.getInterfaceManager().closeChatbox();
	player.getPacketDispatch().sendString("You have completed the Cook's Assistant Quest!", 277, 2);
	player.getPacketDispatch().sendItemZoomOnInterface(1891, 240, 277, 3);
	setStage(100);
	setState(QuestState.COMPLETED);
	player.getPacketDispatch().sendMessage("Congratulations! Quest complete!");
    }

    @Override
    public int getQuestPoints() {
	return 1;
    }

    @Override
    public int[] getConfig() {
	if (state == QuestState.COMPLETED) {
	    return new int[] { 29, 2 };
	} else if (state == QuestState.STARTED) {
	    return new int[] { 29, 1 };
	} else {
	    return new int[] { 29, 0 };
	}
    }

    @Override
    public String getName() {
	return "Cook's Assistant";
    }

    @Override
    public int getIndex() {
	return 15;
    }

}
