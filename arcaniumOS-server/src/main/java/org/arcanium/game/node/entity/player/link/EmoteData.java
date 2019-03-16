package org.arcanium.game.node.entity.player.link;

import org.arcanium.game.content.holiday.HolidayEvent;
import org.arcanium.game.content.holiday.HolidayType;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.parser.player.SavingModule;

import java.nio.ByteBuffer;

/**
 * Represents the emote data.
 *
 * @author Emperor
 */
public final class EmoteData implements SavingModule {

    /**
     * The emote slot constants.
     */
    public static final int YES = 0;
    public static final int NO = 1;
    public static final int BOW = 2;
    public static final int ANGRY = 3;
    public static final int THINK = 4;
    public static final int WAVE = 5;
    public static final int SHRUG = 6;
    public static final int CHEER = 7;
    public static final int BECKON = 8;
    public static final int LAUGH = 9;
    public static final int JUMP_FOR_JOY = 10;
    public static final int YAWN = 11;
    public static final int DANCE = 12;
    public static final int JIG = 13;
    public static final int TWIRL = 14;
    public static final int HEADBANG = 15;
    public static final int CRY = 16;
    public static final int BLOW_KISS = 17;
    public static final int PANIC = 18;
    public static final int RASPBERRY = 19;
    public static final int CLAP = 20;
    public static final int SALUTE = 21;
    public static final int GOBLIN_BOW = 22;
    public static final int GOBLIN_SALUTE = 23;
    public static final int GLASS_BOX = 24;
    public static final int CLIMB_ROPE = 25;
    public static final int LEAN = 26;
    public static final int GLASS_WALL = 27;
    public static final int IDEA = 31;
    public static final int STOMP = 29;
    public static final int FLAP = 30;
    public static final int SLAP_HEAD = 28;
    public static final int ZOMBIE_WALK = 32;
    public static final int ZOMBIE_DANCE = 33;
    public static final int ZOMBIE_HAND = 34;
    public static final int SCARED = 35;
    public static final int BUNNY_HOP = 36;
    public static final int SKILLCAPE = 37;
    public static final int SNOWMAN_DANCE = 38;
    public static final int AIR_GUITAR = 39;
    public static final int SAFETY_FIRST = 40;

    /**
     * The emote names.
     */
    public static final String[] EMOTE_NAMES = {"Yes", "No", "Bow", "Angry", "Think", "Wave", "Shrug", "Cheer", "Beckon", "Laugh", "Jump for joy", "Yawn", "Dance", "Jig", "Twirl", "Headbang", "Cry", "Blow kiss", "Panic", "Raspberry", "Clap", "Salute", "Goblin bow", "Goblin salute", "Glass box", "Climb rope", "Lean", "Glass wall", "Idea", "Stomp", "Flap", "Slap head", "Zombie walk", "Zombie dance", "Zombie hand", "Scared", "Bunny hop", "Skillcape", "Snowman dance", "Air guitar", "Safety first"};

