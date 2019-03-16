package org.arcanium.game.node.entity.player.info.login;

import org.arcanium.game.component.Component;
import org.arcanium.game.content.activity.ActivityManager;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.InterfaceSetManager;
import org.arcanium.game.node.entity.player.link.SpellBookManager;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.repository.Repository;

/**
 * Sends the login configuration packets.
 *
 * @author Emperor
 */
public final class LoginConfiguration {

    /**
     * Represents the quest point items to remove.
     */
    private static final Item[] QUEST_ITEMS = new Item[]{new Item(9813), new Item(9814)};

    /**
     * Constructs a new {@Code LoginConfiguration} {@Code Object}
     */
    public LoginConfiguration() {
        /**
         * empty.
         */
    }

    /**
     * Configures the game world.
     *
     * @param player The player.
     */
    public static void configureGameWorld(final Player player) {
        player.getInterfaceManager().close();
        player.getConfigManager().sendVarpReset();
        Repository.getLobbyPlayers().remove(player);
        player.setPlaying(true);
        sendGameConfiguration(player);
        player.getConfigManager().sendVarp(1055, 256);
        player.getPacketDispatch().sendCS2Script(917, new Object[]{-1, -1});
    }

    /**
     * Sends the game configuration packets.
     *
     * @param player The player to send to.
     */
    public static void sendGameConfiguration(final Player player) {
        player.getInterfaceManager().openWindowsPane(new Component(548));
        InterfaceSetManager.sendSets(player, player.getDetails().getClientInfo().getWindowMode() + 2);
        player.getInterfaceManager().openRootChatbox();
        player.getConfigManager().sendVarp(1055, 147972);
        player.getPacketDispatch().sendCS2Script(1080, new Object[]{"jj"});
        player.getInterfaceManager().openDefaultTabs();
        config(player);
        conditions(player);
        player.getCommunication().sync(player);
    }

    /**
     * Method used to configure all possible settings for the player.
     *
     * @param player the player.
     */
    public static final void config(final Player player) {
        player.getInventory().refresh();
        player.getEquipment().refresh();
        player.getSkills().refresh();
        player.getSkills().configure();
        player.getSettings().update();
        player.getInteraction().setDefault();
        player.getPacketDispatch().sendRunEnergy();
        player.getEmotes().refreshListConfigs();
        player.getInterfaceManager().openDefaultTabs();
        player.getSpellBookManager().update(player);
        player.getPacketDispatch().sendString("Friends List - World " + GameWorld.getSettings().getWorldId(), 429, 2);
        if (player.getAttributes().containsKey("spell:swap")) {
            player.getSpellBookManager().setSpellBook(SpellBookManager.SpellBook.LUNAR);
        }
        player.getConfigManager().init();
        player.getQuestRepository().update(player);
        //player.getMonitor().getActivityMonitor().monitor(player);
    }

    /**
     * Method used to check for all possible conditions on login.
     *
     * @param player the player.
     */
    public static final void conditions(final Player player) {
        player.unlock();
        if (player.isArtificial()) {
            return;
        }
        if (player.getAttribute("fc_wave", -1) > -1) {
            ActivityManager.start(player, "fight caves", true);
        }
        if (player.getAttribute("falconry", false)) {
            ActivityManager.start(player, "falconry", true);
        }
        /**
         * this works! sets quest in quest tab as in progress =]
         */
        player.getConfigManager().set(678, 5);//RFD

        if (player.getSavedData().getQuestData().getDragonSlayerAttribute("repaired")) {
            player.getConfigManager().sendVarp(177, 1967876);
        }
        checkQuestPointsItems(player);
    }

    /**
     * Method used to check for the quest point cape items.
     *
     * @param player the player.
     */
    private static void checkQuestPointsItems(final Player player) {
        if (!player.getQuestRepository().hasCompletedAll() && player.getEquipment().contains(9813, 1) || player.getEquipment().contains(9814, 1)) {
            for (Item i : QUEST_ITEMS) {
                if (player.getEquipment().remove(i)) {
                    player.getDialogueInterpreter().sendItemMessage(i, "As you no longer have completed all the quests, your " + i.getName() + " unequips itself to your " + (player.getInventory().freeSlots() < 1 ? "bank" : "inventory") + "!");
                    if (player.getInventory().freeSlots() < 1) {
                        player.getBank().add(i);
                    } else {
                        player.getInventory().add(i);
                    }
                }
            }
        }
    }
}