package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.lang.management.GarbageCollectorMXBean;
import java.util.Comparator;

@ObfuscatedName("q")
@Implements("TotalQuantityComparator")
final class TotalQuantityComparator implements Comparator {
    @ObfuscatedName("pk")
    @ObfuscatedSignature(
            signature = "Lls;"
    )
    static SpritePixels minimapSprite;
    @ObfuscatedName("pz")
    @ObfuscatedSignature(
            signature = "Lko;"
    )
    static ClanMemberManager clanMemberManager;
    @ObfuscatedName("ay")
    static GarbageCollectorMXBean field24;
    @ObfuscatedName("fv")
    @ObfuscatedSignature(
            signature = "Lkz;"
    )
    static Font font_p12full;

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    public int compare(Object var1, Object var2) {
        return this.method1183((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Le;Le;B)I",
            garbageValue = "-5"
    )
    int method1183(GrandExchangeEvent var1, GrandExchangeEvent var2) {
        return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity ? -1 : (var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity ? 0 : 1);
    }

    @ObfuscatedName("gp")
    @ObfuscatedSignature(
            signature = "(IIIIZI)V",
            garbageValue = "1255618077"
    )
    static final void method1189(int var0, int var1, int var2, int var3, boolean var4) {
        if (var2 < 1) {
            var2 = 1;
        }

        if (var3 < 1) {
            var3 = 1;
        }

        int var5 = var3 - 334;
        int var6;
        if (var5 < 0) {
            var6 = client.field649;
        } else if (var5 >= 100) {
            var6 = client.field896;
        } else {
            var6 = (client.field896 - client.field649) * var5 / 100 + client.field649;
        }

        int var7 = var3 * var6 * 512 / (var2 * 334);
        int var8;
        int var9;
        short var10;
        if (var7 < client.field901) {
            var10 = client.field901;
            var6 = var10 * var2 * 334 / (var3 * 512);
            if (var6 > client.field684) {
                var6 = client.field684;
                var8 = var3 * var6 * 512 / (var10 * 334);
                var9 = (var2 - var8) / 2;
                if (var4) {
                    Rasterizer2D.method439();
                    Rasterizer2D.method449(var0, var1, var9, var3, -16777216);
                    Rasterizer2D.method449(var0 + var2 - var9, var1, var9, var3, -16777216);
                }

                var0 += var9;
                var2 -= var9 * 2;
            }
        } else if (var7 > client.field754) {
            var10 = client.field754;
            var6 = var10 * var2 * 334 / (var3 * 512);
            if (var6 < client.field899) {
                var6 = client.field899;
                var8 = var10 * var2 * 334 / (var6 * 512);
                var9 = (var3 - var8) / 2;
                if (var4) {
                    Rasterizer2D.method439();
                    Rasterizer2D.method449(var0, var1, var2, var9, -16777216);
                    Rasterizer2D.method449(var0, var3 + var1 - var9, var2, var9, -16777216);
                }

                var1 += var9;
                var3 -= var9 * 2;
            }
        }

        client.scale = var3 * var6 / 334;
        if (var2 != client.viewportWidth || var3 != client.viewportHeight) {
            ScriptEvent.method4041(var2, var3);
        }

        client.Viewport_xOffset = var0;
        client.Viewport_yOffset = var1;
        client.viewportWidth = var2;
        client.viewportHeight = var3;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "1511850448"
    )
    public static int method1181(int var0) {
        --var0;
        var0 |= var0 >>> 1;
        var0 |= var0 >>> 2;
        var0 |= var0 >>> 4;
        var0 |= var0 >>> 8;
        var0 |= var0 >>> 16;
        return var0 + 1;
    }
}
