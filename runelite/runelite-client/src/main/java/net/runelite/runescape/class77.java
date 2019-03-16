package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
public class class77 {
    @ObfuscatedName("nx")
    @ObfuscatedGetter(
            intValue = -102353155
    )
    static int field2817;

    @ObfuscatedName("gu")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "1086286921"
    )
    static boolean method1150() {
        return (client.playerNameMask & 8) != 0;
    }

    @ObfuscatedName("aj")
    @ObfuscatedSignature(
            signature = "([BI)[B",
            garbageValue = "1666660678"
    )
    static final byte[] method1151(byte[] var0) {
        Packet var1 = new Packet(var0);
        int var2 = var1.readUnsignedByte();
        int var3 = var1.getInt();
        if (var3 < 0 || Js5Index.field3223 != 0 && var3 > Js5Index.field3223) {
            throw new RuntimeException();
        } else if (var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.method6090(var4, 0, var3);
            return var4;
        } else {
            int var6 = var1.getInt();
            if (var6 < 0 || Js5Index.field3223 != 0 && var6 > Js5Index.field3223) {
                throw new RuntimeException();
            } else {
                byte[] var5 = new byte[var6];
                if (var2 == 1) {
                    class187.method3641(var5, var6, var0, var3, 9);
                } else {
                    Js5Index.gzip.method5445(var1, var5);
                }

                return var5;
            }
        }
    }

    @ObfuscatedName("hm")
    @ObfuscatedSignature(
            signature = "(IIIIIIIIII)V",
            garbageValue = "-1761911777"
    )
    static final void method1152(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        PendingSpawn var9 = null;

        for (PendingSpawn var10 = (PendingSpawn) client.pendingSpawns.method4373(); var10 != null; var10 = (PendingSpawn) client.pendingSpawns.method4358()) {
            if (var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
                var9 = var10;
                break;
            }
        }

        if (var9 == null) {
            var9 = new PendingSpawn();
            var9.level = var0;
            var9.type = var3;
            var9.x = var1;
            var9.y = var2;
            class2.method19(var9);
            client.pendingSpawns.method4351(var9);
        }

        var9.id = var4;
        var9.field931 = var5;
        var9.orientation = var6;
        var9.delay = var7;
        var9.hitpoints = var8;
    }
}
