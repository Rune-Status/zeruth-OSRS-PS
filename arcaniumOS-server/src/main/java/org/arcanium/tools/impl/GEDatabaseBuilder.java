package org.arcanium.tools.impl;

import org.arcanium.cache.def.impl.ItemDefinition;
import org.arcanium.game.content.eco.ge.GrandExchangeDatabase;
import org.arcanium.game.content.eco.ge.GrandExchangeEntry;
import org.arcanium.game.world.GameWorld;
import org.arcanium.parser.item.ItemConfiguration;

import java.io.BufferedReader;
import java.io.FileReader;

public class GEDatabaseBuilder {

    public static void main(String... args) throws Throwable {
	GameWorld.prompt(false);
	BufferedReader br = new BufferedReader(new FileReader("./info/ge_dump_result.txt"));
	String s;
	while ((s = br.readLine()) != null) {
	    // Item price [id=2, value=381].
	    s = s.replace("Item price [id=", "").replace("].", "").replace(", value=", ";");
	    String[] arg = s.split(";");
	    int id = Integer.parseInt(arg[0]);
	    ItemDefinition def = ItemDefinition.forId(id);
	    GrandExchangeEntry entry = new GrandExchangeEntry(id);
	    if (def == null) {
		break;
	    }
	    int value = def.getConfiguration(ItemConfiguration.GE_PRICE, def.getConfiguration(ItemConfiguration.SHOP_PRICE, def.getAlchemyValue(true)));
	    if (value == 0) {
		value = Integer.parseInt(arg[1]);
		System.out.println("Value was 0!");
	    }
	    System.out.println("[database]: added entry [id=" + id + ", val=" + value + "]...");
	    entry.setValue(value);
	    GrandExchangeDatabase.getDatabase().put(id, entry);
	}
	br.close();
	GrandExchangeDatabase.dump("./data/");
	System.out.println("Done!");
    }
}
