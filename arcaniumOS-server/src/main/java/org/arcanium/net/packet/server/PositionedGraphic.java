package org.arcanium.net.packet.server;

import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.update.flag.context.Graphics;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.PositionedGraphicContext;
import org.arcanium.net.packet.server.zone.UpdateZonePartialFollows;

/**
 * The positioned graphic outgoing packet.
 *
 * @author Emperor
 */
public final class PositionedGraphic implements ServerPacket<PositionedGraphicContext> {

    @Override
    public void send(PositionedGraphicContext context) {
        Location l = context.getLocation();
        Graphics g = context.getGraphic();
        final int targetLocalX = l.getX() - (l.getChunkX() << 4);
        final int targetLocalY = l.getY() - (l.getChunkY() << 4);
        final int offsetHash = (targetLocalX & 0x7) << 4 | (targetLocalY & 0x7);
        IoBuffer buffer = new UpdateZonePartialFollows().getBuffer(context.getPlayer(), l);
        IoBuffer gBuffer = new IoBuffer(143);
        gBuffer.put(offsetHash).putShort(g.getId()).put(g.getHeight()).putShort(g.getDelay());
        context.getPlayer().getSession().write(buffer);
        context.getPlayer().getSession().write(gBuffer);
    }

}
