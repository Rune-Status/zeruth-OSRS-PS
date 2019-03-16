package org.arcanium.game.interaction.widget;

import org.arcanium.game.component.Component;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.GameWorld;

/**
 * Represents the interface used to logout of the game.
 * @author 'Vexia
 * @version 1.0
 */
public final class LogoutInterface {

    public static boolean handle(Player player, Component component, int opcode, int button, int slot, int itemId) {
	if (component.getId() == 182 && button == 8) {
	    if (!player.getZoneMonitor().canLogout()) {
		return true;
	    }
	    if (player.inCombat()) {
		player.getPacketDispatch().sendMessage("You can't log out until 10 seconds after the end of combat.");
		return true;
	    }
	    if (player.getAttribute("logoutDelay", 0) < GameWorld.getTicks()) {
		player.getPacketDispatch().sendLogout();
		player.setAttribute("logoutDelay", GameWorld.getTicks() + 3);
	    }
	}
	return true;
    }
}
