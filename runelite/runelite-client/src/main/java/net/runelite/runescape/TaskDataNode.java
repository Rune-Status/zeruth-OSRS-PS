package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("TaskDataNode")
public abstract class TaskDataNode extends Node {
    @ObfuscatedName("f")
    int field1443;
    @ObfuscatedName("w")
    volatile boolean field1445;
    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "Ldj;"
    )
    AbstractIntegerNode0 data;
    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "Ldz;"
    )
    TaskDataNode field1444;

    protected TaskDataNode() {
        this.field1445 = true;
    }

    @ObfuscatedName("x")
    protected abstract void vmethod6450(int var1);

    @ObfuscatedName("m")
    protected abstract int vmethod6465();

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "()Ldz;"
    )
    protected abstract TaskDataNode vmethod6446();

    @ObfuscatedName("av")
    int vmethod6455() {
        return 255;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "()Ldz;"
    )
    protected abstract TaskDataNode vmethod6454();

    @ObfuscatedName("d")
    protected abstract void vmethod6449(int[] var1, int var2, int var3);

    @ObfuscatedName("fc")
    final void method6448(int[] var1, int var2, int var3) {
        if (this.field1445) {
            this.vmethod6449(var1, var2, var3);
        } else {
            this.vmethod6450(var3);
        }

    }
}
