package org.arcanium.game.content.global.quest.impl.free;

import org.arcanium.game.content.global.quest.Quest;
import org.arcanium.game.content.global.quest.QuestState;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;

/**
 * Represents the shield of arrav quest.
 * @author 'Vexia
 * @date 1/1/14
 */
public class ShieldofArrav extends Quest {

    /**
     * Constructs a new {@code ShieldofArrav} {@code Object}.
     * @param player The player to construct the class for.
     */
    public ShieldofArrav(final Player player) {
	super(player);
    }

    /**
     * Represents the shield of arrav book item.
     */
    public static final Item BOOK = new Item(757);

    /**
     * Represents the intel report item.
     */
    public static final Item INTEL_REPORT = new Item(761);

    /**
     * Represents the weapon store item key.
     */
    public static final Item KEY = new Item(759);

    /**
     * Represents the phoenix shield item.
     */
    public static final Item PHOENIX_SHIELD = new Item(763);

    /**
     * Represents the black arm shield item.
     */
    public static final Item BLACKARM_SHIELD = new Item(765);

    /**
     * Represents the blackarm certificate item.
     */
    public static final Item BLACKARM_CERTIFICATE = new Item(11174, 2);

    /**
     * Represents the phoenix certificate item.
     */
    public static final Item PHOENIX_CERTIFICATE = new Item(11173, 2);

