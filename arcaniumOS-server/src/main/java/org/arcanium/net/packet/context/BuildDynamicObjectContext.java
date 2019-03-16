package org.arcanium.net.packet.context;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.net.packet.Context;

public class BuildDynamicObjectContext implements Context {

    /**
     * The list of game objects to send.
     */
    private final GameObject gameObject;

    /**
     * Constructs a new {@code BuildObjectContext} {@code Object}.
     *
     * @param player      The player
     * @param gameObjects The list of game objects to send.
     */
    public BuildDynamicObjectContext(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    /**
     * Gets the gameObject.
     *
     * @return The gameObject.
     */
    public GameObject getGameObject() {
        return gameObject;
    }

    /**
     * Gets the node.
     *
     * @return The node.
     */
    @Override
    public Player getPlayer() {
        return null;
    }
}