package net.runelite.runescape;

import net.runelite.api.kit.KitType;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPlayerComposition;

@ObfuscatedName("hi")
@Implements("PlayerComposition")
public class PlayerComposition implements RSPlayerComposition {
    @ObfuscatedName("w")
    public static boolean isMembersWorld;
    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    static NodeCache field2636;
    @ObfuscatedName("p")
    static final int[] field2644;
    @ObfuscatedName("n")
    public static short[] field2642;
    @ObfuscatedName("i")
    public static short[][] field2638;
    @ObfuscatedName("h")
    static String[] historicCacheLocations;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            longValue = 5620474286414922863L
    )
    long field2645;
    @ObfuscatedName("r")
    int[] bodyPartColours;
    @ObfuscatedName("e")
    public boolean isFemale;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -2143718159
    )
    public int transformedNpcId;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            longValue = 3116875124835442359L
    )
    long hash;
    @ObfuscatedName("g")
    int[] equipmentIds;

    static {
        field2644 = new int[]{8, 11, 4, 6, 9, 7, 10};
        field2636 = new NodeCache(260);
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IZB)V",
            garbageValue = "33"
    )
    public void method620(int var1, boolean var2) {
        if (var1 != 1 || !this.isFemale) {
            int var3 = this.equipmentIds[field2644[var1]];
            if (var3 != 0) {
                var3 -= 256;

                IDKType var4;
                do {
                    if (!var2) {
                        --var3;
                        if (var3 < 0) {
                            var3 = IDKType.field3368 - 1;
                        }
                    } else {
                        ++var3;
                        if (var3 >= IDKType.field3368) {
                            var3 = 0;
                        }
                    }

                    var4 = ClientProt.method6053(var3);
                } while (var4 == null || var4.nonSelectable || var4.bodyPartId != (this.isFemale ? 7 : 0) + var1);

                this.equipmentIds[field2644[var1]] = var3 + 256;
                this.method624();
            }
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IZI)V",
            garbageValue = "272980366"
    )
    public void method621(int var1, boolean var2) {
        int var3 = this.bodyPartColours[var1];
        boolean var4;
        if (!var2) {
            do {
                --var3;
                if (var3 < 0) {
                    var3 = VarPlayerType.colorsToReplace[var1].length - 1;
                }

                if (var1 == 4 && var3 >= 8) {
                    var4 = false;
                } else {
                    var4 = true;
                }
            } while (!var4);
        } else {
            do {
                ++var3;
                if (var3 >= VarPlayerType.colorsToReplace[var1].length) {
                    var3 = 0;
                }

                if (var1 == 4 && var3 >= 8) {
                    var4 = false;
                } else {
                    var4 = true;
                }
            } while (!var4);
        }

        this.bodyPartColours[var1] = var3;
        this.method624();
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(ZI)V",
            garbageValue = "1010932829"
    )
    public void method622(boolean var1) {
        if (this.isFemale != var1) {
            this.method619((int[]) null, this.bodyPartColours, var1, -1);
        }
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(I)Ldu;",
            garbageValue = "520490175"
    )
    ModelData method626() {
        if (this.transformedNpcId != -1) {
            return FileRequest.method4030(this.transformedNpcId).method5870();
        } else {
            boolean var1 = false;

            int var3;
            for (int var2 = 0; var2 < 12; ++var2) {
                var3 = this.equipmentIds[var2];
                if (var3 >= 256 && var3 < 512 && !ClientProt.method6053(var3 - 256).method1894()) {
                    var1 = true;
                }

                if (var3 >= 512 && !Varcs.method4770(var3 - 512).method6316(this.isFemale)) {
                    var1 = true;
                }
            }

            if (var1) {
                return null;
            } else {
                ModelData[] var7 = new ModelData[12];
                var3 = 0;

                int var5;
                for (int var4 = 0; var4 < 12; ++var4) {
                    var5 = this.equipmentIds[var4];
                    ModelData var6;
                    if (var5 >= 256 && var5 < 512) {
                        var6 = ClientProt.method6053(var5 - 256).method1895();
                        if (var6 != null) {
                            var7[var3++] = var6;
                        }
                    }

                    if (var5 >= 512) {
                        var6 = Varcs.method4770(var5 - 512).method6348(this.isFemale);
                        if (var6 != null) {
                            var7[var3++] = var6;
                        }
                    }
                }

                ModelData var8 = new ModelData(var7, var3);

                for (var5 = 0; var5 < 5; ++var5) {
                    if (this.bodyPartColours[var5] < VarPlayerType.colorsToReplace[var5].length) {
                        var8.method1411(KeyFocusListener.colorsToFind[var5], VarPlayerType.colorsToReplace[var5][this.bodyPartColours[var5]]);
                    }

                    if (this.bodyPartColours[var5] < field2638[var5].length) {
                        var8.method1411(field2642[var5], field2638[var5][this.bodyPartColours[var5]]);
                    }
                }

                return var8;
            }
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(Ljg;ILjg;IB)Ldl;",
            garbageValue = "9"
    )
    public Model method625(Sequence var1, int var2, Sequence var3, int var4) {
        if (this.transformedNpcId != -1) {
            return FileRequest.method4030(this.transformedNpcId).method5854(var1, var2, var3, var4);
        } else {
            long var5 = this.hash;
            int[] var7 = this.equipmentIds;
            if (var1 != null && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
                var7 = new int[12];

                for (int var18 = 0; var18 < 12; ++var18) {
                    var7[var18] = this.equipmentIds[var18];
                }

                if (var1.leftHandItem >= 0) {
                    var5 += (long) (var1.leftHandItem - this.equipmentIds[5] << 40);
                    var7[5] = var1.leftHandItem;
                }

                if (var1.rightHandItem >= 0) {
                    var5 += (long) (var1.rightHandItem - this.equipmentIds[3] << 48);
                    var7[3] = var1.rightHandItem;
                }
            }

            Model var8 = (Model) field2636.method951(var5);
            if (var8 == null) {
                boolean var9 = false;

                int var11;
                for (int var10 = 0; var10 < 12; ++var10) {
                    var11 = var7[var10];
                    if (var11 >= 256 && var11 < 512 && !ClientProt.method6053(var11 - 256).method1893()) {
                        var9 = true;
                    }

                    if (var11 >= 512 && !Varcs.method4770(var11 - 512).method6314(this.isFemale)) {
                        var9 = true;
                    }
                }

                if (var9) {
                    if (this.field2645 != -1L) {
                        var8 = (Model) field2636.method951(this.field2645);
                    }

                    if (var8 == null) {
                        return null;
                    }
                }

                if (var8 == null) {
                    ModelData[] var15 = new ModelData[12];
                    var11 = 0;

                    int var13;
                    for (int var12 = 0; var12 < 12; ++var12) {
                        var13 = var7[var12];
                        ModelData var14;
                        if (var13 >= 256 && var13 < 512) {
                            var14 = ClientProt.method6053(var13 - 256).method1890();
                            if (var14 != null) {
                                var15[var11++] = var14;
                            }
                        }

                        if (var13 >= 512) {
                            var14 = Varcs.method4770(var13 - 512).method6315(this.isFemale);
                            if (var14 != null) {
                                var15[var11++] = var14;
                            }
                        }
                    }

                    ModelData var17 = new ModelData(var15, var11);

                    for (var13 = 0; var13 < 5; ++var13) {
                        if (this.bodyPartColours[var13] < VarPlayerType.colorsToReplace[var13].length) {
                            var17.method1411(KeyFocusListener.colorsToFind[var13], VarPlayerType.colorsToReplace[var13][this.bodyPartColours[var13]]);
                        }

                        if (this.bodyPartColours[var13] < field2638[var13].length) {
                            var17.method1411(field2642[var13], field2638[var13][this.bodyPartColours[var13]]);
                        }
                    }

                    var8 = var17.method1408(64, 850, -30, -50, -30);
                    field2636.method957(var8, var5);
                    this.field2645 = var5;
                }
            }

            if (var1 == null && var3 == null) {
                return var8;
            } else {
                Model var16;
                if (var1 != null && var3 != null) {
                    var16 = var1.method4781(var8, var2, var3, var4, -2120673223);
                } else if (var1 != null) {
                    var16 = var1.method4779(var8, var2, -1140097691);
                } else {
                    var16 = var3.method4779(var8, var4, -1140097691);
                }

                return var16;
            }
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-1388801683"
    )
    public void method623(Packet var1) {
        var1.putByte(this.isFemale ? 1 : 0);

        int var2;
        for (var2 = 0; var2 < 7; ++var2) {
            int var3 = this.equipmentIds[field2644[var2]];
            if (var3 == 0) {
                var1.putByte(-1);
            } else {
                var1.putByte(var3 - 256);
            }
        }

        for (var2 = 0; var2 < 5; ++var2) {
            var1.putByte(this.bodyPartColours[var2]);
        }

    }

    public int[] getEquipmentIds() {
        return this.equipmentIds;
    }

    public int getEquipmentId(KitType var1) {
        int var2 = this.getEquipmentIds()[var1.getIndex()];
        return var2 < 512 ? -1 : var2 - 512;
    }

    public int getKitId(KitType var1) {
        int var2 = this.getEquipmentIds()[var1.getIndex()];
        return var2 >= 256 && var2 < 512 ? var2 - 256 : -1;
    }

    public int[] getBodyPartColours() {
        return this.bodyPartColours;
    }

    public boolean isFemale() {
        return this.isFemale;
    }

    public void setTransformedNpcId(int var1) {
        this.transformedNpcId = var1;
    }

    public void setHash() {
        this.method624();
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "666329766"
    )
    void method624() {
        long var1 = this.hash;
        int var3 = this.equipmentIds[5];
        int var4 = this.equipmentIds[9];
        this.equipmentIds[5] = var4;
        this.equipmentIds[9] = var3;
        this.hash = 0L;

        int var5;
        for (var5 = 0; var5 < 12; ++var5) {
            this.hash <<= 4;
            if (this.equipmentIds[var5] >= 256) {
                this.hash += (long) (this.equipmentIds[var5] - 256);
            }
        }

        if (this.equipmentIds[0] >= 256) {
            this.hash += (long) (this.equipmentIds[0] - 256 >> 4);
        }

        if (this.equipmentIds[1] >= 256) {
            this.hash += (long) (this.equipmentIds[1] - 256 >> 8);
        }

        for (var5 = 0; var5 < 5; ++var5) {
            this.hash <<= 3;
            this.hash += (long) this.bodyPartColours[var5];
        }

        this.hash <<= 1;
        this.hash += (long) (this.isFemale ? 1 : 0);
        this.equipmentIds[5] = var3;
        this.equipmentIds[9] = var4;
        if (var1 != 0L && var1 != this.hash) {
            field2636.method950(var1);
        }

    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-1528803238"
    )
    public int method627() {
        return this.transformedNpcId == -1 ? (this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) : 305419896 + FileRequest.method4030(this.transformedNpcId).id;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "([I[IZII)V",
            garbageValue = "978549285"
    )
    public void method619(int[] var1, int[] var2, boolean var3, int var4) {
        if (var1 == null) {
            var1 = new int[12];

            for (int var5 = 0; var5 < 7; ++var5) {
                for (int var6 = 0; var6 < IDKType.field3368; ++var6) {
                    IDKType var7 = ClientProt.method6053(var6);
                    if (var7 != null && !var7.nonSelectable && var7.bodyPartId == var5 + (var3 ? 7 : 0)) {
                        var1[field2644[var5]] = var6 + 256;
                        break;
                    }
                }
            }
        }

        this.equipmentIds = var1;
        this.bodyPartColours = var2;
        this.isFemale = var3;
        this.transformedNpcId = var4;
        this.method624();
    }
}
