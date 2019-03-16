package org.arcanium.game.container.impl;


import org.arcanium.game.component.Component;
import org.arcanium.game.container.*;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.IronmanMode;
import org.arcanium.game.node.item.Item;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.ContainerContext;
import org.arcanium.net.packet.server.FullContainerPacket;
import org.arcanium.parser.item.ItemConfiguration;

/**
 * Represents the osrs bank container.
 *
 * @author Emperor
 * @author trees
 */
public final class BankContainer extends Container {

    /**
     * The player reference.
     */
    private Player player;

    /**
     * The bank listener.
     */
    private final BankListener listener;

    /**
     * Set {@code true} to note items.
     */
    private boolean noteItems;

    /**
     * If the bank is open.
     */
    private boolean open;

    public static final int SIZE = 520;
    public static final int BANK_INTERFACE = 12;
    public static final int PLAYER_INVENTORY_INTERFACE = 15;

    /**
     * Construct a new {@code BankContainer} {@code Object}.
     *
     * @param player The player reference.
     */
    public BankContainer(Player player) {
        super(SIZE, ContainerType.ALWAYS_STACK, SortType.HASH);
        super.register(listener = new BankListener(player));
        this.player = player;
    }

    /**
     * Open the bank.
     */
    public void open() {
        if (open) {
            return;
        }
        if (player.getIronmanManager().checkRestriction(IronmanMode.ULTIMATE)) {
            return;
        }
        player.getInterfaceManager().close();
        player.getPacketDispatch().sendString("" + (800), BANK_INTERFACE, 18);
        player.getConfigManager().sendVarp(115, 0);
        player.getPacketDispatch().sendInterface(161, 13, BANK_INTERFACE, false);
        player.getPacketDispatch().sendInterface(161, 13, PLAYER_INVENTORY_INTERFACE, false);
        player.getPacketDispatch().sendCS2Script(1495, new Object[]{"Non-members' capacity: 400<br>+8 for your PIN<br>+8 for your Authenticator", 786487, 786450});// player
        player.getPacketDispatch().sendString("Bank of Arcanium", BANK_INTERFACE, 4);

        int[] tabItems = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int varpOne = 0;
        int varpTwo = 0;
        int varpThree = 0;

        varpOne += tabItems[0];
        varpOne += tabItems[1] << 10;
        varpOne += tabItems[2] << 20;

        varpTwo += tabItems[3];
        varpTwo += tabItems[4] << 10;
        varpTwo += tabItems[5] << 20;
        varpTwo += tabItems[6] << 30;

        varpThree += tabItems[7];
        varpThree += tabItems[8] << 10;
        varpThree += tabItems[9] << 20;

        if (false) {
            varpTwo += 1 << 30;//if placeholders are enabled
        }

        player.getConfigManager().sendVarp(867, varpOne);
        player.getConfigManager().sendVarp(867, varpOne);
        player.getConfigManager().sendVarp(867, varpOne);

        player.getConfigManager().sendVarp(1052, varpTwo);
        player.getConfigManager().sendVarp(1052, varpTwo);
        player.getConfigManager().sendVarp(1052, varpTwo);

        player.getConfigManager().sendVarp(1053, varpThree);
        player.getConfigManager().sendVarp(1053, varpThree);
        player.getConfigManager().sendVarp(1053, varpThree);

        sendBankAccessMasks(player);

        super.refresh();
        player.getInventory().getListeners().add(listener);
        player.getInventory().refresh();
        player.getInterfaceManager().openComponent(BANK_INTERFACE).setCloseEvent((player, c) -> {
            BankContainer.this.close();
            return true; //Return true so the component gets removed.
        });
        player.getInterfaceManager().openSingleTab(new Component(PLAYER_INVENTORY_INTERFACE));
        open = true;
        shift();
    }

    /**
     * Sends a series of interface settings to setup the bank system.
     *
     * @param player
     */
    public static void sendBankAccessMasks(Player player) {
        player.getPacketDispatch().sendInterfaceSettings(1311998, BANK_INTERFACE, 12, 0, 799);
        player.getPacketDispatch().sendInterfaceSettings(2, BANK_INTERFACE, 12, 809, 817);
        player.getPacketDispatch().sendInterfaceSettings(1048576, BANK_INTERFACE, 12, 818, 827);
        player.getPacketDispatch().sendInterfaceSettings(1048578, BANK_INTERFACE, 10, 10, 10);
        player.getPacketDispatch().sendInterfaceSettings(1179714, BANK_INTERFACE, 10, 11, 19);
        player.getPacketDispatch().sendInterfaceSettings(1181438, PLAYER_INVENTORY_INTERFACE, 3, 0, 27);
        player.getPacketDispatch().sendInterfaceSettings(1054, PLAYER_INVENTORY_INTERFACE, 12, 0, 27);
        player.getPacketDispatch().sendInterfaceSettings(2, BANK_INTERFACE, 32, 0, 3);
    }

