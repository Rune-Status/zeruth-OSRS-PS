package org.arcanium.net.event;

import org.arcanium.net.IoSession;
import org.arcanium.net.IoWriteEvent;
import org.arcanium.net.producer.GameEventProducer;
import org.arcanium.net.producer.JS5EventProducer;
import org.arcanium.net.producer.LoginEventProducer;

import java.nio.ByteBuffer;

/**
 * Handles Handshake write events.
 *
 * @author Emperor
 */
public final class HSWriteEvent extends IoWriteEvent {

    /**
     * The JS-5 event producer.
     */
    private static final JS5EventProducer JS5_PRODUCER = new JS5EventProducer();

    /**
     * The login event producer.
     */
    private static final LoginEventProducer LOGIN_PRODUCER = new LoginEventProducer();


    /**
     * Constructs a new {@code HSWriteEvent} {@code Object}.
     *
     * @param session The session.
     * @param context The context.
     */
    public HSWriteEvent(IoSession session, Object context) {
        super(session, context);
    }

    @Override
    public void write(IoSession session, Object context) {
        if (!session.getProducer().getClass().equals(GameEventProducer.class))  {
            ByteBuffer buffer = ByteBuffer.allocate(9);
            buffer.put((byte) 0);
            if ((Boolean) context) {
                buffer.putLong(session.getServerKey());
                session.setProducer(LOGIN_PRODUCER);
            } else {
                session.setProducer(JS5_PRODUCER);
            }
            buffer.flip();
            session.queue(buffer);
        }
    }

}