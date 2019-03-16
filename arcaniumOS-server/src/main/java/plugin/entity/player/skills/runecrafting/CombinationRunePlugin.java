package plugin.entity.player.skills.runecrafting;

import org.arcanium.game.content.skill.f2p.runecrafting.*;
import org.arcanium.game.interaction.NodeUsageEvent;
import org.arcanium.game.interaction.UseWithHandler;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.plugin.Plugin;

/**
 * Handles the combination runes.
 *
 * @author Vexia
 */
public final class CombinationRunePlugin extends UseWithHandler {

    /**
     * Constructs a new {@code CombinationRunePlugin} {@code Object}.
     */
    public CombinationRunePlugin() {
        super(Talisman.AIR.getTalisman().getId(), Talisman.WATER.getTalisman().getId(), Talisman.EARTH.getTalisman().getId(), Talisman.FIRE.getTalisman().getId(), Rune.WATER.getRune().getId(), Rune.EARTH.getRune().getId(), Rune.AIR.getRune().getId(), Rune.FIRE.getRune().getId());
    }

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        for (Altar altar : Altar.values()) {
            addHandler(altar.getObject(), OBJECT_TYPE, this);
        }
        return this;
    }

    @Override
    public boolean handle(NodeUsageEvent event) {
        final Player player = event.getPlayer();
        final Altar altar = Altar.forObject(((GameObject) event.getUsedWith()));
        final CombinationRune combo = CombinationRune.forAltar(altar, event.getUsedItem());
        if (combo == null) {
            return false;
        }
        player.getPulseManager().run(new RuneCraftPulse(player, event.getUsedItem(), altar, true, combo));
        return true;
    }

}
