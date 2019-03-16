package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
@Implements("DState")
public final class DState {
    @ObfuscatedName("f")
    @ObfuscatedGetter(
            intValue = 482945763
    )
    int blockSize100k;
    @ObfuscatedName("l")
    final int field2371;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = 2037948873
    )
    int total_in_hi32;
    @ObfuscatedName("r")
    final int field2400;
    @ObfuscatedName("e")
    final int field2368;
    @ObfuscatedName("af")
    boolean[] inUse;
    @ObfuscatedName("ae")
    int[] field2373;
    @ObfuscatedName("k")
    @ObfuscatedGetter(
            intValue = 1580799655
    )
    int k0;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = -210233059
    )
    int next_in;
    @ObfuscatedName("q")
    final int field2369;
    @ObfuscatedName("x")
    @ObfuscatedGetter(
            intValue = 1123004115
    )
    int out_len;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = -1438073907
    )
    int field2382;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = 443188035
    )
    int next_out;
    @ObfuscatedName("ag")
    int[][] field2399;
    @ObfuscatedName("b")
    byte[] strm;
    @ObfuscatedName("aj")
    byte[][] field2383;
    @ObfuscatedName("aw")
    byte[] field2394;
    @ObfuscatedName("o")
    @ObfuscatedGetter(
            intValue = -735341223
    )
    int nInUse;
    @ObfuscatedName("a")
    @ObfuscatedGetter(
            intValue = -520340777
    )
    int field2387;
    @ObfuscatedName("z")
    int[] field2389;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -1249253775
    )
    int total_out_lo32;
    @ObfuscatedName("c")
    final int field2370;
    @ObfuscatedName("t")
    @ObfuscatedGetter(
            intValue = -93743319
    )
    int tPos;
    @ObfuscatedName("an")
    boolean[] field2392;
    @ObfuscatedName("i")
    byte[] out;
    @ObfuscatedName("at")
    int[] field2402;
    @ObfuscatedName("y")
    int[] field2377;
    @ObfuscatedName("as")
    @ObfuscatedGetter(
            intValue = 189508187
    )
    int field2403;
    @ObfuscatedName("ax")
    byte[] seqToUnseq;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = 417811481
    )
    int total_out_hi32;
    @ObfuscatedName("ar")
    int[][] field2401;
    @ObfuscatedName("j")
    byte out_ch;
    @ObfuscatedName("s")
    @ObfuscatedGetter(
            intValue = 944517239
    )
    int nblock_used;
    @ObfuscatedName("az")
    byte[] field2397;
    @ObfuscatedName("ac")
    byte[] field2396;
    @ObfuscatedName("h")
    @ObfuscatedGetter(
            intValue = 1795747917
    )
    int total_in_lo32;
    @ObfuscatedName("ab")
    int[][] field2384;
    @ObfuscatedName("g")
    final int field2381;

    DState() {
        this.field2381 = 4096;
        this.field2400 = 16;
        this.field2368 = 258;
        this.field2369 = 6;
        this.field2370 = 50;
        this.field2371 = 18002;
        this.next_in = 0;
        this.next_out = 0;
        this.field2389 = new int[256];
        this.field2377 = new int[257];
        this.inUse = new boolean[256];
        this.field2392 = new boolean[16];
        this.seqToUnseq = new byte[256];
        this.field2394 = new byte[4096];
        this.field2373 = new int[16];
        this.field2396 = new byte[18002];
        this.field2397 = new byte[18002];
        this.field2383 = new byte[6][258];
        this.field2399 = new int[6][258];
        this.field2384 = new int[6][258];
        this.field2401 = new int[6][258];
        this.field2402 = new int[6];
    }

    @ObfuscatedName("hd")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZB)V",
            garbageValue = "-75"
    )
    static final void method5638(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
        if (!client.isMenuOpen) {
            if (client.menuOptionCount < 500) {
                client.menuOptions[client.menuOptionCount] = var0;
                client.menuTargets[client.menuOptionCount] = var1;
                client.menuTypes[client.menuOptionCount] = var2;
                client.menuIdentifiers[client.menuOptionCount] = var3;
                client.menuActionParams0[client.menuOptionCount] = var4;
                client.menuActionParams1[client.menuOptionCount] = var5;
                client.menuBooleanArray[client.menuOptionCount] = var6;
                ++client.menuOptionCount;
                client.onMenuOptionsChanged(-1);
            }

        }
    }
}
