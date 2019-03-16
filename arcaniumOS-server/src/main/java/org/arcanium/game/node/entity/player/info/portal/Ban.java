package org.arcanium.game.node.entity.player.info.portal;

import org.arcanium.game.node.entity.player.Player;

/**
 * Handles a ban.
 * @author Vexia
 */
public final class Ban extends Punishment {

    @Override
    public void inflict(final Player player) {
	if (player.isActive()) {
	    player.getPacketDispatch().sendLogout();// disconnects.
	}
    }

    @Override
    public String toString() {
	return "You have been " + (permanent ? "permanently" : "temporarily") + " banned due to breaking a rule.";
    }
}
