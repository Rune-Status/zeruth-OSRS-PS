package org.arcanium.net.packet.server;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.world.map.Location;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.BuildObjectContext;

/**
 * The clear game object outgoing packet.
 *
 * @author Emperor
 */
public final class ClearObject implements ServerPacket<BuildObjectContext> {

    /**
     * Writes the packet.
     *
     * @param buffer The buffer.
     * @param object The objects.
     */
    public static IoBuffer write(IoBuffer buffer, GameObject object) {
        Location l = object.getLocation();
        buffer.put(ServerProt.ServerPackets.LOC_DEL.getPacketId());
        buffer.put128Byte((object.getType() << 2) + (object.getRotation() & 3));
        buffer.put128Byte(((l.getChunkOffsetX() & 0x7) << 4) | (l.getChunkOffsetY() & 0x7));
        System.out.println("[ClearObject] [Write] " + (((l.getChunkOffsetX() & 0x7)) << 4 | (l.getChunkOffsetY() & 0x7)));
        System.out.println("[ClearObject] [Write] " + ((object.getType() << 2) | (object.getRotation() & 0x3)));
        System.out.println("[ClearObject] [Write] " + object.getId());
        return buffer;
    }

    @Override
    public void send(BuildObjectContext context) {
        Player player = context.getPlayer();
        GameObject o = context.getGameObject();
        Location l = o.getLocation();
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.LOC_DEL.getPacketId());
        buffer.put128Byte((o.getType() << 2) + (o.getRotation() & 3));
        buffer.put128Byte(((l.getChunkOffsetX() & 0x7) << 4) | (l.getChunkOffsetY() & 0x7));
        player.getSession().write(buffer);
    }

}