package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapManager;

import java.awt.*;
import java.util.List;
import java.util.*;

@ObfuscatedName("ae")
@Implements("WorldMapManager")
public final class WorldMapManager implements RSWorldMapManager {
    @ObfuscatedName("qc")
    @ObfuscatedGetter(
            intValue = -688864877
    )
    static int field314;
    @ObfuscatedName("ai")
    @ObfuscatedSignature(
            signature = "Lly;"
    )
    public static BufferProvider rasterProvider;
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "[[Ly;"
    )
    WorldMapRegion[][] mapRegions;
    @ObfuscatedName("r")
    boolean loading;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Laj;"
    )
    class124 field302;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            signature = "[Lli;"
    )
    IndexedSprite[] field306;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lls;"
    )
    SpritePixels field308;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = 684781527
    )
    int field299;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -786526337
    )
    int mapSurfaceBaseOffsetY;
    @ObfuscatedName("b")
    HashMap field305;
    @ObfuscatedName("n")
    final HashMap mapFonts;
    @ObfuscatedName("c")
    HashMap field303;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = -1822126943
    )
    int mapSurfaceBaseOffsetX;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = 1894696781
    )
    int field311;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = -174365543
    )
    public int field312;
    @ObfuscatedName("g")
    boolean loaded;

    @ObfuscatedSignature(
            signature = "([Lli;Ljava/util/HashMap;)V"
    )
    public WorldMapManager(IndexedSprite[] var1, HashMap var2) {
        this.loaded = false;
        this.loading = false;
        this.field305 = new HashMap();
        this.field312 = 0;
        this.field306 = var1;
        this.mapFonts = var2;
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(III)F",
            garbageValue = "-503418480"
    )
    float method930(int var1, int var2) {
        return class166.clientInstance.getRenderOverview().getWorldMapZoom();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-756795179"
    )
    public final void method915() {
        this.field303 = null;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IIIIIIIII)V",
            garbageValue = "-619943859"
    )
    public final void method905(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int[] var9 = Rasterizer2D.graphicsPixels;
        int var10 = Rasterizer2D.graphicsPixelsWidth;
        int var11 = Rasterizer2D.graphicsPixelsHeight;
        int[] var12 = new int[4];
        Rasterizer2D.method512(var12);
        WorldMapRectangle var13 = this.method910(var1, var2, var3, var4);
        float var14 = this.method930(var7 - var5, var3 - var1);
        int var15 = (int) Math.ceil((double) var14);
        this.field312 = var15;
        if (!this.field305.containsKey(Integer.valueOf(var15))) {
            class324 var16 = new class324(var15);
            var16.method6370();
            this.field305.put(Integer.valueOf(var15), var16);
        }

        WorldMapRegion[] var22 = new WorldMapRegion[8];

        int var17;
        int var18;
        for (var17 = var13.worldMapRegionX; var17 < var13.worldMapRegionX + var13.worldMapRegionWidth; ++var17) {
            for (var18 = var13.worldMapRegionY; var18 < var13.worldMapRegionHeight + var13.worldMapRegionY; ++var18) {
                this.method902(var17, var18, var22);
                this.mapRegions[var17][var18].method4151(var15, (class324) this.field305.get(Integer.valueOf(var15)), var22, this.field306);
            }
        }

        Rasterizer2D.method440(var9, var10, var11);
        Rasterizer2D.method452(var12);
        var17 = (int) (var14 * 64.0F);
        var18 = this.mapSurfaceBaseOffsetX + var1;
        int var19 = var2 + this.mapSurfaceBaseOffsetY;

        for (int var20 = var13.worldMapRegionX; var20 < var13.worldMapRegionX + var13.worldMapRegionWidth; ++var20) {
            for (int var21 = var13.worldMapRegionY; var21 < var13.worldMapRegionY + var13.worldMapRegionHeight; ++var21) {
                this.mapRegions[var20][var21].method4146(var5 + var17 * (this.mapRegions[var20][var21].field233 * 64 - var18) / 64, var8 - var17 * (this.mapRegions[var20][var21].field234 * 64 - var19 + 64) / 64, var17);
            }
        }

    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
            garbageValue = "-747039163"
    )
    public final void method917(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
        WorldMapRectangle var14 = this.method910(var1, var2, var3, var4);
        float var15 = this.method930(var7 - var5, var3 - var1);
        int var16 = (int) (64.0F * var15);
        int var17 = this.mapSurfaceBaseOffsetX + var1;
        int var18 = var2 + this.mapSurfaceBaseOffsetY;

        int var19;
        int var20;
        for (var19 = var14.worldMapRegionX; var19 < var14.worldMapRegionX + var14.worldMapRegionWidth; ++var19) {
            for (var20 = var14.worldMapRegionY; var20 < var14.worldMapRegionY + var14.worldMapRegionHeight; ++var20) {
                if (var13) {
                    this.mapRegions[var19][var20].method4246();
                }

                this.mapRegions[var19][var20].method4226(var5 + var16 * (this.mapRegions[var19][var20].field233 * 64 - var17) / 64, var8 - var16 * (this.mapRegions[var19][var20].field234 * 64 - var18 + 64) / 64, var16, var9);
            }
        }

        if (var10 != null && var11 > 0) {
            for (var19 = var14.worldMapRegionX; var19 < var14.worldMapRegionX + var14.worldMapRegionWidth; ++var19) {
                for (var20 = var14.worldMapRegionY; var20 < var14.worldMapRegionY + var14.worldMapRegionHeight; ++var20) {
                    this.mapRegions[var19][var20].method4153(var10, var11, var12);
                }
            }
        }

    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-2131106684"
    )
    void method937() {
        if (this.field303 == null) {
            this.field303 = new HashMap();
        }

        this.field303.clear();

        for (int var1 = 0; var1 < this.mapRegions.length; ++var1) {
            for (int var2 = 0; var2 < this.mapRegions[var1].length; ++var2) {
                List var3 = this.mapRegions[var1][var2].method4216();
                Iterator var4 = var3.iterator();

                while (var4.hasNext()) {
                    MapIcon var5 = (MapIcon) var4.next();
                    if (!this.field303.containsKey(Integer.valueOf(var5.areaId))) {
                        LinkedList var6 = new LinkedList();
                        var6.add(var5);
                        this.field303.put(Integer.valueOf(var5.areaId), var6);
                    } else {
                        List var7 = (List) this.field303.get(Integer.valueOf(var5.areaId));
                        var7.add(var5);
                    }
                }
            }
        }

    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(IIIII)Lf;",
            garbageValue = "-1371716593"
    )
    WorldMapRectangle method910(int var1, int var2, int var3, int var4) {
        WorldMapRectangle var5 = new WorldMapRectangle(this);
        int var6 = this.mapSurfaceBaseOffsetX + var1;
        int var7 = var2 + this.mapSurfaceBaseOffsetY;
        int var8 = var3 + this.mapSurfaceBaseOffsetX;
        int var9 = var4 + this.mapSurfaceBaseOffsetY;
        int var10 = var6 / 64;
        int var11 = var7 / 64;
        int var12 = var8 / 64;
        int var13 = var9 / 64;
        var5.worldMapRegionWidth = var12 - var10 + 1;
        var5.worldMapRegionHeight = var13 - var11 + 1;
        var5.worldMapRegionX = var10 - this.field302.method1017();
        var5.worldMapRegionY = var11 - this.field302.method988();
        if (var5.worldMapRegionX < 0) {
            var5.worldMapRegionWidth += var5.worldMapRegionX;
            var5.worldMapRegionX = 0;
        }

        if (var5.worldMapRegionX > this.mapRegions.length - var5.worldMapRegionWidth) {
            var5.worldMapRegionWidth = this.mapRegions.length - var5.worldMapRegionX;
        }

        if (var5.worldMapRegionY < 0) {
            var5.worldMapRegionHeight += var5.worldMapRegionY;
            var5.worldMapRegionY = 0;
        }

        if (var5.worldMapRegionY > this.mapRegions[0].length - var5.worldMapRegionHeight) {
            var5.worldMapRegionHeight = this.mapRegions[0].length - var5.worldMapRegionY;
        }

        var5.worldMapRegionWidth = Math.min(var5.worldMapRegionWidth, this.mapRegions.length);
        var5.worldMapRegionHeight = Math.min(var5.worldMapRegionHeight, this.mapRegions[0].length);
        return var5;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(IIIIIIIIIII)Ljava/util/List;",
            garbageValue = "-475715480"
    )
    public List method909(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
        LinkedList var11 = new LinkedList();
        if (!this.loaded) {
            return var11;
        } else {
            WorldMapRectangle var12 = this.method910(var1, var2, var3, var4);
            float var13 = this.method930(var7, var3 - var1);
            int var14 = (int) (64.0F * var13);
            int var15 = this.mapSurfaceBaseOffsetX + var1;
            int var16 = var2 + this.mapSurfaceBaseOffsetY;

            for (int var17 = var12.worldMapRegionX; var17 < var12.worldMapRegionX + var12.worldMapRegionWidth; ++var17) {
                for (int var18 = var12.worldMapRegionY; var18 < var12.worldMapRegionHeight + var12.worldMapRegionY; ++var18) {
                    List var19 = this.mapRegions[var17][var18].method4181(var5 + var14 * (this.mapRegions[var17][var18].field233 * 64 - var15) / 64, var8 + var6 - var14 * (this.mapRegions[var17][var18].field234 * 64 - var16 + 64) / 64, var14, var9, var10);
                    if (!var19.isEmpty()) {
                        var11.addAll(var19);
                    }
                }
            }

            return var11;
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(II[Ly;B)V",
            garbageValue = "36"
    )
    void method902(int var1, int var2, WorldMapRegion[] var3) {
        boolean var4 = var1 <= 0;
        boolean var5 = var1 >= this.mapRegions.length - 1;
        boolean var6 = var2 <= 0;
        boolean var7 = var2 >= this.mapRegions[0].length - 1;
        if (var7) {
            var3[class233.field3172.vmethod5358()] = null;
        } else {
            var3[class233.field3172.vmethod5358()] = this.mapRegions[var1][var2 + 1];
        }

        var3[class233.field3163.vmethod5358()] = !var7 && !var5 ? this.mapRegions[var1 + 1][var2 + 1] : null;
        var3[class233.field3167.vmethod5358()] = !var7 && !var4 ? this.mapRegions[var1 - 1][var2 + 1] : null;
        var3[class233.field3164.vmethod5358()] = var5 ? null : this.mapRegions[var1 + 1][var2];
        var3[class233.field3168.vmethod5358()] = var4 ? null : this.mapRegions[var1 - 1][var2];
        var3[class233.field3166.vmethod5358()] = var6 ? null : this.mapRegions[var1][var2 - 1];
        var3[class233.field3162.vmethod5358()] = !var6 && !var5 ? this.mapRegions[var1 + 1][var2 - 1] : null;
        var3[class233.field3169.vmethod5358()] = !var6 && !var4 ? this.mapRegions[var1 - 1][var2 - 1] : null;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public int getSurfaceOffsetX() {
        return this.mapSurfaceBaseOffsetX;
    }

    public int getSurfaceOffsetY() {
        return this.mapSurfaceBaseOffsetY;
    }

    public float getPixelsPerTile(int var1, int var2) {
        return this.method930(var1, var2);
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(IIIILjava/util/HashSet;III)V",
            garbageValue = "1068522909"
    )
    public void method908(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
        if (this.field308 != null) {
            this.field308.method2255(var1, var2, var3, var4);
            if (var6 > 0 && var6 % var7 < var7 / 2) {
                if (this.field303 == null) {
                    this.method937();
                }

                Iterator var8 = var5.iterator();

                while (true) {
                    List var10;
                    do {
                        if (!var8.hasNext()) {
                            return;
                        }

                        int var9 = ((Integer) var8.next()).intValue();
                        var10 = (List) this.field303.get(Integer.valueOf(var9));
                    } while (var10 == null);

                    Iterator var11 = var10.iterator();

                    while (var11.hasNext()) {
                        MapIcon var12 = (MapIcon) var11.next();
                        int var13 = var3 * (var12.field277.worldX - this.mapSurfaceBaseOffsetX) / this.field299;
                        int var14 = var4 - (var12.field277.worldY - this.mapSurfaceBaseOffsetY) * var4 / this.field311;
                        Rasterizer2D.method497(var13 + var1, var14 + var2, 2, 16776960, 256);
                    }
                }
            }
        }
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1670807775"
    )
    public boolean method911() {
        return this.loaded;
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(I)Ljava/util/HashMap;",
            garbageValue = "1356369007"
    )
    public HashMap method912() {
        this.method937();
        return this.field303;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Liu;Ljava/lang/String;ZI)V",
            garbageValue = "1999096986"
    )
    public void method903(Js5Index var1, String var2, boolean var3) {
        if (!this.loading) {
            this.loaded = false;
            this.loading = true;
            System.nanoTime();
            int var4 = var1.method1510(MapCacheArchiveNames.field291.name);
            int var5 = var1.method1532(var4, var2);
            Packet var6 = new Packet(var1.method1534(MapCacheArchiveNames.field291.name, var2));
            Packet var7 = new Packet(var1.method1534(MapCacheArchiveNames.field288.name, var2));
            Packet var8 = new Packet(var1.method1534(var2, MapCacheArchiveNames.field290.name));
            System.nanoTime();
            System.nanoTime();
            this.field302 = new class124();

            try {
                this.field302.method2088(var6, var8, var7, var5, var3);
            } catch (IllegalStateException var20) {
                return;
            }

            this.field302.method1040();
            this.field302.method993();
            this.field302.method1002();
            this.mapSurfaceBaseOffsetX = this.field302.method1017() * 64;
            this.mapSurfaceBaseOffsetY = this.field302.method988() * 64;
            this.field299 = (this.field302.method997() - this.field302.method1017() + 1) * 64;
            this.field311 = (this.field302.method1008() - this.field302.method988() + 1) * 64;
            int var17 = this.field302.method997() - this.field302.method1017() + 1;
            int var10 = this.field302.method1008() - this.field302.method988() + 1;
            System.nanoTime();
            System.nanoTime();
            FriendManager.method119();
            this.mapRegions = new WorldMapRegion[var17][var10];
            Iterator var11 = this.field302.field327.iterator();

            while (var11.hasNext()) {
                class113 var12 = (class113) var11.next();
                int var13 = var12.field146;
                int var14 = var12.field151;
                int var15 = var13 - this.field302.method1017();
                int var16 = var14 - this.field302.method988();
                this.mapRegions[var15][var16] = new WorldMapRegion(var13, var14, this.field302.method994(), this.mapFonts);
                this.mapRegions[var15][var16].method4147(var12, this.field302.field326);
            }

            for (int var18 = 0; var18 < var17; ++var18) {
                for (int var19 = 0; var19 < var10; ++var19) {
                    if (this.mapRegions[var18][var19] == null) {
                        this.mapRegions[var18][var19] = new WorldMapRegion(this.field302.method1017() + var18, this.field302.method988() + var19, this.field302.method994(), this.mapFonts);
                        this.mapRegions[var18][var19].method4256(this.field302.field324, this.field302.field326);
                    }
                }
            }

            System.nanoTime();
            System.nanoTime();
            if (var1.method1533(MapCacheArchiveNames.field289.name, var2)) {
                byte[] var21 = var1.method1534(MapCacheArchiveNames.field289.name, var2);
                this.field308 = class48.method776(var21);
            }

            System.nanoTime();
            var1.method1527();
            var1.method1529();
            this.loaded = true;
        }
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Ljava/awt/Component;I)V",
            garbageValue = "1302375733"
    )
    static void method942(Component var0) {
        var0.setFocusTraversalKeysEnabled(false);
        var0.addKeyListener(KeyFocusListener.keyboard);
        var0.addFocusListener(KeyFocusListener.keyboard);
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IIII)Lcx;",
            garbageValue = "-69024650"
    )
    static class106 method946(int var0, int var1, int var2) {
        int var3 = class120.method2061(var1, var0);
        class106 var4 = class106.method1872(var3, var0);
        if (var4 != null) {
            return var4;
        } else {
            int var5 = var0 + (var2 + 40000 << 8);
            var4 = class106.method1872(var5, var0);
            return var4 != null ? var4 : null;
        }
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "2145588800"
    )
    static void method943(int var0) {
        ItemContainer var1 = (ItemContainer) ItemContainer.itemContainers.method380((long) var0);
        if (var1 != null) {
            var1.method6469();
        }
    }

    @ObfuscatedName("fe")
    @ObfuscatedSignature(
            signature = "(ZI)V",
            garbageValue = "-2073251868"
    )
    static final void method945(boolean var0) {
        if (var0) {
            client.field681 = class316.field1172 ? AuthProt.field1965 : AuthProt.field1966;
        } else {
            LinkedHashMap var1 = GameEngine.options.authRememberTokens;
            String var3 = class316.username;
            int var4 = var3.length();
            int var5 = 0;

            for (int var6 = 0; var6 < var4; ++var6) {
                var5 = (var5 << 5) - var5 + var3.charAt(var6);
            }

            client.field681 = var1.containsKey(Integer.valueOf(var5)) ? AuthProt.field1967 : AuthProt.field1964;
        }

    }

    @ObfuscatedName("ib")
    @ObfuscatedSignature(
            signature = "(IIIZI)V",
            garbageValue = "1322055867"
    )
    static final void method904(int var0, int var1, int var2, boolean var3) {
        if (class232.method4564(var0)) {
            Timer.method5401(class36.interfaces[var0], -1, var1, var2, var3);
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Ljava/awt/Component;I)V",
            garbageValue = "1654789779"
    )
    static void method947(Component var0) {
        var0.addMouseListener(MouseInput.mouse);
        var0.addMouseMotionListener(MouseInput.mouse);
        var0.addFocusListener(MouseInput.mouse);
    }
}
