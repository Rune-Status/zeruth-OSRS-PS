package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSBufferProvider;

@ObfuscatedName("ly")
@Implements("BufferProvider")
public abstract class BufferProvider implements RSBufferProvider {
    @ObfuscatedName("f")
    @ObfuscatedGetter(
            intValue = 96439049
    )
    static int field3863;
    @ObfuscatedName("e")
    public int[] pixels;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -608631809
    )
    public int width;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 1469094279
    )
    public int height;

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "1963091958"
    )
    public abstract void vmethod2955(int var1, int var2);

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IIIII)V",
            garbageValue = "-1234412621"
    )
    public abstract void vmethod2950(int var1, int var2, int var3, int var4);

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(S)V",
            garbageValue = "2504"
    )
    public final void method347() {
        Rasterizer2D.method440(this.pixels, this.width, this.height);
    }

    public int[] getPixels() {
        return this.pixels;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setRaster() {
        this.method347();
    }
}
