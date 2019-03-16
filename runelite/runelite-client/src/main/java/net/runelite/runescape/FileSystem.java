package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("FileSystem")
public class FileSystem extends Node {
    @ObfuscatedName("r")
    byte[] field3212;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lfp;"
    )
    IndexFile index;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lih;"
    )
    Js5 data;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -853721713
    )
    int type;

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
            garbageValue = "57"
    )
    public static String method5641(CharSequence var0) {
        int var2 = var0.length();
        char[] var3 = new char[var2];

        for (int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = '*';
        }

        String var1 = new String(var3);
        return var1;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(B)[Liz;",
            garbageValue = "-99"
    )
    public static ModeGame[] method5639() {
        return new ModeGame[]{ModeGame.STELLARDAWN, ModeGame.RUNESCAPE, ModeGame.GAME4, ModeGame.OLDSCAPE, ModeGame.GAME3, ModeGame.GAME5};
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "102"
    )
    public static void method5640() {
        class186.classInfos = new CombatInfoList();
    }
}
