package org.arcanium.game.system;

import org.arcanium.game.world.repository.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Holds the system configurations from the database.
 *
 * @author Vexia
 */
public class SystemConfig {

    /**
     * The system-objec configurations.
     */
    private final Map<String, Object> configs = new HashMap<>();

    /**
     * The admin names.
     */
    private final List<String> admins = new ArrayList<>();

    /**
     * The moderator names.
     */
    private final List<String> moderators = new ArrayList<>();

    /**
     * The beta users.
     */
    private final List<String> betaUsers = new ArrayList<>();

    /**
     * The mac addresses.
     */
    private final List<String> macs = new ArrayList<>();

    /**
     * Constructs a new {@Code SystemConfig} {@Code Object}
     */
    public SystemConfig() {
    /*
	 * empty.
	 */
    }

    /**
     * Reloads the system configurations.
     */
    public void reload() {
        admins.clear();
        moderators.clear();
        macs.clear();
        configs.clear();
        betaUsers.clear();
        if (getConfig("dxp", false)) {
            Repository.sendNews("A double XP weekend is now active!");
        }
    }

    /**
     * Checks if the serial is an approved staff-serial.
     *
     * @param serial the serial.
     * @return {@code True} if so.
     */
    public boolean checkSerial(String serial) {
        return macs.contains(serial);
    }

    /**
     * Checks if the name is an admin approved name.
     *
     * @param name the name.
     * @return {@code True} if so.
     */
    public boolean isAdmin(String name) {
        return admins.contains(name);
    }

    /**
     * Checks if the name is a staff-approved name.
     *
     * @param name the name.
     * @return {@code True} if a staff member.
     */
    public boolean isStaff(String name) {
        return moderators.contains(name) || admins.contains(name);
    }

    /**
     * Splits the data into an array list using a regex.
     *
     * @param data  the data.
     * @param regex the regex to split.
     * @return the list of data.
     */
    public List<String> split(String data, String regex) {
        List<String> split = new ArrayList<>();
        String[] tokens = data.trim().split(regex);
        for (String s : tokens) {
            split.add(s);
        }
        return split;
    }

    /**
     * Gets an attribute.
     *
     * @param key The attribute name.
     * @return The attribute value.
     */
    @SuppressWarnings("unchecked")
    public <T> T getConfig(String key) {
        if (!configs.containsKey(key)) {
            return null;
        }
        return (T) configs.get(key);
    }

    /**
     * Gets an attribute.
     *
     * @param string The attribute name.
     * @param fail   The value to return if the attribute is null.
     * @return The attribute value, or the fail argument when null.
     */
    @SuppressWarnings("unchecked")
    public <T> T getConfig(String string, T fail) {
        Object object = configs.get(string);
        if (object != null) {
            return (T) object;
        }
        return fail;
    }

    /**
     * Gets the admins.
     *
     * @return the admins.
     */
    public List<String> getAdmins() {
        return admins;
    }

    /**
     * Gets the moderators.
     *
     * @return the moderators.
     */
    public List<String> getModerators() {
        return moderators;
    }

    /**
     * Gets the macs.
     *
     * @return the macs.
     */
    public List<String> getMacs() {
        return macs;
    }

    /**
     * Gets the configs.
     *
     * @return the configs.
     */
    public Map<String, Object> getConfigs() {
        return configs;
    }

    /**
     * Gets the betaUsers.
     *
     * @return the betaUsers.
     */
    public List<String> getBetaUsers() {
        return betaUsers;
    }

}
