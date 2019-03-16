package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMapElementConfig;
import net.runelite.rs.api.RSSpritePixels;

@ObfuscatedName("ii")
@Implements("MapElementType")
public class MapElementType extends CacheableNode implements RSMapElementConfig {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "[Lii;"
    )
    public static MapElementType[] mapElementTypes;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 1330461985
    )
    public static int field3331;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache areaSpriteCache;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    public static Js5Index field3309;
    @ObfuscatedName("f")
    @ObfuscatedGetter(
            intValue = -1417143615
    )
    int field3332;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -64380265
    )
    public int spriteId;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = -257371127
    )
    int field3326;
    @ObfuscatedName("k")
    int[] field3329;
    @ObfuscatedName("w")
    public String text;
    @ObfuscatedName("x")
    @ObfuscatedGetter(
            intValue = -58306061
    )
    int field3323;
    @ObfuscatedName("m")
    public String[] field3320;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -246759683
    )
    int field3311;
    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "Ljq;"
    )
    public class182 horizontalAlignment;
    @ObfuscatedName("z")
    byte[] field3330;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = 493981169
    )
    public int field3327;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 1743324841
    )
    public final int id;
    @ObfuscatedName("t")
    @ObfuscatedSignature(
            signature = "Lix;"
    )
    public class101 verticalAlignment;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = -1288246287
    )
    public int textSize;
    @ObfuscatedName("d")
    public String field3321;
    @ObfuscatedName("j")
    int[] field3322;
    @ObfuscatedName("s")
    @ObfuscatedGetter(
            intValue = -2058211947
    )
    public int category;
    @ObfuscatedName("h")
    @ObfuscatedGetter(
            intValue = -1724875489
    )
    int field3325;

    static {
        areaSpriteCache = new NodeCache(256);
    }

    public MapElementType(int var1) {
        this.spriteId = -1;
        this.field3311 = -1;
        this.textSize = 0;
        this.field3320 = new String[5];
        this.field3323 = Integer.MAX_VALUE;
        this.field3326 = Integer.MAX_VALUE;
        this.field3325 = Integer.MIN_VALUE;
        this.field3332 = Integer.MIN_VALUE;
        this.horizontalAlignment = class182.field3559;
        this.verticalAlignment = class101.field3291;
        this.category = -1;
        this.id = var1;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lgl;B)V",
            garbageValue = "15"
    )
    public void method2375(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method2366(var1, var2);
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "-1977714961"
    )
    void method2366(Packet var1, int var2) {
        if (var2 == 1) {
            this.spriteId = var1.method6207();
        } else if (var2 == 2) {
            this.field3311 = var1.method6207();
        } else if (var2 == 3) {
            this.text = var1.readString();
        } else if (var2 == 4) {
            this.field3327 = var1.method6082();
        } else if (var2 == 5) {
            var1.method6082();
        } else if (var2 == 6) {
            this.textSize = var1.readUnsignedByte();
        } else {
            int var3;
            if (var2 == 7) {
                var3 = var1.readUnsignedByte();
                if ((var3 & 1) == 0) {
                    ;
                }

                if ((var3 & 2) == 2) {
                    ;
                }
            } else if (var2 == 8) {
                var1.readUnsignedByte();
            } else if (var2 >= 10 && var2 <= 14) {
                this.field3320[var2 - 10] = var1.readString();
            } else if (var2 == 15) {
                var3 = var1.readUnsignedByte();
                this.field3322 = new int[var3 * 2];

                int var4;
                for (var4 = 0; var4 < var3 * 2; ++var4) {
                    this.field3322[var4] = var1.method6123();
                }

                var1.getInt();
                var4 = var1.readUnsignedByte();
                this.field3329 = new int[var4];

                int var5;
                for (var5 = 0; var5 < this.field3329.length; ++var5) {
                    this.field3329[var5] = var1.getInt();
                }

                this.field3330 = new byte[var3];

                for (var5 = 0; var5 < var3; ++var5) {
                    this.field3330[var5] = var1.method6240();
                }
            } else if (var2 != 16) {
                if (var2 == 17) {
                    this.field3321 = var1.readString();
                } else if (var2 == 18) {
                    var1.method6207();
                } else if (var2 == 19) {
                    this.category = var1.readUnsignedShort();
                } else if (var2 == 21) {
                    var1.getInt();
                } else if (var2 == 22) {
                    var1.getInt();
                } else if (var2 == 23) {
                    var1.readUnsignedByte();
                    var1.readUnsignedByte();
                    var1.readUnsignedByte();
                } else if (var2 == 24) {
                    var1.method6123();
                    var1.method6123();
                } else if (var2 == 25) {
                    var1.method6207();
                } else if (var2 == 28) {
                    var1.readUnsignedByte();
                } else if (var2 == 29) {
                    this.horizontalAlignment = (class182) class2.method20(class131.method2181(), var1.readUnsignedByte());
                } else if (var2 == 30) {
                    class101[] var6 = new class101[]{class101.field3296, class101.field3291, class101.field3290};
                    this.verticalAlignment = (class101) class2.method20(var6, var1.readUnsignedByte());
                }
            }
        }

    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "2"
    )
    public void method2365() {
        if (this.field3322 != null) {
            for (int var1 = 0; var1 < this.field3322.length; var1 += 2) {
                if (this.field3322[var1] < this.field3323) {
                    this.field3323 = this.field3322[var1];
                } else if (this.field3322[var1] > this.field3325) {
                    this.field3325 = this.field3322[var1];
                }

                if (this.field3322[var1 + 1] < this.field3326) {
                    this.field3326 = this.field3322[var1 + 1];
                } else if (this.field3322[var1 + 1] > this.field3332) {
                    this.field3332 = this.field3322[var1 + 1];
                }
            }
        }

    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "4"
    )
    public int method2368() {
        return this.id;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(ZI)Lls;",
            garbageValue = "-1865508122"
    )
    public SpritePixels method2386(boolean var1) {
        int var2 = var1 ? this.field3311 : this.spriteId;
        return this.method2367(var2);
    }

    public RSSpritePixels getMapIcon(boolean var1) {
        return this.method2386(var1);
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(II)Lls;",
            garbageValue = "1381751159"
    )
    SpritePixels method2367(int var1) {
        if (var1 < 0) {
            return null;
        } else {
            SpritePixels var2 = (SpritePixels) areaSpriteCache.method951((long) var1);
            if (var2 != null) {
                return var2;
            } else {
                var2 = class36.method576(field3309, var1, 0, (byte) 47);
                if (var2 != null) {
                    areaSpriteCache.method957(var2, (long) var1);
                }

                return var2;
            }
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Liu;Ljava/lang/String;Ljava/lang/String;I)Lli;",
            garbageValue = "1918616421"
    )
    public static IndexedSprite method2369(Js5Index var0, String var1, String var2) {
        int var3 = var0.method1510(var1);
        int var4 = var0.method1532(var3, var2);
        return Signlink.method4455(var0, var3, var4);
    }

    @ObfuscatedName("js")
    @ObfuscatedSignature(
            signature = "(IIIILls;Lhx;B)V",
            garbageValue = "-25"
    )
    static final void method2387(int var0, int var1, int var2, int var3, SpritePixels var4, class96 var5) {
        int var6 = var3 * var3 + var2 * var2;
        if (var6 > 4225 && var6 < 90000) {
            int var7 = client.mapAngle & 2047;
            int var8 = Graphics3D.SINE[var7];
            int var9 = Graphics3D.COSINE[var7];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            double var12 = Math.atan2((double) var10, (double) var11);
            int var14 = var5.field2626 / 2 - 25;
            int var15 = (int) (Math.sin(var12) * (double) var14);
            int var16 = (int) (Math.cos(var12) * (double) var14);
            byte var17 = 20;
            Size.mapedge.method2256(var15 + (var0 + var5.field2626 / 2 - var17 / 2), var5.field2621 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
        } else {
            SubInterface.method2438(var0, var1, var2, var3, var4, var5);
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Liu;Liu;ZS)V",
            garbageValue = "12625"
    )
    public static void method2388(Js5Index var0, Js5Index var1, boolean var2) {
        LocType.objects_ref = var0;
        LocType.field3452 = var1;
        LocType.objectCompositionLowDetail = var2;
    }
}
