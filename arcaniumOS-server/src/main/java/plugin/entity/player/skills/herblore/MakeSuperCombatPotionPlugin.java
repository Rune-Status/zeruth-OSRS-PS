package plugin.entity.player.skills.herblore;

import org.arcanium.game.content.dialogue.SkillDialogueHandler;
import org.arcanium.game.interaction.NodeUsageEvent;
import org.arcanium.game.interaction.UseWithHandler;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.plugin.Plugin;

/**
 * The plugin that creates the Super Combat potion.
 *
 * @author Empathy
 */
public class MakeSuperCombatPotionPlugin extends UseWithHandler {

    /**
     * The ingredients.
     */
    private static final int[] INGREDIENTS = new int[]{2436, 2442, 2440};

    /**
     * The base.
     */
    private static final Item BASE = new Item(2436);

    /**
     * The product.
     */
    private static final Item PRODUCT = new Item(14871);

    /**
     * Constructs a new @{Code MakeSuperCombatPotionPlugin} object.
     */
    public MakeSuperCombatPotionPlugin() {
        super(269, 2436, 2442, 2440);
    }

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        for (int i : INGREDIENTS) {
            addHandler(i, ITEM_TYPE, this);
        }
        return this;
    }

    @Override
    public boolean handle(NodeUsageEvent event) {
        final Player player = event.getPlayer();
        SkillDialogueHandler handler = new SkillDialogueHandler(player, SkillDialogueHandler.SkillDialogue.ONE_OPTION, PRODUCT) {
            @Override
            public void create(final int amount, int index) {
                /**
                 * TODO: add superCombatPulse
                 */
                //player.getPulseManager().run(new SuperCombatPulse(player, BASE, amount));
            }

            @Override
            public int getAll(int index) {
                return player.getInventory().getAmount(BASE);
            }

        };
        if (player.getInventory().getAmount(BASE) == 1) {
            handler.create(0, 1);
        } else {
            handler.open();
        }
        return true;
    }

}
