package org.arcanium.net.packet.server;

import org.arcanium.game.node.entity.player.link.audio.Audio;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.DefaultContext;

/**
 * Sends an audio packet.
 *
 * @author Vexia
 */
public class AudioPacket implements ServerPacket<DefaultContext> {

    @Override
    public void send(DefaultContext context) {
        final Audio audio = (Audio) context.getObjects()[0];
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.SYNTH_SOUND.getPacketId());
        buffer.putShort(audio.getId());
        buffer.put((byte) audio.getVolume());
        buffer.putShort(audio.getDelay());
        context.getPlayer().getSession().write(buffer);
    }

}
