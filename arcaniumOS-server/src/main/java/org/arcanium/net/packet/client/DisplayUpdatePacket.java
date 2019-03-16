package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;

public class DisplayUpdatePacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
        int windowMode = buffer.getByte(); //Window mode
        int screenWidth = buffer.getShort();
        int screenHeight = buffer.getShort();
        player.getDetails().getClientInfo().setScreenWidth(screenWidth);
        player.getDetails().getClientInfo().setScreenHeight(screenHeight);
        player.getInterfaceManager().switchWindowMode(windowMode);
    }

}
