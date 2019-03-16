package plugin.interaction.object;

import org.arcanium.cache.def.impl.ObjectDefinition;
import org.arcanium.game.interaction.MovementPulse;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.impl.ForceMovement;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.audio.Audio;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.update.flag.context.Animation;
import org.arcanium.plugin.Plugin;

/**
 * Represents the plugin to handle the crossing.
 *
 * @author 'Vexia
 * @author trees
 */
public final class WildernessDitchPlugin extends OptionHandler {

    /**
     * The animation.
     */
    private static final Animation ANIMATION = Animation.create(6132);

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        ObjectDefinition.forId(23271).getConfigurations().put("option:cross", this);
        //PluginManager.definePlugin(new WildernessInterfacePlugin());
        return this;
    }

    @Override
    public boolean handle(final Player player, final Node node, String option) {
        if (player.getLocation().getDistance(node.getLocation()) < 3) {
            handleDitch(player);
        } else {
            player.getPulseManager().run(new MovementPulse(player, node) {
                @Override
                public boolean pulse() {
                    handleDitch(player);
                    return true;
                }
            }, "movement");
        }
        return true;
    }

    /**
     * Method used to handle the ditch interface.
     *
     * @param player the player.
     */
    public static void handleDitch(final Player player) {
        GameObject ditch = player.getAttribute("wildy_ditch");
        if (ditch == null) {
            return;
        }

        player.removeAttribute("wildy_ditch");
        Location l = ditch.getLocation();
        int x = player.getLocation().getX();
        int y = player.getLocation().getY();
        if (ditch.getRotation() % 2 == 0) {
            if (y <= l.getY()) {
                ForceMovement.run(player, Location.create(x, l.getY() - 1, 0), Location.create(x, l.getY() + 2, 0), ANIMATION, 20).setEndAnimation(null);
            } else {
                ForceMovement.run(player, Location.create(x, l.getY() + 2, 0), Location.create(x, l.getY() - 1, 0), ANIMATION, 20).setEndAnimation(null);
            }
        } else {
            if (x > l.getX()) {
                ForceMovement.run(player, Location.create(l.getX() + 2, y, 0), Location.create(l.getX() - 1, y, 0), ANIMATION, 20).setEndAnimation(null);
            } else {
                ForceMovement.run(player, Location.create(l.getX() - 1, y, 0), Location.create(l.getX() + 2, y, 0), ANIMATION, 20).setEndAnimation(null);
            }
        }
        player.getAudioManager().send(new Audio(2462, 10, 30));
    }

    @Override
    public boolean isWalk() {
        return true;
    }
}