    @Override
    public void update() {
	super.clear();
	switch (stage) {
	case 0:
	    player.getPacketDispatch().sendString(getBlue() + "I can start this quest by speaking to " + getRed() + "Reldo " + getBlue() + "in " + getRed() + "Varrock's", 275, 4);
	    player.getPacketDispatch().sendString(getRed() + "Palace Library" + getBlue() + ", or by speaking to " + getRed() + "Charlie the Tramp" + getBlue() + " near", 275, 5);
	    player.getPacketDispatch().sendString(getBlue() + "the " + getRed() + "Blue Moon Inn " + getBlue() + "in " + getRed() + "Varrock.", 275, 6);
	    player.getPacketDispatch().sendString(getBlue() + "I will need a friend to help me and some combat experience", 275, 7);
	    player.getPacketDispatch().sendString(getBlue() + "may be an advantage.", 275, 8);
	    break;
	case 10:
	    line(RED + "Reldo " + BLUE + "says there is a " + RED + "quest " + BLUE + "hidden in one of the books in", 4);
	    line(BLUE + "his " + RED + "library" + BLUE + " somewhere. I should look for it and see.", 5);
	    break;
	case 20:
	    line("<str>I read about a valuable shield stolen long ago by a gang of", 4);
	    line("<str>thieves with an outstanding reward upon it.", 5);
	    line(BLUE + "I should ask " + RED + "Reldo " + BLUE + "if he knows anything more about this.", 6);
	    break;
	case 30:
	    line("<str>I read about a valuable shield stolen long ago by a gang of", 4);
	    line("<str>thieves with an outstanding reward upon it.", 5);
	    line(BLUE + "Reldo told me that the fur trader in " + RED + "Varrock" + BLUE + ", named", 6);
	    line(RED + "Baraeck" + BLUE + ", knows about the " + RED + "Phoenix Gang." + BLUE + " I should speak to", 7);
	    line(BLUE + "him next.", 8);
	    break;
	case 40:
	    line("<str>I read about a valuable shield stolen long ago by a gang of", 4);
	    line("<str>thieves with an outstanding reward upon it.", 5);
	    line(BLUE + "Baraeck told me that the " + RED + "'Phoenix Gang' " + BLUE + "have a hideout in", 6);
	    line(BLUE + "the " + RED + "south-eastern part of Varrock" + BLUE + ", disgusing themselves", 7);
	    line(BLUE + "as the " + RED + "VTAM Corporation" + BLUE + ". I should find them and join.", 8);
	    break;
	case 50:
	    line("<str>I read about a valuable shield stolen long ago by a gang of", 4);
	    line("<str>thieves with an outstanding reward upon it.", 5);
	    line(BLUE + "Baraeck told me that the " + RED + "'Phoenix Gang' " + BLUE + "have a hideout in", 6);
	    line(BLUE + "the " + RED + "south-eastern part of Varrock" + BLUE + ", disgusing themselves", 7);
	    line(BLUE + "as the " + RED + "VTAM Corporation" + BLUE + ". I should find them and join.", 8);
	    line("<str>I also spoke to Charlie the tramp in Varrock.", 9);
	    line(BLUE + "According to him there is a criminal organisation known as", 10);
	    line(BLUE + "the " + RED + "'Black Army Gang' " + BLUE + "down an alley near to him. I should", 11);
	    line(BLUE + "speak to their " + RED + "leader, Katrine" + BLUE + ", about joining.", 12);
	    break;
	case 60:
	    line("<str>I read about a valuable shield stolen long ago by a gang of", 4);
	    line("<str>thieves with an outstanding reward upon it. Baraeck told me", 5);
	    line("<str>the location of the Phoenix Gang hideout.", 6);
	    line("<str>I also spoke to Charlie the tramp in Varrock.", 7);
	    line("<str>According to him there is a criminal organisation known as", 8);
	    line("<str>the " + RED + "'Black Arm Gang'" + BLUE + "down the alley near to him.", 9);
	    if (isPhoenixMission(player) && isBlackArmMission(player)) {
		line("<str>I read about a valuable shield stolen long ago by a gang of", 4);
		line("<str>thieves with an outstanding reward upon it. Baraeck told me", 5);
		line("<str>the location of the Phoenix Gang hideout.", 6);
		line("<str>To start this quest, I spoke to Charlie the tramp in Varrock.", 7);
		line("<str>He gave me the location of the Black Arm gang HQ.", 8);
		line("<str>According to him there is a criminal organisation known as", 9);
		line("<str>the " + RED + "'Black Arm Gang'" + BLUE + "down the alley near to him.", 10);
		line(BLUE + "If I want to join the " + RED + "Phoenix Gang " + BLUE + "I need to kill" + RED + " Jonny The", 11);
		line(RED + "Beard " + BLUE + "in the " + RED + "Blue Moon Inn " + BLUE + "and retreive his " + RED + "report.", 12);
		line(RED + "Katrine " + BLUE + "said if I wanted to join the " + RED + "Black Arm Gang," + BLUE + " I'd", 13);
		line(BLUE + "have to steal " + RED + "two Phoenix crossbows " + BLUE + "from the rival gang.", 14);
		line(BLUE + "Maybe " + RED + "Charlie the tramp " + BLUE + "can give me some ideas about", 15);
		line(BLUE + "how to do this.", 16);
	    } else if (isPhoenixMission(player)) {
		line(BLUE + "If I want to join the " + RED + "Phoenix Gang " + BLUE + "I need to kill" + RED + " Jonny The", 10);
		line(RED + "Beard " + BLUE + "in the " + RED + "Blue Moon Inn " + BLUE + "and retreive his " + RED + "report.", 11);
		line(BLUE + "Alternatively, if I want to join the " + RED + "Blackarm gang " + BLUE + "I should", 12);
		line(BLUE + "speak to their " + RED + "leader, Katrine, " + BLUE + "about joining.", 13);
	    } else if (isBlackArmMission(player)) {
		line(RED + "Katrine " + BLUE + "said if I wanted to join the " + RED + "Black Arm Gang" + BLUE + ", I'd", 10);
		line(BLUE + "have to steal " + RED + "two Phoenix crossbows " + BLUE + "from the rival gang.", 11);
		line(BLUE + "Maybe " + RED + "Charlie the tramp " + BLUE + "can give me some ideas about", 12);
		line(BLUE + "how to do this.", 13);
	    }
	    break;
	case 70:
	    if (isPhoenix(player)) {
		line("<str>I read about a valuable shield stolen long ago by a gang of", 4);
		line("<str>thieves with an outstanding reward upon it. Baraeck told me", 5);
		line("<str>the location of the Phoenix Gang hideout.", 6);
		line("<str>I killed Jonny the Beard and was welcomed into the Phoenix", 7);
		line("<str>Gang. Straven gave me a key to the weapons room.", 8);
		if (!player.getInventory().containsItem(PHOENIX_SHIELD) && !player.getBank().containsItem(PHOENIX_SHIELD)) {
		    line(BLUE + "I need to search the " + RED + "Phoenix Gang's hideout " + BLUE + "to find half", 10);
		    line(BLUE + "of the " + RED + "Shield of Arrav.", 11);
		} else {
		    line(BLUE + "I found half of the " + RED + "Shield of Arrav " + BLUE + "in the " + RED + "Phoenix Gang's", 10);
		    line(RED + "hideout.", 11);
		}
		line(BLUE + "The second half of the " + RED + "shield" + BLUE + " belongs to a rival gang", 12);
		line(BLUE + "known as the " + RED + "Black Arm Gang. " + BLUE + "I will need " + RED + "a friend's help " + BLUE + "to", 13);
		line(BLUE + "retreive it before claiming the " + RED + "reward " + BLUE + "for it.", 14);
	    } else {
		line("<str>I read about a valuable shield stolen long ago by a gang of", 4);
		line("<str>thieves with an outstanding reward upon it. Baraeck told me", 5);
		line("<str>the location of the Phoenix Gang hideout.", 6);
		line("<str>With the help of a friend, I managed to obtain two Phoenix", 8);
		line("<str>Crossbows from the Phoenix Gang's weapons store, and", 9);
		line("<str>Katrine welcomes me as a Black Arm Gang member.", 10);
		line(BLUE + "With " + RED + "my friend's help" + BLUE + ", I can get both pieces of the shield", 12);
		line(BLUE + "and return it to " + RED + "King Roald " + BLUE + "for my " + RED + "reward.", 13);
	    }
	    break;
	case 100:
	    line("<str>I read about a valuable shield stolen long ago by a gang of", 4);
	    line("<str>thieves with an outstanding reward upon it. Baraeck told me", 5);
	    line("<str>the location of the Phoenix Gang hideout.", 6);
	    if (!isPhoenix(player)) {
		line("<str>With the help of a friend, I managed to obtain two Phoenix", 8);
		line("<str>Crossbows from the Phoenix Gang's weapons store, and", 9);
		line("<str>Katrine welcomes me as a Black Arm Gang member.", 10);
		line("<str>With the help of my friend in the rival gang, I was able to", 12);
		line("<str>retreive both parts of the fabled Shield of Arrav and", 13);
		line("<str>return it to the Museum of Varrock. In Recognition of my", 14);
		line("<str>efforts, King Roald paid me the reward set by his", 15);
		line("<str>ancestor.", 16);
		line("<col=FF00000>QUEST COMPLETE!", 18);
		line(RED + "I received a reward of 600 coins and got 1 quest point.", 19);
	    } else {
		line("<str>I killed Jonny the Beard and was welcomed into the Phoenix", 7);
		line("<str>Gang. Straven gave me a key to the weapons room.", 8);
		line("<str>With the help of my friend in the rival gang, I was able to", 10);
		line("<str>retreive both parts of the fabled Shield of Arrav and", 11);
		line("<str>return it to the Museum of Varrock. In Recognition of my", 12);
		line("<str>efforts, King Roald paid me the reward set by his", 13);
		line("<str>ancestor.", 14);
		line("<col=FF00000>QUEST COMPLETE!", 16);
		line(RED + "I received a reward of 600 coins and got 1 quest point.", 17);
	    }
	    break;
	}
    }

