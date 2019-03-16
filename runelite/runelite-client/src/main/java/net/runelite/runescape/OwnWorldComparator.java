package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;

@ObfuscatedName("bb")
@Implements("OwnWorldComparator")
public class OwnWorldComparator implements Comparator {
    @ObfuscatedName("an")
    static int[] field640;
    @ObfuscatedName("g")
    boolean field636;

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    public int compare(Object var1, Object var2) {
        return this.method522((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Le;Le;B)I",
            garbageValue = "-31"
    )
    int method522(GrandExchangeEvent var1, GrandExchangeEvent var2) {
        if (var2.world == var1.world) {
            return 0;
        } else {
            if (this.field636) {
                if (client.world == var1.world) {
                    return -1;
                }

                if (var2.world == client.world) {
                    return 1;
                }
            }

            return var1.world < var2.world ? -1 : 1;
        }
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1078004710"
    )
    static void method532() {
        class254.highResolutionPlayerCount = 0;

        for (int var0 = 0; var0 < 2048; ++var0) {
            class254.appearances[var0] = null;
            class254.moveSpeeds[var0] = 1;
        }

    }

    @ObfuscatedName("hz")
    @ObfuscatedSignature(
            signature = "(IIIIB)V",
            garbageValue = "-85"
    )
    static void method531(int var0, int var1, int var2, int var3) {
        ComponentType var4 = class192.method3785(var0, var1);
        if (var4 != null && var4.onTargetEnterListener != null) {
            ScriptEvent var5 = new ScriptEvent();
            var5.source = var4;
            var5.params = var4.onTargetEnterListener;
            class73.method1124(var5);
        }

        client.field734 = var3;
        client.spellSelected = true;
        class174.field3796 = var0;
        client.field799 = var1;
        FontName.ifTargetMask = var2;
        class208.method4144(var4);
    }
}
