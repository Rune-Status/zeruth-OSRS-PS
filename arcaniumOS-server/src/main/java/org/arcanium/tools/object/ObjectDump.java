package org.arcanium.tools.object;

import org.arcanium.cache.Cache;
import org.arcanium.cache.def.impl.ObjectDefinition;
import org.arcanium.game.world.GameWorld;

public class ObjectDump {

    public static void main(String... args) throws Throwable {
	GameWorld.prompt(false);
	for (int i = 0; i < Cache.getObjectDefinitionsSize(); i++) {
	    ObjectDefinition def = ObjectDefinition.forId(i);
	    if (def.hasAction("build") || def.hasAction("remove")) {
		System.out.println(def.getId() + ",");
	    }
	}
    }
}
