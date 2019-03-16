package plugin.entity.player.skills.mining;

import org.arcanium.cache.def.impl.ObjectDefinition;
import org.arcanium.game.content.skill.f2p.gather.GatheringSkillPulse;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.map.Location;
import org.arcanium.plugin.Plugin;

public class MiningMinePlugin extends OptionHandler {

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        ObjectDefinition.setOptionHandler("mine", this);
        return this;
    }

    @Override
    public boolean handle(Player player, Node node, String option) {
        System.out.println("handling mining");
        player.faceLocation(new Location(node.getLocation().getX(), node.getLocation().getY(), node.getLocation().getZ()));
        player.getPulseManager().run(new GatheringSkillPulse(player, node.asObject()));
        return true;
    }

    @Override
    public boolean isWalk() {
        return true;
    }

}
