package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSVarbit;

@ObfuscatedName("jk")
@Implements("Varbit")
public class Varbit extends CacheableNode implements RSVarbit {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache varbits;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            signature = "Lli;"
    )
    static IndexedSprite logoSprite;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index varbit_ref;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -231080719
    )
    public int configId;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 1286428493
    )
    public int leastSignificantBit;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 699245035
    )
    public int mostSignificantBit;

    static {
        varbits = new NodeCache(64);
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-1914491452"
    )
    void method3111(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method3115(var1, var2);
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "1853206793"
    )
    void method3115(Packet var1, int var2) {
        if (var2 == 1) {
            this.configId = var1.readUnsignedShort();
            this.leastSignificantBit = var1.readUnsignedByte();
            this.mostSignificantBit = var1.readUnsignedByte();
        }

    }

    public int getIndex() {
        return this.configId;
    }

    public int getLeastSignificantBit() {
        return this.leastSignificantBit;
    }

    public int getMostSignificantBit() {
        return this.mostSignificantBit;
    }
}
