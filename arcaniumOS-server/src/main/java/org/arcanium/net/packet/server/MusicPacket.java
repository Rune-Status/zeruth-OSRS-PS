package org.arcanium.net.packet.server;

import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.MusicContext;

/**
 * Outgoing Music packet
 *
 * @author SonicForce41
 */
public class MusicPacket implements ServerPacket<MusicContext> {

    @Override
    public void send(MusicContext context) {
        IoBuffer buffer = null;
        if (context.isSecondary()) {
            buffer = new IoBuffer(ServerProt.ServerPackets.SYNTH_SOUND.getPacketId());
            buffer.putShort(context.getMusicId());
            buffer.put(0);
            buffer.putShort(context.getMusicId());
        } else {
            buffer = new IoBuffer(ServerProt.ServerPackets.MIDI_SONG.getPacketId());
            buffer.putLEShortA(context.getMusicId());
        }
        context.getPlayer().getDetails().getSession().write(buffer);
    }

}
