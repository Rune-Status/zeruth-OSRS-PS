package org.arcanium.net.packet.server.zone.types;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.world.map.Location;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.ObjectContext;
import org.arcanium.net.packet.server.zone.UpdateZonePartialFollows;

public class LocAddChange implements ServerPacket<ObjectContext> {

    @Override
    public void send(ObjectContext context) {
        Player player = context.getPlayer();
        GameObject o = context.getGameObject();
        IoBuffer buffer = new UpdateZonePartialFollows().getBuffer(player, o.getLocation().getChunkBase());
        Location l = o.getLocation();
        IoBuffer oBuf = new IoBuffer(ServerProt.ServerPackets.LOC_ADD_CHANGE.getPacketId())
                .putByte128((l.getChunkOffsetX() << 4) | (l.getChunkOffsetY() & 0x7))
                .put128Byte((o.getType() << 2) | (o.getRotation() & 0x3))
                .putShort128(o.getId());

        System.out.println("DEBUG: " + "[ConstructObject]" + ((l.getChunkOffsetX() << 4) | (l.getChunkOffsetY() & 0x7)));
        System.out.println("DEBUG: " + "[ConstructObject]" + ((o.getType() << 2) | (o.getRotation() & 0x3)));
        System.out.println("DEBUG: " + "[ConstructObject]" + o.getId());

        player.getSession().write(buffer);
        player.getSession().write(oBuf);
    }
}
