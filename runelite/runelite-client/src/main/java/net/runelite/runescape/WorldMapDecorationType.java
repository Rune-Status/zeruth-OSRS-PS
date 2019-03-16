package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2833(0, 0),
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2835(1, 0),
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2830(2, 0),
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2841(3, 0),
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2818(9, 2),
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2823(4, 1),
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2824(5, 1),
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2825(6, 1),
    @ObfuscatedName("n")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2826(7, 1),
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2827(8, 1),
    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2828(12, 2),
    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2821(13, 2),
    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2836(14, 2),
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2831(15, 2),
    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2832(16, 2),
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2822(17, 2),
    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2834(18, 2),
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2829(19, 2),
    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2837(20, 2),
    @ObfuscatedName("t")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2819(21, 2),
    @ObfuscatedName("k")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2838(10, 2),
    @ObfuscatedName("z")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2820(11, 2),
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "Liv;"
    )
    field2840(22, 3);

    @ObfuscatedName("y")
    @ObfuscatedGetter(
            intValue = -1883367987
    )
    public final int rsOrdinal;

    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "0"
    )
    WorldMapDecorationType(int var3, int var4) {
        this.rsOrdinal = var3;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "1"
    )
    public int vmethod5358() {
        return this.rsOrdinal;
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)Ljava/lang/String;",
            garbageValue = "-438189605"
    )
    public static String method2691(String var0) {
        int var1 = var0.length();
        char[] var2 = new char[var1];
        byte var3 = 2;

        for (int var4 = 0; var4 < var1; ++var4) {
            char var5 = var0.charAt(var4);
            if (var3 == 0) {
                var5 = Character.toLowerCase(var5);
            } else if (var3 == 2 || Character.isUpperCase(var5)) {
                char var6;
                if (var5 != 181 && var5 != 131) {
                    var6 = Character.toTitleCase(var5);
                } else {
                    var6 = var5;
                }

                var5 = var6;
            }

            if (Character.isLetter(var5)) {
                var3 = 0;
            } else if (var5 != '.' && var5 != '?' && var5 != '!') {
                if (Character.isSpaceChar(var5)) {
                    if (var3 != 2) {
                        var3 = 1;
                    }
                } else {
                    var3 = 1;
                }
            } else {
                var3 = 2;
            }

            var2[var4] = var5;
        }

        return new String(var2);
    }
}
