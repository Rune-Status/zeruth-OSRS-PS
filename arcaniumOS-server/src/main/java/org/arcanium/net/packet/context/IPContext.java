package org.arcanium.net.packet.context;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.Context;
import org.arcanium.tools.IPAddressUtils;

public class IPContext implements Context {

    private final Player player;
    private final String ip;

    public IPContext(Player player, String ip) {
        this.player = player;
        this.ip = ip;
    }

    public int getHash() {
        return IPAddressUtils.ipToInt(ip);
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}