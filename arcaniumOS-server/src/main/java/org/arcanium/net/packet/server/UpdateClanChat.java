package org.arcanium.net.packet.server;

import org.arcanium.game.system.communication.ClanEntry;
import org.arcanium.game.system.communication.ClanRepository;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketHeader;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.context.ClanContext;
import org.arcanium.tools.StringUtils;

/**
 * Handles the update clan chat outgoing packet.
 *
 * @author Emperor
 */
public final class UpdateClanChat implements ServerPacket<ClanContext> {

    @Override
    public void send(ClanContext context) {
        IoBuffer buffer = new IoBuffer(115, PacketHeader.SHORT);
        ClanRepository clan = context.getClan();
        if (!context.isLeave()) {
            buffer.putString(clan.getOwner());
            buffer.putLong(StringUtils.stringToLong(clan.getName()));
            buffer.put(clan.getKickRequirement().getValue());
            int size = clan.getPlayers().size();
            if (size > 100) {
                size = 100;
            }
            buffer.put(size);
            for (int i = 0; i < size; i++) {
                ClanEntry entry = clan.getPlayers().get(i);
                buffer.putString(entry.getName());
                buffer.putShort(entry.getWorldId());
                buffer.put(clan.getRank(entry).getValue());
                buffer.putString("World " + entry.getWorldId());
            }
        } else {
            buffer.putLong(0);
        }
        context.getPlayer().getSession().write(buffer);
    }

}