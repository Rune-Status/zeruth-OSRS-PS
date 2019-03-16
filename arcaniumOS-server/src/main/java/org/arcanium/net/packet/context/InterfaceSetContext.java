package org.arcanium.net.packet.context;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.Context;

/**
        * Created by Chris on 7/23/2017.
        */
public class InterfaceSetContext implements Context {

    /**
     * The player.
     */
    private Player player;

    private final int fromRoot;
    private final int fromChild;
    private final int toRoot;
    private final int toChild;

    public InterfaceSetContext(Player player, int fromRoot, int fromChild, int toRoot, int toChild) {
        this.player = player;
        this.fromRoot = fromRoot;
        this.fromChild = fromChild;
        this.toRoot = toRoot;
        this.toChild = toChild;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
    public int getFromRoot() {
        return fromRoot;
    }

    public int getFromChild() {
        return fromChild;
    }

    public int getToChild() {
        return toChild;
    }

    public int getToRoot() {
        return toRoot;
    }
}