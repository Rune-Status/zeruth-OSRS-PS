package org.arcanium.game.content.global.quest.impl.free;

import org.arcanium.game.component.Component;
import org.arcanium.game.content.global.quest.Quest;
import org.arcanium.game.content.global.quest.QuestState;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.content.skill.p2p.agility.AgilityHandler;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.system.task.Pulse;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.game.world.update.flag.context.Animation;

/**
 * Represents the dragon slayer quest.
 * @author 'Vexia
 */
public final class DragonSlayer extends Quest {

    /**
     * Represents the maze key given by the guildmaster.
     */
    public static final Item MAZE_KEY = new Item(1542);

    /**
     * Represents the red key item.
     */
    public static final Item RED_KEY = new Item(1543);

    /**
     * Represents the orange key item.
     */
    public static final Item ORANGE_KEY = new Item(1544);

    /**
     * Represents the yellow key item.
     */
    public static final Item YELLOW_KEY = new Item(1545);

    /**
     * Represents the blue key item.
     */
    public static final Item BLUE_KEY = new Item(1546);

    /**
     * Represents the purple key item.
     */
    public static final Item PURPLE_KEY = new Item(1547);

    /**
     * Represents the green key item.
     */
    public static final Item GREEN_KEY = new Item(1548);

    /**
     * Represents the maze map piece.
     */
    public static final Item MAZE_PIECE = new Item(1535);

    /**
     * Represents the magic door map piece.
     */
    public static final Item MAGIC_PIECE = new Item(1537);

    /**
     * Represents the wormbrain piece.
     */
    public static final Item WORMBRAIN_PIECE = new Item(1536);

    /**
     * Represents the anti dragon fire shield.
     */
    public static final Item SHIELD = new Item(1540);

    /**
     * Represents the crandor map item.
     */
    public static final Item CRANDOR_MAP = new Item(1538);

    /**
     * Represents the map component interface.
     */
    public static final Component MAP_COMPONENT = new Component(547);

    /**
     * Represents the nails item.
     */
    public static final Item NAILS = new Item(1539, 30);

    /**
     * Represents the plank item.
     */
    public static final Item PLANK = new Item(960);

    /**
     * Represents the hammer item.
     */
    public static final Item HAMMER = new Item(2347);

    /**
     * Represents the elvarg head item.
     */
    public static final Item ELVARG_HEAD = new Item(11279);

    /**
     * Constructs a new {@code DragonSlayer} {@code Object}.
     * @param player the player.
     */
    public DragonSlayer(Player player) {
	super(player);
    }

