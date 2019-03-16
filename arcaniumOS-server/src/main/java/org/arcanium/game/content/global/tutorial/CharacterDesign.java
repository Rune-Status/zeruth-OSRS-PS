package org.arcanium.game.content.global.tutorial;

import org.arcanium.game.component.CloseEvent;
import org.arcanium.game.component.Component;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.appearance.Gender;
import org.arcanium.game.world.GameWorld;

/**
 * Represents the class used to handle the character design.
 * @author Emperor
 */
public final class CharacterDesign {

    /**
     * The male head ids.
     */
    private static final int[] MALE_HEAD_IDS = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 91, 92, 93, 94, 95, 96, 97 };

    /**
     * The female head ids.
     */
    private static final int[] FEMALE_HEAD_IDS = { 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146 };

    /**
     * The male jaw ids.
     */
    private static final int[] MALE_JAW_IDS = { 10, 11, 12, 13, 14, 15, 16, 17, 98, 99, 100, 101, 102, 103, 104 };

    /**
     * The female jaw ids.
     */
    private static final int[] FEMALE_JAW_IDS = { 1000 };

    /**
     * The male torso ids.
     */
    private static final int[] MALE_TORSO_IDS = { 18, 19, 20, 21, 22, 23, 24, 25, 111, 112, 113, 114, 115, 116 };

    /**
     * The female torso ids.
     */
    private static final int[] FEMALE_TORSO_IDS = { 56, 57, 58, 59, 60, 153, 154, 155, 156, 157, 158 };

    /**
     * The male arms ids.
     */
    private static final int[] MALE_ARMS_IDS = { 26, 27, 28, 29, 30, 31, 105, 106, 107, 108, 109, 110 };

    /**
     * The female arms ids.
     */
    private static final int[] FEMALE_ARMS_IDS = { 61, 62, 63, 64, 65, 147, 148, 149, 150, 151, 152 };

    /**
     * The male hands ids.
     */
    private static final int[] MALE_HANDS_IDS = { 33, 34, 84, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126 };

    /**
     * The female hands ids.
     */
    private static final int[] FEMALE_HANDS_IDS = { 67, 68, 127, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168 };

    /**
     * The male legs ids.
     */
    private static final int[] MALE_LEGS_IDS = { 36, 37, 38, 39, 40, 85, 86, 87, 88, 89, 90 };

    /**
     * The female legs ids.
     */
    private static final int[] FEMALE_LEGS_IDS = { 70, 71, 72, 73, 74, 75, 76, 77, 128, 129, 130, 131, 132, 133, 134 };

    /**
     * The male feet ids.
     */
    private static final int[] MALE_FEET_IDS = { 42, 43 };

    /**
     * The female feet ids.
     */
    private static final int[] FEMALE_FEET_IDS = { 79, 80 };

    /**
     * The male look ids.
     */
    private static final int[][] MALE_LOOK_IDS = { MALE_HEAD_IDS, MALE_JAW_IDS, MALE_TORSO_IDS, MALE_ARMS_IDS, MALE_HANDS_IDS, MALE_LEGS_IDS, MALE_FEET_IDS };

    /**
     * The female look ids.
     */
    private static final int[][] FEMALE_LOOK_IDS = { FEMALE_HEAD_IDS, FEMALE_JAW_IDS, FEMALE_TORSO_IDS, FEMALE_ARMS_IDS, FEMALE_HANDS_IDS, FEMALE_LEGS_IDS, FEMALE_FEET_IDS };

    /**
     * The colour indexes.
     */
    private static final int colors[] = new int[] { 0, 2, 4, 5, 6 };

    /**
     * Method used to open the design.
     * @param player the player.
     */
    public static void open(final Player player) {
	player.unlock();
	player.getAppearance().changeChender(player.getAppearance().getGender());
	player.removeAttribute("char-design:accepted");
	Component c = player.getInterfaceManager().openComponent(660);
	if (c != null) {
	    c.setCloseEvent(new CloseEvent() {
		@Override
		public boolean close(Player player, Component c) { // Unclosable!
		    return player.getAttribute("char-design:accepted", false);
		}
	    });
	}
	reset(player);
	refresh(player, true, true);
    }

    /**
     * Handles the buttons.
     * @param opcode the opcode.
     * @param button the button.
     */
    public static boolean handleButtons(Player player, int buttonId) {
	switch (buttonId) {
	case 137:
	case 138:
	    changeGender(player, buttonId == 138);
	    break;
	case 107:
	case 114:
	    updateLook(player, 0, buttonId == 114, MALE_HEAD_IDS.length - 1, FEMALE_HEAD_IDS.length - 1);
	    return true;
	case 108:
	case 115:
	    updateLook(player, 1, buttonId == 115, MALE_JAW_IDS.length - 1, FEMALE_JAW_IDS.length - 1);
	    return true;
	case 109:
	case 116:
	    updateLook(player, 2, buttonId == 116, MALE_TORSO_IDS.length - 1, FEMALE_TORSO_IDS.length - 1);
	    return true;
	case 110:
	case 117:
	    updateLook(player, 3, buttonId == 117, MALE_ARMS_IDS.length - 1, FEMALE_ARMS_IDS.length - 1);
	    return true;
	case 111:
	case 118:
	    updateLook(player, 4, buttonId == 118, MALE_HANDS_IDS.length - 1, FEMALE_HANDS_IDS.length - 1);
	    return true;
	case 112:
	case 119:
	    updateLook(player, 5, buttonId == 119, MALE_LEGS_IDS.length - 1, FEMALE_LEGS_IDS.length - 1);
	    return true;
	case 113:
	case 120:
	    updateLook(player, 6, buttonId == 120, MALE_FEET_IDS.length - 1, FEMALE_FEET_IDS.length - 1);
	    return true;
	case 123:
	case 128:
	    updateColour(player, 24, 0, buttonId == 128);
	    return true;
	case 124:
	case 129:
	    updateColour(player, 28, 2, buttonId == 129);
	    return true;
	case 125:
	case 130:
	    updateColour(player, 28, 5, buttonId == 130);
	    return true;
	case 126:
	case 131:
	    updateColour(player, 5, 6, buttonId == 131);
	    return true;
	case 127:
	case 132:
	    updateColour(player, 7, 4, buttonId == 132);
	    return true;
	case 100:
	    acceptDesign(player);
	    return true;
	}
	return false;
    }

    /**
     * Accepts the character design settings.
     * @param player The player.
     */
    private static void acceptDesign(Player player) {
	boolean male = player.getAttribute("char-design:gender", 0) == 0;
	player.getAppearance().setGender(male ? Gender.MALE : Gender.FEMALE);
	int index = 0;
	for (int[] ids : (male ? MALE_LOOK_IDS : FEMALE_LOOK_IDS)) {
	    player.getAppearance().getAppearanceCache()[index].changeLook(ids[player.getAttribute("char-design:look" + (index++), 0)]);
	}
	for (int i : colors) {
	    player.getAppearance().getAppearanceCache()[i].changeColor(player.getAttribute(new StringBuilder("char-design:colour").append(i).toString(), 0));
	}
	player.getAppearance().sync();
	player.setAttribute("char-design:accepted", true);
	player.getInterfaceManager().close();
	if (!GameWorld.isEconomyWorld()) {
	    player.lock();
	    player.getDialogueInterpreter().sendDialogue("Looking good, " + player.getUsername() + "! Now it's time to decide a class", "style.");
	}
    }

    /**
     * Updates the colour settings.
     * @param player The player.
     * @param max The maximum colour value.
     * @param index The colour index.
     * @param incr If we are incrementing the value.
     */
    private static void updateColour(Player player, int max, int index, boolean incr) {
	String type = "char-design:colour" + index;
	int value = player.getAttribute(type, 0) + (incr ? 1 : -1);
	if (value < 0) {
	    value = max;
	} else if (value > max) {
	    value = 0;
	}
	player.setAttribute(type, value);
	refresh(player, false, true);
    }

    /**
     * Updates the current value.
     * @param player The player.
     * @param look The look index.
     * @param incr If we should increment the current value.
     * @param bounds The boundaries.
     */
    private static void updateLook(Player player, int look, boolean incr, int maleMax, int femaleMax) {
	String type = "char-design:look" + look;
	int max = player.getAttribute("char-design:gender", 0) == 0 ? maleMax : femaleMax;
	int value = player.getAttribute(type, 0) + (incr ? 1 : -1);
	if (value < 0) {
	    value = max;
	} else if (value > max) {
	    value = 0;
	}
	// System.out.println("max=" + max + ", type=" + type + ", value=" +
	// value);
	player.setAttribute(type, value);
	refresh(player, true, false);
    }

    /**
     * Changes the gender settings.
     * @param player The player.
     * @param female If the gender is being set to female.
     */
    private static void changeGender(Player player, boolean female) {
	player.setAttribute("char-design:gender", female ? 1 : 0);
	for (int i = 0; i < 6; i++) {
	    player.removeAttribute("char-design:look" + i);
	}
	refresh(player, true, true);
    }

    /**
     * Refreshes the character design screen.
     * @param player The player.
     * @param looks If we should refresh the looks.
     * @param colours If we should refresh the colours.
     */
    private static void refresh(Player player, boolean looks, boolean colours) {
	if (looks) {
	    // Head
	    int value = player.getAttribute("char-design:look0", 0);
	    // Torso
	    value |= player.getAttribute("char-design:look2", 0) << 9;
	    // Arms
	    value |= player.getAttribute("char-design:look3", 0) << 13;
	    // Hands
	    value |= player.getAttribute("char-design:look4", 0) << 17;
	    // Legs
	    value |= player.getAttribute("char-design:look5", 0) << 21;
	    // Feet
	    value |= player.getAttribute("char-design:look6", 0) << 25;
	    // System.err.println("[Char design] look value=" + value + ".");
	    player.getConfigManager().sendVarp(1158, value);
	}
	if (colours) {
	    // Hair color
	    int value = player.getAttribute("char-design:colour0", 0);
	    // Torso color
	    value |= player.getAttribute("char-design:colour2", 0) << 5;
	    // Legs color.
	    value |= player.getAttribute("char-design:colour5", 0) << 10;
	    // Boots color
	    value |= player.getAttribute("char-design:colour6", 0) << 15;
	    // Skin color
	    value |= player.getAttribute("char-design:colour4", 0) << 18;
	    // Gender
	    value |= player.getAttribute("char-design:gender", 0) << 21;
	    // System.err.println("[Char design] colour value=" + value + ".");
	    player.getConfigManager().sendVarp(1159, value);
	}
    }

    /**
     * Resets the character design attributes.
     * @param player The player.
     */
    private static void reset(Player player) {
	boolean male = player.getAppearance().getGender() == Gender.MALE;
	int index = 0;
	for (int[] id : (male ? MALE_LOOK_IDS : FEMALE_LOOK_IDS)) {
	    player.setAttribute("char-design:look" + index, getIndex(player.getAppearance().getAppearanceCache()[index++].getLook(), id));
	}
	for (int i : colors) {
	    player.setAttribute("char-design:colour" + i, player.getAppearance().getAppearanceCache()[i].getColor());
	}
	player.setAttribute("char-design:gender", male ? 0 : 1);
    }

    /**
     * Gets the index of the look id.
     * @param lookId The current look id.
     * @param ids The ids.
     * @return The index.
     */
    private static int getIndex(int lookId, int[] ids) {
	for (int i = 0; i < ids.length; i++) {
	    if (ids[i] == lookId) {
		return i;
	    }
	}
	return 0;
    }
}
