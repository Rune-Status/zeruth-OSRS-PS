package org.arcanium.game.world.map;

import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Represents an entity's viewport.
 * @author Emperor
 */
public final class Viewport {

    /**
     * The amount of chunks in a viewport.
     */
    public static final int CHUNK_SIZE = 5;

    /**
     * The region region.
     */
    private Region region;

    /**
     * The region chunks.
     */
    private RegionChunk[][] chunks = new RegionChunk[CHUNK_SIZE][CHUNK_SIZE];

    /**
     * The region region plane.
     */
    private RegionPlane currentPlane;

    /**
     * The region planes the entity can see.
     */
    private Deque<RegionPlane> viewingPlanes = new ArrayDeque<>();

    /**
     * Constructs a new {@code Viewport} {@code Object}.
     */
    public Viewport() {
		/*
		 * empty.
		 */
    }

    /**
     * Updates the entity's viewport.
     * @param entity The entity.
     */
    public void updateViewport(Entity entity) {
        RegionChunk chunk = RegionManager.getRegionChunk(entity.getLocation());
        int center = chunks.length >> 1;
        if (chunks[center][center] == chunk) {
            return;
        }
        int offset = center * -8;
        Location l = chunk.getCurrentBase();
        for (int x = 0; x < chunks.length; x++) {
            for (int y = 0; y < chunks[x].length; y++) {
                chunks[x][y] = RegionManager.getRegionChunk(l.transform(offset + (8 * x), offset + (8 * y), 0));
            }
        }
    }

    /**
     * Removes the entity from the viewingPlanes.
     * @param entity The entity.
     */
    public void remove(Entity entity) {
        //System.out.println("Removing entity " + entity + " - " + region);
        if (region == null) {
            return;
        }
        if (entity instanceof Player) {
            region.remove((Player) entity);
            Region region = null;

            for (RegionPlane r : viewingPlanes) {
                if (region != r.getRegion()) {
                    region = r.getRegion();
                    region.decrementViewAmount();
                    region.checkInactive();
                }
            }
        } else {
            region.remove((NPC) entity);
        }
    }

    /**
     * Gets the region.
     * @return The region.
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Sets the region.
     * @param region The region to set.
     */
    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     * Gets the chunks.
     * @return The chunks.
     */
    public RegionChunk[][] getChunks() {
        return chunks;
    }

    /**
     * Sets the chunks.
     * @param chunks The chunks to set.
     */
    public void setChunks(RegionChunk[][] chunks) {
        this.chunks = chunks;
    }

    /**
     * Gets the viewingPlanes.
     * @return The viewingPlanes.
     */
    public Deque<RegionPlane> getViewingPlanes() {
        return viewingPlanes;
    }

    /**
     * Sets the viewingPlanes.
     * @param viewingPlanes The viewingPlanes to set.
     */
    public void setViewingPlanes(Deque<RegionPlane> regions) {
        this.viewingPlanes = regions;
    }

    /**
     * Gets the currentPlane.
     * @return The currentPlane.
     */
    public RegionPlane getCurrentPlane() {
        return currentPlane;
    }

    /**
     * Sets the currentPlane.
     * @param currentPlane The currentPlane to set.
     */
    public void setCurrentPlane(RegionPlane currentPlane) {
        this.currentPlane = currentPlane;
    }

}