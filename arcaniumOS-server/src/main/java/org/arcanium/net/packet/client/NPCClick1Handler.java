package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

public class NPCClick1Handler implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	final boolean run = buffer.getByte128() == 0;
	final int npcId = buffer.getShortLE();
	
	final NPC n = Repository.getNpcs().get(npcId);
	if (n == null)
	    return;
	player.teleport(n.getCenterLocation());
	
       /** int windowMode = buffer.get(); //Window mode
        int screenWidth = buffer.getShort();
        int screenHeight = buffer.getShort();
        player.getDetails().getClientInfo().setScreenWidth(screenWidth);
        player.getDetails().getClientInfo().setScreenHeight(screenHeight);
        player.getInterfaceManager().switchWindowMode(windowMode);*/
    }
}
