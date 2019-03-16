package org.arcanium.game.node.object;

import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.GroundItem;
import org.arcanium.game.node.item.GroundItemManager;
import org.arcanium.game.system.task.Pulse;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.game.world.map.build.LandscapeParser;
import org.arcanium.game.world.update.flag.chunk.ObjectUpdateFlag;

/**
 * An aiding class for object constructing/removing.
 *
 * @author Emperor
 */
public final class ObjectBuilder {

    /**
     * The default restore time of an object.
     */
    public static final int DEFAULT_RESTORE_TIME = 35;

    /**
     * Replaces a game object.
     *
     * @param remove    The object to remove.
     * @param construct The object to add.
     * @return {@code True} if successful.
     */
    public static boolean replace(GameObject remove, GameObject construct) {
        return replace(remove, construct, true, null);
    }

    public static boolean replace(GameObject remove, GameObject construct, Player player) {
        return replace(remove, construct, true, player);
    }

    /**
     * Replaces a game object.
     *
     * @param remove    The object to remove.
     * @param construct The object to add.
     * @param clip      If clipping should be adjusted.
     * @return {@code True} if successful.
     */
    public static boolean replace(GameObject remove, GameObject construct, boolean clip, Player player) {
        if (!clip) {
            return replaceClientSide(remove, construct, -1);
        }
        remove = remove.getWrapper();
        GameObject current = LandscapeParser.removeGameObject(remove);
        if (current == null) {
            if (GameWorld.getSettings().isDevMode()) {
                System.err.println("Object could not be replaced - object to remove is invalid.");
            }
            return false;
        }
        if (current.getRestorePulse() != null) {
            current.getRestorePulse().stop();
            current.setRestorePulse(null);
        }
        if (current instanceof Constructed) {
            GameObject previous = ((Constructed) current).getReplaced();
            if (previous != null && previous.equals(construct)) {
                LandscapeParser.addGameObject(previous);
                update(current, previous);
                return true;
            }
        }
        Constructed constructed = construct.asConstructed();
        constructed.setReplaced(current);
        LandscapeParser.addGameObject(constructed);
        update(current, constructed);
        return true;
    }

    /**
     * Replaces the object client sided alone.
     *
     * @param remove       The object to remove.
     * @param construct    The object to replace with.
     * @param restoreTicks The restoration ticks.
     * @return {@code True} if successful.
     */
    private static boolean replaceClientSide(final GameObject remove, final GameObject construct, int restoreTicks) {
        RegionManager.getRegionChunk(remove.getLocation()).flag(new ObjectUpdateFlag(remove, true));
        RegionManager.getRegionChunk(construct.getLocation()).flag(new ObjectUpdateFlag(construct, false));

        if (restoreTicks > 0) {
            GameWorld.submit(new Pulse(restoreTicks) {
                @Override
                public boolean pulse() {
                    return replaceClientSide(construct, remove, -1);
                }
            });
        }
        return true;
    }

    /**
     * Replaces the object with an npc.
     *
     * @param object
     * @param construct
     * @param restoreTicks
     * @return
     */
    public static void transformToNPC(final GameObject object, final NPC construct, int restoreTicks) {
        object.setRenderable(false);
        RegionManager.getRegionChunk(object.getLocation()).flag(new ObjectUpdateFlag(object, true));
        construct.init();
        if (restoreTicks > 0) {
            GameWorld.submit(new Pulse(restoreTicks) {
                @Override
                public boolean pulse() {
                    construct.clear();
                    object.setRenderable(true);
                    RegionManager.getRegionChunk(object.getLocation()).flag(new ObjectUpdateFlag(object, false));
                    return true;
                }
            });
        }
    }

    public static void transformObject(final GameObject object, final GameObject replacement, int restoreTicks) {
        object.setRenderable(false);
        RegionManager.getRegionChunk(object.getLocation()).flag(new ObjectUpdateFlag(object, true));
        add(replacement);
        if (restoreTicks > 0) {
            GameWorld.submit(new Pulse(restoreTicks) {
                @Override
                public boolean pulse() {
                    if (remove(replacement)) {
                        //	TODO XXX This may cause harm to the server. I will continue
                        //	To look for a better way of doing this...
                        object.setRenderable(true);
                        add(object);
                    }
                    return true;
                }
            });
        }
    }

