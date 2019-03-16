package org.arcanium.game.content.skill;

import org.arcanium.game.content.global.Skillcape;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.EmoteData;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.MusicContext;
import org.arcanium.net.packet.server.MusicPacket;

/**
 * Represents a leveling up action.
 *
 * @author Emperor
 */
public final class LevelUp {

    /**
     * The skill interface ids.
     */
    private static final int[] SKILL_INTERFACES = {158, 161, 175, 167, 171, 170, 168, 159, 177, 165, 233, 163, 160, 174, 169, 166, 157, 176, 173, 162, 172, 172, 395, 630};

    /**
     * Level up sound ids.
     */
    private static final int[] SOUND_EFFECTS = {29, 37, 65, 48, 57, 55, 52, 33, 69, 44, 41, 39, 35, 43, 53, 45, 28, 34, 62, 11, 60, 49, 31, 300};

    /**
     * The skillcapes data.
     */
    private static final int[] SKILLCAPES = {9747, // Attack
            9753, // Defence
            9750, // Strength
            9768, // Hitpoints
            9756, // Range
            9759, // Prayer
            9762, // Magic
            9801, // Cooking
            9807, // Woodcutting
            9783, // Fletching
            9798, // Fishing
            9804, // Firemaking
            9780, // Crafting
            9795, // Smithing
            9792, // Mining
            9774, // Herblore
            9771, // Agility
            9777, // Thieving
            9786, // Slayer
            9810, // Farming
            9765, // Runecrafting
            9948, // Hunter
            9789, // Construction
            12169 // Summoning
    };

    /**
     * Sends the level up interface etc.
     *
     * @param player The player.
     * @param slot   The skill slot.
     */
    public static void levelup(Player player, int slot) {
        System.out.println("sending level up (" + slot + ")");
        // if (player.getAttribute("tut-island") != null) {
        //   return;
        //}
        // if (TutorialSession.getExtension(player).getStage() < TutorialSession.MAX_STAGE) {
        //  return;
        // }
        int interfaceId = 233;
        int soundId = SOUND_EFFECTS[slot];
        if (soundId > -1) {
            PacketRepository.send(MusicPacket.class, new MusicContext(player, soundId, true));
        }
        player.getPacketDispatch().sendGraphic(199);
        player.getPacketDispatch().sendCS2Script(2379, new Object[]{2260});
        player.getPacketDispatch().sendInterface(162, 29, 233, false);
        player.getPacketDispatch().sendString("Click here to continue", 233, 3);

        player.getPacketDispatch().sendString("<col=00008B>Congratulations, you've just advanced a " + Skills.SKILL_NAME[slot] + " level!", interfaceId, 1);
        player.getPacketDispatch().sendString("Your " + Skills.SKILL_NAME[slot] + " level is now " + player.getSkills().getStaticLevel(slot) + ".", interfaceId, 2);
        player.getPacketDispatch().sendMessage("You've just advanced a " + Skills.SKILL_NAME[slot] + " level! You have reached level " + player.getSkills().getStaticLevel(slot) + ".");
        if (slot == Skills.PRAYER) {
            player.getSkills().incrementPrayerPoints(1);
        }
        if (player.getSkills().getStaticLevel(slot) == 99) {
            Repository.sendNews(player.getUsername() + " has just achieved 99 " + Skills.SKILL_NAME[slot]);
            Skillcape.trim(player);
            player.getEmotes().unlock(EmoteData.SKILLCAPE);
        }
        player.getInterfaceManager().openChatbox(interfaceId);
        if (slot == Skills.HUNTER) {
            player.getPacketDispatch().sendItemOnInterface(9951, 1, interfaceId, 3);
        }
    }

    /**
     * @return the skillcapes
     */
    public static int[] getSkillcapes() {
        return SKILLCAPES;
    }

}