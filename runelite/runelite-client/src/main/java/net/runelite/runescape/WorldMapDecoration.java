package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
    @ObfuscatedName("dn")
    @ObfuscatedSignature(
            signature = "Lih;"
    )
    static Js5 anims;
    @ObfuscatedName("ae")
    static int[] field183;
    @ObfuscatedName("q")
    static byte[][][] tileUnderlayIds;
    @ObfuscatedName("aw")
    static int[] field182;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -1425596791
    )
    static int field189;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -1705638817
    )
    final int decoration;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1838408627
    )
    final int rotation;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -939821209
    )
    final int objectDefinitionId;

    WorldMapDecoration(int var1, int var2, int var3) {
        this.objectDefinitionId = var1;
        this.decoration = var2;
        this.rotation = var3;
    }

    @ObfuscatedName("r")
    public static boolean method2946(long var0) {
        boolean var2 = 0L != var0;
        if (var2) {
            boolean var3 = (int) (var0 >>> 16 & 1L) == 1;
            var2 = !var3;
        }

        return var2;
    }

    @ObfuscatedName("ja")
    @ObfuscatedSignature(
            signature = "(II)Z",
            garbageValue = "67572877"
    )
    static boolean method2944(int var0) {
        for (int var1 = 0; var1 < client.field865; ++var1) {
            if (client.field867[var1] == var0) {
                return true;
            }
        }

        return false;
    }

    @ObfuscatedName("fp")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-904767418"
    )
    static final void method2943() {
        if (client.field725 > 0) {
            class9.method133();
        } else {
            client.field904.method2490();
            class310.method5922(40);
            class60.field524 = client.serverConnection.method5880();
            client.serverConnection.method5879();
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(II)Ljava/lang/String;",
            garbageValue = "703327785"
    )
    static String method2945(int var0) {
        return "<img=" + var0 + ">";
    }
}
