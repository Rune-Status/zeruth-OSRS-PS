package org.arcanium.game.world.map;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.GroundItem;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.world.map.build.DynamicRegion;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.BuildItemContext;
import org.arcanium.net.packet.context.BuildObjectContext;
import org.arcanium.net.packet.server.ClearObject;
import org.arcanium.net.packet.server.ConstructGroundItem;
import org.arcanium.net.packet.server.ConstructObject;
import org.arcanium.net.packet.server.zone.UpdateZonePartialFollows;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a region chunk.
 *
 * @author Emperor
 */
public class RegionChunk {

    /**
     * The chunk size.
     */
    public static final int SIZE = 8;

    /**
     * The base location of the copied region chunk.
     */
    protected Location base;

    /**
     * The current base location.
     */
    protected Location currentBase;

    /**
     * The region plane.
     */
    protected RegionPlane plane;

    /**
     * The items in this chunk.
     */
    protected List<Item> items;

    /**
     * The game objects in this chunk.
     */
    protected GameObject[][] objects;

    /**
     * The rotation.
     */
    protected int rotation;

    /**
     * The update flags.
     */
    private List<UpdateFlag<?>> flags = new ArrayList<>();

    /**
     * Constructs a new {@code RegionChunk} {@code Object}.
     *
     * @param base     The base location of the region chunk.
     * @param rotation The rotation.
     */
    public RegionChunk(Location base, int rotation, RegionPlane plane) {
        this.base = base;
        this.currentBase = base;
        this.rotation = rotation;
        this.plane = plane;
        this.objects = new GameObject[SIZE][SIZE];
    }

    /**
     * Copies the region chunk.
     *
     * @param plane The region plane.
     * @return The region chunk.
     */
    public RegionChunk copy(RegionPlane plane) {
        return new RegionChunk(base, rotation, plane);
    }

    /**
     * Registers an update flag.
     *
     * @param flag The flag.
     */
    public void flag(UpdateFlag<?> flag) {
        flags.add(flag);
    }

    /**
     * Clears the region chunk.
     */
    public void clear() {
        flags.clear();
        if (items != null && plane.getRegion() instanceof DynamicRegion) {
            items.clear();
            items = null;
        }
    }

    /**
     * Updates the region chunk.
     *
     * @param player The player.
     */
    public void synchronize(Player player) {
        IoBuffer buffer = UpdateZonePartialFollows.getChunkUpdateBuffer(player, currentBase.getChunkBase());
        int baseX = currentBase.getLocalX();
        int baseY = currentBase.getLocalY();
        int count = 0;
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                GameObject dyn = objects[x][y];
                if (dyn == null || plane.getObjects() == null) {
                    continue;
                }
                GameObject stat = plane.getObjects()[baseX + x][baseY + y];
                if (!dyn.isRenderable() && stat != null) {
                    PacketRepository.send(ClearObject.class, new BuildObjectContext(player, stat));
                    count++;
                } else if (dyn != stat) {
                    if (stat != null) {
                        PacketRepository.send(ClearObject.class, new BuildObjectContext(player, stat));
                    }
                    PacketRepository.send(ConstructObject.class, new BuildObjectContext(player, dyn));
                    count++;
                }
            }
        }
        if (items != null) {
            for (Item item : items) {
                if (item != null && item.isActive() && item.getLocation() != null) {
                    GroundItem g = (GroundItem) item;
                    if (!g.isPrivate() || g.droppedBy(player)) {
                        PacketRepository.send(ConstructGroundItem.class, new BuildItemContext(player, item));
                        count++;
                    }
                }
            }
        }
        if (count > 0) {
            player.getSession().write(buffer);
        }
    }

    /**
     * Sends all the update flags.
     */
    public void update(Player player) {
        if (isUpdated()) {
            IoBuffer buffer = UpdateZonePartialFollows.getChunkUpdateBuffer(player, currentBase.getChunkBase());
            for (UpdateFlag<?> flag : flags) {
                flag.writeDynamic(buffer, player);
            }
            player.getSession().write(buffer);
            this.synchronize(player);

        }
    }

    /**
     * Gets the items.
     *
     * @return The items.
     */
    public List<Item> getItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    /**
     * Sets the items.
     *
     * @param items The items to set.
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Gets the objects.
     *
     * @return The objects.
     */
    public GameObject[][] getObjects() {
        return objects;
    }

    /**
     * Sets the objects.
     *
     * @param objects The objects to set.
     */
    public void setObjects(GameObject[][] objects) {
        this.objects = objects;
    }

    /**
     * Gets the base.
     *
     * @return The base.
     */
    public Location getBase() {
        return base;
    }

    /**
     * Sets the base location of the region to copy.
     *
     * @param base The base location.
     */
    public void setBase(Location base) {
        this.base = base;
    }

    /**
     * Gets the rotation.
     *
     * @return The rotation.
     */
    public int getRotation() {
        return rotation;
    }

    /**
     * Sets the rotation of the region chunk.
     *
     * @param rotation The rotation
     */
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    /**
     * Gets the updated.
     *
     * @return The updated.
     */
    public boolean isUpdated() {
        return !flags.isEmpty();
    }

    /**
     * Resets the flags.
     */
    public void resetFlags() {
        flags.clear();
    }

    /**
     * Gets the region plane.
     *
     * @return The plane.
     */
    public RegionPlane getPlane() {
        return plane;
    }

    /**
     * Gets the currentBase.
     *
     * @return The currentBase.
     */
    public Location getCurrentBase() {
        return currentBase;
    }

    /**
     * Sets the currentBase.
     *
     * @param currentBase The currentBase to set.
     */
    public void setCurrentBase(Location currentBase) {
        this.currentBase = currentBase;
    }


}