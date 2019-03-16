package org.arcanium.game.world.map.zone;

import org.arcanium.game.world.callback.CallBack;
import org.arcanium.game.world.map.zone.impl.*;

/**
 * Loads all the default zones.
 * @author Emperor
 */
public class ZoneBuilder implements CallBack {

    @Override
    public boolean call() {
	configure(WildernessZone.getInstance());
	configure(MultiwayCombatZone.getInstance());
	configure(new ModeratorZone());
	configure(new DarkZone());
	configure(new KaramjaZone());
	configure(new BankZone());
	configure(DonatorZone.getInstance());
	return true;
    }

    /**
     * Configures the map zone.
     * @param zone The map zone.
     */
    public static void configure(MapZone zone) {
	zone.setUid(zone.getName().hashCode());
	zone.configure();
    }
}