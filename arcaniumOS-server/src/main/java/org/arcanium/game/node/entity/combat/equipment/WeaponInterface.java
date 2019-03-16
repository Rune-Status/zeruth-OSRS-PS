package org.arcanium.game.node.entity.combat.equipment;

import org.arcanium.game.component.Component;
import org.arcanium.game.component.ComponentDefinition;
import org.arcanium.game.container.impl.EquipmentContainer;
import org.arcanium.game.node.entity.combat.CombatSpell;
import org.arcanium.game.node.entity.impl.Animator.Priority;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.InterfaceManager;
import org.arcanium.game.node.entity.player.link.SpellBookManager.SpellBook;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.world.update.flag.context.Animation;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.InterfaceConfigContext;
import org.arcanium.net.packet.context.InterfaceContext;
import org.arcanium.net.packet.context.StringContext;
import org.arcanium.net.packet.server.Interface;
import org.arcanium.net.packet.server.InterfaceConfig;
import org.arcanium.net.packet.server.StringPacket;
import org.arcanium.parser.item.ItemConfiguration;

/**
 * Represents the weapon interface component.
 *
 * @author Emperor
 */
public final class WeaponInterface extends Component {

    /**
     * The modern spell ids.
     */
    private static final int[] MODERN_SPELL_IDS = {1, 4, 6, 8, 10, 14, 17, 20, 24, 27, 33, 38, 45, 48, 52, 55};

    /**
     * The ancient spell ids.
     */
    private static final int[] ANCIENT_SPELL_IDS = {8, 12, 4, 0, 10, 14, 6, 2, 9, 13, 5, 1, 11, 15, 7, 3};

    /**
     * The default attack animations.
     */
    public static final Animation[] DEFAULT_ANIMS = {
            new Animation(422, Priority.HIGH), new Animation(423, Priority.HIGH),
            new Animation(422, Priority.HIGH), new Animation(422, Priority.HIGH)
    };

    /**
     * The stab equipment bonus index.
     */
    public static final int BONUS_STAB = 0;

    /**
     * The slash equipment bonus index.
     */
    public static final int BONUS_SLASH = 1;

    /**
     * The crush equipment bonus index.
     */
    public static final int BONUS_CRUSH = 2;

    /**
     * The magic equipment bonus index.
     */
    public static final int BONUS_MAGIC = 3;

    /**
     * The range equipment bonus index.
     */
    public static final int BONUS_RANGE = 4;

    /**
     * The accurate melee attack style
     */
    public static final int STYLE_ACCURATE = 0;

    /**
     * The aggressive attack style
     */
    public static final int STYLE_AGGRESSIVE = 1;

    /**
     * The controlled attack style
     */
    public static final int STYLE_CONTROLLED = 2;

    /**
     * The defensive attack style
     */
    public static final int STYLE_DEFENSIVE = 3;

    /**
     * The accurate range attack style
     */
    public static final int STYLE_RANGE_ACCURATE = 4;

    /**
     * The rapid range attack style
     */
    public static final int STYLE_RAPID = 5;

    /**
     * The long range attack style
     */
    public static final int STYLE_LONG_RANGE = 6;

    /**
     * The defensive spell cast attack style
     */
    public static final int STYLE_DEFENSIVE_CAST = 7;

    /**
     * The spell cast attack style
     */
    public static final int STYLE_CAST = 8;

    /**
     * The player.
     */
    private final Player player;

    /**
     * The current weapon interface.
     */
    private WeaponInterfaces current;

    /**
     * If the player has the special attack bar shown.
     */
    private boolean specialBar;

    /**
     * The player's attack animations.
     */
    private Animation[] attackAnimations;

    /**
     * Constructs a new {@code WeaponInterface} {@code Object}.
     *
     * @param player The player.
     */
    public WeaponInterface(Player player) {
        super(593);
        this.player = player;
        player.addExtension(WeaponInterface.class, this);
    }

    @Override
    public void open(Player player) {
        current = null;
        updateInterface();
    }

