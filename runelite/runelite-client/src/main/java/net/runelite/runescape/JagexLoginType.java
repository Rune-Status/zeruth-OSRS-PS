package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSJagexLoginType;

@ObfuscatedName("lq")
@Implements("JagexLoginType")
public class JagexLoginType implements RSJagexLoginType {
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    static final JagexLoginType field4005;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    static final JagexLoginType field4008;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    static final JagexLoginType field4003;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    static final JagexLoginType field4007;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    static final JagexLoginType field4000;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    static final JagexLoginType field4006;
    @ObfuscatedName("n")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    public static final JagexLoginType field4009;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    static final JagexLoginType field4004;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    public static final JagexLoginType field4002;
    @ObfuscatedName("p")
    final String identifier;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = -1703950111
    )
    public final int field4001;

    static {
        field4002 = new JagexLoginType(0, 0, "", "");
        field4008 = new JagexLoginType(8, 1, "", "");
        field4003 = new JagexLoginType(5, 2, "", "");
        field4000 = new JagexLoginType(2, 3, "", "");
        field4004 = new JagexLoginType(6, 4, "", "");
        field4005 = new JagexLoginType(3, 5, "", "");
        field4006 = new JagexLoginType(4, 6, "", "");
        field4007 = new JagexLoginType(7, 7, "", "");
        field4009 = new JagexLoginType(1, -1, "", "", true, new JagexLoginType[]{field4002, field4008, field4003, field4004, field4000});
    }

    JagexLoginType(int var1, int var2, String var3, String var4) {
        this.field4001 = var1;
        this.identifier = var4;
    }

    @ObfuscatedSignature(
            signature = "(IILjava/lang/String;Ljava/lang/String;Z[Llq;)V"
    )
    JagexLoginType(int var1, int var2, String var3, String var4, boolean var5, JagexLoginType[] var6) {
        this.field4001 = var1;
        this.identifier = var4;
    }

    public String toString() {
        return this.identifier;
    }
}
