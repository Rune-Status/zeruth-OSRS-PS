package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.DisplayModelContext;

/**
 * Represents the outgoing packet for the displaying of a node model on an
 * interface.
 *
 * @author Emperor
 */
public final class DisplayModel implements ServerPacket<DisplayModelContext> {

    @Override
    public void send(DisplayModelContext context) {
        IoBuffer buffer;
        switch (context.getType()) {
            case PLAYER:
                buffer = new IoBuffer(120);
                buffer.putIntV2(context.getInterfaceId() << 16 | context.getChildId());
                break;
            case NPC:
                buffer = new IoBuffer(153);
                buffer.putShort128(context.getNodeId());
                buffer.putIntV1((context.getInterfaceId() << 16) | context.getChildId());
                break;
            case ITEM:
                int value = context.getAmount() > 0 ? context.getAmount() : context.getZoom();
                buffer = new IoBuffer(20);
                buffer.putIntLE(context.getInterfaceId() << 16 | context.getChildId());
                buffer.putShortLE(context.getNodeId());
                buffer.putIntLE(value);
                break;
            case MODEL:
                buffer = new IoBuffer(244);
                buffer.putShortLE(context.getNodeId());
                buffer.putIntLE(context.getInterfaceId() << 16 | context.getChildId());
                break;
            default:
                return;
        }
        context.getPlayer().getSession().write(buffer);
    }

}