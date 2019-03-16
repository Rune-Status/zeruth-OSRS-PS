package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSCombatInfo2;
import net.runelite.rs.api.RSCombatInfoList;
import net.runelite.rs.api.RSCombatInfoListHolder;

@ObfuscatedName("bd")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node implements RSCombatInfoListHolder {
    @ObfuscatedName("gx")
    @ObfuscatedGetter(
            intValue = -1673024611
    )
    static int updateZoneY;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Ljf;"
    )
    HeadbarType headbar;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgb;"
    )
    CombatInfoList combatInfo1;

    @ObfuscatedSignature(
            signature = "(Ljf;)V"
    )
    CombatInfoListHolder(HeadbarType var1) {
        this.combatInfo1 = new CombatInfoList();
        this.headbar = var1;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)Lbg;",
            garbageValue = "2056257489"
    )
    CombatInfo1 method1493(int var1) {
        CombatInfo1 var2 = (CombatInfo1) this.combatInfo1.method4329();
        if (var2 != null && var2.cycle <= var1) {
            for (CombatInfo1 var3 = (CombatInfo1) this.combatInfo1.method4327(); var3 != null && var3.cycle <= var1; var3 = (CombatInfo1) this.combatInfo1.method4327()) {
                var2.method6469();
                var2 = var3;
            }

            if (this.headbar.field3387 + var2.int2 + var2.cycle > var1) {
                return var2;
            } else {
                var2.method6469();
                return null;
            }
        } else {
            return null;
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1640004367"
    )
    boolean method1498() {
        return this.combatInfo1.method4328();
    }

    public RSCombatInfo2 getCombatInfo2() {
        return this.headbar;
    }

    public RSCombatInfoList getCombatInfo1() {
        return this.combatInfo1;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(IIIII)V",
            garbageValue = "-112883502"
    )
    void method1492(int var1, int var2, int var3, int var4) {
        CombatInfo1 var5 = null;
        int var6 = 0;

        for (CombatInfo1 var7 = (CombatInfo1) this.combatInfo1.method4329(); var7 != null; var7 = (CombatInfo1) this.combatInfo1.method4327()) {
            ++var6;
            if (var7.cycle == var1) {
                var7.method1155(var1, var2, var3, var4);
                return;
            }

            if (var7.cycle <= var1) {
                var5 = var7;
            }
        }

        if (var5 == null) {
            if (var6 < 4) {
                this.combatInfo1.method4325(new CombatInfo1(var1, var2, var3, var4));
            }

        } else {
            CombatInfoList.method4324(new CombatInfo1(var1, var2, var3, var4), var5);
            if (var6 >= 4) {
                this.combatInfo1.method4329().method6469();
            }

        }
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Liu;Ljava/lang/String;Ljava/lang/String;IZI)V",
            garbageValue = "124316333"
    )
    public static void method1500(Js5Index var0, String var1, String var2, int var3, boolean var4) {
        int var5 = var0.method1510(var1);
        int var6 = var0.method1532(var5, var2);
        class139.method2413(var0, var5, var6, var3, var4);
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(IIB)I",
            garbageValue = "92"
    )
    static final int method1491(int var0, int var1) {
        int var2 = var0 + var1 * 57;
        var2 ^= var2 << 13;
        int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
        return var3 >> 19 & 255;
    }
}
