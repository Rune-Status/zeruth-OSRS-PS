package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("Enumerated")
public interface Enumerated {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "1"
    )
    int vmethod5358();
}
