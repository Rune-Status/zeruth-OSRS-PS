package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("ModeWhere")
public class ModeWhere {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lin;"
    )
    static final ModeWhere BUILDLIVE;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lin;"
    )
    static final ModeWhere RC;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lin;"
    )
    static final ModeWhere WIP;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lin;"
    )
    static final ModeWhere LIVE;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -232062523
    )
    final int field3197;
    @ObfuscatedName("c")
    public final String identifier;

    static {
        LIVE = new ModeWhere("LIVE", 0);
        BUILDLIVE = new ModeWhere("BUILDLIVE", 3);
        RC = new ModeWhere("RC", 1);
        WIP = new ModeWhere("WIP", 2);
    }

    ModeWhere(String var1, int var2) {
        this.identifier = var1;
        this.field3197 = var2;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Liu;I)V",
            garbageValue = "-1712592106"
    )
    public static void method2940(Js5Index var0) {
        VarClientStringType.field3340 = var0;
    }
}
