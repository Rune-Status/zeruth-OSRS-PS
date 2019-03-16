package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("VertexNormal")
public class VertexNormal {
    @ObfuscatedName("fb")
    @ObfuscatedGetter(
            intValue = -1433624309
    )
    static int field1727;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 334751985
    )
    int y;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1861325311
    )
    int z;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 1817634451
    )
    int magnitude;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 1316132941
    )
    int x;

    VertexNormal() {
    }

    @ObfuscatedSignature(
            signature = "(Ldf;)V"
    )
    VertexNormal(VertexNormal var1) {
        this.x = var1.x;
        this.y = var1.y;
        this.z = var1.z;
        this.magnitude = var1.magnitude;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IIB)I",
            garbageValue = "-17"
    )
    static int method2548(int var0, int var1) {
        if (var0 == -2) {
            return 12345678;
        } else if (var0 == -1) {
            if (var1 < 0) {
                var1 = 0;
            } else if (var1 > 127) {
                var1 = 127;
            }

            var1 = 127 - var1;
            return var1;
        } else {
            var1 = (var0 & 127) * var1 / 128;
            if (var1 < 2) {
                var1 = 2;
            } else if (var1 > 126) {
                var1 = 126;
            }

            return (var0 & 65408) + var1;
        }
    }
}
