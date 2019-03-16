package org.arcanium.game.content.skill.f2p.firemaking;

/**
 * Represents an enumeration of burnable logs.
 *
 * @author 'Vexia
 */
public enum Log {
    NORMAL(1511, 1, 180, 26185, 40),
    ACHEY(2862, 1, 180, 26185, 40),
    OAK(1521, 15, 200, 26185, 60),
    WILLOW(1519, 30, 250, 26185, 90),
    TEAK(6333, 35, 300, 26185, 105),
    ARCTIC_PINE(10810, 42, 500, 26185, 125),
    MAPLE(1517, 45, 300, 26185, 135),
    MAHOGANY(6332, 50, 300, 26185, 157.5),
    EUCALYPTUS(12581, 58, 300, 26185, 193.5),
    YEW(1515, 60, 400, 26185, 202.5),
    MAGIC(1513, 75, 450, 26185, 303.8),
    CURSED_MAGIC(13567, 82, 650, 26185, 303.8),
    PURPLE(10329, 1, 200, 20001, 50),
    WHITE(10328, 1, 200, 20000, 50),
    BLUE(7406, 1, 200, 11406, 50),
    GREEN(7405, 1, 200, 11405, 50),
    RED(7404, 1, 200, 11404, 50),
    JOGRE(3125, 1, 200, 3862, 50);
    /**
     * The log id.
     */
    private final int logId;

    /**
     * The level.
     */
    private final int level;

    /**
     * The life.
     */
    private final int life;

    /**
     * The fire id.
     */
    private final int fireId;

    /**
     * The exp gained.
     */
    private final double xp;

    /**
     * Constructs a new {@code FireMakingDefinitions.java} {@code Object}.
     *
     * @param logId  the log id.
     * @param level  the level.
     * @param life   the life.
     * @param fireId the fire id.
     * @param xp     the experience.
     * @param time   the time.
     */
    Log(int logId, int level, int life, int fireId, double xp) {
        this.logId = logId;
        this.level = level;
        this.life = life;
        this.fireId = fireId;
        this.xp = xp;
    }

    /**
     * Gets the logId.
     *
     * @return The logId.
     */
    public int getLogId() {
        return logId;
    }

    /**
     * Gets the level.
     *
     * @return The level.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets the life.
     *
     * @return The life.
     */
    public int getLife() {
        return life;
    }

    /**
     * Gets the fireId.
     *
     * @return The fireId.
     */
    public int getFireId() {
        return fireId;
    }

    /**
     * Gets the xp.
     *
     * @return The xp.
     */
    public double getXp() {
        return xp;
    }

    /**
     * Gets the log by the id.
     *
     * @param id the id.
     * @return the log.
     */
    public static Log forId(int id) {
        for (Log fire : Log.values()) {
            if (fire.getLogId() == id) {
                return fire;
            }
        }
        return null;
    }
}