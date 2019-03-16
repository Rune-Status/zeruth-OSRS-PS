package org.arcanium.parser.player;

import org.arcanium.ServerConstants;
import org.arcanium.game.node.entity.combat.CombatSpell;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.SpellBookManager;
import org.arcanium.game.world.map.Location;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Arrays;

/**
 * Handles the parsing and dumping of a player's character file.
 *
 * @author Emperor
 */
public final class PlayerParser {

    /**
     * Parses a player's character file.
     *
     * @param player The player.
     */
    @SuppressWarnings("deprecation")
    public static void parse(Player player) {
        final File file = new File(ServerConstants.PLAYER_SAVE_PATH + player.getName() + ".arcanium");
        if (!file.exists()) {
            dump(player);
        }
        try (RandomAccessFile raf = new RandomAccessFile(file, "r"); FileChannel channel = raf.getChannel()) {
            ByteBuffer buffer = channel.map(MapMode.READ_ONLY, 0, channel.size());
            int opcode;
            long networth = 0;
            int[] opcodeLog = new int[5];
            while ((opcode = buffer.get() & 0xFF) != 0) {
                System.out.println(opcode);
                switch (opcode) {
                    case 1:
                        player.setLocation(Location.create(buffer.getShort() & 0xFFFF, buffer.getShort() & 0xFFFF, buffer.get() & 0xF));
                        break;
                    case 2:
                        networth += player.getInventory().parse(buffer);
                        break;
                    case 3:
                        networth += player.getEquipment().parse(buffer);
                        break;
                    case 4:
                        networth += 0;//player.getBank().parse(buffer);
                        break;
                    case 5:
                        player.getSkills().parse(buffer);
                        break;
                    case 6:
                        player.getSettings().parse(buffer);
                        break;
                    case 7:
                        player.getEmotes().parse(buffer);
                        break;
                    case 10:
                        player.getGameAttributes().parse(buffer);
                        break;
                    case 14:
                        player.getSlayer().parse(buffer);
                        break;
                    case 17:
                        player.getQuestRepository().parse(buffer);
                        break;
                    case 21:
                        player.getAppearance().parse(buffer);
                        break;
                    case 25:
                        player.getSpellBookManager().parse(buffer);
                        break;
                    case 26:
                        player.getGrandExchange().parse(buffer);
                        break;
                    case 27:
                        player.getSavedData().parse(buffer);
                        break;
                    case 28:
                        player.getDetails().getCommunication().parsePrevious(buffer);
                        break;
                    case 29:
                        player.getProperties().setAutocastSpell((CombatSpell) SpellBookManager.SpellBook.values()[buffer.get()].getSpell(buffer.get() & 0xFF));
                        break;
                    case 30:
                        player.getFarmingManager().parse(buffer);
                        break;
                    case 31:
                        player.getConfigManager().parse(buffer);
                        break;
                    case 32:
                        player.getWarningMessages().parse(buffer);
                        break;
                    case 33:
                        player.getMonitor().parse(buffer);
                        break;
                    case 34:
                        player.getMusicPlayer().parse(buffer);
                        break;
                    case 35:
                        // player.getFamiliarManager().parse(buffer);
                        break;
                    case 36:
                        player.getBarcrawlManager().parse(buffer);
                        break;
                    case 37:
                        player.getStateManager().parse(buffer);
                        break;
                    case 39:
                        player.getTreasureTrailManager().parse(buffer);
                        break;
                    case 40:
                        player.getBankPinManager().parse(buffer);
                        break;
                    case 41:
                        player.getHouseManager().parse(buffer);
                        break;
                    case 42:
                        player.getAchievementDiaryManager().parse(buffer);
                        break;
                    case 43:
                        player.getIronmanManager().parse(buffer);
                        break;
                    default:
                        System.err.println("[Player parsing] Unhandled opcode: " + opcode + " for " + player.getName() + " - [log=" + Arrays.toString(opcodeLog) + "].");
                        break;
                }
                for (int i = opcodeLog.length - 2; i >= 0; i--) {
                    opcodeLog[i + 1] = opcodeLog[i];
                }
                opcodeLog[0] = opcode;
            }
            player.getMonitor().setNetworth(networth);
            raf.close();
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dumps the player's details to the character file.
     *
     * @param player The player.
     */
    public static void dump(Player player) {
        dump(player, "data/");
    }

    /**
     * Dumps the player's details to the character file.
     *
     * @param player    The player.
     * @param directory The saving directory.
     */
    public static void dump(Player player, String directory) {
        ByteBuffer buffer = ByteBuffer.allocate(4096 << 2);
        long networth = 0;
        // Location
        buffer.put((byte) 1).putShort((short) player.getLocation().getX()).putShort((short) player.getLocation().getY()).put((byte) player.getLocation().getZ());

        // Inventory
        if (!player.getInventory().isEmpty()) {
            networth += player.getInventory().save(buffer.put((byte) 2));
        }
        // Equipment
        if (!player.getEquipment().isEmpty()) {
            networth += player.getEquipment().save(buffer.put((byte) 3));
        }
        // Bank
        if (!player.getBank().isEmpty()) {
            networth += 0;//player.getBank().save(buffer.put((byte) 4));
        }
        // Skills
        player.getSkills().save(buffer.put((byte) 5));

        // Settings
        player.getSettings().save(buffer.put((byte) 6));

        // Emotes
        player.getEmotes().save(buffer.put((byte) 7));

        // Attributes
        if (!player.getGameAttributes().getSavedAttributes().isEmpty()) {
            player.getGameAttributes().dump(buffer.put((byte) 10));
        }
        // Slayer
        player.getSlayer().save(buffer.put((byte) 14));

        // Quests
        player.getQuestRepository().save(buffer.put((byte) 17));

        // Appearance
        player.getAppearance().save(buffer.put((byte) 21));

        // Spellbook
        if (player.getSpellBookManager().getSpellBook() != 192) {
            player.getSpellBookManager().save(buffer.put((byte) 25));
        }
        // Grand exchange
        if (player.getGrandExchange().hasActiveOffer()) {
            player.getGrandExchange().save(buffer.put((byte) 26));
        }
        // Activity
        player.getSavedData().save(buffer.put((byte) 27));

        // 28 was used for communication!

        // Autocasting
        if (player.getProperties().getAutocastSpell() != null) {
            CombatSpell spell = player.getProperties().getAutocastSpell();
            buffer.put((byte) 29).put((byte) spell.getBook().ordinal()).put((byte) spell.getSpellId());
        }
        // Farming
        player.getFarmingManager().save(buffer.put((byte) 30));

        // Configurations
        player.getConfigManager().save(buffer.put((byte) 31));

        // Warning messages
        player.getWarningMessages().save(buffer.put((byte) 32));

        // Player monitor data
        player.getMonitor().checkNetworth(player, networth);
        player.getMonitor().save(buffer.put((byte) 33));

        // Music
        player.getMusicPlayer().save(buffer.put((byte) 34));

        // Familiar/pet data
        //player.getFamiliarManager().save(buffer.put((byte) 35));

        // Barcrawl miniquest.
        player.getBarcrawlManager().save(buffer.put((byte) 36));

        // States (poison/skull/...)
        if (player.getStateManager().isSaveRequired()) {
            player.getStateManager().save(buffer.put((byte) 37));
        }

        // Treasure trail saving
        player.getTreasureTrailManager().save(buffer.put((byte) 39));

        // Bank pin
        player.getBankPinManager().save(buffer.put((byte) 40));

        // Construction saving.
        if (player.getHouseManager().hasHouse()) {
            player.getHouseManager().save(buffer.put((byte) 41));
        }

        // Achievement Diary
        player.getAchievementDiaryManager().save(buffer.put((byte) 42));

        // Ironman Manager
        player.getIronmanManager().save(buffer.put((byte) 43));

        buffer.put((byte) 0); // EOF opcode
        buffer.flip();
        File file = new File(directory + "players/" + player.getName() + ".arcanium");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw"); FileChannel channel = raf.getChannel()) {
            channel.write(buffer);
            raf.close();
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}