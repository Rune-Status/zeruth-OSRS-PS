package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -2075718743
    )
    public int field3814;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 1917826073
    )
    public int field3817;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 1854306227
    )
    public int field3815;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = -1525934389
    )
    public int field3820;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -429976843
    )
    public int field3818;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -2073985007
    )
    public int field3823;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 1524455799
    )
    public int field3819;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -1009787055
    )
    public int field3821;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 1163942849
    )
    public int field3813;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 749697465
    )
    public int field3822;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1828970997
    )
    public int field3816;

    public GraphicsDefaults() {
        this.field3816 = -1;
        this.field3817 = -1;
        this.field3815 = -1;
        this.field3818 = -1;
        this.field3813 = -1;
        this.field3814 = -1;
        this.field3819 = -1;
        this.field3820 = -1;
        this.field3821 = -1;
        this.field3822 = -1;
        this.field3823 = -1;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Liu;I)V",
            garbageValue = "1175740462"
    )
    public void method4013(Js5Index var1) {
        byte[] var2 = var1.method1520(DefaultsGroup.field3812.group);
        Packet var3 = new Packet(var2);

        while (true) {
            int var4 = var3.readUnsignedByte();
            if (var4 == 0) {
                return;
            }

            switch (var4) {
                case 1:
                    var3.method6082();
                    break;
                case 2:
                    this.field3816 = var3.method6207();
                    this.field3817 = var3.method6207();
                    this.field3815 = var3.method6207();
                    this.field3818 = var3.method6207();
                    this.field3813 = var3.method6207();
                    this.field3814 = var3.method6207();
                    this.field3819 = var3.method6207();
                    this.field3820 = var3.method6207();
                    this.field3821 = var3.method6207();
                    this.field3822 = var3.method6207();
                    this.field3823 = var3.method6207();
            }
        }
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(I)[Lli;",
            garbageValue = "-1791356129"
    )
    public static IndexedSprite[] method4016() {
        IndexedSprite[] var0 = new IndexedSprite[class95.indexedSpriteCount];

        for (int var1 = 0; var1 < class95.indexedSpriteCount; ++var1) {
            IndexedSprite var2 = var0[var1] = new IndexedSprite();
            var2.originalWidth = class95.indexedSpriteWidth;
            var2.originalHeight = class95.indexedSpriteHeight;
            var2.offsetX = class95.indexedSpriteOffsetXs[var1];
            var2.offsetY = class95.indexedSpriteOffsetYs[var1];
            var2.width = class95.indexSpriteWidths[var1];
            var2.height = VarClientType.indexedSpriteHeights[var1];
            var2.palette = class95.indexedSpritePalette;
            var2.pixels = class95.spritePixels[var1];
        }

        class95.indexedSpriteOffsetXs = null;
        class95.indexedSpriteOffsetYs = null;
        class95.indexSpriteWidths = null;
        VarClientType.indexedSpriteHeights = null;
        class95.indexedSpritePalette = null;
        class95.spritePixels = null;
        return var0;
    }
}
