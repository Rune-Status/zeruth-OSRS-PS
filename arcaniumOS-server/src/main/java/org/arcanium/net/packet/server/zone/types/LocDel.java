package org.arcanium.net.packet.server.zone.types;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.ObjectContext;
import org.arcanium.net.packet.server.zone.UpdateZonePartialFollows;

public class LocDel implements ServerPacket<ObjectContext> {


    @Override
    public void send(ObjectContext context) {
        Player player = context.getPlayer();
        IoBuffer regBuffer = new UpdateZonePartialFollows().getBuffer(player, context.getGameObject().getLocation().getChunkBase());
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.LOC_DEL.getPacketId());
        int srcHash = ((context.getGameObject().getLocation().getX() & 0x7) << 4) | (context.getGameObject().getLocation().getY() & 0x7);
        buffer.put128Byte((context.getGameObject().getType() << 2) | (context.getGameObject().getRotation() & 3));
        buffer.put128Byte(srcHash);

        player.getSession().write(buffer);
        player.getSession().write(regBuffer);

        System.out.println("[DestructObject] " + srcHash);
        System.out.println("[DestructObject] " + ((context.getGameObject().getType() << 2) | (context.getGameObject().getRotation() & 0x7)));


    }
}
