package plugin.entity.player.skills.fletching;

import org.arcanium.game.interaction.NodeUsageEvent;
import org.arcanium.game.interaction.UseWithHandler;
import org.arcanium.plugin.Plugin;

import static org.arcanium.game.node.entity.player.link.CS2Repository.CRAFTING_SCRIPT;

/**
 * Represents the plugin used to open the fletching dialogue.
 *
 * @author 'Vexia
 * @version 1.0
 */
public class FletchingPlugin extends UseWithHandler {

    /**
     * Constructs a new {@code FletchingPlugin} {@code Object}.
     */
    public FletchingPlugin() {
        super(1511, 1521, 1519, 1517, 1515, 1513, 6332, 6333);
    }

    public enum FletchConfigs {

        TREE(1151, new Object[]{0, "What would you like to make?|30 arrow shafts|Shortbow|Longbow|Crossbow stock|Wooden shield|||||", 1, 52, 54, 56, 9442, 22251, -1, -1, -1, -1, -1, -1}),
        OAK(1521, new Object[]{0, "What would you like to make?|30 arrow shafts|Oak shortbow|Oak longbow|Crossbow stock|Oak shield|||||", 1, 52, 54, 56, 9442, 22251, -1, -1, -1, -1, -1, -1}),
        WILLOW(1519, new Object[]{2046, 0, "What would you like to make?|45 arrow shafts|Willow shortbow|Willow longbow|Crossbow stock|Willow shield|||||", 1, 52, 60, 58, 9444, 22254, -1, -1, -1, -1, -1, 1}),
        YEW(1517, new Object[]{2046, 0, "What would you like to make?|75 arrow shafts|Yew shortbow|Yew longbow|Crossbow stock|Yew shield|||||", 1, 52, 68, 66, 9452, 22260, -1, -1, -1, -1, -1, 1});

        /**
         * The config
         *
         * @param config
         */
        private final Object[] config;

        /**
         * The item id.
         */
        private final int itemId;

        private FletchConfigs(int id, Object[] config) {
            this.itemId = id;
            this.config = config;
        }

    }

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        addHandler(946, ITEM_TYPE, this);
        return this;
    }

    @Override
    public boolean handle(NodeUsageEvent event) {
        event.getPlayer().getVarBitManager().sendVarBit(5983, 1);
        event.getPlayer().getPacketDispatch().sendInterface(162, 561, 270, true);
        event.getPlayer().getPacketDispatch().sendCS2Script(CRAFTING_SCRIPT, new Object[]{0, "What would you like to make?|30 arrow shafts|Oak shortbow|Oak longbow|Crossbow stock|Oak shield|||||", 1, 52, 54, 56, 9442, 22251, -1, -1, -1, -1, -1, -1});
        return true;
    }
}