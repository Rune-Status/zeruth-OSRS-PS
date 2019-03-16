package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
@Implements("Overlay")
public class Overlay extends CacheableNode {
    @ObfuscatedName("pc")
    @ObfuscatedSignature(
            signature = "Lkf;"
    )
    static class307 field3613;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache overlays;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    public static Js5Index overlay_ref;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 225571133
    )
    public int otherRgbColor;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -131754801
    )
    public int color;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 1130465573
    )
    public int saturation;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -1861211023
    )
    public int texture;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = -111305379
    )
    public int otherLightness;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -356057393
    )
    public int otherSaturation;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -671356939
    )
    public int hue;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -1055069025
    )
    public int lightness;
    @ObfuscatedName("c")
    public boolean isHidden;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 1864784443
    )
    public int otherHue;

    static {
        overlays = new NodeCache(64);
    }

    public Overlay() {
        this.color = 0;
        this.texture = -1;
        this.isHidden = true;
        this.otherRgbColor = -1;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(S)V",
            garbageValue = "-32333"
    )
    public void method398() {
        if (this.otherRgbColor != -1) {
            this.method404(this.otherRgbColor);
            this.otherHue = this.hue;
            this.otherSaturation = this.saturation;
            this.otherLightness = this.lightness;
        }

        this.method404(this.color);
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;IB)V",
            garbageValue = "-98"
    )
    public void method418(Packet var1, int var2) {
        while (true) {
            int var3 = var1.readUnsignedByte();
            if (var3 == 0) {
                return;
            }

            this.method400(var1, var3, var2);
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;III)V",
            garbageValue = "-1380971442"
    )
    void method400(Packet var1, int var2, int var3) {
        if (var2 == 1) {
            this.color = var1.method6082();
        } else if (var2 == 2) {
            this.texture = var1.readUnsignedByte();
        } else if (var2 == 5) {
            this.isHidden = false;
        } else if (var2 == 7) {
            this.otherRgbColor = var1.method6082();
        } else if (var2 == 8) {
            ;
        }

    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1600281127"
    )
    void method404(int var1) {
        double var2 = (double) (var1 >> 16 & 255) / 256.0D;
        double var4 = (double) (var1 >> 8 & 255) / 256.0D;
        double var6 = (double) (var1 & 255) / 256.0D;
        double var8 = var2;
        if (var4 < var2) {
            var8 = var4;
        }

        if (var6 < var8) {
            var8 = var6;
        }

        double var10 = var2;
        if (var4 > var2) {
            var10 = var4;
        }

        if (var6 > var10) {
            var10 = var6;
        }

        double var12 = 0.0D;
        double var14 = 0.0D;
        double var16 = (var10 + var8) / 2.0D;
        if (var10 != var8) {
            if (var16 < 0.5D) {
                var14 = (var10 - var8) / (var8 + var10);
            }

            if (var16 >= 0.5D) {
                var14 = (var10 - var8) / (2.0D - var10 - var8);
            }

            if (var10 == var2) {
                var12 = (var4 - var6) / (var10 - var8);
            } else if (var4 == var10) {
                var12 = (var6 - var2) / (var10 - var8) + 2.0D;
            } else if (var6 == var10) {
                var12 = (var2 - var4) / (var10 - var8) + 4.0D;
            }
        }

        var12 /= 6.0D;
        this.hue = (int) (var12 * 256.0D);
        this.saturation = (int) (var14 * 256.0D);
        this.lightness = (int) (var16 * 256.0D);
        if (this.saturation < 0) {
            this.saturation = 0;
        } else if (this.saturation > 255) {
            this.saturation = 255;
        }

        if (this.lightness < 0) {
            this.lightness = 0;
        } else if (this.lightness > 255) {
            this.lightness = 255;
        }

    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(B)Lli;",
            garbageValue = "28"
    )
    static IndexedSprite method405() {
        IndexedSprite var0 = new IndexedSprite();
        var0.originalWidth = class95.indexedSpriteWidth;
        var0.originalHeight = class95.indexedSpriteHeight;
        var0.offsetX = class95.indexedSpriteOffsetXs[0];
        var0.offsetY = class95.indexedSpriteOffsetYs[0];
        var0.width = class95.indexSpriteWidths[0];
        var0.height = VarClientType.indexedSpriteHeights[0];
        var0.palette = class95.indexedSpritePalette;
        var0.pixels = class95.spritePixels[0];
        class95.indexedSpriteOffsetXs = null;
        class95.indexedSpriteOffsetYs = null;
        class95.indexSpriteWidths = null;
        VarClientType.indexedSpriteHeights = null;
        class95.indexedSpritePalette = null;
        class95.spritePixels = null;
        return var0;
    }
}
