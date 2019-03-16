package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
    @ObfuscatedName("y")
    static int[] field583;
    @ObfuscatedName("l")
    long[] field582;
    @ObfuscatedName("r")
    Object lock;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 2016846061
    )
    int index;
    @ObfuscatedName("q")
    int[] xs;
    @ObfuscatedName("c")
    int[] ys;
    @ObfuscatedName("g")
    boolean isRunning;

    MouseRecorder() {
        this.isRunning = true;
        this.lock = new Object();
        this.index = 0;
        this.xs = new int[500];
        this.ys = new int[500];
        this.field582 = new long[500];
    }

    public void run() {
        for (; this.isRunning; class182.method3129(50L)) {
            Object var1 = this.lock;
            synchronized (this.lock) {
                if (this.index < 500) {
                    this.xs[this.index] = MouseInput.mouseLastX;
                    this.ys[this.index] = MouseInput.mouseLastY * -976212263;
                    this.field582[this.index] = MouseInput.field472;
                    ++this.index;
                }
            }
        }

    }

    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            signature = "(Ldz;I)V",
            garbageValue = "1477606347"
    )
    static final void method2745(TaskDataNode var0) {
        var0.field1445 = false;
        if (var0.data != null) {
            var0.data.int1 = 0;
        }

        for (TaskDataNode var1 = var0.vmethod6454(); var1 != null; var1 = var0.vmethod6446()) {
            method2745(var1);
        }

    }

    @ObfuscatedName("ga")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;ZI)V",
            garbageValue = "1736315477"
    )
    static final void method2747(String var0, boolean var1) {
        if (client.field758) {
            byte var2 = 4;
            int var3 = var2 + 6;
            int var4 = var2 + 6;
            int var5 = TotalQuantityComparator.font_p12full.method1777(var0, 250);
            int var6 = TotalQuantityComparator.font_p12full.method1778(var0, 250) * 13;
            Rasterizer2D.method449(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
            Rasterizer2D.method518(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 16777215);
            TotalQuantityComparator.font_p12full.method1774(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
            int var7 = var3 - var2;
            int var8 = var4 - var2;
            int var9 = var2 + var5 + var2;
            int var10 = var2 + var6 + var2;

            for (int var11 = 0; var11 < client.widgetCount; ++var11) {
                if (client.widgetBoundsWidth[var11] + client.widgetPositionX[var11] > var7 && client.widgetPositionX[var11] < var9 + var7 && client.widgetBoundsHeight[var11] + client.widgetPositionY[var11] > var8 && client.widgetPositionY[var11] < var8 + var10) {
                    client.field848[var11] = true;
                }
            }

            if (var1) {
                WorldMapManager.rasterProvider.vmethod2955(0, 0);
            } else {
                class311.method5932(var3, var4, var5, var6);
            }

        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Liu;Liu;Liu;I)V",
            garbageValue = "-1827132090"
    )
    public static void method2746(Js5Index var0, Js5Index var1, Js5Index var2) {
        Sequence.seq_ref = var0;
        Sequence.skel_ref = var1;
        Sequence.skin_ref = var2;
    }
}
