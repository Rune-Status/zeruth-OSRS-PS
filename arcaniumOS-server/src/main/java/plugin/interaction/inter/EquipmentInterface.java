package plugin.interaction.inter;

import org.arcanium.cache.def.impl.ItemDefinition;
import org.arcanium.game.component.Component;
import org.arcanium.game.component.ComponentDefinition;
import org.arcanium.game.component.ComponentPlugin;
import org.arcanium.game.content.global.action.EquipHandler;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.system.task.Pulse;
import org.arcanium.game.world.GameWorld;
import org.arcanium.plugin.Plugin;

/**
 * Represents the equipment interface..
 *
 * @author Emperor
 * @author trees
 */
public final class EquipmentInterface extends ComponentPlugin {

    public static enum SlotData {

        WEAPON(9, 3, "weapon"),

        CHEST(10, 4, "torso"),

        HELMET(6, 0, "helmet"),

        LEGS(12, 7, "legs"),

        SHIELD(11, 5, "shield"),

        AMULET(8, 2, "amulet"),

        BOOTS(14, 10, "boots"),

        RING(15, 12, "ring"),

        GLOVES(13, 9, "gloves"),

        CAPE(7, 1, "cape"),

        AMMO(16, 13, "ammo");

        int button, slot;

        SlotData(int button, int slot, String slot_name) {
            this.button = button;
            this.slot = slot;
        }

        public int getButton() {
            return button;
        }

        public int getSlot() {
            return slot;
        }


        public static SlotData getSlotFor(int button) {
            for (SlotData item : SlotData.values()) {
                if (button == item.getButton()) {
                    return item;
                }
            }
            return null;
        }

    }

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        ComponentDefinition.put(387, this);
        ComponentDefinition.put(84, this);
        ComponentDefinition.put(513, this);
        return this;
    }

    @Override
    public boolean handle(final Player p, Component component, int opcode, int button, final int slot, final int itemId) {
        /**
         * Equipment Screen
         */
        if (component.getId() == 84) {
            switch (opcode) {
                case 68:
                    System.out.println("Removing equipment...");
                    p.getPulseManager().clear();
                    GameWorld.submit(new Pulse(1, p) {
                        @Override
                        public boolean pulse() {
                            EquipHandler.unequip(p, slot, itemId);
                            System.out.println("-> Unequipped " + ItemDefinition.forId(itemId).getName());
                            return true;
                        }
                    });
                    return true;
            }
            return true;
        }
        /**
         * Equipment Tab
         */
        if (component.getId() == 387) {
            if (button >= 1 && button <= 22) {
                System.out.println("Removing equipment...");
                if (opcode == 68) {
                    p.getPulseManager().clear();
                    GameWorld.submit(new Pulse(1, p) {
                        @Override
                        public boolean pulse() {
                            if (SlotData.getSlotFor(button) != null) {
                                EquipHandler.unequip(p, SlotData.getSlotFor(button).getSlot(), itemId);
                                System.out.println("-> Unequipped " + ItemDefinition.forId(itemId).getName());
                            }
                            return true;
                        }
                    });
                    return true;
                }
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
    public void operate(Player player, int slot, int itemId) {
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

}
