package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IIIB)Z",
            garbageValue = "-81"
    )
    boolean vmethod5812(int var1, int var2, int var3);

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IIB)Z",
            garbageValue = "79"
    )
    boolean vmethod5811(int var1, int var2);

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(IIII)[I",
            garbageValue = "-1381851995"
    )
    int[] vmethod5814(int var1, int var2, int var3);

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IIB)Lhz;",
            garbageValue = "-126"
    )
    Coordinates vmethod5817(int var1, int var2);

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-821481708"
    )
    void vmethod5829(Packet var1);

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lk;B)V",
            garbageValue = "-126"
    )
    void vmethod5820(WorldMapData var1);
}
