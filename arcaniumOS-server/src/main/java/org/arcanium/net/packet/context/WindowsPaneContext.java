package org.arcanium.net.packet.context;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.Context;

/**
 * Represents the windows pane packet context.
 * @author Emperor
 */
public final class WindowsPaneContext implements Context {

    /**
     * The player.
     */
    private final Player player;

    /**
     * The window id.
     */
    private final int windowId;

    /**
     * Constructs a new {@code WindowsPaneContext} object.
     * @param player The player.
     * @param windowId The window id.
     */
    public WindowsPaneContext(Player player, int windowId) {
        this.player = player;
        this.windowId = windowId;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the windowId.
     * @return The windowId.
     */
    public int getWindowId() {
        return windowId;
    }

}