package org.arcanium.cache.def.impl;

import org.arcanium.cache.Cache;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.GameWorld;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles config definition reading.
 *
 * @author Emperor
 */
public final class ConfigFileDefinition {

    /**
     * The config definitions mapping.
     */
    private static final Map<Integer, ConfigFileDefinition> MAPPING = new HashMap<>();

    /**
     * The bit size flags.
     */
    private static final int[] BITS = new int[32];

    /**
     * The file id.
     */
    private final int id;

    /**
     * The config id.
     */
    private int configId;

    /**
     * The bit shift amount.
     */
    private int bitShift;

    /**
     * The bit amount.
     */
    private int bitSize;

    /**
     * Constructs a new {@code ConfigFileDefinition} {@code Object}.
     *
     * @param id The file id.
     */
    public ConfigFileDefinition(int id) {
        this.id = id;
    }

    /**
     * Initializes the bit flags.
     */
    static {
        int flag = 2;
        for (int i = 0; i < 32; i++) {
            BITS[i] = flag - 1;
            flag += flag;
        }
    }

    /**
     * Gets the config file definitions for the given file id.
     *
     * @param varBitId The file id.
     * @return The definition.
     */
    public static ConfigFileDefinition forId(int varBitId) {
        ConfigFileDefinition def = MAPPING.get(varBitId);
        if (def != null) {
            return def;
        }
        def = new ConfigFileDefinition(varBitId);
        byte[] bs = Cache.getIndexes()[2].getFileData(14, varBitId);
        if (bs != null) {
            ByteBuffer buffer = ByteBuffer.wrap(bs);
            int opcode = 0;
            while ((opcode = buffer.get() & 0xFF) != 0) {
                if (opcode == 1) {
                    def.configId = buffer.getShort() & 0xFFFF;
                    def.bitShift = buffer.get() & 0xFF;
                    def.bitSize = buffer.get() & 0xFF;
                }
            }
        }
        MAPPING.put(varBitId, def);
        return def;
    }

    public static void main(String... args) throws Throwable {
        GameWorld.prompt(false);
        for (int i = 0; i < 15000; i++) {
            ConfigFileDefinition def = forId(i);
            if (def != null && def.configId == 33) {
                System.out.println("Config file [id=" + i + ", shift=" + def.bitShift + "]!");
            }
        }
    }

    /**
     * Gets the current config value for this file.
     *
     * @param player The player.
     * @return The config value.
     */
    public int getValue(Player player) {
        int size = BITS[bitSize - bitShift];
        return size & player.getConfigManager().get(configId) >> bitShift;
    }

    /**
     * Gets the mapping.
     *
     * @return The mapping.
     */
    public static Map<Integer, ConfigFileDefinition> getMapping() {
        return MAPPING;
    }

    /**
     * Gets the id.
     *
     * @return The id.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the configId.
     *
     * @return The configId.
     */
    public int getConfigId() {
        return configId;
    }

    /**
     * Gets the bitShift.
     *
     * @return The bitShift.
     */
    public int getBitShift() {
        return bitShift;
    }

    /**
     * Gets the bitSize.
     *
     * @return The bitSize.
     */
    public int getBitSize() {
        return bitSize;
    }

    @Override
    public String toString() {
        return "ConfigFileDefinition [id=" + id + ", configId=" + configId + ", bitShift=" + bitShift + ", bitSize=" + bitSize + "]";
    }
}