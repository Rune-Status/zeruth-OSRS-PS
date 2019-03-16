package net.runelite.runescape;

import net.runelite.mapping.*;
import net.runelite.rs.api.RSPacketBuffer;

@ObfuscatedName("ge")
@Implements("Bit")
public final class Bit extends Packet implements RSPacketBuffer {
    @ObfuscatedName("i")
    static final int[] field2445;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = 363739921
    )
    int bitPosition;
    @ObfuscatedName("n")
    @ObfuscatedSignature(
            signature = "Lgt;"
    )
    Isaac cipher;

    static {
        field2445 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
    }

    public Bit(int var1) {
        super(var1);
    }

    @ObfuscatedName("ik")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "-595759265"
    )
    @Export("getBits")
    public int getBits(int var1) {
        int var2 = this.bitPosition >> 3;
        int var3 = 8 - (this.bitPosition & 7);
        int var4 = 0;

        for (this.bitPosition += var1; var1 > var3; var3 = 8) {
            var4 += (super.payload[var2++] & field2445[var3]) << var1 - var3;
            var1 -= var3;
        }

        if (var3 == var1) {
            var4 += super.payload[var2] & field2445[var3];
        } else {
            var4 += super.payload[var2] >> var3 - var1 & field2445[var1];
        }

        return var4;
    }

    @ObfuscatedName("ix")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "-32"
    )
    public int method2825() {
        return super.payload[++super.offset - 1] - this.cipher.method4018() & 255;
    }

    @ObfuscatedName("ii")
    @ObfuscatedSignature(
            signature = "([BIII)V",
            garbageValue = "479364060"
    )
    public void method2839(byte[] var1, int var2, int var3) {
        for (int var4 = 0; var4 < var3; ++var4) {
            var1[var4 + var2] = (byte) (super.payload[++super.offset - 1] - this.cipher.method4018());
        }

    }

    @ObfuscatedName("ih")
    @ObfuscatedSignature(
            signature = "([IB)V",
            garbageValue = "-27"
    )
    public void method2831(int[] var1) {
        this.cipher = new Isaac(var1);
    }

    @ObfuscatedName("ic")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "-52"
    )
    public boolean method2829() {
        int var1 = super.payload[super.offset] - this.cipher.method4017() & 255;
        return var1 >= 128;
    }

    @ObfuscatedName("is")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "104"
    )
    public void method2828(int var1) {
        super.payload[++super.offset - 1] = (byte) (var1 + this.cipher.method4018());
    }

    @ObfuscatedName("id")
    @ObfuscatedSignature(
            signature = "(Lgt;S)V",
            garbageValue = "29081"
    )
    public void method2827(Isaac var1) {
        this.cipher = var1;
    }

    @ObfuscatedName("ju")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "66410185"
    )
    public int method2835(int var1) {
        return var1 * 8 - this.bitPosition;
    }

    @ObfuscatedName("jx")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-2058300325"
    )
    public void method2834() {
        super.offset = (this.bitPosition + 7) / 8;
    }

    @ObfuscatedName("ia")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1537431138"
    )
    public void method2837() {
        this.bitPosition = super.offset * 8;
    }

    @ObfuscatedName("im")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-711467529"
    )
    public int method2830() {
        int var1 = super.payload[++super.offset - 1] - this.cipher.method4018() & 255;
        return var1 < 128 ? var1 : (var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.method4018() & 255);
    }
}
