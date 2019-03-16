package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
@Implements("ObjectNode")
public class ObjectNode extends Node {
    @ObfuscatedName("g")
    public final Object value;

    public ObjectNode(Object var1) {
        this.value = var1;
    }
}