    @Override
    public void update() {
	super.clear();
	switch (getStage()) {
	case 0:
	    player.getPacketDispatch().sendString(getBlue() + "I can start this quest by speaking to the " + getRed() + "Guildmaster " + getBlue() + "in", 275, 4);
	    player.getPacketDispatch().sendString(getBlue() + "the " + getRed() + "Champions' Guild" + getBlue() + " ,south-west of Varrock.", 275, 5);
	    player.getPacketDispatch().sendString(getBlue() + "I will need to be able to defeat a " + getRed() + "level 83 dragon.", 275, 6);
	    if (player.getQuestRepository().getPoints() < 32) {
		player.getPacketDispatch().sendString(getBlue() + "To enter the Champions' Guild I need" + getRed() + " 32 Quest Points.", 275, 7);
	    } else {
		player.getPacketDispatch().sendString("<str>To enter the Champions' Guild I need 32 Quest Points.", 275, 7);
	    }
	    break;
	case 10:
	    line("<str>The Guildmaster of the Champions' Guild said I could earn", 4);
	    line("<str>the right to wear rune armour if I went on a quest for", 5);
	    line("<str>Oziach, who makes the armour.", 6);
	    line(BLUE + "I should speak to " + RED + "Oziach" + BLUE + ", who lives by the cliffs to the", 7);
	    line(BLUE + "west of " + RED + "Edgeville.", 8);
	    break;
	case 15:
	    line("<str>The Guildmaster of the Champions' Guild said I could earn", 4);
	    line("<str>the right to wear rune armour if I went on a quest for", 5);
	    line("<str>Oziach, who makes the armour.", 6);
	    line("<str>I spoke to Oziach in Edgeville. He told me to slay the", 7);
	    line("<str>dragon of Crandor island.", 8);
	    line(BLUE + "I should return to the " + RED + "Champions' Guild Guildmaster " + BLUE + "for", 9);
	    line(BLUE + "more detailed instructions.", 10);
	    break;
	case 20:
	    line("<str>The Guildmaster of the Champions' Guild said I could earn", 4);
	    line("<str>the right to wear rune armour if I went on a quest for", 5);
	    line("<str>Oziach, who makes the armour.", 6);
	    line("<str>I spoke to Oziach in Edgeville. He told me to slay the", 7);
	    line("<str>dragon of Crandor island.", 8);
	    line("<str>The Champions' Guild Guildmaster gave me more detailed", 9);
	    line("<str>instructions.", 10);
	    line(BLUE + "To defeat the dragon I will need to find a " + RED + "map " + BLUE + "to Crandor, a", 11);
	    line(RED + "ship" + BLUE + ", a " + RED + "captain " + BLUE + "to take me there and some kind of", 12);
	    line(RED + "protection " + BLUE + "against the dragon's breath.", 13);
	    if (!player.getInventory().containsItem(MAZE_PIECE) && !player.getBank().containsItem(MAZE_PIECE)) {
		line(BLUE + "One-third of the map is in " + RED + "Melzar's Maze" + BLUE + ", near", 14);
		line(RED + "Rimmington" + ".", 15);
	    } else {
		line("<str>I found the piece of the map that was hidden in Melzar's", 14);
		line("<str>Maze.", 15);
	    }
	    if (!player.getInventory().containsItem(MAGIC_PIECE) && !player.getBank().containsItem(MAGIC_PIECE)) {
		line(BLUE + "One-third of the map is hidden, and only the " + RED + "Oracle " + BLUE + "on " + RED + "Ice", 16);
		line(RED + "Mountain" + BLUE + " will know where it is.", 17);
	    } else {
		line("<str>I found the piece of the map that was hidden beneath Ice", 16);
		line("<str>Mountain.", 18);
	    }
	    if (!player.getInventory().containsItem(WORMBRAIN_PIECE) && !player.getBank().containsItem(WORMBRAIN_PIECE)) {
		line(BLUE + "One-third of the map was stolen by a " + RED + "goblin " + BLUE + "from the", 18);
		line(RED + "Goblin Village.", 19);
	    } else {
		line("<str>I found the piece of the map that the goblin, Wormbrain,", 18);
		line("<str>stole.", 19);
	    }
	    if (!player.getInventory().containsItem(SHIELD) && !player.getBank().containsItem(SHIELD)) {
		line(BLUE + "I should ask the " + RED + "Duke of Lumbridge " + BLUE + "for an " + RED + "anti-", 20);
		line(RED + "dragonbreath shield.", 21);
	    } else {
		line("<str>The Duke of Lumbridge gave me an anti-dragonbreath", 20);
		line("<str>shield.", 21);

	    }
	    if (!player.getSavedData().getQuestData().getDragonSlayerAttribute("ship")) {
		line(BLUE + "I should see if there is a " + RED + "ship " + BLUE + "for sale in " + RED + "Port Sarim", 22);
	    } else {
		line("<str>I bought a ship in Port Sarim called the Lady Lumbridge.", 22);
		if (!player.getSavedData().getQuestData().getDragonSlayerAttribute("repaired")) {
		    line("<str>I need to repair the hole in bottom of the ship.", 23);
		} else {
		    line("<str>I have repared my ship using wooden planks and steel", 23);
		    line("<str>nails.", 24);
		}
	    }
	    break;
	case 30:
	    line("<str>The Guildmaster of the Champions' Guild said I could earn", 4);
	    line("<str>the right to wear rune armour if I went on a quest for", 5);
	    line("<str>Oziach, who makes the armour.", 6);
	    line("<str>I spoke to Oziach in Edgeville. He told me to slay the", 7);
	    line("<str>dragon of Crandor island.", 8);
	    line("<str>The Champions' Guilg Guildmaster told me I had to find", 9);
	    line("<str>three pieces of a map to Crandor, a ship, a captain to take", 10);
	    line("<str>me there and a shield to protect me from the dragon's", 11);
	    line("<str>breath.", 12);
	    line("<str>I found the piece of the map that was hidden in Melzar's", 13);
	    line("<str>Maze.", 14);
	    line("<str>I found the piece of the map that was hidden beneath Ice", 15);
	    line("<str>Mountain.", 16);
	    line("<str>I found the piece of the map that the goblin, Wormbrain,", 17);
	    line("<str>stole.", 18);
	    line("<str>The Duke of Lumbridge gave me an anti-dragonbreath", 19);
	    line("<str>shield.", 20);
	    line("<str>I bought a ship in Port Sarim called the Lady Lumbridge", 21);
	    line("<str>I have repaired my ship using wooden planks and steel", 22);
	    line("<str>nails.", 23);
	    line("<str>Captain Ned from Draynor Village has agreed to sail the", 24);
	    line("<str>ship to Crandor for me.", 25);
	    line(BLUE + "Now I should go to my ship in " + RED + "Port Sarim " + BLUE + "and set sail for", 26);
	    line(RED + "Crandor" + BLUE + "!", 27);
	    break;
	case 40:
	    line("<str>The Guildmaster of the Champions' Guild said I could earn", 4);
	    line("<str>the right to wear rune armour if I went on a quest for", 5);
	    line("<str>Oziach, who makes the armour.", 6);
	    line("<str>I spoke to Oziach in Edgeville. He told me to slay the", 7);
	    line("<str>dragon of Crandor island.", 8);
	    line("<str>The Champions' Guilg Guildmaster told me I had to find", 9);
	    line("<str>three pieces of a map to Crandor, a ship, a captain to take", 10);
	    line("<str>me there and a shield to protect me from the dragon's", 11);
	    line("<str>breath.", 12);
	    line("<str>I found the piece of the map that was hidden in Melzar's", 13);
	    line("<str>Maze.", 14);
	    line("<str>I found the piece of the map that was hidden beneath Ice", 15);
	    line("<str>Mountain.", 16);
	    line("<str>I found the piece of the map that the goblin, Wormbrain,", 17);
	    line("<str>stole.", 18);
	    line("<str>The Duke of Lumbridge gave me an anti-dragonbreath", 19);
	    line("<str>shield.", 20);
	    if (!player.getAttribute("demon-slayer:memorize", false)) {
		if (!player.getInventory().containsItem(ELVARG_HEAD)) {
		    line(BLUE + "Now all I need to do is kill the " + RED + "dragon" + BLUE + "!", 21);
		} else {
		    line(BLUE + "I have slain the dragon! Now I just need to tell " + RED + "Oziach.", 21);
		}
	    } else {
		line("<str>I have found a secret passage leading from Karamaja to", 21);
		line("<str>Crandor, so I no longer need to worry about finding a", 22);
		line("<str>seaworthy ship and captain to take me there.", 23);
		if (!player.getInventory().containsItem(ELVARG_HEAD)) {
		    line(BLUE + "Now all I need to do is kill the " + RED + "dragon" + BLUE + "!", 24);
		} else {
		    line(BLUE + "I have slain the dragon! Now I just need to tell " + RED + "Oziach.", 24);
		}
	    }
	    break;
	case 100:
	    line("<str>The Guildmaster of the Champions' Guild said I could earn", 4);
	    line("<str>the right to wear rune armour if I went on a quest for", 5);
	    line("<str>Oziach, who makes the armour.", 6);
	    line("<str>I spoke to Oziach in Edgeville. He told me to slay the", 7);
	    line("<str>dragon of Crandor island.", 8);
	    line("<str>The Champions' Guilg Guildmaster told me I had to find", 9);
	    line("<str>three pieces of a map to Crandor, a ship, a captain to take", 10);
	    line("<str>me there and a shield to protect me from the dragon's", 11);
	    line("<str>breath.", 12);
	    line("<str>I found the piece of the map that was hidden in Melzar's", 13);
	    line("<str>Maze.", 14);
	    line("<str>I found the piece of the map that was hidden beneath Ice", 15);
	    line("<str>Mountain.", 16);
	    line("<str>I found the piece of the map that the goblin, Wormbrain,", 17);
	    line("<str>stole.", 18);
	    line("<str>The Duke of Lumbridge gave me an anti-dragonbreath", 19);
	    line("<str>shield.", 20);
	    line("<str>I have found a secret passage leading from Karamaja to", 21);
	    line("<str>Crandor, so I no longer need to worry about finding a", 22);
	    line("<str>seaworthy ship and captain to take me there.", 23);
	    line("<str>I sailed to Crandor and killed the dragon. I am not a true", 24);
	    line("<str>champion and have proved myself worthy to wear rune", 25);
	    line("<str>platemail!", 26);
	    line("<col=FF0000>QUEST COMPLETE!</col>", 27);
	    line(BLUE + "I gained " + RED + "2 Quest Points" + BLUE + ", " + RED + "18,650 Strength XP" + BLUE + "," + RED + " 18" + BLUE + ",650", 28);
	    line(RED + "Defence XP " + BLUE + "and the right to wear " + RED + "rune platebodies.", 29);
	    break;
	}
    }

