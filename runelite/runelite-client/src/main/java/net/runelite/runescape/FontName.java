package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
@Implements("FontName")
public class FontName {
    @ObfuscatedName("ln")
    @ObfuscatedGetter(
            intValue = 814290865
    )
    static int ifTargetMask;
    @ObfuscatedName("fn")
    @ObfuscatedSignature(
            signature = "Lkc;"
    )
    static Fonts fonts;
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Lkm;"
    )
    public static final FontName field3743;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lkm;"
    )
    public static final FontName FontName_plain12;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lkm;"
    )
    public static final FontName FontName_bold12;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lkm;"
    )
    public static final FontName field3741;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Lkm;"
    )
    public static final FontName field3742;
    @ObfuscatedName("d")
    static int[] floorMultiplier;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lkm;"
    )
    public static final FontName FontName_plain11;
    @ObfuscatedName("b")
    String field3748;

    static {
        FontName_plain11 = new FontName("p11_full");
        FontName_plain12 = new FontName("p12_full");
        FontName_bold12 = new FontName("b12_full");
        field3741 = new FontName("verdana_11pt_regular");
        field3742 = new FontName("verdana_13pt_regular");
        field3743 = new FontName("verdana_15pt_regular");
    }

    FontName(String var1) {
        this.field3748 = var1;
    }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "-46607763"
    )
    static int method1975(int var0) {
        return (int) Math.pow(2.0D, (double) (7.0F + (float) var0 / 256.0F));
    }

    @ObfuscatedName("az")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "1835436263"
    )
    static int method1974(int var0, class106 var1, boolean var2) {
        int var3;
        int var4;
        if (var0 == 4000) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = var4 + var3;
            return 1;
        } else if (var0 == 4001) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = var3 - var4;
            return 1;
        } else if (var0 == 4002) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = var3 * var4;
            return 1;
        } else if (var0 == 4003) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = var3 / var4;
            return 1;
        } else if (var0 == 4004) {
            var3 = class48.intStack[--class228.intStackSize];
            class48.intStack[++class228.intStackSize - 1] = (int) (Math.random() * (double) var3);
            return 1;
        } else if (var0 == 4005) {
            var3 = class48.intStack[--class228.intStackSize];
            class48.intStack[++class228.intStackSize - 1] = (int) (Math.random() * (double) (var3 + 1));
            return 1;
        } else if (var0 == 4006) {
            class228.intStackSize -= 5;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            int var5 = class48.intStack[class228.intStackSize + 2];
            int var6 = class48.intStack[class228.intStackSize + 3];
            int var7 = class48.intStack[class228.intStackSize + 4];
            class48.intStack[++class228.intStackSize - 1] = var3 + (var4 - var3) * (var7 - var5) / (var6 - var5);
            return 1;
        } else if (var0 == 4007) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = var3 + var4 * var3 / 100;
            return 1;
        } else if (var0 == 4008) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = var3 | 1 << var4;
            return 1;
        } else if (var0 == 4009) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = var3 & -1 - (1 << var4);
            return 1;
        } else if (var0 == 4010) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
            return 1;
        } else if (var0 == 4011) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = var3 % var4;
            return 1;
        } else if (var0 == 4012) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            if (var3 == 0) {
                class48.intStack[++class228.intStackSize - 1] = 0;
            } else {
                class48.intStack[++class228.intStackSize - 1] = (int) Math.pow((double) var3, (double) var4);
            }

            return 1;
        } else if (var0 == 4013) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            if (var3 == 0) {
                class48.intStack[++class228.intStackSize - 1] = 0;
                return 1;
            } else {
                switch (var4) {
                    case 0:
                        class48.intStack[++class228.intStackSize - 1] = Integer.MAX_VALUE;
                        break;
                    case 1:
                        class48.intStack[++class228.intStackSize - 1] = var3;
                        break;
                    case 2:
                        class48.intStack[++class228.intStackSize - 1] = (int) Math.sqrt((double) var3);
                        break;
                    case 3:
                        class48.intStack[++class228.intStackSize - 1] = (int) Math.cbrt((double) var3);
                        break;
                    case 4:
                        class48.intStack[++class228.intStackSize - 1] = (int) Math.sqrt(Math.sqrt((double) var3));
                        break;
                    default:
                        class48.intStack[++class228.intStackSize - 1] = (int) Math.pow((double) var3, 1.0D / (double) var4);
                }

                return 1;
            }
        } else if (var0 == 4014) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = var3 & var4;
            return 1;
        } else if (var0 == 4015) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = var3 | var4;
            return 1;
        } else if (var0 == 4018) {
            class228.intStackSize -= 3;
            long var9 = (long) class48.intStack[class228.intStackSize];
            long var11 = (long) class48.intStack[class228.intStackSize + 1];
            long var13 = (long) class48.intStack[class228.intStackSize + 2];
            class48.intStack[++class228.intStackSize - 1] = (int) (var9 * var13 / var11);
            return 1;
        } else {
            return 2;
        }
    }
}
