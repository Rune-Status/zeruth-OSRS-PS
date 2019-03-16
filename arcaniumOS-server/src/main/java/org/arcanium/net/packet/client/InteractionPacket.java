package org.arcanium.net.packet.client;

import org.arcanium.ServerConstants;
import org.arcanium.game.interaction.Interaction;
import org.arcanium.game.interaction.Option;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.GroundItem;
import org.arcanium.game.node.item.GroundItemManager;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.system.SystemLogger;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.PlayerContext;
import org.arcanium.net.packet.server.ClearMinimapFlag;

/**
 * Handles the incoming interaction packets.
 *
 * @author Emperor
 */
public final class InteractionPacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
        System.out.println("Interaction packet opcode received : " + buffer.opcode());
        if (player == null) {
            return;
        }
        if (buffer.opcode() != 105) {
            player = getPlayer(player);
        }
        if (player.getLocks().isInteractionLocked() || !player.getInterfaceManager().close()) {
            return;
        }
        // TODO: Possible chatbox closing ?
        int x = 0, y = 0, index = 0;
        int objectId = 0;
        switch (buffer.opcode()) {
            /**
             * Correct as of 2/4/19 rev 177
             */
            case 71: // NPC INTERACTION 1 // talk to
                buffer.getByteC();
                index = buffer.getShortLE();
                handleNPCInteraction(player, 0, index);
                return;
            /**
             * Correct as of 2/4/19 rev 177
             */
            case 1: // NPC INTERACTION 2 //attack
                index = buffer.getShort128();
                buffer.getByte();
                handleNPCInteraction(player, 1, index);
                return;
            /**
             * Correct as of 2/4/19 rev 177
             */
            case 33: // NPC INTERACTION 3 //pickpocket
                index = buffer.getShortLEA();
                System.out.println("[Pickpocket Interaction] ID " + index);
                buffer.getByte();
                handleNPCInteraction(player, 2, index);
                return;
            /**
             * Correct as of 2/4/19 rev 177
             */
            case 59: // NPC INTERACTION 4
                index = buffer.getShort();
                buffer.getByte128();
                System.out.println("[NPC Interaction 4] ID " + index);
                handleNPCInteraction(player, 3, index);
                return;
            /**
             * Correct as of 2/4/19 rev 177
             */
            case 31: // NPC INTERACTION 5
                buffer.getByte();
                index = buffer.getShort128();
                handleNPCInteraction(player, 4, index);
                return;
            /**
             * Correct as of 2/14/19 rev 177
             */
            case 47: // Player action 1
                index = buffer.getShort();
                buffer.getByteC();
                handlePlayerInteraction(player, 0, index);
                break;
            /**
             * Correct as of 2/14/19 rev 177
             */
            case 56: // Player action 2
                buffer.getByte128();
                index = buffer.getShort128();
                handlePlayerInteraction(player, 1, index);
                break;
            /**
             * Correct as of 2/14/19 rev 177
             */
            case 62: // Player action 3
                index = buffer.getShort128();
                buffer.getByte();
                handlePlayerInteraction(player, 2, index);
                break;
            /**
             * Correct as of 2/14/19 rev 177
             */
            case 27: // Player action 4
                index = buffer.getShortLEA();
                buffer.getByteC();
                handlePlayerInteraction(player, 3, index);
                break;
            /**
             * Correct as of 2/14/19 rev 177
             */
            case 83: // Player action 5
                buffer.getByte128();
                index = buffer.getShort128();
                handlePlayerInteraction(player, 4, index);
                break;
            /**
             * Correct as of 2/14/19 rev 177
             */
            case 93: // Player action 6
                index = buffer.getShort128();
                buffer.getByteS();
                handlePlayerInteraction(player, 5, index);
                break;
            /**
             * Correct as of 2/14/19 rev 177
             */
            case 75: // Player action 7
                buffer.getByteS();
                index = buffer.getShortLE();
                handlePlayerInteraction(player, 6, index);
                break;
            /**
             * Correct as of 2/14/19 rev 177
             */
            case 50: // Player action 8
                buffer.getByteC();
                index = buffer.getShortLEA();
                handlePlayerInteraction(player, 7, index);
                break;
            /**
             * Correct as of 2/4/19 rev 177
             */
            case 10: // Object action 1
                y = buffer.getShort();
                buffer.getByteS();
                objectId = buffer.getShortA();
                x = buffer.getShortLEA();
                handleObjectInteraction(player, 0, x, y, objectId);
                break;
            /**
             * Correct as of 2/14/19 rev 177
             */
            case 79: // Object action 2
                buffer.getByte128();
                objectId = buffer.getShort() & 0xFFFF;
                y = buffer.getShort();
                x = buffer.getShort();
                handleObjectInteraction(player, 1, x, y, objectId);
                break;
            /**
             * Correct as of 2/14/19 rev 177
             */
            case 44: // Object action 3
                y = buffer.getShortLEA();
                int slot = buffer.getShortLE();
                int ctrlRun = buffer.getByte128();
                int interfaceHash = buffer.getLEInt();
                x = buffer.getShortLEA();
                objectId = buffer.getShort();
                index = buffer.getShortLE();

                System.out.println("[OPLOCU] Y: " + y);
                System.out.println("[OPLOCU] Slot: " + slot);
                System.out.println("[OPLOCU] Ctrl Run: " + ctrlRun);
                System.out.println("[OPLOCU] Hash: " + interfaceHash);
                System.out.println("[OPLOCU] X: " + x);
                System.out.println("[OPLOCU] Object ID: " + objectId);
                System.out.println("[OPLOCU] Index: " + index);

                handleObjectInteraction(player, 2, x, y, objectId);
                break;
            /**
             * Working as of 2/10/19
             * Rev 177
             */
            case 6: // Ground item action 2
                y = buffer.getShortLE();
                buffer.getByteS(); //whether or not ctrl is being held or not, used to run to item or not
                x = buffer.getShortLE();
                int itemId = buffer.getShortLE();

                System.out.println(y);
                System.out.println(x);
                System.out.println(itemId);

                handleGroundItemInteraction(player, 2, itemId, Location.create(x, y, player.getLocation().getZ()));
                break;
            case 18: // Ground item action 2
                itemId = buffer.getShortLE();
                y = buffer.getShortLEA();
                buffer.getByte();
                x = buffer.getShort128();
                handleGroundItemInteraction(player, 0, itemId, Location.create(x, y, player.getLocation().getZ()));
                break;
        }
    }

    /**
     * Handles the NPC interaction.
     *
     * @param player      the player.
     * @param optionIndex option index.
     * @param index       the index.
     */
    private static void handleNPCInteraction(Player player, int optionIndex, final int index) {
        if (ServerConstants.DEBUG) {
            System.out.println("[InteractionPacket] Option Index Click (" + optionIndex + ")");
        }
        if (index < 1 || index > ServerConstants.MAX_NPCS) {
            PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
            return;
        }
        final NPC npc = Repository.getNpcs().get(index);
        if (npc == null) {
            System.out.println("[NPC INTERACTION] NPC IS NULL");
            PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
            return;
        }
        if (player.getAttribute("removenpc", false)) {
            npc.clear();
            player.getPacketDispatch().sendMessage("Removed npc=" + npc.toString());
            return;
        }

        if (npc.getInteraction().get(optionIndex) == null) {
            SystemLogger.log("[InteractionPacket] " + npc.getInteraction().get(optionIndex) + " npc option index for [" + npc.toString() + "]");
            return;
        }

        final Option option = npc.getInteraction().get(optionIndex).getName().equalsIgnoreCase("attack") ? Option._P_ATTACK : npc.getInteraction().get(optionIndex);

        System.out.println("[NPC INTERACTION]  (" + (index) + ") OPTION : " + (option != null ? option.getName().toLowerCase() : "null"));
        if (option == null) {
            PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
            Interaction.handleInvalidInteraction(player, npc, Option.NULL);
            return;
        }
        if (ServerConstants.DEBUG) {
            System.out.println("NPC Interacting with \"" + npc.getName() + "\" [index=" + index + ", renderable=" + npc.isRenderable() + "]");
            System.out.println("option=" + option.getName() + ", slot=" + option.getIndex() + ", id=" + npc.getId() + " original=" + npc.getId() + ", location=" + npc.getLocation() + ".");
        }
        npc.getInteraction().handle(player, option);
    }

    /**
     * Handles object interaction
     *
     * @param player      The interacting player.
     * @param optionIndex The option index.
     * @param x           The x-coordinate of the object.
     * @param y           The y-coordinate of the object.
     * @param objectId    The object id.
     */
    private static void handleObjectInteraction(final Player player, int optionIndex, int x, int y, int objectId) {
        GameObject object = RegionManager.getObject(player.getLocation().getZ(), x, y);
        try {
            //player.debug(object.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (object == null || object.getId() != objectId) {
            PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
            Interaction.handleInvalidInteraction(player, object, Option.NULL);
            return;
        }
        if (!object.isActive()) {
            PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
            Interaction.handleInvalidInteraction(player, object, Option.NULL);
            return;
        }
        object = object.getChild(player);
        Option option = object.getInteraction().get(optionIndex);

        if (option == null) {
            player.debug("Invalid option" + object + ", original: " + objectId + ".");
            PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
            Interaction.handleInvalidInteraction(player, object, Option.NULL);
            return;
        }
        player.debug(object + ", original=" + objectId + ", option=" + option.getName() + "");
        player.debug("dir=" + object.getDirection());
        if (option.getHandler() != null) {
            player.debug("Object handler: " + option.getHandler().getClass().getSimpleName());
        }
        System.out.println("GameObject Interaction(" + objectId + ") interaction was " + object + " at location " + x + ", " + y + ".");

        object.getInteraction().handle(player, option);
    }

    /**
     * Handles player interaction.
     *
     * @param player      player interacting.
     * @param optionIndex The option index.
     * @param index       The target index.
     */
    private static void handlePlayerInteraction(Player player, int optionIndex, int index) {
        if (index < 1 || index > ServerConstants.MAX_PLAYERS) {
            PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
            return;
        }
        final Player target = Repository.getPlayers().get(index);
        if (target == null || !target.isActive()) {
            PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
            return;
        }
        final Option option = player.getInteraction().get(optionIndex);
        if (option == null) {
            PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
            return;
        }
        target.getInteraction().handle(player, option);
    }

    /**
     * Handles the ground item interaction.
     *
     * @param player   The player.
     * @param index    The index of the action.
     * @param itemId   The item id.
     * @param location location of the item.
     */
    private static void handleGroundItemInteraction(final Player player, int index, int itemId, Location location) {
        final GroundItem item = GroundItemManager.get(itemId, location, player);
        if (item == null) {
            PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
            return;
        }
        final Option option = item.getInteraction().get(index);
        if (option == null) {
            PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
            Interaction.handleInvalidInteraction(player, item, Option.NULL);
            return;
        }
        item.getInteraction().handle(player, option);
    }

    /**
     * Gets the player instance (used for AIP controlling).
     *
     * @param player The player.
     * @return The player instance, or the AIP when the player is controlling an
     * AIP.
     */
    private static Player getPlayer(Player player) {
        return player;
    }

}