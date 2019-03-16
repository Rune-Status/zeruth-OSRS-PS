package org.arcanium.game.component;

import org.arcanium.cache.misc.buffer.ByteBufferUtils;
import org.arcanium.net.packet.context.AccessMaskContext;
import org.arcanium.net.packet.context.ConfigContext;
import org.arcanium.net.packet.context.InterfaceContext;
import org.arcanium.net.packet.context.RunScriptContext;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents the component definitions.
 *
 * @author Emperor
 */
public final class ComponentDefinition {

    /**
     * The component definitions mapping.
     */
    private static final Map<Integer, ComponentDefinition> DEFINITIONS = new HashMap<Integer, ComponentDefinition>();

    /**
     * The interface context.
     */
    private InterfaceContext context;

    /**
     * The access mask
     */
    private AccessMaskContext accessMask;

    /**
     * The default config context.
     */
    private ConfigContext[] configContext;

    /**
     * The cs2-script context.
     */
    private RunScriptContext cs2ScriptContext;

    /**
     * Represents the plugin handler.
     */
    private ComponentPlugin plugin;

    /**
     * Constructs a new {@code ComponentDefinition} {@code Object}.
     */
    public ComponentDefinition() {
        configContext = new ConfigContext[0];
    }

    /**
     * Gets the component definitions for the component id.
     *
     * @param componentId The component id.
     * @return The component definitions.
     */
    public static ComponentDefinition forId(int componentId) {
        ComponentDefinition def = DEFINITIONS.get(componentId);
        if (def == null) {
            DEFINITIONS.put(componentId, def = new ComponentDefinition());
        }
        return def;
    }

    /**
     * Parses the component definitions.
     *
     * @param buffer The byte buffer.
     * @return The component defnitions.
     */
    public static ComponentDefinition parse(ByteBuffer buffer) {
        int opcode;
        ComponentDefinition def = new ComponentDefinition();
        while (buffer.remaining() > 0 && (opcode = buffer.get() & 0xFF) != 0) { //TODO REMOVE THIS AND ENABLE EARLIER VERSION.
            switch (opcode) {
                case 1:
                    int data;
                    def.context = new InterfaceContext(null, buffer.getShort() & 0xFFFF, buffer.getShort() & 0xFFFF, buffer.getShort() & 0xFFFF, buffer.get() == 1);
                    break;
                case 2:
                    int id = buffer.getShort() & 0xFFFF;
                    data = buffer.getInt();
                    def.accessMask = new AccessMaskContext(null, id, data >> 16 & 0xFFFF, data & 0xFFFF,
                            buffer.getShort() & 0xFFFF, buffer.getShort() & 0xFFFF);
                    break;
                case 3:
                    def.configContext = new ConfigContext[buffer.get() & 0xFF];
                    for (int i = 0; i < def.configContext.length; i++) {
                        def.configContext[i] = new ConfigContext(null, buffer.getShort(), buffer.getInt(), buffer.get() == 1);
                    }
                    break;
                case 4:
                    id = buffer.getShort() & 0xFFFF;
                    String identifier = ByteBufferUtils.getString(buffer);
                    Object[] objects = new Object[identifier.length()];
                    int offset = 0;
                    for (int i = identifier.length() - 1; i >= 0; i--) {
                        if (identifier.charAt(i) == 's') {
                            objects[offset++] = ByteBufferUtils.getString(buffer);
                        } else {
                            objects[offset++] = buffer.getInt();
                        }
                    }
                    def.cs2ScriptContext = new RunScriptContext(null, id, identifier, objects);
                    break;
            }
        }
        return def;
    }

    /**
     * Method used to put a plugin.
     *
     * @param id     the id.
     * @param plugin the plugin.
     */
    public static void put(int id, ComponentPlugin plugin) {
        ComponentDefinition.forId(id).setPlugin(plugin);
    }

    /**
     * Gets the context.
     *
     * @return The context.
     */
    public InterfaceContext getContext() {
        return context;
    }

    /**
     * Gets the accessMask.
     *
     * @return The accessMask.
     */
    public AccessMaskContext getAccessMask() {
        return accessMask;
    }

    /**
     * Gets the configContext.
     *
     * @return The configContext.
     */
    public ConfigContext[] getConfigContext() {
        return configContext;
    }

    /**
     * Gets the definitions mapping.
     *
     * @return The definitions mapping.
     */
    public static Map<Integer, ComponentDefinition> getDefinitions() {
        return DEFINITIONS;
    }

    /**
     * Sets the context.
     *
     * @param context The context to set.
     */
    public void setContext(InterfaceContext context) {
        this.context = context;
    }

    /**
     * Sets the accessMask.
     *
     * @param accessMask The accessMask to set.
     */
    public void setAccessMask(AccessMaskContext accessMask) {
        this.accessMask = accessMask;
    }

    /**
     * Sets the configContext.
     *
     * @param configContext The configContext to set.
     */
    public void setConfigContext(ConfigContext[] configContext) {
        this.configContext = configContext;
    }

    /**
     * Gets the cs2ScriptContext.
     *
     * @return The cs2ScriptContext.
     */
    public RunScriptContext getCs2ScriptContext() {
        return cs2ScriptContext;
    }

    /**
     * Sets the cs2ScriptContext.
     *
     * @param cs2ScriptContext The cs2ScriptContext to set.
     */
    public void setCs2ScriptContext(RunScriptContext cs2ScriptContext) {
        this.cs2ScriptContext = cs2ScriptContext;
    }

    /**
     * Gets the plugin.
     *
     * @return The plugin.
     */
    public ComponentPlugin getPlugin() {
        return plugin;
    }

    /**
     * Sets the plugin.
     *
     * @param plugin The plugin to set.
     */
    public void setPlugin(ComponentPlugin plugin) {
        this.plugin = plugin;
    }
}