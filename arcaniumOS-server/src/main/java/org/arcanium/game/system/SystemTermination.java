package org.arcanium.game.system;

import org.arcanium.cache.ServerStore;
import org.arcanium.game.content.eco.ge.GEOfferDispatch;
import org.arcanium.game.content.eco.ge.GrandExchangeDatabase;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.parser.player.PlayerParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.Executors;

/**
 * Handles the terminating of the system.
 *
 * @author Emperor
 */
public final class SystemTermination {

    /**
     * The data directory.
     */
    private static final String DATA_DIRECTORY = "data/";

    /**
     * The backup directory.
     */
    private static final String BACKUP_DIRECTORY = "data/backup/";

    /**
     * Constructs a new {@code SystemTermination} {@code Object}.
     */
    protected SystemTermination() {
        /*
         * empty.
         */
    }

    /**
     * Terminates the system safely.
     */
    public void terminate() {
        SystemLogger.log("[SystemTerminator] Initializing termination sequence - do not shutdown!");
        try {
            save(getDataDirectory());
        } catch (Throwable e) {
            e.printStackTrace();
            try {
                save(getBackupDirectory());
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
        SystemLogger.log("[SystemTerminator] Server successfully terminated!");
        System.exit(0);
    }

    /**
     * Generates a backup.
     */
    public void generateBackup() {
        if (GameWorld.getSettings().isDevMode()) {
            return;
        }
        try {
            save(getDataDirectory());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Executors.newSingleThreadExecutor().submit(() -> {
            String date = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
            String directory = getBackupDirectory() + date;
            File dir = new File(directory);
            if (!dir.exists()) {
                dir.mkdir();
                dir = new File(directory + "/eco/");
                dir.mkdir();
                dir = new File(directory + "/store/");
                dir.mkdir();
                dir = new File(directory + "/clans");
                dir.mkdir();
                dir = new File(directory + "/players");
                dir.mkdir();
                dir = new File(directory + "/players/details");
                dir.mkdir();
            }
            for (File file : new File(getDataDirectory() + "players/").listFiles()) {
                if (!file.isDirectory()) {
                    copyFile(file, new File(directory + "/players/" + file.getName()));
                }
            }
            for (File file : new File(getDataDirectory() + "players/details").listFiles()) {
                if (file.exists()) {
                    copyFile(file, new File(directory + "/players/details/" + file.getName()));
                }
            }
            for (File file : new File(getDataDirectory() + "clans/").listFiles()) {
                if (!file.isDirectory()) {
                    copyFile(file, new File(directory + "/clans/" + file.getName()));
                }
            }
            File file = new File(getDataDirectory() + "eco/grand_exchange_db.emp");
            if (file.exists()) {
                copyFile(file, new File(directory + "/eco/" + file.getName()));
            }
            file = new File(getDataDirectory() + "eco/offer_dispatch_db.emp");
            if (file.exists()) {
                copyFile(file, new File(directory + "/eco/" + file.getName()));
            }
            file = new File(getDataDirectory() + "store/dynamic_cache.arcanium");
            if (file.exists()) {
                copyFile(file, new File(directory + "/store/" + file.getName()));
            }
            SystemLogger.log("[SystemTerminator] Successfully generated backup!");
        });
    }

    /**
     * Saves all system data on the directory.
     *
     * @param directory The base directory.
     * @throws Throwable When an exception occurs.
     */
    public void save(String directory) throws Throwable {
        File file = new File(directory);
        SystemLogger.log("[SystemTerminator] Saving data [dir=" + file.getAbsolutePath() + "]...");
        if (!file.isDirectory()) {
            file.mkdir();
        }
        GrandExchangeDatabase.dump(directory);
        GEOfferDispatch.dump(directory);
        SystemLogger.log("[SystemTerminator] Saved Grand Exchange databases!");
        Repository.getDisconnectionQueue().clear();
        for (Iterator<Player> it = Repository.getPlayers().iterator(); it.hasNext(); ) {
            try {
                Player p = it.next();
                if (p != null && !p.isArtificial()) { // Should never be null.
                    p.removeAttribute("combat-time");
                    p.clear();
                    PlayerParser.dump(p, directory);
                    p.getDetails().save(directory);
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
        ServerStore.dump(directory + "store/");
        SystemLogger.log("[SystemTerminator] Saved player accounts!");
    }

    /**
     * Copies a file.
     *
     * @param in  The file to be copied.
     * @param out The file to copy to.
     */
    private static void copyFile(File in, File out) {
        try (FileChannel channel = new FileInputStream(in).getChannel()) {
            try (FileChannel output = new FileOutputStream(out).getChannel()) {
                channel.transferTo(0, channel.size(), output);
                channel.close();
                output.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the data directory.
     *
     * @return the directory.
     */
    public static String getDataDirectory() {
        return DATA_DIRECTORY;
    }

    /**
     * Gets the backup directory.
     *
     * @return the directory.
     */
    public static String getBackupDirectory() {
        return BACKUP_DIRECTORY;
    }
}