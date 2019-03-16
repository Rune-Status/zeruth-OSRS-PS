package org.arcanium.game.content.dialogue;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.ChildPositionContext;
import org.arcanium.net.packet.server.RepositionChild;
import org.arcanium.tools.StringUtils;

/**
 * Represents a skill dialogue handler class.
 *
 * @author 'Vexia
 */
public class SkillDialogueHandler {

    /**
     * Represents the skill dialogue id.
     */
    public static final int SKILL_DIALOGUE = 3 << 16;

    /**
     * Represents the default child positions.
     */
    public static final int[][] DEFAULT_POSITIONS = new int[][] {{0, 0}};

    /**
     * Represents the player.
     */
    private final Player player;

    /**
     * Represents the skill dialogue type.
     */
    private final SkillDialogue type;

    /**
     * Represents the skills item positions.
     */
    private final int[][] positions;

    /**
     * Represents the zooms of the items.
     */
    private final int[] zooms;

    /**
     * Represents the names of the items.
     */
    private final String[] names;

    /**
     * Represents the object data passed through.
     */
    private final Object[] data;

    /**
     * Constructs a new {@code SkillDialogueHandler} {@code Object}.
     *
     * @param player the player.
     * @param type   the type.
     * @param data   the data.
     */
    public SkillDialogueHandler(final Player player, final SkillDialogue type, int[][] positions, int[] zooms, String[] names, final Object... data) {
        this.player = player;
        this.type = type;
        this.positions = positions;
        this.zooms = zooms;
        this.names = names;
        this.data = data;
    }

    /**
     * Constructs a new {@code SkillDialogueHandler} {@code Object}.
     *
     * @param player the player.
     * @param type   the type.
     * @param data   the data.
     */
    public SkillDialogueHandler(final Player player, final SkillDialogue type, int[][] positions, int[] zooms, final Object... data) {
        this.player = player;
        this.type = type;
        this.positions = positions;
        this.zooms = zooms;
        this.names = null;
        this.data = data;
    }

    /**
     * Constructs a new {@code SkillDialogueHandler} {@code Object}.
     *
     * @param player the player.
     * @param type   the type.
     * @param data   the data.
     */
    public SkillDialogueHandler(final Player player, final SkillDialogue type, int[][] positions, String[] names, final Object... data) {
        this.player = player;
        this.type = type;
        this.positions = positions;
        this.zooms = null;
        this.names = names;
        this.data = data;
    }

    /**
     * Constructs a new {@code SkillDialogueHandler} {@code Object}.
     *
     * @param player the player.
     * @param type   the type.
     * @param data   the data.
     */
    public SkillDialogueHandler(final Player player, final SkillDialogue type, int[][] positions, final Object... data) {
        this.player = player;
        this.type = type;
        this.positions = positions;
        this.zooms = null;
        this.names = null;
        this.data = data;
    }

    /**
     * Constructs a new {@code SkillDialogueHandler} {@code Object}.
     *
     * @param player the player.
     * @param type   the type.
     * @param data   the data.
     */
    public SkillDialogueHandler(final Player player, final SkillDialogue type, final Object... data) {
        this.player = player;
        this.type = type;
        this.positions = DEFAULT_POSITIONS;
        this.zooms = null;
        this.names = null;
        this.data = data;
    }

    /**
     * Method used to open a skill dialogue.
     */
    public void open() {
        player.getDialogueInterpreter().open(SKILL_DIALOGUE, this);
    }

    /**
     * Method used to display the content on the dialogue.
     */
    public void display() {
        type.display(player, this);
    }

    /**
     * Method used to create a product.
     *
     * @param amount the amount.
     * @param index  the index.
     */
    public void create(final int amount, int index) {
    }

    /**
     * Gets the total amount of items to be made.
     *
     * @param index the index.
     * @return the amount.
     */
    public int getAll(int index) {
        return 0;
    }

    /**
     * Gets the player.
     *
     * @return The player.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the type.
     *
     * @return The type.
     */
    public SkillDialogue getType() {
        return type;
    }

    /**
     * Gets the passed data.
     *
     * @return the data.
     */
    public Object[] getData() {
        return data;
    }

    /**
     * Gets the name.
     *
     * @param item the item.
     * @return the name.
     */
    protected String getName(Item item) {
        return StringUtils.formatDisplayName(item.getName().replace("Unfired", ""));
    }

