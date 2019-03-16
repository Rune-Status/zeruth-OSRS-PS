package org.arcanium.net.packet.server;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.world.map.Location;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.BuildObjectContext;

public class ConstructObject implements ServerPacket<BuildObjectContext> {
    /**
     * Writes the packet.
     *
     * @param buffer The buffer.
     * @param object The objects.
     */
    public static IoBuffer write(IoBuffer buffer, GameObject object) {
        Location l = object.getLocation();
        buffer.put(ServerProt.ServerPackets.LOC_ADD_CHANGE.getPacketId());
        buffer.putByte128((l.getChunkOffsetX() & 0x7) << 4 | (l.getChunkOffsetY() & 0x7));
        buffer.put128Byte((object.getType() << 2) | (object.getRotation() & 0x3));
        buffer.putShort128(object.getId());

        System.out.println("[ConstructObject] [Write] " + (((l.getChunkOffsetX() & 0x7) << 4 | (l.getChunkOffsetY() & 7))));
        System.out.println("[ConstructObject] [Write] " + ((object.getType() << 2) | (object.getRotation() & 3)));
        System.out.println("[ConstructObject] [Write] " + object.getId());
        return buffer;
    }

    @Override
    public void send(BuildObjectContext context) {
        Player player = context.getPlayer();
        GameObject o = context.getGameObject();
        Location l = o.getLocation();
        IoBuffer oBuf = new IoBuffer(ServerProt.ServerPackets.LOC_ADD_CHANGE.getPacketId())
                .putByte128((l.getChunkOffsetX() & 0x7) << 4 | (l.getChunkOffsetY() & 0x7))
                .put128Byte((o.getType() << 2) | (o.getRotation() & 0x3))
                .putShort128(o.getId());
        System.out.println("[ConstructObject] [Send] " + (((l.getChunkOffsetX() & 0x7)) << 4 | (l.getChunkOffsetY() & 0x7)));
        System.out.println("[ConstructObject] [Send] " + ((o.getType() << 2) | (o.getRotation() & 0x3)));
        System.out.println("[ConstructObject] [Send] " + o.getId());
        player.getSession().write(oBuf);
    }

}