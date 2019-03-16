package org.arcanium.game.content.global.action;

import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.audio.Audio;
import org.arcanium.game.node.item.GroundItemManager;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.system.SystemLogger;
import org.arcanium.game.world.GameWorld;
import org.arcanium.parser.player.PlayerParser;

/**
 * Handles the dropping of an item.
 *
 * @author Vexia
 */
public final class DropItemHandler {

    /**
     * Handles the droping of an item.
     *
     * @param player the player.
     * @param node   the node.
     * @param option the option.
     * @return {@code True} if so.
     */
    public static boolean handle(final Player player, Node node, String option) {
        Item item = (Item) node;
        if (item.getSlot() == -1) {
            player.getPacketDispatch().sendMessage("Invalid slot!");
            return false;
        }
        switch (option) {
            case "drop":

            case "destroy":
                if (!player.getInterfaceManager().close()) {
                    return true;
                }
                player.getDialogueInterpreter().close();
                player.getAudioManager().send(new Audio(2393, 0, 0));
                player.getPulseManager().clear();
                if (option.equalsIgnoreCase("destroy")) {
                    player.getDialogueInterpreter().open(9878, item);
                    return true;
                }
                if (player.getAttribute("equipLock:" + item.getId(), 0) > GameWorld.getTicks()) {
                    SystemLogger.log(player + ", tried to do the drop & equip dupe.");
                    return true;
                }
                //Temp; players don't usually drop 50k+ coins at all, so this is a good catch
                if (item.getId() == 995 && item.getAmount() >= 50000) {
                    SystemLogger.log(player.getUsername() + " dropped " + item.getAmount() + " coins at [" + player.getLocation().getX() + ", " + player.getLocation().getY() + "].");
                }
                if (player.getInventory().replace(null, item.getSlot()) == item) {
                    player.getAudioManager().send(new Audio(item.getId() == 995 ? 10 : 2739, 1, 0));
                    // if (!player.getDetails().getRights().equals(Rights.ADMINISTRATOR), false)) {//TODO: ADD BACK
                    GroundItemManager.create(item, player.getLocation(), player);
                    PlayerParser.dump(player);
                    // }
                } else {
                    GroundItemManager.create(item, player.getLocation(), player).setDecayTime(99);
                    PlayerParser.dump(player);
                }
                player.setAttribute("droppedItem:" + item.getId(), GameWorld.getTicks() + 2);
                return true;
        }
        return false;
    }

    /**
     * Drops an item.
     *
     * @param player the player.
     * @param item   the item.
     * @return
     */
    public static boolean drop(Player player, Item item) {
        return handle(player, item, item.getDefinition().hasDestroyAction() ? "destroy" : "drop");
    }
}
