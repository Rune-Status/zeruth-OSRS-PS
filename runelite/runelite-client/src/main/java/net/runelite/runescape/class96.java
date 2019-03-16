package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class96 extends CacheableNode {
    @ObfuscatedName("ay")
    static String field2624;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 849885151
    )
    public final int field2621;
    @ObfuscatedName("e")
    public final int[] field2622;
    @ObfuscatedName("q")
    public final int[] field2623;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -825392219
    )
    public final int field2626;

    class96(int var1, int var2, int[] var3, int[] var4, int var5) {
        this.field2626 = var1;
        this.field2621 = var2;
        this.field2622 = var3;
        this.field2623 = var4;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(III)Z",
            garbageValue = "-738436135"
    )
    public boolean method1622(int var1, int var2) {
        if (var2 >= 0 && var2 < this.field2623.length) {
            int var3 = this.field2623[var2];
            if (var1 >= var3 && var1 <= var3 + this.field2622[var2]) {
                return true;
            }
        }

        return false;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lgl;Lgr;S)Lgr;",
            garbageValue = "-23839"
    )
    static final IterableHashTable method1621(Packet var0, IterableHashTable var1) {
        int var2 = var0.readUnsignedByte();
        int var3;
        if (var1 == null) {
            var3 = TotalQuantityComparator.method1181(var2);
            var1 = new IterableHashTable(var3);
        }

        for (var3 = 0; var3 < var2; ++var3) {
            boolean var4 = var0.readUnsignedByte() == 1;
            int var5 = var0.method6082();
            Object var6;
            if (var4) {
                var6 = new ObjectNode(var0.readString());
            } else {
                var6 = new IntegerNode(var0.getInt());
            }

            var1.method2749((Node) var6, (long) var5);
        }

        return var1;
    }
}
