package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
    @ObfuscatedName("sr")
    @ObfuscatedGetter(
            intValue = 317926135
    )
    static int field1983;
    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "Lar;"
    )
    static MapIconReference scriptMapIconReference;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 312258391
    )
    int field1978;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -591026959
    )
    int field1977;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 1603915075
    )
    int sleepTime;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            longValue = 2310160410611864431L
    )
    long field1979;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -1635768921
    )
    int field1981;
    @ObfuscatedName("g")
    long[] field1976;

    MilliTimer() {
        this.field1976 = new long[10];
        this.field1977 = 256;
        this.sleepTime = 1;
        this.field1981 = 0;
        this.field1979 = Tile.method4297();

        for (int var1 = 0; var1 < 10; ++var1) {
            this.field1976[var1] = this.field1979;
        }

    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "-191189521"
    )
    public int vmethod5391(int var1, int var2) {
        int var3 = this.field1977;
        int var4 = this.sleepTime;
        this.field1977 = 300;
        this.sleepTime = 1;
        this.field1979 = Tile.method4297();
        if (this.field1976[this.field1978] == 0L) {
            this.field1977 = var3;
            this.sleepTime = var4;
        } else if (this.field1979 > this.field1976[this.field1978]) {
            this.field1977 = (int) ((long) (var1 * 2560) / (this.field1979 - this.field1976[this.field1978]));
        }

        if (this.field1977 < 25) {
            this.field1977 = 25;
        }

        if (this.field1977 > 256) {
            this.field1977 = 256;
            this.sleepTime = (int) ((long) var1 - (this.field1979 - this.field1976[this.field1978]) / 10L);
        }

        if (this.sleepTime > var1) {
            this.sleepTime = var1;
        }

        this.field1976[this.field1978] = this.field1979;
        this.field1978 = (this.field1978 + 1) % 10;
        int var5;
        if (this.sleepTime > 1) {
            for (var5 = 0; var5 < 10; ++var5) {
                if (0L != this.field1976[var5]) {
                    this.field1976[var5] += (long) this.sleepTime;
                }
            }
        }

        if (this.sleepTime < var2) {
            this.sleepTime = var2;
        }

        class182.method3129((long) this.sleepTime);

        for (var5 = 0; this.field1981 < 256; this.field1981 += this.field1977) {
            ++var5;
        }

        this.field1981 &= 255;
        return var5;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "2124397224"
    )
    public void vmethod5390() {
        for (int var1 = 0; var1 < 10; ++var1) {
            this.field1976[var1] = 0L;
        }

    }

    @ObfuscatedName("gq")
    @ObfuscatedSignature(
            signature = "(IIIB)I",
            garbageValue = "22"
    )
    static final int method2824(int var0, int var1, int var2) {
        int var3 = var0 >> 7;
        int var4 = var1 >> 7;
        if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
            int var5 = var2;
            if (var2 < 3 && (class98.tileSettings[1][var3][var4] & 2) == 2) {
                var5 = var2 + 1;
            }

            int var6 = var0 & 127;
            int var7 = var1 & 127;
            int var8 = (128 - var6) * class98.tileHeights[var5][var3][var4] + class98.tileHeights[var5][var3 + 1][var4] * var6 >> 7;
            int var9 = var6 * class98.tileHeights[var5][var3 + 1][var4 + 1] + class98.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
            return var9 * var7 + var8 * (128 - var7) >> 7;
        } else {
            return 0;
        }
    }
}
