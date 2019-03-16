package plugin.interaction.object;

import org.arcanium.cache.def.impl.ObjectDefinition;
import org.arcanium.game.interaction.MovementPulse;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.plugin.Plugin;

/**
 * Represents the plugin to handle the bank booths
 *
 * @author trees
 */
public final class BankBoothPlugin extends OptionHandler {


    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        ObjectDefinition.setOptionHandler("bank", this);
        return this;
    }

    @Override
    public boolean handle(final Player player, final Node node, String option) {

        player.getPulseManager().run(new MovementPulse(player, node) {
            @Override
            public boolean pulse() {
                player.faceLocation(node.getLocation( ));
                player.getBank().open();
                return true;
            }
        }, "movement");
        return true;
    }

    @Override
    public boolean isWalk() {
        return true;
    }
}
