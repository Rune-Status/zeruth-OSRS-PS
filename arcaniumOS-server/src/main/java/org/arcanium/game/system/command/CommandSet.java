package org.arcanium.game.system.command;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.info.Rights;
import org.arcanium.game.system.SystemManager;
import org.arcanium.game.world.GameWorld;

/**
 * Represents a command set.
 * @author Vexia
 */
public enum CommandSet {
    PLAYER(), MODERATOR() {
	@Override
	public boolean validate(Player player) {
	    return player.getDetails().getRights().ordinal() > 0 && SystemManager.getSystemConfig().isStaff(player.getName());
	}
    },
    ADMINISTRATOR() {
	@Override
	public boolean validate(Player player) {
	    return player.getDetails().getRights().equals(Rights.ADMINISTRATOR) && SystemManager.getSystemConfig().isAdmin(player.getName());
	}
    },
    DEVELOPER() {
	@Override
	public boolean validate(Player player) {
	    if (!ADMINISTRATOR.validate(player)) {
		return false;
	    }
	    return SystemManager.getSystemConfig().isAdmin(player.getName());
	}
    },
    BETA() {
	@Override
	public boolean validate(Player player) {
	    return GameWorld.getSettings().isBeta() || ADMINISTRATOR.validate(player) || GameWorld.getSettings().isDevMode();
	}
    };

    /**
     * Constructs a new {@code CommandSet} {@code Object}.
     */
    private CommandSet() {
	/*
	 * empty.
	 */
    }

    /**
     * Checks if the player can use this set.
     * @param player the player.
     */
    public boolean validate(final Player player) {
	return true;
    }

    /**
     * Interprets and incoming command by dispatching it to it's plugins.
     * @param player the player.
     * @param name the name.
     * @param arguments the arguments.
     * @return <code>True</code> if the command was interpreted.
     */
    public boolean interpret(final Player player, final String name, final String... arguments) {
	if (player == null) {
	    return false;
	}
	if (!validate(player)) {
	    return false;
	}

	if (player.getZoneMonitor().parseCommand(player, name, arguments)) {
	    return true;
	}
	if (PlayerCommands.parse(player, name, arguments)) {
	    return true;
	}
	return false;
    }
}
