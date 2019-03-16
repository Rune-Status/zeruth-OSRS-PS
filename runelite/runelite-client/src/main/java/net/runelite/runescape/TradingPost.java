package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@ObfuscatedName("r")
@Implements("TradingPost")
public class TradingPost {
    @ObfuscatedName("no")
    @ObfuscatedGetter(
            intValue = -29361243
    )
    static int field12;
    @ObfuscatedName("r")
    public static Comparator field4;
    @ObfuscatedName("e")
    public static Comparator field3;
    @ObfuscatedName("q")
    public static Comparator field10;
    @ObfuscatedName("fw")
    @ObfuscatedGetter(
            longValue = -6109128558503693093L
    )
    static long field6;
    @ObfuscatedName("c")
    public static Comparator field7;
    @ObfuscatedName("ei")
    @ObfuscatedSignature(
            signature = "Lkt;"
    )
    static GraphicsDefaults graphicsDefaults;
    @ObfuscatedName("ev")
    @ObfuscatedGetter(
            intValue = -920975741
    )
    static int field5;
    @ObfuscatedName("g")
    public final List events;

    static {
        field4 = new class70();
        new WorldComparator();
        field3 = new UnitPriceComparator();
        field10 = new class116();
        field7 = new TotalQuantityComparator();
    }

