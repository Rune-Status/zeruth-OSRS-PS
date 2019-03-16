package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;

@ObfuscatedName("l")
@Implements("UnitPriceComparator")
final class UnitPriceComparator implements Comparator {
    public int compare(Object var1, Object var2) {
        return this.method539((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Le;Le;B)I",
            garbageValue = "117"
    )
    int method539(GrandExchangeEvent var1, GrandExchangeEvent var2) {
        return var1.grandExchangeOffer.price < var2.grandExchangeOffer.price ? -1 : (var2.grandExchangeOffer.price == var1.grandExchangeOffer.price ? 0 : 1);
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(IIIIIIII)Z",
            garbageValue = "2110516595"
    )
    static final boolean method547(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        int var7 = class195.Viewport_mouseY + var6;
        if (var7 < var0 && var7 < var1 && var7 < var2) {
            return false;
        } else {
            var7 = class195.Viewport_mouseY - var6;
            if (var7 > var0 && var7 > var1 && var7 > var2) {
                return false;
            } else {
                var7 = class195.Viewport_mouseX + var6;
                if (var7 < var3 && var7 < var4 && var7 < var5) {
                    return false;
                } else {
                    var7 = class195.Viewport_mouseX - var6;
                    return var7 <= var3 || var7 <= var4 || var7 <= var5;
                }
            }
        }
    }
}
