package org.arcanium.game.world.update.flag;

import org.arcanium.game.node.entity.player.Player;

/**
 * @author Sean
 */
public enum GlobalUpdateStage {

	ADD_PLAYER,
	HEIGHT_UPDATED,
	MAP_REGION_DIRECTION,
	TELEPORTED;

	/**
	 * Gets the global update stages.
	 * @param player The player for the update,
	 * @param otherPlayer The players to update for.
	 * @return The state.
	 */
	public static GlobalUpdateStage getStage(Player player, Player otherPlayer) {
		if (otherPlayer == null || !(otherPlayer.isActive())) {
			return null;
		} else if (player != otherPlayer && player.getLocation().withinDistance(otherPlayer.getLocation())) {
			return ADD_PLAYER;
		} else if (otherPlayer.getLastLocation() != null && otherPlayer.getLocation().getZ() != otherPlayer.getLastLocation().getZ()) {
			return HEIGHT_UPDATED;
		} else if (otherPlayer.getProperties().isTeleporting()) {
			return TELEPORTED;
		}
		return null;
	}
}