    /**
     * Opens the interface.
     */
    private void open() {
        ComponentDefinition definition = ComponentDefinition.forId(593);
        if (definition.getContext() != null) {
            definition.getContext().setWindowId(player.getInterfaceManager().getWindowsPane());
            PacketRepository.send(Interface.class, definition.getContext().transform(player, id));
        }
        int slot = ensureStyleIndex(player, player.getSettings().getAttackStyleIndex());
        if (slot != player.getSettings().getAttackStyleIndex()) {
            player.getSettings().toggleAttackStyleIndex(slot);
        }
        player.getProperties().setAttackStyle(current.getAttackStyles()[slot]);
        checkStaffConfigs(slot);
    }

    /**
     * Ensures the style index.
     *
     * @param player The player.
     * @param slot   The attack style index.
     * @return The index, ensured to be smaller than styles.length and larger than 0.
     */
    private int ensureStyleIndex(Player player, int slot) {
        AttackStyle style = player.getProperties().getAttackStyle();
        if (slot >= current.getAttackStyles().length) {
            slot = current.getAttackStyles().length - 1;
            if (style != null) {
                for (int i = slot; i >= 0; i--) {
                    if (current.getAttackStyles()[i].style == style.style) {
                        return i;
                    }
                }
            }
            return slot;
        }
        if (style != null && current.getAttackStyles()[slot].style != style.style) {
            for (int i = current.getAttackStyles().length - 1; i >= 0; i--) {
                if (current.getAttackStyles()[i].style == style.style) {
                    return i;
                }
            }
        }
        return slot;
    }

    /**
     * Updates the interface.
     */
    public void updateInterface() {
        player.getInterfaceManager().getTabs()[0] = this;
        Item weapon = player.getEquipment().get(EquipmentContainer.SLOT_WEAPON);
        WeaponInterfaces inter = getWeaponInterface(weapon);
        String name;
        if (weapon != null) {
            name = weapon.getDefinition().getName();
            specialBar = weapon.getDefinition().getConfiguration(ItemConfiguration.HAS_SPECIAL, false);
            attackAnimations = weapon.getDefinition().getConfiguration(ItemConfiguration.ATTACK_ANIMS, DEFAULT_ANIMS);
        } else {
            name = "Unarmed";
            specialBar = false;
            attackAnimations = DEFAULT_ANIMS;
        }
        if (inter != current) {
            current = inter;
            open();
            player.getProperties().getCombatPulse().updateStyle();
        }
        if (player.getSettings().getAttackStyleIndex() < attackAnimations.length && !player.getAppearance().isNpc()) {
            player.getProperties().setAttackAnimation(attackAnimations[player.getSettings().getAttackStyleIndex()]);
        }
        if (current != WeaponInterfaces.STAFF) {
            selectAutoSpell(-1, false);
            PacketRepository.send(InterfaceConfig.class, new InterfaceConfigContext(player, id, current.getAttackStyles().length > 3 ? 12 : 10, !specialBar));
        }
        if (!canAutocast(false)) {
            if (current == WeaponInterfaces.STAFF && player.getAttribute("autocast_select", false)) {
                open();
            }
            //selectAutoSpell(-1, true);
        }
        PacketRepository.send(StringPacket.class, new StringContext(player, name, id, 1));
        PacketRepository.send(StringPacket.class, new StringContext(player, "Combat Lvl: " + player.getProperties().getCombatLevel(), id, 2));
        player.getConfigManager().sendVarp(843, current.getConfig());
        if (player.getSettings().isSpecialToggled()) {
            player.getSettings().toggleSpecialBar();
        }
    }

