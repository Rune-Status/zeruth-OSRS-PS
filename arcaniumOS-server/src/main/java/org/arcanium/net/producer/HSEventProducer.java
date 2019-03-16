package org.arcanium.net.producer;

import org.arcanium.net.EventProducer;
import org.arcanium.net.IoReadEvent;
import org.arcanium.net.IoSession;
import org.arcanium.net.IoWriteEvent;
import org.arcanium.net.event.HSReadEvent;
import org.arcanium.net.event.HSWriteEvent;

import java.nio.ByteBuffer;

/**
 * Produces I/O events for the handshake protocol.
 * @author Emperor
 */
public final class HSEventProducer implements EventProducer {

    @Override
    public IoReadEvent produceReader(IoSession session, ByteBuffer buffer) {
	return new HSReadEvent(session, buffer);
    }

    @Override
    public IoWriteEvent produceWriter(IoSession session, Object context) {
	return new HSWriteEvent(session, context);
    }

    @Override
    public IoWriteEvent produceWriter(IoSession session, Object context1, Object context2) {
        return null;
    }

}