    @Override
    public void finish() {
	super.finalize();
	setState(QuestState.COMPLETED);
	setStage(100);
	player.removeAttribute("blackarm-mission");
	player.removeAttribute("phoenix-mission");
	player.getPacketDispatch().sendString("1 Quests Points", 277, 8);
	player.getPacketDispatch().sendString("600 Coins", 277, 9);
	player.getPacketDispatch().sendString("You have completed the Shield of Arrav Quest", 277, 2);
	player.getPacketDispatch().sendItemZoomOnInterface(767, 1, 230, 277, 3);
    }

    @Override
    public int[] getConfig() {
	int id = 145;
	if (state == QuestState.COMPLETED) {
	    return new int[] { id, 7 };
	} else if (state == QuestState.STARTED) {
	    return new int[] { id, 1 };
	} else {
	    return new int[] { id, 0 };
	}
    }

    @Override
    public int getIndex() {
	return 29;
    }

    @Override
    public String getName() {
	return "Shield of Arrav";
    }

    @Override
    public int getQuestPoints() {
	return 1;
    }

    /**
     * Sets the phoenix gang.
     * @param player the player.
     */
    public static void setPhoenix(final Player player) {
	player.setAttribute("/save:phoenix-gang", true);
    }

    /**
     * Sets the black arm gang.
     * @param player the player.
     */
    public static void setBlackArm(final Player player) {
	player.setAttribute("/save:black-arm-gang", true);
    }

    /**
     * Method used to check if the player is part of the phoenix gang.
     * @param player the player.
     * @return <code>True</code> if so.
     */
    public static boolean isPhoenix(final Player player) {
	return player.getAttribute("phoenix-gang", false);
    }

    /**
     * Method used to check if the player is part of the black arm gang.
     * @param player the player.
     * @return <code>True</code> if so.
     */
    public static boolean isBlackArm(final Player player) {
	return player.getAttribute("black-arm-gang", false);
    }

    /**
     * Method used to set that the player is trying to do the phoennix mission.
     * @param player the player.
     */
    public static void setPhoenixMission(final Player player) {
	player.setAttribute("/save:phoenix-mission", true);
    }

    /**
     * Method used to set that the player is trying to do the black arm gang
     * mission.
     * @param player the player.
     */
    public static void setBlackArmMission(final Player player) {
	player.setAttribute("/save:blackarm-mission", true);
    }

    /**
     * Method used to check if they're doing the black arm gang mission.
     * @param player the player.
     * @return <code>True</code> if so.
     */
    public static boolean isBlackArmMission(final Player player) {
	return player.getAttribute("blackarm-mission", false);
    }

    /**
     * Method used to check if they're doing the phoenix gang mission.
     * @param player the player.
     * @return <code>True</code> if so.
     */
    public static boolean isPhoenixMission(final Player player) {
	return player.getAttribute("phoenix-mission", false);
    }

    /**
     * Gets the shield item.
     * @param player the player.
     * @return
     */
    public static final Item getShield(final Player player) {
	return isBlackArm(player) ? BLACKARM_SHIELD : PHOENIX_SHIELD;
    }
}
