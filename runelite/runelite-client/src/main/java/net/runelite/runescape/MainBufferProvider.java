package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMainBufferProvider;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.util.Hashtable;

@ObfuscatedName("ay")
@Implements("MainBufferProvider")
public final class MainBufferProvider extends BufferProvider implements RSMainBufferProvider {
    @ObfuscatedName("r")
    Image image;
    @ObfuscatedName("g")
    Component field424;

    MainBufferProvider(int var1, int var2, Component var3) {
        super.width = var1;
        super.height = var2;
        super.pixels = new int[var2 * var1 + 1];
        DataBufferInt var4 = new DataBufferInt(super.pixels, super.pixels.length);
        DirectColorModel var5 = new DirectColorModel(32, 16711680, 65280, 255);
        WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.width, super.height), var4, (Point) null);
        this.image = new BufferedImage(var5, var6, false, new Hashtable());
        this.method2948(var3);
        this.method347();
        this.init(var1, var2, var3);
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "1963091958"
    )
    public final void vmethod2955(int var1, int var2) {
        this.method2951(this.field424.getGraphics(), var1, var2);
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IIIII)V",
            garbageValue = "-1234412621"
    )
    public final void vmethod2950(int var1, int var2, int var3, int var4) {
        this.method2952(this.field424.getGraphics(), var1, var2, var3, var4);
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Ljava/awt/Graphics;IIB)V",
            garbageValue = "0"
    )
    final void method2951(Graphics var1, int var2, int var3) {
        class166.clientInstance.getCallbacks().draw(this, var1, var2, var3);
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(Ljava/awt/Graphics;IIIII)V",
            garbageValue = "-53139195"
    )
    final void method2952(Graphics var1, int var2, int var3, int var4, int var5) {
        try {
            Shape var6 = var1.getClip();
            var1.clipRect(var2, var3, var4, var5);
            var1.drawImage(this.image, 0, 0, this.field424);
            var1.setClip(var6);
        } catch (Exception var7) {
            this.field424.repaint();
        }

    }

    public void setImage(Image var1) {
        this.image = var1;
    }

    public void init(int var1, int var2, Component var3) {
        if (class166.clientInstance.isGpu()) {
            int[] var4 = this.getPixels();
            DataBufferInt var5 = new DataBufferInt(var4, var4.length);
            DirectColorModel var6 = new DirectColorModel(ColorSpace.getInstance(1000), 32, 16711680, 65280, 255, -16777216, true, 3);
            WritableRaster var7 = Raster.createWritableRaster(var6.createCompatibleSampleModel(var1, var2), var5, (Point) null);
            BufferedImage var8 = new BufferedImage(var6, var7, true, new Hashtable());
            this.setImage(var8);
        }
    }

    public Component getCanvas() {
        return this.field424;
    }

    public Image getImage() {
        return this.image;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Ljava/awt/Component;B)V",
            garbageValue = "-29"
    )
    final void method2948(Component var1) {
        this.field424 = var1;
    }
}
