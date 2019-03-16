package org.arcanium.game.component;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.ConfigContext;
import org.arcanium.net.packet.server.AccessMask;
import org.arcanium.net.packet.server.CS2Script;
import org.arcanium.net.packet.server.Interface;
import org.arcanium.net.packet.server.Varp;

/**
 * Represents a component.
 *
 * @author Emperor
 */
public class Component {

    /**
     * The component id.
     */
    protected int id;

    /**
     * The component definitions.
     */
    protected final ComponentDefinition definition;

    /**
     * The close event.
     */
    protected CloseEvent closeEvent;

    /**
     * The component plugin.
     */
    protected ComponentPlugin plugin;

    /**
     * Constructs a new {@code Component} {@code Object}.
     *
     * @param id The component id.
     */
    public Component(int id) {
        this.id = id;
        this.definition = ComponentDefinition.forId(id);
        this.plugin = definition.getPlugin();
    }

    /**
     * Opens the component.
     */
    public void open(Player player) {
        if (definition.getAccessMask() != null) {
            PacketRepository.send(AccessMask.class, definition.getAccessMask().setPlayer(player));
        }
        for (ConfigContext context : definition.getConfigContext()) {
            PacketRepository.send(Varp.class, context.setPlayer(player));
        }
        if (definition.getCs2ScriptContext() != null) {
            PacketRepository.send(CS2Script.class, definition.getCs2ScriptContext().setPlayer(player));
        }
        if (definition.getContext() != null) {
            definition.getContext().setWindowId(player.getInterfaceManager().getWindowsPane());
            PacketRepository.send(Interface.class, definition.getContext().setPlayer(player));
        } else {
            // player.debug("No component definitions added - [id=" + id +
            // "]!");
        }
    }

    /**
     * Closes the component.
     *
     * @param player The player.
     * @return {@code True} if the component can be closed.
     */
    public boolean close(Player player) {
        if (closeEvent != null && !closeEvent.close(player, this)) {
            return false;
        }
        return true;
    }

    /**
     * Gets the id.
     *
     * @return The id.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the definition.
     *
     * @return The definition.
     */
    public ComponentDefinition getDefinition() {
        return definition;
    }

    /**
     * Gets the closeEvent.
     *
     * @return The closeEvent.
     */
    public CloseEvent getCloseEvent() {
        return closeEvent;
    }

    /**
     * Sets the closeEvent.
     *
     * @param closeEvent The closeEvent to set.
     */
    public Component setCloseEvent(CloseEvent closeEvent) {
        this.closeEvent = closeEvent;
        return this;
    }

    /**
     * Sets the component unclosable.
     *
     * @param c The component.
     */
    public static void setUnclosable(Player p, Component c) {
        p.setAttribute("close_c_", false);
        c.setCloseEvent(new CloseEvent() {
            @Override
            public boolean close(Player player, Component c) {
                if (!player.getAttribute("close_c_", false)) {
                    return false;
                }
                return true;
            }
        });
    }

    /**
     * Sets the plugin.
     *
     * @param plugin the plugin.
     */
    public void setPlugin(ComponentPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Gets the component plugin.
     *
     * @return the plugin.
     */
    public ComponentPlugin getPlugin() {
        if (plugin == null) {
            ComponentPlugin p = ComponentDefinition.forId(getId()).getPlugin();
            if ((plugin = p) != null) {
                return p;
            }
        }
        return plugin;
    }
}