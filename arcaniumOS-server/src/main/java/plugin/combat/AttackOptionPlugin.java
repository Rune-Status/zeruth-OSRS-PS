package plugin.combat;

import org.arcanium.cache.def.impl.NPCDefinition;
import org.arcanium.game.interaction.Option;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.plugin.Plugin;

/**
 * Represents the attack option plugin handler.
 *
 * @author Emperor
 * @version 1.0
 */
public final class AttackOptionPlugin extends OptionHandler {

    @Override
    public boolean handle(Player player, Node node, String option) {
        System.out.println("[AttackOptionPlugin] : handling attack!");
        player.attack(node);
        return true;
    }

    @Override
    public boolean isWalk() {
        System.out.println("[AttackOptionPlugin] : Checking walk..");
        return true;
    }

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        Option._P_ATTACK.setHandler(this);
        NPCDefinition.setOptionHandler("attack", this);
        //System.out.println("[AttackOptionPlugin] " + Option._P_ATTACK.toString() + " : Setting option handler 'attack'..");
        return this;
    }

    @Override
    public boolean isDelayed(Player player) {
        return false;
    }

}
