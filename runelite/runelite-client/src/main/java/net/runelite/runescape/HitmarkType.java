package net.runelite.runescape;

import net.runelite.mapping.*;

@ObfuscatedName("jb")
@Implements("HitmarkType")
public class HitmarkType extends CacheableNode {
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache field3434;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    public static Js5Index field3447;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    public static Js5Index field3439;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    @Export("hitmarkTypeCache")
    public static NodeCache hitmarkTypeCache;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache field3430;
    @ObfuscatedName("f")
    @ObfuscatedGetter(
            intValue = 2038572029
    )
    int field3436;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = -754604447
    )
    int field3438;
    @ObfuscatedName("af")
    @ObfuscatedGetter(
            intValue = 446668325
    )
    @Export("multiMarkVarp")
    int multiMarkVarp;
    @ObfuscatedName("k")
    @ObfuscatedGetter(
            intValue = 1451666971
    )
    public int field3442;
    @ObfuscatedName("x")
    @ObfuscatedGetter(
            intValue = -750615437
    )
    int field3437;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = 906132045
    )
    int field3440;
    @ObfuscatedName("o")
    @ObfuscatedGetter(
            intValue = -749262955
    )
    int multiMarkVarbit;
    @ObfuscatedName("a")
    @ObfuscatedGetter(
            intValue = -1840030171
    )
    public int field3441;
    @ObfuscatedName("z")
    String field3444;
    @ObfuscatedName("t")
    @ObfuscatedGetter(
            intValue = -199963919
    )
    public int field3431;
    @ObfuscatedName("y")
    @ObfuscatedGetter(
            intValue = -469164735
    )
    public int field3446;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = -184746315
    )
    public int field3435;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = 26062159
    )
    public int field3428;
    @ObfuscatedName("s")
    @ObfuscatedGetter(
            intValue = -1868060681
    )
    public int field3445;
    @ObfuscatedName("h")
    @ObfuscatedGetter(
            intValue = -1817187279
    )
    int field3427;
    @ObfuscatedName("u")
    @Export("multiMark")
    public int[] multiMark;

    static {
        hitmarkTypeCache = new NodeCache(64);
        field3430 = new NodeCache(64);
        field3434 = new NodeCache(20);
    }

    HitmarkType() {
        this.field3440 = -1;
        this.field3435 = 16777215;
        this.field3428 = 70;
        this.field3437 = -1;
        this.field3438 = -1;
        this.field3427 = -1;
        this.field3436 = -1;
        this.field3441 = 0;
        this.field3431 = 0;
        this.field3442 = -1;
        this.field3444 = "";
        this.field3445 = -1;
        this.field3446 = 0;
        this.multiMarkVarbit = -1;
        this.multiMarkVarp = -1;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lgl;B)V",
            garbageValue = "60"
    )
    void method2206(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method2207(var1, var2);
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "-90164519"
    )
    void method2207(Packet var1, int var2) {
        if (var2 == 1) {
            this.field3440 = var1.method6207();
        } else if (var2 == 2) {
            this.field3435 = var1.method6082();
        } else if (var2 == 3) {
            this.field3437 = var1.method6207();
        } else if (var2 == 4) {
            this.field3427 = var1.method6207();
        } else if (var2 == 5) {
            this.field3438 = var1.method6207();
        } else if (var2 == 6) {
            this.field3436 = var1.method6207();
        } else if (var2 == 7) {
            this.field3441 = var1.method6123();
        } else if (var2 == 8) {
            this.field3444 = var1.method6088();
        } else if (var2 == 9) {
            this.field3428 = var1.readUnsignedShort();
        } else if (var2 == 10) {
            this.field3431 = var1.method6123();
        } else if (var2 == 11) {
            this.field3442 = 0;
        } else if (var2 == 12) {
            this.field3445 = var1.readUnsignedByte();
        } else if (var2 == 13) {
            this.field3446 = var1.method6123();
        } else if (var2 == 14) {
            this.field3442 = var1.readUnsignedShort();
        } else if (var2 == 17 || var2 == 18) {
            this.multiMarkVarbit = var1.readUnsignedShort();
            if (this.multiMarkVarbit == 65535) {
                this.multiMarkVarbit = -1;
            }

            this.multiMarkVarp = var1.readUnsignedShort();
            if (this.multiMarkVarp == 65535) {
                this.multiMarkVarp = -1;
            }

            int var3 = -1;
            if (var2 == 18) {
                var3 = var1.readUnsignedShort();
                if (var3 == 65535) {
                    var3 = -1;
                }
            }

            int var4 = var1.readUnsignedByte();
            this.multiMark = new int[var4 + 2];

            for (int var5 = 0; var5 <= var4; ++var5) {
                this.multiMark[var5] = var1.readUnsignedShort();
                if (this.multiMark[var5] == 65535) {
                    this.multiMark[var5] = -1;
                }
            }

            this.multiMark[var4 + 1] = var3;
        }

    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(B)Ljb;",
            garbageValue = "-37"
    )
    public final HitmarkType method2240() {
        int var1 = -1;
        if (this.multiMarkVarbit != -1) {
            var1 = AbstractSoundSystem.method339(this.multiMarkVarbit);
        } else if (this.multiMarkVarp != -1) {
            var1 = class311.clientVarps[this.multiMarkVarp];
        }

        int var2;
        if (var1 >= 0 && var1 < this.multiMark.length - 1) {
            var2 = this.multiMark[var1];
        } else {
            var2 = this.multiMark[this.multiMark.length - 1];
        }

        return var2 != -1 ? class112.method1959(var2) : null;
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(I)Lls;",
            garbageValue = "-1228964338"
    )
    public SpritePixels method2215() {
        if (this.field3427 < 0) {
            return null;
        } else {
            SpritePixels var1 = (SpritePixels) field3430.method951((long) this.field3427);
            if (var1 != null) {
                return var1;
            } else {
                var1 = class36.method576(field3447, this.field3427, 0, (byte) -96);
                if (var1 != null) {
                    field3430.method957(var1, (long) this.field3427);
                }

                return var1;
            }
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)Lls;",
            garbageValue = "876183082"
    )
    public SpritePixels method2208() {
        if (this.field3438 < 0) {
            return null;
        } else {
            SpritePixels var1 = (SpritePixels) field3430.method951((long) this.field3438);
            if (var1 != null) {
                return var1;
            } else {
                var1 = class36.method576(field3447, this.field3438, 0, (byte) 11);
                if (var1 != null) {
                    field3430.method957(var1, (long) this.field3438);
                }

                return var1;
            }
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(II)Ljava/lang/String;",
            garbageValue = "193568958"
    )
    public String method2224(int var1) {
        String var2 = this.field3444;

        while (true) {
            int var3 = var2.indexOf("%1");
            if (var3 < 0) {
                return var2;
            }

            var2 = var2.substring(0, var3) + class124.method2096(var1, false) + var2.substring(var3 + 2);
        }
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(I)Lls;",
            garbageValue = "2113084260"
    )
    public SpritePixels method2238() {
        if (this.field3437 < 0) {
            return null;
        } else {
            SpritePixels var1 = (SpritePixels) field3430.method951((long) this.field3437);
            if (var1 != null) {
                return var1;
            } else {
                var1 = class36.method576(field3447, this.field3437, 0, (byte) -118);
                if (var1 != null) {
                    field3430.method957(var1, (long) this.field3437);
                }

                return var1;
            }
        }
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)Lls;",
            garbageValue = "1564627351"
    )
    public SpritePixels method2213() {
        if (this.field3436 < 0) {
            return null;
        } else {
            SpritePixels var1 = (SpritePixels) field3430.method951((long) this.field3436);
            if (var1 != null) {
                return var1;
            } else {
                var1 = class36.method576(field3447, this.field3436, 0, (byte) -105);
                if (var1 != null) {
                    field3430.method957(var1, (long) this.field3436);
                }

                return var1;
            }
        }
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(I)Lkz;",
            garbageValue = "-1086243540"
    )
    public Font method2229() {
        if (this.field3440 == -1) {
            return null;
        } else {
            Font var1 = (Font) field3434.method951((long) this.field3440);
            if (var1 != null) {
                return var1;
            } else {
                Js5Index var3 = field3447;
                Js5Index var4 = field3439;
                int var5 = this.field3440;
                Font var2;
                if (!WorldMapRectangle.method128(var3, var5, 0)) {
                    var2 = null;
                } else {
                    byte[] var7 = var4.method1516(var5, 0, 1789634852);
                    Font var6;
                    if (var7 == null) {
                        var6 = null;
                    } else {
                        Font var8 = new Font(var7, class95.indexedSpriteOffsetXs, class95.indexedSpriteOffsetYs, class95.indexSpriteWidths, VarClientType.indexedSpriteHeights, class95.indexedSpritePalette, class95.spritePixels);
                        class95.indexedSpriteOffsetXs = null;
                        class95.indexedSpriteOffsetYs = null;
                        class95.indexSpriteWidths = null;
                        VarClientType.indexedSpriteHeights = null;
                        class95.indexedSpritePalette = null;
                        class95.spritePixels = null;
                        var6 = var8;
                    }

                    var2 = var6;
                }

                if (var2 != null) {
                    field3434.method957(var2, (long) this.field3440);
                }

                return var2;
            }
        }
    }

    @ObfuscatedName("kd")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;B)V",
            garbageValue = "0"
    )
    static final void method2227(String var0) {
        if (!var0.equals("")) {
            TcpConnectionMessage var1 = FaceNormal.method5726(ClientProt.CLAN_JOINCHAT_LEAVECHAT, client.serverConnection.isaac);
            var1.packetBuffer.putByte(AbstractSoundSystem.method338(var0));
            var1.packetBuffer.method6198(var0);
            client.serverConnection.method5881(var1);
        }
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(IIII)I",
            garbageValue = "1434790423"
    )
    static final int method2210(int var0, int var1, int var2) {
        if (var2 > 179) {
            var1 /= 2;
        }

        if (var2 > 192) {
            var1 /= 2;
        }

        if (var2 > 217) {
            var1 /= 2;
        }

        if (var2 > 243) {
            var1 /= 2;
        }

        int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
        return var3;
    }

    @ObfuscatedName("g")
    static double method2239(double var0) {
        return Math.exp(-var0 * var0 / 2.0D) / Math.sqrt(6.283185307179586D);
    }
}