    /**
     * Closes the bank.
     */
    public void close() {
        open = false;
        player.getInventory().getListeners().remove(listener);
        player.getInterfaceManager().closeSingleTab();
        //TODO: Add anything else for banking.
    }

    /**
     * Adds an item to the bank container.
     *
     * @param slot   The item slot.
     * @param amount The amount.
     */
    public void addItem(int slot, int amount) {
        if (slot < 0 || slot > player.getInventory().capacity() || amount < 1) {
            return;
        }
        Item item = player.getInventory().get(slot);
        if (item == null) {
            return;
        }
        int maximum = player.getInventory().getAmount(item);
        if (amount > maximum) {
            amount = maximum;
        }
        int maxCount = super.getMaximumAdd(item);
        if (amount > maxCount) {
            amount = maxCount;
            if (amount < 1) {
                player.getPacketDispatch().sendMessage("There is not enough space left in your bank.");
                return;
            }
        }
        if (!item.getDefinition().getConfiguration(ItemConfiguration.BANKABLE, true)) {
            player.sendMessage("A magical force prevents you from banking this item");
            return;
        }
        item = new Item(item.getId(), amount, item.getCharge());
        boolean unnote = !item.getDefinition().isUnnoted();
        if (player.getInventory().remove(item, slot, true)) {
            Item add = unnote ? new Item(item.getDefinition().getNoteId(), amount, item.getCharge()) : item;
            if (unnote && !add.getDefinition().isUnnoted()) {
                add = item;
            }
            super.add(add);
        }
    }

    /**
     * Takes a item from the bank container and adds one to the inventory container.
     *
     * @param slot   The slot.
     * @param amount The amount.
     */
    public void takeItem(int slot, int amount) {
        if (slot < 0 || slot > super.capacity() || amount <= 0) {
            return;
        }
        Item item = player.getBank().get(slot);
        if (item == null) {
            return;
        }
        if (amount > item.getAmount()) {
            amount = item.getAmount(); //It always stacks in the bank.
        }
        item = new Item(item.getId(), amount, item.getCharge());
        int noteId = item.getDefinition().getNoteId();
        Item add = noteItems && noteId > 0 ? new Item(noteId, amount, item.getCharge()) : item;
        int maxCount = player.getInventory().getMaximumAdd(add);
        if (amount > maxCount) {
            item.setAmount(maxCount);
            add.setAmount(maxCount);
            if (maxCount < 1) {
                player.getPacketDispatch().sendMessage("Not enough space in your inventory.");
                return;
            }
        }
        if (noteItems && noteId < 0) {
            player.getPacketDispatch().sendMessage("This item can't be withdrawn as a note.");
            add = item;
        }
        if (super.remove(item, slot, true)) {
            player.getInventory().add(add);
        }
    }

    /**
     * Checks if the item can be added.
     *
     * @param item the item.
     * @return {@code True} if so.
     */
    public boolean canAdd(Item item) {
        return item.getDefinition().getConfiguration(ItemConfiguration.BANKABLE, true);
    }

    /**
     * If items have to be noted.
     *
     * @return If items have to be noted {@code true}.
     */
    public boolean isNoteItems() {
        return noteItems;
    }

    /**
     * Set if items have to be noted.
     *
     * @param noteItems If items have to be noted {@code true}.
     */
    public void setNoteItems(boolean noteItems) {
        this.noteItems = noteItems;
    }

    /**
     * Listens to the bank container.
     *
     * @author Emperor
     */
    private static class BankListener implements ContainerListener {

        /**
         * The player reference.
         */
        private Player player;

        /**
         * Construct a new {@code BankListener} {@code Object}.
         *
         * @param player The player reference.
         */
        public BankListener(Player player) {
            this.player = player;
        }

        @Override
        public void update(Container c, ContainerEvent event) {
            if (c instanceof BankContainer) {
                PacketRepository.send(FullContainerPacket.class, new ContainerContext(player, -1, 64207, 95, event.getItems(), false, event.getSlots()));
            } else {
                PacketRepository.send(FullContainerPacket.class, new ContainerContext(player, -1, 64209, 93, event.getItems(), false, event.getSlots()));
            }
        }

        @Override
        public void refresh(Container c) {
            if (c instanceof BankContainer) {
                PacketRepository.send(FullContainerPacket.class, new ContainerContext(player, -1, 64207, 95, c.toArray(), c.capacity(), false));
            } else {
                PacketRepository.send(FullContainerPacket.class, new ContainerContext(player, -1, 64209, 93, c.toArray(), 28, false));
            }
        }
    }
}