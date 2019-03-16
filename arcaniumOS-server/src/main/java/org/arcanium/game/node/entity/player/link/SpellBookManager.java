package org.arcanium.game.node.entity.player.link;

import org.arcanium.game.content.skill.f2p.magic.MagicSpell;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.parser.player.SavingModule;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a managing class of a players spell book.
 *
 * @author Vexia
 */
public final class SpellBookManager implements SavingModule {

    public final static int MODERN_SPELLBOOK_INTERFACE = 218;
    public final static int LUNAR_SPELLBOOK_INTERFACE = 430;
    public final static int ANCIENT_SPELLBOOK_INTERFACE = 193;

    /**
     * Represents the current interface if of the spellbook.
     */
    private int spellBook = SpellBook.MODERN.getConfig();

    /**
     * Constructs a new {@code SpellBookManager} {@code Object}.
     */
    public SpellBookManager() {
        /**
         * empty.
         */
    }

    @Override
    public void save(ByteBuffer buffer) {
        buffer.put((byte) spellBook);
    }

    @Override
    public void parse(ByteBuffer buffer) {
        if (buffer.hasRemaining()) {
            setSpellBook(SpellBook.forConfig(buffer.get()));
        }
    }

    /**
     * Sets the spell book.
     *
     * @param book
     */
    public void setSpellBook(SpellBook book) {
        this.spellBook = book.getConfig();
    }

    /**
     * Updates the
     *
     * @param player
     */
    public void update(Player player) {
        player.getConfigManager().sendVarp(439, SpellBook.forConfig(this.spellBook).getConfig());
    }

    /**
     * Gets the spell book.
     *
     * @return the spellBook
     */
    public int getSpellBook() {
        return spellBook;
    }

    /**
     * Represents a characters spellbook.
     *
     * @author 'Vexia
     * @author Emperor
     */
    public static enum SpellBook {

        /**
         * The modern magic spell book.
         */
        MODERN(0),

        /**
         * The ancient magicks spell book.
         */
        ANCIENT(1),

        /**
         * The lunar magic spell book.
         */
        LUNAR(2),

        /**
         * The arceuus magic spell book.
         */
        ARCEUUS(3);

        /**
         * The interface id of this spell book.
         */
        private int config;

        /**
         * The spells mapping.
         */
        private final Map<Integer, MagicSpell> spells = new HashMap<>();

        /**
         * Creates the spell book.
         *
         * @param config The spellbook config id.
         */
        private SpellBook(int config) {
            this.config = config;
        }

        /**
         * @return The interfaceId.
         */
        public int getConfig() {
            return config;
        }

        /**
         * Method used to get the book.
         *
         * @param id the id.
         */
        public static SpellBook forConfig(final int id) {
            for (SpellBook book : SpellBook.values()) {
                if (book.config == id) {
                    return book;
                }
            }
            return null;
        }

        /**
         * Registers a new spell.
         *
         * @param buttonId The button id.
         * @param spell    The spell.
         */
        public void register(int buttonId, MagicSpell spell) {
            spell.setSpellId(buttonId);
            spells.put(buttonId, spell);
        }

        /**
         * Gets a spell from the spellbook.
         *
         * @param buttonId The button id.
         * @return The spell.
         */
        public MagicSpell getSpell(int buttonId) {
            return spells.get(buttonId);
        }
    }

}