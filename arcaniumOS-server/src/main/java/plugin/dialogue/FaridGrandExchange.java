package plugin.dialogue;

import org.arcanium.game.content.dialogue.DialoguePlugin;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;

/**
 * Handles the FaridGrandExchange dialogue.
 *
 * @author trees
 */
public class FaridGrandExchange extends DialoguePlugin {

    public FaridGrandExchange() {

    }

    public FaridGrandExchange(Player player) {
        super(player);
    }

    @Override
    public DialoguePlugin newInstance(Player player) {

        return new FaridGrandExchange(player);
    }

    @Override
    public boolean open(Object... args) {
        npc = (NPC) args[0];
        player.getPacketDispatch().sendCS2Script(2524, new Object[]{-1, -1});//ii
        player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 237, false);
        player.getPacketDispatch().sendCS2Script(799, new Object[]{118, "Ores and Bars"});//vs
        return true;
    }

    @Override
    public boolean handle(int interfaceId, int buttonId) {
        System.out.println("handling farid g.e");
        return true;
    }

    @Override
    public int[] getIds() {
        return new int[]{3115};
    }
}