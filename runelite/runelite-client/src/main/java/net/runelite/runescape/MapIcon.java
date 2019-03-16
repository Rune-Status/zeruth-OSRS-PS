package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("MapIcon")
public class MapIcon {
    @ObfuscatedName("k")
    public static String osName;
    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index field282;
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Ls;"
    )
    final MapLabel field278;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lhz;"
    )
    public final Coordinates field277;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lhz;"
    )
    public final Coordinates field279;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 440806547
    )
    int screenY;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 1737581913
    )
    final int field281;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 2075998493
    )
    int screenX;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -1640983307
    )
    final int field280;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 1394489091
    )
    public final int areaId;

    @ObfuscatedSignature(
            signature = "(ILhz;Lhz;Ls;)V"
    )
    MapIcon(int var1, Coordinates var2, Coordinates var3, MapLabel var4) {
        this.areaId = var1;
        this.field279 = var2;
        this.field277 = var3;
        this.field278 = var4;
        MapElementType var5 = Timer.method5389(this.areaId);
        SpritePixels var6 = var5.method2386(false);
        if (var6 != null) {
            this.field281 = var6.width;
            this.field280 = var6.height;
        } else {
            this.field281 = 0;
            this.field280 = 0;
        }

    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(III)Z",
            garbageValue = "2058981001"
    )
    boolean method4551(int var1, int var2) {
        MapElementType var3 = Timer.method5389(this.areaId);
        switch (var3.horizontalAlignment.field3562) {
            case 0:
                if (var1 > this.screenX - this.field281 && var1 <= this.screenX) {
                    break;
                }

                return false;
            case 1:
                if (var1 >= this.screenX - this.field281 / 2 && var1 <= this.field281 / 2 + this.screenX) {
                    break;
                }

                return false;
            case 2:
                if (var1 < this.screenX || var1 >= this.field281 + this.screenX) {
                    return false;
                }
        }

        switch (var3.verticalAlignment.field3292) {
            case 0:
                if (var2 >= this.screenY && var2 < this.screenY + this.field280) {
                    break;
                }

                return false;
            case 1:
                if (var2 < this.screenY - this.field280 / 2 || var2 > this.field280 / 2 + this.screenY) {
                    return false;
                }
                break;
            case 2:
                if (var2 <= this.screenY - this.field280 || var2 > this.screenY) {
                    return false;
                }
        }

        return true;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IIB)Z",
            garbageValue = "34"
    )
    boolean method4553(int var1, int var2) {
        return this.field278 == null ? false : (var1 >= this.screenX - this.field278.field214 / 2 && var1 <= this.field278.field214 / 2 + this.screenX ? var2 >= this.screenY && var2 <= this.field278.field215 + this.screenY : false);
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(III)Z",
            garbageValue = "-1318094050"
    )
    boolean method4556(int var1, int var2) {
        return this.method4551(var1, var2) ? true : this.method4553(var1, var2);
    }
}
