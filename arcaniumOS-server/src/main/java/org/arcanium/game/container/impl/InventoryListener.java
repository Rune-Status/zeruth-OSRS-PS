package org.arcanium.game.container.impl;

import org.arcanium.game.container.Container;
import org.arcanium.game.container.ContainerEvent;
import org.arcanium.game.container.ContainerListener;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.ContainerContext;
import org.arcanium.net.packet.server.FullContainerPacket;
import org.arcanium.net.packet.server.PartialContainerPacket;

/**
 * Handles the inventory container listening.
 *
 * @author Emperor
 */
public final class InventoryListener implements ContainerListener {

    /**
     * The player.
     */
    private final Player player;

    /**
     * Constructs a new {@code InventoryListener} {@code Object}.
     *
     * @param player The player.
     */
    public InventoryListener(Player player) {
        this.player = player;
    }

    /**
     * Updates the required settings etc for the player when the container
     * updates.
     *
     * @param c The container.
     */
    public void update(Container c) {
        player.getSettings().updateWeight();
    }

    @Override
    public void refresh(Container c) {
        PacketRepository.send(FullContainerPacket.class, new ContainerContext(player, 149, 0, 93, c, false));
        update(c);
    }

    @Override
    public void update(Container c, ContainerEvent event) {
        PacketRepository.send(PartialContainerPacket.class, new ContainerContext(player, 149, 0, 93, event.getItems(), false, event.getSlots()));
        update(c);
    }

}