    /**
     * Replaces a game object temporarily.
     *
     * @param remove       The object to remove.
     * @param construct    The object to add.
     * @param restoreTicks The amount of ticks before the object gets restored.
     * @return {@code True} if successful.
     */
    public static boolean replace(GameObject remove, GameObject construct, int restoreTicks) {
        return replace(remove, construct, restoreTicks, true);
    }

    /**
     * Replaces a game object temporarily.
     *
     * @param remove       The object to remove.
     * @param construct    The object to add.
     * @param restoreTicks The amount of ticks before the object gets restored.
     * @return {@code True} if successful.
     */
    public static boolean replace(GameObject remove, GameObject construct, int restoreTicks, final boolean clip) {
        if (!clip) {
            return replaceClientSide(remove, construct, restoreTicks);
        }
        remove = remove.getWrapper();
        GameObject current = LandscapeParser.removeGameObject(remove);
        if (current == null) {
            if (GameWorld.getSettings().isDevMode()) {
                System.err.println("Object could not be replaced - object to remove is invalid.");
            }
            return false;
        }
        if (current.getRestorePulse() != null) {
            current.getRestorePulse().stop();
            current.setRestorePulse(null);
        }
        if (current instanceof Constructed) {
            GameObject previous = ((Constructed) current).getReplaced();
            if (previous != null && previous.equals(construct)) {
                //Shouldn't happen.
                throw new IllegalStateException("Can't temporarily replace an already temporary object!");
            }
        }
        final Constructed constructed = construct.asConstructed();
        constructed.setReplaced(current);
        LandscapeParser.addGameObject(constructed);
        update(current, constructed); //issue is here
        if (restoreTicks < 0) {
            return true;
        }
        constructed.setRestorePulse(new Pulse(restoreTicks) {
            @Override
            public boolean pulse() {
                replace(constructed, constructed.getReplaced());
                return true;
            }
        });
        GameWorld.submit(constructed.getRestorePulse());
        return true;
    }

    /**
     * Adds a game object.
     *
     * @param object The object to add.
     * @return {@code True} if successful.
     */
    public static Constructed add(GameObject object) {
        return add(object, -1);
    }

    /**
     * Adds a game object.
     *
     * @param object The object to add.
     * @param ticks  The amount of ticks this object should last for (-1 for permanent).
     * @return {@code True} if successful.
     */
    public static Constructed add(GameObject object, int ticks, final GroundItem... items) {
        object = object.getWrapper();
        final Constructed constructed = object.asConstructed();
        LandscapeParser.addGameObject(constructed);
        update(constructed); // has problem
        if (ticks > -1) {
            GameWorld.submit(new Pulse(ticks, object) {
                @Override
                public boolean pulse() {
                    remove(constructed);
                    if (items != null) {
                        for (int i = 0; i < items.length; i++) {
                            GroundItemManager.create(items[i]);
                        }
                    }
                    return true;
                }
            });
        }
        return constructed;
    }

    /**
     * Removes a game object.
     *
     * @param object The object to remove.
     * @return {@code True} if successful.
     */
    public static boolean remove(GameObject object) {
        object = object.getWrapper();
        GameObject current = LandscapeParser.removeGameObject(object);
        if (current == null) {
            return false;
        }
        update(current);
        return true;
    }

    /**
     * Removes a game object.
     *
     * @param object       the object.
     * @param respawnTicks the respawn ticks.
     * @return {@code True}if removed.
     */
    public static boolean remove(final GameObject object, int respawnTicks) {
        if (remove(object)) {
            GameWorld.submit(new Pulse(respawnTicks) {

                @Override
                public boolean pulse() {
                    add(object);
                    return true;
                }

            });
            return true;
        }
        return false;
    }

    /**
     * Updates the game object on all the player's screen.
     *
     * @param objects The game objects.
     */
    public static void update(GameObject... objects) {
        for (GameObject o : objects) {
            if (o == null) {
                continue;
            }
            RegionManager.getRegionChunk(o.getLocation()).flag(new ObjectUpdateFlag(o, !o.isActive()));
        }
    }
}