    /**
     * Sets the current attack style.
     *
     * @param button The button the player has pressed.
     * @return {@code True} if the attack style got set.
     */
    public boolean setAttackStyle(int button) {
        int slot = (button / 4);
		/*if(slot == 3 && current.getAttackStyles().length == 3)
			slot--;*/
        System.out.println("[WeaponInterface] Setting attack style slot=" + slot);
        if (current == WeaponInterfaces.STAFF) {
            slot = 1;
        }
		/*if (current == WeaponInterfaces.WARHAMMER_MAUL || (current.attackStyles.length > 2 && current.attackStyles[2].bonusType == BONUS_RANGE)) {
			slot = button == 4 ? 1 : button == 3 ? 2 : 0;
		}
		else if (current == WeaponInterfaces.CLAWS) {
			slot = button == 5 ? 1 : button == 3 ? 3 : slot;
		}*/
		/*if (current == WeaponInterfaces.AXE) {
			if (button == 5) {
				slot = 1;
			} else if (button == 3) {
				slot = 3;
			}
		}*/
        if (slot < 0 || slot >= current.getAttackStyles().length) {
            System.out.println("[WeaponInterface] Invalid attack slot");
            return false;
        }
        AttackStyle style = current.getAttackStyles()[slot];
        System.out.println("[WeaponInterface] Attack style is null ? " + (style == null ? "true" : "false"));
        player.getProperties().setAttackStyle(style);
        player.getSettings().toggleAttackStyleIndex(slot);
        if (slot < attackAnimations.length && !player.getAppearance().isNpc()) {
            player.getProperties().setAttackAnimation(attackAnimations[slot]);
        }
        checkStaffConfigs(button - 1);
        return true;
    }

    /**
     * Checks the staff configurations.
     *
     * @param slot The slot of the current attack style selected.
     */
    private void checkStaffConfigs(int slot) {
        System.out.println("[WeaponInterface] Checking staff configs");
        if (current != WeaponInterfaces.STAFF) {
            selectAutoSpell(-1, false);
            return;
        }
        boolean defensive = slot == 3;
        player.getConfigManager().sendVarp(439, defensive ? -5 : 0);
        if (slot > 2) {
            player.getConfigManager().sendVarp(43, defensive ? -1 : 3);
        }
    }

    ;

    /**
     * Gets the autocast tab component id.
     *
     * @param spellId The spell id.
     * @return The component id for the autocast select tab.
     */
    public int getAutospellId(int spellId) {
        boolean modern = player.getSpellBookManager().getSpellBook() == SpellBook.MODERN.getConfig();
        int[] data = modern ? MODERN_SPELL_IDS : ANCIENT_SPELL_IDS;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == spellId) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Selects the current autocast spell.
     *
     * @param buttonId          The button id.
     * @param adjustAttackStyle If the attack style should be adjusted.
     */
    public void selectAutoSpell(int buttonId, boolean adjustAttackStyle) {
        boolean modern = player.getSpellBookManager().getSpellBook() == SpellBook.MODERN.getConfig();
        int[] data = modern ? MODERN_SPELL_IDS : ANCIENT_SPELL_IDS;
        CombatSpell current = player.getProperties().getAutocastSpell();
        if (buttonId >= data.length) {
            return;
        }
        int configStart = modern ? 45 : 13;
        if (current != null) {
            for (int index = 0; index < data.length; index++) {
                if (data[index] == current.getComponentId()) {
                    player.getPacketDispatch().sendInterfaceConfig(90, configStart + (2 * index), true);
                    player.getPacketDispatch().sendInterfaceConfig(90, 100 + configStart + (2 * index), true);
                }
            }
        }
        if (buttonId < 0) {
            player.getProperties().setAutocastSpell(null);
            if (adjustAttackStyle && current != null) {
                setAttackStyle(3);
                player.getProperties().getCombatPulse().updateStyle();
            }
            return;
        }
        boolean defensive = player.getSettings().getAttackStyleIndex() == 3;
        player.getPacketDispatch().sendInterfaceConfig(90, 183, defensive);
        player.getPacketDispatch().sendInterfaceConfig(90, 83, !defensive);
        current = (CombatSpell) (modern ? SpellBook.MODERN.getSpell(data[buttonId]) : SpellBook.ANCIENT.getSpell(data[buttonId]));
        player.getProperties().setAutocastSpell(current);
        player.getPacketDispatch().sendInterfaceConfig(90, (defensive ? 100 : 0) + configStart + (2 * buttonId), false);
    }

