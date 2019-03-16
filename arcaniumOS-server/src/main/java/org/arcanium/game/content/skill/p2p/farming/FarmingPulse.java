package org.arcanium.game.content.skill.p2p.farming;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.system.task.Pulse;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.callback.CallBack;
import org.arcanium.game.world.repository.Repository;

/**
 * Represents the pulsed used to update all players farming states.
 * @author 'Vexia
 */
public final class FarmingPulse extends Pulse implements CallBack {

    @Override
    public boolean pulse() {
	for (Player p : Repository.getPlayers()) {
	    if (p == null) {
		continue;
	    }
	    p.getFarmingManager().cycle();
	}
	return false;
    }

    @Override
    public boolean call() {
	GameWorld.submit(this);
	return true;
    }

}