    @Override
    public void finish() {
	super.finalize();
	player.getPacketDispatch().sendString("2 Quests Points", 277, 8);
	player.getPacketDispatch().sendString("Ability to wear rune platebody", 277, 9);
	player.getPacketDispatch().sendString("18,650 Strength XP", 277, 10);
	player.getPacketDispatch().sendString("18,650 Defence XP", 277, 11);
	player.getPacketDispatch().sendString("You have completed the Dragon Slayer Quest!", 277, 2);
	player.getPacketDispatch().sendItemZoomOnInterface(ELVARG_HEAD.getId(), 230, 277, 3);
	player.getSkills().addExperience(Skills.STRENGTH, 18650);
	player.getSkills().addExperience(Skills.DEFENCE, 18650);
    }

    /**
     * Method used to handle going through the magic door.
     * @param player the player.
     * @param interaction the interaction.
     * @return <code>True</code> if so.
     */
    public static boolean handleMagicDoor(final Player player, boolean interaction) {
	if (!player.getSavedData().getQuestData().getDragonSlayerItem("lobster") || !player.getSavedData().getQuestData().getDragonSlayerItem("bowl") || !player.getSavedData().getQuestData().getDragonSlayerItem("silk") || !player.getSavedData().getQuestData().getDragonSlayerItem("wizard")) {
	    if (interaction) {
		player.getPacketDispatch().sendMessage("You can't see any way to open the door.");
	    }
	    return true;
	}
	player.getPacketDispatch().sendMessage("The door opens...");
	final GameObject object = RegionManager.getObject(new Location(3050, 9839, 0));
	player.faceLocation(object.getLocation());
	player.getPacketDispatch().sendObjectAnimation(object, new Animation(6636));
	GameWorld.submit(new Pulse(1, player) {
	    int counter = 0;

	    @Override
	    public boolean pulse() {
		switch (counter++) {
		case 4:
		    AgilityHandler.walk(player, 0, player.getLocation(), player.getLocation().getX() == 3051 ? Location.create(3049, 9840, 0) : Location.create(3051, 9840, 0), null, 0, null);
		    break;
		case 5:
		    player.getPacketDispatch().sendObjectAnimation(object, new Animation(6637));
		    break;
		case 6:
		    player.getPacketDispatch().sendObjectAnimation(object, new Animation(6635));
		    return true;
		}
		return false;
	    }
	});
	return true;
    }

    @Override
    public int[] getConfig() {
	int id = 176;
	if (state == QuestState.COMPLETED) {
	    return new int[] { id, 10 };
	} else if (state == QuestState.STARTED) {
	    return new int[] { id, 1 };
	} else {
	    return new int[] { id, 0 };
	}
    }

    @Override
    public int getIndex() {
	return 18;
    }

    @Override
    public String getName() {
	return "Dragon Slayer";
    }

    @Override
    public int getQuestPoints() {
	return 2;
    }
}
