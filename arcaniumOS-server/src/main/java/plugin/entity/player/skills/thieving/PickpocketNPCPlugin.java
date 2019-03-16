package plugin.entity.player.skills.thieving;

import org.arcanium.cache.def.impl.NPCDefinition;
import org.arcanium.game.content.skill.p2p.thieving.Pickpocket;
import org.arcanium.game.content.skill.p2p.thieving.PickpocketPulse;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.map.Location;
import org.arcanium.plugin.Plugin;

/**
 * Handles the NPC pickpocket option.
 *
 * @author trees
 */
public final class PickpocketNPCPlugin extends OptionHandler {

    @Override
    public Location getDestination(Node n, Node node) {
        NPC npc = (NPC) node;
        int offsetX = npc.getDirection().getStepX() << 1;
        int offsetY = npc.getDirection().getStepY() << 1;
        return npc.getLocation().transform(offsetX, offsetY, 0);
    }

    @Override
    public boolean handle(Player player, Node node, String option) {
        final NPC npc = (NPC) node;
        npc.faceLocation(player.getLocation());
        System.out.println("thieving handling : [ " + option + " ]" + Pickpocket.forNPC(npc));
        player.getPulseManager().run(new PickpocketPulse(player, npc, Pickpocket.forNPC(npc)));
        return true;
    }


    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        NPCDefinition.setOptionHandler("pickpocket", this);
        for (Pickpocket pick_val : Pickpocket.values()) {
            for (int i = 0; i < pick_val.getNpc().length; i++) {
                NPCDefinition.forId(pick_val.getNpc()[i]).getConfigurations().put("option:pickpocket", this); // MAN
                ///System.out.println("Added pickpocket option to npc (" + pick_val.getNpc()[i] + ")");
            }
        }
        return this;
    }
}