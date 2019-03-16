package org.arcanium.parser.object;

import org.arcanium.cache.Cache;
import org.arcanium.cache.def.impl.ObjectDefinition;
import org.arcanium.parser.Parser;

import java.nio.ByteBuffer;

/**
 * The object definitions parser.
 *
 * @author Emperor
 */
public final class ObjectDefinitionsParser implements Parser {

    @Override
    public boolean parse() throws Throwable {
        for (int objectId = 0; objectId < Cache.getObjectDefinitionsSize(); objectId++) {
            byte[] data = Cache.getIndexes()[2].getFileData(6, objectId);
            if (data == null) {
                ObjectDefinition.getDefinitions().put(objectId, new ObjectDefinition());
                System.err.println("Could not load object definitions for id " + objectId + " - no data!");
                continue;
            }
            ObjectDefinition def = ObjectDefinition.parseDefinition(objectId, ByteBuffer.wrap(data));
            if (def == null) {
                System.err.println("Could not load object definitions for id " + objectId + " - no definitions found!");
                return false;
            }
            ObjectDefinition.getDefinitions().put(objectId, def);
            data = null;
        }
        return true;
    }

    /**
     * Get the container id.
     *
     * @param id The object id.
     * @return The container id.
     */
    public static int getContainerId(int id) {
        return id >>> 1998118472;
    }
}