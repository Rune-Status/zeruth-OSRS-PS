package net.runelite.runescape;

import net.runelite.mapping.*;
import net.runelite.rs.api.RSBuffer;

import java.math.BigInteger;

@ObfuscatedName("gl")
@Implements("Packet")
public class Packet extends Node implements RSBuffer {
    @ObfuscatedName("e")
    static int[] crc32Table;
    @ObfuscatedName("m")
    static int[] field2408;
    @ObfuscatedName("c")
    static long[] crc64Table;
    @ObfuscatedName("he")
    @ObfuscatedGetter(
            intValue = -1021742515
    )
    static int cameraZ;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 2087195987
    )
    public int offset;
    @ObfuscatedName("g")
    public byte[] payload;

    static {
        crc32Table = new int[256];

        int var2;
        for (int var1 = 0; var1 < 256; ++var1) {
            int var0 = var1;

            for (var2 = 0; var2 < 8; ++var2) {
                if ((var0 & 1) == 1) {
                    var0 = var0 >>> 1 ^ -306674912;
                } else {
                    var0 >>>= 1;
                }
            }

            crc32Table[var1] = var0;
        }

        crc64Table = new long[256];

        for (var2 = 0; var2 < 256; ++var2) {
            long var4 = (long) var2;

            for (int var3 = 0; var3 < 8; ++var3) {
                if (1L == (var4 & 1L)) {
                    var4 = var4 >>> 1 ^ -3932672073523589310L;
                } else {
                    var4 >>>= 1;
                }
            }

            crc64Table[var2] = var4;
        }

    }

    public Packet(int var1) {
        this.payload = ChatLineBuffer.method1943(var1);
        this.offset = 0;
    }

    public Packet(byte[] var1) {
        this.payload = var1;
        this.offset = 0;
    }

    @ObfuscatedName("ak")
    @ObfuscatedSignature(
            signature = "([IS)V",
            garbageValue = "334"
    )
    public void method6097(int[] var1) {
        int var2 = this.offset / 8;
        this.offset = 0;

        for (int var3 = 0; var3 < var2; ++var3) {
            int var4 = this.getInt();
            int var5 = this.getInt();
            int var6 = 0;
            int var7 = -1640531527;

            for (int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) {
                var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
                var6 += var7;
            }

            this.offset -= 8;
            this.method6230(var4);
            this.method6230(var5);
        }

    }

    @ObfuscatedName("by")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "56"
    )
    @Export("putIntV1")
    public void putIntV1(int var1) {
        this.payload[++this.offset - 1] = (byte) (var1 >> 8);
        this.payload[++this.offset - 1] = (byte) var1;
        this.payload[++this.offset - 1] = (byte) (var1 >> 24);
        this.payload[++this.offset - 1] = (byte) (var1 >> 16);
    }

    @ObfuscatedName("bh")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "28"
    )
    @Export("putIntLE")
    public void putIntLE(int var1) {
        this.payload[++this.offset - 1] = (byte) var1;
        this.payload[++this.offset - 1] = (byte) (var1 >> 8);
        this.payload[++this.offset - 1] = (byte) (var1 >> 16);
        this.payload[++this.offset - 1] = (byte) (var1 >> 24);
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "([BIII)V",
            garbageValue = "-1348780797"
    )
    public void method6072(byte[] var1, int var2, int var3) {
        for (int var4 = var2; var4 < var3 + var2; ++var4) {
            this.payload[++this.offset - 1] = var1[var4];
        }

    }

    @ObfuscatedName("bn")
    @ObfuscatedSignature(
            signature = "([BIIB)V",
            garbageValue = "121"
    )
    public void method6228(byte[] var1, int var2, int var3) {
        for (int var4 = var2; var4 < var3 + var2; ++var4) {
            var1[var4] = (byte) (this.payload[++this.offset - 1] - 128);
        }

    }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1645531027"
    )
    @Export("putByteC")
    public void putByteC(int var1) {
        this.payload[++this.offset - 1] = (byte) (0 - var1);
    }

    @ObfuscatedName("bb")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "64801268"
    )
    @Export("readShortLE")
    public int readShortLE() {
        this.offset += 2;
        return ((this.payload[this.offset - 1] & 255) << 8)
                + (this.payload[this.offset - 2] & 255);
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;B)V",
            garbageValue = "-1"
    )
    public void method6265(String var1) {
        int var2 = var1.indexOf(0);
        if (var2 >= 0) {
            throw new IllegalArgumentException("");
        } else {
            this.payload[++this.offset - 1] = 0;
            this.offset += ModeGame.method4298(var1, 0, var1.length(), this.payload, this.offset);
            this.payload[++this.offset - 1] = 0;
        }
    }

    @ObfuscatedName("bm")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-295803274"
    )
    @Export("putIntV2")
    public void putIntV2(int var1) {
        this.payload[++this.offset - 1] = (byte) (var1 >> 16);
        this.payload[++this.offset - 1] = (byte) (var1 >> 24);
        this.payload[++this.offset - 1] = (byte) var1;
        this.payload[++this.offset - 1] = (byte) (var1 >> 8);
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-33"
    )
    public void method6061() {
        if (this.payload != null) {
            WorldMapType2.method3153(this.payload);
        }

        this.payload = null;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "40"
    )
    @Export("putByte")
    public void putByte(int var1) {
        this.payload[++this.offset - 1] = (byte) var1;
    }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "20"
    )
    @Export("readUnsignedShort")
    public int readUnsignedShort() {
        this.offset += 2;
        return (this.payload[this.offset - 1] & 255)
                + ((this.payload[this.offset - 2] & 255) << 8);
    }

    @ObfuscatedName("bs")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-2125890607"
    )
    public void putByteS(int var1) {
        this.payload[++this.offset - 1] = (byte) (128 - var1);
    }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "2"
    )
    public int method6096() {
        byte var1 = this.payload[++this.offset - 1];

        int var2;
        for (var2 = 0; var1 < 0; var1 = this.payload[++this.offset - 1]) {
            var2 = (var2 | var1 & 127) << 7;
        }

        return var2 | var1;
    }

    @ObfuscatedName("ae")
    @ObfuscatedSignature(
            signature = "(B)J",
            garbageValue = "127"
    )
    public long method6084() {
        long var1 = (long) this.getInt() & 4294967295L;
        long var3 = (long) this.getInt() & 4294967295L;
        return (var1 << 32) + var3;
    }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "-67"
    )
    public void method6075(int var1) {
        this.payload[this.offset - var1 - 1] = (byte) var1;
    }

    @ObfuscatedName("bz")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "54"
    )
    @Export("getByte128")
    public int getByte128() {
        return this.payload[++this.offset - 1] - 128 & 255;
    }

    @ObfuscatedName("bg")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "1308083007"
    )
    public int method6119() {
        this.offset += 2;
        int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
        if (var1 > 32767) {
            var1 -= 65536;
        }

        return var1;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1271900923"
    )
    @Export("putShort")
    public void putShort(int var1) {
        this.payload[++this.offset - 1] = (byte) (var1 >> 8);
        this.payload[++this.offset - 1] = (byte) var1;
    }

    @ObfuscatedName("bd")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "287627655"
    )
    @Export("readNewVal")
    public int readNewVal() {
        this.offset += 4;
        return ((this.payload[this.offset - 2] & 255) << 24)
                + ((this.payload[this.offset - 4] & 255) << 8)
                + (this.payload[this.offset - 3] & 255)
                + ((this.payload[this.offset - 1] & 255) << 16);
    }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "506308590"
    )
    @Export("putByte128")
    public void putByte128(int var1) {
        this.payload[++this.offset - 1] = (byte) (var1 + 128);
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)V",
            garbageValue = "1492135448"
    )
    public void method6198(String var1) {
        int var2 = var1.indexOf(0);
        if (var2 >= 0) {
            throw new IllegalArgumentException("");
        } else {
            this.offset += ModeGame.method4298(var1, 0, var1.length(), this.payload, this.offset);
            this.payload[++this.offset - 1] = 0;
        }
    }

    @ObfuscatedName("m")
    public void method6067(long var1) {
        this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 56));
        this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 48));
        this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 40));
        this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 32));
        this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 24));
        this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 16));
        this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 8));
        this.payload[++this.offset - 1] = (byte) ((int) var1);
    }

    @ObfuscatedName("ba")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-106999200"
    )
    @Export("readN")
    public int readN() {
        return 0 - this.payload[++this.offset - 1] & 255;
    }

    @ObfuscatedName("p")
    public void method6066(long var1) {
        this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 40));
        this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 32));
        this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 24));
        this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 16));
        this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 8));
        this.payload[++this.offset - 1] = (byte) ((int) var1);
    }

    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            signature = "(I)Ljava/lang/String;",
            garbageValue = "1447526260"
    )
    public String method6088() {
        byte var1 = this.payload[++this.offset - 1];
        if (var1 != 0) {
            throw new IllegalStateException("");
        } else {
            int var2 = this.offset;

            while (this.payload[++this.offset - 1] != 0) {
                ;
            }

            int var3 = this.offset - var2 - 1;
            return var3 == 0 ? "" : Isaac.method4024(this.payload, var2, var3);
        }
    }

    @ObfuscatedName("aj")
    @ObfuscatedSignature(
            signature = "(I)Ljava/lang/String;",
            garbageValue = "-453480170"
    )
    @Export("readString")
    public String readString() {
        int var1 = this.offset;

        while (this.payload[++this.offset - 1] != 0) {
            ;
        }

        int var2 = this.offset - var1 - 1;
        return var2 == 0 ? "" : Isaac.method4024(this.payload, var1, var2);
    }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "2115207234"
    )
    @Export("getInt")
    public int getInt() {
        this.offset += 4;
        return ((this.payload[this.offset - 3] & 255) << 16)
                + (this.payload[this.offset - 1] & 255)
                + ((this.payload[this.offset - 2] & 255) << 8)
                + ((this.payload[this.offset - 4] & 255) << 24);
    }

    @ObfuscatedName("bo")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "1534204633"
    )
    @Export("getIntV2")
    public int getIntV2() {
        this.offset += 4;
        return ((this.payload[this.offset - 1] & 255) << 8)
                + ((this.payload[this.offset - 4] & 255) << 16)
                + (this.payload[this.offset - 2] & 255)
                + ((this.payload[this.offset - 3] & 255) << 24);
    }

    @ObfuscatedName("o")
    @ObfuscatedSignature(
            signature = "(I)B",
            garbageValue = "2043532631"
    )
    public byte method6240() {
        return this.payload[++this.offset - 1];
    }

    @ObfuscatedName("bp")
    @ObfuscatedSignature(
            signature = "(I)B",
            garbageValue = "1003182180"
    )
    @Export("readByte128")
    public byte readByte128() {
        return (byte) (this.payload[++this.offset - 1] - 128);
    }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "0"
    )
    public void method6073(int var1) {
        this.payload[this.offset - var1 - 4] = (byte) (var1 >> 24);
        this.payload[this.offset - var1 - 3] = (byte) (var1 >> 16);
        this.payload[this.offset - var1 - 2] = (byte) (var1 >> 8);
        this.payload[this.offset - var1 - 1] = (byte) var1;
    }

    @ObfuscatedName("ai")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "130636952"
    )
    public int method6094() {
        return this.payload[this.offset] < 0 ? this.getInt() & Integer.MAX_VALUE : this.readUnsignedShort();
    }

    @ObfuscatedName("av")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "66"
    )
    public boolean method6095() {
        this.offset -= 4;
        int var1 = NPCEntity.method2151(this.payload, 0, this.offset);
        int var2 = this.getInt();
        return var2 == var1;
    }

    @ObfuscatedName("bc")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "1840053040"
    )
    @Export("readLEShortA")
    public int readLEShortA() {
        this.offset += 2;
        return ((this.payload[this.offset - 1] & 255) << 8
        ) + (this.payload[this.offset - 2] - 128 & 255);
    }

    @ObfuscatedName("bq")
    @ObfuscatedSignature(
            signature = "(B)B",
            garbageValue = "44"
    )
    public byte method6112() {
        return (byte) (128 - this.payload[++this.offset - 1]);
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1616226405"
    )
    public void method6064(int var1) {
        this.payload[++this.offset - 1] = (byte) (var1 >> 16);
        this.payload[++this.offset - 1] = (byte) (var1 >> 8);
        this.payload[++this.offset - 1] = (byte) var1;
    }

    @ObfuscatedName("bk")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1224941199"
    )
    @Export("putShortLEA")
    public void putShortLEA(int var1) {
        this.payload[++this.offset - 1] = (byte) (var1 + 128);
        this.payload[++this.offset - 1] = (byte) (var1 >> 8);
    }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1659854833"
    )
    public void method6074(int var1) {
        this.payload[this.offset - var1 - 2] = (byte) (var1 >> 8);
        this.payload[this.offset - var1 - 1] = (byte) var1;
    }

    @ObfuscatedName("ay")
    @ObfuscatedSignature(
            signature = "([IIII)V",
            garbageValue = "1256882832"
    )
    public void method6100(int[] var1, int var2, int var3) {
        int var4 = this.offset;
        this.offset = var2;
        int var5 = (var3 - var2) / 8;

        for (int var6 = 0; var6 < var5; ++var6) {
            int var7 = this.getInt();
            int var8 = this.getInt();
            int var9 = -957401312;
            int var10 = -1640531527;

            for (int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
                var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
                var9 -= var10;
            }

            this.offset -= 8;
            this.method6230(var7);
            this.method6230(var8);
        }

        this.offset = var4;
    }

    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;B)V",
            garbageValue = "1"
    )
    public void method6170(BigInteger var1, BigInteger var2) {
        int var3 = this.offset;
        this.offset = 0;
        byte[] var4 = new byte[var3];
        this.method6090(var4, 0, var3);
        BigInteger var5 = new BigInteger(var4);
        BigInteger var6 = var5.modPow(var1, var2);
        byte[] var7 = var6.toByteArray();
        this.offset = 0;
        this.putShort(var7.length);
        this.method6072(var7, 0, var7.length);
    }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "-1"
    )
    public int method6123() {
        this.offset += 2;
        int var1 = (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
        if (var1 > 32767) {
            var1 -= 65536;
        }

        return var1;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public int getOffset() {
        return this.offset;
    }

    @ObfuscatedName("be")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-1831644342"
    )
    public int method6120() {
        this.offset += 2;
        int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
        if (var1 > 32767) {
            var1 -= 65536;
        }

        return var1;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "1639292109"
    )
    public void method6230(int var1) {
        this.payload[++this.offset - 1] = (byte) (var1 >> 24);
        this.payload[++this.offset - 1] = (byte) (var1 >> 16);
        this.payload[++this.offset - 1] = (byte) (var1 >> 8);
        this.payload[++this.offset - 1] = (byte) var1;
    }

    @ObfuscatedName("bv")
    @ObfuscatedSignature(
            signature = "(I)B",
            garbageValue = "1038768925"
    )
    public byte method6111() {
        return (byte) (0 - this.payload[++this.offset - 1]);
    }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "1982278071"
    )
    public int method6091() {
        int var1 = this.payload[this.offset] & 255;
        return var1 < 128 ? this.readUnsignedByte() - 64 : this.readUnsignedShort() - 49152;
    }

    @ObfuscatedName("y")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "96"
    )
    public void method6077(int var1) {
        if ((var1 & -128) != 0) {
            if ((var1 & -16384) != 0) {
                if ((var1 & -2097152) != 0) {
                    if ((var1 & -268435456) != 0) {
                        this.putByte(var1 >>> 28 | 128);
                    }

                    this.putByte(var1 >>> 21 | 128);
                }

                this.putByte(var1 >>> 14 | 128);
            }

            this.putByte(var1 >>> 7 | 128);
        }

        this.putByte(var1 & 127);
    }

    @ObfuscatedName("am")
    @ObfuscatedSignature(
            signature = "([IIIB)V",
            garbageValue = "0"
    )
    public void method6099(int[] var1, int var2, int var3) {
        int var4 = this.offset;
        this.offset = var2;
        int var5 = (var3 - var2) / 8;

        for (int var6 = 0; var6 < var5; ++var6) {
            int var7 = this.getInt();
            int var8 = this.getInt();
            int var9 = 0;
            int var10 = -1640531527;

            for (int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
                var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
                var9 += var10;
            }

            this.offset -= 8;
            this.method6230(var7);
            this.method6230(var8);
        }

        this.offset = var4;
    }

    @ObfuscatedName("bf")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "289154243"
    )
    @Export("getShort128")
    public void getShort128(int var1) {
        this.payload[++this.offset - 1] = (byte) (var1 >> 8);
        this.payload[++this.offset - 1] = (byte) (var1 + 128);
    }

    @ObfuscatedName("as")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-1628080529"
    )
    @Export("readUSmart")
    public int readUSmart() {
        int var1 = this.payload[this.offset] & 255;
        return var1 < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - 32768;
    }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "2062654558"
    )
    public int method6082() {
        this.offset += 3;
        return ((this.payload[this.offset - 3] & 255) << 16)
                + (this.payload[this.offset - 1] & 255)
                + ((this.payload[this.offset - 2] & 255) << 8);
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(ZS)V",
            garbageValue = "10410"
    )
    @Export("putBoolean")
    public void putBoolean(boolean var1) {
        this.putByte(var1 ? 1 : 0);
    }

    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            signature = "([BIIB)V",
            garbageValue = "30"
    )
    public void method6090(byte[] var1, int var2, int var3) {
        for (int var4 = var2; var4 < var3 + var2; ++var4) {
            var1[var4] = this.payload[++this.offset - 1];
        }

    }

    @ObfuscatedName("ad")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "-39"
    )
    public int method6207() {
        if (this.payload[this.offset] < 0) {
            return this.getInt() & Integer.MAX_VALUE;
        } else {
            int var1 = this.readUnsignedShort();
            return var1 == 32767 ? -1 : var1;
        }
    }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-145581161"
    )
    public int method6093() {
        int var1 = 0;

        int var2;
        for (var2 = this.readUSmart(); var2 == 32767; var2 = this.readUSmart()) {
            var1 += 32767;
        }

        var1 += var2;
        return var1;
    }

    @ObfuscatedName("bx")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "8"
    )
    public int method6125() {
        this.offset += 4;
        return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24);
    }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "-76"
    )
    @Export("pSmart1or2")
    public void pSmart1or2(int var1) {
        if (var1 >= 0 && var1 < 128) {
            this.putByte(var1);
        } else if (var1 >= 0 && var1 < 32768) {
            this.putShort(var1 + 32768);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @ObfuscatedName("bl")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-1873828017"
    )
    @Export("readShort128")
    public int readShort128() {
        this.offset += 2;
        return (this.payload[this.offset - 1] - 128 & 255)
                + ((this.payload[this.offset - 2] & 255) << 8);
    }

    @ObfuscatedName("az")
    @ObfuscatedSignature(
            signature = "(I)Ljava/lang/String;",
            garbageValue = "1414776804"
    )
    public String method6086() {
        if (this.payload[this.offset] == 0) {
            ++this.offset;
            return null;
        } else {
            return this.readString();
        }
    }

    @ObfuscatedName("bw")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "1"
    )
    @Export("putShortLE")
    public void putShortLE(int var1) {
        this.payload[++this.offset - 1] = (byte) var1;
        this.payload[++this.offset - 1] = (byte) (var1 >> 8);
    }

    @ObfuscatedName("ap")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "377514379"
    )
    public int method6059(int var1) {
        int var2 = NPCEntity.method2151(this.payload, var1, this.offset);
        this.method6230(var2);
        return var2;
    }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "-43"
    )
    public boolean method6085() {
        return (this.readUnsignedByte() & 1) == 1;
    }

    @ObfuscatedName("bi")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "0"
    )
    @Export("read128Byte")
    public int read128Byte() {
        return 128 - this.payload[++this.offset - 1] & 255;
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/CharSequence;I)V",
            garbageValue = "1449200682"
    )
    public void method6298(CharSequence var1) {
        int var3 = var1.length();
        int var4 = 0;

        for (int var5 = 0; var5 < var3; ++var5) {
            char var6 = var1.charAt(var5);
            if (var6 <= 127) {
                ++var4;
            } else if (var6 <= 2047) {
                var4 += 2;
            } else {
                var4 += 3;
            }
        }

        this.payload[++this.offset - 1] = 0;
        this.method6077(var4);
        this.offset += class56.method852(this.payload, this.offset, var1);
    }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-839331536"
    )
    @Export("readUnsignedByte")
    public int readUnsignedByte() {
        return this.payload[++this.offset - 1] & 255;
    }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            signature = "(B)Ljava/lang/String;",
            garbageValue = "56"
    )
    public String method6089() {
        byte var1 = this.payload[++this.offset - 1];
        if (var1 != 0) {
            throw new IllegalStateException("");
        } else {
            int var2 = this.method6096();
            if (var2 + this.offset > this.payload.length) {
                throw new IllegalStateException("");
            } else {
                byte[] var4 = this.payload;
                int var5 = this.offset;
                char[] var6 = new char[var2];
                int var7 = 0;
                int var8 = var5;

                int var11;
                for (int var9 = var5 + var2; var8 < var9; var6[var7++] = (char) var11) {
                    int var10 = var4[var8++] & 255;
                    if (var10 < 128) {
                        if (var10 == 0) {
                            var11 = 65533;
                        } else {
                            var11 = var10;
                        }
                    } else if (var10 < 192) {
                        var11 = 65533;
                    } else if (var10 < 224) {
                        if (var8 < var9 && (var4[var8] & 192) == 128) {
                            var11 = (var10 & 31) << 6 | var4[var8++] & 63;
                            if (var11 < 128) {
                                var11 = 65533;
                            }
                        } else {
                            var11 = 65533;
                        }
                    } else if (var10 < 240) {
                        if (var8 + 1 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128) {
                            var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                            if (var11 < 2048) {
                                var11 = 65533;
                            }
                        } else {
                            var11 = 65533;
                        }
                    } else if (var10 < 248) {
                        if (var8 + 2 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128 && (var4[var8 + 2] & 192) == 128) {
                            var11 = (var10 & 7) << 18 | (var4[var8++] & 63) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                            if (var11 >= 65536 && var11 <= 1114111) {
                                var11 = 65533;
                            } else {
                                var11 = 65533;
                            }
                        } else {
                            var11 = 65533;
                        }
                    } else {
                        var11 = 65533;
                    }
                }

                String var3 = new String(var6, 0, var7);
                this.offset += var2;
                return var3;
            }
        }
    }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            signature = "([II)V",
            garbageValue = "34938715"
    )
    public void method6227(int[] var1) {
        int var2 = this.offset / 8;
        this.offset = 0;

        for (int var3 = 0; var3 < var2; ++var3) {
            int var4 = this.getInt();
            int var5 = this.getInt();
            int var6 = -957401312;
            int var7 = -1640531527;

            for (int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) {
                var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
                var6 -= var7;
            }

            this.offset -= 8;
            this.method6230(var4);
            this.method6230(var5);
        }

    }

    @ObfuscatedName("bj")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "1652165997"
    )
    public int method6121() {
        this.offset += 3;
        return (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 1] & 255) << 16);
    }

    @ObfuscatedName("is")
    @ObfuscatedSignature(
            signature = "(II)Ljava/lang/String;",
            garbageValue = "1596556073"
    )
    static final String method6303(int var0) {
        return var0 < 999999999 ? Integer.toString(var0) : "*";
    }
}
