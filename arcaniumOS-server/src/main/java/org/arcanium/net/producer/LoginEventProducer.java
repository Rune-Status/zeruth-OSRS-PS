package org.arcanium.net.producer;

import org.arcanium.net.EventProducer;
import org.arcanium.net.IoReadEvent;
import org.arcanium.net.IoSession;
import org.arcanium.net.IoWriteEvent;
import org.arcanium.net.event.LoginReadEvent;
import org.arcanium.net.event.LoginWriteEvent;

import java.nio.ByteBuffer;

/**
 * Produces login I/O events.
 * @author Emperor
 */
public final class LoginEventProducer implements EventProducer {

    @Override
    public IoReadEvent produceReader(IoSession session, ByteBuffer buffer) {
	return new LoginReadEvent(session, buffer);
    }

    @Override
    public IoWriteEvent produceWriter(IoSession session, Object context) {
	return new LoginWriteEvent(session, context);
    }
    @Override
    public IoWriteEvent produceWriter(IoSession session, Object context1, Object context2) {
        return null;
    }


}