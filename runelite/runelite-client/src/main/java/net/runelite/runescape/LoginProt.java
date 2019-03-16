package net.runelite.runescape;

import net.runelite.mapping.*;

@ObfuscatedName("fs")
@Implements("LoginProt")
public class LoginProt implements class102 {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lfs;"
    )
    static final LoginProt field2310;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lfs;"
    )
    public static final LoginProt field2311;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lfs;"
    )
    public static final LoginProt field2312;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "[Lfs;"
    )
    static final LoginProt[] field2309;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Lfs;"
    )
    static final LoginProt field2315;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lfs;"
    )
    public static final LoginProt field2313;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 145610607
    )
    @Export("id")
    public final int id;

    static {
        field2313 = new LoginProt(14, 0);
        field2310 = new LoginProt(15, 4);
        field2311 = new LoginProt(16, -2);
        field2312 = new LoginProt(18, -2);
        field2315 = new LoginProt(27, 0);
        field2309 = new LoginProt[32];
        LoginProt[] var0 = class116.method2010();

        for (int var1 = 0; var1 < var0.length; ++var1) {
            field2309[var0[var1].id] = var0[var1];
        }

    }

    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "0"
    )
    LoginProt(int var1, int var2) {
        this.id = var1;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/CharSequence;I)I",
            garbageValue = "-2035507757"
    )
    public static int method871(CharSequence var0) {
        return class139.method2417(var0, 10, true);
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IB)Z",
            garbageValue = "8"
    )
    public static boolean method870(int var0) {
        return (var0 >> 30 & 1) != 0;
    }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)V",
            garbageValue = "681449749"
    )
    static final void method872(String var0) {
        class115.method2002(var0 + " is already on your ignore list");
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)[Lin;",
            garbageValue = "199242530"
    )
    static ModeWhere[] method866() {
        return new ModeWhere[]{ModeWhere.RC, ModeWhere.BUILDLIVE, ModeWhere.WIP, ModeWhere.LIVE};
    }
}
