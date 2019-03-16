package org.arcanium.game.interaction.widget;

import org.arcanium.cache.def.impl.ItemDefinition;
import org.arcanium.game.component.Component;
import org.arcanium.game.container.Container;
import org.arcanium.game.container.ContainerEvent;
import org.arcanium.game.container.ContainerListener;
import org.arcanium.game.container.access.BitregisterAssembler;
import org.arcanium.game.container.impl.EquipmentContainer;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.entity.combat.DeathTask;
import org.arcanium.game.node.entity.lock.Lock;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.audio.Audio;
import org.arcanium.game.node.entity.player.link.prayer.PrayerType;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.system.task.Pulse;
import org.arcanium.game.world.GameWorld;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.ContainerContext;
import org.arcanium.net.packet.server.PartialContainerPacket;

/**
 * Represents the equipment interface..
 *
 * @author Emperor
 * @version 1.1
 */
public final class EquipmentInterface {

    public static boolean handle(final Player player, Component component, int opcode, int button, final int slot, final int itemId) {
        if (component.getId() == 667) {
            if (button != 20) {
                return false;
            }
            switch (opcode) {
                case 230:
                    player.getPulseManager().clear();
                    GameWorld.submit(new Pulse(1, player) {
                        @Override
                        public boolean pulse() {
                            unequip(player, slot, itemId);
                            return true;
                        }
                    });
                    return true;
                case 205:
                    GameWorld.submit(new Pulse(1, player) {
                        @Override
                        public boolean pulse() {
                            operate(player, slot, itemId);
                            return true;
                        }
                    });
                    return true;
            }
            return false;
        }
        switch (component.getId()) {
            case 236:
                GameWorld.submit(new Pulse(1, player) {
                    @Override
                    public boolean pulse() {
                        operate(player, slot, itemId);
                        return true;
                    }
                });
                return true;
            case 387:
                switch (button) {
                    case 19: // Open Price Checker Interface
                        player.getPacketDispatch().sendCS2Script(917, new Object[]{-1, -1});//ii
                        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 464, false);
                        player.getPacketDispatch().sendCS2Script(785, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});//iiiiiiiiiiiiiiiiiiiiiiiiiiii
                        player.getPacketDispatch().sendCS2Script(600, new Object[]{1, 1, 15, 30408716});//iiiI
                        player.getPacketDispatch().sendString("Total guide price:<br><col=ffffff>0</col>", 464, 12);
                        player.getPacketDispatch().sendCS2Script(149, new Object[]{15597568, 93, 4, 7, 0, -1, "Add<col=ff9040>, Add-5<col=ff9040>, Add-10<col=ff9040>, Add-All<col=ff9040>, Add-X<col=ff9040>"});//IviiiIsssss
                        break;
                    case 21:
                        if (player.getInterfaceManager().isOpened() && player.getInterfaceManager().getOverlay().getId() == 4) {
                            return true;
                        }
                        boolean skulled = player.getSkullManager().isSkulled();
                        boolean usingProtect = player.getPrayer().get(PrayerType.PROTECT_ITEMS);
                        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 4, false);
                        player.getPacketDispatch().sendAccessMask(211, 0, 2, 6684690, 4);
                        player.getPacketDispatch().sendAccessMask(212, 0, 2, 6684693, 42);
                        Container[] itemArray = DeathTask.getContainers(player);
                        Container kept = itemArray[0];
                        int state = 0;
                        int keptItems = skulled ? (usingProtect ? 1 : 0) : (usingProtect ? 4 : 3);
                        int zoneType = player.getZoneMonitor().getType();
                        int pvpType = player.getSkullManager().isWilderness() ? 0 : 1;
                        Object[] params = new Object[]{11510, 12749, "", state, pvpType, kept.getId(3), kept.getId(2), kept.getId(1), kept.getId(0), keptItems, zoneType};
                        PacketRepository.send(PartialContainerPacket.class, new ContainerContext(player, 149, 0, 91, itemArray[1], false));
                        player.getPacketDispatch().sendRunScript(118, "iiooooiisii", params);
                        break;
                    case 28:
                        if (opcode == 133) {
                            player.getPulseManager().clear();
                            GameWorld.submit(new Pulse(1, player) {
                                @Override
                                public boolean pulse() {
                                    unequip(player, slot, itemId);
                                    return true;
                                }
                            });
                            return true;
                        }
                        break;
                    case 17:
                        if (player.getInterfaceManager().isOpened() && player.getInterfaceManager().getOpened().getId() == 84) {
                            return true;
                        }
                        final ContainerListener listener = new ContainerListener() {
                            @Override
                            public void update(Container c, ContainerEvent e) {
                                PacketRepository.send(PartialContainerPacket.class, new ContainerContext(player, -1, -1, 98, e.getItems(), false, e.getSlots()));
                            }

                            @Override
                            public void refresh(Container c) {
                                PacketRepository.send(PartialContainerPacket.class, new ContainerContext(player, -1, -1, 98, c, false));
                            }
                        };
                        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 84, false);
                        player.setAttribute("equip_stats_open", true);
                        EquipmentContainer.update(player);

                        player.getInterfaceManager().removeTabs(0, 1, 2, 5, 6, 7, 8, 9, 10, 11, 12, 13);
                        //player.getInterfaceManager().openTab(new Component(149));
                        player.getInventory().getListeners().add(listener);
                        player.getInventory().refresh();
                        ItemDefinition.statsUpdate(player);
                        player.getPacketDispatch().sendAccessMask(BitregisterAssembler.calculateRegister(2), 20, 84, 0, 13);
                        break;
                }
        }
        return true;
    }

    /**
     * Operates an item.
     *
     * @param player The player.
     * @param slot   The container slot.
     * @param itemId The item id.
     */
    public static void operate(Player player, int slot, int itemId) {
        if (slot < 0 || slot > 13) {
            return;
        }
        Item item = player.getEquipment().get(slot);
        if (item == null) {
            return;
        }
        OptionHandler handler = item.getOperateHandler();
        if (handler != null && handler.handle(player, item, "operate")) {
            return;
        }
        player.getPacketDispatch().sendMessage("You can't operate that.");
    }

    /**
     * Unequips an item.
     *
     * @param player the player.
     * @param slot   the slot.
     * @param itemId the item id.
     */
    public static void unequip(Player player, int slot, int itemId) {
        if (slot < 0 || slot > 13) {
            return;
        }
        Item item = player.getEquipment().get(slot);
        if (item == null) {
            return;
        }
        Lock lock = player.getLocks().getEquipmentLock();
        if (lock != null && lock.isLocked()) {
            if (lock.getMessage() != null) {
                player.getPacketDispatch().sendMessage(lock.getMessage());
            }
            return;
        }
        if (slot == EquipmentContainer.SLOT_WEAPON) {
            player.getPacketDispatch().sendString("", 92, 0);
        }
        int maximumAdd = player.getInventory().getMaximumAdd(item);
        if (maximumAdd < item.getAmount()) {
            player.getPacketDispatch().sendMessage("Not enough free space in your inventory.");
            return;
        }

        if (player.getEquipment().remove(item)) {
            player.getAudioManager().send(new Audio(2238, 10, 1));
            player.getDialogueInterpreter().close();
            player.getInventory().add(item);
        }
    }
}