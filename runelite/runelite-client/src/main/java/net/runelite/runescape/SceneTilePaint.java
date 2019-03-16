package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSSceneTilePaint;

@ObfuscatedName("di")
@Implements("SceneTilePaint")
public final class SceneTilePaint implements RSSceneTilePaint {
    @ObfuscatedName("l")
    boolean flatShade;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -1909340085
    )
    int seColor;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 2018545505
    )
    int neColor;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -33883349
    )
    int nwColor;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -1390331519
    )
    int rgb;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 52639837
    )
    int texture;
    public int rl$paintModelBufferOffset;
    public int rl$paintModelUvBufferOffset;
    public int rl$paintModelBufferLen;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -264466195
    )
    int swColor;

    SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
        this.flatShade = true;
        this.swColor = var1;
        this.seColor = var2;
        this.neColor = var3;
        this.nwColor = var4;
        this.texture = var5;
        this.rgb = var6;
        this.flatShade = var7;
    }

    public int getBufferOffset() {
        return this.rl$paintModelBufferOffset;
    }

    public void setBufferOffset(int var1) {
        this.rl$paintModelBufferOffset = var1;
    }

    public int getUvBufferOffset() {
        return this.rl$paintModelUvBufferOffset;
    }

    public void setUvBufferOffset(int var1) {
        this.rl$paintModelUvBufferOffset = var1;
    }

    public int getBufferLen() {
        return this.rl$paintModelBufferLen;
    }

    public void setBufferLen(int var1) {
        this.rl$paintModelBufferLen = var1;
    }

    public int getSwColor() {
        return this.swColor;
    }

    public int getNwColor() {
        return this.seColor;
    }

    public int getNeColor() {
        return this.neColor;
    }

    public int getSeColor() {
        return this.nwColor;
    }

    public int getTexture() {
        return this.texture;
    }

    public int getRBG() {
        return this.rgb;
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "([BI)V",
            garbageValue = "1926576474"
    )
    public static void method667(byte[] var0) {
        Packet var1 = new Packet(var0);
        var1.offset = var0.length - 2;
        class95.indexedSpriteCount = var1.readUnsignedShort();
        class95.indexedSpriteOffsetXs = new int[class95.indexedSpriteCount];
        class95.indexedSpriteOffsetYs = new int[class95.indexedSpriteCount];
        class95.indexSpriteWidths = new int[class95.indexedSpriteCount];
        VarClientType.indexedSpriteHeights = new int[class95.indexedSpriteCount];
        class95.spritePixels = new byte[class95.indexedSpriteCount][];
        var1.offset = var0.length - 7 - class95.indexedSpriteCount * 8;
        class95.indexedSpriteWidth = var1.readUnsignedShort();
        class95.indexedSpriteHeight = var1.readUnsignedShort();
        int var2 = (var1.readUnsignedByte() & 255) + 1;

        int var3;
        for (var3 = 0; var3 < class95.indexedSpriteCount; ++var3) {
            class95.indexedSpriteOffsetXs[var3] = var1.readUnsignedShort();
        }

        for (var3 = 0; var3 < class95.indexedSpriteCount; ++var3) {
            class95.indexedSpriteOffsetYs[var3] = var1.readUnsignedShort();
        }

        for (var3 = 0; var3 < class95.indexedSpriteCount; ++var3) {
            class95.indexSpriteWidths[var3] = var1.readUnsignedShort();
        }

        for (var3 = 0; var3 < class95.indexedSpriteCount; ++var3) {
            VarClientType.indexedSpriteHeights[var3] = var1.readUnsignedShort();
        }

        var1.offset = var0.length - 7 - class95.indexedSpriteCount * 8 - (var2 - 1) * 3;
        class95.indexedSpritePalette = new int[var2];

        for (var3 = 1; var3 < var2; ++var3) {
            class95.indexedSpritePalette[var3] = var1.method6082();
            if (class95.indexedSpritePalette[var3] == 0) {
                class95.indexedSpritePalette[var3] = 1;
            }
        }

        var1.offset = 0;

        for (var3 = 0; var3 < class95.indexedSpriteCount; ++var3) {
            int var4 = class95.indexSpriteWidths[var3];
            int var5 = VarClientType.indexedSpriteHeights[var3];
            int var6 = var4 * var5;
            byte[] var7 = new byte[var6];
            class95.spritePixels[var3] = var7;
            int var8 = var1.readUnsignedByte();
            int var9;
            if (var8 == 0) {
                for (var9 = 0; var9 < var6; ++var9) {
                    var7[var9] = var1.method6240();
                }
            } else if (var8 == 1) {
                for (var9 = 0; var9 < var4; ++var9) {
                    for (int var10 = 0; var10 < var5; ++var10) {
                        var7[var9 + var4 * var10] = var1.method6240();
                    }
                }
            }
        }

    }

    @ObfuscatedName("fr")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1338888273"
    )
    static final void method668() {
        MouseInput.method5787();
        FloorUnderlayDefinition.underlays.method952();
        WorldMapRectangle.method126();
        LocType.objects.method952();
        LocType.field3457.method952();
        LocType.cachedModels.method952();
        LocType.field3473.method952();
        NPCType.npcTypeCache.method952();
        NPCType.npcModelCache.method952();
        ServerConnection.method5888();
        ScriptState.method423();
        class11.method171();
        Varbit.varbits.method952();
        class228.method4529();
        HitmarkType.hitmarkTypeCache.method952();
        HitmarkType.field3430.method952();
        HitmarkType.field3434.method952();
        HeadbarType.field3385.method952();
        HeadbarType.field3382.method952();
        class60.method886();
        class49.method780();
        MapElementType.areaSpriteCache.method952();
        SubInterface.method2439();
        ComponentType.field2661.method952();
        ComponentType.componentModelCache.method952();
        ComponentType.componentFontCache.method952();
        ComponentType.field2664.method952();
        ((TextureProvider) Graphics3D.textureLoader).method2787();
        class106.field1261.method952();
        WorldMapDecoration.anims.method1529();
        GameCanvas.bases.method1529();
        class166.interfacesArchive.method1529();
        class192.synths.method1529();
        class239.maps.method1529();
        ServerProt.music.method1529();
        class113.models.method1529();
        JagException.sprites.method1529();
        WorldMapRectangle.textures.method1529();
        Size.binary.method1529();
        Isaac.jingles.method1529();
        UrlRequester.clientscripts.method1529();
    }
}
