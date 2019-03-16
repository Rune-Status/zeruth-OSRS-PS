package org.arcanium.net.packet.client;

import org.arcanium.game.interaction.NodeUsageEvent;
import org.arcanium.game.interaction.UseWithHandler;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles item used on entity packet.
 *
 * @author Emperor
 */
public class ItemUseOnPacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
        if (player.getLocks().isInteractionLocked()) {
            return;
        }
        switch (buffer.opcode()) {
            case 58: // Item on NPC
                int itemId = buffer.getShortLE();
                int interfaceId = buffer.getIntV1() >> 16;
                int slotId = buffer.getShort128();
                int npcIndex = buffer.getShortLE();
                NPC npc = Repository.getNpcs().get(npcIndex);
                Item item = player.getInventory().get(slotId);
                if (item == null || item.getId() != itemId) {
                    return;
                }
                NodeUsageEvent event = new NodeUsageEvent(player, interfaceId, item, npc);
                UseWithHandler.run(event);
                break;
            case 61: // Item on Player
                interfaceId = buffer.getInt() >> 16;
                itemId = buffer.getShort();
                slotId = buffer.getShortLEA();
                int playerIndex = buffer.getShort128();
                Player target = Repository.getPlayers().get(playerIndex);
                item = player.getInventory().get(slotId);
                if (target == null || item == null || item.getId() != itemId) {
                    return;
                }
                event = new NodeUsageEvent(player, interfaceId, item, target);
                UseWithHandler.run(event);
                break;
        }
    }

}
