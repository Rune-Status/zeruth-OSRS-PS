package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@ObfuscatedName("aj")
public class class124 extends WorldMapData {
    @ObfuscatedName("sj")
    static short[] field325;
    @ObfuscatedName("x")
    List field326;
    @ObfuscatedName("d")
    HashSet field327;
    @ObfuscatedName("j")
    HashSet field324;

    @ObfuscatedName("bt")
    @ObfuscatedSignature(
            signature = "(Lgl;Lgl;Lgl;IZI)V",
            garbageValue = "674403176"
    )
    void method2088(Packet var1, Packet var2, Packet var3, int var4, boolean var5) {
        this.method999(var1, var4);
        int var6 = var3.readUnsignedShort();
        this.field327 = new HashSet(var6);

        int var7;
        for (var7 = 0; var7 < var6; ++var7) {
            class113 var8 = new class113();

            try {
                var8.method1961(var2, var3);
            } catch (IllegalStateException var13) {
                continue;
            }

            this.field327.add(var8);
        }

        var7 = var3.readUnsignedShort();
        this.field324 = new HashSet(var7);

        for (int var11 = 0; var11 < var7; ++var11) {
            class115 var9 = new class115();

            try {
                var9.method1990(var2, var3);
            } catch (IllegalStateException var12) {
                continue;
            }

            this.field324.add(var9);
        }

        this.method2089(var2, var5);
    }

    @ObfuscatedName("cb")
    @ObfuscatedSignature(
            signature = "(Lgl;ZB)V",
            garbageValue = "101"
    )
    void method2089(Packet var1, boolean var2) {
        this.field326 = new LinkedList();
        int var3 = var1.readUnsignedShort();

        for (int var4 = 0; var4 < var3; ++var4) {
            int var5 = var1.method6207();
            Coordinates var6 = new Coordinates(var1.getInt());
            boolean var7 = var1.readUnsignedByte() == 1;
            if (var2 || !var7) {
                this.field326.add(new class260(var5, var6));
            }
        }

    }

    @ObfuscatedName("gv")
    @ObfuscatedSignature(
            signature = "(Lbc;II)V",
            garbageValue = "1751819809"
    )
    static final void method2092(PathingEntity var0, int var1) {
        class166.method2813(var0.x, var0.y, var1);
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(IZI)Ljava/lang/String;",
            garbageValue = "-1872629249"
    )
    public static String method2096(int var0, boolean var1) {
        if (var1 && var0 >= 0) {
            int var3 = var0;
            String var2;
            if (var1 && var0 >= 0) {
                int var4 = 2;

                for (int var5 = var0 / 10; var5 != 0; ++var4) {
                    var5 /= 10;
                }

                char[] var6 = new char[var4];
                var6[0] = '+';

                for (int var7 = var4 - 1; var7 > 0; --var7) {
                    int var8 = var3;
                    var3 /= 10;
                    int var9 = var8 - var3 * 10;
                    if (var9 >= 10) {
                        var6[var7] = (char) (var9 + 87);
                    } else {
                        var6[var7] = (char) (var9 + 48);
                    }
                }

                var2 = new String(var6);
            } else {
                var2 = Integer.toString(var0, 10);
            }

            return var2;
        } else {
            return Integer.toString(var0);
        }
    }

    @ObfuscatedName("jf")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "1672310506"
    )
    static final void method2087(int var0, int var1) {
        if (class232.method4564(var0)) {
            WorldMapRegion.method4145(class36.interfaces[var0], var1);
        }
    }
}
