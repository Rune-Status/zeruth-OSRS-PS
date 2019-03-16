package org.arcanium.net.packet.client;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.RunScript;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.tools.StringUtils;

/**
 * Represents the incoming packet to handle a run script.
 * @author 'Vexia
 */
public class RunScriptPacketHandler implements ClientPacket {

    @Override
    public void decode(Player player, int opcode, IoBuffer buffer) {
	final RunScript script = player.getAttribute("runscript", null);
	if (script == null || player.getLocks().isInteractionLocked()) {
	    return;
	}
	Object value = "";
	if (opcode == 179) {
	    value = StringUtils.longToString(buffer.getLong());
	} else if (opcode == 106) {
	    char c = (char) buffer.getByte();
	    value = c + buffer.getString();
	} else {
	    value = buffer.getInt();
	}
	script.setValue(value);
	script.setPlayer(player);
	player.removeAttribute("runscript");
	script.handle();
    }
}
