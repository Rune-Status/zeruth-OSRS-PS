package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("MapCacheArchiveNames")
public class MapCacheArchiveNames {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Law;"
    )
    public static final MapCacheArchiveNames field288;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Law;"
    )
    public static final MapCacheArchiveNames field289;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Law;"
    )
    public static final MapCacheArchiveNames field290;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Law;"
    )
    public static final MapCacheArchiveNames field292;
    @ObfuscatedName("gl")
    static int[] landRegionFileIds;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Law;"
    )
    public static final MapCacheArchiveNames field291;
    @ObfuscatedName("l")
    public final String name;

    static {
        field291 = new MapCacheArchiveNames("details");
        field288 = new MapCacheArchiveNames("compositemap");
        field289 = new MapCacheArchiveNames("compositetexture");
        field290 = new MapCacheArchiveNames("area");
        field292 = new MapCacheArchiveNames("labels");
    }

    MapCacheArchiveNames(String var1) {
        this.name = var1;
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(IIIIIZI)Lls;",
            garbageValue = "-1711011641"
    )
    public static final SpritePixels method2148(int var0, int var1, int var2, int var3, int var4, boolean var5) {
        if (var1 == -1) {
            var4 = 0;
        } else if (var4 == 2 && var1 != 1) {
            var4 = 1;
        }

        long var6 = ((long) var4 << 40) + (long) var0 + ((long) var1 << 16) + ((long) var2 << 38) + ((long) var3 << 42);
        SpritePixels var8;
        if (!var5) {
            var8 = (SpritePixels) ObjType.itemSpriteCache.method951(var6);
            if (var8 != null) {
                return var8;
            }
        }

        ObjType var9 = Varcs.method4770(var0);
        if (var1 > 1 && var9.countObj != null) {
            int var10 = -1;

            for (int var11 = 0; var11 < 10; ++var11) {
                if (var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
                    var10 = var9.countObj[var11];
                }
            }

            if (var10 != -1) {
                var9 = Varcs.method4770(var10);
            }
        }

        Model var21 = var9.method6333(1);
        if (var21 == null) {
            return null;
        } else {
            SpritePixels var22 = null;
            if (var9.certTemplate != -1) {
                var22 = method2148(var9.certLink, 10, 1, 0, 0, true);
                if (var22 == null) {
                    return null;
                }
            } else if (var9.boughtTemplate != -1) {
                var22 = method2148(var9.boughtLink, var1, var2, var3, 0, false);
                if (var22 == null) {
                    return null;
                }
            } else if (var9.placeholderTemplate != -1) {
                var22 = method2148(var9.placeholderLink, var1, 0, 0, 0, false);
                if (var22 == null) {
                    return null;
                }
            }

            int[] var12 = Rasterizer2D.graphicsPixels;
            int var13 = Rasterizer2D.graphicsPixelsWidth;
            int var14 = Rasterizer2D.graphicsPixelsHeight;
            int[] var15 = new int[4];
            Rasterizer2D.method512(var15);
            var8 = new SpritePixels(36, 32);
            Rasterizer2D.method440(var8.pixels, 36, 32);
            Rasterizer2D.resetDepthBuffer();
            Rasterizer2D.method445();
            Graphics3D.method2586();
            Graphics3D.method2572(16, 16);
            Graphics3D.rasterGouraudLowRes = false;
            if (var9.placeholderTemplate != -1) {
                var22.method2253(0, 0);
            }

            int var16 = var9.zoom2d;
            if (var5) {
                var16 = (int) (1.5D * (double) var16);
            } else if (var2 == 2) {
                var16 = (int) ((double) var16 * 1.04D);
            }

            int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
            int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
            var21.method5457();
            var21.method5509(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.xof2d, var21.modelHeight / 2 + var17 + var9.yof2d, var18 + var9.yof2d);
            if (var9.boughtTemplate != -1) {
                var22.method2253(0, 0);
            }

            if (var2 >= 1) {
                var8.method2249(1);
            }

            if (var2 >= 2) {
                var8.method2249(16777215);
            }

            if (var3 != 0) {
                var8.method2250(var3);
            }

            Rasterizer2D.method440(var8.pixels, 36, 32);
            if (var9.certTemplate != -1) {
                var22.method2253(0, 0);
            }

            if (var4 == 1 || var4 == 2 && var9.stackable == 1) {
                Font var19 = class82.field1931;
                String var20;
                if (var1 < 100000) {
                    var20 = "<col=ffff00>" + var1 + "</col>";
                } else if (var1 < 10000000) {
                    var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
                } else {
                    var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
                }

                var19.method1828(var20, 0, 9, 16776960, 1);
            }

            if (!var5) {
                ObjType.itemSpriteCache.method957(var8, var6);
            }

            Rasterizer2D.method440(var12, var13, var14);
            Rasterizer2D.method452(var15);
            Graphics3D.method2586();
            Graphics3D.rasterGouraudLowRes = true;
            return var8;
        }
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)Ljg;",
            garbageValue = "-1552610333"
    )
    public static Sequence method2149(int var0) {
        Sequence var1 = (Sequence) Sequence.sequences.method951((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = Sequence.seq_ref.method1516(12, var0, 1789634852);
            var1 = new Sequence();
            if (var2 != null) {
                var1.method4786(new Packet(var2));
            }

            var1.method4778();
            Sequence.sequences.method957(var1, (long) var0);
            return var1;
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "1429006499"
    )
    static int method2147(int var0, class106 var1, boolean var2) {
        ComponentType var3;
        if (var0 >= 2000) {
            var0 -= 1000;
            var3 = WorldMapType1.method2440(class48.intStack[--class228.intStackSize]);
        } else {
            var3 = var2 ? class113.field75 : class48.field1080;
        }

        class208.method4144(var3);
        if (var0 != 1200 && var0 != 1205 && var0 != 1212) {
            if (var0 == 1201) {
                var3.modelType = 2;
                var3.modelId = class48.intStack[--class228.intStackSize];
                return 1;
            } else if (var0 == 1202) {
                var3.modelType = 3;
                var3.modelId = class4.localPlayer.composition.method627();
                return 1;
            } else {
                return 2;
            }
        } else {
            class228.intStackSize -= 2;
            int var4 = class48.intStack[class228.intStackSize];
            int var5 = class48.intStack[class228.intStackSize + 1];
            var3.linkObjType = var4;
            var3.linkObjCount = var5;
            ObjType var6 = Varcs.method4770(var4);
            var3.xan2d = var6.xan2d;
            var3.yan2d = var6.yan2d;
            var3.zan2d = var6.zan2d;
            var3.offsetX2d = var6.xof2d;
            var3.offsetY2d = var6.yof2d;
            var3.zoom2d = var6.zoom2d;
            if (var0 == 1205) {
                var3.objNumMode = 0;
            } else if (var0 == 1212 | var6.stackable == 1) {
                var3.objNumMode = 1;
            } else {
                var3.objNumMode = 2;
            }

            if (var3.field2722 > 0) {
                var3.zoom2d = var3.zoom2d * 32 / var3.field2722;
            } else if (var3.sizeX > 0) {
                var3.zoom2d = var3.zoom2d * 32 / var3.sizeX;
            }

            return 1;
        }
    }

    @ObfuscatedName("g")
    static boolean method2150(long var0) {
        int var2 = (int) (var0 >>> 14 & 3L);
        return var2 == 2;
    }
}
