package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.EOFException;
import java.io.IOException;

@ObfuscatedName("fp")
@Implements("IndexFile")
public final class IndexFile {
    @ObfuscatedName("nn")
    @ObfuscatedSignature(
            signature = "Lft;"
    )
    static class81 mouseWheel;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 1205776559
    )
    static int field2073;
    @ObfuscatedName("fd")
    @ObfuscatedGetter(
            intValue = 100433815
    )
    static int field2075;
    @ObfuscatedName("g")
    static byte[] IndexStore_buffer;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Ldr;"
    )
    CacheFile dataFile;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Ldr;"
    )
    CacheFile indexFile;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -636059971
    )
    int index;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 1108350575
    )
    int maxSize;

    static {
        IndexStore_buffer = new byte[520];
    }

    @ObfuscatedSignature(
            signature = "(ILdr;Ldr;I)V"
    )
    public IndexFile(int var1, CacheFile var2, CacheFile var3, int var4) {
        this.dataFile = null;
        this.indexFile = null;
        this.maxSize = 65000;
        this.index = var1;
        this.dataFile = var2;
        this.indexFile = var3;
        this.maxSize = var4;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I[BIB)Z",
            garbageValue = "2"
    )
    public boolean method5675(int var1, byte[] var2, int var3) {
        CacheFile var4 = this.dataFile;
        synchronized (this.dataFile) {
            if (var3 >= 0 && var3 <= this.maxSize) {
                boolean var5 = this.method5676(var1, var2, var3, true);
                if (!var5) {
                    var5 = this.method5676(var1, var2, var3, false);
                }

                return var5;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I[BIZI)Z",
            garbageValue = "-1448378756"
    )
    boolean method5676(int var1, byte[] var2, int var3, boolean var4) {
        CacheFile var5 = this.dataFile;
        synchronized (this.dataFile) {
            try {
                int var6;
                boolean var10000;
                if (var4) {
                    if (this.indexFile.method2111() < (long) (var1 * 6 + 6)) {
                        var10000 = false;
                        return var10000;
                    }

                    this.indexFile.method2099((long) (var1 * 6));
                    this.indexFile.method2102(IndexStore_buffer, 0, 6);
                    var6 = (IndexStore_buffer[5] & 255) + ((IndexStore_buffer[3] & 255) << 16) + ((IndexStore_buffer[4] & 255) << 8);
                    if (var6 <= 0 || (long) var6 > this.dataFile.method2111() / 520L) {
                        var10000 = false;
                        return var10000;
                    }
                } else {
                    var6 = (int) ((this.dataFile.method2111() + 519L) / 520L);
                    if (var6 == 0) {
                        var6 = 1;
                    }
                }

                IndexStore_buffer[0] = (byte) (var3 >> 16);
                IndexStore_buffer[1] = (byte) (var3 >> 8);
                IndexStore_buffer[2] = (byte) var3;
                IndexStore_buffer[3] = (byte) (var6 >> 16);
                IndexStore_buffer[4] = (byte) (var6 >> 8);
                IndexStore_buffer[5] = (byte) var6;
                this.indexFile.method2099((long) (var1 * 6));
                this.indexFile.method2108(IndexStore_buffer, 0, 6);
                int var7 = 0;
                int var8 = 0;

                while (true) {
                    if (var7 < var3) {
                        label143:
                        {
                            int var9 = 0;
                            int var14;
                            if (var4) {
                                this.dataFile.method2099((long) (var6 * 520));

                                try {
                                    this.dataFile.method2102(IndexStore_buffer, 0, 8);
                                } catch (EOFException var16) {
                                    break label143;
                                }

                                var14 = (IndexStore_buffer[1] & 255) + ((IndexStore_buffer[0] & 255) << 8);
                                int var11 = (IndexStore_buffer[3] & 255) + ((IndexStore_buffer[2] & 255) << 8);
                                var9 = ((IndexStore_buffer[5] & 255) << 8) + ((IndexStore_buffer[4] & 255) << 16) + (IndexStore_buffer[6] & 255);
                                int var12 = IndexStore_buffer[7] & 255;
                                if (var14 != var1 || var8 != var11 || var12 != this.index) {
                                    var10000 = false;
                                    return var10000;
                                }

                                if (var9 < 0 || (long) var9 > this.dataFile.method2111() / 520L) {
                                    var10000 = false;
                                    return var10000;
                                }
                            }

                            if (var9 == 0) {
                                var4 = false;
                                var9 = (int) ((this.dataFile.method2111() + 519L) / 520L);
                                if (var9 == 0) {
                                    ++var9;
                                }

                                if (var6 == var9) {
                                    ++var9;
                                }
                            }

                            if (var3 - var7 <= 512) {
                                var9 = 0;
                            }

                            IndexStore_buffer[0] = (byte) (var1 >> 8);
                            IndexStore_buffer[1] = (byte) var1;
                            IndexStore_buffer[2] = (byte) (var8 >> 8);
                            IndexStore_buffer[3] = (byte) var8;
                            IndexStore_buffer[4] = (byte) (var9 >> 16);
                            IndexStore_buffer[5] = (byte) (var9 >> 8);
                            IndexStore_buffer[6] = (byte) var9;
                            IndexStore_buffer[7] = (byte) this.index;
                            this.dataFile.method2099((long) (var6 * 520));
                            this.dataFile.method2108(IndexStore_buffer, 0, 8);
                            var14 = var3 - var7;
                            if (var14 > 512) {
                                var14 = 512;
                            }

                            this.dataFile.method2108(var2, var7, var14);
                            var7 += var14;
                            var6 = var9;
                            ++var8;
                            continue;
                        }
                    }

                    var10000 = true;
                    return var10000;
                }
            } catch (IOException var17) {
                return false;
            }
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(II)[B",
            garbageValue = "-2075178153"
    )
    public byte[] method5680(int var1) {
        CacheFile var2 = this.dataFile;
        synchronized (this.dataFile) {
            try {
                Object var10000;
                if (this.indexFile.method2111() < (long) (var1 * 6 + 6)) {
                    var10000 = null;
                    return (byte[]) var10000;
                } else {
                    this.indexFile.method2099((long) (var1 * 6));
                    this.indexFile.method2102(IndexStore_buffer, 0, 6);
                    int var3 = ((IndexStore_buffer[0] & 255) << 16) + (IndexStore_buffer[2] & 255) + ((IndexStore_buffer[1] & 255) << 8);
                    int var4 = (IndexStore_buffer[5] & 255) + ((IndexStore_buffer[3] & 255) << 16) + ((IndexStore_buffer[4] & 255) << 8);
                    if (var3 < 0 || var3 > this.maxSize) {
                        var10000 = null;
                        return (byte[]) var10000;
                    } else if (var4 <= 0 || (long) var4 > this.dataFile.method2111() / 520L) {
                        var10000 = null;
                        return (byte[]) var10000;
                    } else {
                        byte[] var5 = new byte[var3];
                        int var6 = 0;
                        int var7 = 0;

                        while (var6 < var3) {
                            if (var4 == 0) {
                                var10000 = null;
                                return (byte[]) var10000;
                            }

                            this.dataFile.method2099((long) (var4 * 520));
                            int var8 = var3 - var6;
                            if (var8 > 512) {
                                var8 = 512;
                            }

                            this.dataFile.method2102(IndexStore_buffer, 0, var8 + 8);
                            int var9 = (IndexStore_buffer[1] & 255) + ((IndexStore_buffer[0] & 255) << 8);
                            int var10 = (IndexStore_buffer[3] & 255) + ((IndexStore_buffer[2] & 255) << 8);
                            int var11 = ((IndexStore_buffer[5] & 255) << 8) + ((IndexStore_buffer[4] & 255) << 16) + (IndexStore_buffer[6] & 255);
                            int var12 = IndexStore_buffer[7] & 255;
                            if (var9 == var1 && var10 == var7 && var12 == this.index) {
                                if (var11 >= 0 && (long) var11 <= this.dataFile.method2111() / 520L) {
                                    for (int var13 = 0; var13 < var8; ++var13) {
                                        var5[var6++] = IndexStore_buffer[var13 + 8];
                                    }

                                    var4 = var11;
                                    ++var7;
                                    continue;
                                }

                                var10000 = null;
                                return (byte[]) var10000;
                            }

                            var10000 = null;
                            return (byte[]) var10000;
                        }

                        byte[] var18 = var5;
                        return var18;
                    }
                }
            } catch (IOException var16) {
                return null;
            }
        }
    }
}
