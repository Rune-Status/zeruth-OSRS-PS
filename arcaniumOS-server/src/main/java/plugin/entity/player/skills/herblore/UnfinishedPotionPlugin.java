package plugin.entity.player.skills.herblore;

import org.arcanium.game.content.skill.p2p.herblore.GenericPotion;
import org.arcanium.game.content.skill.p2p.herblore.UnfinishedPotion;
import org.arcanium.game.interaction.NodeUsageEvent;
import org.arcanium.game.interaction.UseWithHandler;
import org.arcanium.plugin.Plugin;

/**
 * Represents the plugin used to handle the creation of creation an unf-potion.
 *
 * @author 'Vexia
 */
public final class UnfinishedPotionPlugin extends UseWithHandler {

    /**
     * Constructs a new {@code UnfinishedPotionPlugin} {@code Object}.
     */
    public UnfinishedPotionPlugin() {
        super(227, 5935);
    }

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        for (UnfinishedPotion potion : UnfinishedPotion.values()) {
            addHandler(potion.getIngredient().getId(), ITEM_TYPE, this);
        }
        return this;
    }

    @Override
    public boolean handle(NodeUsageEvent event) {
        final UnfinishedPotion potion = UnfinishedPotion.forItem(event.getUsedItem(), event.getBaseItem());
        if (potion == null) {
            return false;
        }
        event.getPlayer().getDialogueInterpreter().open(21947748, GenericPotion.transform(potion));
        return true;
    }

}
