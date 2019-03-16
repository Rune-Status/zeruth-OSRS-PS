package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFontTypeFace;

import java.util.Random;

@ObfuscatedName("kx")
@Implements("FontTypeFace")
public abstract class FontTypeFace extends Rasterizer2D implements RSFontTypeFace {
    @ObfuscatedName("f")
    static int field3776;
    @ObfuscatedName("v")
    static int prevColorRGB;
    @ObfuscatedName("k")
    static Random field3771;
    @ObfuscatedName("x")
    static int shadow;
    @ObfuscatedName("m")
    static int strikeRGB;
    @ObfuscatedName("a")
    static int field3780;
    @ObfuscatedName("z")
    static String[] field3775;
    @ObfuscatedName("t")
    static int field3778;
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "[Lli;"
    )
    public static IndexedSprite[] modIcons;
    @ObfuscatedName("d")
    static int underlineRGB;
    @ObfuscatedName("j")
    static int prevShadeRGB;
    @ObfuscatedName("h")
    static int color;
    @ObfuscatedName("l")
    int[] verticalOffsets;
    @ObfuscatedName("r")
    int[] field3779;
    @ObfuscatedName("e")
    int[] gylphHeights;
    @ObfuscatedName("w")
    public int minSpacing;
    @ObfuscatedName("q")
    int[] glyphWidths;
    @ObfuscatedName("p")
    byte[] field3769;
    @ObfuscatedName("b")
    public int verticalSpace;
    @ObfuscatedName("n")
    public int maxSpacing;
    @ObfuscatedName("c")
    int[] horizontalOffsets;
    @ObfuscatedName("g")
    byte[][] gylphs;

    static {
        strikeRGB = -1;
        underlineRGB = -1;
        prevShadeRGB = -1;
        shadow = -1;
        prevColorRGB = 0;
        color = 0;
        field3776 = 256;
        field3780 = 0;
        field3778 = 0;
        field3771 = new Random();
        field3775 = new String[100];
    }

    FontTypeFace(byte[] var1) {
        this.gylphs = new byte[256][];
        this.verticalSpace = 0;
        this.method1772(var1);
    }

    FontTypeFace(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
        this.gylphs = new byte[256][];
        this.verticalSpace = 0;
        this.horizontalOffsets = var2;
        this.verticalOffsets = var3;
        this.gylphHeights = var4;
        this.glyphWidths = var5;
        this.method1772(var1);
        this.gylphs = var7;
        int var8 = Integer.MAX_VALUE;
        int var9 = Integer.MIN_VALUE;

        for (int var10 = 0; var10 < 256; ++var10) {
            if (this.verticalOffsets[var10] < var8 && this.glyphWidths[var10] != 0) {
                var8 = this.verticalOffsets[var10];
            }

            if (this.verticalOffsets[var10] + this.glyphWidths[var10] > var9) {
                var9 = this.verticalOffsets[var10] + this.glyphWidths[var10];
            }
        }

        this.minSpacing = this.verticalSpace - var8;
        this.maxSpacing = var9 - this.verticalSpace;
    }

    @ObfuscatedName("f")
    public int method1777(String var1, int var2) {
        int var3 = this.method1776(var1, new int[]{var2}, field3775);
        int var4 = 0;

        for (int var5 = 0; var5 < var3; ++var5) {
            int var6 = this.method1775(field3775[var5]);
            if (var6 > var4) {
                var4 = var6;
            }
        }

        return var4;
    }

    @ObfuscatedName("v")
    public int method1775(String var1) {
        if (var1 == null) {
            return 0;
        } else {
            int var2 = -1;
            int var3 = -1;
            int var4 = 0;

            for (int var5 = 0; var5 < var1.length(); ++var5) {
                char var6 = var1.charAt(var5);
                if (var6 == '<') {
                    var2 = var5;
                } else {
                    if (var6 == '>' && var2 != -1) {
                        String var7 = var1.substring(var2 + 1, var5);
                        var2 = -1;
                        if (var7.equals("lt")) {
                            var6 = '<';
                        } else {
                            if (!var7.equals("gt")) {
                                if (var7.startsWith("img=")) {
                                    try {
                                        int var8 = LoginProt.method871(var7.substring(4));
                                        var4 += modIcons[var8].originalWidth;
                                        var3 = -1;
                                    } catch (Exception var10) {
                                        ;
                                    }
                                }
                                continue;
                            }

                            var6 = '>';
                        }
                    }

                    if (var6 == 160) {
                        var6 = ' ';
                    }

                    if (var2 == -1) {
                        var4 += this.field3779[(char) (FaceNormal.method5725(var6) & 255)];
                        if (this.field3769 != null && var3 != -1) {
                            var4 += this.field3769[var6 + (var3 << 8)];
                        }

                        var3 = var6;
                    }
                }
            }

            return var4;
        }
    }

    @ObfuscatedName("r")
    abstract void vmethod2356(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

    @ObfuscatedName("af")
    public void method1784(String var1, int var2, int var3, int var4, int var5, int var6) {
        if (var1 != null) {
            this.method1788(var4, var5);
            int[] var7 = new int[var1.length()];

            for (int var8 = 0; var8 < var1.length(); ++var8) {
                var7[var8] = (int) (Math.sin((double) var8 / 2.0D + (double) var6 / 5.0D) * 5.0D);
            }

            this.method1792(var1, var2 - this.method1775(var1) / 2, var3, (int[]) null, var7);
        }
    }

    @ObfuscatedName("ae")
    void method1788(int var1, int var2) {
        strikeRGB = -1;
        underlineRGB = -1;
        prevShadeRGB = var2;
        shadow = var2;
        prevColorRGB = var1;
        color = var1;
        field3776 = 256;
        field3780 = 0;
        field3778 = 0;
    }

    @ObfuscatedName("k")
    public void method1828(String var1, int var2, int var3, int var4, int var5) {
        if (var1 != null) {
            this.method1788(var4, var5);
            this.method1866(var1, var2, var3);
        }
    }

    @ObfuscatedName("x")
    int method1807(char var1) {
        if (var1 == 160) {
            var1 = ' ';
        }

        return this.field3779[FaceNormal.method5725(var1) & 255];
    }

    @ObfuscatedName("ag")
    void method1792(String var1, int var2, int var3, int[] var4, int[] var5) {
        var3 -= this.verticalSpace;
        int var6 = -1;
        int var7 = -1;
        int var8 = 0;

        for (int var9 = 0; var9 < var1.length(); ++var9) {
            if (var1.charAt(var9) != 0) {
                char var10 = (char) (FaceNormal.method5725(var1.charAt(var9)) & 255);
                if (var10 == '<') {
                    var6 = var9;
                } else {
                    int var12;
                    int var13;
                    int var14;
                    if (var10 == '>' && var6 != -1) {
                        String var11 = var1.substring(var6 + 1, var9);
                        var6 = -1;
                        if (var11.equals("lt")) {
                            var10 = '<';
                        } else {
                            if (!var11.equals("gt")) {
                                if (var11.startsWith("img=")) {
                                    try {
                                        if (var4 != null) {
                                            var12 = var4[var8];
                                        } else {
                                            var12 = 0;
                                        }

                                        if (var5 != null) {
                                            var13 = var5[var8];
                                        } else {
                                            var13 = 0;
                                        }

                                        ++var8;
                                        var14 = LoginProt.method871(var11.substring(4));
                                        IndexedSprite var15 = modIcons[var14];
                                        var15.method824(var12 + var2, var13 + (var3 + this.verticalSpace - var15.originalHeight));
                                        var2 += var15.originalWidth;
                                        var7 = -1;
                                    } catch (Exception var19) {
                                        ;
                                    }
                                } else {
                                    this.method1789(var11);
                                }
                                continue;
                            }

                            var10 = '>';
                        }
                    }

                    if (var10 == 160) {
                        var10 = ' ';
                    }

                    if (var6 == -1) {
                        if (this.field3769 != null && var7 != -1) {
                            var2 += this.field3769[var10 + (var7 << 8)];
                        }

                        int var17 = this.gylphHeights[var10];
                        var12 = this.glyphWidths[var10];
                        if (var4 != null) {
                            var13 = var4[var8];
                        } else {
                            var13 = 0;
                        }

                        if (var5 != null) {
                            var14 = var5[var8];
                        } else {
                            var14 = 0;
                        }

                        ++var8;
                        if (var10 != ' ') {
                            if (field3776 == 256) {
                                if (shadow != -1) {
                                    method1795(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10] + 1, var3 + var14 + this.verticalOffsets[var10] + 1, var17, var12, shadow);
                                }

                                this.vmethod2360(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10], var3 + var14 + this.verticalOffsets[var10], var17, var12, color);
                            } else {
                                if (shadow != -1) {
                                    method1849(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10] + 1, var3 + var14 + this.verticalOffsets[var10] + 1, var17, var12, shadow, field3776);
                                }

                                this.vmethod2356(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10], var3 + var14 + this.verticalOffsets[var10], var17, var12, color, field3776);
                            }
                        } else if (field3780 > 0) {
                            field3778 += field3780;
                            var2 += field3778 >> 8;
                            field3778 &= 255;
                        }

                        int var18 = this.field3779[var10];
                        if (strikeRGB != -1) {
                            Rasterizer2D.method500(var2, var3 + (int) ((double) this.verticalSpace * 0.7D), var18, strikeRGB);
                        }

                        if (underlineRGB != -1) {
                            Rasterizer2D.method500(var2, var3 + this.verticalSpace, var18, underlineRGB);
                        }

                        var2 += var18;
                        var7 = var10;
                    }
                }
            }
        }

    }

    @ObfuscatedName("aj")
    void method1866(String var1, int var2, int var3) {
        var3 -= this.verticalSpace;
        int var4 = -1;
        int var5 = -1;

        for (int var6 = 0; var6 < var1.length(); ++var6) {
            if (var1.charAt(var6) != 0) {
                char var7 = (char) (FaceNormal.method5725(var1.charAt(var6)) & 255);
                if (var7 == '<') {
                    var4 = var6;
                } else {
                    int var9;
                    if (var7 == '>' && var4 != -1) {
                        String var8 = var1.substring(var4 + 1, var6);
                        var4 = -1;
                        if (var8.equals("lt")) {
                            var7 = '<';
                        } else {
                            if (!var8.equals("gt")) {
                                if (var8.startsWith("img=")) {
                                    try {
                                        var9 = LoginProt.method871(var8.substring(4));
                                        IndexedSprite var10 = modIcons[var9];
                                        var10.method824(var2, var3 + this.verticalSpace - var10.originalHeight);
                                        var2 += var10.originalWidth;
                                        var5 = -1;
                                    } catch (Exception var14) {
                                        ;
                                    }
                                } else {
                                    this.method1789(var8);
                                }
                                continue;
                            }

                            var7 = '>';
                        }
                    }

                    if (var7 == 160) {
                        var7 = ' ';
                    }

                    if (var4 == -1) {
                        if (this.field3769 != null && var5 != -1) {
                            var2 += this.field3769[var7 + (var5 << 8)];
                        }

                        int var12 = this.gylphHeights[var7];
                        var9 = this.glyphWidths[var7];
                        if (var7 != ' ') {
                            if (field3776 == 256) {
                                if (shadow != -1) {
                                    method1795(this.gylphs[var7], var2 + this.horizontalOffsets[var7] + 1, var3 + this.verticalOffsets[var7] + 1, var12, var9, shadow);
                                }

                                this.vmethod2360(this.gylphs[var7], var2 + this.horizontalOffsets[var7], var3 + this.verticalOffsets[var7], var12, var9, color);
                            } else {
                                if (shadow != -1) {
                                    method1849(this.gylphs[var7], var2 + this.horizontalOffsets[var7] + 1, var3 + this.verticalOffsets[var7] + 1, var12, var9, shadow, field3776);
                                }

                                this.vmethod2356(this.gylphs[var7], var2 + this.horizontalOffsets[var7], var3 + this.verticalOffsets[var7], var12, var9, color, field3776);
                            }
                        } else if (field3780 > 0) {
                            field3778 += field3780;
                            var2 += field3778 >> 8;
                            field3778 &= 255;
                        }

                        int var13 = this.field3779[var7];
                        if (strikeRGB != -1) {
                            Rasterizer2D.method500(var2, var3 + (int) ((double) this.verticalSpace * 0.7D), var13, strikeRGB);
                        }

                        if (underlineRGB != -1) {
                            Rasterizer2D.method500(var2, var3 + this.verticalSpace + 1, var13, underlineRGB);
                        }

                        var2 += var13;
                        var5 = var7;
                    }
                }
            }
        }

    }

    @ObfuscatedName("aw")
    public void method1810(String var1, int var2, int var3, int var4, int var5, int var6) {
        if (var1 != null) {
            this.method1788(var4, var5);
            field3771.setSeed((long) var6);
            field3776 = 192 + (field3771.nextInt() & 31);
            int[] var7 = new int[var1.length()];
            int var8 = 0;

            for (int var9 = 0; var9 < var1.length(); ++var9) {
                var7[var9] = var8;
                if ((field3771.nextInt() & 3) == 0) {
                    ++var8;
                }
            }

            this.method1792(var1, var2, var3, var7, (int[]) null);
        }
    }

    @ObfuscatedName("o")
    public int method1774(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
        if (var1 == null) {
            return 0;
        } else {
            this.method1788(var6, var7);
            if (var10 == 0) {
                var10 = this.verticalSpace;
            }

            int[] var11 = new int[]{var4};
            if (var5 < var10 + this.minSpacing + this.maxSpacing && var5 < var10 + var10) {
                var11 = null;
            }

            int var12 = this.method1776(var1, var11, field3775);
            if (var9 == 3 && var12 == 1) {
                var9 = 1;
            }

            int var13;
            int var14;
            if (var9 == 0) {
                var13 = var3 + this.minSpacing;
            } else if (var9 == 1) {
                var13 = var3 + (var5 - this.minSpacing - this.maxSpacing - var10 * (var12 - 1)) / 2 + this.minSpacing;
            } else if (var9 == 2) {
                var13 = var3 + var5 - this.maxSpacing - var10 * (var12 - 1);
            } else {
                var14 = (var5 - this.minSpacing - this.maxSpacing - var10 * (var12 - 1)) / (var12 + 1);
                if (var14 < 0) {
                    var14 = 0;
                }

                var13 = var3 + var14 + this.minSpacing;
                var10 += var14;
            }

            for (var14 = 0; var14 < var12; ++var14) {
                if (var8 == 0) {
                    this.method1866(field3775[var14], var2, var13);
                } else if (var8 == 1) {
                    this.method1866(field3775[var14], var2 + (var4 - this.method1775(field3775[var14])) / 2, var13);
                } else if (var8 == 2) {
                    this.method1866(field3775[var14], var2 + var4 - this.method1775(field3775[var14]), var13);
                } else if (var14 == var12 - 1) {
                    this.method1866(field3775[var14], var2, var13);
                } else {
                    this.method1790(field3775[var14], var4);
                    this.method1866(field3775[var14], var2, var13);
                    field3780 = 0;
                }

                var13 += var10;
            }

            return var12;
        }
    }

    @ObfuscatedName("a")
    public int method1778(String var1, int var2) {
        return this.method1776(var1, new int[]{var2}, field3775);
    }

    @ObfuscatedName("an")
    public void method1785(String var1, int var2, int var3, int var4, int var5, int var6) {
        if (var1 != null) {
            this.method1788(var4, var5);
            int[] var7 = new int[var1.length()];
            int[] var8 = new int[var1.length()];

            for (int var9 = 0; var9 < var1.length(); ++var9) {
                var7[var9] = (int) (Math.sin((double) var9 / 5.0D + (double) var6 / 5.0D) * 5.0D);
                var8[var9] = (int) (Math.sin((double) var9 / 3.0D + (double) var6 / 5.0D) * 5.0D);
            }

            this.method1792(var1, var2 - this.method1775(var1) / 2, var3, var7, var8);
        }
    }

    public int getBaseline() {
        return this.verticalSpace;
    }

    public int getTextWidth(String var1) {
        return this.method1775(var1);
    }

    @ObfuscatedName("y")
    public void method1781(String var1, int var2, int var3, int var4, int var5) {
        if (var1 != null) {
            this.method1788(var4, var5);
            this.method1866(var1, var2 - this.method1775(var1), var3);
        }
    }

    @ObfuscatedName("ax")
    public void method1802(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        if (var1 != null) {
            this.method1788(var4, var5);
            double var8 = 7.0D - (double) var7 / 8.0D;
            if (var8 < 0.0D) {
                var8 = 0.0D;
            }

            int[] var10 = new int[var1.length()];

            for (int var11 = 0; var11 < var1.length(); ++var11) {
                var10[var11] = (int) (Math.sin((double) var11 / 1.5D + (double) var6 / 1.0D) * var8);
            }

            this.method1792(var1, var2 - this.method1775(var1) / 2, var3, (int[]) null, var10);
        }
    }

    @ObfuscatedName("d")
    void method1772(byte[] var1) {
        this.field3779 = new int[256];
        int var2;
        if (var1.length == 257) {
            for (var2 = 0; var2 < this.field3779.length; ++var2) {
                this.field3779[var2] = var1[var2] & 255;
            }

            this.verticalSpace = var1[256] & 255;
        } else {
            var2 = 0;

            for (int var3 = 0; var3 < 256; ++var3) {
                this.field3779[var3] = var1[var2++] & 255;
            }

            int[] var10 = new int[256];
            int[] var4 = new int[256];

            int var5;
            for (var5 = 0; var5 < 256; ++var5) {
                var10[var5] = var1[var2++] & 255;
            }

            for (var5 = 0; var5 < 256; ++var5) {
                var4[var5] = var1[var2++] & 255;
            }

            byte[][] var11 = new byte[256][];

            int var8;
            for (int var6 = 0; var6 < 256; ++var6) {
                var11[var6] = new byte[var10[var6]];
                byte var7 = 0;

                for (var8 = 0; var8 < var11[var6].length; ++var8) {
                    var7 += var1[var2++];
                    var11[var6][var8] = var7;
                }
            }

            byte[][] var12 = new byte[256][];

            int var13;
            for (var13 = 0; var13 < 256; ++var13) {
                var12[var13] = new byte[var10[var13]];
                byte var14 = 0;

                for (int var9 = 0; var9 < var12[var13].length; ++var9) {
                    var14 += var1[var2++];
                    var12[var13][var9] = var14;
                }
            }

            this.field3769 = new byte[65536];

            for (var13 = 0; var13 < 256; ++var13) {
                if (var13 != 32 && var13 != 160) {
                    for (var8 = 0; var8 < 256; ++var8) {
                        if (var8 != 32 && var8 != 160) {
                            this.field3769[var8 + (var13 << 8)] = (byte) method1773(var11, var12, var4, this.field3779, var10, var13, var8);
                        }
                    }
                }
            }

            this.verticalSpace = var4[32] + var10[32];
        }

    }

    @ObfuscatedName("s")
    public void method1846(String var1, int var2, int var3, int var4, int var5, int var6) {
        if (var1 != null) {
            this.method1788(var4, var5);
            field3776 = var6;
            this.method1866(var1, var2, var3);
        }
    }

    @ObfuscatedName("az")
    void method1790(String var1, int var2) {
        int var3 = 0;
        boolean var4 = false;

        for (int var5 = 0; var5 < var1.length(); ++var5) {
            char var6 = var1.charAt(var5);
            if (var6 == '<') {
                var4 = true;
            } else if (var6 == '>') {
                var4 = false;
            } else if (!var4 && var6 == ' ') {
                ++var3;
            }
        }

        if (var3 > 0) {
            field3780 = (var2 - this.method1775(var1) << 8) / var3;
        }

    }

    @ObfuscatedName("ac")
    void method1789(String var1) {
        try {
            int var2;
            String var3;
            if (var1.startsWith("col=")) {
                var3 = var1.substring(4);
                var2 = class139.method2417(var3, 16, true);
                color = var2;
            } else if (var1.equals("/col")) {
                color = prevColorRGB;
            } else if (var1.startsWith("str=")) {
                var3 = var1.substring(4);
                var2 = class139.method2417(var3, 16, true);
                strikeRGB = var2;
            } else if (var1.equals("str")) {
                strikeRGB = 8388608;
            } else if (var1.equals("/str")) {
                strikeRGB = -1;
            } else if (var1.startsWith("u=")) {
                var3 = var1.substring(2);
                var2 = class139.method2417(var3, 16, true);
                underlineRGB = var2;
            } else if (var1.equals("u")) {
                underlineRGB = 0;
            } else if (var1.equals("/u")) {
                underlineRGB = -1;
            } else if (var1.startsWith("shad=")) {
                var3 = var1.substring(5);
                var2 = class139.method2417(var3, 16, true);
                shadow = var2;
            } else if (var1.equals("shad")) {
                shadow = 0;
            } else if (var1.equals("/shad")) {
                shadow = prevShadeRGB;
            } else if (var1.equals("br")) {
                this.method1788(prevColorRGB, prevShadeRGB);
            }
        } catch (Exception var5) {
            ;
        }

    }

    @ObfuscatedName("h")
    public int method1776(String var1, int[] var2, String[] var3) {
        if (var1 == null) {
            return 0;
        } else {
            int var4 = 0;
            int var5 = 0;
            StringBuilder var6 = new StringBuilder(100);
            int var7 = -1;
            int var8 = 0;
            byte var9 = 0;
            int var10 = -1;
            char var11 = 0;
            int var12 = 0;
            int var13 = var1.length();

            for (int var14 = 0; var14 < var13; ++var14) {
                char var15 = var1.charAt(var14);
                if (var15 == '<') {
                    var10 = var14;
                } else {
                    if (var15 == '>' && var10 != -1) {
                        String var16 = var1.substring(var10 + 1, var14);
                        var10 = -1;
                        var6.append('<');
                        var6.append(var16);
                        var6.append('>');
                        if (var16.equals("br")) {
                            var3[var12] = var6.toString().substring(var5, var6.length());
                            ++var12;
                            var5 = var6.length();
                            var4 = 0;
                            var7 = -1;
                            var11 = 0;
                        } else if (var16.equals("lt")) {
                            var4 += this.method1807('<');
                            if (this.field3769 != null && var11 != -1) {
                                var4 += this.field3769[(var11 << '\b') + 60];
                            }

                            var11 = '<';
                        } else if (var16.equals("gt")) {
                            var4 += this.method1807('>');
                            if (this.field3769 != null && var11 != -1) {
                                var4 += this.field3769[(var11 << '\b') + 62];
                            }

                            var11 = '>';
                        } else if (var16.startsWith("img=")) {
                            try {
                                int var17 = LoginProt.method871(var16.substring(4));
                                var4 += modIcons[var17].originalWidth;
                                var11 = 0;
                            } catch (Exception var20) {
                                ;
                            }
                        }

                        var15 = 0;
                    }

                    if (var10 == -1) {
                        if (var15 != 0) {
                            var6.append(var15);
                            var4 += this.method1807(var15);
                            if (this.field3769 != null && var11 != -1) {
                                var4 += this.field3769[var15 + (var11 << '\b')];
                            }

                            var11 = var15;
                        }

                        if (var15 == ' ') {
                            var7 = var6.length();
                            var8 = var4;
                            var9 = 1;
                        }

                        if (var2 != null && var4 > var2[var12 < var2.length ? var12 : var2.length - 1] && var7 >= 0) {
                            var3[var12] = var6.toString().substring(var5, var7 - var9);
                            ++var12;
                            var5 = var7;
                            var7 = -1;
                            var4 -= var8;
                            var11 = 0;
                        }

                        if (var15 == '-') {
                            var7 = var6.length();
                            var8 = var4;
                            var9 = 0;
                        }
                    }
                }
            }

            String var19 = var6.toString();
            if (var19.length() > var5) {
                var3[var12++] = var19.substring(var5, var19.length());
            }

            return var12;
        }
    }

    @ObfuscatedName("u")
    public void method1862(String var1, int var2, int var3, int var4, int var5) {
        if (var1 != null) {
            this.method1788(var4, var5);
            this.method1866(var1, var2 - this.method1775(var1) / 2, var3);
        }
    }

    @ObfuscatedName("g")
    abstract void vmethod2360(byte[] var1, int var2, int var3, int var4, int var5, int var6);

    @ObfuscatedName("t")
    public static String method1779(String var0) {
        int var1 = var0.length();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            char var4 = var0.charAt(var3);
            if (var4 == '<' || var4 == '>') {
                var2 += 3;
            }
        }

        StringBuilder var6 = new StringBuilder(var1 + var2);

        for (int var7 = 0; var7 < var1; ++var7) {
            char var5 = var0.charAt(var7);
            if (var5 == '<') {
                var6.append("<lt>");
            } else if (var5 == '>') {
                var6.append("<gt>");
            } else {
                var6.append(var5);
            }
        }

        return var6.toString();
    }

    @ObfuscatedName("at")
    static void method1849(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        int var7 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
        int var8 = Rasterizer2D.graphicsPixelsWidth - var3;
        int var9 = 0;
        int var10 = 0;
        int var11;
        if (var2 < Rasterizer2D.drawingAreaTop) {
            var11 = Rasterizer2D.drawingAreaTop - var2;
            var4 -= var11;
            var2 = Rasterizer2D.drawingAreaTop;
            var10 += var3 * var11;
            var7 += var11 * Rasterizer2D.graphicsPixelsWidth;
        }

        if (var2 + var4 > Rasterizer2D.drawingAreaRight) {
            var4 -= var2 + var4 - Rasterizer2D.drawingAreaRight;
        }

        if (var1 < Rasterizer2D.draw_region_x) {
            var11 = Rasterizer2D.draw_region_x - var1;
            var3 -= var11;
            var1 = Rasterizer2D.draw_region_x;
            var10 += var11;
            var7 += var11;
            var9 += var11;
            var8 += var11;
        }

        if (var3 + var1 > Rasterizer2D.drawingAreaBottom) {
            var11 = var3 + var1 - Rasterizer2D.drawingAreaBottom;
            var3 -= var11;
            var9 += var11;
            var8 += var11;
        }

        if (var3 > 0 && var4 > 0) {
            method1798(Rasterizer2D.graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
        }
    }

    @ObfuscatedName("as")
    static void method1798(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
        var2 = ((var2 & 65280) * var9 & 16711680) + (var9 * (var2 & 16711935) & -16711936) >> 8;
        var9 = 256 - var9;

        for (int var10 = -var6; var10 < 0; ++var10) {
            for (int var11 = -var5; var11 < 0; ++var11) {
                if (var1[var3++] != 0) {
                    int var12 = var0[var4];
                    client.drawAlpha(var0, var4++, (((var12 & 65280) * var9 & 16711680) + ((var12 & 16711935) * var9 & -16711936) >> 8) + var2, 255 - var9);
                } else {
                    ++var4;
                }
            }

            var4 += var7;
            var3 += var8;
        }

    }

    @ObfuscatedName("ar")
    static void method1796(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9 = -(var5 >> 2);
        var5 = -(var5 & 3);

        for (int var10 = -var6; var10 < 0; ++var10) {
            int var11;
            for (var11 = var9; var11 < 0; ++var11) {
                if (var1[var3++] != 0) {
                    var0[var4++] = var2 | -16777216;
                } else {
                    ++var4;
                }

                if (var1[var3++] != 0) {
                    var0[var4++] = var2 | -16777216;
                } else {
                    ++var4;
                }

                if (var1[var3++] != 0) {
                    var0[var4++] = var2 | -16777216;
                } else {
                    ++var4;
                }

                if (var1[var3++] != 0) {
                    var0[var4++] = var2 | -16777216;
                } else {
                    ++var4;
                }
            }

            for (var11 = var5; var11 < 0; ++var11) {
                if (var1[var3++] != 0) {
                    var0[var4++] = var2 | -16777216;
                } else {
                    ++var4;
                }
            }

            var4 += var7;
            var3 += var8;
        }

    }

    @ObfuscatedName("j")
    static int method1773(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
        int var7 = var2[var5];
        int var8 = var7 + var4[var5];
        int var9 = var2[var6];
        int var10 = var9 + var4[var6];
        int var11 = var7;
        if (var9 > var7) {
            var11 = var9;
        }

        int var12 = var8;
        if (var10 < var8) {
            var12 = var10;
        }

        int var13 = var3[var5];
        if (var3[var6] < var13) {
            var13 = var3[var6];
        }

        byte[] var14 = var1[var5];
        byte[] var15 = var0[var6];
        int var16 = var11 - var7;
        int var17 = var11 - var9;

        for (int var18 = var11; var18 < var12; ++var18) {
            int var19 = var14[var16++] + var15[var17++];
            if (var19 < var13) {
                var13 = var19;
            }
        }

        return -var13;
    }

    @ObfuscatedName("ab")
    static void method1795(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
        int var6 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
        int var7 = Rasterizer2D.graphicsPixelsWidth - var3;
        int var8 = 0;
        int var9 = 0;
        int var10;
        if (var2 < Rasterizer2D.drawingAreaTop) {
            var10 = Rasterizer2D.drawingAreaTop - var2;
            var4 -= var10;
            var2 = Rasterizer2D.drawingAreaTop;
            var9 += var3 * var10;
            var6 += var10 * Rasterizer2D.graphicsPixelsWidth;
        }

        if (var2 + var4 > Rasterizer2D.drawingAreaRight) {
            var4 -= var2 + var4 - Rasterizer2D.drawingAreaRight;
        }

        if (var1 < Rasterizer2D.draw_region_x) {
            var10 = Rasterizer2D.draw_region_x - var1;
            var3 -= var10;
            var1 = Rasterizer2D.draw_region_x;
            var9 += var10;
            var6 += var10;
            var8 += var10;
            var7 += var10;
        }

        if (var3 + var1 > Rasterizer2D.drawingAreaBottom) {
            var10 = var3 + var1 - Rasterizer2D.drawingAreaBottom;
            var3 -= var10;
            var8 += var10;
            var7 += var10;
        }

        if (var3 > 0 && var4 > 0) {
            method1796(Rasterizer2D.graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
        }
    }
}
