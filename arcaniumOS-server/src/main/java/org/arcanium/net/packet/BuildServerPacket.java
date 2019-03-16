package org.arcanium.net.packet;

import org.arcanium.game.node.item.Item;

/**
 * Represents an outgoing packet.
 *
 * @param <T> The context type.
 * @author Emperor
 */
public interface BuildServerPacket<T extends Context> {

    /**
     * Sends the packet.
     *
     * @param context The context.
     */
    public void send(T context);

    public void send(IoBuffer buffer, Item item);

}