package org.arcanium.game.node.entity.player.info.portal;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.system.SystemManager;
import org.arcanium.parser.player.SavingModule;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * A punishment.
 * @author Vexia
 */
public abstract class Punishment implements SavingModule {

    /**
     * Represents the date at wich the punishment is terminated.
     */
    protected long end = 0L;

    /**
     * Represents if this punishment is permanent.
     */
    protected boolean permanent;

    /**
     * If a temporary, non-saved punishment is enabled.
     */
    private boolean temporary;

    /**
     * Method used to inflict any other related damage/messages/alters to the
     * player.
     */
    public abstract void inflict(final Player player);

    @Override
    public void parse(ByteBuffer buffer) {
	end = buffer.getLong();
    }

    @Override
    public void save(ByteBuffer buffer) {
	if (end != 0L) {
	    buffer.put((byte) (this instanceof Mute ? 1 : 0));
	    buffer.putLong(end);
	}
    }

    /**
     * Punishes the player.
     * @param player The player.
     * @param end The end time (use System.currentTimeMillis() + duration).
     * @return {@code True} if successful.
     */
    public boolean punish(Player player, long end) {
	if (SystemManager.getSystemConfig().isAdmin(player.getName())) {
	    return false;
	}
	if (end > System.currentTimeMillis()) {
	    inflict(player);
	} else {
	    permanent = false;
	}
	this.end = end;
	return true;
    }

    /**
     * Punishes the player.
     * @param days the days to restrict.
     */
    public boolean punish(Player player, int days) {
	if (SystemManager.getSystemConfig().isAdmin(player.getName())) {
	    return false;
	}
	if (player.getDetails().getPortal().getBlackMarks() >= 10 || days == Integer.MAX_VALUE) {
	    permanent = true;
	}
	setDays(days);
	inflict(player);
	return true;
    }

    /**
     * Method used to set the days to restrict this punishment.
     * @param days the days to punish.
     */
    private final void setDays(final int days) {
	end = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(days);
    }

    /**
     * Method used to reset a punishment.
     */
    public final void reset() {
	end = 0L;
	permanent = false;
    }

    /**
     * Method used to check if the player is punished.
     * @return <code>True</code> if punished and <code>False</code> if not.
     */
    public final boolean isPunished() {
	return permanent || end > System.currentTimeMillis() || temporary;
    }

    /**
     * Gets the temporary.
     * @return the temporary
     */
    public boolean isTemporary() {
	return temporary;
    }

    /**
     * Sets the temporary.
     * @param temporary the temporary to set.
     */
    public void setTemporary(boolean temporary) {
	this.temporary = temporary;
    }
}
