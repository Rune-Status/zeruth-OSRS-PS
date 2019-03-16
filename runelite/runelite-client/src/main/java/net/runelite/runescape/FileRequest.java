package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 950982671
    )
    static int field3222;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 1984455813
    )
    int crc;
    @ObfuscatedName("e")
    byte padding;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lih;"
    )
    Js5 index;

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)Ljv;",
            garbageValue = "-203232767"
    )
    public static NPCType method4030(int var0) {
        NPCType var1 = (NPCType) NPCType.npcTypeCache.method951((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = NPCType.NpcDefinition_indexCache.method1516(9, var0, 1789634852);
            var1 = new NPCType();
            var1.id = var0;
            if (var2 != null) {
                var1.method5857(new Packet(var2));
            }

            var1.method5832();
            NPCType.npcTypeCache.method957(var1, (long) var0);
            return var1;
        }
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(I)Lls;",
            garbageValue = "1642096242"
    )
    static SpritePixels method4031() {
        SpritePixels var0 = new SpritePixels();
        var0.maxWidth = class95.indexedSpriteWidth;
        var0.maxHeight = class95.indexedSpriteHeight;
        var0.offsetX = class95.indexedSpriteOffsetXs[0];
        var0.offsetY = class95.indexedSpriteOffsetYs[0];
        var0.width = class95.indexSpriteWidths[0];
        var0.height = VarClientType.indexedSpriteHeights[0];
        int var1 = var0.height * var0.width;
        byte[] var2 = class95.spritePixels[0];
        var0.pixels = new int[var1];

        for (int var3 = 0; var3 < var1; ++var3) {
            var0.pixels[var3] = class95.indexedSpritePalette[var2[var3] & 255];
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
