package plugin.entity.player.skills.runecrafting;

import org.arcanium.cache.def.impl.ItemDefinition;
import org.arcanium.cache.def.impl.NPCDefinition;
import org.arcanium.cache.def.impl.ObjectDefinition;
import org.arcanium.game.component.Component;
import org.arcanium.game.content.global.action.ClimbActionHandler;
import org.arcanium.game.content.global.travel.EssenceTeleport;
import org.arcanium.game.content.skill.f2p.runecrafting.Altar;
import org.arcanium.game.content.skill.f2p.runecrafting.MysteriousRuin;
import org.arcanium.game.content.skill.f2p.runecrafting.RuneCraftPulse;
import org.arcanium.game.content.skill.f2p.runecrafting.Talisman;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.system.task.Pulse;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.map.Location;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.MinimapStateContext;
import org.arcanium.net.packet.server.MinimapState;
import org.arcanium.plugin.Plugin;
import org.arcanium.plugin.PluginManager;
import plugin.entity.player.skills.runecrafting.abyss.AbyssPlugin;

/**
 * Handles runecrafting related options.
 *
 * @author Vexia
 */
public class RunecraftingPlugin extends OptionHandler {

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        addNodes();
        PluginManager.definePlugin(new AbyssPlugin());
        PluginManager.definePlugin(new TiaraPlugin());
        PluginManager.definePlugin(new RunePouchPlugin());
        PluginManager.definePlugin(new EnchantTiaraPlugin());
        PluginManager.definePlugin(new MysteriousRuinPlugin());
        PluginManager.definePlugin(new CombinationRunePlugin());
        ObjectDefinition.forId(2492).getConfigurations().put("option:use", this);
        NPCDefinition.forId(637).getConfigurations().put("option:teleport", this);
        NPCDefinition.forId(2581).getConfigurations().put("option:teleport", this);
        ObjectDefinition.forId(26849).getConfigurations().put("option:climb", this);
        ObjectDefinition.forId(26850).getConfigurations().put("option:climb", this);
        ObjectDefinition.forId(268).getConfigurations().put("option:climb", this);
        ObjectDefinition.forId(26844).getConfigurations().put("option:squeeze-through", this);
        ObjectDefinition.forId(26845).getConfigurations().put("option:squeeze-through", this);
        return this;
    }

    @Override
    public boolean handle(final Player player, Node node, String option) {
        switch (node.getId()) {
            case 2492:
                EssenceTeleport.home(player);
                return true;
            case 26844:
            case 26845:
                final Location location = node.getId() == 26845 ? new Location(3309, 4820, 0) : new Location(3311, 4817, 0);
                player.lock(4);
                player.getInterfaceManager().openOverlay(new Component(115));
                PacketRepository.send(MinimapState.class, new MinimapStateContext(player, 1));
                GameWorld.submit(new Pulse(4, player) {

                    @Override
                    public boolean pulse() {
                        player.teleport(location);
                        player.getInterfaceManager().close();
                        player.getInterfaceManager().closeOverlay();
                        PacketRepository.send(MinimapState.class, new MinimapStateContext(player, 0));
                        return true;
                    }

                });
                return true;
            case 553:
            case 2328:
            case 844:
                EssenceTeleport.teleport(((NPC) node), player);
                return true;
        }
        switch (option) {
            case "use":
                final Altar altar = Altar.forObject(((GameObject) node));
                player.getProperties().setTeleportLocation(altar.getRuin().getBase());
                break;
            case "craft-rune":
                if (node.getLocation().equals(new Location(3151, 3484))) {
                    player.sendMessage("You can only craft Astral runes on Lunar Isle.");
                    return true;
                }
                player.getPulseManager().run(new RuneCraftPulse(player, null, Altar.forObject(((GameObject) node)), false, null));
                break;
            case "locate":
                final Talisman talisman = Talisman.forItem(((Item) node));
                talisman.locate(player);
                break;
            case "enter":
                final MysteriousRuin ruin = MysteriousRuin.forObject(((GameObject) node));
                if (ruin == null) {
                    return true;
                }
                ruin.enter(player);
                break;
            case "climb":
                int id = ((GameObject) node).getId();
                switch (id) {
                    case 26849:
                        ClimbActionHandler.climb(player, null, new Location(3271, 4861, 0));
                        break;
                    case 26850:
                        ClimbActionHandler.climb(player, null, new Location(2452, 3230, 0));
                        break;
                }
                break;
        }
        return true;
    }

    /**
     * Adds the nodes to this plugin.
     */
    private void addNodes() {
        for (Altar altar : Altar.values()) {
            ObjectDefinition.forId(altar.getObject()).getConfigurations().put("option:craft-rune", this);
            ObjectDefinition.forId(altar.getPortal()).getConfigurations().put("option:use", this);
        }
        for (MysteriousRuin ruin : MysteriousRuin.values()) {
            for (int i : ruin.getObject()) {
                ObjectDefinition.forId(i).getConfigurations().put("option:enter", this);
            }
        }
        for (Talisman talisman : Talisman.values()) {
            ItemDefinition.forId(talisman.getTalisman().getId()).getConfigurations().put("option:locate", this);
        }
    }

    @Override
    public boolean isWalk() {
        return false;
    }

    @Override
    public boolean isWalk(final Player player, final Node node) {
        return !(node instanceof Item);
    }

}