    /**
     * Represents a skill dialogue type.
     *
     * @author 'Vexia
     */
    public enum SkillDialogue {
        ONE_OPTION(309, 5, 1) {
            @Override
            public void display(Player player, SkillDialogueHandler handler) {
                final Item item = (Item) handler.getData()[0];
                player.getPacketDispatch().sendString("<br><br><br><br>" + (handler.names != null ? handler.names[0] : item.getName()), 309, 6);
                player.getPacketDispatch().sendItemZoomOnInterface(item.getId(), handler.zooms != null ? handler.zooms[0] : 160, 309, 2);
                PacketRepository.send(RepositionChild.class, new ChildPositionContext(player, 309, 2, handler.positions[0][0], handler.positions[0][1]));
            }

            @Override
            public int getAmount(SkillDialogueHandler handler, final int buttonId) {
                return buttonId == 6 ? 1 : buttonId == 5 ? 5 : buttonId == 4 ? -1 : handler.getAll(getIndex(handler, buttonId));
            }
        }, TWO_OPTION(306, 0, 2) { //TODO: FIXME CHECKME
            @Override
            public void display(Player player, SkillDialogueHandler handler) {
                Item item;
                player.getInterfaceManager().openChatbox(306);
                for (int i = 0; i < handler.getData().length; i++) {
                    item = (Item) handler.getData()[i];
                    player.getPacketDispatch().sendString("<br><br><br><br>" + (handler.names != null ? handler.names[i] : item.getName()), 306, 7 + i);
                    player.getPacketDispatch().sendItemZoomOnInterface(item.getId(), handler.zooms != null ? handler.zooms[i] : 160, 306, 2 + i);
                }
            }
        },
        THREE_OPTION(304, 5, 3) {
            @Override
            public void display(Player player, SkillDialogueHandler handler) {
                Item item;
                for (int i = 0; i < 3; i++) {
                    item = (Item) handler.getData()[i];
                    player.getPacketDispatch().sendItemZoomOnInterface(item.getId(), handler.zooms != null ? handler.zooms[i] : 135, 304, 2 + i);
                    player.getPacketDispatch().sendString("<br><br><br><br>" + (handler.names != null ? handler.names[i] : item.getName()), 304, (304 - 296) + (i * 4));
                    PacketRepository.send(RepositionChild.class, new ChildPositionContext(player, 305, 2 + i, handler.positions[i][0], handler.positions[i][1]));
                }
            }
        },
        FOUR_OPTION(305, 6, 4) {
            @Override
            public void display(Player player, SkillDialogueHandler handler) {
                Item item;
                player.getInterfaceManager().openChatbox(305);
                for (int i = 0; i < 4; i++) {
                    item = (Item) handler.getData()[i];
                    player.getPacketDispatch().sendItemZoomOnInterface(item.getId(), handler.zooms != null ? handler.zooms[i] : 160, 305, 2 + i);
                    player.getPacketDispatch().sendString("<br><br><br><br>" + (handler.names != null ? handler.names[i] : item.getName()), 305, (305 - 296) + (i * 4));
                    PacketRepository.send(RepositionChild.class, new ChildPositionContext(player, 305, 2 + i, handler.positions[i][0], handler.positions[i][1]));
                }
            }
        },
        FIVE_OPTION(306, 7, 5) {
            @Override
            public void display(Player player, SkillDialogueHandler handler) {
                Item item;
                player.getInterfaceManager().openChatbox(306);
                for (int i = 0; i < handler.getData().length; i++) {
                    item = (Item) handler.getData()[i];
                    player.getPacketDispatch().sendString("<br><br><br><br>" + (handler.names != null ? handler.names[i] : item.getName()), 306, 10 + (4 * i));
                    player.getPacketDispatch().sendItemZoomOnInterface(item.getId(), handler.zooms != null ? handler.zooms[i] : 160, 306, 2 + i);
                    PacketRepository.send(RepositionChild.class, new ChildPositionContext(player, 306, 2 + i, handler.positions[i][0], handler.positions[i][1]));
                }
            }
        };

        /**
         * Represents the interface id.
         */
        private final int interfaceId;

        /**
         * Represents the base button.
         */
        private final int baseButton;

        /**
         * Represents the length.
         */
        private final int length;

        /**
         * Constructs a new {@code SkillDialogue} {@code Object}.
         *
         * @param interfaceId the interface id.
         * @param baseButton  the base button.
         * @param length      the length.
         */
        SkillDialogue(final int interfaceId, final int baseButton, final int length) {
            this.interfaceId = interfaceId;
            this.baseButton = baseButton;
            this.length = length;
        }

        /**
         * Method used to display the content for this type.
         *
         * @param player  the player.
         * @param handler the handler.
         */
        public void display(final Player player, final SkillDialogueHandler handler) {

        }

        /**
         * Gets the amount.
         *
         * @param handler  the handler.
         * @param buttonId the buttonId.
         * @return the amount.
         */
        public int getAmount(SkillDialogueHandler handler, final int buttonId) {
            for (int k = 0; k < 4; k++) {
                for (int i = 0; i < length; i++) {
                    int val = (baseButton + k) + (4 * i);
                    if (val == buttonId) {
                        return k == 3 ? 1 : k == 2 ? 5 : k == 1 ? 10 : -1;
                    }
                }
            }
            return 0;
        }

        /**
         * Gets the index selected.
         *
         * @param handler  the handler.
         * @param buttonId the buttonId.
         * @return the index selected.
         */
        public int getIndex(SkillDialogueHandler handler, final int buttonId) {
            int index = 0;
            for (int k = 0; k < 4; k++) {
                for (int i = 1; i < length; i++) {
                    int val = (baseButton + k) + (4 * i);
                    if (val == buttonId) {
                        return index + 1;
                    } else if (val <= buttonId) {
                        index++;
                    }
                }
                index = 0;
            }
            return index;
        }

        /**
         * Gets the interfaceId.
         *
         * @return The interfaceId.
         */
        public int getInterfaceId() {
            return interfaceId;
        }

    }
}