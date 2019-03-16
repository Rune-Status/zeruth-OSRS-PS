package org.arcanium.net.event;

import org.arcanium.NetworkConstants;
import org.arcanium.net.IoReadEvent;
import org.arcanium.net.IoSession;
import org.arcanium.tools.RandomFunction;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles handshake read events.
 *
 * @author Emperor
 */
public final class HSReadEvent extends IoReadEvent {

    // debug
    static Map<String, Integer> count = new HashMap<>();

    /**
     * Constructs a new {@code HSReadEvent}.
     *
     * @param session The session.
     * @param buffer  The buffer.
     */
    public HSReadEvent(IoSession session, ByteBuffer buffer) {
        super(session, buffer);
    }

    @Override
    public void read(IoSession session, ByteBuffer buffer) {
        Integer amount = count.get(session.getAddress());
        if (amount == null) {
            amount = 0;
        }
        count.put(session.getAddress(), amount + 1);
        int opcode = buffer.get() & 0xFF;
        switch (opcode) {
            case 14:
                session.setServerKey(RandomFunction.RANDOM.nextLong());
                session.write(true);
                break;
            case 15:
                int revision = buffer.getInt();
                if (revision != NetworkConstants.REVISION) {
                    System.err.println("Client build does not match server build!");
                    session.disconnect();
                    break;
                }
                session.write(false);
                break;
            default:
                session.disconnect();
                break;
        }
    }

}