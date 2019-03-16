package org.arcanium.game.content.skill.p2p.thieving.impl;

import org.arcanium.game.content.skill.p2p.thieving.Pickpocket;
import org.arcanium.game.content.skill.p2p.thieving.PickpocketPulse;
import org.arcanium.game.content.skill.p2p.thieving.Stall;
import org.arcanium.game.content.skill.p2p.thieving.StallThiefPulse;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.object.GameObject;

/**
 * Represents the plugin used to handle thieving options.
 * @author 'Vexia
 * @date 22/10/2013
 */
public class ThievingOption{

	public static boolean handle(Player player, Node node, String option) {
		switch (option) {
		case "pick-pocket":
		case "pickpocket":
			player.getPulseManager().run(new PickpocketPulse(player,(NPC) node, Pickpocket.forNPC((NPC) node)));
			return true;
		case "steal-from":
		case "steal from":
			player.getPulseManager().run(new StallThiefPulse(player, (GameObject) node, Stall.forObject((GameObject) node)));
			return true;
		}
		return false;
	}

}
