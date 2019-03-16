package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class319 {
    @ObfuscatedName("i")
    static final byte[] field2594;
    @ObfuscatedName("l")
    int[] field2592;
    @ObfuscatedName("r")
    int field2588;
    @ObfuscatedName("e")
    int[] field2589;
    @ObfuscatedName("q")
    int[] field2590;
    @ObfuscatedName("b")
    int field2593;
    @ObfuscatedName("n")
    long field2595;
    @ObfuscatedName("c")
    int[] field2591;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lgl;"
    )
    Packet field2597;

    static {
        field2594 = new byte[]{(byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 0, (byte) 1, (byte) 2, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    }

    class319(byte[] var1) {
        this.field2597 = new Packet((byte[]) null);
        this.method5999(var1);
    }

    class319() {
        this.field2597 = new Packet((byte[]) null);
    }

    @ObfuscatedName("f")
    boolean method6011() {
        int var1 = this.field2590.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            if (this.field2590[var2] >= 0) {
                return false;
            }
        }

        return true;
    }

    @ObfuscatedName("v")
    long method6009(int var1) {
        return this.field2595 + (long) var1 * (long) this.field2593;
    }

    @ObfuscatedName("r")
    void method6050() {
        this.field2597.payload = null;
        this.field2589 = null;
        this.field2590 = null;
        this.field2591 = null;
        this.field2592 = null;
    }

    @ObfuscatedName("e")
    boolean method5997() {
        return this.field2597.payload != null;
    }

    @ObfuscatedName("q")
    int method6040() {
        return this.field2590.length;
    }

    @ObfuscatedName("x")
    int method6008(int var1, int var2) {
        int var4;
        if (var2 == 255) {
            int var7 = this.field2597.readUnsignedByte();
            var4 = this.field2597.method6096();
            if (var7 == 47) {
                this.field2597.offset += var4;
                return 1;
            } else if (var7 == 81) {
                int var5 = this.field2597.method6082();
                var4 -= 3;
                int var6 = this.field2591[var1];
                this.field2595 += (long) var6 * (long) (this.field2593 - var5);
                this.field2593 = var5;
                this.field2597.offset += var4;
                return 2;
            } else {
                this.field2597.offset += var4;
                return 3;
            }
        } else {
            byte var3 = field2594[var2 - 128];
            var4 = var2;
            if (var3 >= 1) {
                var4 = var2 | this.field2597.readUnsignedByte() << 8;
            }

            if (var3 >= 2) {
                var4 |= this.field2597.readUnsignedByte() << 16;
            }

            return var4;
        }
    }

    @ObfuscatedName("m")
    void method6005(int var1) {
        int var2 = this.field2597.method6096();
        this.field2591[var1] += var2;
    }

    @ObfuscatedName("p")
    void method6004() {
        this.field2597.offset = -1;
    }

    @ObfuscatedName("a")
    void method6002(long var1) {
        this.field2595 = var1;
        int var3 = this.field2590.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            this.field2591[var4] = 0;
            this.field2592[var4] = 0;
            this.field2597.offset = this.field2589[var4];
            this.method6005(var4);
            this.field2590[var4] = this.field2597.offset;
        }

    }

    @ObfuscatedName("c")
    void method6036(int var1) {
        this.field2597.offset = this.field2590[var1];
    }

    @ObfuscatedName("i")
    void method6003(int var1) {
        this.field2590[var1] = this.field2597.offset;
    }

    @ObfuscatedName("d")
    int method6006(int var1) {
        int var2 = this.method6007(var1);
        return var2;
    }

    @ObfuscatedName("j")
    int method6007(int var1) {
        byte var2 = this.field2597.payload[this.field2597.offset];
        int var5;
        if (var2 < 0) {
            var5 = var2 & 255;
            this.field2592[var1] = var5;
            ++this.field2597.offset;
        } else {
            var5 = this.field2592[var1];
        }

        if (var5 != 240 && var5 != 247) {
            return this.method6008(var1, var5);
        } else {
            int var3 = this.field2597.method6096();
            if (var5 == 247 && var3 > 0) {
                int var4 = this.field2597.payload[this.field2597.offset] & 255;
                if (var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
                    ++this.field2597.offset;
                    this.field2592[var1] = var4;
                    return this.method6008(var1, var4);
                }
            }

            this.field2597.offset += var3;
            return 0;
        }
    }

    @ObfuscatedName("h")
    int method6041() {
        int var1 = this.field2590.length;
        int var2 = -1;
        int var3 = Integer.MAX_VALUE;

        for (int var4 = 0; var4 < var1; ++var4) {
            if (this.field2590[var4] >= 0 && this.field2591[var4] < var3) {
                var2 = var4;
                var3 = this.field2591[var4];
            }
        }

        return var2;
    }

    @ObfuscatedName("g")
    void method5999(byte[] var1) {
        this.field2597.payload = var1;
        this.field2597.offset = 10;
        int var2 = this.field2597.readUnsignedShort();
        this.field2588 = this.field2597.readUnsignedShort();
        this.field2593 = 500000;
        this.field2589 = new int[var2];

        int var3;
        int var5;
        for (var3 = 0; var3 < var2; this.field2597.offset += var5) {
            int var4 = this.field2597.getInt();
            var5 = this.field2597.getInt();
            if (var4 == 1297379947) {
                this.field2589[var3] = this.field2597.offset;
                ++var3;
            }
        }

        this.field2595 = 0L;
        this.field2590 = new int[var2];

        for (var3 = 0; var3 < var2; ++var3) {
            this.field2590[var3] = this.field2589[var3];
        }

        this.field2591 = new int[var2];
        this.field2592 = new int[var2];
    }
}
