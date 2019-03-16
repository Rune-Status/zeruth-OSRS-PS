package plugin.entity.npc;

import org.arcanium.cache.def.impl.NPCDefinition;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.map.Location;
import org.arcanium.plugin.Plugin;

/**
 * Handles the NPC talk-to option.
 *
 * @author Emperor
 */
public final class NPCTalkPlugin extends OptionHandler {

    @Override
    public Location getDestination(Node n, Node node) {
        NPC npc = (NPC) node;
        if (npc.getAttribute("facing_booth", false)) {
            int offsetX = npc.getDirection().getStepX() << 1;
            int offsetY = npc.getDirection().getStepY() << 1;
            return npc.getLocation().transform(offsetX, offsetY, 0);
        }
        return null;
    }

    @Override
    public boolean handle(Player player, Node node, String option) {
        final NPC npc = (NPC) node;
        if (npc !=null) {
            npc.faceLocation(player.getLocation());
        }
        return player.getDialogueInterpreter().open(npc.getId(), npc);
    }

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        NPCDefinition.setOptionHandler("talk-to", this);
        return this;
    }

    @Override
    public boolean isWalk() {
        return true;
    }

}