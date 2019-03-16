package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.*;
import java.util.Map.Entry;

@ObfuscatedName("y")
@Implements("WorldMapRegion")
public class WorldMapRegion {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "Lhz;"
    )
    static final Coordinates field240;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            signature = "Lgz;"
    )
    static class299 field232;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Lgz;"
    )
    static class299 field235;
    @ObfuscatedName("v")
    HashMap field241;
    @ObfuscatedName("x")
    List field239;
    @ObfuscatedName("m")
    LinkedList field230;
    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "Lp;"
    )
    class113 field236;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -510316149
    )
    int field233;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 92467027
    )
    int field234;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = -281458697
    )
    int field237;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = -1503482807
    )
    int pixelsPerTile;
    @ObfuscatedName("h")
    final HashMap mapFonts;

    static {
        field235 = new class299(37748736, 256);
        field232 = new class299(256, 256);
        field240 = new Coordinates();
    }

    WorldMapRegion(int var1, int var2, int var3, HashMap var4) {
        this.field233 = var1;
        this.field234 = var2;
        this.field230 = new LinkedList();
        this.field239 = new LinkedList();
        this.field241 = new HashMap();
        this.field237 = var3 | -16777216;
        this.mapFonts = var4;
    }

    @ObfuscatedName("ak")
    @ObfuscatedSignature(
            signature = "(IIIIII)Ljava/util/List;",
            garbageValue = "1735993427"
    )
    List method4181(int var1, int var2, int var3, int var4, int var5) {
        LinkedList var6 = new LinkedList();
        if (var4 >= var1 && var5 >= var2) {
            if (var4 < var3 + var1 && var5 < var3 + var2) {
                Iterator var7 = this.field241.values().iterator();

                MapIcon var8;
                while (var7.hasNext()) {
                    var8 = (MapIcon) var7.next();
                    if (var8.method4556(var4, var5)) {
                        var6.add(var8);
                    }
                }

                var7 = this.field239.iterator();

                while (var7.hasNext()) {
                    var8 = (MapIcon) var7.next();
                    if (var8.method4556(var4, var5)) {
                        var6.add(var8);
                    }
                }

                return var6;
            } else {
                return var6;
            }
        } else {
            return var6;
        }
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(IILh;Lab;[Lli;I)V",
            garbageValue = "-1918314592"
    )
    void method4156(int var1, int var2, class310 var3, class324 var4, IndexedSprite[] var5) {
        this.method4166(var1, var2, var3);
        this.method4165(var1, var2, var3, var5);
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(Lab;[Ly;[Lli;Lz;B)V",
            garbageValue = "37"
    )
    void method4205(class324 var1, WorldMapRegion[] var2, IndexedSprite[] var3, class147 var4) {
        int var5;
        int var6;
        for (var5 = 0; var5 < 64; ++var5) {
            for (var6 = 0; var6 < 64; ++var6) {
                this.method4277(var5, var6, this.field236, var1, var4);
                this.method4154(var5, var6, this.field236, var1);
            }
        }

        for (var5 = 0; var5 < 64; ++var5) {
            for (var6 = 0; var6 < 64; ++var6) {
                this.method4156(var5, var6, this.field236, var1, var3);
            }
        }

    }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            signature = "(IILh;Lz;I)I",
            garbageValue = "1397575589"
    )
    int method4164(int var1, int var2, class310 var3, class147 var4) {
        return var3.field152[0][var1][var2] == 0 ? this.field237 : var4.method2537(var1, var2);
    }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            signature = "(Lii;I)Ls;",
            garbageValue = "166000646"
    )
    MapLabel method4194(MapElementType var1) {
        if (var1.text != null && this.mapFonts != null && this.mapFonts.get(Size.field92) != null) {
            Size var2 = Size.method4687(var1.textSize);
            if (var2 == null) {
                return null;
            } else {
                Font var3 = (Font) this.mapFonts.get(var2);
                if (var3 == null) {
                    return null;
                } else {
                    int var4 = var3.method1778(var1.text, 1000000);
                    String[] var5 = new String[var4];
                    var3.method1776(var1.text, (int[]) null, var5);
                    int var6 = var5.length * var3.verticalSpace / 2;
                    int var7 = 0;
                    String[] var8 = var5;

                    for (int var9 = 0; var9 < var8.length; ++var9) {
                        String var10 = var8[var9];
                        int var11 = var3.method1775(var10);
                        if (var11 > var7) {
                            var7 = var11;
                        }
                    }

                    return new MapLabel(var1.text, var7, var6, var2);
                }
            }
        } else {
            return null;
        }
    }

    @ObfuscatedName("ae")
    @ObfuscatedSignature(
            signature = "(Ljava/util/HashSet;III)V",
            garbageValue = "-256903629"
    )
    void method4168(HashSet var1, int var2, int var3) {
        Iterator var4 = this.field239.iterator();

        while (var4.hasNext()) {
            MapIcon var5 = (MapIcon) var4.next();
            MapElementType var6 = Timer.method5389(var5.areaId);
            if (var6 != null && var1.contains(Integer.valueOf(var6.method2368()))) {
                this.method4169(var6, var5.screenX, var5.screenY, var2, var3);
            }
        }

    }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            signature = "(II[Ly;I)Lz;",
            garbageValue = "1775981142"
    )
    class147 method4159(int var1, int var2, WorldMapRegion[] var3) {
        class299 var5 = field232;
        long var6 = (long) (0 | var1 << 8 | var2);
        class147 var4 = (class147) var5.method5733(var6);
        class147 var11 = var4;
        if (var4 == null) {
            var11 = this.method4279(var3);
            class299 var10 = field232;
            long var8 = (long) (0 | var1 << 8 | var2);
            var10.method5731(var11, var8);
        }

        return var11;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(IIII)V",
            garbageValue = "114823708"
    )
    void method4146(int var1, int var2, int var3) {
        int var5 = this.field233;
        int var6 = this.field234;
        int var7 = this.pixelsPerTile;
        class299 var8 = field235;
        long var9 = (long) (var7 << 16 | var5 << 8 | var6);
        SpritePixels var4 = (SpritePixels) var8.method5733(var9);
        if (var4 != null) {
            if (var3 == this.pixelsPerTile * 64) {
                var4.method2273(var1, var2);
            } else {
                var4.method2263(var1, var2, var3, var3);
            }

        }
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(Ljava/util/HashSet;IIB)V",
            garbageValue = "72"
    )
    void method4153(HashSet var1, int var2, int var3) {
        Iterator var4 = this.field241.values().iterator();

        while (var4.hasNext()) {
            MapIcon var5 = (MapIcon) var4.next();
            if (var1.contains(Integer.valueOf(var5.areaId))) {
                MapElementType var6 = Timer.method5389(var5.areaId);
                this.method4169(var6, var5.screenX, var5.screenY, var2, var3);
            }
        }

        this.method4168(var1, var2, var3);
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(Ljava/util/List;I)V",
            garbageValue = "439873852"
    )
    void method4150(List var1) {
        Iterator var2 = var1.iterator();

        while (var2.hasNext()) {
            class260 var3 = (class260) var2.next();
            if (var3.field109.worldX >> 6 == this.field233 && var3.field109.worldY >> 6 == this.field234) {
                MapIcon var4 = new MapIcon(var3.field108, var3.field109, var3.field109, this.method4179(var3.field108));
                this.field239.add(var4);
            }
        }

    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(IIIILh;I)V",
            garbageValue = "-865879683"
    )
    void method4149(int var1, int var2, int var3, int var4, class310 var5) {
        for (int var6 = var1; var6 < var3 + var1; ++var6) {
            label56:
            for (int var7 = var2; var7 < var2 + var4; ++var7) {
                Coordinates var8 = new Coordinates(0, var6, var7);

                for (int var9 = 0; var9 < var5.field148; ++var9) {
                    WorldMapDecoration[] var10 = var5.decorations[var9][var6][var7];
                    if (var10 != null && var10.length != 0) {
                        WorldMapDecoration[] var11 = var10;

                        for (int var12 = 0; var12 < var11.length; ++var12) {
                            WorldMapDecoration var13 = var11[var12];
                            MapElementType var14 = this.method4244(var13.objectDefinitionId);
                            if (var14 != null) {
                                Coordinates var15 = new Coordinates(var9, this.field233 * 64 + var6, this.field234 * 64 + var7);
                                Coordinates var16 = null;
                                if (this.field236 != null) {
                                    var16 = new Coordinates(this.field236.field150 + var9, var6 + this.field236.field146 * 64, var7 + this.field236.field151 * 64);
                                } else {
                                    class115 var17 = (class115) var5;
                                    var16 = new Coordinates(var9 + var17.field150, var17.field146 * 64 + var6 + var17.method1986() * 8, var7 + var17.field151 * 64 + var17.method1979() * 8);
                                }

                                MapIcon var18 = new MapIcon(var14.id, var16, var15, this.method4194(var14));
                                this.field241.put(var8, var18);
                                continue label56;
                            }
                        }
                    }
                }
            }
        }

    }

    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            signature = "(Lax;Lii;IIFB)V",
            garbageValue = "-83"
    )
    void method4180(MapIcon var1, MapElementType var2, int var3, int var4, float var5) {
        if (var1.field278 != null) {
            if (var1.field278.fontSize.method4692(var5)) {
                Font var6 = (Font) this.mapFonts.get(var1.field278.fontSize);
                var6.method1774(var1.field278.text, var3 - var1.field278.field214 / 2, var4, var1.field278.field214, var1.field278.field215, -16777216 | var2.field3327, 0, 1, 0, var6.verticalSpace / 2);
            }
        }
    }

    @ObfuscatedName("aj")
    @ObfuscatedSignature(
            signature = "(Lii;III)V",
            garbageValue = "2112207294"
    )
    void method4192(MapElementType var1, int var2, int var3) {
        SpritePixels var4 = var1.method2386(false);
        if (var4 != null) {
            int var5 = this.method4176(var4, var1.horizontalAlignment);
            int var6 = this.method4177(var4, var1.verticalAlignment);
            var4.method2253(var5 + var2, var3 + var6);
        }

    }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            signature = "(IILjava/util/HashSet;II)V",
            garbageValue = "1985874821"
    )
    void method4167(int var1, int var2, HashSet var3, int var4) {
        float var5 = (float) var4 / 64.0F;
        float var6 = var5 / 2.0F;
        Iterator var7 = this.field241.entrySet().iterator();

        while (var7.hasNext()) {
            Entry var8 = (Entry) var7.next();
            Coordinates var9 = (Coordinates) var8.getKey();
            int var10 = (int) ((float) var9.worldX * var5 + (float) var1 - var6);
            int var11 = (int) ((float) (var2 + var4) - var5 * (float) var9.worldY - var6);
            MapIcon var12 = (MapIcon) var8.getValue();
            if (var12 != null) {
                var12.screenX = var10;
                var12.screenY = var11;
                MapElementType var13 = Timer.method5389(var12.areaId);
                if (!var3.contains(Integer.valueOf(var13.method2368()))) {
                    this.method4281(var12, var10, var11, var5);
                }
            }
        }

    }

    @ObfuscatedName("o")
    @ObfuscatedSignature(
            signature = "(IIIIIILy;Laz;I)V",
            garbageValue = "-1853577400"
    )
    void method4163(int var1, int var2, int var3, int var4, int var5, int var6, WorldMapRegion var7, class284 var8) {
        for (int var9 = 0; var9 < var5; ++var9) {
            for (int var10 = 0; var10 < var6; ++var10) {
                int var11 = var7.method4184(var9 + var1, var10 + var2);
                if (var11 != -1) {
                    FloorUnderlayDefinition var12 = class315.method5966(var11);
                    var8.method5559(var3 + var9, var10 + var4, 5, var12);
                }
            }
        }

    }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(IILh;Lab;Lz;I)V",
            garbageValue = "-378654210"
    )
    void method4277(int var1, int var2, class310 var3, class324 var4, class147 var5) {
        int var6 = var3.field152[0][var1][var2] - 1;
        int var7 = var3.field153[0][var1][var2] - 1;
        if (var6 == -1 && var7 == -1) {
            Rasterizer2D.method449(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, this.field237);
        }

        int var8 = 16711935;
        int var9;
        if (var7 != -1) {
            int var10 = this.field237;
            Overlay var11 = class43.method616(var7);
            if (var11 == null) {
                var9 = var10;
            } else if (var11.otherRgbColor >= 0) {
                var9 = var11.otherRgbColor | -16777216;
            } else if (var11.texture >= 0) {
                int var12 = VertexNormal.method2548(Graphics3D.textureLoader.vmethod5363(var11.texture), 96);
                var9 = Graphics3D.colorPalette[var12] | -16777216;
            } else if (var11.color == 16711935) {
                var9 = var10;
            } else {
                int var13 = var11.hue;
                int var14 = var11.saturation;
                int var15 = var11.lightness;
                if (var15 > 179) {
                    var14 /= 2;
                }

                if (var15 > 192) {
                    var14 /= 2;
                }

                if (var15 > 217) {
                    var14 /= 2;
                }

                if (var15 > 243) {
                    var14 /= 2;
                }

                int var16 = (var14 / 32 << 7) + var15 / 2 + (var13 / 4 << 10);
                int var17 = VertexNormal.method2548(var16, 96);
                var9 = Graphics3D.colorPalette[var17] | -16777216;
            }

            var8 = var9;
        }

        if (var7 > -1 && var3.field154[0][var1][var2] == 0) {
            Rasterizer2D.method449(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var8);
        } else {
            var9 = this.method4164(var1, var2, var3, var5);
            if (var7 == -1) {
                Rasterizer2D.method449(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var9);
            } else {
                var4.method6408(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), var9, var8, this.pixelsPerTile, this.pixelsPerTile, var3.field154[0][var1][var2], var3.field155[0][var1][var2]);
            }
        }
    }

    @ObfuscatedName("ai")
    @ObfuscatedSignature(
            signature = "(II)Lii;",
            garbageValue = "1582513249"
    )
    MapElementType method4244(int var1) {
        LocType var2 = class225.method4485(var1);
        if (var2.multiLocs != null) {
            var2 = var2.method1717();
            if (var2 == null) {
                return null;
            }
        }

        return var2.mapIconId != -1 ? Timer.method5389(var2.mapIconId) : null;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(Lp;Ljava/util/List;B)V",
            garbageValue = "23"
    )
    void method4147(class113 var1, List var2) {
        this.field241.clear();
        this.field236 = var1;
        this.method4149(0, 0, 64, 64, this.field236);
        this.method4150(var2);
    }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            signature = "(IILh;Lab;I)V",
            garbageValue = "-227086239"
    )
    void method4154(int var1, int var2, class310 var3, class324 var4) {
        for (int var5 = 1; var5 < var3.field148; ++var5) {
            int var6 = var3.field153[var5][var1][var2] - 1;
            if (var6 > -1) {
                int var7 = CombatInfo1.method1157(var6, this.field237);
                if (var3.field154[var5][var1][var2] == 0) {
                    Rasterizer2D.method449(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var7);
                } else {
                    var4.method6408(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 0, var7, this.pixelsPerTile, this.pixelsPerTile, var3.field154[var5][var1][var2], var3.field155[var5][var1][var2]);
                }
            }
        }

    }

    @ObfuscatedName("ay")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "-1843727904"
    )
    int method4184(int var1, int var2) {
        if (this.field236 != null) {
            return this.field236.method5904(var1, var2);
        } else {
            if (!this.field230.isEmpty()) {
                Iterator var3 = this.field230.iterator();

                while (var3.hasNext()) {
                    class115 var4 = (class115) var3.next();
                    if (var4.method1977(var1, var2)) {
                        return var4.method5904(var1, var2);
                    }
                }
            }

            return -1;
        }
    }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            signature = "(IILh;[Lli;B)V",
            garbageValue = "-78"
    )
    void method4165(int var1, int var2, class310 var3, IndexedSprite[] var4) {
        for (int var5 = 0; var5 < var3.field148; ++var5) {
            WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
            if (var6 != null && var6.length != 0) {
                WorldMapDecoration[] var7 = var6;

                for (int var8 = 0; var8 < var7.length; ++var8) {
                    WorldMapDecoration var9 = var7[var8];
                    if (AbstractByteBuffer.method5420(var9.decoration) || class321.method6056(var9.decoration)) {
                        LocType var10 = class225.method4485(var9.objectDefinitionId);
                        if (var10.mapSceneId != -1) {
                            if (var10.mapSceneId != 46 && var10.mapSceneId != 52) {
                                var4[var10.mapSceneId].method819(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2, this.pixelsPerTile * 2);
                            } else {
                                var4[var10.mapSceneId].method819(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2 + 1, this.pixelsPerTile * 2 + 1);
                            }
                        }
                    }
                }
            }
        }

    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
            garbageValue = "2030058438"
    )
    void method4256(HashSet var1, List var2) {
        this.field241.clear();
        Iterator var3 = var1.iterator();

        while (var3.hasNext()) {
            class115 var4 = (class115) var3.next();
            if (var4.method5924() == this.field233 && var4.method5900() == this.field234) {
                this.field230.add(var4);
                this.method4149(var4.method1980() * 8, var4.method1981() * 8, 8, 8, var4);
            }
        }

        this.method4150(var2);
    }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            signature = "(IILh;I)V",
            garbageValue = "-238497050"
    )
    void method4157(int var1, int var2, class310 var3) {
        field240.method2469(0, var1, var2);

        for (int var4 = 0; var4 < var3.field148; ++var4) {
            WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
            if (var5 != null && var5.length != 0) {
                WorldMapDecoration[] var6 = var5;

                for (int var7 = 0; var7 < var6.length; ++var7) {
                    WorldMapDecoration var8 = var6[var7];
                    MapElementType var9 = this.method4244(var8.objectDefinitionId);
                    if (var9 != null) {
                        MapIcon var10 = (MapIcon) this.field241.get(field240);
                        if (var10 != null) {
                            if (var10.areaId != var9.id) {
                                MapIcon var16 = new MapIcon(var9.id, var10.field279, var10.field277, this.method4194(var9));
                                this.field241.put(new Coordinates(field240), var16);
                                var10 = var16;
                            }

                            int var15 = var10.field279.plane - var10.field277.plane;
                            var10.field277.plane = var4;
                            var10.field279.plane = var15 + var4;
                            return;
                        }

                        Coordinates var11 = new Coordinates(var4, this.field233 * 64 + var1, this.field234 * 64 + var2);
                        Coordinates var12 = null;
                        if (this.field236 != null) {
                            var12 = new Coordinates(this.field236.field150 + var4, this.field236.field146 * 64 + var1, var2 + this.field236.field151 * 64);
                        } else {
                            Iterator var13 = this.field230.iterator();

                            while (var13.hasNext()) {
                                class115 var14 = (class115) var13.next();
                                if (var14.method1977(var1, var2)) {
                                    var12 = new Coordinates(var4 + var14.field150, var14.field146 * 64 + var1 + var14.method1986() * 8, var14.field151 * 64 + var2 + var14.method1979() * 8);
                                    break;
                                }
                            }
                        }

                        if (var12 != null) {
                            var10 = new MapIcon(var9.id, var12, var11, this.method4194(var9));
                            this.field241.put(new Coordinates(field240), var10);
                            return;
                        }
                    }
                }
            }
        }

        this.field241.remove(field240);
    }

    @ObfuscatedName("y")
    @ObfuscatedSignature(
            signature = "([Ly;Laz;B)V",
            garbageValue = "-111"
    )
    void method4161(WorldMapRegion[] var1, class284 var2) {
        class233[] var3 = new class233[]{class233.field3166, class233.field3172, class233.field3162, class233.field3168, class233.field3169, class233.field3164, class233.field3163, class233.field3167};
        class233[] var5 = var3;

        for (int var6 = 0; var6 < var5.length; ++var6) {
            class233 var7 = var5[var6];
            if (var1[var7.vmethod5358()] != null) {
                byte var8 = 0;
                byte var9 = 0;
                byte var10 = 64;
                byte var11 = 64;
                byte var12 = 0;
                byte var13 = 0;
                switch (var7.field3170) {
                    case 0:
                        var13 = 59;
                        var11 = 5;
                        var8 = 59;
                        var10 = 5;
                        break;
                    case 1:
                        var8 = 59;
                        var10 = 5;
                        break;
                    case 2:
                        var12 = 59;
                        var10 = 5;
                        break;
                    case 3:
                        var12 = 59;
                        var13 = 59;
                        var10 = 5;
                        var11 = 5;
                        break;
                    case 4:
                        var13 = 59;
                        var11 = 5;
                        break;
                    case 5:
                        var9 = 59;
                        var11 = 5;
                        break;
                    case 6:
                        var9 = 59;
                        var11 = 5;
                        var8 = 59;
                        var10 = 5;
                        break;
                    case 7:
                        var9 = 59;
                        var11 = 5;
                        var12 = 59;
                        var10 = 5;
                }

                this.method4163(var12, var13, var8, var9, var10, var11, var1[var7.vmethod5358()], var2);
            }
        }

    }

    @ObfuscatedName("am")
    @ObfuscatedSignature(
            signature = "(IIIIB)V",
            garbageValue = "-75"
    )
    void method4239(int var1, int var2, int var3, int var4) {
        var3 %= 4;
        if (var3 == 0) {
            Rasterizer2D.method456(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
        }

        if (var3 == 1) {
            Rasterizer2D.method500(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
        }

        if (var3 == 2) {
            Rasterizer2D.method456(this.pixelsPerTile + this.pixelsPerTile * var1 - 1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
        }

        if (var3 == 3) {
            Rasterizer2D.method500(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, this.pixelsPerTile, var4);
        }

    }

    @ObfuscatedName("as")
    @ObfuscatedSignature(
            signature = "(Lls;Ljq;I)I",
            garbageValue = "-393719013"
    )
    int method4176(SpritePixels var1, class182 var2) {
        switch (var2.field3562) {
            case 0:
                return 0;
            case 1:
                return -var1.width / 2;
            default:
                return -var1.width;
        }
    }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            signature = "(IILh;I)V",
            garbageValue = "181333957"
    )
    void method4166(int var1, int var2, class310 var3) {
        for (int var4 = 0; var4 < var3.field148; ++var4) {
            WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
            if (var5 != null && var5.length != 0) {
                WorldMapDecoration[] var6 = var5;

                for (int var7 = 0; var7 < var6.length; ++var7) {
                    WorldMapDecoration var8 = var6[var7];
                    int var10 = var8.decoration;
                    boolean var9 = var10 >= WorldMapDecorationType.field2833.rsOrdinal && var10 <= WorldMapDecorationType.field2841.rsOrdinal || var10 == WorldMapDecorationType.field2818.rsOrdinal;
                    if (var9) {
                        LocType var11 = class225.method4485(var8.objectDefinitionId);
                        int var12 = var11.field3470 != 0 ? -3407872 : -3355444;
                        if (var8.decoration == WorldMapDecorationType.field2833.rsOrdinal) {
                            this.method4239(var1, var2, var8.rotation, var12);
                        }

                        if (var8.decoration == WorldMapDecorationType.field2830.rsOrdinal) {
                            this.method4239(var1, var2, var8.rotation, -3355444);
                            this.method4239(var1, var2, var8.rotation + 1, var12);
                        }

                        if (var8.decoration == WorldMapDecorationType.field2841.rsOrdinal) {
                            if (var8.rotation == 0) {
                                Rasterizer2D.method500(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 1, var12);
                            }

                            if (var8.rotation == 1) {
                                Rasterizer2D.method500(this.pixelsPerTile * var1 + this.pixelsPerTile - 1, this.pixelsPerTile * (63 - var2), 1, var12);
                            }

                            if (var8.rotation == 2) {
                                Rasterizer2D.method500(this.pixelsPerTile + this.pixelsPerTile * var1 - 1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var12);
                            }

                            if (var8.rotation == 3) {
                                Rasterizer2D.method500(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var12);
                            }
                        }

                        if (var8.decoration == WorldMapDecorationType.field2818.rsOrdinal) {
                            int var13 = var8.rotation % 2;
                            int var14;
                            if (var13 == 0) {
                                for (var14 = 0; var14 < this.pixelsPerTile; ++var14) {
                                    Rasterizer2D.method500(var14 + this.pixelsPerTile * var1, (64 - var2) * this.pixelsPerTile - 1 - var14, 1, var12);
                                }
                            } else {
                                for (var14 = 0; var14 < this.pixelsPerTile; ++var14) {
                                    Rasterizer2D.method500(var14 + this.pixelsPerTile * var1, var14 + this.pixelsPerTile * (63 - var2), 1, var12);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(ILab;[Ly;[Lli;I)V",
            garbageValue = "-2006576570"
    )
    void method4151(int var1, class324 var2, WorldMapRegion[] var3, IndexedSprite[] var4) {
        this.pixelsPerTile = var1;
        if (this.field236 != null || !this.field230.isEmpty()) {
            int var6 = this.field233;
            int var7 = this.field234;
            class299 var8 = field235;
            long var9 = (long) (var1 << 16 | var6 << 8 | var7);
            SpritePixels var5 = (SpritePixels) var8.method5733(var9);
            if (var5 == null) {
                class147 var12 = this.method4159(this.field233, this.field234, var3);
                SpritePixels var11 = new SpritePixels(this.pixelsPerTile * 64, this.pixelsPerTile * 64);
                var11.method2244();
                if (this.field236 != null) {
                    this.method4205(var2, var3, var4, var12);
                } else {
                    this.method4170(var2, var4, var12);
                }

                class113.method1969(var11, this.field233, this.field234, this.pixelsPerTile);
            }
        }
    }

    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-26"
    )
    void method4246() {
        if (this.field236 != null) {
            for (int var1 = 0; var1 < 64; ++var1) {
                for (int var2 = 0; var2 < 64; ++var2) {
                    this.method4157(var1, var2, this.field236);
                }
            }
        } else {
            Iterator var5 = this.field230.iterator();

            while (var5.hasNext()) {
                class115 var6 = (class115) var5.next();

                for (int var3 = var6.method1980() * 8; var3 < var6.method1980() * 8 + 8; ++var3) {
                    for (int var4 = var6.method1981() * 8; var4 < var6.method1981() * 8 + 8; ++var4) {
                        this.method4157(var3, var4, var6);
                    }
                }
            }
        }

    }

    @ObfuscatedName("ad")
    @ObfuscatedSignature(
            signature = "(II)Ls;",
            garbageValue = "-1617354438"
    )
    MapLabel method4179(int var1) {
        MapElementType var2 = Timer.method5389(var1);
        return this.method4194(var2);
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(IIILjava/util/HashSet;I)V",
            garbageValue = "431492400"
    )
    void method4226(int var1, int var2, int var3, HashSet var4) {
        if (var4 == null) {
            var4 = new HashSet();
        }

        this.method4167(var1, var2, var4, var3);
        this.method4173(var1, var2, var4, var3);
    }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            signature = "(Lls;Lix;B)I",
            garbageValue = "-1"
    )
    int method4177(SpritePixels var1, class101 var2) {
        switch (var2.field3292) {
            case 1:
                return -var1.height / 2;
            case 2:
                return 0;
            default:
                return -var1.height;
        }
    }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "([Ly;I)Lz;",
            garbageValue = "2088723965"
    )
    class147 method4279(WorldMapRegion[] var1) {
        class284 var2 = new class284(64, 64);
        if (this.field236 != null) {
            this.method4162(0, 0, 64, 64, this.field236, var2);
        } else {
            Iterator var3 = this.field230.iterator();

            while (var3.hasNext()) {
                class115 var4 = (class115) var3.next();
                this.method4162(var4.method1980() * 8, var4.method1981() * 8, 8, 8, var4, var2);
            }
        }

        this.method4161(var1, var2);
        class147 var5 = new class147();
        var5.method2536(var2);
        return var5;
    }

    @ObfuscatedName("az")
    @ObfuscatedSignature(
            signature = "(Lax;IIFS)V",
            garbageValue = "-10117"
    )
    void method4281(MapIcon var1, int var2, int var3, float var4) {
        MapElementType var5 = Timer.method5389(var1.areaId);
        this.method4192(var5, var2, var3);
        this.method4180(var1, var5, var2, var3, var4);
    }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            signature = "(Lii;IIIII)V",
            garbageValue = "-1301589807"
    )
    void method4169(MapElementType var1, int var2, int var3, int var4, int var5) {
        SpritePixels var6 = var1.method2386(false);
        if (var6 != null) {
            var6.method2253(var2 - var6.width / 2, var3 - var6.height / 2);
            if (var4 % var5 < var5 / 2) {
                Rasterizer2D.method497(var2, var3, 15, 16776960, 128);
                Rasterizer2D.method497(var2, var3, 7, 16777215, 256);
            }

        }
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(Lab;[Lli;Lz;I)V",
            garbageValue = "-1552107898"
    )
    void method4170(class324 var1, IndexedSprite[] var2, class147 var3) {
        Iterator var4 = this.field230.iterator();

        class115 var5;
        int var6;
        int var7;
        while (var4.hasNext()) {
            var5 = (class115) var4.next();

            for (var6 = var5.method1980() * 8; var6 < var5.method1980() * 8 + 8; ++var6) {
                for (var7 = var5.method1981() * 8; var7 < var5.method1981() * 8 + 8; ++var7) {
                    this.method4277(var6, var7, var5, var1, var3);
                    this.method4154(var6, var7, var5, var1);
                }
            }
        }

        var4 = this.field230.iterator();

        while (var4.hasNext()) {
            var5 = (class115) var4.next();

            for (var6 = var5.method1980() * 8; var6 < var5.method1980() * 8 + 8; ++var6) {
                for (var7 = var5.method1981() * 8; var7 < var5.method1981() * 8 + 8; ++var7) {
                    this.method4156(var6, var7, var5, var1, var2);
                }
            }
        }

    }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            signature = "(IIIILh;Laz;I)V",
            garbageValue = "1934378079"
    )
    void method4162(int var1, int var2, int var3, int var4, class310 var5, class284 var6) {
        for (int var7 = var1; var7 < var3 + var1; ++var7) {
            for (int var8 = var2; var8 < var2 + var4; ++var8) {
                int var9 = var5.field152[0][var7][var8] - 1;
                if (var9 != -1) {
                    FloorUnderlayDefinition var10 = class315.method5966(var9);
                    var6.method5559(var7, var8, 5, var10);
                }
            }
        }

    }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            signature = "(IILjava/util/HashSet;IB)V",
            garbageValue = "122"
    )
    void method4173(int var1, int var2, HashSet var3, int var4) {
        float var5 = (float) var4 / 64.0F;
        Iterator var6 = this.field239.iterator();

        while (var6.hasNext()) {
            MapIcon var7 = (MapIcon) var6.next();
            int var8 = var7.field277.worldX % 64;
            int var9 = var7.field277.worldY % 64;
            var7.screenX = (int) (var5 * (float) var8 + (float) var1);
            var7.screenY = (int) (var5 * (float) (63 - var9) + (float) var2);
            if (!var3.contains(Integer.valueOf(var7.areaId))) {
                this.method4281(var7, var7.screenX, var7.screenY, var5);
            }
        }

    }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            signature = "(I)Ljava/util/List;",
            garbageValue = "-1441129299"
    )
    List method4216() {
        LinkedList var1 = new LinkedList();
        var1.addAll(this.field239);
        var1.addAll(this.field241.values());
        return var1;
    }

    @ObfuscatedName("jh")
    @ObfuscatedSignature(
            signature = "([Lhn;II)V",
            garbageValue = "1644708717"
    )
    static final void method4145(ComponentType[] var0, int var1) {
        for (int var2 = 0; var2 < var0.length; ++var2) {
            ComponentType var3 = var0[var2];
            if (var3 != null) {
                if (var3.type == 0) {
                    if (var3.children != null) {
                        method4145(var3.children, var1);
                    }

                    SubInterface var4 = (SubInterface) client.subInterfaces.method380((long) var3.id);
                    if (var4 != null) {
                        class124.method2087(var4.id, var1);
                    }
                }

                ScriptEvent var5;
                if (var1 == 0 && var3.onDialogAbortListener != null) {
                    var5 = new ScriptEvent();
                    var5.source = var3;
                    var5.params = var3.onDialogAbortListener;
                    class73.method1124(var5);
                }

                if (var1 == 1 && var3.onSubChangeListener != null) {
                    if (var3.index >= 0) {
                        ComponentType var6 = WorldMapType1.method2440(var3.id);
                        if (var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                            continue;
                        }
                    }

                    var5 = new ScriptEvent();
                    var5.source = var3;
                    var5.params = var3.onSubChangeListener;
                    class73.method1124(var5);
                }
            }
        }

    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "1"
    )
    public static void method4152() {
        class267.field2461.method4974();
        class120.field2529 = 1;
        UrlRequester.field1911 = null;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(IIIIIILde;Lfn;B)V",
            garbageValue = "17"
    )
    static final void method4191(int var0, int var1, int var2, int var3, int var4, int var5, SceneManager var6, CollisionData var7) {
        if (!client.lowMemory || (class98.tileSettings[0][var1][var2] & 2) != 0 || (class98.tileSettings[var0][var1][var2] & 16) == 0) {
            if (var0 < class98.field493) {
                class98.field493 = var0;
            }

            LocType var8 = class225.method4485(var3);
            int var9;
            int var10;
            if (var4 != 1 && var4 != 3) {
                var9 = var8.width;
                var10 = var8.length;
            } else {
                var9 = var8.length;
                var10 = var8.width;
            }

            int var11;
            int var12;
            if (var9 + var1 <= 104) {
                var11 = (var9 >> 1) + var1;
                var12 = (var9 + 1 >> 1) + var1;
            } else {
                var11 = var1;
                var12 = var1 + 1;
            }

            int var13;
            int var14;
            if (var10 + var2 <= 104) {
                var13 = (var10 >> 1) + var2;
                var14 = var2 + (var10 + 1 >> 1);
            } else {
                var13 = var2;
                var14 = var2 + 1;
            }

            int[][] var15 = class98.tileHeights[var0];
            int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
            int var17 = (var1 << 7) + (var9 << 6);
            int var18 = (var2 << 7) + (var10 << 6);
            long var19 = WorldComparator.method6484(var1, var2, 2, var8.field3470 == 0, var3);
            int var21 = var5 + (var4 << 6);
            if (var8.supportItems == 1) {
                var21 += 256;
            }

            int var23;
            int var24;
            if (var8.method1720()) {
                class4 var22 = new class4();
                var22.field1048 = var0;
                var22.field1049 = var1 * 128;
                var22.field1059 = var2 * 128;
                var23 = var8.width;
                var24 = var8.length;
                if (var4 == 1 || var4 == 3) {
                    var23 = var8.length;
                    var24 = var8.width;
                }

                var22.field1062 = (var23 + var1) * 128;
                var22.field1052 = (var24 + var2) * 128;
                var22.field1054 = var8.ambientSoundId;
                var22.field1053 = var8.int4 * 128;
                var22.field1056 = var8.int5;
                var22.field1057 = var8.int6;
                var22.field1058 = var8.field3499;
                if (var8.multiLocs != null) {
                    var22.field1061 = var8;
                    var22.method33();
                }

                class4.field1051.method4351(var22);
                if (var22.field1058 != null) {
                    var22.field1055 = var22.field1056 + (int) (Math.random() * (double) (var22.field1057 - var22.field1056));
                }
            }

            Object var34;
            if (var5 == 22) {
                if (!client.lowMemory || var8.field3470 != 0 || var8.clipType == 1 || var8.obstructsGround) {
                    if (var8.animationId == -1 && var8.multiLocs == null) {
                        var34 = var8.method1726(22, var4, var15, var17, var16, var18);
                    } else {
                        var34 = new Location(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Entity) null);
                    }

                    var6.method3801(var0, var1, var2, var16, (Entity) var34, var19, var21);
                    if (var8.clipType == 1 && var7 != null) {
                        var7.method198(var1, var2);
                    }

                }
            } else if (var5 != 10 && var5 != 11) {
                if (var5 >= 12) {
                    if (var8.animationId == -1 && var8.multiLocs == null) {
                        var34 = var8.method1726(var5, var4, var15, var17, var16, var18);
                    } else {
                        var34 = new Location(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity) null);
                    }

                    var6.method3805(var0, var1, var2, var16, 1, 1, (Entity) var34, 0, var19, var21);
                    if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                        class306.field553[var0][var1][var2] |= 2340;
                    }

                    if (var8.clipType != 0 && var7 != null) {
                        var7.method223(var1, var2, var9, var10, var8.blocksProjectile);
                    }

                } else if (var5 == 0) {
                    if (var8.animationId == -1 && var8.multiLocs == null) {
                        var34 = var8.method1726(0, var4, var15, var17, var16, var18);
                    } else {
                        var34 = new Location(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Entity) null);
                    }

                    var6.method3803(var0, var1, var2, var16, (Entity) var34, (Entity) null, class98.field491[var4], 0, var19, var21);
                    if (var4 == 0) {
                        if (var8.clipped) {
                            class98.field503[var0][var1][var2] = 50;
                            class98.field503[var0][var1][var2 + 1] = 50;
                        }

                        if (var8.modelClipped) {
                            class306.field553[var0][var1][var2] |= 585;
                        }
                    } else if (var4 == 1) {
                        if (var8.clipped) {
                            class98.field503[var0][var1][var2 + 1] = 50;
                            class98.field503[var0][var1 + 1][var2 + 1] = 50;
                        }

                        if (var8.modelClipped) {
                            class306.field553[var0][var1][var2 + 1] |= 1170;
                        }
                    } else if (var4 == 2) {
                        if (var8.clipped) {
                            class98.field503[var0][var1 + 1][var2] = 50;
                            class98.field503[var0][var1 + 1][var2 + 1] = 50;
                        }

                        if (var8.modelClipped) {
                            class306.field553[var0][var1 + 1][var2] |= 585;
                        }
                    } else if (var4 == 3) {
                        if (var8.clipped) {
                            class98.field503[var0][var1][var2] = 50;
                            class98.field503[var0][var1 + 1][var2] = 50;
                        }

                        if (var8.modelClipped) {
                            class306.field553[var0][var1][var2] |= 1170;
                        }
                    }

                    if (var8.clipType != 0 && var7 != null) {
                        var7.method197(var1, var2, var5, var4, var8.blocksProjectile);
                    }

                    if (var8.decorDisplacement != 16) {
                        var6.method3811(var0, var1, var2, var8.decorDisplacement);
                    }

                } else if (var5 == 1) {
                    if (var8.animationId == -1 && var8.multiLocs == null) {
                        var34 = var8.method1726(1, var4, var15, var17, var16, var18);
                    } else {
                        var34 = new Location(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Entity) null);
                    }

                    var6.method3803(var0, var1, var2, var16, (Entity) var34, (Entity) null, class98.field499[var4], 0, var19, var21);
                    if (var8.clipped) {
                        if (var4 == 0) {
                            class98.field503[var0][var1][var2 + 1] = 50;
                        } else if (var4 == 1) {
                            class98.field503[var0][var1 + 1][var2 + 1] = 50;
                        } else if (var4 == 2) {
                            class98.field503[var0][var1 + 1][var2] = 50;
                        } else if (var4 == 3) {
                            class98.field503[var0][var1][var2] = 50;
                        }
                    }

                    if (var8.clipType != 0 && var7 != null) {
                        var7.method197(var1, var2, var5, var4, var8.blocksProjectile);
                    }

                } else {
                    int var28;
                    if (var5 == 2) {
                        var28 = var4 + 1 & 3;
                        Object var29;
                        Object var30;
                        if (var8.animationId == -1 && var8.multiLocs == null) {
                            var29 = var8.method1726(2, var4 + 4, var15, var17, var16, var18);
                            var30 = var8.method1726(2, var28, var15, var17, var16, var18);
                        } else {
                            var29 = new Location(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity) null);
                            var30 = new Location(var3, 2, var28, var0, var1, var2, var8.animationId, true, (Entity) null);
                        }

                        var6.method3803(var0, var1, var2, var16, (Entity) var29, (Entity) var30, class98.field491[var4], class98.field491[var28], var19, var21);
                        if (var8.modelClipped) {
                            if (var4 == 0) {
                                class306.field553[var0][var1][var2] |= 585;
                                class306.field553[var0][var1][1 + var2] |= 1170;
                            } else if (var4 == 1) {
                                class306.field553[var0][var1][var2 + 1] |= 1170;
                                class306.field553[var0][var1 + 1][var2] |= 585;
                            } else if (var4 == 2) {
                                class306.field553[var0][var1 + 1][var2] |= 585;
                                class306.field553[var0][var1][var2] |= 1170;
                            } else if (var4 == 3) {
                                class306.field553[var0][var1][var2] |= 1170;
                                class306.field553[var0][var1][var2] |= 585;
                            }
                        }

                        if (var8.clipType != 0 && var7 != null) {
                            var7.method197(var1, var2, var5, var4, var8.blocksProjectile);
                        }

                        if (var8.decorDisplacement != 16) {
                            var6.method3811(var0, var1, var2, var8.decorDisplacement);
                        }

                    } else if (var5 == 3) {
                        if (var8.animationId == -1 && var8.multiLocs == null) {
                            var34 = var8.method1726(3, var4, var15, var17, var16, var18);
                        } else {
                            var34 = new Location(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Entity) null);
                        }

                        var6.method3803(var0, var1, var2, var16, (Entity) var34, (Entity) null, class98.field499[var4], 0, var19, var21);
                        if (var8.clipped) {
                            if (var4 == 0) {
                                class98.field503[var0][var1][var2 + 1] = 50;
                            } else if (var4 == 1) {
                                class98.field503[var0][var1 + 1][var2 + 1] = 50;
                            } else if (var4 == 2) {
                                class98.field503[var0][var1 + 1][var2] = 50;
                            } else if (var4 == 3) {
                                class98.field503[var0][var1][var2] = 50;
                            }
                        }

                        if (var8.clipType != 0 && var7 != null) {
                            var7.method197(var1, var2, var5, var4, var8.blocksProjectile);
                        }

                    } else if (var5 == 9) {
                        if (var8.animationId == -1 && var8.multiLocs == null) {
                            var34 = var8.method1726(var5, var4, var15, var17, var16, var18);
                        } else {
                            var34 = new Location(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity) null);
                        }

                        var6.method3805(var0, var1, var2, var16, 1, 1, (Entity) var34, 0, var19, var21);
                        if (var8.clipType != 0 && var7 != null) {
                            var7.method223(var1, var2, var9, var10, var8.blocksProjectile);
                        }

                        if (var8.decorDisplacement != 16) {
                            var6.method3811(var0, var1, var2, var8.decorDisplacement);
                        }

                    } else if (var5 == 4) {
                        if (var8.animationId == -1 && var8.multiLocs == null) {
                            var34 = var8.method1726(4, var4, var15, var17, var16, var18);
                        } else {
                            var34 = new Location(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity) null);
                        }

                        var6.method3804(var0, var1, var2, var16, (Entity) var34, (Entity) null, class98.field491[var4], 0, 0, 0, var19, var21);
                    } else {
                        long var31;
                        Object var33;
                        if (var5 == 5) {
                            var28 = 16;
                            var31 = var6.method3821(var0, var1, var2);
                            if (var31 != 0L) {
                                var28 = class225.method4485(SubInterface.method2437(var31)).decorDisplacement;
                            }

                            if (var8.animationId == -1 && var8.multiLocs == null) {
                                var33 = var8.method1726(4, var4, var15, var17, var16, var18);
                            } else {
                                var33 = new Location(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity) null);
                            }

                            var6.method3804(var0, var1, var2, var16, (Entity) var33, (Entity) null, class98.field491[var4], 0, var28 * class98.field497[var4], var28 * class98.field501[var4], var19, var21);
                        } else if (var5 == 6) {
                            var28 = 8;
                            var31 = var6.method3821(var0, var1, var2);
                            if (var31 != 0L) {
                                var28 = class225.method4485(SubInterface.method2437(var31)).decorDisplacement / 2;
                            }

                            if (var8.animationId == -1 && var8.multiLocs == null) {
                                var33 = var8.method1726(4, var4 + 4, var15, var17, var16, var18);
                            } else {
                                var33 = new Location(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity) null);
                            }

                            var6.method3804(var0, var1, var2, var16, (Entity) var33, (Entity) null, 256, var4, var28 * class98.field502[var4], var28 * class98.field507[var4], var19, var21);
                        } else if (var5 == 7) {
                            var23 = var4 + 2 & 3;
                            if (var8.animationId == -1 && var8.multiLocs == null) {
                                var34 = var8.method1726(4, var23 + 4, var15, var17, var16, var18);
                            } else {
                                var34 = new Location(var3, 4, var23 + 4, var0, var1, var2, var8.animationId, true, (Entity) null);
                            }

                            var6.method3804(var0, var1, var2, var16, (Entity) var34, (Entity) null, 256, var23, 0, 0, var19, var21);
                        } else if (var5 == 8) {
                            var28 = 8;
                            var31 = var6.method3821(var0, var1, var2);
                            if (0L != var31) {
                                var28 = class225.method4485(SubInterface.method2437(var31)).decorDisplacement / 2;
                            }

                            int var27 = var4 + 2 & 3;
                            Object var26;
                            if (var8.animationId == -1 && var8.multiLocs == null) {
                                var33 = var8.method1726(4, var4 + 4, var15, var17, var16, var18);
                                var26 = var8.method1726(4, var27 + 4, var15, var17, var16, var18);
                            } else {
                                var33 = new Location(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity) null);
                                var26 = new Location(var3, 4, var27 + 4, var0, var1, var2, var8.animationId, true, (Entity) null);
                            }

                            var6.method3804(var0, var1, var2, var16, (Entity) var33, (Entity) var26, 256, var4, var28 * class98.field502[var4], var28 * class98.field507[var4], var19, var21);
                        }
                    }
                }
            } else {
                if (var8.animationId == -1 && var8.multiLocs == null) {
                    var34 = var8.method1726(10, var4, var15, var17, var16, var18);
                } else {
                    var34 = new Location(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Entity) null);
                }

                if (var34 != null && var6.method3805(var0, var1, var2, var16, var9, var10, (Entity) var34, var5 == 11 ? 256 : 0, var19, var21) && var8.clipped) {
                    var23 = 15;
                    if (var34 instanceof Model) {
                        var23 = ((Model) var34).method5459() / 4;
                        if (var23 > 30) {
                            var23 = 30;
                        }
                    }

                    for (var24 = 0; var24 <= var9; ++var24) {
                        for (int var25 = 0; var25 <= var10; ++var25) {
                            if (var23 > class98.field503[var0][var24 + var1][var25 + var2]) {
                                class98.field503[var0][var24 + var1][var25 + var2] = (byte) var23;
                            }
                        }
                    }
                }

                if (var8.clipType != 0 && var7 != null) {
                    var7.method223(var1, var2, var9, var10, var8.blocksProjectile);
                }

            }
        }
    }
}
