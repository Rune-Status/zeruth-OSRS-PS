package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dk")
@Implements("Mapping")
public class Mapping {
    @ObfuscatedName("r")
    int mux;
    @ObfuscatedName("e")
    int[] submapFloors;
    @ObfuscatedName("q")
    int[] field1446;
    @ObfuscatedName("g")
    int field1447;

    Mapping() {
        class237.method4588(16);
        this.field1447 = class237.method4603() != 0 ? class237.method4588(4) + 1 : 1;
        if (class237.method4603() != 0) {
            class237.method4588(8);
        }

        class237.method4588(2);
        if (this.field1447 > 1) {
            this.mux = class237.method4588(4);
        }

        this.submapFloors = new int[this.field1447];
        this.field1446 = new int[this.field1447];

        for (int var1 = 0; var1 < this.field1447; ++var1) {
            class237.method4588(8);
            this.submapFloors[var1] = class237.method4588(8);
            this.field1446[var1] = class237.method4588(8);
        }

    }
}
