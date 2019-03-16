package org.arcanium.net.packet.server;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.map.Region;
import org.arcanium.game.world.map.RegionChunk;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.game.world.map.build.DynamicRegion;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.DynamicSceneContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emperor
 */
public final class BuildDynamicScene implements ServerPacket<DynamicSceneContext> {

    @Override
    public void send(DynamicSceneContext context) {
	IoBuffer buffer = new IoBuffer(177, PacketHeader.SHORT);
	buffer.setBitAccess();
	List<Integer> regionIds = new ArrayList<>();
	Player player = context.getPlayer();
	Region r = player.getViewport().getRegion();
	RegionChunk[][][] chunks = new RegionChunk[4][13][13];
	int baseX = player.getLocation().getChunkX() - 6;
	int baseY = player.getLocation().getChunkY() - 6;
	for (int z = 0; z < 4; z++) {
	    for (int x = baseX; x <= player.getLocation().getChunkX() + 6; x++) {
		for (int y = baseY; y <= player.getLocation().getChunkY() + 6; y++) {
		    r = RegionManager.forId((x >> 3) << 8 | (y >> 3));
		    if (r instanceof DynamicRegion) {
			DynamicRegion dr = (DynamicRegion) r;
			chunks[z][x - baseX][y - baseY] = dr.getChunks()[z][x - (dr.getX() << 3)][y - (dr.getY() << 3)];
		    }
		}
	    }
	}
	for (int plane = 0; plane < 4; plane++) {
	    for (int offsetX = 0; offsetX < 13; offsetX++) {
		for (int offsetY = 0; offsetY < 13; offsetY++) {
		    RegionChunk c = chunks[plane][offsetX][offsetY];
		    if (c == null || c.getBase().getX() < 0 || c.getBase().getY() < 0) {
			buffer.putBits(1, 0);
			continue;
		    }
		    int realRegionX = c.getBase().getChunkX();
		    int realRegionY = c.getBase().getChunkY();
		    int realPlane = c.getBase().getZ();
		    int rotation = c.getRotation();
		    int id = (realRegionX >> 3) << 8 | (realRegionY >> 3);
		    if (!regionIds.contains(id)) {
			regionIds.add(id);
		    }
		    buffer.putBits(1, 1);
		    buffer.putBits(26, (rotation << 1) | (realPlane << 24) | (realRegionX << 14) | (realRegionY << 3));
		}
	    }
	}
	buffer.setByteAccess();
	for (int i = 0; i < regionIds.size(); i++) {// int id : regionIds) {
	    /*int[] keys = UpdateSceneGraph.KEYS;
	    buffer.putInt(keys[0]).putInt(keys[1]).putInt(keys[2]).putInt(keys[3]);*/
	}
	buffer.putShortLE(player.getLocation().getSceneY());
	buffer.putShort128(player.getLocation().getSceneX());
	buffer.putShort(player.getLocation().getChunkY());
	buffer.putShortLE(player.getLocation().getChunkX());
	buffer.put(player.getLocation().getZ());
	context.getPlayer().getSession().write(buffer);
	player.getPlayerFlags().setLastSceneGraph(player.getLocation());
    }

}