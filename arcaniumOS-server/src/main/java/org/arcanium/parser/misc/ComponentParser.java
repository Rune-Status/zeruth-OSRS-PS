package org.arcanium.parser.misc;

import org.arcanium.cache.Cache;
import org.arcanium.cache.ServerStore;
import org.arcanium.game.component.ComponentDefinition;
import org.arcanium.parser.Parser;

import java.nio.ByteBuffer;

/**
 * The component definitions parser.
 * @author Emperor
 */
public final class ComponentParser implements Parser {

    @Override
    public boolean parse() throws Throwable {
	ByteBuffer buf = ServerStore.getArchive("component_config");
	for (int id = 0; id < Cache.getInterfaceDefinitionsSize(); id++) {
	    ComponentDefinition.getDefinitions().put(id, ComponentDefinition.parse(buf));
	}
	return true;
    }

}