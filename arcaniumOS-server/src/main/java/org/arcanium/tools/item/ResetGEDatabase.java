package org.arcanium.tools.item;

import org.arcanium.ServerConstants;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.info.PlayerDetails;
import org.arcanium.game.world.GameWorld;
import org.arcanium.parser.player.PlayerParser;

import java.io.File;

/**
 * Resets the Grand Exchange database.
 *
 * @author Emperor
 */
public final class ResetGEDatabase {

    /**
     * The main method.
     *
     * @param args The arguments cast on runtime.
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        GameWorld.prompt(false);
        for (File file : new File(ServerConstants.PLAYER_SAVE_PATH).listFiles()) {
            if (!file.getName().endsWith(".arcanium")) {
                continue;
            }
            try {
                PlayerDetails details = new PlayerDetails(file.getName().replaceAll(".arcanium", ""), "unknown", null);
                details.parse();
                Player player = new Player(details);
                PlayerParser.parse(player);
                for (int i = 0; i < player.getGrandExchange().getOffers().length; i++) {
                    player.getGrandExchange().getOffers()[i] = null;
                }
                PlayerParser.dump(player);
            } catch (Throwable t) {
                t.printStackTrace();
                System.out.println("Error loading " + file.getName() + "!");
            }
        }
        if (new File("./data/eco/offer_dispatch_db.emp").delete()) {
            System.out.println("Successfully reset Grand Exchange offer database!");
        }
    }

}