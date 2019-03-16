package org.arcanium.game.world.update.flag.chunk;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.net.packet.IoBuffer;

import java.util.List;

/**
 * The object update flag.
 *
 * @author Emperor
 */
public class ObjectUpdateFlag extends UpdateFlag<Object> {

    /**
     * The object to update.
     */
    private final GameObject object;

    /**
     * If we should remove the object.
     */
    private final boolean remove;


    /**
     * Constructs a new {@code ObjectUpdateFlag} {@code Object}.
     *
     * @param object The object to update.
     * @param remove If we should remove the object.
     */
    public ObjectUpdateFlag(GameObject object, boolean remove) {
        super(null);
        this.object = object;
        this.remove = remove;
    }

    @Override
    public void write(IoBuffer buffer) {
        if (remove) {
            List<Player> players = RegionManager.getRegionPlayers(object.getLocation().getRegionId());
            for (Player player : players) {
                player.getPacketDispatch().sendObjectDelete(object);
                System.out.println("[ObjectUpdateFlag] [write] Running..");
            }
        } else {
            List<Player> players = RegionManager.getRegionPlayers(object.getLocation().getRegionId());
            for (Player player : players) {
                player.getPacketDispatch().sendObjectCreateChange(object);
                System.out.println("[ObjectUpdateFlag] [write] Running..");
            }
        }
    }

    @Override
    public int data() {
        return 0;
    }

    @Override
    public int ordinal() {
        return 0;
    }

}