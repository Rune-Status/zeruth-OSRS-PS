package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;
import java.io.RandomAccessFile;

@ObfuscatedName("ga")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
    @ObfuscatedName("r")
    static boolean directBufferUnavailable;
    @ObfuscatedName("en")
    @ObfuscatedGetter(
            intValue = -1363473765
    )
    static int field2438;

    static {
        directBufferUnavailable = false;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "([BI)V",
            garbageValue = "-2095923979"
    )
    abstract void vmethod5416(byte[] var1);

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(S)[B",
            garbageValue = "1376"
    )
    abstract byte[] vmethod5407();

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Ljava/io/File;ZI)Z",
            garbageValue = "-2018829811"
    )
    static boolean method5408(File var0, boolean var1) {
        try {
            RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
            int var3 = var2.read();
            var2.seek(0L);
            var2.write(var3);
            var2.seek(0L);
            var2.close();
            if (var1) {
                var0.delete();
            }

            return true;
        } catch (Exception var4) {
            return false;
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(II)Z",
            garbageValue = "2097154651"
    )
    public static boolean method5420(int var0) {
        return var0 >= WorldMapDecorationType.field2838.rsOrdinal && var0 <= WorldMapDecorationType.field2820.rsOrdinal;
    }
}
