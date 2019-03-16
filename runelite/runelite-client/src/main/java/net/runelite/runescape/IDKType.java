package net.runelite.runescape;

import net.runelite.mapping.*;

@ObfuscatedName("ja")
@Implements("IDKType")
public class IDKType extends CacheableNode {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    public static Js5Index field3367;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1947138161
    )
    public static int field3368;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    @Export("identKits")
    static NodeCache identKits;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    @Export("identKit_ref")
    public static Js5Index identKit_ref;
    @ObfuscatedName("l")
    @Export("modelIds")
    int[] modelIds;
    @ObfuscatedName("w")
    @Export("recolorToReplace")
    short[] recolorToReplace;
    @ObfuscatedName("m")
    @Export("nonSelectable")
    public boolean nonSelectable;
    @ObfuscatedName("p")
    @Export("models")
    int[] models;
    @ObfuscatedName("b")
    @Export("recolorToFind")
    short[] recolorToFind;
    @ObfuscatedName("n")
    @Export("retextureToFind")
    short[] retextureToFind;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -523139729
    )
    @Export("bodyPartId")
    public int bodyPartId;
    @ObfuscatedName("i")
    @Export("drawingAreaTop")
    short[] retextureToReplace;

    static {
        identKits = new NodeCache(64);
    }

    IDKType() {
        this.bodyPartId = -1;
        this.models = new int[]{-1, -1, -1, -1, -1};
        this.nonSelectable = false;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "2084504661"
    )
    void method1891(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method1896(var1, var2);
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "-671766700"
    )
    void method1896(Packet var1, int var2) {
        if (var2 == 1) {
            this.bodyPartId = var1.readUnsignedByte();
        } else {
            int var3;
            int var4;
            if (var2 == 2) {
                var3 = var1.readUnsignedByte();
                this.modelIds = new int[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.modelIds[var4] = var1.readUnsignedShort();
                }
            } else if (var2 == 3) {
                this.nonSelectable = true;
            } else if (var2 == 40) {
                var3 = var1.readUnsignedByte();
                this.recolorToFind = new short[var3];
                this.recolorToReplace = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.recolorToFind[var4] = (short) var1.readUnsignedShort();
                    this.recolorToReplace[var4] = (short) var1.readUnsignedShort();
                }
            } else if (var2 == 41) {
                var3 = var1.readUnsignedByte();
                this.retextureToFind = new short[var3];
                this.retextureToReplace = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.retextureToFind[var4] = (short) var1.readUnsignedShort();
                    this.retextureToReplace[var4] = (short) var1.readUnsignedShort();
                }
            } else if (var2 >= 60 && var2 < 70) {
                this.models[var2 - 60] = var1.readUnsignedShort();
            }
        }

    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1058310311"
    )
    public boolean method1893() {
        if (this.modelIds == null) {
            return true;
        } else {
            boolean var1 = true;

            for (int var2 = 0; var2 < this.modelIds.length; ++var2) {
                if (!field3367.method1515(this.modelIds[var2], 0)) {
                    var1 = false;
                }
            }

            return var1;
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)Ldu;",
            garbageValue = "-1790881696"
    )
    public ModelData method1895() {
        ModelData[] var1 = new ModelData[5];
        int var2 = 0;

        for (int var3 = 0; var3 < 5; ++var3) {
            if (this.models[var3] != -1) {
                var1[var2++] = ModelData.method1479(field3367, this.models[var3], 0);
            }
        }

        ModelData var5 = new ModelData(var1, var2);
        int var4;
        if (this.recolorToFind != null) {
            for (var4 = 0; var4 < this.recolorToFind.length; ++var4) {
                var5.method1411(this.recolorToFind[var4], this.recolorToReplace[var4]);
            }
        }

        if (this.retextureToFind != null) {
            for (var4 = 0; var4 < this.retextureToFind.length; ++var4) {
                var5.method1421(this.retextureToFind[var4], this.retextureToReplace[var4]);
            }
        }

        return var5;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(B)Ldu;",
            garbageValue = "0"
    )
    public ModelData method1890() {
        if (this.modelIds == null) {
            return null;
        } else {
            ModelData[] var1 = new ModelData[this.modelIds.length];

            for (int var2 = 0; var2 < this.modelIds.length; ++var2) {
                var1[var2] = ModelData.method1479(field3367, this.modelIds[var2], 0);
            }

            ModelData var4;
            if (var1.length == 1) {
                var4 = var1[0];
            } else {
                var4 = new ModelData(var1, var1.length);
            }

            int var3;
            if (this.recolorToFind != null) {
                for (var3 = 0; var3 < this.recolorToFind.length; ++var3) {
                    var4.method1411(this.recolorToFind[var3], this.recolorToReplace[var3]);
                }
            }

            if (this.retextureToFind != null) {
                for (var3 = 0; var3 < this.retextureToFind.length; ++var3) {
                    var4.method1421(this.retextureToFind[var3], this.retextureToReplace[var3]);
                }
            }

            return var4;
        }
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "275237055"
    )
    public boolean method1894() {
        boolean var1 = true;

        for (int var2 = 0; var2 < 5; ++var2) {
            if (this.models[var2] != -1 && !field3367.method1515(this.models[var2], 0)) {
                var1 = false;
            }
        }

        return var1;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "([BIIIIIII[Lfn;B)V",
            garbageValue = "69"
    )
    static final void method1908(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
        int var10;
        for (int var9 = 0; var9 < 8; ++var9) {
            for (var10 = 0; var10 < 8; ++var10) {
                if (var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
                    var8[var1].flags[var9 + var2][var3 + var10] &= -16777217;
                }
            }
        }

        Packet var28 = new Packet(var0);

        for (var10 = 0; var10 < 4; ++var10) {
            for (int var11 = 0; var11 < 64; ++var11) {
                for (int var12 = 0; var12 < 64; ++var12) {
                    if (var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                        int var17 = var11 & 7;
                        int var18 = var12 & 7;
                        int var19 = var7 & 3;
                        int var16;
                        if (var19 == 0) {
                            var16 = var17;
                        } else if (var19 == 1) {
                            var16 = var18;
                        } else if (var19 == 2) {
                            var16 = 7 - var17;
                        } else {
                            var16 = 7 - var18;
                        }

                        int var22 = var2 + var16;
                        int var25 = var11 & 7;
                        int var26 = var12 & 7;
                        int var27 = var7 & 3;
                        int var24;
                        if (var27 == 0) {
                            var24 = var26;
                        } else if (var27 == 1) {
                            var24 = 7 - var25;
                        } else if (var27 == 2) {
                            var24 = 7 - var26;
                        } else {
                            var24 = var25;
                        }

                        FrameMap.method553(var28, var1, var22, var3 + var24, 0, 0, var7);
                    } else {
                        FrameMap.method553(var28, 0, -1, -1, 0, 0, 0);
                    }
                }
            }
        }

    }
}
