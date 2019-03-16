package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("ITextureLoader")
public interface ITextureLoader {
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IB)[I",
            garbageValue = "40"
    )
    int[] vmethod5375(int var1);

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "1901823043"
    )
    int vmethod5363(int var1);

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IB)Z",
            garbageValue = "-59"
    )
    boolean vmethod5366(int var1);

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(II)Z",
            garbageValue = "844577854"
    )
    boolean vmethod5364(int var1);
}
