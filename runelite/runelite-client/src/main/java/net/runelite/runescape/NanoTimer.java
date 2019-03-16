package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("NanoTimer")
public class NanoTimer extends Timer {
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            longValue = -4056705366710993001L
    )
    long nanoTime;

    NanoTimer() {
        this.nanoTime = System.nanoTime();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "-191189521"
    )
    public int vmethod5391(int var1, int var2) {
        long var3 = 1000000L * (long) var2;
        long var5 = this.nanoTime - System.nanoTime();
        if (var5 < var3) {
            var5 = var3;
        }

        class182.method3129(var5 / 1000000L);
        long var7 = System.nanoTime();

        int var9;
        for (var9 = 0; var9 < 10 && (var9 < 1 || this.nanoTime < var7); this.nanoTime += (long) var1 * 1000000L) {
            ++var9;
        }

        if (this.nanoTime < var7) {
            this.nanoTime = var7;
        }

        return var9;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "2124397224"
    )
    public void vmethod5390() {
        this.nanoTime = System.nanoTime();
    }
}
