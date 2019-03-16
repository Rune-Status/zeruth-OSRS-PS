package org.arcanium.game.node.entity.player.info;

import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.repository.NodeList;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.net.packet.IoBuffer;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kyle Friz
 * @since  Aug 29, 2015
 */
public class RenderInfo {
    /**
     * The player's list of local npcs.
     */
    private final List<NPC> localNpcs = new ArrayList<>();

    public static final int MAX_PLAYER_ADD = 15;

    public Player player;

    public byte[] slotFlags;

    public Player[] localPlayers;
    public int[] localPlayersIndexes;
    public int localPlayersIndexesCount;

    public int[] outPlayersIndexes;
    public int outPlayersIndexesCount;

    public int[] regionHashes;

    public byte[][] cachedAppearencesHashes;
    public int totalRenderDataSentLength;

    /**
     * The amount of local players added this tick.
     */
    public int localAddedPlayers;

    public RenderInfo(Player player) {
        this.player = player;
        slotFlags = new byte[2048];
        localPlayers = new Player[2048];
        localPlayersIndexes = new int[2048];
        outPlayersIndexes = new int[2048];
        regionHashes = new int[2048];
        cachedAppearencesHashes = new byte[2048][];
    }
    
    private final int getHash(final Location tile) {
	return (tile.getY() >> 13 | (tile.getX() >> 13) << 8 | (tile.getZ() & 0x3) << 16);
    }

    public synchronized void initialize(IoBuffer stream) {
        stream.setBitAccess();
        stream.putBits(30, player.getLocation().getTileHash());
        localPlayers[player.getIndex()] = player;
        localPlayersIndexes[localPlayersIndexesCount++] = player.getIndex();
        localPlayers[player.getIndex()] = player;
        final NodeList<Player> players = Repository.getPlayers();
        for (int playerIndex = 1; playerIndex < 2048; playerIndex++) {
            if (playerIndex == player.getIndex())
                continue;
            Player externalPlayer = players.get(playerIndex);
            stream.putBits(18, regionHashes[playerIndex] = externalPlayer == null ? 0 : getHash(externalPlayer.getLocation()));
            outPlayersIndexes[outPlayersIndexesCount++] = playerIndex;

        }
        stream.setByteAccess();
    }

    public synchronized void refresh() {
        totalRenderDataSentLength = 0;
        localPlayersIndexesCount = 0;
        outPlayersIndexesCount = 0;
        for (int playerIndex = 1; playerIndex < 2048; playerIndex++) {
            slotFlags[playerIndex] >>= 1;
            Player player = localPlayers[playerIndex];
            if (player == null)
                outPlayersIndexes[outPlayersIndexesCount++] = playerIndex;
            else
                localPlayersIndexes[localPlayersIndexesCount++] = playerIndex;
        }
    }

    /**
     * @return the localNpcs
     */
    public List<NPC> getLocalNpcs() {
        return localNpcs;
    }

    public boolean needAppearenceUpdate(int index, byte[] hash) {
        if (totalRenderDataSentLength > 3500 || hash == null)
            return false;
        return cachedAppearencesHashes[index] == null || !MessageDigest.isEqual(cachedAppearencesHashes[index], hash);
    }

}

