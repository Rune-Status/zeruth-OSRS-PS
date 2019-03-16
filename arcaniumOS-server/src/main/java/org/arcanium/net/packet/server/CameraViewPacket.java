package org.arcanium.net.packet.server;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.map.Location;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.CameraContext;

/**
 * Handles the outgoing camera view packets.
 *
 * @author Emperor
 */
public final class CameraViewPacket implements ServerPacket<CameraContext> {

    @Override
    public void send(CameraContext context) {
        CameraContext.CameraType type = context.getType();
        IoBuffer buffer = new IoBuffer(type.opcode());
        Location l = Location.create(context.getX(), context.getY(), 0);
        Player p = context.getPlayer();
        switch (type) {
            case ROTATION:
            case POSITION:
                int x = l.getSceneX(p.getPlayerFlags().getLastSceneGraph());
                int y = l.getSceneY(p.getPlayerFlags().getLastSceneGraph());
                buffer.put(x).put(y).putShort(context.getHeight()).put(context.getSpeed()).put(context.getZoomSpeed());
                break;
            case SET:
                buffer.put(context.getX()).put(context.getY());
                break;
            case SHAKE:
                buffer.put(l.getX()).put(l.getY()).put(context.getSpeed()).put(context.getZoomSpeed()).putShort(context.getHeight());
                break;
            case RESET:
                break;
        }
        p.getSession().write(buffer);
    }

}
