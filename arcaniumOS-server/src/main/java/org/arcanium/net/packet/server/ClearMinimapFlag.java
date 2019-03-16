package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.PlayerContext;

/**
 * Handles the removal of the minimap flag.
 *
 * @author Emperor
 */
public final class ClearMinimapFlag implements ServerPacket<PlayerContext> {

    @Override
    public void send(PlayerContext context) {
        context.getPlayer().getDetails().getSession().write(new IoBuffer(ServerProt.ServerPackets.SET_MAP_FLAG.getPacketId()).put(255).put(255));
    }

}