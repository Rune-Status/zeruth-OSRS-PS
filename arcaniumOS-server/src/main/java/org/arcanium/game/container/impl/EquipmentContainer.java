package org.arcanium.game.container.impl;

import org.arcanium.game.container.Container;
import org.arcanium.game.container.ContainerEvent;
import org.arcanium.game.container.ContainerListener;
import org.arcanium.game.node.entity.combat.equipment.WeaponInterface;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.world.update.flag.player.AppearanceFlag;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.ContainerContext;
import org.arcanium.net.packet.server.FullContainerPacket;
import org.arcanium.net.packet.server.PartialContainerPacket;
import org.arcanium.net.packet.server.WeightUpdate;
import org.arcanium.parser.item.ItemConfiguration;

/**
 * Represents the equipment container.
 *
 * @author Emperor
 */
public final class EquipmentContainer extends Container {

    /**
     * The equipment slots.
     */
    public static final int SLOT_HAT = 0, SLOT_CAPE = 1, SLOT_AMULET = 2,
            SLOT_WEAPON = 3, SLOT_CHEST = 4, SLOT_SHIELD = 5, SLOT_LEGS = 7,
            SLOT_HANDS = 9, SLOT_FEET = 10, SLOT_RING = 12, SLOT_ARROWS = 13;

    /**
     * The bonus names.
     */
    /*
     * player.getPacketDispatch().sendString("Stab: +0", 84, 23);
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
     */
    private static final String[] BONUS_NAMES = {"Stab: ", "Slash: ", "Crush: ", "Magic: ", "Range: ", "Stab: ", "Slash: ", "Crush: ", "Range: ", "Magic: ", "Melee strength: ", "Ranged strength: ", "Magic damage: ", "Prayer: ", "Undead: ", "Slayer: "};

    /**
     * The player.
     */
    private final Player player;

    /**
     * Constructs a new {@code EquipmentContainer} {@code Object}.
     *
     * @param player The player.
     */
    public EquipmentContainer(Player player) {
        super(14);
        this.player = player;
        register(new EquipmentListener(player));
    }

    @Override
    public boolean add(Item item, boolean fire) {
        return add(item, fire, true);
    }

    /**
     * Adds an item to the equipment container.
     *
     * @param item          The item to add.
     * @param fire          If we should refresh.
     * @param fromInventory If the item is being equipped from the inventory.
     * @return {@code True} if succesful, {@code false} if not.
     */
    public boolean add(Item item, boolean fire, boolean fromInventory) {
        return add(item, player.getInventory().getSlot(item), fire, fromInventory);
    }

    /**
     * Adds an item to the equipment container.
     *
     * @param item          The item to add.
     * @param inventorySlot The inventory slot of the item.
     * @param fire          If we should refresh.
     * @param fromInventory If the item is being equipped from the inventory.
     * @return {@code True} if succesful, {@code false} if not.
     */
    public boolean add(Item item, int inventorySlot, boolean fire, boolean fromInventory) {
        int slot = item.getDefinition().getConfiguration(ItemConfiguration.EQUIP_SLOT, -1);
        if (slot == -1 && item.getDefinition().getConfiguration(ItemConfiguration.WEAPON_INTERFACE, -1) != -1) {
            slot = 3;
        }
        if (slot < 0) {
            return false; //Item can't be equipped.
        }
        if (!item.getDefinition().hasRequirement(player, true, true)) {
            return false;
        }
        Item current = super.get(slot);
        if (current != null && current.getId() == item.getId() && current.getDefinition().isStackable()) {
            int amount = getMaximumAdd(item);
            if (item.getAmount() > amount) {
                amount += current.getAmount();
            } else {
                amount = current.getAmount() + item.getAmount();
            }
            if (fromInventory) {
                player.getInventory().remove(new Item(item.getId(), amount - current.getAmount()));
            }
            replace(new Item(item.getId(), amount), slot);
            return true;
        }
        if (fromInventory && current != null) {
            //TODO removed plugin
        }
        if (fromInventory && !player.getInventory().remove(item, inventorySlot, true)) {
            return false;
        }
        Item secondary = null;
        if (item.getDefinition().getConfiguration(ItemConfiguration.TWO_HANDED, false)) {
            secondary = get(SLOT_SHIELD);
        } else if (slot == SLOT_SHIELD) {
            secondary = get(SLOT_WEAPON);
            if (secondary != null && !secondary.getDefinition().getConfiguration(ItemConfiguration.TWO_HANDED, false)) {
                secondary = null;
            }
        }
        int currentSlot = -1;
        if (current != null) {
            currentSlot = inventorySlot;
            if (current.getDefinition().isStackable() && player.getInventory().contains(current.getId(), 1)) {
                currentSlot = -1;
            }
        }
        if (current != null && !player.getInventory().add(current, true, inventorySlot)) {
            player.getInventory().add(item);
            player.getPacketDispatch().sendMessage("Not enough space in your inventory!");
            return false;
        }
        if (secondary != null && !player.getInventory().add(secondary)) {
            if (current != null && currentSlot != -1) {
                player.getInventory().remove(current, currentSlot, false);
            }
            player.getInventory().add(item);
            player.getPacketDispatch().sendMessage("Not enough space in your inventory!");
            return false;
        }
        super.replace(item, slot, fire);
        if (item.getSlot() == SLOT_WEAPON) {
            //player.getPacketDispatch().sendString(item.getName(), 92, 0);
        }
        if (secondary != null) {
            super.remove(secondary);
        }
        return true;
    }

