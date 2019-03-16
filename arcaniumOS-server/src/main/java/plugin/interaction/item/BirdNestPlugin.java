package plugin.interaction.item;

import org.arcanium.game.content.global.BirdNest;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.plugin.Plugin;

/**
 * Handles the searching of a bird nest item.
 *
 * @author Vexia
 */
public final class BirdNestPlugin extends OptionHandler {

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        for (BirdNest nest : BirdNest.values()) {
            nest.getNest().getDefinition().getConfigurations().put("option:search", this);
        }
        return null;
    }

    @Override
    public boolean handle(Player player, Node node, String option) {
        final Item item = (Item) node;
        BirdNest.forNest(item).search(player, item);
        return true;
    }

    @Override
    public boolean isWalk() {
        return false;
    }
}
