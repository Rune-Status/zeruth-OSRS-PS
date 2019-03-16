package org.arcanium.net.packet.client;

import org.arcanium.game.component.Component;
import org.arcanium.game.component.ComponentPlugin;
import org.arcanium.game.container.Container;
import org.arcanium.game.content.dialogue.DialogueAction;
import org.arcanium.game.interaction.Option;
import org.arcanium.game.interaction.widget.EquipmentInterface;
import org.arcanium.game.interaction.widget.GameInterface;
import org.arcanium.game.interaction.widget.LogoutInterface;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.info.login.LoginConfiguration;
import org.arcanium.game.node.item.Item;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.InterfaceContext;
import org.arcanium.net.packet.server.CloseInterface;

import java.util.List;

/**
 * The incoming action button packet.
 *
 * @author Emperor
 * @author trees
 */
public class ActionButtonPacket implements ClientPacket {

    @Override
    public void decode(final Player player, int opcode, IoBuffer buffer) {
        if (player == null) {
            return;
        }
        int[] args = getArguments(player, buffer);
        int componentId = args[0];
        int buttonId = args[1];
        int slot = args[2];
        int itemId = args[3];
        System.out.println("Component=" + componentId + ", button=" + buttonId + ", slot=" + slot + ", item=" + itemId + ", opcode=" + buffer.opcode());
        switch (componentId) {

            /**
             * Grand Exchange
             */
            case 383: // GE History Interface
                switch (buttonId) {
                    case 2:
                        player.getGrandExchange().open();
                        break;
                }
                break;
            case 465: // Main GE Interface
                switch (buttonId) {
                    case 3: // View GE History
                        player.getPacketDispatch().sendCS2Script(2524, new Object[]{-1, -1});//ii
                        //player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 149, true);
                        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 383, false);
                        player.getPacketDispatch().sendCS2Script(1644, new Object[]{});//
                        player.getPacketDispatch().sendCS2Script(1645, new Object[]{0, 373, 0, 50, 18500});//ioiii
                        player.getPacketDispatch().sendCS2Script(1645, new Object[]{1, 563, 1, 100, 20100});//ioiii
                        player.getPacketDispatch().sendCS2Script(1645, new Object[]{2, 1513, 1, 1000, 1103000});//ioiii
                        player.getPacketDispatch().sendCS2Script(1645, new Object[]{3, 2353, 1, 1000, 466000});//ioiii
                        player.getPacketDispatch().sendCS2Script(1645, new Object[]{4, 536, 1, 600, 1329366});//ioiii
                        player.getPacketDispatch().sendCS2Script(1645, new Object[]{5, 565, 1, 5000, 1075000});//ioiii
                        player.getPacketDispatch().sendCS2Script(1645, new Object[]{6, 560, 1, 2000, 452000});//ioiii
                        player.getPacketDispatch().sendCS2Script(1645, new Object[]{7, 157, 1, 3, 4401});//ioiii
                        player.getPacketDispatch().sendCS2Script(1645, new Object[]{8, 12213, 1, 1, 49718});//ioiii
                        player.getPacketDispatch().sendCS2Script(1645, new Object[]{9, 12207, 1, 1, 57701});//ioiii
                        player.getPacketDispatch().sendCS2Script(1646, new Object[]{});//
                        break;
                }
                break;

            /**
             * Clan Chat Tab
             */
            case 7:
                switch (buttonId) {
                    case 23: // Open Clan Setup
                        player.getConfigManager().sendVarp(1021, 0);
                        player.getPacketDispatch().sendString("Any friends", 94, 13);
                        player.getPacketDispatch().sendString("Any friends", 94, 16);
                        player.getPacketDispatch().sendString("Only me", 94, 19);
                        player.getPacketDispatch().sendString("F2p", 94, 10);
                        player.getPacketDispatch().sendCS2Script(917, new Object[]{-1, -1});//ii
                        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 94, false);

                        break;
                }
                break;
            /**
             * Equipment Sidebar
             */
            case 387:
                switch (buttonId) {

                    case 17: // Open Equipment Interface
                        player.getPacketDispatch().sendCS2Script(917, new Object[]{-1, -1});//ii
                        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 84, false);
                        player.getPacketDispatch().sendCS2Script(149, new Object[]{5570560, 93, 4, 7, 1, -1, "Equip, , , , "});//IviiiIsssss
                        player.getPacketDispatch().sendString("Stab: +0", 84, 23);
                        player.getPacketDispatch().sendString("Slash: +0", 84, 24);
                        player.getPacketDispatch().sendString("Crush: +0", 84, 25);
                        player.getPacketDispatch().sendString("Magic: +0", 84, 26);
                        player.getPacketDispatch().sendString("Range: +0", 84, 27);
                        player.getPacketDispatch().sendString("Stab: +0", 84, 29);
                        player.getPacketDispatch().sendString("Slash: +0", 84, 30);
                        player.getPacketDispatch().sendString("Crush: +0", 84, 31);
                        player.getPacketDispatch().sendString("Range: +0", 84, 33);
                        player.getPacketDispatch().sendString("Magic: +0", 84, 32);
                        player.getPacketDispatch().sendString("Melee strength: +0", 84, 35);
                        player.getPacketDispatch().sendString("Ranged strength: +0", 84, 36);
                        player.getPacketDispatch().sendString("Magic damage: +0.0%", 84, 37);
                        player.getPacketDispatch().sendString("Prayer: +0", 84, 38);
                        player.getPacketDispatch().sendString("Undead: 0%", 84, 40);
                        player.getPacketDispatch().sendString("Slayer: 0%", 84, 41);
                        break;

