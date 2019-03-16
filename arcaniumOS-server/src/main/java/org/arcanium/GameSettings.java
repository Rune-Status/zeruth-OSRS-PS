package org.arcanium;

import org.arcanium.game.system.SystemLogger;
import org.arcanium.game.world.GameType;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Represents the game settings used for this game instance.
 *
 * @author Vexia
 */
public final class GameSettings {

    /**
     * The name of the namme.
     */
    private final String name;

    /**
     * If the game is in beta mode.
     */
    private final boolean beta;

    /**
     * If the game is in developer mode.
     */
    private final boolean devMode;

    /**
     * If the gui is enabled.
     */
    private final boolean gui;

    /**
     * The game type.
     */
    private final GameType type = GameType.ECONOMY;

    /**
     * The world id of the server.
     */
    private final int worldId;

    /**
     * The country index.
     */
    private final int countryIndex;

    /**
     * If the world is members only.
     */
    private final boolean members;

    /**
     * The address of the Management server.
     */
    private final String msAddress;

    /**
     * Constructs a new {@code GameSettings} {@code Object}.
     *
     * @param name         the name.
     * @param beta         the beta.
     * @param type         the game type.
     * @param gui          if gui is enabled.
     * @param worldId      the world id.
     * @param countryIndex The country index.
     * @param members      If the world is members only.
     * @param msAddress    The address of the Management server.
     */
    GameSettings(String name, boolean beta, boolean devMode, boolean gui, int worldId, int countryIndex, boolean members, String msAddress) {
        this.name = name;
        this.beta = beta;
        this.devMode = devMode;
        this.gui = gui;
        this.worldId = worldId;
        this.countryIndex = countryIndex;
        this.members = members;
        this.msAddress = msAddress;
    }

    /**
     * Parses the game settings from the program arguments.
     *
     * @param args The program arguments.
     * @return The game settings.
     */
    public static GameSettings parse(String[] args) {
        String name = "Inferno";
        boolean beta = false;
        boolean devMode = true;
        boolean gui = true;
        int worldId = 2;
        int country = 0;
        boolean members = true;
        String msAddress = NetworkConstants.DEFAULT_MS_IP;
        for (String arg : args) {
            if (arg.startsWith("name=")) {
                name = arg.replace("name=", "");
            } else if (arg.startsWith("beta=")) {
                beta = Boolean.parseBoolean(arg.replace("beta=", ""));
            } else if (arg.startsWith("devMode=")) {
                devMode = Boolean.parseBoolean(arg.replace("devMode=", ""));
            } else if (arg.startsWith("gui=")) {
                gui = Boolean.parseBoolean(arg.replace("gui=", ""));
            } else if (arg.startsWith("world=")) {
                worldId = Integer.parseInt(arg.replace("world=", ""));
            } else if (arg.startsWith("country=")) {
                country = Integer.parseInt(arg.replace("country=", ""));
            } else if (arg.startsWith("members=")) {
                members = Boolean.parseBoolean(arg.replace("members=", ""));
            } else if (arg.startsWith("msip=")) {
                msAddress = arg.replace("msip=", "");
            }
        }
        return new GameSettings(name, beta, devMode, gui, worldId, country, members, msAddress);
    }

    /**
     * Parses a game settings file.
     *
     * @param path the path.
     * @return the settings.
     */
    public static GameSettings parse(final String path) {
        final Properties properties = getProperties(path);
        String address = NetworkConstants.DEFAULT_MS_IP;
        if (properties.containsKey("msip")) {
            address = properties.getProperty("msip");
        }
        return new GameSettings(properties.getProperty("name"), Boolean.parseBoolean(properties.getProperty("beta")), Boolean.parseBoolean(properties.getProperty("devMode")), Boolean.parseBoolean(properties.getProperty("gui")), Integer.parseInt(properties.getProperty("worldId")), Integer.parseInt(properties.getProperty("country")), Boolean.parseBoolean(properties.getProperty("members")), address);
    }

    /**
     * Gets the properties.
     *
     * @param path the path.
     * @return the properties.
     */
    private static Properties getProperties(String path) {
        FileInputStream file;
        Properties properties = new Properties();
        try {
            file = new FileInputStream(path);
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * Gets the devMode.
     *
     * @return The devMode.
     */
    public boolean isDevMode() {
        return devMode;
    }

    /**
     * Gets the name.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the beta.
     *
     * @return The beta.
     */
    public boolean isBeta() {
        return beta;
    }

    /**
     * Gets the type.
     *
     * @return The type.
     */
    public GameType getType() {
        return type;
    }

    /**
     * Checks if the server is hosted publicly.
     *
     * @return {@code True} if so.
     */
    public boolean isHosted() {
        return !devMode;
    }

    /**
     * Checks if its an economy type.
     *
     * @return {@code True} if so.
     */
    public boolean isEconomy() {
        return getType() == GameType.ECONOMY;
    }

    /**
     * Gets the gui.
     *
     * @return The gui.
     */
    public boolean isGui() {
        return gui;
    }

    /**
     * Gets the worldId.
     *
     * @return The worldId.
     */
    public int getWorldId() {
        return worldId;
    }

    @Override
    public String toString() {
        if (!isEconomy()) {
            if (!devMode) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to enter Spawn Mode?");
                if (result != 0) {
                    System.exit(-1);
                    return "";
                }
            }
            SystemLogger.log("Arcanium is running in SPAWN mode!");
        }
        return "GameSettings [name=" + name + ", beta=" + beta + ", devMode=" + devMode + ", gui=" + gui + ", type=" + type + ", worldId=" + worldId + "]";
    }

    /**
     * Gets the countryIndex.
     *
     * @return the countryIndex
     */
    public int getCountryIndex() {
        return countryIndex;
    }

    /**
     * Gets the members.
     *
     * @return the members
     */
    public boolean isMembers() {
        return members;
    }

    /**
     * Gets the msAddress.
     *
     * @return the msAddress
     */
    public String getMsAddress() {
        return msAddress;
    }
}