    /**
     * Opens the autocast select.
     */
    public void openAutocastSelect() {
        if (current != WeaponInterfaces.STAFF) {
            System.out.println("[Autocast] Weapon is not staff returning");
            return;
        }
        if (!canAutocast(true)) {
            setAttackStyle(3);
            return;
        }
        player.setAttribute("autocast_select", true);
        int id = 201;
        Component component = new Component(id);
        component.getDefinition().setContext(new InterfaceContext(player, player.getInterfaceManager().getWindowsPane(), InterfaceManager.ATTACK_SLOT, id, false));
        player.getInterfaceManager().openTab(component);
    }

    /**
     * Checks if the player is currently able to autocast.
     *
     * @param message If we should notify the player if he's unable to autocast.
     * @return {@code True} if so.
     */
    public boolean canAutocast(boolean message) {
        if (current != WeaponInterfaces.STAFF) {
            return false;
        }
        if (player.getSpellBookManager().getSpellBook() == SpellBook.LUNAR.getConfig()) {
            if (message) {
                player.getPacketDispatch().sendMessage("You can't autocast Lunar magic.");
            }
            return false;
        }
        boolean ancientStaff = player.getEquipment().getNew(3).getName().contains("ncient staff");
        if ((player.getSpellBookManager().getSpellBook() == SpellBook.LUNAR.getConfig() && ancientStaff)
                || (player.getSpellBookManager().getSpellBook() == SpellBook.ANCIENT.getConfig() && !ancientStaff)) {
            if (message) {
                player.getPacketDispatch().sendMessage("You can only autocast ancient magicks with an Ancient staff.");
            }
            return false;
        }
        return true;
    }

    /**
     * Gets the current weapon interface id.
     *
     * @return The component id.
     */
    public static WeaponInterfaces getWeaponInterface(Item weapon) {
        if (weapon == null) {
            return WeaponInterfaces.values()[0];
        }
        int slot = weapon.getDefinition().getConfiguration(ItemConfiguration.WEAPON_INTERFACE, 0);
        return WeaponInterfaces.values()[slot];
    }

    /**
     * Represents an attack style.
     *
     * @author Emperor
     */
    public static class AttackStyle {

        /**
         * The style type.
         */
        private final int style;

        /**
         * The bonus type.
         */
        private final int bonusType;

        /**
         * Constructs a new {@code AttackStyle} {@code Object}.
         *
         * @param style     The style type.
         * @param bonusType The bonus type.
         */
        public AttackStyle(int style, int bonusType) {
            this.style = style;
            this.bonusType = bonusType;
        }

        /**
         * Gets the style.
         *
         * @return The style.
         */
        public int getStyle() {
            return style;
        }

        /**
         * Gets the bonusType.
         *
         * @return The bonusType.
         */
        public int getBonusType() {
            return bonusType;
        }
    }

    /**
     * Represents the weapon interfaces.
     *
     * @author Emperor
     */
    public static enum WeaponInterfaces {

        /**
         * The unarmed weapon interface (ordinal=0)
         */
        UNARMED(0, new AttackStyle(STYLE_ACCURATE, BONUS_CRUSH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_CRUSH), new AttackStyle(STYLE_DEFENSIVE, BONUS_CRUSH)),

        /**
         * The staff weapon interface (ordinal=1)
         */
        STAFF(18, new AttackStyle(STYLE_ACCURATE, BONUS_CRUSH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_CRUSH), new AttackStyle(STYLE_DEFENSIVE, BONUS_CRUSH), new AttackStyle(STYLE_DEFENSIVE_CAST, BONUS_MAGIC), new AttackStyle(STYLE_CAST, BONUS_MAGIC)),

        /**
         * The (battle) axe weapon interface (ordinal=2)
         */
        AXE(1, new AttackStyle(STYLE_ACCURATE, BONUS_SLASH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_SLASH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_CRUSH), new AttackStyle(STYLE_DEFENSIVE, BONUS_SLASH)),

