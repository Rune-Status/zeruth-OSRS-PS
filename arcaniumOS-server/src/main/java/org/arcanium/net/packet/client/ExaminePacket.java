package org.arcanium.net.packet.client;

import org.arcanium.cache.Cache;
import org.arcanium.cache.def.impl.ItemDefinition;
import org.arcanium.cache.def.impl.NPCDefinition;
import org.arcanium.cache.def.impl.ObjectDefinition;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.tools.StringUtils;

import java.util.Arrays;

/**
 * Handles the incoming examine packets.
 *
 * @author Emperor
 */
public final class ExaminePacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
        String name;
        switch (buffer.opcode()) {
            /**
             * Correct as of 2/10/19
             * Rev 177
             */
            case 36: // Object examine
                int id = buffer.getShort128();
                if (id < 0 || id > Cache.getObjectDefinitionsSize()) {
                    break;
                }
                ObjectDefinition d = ObjectDefinition.forId(id);
                name = d.getName();
                player.debug("Object id: " + id + ", " + (d.getModelIds() != null ? Arrays.toString(d.getModelIds()) : null) + ", " + d.animationId);
                player.getPacketDispatch().sendMessage("It's a" + (StringUtils.isPlusN(name) ? "n " : " ") + name + ".");
                break;
            /**
             * Correct as of 2/10/19
             * Rev 177
             */
            case 24: // Item examine
                id = buffer.getShortLE();
                if (id < 0 || id > Cache.getItemDefinitionsSize()) {
                    break;
                }
                // System.out.println("Item: " + id + ", name: " +
                // ItemDefinition.forId(id).getName());
                player.getPacketDispatch().sendMessage(getItemExamine(id));
                break;
            /**
             * Correct as of 2/10/19
             * Rev 177
             */
            case 30: // NPC examine
                id = buffer.getShort128();
                if (id < 0 || id > Cache.getNPCDefinitionsSize()) {
                    break;
                }
                player.debug("NPC id: " + id + ".");
                NPCDefinition def = NPCDefinition.forId(id);
                if (def == null) {
                    break;
                }
                player.getPacketDispatch().sendMessage(def.getExamine());
                break;
        }
    }

    /**
     * Gets the item examine.
     *
     * @param id the id.
     * @return the name.
     */
    public static String getItemExamine(int id) {
        if (id == 995) {
            return "Lovely money!";
        }
        if (ItemDefinition.forId(id).getExamine().length() == 255) {
            return "A set of instructions to be followed.";
        }
        return ItemDefinition.forId(id).getExamine();
    }
}