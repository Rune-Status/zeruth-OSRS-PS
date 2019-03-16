package net.runelite.runescape;

import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSRenderOverview;
import net.runelite.rs.api.RSWorldMapData;
import net.runelite.rs.api.RSWorldMapManager;

import java.util.*;

@ObfuscatedName("lg")
@Implements("WorldMap")
public class WorldMap implements RSRenderOverview {
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            signature = "Lkm;"
    )
    static final FontName fontNameVerdana11;
    @ObfuscatedName("n")
    @ObfuscatedSignature(
            signature = "Lkm;"
    )
    static final FontName fontNameVerdana13;
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "Lkm;"
    )
    static final FontName fontNameVerdana15;
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "Lae;"
    )
    WorldMapManager worldMapManager;
    @ObfuscatedName("bb")
    @ObfuscatedGetter(
            intValue = 1614374843
    )
    int field3999;
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "Lk;"
    )
    WorldMapData worldMapData;
    @ObfuscatedName("af")
    @ObfuscatedGetter(
            intValue = 500830005
    )
    int worldMapDisplayHeight;
    @ObfuscatedName("bs")
    final int[] field3989;
    @ObfuscatedName("al")
    boolean field3988;
    @ObfuscatedName("ae")
    @ObfuscatedGetter(
            intValue = 1887019003
    )
    int field3983;
    @ObfuscatedName("k")
    @ObfuscatedGetter(
            intValue = -2072572821
    )
    int worldMapY;
    @ObfuscatedName("bz")
    List field3990;
    @ObfuscatedName("au")
    @ObfuscatedGetter(
            intValue = -1532116283
    )
    int field3995;
    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "Lk;"
    )
    WorldMapData field3951;
    @ObfuscatedName("m")
    HashMap mapFonts;
    @ObfuscatedName("ba")
    Iterator field3991;
    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "Lkz;"
    )
    Font field3984;
    @ObfuscatedName("ag")
    @ObfuscatedGetter(
            intValue = 1311718319
    )
    int field3972;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    Js5Index field3944;
    @ObfuscatedName("aj")
    @ObfuscatedGetter(
            intValue = -1868493785
    )
    int field3971;
    @ObfuscatedName("aw")
    @ObfuscatedGetter(
            intValue = 2013760117
    )
    int field3967;
    @ObfuscatedName("o")
    @ObfuscatedGetter(
            intValue = 1091688259
    )
    int worldMapDisplayWidth;
    @ObfuscatedName("bp")
    @ObfuscatedSignature(
            signature = "Lhz;"
    )
    Coordinates field3993;
    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "Llz;"
    )
    class296 field3985;
    @ObfuscatedName("ai")
    @ObfuscatedGetter(
            intValue = -1924655655
    )
    int field3970;
    @ObfuscatedName("z")
    @ObfuscatedGetter(
            intValue = 1705208463
    )
    int worldMapTargetX;
    @ObfuscatedName("av")
    boolean field3987;
    @ObfuscatedName("bq")
    @ObfuscatedSignature(
            signature = "Lls;"
    )
    SpritePixels field3957;
    @ObfuscatedName("bk")
    @ObfuscatedGetter(
            intValue = 324290877
    )
    int field3956;
    @ObfuscatedName("t")
    @ObfuscatedGetter(
            intValue = 1664977133
    )
    int worldMapX;
    @ObfuscatedName("ay")
    HashSet field3996;
    @ObfuscatedName("ah")
    HashSet field3958;
    @ObfuscatedName("an")
    @ObfuscatedGetter(
            intValue = 604208031
    )
    int worldMapDisplayX;
    @ObfuscatedName("bv")
    public boolean field3994;
    @ObfuscatedName("at")
    @ObfuscatedGetter(
            intValue = 1176673173
    )
    int field3975;
    @ObfuscatedName("y")
    float worldMapZoom;
    @ObfuscatedName("am")
    HashSet field3973;
    @ObfuscatedName("bf")
    @ObfuscatedGetter(
            intValue = 1824768933
    )
    int field3997;
    @ObfuscatedName("as")
    @ObfuscatedGetter(
            intValue = 1914552971
    )
    int field3959;
    @ObfuscatedName("ax")
    @ObfuscatedGetter(
            intValue = -1171311183
    )
    int worldMapDisplayY;
    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "[Lli;"
    )
    IndexedSprite[] field3950;
    @ObfuscatedName("ar")
    @ObfuscatedGetter(
            intValue = 917722155
    )
    int field3974;
    @ObfuscatedName("ad")
    @ObfuscatedGetter(
            intValue = -1970075605
    )
    int field3979;
    @ObfuscatedName("j")
    HashMap worldMapDataByIdentifier;
    @ObfuscatedName("aa")
    @ObfuscatedGetter(
            longValue = -1481722795161453545L
    )
    long field3977;
    @ObfuscatedName("s")
    @ObfuscatedGetter(
            intValue = 1650915895
    )
    int worldMapTargetY;
    @ObfuscatedName("az")
    HashSet field3940;
    @ObfuscatedName("bw")
    @ObfuscatedGetter(
            intValue = 623806023
    )
    int field3961;
    @ObfuscatedName("ap")
    HashSet field3965;
    @ObfuscatedName("ac")
    boolean field3969;
    @ObfuscatedName("bi")
    HashSet field3992;
    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "Lk;"
    )
    WorldMapData field3954;
    @ObfuscatedName("u")
    float worldMapZoomTarget;
    @ObfuscatedName("ab")
    @ObfuscatedGetter(
            intValue = -1495816037
    )
    int field3986;

    static {
        fontNameVerdana11 = FontName.field3741;
        fontNameVerdana13 = FontName.field3742;
        fontNameVerdana15 = FontName.field3743;
    }

    public WorldMap() {
        this.worldMapTargetX = -1;
        this.worldMapTargetY = -1;
        this.worldMapDisplayWidth = -1;
        this.worldMapDisplayHeight = -1;
        this.worldMapDisplayX = -1;
        this.worldMapDisplayY = -1;
        this.field3967 = 3;
        this.field3983 = 50;
        this.field3969 = false;
        this.field3940 = null;
        this.field3971 = -1;
        this.field3972 = -1;
        this.field3986 = -1;
        this.field3974 = -1;
        this.field3975 = -1;
        this.field3959 = -1;
        this.field3988 = true;
        this.field3973 = new HashSet();
        this.field3996 = new HashSet();
        this.field3958 = new HashSet();
        this.field3965 = new HashSet();
        this.field3987 = false;
        this.field3995 = 0;
        this.field3989 = new int[]{1008, 1009, 1010, 1011, 1012};
        this.field3992 = new HashSet();
        this.field3993 = null;
        this.field3994 = false;
        this.field3997 = -1;
        this.field3956 = -1;
        this.field3999 = -1;
    }

    @ObfuscatedName("ak")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "1256483564"
    )
    public int method1230() {
        return this.worldMapDisplayWidth;
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-356648505"
    )
    public void method1205(int var1) {
        WorldMapData var2 = this.method1222(var1);
        if (var2 != null) {
            this.method1208(var2);
        }

    }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1317188494"
    )
    public void method1238(int var1) {
        this.field3940 = new HashSet();
        this.field3971 = 0;
        this.field3972 = 0;

        for (int var2 = 0; var2 < MapElementType.field3331; ++var2) {
            if (Timer.method5389(var2) != null && Timer.method5389(var2).category == var1) {
                this.field3940.add(Integer.valueOf(Timer.method5389(var2).id));
            }
        }

    }

    @ObfuscatedName("bb")
    @ObfuscatedSignature(
            signature = "(IILhz;Lhz;I)V",
            garbageValue = "1273108680"
    )
    public void method1249(int var1, int var2, Coordinates var3, Coordinates var4) {
        ScriptEvent var5 = new ScriptEvent();
        MapIconReference var6 = new MapIconReference(var2, var3, var4);
        var5.method4033(new Object[]{var6});
        switch (var1) {
            case 1008:
                var5.method4035(10);
                break;
            case 1009:
                var5.method4035(11);
                break;
            case 1010:
                var5.method4035(12);
                break;
            case 1011:
                var5.method4035(13);
                break;
            case 1012:
                var5.method4035(14);
        }

        class73.method1124(var5);
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(IIIB)Lk;",
            garbageValue = "0"
    )
    public WorldMapData method1203(int var1, int var2, int var3) {
        Iterator var4 = this.worldMapDataByIdentifier.values().iterator();

        WorldMapData var5;
        do {
            if (!var4.hasNext()) {
                return null;
            }

            var5 = (WorldMapData) var4.next();
        } while (!var5.method985(var1, var2, var3));

        return var5;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "92"
    )
    public int method1196() {
        return this.field3944.method1538(this.field3951.method1001(), MapCacheArchiveNames.field290.name) ? 100 : this.field3944.method1530(this.field3951.method1001());
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "2102363020"
    )
    public void method1227() {
        class170.method2868();
    }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            signature = "(IIIIIII)Z",
            garbageValue = "2067598860"
    )
    boolean method1213(int var1, int var2, int var3, int var4, int var5, int var6) {
        return this.field3957 == null ? true : (this.field3957.width == var1 && this.field3957.height == var2 ? (this.worldMapManager.field312 != this.field3961 ? true : (this.field3999 != client.field914 ? true : (var3 <= 0 && var4 <= 0 ? var3 + var1 < var5 || var2 + var4 < var6 : true))) : true);
    }

    @ObfuscatedName("bs")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1612049656"
    )
    public void method1239() {
        this.field3940 = null;
    }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            signature = "(I)Lhz;",
            garbageValue = "-1345452263"
    )
    public Coordinates method1229() {
        return this.worldMapData == null ? null : this.worldMapData.method1016(this.method1242(), this.method1228());
    }

    @ObfuscatedName("ae")
    @ObfuscatedSignature(
            signature = "(IIIIII)V",
            garbageValue = "-9546892"
    )
    void method1217(int var1, int var2, int var3, int var4, int var5) {
        byte var6 = 20;
        int var7 = var3 / 2 + var1;
        int var8 = var4 / 2 + var2 - 18 - var6;
        Rasterizer2D.method449(var1, var2, var3, var4, -16777216);
        Rasterizer2D.method518(var7 - 152, var8, 304, 34, -65536);
        Rasterizer2D.method449(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
        this.field3984.method1862("Loading...", var7, var8 + var6, -1, -1);
    }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            signature = "(Lk;I)V",
            garbageValue = "-1997243291"
    )
    void method1208(WorldMapData var1) {
        if (this.worldMapData == null || var1 != this.worldMapData) {
            this.method1260(var1);
            this.method1209(-1, -1, -1);
        }
    }

    @ObfuscatedName("bz")
    @ObfuscatedSignature(
            signature = "(ZB)V",
            garbageValue = "22"
    )
    public void method1367(boolean var1) {
        this.field3987 = !var1;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(IIZIIIII)V",
            garbageValue = "2005243957"
    )
    public void method1194(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
        if (this.field3985.method5688()) {
            this.method1290();
            this.method1278();
            if (var3) {
                int var8 = (int) Math.ceil((double) ((float) var6 / this.worldMapZoom));
                int var9 = (int) Math.ceil((double) ((float) var7 / this.worldMapZoom));
                List var10 = this.worldMapManager.method909(this.worldMapX - var8 / 2 - 1, this.worldMapY - var9 / 2 - 1, var8 / 2 + this.worldMapX + 1, var9 / 2 + this.worldMapY + 1, var4, var5, var6, var7, var1, var2);
                HashSet var11 = new HashSet();

                Iterator var12;
                MapIcon var13;
                ScriptEvent var14;
                MapIconReference var15;
                for (var12 = var10.iterator(); var12.hasNext(); class73.method1124(var14)) {
                    var13 = (MapIcon) var12.next();
                    var11.add(var13);
                    var14 = new ScriptEvent();
                    var15 = new MapIconReference(var13.areaId, var13.field279, var13.field277);
                    var14.method4033(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                    if (this.field3992.contains(var13)) {
                        var14.method4035(17);
                    } else {
                        var14.method4035(15);
                    }
                }

                var12 = this.field3992.iterator();

                while (var12.hasNext()) {
                    var13 = (MapIcon) var12.next();
                    if (!var11.contains(var13)) {
                        var14 = new ScriptEvent();
                        var15 = new MapIconReference(var13.areaId, var13.field279, var13.field277);
                        var14.method4033(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                        var14.method4035(16);
                        class73.method1124(var14);
                    }
                }

                this.field3992 = var11;
            }
        }
    }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "80"
    )
    public void method1250(int var1) {
        this.field3940 = new HashSet();
        this.field3940.add(Integer.valueOf(var1));
        this.field3971 = 0;
        this.field3972 = 0;
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1503482807"
    )
    boolean method1352() {
        return this.worldMapTargetX != -1 && this.worldMapTargetY != -1;
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "85"
    )
    void method1278() {
        if (this.method1352()) {
            int var1 = this.worldMapTargetX - this.worldMapX;
            int var2 = this.worldMapTargetY - this.worldMapY;
            if (var1 != 0) {
                var1 /= Math.min(8, Math.abs(var1));
            }

            if (var2 != 0) {
                var2 /= Math.min(8, Math.abs(var2));
            }

            this.method1200(var1 + this.worldMapX, var2 + this.worldMapY, true);
            if (this.worldMapTargetX == this.worldMapX && this.worldMapTargetY == this.worldMapY) {
                this.worldMapTargetX = -1;
                this.worldMapTargetY = -1;
            }

        }
    }

    @ObfuscatedName("ba")
    @ObfuscatedSignature(
            signature = "(IZB)V",
            garbageValue = "4"
    )
    public void method1198(int var1, boolean var2) {
        if (!var2) {
            this.field3973.add(Integer.valueOf(var1));
        } else {
            this.field3973.remove(Integer.valueOf(var1));
        }

        this.method1246();
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-59"
    )
    void method1290() {
        if (class82.field1933 != null) {
            this.worldMapZoom = this.worldMapZoomTarget;
        } else {
            if (this.worldMapZoom < this.worldMapZoomTarget) {
                this.worldMapZoom = Math.min(this.worldMapZoomTarget, this.worldMapZoom / 30.0F + this.worldMapZoom);
            }

            if (this.worldMapZoom > this.worldMapZoomTarget) {
                this.worldMapZoom = Math.max(this.worldMapZoomTarget, this.worldMapZoom - this.worldMapZoom / 30.0F);
            }

        }
    }

    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "2082620146"
    )
    public boolean method1201() {
        return this.field3985.method5688();
    }

    @ObfuscatedName("aj")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-2080525260"
    )
    public void method1220() {
        this.field3985.method5687();
    }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "2052488028"
    )
    public void method1199(int var1) {
        this.worldMapZoomTarget = this.method1218(var1);
    }

    @ObfuscatedName("o")
    @ObfuscatedSignature(
            signature = "(IIIIII)V",
            garbageValue = "1291841987"
    )
    public void method1212(int var1, int var2, int var3, int var4, int var5) {
        int[] var6 = new int[4];
        Rasterizer2D.method512(var6);
        Rasterizer2D.method469(var1, var2, var3 + var1, var2 + var4);
        Rasterizer2D.method449(var1, var2, var3, var4, -16777216);
        int var7 = this.field3985.method5697();
        if (var7 < 100) {
            this.method1217(var1, var2, var3, var4, var7);
        } else {
            if (!this.worldMapManager.method911()) {
                this.worldMapManager.method903(this.field3944, this.worldMapData.method1001(), client.isMembers);
                if (!this.worldMapManager.method911()) {
                    return;
                }
            }

            if (this.field3940 != null) {
                ++this.field3972;
                if (this.field3972 % this.field3983 == 0) {
                    this.field3972 = 0;
                    ++this.field3971;
                }

                if (this.field3971 >= this.field3967 && !this.field3969) {
                    this.field3940 = null;
                }
            }

            int var8 = (int) Math.ceil((double) ((float) var3 / this.worldMapZoom));
            int var9 = (int) Math.ceil((double) ((float) var4 / this.worldMapZoom));
            this.worldMapManager.method905(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4);
            if (!this.field3987) {
                boolean var10 = false;
                if (var5 - this.field3995 > 100) {
                    this.field3995 = var5;
                    var10 = true;
                }

                this.worldMapManager.method917(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var2, var3 + var1, var2 + var4, this.field3965, this.field3940, this.field3972, this.field3983, var10);
            }

            this.method1244(var1, var2, var3, var4, var8, var9);
            if (class60.method885() && this.field3994 && this.field3993 != null) {
                this.field3984.method1828("Coord: " + this.field3993, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
            }

            this.worldMapDisplayWidth = var8;
            this.worldMapDisplayHeight = var9;
            this.worldMapDisplayX = var1;
            this.worldMapDisplayY = var2;
            Rasterizer2D.method452(var6);
        }
    }

    @ObfuscatedName("bp")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1835460833"
    )
    public boolean method1243() {
        return !this.field3987;
    }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "1223065204"
    )
    public int method1211() {
        return this.worldMapData == null ? -1 : this.worldMapData.method990();
    }

    @ObfuscatedName("ai")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "-95"
    )
    public int method1242() {
        return this.worldMapData == null ? -1 : this.worldMapX + this.worldMapData.method1017() * 64;
    }

    @ObfuscatedName("av")
    @ObfuscatedSignature(
            signature = "(ZI)V",
            garbageValue = "-743906747"
    )
    public void method1289(boolean var1) {
        this.field3969 = var1;
    }

    @ObfuscatedName("bc")
    @ObfuscatedSignature(
            signature = "(I)Lax;",
            garbageValue = "2003183733"
    )
    public MapIcon method1251() {
        return this.field3991 == null ? null : (!this.field3991.hasNext() ? null : (MapIcon) this.field3991.next());
    }

    @ObfuscatedName("bq")
    @ObfuscatedSignature(
            signature = "(IB)Z",
            garbageValue = "-82"
    )
    public boolean method1247(int var1) {
        return !this.field3996.contains(Integer.valueOf(var1));
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IIZZB)V",
            garbageValue = "10"
    )
    public void method1354(int var1, int var2, boolean var3, boolean var4) {
        long var5 = Tile.method4297();
        this.method1197(var1, var2, var4, var5);
        if (!this.method1352() && (var4 || var3)) {
            if (var4) {
                this.field3975 = var1;
                this.field3959 = var2;
                this.field3986 = this.worldMapX;
                this.field3974 = this.worldMapY;
            }

            if (this.field3986 != -1) {
                int var7 = var1 - this.field3975;
                int var8 = var2 - this.field3959;
                this.method1200(this.field3986 - (int) ((float) var7 / this.worldMapZoomTarget), (int) ((float) var8 / this.worldMapZoomTarget) + this.field3974, false);
            }
        } else {
            this.method1206();
        }

        if (var4) {
            this.field3977 = var5;
            this.field3970 = var1;
            this.field3979 = var2;
        }

    }

    @ObfuscatedName("bk")
    @ObfuscatedSignature(
            signature = "(ILhz;I)Lhz;",
            garbageValue = "1298266560"
    )
    public Coordinates method1248(int var1, Coordinates var2) {
        if (!this.field3985.method5688()) {
            return null;
        } else if (!this.worldMapManager.method911()) {
            return null;
        } else if (!this.worldMapData.method986(var2.worldX, var2.worldY)) {
            return null;
        } else {
            HashMap var3 = this.worldMapManager.method912();
            List var4 = (List) var3.get(Integer.valueOf(var1));
            if (var4 != null && !var4.isEmpty()) {
                MapIcon var5 = null;
                int var6 = -1;
                Iterator var7 = var4.iterator();

                while (true) {
                    MapIcon var8;
                    int var11;
                    do {
                        if (!var7.hasNext()) {
                            return var5.field277;
                        }

                        var8 = (MapIcon) var7.next();
                        int var9 = var8.field277.worldX - var2.worldX;
                        int var10 = var8.field277.worldY - var2.worldY;
                        var11 = var10 * var10 + var9 * var9;
                        if (var11 == 0) {
                            return var8.field277;
                        }
                    } while (var11 >= var6 && var5 != null);

                    var5 = var8;
                    var6 = var11;
                }
            } else {
                return null;
            }
        }
    }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            signature = "(I)Lk;",
            garbageValue = "1494601904"
    )
    public WorldMapData method1207() {
        return this.worldMapData;
    }

    @ObfuscatedName("ay")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "100"
    )
    public void method1233() {
        this.field3967 = 3;
    }

    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1614324548"
    )
    public void method1234(int var1) {
        if (var1 >= 1) {
            this.field3983 = var1;
        }

    }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            signature = "(IIIIIII)V",
            garbageValue = "1873392112"
    )
    void method1244(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (class82.field1933 != null) {
            int var7 = 512 / (this.worldMapManager.field312 * 2);
            int var8 = var3 + 512;
            int var9 = var4 + 512;
            float var10 = 1.0F;
            var8 = (int) ((float) var8 / var10);
            var9 = (int) ((float) var9 / var10);
            int var11 = this.method1242() - var5 / 2 - var7;
            int var12 = this.method1228() - var6 / 2 - var7;
            int var13 = var1 - (var11 + var7 - this.field3997) * this.worldMapManager.field312;
            int var14 = var2 - this.worldMapManager.field312 * (var7 - (var12 - this.field3956));
            if (this.method1213(var8, var9, var13, var14, var3, var4)) {
                if (this.field3957 != null && this.field3957.width == var8 && this.field3957.height == var9) {
                    Arrays.fill(this.field3957.pixels, 0);
                } else {
                    this.field3957 = new SpritePixels(var8, var9);
                }

                this.field3997 = this.method1242() - var5 / 2 - var7;
                this.field3956 = this.method1228() - var6 / 2 - var7;
                this.field3961 = this.worldMapManager.field312;
                class82.field1933.method4476(this.field3997, this.field3956, this.field3957, (float) this.field3961 / var10);
                this.field3999 = client.field914;
                var13 = var1 - (var11 + var7 - this.field3997) * this.worldMapManager.field312;
                var14 = var2 - this.worldMapManager.field312 * (var7 - (var12 - this.field3956));
            }

            Rasterizer2D.method448(var1, var2, var3, var4, 0, 128);
            if (var10 == 1.0F) {
                this.field3957.method2275(var13, var14, 192);
            } else {
                this.field3957.method2334(var13, var14, (int) (var10 * (float) var8), (int) ((float) var9 * var10), 192);
            }
        }

    }

    public RSWorldMapManager getWorldMapManager() {
        return this.worldMapManager;
    }

    public int getWorldMapX() {
        return this.worldMapX;
    }

    public void setWorldMapPositionTarget(int var1, int var2) {
        this.method1361(var1, var2);
    }

    public int getWorldMapY() {
        return this.worldMapY;
    }

    public Point getWorldMapPosition() {
        RSWorldMapManager var1 = this.getWorldMapManager();
        int var2 = this.getWorldMapX() + var1.getSurfaceOffsetX();
        int var3 = this.getWorldMapY() + var1.getSurfaceOffsetY();
        return new Point(var2, var3);
    }

    public void setWorldMapPositionTarget(WorldPoint var1) {
        this.setWorldMapPositionTarget(var1.getX(), var1.getY());
    }

    public RSWorldMapData getWorldMapData() {
        return this.worldMapData;
    }

    public int getWorldMapTargetX() {
        return this.worldMapTargetX;
    }

    public int getWorldMapTargetY() {
        return this.worldMapTargetY;
    }

    public float getWorldMapZoom() {
        return this.worldMapZoom;
    }

    public int getWorldMapDisplayWidth() {
        return this.worldMapDisplayWidth;
    }

    public int getWorldMapDisplayHeight() {
        return this.worldMapDisplayHeight;
    }

    public int getWorldMapDisplayX() {
        return this.worldMapDisplayX;
    }

    public int getWorldMapDisplayY() {
        return this.worldMapDisplayY;
    }

    public void setWorldMapPosition(int var1, int var2, boolean var3) {
        this.method1200(var1, var2, var3);
    }

    public void initializeWorldMap(net.runelite.api.WorldMapData var1) {
        this.method1260((WorldMapData) var1);
    }

    @ObfuscatedName("i")
    void method1197(int var1, int var2, boolean var3, long var4) {
        if (this.worldMapData != null) {
            int var6 = (int) ((float) this.worldMapX + ((float) (var1 - this.worldMapDisplayX) - (float) this.method1230() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
            int var7 = (int) ((float) this.worldMapY - ((float) (var2 - this.worldMapDisplayY) - (float) this.method1231() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
            this.field3993 = this.worldMapData.method1016(var6 + this.worldMapData.method1017() * 64, var7 + this.worldMapData.method988() * 64);
            if (this.field3993 != null && var3) {
                if (class60.method885() && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81]) {
                    class158.method2697(this.field3993.worldX, this.field3993.worldY, this.field3993.plane, false);
                } else {
                    boolean var8 = true;
                    if (this.field3988) {
                        int var9 = var1 - this.field3970;
                        int var10 = var2 - this.field3979;
                        if (var4 - this.field3977 > 500L || var9 < -25 || var9 > 25 || var10 < -25 || var10 > 25) {
                            var8 = false;
                        }
                    }

                    if (var8) {
                        TcpConnectionMessage var11 = FaceNormal.method5726(ClientProt.WORLD_MAP_CLICK, client.serverConnection.isaac);
                        var11.packetBuffer.putIntV1(this.field3993.method2471());
                        client.serverConnection.method5881(var11);
                        this.field3977 = 0L;
                    }
                }
            }
        } else {
            this.field3993 = null;
        }

    }

    @ObfuscatedName("bv")
    @ObfuscatedSignature(
            signature = "(II)Z",
            garbageValue = "1501070545"
    )
    public boolean method1245(int var1) {
        return !this.field3973.contains(Integer.valueOf(var1));
    }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "1599454875"
    )
    public void method1312(int var1, int var2) {
        if (this.worldMapData != null) {
            this.method1200(var1 - this.worldMapData.method1017() * 64, var2 - this.worldMapData.method988() * 64, true);
            this.worldMapTargetX = -1;
            this.worldMapTargetY = -1;
        }
    }

    @ObfuscatedName("y")
    @ObfuscatedSignature(
            signature = "(Lk;Lhz;Lhz;ZB)V",
            garbageValue = "3"
    )
    public void method1210(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
        if (var1 != null) {
            if (this.worldMapData == null || var1 != this.worldMapData) {
                this.method1260(var1);
            }

            if (!var4 && this.worldMapData.method985(var2.plane, var2.worldX, var2.worldY)) {
                this.method1209(var2.plane, var2.worldX, var2.worldY);
            } else {
                this.method1209(var3.plane, var3.worldX, var3.worldY);
            }

        }
    }

    @ObfuscatedName("am")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "61"
    )
    public void method1232(int var1) {
        if (var1 >= 1) {
            this.field3967 = var1;
        }

    }

    @ObfuscatedName("bf")
    @ObfuscatedSignature(
            signature = "(IIIIIII)V",
            garbageValue = "-1438573796"
    )
    public void method1293(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (this.field3985.method5688()) {
            int var7 = (int) Math.ceil((double) ((float) var3 / this.worldMapZoom));
            int var8 = (int) Math.ceil((double) ((float) var4 / this.worldMapZoom));
            List var9 = this.worldMapManager.method909(this.worldMapX - var7 / 2 - 1, this.worldMapY - var8 / 2 - 1, var7 / 2 + this.worldMapX + 1, var8 / 2 + this.worldMapY + 1, var1, var2, var3, var4, var5, var6);
            if (!var9.isEmpty()) {
                Iterator var10 = var9.iterator();

                boolean var13;
                do {
                    if (!var10.hasNext()) {
                        return;
                    }

                    MapIcon var11 = (MapIcon) var10.next();
                    MapElementType var12 = Timer.method5389(var11.areaId);
                    var13 = false;

                    for (int var14 = this.field3989.length - 1; var14 >= 0; --var14) {
                        if (var12.field3320[var14] != null) {
                            class316.method5992(var12.field3320[var14], var12.field3321, this.field3989[var14], var11.areaId, var11.field279.method2471(), var11.field277.method2471());
                            var13 = true;
                        }
                    }
                } while (!var13);

            }
        }
    }

    @ObfuscatedName("as")
    @ObfuscatedSignature(
            signature = "(IIII)V",
            garbageValue = "2063693495"
    )
    public void method1225(int var1, int var2, int var3) {
        if (this.worldMapData != null) {
            int[] var4 = this.worldMapData.method987(var1, var2, var3);
            if (var4 != null) {
                this.method1361(var4[0], var4[1]);
            }

        }
    }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            signature = "(IIIIB)V",
            garbageValue = "114"
    )
    public void method1365(int var1, int var2, int var3, int var4) {
        if (this.field3985.method5688()) {
            if (!this.worldMapManager.method911()) {
                this.worldMapManager.method903(this.field3944, this.worldMapData.method1001(), client.isMembers);
                if (!this.worldMapManager.method911()) {
                    return;
                }
            }

            this.worldMapManager.method908(var1, var2, var3, var4, this.field3940, this.field3972, this.field3983);
        }
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(IIZB)V",
            garbageValue = "-52"
    )
    final void method1200(int var1, int var2, boolean var3) {
        this.worldMapX = var1;
        this.worldMapY = var2;
        Tile.method4297();
        if (var3) {
            this.method1206();
        }

    }

    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            signature = "(IIB)V",
            garbageValue = "37"
    )
    public void method1361(int var1, int var2) {
        if (this.worldMapData != null && this.worldMapData.method986(var1, var2)) {
            this.worldMapTargetX = var1 - this.worldMapData.method1017() * 64;
            this.worldMapTargetY = var2 - this.worldMapData.method988() * 64;
        }
    }

    @ObfuscatedName("ad")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-1581762126"
    )
    public int method1228() {
        return this.worldMapData == null ? -1 : this.worldMapY + this.worldMapData.method988() * 64;
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(S)V",
            garbageValue = "-24130"
    )
    final void method1206() {
        this.field3959 = -1;
        this.field3975 = -1;
        this.field3974 = -1;
        this.field3986 = -1;
    }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            signature = "(IIIB)V",
            garbageValue = "0"
    )
    public void method1226(int var1, int var2, int var3) {
        if (this.worldMapData != null) {
            int[] var4 = this.worldMapData.method987(var1, var2, var3);
            if (var4 != null) {
                this.method1312(var4[0], var4[1]);
            }

        }
    }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "(Lk;I)V",
            garbageValue = "-611236054"
    )
    void method1260(WorldMapData var1) {
        this.worldMapData = var1;
        this.worldMapManager = new WorldMapManager(this.field3950, this.mapFonts);
        this.field3985.method5686(this.worldMapData.method1001());
    }

    @ObfuscatedName("bl")
    @ObfuscatedSignature(
            signature = "(I)Lax;",
            garbageValue = "42744814"
    )
    public MapIcon method1381() {
        if (!this.field3985.method5688()) {
            return null;
        } else if (!this.worldMapManager.method911()) {
            return null;
        } else {
            HashMap var1 = this.worldMapManager.method912();
            this.field3990 = new LinkedList();
            Iterator var2 = var1.values().iterator();

            while (var2.hasNext()) {
                List var3 = (List) var2.next();
                this.field3990.addAll(var3);
            }

            this.field3991 = this.field3990.iterator();
            return this.method1251();
        }
    }

    @ObfuscatedName("az")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-1272691340"
    )
    public int method1264() {
        return 1.0D == (double) this.worldMapZoomTarget ? 25 : ((double) this.worldMapZoomTarget == 1.5D ? 37 : (2.0D == (double) this.worldMapZoomTarget ? 50 : (3.0D == (double) this.worldMapZoomTarget ? 75 : (4.0D == (double) this.worldMapZoomTarget ? 100 : 200))));
    }

    @ObfuscatedName("bw")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "62"
    )
    void method1246() {
        this.field3965.clear();
        this.field3965.addAll(this.field3973);
        this.field3965.addAll(this.field3958);
    }

    @ObfuscatedName("ap")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "598934438"
    )
    public void method1235() {
        this.field3983 = 50;
    }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            signature = "(II)F",
            garbageValue = "-1849574830"
    )
    float method1218(int var1) {
        return var1 == 25 ? 1.0F : (var1 == 37 ? 1.5F : (var1 == 50 ? 2.0F : (var1 == 75 ? 3.0F : (var1 == 100 ? 4.0F : 8.0F))));
    }

    @ObfuscatedName("bi")
    @ObfuscatedSignature(
            signature = "(IZB)V",
            garbageValue = "1"
    )
    public void method1195(int var1, boolean var2) {
        if (!var2) {
            this.field3996.add(Integer.valueOf(var1));
        } else {
            this.field3996.remove(Integer.valueOf(var1));
        }

        for (int var3 = 0; var3 < MapElementType.field3331; ++var3) {
            if (Timer.method5389(var3) != null && Timer.method5389(var3).category == var1) {
                int var4 = Timer.method5389(var3).id;
                if (!var2) {
                    this.field3958.add(Integer.valueOf(var4));
                } else {
                    this.field3958.remove(Integer.valueOf(var4));
                }
            }
        }

        this.method1246();
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(IIIZB)V",
            garbageValue = "-28"
    )
    public void method1204(int var1, int var2, int var3, boolean var4) {
        WorldMapData var5 = this.method1203(var1, var2, var3);
        if (var5 == null) {
            if (!var4) {
                return;
            }

            var5 = this.field3951;
        }

        boolean var6 = false;
        if (var5 != this.field3954 || var4) {
            this.field3954 = var5;
            this.method1208(var5);
            var6 = true;
        }

        if (var6 || var4) {
            this.method1209(var1, var2, var3);
        }

    }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            signature = "(IIIB)V",
            garbageValue = "3"
    )
    void method1209(int var1, int var2, int var3) {
        if (this.worldMapData != null) {
            int[] var4 = this.worldMapData.method987(var1, var2, var3);
            if (var4 == null) {
                var4 = this.worldMapData.method987(this.worldMapData.method993(), this.worldMapData.method1040(), this.worldMapData.method1002());
            }

            this.method1200(var4[0] - this.worldMapData.method1017() * 64, var4[1] - this.worldMapData.method988() * 64, true);
            this.worldMapTargetX = -1;
            this.worldMapTargetY = -1;
            this.worldMapZoom = this.method1218(this.worldMapData.method995());
            this.worldMapZoomTarget = this.worldMapZoom;
            this.field3990 = null;
            this.field3991 = null;
            this.worldMapManager.method915();
        }
    }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            signature = "(II)Lk;",
            garbageValue = "-408063967"
    )
    public WorldMapData method1222(int var1) {
        Iterator var2 = this.worldMapDataByIdentifier.values().iterator();

        WorldMapData var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (WorldMapData) var2.next();
        } while (var3.method990() != var1);

        return var3;
    }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "2139444004"
    )
    public int method1231() {
        return this.worldMapDisplayHeight;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Liu;Lkz;Ljava/util/HashMap;[Lli;I)V",
            garbageValue = "-428996887"
    )
    public void method1192(Js5Index var1, Font var2, HashMap var3, IndexedSprite[] var4) {
        this.field3950 = var4;
        this.field3944 = var1;
        this.field3984 = var2;
        this.mapFonts = new HashMap();
        this.mapFonts.put(Size.field92, var3.get(fontNameVerdana11));
        this.mapFonts.put(Size.field93, var3.get(fontNameVerdana13));
        this.mapFonts.put(Size.field94, var3.get(fontNameVerdana15));
        this.field3985 = new class296(var1);
        int var5 = this.field3944.method1510(MapCacheArchiveNames.field291.name);
        int[] var6 = this.field3944.method1524(var5);
        this.worldMapDataByIdentifier = new HashMap(var6.length);

        for (int var7 = 0; var7 < var6.length; ++var7) {
            Packet var8 = new Packet(this.field3944.method1516(var5, var6[var7], 1789634852));
            WorldMapData var9 = new WorldMapData();
            var9.method999(var8, var6[var7]);
            this.worldMapDataByIdentifier.put(var9.method1001(), var9);
            if (var9.method991()) {
                this.field3951 = var9;
            }
        }

        this.method1208(this.field3951);
        this.field3954 = null;
    }
}
