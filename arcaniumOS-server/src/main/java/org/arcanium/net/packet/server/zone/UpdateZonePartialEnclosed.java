package org.arcanium.net.packet.server.zone;

import org.apache.commons.lang3.ArrayUtils;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.map.Location;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.AreaPositionContext;
import org.arcanium.net.packet.server.zone.types.*;

import java.util.ArrayList;
import java.util.List;

import static org.arcanium.net.packet.ServerProt.ServerPackets.UPDATE_ZONE_PARTIAL_ENCLOSED;

public class UpdateZonePartialEnclosed implements ServerPacket<AreaPositionContext> {

    public final List<ServerPacket> packets = new ArrayList<>();

    /**
     * Gets the region chunk update buffer & zone index.
     *
     * @param player The player.
     * @param base   The base location of the chunk.
     * @return The buffer.
     */
    public IoBuffer getBuffer(Player player, Location base) {
        int x = base.getSceneX(player.getPlayerFlags().getLastSceneGraph());
        int y = base.getSceneY(player.getPlayerFlags().getLastSceneGraph());
        IoBuffer buffer = new IoBuffer(UPDATE_ZONE_PARTIAL_ENCLOSED.getPacketId()).put128Byte(y).putN(x);
        for (int i = packets.size() - 1; i >= 0; i--) {
            ServerPacket packet = packets.get(i);
            int arrayIndex = ArrayUtils.indexOf(ZONE_FOLLOW_TYPES, packet.getClass());
            if (arrayIndex == -1) {
                continue;
            }
            buffer.put(arrayIndex);
        }
        return buffer;
    }

    @Override
    public void send(AreaPositionContext context) {
        context.getPlayer().getSession().write(getBuffer(context.getPlayer(), context.getLocation()));
    }


    private static final Class<?>[] ZONE_FOLLOW_TYPES = new Class<?>[] {
        AlterGroundItem.class, MapProjAnim.class, EmptyClass.class, MapAnim.class, LocAnim.class,
            SoundArea.class, LocDel.class, GroundItemAdd.class, GroundItemRemove.class, LocAddChange.class
    };


}