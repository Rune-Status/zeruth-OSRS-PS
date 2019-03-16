package org.arcanium.net.event;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.info.login.Response;
import org.arcanium.net.EventProducer;
import org.arcanium.net.IoSession;
import org.arcanium.net.IoWriteEvent;
import org.arcanium.net.producer.GameEventProducer;

import java.nio.ByteBuffer;

/**
 * Handles login writing events.
 *
 * @author Emperor
 */
public final class LoginWriteEvent extends IoWriteEvent {

    /**
     * The game event producer.
     */
    private static final EventProducer GAME_PRODUCER = new GameEventProducer();

    /**
     * Constructs a new {@code LoginWriteEvent}.
     *
     * @param session The session.
     * @param context The event context.
     */
    public LoginWriteEvent(IoSession session, Object context) {
        super(session, context);
    }

    @Override
    public void write(IoSession session, Object context) {
        Response response = (Response) context;
        ByteBuffer buffer = ByteBuffer.allocate(500);
        buffer.put((byte) response.opcode());
        switch (response.opcode()) {
            case 2:
                buffer.put(getWorldResponse(session));
                session.setProducer(GAME_PRODUCER);
                break;
            case 21:
                buffer.put((byte) session.getServerKey());
                break;
        }
        buffer.flip();
        session.queue(buffer);
    }

    /**
     * Gets the world response buffer.
     *
     * @param session The session.
     * @return The buffer.
     */
    private static ByteBuffer getWorldResponse(IoSession session) {
        ByteBuffer buffer = ByteBuffer.allocate(150);
        Player player = session.getPlayer();
        buffer.put((byte) 13);
        buffer.put((byte) 0);
        buffer.putInt(0);
        buffer.put((byte) /*player.getDetails().getRights().ordinal()*/0);//im not sending player index...
        buffer.put((byte) 0);
        buffer.putShort((short) player.getIndex());
        buffer.put((byte) 1);
        buffer.flip();
        return buffer;

    }
}