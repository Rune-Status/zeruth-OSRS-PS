package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSCombatInfo2;

@ObfuscatedName("jf")
@Implements("HeadbarType")
public class HeadbarType extends CacheableNode implements RSCombatInfo2 {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    public static Js5Index field3380;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache field3385;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache field3382;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    public static Js5Index field3389;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = 382132199
    )
    public int field3393;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 768727517
    )
    public int field3391;
    @ObfuscatedName("x")
    @ObfuscatedGetter(
            intValue = 1894704517
    )
    public int healthScale;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = -1837917425
    )
    public int field3387;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = 1615417507
    )
    public int field3381;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = 852504283
    )
    public int field3386;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -1652351465
    )
    public int field3383;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 1633062419
    )
    public int field3394;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = -436830649
    )
    int field3390;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = -233086243
    )
    int field3379;

    static {
        field3385 = new NodeCache(64);
        field3382 = new NodeCache(64);
    }

    HeadbarType() {
        this.field3391 = 255;
        this.field3386 = 255;
        this.field3394 = -1;
        this.field3381 = 1;
        this.field3387 = 70;
        this.field3390 = -1;
        this.field3379 = -1;
        this.healthScale = 30;
        this.field3393 = 0;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lgl;B)V",
            garbageValue = "-97"
    )
    void method4514(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method4523(var1, var2);
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "-991537919"
    )
    void method4523(Packet var1, int var2) {
        if (var2 == 1) {
            var1.readUnsignedShort();
        } else if (var2 == 2) {
            this.field3391 = var1.readUnsignedByte();
        } else if (var2 == 3) {
            this.field3386 = var1.readUnsignedByte();
        } else if (var2 == 4) {
            this.field3394 = 0;
        } else if (var2 == 5) {
            this.field3387 = var1.readUnsignedShort();
        } else if (var2 == 6) {
            var1.readUnsignedByte();
        } else if (var2 == 7) {
            this.field3390 = var1.method6207();
        } else if (var2 == 8) {
            this.field3379 = var1.method6207();
        } else if (var2 == 11) {
            this.field3394 = var1.readUnsignedShort();
        } else if (var2 == 14) {
            this.healthScale = var1.readUnsignedByte();
        } else if (var2 == 15) {
            this.field3393 = var1.readUnsignedByte();
        }

    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(I)Lls;",
            garbageValue = "-1081176616"
    )
    public SpritePixels method4516() {
        if (this.field3390 < 0) {
            return null;
        } else {
            SpritePixels var1 = (SpritePixels) field3382.method951((long) this.field3390);
            if (var1 != null) {
                return var1;
            } else {
                var1 = class36.method576(field3380, this.field3390, 0, (byte) -8);
                if (var1 != null) {
                    field3382.method957(var1, (long) this.field3390);
                }

                return var1;
            }
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)Lls;",
            garbageValue = "-1057793537"
    )
    public SpritePixels method4517() {
        if (this.field3379 < 0) {
            return null;
        } else {
            SpritePixels var1 = (SpritePixels) field3382.method951((long) this.field3379);
            if (var1 != null) {
                return var1;
            } else {
                var1 = class36.method576(field3380, this.field3379, 0, (byte) 29);
                if (var1 != null) {
                    field3382.method957(var1, (long) this.field3379);
                }

                return var1;
            }
        }
    }

    public int getHealthScale() {
        return this.healthScale;
    }
}
