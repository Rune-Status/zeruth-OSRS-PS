package net.runelite.runescape;

import net.runelite.mapping.*;

@ObfuscatedName("cb")
@Implements("AttackOpPriority")
public enum AttackOpPriority implements Enumerated {
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lcb;"
    )
    @Export("COMBAT_LEVEL_BASED")
    COMBAT_LEVEL_BASED(0),
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lcb;"
    )
    @Export("UNPRIORITISED")
    UNPRIORITISED(1),
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lcb;"
    )
    @Export("PRIORITISED")
    PRIORITISED(2),
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lcb;"
    )
    @Export("HIDDEN")
    HIDDEN(3);

    @ObfuscatedName("bx")
    @ObfuscatedSignature(
            signature = "[Lls;"
    )
    static SpritePixels[] field1137;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -538686965
    )
    @Export("id")
    final int id;

    AttackOpPriority(int var3) {
        this.id = var3;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "1"
    )
    public int vmethod5358() {
        return this.id;
    }
}
