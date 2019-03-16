package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("VarClientStringType")
public class VarClientStringType extends CacheableNode {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    static NodeCache field3339;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index field3340;
    @ObfuscatedName("e")
    public boolean serialize;

    static {
        field3339 = new NodeCache(64);
    }

    VarClientStringType() {
        this.serialize = false;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "2012780847"
    )
    void method177(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method175(var1, var2);
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "-1388161728"
    )
    void method175(Packet var1, int var2) {
        if (var2 == 2) {
            this.serialize = true;
        }

    }

    @ObfuscatedName("ir")
    @ObfuscatedSignature(
            signature = "(II)Z",
            garbageValue = "-85178759"
    )
    static boolean method184(int var0) {
        return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
    }
}
