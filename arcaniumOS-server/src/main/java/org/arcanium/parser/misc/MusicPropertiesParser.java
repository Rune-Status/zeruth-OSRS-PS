package org.arcanium.parser.misc;

import org.arcanium.cache.ServerStore;
import org.arcanium.cache.misc.buffer.ByteBufferUtils;
import org.arcanium.game.node.entity.player.link.music.MusicEntry;
import org.arcanium.game.node.entity.player.link.music.MusicZone;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.game.world.map.zone.ZoneBorders;
import org.arcanium.parser.Parser;

import java.nio.ByteBuffer;

/**
 * Parses the music properties.
 * @author Emperor
 */
public final class MusicPropertiesParser implements Parser {

    @Override
    public boolean parse() throws Throwable {
	ByteBuffer buf = ServerStore.getArchive("music");
	int musicId;
	while ((musicId = buf.getShort()) != -1) {
	    String name = ByteBufferUtils.getString(buf);
	    int index = buf.getShort();
	    MusicEntry entry = new MusicEntry(musicId, name, index);
	    MusicEntry.getSongs().put(musicId, entry);
	    int length = buf.get() & 0xFF;
	    ZoneBorders borders = null;
	    for (int i = 0; i < length; i++) {
		int exceptions = buf.get() & 0xFF;
		int southWestX = buf.getShort();
		int southWestY = buf.getShort();
		int northEastX = buf.getShort();
		int northEastY = buf.getShort();
		borders = new ZoneBorders(southWestX, southWestY, northEastX, northEastY);
		for (int j = 0; j < exceptions; j++) {
		    southWestX = buf.getShort();
		    southWestY = buf.getShort();
		    northEastX = buf.getShort();
		    northEastY = buf.getShort();
		    borders.addException(new ZoneBorders(southWestX, southWestY, northEastX, northEastY));
		}
		MusicZone zone = new MusicZone(musicId, borders);
		for (Integer id : borders.getRegionIds()) {
		    RegionManager.forId(id).getMusicZones().add(zone);
		}
	    }
	}
	return true;
    }

}