    /**
     * The locked emotes messages.
     */
    public static final String[] LOCKED_MESSAGE = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "This emote can be unlocked during the Lost Tribe quest.", // Goblin
            // bow
            "This emote can be unlocked during the Lost Tribe quest.", // Goblin
            // salute.
            "This emote can be unlocked during the Mime random event.", // Glass
            // box
            "This emote can be unlocked during the Mime random event.", // Climb
            // rope
            "This emote can be unlocked during the Mime random event.", // Lean
            "This emote can be unlocked during the Mime random event.", // Glass
            // wall
            "You can't use this emote yet. <br>Visit the Stronghold of Security to unlock it.", // Idea
            "You can't use this emote yet. <br>Visit the Stronghold of Security to unlock it.", // Stomp
            "You can't use this emote yet. <br>Visit the Stronghold of Security to unlock it.", // Flap
            "You can't use this emote yet. <br>Visit the Stronghold of Security to unlock it.", // Slap
            // head
            "This emote can be unlocked during the Gravedigger random event.", // Zombie
            // walk
            "This emote can be unlocked during the Gravedigger random event.", // Zombie
            // dance
            "This emote can be unlocked by playing a Halloween holiday event.", // Zombie
            // Hand
            "This emote can be unlocked by playing a Halloween holiday event.", // Scared
            "This emote can be unlocked by playing an Easter holiday event.", // Bunny
            // hop
            null, // Skillcape emote.
            "This emote can be unlocked by playing a Christmas holiday event.", // Snowman
            // dance
            "This emote can be accessed by unlocking 200 pieces of music.", // Air
            // guitar
            "You can't use this emote yet. Visit the Stronghold of Player safety to<br>unlock it.", // Safety
            // first
    };

    public static boolean SAVE_530 = true;

    /**
     * The player.
     */
    private final Player player;

    /**
     * The unlocked emotes.
     */
    private final boolean[] unlocked = new boolean[41];

    /**
     * Constructs a new {@code EmoteData} {@code Object}.
     *
     * @param player The player.
     */
    public EmoteData(Player player) {
        this.player = player;
        for (int i = 0; i < 22; i++) {
            unlocked[i] = true;
        }
    }

    /**
     * Loads the player's emote data.
     *
     * @param buffer The byte buffer to read from.
     */
    @Override
    public void parse(ByteBuffer buffer) {
        int opcode;
        while ((opcode = buffer.get() & 0xFF) != 0) {
            switch (opcode) {
                default: // Opcodes 22-40 are used for locked emotes.
                    unlocked[opcode] = true;
                    break;
            }
        }
    }

    @Override
    public void save(ByteBuffer buffer) {
       /* if (SAVE_530) {
            int size = 0;
            for (int i = 22; i < unlocked.length; i++) {
                if (unlocked[i]) {
                    size++;
                }
            }
            buffer.put((byte) size);
            for (int i = 22; i < unlocked.length; i++) {
                if (unlocked[i]) {
                    buffer.put((byte) i);
                }
            }
            return;
        }*/
        for (int i = 22; i < unlocked.length; i++) {
            if (unlocked[i]) {
                buffer.put((byte) i);
            }
        }
        buffer.put((byte) 0);
    }

    /**
     * Unlocks an emote.
     *
     * @param emoteId The emote id.
     */
    public void unlock(int emoteId) {
        if (!unlocked[emoteId]) {
            unlocked[emoteId] = true;
            refreshListConfigs();
        }
    }

    /**
     * Locks an emote.
     *
     * @param emoteId The emote id.
     */
    public void lock(int emoteId) {
        if (unlocked[emoteId]) {
            unlocked[emoteId] = false;
            refreshListConfigs();
        }
    }

    /**
     * Refreshes the emote list configurations.
     */
    public void refreshListConfigs() {
        if (!unlocked[BUNNY_HOP] && HolidayEvent.getCurrent() != null && HolidayEvent.getCurrent().getType() == HolidayType.EASTER && HolidayEvent.getCurrent().isComplete(player)) {
            unlock(BUNNY_HOP);
        }
        if (unlocked[GOBLIN_BOW] && unlocked[GOBLIN_SALUTE]) {
            player.getConfigManager().sendVarp(465, 7); // goblin quest emotes
        }
        int value1 = 0;
        if (unlocked[31]) {
            value1 += 4;
        }
        if (unlocked[30]) {
            value1 += 1;
        }
        if (unlocked[29]) {
            value1 += 8;
        }
        if (unlocked[28]) {
            value1 += 2;
        }
        player.getConfigManager().sendVarp(802, value1); // stronghold of // security
        // emotes
        int value2 = 0;
        if (unlocked[GLASS_BOX]) {
            value2 += 1;
        }
        if (unlocked[CLIMB_ROPE]) {
            value2 += 2;
        }
        if (unlocked[LEAN]) {
            value2 += 4;
        }
        if (unlocked[GLASS_WALL]) {
            value2 += 8;
        }
        if (unlocked[SCARED]) {
            value2 += 16;
        }
        if (unlocked[ZOMBIE_DANCE]) {
            value2 += 32;
        }
        if (unlocked[ZOMBIE_WALK]) {
            value2 += 64;
        }
        if (unlocked[BUNNY_HOP]) {
            value2 += 128;
        }
        if (unlocked[SKILLCAPE] || hasMaxedSkill(player)) {
            value2 += 256;
        }
        if (unlocked[SNOWMAN_DANCE]) {
            value2 += 512;
        }
        if (unlocked[AIR_GUITAR]) {
            value2 += 1024;
        }
        if (unlocked[SAFETY_FIRST]) {
            value2 += 2048;
        }
        if (value2 > 0) {
            player.getConfigManager().sendVarp(313, value2); // events emotes
        }
    }

    /**
     * Method used to check if the player has a 99.
     *
     * @param player the player.
     */
    public boolean hasMaxedSkill(final Player player) {
        for (int i = 0; i < 23; i++) {
            if (player.getSkills().getStaticLevel(i) >= 99) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the unlocked.
     *
     * @return The unlocked.
     */
    public boolean[] getUnlocked() {
        return unlocked;
    }

    /**
     * An emote.
     *
     * @author Vexia
     */
    public enum Emote {
        YES(EmoteData.YES, 2), NO(EmoteData.NO, 3), BOW(EmoteData.BOW, 4), ANGRY(EmoteData.ANGRY, 5), THINK(EmoteData.THINK, 6), WAVE(EmoteData.WAVE, 7), SHRUG(EmoteData.SHRUG, 8), CHEER(EmoteData.CHEER, 9), BECKON(EmoteData.BECKON, 10), LAUGH(EmoteData.LAUGH, 11), JUMP_FOR_JOY(EmoteData.JUMP_FOR_JOY, 12), YAWN(EmoteData.YAWN, 13), DANCE(EmoteData.DANCE, 14), JIG(EmoteData.JIG, 15), SPIN(EmoteData.TWIRL, 16), HEAD_BANG(EmoteData.HEADBANG, 17), CRY(EmoteData.CRY, 18), BLOW_KISS(EmoteData.BLOW_KISS, 19), PANIC(EmoteData.PANIC, 20), RASPBERRY(EmoteData.RASPBERRY, 21), CLAP(EmoteData.CLAP, 22), SALUTE(EmoteData.SALUTE, 23);

        /**
         * The emote id.
         */
        private final int emoteId;

        /**
         * The button id.
         */
        private final int buttonId;

        /**
         * Constructs a new {@Code Emote} {@Code Object}
         *
         * @param emoteId  the emote id.
         * @param buttonId the button id.
         */
        private Emote(int emoteId, int buttonId) {
            this.emoteId = emoteId;
            this.buttonId = buttonId;
        }

        /**
         * Gets an emote by the id.
         *
         * @param buttonId the buttonId.
         * @return the emote.
         */
        public static Emote forId(int buttonId) {
            for (Emote emote : values()) {
                if (emote.getButtonId() == buttonId) {
                    return emote;
                }
            }
            return null;
        }

        /**
         * Gets the bemoteId.
         *
         * @return the emoteId
         */
        public int getEmoteId() {
            return emoteId;
        }

        /**
         * Gets the bbuttonId.
         *
         * @return the buttonId
         */
        public int getButtonId() {
            return buttonId;
        }

    }
}