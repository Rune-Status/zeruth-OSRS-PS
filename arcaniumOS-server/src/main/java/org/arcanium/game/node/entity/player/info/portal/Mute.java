package org.arcanium.game.node.entity.player.info.portal;

import org.arcanium.game.node.entity.player.Player;

/**
 * Handles a mute.
 * @author Vexia
 */
public class Mute extends Punishment {

    @Override
    public void inflict(final Player player) {
	if (player != null && player.isActive()) {
	    player.getPacketDispatch().sendMessage("You have been muted.");
	    player.getPacketDispatch().sendMessage("To prevent further mutes please read the rules.");
	}
    }

    @Override
    public String toString() {
	return "You have been " + (permanent ? "permanently" : "temporarily") + " muted due to breaking a rule.";
    }
}
