package org.arcanium.parser.item;

import org.arcanium.cache.Cache;
import org.arcanium.cache.def.impl.ItemDefinition;
import org.arcanium.parser.Parser;

import java.nio.ByteBuffer;

/**
 * The item definitions parser.
 *
 * @author Emperor
 */
public final class ItemDefinitionsParser implements Parser {

    @Override
    public boolean parse() throws Throwable {
        int size = Cache.getItemDefinitionsSize();
        for (int itemId = 0; itemId < size; itemId++) {
            byte[] data = Cache.getIndexes()[2].getFileData(10, itemId);
            if (data == null) {
                ItemDefinition.getDefinitions().put(itemId, new ItemDefinition());
                continue;
            }
            ItemDefinition def = ItemDefinition.parseDefinition(itemId, ByteBuffer.wrap(data));
            if (def == null) {
                System.err.println("Could not load item definitions for id " + itemId + " - no definitions found!");
                return false;
            }
            ItemDefinition.getDefinitions().put(itemId, def);
        }
        //System.out.println("[ItemDefinitionParser] Index Sizes [index 10 size (" + size + ")]");
        ItemDefinition.defineTemplates();
        return true;
    }

}