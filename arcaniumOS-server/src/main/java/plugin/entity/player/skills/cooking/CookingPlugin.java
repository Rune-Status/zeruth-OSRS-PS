package plugin.entity.player.skills.cooking;

import org.arcanium.game.content.global.consumable.Consumables;
import org.arcanium.game.content.global.consumable.Food;
import org.arcanium.game.interaction.NodeUsageEvent;
import org.arcanium.game.interaction.UseWithHandler;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.world.map.Direction;
import org.arcanium.game.world.map.Location;
import org.arcanium.plugin.Plugin;

/**
 * Represents the plugin used to handle the interaction of a cooking consumable
 * with a range/fire.
 *
 * @author 'Vexia
 */
public final class CookingPlugin extends UseWithHandler {

    /**
     * Represents the objects allowed to cook {@code Food} on.
     */
    private static final int[] OBJECTS = new int[]{26185, 7183, 114, 26180};

    /**
     * Constructs a new {@code CookingPlugin} {@code Object}.
     */
    public CookingPlugin() {
        super(2138, 2142, 2134, 3142, 2136, 1859, 3226, 7518, 3150, 327, 321, 345, 353, 335, 341, 349, 331, 3379, 359, 10138, 5001, 377, 363, 371, 2148, 7944, 383, 395, 389, 3363, 3365, 3367, 5986, 401, 1942, 4237, 2001, 7076, 1871, 7080, 2307, 1889, 2132, 2132, 2132, 2132, 2321, 2319, 7168, 2317, 7176, 7186, 7196, 7206, 7216, 2287, 317, 9986, 2876, 7566, 9984, 7224);
    }

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        for (int object : OBJECTS) {
            addHandler(object, OBJECT_TYPE, this);
        }
        return this;
    }

    @Override
    public boolean handle(NodeUsageEvent event) {
        final GameObject object = (GameObject) event.getUsedWith();
        final Food food = Consumables.forRaw(event.getUsedItem());
        if (food == null || !food.interact(event.getPlayer(), object)) {
            return true;
        }
        event.getPlayer().getDialogueInterpreter().open(43989, food, event.getUsedWith());
        return true;
    }

    @Override
    public Location getDestination(final Player player, final Node node) {
        if (node.getName().toLowerCase().equals("fire")) {
            return player.getLocation().getY() > node.getLocation().getY() ? node.getLocation().transform(0, 1, 0) : player.getLocation().getX() < node.getLocation().getX() ? node.getLocation().transform(-1, 0, 0) : player.getLocation().getX() > node.getLocation().getX() ? node.getLocation().transform(1, 0, 0) : node.getLocation().transform(0, -1, 0);
        } else {
            Direction direction = node.getDirection();
            if (direction == Direction.NORTH) {
                return node.getLocation().transform(1, 1, 0);
            } else if (direction == Direction.SOUTH) {
                return node.getLocation().transform(-1, 0, 0);
            }
            return null;
        }
    }

}
