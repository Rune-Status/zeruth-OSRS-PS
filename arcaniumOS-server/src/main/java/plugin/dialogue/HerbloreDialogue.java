package plugin.dialogue;

import org.arcanium.game.content.dialogue.DialoguePlugin;
import org.arcanium.game.content.skill.p2p.herblore.GenericPotion;
import org.arcanium.game.content.skill.p2p.herblore.HerblorePulse;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.RunScript;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.ChildPositionContext;
import org.arcanium.net.packet.server.RepositionChild;

/**
 * Represents the dialogue used to determine the amount of a potion to make.
 *
 * @author 'Vexia
 * @version 1.0
 */
public final class HerbloreDialogue extends DialoguePlugin {

    /**
     * Represents this dialogues id.
     */
    public static final int ID = 21947748;

    /**
     * Represents the generic potion to create.
     */
    private GenericPotion potion;

    /**
     * Constructs a new {@code HerbloreDialogue} {@code Object}.
     */
    public HerbloreDialogue() {
        /**
         * empty.
         */
    }

    /**
     * Constructs a new {@code HerbloreDialogue} {@code Object}.
     *
     * @param player the player.
     */
    public HerbloreDialogue(Player player) {
        super(player);
    }

    @Override
    public DialoguePlugin newInstance(Player player) {
        return new HerbloreDialogue(player);
    }

    @Override
    public boolean open(Object... args) {
        System.out.println("Sending herblore dialogue");
        potion = (GenericPotion) args[0];
        player.getInterfaceManager().openChatbox(309);
        PacketRepository.send(RepositionChild.class, new ChildPositionContext(player, 309, 3, 60, 79));
        PacketRepository.send(RepositionChild.class, new ChildPositionContext(player, 309, 2, 210, 27));
        player.getPacketDispatch().sendItemZoomOnInterface(potion.getProduct().getId(), 160, 309, 2);
        player.getPacketDispatch().sendString(potion.getProduct().getName().replace("(unf)", ""), 309, 3);
        stage = 0;
        return true;
    }

    @Override
    public boolean handle(int interfaceId, int buttonId) {
        switch (stage) {
            case 0:
                int amount = getAmount(buttonId);
                if (amount == -1) {
                    player.setAttribute("runscript", new RunScript() {
                        @Override
                        public boolean handle() {
                            int amount = (int) value;
                            player.getPulseManager().run(new HerblorePulse(player, potion.getBase(), amount, potion));
                            end();
                            return false;
                        }
                    });
                    player.getDialogueInterpreter().sendInput(false, "Enter amount:");
                    return true;
                }
                player.getPulseManager().run(new HerblorePulse(player, potion.getBase(), amount, potion));
                end();
                break;
        }
        return true;
    }

    @Override
    public int[] getIds() {
        return new int[]{ID};
    }

    /**
     * Method used to get the amount to make based off the button id.
     *
     * @param buttonId the button id.
     * @return the amount to make.
     */
    private final int getAmount(final int buttonId) {
        switch (buttonId) {
            case 6:
                return 1;
            case 5:
                return 5;
            case 4:
                return -1;
        }
        return -1;
    }
}