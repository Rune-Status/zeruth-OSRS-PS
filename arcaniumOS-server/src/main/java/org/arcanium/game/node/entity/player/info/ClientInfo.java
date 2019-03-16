package org.arcanium.game.node.entity.player.info;

/**
 * Created by Chris on 8/15/2017.
 */
public final class ClientInfo {

    /**
     * The current window mode.
     */
    private int windowMode;

    /**
     * The screen width.
     */
    private int screenWidth;

    /**
     * The screen height.
     */
    private int screenHeight;

    /**
     * Constructs a new {@Code ClientInfo} {@Code Object}
     * @param windowMode The window mode.
     * @param screenWidth The screen width.
     * @param screenHeight The screen height.
     */
    public ClientInfo(int windowMode, int screenWidth, int screenHeight) {
        this.windowMode = windowMode;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    /**
     * Checks if the client screen is resizable.
     * @return {@code True} if so.
     */
    public boolean isResizable() {
        return windowMode > 1;
    }

    /**
     * Gets the windowMode.
     * @return the windowMode
     */
    public int getWindowMode() {
        return windowMode;
    }

    /**
     * Sets the windowMode.
     * @param windowMode the windowMode to set.
     */
    public void setWindowMode(int windowMode) {
        this.windowMode = windowMode;
    }

    /**
     * Gets the screenWidth.
     * @return the screenWidth
     */
    public int getScreenWidth() {
        return screenWidth;
    }

    /**
     * Sets the screenWidth.
     * @param screenWidth the screenWidth to set.
     */
    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    /**
     * Gets the screenHeight.
     * @return the screenHeight
     */
    public int getScreenHeight() {
        return screenHeight;
    }

    /**
     * Sets the screenHeight.
     * @param screenHeight the screenHeight to set.
     */
    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }
}