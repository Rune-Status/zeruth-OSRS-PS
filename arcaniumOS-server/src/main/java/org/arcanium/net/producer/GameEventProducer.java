package org.arcanium.net.producer;

import org.arcanium.net.EventProducer;
import org.arcanium.net.IoReadEvent;
import org.arcanium.net.IoSession;
import org.arcanium.net.IoWriteEvent;
import org.arcanium.net.event.GameReadEvent;
import org.arcanium.net.event.GameWriteEvent;

import java.nio.ByteBuffer;

/**
 * Produces game packet I/O events.
 * @author Emperor
 */
public final class GameEventProducer implements EventProducer {

    @Override
    public IoReadEvent produceReader(IoSession session, ByteBuffer buffer) {
	return new GameReadEvent(session, buffer);
    }

    @Override
    public IoWriteEvent produceWriter(IoSession session, Object context) {
	    return new GameWriteEvent(session, context);
    }

    @Override
    public IoWriteEvent produceWriter(IoSession session, Object context1, Object context2) {
        return new GameWriteEvent(session, context1, context2);
    }

}