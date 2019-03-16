package org.arcanium.net.packet.server;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.update.flag.context.Animation;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.AnimateObjectContext;
import org.arcanium.net.packet.server.zone.UpdateZonePartialFollows;

/**
 * Represents the packet used to animate an object.
 *
 * @author 'Vexia
 * @date 10/11/2013
 */
public class AnimateObjectPacket implements ServerPacket<AnimateObjectContext> {

    /**
     * Writes the packet.
     *
     * @param buffer The buffer.
     * @param item   The item.
     */
    public static IoBuffer write(IoBuffer buffer, Animation animation) {
        GameObject object = animation.getObject();
        Location l = object.getLocation();
        buffer.put(23);
        buffer.putByte128((l.getChunkOffsetX() << 4) | (l.getChunkOffsetY() & 0x7));
        buffer.putShortLE(animation.getId());
        buffer.putByteC((object.getType() << 2) + (object.getRotation() & 0x3));
        return buffer;
    }

    @Override
    public void send(AnimateObjectContext context) {
        Player player = context.getPlayer();
        GameObject object = context.getAnimation().getObject();
        Location l = object.getLocation();
        Animation anim = context.getAnimation();
        IoBuffer buffer = new UpdateZonePartialFollows().getBuffer(player, object.getLocation().getChunkBase());
        IoBuffer animBuf = new IoBuffer(23);
        animBuf.putByte128((l.getChunkOffsetX() << 4) | (l.getChunkOffsetY() & 0x7));
        animBuf.putShortLE(anim.getId());
        animBuf.putByteC((object.getType() << 2) + (object.getRotation() & 0x3));
        player.getDetails().getSession().write(buffer);
        player.getDetails().getSession().write(animBuf);
    }
}
