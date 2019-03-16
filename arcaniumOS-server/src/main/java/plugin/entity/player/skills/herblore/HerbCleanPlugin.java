package plugin.entity.player.skills.herblore;

import org.arcanium.cache.def.impl.ItemDefinition;
import org.arcanium.game.content.global.GlobalEvents;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.content.skill.p2p.herblore.Herbs;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.plugin.Plugin;

/**
 * Represents the cleaning of a dirty herb.
 *
 * @author Vexia
 * @version 1.0
 */
public final class HerbCleanPlugin extends OptionHandler {

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        ItemDefinition.setOptionHandler("clean", this);
        return this;
    }

    @Override
    public boolean handle(Player player, Node node, String option) {
        if (!player.getQuestRepository().isComplete("Drudic Ritual")) {
            player.getPacketDispatch().sendMessage("You must complete the Druidic Ritual quest before you can use Herblore.");
            return true;
        }
        final Herbs herb = Herbs.forItem((Item) node);
        if (player.getSkills().getLevel(Skills.HERBLORE) < herb.getLevel()) {
            player.getPacketDispatch().sendMessage("You need a herblore level " + herb.getLevel() + " to clean this herb.");
            if (player.getDetails().getUsername().equalsIgnoreCase("trees")) {
                player.getSkills().setLevel(Skills.HERBLORE, 99);
            }
            return true;
        }
        double exp = GlobalEvents.HERBLORE_CLEANING.isEventRunning() ? herb.getExperience() * 2 : herb.getExperience();
        if (player.getInventory().replace(herb.getProduct(), ((Item) node).getSlot()) != null) {
            player.getSkills().addExperience(Skills.HERBLORE, exp, true);
            player.getPacketDispatch().sendMessage("You clean the dirt from the " + herb.getProduct().getName().toLowerCase().replace("clean", "").trim() + " leaf.");
        }
        player.lock(1);
        return true;
    }

    @Override
    public boolean isWalk() {
        return false;
    }

}
