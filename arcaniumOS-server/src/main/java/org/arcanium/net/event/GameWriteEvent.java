package org.arcanium.net.event;

import org.arcanium.net.IoSession;
import org.arcanium.net.IoWriteEvent;
import org.arcanium.net.packet.IoBuffer;

import java.nio.ByteBuffer;

/**
 * Handles game packet writing events.
 *
 * @author Emperor
 */
public final class GameWriteEvent extends IoWriteEvent {

    /**
     * Constructs a new {@code GameWriteEvent}.
     *
     * @param session The session.
     * @param context The context.
     */
    public GameWriteEvent(IoSession session, Object context) {
        super(session, context);
    }

    /**
     * Constructs a new {@code GameWriteEvent}.
     *
     * @param session The session.
     * @param context The context.
     */
    public GameWriteEvent(IoSession session, Object context1, Object context2) {
        super(session, context1, context2);
    }

    @Override
    public void write(IoSession session, Object context) {
        if (context instanceof ByteBuffer) {
            session.queue((ByteBuffer) context);
            return;
        }
        IoBuffer buffer = (IoBuffer) context;
        ByteBuffer buf = (ByteBuffer) buffer.toByteBuffer().flip();
        if (buf == null) {
            throw new RuntimeException("Critical networking error: The byte buffer requested was null.");
        }
        if (buffer.opcode() != -1) {
           // System.out.println(buffer.opcode() + ", " + buffer.readableBytes());
            int packetLength = buf.remaining() + 4;
            ByteBuffer response = ByteBuffer.allocate(packetLength);
            response.put((byte) (buffer.opcode() + session.getIsaacPair().getOutput().getNextValue()));
            switch (buffer.getHeader()) {
                case BYTE:
                    response.put((byte) buf.remaining());
                    break;
                case SHORT:
                    response.putShort((short) buf.remaining());
                    break;
                default:
                    break;
            }
            buf = (ByteBuffer) response.put(buf).flip();
        }
        session.queue(buf);
    }

    @Override
    public void write(IoSession session, Object context1, Object context2) {
        if (context1 instanceof ByteBuffer && context2 instanceof ByteBuffer) {
            int packetLength = ((ByteBuffer) context1).remaining() + ((ByteBuffer) context2).remaining();
            ByteBuffer response = ByteBuffer.allocate(packetLength);
            response.put((ByteBuffer) context1);
            response.put((ByteBuffer) context2);
            session.queue(response);
            return;
        }
        IoBuffer buffer1 = (IoBuffer) context1;
        ByteBuffer buf1 = (ByteBuffer) buffer1.toByteBuffer().flip();
        IoBuffer buffer2 = (IoBuffer) context2;
        ByteBuffer buf2 = (ByteBuffer) buffer2.toByteBuffer().flip();
        if (buf1 == null || buf2 == null) {
            throw new RuntimeException("Critical networking error: The byte buffer requested was null.");
        }
        if (buffer1.opcode() != -1 && buffer2.opcode() != -1) {
            int opcode1 = buffer1.opcode() + session.getIsaacPair().getOutput().getNextValue();
            int opcode2 = buffer2.opcode() + session.getIsaacPair().getOutput().getNextValue();
            int packetLength = buf1.remaining() + buf2.remaining();
            ByteBuffer response = ByteBuffer.allocate(packetLength + 6);
            response.put((byte) opcode1);
            response.putShort((short) (packetLength + 3));
            response.put(buf1);
            response.put((byte) opcode2);
            response.putShort((short) (buf2.remaining()));
            response.put(buf2);
            session.queue((ByteBuffer)response.flip());
        }
    }

}