package org.arcanium.game.node.entity.player.link.request.trade;

import org.arcanium.game.component.CloseEvent;
import org.arcanium.game.component.Component;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.ContainerContext;
import org.arcanium.net.packet.server.PartialContainerPacket;

/**
 * Represents the close event invoked at the closing of a trade interface.
 * @author Vexia
 */
public final class TradeCloseEvent implements CloseEvent {

    @Override
    public boolean close(Player player, Component c) {
	final TradeModule module = TradeModule.getExtension(player);
	player.getPacketDispatch().sendRunScript(101, "");
	if (module == null) {
	    return true;
	}
	TradeModule otherModule = TradeModule.getExtension(module.getTarget());
	if (otherModule == null) {
	    return true;
	}
	if (module.isAccepted() && otherModule.isAccepted()) {
	    return true;
	}
	if (module.getStage() != 2) {
	    retainContainer(player);
	    retainContainer(module.getTarget());
	}
	closeInterfaces(player);
	closeInterfaces(module.getTarget());
	module.getTarget().getInterfaceManager().close();
	end(player);
	end(module.getTarget());
	return true;
    }

    /**
     * Method used to close the trade interface.
     * @param player the player.
     */
    private void closeInterfaces(final Player player) {
	player.removeExtension(TradeModule.class);
	player.getInterfaceManager().closeSingleTab();
	player.getInterfaceManager().openDefaultTabs();
	PacketRepository.send(PartialContainerPacket.class, new ContainerContext(player, -1, 2, 24, new Item[] {}, 27, false));
	PacketRepository.send(PartialContainerPacket.class, new ContainerContext(player, -1, 2, 23, new Item[] {}, 27, false));
	player.getPacketDispatch().sendRunScript(101, "");
    }

    /**
     * Method used to end the trade session.
     * @param player the player.
     */
    private void end(final Player player) {
	player.getConfigManager().sendVarp(1043, 0);
	player.getConfigManager().sendVarp(1042, 0);
    }

    /**
     * Method used to retain the trade container.
     * @param player the player.
     */
    private void retainContainer(final Player player) {
	final TradeModule module = TradeModule.getExtension(player);
	if (module == null || module.isRetained()) {
	    return;
	}
	module.setRetained(true);
	player.getInventory().addAll(module.getContainer());
    }

}