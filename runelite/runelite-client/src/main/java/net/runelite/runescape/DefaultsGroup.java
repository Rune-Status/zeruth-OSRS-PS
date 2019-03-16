package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
@Implements("DefaultsGroup")
public class DefaultsGroup {
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lkq;"
    )
    static final DefaultsGroup field3812;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 2074305639
    )
    final int group;

    static {
        field3812 = new DefaultsGroup(3);
    }

    DefaultsGroup(int var1) {
        this.group = var1;
    }
}
