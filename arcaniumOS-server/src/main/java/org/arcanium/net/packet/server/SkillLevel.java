package org.arcanium.net.packet.server;

import org.arcanium.game.content.skill.Skills;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.ServerPacket;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.SkillContext;

/**
 * Handles the update skill outgoing packet.
 *
 * @author Emperor
 */
public final class SkillLevel implements ServerPacket<SkillContext> {

    @Override
    public void send(SkillContext context) {
        final IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.UPDATE_STAT.getPacketId());
        Skills skills = context.getPlayer().getSkills();
        /*if (context.getSkillId() == Skills.PRAYER) {
            buffer.putByteC((int) Math.ceil(skills.getPrayerPoints()));
        } else if (context.getSkillId() == Skills.HITPOINTS) {
            buffer.putByteC(skills.getLifepoints());
        } else {
            buffer.putByteC(skills.getLevel(context.getSkillId()));
        }*/
        buffer.putIntLE((int) skills.getExperience(context.getSkillId()));
        buffer.putN(context.getSkillId());
        buffer.put(skills.getLevel(context.getSkillId()));
        context.getPlayer().getDetails().getSession().write(buffer);
    }

}