package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("ChatCrownType")
public enum ChatCrownType implements Enumerated {
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lif;"
    )
    NONE(0, -1, true, false, true),
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lif;"
    )
    PLAYER_MOD(1, 0, true, true, true),
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lif;"
    )
    STAFF_MOD(2, 1, true, true, false),
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lif;"
    )
    IRONMAN(3, 2, false, false, true),
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Lif;"
    )
    ULTIMATE_IRONMAN(4, 3, false, false, true),
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Lif;"
    )
    HARDCORE_IRONMAN(5, 10, false, false, true);

    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 1432563027
    )
    public final int icon;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 1712147215
    )
    final int id;
    @ObfuscatedName("n")
    public final boolean moderator;
    @ObfuscatedName("i")
    public final boolean ignorable;

    ChatCrownType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
        this.id = var3;
        this.icon = var4;
        this.moderator = var6;
        this.ignorable = var7;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "1"
    )
    public int vmethod5358() {
        return this.id;
    }

    @ObfuscatedName("kj")
    @ObfuscatedSignature(
            signature = "(Lhn;I)Lhn;",
            garbageValue = "-1495361248"
    )
    static ComponentType method834(ComponentType var0) {
        int var1 = class113.method1965(class101.method1704(var0));
        if (var1 == 0) {
            return null;
        } else {
            for (int var2 = 0; var2 < var1; ++var2) {
                var0 = WorldMapType1.method2440(var0.layer);
                if (var0 == null) {
                    return null;
                }
            }

            return var0;
        }
    }
}
