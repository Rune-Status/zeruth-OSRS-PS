package org.arcanium.net.packet.server;

import org.arcanium.cache.xtea.XteaManager;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.SceneGraphContext;

import java.util.ArrayList;

/**
 * The update scene graph outgoing packet.
 *
 * @author Emperor
 */
public final class UpdateSceneGraph implements ServerPacket<SceneGraphContext> {

    @Override
    public void send(SceneGraphContext context) {
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.REBUILD_NORMAL.getPacketId(), PacketHeader.SHORT);
        Player player = context.getPlayer();
        player.getPlayerFlags().setLastSceneGraph(player.getLocation());
        if (context.isLogin()) {
            player.getRenderInfo().initialize(buffer);
        }
        final int chunkX = player.getLocation().getChunkX();
        final int chunkY = player.getLocation().getChunkY();
        boolean forceSend = false;
        if ((48 == chunkX / 8 || chunkX / 8 == 49) && chunkY / 8 == 48) {
            forceSend = true;
        }

        if (48 == chunkX / 8 && chunkY / 8 == 148) {
            forceSend = true;
        }
        buffer.putLEShortA(chunkY);
        buffer.putShort128(chunkX);
        ArrayList<Integer> xteas = new ArrayList<Integer>();
        for (int xCalc = (chunkX - 6) / 8; xCalc <= ((chunkX + 6) / 8); xCalc++) {
            for (int yCalc = (chunkY - 6) / 8; yCalc <= ((chunkY + 6) / 8); yCalc++) {
                if (!forceSend || yCalc != 49 && 149 != yCalc && 147 != yCalc && xCalc != 50 && (xCalc != 49 || yCalc != 47)) {
                    int region = yCalc + (xCalc << 8);
                    int[] keys = XteaManager.getKey(region);
                    for (int i = 0; i < keys.length; i++) {
                        xteas.add(keys[i]);
                    }
                }
            }
        }
        buffer.putShort(xteas.size() / 4);
        for (int i : xteas) {
            buffer.putInt(i);
        }
        player.getDetails().getSession().write(buffer);
    }

}