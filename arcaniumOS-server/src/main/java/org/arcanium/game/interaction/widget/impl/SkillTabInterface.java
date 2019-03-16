package org.arcanium.game.interaction.widget.impl;

import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.node.entity.player.Player;

/**
 * 174 Skill Tab && Interface Handler
 *
 * @author trees
 */
public class SkillTabInterface {

    /**
     * Sends the interface to client
     *
     * @param player
     * @param skill
     */
    public static boolean open(Player player, Skill skill) {
        if (skill == null) {
            return false;
        }
        player.getConfigManager().sendVarp(965, skill.config_1);
        player.getConfigManager().sendVarp(965, skill.config_2);
        player.getPacketDispatch().sendCS2Script(2524, new Object[]{4600861, 80});//ii
        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 214, false);
        return true;
    }

    /**
     * Skill Tab Selection Data
     */
    public enum Skill {
        ATT(Skills.ATTACK, 2, 1), STR(Skills.STRENGTH, 1, 2), DEF(Skills.DEFENCE, 0, 5), RAN(Skills.RANGE, 5, 3), PRAY(Skills.PRAYER, 3, 7), MAG(Skills.MAGIC, 7, 4), RUNEC(Skills.RUNECRAFTING, 4, 12),
        CONS(Skills.CONSTRUCTION, 12, 22), HIT(Skills.HITPOINTS, 22, 6), AGI(Skills.AGILITY, 6, 8), HER(Skills.HERBLORE, 8, 9), THIE(Skills.THIEVING, 9, 10), CRAF(Skills.CRAFTING, 10, 11),
        FLE(Skills.FLETCHING, 11, 19), SLA(Skills.SLAYER, 19, 20), HUN(Skills.HUNTER, 20, 23), MIN(Skills.MINING, 23, 13), SMI(Skills.SMITHING, 13, 14), FIS(Skills.FISHING, 14, 15), COO(Skills.COOKING, 15, 16),
        FIR(Skills.FIREMAKING, 16, 17), WOO(Skills.WOODCUTTING, 17, 18), FAR(Skills.FARMING, 18, 21);

        int skill_id;
        int config_1;
        int config_2;

        Skill(int id, int int_1, int int_2) {
            this.skill_id = id;
            this.config_1 = int_1;
            this.config_2 = int_2;
        }
    }
}
