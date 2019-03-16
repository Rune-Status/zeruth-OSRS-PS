package org.arcanium.tools.impl;

import org.arcanium.ServerConstants;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.info.PlayerDetails;
import org.arcanium.game.system.communication.CommunicationInfo;
import org.arcanium.game.system.communication.Contact;
import org.arcanium.game.system.task.TaskExecutor;
import org.arcanium.game.world.GameWorld;
import org.arcanium.parser.player.PlayerParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Map.Entry;

/**
 * Ensures the character accounts data.
 *
 * @author Emperor
 */
public final class EnsureCharacterAccounts {

    static int goodCount = 0;

    /**
     * The main method.
     *
     * @param args The arguments cast on runtime.
     * @throws Throwable When an exception occurs.
     */
    public static void main(String... args) throws Throwable {
        GameWorld.prompt(false);
        final File backupDir = new File("./invalid_chars/");
        int totalCount = new File(ServerConstants.PLAYER_SAVE_PATH).listFiles().length;

        for (final File file : new File(ServerConstants.PLAYER_SAVE_PATH).listFiles()) {
            if (!file.getName().endsWith(".arcanium")) {
                totalCount--;
                continue;
            }
            TaskExecutor.executeSQL(new Runnable() {

                                        @Override
                                        public void run() {
                                            try {
                                                PlayerDetails details = new PlayerDetails(file.getName().replaceAll(".arcanium", ""), "unknown", null);
                                                details.parse();
                                                Player player = new Player(details);
                                                PlayerParser.parse(player);
                                                String contacts = "";
                                                String blocked = "";
                                                CommunicationInfo info = player.getDetails().getCommunication();
                                                for (int i = 0; i < info.getBlocked().size(); i++) {
                                                    blocked += (i == 0 ? "" : ",") + info.getBlocked().get(i);
                                                }
                                                int count = 0;
                                                for (Entry<String, Contact> entry : info.getContacts().entrySet()) {
                                                    contacts += "{" + entry.getKey() + "," + entry.getValue().getRank().ordinal() + "}" + (count == info.getContacts().size() - 1 ? "" : "~");
                                                    count++;
                                                }

                                                PlayerParser.dump(player, "./530/");
                                                goodCount++;
                                                System.out.println("Ensured " + file.getName().replaceAll(".arcanium", "") + "'s account data!");
                                            } catch (Throwable t) {
                                                t.printStackTrace();
                                                System.out.println("Error ensuring " + file.getName().replaceAll(".arcanium", "") + "'s account data!");
                                                try {
                                                    if (!backupDir.isDirectory()) {
                                                        backupDir.mkdir();
                                                    }
                                                    copyFile(file, new File("./invalid_chars/" + file.getName()));
                                                    file.delete();
                                                } catch (Throwable e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                    }

            );
        }
        System.out.println("Conversion of 498 -> 530 accounts completed, " + goodCount + "/" + totalCount + " accounts converted!");
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
}