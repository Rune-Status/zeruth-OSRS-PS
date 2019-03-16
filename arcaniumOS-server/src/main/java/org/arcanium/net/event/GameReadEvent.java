package org.arcanium.net.event;

import org.arcanium.net.IoReadEvent;
import org.arcanium.net.IoSession;
import org.arcanium.net.packet.*;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles game packet reading.
 *
 * @author Emperor
 */
public final class GameReadEvent extends IoReadEvent {

    /**
     * Constructs a new {@code GameReadEvent}.
     *
     * @param session The session.
     * @param buffer  The buffer to read from.
     */
    public GameReadEvent(IoSession session, ByteBuffer buffer) {
        super(session, buffer);
    }

    @Override
    public void read(IoSession session, ByteBuffer buffer) {
        int last = -1;
        while (buffer.hasRemaining()) {
            int opcode = (buffer.get() - session.getIsaacPair().getInput().getNextValue()) & 0xFF;
            if (session == null || session.getPlayer() == null) {
                continue;
            }
            Map<Integer, Integer> packetLog = session.getPlayer().getAttribute("packet_log");
            if (packetLog == null) {
                session.getPlayer().setAttribute("packet_log", packetLog = new HashMap<>());
            }
            Integer amount = packetLog.get(opcode);
            if (amount == null) {
                amount = 0;
            }
            packetLog.put(opcode, amount + 1);
            int header = ClientProt.ClientPackets.values()[opcode].getPacketSize();
            int size = header;
            if (header < 0) {
                size = getPacketSize(buffer, opcode, header, last);
            }
            if (size == -1) {
                break;
            }
            //this is reading client2server packets. need vice versa.
            if (buffer.remaining() < size) {
                switch (header) {
                    case -2:
                        queueBuffer(opcode, size >> 8, size);
                        break;
                    case -1:
                        queueBuffer(opcode, size);
                        break;
                    default:
                        queueBuffer(opcode);
                        break;
                }
                break;
            }
            byte[] data = new byte[size];
            buffer.get(data);
            IoBuffer buf = new IoBuffer(opcode, size, null, ByteBuffer.wrap(data));
            ClientPacket packet = PacketRepository.getClientPacket(opcode);
            if (packet == null) {
                continue;
            }
            last = opcode;
            try {
                session.setLastPing(System.currentTimeMillis());
                packet.decode(session.getPlayer(), opcode, buf);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    /**
     * Gets the packet size for the given opcode.
     *
     * @param buffer The buffer.
     * @param opcode The opcode.
     * @param header The packet header.
     * @param last   The last opcode.
     * @return The packet size.
     */
    private int getPacketSize(ByteBuffer buffer, int opcode, int header, int last) {
        if (header == -1) {
            if (buffer.remaining() < 1) {
                queueBuffer(opcode);
                return -1;
            }
            return buffer.get() & 0xFF;
        }
        if (header == -2) {
            if (buffer.remaining() < 2) {
                queueBuffer(opcode);
                return -1;
            }
            return buffer.getShort() & 0xFFFF;
        }
        if (header == -3) {
            return buffer.remaining();
        }
        System.err.println("Invalid packet [opcode=" + opcode + ", last=" + last + ", queued=" + usedQueuedBuffer + "]!");
        return -1;
    }

}