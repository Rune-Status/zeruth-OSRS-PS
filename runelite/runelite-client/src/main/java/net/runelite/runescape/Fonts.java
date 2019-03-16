package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.HashMap;

@ObfuscatedName("kc")
@Implements("Fonts")
public class Fonts {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    Js5Index field3750;
    @ObfuscatedName("e")
    HashMap map;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    Js5Index field3751;

    @ObfuscatedSignature(
            signature = "(Liu;Liu;)V"
    )
    public Fonts(Js5Index var1, Js5Index var2) {
        this.field3751 = var1;
        this.field3750 = var2;
        this.map = new HashMap();
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "([Lkm;I)Ljava/util/HashMap;",
            garbageValue = "-1974155434"
    )
    public HashMap method4045(FontName[] var1) {
        HashMap var2 = new HashMap();
        FontName[] var3 = var1;

        for (int var4 = 0; var4 < var3.length; ++var4) {
            FontName var5 = var3[var4];
            if (this.map.containsKey(var5)) {
                var2.put(var5, this.map.get(var5));
            } else {
                Js5Index var7 = this.field3751;
                Js5Index var8 = this.field3750;
                String var9 = var5.field3748;
                int var10 = var7.method1510(var9);
                int var11 = var7.method1532(var10, "");
                Font var12;
                if (!WorldMapRectangle.method128(var7, var10, var11)) {
                    var12 = null;
                } else {
                    byte[] var14 = var8.method1516(var10, var11, 1789634852);
                    Font var13;
                    if (var14 == null) {
                        var13 = null;
                    } else {
                        Font var15 = new Font(var14, class95.indexedSpriteOffsetXs, class95.indexedSpriteOffsetYs, class95.indexSpriteWidths, VarClientType.indexedSpriteHeights, class95.indexedSpritePalette, class95.spritePixels);
                        class95.indexedSpriteOffsetXs = null;
                        class95.indexedSpriteOffsetYs = null;
                        class95.indexSpriteWidths = null;
                        VarClientType.indexedSpriteHeights = null;
                        class95.indexedSpritePalette = null;
                        class95.spritePixels = null;
                        var13 = var15;
                    }

                    var12 = var13;
                }

                if (var12 != null) {
                    this.map.put(var5, var12);
                    var2.put(var5, var12);
                }
            }
        }

        return var2;
    }
}
