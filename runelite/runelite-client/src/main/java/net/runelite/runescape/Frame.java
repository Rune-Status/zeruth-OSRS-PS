package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFrame;
import net.runelite.rs.api.RSFrameMap;

@ObfuscatedName("do")
@Implements("Frame")
public class Frame implements RSFrame {
    @ObfuscatedName("r")
    static int[] field1605;
    @ObfuscatedName("e")
    static int[] field1606;
    @ObfuscatedName("q")
    static int[] field1607;
    @ObfuscatedName("g")
    static int[] field1612;
    @ObfuscatedName("l")
    int transformCount;
    @ObfuscatedName("w")
    int[] translator_x;
    @ObfuscatedName("p")
    boolean showing;
    @ObfuscatedName("b")
    int[] transformTypes;
    @ObfuscatedName("n")
    int[] translator_y;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Ldb;"
    )
    FrameMap skin;
    @ObfuscatedName("i")
    int[] translator_z;

    static {
        field1612 = new int[500];
        field1605 = new int[500];
        field1606 = new int[500];
        field1607 = new int[500];
    }

    @ObfuscatedSignature(
            signature = "([BLdb;)V"
    )
    Frame(byte[] var1, FrameMap var2) {
        this.skin = null;
        this.transformCount = -1;
        this.showing = false;
        this.skin = var2;
        Packet var3 = new Packet(var1);
        Packet var4 = new Packet(var1);
        var3.offset = 2;
        int var5 = var3.readUnsignedByte();
        int var6 = -1;
        int var7 = 0;
        var4.offset = var5 + var3.offset;

        int var8;
        for (var8 = 0; var8 < var5; ++var8) {
            int var9 = var3.readUnsignedByte();
            if (var9 > 0) {
                if (this.skin.types[var8] != 0) {
                    for (int var10 = var8 - 1; var10 > var6; --var10) {
                        if (this.skin.types[var10] == 0) {
                            field1612[var7] = var10;
                            field1605[var7] = 0;
                            field1606[var7] = 0;
                            field1607[var7] = 0;
                            ++var7;
                            break;
                        }
                    }
                }

                field1612[var7] = var8;
                short var11 = 0;
                if (this.skin.types[var8] == 3) {
                    var11 = 128;
                }

                if ((var9 & 1) != 0) {
                    field1605[var7] = var4.method6091();
                } else {
                    field1605[var7] = var11;
                }

                if ((var9 & 2) != 0) {
                    field1606[var7] = var4.method6091();
                } else {
                    field1606[var7] = var11;
                }

                if ((var9 & 4) != 0) {
                    field1607[var7] = var4.method6091();
                } else {
                    field1607[var7] = var11;
                }

                var6 = var8;
                ++var7;
                if (this.skin.types[var8] == 5) {
                    this.showing = true;
                }
            }
        }

        if (var1.length != var4.offset) {
            throw new RuntimeException();
        } else {
            this.transformCount = var7;
            this.transformTypes = new int[var7];
            this.translator_x = new int[var7];
            this.translator_y = new int[var7];
            this.translator_z = new int[var7];

            for (var8 = 0; var8 < var7; ++var8) {
                this.transformTypes[var8] = field1612[var8];
                this.translator_x[var8] = field1605[var8];
                this.translator_y[var8] = field1606[var8];
                this.translator_z[var8] = field1607[var8];
            }

        }
    }

    public RSFrameMap getSkin() {
        return this.skin;
    }

    public int getTransformCount() {
        return this.transformCount;
    }

    public int[] getTransformTypes() {
        return this.transformTypes;
    }

    public int[] getTranslatorX() {
        return this.translator_x;
    }

    public int[] getTranslatorY() {
        return this.translator_y;
    }

    public int[] getTranslatorZ() {
        return this.translator_z;
    }

    public boolean isShowing() {
        return this.showing;
    }
}
