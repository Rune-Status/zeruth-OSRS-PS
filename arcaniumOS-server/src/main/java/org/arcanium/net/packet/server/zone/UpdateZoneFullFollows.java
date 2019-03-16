package org.arcanium.net.packet.server.zone;

import org.arcanium.game.world.map.Location;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.ClearChunkContext;

/**
 * Handles the clear region chunk outgoing packet.
 *
 * @author Emperor
 */
public final class UpdateZoneFullFollows implements ServerPacket<ClearChunkContext> {

    @Override
    public void send(ClearChunkContext context) {
        Location l = context.getPlayer().getPlayerFlags().getLastSceneGraph();
        int x = context.getChunk().getCurrentBase().getSceneX(l);
        int y = context.getChunk().getCurrentBase().getSceneY(l);
        if (x >= 0 && y >= 0 && x < 104 && y < 104) {
            IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.UPDATE_ZONE_FULL_FOLLOWS.getPacketId()).putN(y).put(x);
            context.getPlayer().getSession().write(buffer);
        }
    }

}
