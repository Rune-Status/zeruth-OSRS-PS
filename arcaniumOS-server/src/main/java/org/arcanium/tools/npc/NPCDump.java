package org.arcanium.tools.npc;

import org.arcanium.cache.Cache;
import org.arcanium.cache.def.impl.NPCDefinition;
import org.arcanium.game.world.GameWorld;

public class NPCDump {

    public static void main(String... args) throws Throwable {
	GameWorld.prompt(false);
	for (int i = 0; i < Cache.getNPCDefinitionsSize(); i++) {
	    NPCDefinition def = NPCDefinition.forId(i);
	    if (def == null) {
		continue;
	    }
	    if (def.getName().toLowerCase().contains("corp")) {
		System.out.println(def.getId() + "," + def.getName());
	    }
	}
    }
}
