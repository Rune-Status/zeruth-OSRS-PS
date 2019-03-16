package org.arcanium.game.content.skill.f2p.fishing;

import org.arcanium.game.content.global.tutorial.TutorialSession;
import org.arcanium.game.content.global.tutorial.TutorialStage;
import org.arcanium.game.content.skill.SkillPulse;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.info.portal.Perks;
import org.arcanium.game.node.entity.player.link.diary.DiaryType;
import org.arcanium.game.world.map.Location;

/**
 * Handles a fishing pulse.
 *
 * @author Vexia
 */
public final class FishingPulse extends SkillPulse<NPC> {

    /**
     * Represents the fishing option.
     */
    private final FishingOption option;

    /**
     * Represents the fish type.
     */
    private Fish fish;

    /**
     * Represents the base location the npc was at.
     */
    private final Location location;

    /**
     * Constructs a new {@code FishingPulse} {@code Object}.
     *
     * @param player the player.
     * @param npc    the fishing spot NPC.
     * @param option The fishing option.
     */
    public FishingPulse(final Player player, final NPC npc, final FishingOption option) {
        super(player, npc);
        this.option = option;
        this.location = npc.getLocation();
        if (option != null) {
            this.fish = option.getRandomFish(player);
        }
    }

    @Override
    public void start() {
        /*if (TutorialSession.getExtension(player).getStage() == 12) {
            TutorialStage.load(player, 13, false);
        }*/
        super.start();
    }

    @Override
    public boolean checkRequirements() {
        if (option == null) {
            return false;
        }

        if (!player.getInventory().containsItem(option.getTool()) && !hasBarbTail()) {
            player.getDialogueInterpreter().sendDialogue("You need a " + option.getTool().getName().toLowerCase() + " to catch these fish.");
            stop();
            return false;
        }
        if (option.getBait() != null && !player.getInventory().containsItem(option.getBait())) {
            player.getDialogueInterpreter().sendDialogue("You don't have any " + option.getBait().getName().toLowerCase() + "s left.");
            stop();
            return false;
        }
        if (player.getSkills().getLevel(Skills.FISHING) < fish.getLevel()) {
            player.getDialogueInterpreter().sendDialogue("You need a fishing level of " + fish.getLevel() + " to catch " + (fish == Fish.SHRIMP || fish == Fish.ANCHOVIE ? "" : "a") + " " + fish.getItem().getName().toLowerCase() + ".".trim());
            stop();
            return false;
        }
        if (player.getInventory().freeSlots() == 0) {
            player.getDialogueInterpreter().sendDialogue("You don't have enough space in your inventory.");
            stop();
            return false;
        }
        if (location != node.getLocation() || !node.isActive() || node.isHidden()) {
            stop();
            return false;
        }
        return true;
    }

    @Override
    public void animate() {
        player.animate(option.getAnimation());
    }

    @Override
    public boolean reward() {
        if (getDelay() == 1) {
            super.setDelay(5);
            return false;
        }
        if (node.getId() == 333 && player.getZoneMonitor().isInZone("karamja") && player.getLocation().withinDistance(new Location(2924, 3178, 0), 10) && !player.getAchievementDiaryManager().hasCompletedTask(DiaryType.KARAMJA, 0, 6)) {
            player.getAchievementDiaryManager().updateTask(player, DiaryType.KARAMJA, 0, 6, true);
        }
        if (success()) {
            if (player.getInventory().hasSpaceFor(fish.getItem()) && option.getBait() != null ? player.getInventory().remove(option.getBait()) : true) {
                if (fish == Fish.TROUT && player.getLocation().withinDistance(new Location(3105, 3429, 0)) && !player.getAchievementDiaryManager().getDiary(DiaryType.VARROCK).isComplete(0, 11)) {
                    player.getAchievementDiaryManager().getDiary(DiaryType.VARROCK).updateTask(player, 0, 11, true);
                }
                Perks.addDouble(player, fish.getItem());
                player.getSkills().addExperience(Skills.FISHING, fish.getExperience(), true);
                message(2);
                if (TutorialSession.getExtension(player).getStage() == 13) {
                    TutorialStage.load(player, 14, false);
                    stop();
                    return true;
                }
                fish = option.getRandomFish(player);
            }
        }
        return player.getInventory().freeSlots() == 0;
    }

    /**
     * Checks if they have the barb tail harpoon.
     *
     * @return {@code True} if so.
     */
    private boolean hasBarbTail() {
        if (option == FishingOption.HARPOON) {
            if (player.getInventory().containsItem(FishingOption.BARB_HARPOON.getTool()) || player.getEquipment().containsItem(FishingOption.BARB_HARPOON.getTool())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void message(int type) {
        switch (type) {
            case 0:
                player.getPacketDispatch().sendMessage(option.getStartMessage());
                break;
            case 2:
                player.getPacketDispatch().sendMessage(fish == Fish.ANCHOVIE || fish == Fish.SHRIMP ? "You catch some " + fish.getItem().getName().toLowerCase().replace("raw", "").trim() + "." : "You catch a " + fish.getItem().getName().toLowerCase().replace("raw", "").trim() + ".");
                if (player.getInventory().freeSlots() == 0) {
                    player.getDialogueInterpreter().sendDialogue("You don't have enough space in your inventory.");
                    stop();
                }
                break;
        }
    }

    /**
     * Method used to check if the catch was a success.
     *
     * @param player the player.
     * @return <code>True</code> if so.
     */
    private boolean success() {
        if (getDelay() == 1) {
            return false;
        }
        int level = 1 + player.getSkills().getLevel(Skills.FISHING);
        double hostRatio = Math.random() * fish.getLevel();
        double clientRatio = Math.random() * ((level * 1.25 - fish.getLevel()));
        return hostRatio < clientRatio;
    }
}