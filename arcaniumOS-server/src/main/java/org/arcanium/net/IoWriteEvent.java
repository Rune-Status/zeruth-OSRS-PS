package org.arcanium.net;

import java.nio.channels.CancelledKeyException;

/**
 * Handles a writing event.
 * @author Emperor
 */
public abstract class IoWriteEvent implements Runnable {

    /**
     * The I/O session.
     */
    private final IoSession session;

    /**
     * The buffer.
     */
    private final Object context1;

    /**
     * The buffer.
     */
    private final Object context2;

    /**
     * Constructs a new {@code IoWriteEvent}.
     * @param session The session.
     * @param context The write event context1.
     */
    public IoWriteEvent(IoSession session, Object context) {
	this.session = session;
	this.context1 = context;
	this.context2 = null;
    }

    /**
     * Constructs a new {@code IoWriteEvent}.
     * @param session The session.
     * @param context The write event context1.
     */
    public IoWriteEvent(IoSession session, Object context1, Object context2) {
        this.session = session;
        this.context1 = context1;
        this.context2 = context2;
    }

    @Override
    public void run() {
	try {
	    if(context2 == null)
	        write(session, context1);
	    else
	        write(session, context1, context2);
	} catch (Throwable t) {
	    if (!(t instanceof CancelledKeyException)) {
		t.printStackTrace();
	    }
	    session.disconnect();
	}
    }

    /**
     * Writes the data.
     * @param session The session.
     * @param context The write event context1.
     */
    public abstract void write(IoSession session, Object context);

    /**
     * Writes the data.
     * @param session The session.
     * @param context The write event context1.
     */
    public void write(IoSession session, Object context1, Object context2) {

    }

}