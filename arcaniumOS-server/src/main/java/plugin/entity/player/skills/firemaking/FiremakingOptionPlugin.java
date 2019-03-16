package plugin.entity.player.skills.firemaking;

import org.arcanium.game.content.global.tutorial.TutorialSession;
import org.arcanium.game.content.global.tutorial.TutorialStage;
import org.arcanium.game.content.skill.f2p.firemaking.FireMakingPulse;
import org.arcanium.game.interaction.NodeUsageEvent;
import org.arcanium.game.interaction.UseWithHandler;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.plugin.Plugin;

public class FiremakingOptionPlugin extends UseWithHandler {

    /**
     * Constructs a new {@code FireMakingOptionPlugin} {@code Object}.
     */
    public FiremakingOptionPlugin() {
        super(1511, 1521, 1513, 1515, 1517, 1519, 1521, 2862, 3438, 3440, 3442, 3444, 3446, 3448, 6211, 6213, 6332, 6333, 7404, 7405, 7406, 8934, 9067, 10328, 10329, 10808, 10810, 10812, 11035, 12581, 12583, 3125);
    }

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        addHandler(590, ITEM_TYPE, this);
        return this;
    }

    @Override
    public boolean handle(NodeUsageEvent event) {
        Item item = event.getUsedItem();
        if (item == null) {
            return false;
        }
        Player player = event.getPlayer();
        if (TutorialSession.getExtension(player).getStage() == 8) {
            TutorialStage.load(player, 9, false);
        }
        player.getPulseManager().run(new FireMakingPulse(player, item, null));
        return true;
    }

}
