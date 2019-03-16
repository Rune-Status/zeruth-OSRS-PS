package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.zip.Inflater;

@ObfuscatedName("fo")
@Implements("GZipDecompressor")
public class GZipDecompressor {
    @ObfuscatedName("g")
    Inflater inflator;

    public GZipDecompressor() {
        this(-1, 1000000, 1000000);
    }

    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "1000000"
    )
    GZipDecompressor(int var1, int var2, int var3) {
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lgl;[BB)V",
            garbageValue = "4"
    )
    public void method5445(Packet var1, byte[] var2) {
        if (var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
            if (this.inflator == null) {
                this.inflator = new Inflater(true);
            }

            try {
                this.inflator.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 8 + 10));
                this.inflator.inflate(var2);
            } catch (Exception var4) {
                this.inflator.reset();
                throw new RuntimeException("");
            }

            this.inflator.reset();
        } else {
            throw new RuntimeException("");
        }
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "-366823646"
    )
    static final int method5450(int var0, int var1) {
        int var2 = CombatInfoListHolder.method1491(var0 - 1, var1 - 1) + CombatInfoListHolder.method1491(1 + var0, var1 - 1) + CombatInfoListHolder.method1491(var0 - 1, var1 + 1) + CombatInfoListHolder.method1491(1 + var0, 1 + var1);
        int var3 = CombatInfoListHolder.method1491(var0 - 1, var1) + CombatInfoListHolder.method1491(var0 + 1, var1) + CombatInfoListHolder.method1491(var0, var1 - 1) + CombatInfoListHolder.method1491(var0, 1 + var1);
        int var4 = CombatInfoListHolder.method1491(var0, var1);
        return var2 / 16 + var3 / 8 + var4 / 4;
    }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "842306733"
    )
    static int method5447(int var0, class106 var1, boolean var2) {
        ComponentType var3 = WorldMapType1.method2440(class48.intStack[--class228.intStackSize]);
        if (var0 == 2500) {
            class48.intStack[++class228.intStackSize - 1] = var3.x;
            return 1;
        } else if (var0 == 2501) {
            class48.intStack[++class228.intStackSize - 1] = var3.y;
            return 1;
        } else if (var0 == 2502) {
            class48.intStack[++class228.intStackSize - 1] = var3.width;
            return 1;
        } else if (var0 == 2503) {
            class48.intStack[++class228.intStackSize - 1] = var3.height;
            return 1;
        } else if (var0 == 2504) {
            class48.intStack[++class228.intStackSize - 1] = var3.isHidden ? 1 : 0;
            return 1;
        } else if (var0 == 2505) {
            class48.intStack[++class228.intStackSize - 1] = var3.layer;
            return 1;
        } else {
            return 2;
        }
    }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-450458343"
    )
    protected static int method5443() {
        int var0 = 0;
        if (TotalQuantityComparator.field24 == null || !TotalQuantityComparator.field24.isValid()) {
            try {
                Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                while (var1.hasNext()) {
                    GarbageCollectorMXBean var2 = (GarbageCollectorMXBean) var1.next();
                    if (var2.isValid()) {
                        TotalQuantityComparator.field24 = var2;
                        GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                        GameEngine.garbageCollectorLastCollectionTime = -1L;
                    }
                }
            } catch (Throwable var11) {
                ;
            }
        }

        if (TotalQuantityComparator.field24 != null) {
            long var9 = Tile.method4297();
            long var3 = TotalQuantityComparator.field24.getCollectionTime();
            if (GameEngine.garbageCollectorLastCollectionTime != -1L) {
                long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
                long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
                if (var7 != 0L) {
                    var0 = (int) (100L * var5 / var7);
                }
            }

            GameEngine.garbageCollectorLastCollectionTime = var3;
            GameEngine.garbageCollectorLastCheckTimeMs = var9;
        }

        return var0;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "([Ljava/lang/String;[SIII)V",
            garbageValue = "1917868403"
    )
    public static void method5444(String[] var0, short[] var1, int var2, int var3) {
        if (var2 < var3) {
            int var4 = (var3 + var2) / 2;
            int var5 = var2;
            String var6 = var0[var4];
            var0[var4] = var0[var3];
            var0[var3] = var6;
            short var7 = var1[var4];
            var1[var4] = var1[var3];
            var1[var3] = var7;

            for (int var8 = var2; var8 < var3; ++var8) {
                if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
                    String var9 = var0[var8];
                    var0[var8] = var0[var5];
                    var0[var5] = var9;
                    short var10 = var1[var8];
                    var1[var8] = var1[var5];
                    var1[var5++] = var10;
                }
            }

            var0[var3] = var0[var5];
            var0[var5] = var6;
            var1[var3] = var1[var5];
            var1[var5] = var7;
            method5444(var0, var1, var2, var5 - 1);
            method5444(var0, var1, var5 + 1, var3);
        }

    }
}
