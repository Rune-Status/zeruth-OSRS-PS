package org.arcanium.net.producer;

import org.arcanium.net.EventProducer;
import org.arcanium.net.IoReadEvent;
import org.arcanium.net.IoSession;
import org.arcanium.net.IoWriteEvent;
import org.arcanium.net.event.JS5ReadEvent;
import org.arcanium.net.event.JS5WriteEvent;

import java.nio.ByteBuffer;

/**
 * Produces JS-5 I/O events.
 * @author Tyler
 * @author Emperor
 */
public class JS5EventProducer implements EventProducer {

    @Override
    public IoReadEvent produceReader(IoSession session, ByteBuffer buffer) {
	return new JS5ReadEvent(session, buffer);
    }

    @Override
    public IoWriteEvent produceWriter(IoSession session, Object context) {
	return new JS5WriteEvent(session, context);
    }

    @Override
    public IoWriteEvent produceWriter(IoSession session, Object context1, Object context2) {
        return null;
    }

}
