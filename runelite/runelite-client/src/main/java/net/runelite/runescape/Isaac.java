package net.runelite.runescape;

import net.runelite.mapping.*;

@ObfuscatedName("gt")
@Implements("Isaac")
public final class Isaac {
    @ObfuscatedName("gk")
    static byte[][] field2458;
    @ObfuscatedName("df")
    @ObfuscatedSignature(
            signature = "Lih;"
    )
    @Export("jingles")
    static Js5 jingles;
    @ObfuscatedName("l")
    @Export("mem")
    int[] mem;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 702603155
    )
    int field2455;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 1444526381
    )
    @Export("count")
    int count;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 1113218969
    )
    int field2454;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = 1665830875
    )
    int field2449;
    @ObfuscatedName("c")
    @Export("rsl")
    int[] rsl;

    public Isaac(int[] var1) {
        this.mem = new int[256];
        this.rsl = new int[256];

        for (int var2 = 0; var2 < var1.length; ++var2) {
            this.rsl[var2] = var1[var2];
        }

        this.method4021();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "-38"
    )
    final int method4017() {
        if (this.count == 0) {
            this.method4020();
            this.count = 256;
        }

        return this.rsl[this.count - 1];
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1984089559"
    )
    final void method4020() {
        this.field2455 += ++this.field2449;

        for (int var1 = 0; var1 < 256; ++var1) {
            int var2 = this.mem[var1];
            if ((var1 & 2) == 0) {
                if ((var1 & 1) == 0) {
                    this.field2454 ^= this.field2454 << 13;
                } else {
                    this.field2454 ^= this.field2454 >>> 6;
                }
            } else if ((var1 & 1) == 0) {
                this.field2454 ^= this.field2454 << 2;
            } else {
                this.field2454 ^= this.field2454 >>> 16;
            }

            this.field2454 += this.mem[var1 + 128 & 255];
            int var3;
            this.mem[var1] = var3 = this.mem[(var2 & 1020) >> 2] + this.field2454 + this.field2455;
            this.rsl[var1] = this.field2455 = this.mem[(var3 >> 8 & 1020) >> 2] + var2;
        }

    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "818623933"
    )
    final void method4021() {
        int var9 = -1640531527;
        int var8 = -1640531527;
        int var7 = -1640531527;
        int var6 = -1640531527;
        int var5 = -1640531527;
        int var4 = -1640531527;
        int var3 = -1640531527;
        int var2 = -1640531527;

        int var1;
        for (var1 = 0; var1 < 4; ++var1) {
            var2 ^= var3 << 11;
            var5 += var2;
            var3 += var4;
            var3 ^= var4 >>> 2;
            var6 += var3;
            var4 += var5;
            var4 ^= var5 << 8;
            var7 += var4;
            var5 += var6;
            var5 ^= var6 >>> 16;
            var8 += var5;
            var6 += var7;
            var6 ^= var7 << 10;
            var9 += var6;
            var7 += var8;
            var7 ^= var8 >>> 4;
            var2 += var7;
            var8 += var9;
            var8 ^= var9 << 8;
            var3 += var8;
            var9 += var2;
            var9 ^= var2 >>> 9;
            var4 += var9;
            var2 += var3;
        }

        for (var1 = 0; var1 < 256; var1 += 8) {
            var2 += this.rsl[var1];
            var3 += this.rsl[var1 + 1];
            var4 += this.rsl[var1 + 2];
            var5 += this.rsl[var1 + 3];
            var6 += this.rsl[var1 + 4];
            var7 += this.rsl[var1 + 5];
            var8 += this.rsl[var1 + 6];
            var9 += this.rsl[var1 + 7];
            var2 ^= var3 << 11;
            var5 += var2;
            var3 += var4;
            var3 ^= var4 >>> 2;
            var6 += var3;
            var4 += var5;
            var4 ^= var5 << 8;
            var7 += var4;
            var5 += var6;
            var5 ^= var6 >>> 16;
            var8 += var5;
            var6 += var7;
            var6 ^= var7 << 10;
            var9 += var6;
            var7 += var8;
            var7 ^= var8 >>> 4;
            var2 += var7;
            var8 += var9;
            var8 ^= var9 << 8;
            var3 += var8;
            var9 += var2;
            var9 ^= var2 >>> 9;
            var4 += var9;
            var2 += var3;
            this.mem[var1] = var2;
            this.mem[var1 + 1] = var3;
            this.mem[var1 + 2] = var4;
            this.mem[var1 + 3] = var5;
            this.mem[var1 + 4] = var6;
            this.mem[var1 + 5] = var7;
            this.mem[var1 + 6] = var8;
            this.mem[var1 + 7] = var9;
        }

        for (var1 = 0; var1 < 256; var1 += 8) {
            var2 += this.mem[var1];
            var3 += this.mem[var1 + 1];
            var4 += this.mem[var1 + 2];
            var5 += this.mem[var1 + 3];
            var6 += this.mem[var1 + 4];
            var7 += this.mem[var1 + 5];
            var8 += this.mem[var1 + 6];
            var9 += this.mem[var1 + 7];
            var2 ^= var3 << 11;
            var5 += var2;
            var3 += var4;
            var3 ^= var4 >>> 2;
            var6 += var3;
            var4 += var5;
            var4 ^= var5 << 8;
            var7 += var4;
            var5 += var6;
            var5 ^= var6 >>> 16;
            var8 += var5;
            var6 += var7;
            var6 ^= var7 << 10;
            var9 += var6;
            var7 += var8;
            var7 ^= var8 >>> 4;
            var2 += var7;
            var8 += var9;
            var8 ^= var9 << 8;
            var3 += var8;
            var9 += var2;
            var9 ^= var2 >>> 9;
            var4 += var9;
            var2 += var3;
            this.mem[var1] = var2;
            this.mem[var1 + 1] = var3;
            this.mem[var1 + 2] = var4;
            this.mem[var1 + 3] = var5;
            this.mem[var1 + 4] = var6;
            this.mem[var1 + 5] = var7;
            this.mem[var1 + 6] = var8;
            this.mem[var1 + 7] = var9;
        }

        this.method4020();
        this.count = 256;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "211796966"
    )
    final int method4018() {
        if (0 == --this.count + 1) {
            this.method4020();
            this.count = 255;
        }

        return this.rsl[this.count];
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "([BIII)Ljava/lang/String;",
            garbageValue = "1880571754"
    )
    public static String method4024(byte[] var0, int var1, int var2) {
        char[] var3 = new char[var2];
        int var4 = 0;

        for (int var5 = 0; var5 < var2; ++var5) {
            int var6 = var0[var5 + var1] & 255;
            if (var6 != 0) {
                if (var6 >= 128 && var6 < 160) {
                    char var7 = class50.cp1252AsciiExtension[var6 - 128];
                    if (var7 == 0) {
                        var7 = '?';
                    }

                    var6 = var7;
                }

                var3[var4++] = (char) var6;
            }
        }

        return new String(var3, 0, var4);
    }
}
