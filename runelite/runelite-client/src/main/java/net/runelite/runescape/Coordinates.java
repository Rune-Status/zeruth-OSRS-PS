package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("Coordinates")
public class Coordinates {
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -1863832433
    )
    public int worldX;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 584949981
    )
    public int worldY;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -729775687
    )
    public int plane;

    @ObfuscatedSignature(
            signature = "(Lhz;)V"
    )
    public Coordinates(Coordinates var1) {
        this.plane = var1.plane;
        this.worldX = var1.worldX;
        this.worldY = var1.worldY;
    }

    public Coordinates(int var1, int var2, int var3) {
        this.plane = var1;
        this.worldX = var2;
        this.worldY = var3;
    }

    public Coordinates(int var1) {
        if (var1 == -1) {
            this.plane = -1;
        } else {
            this.plane = var1 >> 28 & 3;
            this.worldX = var1 >> 14 & 16383;
            this.worldY = var1 & 16383;
        }

    }

    public Coordinates() {
        this.plane = -1;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "1586823338"
    )
    public int method2471() {
        return this.plane << 28 | this.worldX << 14 | this.worldY;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lhz;I)Z",
            garbageValue = "-611395595"
    )
    boolean method2484(Coordinates var1) {
        return this.plane != var1.plane ? false : (this.worldX != var1.worldX ? false : this.worldY == var1.worldY);
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)Ljava/lang/String;",
            garbageValue = "-1981309301"
    )
    String method2481(String var1) {
        return this.plane + var1 + (this.worldX >> 6) + var1 + (this.worldY >> 6) + var1 + (this.worldX & 63) + var1 + (this.worldY & 63);
    }

    public int hashCode() {
        return this.method2471();
    }

    public String toString() {
        return this.method2481(",");
    }

    public boolean equals(Object var1) {
        return this == var1 ? true : (!(var1 instanceof Coordinates) ? false : this.method2484((Coordinates) var1));
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(IIIB)V",
            garbageValue = "33"
    )
    public void method2469(int var1, int var2, int var3) {
        this.plane = var1;
        this.worldX = var2;
        this.worldY = var3;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/CharSequence;B)J",
            garbageValue = "-32"
    )
    static long method2470(CharSequence var0) {
        long var1 = 0L;
        int var3 = var0.length();

        for (int var4 = 0; var4 < var3; ++var4) {
            var1 *= 37L;
            char var5 = var0.charAt(var4);
            if (var5 >= 'A' && var5 <= 'Z') {
                var1 += (long) (var5 + 1 - 65);
            } else if (var5 >= 'a' && var5 <= 'z') {
                var1 += (long) (var5 + 1 - 97);
            } else if (var5 >= '0' && var5 <= '9') {
                var1 += (long) (var5 + 27 - 48);
            }

            if (var1 >= 177917621779460413L) {
                break;
            }
        }

        while (0L == var1 % 37L && var1 != 0L) {
            var1 /= 37L;
        }

        return var1;
    }
}
