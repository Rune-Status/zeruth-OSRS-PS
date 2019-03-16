package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("ParamType")
public class ParamType extends CacheableNode {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    static NodeCache paramTypeCache;
    @ObfuscatedName("l")
    boolean autoDisable;
    @ObfuscatedName("e")
    char type;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 1139172153
    )
    public int defaultInt;
    @ObfuscatedName("c")
    public String defaultStr;

    static {
        paramTypeCache = new NodeCache(64);
    }

    ParamType() {
        this.autoDisable = true;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1772411568"
    )
    void method4108() {
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "820419216"
    )
    void method4098(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method4101(var1, var2);
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;IB)V",
            garbageValue = "-28"
    )
    void method4101(Packet var1, int var2) {
        if (var2 == 1) {
            byte var4 = var1.method6240();
            int var5 = var4 & 255;
            if (var5 == 0) {
                throw new IllegalArgumentException("");
            }

            if (var5 >= 128 && var5 < 160) {
                char var6 = class50.cp1252AsciiExtension[var5 - 128];
                if (var6 == 0) {
                    var6 = '?';
                }

                var5 = var6;
            }

            char var3 = (char) var5;
            this.type = var3;
        } else if (var2 == 2) {
            this.defaultInt = var1.getInt();
        } else if (var2 == 4) {
            this.autoDisable = false;
        } else if (var2 == 5) {
            this.defaultStr = var1.readString();
        }

    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "-79"
    )
    public boolean method4102() {
        return this.type == 's';
    }
}
