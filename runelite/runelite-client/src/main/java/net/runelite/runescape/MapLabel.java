package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("MapLabel")
public class MapLabel {
    @ObfuscatedName("pu")
    static boolean field221;
    @ObfuscatedName("lj")
    @ObfuscatedGetter(
            intValue = 740122547
    )
    static int selectedItemIndex;
    @ObfuscatedName("aa")
    protected static String field222;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 821831995
    )
    int field214;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 1790492135
    )
    int field215;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Ld;"
    )
    Size fontSize;
    @ObfuscatedName("g")
    String text;

    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;IILd;)V"
    )
    MapLabel(String var1, int var2, int var3, Size var4) {
        this.text = var1;
        this.field214 = var2;
        this.field215 = var3;
        this.fontSize = var4;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;B)Ljava/lang/String;",
            garbageValue = "36"
    )
    public static String method5551(Packet var0) {
        return Tile.method4296(var0, 32767);
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lge;S)I",
            garbageValue = "-2488"
    )
    static int method5552(Bit var0) {
        int var1 = var0.getBits(2);
        int var2;
        if (var1 == 0) {
            var2 = 0;
        } else if (var1 == 1) {
            var2 = var0.getBits(5);
        } else if (var1 == 2) {
            var2 = var0.getBits(8);
        } else {
            var2 = var0.getBits(11);
        }

        return var2;
    }

    @ObfuscatedName("q")
    public static int method5553(long var0) {
        return (int) (var0 >>> 0 & 127L);
    }
}
