package org.arcanium.game.content.skill.p2p.construction.conditions;

import org.arcanium.game.node.entity.player.Player;

/**
 * A decoration condition.
 * @author Vexia
 */
public interface DecorationCondition {

    /**
     * Checks if the player has the requirements to build a condition.
     * @param player the player.
     * @param message the message.
     * @return {@code True} if so.
     */
    boolean hasRequirements(Player player, boolean message);

    /**
     * Removes the required items.
     * @param player the player.
     * @return {@code True} if the item(s) are removed.
     */
    boolean remove(Player player);

}
