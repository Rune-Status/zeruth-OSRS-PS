package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.nio.ByteBuffer;

@ObfuscatedName("gc")
@Implements("gc")
public class DirectByteBuffer extends AbstractByteBuffer {
    @ObfuscatedName("g")
    ByteBuffer buffer;

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "([BI)V",
            garbageValue = "-2095923979"
    )
    void vmethod5416(byte[] var1) {
        this.buffer = ByteBuffer.allocateDirect(var1.length);
        this.buffer.position(0);
        this.buffer.put(var1);
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(S)[B",
            garbageValue = "1376"
    )
    byte[] vmethod5407() {
        byte[] var1 = new byte[this.buffer.capacity()];
        this.buffer.position(0);
        this.buffer.get(var1);
        return var1;
    }
}
