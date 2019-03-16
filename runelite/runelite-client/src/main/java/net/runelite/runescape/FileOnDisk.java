package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFileOnDisk;

import java.io.*;

@ObfuscatedName("dn")
@Implements("FileOnDesk")
public final class FileOnDisk implements RSFileOnDisk {
    @ObfuscatedName("bk")
    static String field1496;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            longValue = -2899927704915069947L
    )
    long length;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            longValue = -8201542549901260881L
    )
    long position;
    @ObfuscatedName("g")
    RandomAccessFile file;

    public FileOnDisk(File var1, String var2, long var3) throws IOException {
        if (-1L == var3) {
            var3 = Long.MAX_VALUE;
        }

        if (var1.length() >= var3) {
            var1.delete();
        }

        this.file = new RandomAccessFile(var1, var2);
        this.length = var3;
        this.position = 0L;
        int var5 = this.file.read();
        if (var5 != -1 && !var2.equals("r")) {
            this.file.seek(0L);
            this.file.write(var5);
        }

        this.file.seek(0L);
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "([BIII)V",
            garbageValue = "-2029981604"
    )
    public final void method145(byte[] var1, int var2, int var3) throws IOException {
        if ((long) var3 + this.position > this.length) {
            this.file.seek(1L + this.length);
            this.file.write(1);
            throw new EOFException();
        } else {
            this.file.write(var1, var2, var3);
            this.position += (long) var3;
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1374671575"
    )
    public final void method146() throws IOException {
        this.method169(false);
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(ZI)V",
            garbageValue = "1408817423"
    )
    public final void method169(boolean var1) throws IOException {
        if (this.file != null) {
            if (var1) {
                try {
                    this.file.getFD().sync();
                } catch (SyncFailedException var3) {
                    ;
                }
            }

            this.file.close();
            this.file = null;
        }

    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)J",
            garbageValue = "-1043811706"
    )
    public final long method148() throws IOException {
        return this.file.length();
    }

    protected void finalize() throws Throwable {
        if (this.file != null) {
            System.out.println("");
            this.method146();
        }

    }

    public RandomAccessFile getFile() {
        return this.file;
    }

    public long getLength() {
        return this.length;
    }

    public long getPosition() {
        return this.position;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "([BIII)I",
            garbageValue = "376444320"
    )
    public final int method149(byte[] var1, int var2, int var3) throws IOException {
        int var4 = this.file.read(var1, var2, var3);
        if (var4 > 0) {
            this.position += (long) var4;
        }

        return var4;
    }

    @ObfuscatedName("g")
    final void method147(long var1) throws IOException {
        this.file.seek(var1);
        this.position = var1;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1059456455"
    )
    public static void method152() {
        try {
            class166.cacheDat.method2098();

            for (int var0 = 0; var0 < class166.archiveCount; ++var0) {
                class166.cacheIndex[var0].method2098();
            }

            class166.masterIndex.method2098();
            class166.uidDat.method2098();
        } catch (Exception var2) {
            ;
        }

    }
}