                    case 19: // Open Price Checker Interface
                        player.getPacketDispatch().sendCS2Script(917, new Object[]{-1, -1});//ii
                        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 464, false);
                        //player.getPacketDispatch().sendInterface(164, 21, 238, false);
                        player.getPacketDispatch().sendCS2Script(785, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});//iiiiiiiiiiiiiiiiiiiiiiiiiiii
                        player.getPacketDispatch().sendCS2Script(600, new Object[]{1, 1, 15, 30408716});//iiiI
                        player.getPacketDispatch().sendString("Total guide price:<br><col=ffffff>0</col>", 464, 12);
                        player.getPacketDispatch().sendCS2Script(149, new Object[]{15597568, 93, 4, 7, 0, -1, "Add<col=ff9040>, Add-5<col=ff9040>, Add-10<col=ff9040>, Add-All<col=ff9040>, Add-X<col=ff9040>"});//IviiiIsssss

                        // TODO SEND DUMMY ITEM BELOW (Doesnt do shit)
                        player.getPacketDispatch().sendCS2Script(785, new Object[]{5284, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});//iiiiiiiiiiiiiiiiiiiiiiiiiiii
                        player.getPacketDispatch().sendCS2Script(600, new Object[]{1, 1, 15, 30408716});//iiiI
                        player.getPacketDispatch().sendString("Total guide price:<br><col=ffffff>trees was here</col>", 464, 12);
                        break;
                    case 21: // Open Items On Death
                        player.getPacketDispatch().sendCS2Script(917, new Object[]{-1, -1});//ii
                        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 4, false);
                        player.getPacketDispatch().sendCS2Script(118, new Object[]{0, 3, 0, 0, 3, "gp"});//isii1s
                        break;
                }
                break;

            /**
             * Settings SideBar
             */
            case 261:
                switch (buttonId) {
                    case 35: // Advanced Settings
                        System.out.println("Sending Advanced Settings");
                        player.getPacketDispatch().sendCS2Script(917, new Object[]{-1, -1});
                        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 60, false);
                        break;
                    case 83: // Open F-Keys Interface
                        player.getConfigManager().sendVarp(1226, 12);
                        player.getPacketDispatch().sendCS2Script(917, new Object[]{-1, -1});//ii
                        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 121, false);
                        break;
                    case 75: // Display Name Change
                        System.out.println("Sending Display Name Change");
                        player.getConfigManager().sendVarp(1042, 0);
                        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 589, false);
                        player.getPacketDispatch().sendCS2Script(635, new Object[]{});//s
                        player.getPacketDispatch().sendString("Next free change:", 589, 6);
                        player.getPacketDispatch().sendString("---", 589, 7);
                        player.getPacketDispatch().sendString("Extra changes: <col=ffb83f>-</col>", 589, 8);
                        player.getPacketDispatch().sendString("Loading...", 589, 15);
                        player.getConfigManager().sendVarp(1042, 8);
                        player.getConfigManager().sendVarp(1042, 9);
                        player.getPacketDispatch().sendString("Next free change:", 589, 6);
                        player.getPacketDispatch().sendString("Now!", 589, 7);
                        player.getPacketDispatch().sendString("Extra changes: <col=ffb83f>0</col>", 589, 8);
                        player.getPacketDispatch().sendString("", 589, 15);
                        break;
                    case 100: // Open Bond Menu
                        player.getConfigManager().sendVarp(1780, 5);
                        player.getConfigManager().sendVarp(1781, 1);
                        player.getPacketDispatch().sendCS2Script(917, new Object[]{-1, -1});//ii
                        player.getPacketDispatch().sendCS2Script(2498, new Object[]{1, 1});//i1
                        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 65, false);
                        player.getPacketDispatch().sendCS2Script(2276, new Object[]{0});//i
                        player.getPacketDispatch().sendCS2Script(733, new Object[]{0, 0, 0, 0, 0, 0, 0, 0});//iiiiiiii
                        break;
                }
                break;

            /**
             * World Map
             */
            case 595:
                switch (buttonId) {
                    case 37:
                        PacketRepository.send(CloseInterface.class, new InterfaceContext(player, player.getInterfaceManager().getWindowsPane(), 22, 595, true));
                        break;
                }
                break;

            /**
             * Login Screen
             */
            case 378:
                switch (buttonId) {
                    case 81:
                        LoginConfiguration.configureGameWorld(player);
                        PacketRepository.send(CloseInterface.class, new InterfaceContext(player, 165, 27, 378, false));
                        break;
                }
                break;

        }
        if (player.getDialogueInterpreter().getDialogue() != null && buffer.opcode() != 76 && componentId != player.getInterfaceManager().getWindowsPane()) {
            player.getDialogueInterpreter().close();
        }
        if (player.getLocks().isComponentLocked()) {
            return;
        }
        if (itemId > -1 && slot > -1) {
            Container container = getContainer(player, componentId);
            if (container != null) {
                handleItemInteraction(player, buffer.opcode(), itemId, slot, container);
                return;
            }
        }
        if (player.getZoneMonitor().clickButton(componentId, buttonId, slot, itemId, opcode)) {
            return;
        }
        Component c = player.getInterfaceManager().getComponent(componentId);
        if (c == null) {
            return;
        }
        ComponentPlugin plugin = c.getPlugin();
        if (plugin != null) {
            plugin.handle(player, c, buffer.opcode(), buttonId, slot, itemId);
        }
        handleWidgets(player, c, buffer.opcode(), buttonId, slot, itemId);
    }

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

    /**
     * Gets the arguments for the action button.
     *
     * @param playerThe player.
     * @param buffer    The buffer.
     * @return The arguments [component, button, slot, item]
     */
    private static int[] getArguments(Player player, IoBuffer buffer) {
        int data = -1;
        int componentId = -1;
        int buttonId = -1;
        int itemId = -1;
        int slot = -1;

        switch (buffer.opcode()) {
            case 17:
                slot = buffer.getShort128();
                data = buffer.getIntV1();
                itemId = buffer.getShortLE();
                componentId = (data >> 16) & 0xFFFF;
                buttonId = data & 0xFFFF;
                System.out.println(slot + ", " + itemId + ", " + buttonId);
                break;
            case 0:
                slot = buffer.getShortLE();
                itemId = buffer.getShortLEA();
                data = buffer.getLEInt();
                componentId = (data >> 16) & 0xFFFF;
                buttonId = data & 0xFFFF;
                break;
            case 93:
                itemId = buffer.getShortLE();
                slot = buffer.getShortLEA();
                data = buffer.getIntV1();
                componentId = (data >> 16) & 0xFFFF;
                buttonId = data & 0xFFFF;
                break;
            case 171:
                data = buffer.getLEInt();
                componentId = (data >> 16) & 0xFFFF;
                buttonId = data & 0xFFFF;
                itemId = buffer.getShortLEA();
                slot = buffer.getShortLE();
                break;
            case 20:
                itemId = buffer.getShort();
                data = buffer.getLEInt();
                slot = buffer.getShort();
                componentId = (data >> 16) & 0xFFFF;
                buttonId = data & 0xFFFF;
                break;
            case 18:
                data = buffer.getInt();
                itemId = buffer.getShortLE();
                componentId = (data >> 16) & 0xFFFF;
                buttonId = data & 0xFFFF;
                if (player.getDialogueInterpreter().getDialogue() == null && player.getDialogueInterpreter().getDialogueStage() == null) {
                    player.getInterfaceManager().closeChatbox();
                    List<DialogueAction> actions = player.getDialogueInterpreter().getActions();
                    if (actions.size() > 0) {
                        DialogueAction action = actions.get(0);
                        action.handle(player, buttonId);
                        actions.remove(action);
                        actions.clear();
                    }
                    break;
                }
                player.getDialogueInterpreter().handle(componentId, buttonId);
                System.out.println(componentId + " , " + buttonId + ", " + itemId);
                break;
            case 68:
                data = buffer.getInt();
                componentId = (data >> 16) & 0xFFFF;
                buttonId = data & 0xFFFF;
                break;
            case 30:
                data = buffer.getInt();
                componentId = (data >> 16) & 0xFFFF;
                buttonId = data & 0xFFFF;
                buffer.getShort();
                slot = buffer.getShort();
                if (componentId == 49) {
                    if (player.getDialogueInterpreter().getDialogue() == null && player.getDialogueInterpreter().getDialogueStage() == null) {
                        player.getInterfaceManager().closeChatbox();
                        return null;
                    }
                    player.getDialogueInterpreter().getDialogue().handle(componentId, buttonId);
                }
                break;
        }
        return new int[]{componentId, buttonId, slot, itemId};
    }

    /**
     * Handles an item interaction.
     *
     * @param playerThe player.
     * @param opcodeThe opcode.
     * @param item      The item.
     */
    private static void handleItemInteraction(Player player, int opcode, int itemId, int slot, Container container) {
        if (slot < 0 || slot >= container.capacity()) {
            return;
        }
        Item item = container.get(slot);
        if (item == null || item.getId() != itemId) {
            return;
        }
        int index = 0;
        switch (opcode) {
            case 99: // First option
                index = 0;
                break;
            case 64: // Second option (wield/wear)
                index = 1;
                break;
            case 60: // Third option
                index = 2;
                break;
            case 93: // Fourth option
                index = 3;
                break;
            case 61: // Fifth option (drop/destroy)
                index = 4;
                break;
        }
        final Option option = item.getInteraction().get(index);
        if (option == null || player.getLocks().isInteractionLocked()) {
            return;
        }
        item.getInteraction().handleItemOption(player, option, container);
    }

    public static void handleWidgets(Player player, Component component, int opcode, int button, int slot, int itemId) {
        GameInterface.handle(player, component, opcode, button, slot, itemId);
        LogoutInterface.handle(player, component, opcode, button, slot, itemId);
        EquipmentInterface.handle(player, component, opcode, button, slot, itemId);
    }

}