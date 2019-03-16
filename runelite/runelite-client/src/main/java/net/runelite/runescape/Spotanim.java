package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index SpotAnimationDefinition_modelIndexCache;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    static NodeCache spotanims;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    static NodeCache SpotAnimationDefinition_cachedModels;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index SpotAnimationDefinition_indexCache;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -1040408789
    )
    int field3342;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = 1342538537
    )
    int field3355;
    @ObfuscatedName("w")
    short[] field3349;
    @ObfuscatedName("x")
    @ObfuscatedGetter(
            intValue = 1318976635
    )
    int field3356;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = -320397055
    )
    int widthScale;
    @ObfuscatedName("p")
    short[] field3352;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 1944494541
    )
    public int field3348;
    @ObfuscatedName("n")
    short[] field3346;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -1163250473
    )
    int id;
    @ObfuscatedName("i")
    short[] field3351;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = 485665485
    )
    int heightScale;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = -2104622459
    )
    int orientation;

    static {
        spotanims = new NodeCache(64);
        SpotAnimationDefinition_cachedModels = new NodeCache(30);
    }

    Spotanim() {
        this.field3348 = -1;
        this.widthScale = 128;
        this.heightScale = 128;
        this.orientation = 0;
        this.field3356 = 0;
        this.field3355 = 0;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-1499812191"
    )
    void method5305(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method5306(var1, var2);
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;IS)V",
            garbageValue = "3929"
    )
    void method5306(Packet var1, int var2) {
        if (var2 == 1) {
            this.field3342 = var1.readUnsignedShort();
        } else if (var2 == 2) {
            this.field3348 = var1.readUnsignedShort();
        } else if (var2 == 4) {
            this.widthScale = var1.readUnsignedShort();
        } else if (var2 == 5) {
            this.heightScale = var1.readUnsignedShort();
        } else if (var2 == 6) {
            this.orientation = var1.readUnsignedShort();
        } else if (var2 == 7) {
            this.field3356 = var1.readUnsignedByte();
        } else if (var2 == 8) {
            this.field3355 = var1.readUnsignedByte();
        } else {
            int var3;
            int var4;
            if (var2 == 40) {
                var3 = var1.readUnsignedByte();
                this.field3349 = new short[var3];
                this.field3346 = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.field3349[var4] = (short) var1.readUnsignedShort();
                    this.field3346[var4] = (short) var1.readUnsignedShort();
                }
            } else if (var2 == 41) {
                var3 = var1.readUnsignedByte();
                this.field3351 = new short[var3];
                this.field3352 = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.field3351[var4] = (short) var1.readUnsignedShort();
                    this.field3352[var4] = (short) var1.readUnsignedShort();
                }
            }
        }

    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(II)Ldl;",
            garbageValue = "-1255734612"
    )
    public final Model method5304(int var1) {
        Model var2 = (Model) SpotAnimationDefinition_cachedModels.method951((long) this.id);
        if (var2 == null) {
            ModelData var3 = ModelData.method1479(SpotAnimationDefinition_modelIndexCache, this.field3342, 0);
            if (var3 == null) {
                return null;
            }

            int var4;
            if (this.field3349 != null) {
                for (var4 = 0; var4 < this.field3349.length; ++var4) {
                    var3.method1411(this.field3349[var4], this.field3346[var4]);
                }
            }

            if (this.field3351 != null) {
                for (var4 = 0; var4 < this.field3351.length; ++var4) {
                    var3.method1421(this.field3351[var4], this.field3352[var4]);
                }
            }

            var2 = var3.method1408(this.field3356 + 64, this.field3355 + 850, -30, -50, -30);
            SpotAnimationDefinition_cachedModels.method957(var2, (long) this.id);
        }

        Model var5;
        if (this.field3348 != -1 && var1 != -1) {
            var5 = MapCacheArchiveNames.method2149(this.field3348).method4808(var2, var1, -358677299);
        } else {
            var5 = var2.method5465(true);
        }

        if (this.widthScale != 128 || this.heightScale != 128) {
            var5.method5462(this.widthScale, this.heightScale, this.widthScale);
        }

        if (this.orientation != 0) {
            if (this.orientation == 90) {
                var5.method5464();
            }

            if (this.orientation == 180) {
                var5.method5464();
                var5.method5464();
            }

            if (this.orientation == 270) {
                var5.method5464();
                var5.method5464();
                var5.method5464();
            }
        }

        return var5;
    }

    @ObfuscatedName("ad")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "-431383028"
    )
    static int method5319(int var0, class106 var1, boolean var2) {
        if (var0 == 6200) {
            class228.intStackSize -= 2;
            client.field649 = (short) FontName.method1975(class48.intStack[class228.intStackSize]);
            if (client.field649 <= 0) {
                client.field649 = 256;
            }

            client.field896 = (short) FontName.method1975(class48.intStack[class228.intStackSize + 1]);
            if (client.field896 <= 0) {
                client.field896 = 256;
            }

            return 1;
        } else if (var0 == 6201) {
            class228.intStackSize -= 2;
            client.field897 = (short) class48.intStack[class228.intStackSize];
            if (client.field897 <= 0) {
                client.field897 = 256;
            }

            client.field898 = (short) class48.intStack[class228.intStackSize + 1];
            if (client.field898 <= 0) {
                client.field898 = 320;
            }

            return 1;
        } else if (var0 == 6202) {
            class228.intStackSize -= 4;
            client.field899 = (short) class48.intStack[class228.intStackSize];
            if (client.field899 <= 0) {
                client.field899 = 1;
            }

            client.field684 = (short) class48.intStack[class228.intStackSize + 1];
            if (client.field684 <= 0) {
                client.field684 = 32767;
            } else if (client.field684 < client.field899) {
                client.field684 = client.field899;
            }

            client.field901 = (short) class48.intStack[class228.intStackSize + 2];
            if (client.field901 <= 0) {
                client.field901 = 1;
            }

            client.field754 = (short) class48.intStack[class228.intStackSize + 3];
            if (client.field754 <= 0) {
                client.field754 = 32767;
            } else if (client.field754 < client.field901) {
                client.field754 = client.field901;
            }

            return 1;
        } else if (var0 == 6203) {
            if (client.field815 != null) {
                TotalQuantityComparator.method1189(0, 0, client.field815.width, client.field815.height, false);
                class48.intStack[++class228.intStackSize - 1] = client.viewportWidth;
                class48.intStack[++class228.intStackSize - 1] = client.viewportHeight;
            } else {
                class48.intStack[++class228.intStackSize - 1] = -1;
                class48.intStack[++class228.intStackSize - 1] = -1;
            }

            return 1;
        } else if (var0 == 6204) {
            class48.intStack[++class228.intStackSize - 1] = client.field897;
            class48.intStack[++class228.intStackSize - 1] = client.field898;
            return 1;
        } else if (var0 == 6205) {
            class48.intStack[++class228.intStackSize - 1] = class258.method4991(client.field649);
            class48.intStack[++class228.intStackSize - 1] = class258.method4991(client.field896);
            return 1;
        } else {
            return 2;
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lge;I)V",
            garbageValue = "239407642"
    )
    static final void method5325(Bit var0) {
        var0.method2837();
        int var1 = client.localPlayerIndex;
        PlayerEntity var10000 = client.players[var1] = new PlayerEntity();
        client.cachedPlayersChanged(var1);
        class4.localPlayer = var10000;
        PlayerEntity var2 = var10000;
        var2.playerId = var1;
        int var3 = var0.getBits(30);
        byte var4 = (byte) (var3 >> 28);
        int var5 = var3 >> 14 & 16383;
        int var6 = var3 & 16383;
        var2.pathX[0] = var5 - class158.baseX;
        var2.x = (var2.pathX[0] << 7) + (var2.method2895() << 6);
        var2.pathY[0] = var6 - class107.baseY;
        var2.y = (var2.pathY[0] << 7) + (var2.method2895() << 6);
        class228.level = var2.field620 = var4;
        if (class254.appearances[var1] != null) {
            var2.method2889(class254.appearances[var1]);
        }

        class254.highResolutionPlayerCount = 0;
        class254.highResolutionPlayerIndexes[++class254.highResolutionPlayerCount - 1] = var1;
        class254.skipHistory[var1] = 0;
        class254.lowResolutionPlayerCount = 0;

        for (int var7 = 1; var7 < 2048; ++var7) {
            if (var7 != var1) {
                int var8 = var0.getBits(18);
                int var9 = var8 >> 16;
                int var10 = var8 >> 8 & 597;
                int var11 = var8 & 597;
                class254.coords[var7] = (var10 << 14) + var11 + (var9 << 28);
                class254.facingCoords[var7] = 0;
                class254.facingEntities[var7] = -1;
                class254.lowResolutionPlayerIndexes[++class254.lowResolutionPlayerCount - 1] = var7;
                class254.skipHistory[var7] = 0;
            }
        }

        var0.method2834();
    }
}
