package org.arcanium.tools.item;

import org.arcanium.cache.Cache;
import org.arcanium.cache.def.impl.ItemDefinition;
import org.arcanium.game.content.eco.ge.GrandExchangeDatabase;
import org.arcanium.game.content.eco.ge.GrandExchangeEntry;
import org.arcanium.game.system.task.TaskExecutor;
import org.arcanium.game.world.GameWorld;
import org.arcanium.parser.item.ItemConfiguration;

import java.sql.PreparedStatement;

/**
 * Handles the price guide tool to populate the db.
 * @author Vexia
 */
public class PriceGuideTool {

    /**
     * The main method.
     * @param args the args.
     * @throws Throwable the throwable.
     */
    public static void main(String... args) throws Throwable {
	GameWorld.prompt(false);
	System.out.println(Cache.getItemDefinitionsSize());
	TaskExecutor.executeSQL(new Runnable() {

	    @Override
	    public void run() {
		push();
	    }

	});
    }

    private static int inserted;

    private static ItemDefinition def;

    private static void push() {
	for (int i = 0; i < Cache.getItemDefinitionsSize(); i++) {
	    def = ItemDefinition.forId(i);
	    if (def.getName().equals("null")) {
		continue;
	    }
	    if (!def.isTradeable()) {
		continue;
	    }
	    if (!def.isUnnoted()) {
		continue;
	    }
	    if (i <= 13246) {// TEMP
		continue;
	    }
	    GrandExchangeEntry entry = GrandExchangeDatabase.getDatabase().get(def.getId());
	    int gePrice = entry == null ? def.getConfiguration(ItemConfiguration.GE_PRICE, 0) : entry.getValue();
	    PreparedStatement statement;
	    
	    inserted++;

	}
	System.out.println("Inserted " + inserted + " item prices into the database.");
    }

    /**
     * /**Connection connection = SQLManager.getConnection(); ResultSet result =
     * null; PreparedStatement statement; statement =
     * connection.prepareStatement("SELECT * FROM " + "prices" + " WHERE " + ""
     * + "id" + "='" + i + "'"); result = statement.executeQuery(); if (result
     * == null || result.next()) {//exists SQLManager.close(connection);
     * System.out.println("Row already exists for " + def.getName() + "!");
     * continue; }
     */
    // PreparedStatement statement =
    // connection.prepareStatement("INSERT reports(reporter, reported, messages, reason) VALUES('"
    // + value + "', '" + entry.getVictim() + "', '" + entry.getMessages() +
    // "', '" + entry.getRule().name() + "')");

}
