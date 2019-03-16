package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lc")
@Implements("Bounds")
public class Bounds {
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 1558181167
    )
    public int field3835;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 1903384477
    )
    public int field3837;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -1389254199
    )
    public int field3838;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1369861301
    )
    public int field3836;

    public Bounds(int var1, int var2, int var3, int var4) {
        this.method1089(var1, var2);
        this.method1090(var3, var4);
    }

    public Bounds(int var1, int var2) {
        this(0, 0, var1, var2);
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "1910396135"
    )
    public void method1090(int var1, int var2) {
        this.field3837 = var1;
        this.field3838 = var2;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Llc;Llc;I)V",
            garbageValue = "-683882211"
    )
    public void method1092(Bounds var1, Bounds var2) {
        this.method1121(var1, var2);
        this.method1093(var1, var2);
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Llc;Llc;B)V",
            garbageValue = "-115"
    )
    void method1121(Bounds var1, Bounds var2) {
        var2.field3836 = this.field3836;
        var2.field3837 = this.field3837;
        if (this.field3836 < var1.field3836) {
            var2.field3837 -= var1.field3836 - this.field3836;
            var2.field3836 = var1.field3836;
        }

        if (var2.method1094() > var1.method1094()) {
            var2.field3837 -= var2.method1094() - var1.method1094();
        }

        if (var2.field3837 < 0) {
            var2.field3837 = 0;
        }

    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "978017217"
    )
    int method1095() {
        return this.field3838 + this.field3835;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(Llc;Llc;I)V",
            garbageValue = "587374040"
    )
    void method1093(Bounds var1, Bounds var2) {
        var2.field3835 = this.field3835;
        var2.field3838 = this.field3838;
        if (this.field3835 < var1.field3835) {
            var2.field3838 -= var1.field3835 - this.field3835;
            var2.field3835 = var1.field3835;
        }

        if (var2.method1095() > var1.method1095()) {
            var2.field3838 -= var2.method1095() - var1.method1095();
        }

        if (var2.field3838 < 0) {
            var2.field3838 = 0;
        }

    }

    public String toString() {
        return null;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "198370442"
    )
    int method1094() {
        return this.field3837 + this.field3836;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "540610323"
    )
    public void method1089(int var1, int var2) {
        this.field3836 = var1;
        this.field3835 = var2;
    }
}
