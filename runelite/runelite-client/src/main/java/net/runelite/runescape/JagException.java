package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSRunException;

import java.applet.Applet;

@ObfuscatedName("ef")
@Implements("JagException")
public class JagException extends RuntimeException implements RSRunException {
    @ObfuscatedName("r")
    public static String localPlayerUsername;
    @ObfuscatedName("dw")
    @ObfuscatedSignature(
            signature = "Lih;"
    )
    static Js5 sprites;
    @ObfuscatedName("g")
    public static Applet field1999;
    @ObfuscatedName("l")
    Throwable parent;
    @ObfuscatedName("c")
    String field2001;

    JagException(Throwable var1, String var2) {
        this.field2001 = var2;
        this.parent = var1;
    }

    public Throwable getParent() {
        return this.parent;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IIB)I",
            garbageValue = "45"
    )
    static int method855(int var0, int var1) {
        long var2 = (long) ((var0 << 16) + var1);
        return class267.currentRequest != null && var2 == class267.currentRequest.hash ? class258.NetCache_responseArchiveBuffer.offset * 99 / (class258.NetCache_responseArchiveBuffer.payload.length - class267.currentRequest.padding) + 1 : 0;
    }
}