    /**
     * Listens to the equipment container.
     *
     * @author Emperor
     */
    private static class EquipmentListener implements ContainerListener {

        /**
         * The player.
         */
        private final Player player;

        /**
         * Constructs a new {@code EquipmentContainer} {@code Object}.
         *
         * @param player The player.
         */
        public EquipmentListener(Player player) {
            this.player = player;
        }

        @Override
        public void update(Container c, ContainerEvent event) {
            int[] slots = event.getSlots(); //28 on 464 25 on 462
            PacketRepository.send(PartialContainerPacket.class, new ContainerContext(player, -1, 64208, 94, event.getItems(), false, slots));
            update(c);
            boolean updateDefenceAnimation = false;
            for (int slot : slots) {
                if (slot == EquipmentContainer.SLOT_WEAPON) {
                    player.getProperties().setAttackSpeed(c.getNew(slot).getDefinition().getConfiguration(ItemConfiguration.ATTACK_SPEED, 4));
                    WeaponInterface inter = player.getExtension(WeaponInterface.class);
                    if (inter == null) {
                        break;
                    }
                    inter.updateInterface();
                    updateDefenceAnimation = true;
                } else if (slot == EquipmentContainer.SLOT_SHIELD) {
                    updateDefenceAnimation = true;
                }
            }
            if (updateDefenceAnimation) {
                player.getProperties().updateDefenceAnimation();
            }
        }

        @Override
        public void refresh(Container c) {
            player.getProperties().setAttackSpeed(c.getNew(3).getDefinition().getConfiguration(ItemConfiguration.ATTACK_SPEED, 4));
            WeaponInterface inter = player.getExtension(WeaponInterface.class);
            if (inter != null) {
                inter.updateInterface();
            } //28 on 464 25 on 462
            PacketRepository.send(FullContainerPacket.class, new ContainerContext(player, -1, 64208, 94, c.toArray(), 14, false));
            update(c);
            player.getProperties().updateDefenceAnimation();
        }

        /**
         * Updates the bonuses, weight, animations, ...
         *
         * @param c The container.
         */
        public void update(Container c) {
            if (c.getNew(SLOT_SHIELD).getId() != 11283 && player.getAttribute("dfs_spec", false)) {
                player.removeAttribute("dfs_spec");
                player.getProperties().getCombatPulse().setHandler(null);
                if (!player.getSettings().isSpecialToggled()) {
                    player.getConfigManager().sendVarp(301, 0);
                }
            }
            player.getAppearance().setAnimations();
            player.getUpdateMasks().register(new AppearanceFlag(player));
            player.getSettings().updateWeight();
            updateBonuses(player);
        }
    }

    /**
     * Updates the bonuses.
     *
     * @param player The player.
     */
    public static void updateBonuses(Player player) {
        int[] bonuses = new int[16];
        for (Item item : player.getEquipment().toArray()) {
            if (item != null) {
                int[] bonus = item.getDefinition().getConfiguration(ItemConfiguration.BONUS, new int[16]);
                for (int i = 0; i < bonus.length; i++) {
                    if (i == 14 && bonuses[i] != 0) {
                        continue;
                    }
                    bonuses[i] += (int) bonus[i];
                }
            }
        }
        Item shield = player.getEquipment().get(SLOT_SHIELD);
        if (shield != null && shield.getId() == 11283) {
            int increase = shield.getCharge() / 20;
            bonuses[5] += increase;
            bonuses[6] += increase;
            bonuses[7] += increase;
            bonuses[9] += increase;
        }
        player.getProperties().setBonuses(bonuses);
        update(player);
    }

    /**
     * Updates the equipment stats interface.
     *
     * @param player The player to update for.
     */
    public static void update(Player player) {
        PacketRepository.send(WeightUpdate.class, player.getPacketDispatch().getContext());
        int index = 0;
        int[] bonuses = player.getProperties().getBonuses();
        for (int i = 23; i <= 41; i++) {
            if (i == 28 || i == 34 || i == 39) {
                continue;
            }
            int bonus = bonuses[index];
            String bonusValue = bonus > -1 ? ("+" + bonus) : Integer.toString(bonus);
            //System.out.println("id: " + i);
            player.getPacketDispatch().sendString(BONUS_NAMES[index++] + bonusValue, 84, i);
        }
    }
}