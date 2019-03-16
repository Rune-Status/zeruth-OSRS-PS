package org.arcanium.net.packet.client;

import org.arcanium.ServerConstants;
import org.arcanium.game.container.Container;
import org.arcanium.game.content.global.action.DropItemHandler;
import org.arcanium.game.content.skill.f2p.magic.MagicSpell;
import org.arcanium.game.interaction.NodeUsageEvent;
import org.arcanium.game.interaction.Option;
import org.arcanium.game.interaction.UseWithHandler;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.SpellBookManager;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.world.GameWorld;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * The incoming item action packet.
 *
 * @author Emperor
 * @author trees
 */
public class ItemActionPacket implements ClientPacket {

    final int EQUIP_ITEM = 98;
    final int INTERFACE_ON_ITEM = 72;
    final int ITEM_OPTION_ONE = 87;
    final int ITEM_OPTION_TWO = 7;
    final int DROP_ITEM = 58;
    final int ITEM_ON_ITEM = 63;

    /**
     * Gets the container for the component id.
     *
     * @param player      The player.
     * @param componentId The component id.
     * @return The container.
     */
    private Container getContainer(Player player, int componentId) {
        switch (componentId) {
            case 149:
                return player.getInventory();
        }
        return null;
    }

    @SuppressWarnings("unused")
    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
        if (ServerConstants.DEBUG) {
            System.out.println("[Item Action Packet] Received Incoming Opcode : " + buffer.opcode());
        }
        if (player.getLocks().isInteractionLocked()) {
            return;
        }
        int item_used_on = -1;
        int usedWithSlot = -1;
        int interfaceHash1 = -1;
        int item_used_slot = -1;
        int childId1 = -1;
        int item_used = -1;
        int used_slot = -1;
        int interfaceHash2 = -1;
        int interfaceId2 = -1;
        int childId2 = -1;
        switch (buffer.opcode()) {
            case INTERFACE_ON_ITEM:

                int payload = buffer.getInt() & '\uffff';
                int component = buffer.getIntV1();
                //interfaceId1 = payload >> 16;
                int slot = buffer.getShort();

                if (slot < 0 || slot > 27) {
                    break;
                }

                Item item_m2 = player.getInventory().get(slot);

                System.out.println("Option usage [inter=" + payload + ", child=" + component + ", target=" + slot + ", item=" + item_m2.getName() + "].");

                if (item_m2 == null) {
                    break;
                }
                switch (payload) {
                    case SpellBookManager.MODERN_SPELLBOOK_INTERFACE:
                        if (player.getAttribute("magic:delay", -1) > GameWorld.getTicks()) {
                            break;
                        }
                        if (player.getDetails().getUsername().equalsIgnoreCase("1")) {
                            player.getPacketDispatch().sendMessage("Casting spell - [inter=" + payload + ", child=" + component + ", target=" + item_m2.getId() + "].");
                        }
                        MagicSpell.castSpell(player, SpellBookManager.SpellBook.MODERN, component, item_m2);
                        break;
                    default:
                        if (player.getDetails().getUsername().equalsIgnoreCase("1")) {
                            player.getPacketDispatch().sendMessage("Option usage [inter=" + payload + ", child=" + component + ", target=" + item_m2 + "].");
                        }
                }
                break;
            case ITEM_OPTION_ONE:
                item_used = buffer.getShortLE();
                item_used_on = buffer.getIntV1();
                used_slot = buffer.getShort();

                System.out.println("[ItemActionPacket] [OPHELD1] " + item_used);
                System.out.println("[ItemActionPacket] [OPHELD1] " + item_used_on);
                System.out.println("[ItemActionPacket] [OPHELD1] " + used_slot);

                if (ServerConstants.DEBUG) {
                    System.out.println("[Item Option One] Slot:" + used_slot + " ~ Item:" + item_used + " UPDATE_ZONE_FULL_FOLLOWS:" + item_used_on);
                }
                if (item_used > -1 && used_slot > -1) {
                    Container container = getContainer(player, 149);
                    if (container != null) {
                        handleItemInteraction(player, buffer.opcode(), item_used, used_slot, container);
                        return;
                    }
                }
                return;
            case ITEM_OPTION_TWO:
                used_slot = buffer.getInt() & '\uffff';
                item_used = buffer.getShort128();
                item_used_on = buffer.getShort();
                if (ServerConstants.DEBUG) {
                    System.out.println("[Item Option Two] Slot:" + used_slot + " ~ UPDATE_ZONE_FULL_FOLLOWS" + item_used + " UPDATE_ZONE_FULL_FOLLOWS" + item_used_on);
                }
                if (item_used > -1 && used_slot > -1) {
                    Container container = getContainer(player, 149);
                    if (container != null) {
                        handleItemInteraction(player, buffer.opcode(), player.getInventory().getId(used_slot), used_slot, container);
                        return;
                    }
                }
                return;
            case EQUIP_ITEM:
                item_used = buffer.getShort128();
                item_used_slot = buffer.getInt() & '\uffff';
                used_slot = buffer.getShortLE() - 128;
                if (ServerConstants.DEBUG) {
                    System.out.println("[Equip Item Packet] Slot:" + used_slot + " ~ Interface:" + item_used_slot + " UPDATE_ZONE_FULL_FOLLOWS" + item_used_on);
                }
                if (used_slot > -1) {
                    Container container = getContainer(player, 149);
                    if (container != null) {
                        player.getEquipment().add(new Item(item_used), true, true);

                        return;
                    }
                }
                break;
            case DROP_ITEM:
                System.out.println("Drop Item [item attempted to be dropped.]");

                int unknown_var = buffer.getInt();
                int dr_slot = buffer.getShort();
                int dr_item_id = buffer.getShort() & 0xFFFF;

                if (dr_slot < 0 || dr_slot > 27) {
                    break;
                }
                Item dr_item = player.getInventory().get(dr_slot);
                if (ServerConstants.DEBUG) {
                    System.out.println("Drop Item [item=" + dr_item_id + ", child=" + unknown_var + ", slot=" + dr_slot +/* ", item=" + dr_item.getName() + */"].");
                }
                DropItemHandler.drop(player, dr_item);
                break;
            case ITEM_ON_ITEM:
                int interface_ioi = buffer.getIntV1(); // correct
                interfaceHash1 = buffer.getIntV2(); // correct
                item_used_slot = buffer.getShortLEA(); // WRONG
                item_used = buffer.getShortLE();
                usedWithSlot = buffer.getShortLE();
                item_used_on = buffer.getShortLEA();

                if (ServerConstants.DEBUG) {
                    System.out.println("[Item on Item Data] Interface:" + interface_ioi + " ~ Item Used:" + item_used + " On Item:" + item_used_on);
                }
                Item used = player.getInventory().get(player.getInventory().getSlot(new Item(item_used)));
                Item with = player.getInventory().get(player.getInventory().getSlot(new Item(item_used_on)));
                if (used == null || with == null || used.getId() != item_used || with.getId() != item_used_on) {
                    return;
                }
                if (item_used < item_used_on) {
                    Item item = used;
                    used = with;
                    with = item;
                }
                NodeUsageEvent event = new NodeUsageEvent(player, item_used_slot, used, with);
                UseWithHandler.run(event);
                return;
            default:
                return;
        }
    }

    /**
     * Handles an item interaction.
     *
     * @param player    player.
     * @param opcode    opcode.
     * @param itemId    The item.
     * @param slot      The slot
     * @param container The container type
     */
    private static void handleItemInteraction(Player player, int opcode, int itemId, int slot, Container container) {
        if (slot < 0 || slot >= container.capacity()) {
            return;
        }
        Item item = container.get(slot);
        System.out.println("Item interaction (" + opcode + ") returning item " + item.getName() + " for slot " + slot);
        if (item == null || item.getId() != itemId) {
            return;
        }
        int index = 0;
        switch (opcode) {
            case 87: // First option
                index = 0;
                break;
            case 98: // Second option (wield/wear) // should be correct now
                index = 1;
                break;
            case 60: // Third option
                index = 2;
                break;
            case 93: // Fourth option
                index = 3;
                break;
            case 58: // Fifth option (drop/destroy) // should be correct now
                index = 4;
                break;
        }
        final Option option = item.getInteraction().get(index);
        System.out.println("System " + ((option == null ? "did not find" : "found {" + option.getHandler().getClass().getSimpleName() + "}") + " an option plugin for this item"));
        if (option == null || player.getLocks().isInteractionLocked()) {
            return;
        }
        System.out.println("PASSED OPTION NULL CATCHER ! Plugin = [ " + option.getHandler().toString() + "]");
        item.getInteraction().handleItemOption(player, option, container);
    }
}