        /**
         * The scepter weapon interface (ordinal=3)
         */
        SCEPTER(13, new AttackStyle(STYLE_ACCURATE, BONUS_CRUSH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_CRUSH), new AttackStyle(STYLE_DEFENSIVE, BONUS_CRUSH)),

        /**
         * The pickaxe weapon interface (ordinal=4)
         */
        PICKAXE(11, new AttackStyle(STYLE_ACCURATE, BONUS_STAB), new AttackStyle(STYLE_AGGRESSIVE, BONUS_STAB), new AttackStyle(STYLE_AGGRESSIVE, BONUS_CRUSH), new AttackStyle(STYLE_DEFENSIVE, BONUS_STAB)),

        /**
         * The sword/dagger weapon interface (ordinal=5)
         */
        SWORD_DAGGER(17, new AttackStyle(STYLE_ACCURATE, BONUS_STAB), new AttackStyle(STYLE_AGGRESSIVE, BONUS_STAB), new AttackStyle(STYLE_AGGRESSIVE, BONUS_SLASH), new AttackStyle(STYLE_DEFENSIVE, BONUS_STAB)),

        /**
         * The scimitar/silverlight/silver sickle/... weapon interface (ordinal=6)
         */
        SCIMITAR(9, new AttackStyle(STYLE_ACCURATE, BONUS_SLASH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_SLASH), new AttackStyle(STYLE_CONTROLLED, BONUS_STAB), new AttackStyle(STYLE_DEFENSIVE, BONUS_SLASH)),

        /**
         * The 2-h sword weapon interface (ordinal=7)
         */
        TWO_H_SWORD(10, new AttackStyle(STYLE_ACCURATE, BONUS_SLASH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_SLASH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_CRUSH), new AttackStyle(STYLE_DEFENSIVE, BONUS_SLASH)),

        /**
         * The mace weapon interface (ordinal=8)
         */
        MACE(16, new AttackStyle(STYLE_ACCURATE, BONUS_CRUSH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_CRUSH), new AttackStyle(STYLE_CONTROLLED, BONUS_STAB), new AttackStyle(STYLE_DEFENSIVE, BONUS_CRUSH)),

        /**
         * The claws weapon interface (ordinal=9)
         */
        CLAWS(4, new AttackStyle(STYLE_ACCURATE, BONUS_SLASH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_SLASH), new AttackStyle(STYLE_CONTROLLED, BONUS_STAB), new AttackStyle(STYLE_DEFENSIVE, BONUS_SLASH)),

        /**
         * The warhammer/maul weapon interface (ordinal=10)
         */
        WARHAMMER_MAUL(2, new AttackStyle(STYLE_ACCURATE, BONUS_CRUSH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_CRUSH), new AttackStyle(STYLE_DEFENSIVE, BONUS_CRUSH)),

        /**
         * The abyssal whip weapon interface (ordinal=11)
         */
        WHIP(20, new AttackStyle(STYLE_ACCURATE, BONUS_SLASH), new AttackStyle(STYLE_CONTROLLED, BONUS_SLASH), new AttackStyle(STYLE_DEFENSIVE, BONUS_SLASH)),

        /**
         * The flowers weapon interface (ordinal=12)
         */
        FLOWERS(2, new AttackStyle(STYLE_ACCURATE, BONUS_CRUSH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_CRUSH), new AttackStyle(STYLE_DEFENSIVE, BONUS_CRUSH)),

        /**
         * The mud pie weapon interface (ordinal=13)
         */
        MUD_PIE(19, new AttackStyle(STYLE_RANGE_ACCURATE, BONUS_RANGE), new AttackStyle(STYLE_RAPID, BONUS_RANGE), new AttackStyle(STYLE_LONG_RANGE, BONUS_RANGE)),

        /**
         * The spear weapon interface (ordinal=14)
         */
        SPEAR(15, new AttackStyle(STYLE_CONTROLLED, BONUS_STAB), new AttackStyle(STYLE_CONTROLLED, BONUS_SLASH), new AttackStyle(STYLE_CONTROLLED, BONUS_CRUSH), new AttackStyle(STYLE_DEFENSIVE, BONUS_STAB)),

