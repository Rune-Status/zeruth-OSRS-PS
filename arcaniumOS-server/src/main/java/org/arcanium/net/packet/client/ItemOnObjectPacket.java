package org.arcanium.net.packet.client;

import org.arcanium.game.interaction.NodeUsageEvent;
import org.arcanium.game.interaction.UseWithHandler;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.PlayerContext;
import org.arcanium.net.packet.server.ClearMinimapFlag;

/**
 * Handles the item on object packethandler.
 * @author 'Vexia
 */
public class ItemOnObjectPacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	if (player.getLocks().isInteractionLocked()) {
	    return;
	}
	switch (buffer.opcode()) {
	case 122:
	    int x = buffer.getShort();
	    int slot = buffer.getShort();
	    buffer.getIntV1();
	    int id = buffer.getShortLE();
	    int y = buffer.getShortLEA();
	    int objectId = buffer.getShortLE();
	    int z = player.getLocation().getZ();
	    GameObject object = RegionManager.getObject(z, x, y);
	    if (object == null || object.getId() != objectId) {
		PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
		return;
	    }
	    object = object.getChild(player);
	    if (object == null) {
		PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
		break;
	    }
	    final Item used = player.getInventory().get(slot);
	    if (used == null || used.getId() != id) {
		return;
	    }
	    final NodeUsageEvent event = new NodeUsageEvent(player, 0, used, object);
	    UseWithHandler.run(event);
	    break;
	}
    }

}
