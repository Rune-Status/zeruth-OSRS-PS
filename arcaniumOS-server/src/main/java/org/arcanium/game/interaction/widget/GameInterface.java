package org.arcanium.game.interaction.widget;

import org.arcanium.game.component.Component;
import org.arcanium.game.interaction.widget.impl.SkillTabInterface;
import org.arcanium.game.node.entity.combat.equipment.WeaponInterface;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.InterfaceContext;
import org.arcanium.net.packet.server.CloseInterface;

/**
 * Represents the component plugin used for the game interface.
 *
 * @author 'Vexia
 * @author trees
 */
public final class GameInterface {

    private static final int ATTACK_TAB = 47;
    private static final int SKILL_TAB = 48;
    private static final int QUEST_TAB = 49;
    private static final int INVENTORY_TAB = 50;
    private static final int EQUIPMENT_TAB = 51;
    private static final int PRAYER_TAB = 52;
    private static final int MAGIC_TAB = 53;
    private static final int CLAN_TAB = 30;
    private static final int FRIENDS_TAB = 31;
    private static final int IGNORES_TAB = 32;
    private static final int LOGOUT_TAB = 33;
    private static final int OPTIONS_TAB = 34;
    private static final int EMOTES_TAB = 35;
    private static final int MUSIC_TAB = 36;
    private static final int XP_ORB = 1;
    private static final int PRAYER_ORB = 14;
    private static final int RUN_ORB = 22;
    private static final int WORLD_ORB = 42;

    public static boolean handle(Player player, Component component, int opcode, int button, int slot, int itemId) {

        /**
         * Skilltab
         */
        if (component.getId() == 320) {
            if (SkillTabInterface.open(player, SkillTabInterface.Skill.values()[button - 1])) {
                return true;
            }
        }
        /**
         * Chatbox
         */
        if (component.getId() == 162) {
            switch (button) {
                case 27:
                    openReport(player);
                    return true;
            }
        }

        /**
         * Gameframe Orbs
         */
        if (component.getId() == 160) {
            switch (button) {
                case XP_ORB:
                    switch (opcode) {
                        case 68: // Toggle Counter
                            if (player.xpCounterOn) {
                                player.getConfigManager().sendVarp(1055, 67257348);
                                PacketRepository.send(CloseInterface.class, new InterfaceContext(player, player.getInterfaceManager().getWindowsPane(), 12, 122, true));
                                player.xpCounterOn = false;
                            } else {
                                player.getConfigManager().sendVarp(1055, 67265540);
                                player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 12, 122, true);
                                player.xpCounterOn = true;
                            }
                            return true;
                        case 30: // Open Counter Settings
                            player.getConfigManager().sendVarp(638, 0);
                            player.getConfigManager().sendVarp(262, 0);
                            player.getConfigManager().sendVarp(261, 0);
                            player.getConfigManager().sendVarp(638, 0);
                            player.getPacketDispatch().sendCS2Script(917, new Object[]{-1, -1});//ii
                            player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 137, false);
                            return true;
                    }
                    break;
                case PRAYER_ORB:
                    switch (opcode) {
                        case 68: // Activate
                            player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 22, 595, true);
                            return true;
                        case 30: // Quick Prayer Setup
                            player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 1, 77, true);
                            player.getPacketDispatch().sendCS2Script(915, new Object[]{5}); // Open Side Tab
                            return true;
                    }
                    break;
                case WORLD_ORB:
                    switch (opcode) {
                        case 68: // Open Map
                            player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 22, 595, true);
                            return true;
                    }
                    player.getPacketDispatch().sendInterfaceSettings(595, 17, 0, 4, 2);
                    player.getPacketDispatch().sendCS2Script(1749, new Object[]{player.getLocation().getTileHash()});
                    return true;

                case RUN_ORB:
                    player.getSettings().toggleRun();
                    return true;
            }
        }
        switch (button) {
            case ATTACK_TAB:
            case SKILL_TAB:
            case QUEST_TAB:
            case INVENTORY_TAB:
            case EQUIPMENT_TAB:
            case PRAYER_TAB:
            case MAGIC_TAB:
            case CLAN_TAB:
            case FRIENDS_TAB:
            case IGNORES_TAB:
            case LOGOUT_TAB:
            case OPTIONS_TAB:
            case EMOTES_TAB:
            case MUSIC_TAB:
                player.getInterfaceManager().setCurrentTabIndex(getTabIndex(button));
                return true;
        }
        switch (button) {
            case OPTIONS_TAB:
                break;
            case INVENTORY_TAB:
                player.getInventory().refresh();
                break;
            case SKILL_TAB:
                break;
            case MUSIC_TAB:
                break;
            case EMOTES_TAB:
                break;
            case QUEST_TAB:
                player.getQuestRepository().update(player);
                break;
            case EQUIPMENT_TAB:
                break;
            case ATTACK_TAB:
                if (player.getExtension(WeaponInterface.class) == WeaponInterface.WeaponInterfaces.STAFF) {
                    final WeaponInterface inter = player.getExtension(WeaponInterface.class);
                    inter.updateInterface();
                }
                break;
            case PRAYER_TAB:
                break;
            case FRIENDS_TAB:
                break;
            case IGNORES_TAB:
                break;
            case MAGIC_TAB:
                break;
        }
        return true;
    }

    /**
     * Method used to open the report interface.
     *
     * @param player the player.
     */
    private static void openReport(final Player player) {
        player.getPacketDispatch().sendCS2Script(917, new Object[]{-1, -1});//ii
        player.getPacketDispatch().sendRunScript(1105, "");
        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 553, false);
        player.getPacketDispatch().sendCS2Script(1104, new Object[]{1,});//1s

    }

    /**
     * Gets the tab index.
     *
     * @param button The button id.
     * @return The tab index. TODO: ME
     */
    private static int getTabIndex(int button) {
        return button >= 47 ? (button - 47) : (button - 23);
    }
}