        /**
         * The halberd weapon interface (ordinal=15)
         */
        HALBERD(12, new AttackStyle(STYLE_CONTROLLED, BONUS_STAB), new AttackStyle(STYLE_AGGRESSIVE, BONUS_SLASH), new AttackStyle(STYLE_DEFENSIVE, BONUS_STAB)),

        /**
         * The bow weapon interface (ordinal=16)
         */
        BOW(3, new AttackStyle(STYLE_RANGE_ACCURATE, BONUS_RANGE), new AttackStyle(STYLE_RAPID, BONUS_RANGE), new AttackStyle(STYLE_LONG_RANGE, BONUS_RANGE)),

        /**
         * The crossbow weapon interface (ordinal=17)
         */
        CROSSBOW(5, new AttackStyle(STYLE_RANGE_ACCURATE, BONUS_RANGE), new AttackStyle(STYLE_RAPID, BONUS_RANGE), new AttackStyle(STYLE_LONG_RANGE, BONUS_RANGE)),

        /**
         * The thrown weapons weapon interface (ordinal=18)
         */
        THROWN_WEAPONS(19, new AttackStyle(STYLE_RANGE_ACCURATE, BONUS_RANGE), new AttackStyle(STYLE_RAPID, BONUS_RANGE), new AttackStyle(STYLE_LONG_RANGE, BONUS_RANGE)),

        /**
         * The thrown weapons weapon interface (ordinal=19)
         */
        CHINCHOMPA(7, new AttackStyle(STYLE_RANGE_ACCURATE, BONUS_RANGE), new AttackStyle(STYLE_RAPID, BONUS_RANGE), new AttackStyle(STYLE_LONG_RANGE, BONUS_RANGE)),

        /**
         * The fixed device weapon interface (ordinal=20)
         */
        FIXED_DEVICE(8, new AttackStyle(STYLE_RANGE_ACCURATE, BONUS_RANGE), new AttackStyle(STYLE_AGGRESSIVE, BONUS_CRUSH)),

        /**
         * The salamander weapon interface (ordinal=21)
         */
        SALAMANDER(6, new AttackStyle(STYLE_AGGRESSIVE, BONUS_SLASH), new AttackStyle(STYLE_RANGE_ACCURATE, BONUS_RANGE), new AttackStyle(STYLE_DEFENSIVE_CAST, BONUS_MAGIC)),

        /**
         * The scythe weapon interface (ordinal=22)
         */
        SCYTHE(14, new AttackStyle(STYLE_ACCURATE, BONUS_SLASH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_STAB), new AttackStyle(STYLE_AGGRESSIVE, BONUS_CRUSH), new AttackStyle(STYLE_DEFENSIVE, BONUS_SLASH)),

        /**
         * The ivandis flail weapon interface (ordinal=23) TODO: Find correct interface id!
         */
        IVANDIS_FLAIL(16, new AttackStyle(STYLE_ACCURATE, BONUS_CRUSH), new AttackStyle(STYLE_AGGRESSIVE, BONUS_CRUSH), new AttackStyle(STYLE_DEFENSIVE, BONUS_CRUSH));

        /**
         * The attack styles.
         */
        private final AttackStyle[] attackStyles;

        private final int config;

        /**
         * Constructs a new {@code WeaponInterface} {@code Object}.
         *
         * @param attackStyles The attack styles.
         */
        private WeaponInterfaces(int config, AttackStyle... attackStyles) {
            this.config = config;
            this.attackStyles = attackStyles;
        }

        /**
         * Gets the attackStyles.
         *
         * @return The attackStyles.
         */
        public AttackStyle[] getAttackStyles() {
            return attackStyles;
        }

        public int getConfig() {
            return config;
        }
    }

    /**
     * Gets the currently opened weapon interface.
     *
     * @return The current weapon interface.
     */
    public WeaponInterfaces getWeaponInterface() {
        return current;
    }

    /**
     * If the special bar is enabled.
     *
     * @return {@code True} if so.
     */
    public boolean isSpecialBar() {
        return specialBar;
    }

}