    @ObfuscatedSignature(
            signature = "(Lgl;Z)V",
            garbageValue = "1"
    )
    public TradingPost(Packet var1, boolean var2) {
        int var3 = var1.readUnsignedShort();
        boolean var4 = var1.readUnsignedByte() == 1;
        byte var5;
        if (var4) {
            var5 = 1;
        } else {
            var5 = 0;
        }

        int var6 = var1.readUnsignedShort();
        this.events = new ArrayList(var6);

        for (int var7 = 0; var7 < var6; ++var7) {
            this.events.add(new GrandExchangeEvent(var1, var5, var3));
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Ljava/util/Comparator;ZI)V",
            garbageValue = "-2022263480"
    )
    public void method803(Comparator var1, boolean var2) {
        if (var2) {
            Collections.sort(this.events, var1);
        } else {
            Collections.sort(this.events, Collections.reverseOrder(var1));
        }

    }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(IIIIIIILde;Lfn;I)V",
            garbageValue = "1731734525"
    )
    static final void method805(int var0, int var1, int var2, int var3, int var4, int var5, int var6, SceneManager var7, CollisionData var8) {
        LocType var9 = class225.method4485(var4);
        int var10;
        int var11;
        if (var5 != 1 && var5 != 3) {
            var10 = var9.width;
            var11 = var9.length;
        } else {
            var10 = var9.length;
            var11 = var9.width;
        }

        int var12;
        int var13;
        if (var10 + var2 <= 104) {
            var12 = (var10 >> 1) + var2;
            var13 = var2 + (var10 + 1 >> 1);
        } else {
            var12 = var2;
            var13 = var2 + 1;
        }

        int var14;
        int var15;
        if (var3 + var11 <= 104) {
            var14 = var3 + (var11 >> 1);
            var15 = var3 + (var11 + 1 >> 1);
        } else {
            var14 = var3;
            var15 = var3 + 1;
        }

        int[][] var16 = class98.tileHeights[var1];
        int var17 = var16[var13][var15] + var16[var12][var15] + var16[var12][var14] + var16[var13][var14] >> 2;
        int var18 = (var2 << 7) + (var10 << 6);
        int var19 = (var3 << 7) + (var11 << 6);
        long var20 = WorldComparator.method6484(var2, var3, 2, var9.field3470 == 0, var4);
        int var22 = (var5 << 6) + var6;
        if (var9.supportItems == 1) {
            var22 += 256;
        }

        Object var23;
        if (var6 == 22) {
            if (var9.animationId == -1 && var9.multiLocs == null) {
                var23 = var9.method1714(22, var5, var16, var18, var17, var19);
            } else {
                var23 = new Location(var4, 22, var5, var1, var2, var3, var9.animationId, true, (Entity) null);
            }

            var7.method3801(var0, var2, var3, var17, (Entity) var23, var20, var22);
            if (var9.clipType == 1) {
                var8.method198(var2, var3);
            }

        } else if (var6 != 10 && var6 != 11) {
            if (var6 >= 12) {
                if (var9.animationId == -1 && var9.multiLocs == null) {
                    var23 = var9.method1714(var6, var5, var16, var18, var17, var19);
                } else {
                    var23 = new Location(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Entity) null);
                }

                var7.method3805(var0, var2, var3, var17, 1, 1, (Entity) var23, 0, var20, var22);
                if (var9.clipType != 0) {
                    var8.method223(var2, var3, var10, var11, var9.blocksProjectile);
                }

            } else if (var6 == 0) {
                if (var9.animationId == -1 && var9.multiLocs == null) {
                    var23 = var9.method1714(0, var5, var16, var18, var17, var19);
                } else {
                    var23 = new Location(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Entity) null);
                }

                var7.method3803(var0, var2, var3, var17, (Entity) var23, (Entity) null, class98.field491[var5], 0, var20, var22);
                if (var9.clipType != 0) {
                    var8.method197(var2, var3, var6, var5, var9.blocksProjectile);
                }

            } else if (var6 == 1) {
                if (var9.animationId == -1 && var9.multiLocs == null) {
                    var23 = var9.method1714(1, var5, var16, var18, var17, var19);
                } else {
                    var23 = new Location(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Entity) null);
                }

                var7.method3803(var0, var2, var3, var17, (Entity) var23, (Entity) null, class98.field499[var5], 0, var20, var22);
                if (var9.clipType != 0) {
                    var8.method197(var2, var3, var6, var5, var9.blocksProjectile);
                }

            } else {
                int var29;
                if (var6 == 2) {
                    var29 = var5 + 1 & 3;
                    Object var24;
                    Object var25;
                    if (var9.animationId == -1 && var9.multiLocs == null) {
                        var24 = var9.method1714(2, var5 + 4, var16, var18, var17, var19);
                        var25 = var9.method1714(2, var29, var16, var18, var17, var19);
                    } else {
                        var24 = new Location(var4, 2, var5 + 4, var1, var2, var3, var9.animationId, true, (Entity) null);
                        var25 = new Location(var4, 2, var29, var1, var2, var3, var9.animationId, true, (Entity) null);
                    }

                    var7.method3803(var0, var2, var3, var17, (Entity) var24, (Entity) var25, class98.field491[var5], class98.field491[var29], var20, var22);
                    if (var9.clipType != 0) {
                        var8.method197(var2, var3, var6, var5, var9.blocksProjectile);
                    }

                } else if (var6 == 3) {
                    if (var9.animationId == -1 && var9.multiLocs == null) {
                        var23 = var9.method1714(3, var5, var16, var18, var17, var19);
                    } else {
                        var23 = new Location(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Entity) null);
                    }

                    var7.method3803(var0, var2, var3, var17, (Entity) var23, (Entity) null, class98.field499[var5], 0, var20, var22);
                    if (var9.clipType != 0) {
                        var8.method197(var2, var3, var6, var5, var9.blocksProjectile);
                    }

                } else if (var6 == 9) {
                    if (var9.animationId == -1 && var9.multiLocs == null) {
                        var23 = var9.method1714(var6, var5, var16, var18, var17, var19);
                    } else {
                        var23 = new Location(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Entity) null);
                    }

                    var7.method3805(var0, var2, var3, var17, 1, 1, (Entity) var23, 0, var20, var22);
                    if (var9.clipType != 0) {
                        var8.method223(var2, var3, var10, var11, var9.blocksProjectile);
                    }

                } else if (var6 == 4) {
                    if (var9.animationId == -1 && var9.multiLocs == null) {
                        var23 = var9.method1714(4, var5, var16, var18, var17, var19);
                    } else {
                        var23 = new Location(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Entity) null);
                    }

                    var7.method3804(var0, var2, var3, var17, (Entity) var23, (Entity) null, class98.field491[var5], 0, 0, 0, var20, var22);
                } else {
                    Object var26;
                    long var30;
                    if (var6 == 5) {
                        var29 = 16;
                        var30 = var7.method3821(var0, var2, var3);
                        if (0L != var30) {
                            var29 = class225.method4485(SubInterface.method2437(var30)).decorDisplacement;
                        }

                        if (var9.animationId == -1 && var9.multiLocs == null) {
                            var26 = var9.method1714(4, var5, var16, var18, var17, var19);
                        } else {
                            var26 = new Location(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Entity) null);
                        }

                        var7.method3804(var0, var2, var3, var17, (Entity) var26, (Entity) null, class98.field491[var5], 0, var29 * class98.field497[var5], var29 * class98.field501[var5], var20, var22);
                    } else if (var6 == 6) {
                        var29 = 8;
                        var30 = var7.method3821(var0, var2, var3);
                        if (var30 != 0L) {
                            var29 = class225.method4485(SubInterface.method2437(var30)).decorDisplacement / 2;
                        }

                        if (var9.animationId == -1 && var9.multiLocs == null) {
                            var26 = var9.method1714(4, var5 + 4, var16, var18, var17, var19);
                        } else {
                            var26 = new Location(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Entity) null);
                        }

                        var7.method3804(var0, var2, var3, var17, (Entity) var26, (Entity) null, 256, var5, var29 * class98.field502[var5], var29 * class98.field507[var5], var20, var22);
                    } else if (var6 == 7) {
                        int var32 = var5 + 2 & 3;
                        if (var9.animationId == -1 && var9.multiLocs == null) {
                            var23 = var9.method1714(4, var32 + 4, var16, var18, var17, var19);
                        } else {
                            var23 = new Location(var4, 4, var32 + 4, var1, var2, var3, var9.animationId, true, (Entity) null);
                        }

                        var7.method3804(var0, var2, var3, var17, (Entity) var23, (Entity) null, 256, var32, 0, 0, var20, var22);
                    } else if (var6 == 8) {
                        var29 = 8;
                        var30 = var7.method3821(var0, var2, var3);
                        if (0L != var30) {
                            var29 = class225.method4485(SubInterface.method2437(var30)).decorDisplacement / 2;
                        }

                        int var28 = var5 + 2 & 3;
                        Object var27;
                        if (var9.animationId == -1 && var9.multiLocs == null) {
                            var26 = var9.method1714(4, var5 + 4, var16, var18, var17, var19);
                            var27 = var9.method1714(4, var28 + 4, var16, var18, var17, var19);
                        } else {
                            var26 = new Location(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Entity) null);
                            var27 = new Location(var4, 4, var28 + 4, var1, var2, var3, var9.animationId, true, (Entity) null);
                        }

                        var7.method3804(var0, var2, var3, var17, (Entity) var26, (Entity) var27, 256, var5, var29 * class98.field502[var5], var29 * class98.field507[var5], var20, var22);
                    }
                }
            }
        } else {
            if (var9.animationId == -1 && var9.multiLocs == null) {
                var23 = var9.method1714(10, var5, var16, var18, var17, var19);
            } else {
                var23 = new Location(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Entity) null);
            }

            if (var23 != null) {
                var7.method3805(var0, var2, var3, var17, var10, var11, (Entity) var23, var6 == 11 ? 256 : 0, var20, var22);
            }

            if (var9.clipType != 0) {
                var8.method223(var2, var3, var10, var11, var9.blocksProjectile);
            }

        }
    }
}
