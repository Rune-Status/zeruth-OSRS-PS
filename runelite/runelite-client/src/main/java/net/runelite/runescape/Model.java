package net.runelite.runescape;

import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.model.Jarvis;
import net.runelite.api.model.Triangle;
import net.runelite.api.model.Vertex;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFrame;
import net.runelite.rs.api.RSFrameMap;
import net.runelite.rs.api.RSFrames;
import net.runelite.rs.api.RSModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ObfuscatedName("dl")
@Implements("Model")
public class Model extends Entity implements RSModel {
    @ObfuscatedName("ak")
    static int[] field1681;
    @ObfuscatedName("aq")
    static int[][] field1670;
    @ObfuscatedName("r")
    static byte[] field1639;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Ldl;"
    )
    static Model field1640;
    @ObfuscatedName("bs")
    static int[] field1690;
    @ObfuscatedName("al")
    @Export("modelViewportXs")
    static int[] modelViewportXs;
    @ObfuscatedName("bz")
    static int[] field1652;
    @ObfuscatedName("bg")
    @Export("Model_cosine")
    static int[] Model_cosine;
    @ObfuscatedName("q")
    static byte[] field1675;
    @ObfuscatedName("au")
    static int[] field1688;
    @ObfuscatedName("ba")
    static int[] field1692;
    @ObfuscatedName("bp")
    static int[] field1698;
    @ObfuscatedName("ai")
    static boolean[] field1678;
    @ObfuscatedName("av")
    static int[][] field1689;
    @ObfuscatedName("bc")
    @Export("Model_sine")
    static int[] Model_sine;
    @ObfuscatedName("bq")
    @Export("animOffsetX")
    static int animOffsetX;
    @ObfuscatedName("bk")
    @Export("useBoundingBoxes")
    static boolean useBoundingBoxes3D;
    @ObfuscatedName("ay")
    static int[] field1672;
    @ObfuscatedName("be")
    static int[] field1704;
    @ObfuscatedName("bv")
    @Export("xViewportBuffer")
    static int[] xViewportBuffer;
    @ObfuscatedName("am")
    static int[] field1683;
    @ObfuscatedName("bf")
    @Export("animOffsetZ")
    static int animOffsetZ;
    @ObfuscatedName("ad")
    @Export("modelViewportYs")
    static int[] modelViewportYs;
    @ObfuscatedName("aa")
    static boolean[] field1677;
    @ObfuscatedName("bw")
    @Export("animOffsetY")
    static int animOffsetY;
    @ObfuscatedName("ap")
    static int[] field1686;
    @ObfuscatedName("bi")
    static int[] field1693;
    @ObfuscatedName("ao")
    @Export("yViewportBuffer")
    static int[] yViewportBuffer;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Ldl;"
    )
    static Model field1641;
    @ObfuscatedName("bj")
    static int[] field1705;
    @ObfuscatedName("f")
    byte[] field1655;
    @ObfuscatedName("l")
    @Export("verticesX")
    int[] verticesX;
    @ObfuscatedName("v")
    byte[] field1653;
    @ObfuscatedName("af")
    public boolean field1664;
    @ObfuscatedName("ae")
    @Export("diameter")
    int diameter;
    @ObfuscatedName("k")
    int field1684;
    @ObfuscatedName("w")
    @Export("verticesZ")
    int[] verticesZ;
    @ObfuscatedName("x")
    int[] field1668;
    @ObfuscatedName("m")
    @Export("indices3")
    int[] indices3;
    @ObfuscatedName("p")
    @Export("indices2")
    int[] indices2;
    @ObfuscatedName("ag")
    @Export("centerZ")
    int centerZ;
    @ObfuscatedName("b")
    @Export("verticesY")
    int[] verticesY;
    @ObfuscatedName("aj")
    @Export("centerY")
    int centerY;
    @ObfuscatedName("aw")
    @Export("XYZMag")
    int XYZMag;
    @ObfuscatedName("o")
    int[][] field1679;
    @ObfuscatedName("a")
    short[] field1644;
    @ObfuscatedName("z")
    int[] field1659;
    @ObfuscatedName("n")
    @Export("indicesCount")
    int indicesCount;
    @ObfuscatedName("c")
    @Export("verticesCount")
    int verticesCount;
    @ObfuscatedName("t")
    byte field1657;
    @ObfuscatedName("an")
    @Export("boundsType")
    int boundsType;
    public int rl$sceneId;
    public int rl$bufferOffset;
    public int rl$uvBufferOffset;
    public float[][] rl$faceTextureUCoordinates;
    public float[][] rl$faceTextureVCoordinates;
    @ObfuscatedName("i")
    @Export("indices1")
    int[] indices1;
    @ObfuscatedName("at")
    @Export("extremeZ")
    int extremeZ;
    @ObfuscatedName("y")
    int[] field1661;
    @ObfuscatedName("ax")
    @Export("bottomY")
    int bottomY;
    @ObfuscatedName("d")
    int[] field1650;
    @ObfuscatedName("ar")
    @Export("extremeY")
    int extremeY;
    @ObfuscatedName("j")
    int[] field1706;
    @ObfuscatedName("s")
    int[] field1660;
    @ObfuscatedName("az")
    @Export("centerX")
    int centerX;
    @ObfuscatedName("ac")
    @Export("radius")
    int radius;
    @ObfuscatedName("h")
    byte[] field1642;
    @ObfuscatedName("u")
    @Export("vertexGroups")
    int[][] vertexGroups;
    @ObfuscatedName("ab")
    @Export("extremeX")
    int extremeX;
    @Export("modelViewportDepth")
    static int[] modelViewportDepth;

    static {
        field1641 = new Model();
        field1639 = new byte[1];
        field1640 = new Model();
        field1675 = new byte[1];
        modelViewportDepth = new int[4700];
        field1677 = new boolean[4700];
        field1678 = new boolean[4700];
        modelViewportYs = new int[4700];
        modelViewportXs = new int[4700];
        field1681 = new int[4700];
        yViewportBuffer = new int[4700];
        field1683 = new int[4700];
        field1672 = new int[4700];
        field1686 = new int[1600];
        field1689 = new int[1600][512];
        field1688 = new int[12];
        field1670 = new int[12][2000];
        field1690 = new int[2000];
        field1652 = new int[2000];
        field1692 = new int[12];
        field1693 = new int[10];
        field1698 = new int[10];
        xViewportBuffer = new int[10];
        useBoundingBoxes3D = true;
        Model_sine = Graphics3D.SINE;
        Model_cosine = Graphics3D.COSINE;
        field1704 = Graphics3D.colorPalette;
        field1705 = Graphics3D.field1744;
    }

    Model() {
        this.verticesCount = 0;
        this.indicesCount = 0;
        this.field1657 = 0;
        this.field1684 = 0;
        this.field1664 = false;
        this.extremeX = -1;
        this.extremeY = -1;
        this.extremeZ = -1;
    }

    @ObfuscatedSignature(
            signature = "([Ldl;I)V"
    )
    public Model(Model[] var1, int var2) {
        this.verticesCount = 0;
        this.indicesCount = 0;
        this.field1657 = 0;
        this.field1684 = 0;
        this.field1664 = false;
        this.extremeX = -1;
        this.extremeY = -1;
        this.extremeZ = -1;
        boolean var3 = false;
        boolean var4 = false;
        boolean var5 = false;
        boolean var6 = false;
        this.verticesCount = 0;
        this.indicesCount = 0;
        this.field1684 = 0;
        this.field1657 = -1;

        int var7;
        Model var8;
        for (var7 = 0; var7 < var2; ++var7) {
            var8 = var1[var7];
            if (var8 != null) {
                this.verticesCount += var8.verticesCount;
                this.indicesCount += var8.indicesCount;
                this.field1684 += var8.field1684;
                if (var8.field1653 != null) {
                    var3 = true;
                } else {
                    if (this.field1657 == -1) {
                        this.field1657 = var8.field1657;
                    }

                    if (this.field1657 != var8.field1657) {
                        var3 = true;
                    }
                }

                var4 |= var8.field1642 != null;
                var5 |= var8.field1644 != null;
                var6 |= var8.field1655 != null;
            }
        }

        this.verticesX = new int[this.verticesCount];
        this.verticesY = new int[this.verticesCount];
        this.verticesZ = new int[this.verticesCount];
        this.indices1 = new int[this.indicesCount];
        this.indices2 = new int[this.indicesCount];
        this.indices3 = new int[this.indicesCount];
        this.field1650 = new int[this.indicesCount];
        this.field1706 = new int[this.indicesCount];
        this.field1668 = new int[this.indicesCount];
        if (var3) {
            this.field1653 = new byte[this.indicesCount];
        }

        if (var4) {
            this.field1642 = new byte[this.indicesCount];
        }

        if (var5) {
            this.field1644 = new short[this.indicesCount];
        }

        if (var6) {
            this.field1655 = new byte[this.indicesCount];
        }

        if (this.field1684 > 0) {
            this.field1659 = new int[this.field1684];
            this.field1660 = new int[this.field1684];
            this.field1661 = new int[this.field1684];
        }

        this.verticesCount = 0;
        this.indicesCount = 0;
        this.field1684 = 0;

        for (var7 = 0; var7 < var2; ++var7) {
            var8 = var1[var7];
            if (var8 != null) {
                int var9;
                for (var9 = 0; var9 < var8.indicesCount; ++var9) {
                    this.indices1[this.indicesCount] = this.verticesCount + var8.indices1[var9];
                    this.indices2[this.indicesCount] = this.verticesCount + var8.indices2[var9];
                    this.indices3[this.indicesCount] = this.verticesCount + var8.indices3[var9];
                    this.field1650[this.indicesCount] = var8.field1650[var9];
                    this.field1706[this.indicesCount] = var8.field1706[var9];
                    this.field1668[this.indicesCount] = var8.field1668[var9];
                    if (var3) {
                        if (var8.field1653 != null) {
                            this.field1653[this.indicesCount] = var8.field1653[var9];
                        } else {
                            this.field1653[this.indicesCount] = var8.field1657;
                        }
                    }

                    if (var4 && var8.field1642 != null) {
                        this.field1642[this.indicesCount] = var8.field1642[var9];
                    }

                    if (var5) {
                        if (var8.field1644 != null) {
                            this.field1644[this.indicesCount] = var8.field1644[var9];
                        } else {
                            this.field1644[this.indicesCount] = -1;
                        }
                    }

                    if (var6) {
                        if (var8.field1655 != null && var8.field1655[var9] != -1) {
                            this.field1655[this.indicesCount] = (byte) (this.field1684 + var8.field1655[var9]);
                        } else {
                            this.field1655[this.indicesCount] = -1;
                        }
                    }

                    ++this.indicesCount;
                }

                for (var9 = 0; var9 < var8.field1684; ++var9) {
                    this.field1659[this.field1684] = this.verticesCount + var8.field1659[var9];
                    this.field1660[this.field1684] = this.verticesCount + var8.field1660[var9];
                    this.field1661[this.field1684] = this.verticesCount + var8.field1661[var9];
                    ++this.field1684;
                }

                for (var9 = 0; var9 < var8.verticesCount; ++var9) {
                    this.verticesX[this.verticesCount] = var8.verticesX[var9];
                    this.verticesY[this.verticesCount] = var8.verticesY[var9];
                    this.verticesZ[this.verticesCount] = var8.verticesZ[var9];
                    ++this.verticesCount;
                }
            }
        }

        this.rl$init(var1, var2);
    }

    @ObfuscatedName("f")
    public void method5464() {
        for (int var1 = 0; var1 < this.verticesCount; ++var1) {
            int var2 = this.verticesX[var1];
            this.verticesX[var1] = this.verticesZ[var1];
            this.verticesZ[var1] = -var2;
        }

        this.method5460();
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(Lel;ILel;I[I)V"
    )
    public void method5470(Frames var1, int var2, Frames var3, int var4, int[] var5) {
        if (var2 != -1) {
            if (var5 != null && var4 != -1) {
                Frame var6 = var1.skeletons[var2];
                Frame var7 = var3.skeletons[var4];
                FrameMap var8 = var6.skin;
                animOffsetX = 0;
                animOffsetY = 0;
                animOffsetZ = 0;
                byte var9 = 0;
                int var13 = var9 + 1;
                int var10 = var5[var9];

                int var11;
                int var12;
                for (var11 = 0; var11 < var6.transformCount; ++var11) {
                    for (var12 = var6.transformTypes[var11]; var12 > var10; var10 = var5[var13++]) {
                        ;
                    }

                    if (var12 != var10 || var8.types[var12] == 0) {
                        this.method5463(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
                    }
                }

                animOffsetX = 0;
                animOffsetY = 0;
                animOffsetZ = 0;
                var9 = 0;
                var13 = var9 + 1;
                var10 = var5[var9];

                for (var11 = 0; var11 < var7.transformCount; ++var11) {
                    for (var12 = var7.transformTypes[var11]; var12 > var10; var10 = var5[var13++]) {
                        ;
                    }

                    if (var12 == var10 || var8.types[var12] == 0) {
                        this.method5463(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
                    }
                }

                this.method5460();
            } else {
                this.method5454(var1, var2);
            }
        }
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Z)Ldl;"
    )
    public Model method5453(boolean var1) {
        if (!var1 && field1639.length < this.indicesCount) {
            field1639 = new byte[this.indicesCount + 100];
        }

        return this.method5455(var1, field1641, field1639);
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Z)Ldl;"
    )
    public Model method5465(boolean var1) {
        if (!var1 && field1675.length < this.indicesCount) {
            field1675 = new byte[this.indicesCount + 100];
        }

        return this.method5455(var1, field1640, field1675);
    }

    @ObfuscatedName("af")
    final void method5473(boolean var1, boolean var2, boolean var3, long var4, int bufferOffset) {
        if (this.diameter < 1600) {
            int var6;
            for (var6 = 0; var6 < this.diameter; ++var6) {
                field1686[var6] = 0;
            }

            var6 = var3 ? 20 : 5;

            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var15;
            int var16;
            int var18;
            for (var7 = 0; var7 < this.indicesCount; ++var7) {
                if (this.field1668[var7] != -2) {
                    var8 = this.indices1[var7];
                    var9 = this.indices2[var7];
                    var10 = this.indices3[var7];
                    var11 = modelViewportYs[var8];
                    var12 = modelViewportYs[var9];
                    var13 = modelViewportYs[var10];
                    int var14;
                    if (!var1 || var11 != -5000 && var12 != -5000 && var13 != -5000) {
                        if (var2 && UnitPriceComparator.method547(modelViewportXs[var8], modelViewportXs[var9], modelViewportXs[var10], var11, var12, var13, var6)) {
                            class195.field1714[++class195.Viewport_entityCountAtMouse - 1] = var4;
                            var2 = false;
                        }

                        if ((var11 - var12) * (modelViewportXs[var10] - modelViewportXs[var9]) - (var13 - var12) * (modelViewportXs[var8] - modelViewportXs[var9]) > 0) {
                            field1678[var7] = false;
                            if (var11 >= 0 && var12 >= 0 && var13 >= 0 && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX && var13 <= Graphics3D.rasterClipX) {
                                field1677[var7] = false;
                            } else {
                                field1677[var7] = true;
                            }

                            var14 = (field1681[var8] + field1681[var9] + field1681[var10]) / 3 + this.radius;
                            field1689[var14][field1686[var14]++] = var7;
                        }
                    } else {
                        var14 = yViewportBuffer[var8];
                        var15 = yViewportBuffer[var9];
                        var16 = yViewportBuffer[var10];
                        int var17 = field1683[var8];
                        var18 = field1683[var9];
                        int var19 = field1683[var10];
                        int var20 = field1672[var8];
                        int var21 = field1672[var9];
                        int var22 = field1672[var10];
                        var14 -= var15;
                        var16 -= var15;
                        var17 -= var18;
                        var19 -= var18;
                        var20 -= var21;
                        var22 -= var21;
                        int var23 = var17 * var22 - var20 * var19;
                        int var24 = var20 * var16 - var14 * var22;
                        int var25 = var14 * var19 - var17 * var16;
                        if (var15 * var23 + var18 * var24 + var21 * var25 > 0) {
                            field1678[var7] = true;
                            int var26 = (field1681[var8] + field1681[var9] + field1681[var10]) / 3 + this.radius;
                            field1689[var26][field1686[var26]++] = var7;
                        }
                    }
                }
            }

            int[] var27;
            if (this.field1653 == null) {
                for (var7 = this.diameter - 1; var7 >= 0; --var7) {
                    var8 = field1686[var7];
                    if (var8 > 0) {
                        var27 = field1689[var7];

                        for (var10 = 0; var10 < var8; ++var10) {
                            this.method5474(var27[var10], bufferOffset);
                        }
                    }
                }

            } else {
                for (var7 = 0; var7 < 12; ++var7) {
                    field1688[var7] = 0;
                    field1692[var7] = 0;
                }

                for (var7 = this.diameter - 1; var7 >= 0; --var7) {
                    var8 = field1686[var7];
                    if (var8 > 0) {
                        var27 = field1689[var7];

                        for (var10 = 0; var10 < var8; ++var10) {
                            var11 = var27[var10];
                            byte var33 = this.field1653[var11];
                            var13 = field1688[var33]++;
                            field1670[var33][var13] = var11;
                            if (var33 < 10) {
                                field1692[var33] += var7;
                            } else if (var33 == 10) {
                                field1690[var13] = var7;
                            } else {
                                field1652[var13] = var7;
                            }
                        }
                    }
                }

                var7 = 0;
                if (field1688[1] > 0 || field1688[2] > 0) {
                    var7 = (field1692[1] + field1692[2]) / (field1688[1] + field1688[2]);
                }

                var8 = 0;
                if (field1688[3] > 0 || field1688[4] > 0) {
                    var8 = (field1692[3] + field1692[4]) / (field1688[3] + field1688[4]);
                }

                var9 = 0;
                if (field1688[6] > 0 || field1688[8] > 0) {
                    var9 = (field1692[8] + field1692[6]) / (field1688[8] + field1688[6]);
                }

                var11 = 0;
                var12 = field1688[10];
                int[] var30 = field1670[10];
                int[] var31 = field1690;
                if (var11 == var12) {
                    var11 = 0;
                    var12 = field1688[11];
                    var30 = field1670[11];
                    var31 = field1652;
                }

                if (var11 < var12) {
                    var10 = var31[var11];
                } else {
                    var10 = -1000;
                }

                for (var15 = 0; var15 < 10; ++var15) {
                    while (var15 == 0 && var10 > var7) {
                        this.method5474(var30[var11++], bufferOffset);
                        if (var11 == var12 && var30 != field1670[11]) {
                            var11 = 0;
                            var12 = field1688[11];
                            var30 = field1670[11];
                            var31 = field1652;
                        }

                        if (var11 < var12) {
                            var10 = var31[var11];
                        } else {
                            var10 = -1000;
                        }
                    }

                    while (var15 == 3 && var10 > var8) {
                        this.method5474(var30[var11++], bufferOffset);
                        if (var11 == var12 && var30 != field1670[11]) {
                            var11 = 0;
                            var12 = field1688[11];
                            var30 = field1670[11];
                            var31 = field1652;
                        }

                        if (var11 < var12) {
                            var10 = var31[var11];
                        } else {
                            var10 = -1000;
                        }
                    }

                    while (var15 == 5 && var10 > var9) {
                        this.method5474(var30[var11++], bufferOffset);
                        if (var11 == var12 && var30 != field1670[11]) {
                            var11 = 0;
                            var12 = field1688[11];
                            var30 = field1670[11];
                            var31 = field1652;
                        }

                        if (var11 < var12) {
                            var10 = var31[var11];
                        } else {
                            var10 = -1000;
                        }
                    }

                    var16 = field1688[var15];
                    int[] var32 = field1670[var15];

                    for (var18 = 0; var18 < var16; ++var18) {
                        this.method5474(var32[var18], bufferOffset);
                    }
                }

                while (var10 != -1000) {
                    this.method5474(var30[var11++], bufferOffset);
                    if (var11 == var12 && var30 != field1670[11]) {
                        var11 = 0;
                        var30 = field1670[11];
                        var12 = field1688[11];
                        var31 = field1652;
                    }

                    if (var11 < var12) {
                        var10 = var31[var11];
                    } else {
                        var10 = -1000;
                    }
                }

            }
        }
    }

    @ObfuscatedName("k")
    public void method5522(int var1) {
        int var2 = Model_sine[var1];
        int var3 = Model_cosine[var1];

        for (int var4 = 0; var4 < this.verticesCount; ++var4) {
            int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
            this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
            this.verticesY[var4] = var5;
        }

        this.method5460();
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(ZLdl;[B)Ldl;"
    )
    Model method5455(boolean var1, Model var2, byte[] var3) {
        this.rl$buildSharedModel(var1, var2, var3);
        var2.verticesCount = this.verticesCount;
        var2.indicesCount = this.indicesCount;
        var2.field1684 = this.field1684;
        if (var2.verticesX == null || var2.verticesX.length < this.verticesCount) {
            var2.verticesX = new int[this.verticesCount + 100];
            var2.verticesY = new int[this.verticesCount + 100];
            var2.verticesZ = new int[this.verticesCount + 100];
        }

        int var4;
        for (var4 = 0; var4 < this.verticesCount; ++var4) {
            var2.verticesX[var4] = this.verticesX[var4];
            var2.verticesY[var4] = this.verticesY[var4];
            var2.verticesZ[var4] = this.verticesZ[var4];
        }

        if (var1) {
            var2.field1642 = this.field1642;
        } else {
            var2.field1642 = var3;
            if (this.field1642 == null) {
                for (var4 = 0; var4 < this.indicesCount; ++var4) {
                    var2.field1642[var4] = 0;
                }
            } else {
                for (var4 = 0; var4 < this.indicesCount; ++var4) {
                    var2.field1642[var4] = this.field1642[var4];
                }
            }
        }

        var2.indices1 = this.indices1;
        var2.indices2 = this.indices2;
        var2.indices3 = this.indices3;
        var2.field1650 = this.field1650;
        var2.field1706 = this.field1706;
        var2.field1668 = this.field1668;
        var2.field1653 = this.field1653;
        var2.field1655 = this.field1655;
        var2.field1644 = this.field1644;
        var2.field1657 = this.field1657;
        var2.field1659 = this.field1659;
        var2.field1660 = this.field1660;
        var2.field1661 = this.field1661;
        var2.vertexGroups = this.vertexGroups;
        var2.field1679 = this.field1679;
        var2.field1664 = this.field1664;
        var2.method5460();
        return var2;
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(Lel;I)V"
    )
    public void method5454(Frames var1, int var2) {
        if (this.vertexGroups != null) {
            if (var2 != -1) {
                Frame var3 = var1.skeletons[var2];
                FrameMap var4 = var3.skin;
                animOffsetX = 0;
                animOffsetY = 0;
                animOffsetZ = 0;

                for (int var5 = 0; var5 < var3.transformCount; ++var5) {
                    int var6 = var3.transformTypes[var5];
                    this.method5463(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
                }

                this.method5460();
            }
        }
    }

    @ObfuscatedName("m")
    public int method5459() {
        this.method5457();
        return this.XYZMag;
    }

    @ObfuscatedName("p")
    void method5458() {
        if (this.boundsType != 2) {
            this.boundsType = 2;
            this.XYZMag = 0;

            for (int var1 = 0; var1 < this.verticesCount; ++var1) {
                int var2 = this.verticesX[var1];
                int var3 = this.verticesY[var1];
                int var4 = this.verticesZ[var1];
                int var5 = var2 * var2 + var4 * var4 + var3 * var3;
                if (var5 > this.XYZMag) {
                    this.XYZMag = var5;
                }
            }

            this.XYZMag = (int) (Math.sqrt((double) this.XYZMag) + 0.99D);
            this.radius = this.XYZMag;
            this.diameter = this.XYZMag + this.XYZMag;
        }
    }

    @ObfuscatedName("o")
    public final void method5471(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        field1686[0] = -1;
        if (this.boundsType != 2 && this.boundsType != 1) {
            this.method5458();
        }

        int var9 = Graphics3D.centerX;
        int var10 = Graphics3D.centerY;
        int var11 = Model_sine[var1];
        int var12 = Model_cosine[var1];
        int var13 = Model_sine[var2];
        int var14 = Model_cosine[var2];
        int var15 = Model_sine[var3];
        int var16 = Model_cosine[var3];
        int var17 = Model_sine[var4];
        int var18 = Model_cosine[var4];
        int var19 = var17 * var6 + var18 * var7 >> 16;

        for (int var20 = 0; var20 < this.verticesCount; ++var20) {
            int var21 = this.verticesX[var20];
            int var22 = this.verticesY[var20];
            int var23 = this.verticesZ[var20];
            int var24;
            if (var3 != 0) {
                var24 = var22 * var15 + var21 * var16 >> 16;
                var22 = var22 * var16 - var21 * var15 >> 16;
                var21 = var24;
            }

            if (var1 != 0) {
                var24 = var22 * var12 - var23 * var11 >> 16;
                var23 = var22 * var11 + var23 * var12 >> 16;
                var22 = var24;
            }

            if (var2 != 0) {
                var24 = var23 * var13 + var21 * var14 >> 16;
                var23 = var23 * var14 - var21 * var13 >> 16;
                var21 = var24;
            }

            var21 += var5;
            var22 += var6;
            var23 += var7;
            var24 = var22 * var18 - var23 * var17 >> 16;
            var23 = var22 * var17 + var23 * var18 >> 16;
            field1681[var20] = var23 - var19;
            modelViewportDepth[var20] = var23;
            modelViewportYs[var20] = var9 + var21 * Graphics3D.Rasterizer3D_zoom / var8;
            modelViewportXs[var20] = var10 + var24 * Graphics3D.Rasterizer3D_zoom / var8;
            if (this.field1684 > 0) {
                yViewportBuffer[var20] = var21;
                field1683[var20] = var24;
                field1672[var20] = var23;
            }
        }

        try {
            this.method5473(false, false, false, 0L, 0);
        } catch (Exception var26) {
            ;
        }

    }

    @ObfuscatedName("a")
    public void method5468() {
        for (int var1 = 0; var1 < this.verticesCount; ++var1) {
            this.verticesX[var1] = -this.verticesX[var1];
            this.verticesZ[var1] = -this.verticesZ[var1];
        }

        this.method5460();
    }

    @ObfuscatedName("c")
    void method5456(int var1) {
        if (this.extremeX == -1) {
            int var2 = 0;
            int var3 = 0;
            int var4 = 0;
            int var5 = 0;
            int var6 = 0;
            int var7 = 0;
            int var8 = Model_cosine[var1];
            int var9 = Model_sine[var1];

            for (int var10 = 0; var10 < this.verticesCount; ++var10) {
                int var11 = Graphics3D.method2564(this.verticesX[var10], this.verticesZ[var10], var8, var9);
                int var12 = this.verticesY[var10];
                int var13 = Graphics3D.method2581(this.verticesX[var10], this.verticesZ[var10], var8, var9);
                if (var11 < var2) {
                    var2 = var11;
                }

                if (var11 > var5) {
                    var5 = var11;
                }

                if (var12 < var3) {
                    var3 = var12;
                }

                if (var12 > var6) {
                    var6 = var12;
                }

                if (var13 < var4) {
                    var4 = var13;
                }

                if (var13 > var7) {
                    var7 = var13;
                }
            }

            this.centerX = (var5 + var2) / 2;
            this.centerY = (var6 + var3) / 2;
            this.centerZ = (var7 + var4) / 2;
            this.extremeX = (var5 - var2 + 1) / 2;
            this.extremeY = (var6 - var3 + 1) / 2;
            this.extremeZ = (var7 - var4 + 1) / 2;
            if (this.extremeX < 32) {
                this.extremeX = 32;
            }

            if (this.extremeZ < 32) {
                this.extremeZ = 32;
            }

            if (this.field1664) {
                this.extremeX += 8;
                this.extremeZ += 8;
            }

        }
    }

    @ObfuscatedName("t")
    public void method5480() {
        for (int var1 = 0; var1 < this.verticesCount; ++var1) {
            int var2 = this.verticesZ[var1];
            this.verticesZ[var1] = this.verticesX[var1];
            this.verticesX[var1] = -var2;
        }

        this.method5460();
    }

    @ObfuscatedName("an")
    final void method5474(int var1, int bufferOffset) {
        if (field1678[var1]) {
            this.method5475(var1, bufferOffset);
        } else {
            int var2 = this.indices1[var1];
            int var3 = this.indices2[var1];
            int var4 = this.indices3[var1];
            Graphics3D.rasterClipEnable = field1677[var1];
            if (this.field1642 == null) {
                Graphics3D.rasterAlpha = 0;
            } else {
                Graphics3D.rasterAlpha = this.field1642[var1] & 255;
            }

            if (this.field1644 != null && this.field1644[var1] != -1) {
                int var5;
                int var6;
                int var7;
                if (this.field1655 != null && this.field1655[var1] != -1) {
                    int var8 = this.field1655[var1] & 255;
                    var5 = this.field1659[var8];
                    var6 = this.field1660[var8];
                    var7 = this.field1661[var8];
                } else {
                    var5 = var2;
                    var6 = var3;
                    var7 = var4;
                }

                if (this.field1668[var1] == -1) {
                    Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1650[var1], this.field1650[var1], this.field1650[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1683[var5], field1683[var6], field1683[var7], field1672[var5], field1672[var6], field1672[var7], this.field1644[var1], modelViewportDepth[var2], modelViewportDepth[var3], modelViewportDepth[var4], bufferOffset);
                } else {
                    Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1650[var1], this.field1706[var1], this.field1668[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1683[var5], field1683[var6], field1683[var7], field1672[var5], field1672[var6], field1672[var7], this.field1644[var1], modelViewportDepth[var2], modelViewportDepth[var3], modelViewportDepth[var4], bufferOffset);
                }
            } else if (this.field1668[var1] == -1) {
                Graphics3D.rasterFlat(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], field1704[this.field1650[var1]], modelViewportDepth[var2], modelViewportDepth[var3], modelViewportDepth[var4], bufferOffset);
            } else {
                Graphics3D.rasterGouraud(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1650[var1], this.field1706[var1], this.field1668[var1], modelViewportDepth[var2], modelViewportDepth[var3], modelViewportDepth[var4], bufferOffset);
            }

        }
    }

    public int[] getTrianglesX() {
        return this.indices1;
    }

    public int[][] getVertexGroups() {
        return this.vertexGroups;
    }

    public List getVertices() {
        int[] var1 = this.getVerticesX();
        int[] var2 = this.getVerticesY();
        int[] var3 = this.getVerticesZ();
        ArrayList var4 = new ArrayList();

        for (int var5 = 0; var5 < this.getVerticesCount(); ++var5) {
            Vertex var6 = new Vertex(var1[var5], var2[var5], var3[var5]);
            var4.add(var6);
        }

        return var4;
    }

    public void rl$buildSharedModel(boolean var1, net.runelite.api.Model var2, byte[] var3) {
        RSModel var4 = (RSModel) var2;
        var4.setFaceTextureUCoordinates(this.rl$faceTextureUCoordinates);
        var4.setFaceTextureVCoordinates(this.rl$faceTextureVCoordinates);
    }

    @ObfuscatedSignature(
            signature = "([[IIIIZI)Ldl;"
    )
    @Export("copy$contourGround")
    public Model copy$contourGround(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
        this.method5457();
        int var7 = var2 - this.XYZMag;
        int var8 = var2 + this.XYZMag;
        int var9 = var4 - this.XYZMag;
        int var10 = var4 + this.XYZMag;
        if (var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
            var7 >>= 7;
            var8 = var8 + 127 >> 7;
            var9 >>= 7;
            var10 = var10 + 127 >> 7;
            if (var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
                return this;
            } else {
                Model var11;
                if (var5) {
                    var11 = new Model();
                    var11.verticesCount = this.verticesCount;
                    var11.indicesCount = this.indicesCount;
                    var11.field1684 = this.field1684;
                    var11.verticesX = this.verticesX;
                    var11.verticesZ = this.verticesZ;
                    var11.indices1 = this.indices1;
                    var11.indices2 = this.indices2;
                    var11.indices3 = this.indices3;
                    var11.field1650 = this.field1650;
                    var11.field1706 = this.field1706;
                    var11.field1668 = this.field1668;
                    var11.field1653 = this.field1653;
                    var11.field1642 = this.field1642;
                    var11.field1655 = this.field1655;
                    var11.field1644 = this.field1644;
                    var11.field1657 = this.field1657;
                    var11.field1659 = this.field1659;
                    var11.field1660 = this.field1660;
                    var11.field1661 = this.field1661;
                    var11.vertexGroups = this.vertexGroups;
                    var11.field1679 = this.field1679;
                    var11.field1664 = this.field1664;
                    var11.verticesY = new int[var11.verticesCount];
                } else {
                    var11 = this;
                }

                int var12;
                int var13;
                int var14;
                int var15;
                int var16;
                int var17;
                int var18;
                int var19;
                int var20;
                int var21;
                if (var6 == 0) {
                    for (var12 = 0; var12 < var11.verticesCount; ++var12) {
                        var13 = var2 + this.verticesX[var12];
                        var14 = var4 + this.verticesZ[var12];
                        var15 = var13 & 127;
                        var16 = var14 & 127;
                        var17 = var13 >> 7;
                        var18 = var14 >> 7;
                        var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                        var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                        var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                        var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
                    }
                } else {
                    for (var12 = 0; var12 < var11.verticesCount; ++var12) {
                        var13 = (-this.verticesY[var12] << 16) / super.modelHeight;
                        if (var13 < var6) {
                            var14 = var2 + this.verticesX[var12];
                            var15 = var4 + this.verticesZ[var12];
                            var16 = var14 & 127;
                            var17 = var15 & 127;
                            var18 = var14 >> 7;
                            var19 = var15 >> 7;
                            var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                            var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                            int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                            var11.verticesY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.verticesY[var12];
                        }
                    }
                }

                var11.method5460();
                return var11;
            }
        } else {
            return this;
        }
    }

    public int[] getVerticesX() {
        return this.verticesX;
    }

    public int[] getTrianglesY() {
        return this.indices2;
    }

    public void setFaceTextureUCoordinates(float[][] var1) {
        this.rl$faceTextureUCoordinates = var1;
    }

    public int[] getVerticesY() {
        return this.verticesY;
    }

    public int[] getTrianglesZ() {
        return this.indices3;
    }

    public void setFaceTextureVCoordinates(float[][] var1) {
        this.rl$faceTextureVCoordinates = var1;
    }

    public int[] getVerticesZ() {
        return this.verticesZ;
    }

    public int getVerticesCount() {
        return this.verticesCount;
    }

    public int getTrianglesCount() {
        return this.indicesCount;
    }

    @Export("interpolateFrames")
    public void interpolateFrames(RSFrameMap var1, RSFrame var2, RSFrame var3, int var4, int var5) {
        int var6;
        int var7;
        if (var3 != null && var4 != 0) {
            var6 = 0;
            var7 = 0;

            for (int var8 = 0; var8 < var1.getCount(); ++var8) {
                boolean var9 = false;
                if (var6 < var2.getTransformCount() && var2.getTransformTypes()[var6] == var8) {
                    var9 = true;
                }

                boolean var10 = false;
                if (var7 < var3.getTransformCount() && var3.getTransformTypes()[var7] == var8) {
                    var10 = true;
                }

                if (var9 || var10) {
                    short var11 = 0;
                    int var12 = var1.getTypes()[var8];
                    if (var12 == 3 || var12 == 10) {
                        var11 = 128;
                    }

                    int var13 = var11;
                    int var14 = var11;
                    int var15 = var11;
                    if (var9) {
                        var13 = var2.getTranslatorX()[var6];
                        var14 = var2.getTranslatorY()[var6];
                        var15 = var2.getTranslatorZ()[var6];
                        ++var6;
                    }

                    int var16 = var11;
                    int var17 = var11;
                    int var18 = var11;
                    if (var10) {
                        var16 = var3.getTranslatorX()[var7];
                        var17 = var3.getTranslatorY()[var7];
                        var18 = var3.getTranslatorZ()[var7];
                        ++var7;
                    }

                    int var19;
                    int var20;
                    int var21;
                    if (var12 == 2) {
                        int var22 = var16 - var13 & 255;
                        int var23 = var17 - var14 & 255;
                        int var24 = var18 - var15 & 255;
                        if (var22 >= 128) {
                            var22 -= 256;
                        }

                        if (var23 >= 128) {
                            var23 -= 256;
                        }

                        if (var24 >= 128) {
                            var24 -= 256;
                        }

                        var19 = var13 + var22 * var4 / var5 & 255;
                        var20 = var14 + var23 * var4 / var5 & 255;
                        var21 = var15 + var24 * var4 / var5 & 255;
                    } else if (var12 == 5) {
                        var19 = var13;
                        var20 = 0;
                        var21 = 0;
                    } else {
                        var19 = var13 + (var16 - var13) * var4 / var5;
                        var20 = var14 + (var17 - var14) * var4 / var5;
                        var21 = var15 + (var18 - var15) * var4 / var5;
                    }

                    this.animate(var12, var1.getList()[var8], var19, var20, var21);
                }
            }
        } else {
            for (var6 = 0; var6 < var2.getTransformCount(); ++var6) {
                var7 = var2.getTransformTypes()[var6];
                this.animate(var1.getTypes()[var7], var1.getList()[var7], var2.getTranslatorX()[var6], var2.getTranslatorY()[var6], var2.getTranslatorZ()[var6]);
            }
        }

    }

    public void resetBounds() {
        this.method5460();
    }

    public void animate(int var1, int[] var2, int var3, int var4, int var5) {
        this.method5463(var1, var2, var3, var4, var5);
    }

    public void rl$init(RSModel[] var1, int var2) {
        int var3 = 0;

        for (int var4 = 0; var4 < var2; ++var4) {
            RSModel var5 = var1[var4];
            if (var5 != null) {
                var3 += var5.getTrianglesCount();
            }
        }

        float[][] var12 = new float[var3][];
        float[][] var13 = new float[var3][];
        int var6 = 0;

        for (int var7 = 0; var7 < var2; ++var7) {
            RSModel var8 = var1[var7];
            if (var8 != null) {
                float[][] var9 = var8.getFaceTextureUCoordinates();
                float[][] var10 = var8.getFaceTextureVCoordinates();

                for (int var11 = 0; var11 < var8.getTrianglesCount(); ++var11) {
                    if (var9 != null && var10 != null) {
                        var12[var6] = var9[var11];
                        var13[var6] = var10[var11];
                    }

                    ++var6;
                }
            }
        }

        this.setFaceTextureUCoordinates(var12);
        this.setFaceTextureVCoordinates(var13);
    }

    public List getTriangles() {
        int[] var1 = this.getTrianglesX();
        int[] var2 = this.getTrianglesY();
        int[] var3 = this.getTrianglesZ();
        List var4 = this.getVertices();
        ArrayList var5 = new ArrayList(this.getTrianglesCount());

        for (int var6 = 0; var6 < this.getTrianglesCount(); ++var6) {
            int var7 = var1[var6];
            int var8 = var2[var6];
            int var9 = var3[var6];
            Triangle var10 = new Triangle((Vertex) var4.get(var7), (Vertex) var4.get(var8), (Vertex) var4.get(var9));
            var5.add(var10);
        }

        return var5;
    }

    public void interpolateFrames(RSFrames var1, int var2, RSFrames var3, int var4, int var5, int var6) {
        if (this.getVertexGroups() != null && var2 != -1) {
            RSFrame var7 = var1.getFrames()[var2];
            RSFrameMap var8 = var7.getSkin();
            RSFrame var9 = null;
            if (var3 != null) {
                var9 = var3.getFrames()[var4];
                if (var9.getSkin() != var8) {
                    var9 = null;
                }
            }

            class166.clientInstance.setAnimOffsetX(0);
            class166.clientInstance.setAnimOffsetY(0);
            class166.clientInstance.setAnimOffsetZ(0);
            this.interpolateFrames(var8, var7, var9, var5, var6);
            this.resetBounds();
        }

    }

    public Polygon getConvexHull(int var1, int var2, int var3) {
        List var4 = this.getVertices();

        for (int var5 = 0; var5 < var4.size(); ++var5) {
            Vertex var6 = (Vertex) var4.get(var5);
            var4.set(var5, var6.rotate(var3));
        }

        ArrayList var9 = new ArrayList();
        Iterator var10 = var4.iterator();

        Point var8;
        while (var10.hasNext()) {
            Vertex var7 = (Vertex) var10.next();
            var8 = Perspective.localToCanvas(class166.clientInstance, new LocalPoint(var1 - var7.getX(), var2 - var7.getZ()), class166.clientInstance.getPlane(), -var7.getY());
            if (var8 != null) {
                var9.add(var8);
            }
        }

        List var13 = Jarvis.convexHull(var9);
        if (var13 == null) {
            return null;
        } else {
            Polygon var11 = new Polygon();
            Iterator var12 = var13.iterator();

            while (var12.hasNext()) {
                var8 = (Point) var12.next();
                var11.addPoint(var8.getX(), var8.getY());
            }

            return var11;
        }
    }

    public int getSceneId() {
        return this.rl$sceneId;
    }

    public void setSceneId(int var1) {
        this.rl$sceneId = var1;
    }

    public int getBufferOffset() {
        return this.rl$bufferOffset;
    }

    public void setBufferOffset(int var1) {
        this.rl$bufferOffset = var1;
    }

    public int getUvBufferOffset() {
        return this.rl$uvBufferOffset;
    }

    public void setUvBufferOffset(int var1) {
        this.rl$uvBufferOffset = var1;
    }

    public float[][] getFaceTextureUCoordinates() {
        return this.rl$faceTextureUCoordinates;
    }

    public float[][] getFaceTextureVCoordinates() {
        return this.rl$faceTextureVCoordinates;
    }

    public int[] getFaceColors1() {
        return this.field1650;
    }

    public int[] getFaceColors2() {
        return this.field1706;
    }

    public int[] getFaceColors3() {
        return this.field1668;
    }

    public byte[] getFaceRenderPriorities() {
        return this.field1653;
    }

    public byte[] getTriangleTransparencies() {
        return this.field1642;
    }

    public short[] getFaceTextures() {
        return this.field1644;
    }

    public boolean isClickable() {
        return this.field1664;
    }

    public int getXYZMag() {
        return this.XYZMag;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getCenterX() {
        return this.centerX;
    }

    public int getCenterY() {
        return this.centerY;
    }

    public int getCenterZ() {
        return this.centerZ;
    }

    public int getExtremeX() {
        return this.extremeX;
    }

    public int getExtremeY() {
        return this.extremeY;
    }

    public int getExtremeZ() {
        return this.extremeZ;
    }

    public RSModel toSharedModel(boolean var1) {
        return this.method5453(var1);
    }

    public RSModel toSharedSpotAnimModel(boolean var1) {
        return this.method5465(var1);
    }

    public void calculateExtreme(int var1) {
        this.method5456(var1);
    }

    public void calculateBoundsCylinder() {
        this.method5457();
    }

    public void rotateY90Ccw() {
        this.method5464();
    }

    public void rotateY180Ccw() {
        this.method5468();
    }

    public void rotateY270Ccw() {
        this.method5480();
    }

    @ObfuscatedName("i")
    public void method5457() {
        if (this.boundsType != 1) {
            this.boundsType = 1;
            super.modelHeight = 0;
            this.bottomY = 0;
            this.XYZMag = 0;

            for (int var1 = 0; var1 < this.verticesCount; ++var1) {
                int var2 = this.verticesX[var1];
                int var3 = this.verticesY[var1];
                int var4 = this.verticesZ[var1];
                if (-var3 > super.modelHeight) {
                    super.modelHeight = -var3;
                }

                if (var3 > this.bottomY) {
                    this.bottomY = var3;
                }

                int var5 = var2 * var2 + var4 * var4;
                if (var5 > this.XYZMag) {
                    this.XYZMag = var5;
                }
            }

            this.XYZMag = (int) (Math.sqrt((double) this.XYZMag) + 0.99D);
            this.radius = (int) (Math.sqrt((double) (this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
            this.diameter = this.radius + (int) (Math.sqrt((double) (this.XYZMag * this.XYZMag + this.bottomY * this.bottomY)) + 0.99D);
        }
    }

    @ObfuscatedName("y")
    public void method5462(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < this.verticesCount; ++var4) {
            this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
            this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
            this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
        }

        this.method5460();
    }

    @ObfuscatedName("ax")
    final void method5475(int var1, int bufferOffset) {
        int var2 = Graphics3D.centerX;
        int var3 = Graphics3D.centerY;
        int var4 = 0;
        int var5 = this.indices1[var1];
        int var6 = this.indices2[var1];
        int var7 = this.indices3[var1];
        int var8 = field1672[var5];
        int var9 = field1672[var6];
        int var10 = field1672[var7];
        if (this.field1642 == null) {
            Graphics3D.rasterAlpha = 0;
        } else {
            Graphics3D.rasterAlpha = this.field1642[var1] & 255;
        }

        int var11;
        int var12;
        int var13;
        int var14;
        if (var8 >= 50) {
            field1693[var4] = modelViewportYs[var5];
            field1698[var4] = modelViewportXs[var5];
            xViewportBuffer[var4++] = this.field1650[var1];
        } else {
            var11 = yViewportBuffer[var5];
            var12 = field1683[var5];
            var13 = this.field1650[var1];
            if (var10 >= 50) {
                var14 = field1705[var10 - var8] * (50 - var8);
                field1693[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
                field1698[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1683[var7] - var12) * var14 >> 16)) / 50;
                xViewportBuffer[var4++] = var13 + ((this.field1668[var1] - var13) * var14 >> 16);
            }

            if (var9 >= 50) {
                var14 = field1705[var9 - var8] * (50 - var8);
                field1693[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
                field1698[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1683[var6] - var12) * var14 >> 16)) / 50;
                xViewportBuffer[var4++] = var13 + ((this.field1706[var1] - var13) * var14 >> 16);
            }
        }

        if (var9 >= 50) {
            field1693[var4] = modelViewportYs[var6];
            field1698[var4] = modelViewportXs[var6];
            xViewportBuffer[var4++] = this.field1706[var1];
        } else {
            var11 = yViewportBuffer[var6];
            var12 = field1683[var6];
            var13 = this.field1706[var1];
            if (var8 >= 50) {
                var14 = field1705[var8 - var9] * (50 - var9);
                field1693[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
                field1698[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1683[var5] - var12) * var14 >> 16)) / 50;
                xViewportBuffer[var4++] = var13 + ((this.field1650[var1] - var13) * var14 >> 16);
            }

            if (var10 >= 50) {
                var14 = field1705[var10 - var9] * (50 - var9);
                field1693[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
                field1698[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1683[var7] - var12) * var14 >> 16)) / 50;
                xViewportBuffer[var4++] = var13 + ((this.field1668[var1] - var13) * var14 >> 16);
            }
        }

        if (var10 >= 50) {
            field1693[var4] = modelViewportYs[var7];
            field1698[var4] = modelViewportXs[var7];
            xViewportBuffer[var4++] = this.field1668[var1];
        } else {
            var11 = yViewportBuffer[var7];
            var12 = field1683[var7];
            var13 = this.field1668[var1];
            if (var9 >= 50) {
                var14 = field1705[var9 - var10] * (50 - var10);
                field1693[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
                field1698[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1683[var6] - var12) * var14 >> 16)) / 50;
                xViewportBuffer[var4++] = var13 + ((this.field1706[var1] - var13) * var14 >> 16);
            }

            if (var8 >= 50) {
                var14 = field1705[var8 - var10] * (50 - var10);
                field1693[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
                field1698[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1683[var5] - var12) * var14 >> 16)) / 50;
                xViewportBuffer[var4++] = var13 + ((this.field1650[var1] - var13) * var14 >> 16);
            }
        }

        var11 = field1693[0];
        var12 = field1693[1];
        var13 = field1693[2];
        var14 = field1698[0];
        int var15 = field1698[1];
        int var16 = field1698[2];
        Graphics3D.rasterClipEnable = false;
        int var17;
        int var18;
        int var19;
        int var20;
        if (var4 == 3) {
            if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
                Graphics3D.rasterClipEnable = true;
            }

            if (this.field1644 != null && this.field1644[var1] != -1) {
                if (this.field1655 != null && this.field1655[var1] != -1) {
                    var20 = this.field1655[var1] & 255;
                    var17 = this.field1659[var20];
                    var18 = this.field1660[var20];
                    var19 = this.field1661[var20];
                } else {
                    var17 = var5;
                    var18 = var6;
                    var19 = var7;
                }

                if (this.field1668[var1] == -1) {
                    Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1650[var1], this.field1650[var1], this.field1650[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1683[var17], field1683[var18], field1683[var19], field1672[var17], field1672[var18], field1672[var19], this.field1644[var1], modelViewportDepth[var5], modelViewportDepth[var6], modelViewportDepth[var7], bufferOffset);
                } else {
                    Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1683[var17], field1683[var18], field1683[var19], field1672[var17], field1672[var18], field1672[var19], this.field1644[var1], modelViewportDepth[var5], modelViewportDepth[var6], modelViewportDepth[var7], bufferOffset);
                }
            } else if (this.field1668[var1] == -1) {
                Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1704[this.field1650[var1]], modelViewportDepth[var5], modelViewportDepth[var6], modelViewportDepth[var7], bufferOffset);
            } else {
                Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], modelViewportDepth[var5], modelViewportDepth[var6], modelViewportDepth[var7], bufferOffset);
            }
        }

        if (var4 == 4) {
            if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1693[3] < 0 || field1693[3] > Graphics3D.rasterClipX) {
                Graphics3D.rasterClipEnable = true;
            }

            if (this.field1644 != null && this.field1644[var1] != -1) {
                if (this.field1655 != null && this.field1655[var1] != -1) {
                    var20 = this.field1655[var1] & 255;
                    var17 = this.field1659[var20];
                    var18 = this.field1660[var20];
                    var19 = this.field1661[var20];
                } else {
                    var17 = var5;
                    var18 = var6;
                    var19 = var7;
                }

                short var21 = this.field1644[var1];
                if (this.field1668[var1] == -1) {
                    Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1650[var1], this.field1650[var1], this.field1650[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1683[var17], field1683[var18], field1683[var19], field1672[var17], field1672[var18], field1672[var19], var21, modelViewportDepth[var5], modelViewportDepth[var6], modelViewportDepth[var7], bufferOffset);
                    Graphics3D.rasterTextureAffine(var14, var16, field1698[3], var11, var13, field1693[3], this.field1650[var1], this.field1650[var1], this.field1650[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1683[var17], field1683[var18], field1683[var19], field1672[var17], field1672[var18], field1672[var19], var21, modelViewportDepth[var5], modelViewportDepth[var6], modelViewportDepth[var7], bufferOffset);
                } else {
                    Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1683[var17], field1683[var18], field1683[var19], field1672[var17], field1672[var18], field1672[var19], var21, modelViewportDepth[var5], modelViewportDepth[var6], modelViewportDepth[var7], bufferOffset);
                    Graphics3D.rasterTextureAffine(var14, var16, field1698[3], var11, var13, field1693[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1683[var17], field1683[var18], field1683[var19], field1672[var17], field1672[var18], field1672[var19], var21, modelViewportDepth[var5], modelViewportDepth[var6], modelViewportDepth[var7], bufferOffset);
                }
            } else if (this.field1668[var1] == -1) {
                var17 = field1704[this.field1650[var1]];
                Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17, modelViewportDepth[var5], modelViewportDepth[var6], modelViewportDepth[var7], bufferOffset);
                Graphics3D.rasterFlat(var14, var16, field1698[3], var11, var13, field1693[3], var17, modelViewportDepth[var5], modelViewportDepth[var6], modelViewportDepth[var7], bufferOffset);
            } else {
                Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], modelViewportDepth[var5], modelViewportDepth[var6], modelViewportDepth[var7], bufferOffset);
                Graphics3D.rasterGouraud(var14, var16, field1698[3], var11, var13, field1693[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], modelViewportDepth[var5], modelViewportDepth[var6], modelViewportDepth[var7], bufferOffset);
            }
        }

    }

    @ObfuscatedName("j")
    void method5460() {
        this.boundsType = 0;
        this.extremeX = -1;
    }

    @ObfuscatedName("s")
    public void method5469(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < this.verticesCount; ++var4) {
            this.verticesX[var4] += var1;
            this.verticesY[var4] += var2;
            this.verticesZ[var4] += var3;
        }

        this.method5460();
    }

    @ObfuscatedName("cf")
    void vmethod5472(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9, int bufferOffset) {
        field1686[0] = -1;
        if (this.boundsType != 1) {
            this.method5457();
        }

        this.method5456(var1);
        int var11 = var5 * var8 - var4 * var6 >> 16;
        int var12 = var2 * var7 + var3 * var11 >> 16;
        int var13 = var3 * this.XYZMag >> 16;
        int var14 = var12 + var13;
        if (var14 > 50 && var12 < 3500) {
            int var15 = var8 * var4 + var5 * var6 >> 16;
            int var16 = (var15 - this.XYZMag) * Graphics3D.Rasterizer3D_zoom;
            if (var16 / var14 < Graphics3D.Rasterizer3D_clipMidX2) {
                int var17 = (var15 + this.XYZMag) * Graphics3D.Rasterizer3D_zoom;
                if (var17 / var14 > Graphics3D.Rasterizer3D_clipNegativeMidX) {
                    int var18 = var3 * var7 - var11 * var2 >> 16;
                    int var19 = var2 * this.XYZMag >> 16;
                    int var20 = (var18 + var19) * Graphics3D.Rasterizer3D_zoom;
                    if (var20 / var14 > Graphics3D.Rasterizer3D_clipNegativeMidY) {
                        int var21 = (var3 * super.modelHeight >> 16) + var19;
                        int var22 = (var18 - var21) * Graphics3D.Rasterizer3D_zoom;
                        if (var22 / var14 < Graphics3D.Rasterizer3D_clipMidY2) {
                            int var23 = var13 + (var2 * super.modelHeight >> 16);
                            boolean var24 = false;
                            boolean var25 = false;
                            if (var12 - var23 <= 50) {
                                var25 = true;
                            }

                            boolean var26 = var25 || this.field1684 > 0;
                            int var27 = class195.Viewport_mouseX;
                            int var29 = PathingEntity.method2730();
                            boolean var30 = class195.Viewport_containsMouse;
                            boolean var32 = WorldMapDecoration.method2946(var9);
                            boolean var33 = false;
                            int var35;
                            int var36;
                            int var37;
                            if (var32 && var30) {
                                boolean var34 = false;
                                if (useBoundingBoxes3D) {
                                    var34 = ScriptState.method422(this, var6, var7, var8);
                                } else {
                                    var35 = var12 - var13;
                                    if (var35 <= 50) {
                                        var35 = 50;
                                    }

                                    if (var15 > 0) {
                                        var16 /= var14;
                                        var17 /= var35;
                                    } else {
                                        var17 /= var14;
                                        var16 /= var35;
                                    }

                                    if (var18 > 0) {
                                        var22 /= var14;
                                        var20 /= var35;
                                    } else {
                                        var20 /= var14;
                                        var22 /= var35;
                                    }

                                    var36 = var27 - Graphics3D.centerX;
                                    var37 = var29 - Graphics3D.centerY;
                                    if (var36 > var16 && var36 < var17 && var37 > var22 && var37 < var20) {
                                        var34 = true;
                                    }
                                }

                                if (var34) {
                                    if (this.field1664) {
                                        class195.field1714[++class195.Viewport_entityCountAtMouse - 1] = var9;
                                    } else {
                                        var33 = true;
                                    }
                                }
                            }

                            int var47 = Graphics3D.centerX;
                            var35 = Graphics3D.centerY;
                            var36 = 0;
                            var37 = 0;
                            if (var1 != 0) {
                                var36 = Model_sine[var1];
                                var37 = Model_cosine[var1];
                            }

                            for (int var38 = 0; var38 < this.verticesCount; ++var38) {
                                int var39 = this.verticesX[var38];
                                int var40 = this.verticesY[var38];
                                int var41 = this.verticesZ[var38];
                                int var42;
                                if (var1 != 0) {
                                    var42 = var41 * var36 + var39 * var37 >> 16;
                                    var41 = var41 * var37 - var39 * var36 >> 16;
                                    var39 = var42;
                                }

                                var39 += var6;
                                var40 += var7;
                                var41 += var8;
                                var42 = var41 * var4 + var5 * var39 >> 16;
                                var41 = var5 * var41 - var39 * var4 >> 16;
                                var39 = var42;
                                var42 = var3 * var40 - var41 * var2 >> 16;
                                var41 = var40 * var2 + var3 * var41 >> 16;
                                field1681[var38] = var41 - var12;
                                modelViewportDepth[var38] = var41;
                                if (var41 >= 50) {
                                    modelViewportYs[var38] = var39 * Graphics3D.Rasterizer3D_zoom / var41 + var47;
                                    modelViewportXs[var38] = var42 * Graphics3D.Rasterizer3D_zoom / var41 + var35;
                                } else {
                                    modelViewportYs[var38] = -5000;
                                    var24 = true;
                                }

                                if (var26) {
                                    yViewportBuffer[var38] = var39;
                                    field1683[var38] = var42;
                                    field1672[var38] = var41;
                                }
                            }

                            try {
                                this.method5473(var24, var33, this.field1664, var9, bufferOffset);
                            } catch (Exception var46) {
                                ;
                            }

                        }
                    }
                }
            }
        }
    }

    @ObfuscatedName("h")
    void method5463(int var1, int[] var2, int var3, int var4, int var5) {
        int var6 = var2.length;
        int var7;
        int var8;
        int var11;
        int var12;
        if (var1 == 0) {
            var7 = 0;
            animOffsetX = 0;
            animOffsetY = 0;
            animOffsetZ = 0;

            for (var8 = 0; var8 < var6; ++var8) {
                int var9 = var2[var8];
                if (var9 < this.vertexGroups.length) {
                    int[] var10 = this.vertexGroups[var9];

                    for (var11 = 0; var11 < var10.length; ++var11) {
                        var12 = var10[var11];
                        animOffsetX += this.verticesX[var12];
                        animOffsetY += this.verticesY[var12];
                        animOffsetZ += this.verticesZ[var12];
                        ++var7;
                    }
                }
            }

            if (var7 > 0) {
                animOffsetX = var3 + animOffsetX / var7;
                animOffsetY = var4 + animOffsetY / var7;
                animOffsetZ = var5 + animOffsetZ / var7;
            } else {
                animOffsetX = var3;
                animOffsetY = var4;
                animOffsetZ = var5;
            }

        } else {
            int[] var18;
            int var19;
            if (var1 == 1) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < this.vertexGroups.length) {
                        var18 = this.vertexGroups[var8];

                        for (var19 = 0; var19 < var18.length; ++var19) {
                            var11 = var18[var19];
                            this.verticesX[var11] += var3;
                            this.verticesY[var11] += var4;
                            this.verticesZ[var11] += var5;
                        }
                    }
                }

            } else if (var1 == 2) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < this.vertexGroups.length) {
                        var18 = this.vertexGroups[var8];

                        for (var19 = 0; var19 < var18.length; ++var19) {
                            var11 = var18[var19];
                            this.verticesX[var11] -= animOffsetX;
                            this.verticesY[var11] -= animOffsetY;
                            this.verticesZ[var11] -= animOffsetZ;
                            var12 = (var3 & 255) * 8;
                            int var13 = (var4 & 255) * 8;
                            int var14 = (var5 & 255) * 8;
                            int var15;
                            int var16;
                            int var17;
                            if (var14 != 0) {
                                var15 = Model_sine[var14];
                                var16 = Model_cosine[var14];
                                var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                                this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                                this.verticesX[var11] = var17;
                            }

                            if (var12 != 0) {
                                var15 = Model_sine[var12];
                                var16 = Model_cosine[var12];
                                var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                                this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                                this.verticesY[var11] = var17;
                            }

                            if (var13 != 0) {
                                var15 = Model_sine[var13];
                                var16 = Model_cosine[var13];
                                var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                                this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                                this.verticesX[var11] = var17;
                            }

                            this.verticesX[var11] += animOffsetX;
                            this.verticesY[var11] += animOffsetY;
                            this.verticesZ[var11] += animOffsetZ;
                        }
                    }
                }

            } else if (var1 == 3) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < this.vertexGroups.length) {
                        var18 = this.vertexGroups[var8];

                        for (var19 = 0; var19 < var18.length; ++var19) {
                            var11 = var18[var19];
                            this.verticesX[var11] -= animOffsetX;
                            this.verticesY[var11] -= animOffsetY;
                            this.verticesZ[var11] -= animOffsetZ;
                            this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                            this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                            this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                            this.verticesX[var11] += animOffsetX;
                            this.verticesY[var11] += animOffsetY;
                            this.verticesZ[var11] += animOffsetZ;
                        }
                    }
                }

            } else if (var1 == 5) {
                if (this.field1679 != null && this.field1642 != null) {
                    for (var7 = 0; var7 < var6; ++var7) {
                        var8 = var2[var7];
                        if (var8 < this.field1679.length) {
                            var18 = this.field1679[var8];

                            for (var19 = 0; var19 < var18.length; ++var19) {
                                var11 = var18[var19];
                                var12 = (this.field1642[var11] & 255) + var3 * 8;
                                if (var12 < 0) {
                                    var12 = 0;
                                } else if (var12 > 255) {
                                    var12 = 255;
                                }

                                this.field1642[var11] = (byte) var12;
                            }
                        }
                    }
                }

            }
        }
    }

    @ObfuscatedName("u")
    public final void method5509(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        field1686[0] = -1;
        if (this.boundsType != 2 && this.boundsType != 1) {
            this.method5458();
        }

        int var8 = Graphics3D.centerX;
        int var9 = Graphics3D.centerY;
        int var10 = Model_sine[var1];
        int var11 = Model_cosine[var1];
        int var12 = Model_sine[var2];
        int var13 = Model_cosine[var2];
        int var14 = Model_sine[var3];
        int var15 = Model_cosine[var3];
        int var16 = Model_sine[var4];
        int var17 = Model_cosine[var4];
        int var18 = var16 * var6 + var17 * var7 >> 16;

        for (int var19 = 0; var19 < this.verticesCount; ++var19) {
            int var20 = this.verticesX[var19];
            int var21 = this.verticesY[var19];
            int var22 = this.verticesZ[var19];
            int var23;
            if (var3 != 0) {
                var23 = var21 * var14 + var20 * var15 >> 16;
                var21 = var21 * var15 - var20 * var14 >> 16;
                var20 = var23;
            }

            if (var1 != 0) {
                var23 = var21 * var11 - var22 * var10 >> 16;
                var22 = var21 * var10 + var22 * var11 >> 16;
                var21 = var23;
            }

            if (var2 != 0) {
                var23 = var22 * var12 + var20 * var13 >> 16;
                var22 = var22 * var13 - var20 * var12 >> 16;
                var20 = var23;
            }

            var20 += var5;
            var21 += var6;
            var22 += var7;
            var23 = var21 * var17 - var22 * var16 >> 16;
            var22 = var21 * var16 + var22 * var17 >> 16;
            field1681[var19] = var22 - var18;
            modelViewportDepth[var19] = var22;
            modelViewportYs[var19] = var20 * Graphics3D.Rasterizer3D_zoom / var22 + var8;
            modelViewportXs[var19] = var23 * Graphics3D.Rasterizer3D_zoom / var22 + var9;
            if (this.field1684 > 0) {
                yViewportBuffer[var19] = var20;
                field1683[var19] = var23;
                field1672[var19] = var22;
            }
        }

        try {
            this.method5473(false, false, false, 0L, 0);
        } catch (Exception var25) {
            ;
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "([[IIIIZI)Ldl;"
    )
    public Model method5452(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
        Model var7 = this.copy$contourGround(var1, var2, var3, var4, var5, var6);
        if (var7 != null && var7 != this) {
            RSModel var8 = (RSModel) var7;
            var8.setFaceTextureUCoordinates(this.rl$faceTextureUCoordinates);
            var8.setFaceTextureVCoordinates(this.rl$faceTextureVCoordinates);
        }

        return var7;
    }
}
