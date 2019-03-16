package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("ModeGame")
public enum ModeGame implements Enumerated {
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liz;"
    )
    RUNESCAPE("runescape", "RuneScape", 0),
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Liz;"
    )
    STELLARDAWN("stellardawn", "Stellar Dawn", 1),
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Liz;"
    )
    GAME3("game3", "Game 3", 2),
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Liz;"
    )
    GAME4("game4", "Game 4", 3),
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Liz;"
    )
    GAME5("game5", "Game 5", 4),
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Liz;"
    )
    OLDSCAPE("oldscape", "RuneScape 2007", 5);

    @ObfuscatedName("i")
    static int[] floorHues;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 920591555
    )
    final int id;
    @ObfuscatedName("b")
    public final String name;

    ModeGame(String var3, String var4, int var5) {
        this.name = var3;
        this.id = var5;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "1"
    )
    public int vmethod5358() {
        return this.id;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/CharSequence;II[BIB)I",
            garbageValue = "-86"
    )
    public static int method4298(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
        int var5 = var2 - var1;

        for (int var6 = 0; var6 < var5; ++var6) {
            char var7 = var0.charAt(var6 + var1);
            if (var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
                var3[var6 + var4] = (byte) var7;
            } else if (var7 == 8364) {
                var3[var6 + var4] = -128;
            } else if (var7 == 8218) {
                var3[var6 + var4] = -126;
            } else if (var7 == 402) {
                var3[var6 + var4] = -125;
            } else if (var7 == 8222) {
                var3[var6 + var4] = -124;
            } else if (var7 == 8230) {
                var3[var6 + var4] = -123;
            } else if (var7 == 8224) {
                var3[var6 + var4] = -122;
            } else if (var7 == 8225) {
                var3[var6 + var4] = -121;
            } else if (var7 == 710) {
                var3[var6 + var4] = -120;
            } else if (var7 == 8240) {
                var3[var6 + var4] = -119;
            } else if (var7 == 352) {
                var3[var6 + var4] = -118;
            } else if (var7 == 8249) {
                var3[var6 + var4] = -117;
            } else if (var7 == 338) {
                var3[var6 + var4] = -116;
            } else if (var7 == 381) {
                var3[var6 + var4] = -114;
            } else if (var7 == 8216) {
                var3[var6 + var4] = -111;
            } else if (var7 == 8217) {
                var3[var6 + var4] = -110;
            } else if (var7 == 8220) {
                var3[var6 + var4] = -109;
            } else if (var7 == 8221) {
                var3[var6 + var4] = -108;
            } else if (var7 == 8226) {
                var3[var6 + var4] = -107;
            } else if (var7 == 8211) {
                var3[var6 + var4] = -106;
            } else if (var7 == 8212) {
                var3[var6 + var4] = -105;
            } else if (var7 == 732) {
                var3[var6 + var4] = -104;
            } else if (var7 == 8482) {
                var3[var6 + var4] = -103;
            } else if (var7 == 353) {
                var3[var6 + var4] = -102;
            } else if (var7 == 8250) {
                var3[var6 + var4] = -101;
            } else if (var7 == 339) {
                var3[var6 + var4] = -100;
            } else if (var7 == 382) {
                var3[var6 + var4] = -98;
            } else if (var7 == 376) {
                var3[var6 + var4] = -97;
            } else {
                var3[var6 + var4] = 63;
            }
        }

        return var5;
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(CB)Z",
            garbageValue = "1"
    )
    public static boolean method4305(char var0) {
        return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "([I[II)V",
            garbageValue = "-131664052"
    )
    public static void method4307(int[] var0, int[] var1) {
        if (var0 != null && var1 != null) {
            class134.field253 = var0;
            class150.field2411 = new int[var0.length];
            class309.field3737 = new byte[var0.length][][];

            for (int var2 = 0; var2 < class134.field253.length; ++var2) {
                class309.field3737[var2] = new byte[var1[var2]][];
            }

        } else {
            class134.field253 = null;
            class150.field2411 = null;
            class309.field3737 = null;
        }
    }
}
