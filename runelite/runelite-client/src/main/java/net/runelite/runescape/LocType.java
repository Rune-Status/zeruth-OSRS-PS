package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSObjectComposition;

@ObfuscatedName("jd")
@Implements("LocType")
public class LocType extends CacheableNode implements RSObjectComposition {
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache cachedModels;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index objects_ref;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index field3452;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            signature = "[Ldu;"
    )
    static ModelData[] field3494;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache objects;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache field3473;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache field3457;
    @ObfuscatedName("de")
    @ObfuscatedSignature(
            signature = "Lih;"
    )
    static Js5 instruments;
    @ObfuscatedName("g")
    static boolean objectCompositionLowDetail;
    @ObfuscatedName("ak")
    @ObfuscatedGetter(
            intValue = -769012877
    )
    int multiLocVarbit;
    @ObfuscatedName("f")
    @ObfuscatedGetter(
            intValue = 2008978439
    )
    public int length;
    @ObfuscatedName("v")
    short[] textureToReplace;
    @ObfuscatedName("af")
    @ObfuscatedGetter(
            intValue = -1014650047
    )
    int ambient;
    @ObfuscatedName("al")
    public int[] multiLocs;
    @ObfuscatedName("ae")
    @ObfuscatedGetter(
            intValue = 593009849
    )
    public int mapSceneId;
    @ObfuscatedName("k")
    @ObfuscatedGetter(
            intValue = -1103201829
    )
    public int field3470;
    @ObfuscatedName("au")
    @ObfuscatedSignature(
            signature = "Lgr;"
    )
    IterableHashTable params;
    @ObfuscatedName("x")
    short[] textureToFind;
    @ObfuscatedName("m")
    public String name;
    @ObfuscatedName("p")
    int[] objectTypes;
    @ObfuscatedName("ag")
    @ObfuscatedGetter(
            intValue = 100274719
    )
    int modelSizeHeight;
    @ObfuscatedName("aj")
    @ObfuscatedGetter(
            intValue = -1249355677
    )
    int modelSizeX;
    @ObfuscatedName("aw")
    @ObfuscatedGetter(
            intValue = 1692229289
    )
    public int mapIconId;
    @ObfuscatedName("o")
    @ObfuscatedGetter(
            intValue = 564853691
    )
    public int decorDisplacement;
    @ObfuscatedName("a")
    @ObfuscatedGetter(
            intValue = 2125824409
    )
    public int clipType;
    @ObfuscatedName("ai")
    boolean isHollow;
    @ObfuscatedName("z")
    @ObfuscatedGetter(
            intValue = 1799594821
    )
    int contouredGround;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = 105242647
    )
    public int field3469;
    @ObfuscatedName("av")
    public int[] field3499;
    @ObfuscatedName("t")
    public boolean blocksProjectile;
    @ObfuscatedName("ay")
    @ObfuscatedGetter(
            intValue = 100550507
    )
    public int int4;
    @ObfuscatedName("ah")
    @ObfuscatedGetter(
            intValue = 858929023
    )
    public int int5;
    @ObfuscatedName("an")
    @ObfuscatedGetter(
            intValue = -759044957
    )
    int contrast;
    @ObfuscatedName("i")
    int[] objectModels;
    @ObfuscatedName("at")
    @ObfuscatedGetter(
            intValue = -14313053
    )
    int offsetHeight;
    @ObfuscatedName("y")
    public boolean modelClipped;
    @ObfuscatedName("am")
    @ObfuscatedGetter(
            intValue = 435904231
    )
    public int ambientSoundId;
    @ObfuscatedName("as")
    @ObfuscatedGetter(
            intValue = -115983903
    )
    int offsetY;
    @ObfuscatedName("ax")
    public String[] actions;
    @ObfuscatedName("d")
    short[] recolorToFind;
    @ObfuscatedName("ar")
    @ObfuscatedGetter(
            intValue = -533415901
    )
    int offsetX;
    @ObfuscatedName("ad")
    @ObfuscatedGetter(
            intValue = -377182881
    )
    public int supportItems;
    @ObfuscatedName("j")
    short[] recolorToReplace;
    @ObfuscatedName("aa")
    public boolean obstructsGround;
    @ObfuscatedName("s")
    boolean nonFlatShading;
    @ObfuscatedName("az")
    public boolean clipped;
    @ObfuscatedName("ap")
    @ObfuscatedGetter(
            intValue = -611348635
    )
    public int int6;
    @ObfuscatedName("ac")
    boolean isRotated;
    @ObfuscatedName("h")
    @ObfuscatedGetter(
            intValue = -300740639
    )
    public int width;
    @ObfuscatedName("u")
    @ObfuscatedGetter(
            intValue = 2022965993
    )
    public int animationId;
    @ObfuscatedName("ab")
    @ObfuscatedGetter(
            intValue = -1585599263
    )
    int modelSizeY;
    @ObfuscatedName("ao")
    @ObfuscatedGetter(
            intValue = -1099491681
    )
    int multiLocVarp;

    static {
        objectCompositionLowDetail = false;
        objects = new NodeCache(4096);
        field3457 = new NodeCache(500);
        cachedModels = new NodeCache(30);
        field3473 = new NodeCache(30);
        field3494 = new ModelData[4];
    }

    LocType() {
        this.name = "null";
        this.width = 1;
        this.length = 1;
        this.clipType = 2;
        this.blocksProjectile = true;
        this.field3470 = -1;
        this.contouredGround = -1;
        this.nonFlatShading = false;
        this.modelClipped = false;
        this.animationId = -1;
        this.decorDisplacement = 16;
        this.ambient = 0;
        this.contrast = 0;
        this.actions = new String[5];
        this.mapIconId = -1;
        this.mapSceneId = -1;
        this.isRotated = false;
        this.clipped = true;
        this.modelSizeX = 128;
        this.modelSizeHeight = 128;
        this.modelSizeY = 128;
        this.offsetX = 0;
        this.offsetHeight = 0;
        this.offsetY = 0;
        this.obstructsGround = false;
        this.isHollow = false;
        this.supportItems = -1;
        this.multiLocVarbit = -1;
        this.multiLocVarp = -1;
        this.ambientSoundId = -1;
        this.int4 = 0;
        this.int5 = 0;
        this.int6 = 0;
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(ILjava/lang/String;I)Ljava/lang/String;",
            garbageValue = "1787451266"
    )
    public String method1719(int var1, String var2) {
        return AuthProt.method1670(this.params, var1, var2);
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(B)Ljd;",
            garbageValue = "67"
    )
    public final LocType method1717() {
        int var1 = -1;
        if (this.multiLocVarbit != -1) {
            var1 = AbstractSoundSystem.method339(this.multiLocVarbit);
        } else if (this.multiLocVarp != -1) {
            var1 = class311.clientVarps[this.multiLocVarp];
        }

        int var2;
        if (var1 >= 0 && var1 < this.multiLocs.length - 1) {
            var2 = this.multiLocs[var1];
        } else {
            var2 = this.multiLocs[this.multiLocs.length - 1];
        }

        return var2 != -1 ? class225.method4485(var2) : null;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-343160721"
    )
    void method1738() {
        if (this.field3470 == -1) {
            this.field3470 = 0;
            if (this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
                this.field3470 = 1;
            }

            for (int var1 = 0; var1 < 5; ++var1) {
                if (this.actions[var1] != null) {
                    this.field3470 = 1;
                }
            }
        }

        if (this.supportItems == -1) {
            this.supportItems = this.clipType != 0 ? 1 : 0;
        }

    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-386492996"
    )
    void method1709(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method1710(var1, var2);
        }
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(IIB)Ldu;",
            garbageValue = "8"
    )
    final ModelData method1716(int var1, int var2) {
        ModelData var3 = null;
        boolean var4;
        int var5;
        int var7;
        if (this.objectTypes == null) {
            if (var1 != 10) {
                return null;
            }

            if (this.objectModels == null) {
                return null;
            }

            var4 = this.isRotated;
            if (var1 == 2 && var2 > 3) {
                var4 = !var4;
            }

            var5 = this.objectModels.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                var7 = this.objectModels[var6];
                if (var4) {
                    var7 += 65536;
                }

                var3 = (ModelData) field3457.method951((long) var7);
                if (var3 == null) {
                    var3 = ModelData.method1479(field3452, var7 & 65535, 0);
                    if (var3 == null) {
                        return null;
                    }

                    if (var4) {
                        var3.method1442();
                    }

                    field3457.method957(var3, (long) var7);
                }

                if (var5 > 1) {
                    field3494[var6] = var3;
                }
            }

            if (var5 > 1) {
                var3 = new ModelData(field3494, var5);
            }
        } else {
            int var9 = -1;

            for (var5 = 0; var5 < this.objectTypes.length; ++var5) {
                if (this.objectTypes[var5] == var1) {
                    var9 = var5;
                    break;
                }
            }

            if (var9 == -1) {
                return null;
            }

            var5 = this.objectModels[var9];
            boolean var10 = this.isRotated ^ var2 > 3;
            if (var10) {
                var5 += 65536;
            }

            var3 = (ModelData) field3457.method951((long) var5);
            if (var3 == null) {
                var3 = ModelData.method1479(field3452, var5 & 65535, 0);
                if (var3 == null) {
                    return null;
                }

                if (var10) {
                    var3.method1442();
                }

                field3457.method957(var3, (long) var5);
            }
        }

        if (this.modelSizeX == 128 && this.modelSizeHeight == 128 && this.modelSizeY == 128) {
            var4 = false;
        } else {
            var4 = true;
        }

        boolean var11;
        if (this.offsetX == 0 && this.offsetHeight == 0 && this.offsetY == 0) {
            var11 = false;
        } else {
            var11 = true;
        }

        ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, null == this.recolorToFind, null == this.textureToFind, true);
        if (var1 == 4 && var2 > 3) {
            var8.method1417(256);
            var8.method1463(45, 0, -45);
        }

        var2 &= 3;
        if (var2 == 1) {
            var8.method1440();
        } else if (var2 == 2) {
            var8.method1415();
        } else if (var2 == 3) {
            var8.method1416();
        }

        if (this.recolorToFind != null) {
            for (var7 = 0; var7 < this.recolorToFind.length; ++var7) {
                var8.method1411(this.recolorToFind[var7], this.recolorToReplace[var7]);
            }
        }

        if (this.textureToFind != null) {
            for (var7 = 0; var7 < this.textureToFind.length; ++var7) {
                var8.method1421(this.textureToFind[var7], this.textureToReplace[var7]);
            }
        }

        if (var4) {
            var8.method1419(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
        }

        if (var11) {
            var8.method1463(this.offsetX, this.offsetHeight, this.offsetY);
        }

        return var8;
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(II[[IIIII)Ldd;",
            garbageValue = "-1318761153"
    )
    public final Entity method1726(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
        long var7;
        if (this.objectTypes == null) {
            var7 = (long) (var2 + (this.field3469 << 10));
        } else {
            var7 = (long) (var2 + (var1 << 3) + (this.field3469 << 10));
        }

        Object var9 = (Entity) cachedModels.method951(var7);
        if (var9 == null) {
            ModelData var10 = this.method1716(var1, var2);
            if (var10 == null) {
                return null;
            }

            if (!this.nonFlatShading) {
                var9 = var10.method1408(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
            } else {
                var10.field1548 = (short) (this.ambient + 64);
                var10.contrast = (short) (this.contrast * 25 + 768);
                var10.method1438();
                var9 = var10;
            }

            cachedModels.method957((CacheableNode) var9, var7);
        }

        if (this.nonFlatShading) {
            var9 = ((ModelData) var9).method1418();
        }

        if (this.contouredGround >= 0) {
            if (var9 instanceof Model) {
                var9 = ((Model) var9).method5452(var3, var4, var5, var6, true, this.contouredGround);
            } else if (var9 instanceof ModelData) {
                var9 = ((ModelData) var9).method1427(var3, var4, var5, var6, true, this.contouredGround);
            }
        }

        return (Entity) var9;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1968694969"
    )
    public final boolean method1712() {
        if (this.objectModels == null) {
            return true;
        } else {
            boolean var1 = true;

            for (int var2 = 0; var2 < this.objectModels.length; ++var2) {
                var1 &= field3452.method1515(this.objectModels[var2] & 65535, 0);
            }

            return var1;
        }
    }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1361071379"
    )
    public boolean method1720() {
        if (this.multiLocs == null) {
            return this.ambientSoundId != -1 || this.field3499 != null;
        } else {
            for (int var1 = 0; var1 < this.multiLocs.length; ++var1) {
                if (this.multiLocs[var1] != -1) {
                    LocType var2 = class225.method4485(this.multiLocs[var1]);
                    if (var2.ambientSoundId != -1 || var2.field3499 != null) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "-1639838333"
    )
    void method1710(Packet var1, int var2) {
        int var3;
        int var4;
        if (var2 == 1) {
            var3 = var1.readUnsignedByte();
            if (var3 > 0) {
                if (this.objectModels != null && !objectCompositionLowDetail) {
                    var1.offset += var3 * 3;
                } else {
                    this.objectTypes = new int[var3];
                    this.objectModels = new int[var3];

                    for (var4 = 0; var4 < var3; ++var4) {
                        this.objectModels[var4] = var1.readUnsignedShort();
                        this.objectTypes[var4] = var1.readUnsignedByte();
                    }
                }
            }
        } else if (var2 == 2) {
            this.name = var1.readString();
        } else if (var2 == 5) {
            var3 = var1.readUnsignedByte();
            if (var3 > 0) {
                if (this.objectModels != null && !objectCompositionLowDetail) {
                    var1.offset += var3 * 2;
                } else {
                    this.objectTypes = null;
                    this.objectModels = new int[var3];

                    for (var4 = 0; var4 < var3; ++var4) {
                        this.objectModels[var4] = var1.readUnsignedShort();
                    }
                }
            }
        } else if (var2 == 14) {
            this.width = var1.readUnsignedByte();
        } else if (var2 == 15) {
            this.length = var1.readUnsignedByte();
        } else if (var2 == 17) {
            this.clipType = 0;
            this.blocksProjectile = false;
        } else if (var2 == 18) {
            this.blocksProjectile = false;
        } else if (var2 == 19) {
            this.field3470 = var1.readUnsignedByte();
        } else if (var2 == 21) {
            this.contouredGround = 0;
        } else if (var2 == 22) {
            this.nonFlatShading = true;
        } else if (var2 == 23) {
            this.modelClipped = true;
        } else if (var2 == 24) {
            this.animationId = var1.readUnsignedShort();
            if (this.animationId == 65535) {
                this.animationId = -1;
            }
        } else if (var2 == 27) {
            this.clipType = 1;
        } else if (var2 == 28) {
            this.decorDisplacement = var1.readUnsignedByte();
        } else if (var2 == 29) {
            this.ambient = var1.method6240();
        } else if (var2 == 39) {
            this.contrast = var1.method6240();
        } else if (var2 >= 30 && var2 < 35) {
            this.actions[var2 - 30] = var1.readString();
            if (this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
                this.actions[var2 - 30] = null;
            }
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
            this.textureToFind = new short[var3];
            this.textureToReplace = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.textureToFind[var4] = (short) var1.readUnsignedShort();
                this.textureToReplace[var4] = (short) var1.readUnsignedShort();
            }
        } else if (var2 == 62) {
            this.isRotated = true;
        } else if (var2 == 64) {
            this.clipped = false;
        } else if (var2 == 65) {
            this.modelSizeX = var1.readUnsignedShort();
        } else if (var2 == 66) {
            this.modelSizeHeight = var1.readUnsignedShort();
        } else if (var2 == 67) {
            this.modelSizeY = var1.readUnsignedShort();
        } else if (var2 == 68) {
            this.mapSceneId = var1.readUnsignedShort();
        } else if (var2 == 69) {
            var1.readUnsignedByte();
        } else if (var2 == 70) {
            this.offsetX = var1.method6123();
        } else if (var2 == 71) {
            this.offsetHeight = var1.method6123();
        } else if (var2 == 72) {
            this.offsetY = var1.method6123();
        } else if (var2 == 73) {
            this.obstructsGround = true;
        } else if (var2 == 74) {
            this.isHollow = true;
        } else if (var2 == 75) {
            this.supportItems = var1.readUnsignedByte();
        } else if (var2 != 77 && var2 != 92) {
            if (var2 == 78) {
                this.ambientSoundId = var1.readUnsignedShort();
                this.int4 = var1.readUnsignedByte();
            } else if (var2 == 79) {
                this.int5 = var1.readUnsignedShort();
                this.int6 = var1.readUnsignedShort();
                this.int4 = var1.readUnsignedByte();
                var3 = var1.readUnsignedByte();
                this.field3499 = new int[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.field3499[var4] = var1.readUnsignedShort();
                }
            } else if (var2 == 81) {
                this.contouredGround = var1.readUnsignedByte() * 256;
            } else if (var2 == 82) {
                this.mapIconId = var1.readUnsignedShort();
            } else if (var2 == 249) {
                this.params = class96.method1621(var1, this.params);
            }
        } else {
            this.multiLocVarbit = var1.readUnsignedShort();
            if (this.multiLocVarbit == 65535) {
                this.multiLocVarbit = -1;
            }

            this.multiLocVarp = var1.readUnsignedShort();
            if (this.multiLocVarp == 65535) {
                this.multiLocVarp = -1;
            }

            var3 = -1;
            if (var2 == 92) {
                var3 = var1.readUnsignedShort();
                if (var3 == 65535) {
                    var3 = -1;
                }
            }

            var4 = var1.readUnsignedByte();
            this.multiLocs = new int[var4 + 2];

            for (int var5 = 0; var5 <= var4; ++var5) {
                this.multiLocs[var5] = var1.readUnsignedShort();
                if (this.multiLocs[var5] == 65535) {
                    this.multiLocs[var5] = -1;
                }
            }

            this.multiLocs[var4 + 1] = var3;
        }

    }

    public int getId() {
        return this.field3469;
    }

    public String getName() {
        return this.name;
    }

    public String[] getActions() {
        return this.actions;
    }

    public int getMapIconId() {
        return this.mapIconId;
    }

    public int getMapSceneId() {
        return this.mapSceneId;
    }

    public int[] getImpostorIds() {
        return this.multiLocs;
    }

    public RSObjectComposition getImpostor() {
        return this.method1717();
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(II)Z",
            garbageValue = "150186764"
    )
    public final boolean method1739(int var1) {
        if (this.objectTypes != null) {
            for (int var4 = 0; var4 < this.objectTypes.length; ++var4) {
                if (this.objectTypes[var4] == var1) {
                    return field3452.method1515(this.objectModels[var4] & 65535, 0);
                }
            }

            return true;
        } else if (this.objectModels == null) {
            return true;
        } else if (var1 != 10) {
            return true;
        } else {
            boolean var2 = true;

            for (int var3 = 0; var3 < this.objectModels.length; ++var3) {
                var2 &= field3452.method1515(this.objectModels[var3] & 65535, 0);
            }

            return var2;
        }
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(II[[IIIII)Ldl;",
            garbageValue = "-1740380750"
    )
    public final Model method1714(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
        long var7;
        if (this.objectTypes == null) {
            var7 = (long) (var2 + (this.field3469 << 10));
        } else {
            var7 = (long) (var2 + (var1 << 3) + (this.field3469 << 10));
        }

        Model var9 = (Model) field3473.method951(var7);
        if (var9 == null) {
            ModelData var10 = this.method1716(var1, var2);
            if (var10 == null) {
                return null;
            }

            var9 = var10.method1408(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
            field3473.method957(var9, var7);
        }

        if (this.contouredGround >= 0) {
            var9 = var9.method5452(var3, var4, var5, var6, true, this.contouredGround);
        }

        return var9;
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(II[[IIIILjg;II)Ldl;",
            garbageValue = "2038224680"
    )
    public final Model method1750(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
        long var9;
        if (this.objectTypes == null) {
            var9 = (long) (var2 + (this.field3469 << 10));
        } else {
            var9 = (long) (var2 + (var1 << 3) + (this.field3469 << 10));
        }

        Model var11 = (Model) field3473.method951(var9);
        if (var11 == null) {
            ModelData var12 = this.method1716(var1, var2);
            if (var12 == null) {
                return null;
            }

            var11 = var12.method1408(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
            field3473.method957(var11, var9);
        }

        if (var7 == null && this.contouredGround == -1) {
            return var11;
        } else {
            if (var7 != null) {
                var11 = var7.method4780(var11, var8, var2, 1960875541);
            } else {
                var11 = var11.method5453(true);
            }

            if (this.contouredGround >= 0) {
                var11 = var11.method5452(var3, var4, var5, var6, false, this.contouredGround);
            }

            return var11;
        }
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(IIB)I",
            garbageValue = "14"
    )
    public int method1718(int var1, int var2) {
        return AuthProt.method1664(this.params, var1, var2);
    }
}
