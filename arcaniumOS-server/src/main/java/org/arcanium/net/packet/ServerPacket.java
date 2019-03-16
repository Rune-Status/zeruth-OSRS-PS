package org.arcanium.net.packet;

/**
 * Represents an outgoing packet.
 *
 * @param <T> The context type.
 * @author Emperor
 */
public interface ServerPacket<T extends Context> {

    /**
     * Sends the packet.
     *
     * @param context The context.
     */
    public void send(T context);

}