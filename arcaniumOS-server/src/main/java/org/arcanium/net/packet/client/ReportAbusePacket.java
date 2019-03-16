package org.arcanium.net.packet.client;

import org.arcanium.ServerConstants;
import org.arcanium.game.content.global.report.AbuseReport;
import org.arcanium.game.content.global.report.Rule;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.tools.StringUtils;

import java.io.File;

/**
 * Represents the incoming packet to handle a report against a player.
 *
 * @author 'Vexia
 */
public class ReportAbusePacket implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
        String target = StringUtils.longToString(buffer.getLong());
        Rule rule = Rule.forId(buffer.getByte());
        boolean mute = buffer.getByte() == 1;
        File file = new File(ServerConstants.PLAYER_SAVE_PATH + target + ".arcanium");
        if (!file.exists()) {
            player.getPacketDispatch().sendMessage("Invalid player name.");
            return;
        }
        if (target.equalsIgnoreCase(player.getUsername()) || target.equalsIgnoreCase(player.getDetails().getDisplayName())) {
            player.getPacketDispatch().sendMessage("You can't report yourself!");
            return;
        }
        AbuseReport abuse = new AbuseReport(player.getName(), target, rule);
        if (rule != Rule.BUG_ABUSE && rule != Rule.ACCCOUNT_SHARING && rule != Rule.MACROING && rule != Rule.MULTIPLE_LOGGING && !abuse.getRule().canRequest(Repository.getPlayerByName(target) == null ? Repository.getPlayerFile(target) : Repository.getPlayerByName(target))) {
            player.getPacketDispatch().sendMessage("For that rule you can only report players who have spoken or traded recently.");
            return;
        }
        abuse.construct(player, mute);
    }
}
