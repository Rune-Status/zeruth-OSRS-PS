package net.runelite.runescape;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("Graphics3D")
public class Graphics3D extends Rasterizer2D {
    @ObfuscatedName("f")
    @Export("Rasterizer3D_clipMidX2")
    static int Rasterizer3D_clipMidX2;
    @ObfuscatedName("v")
    @Export("Rasterizer3D_clipHeight")
    static int Rasterizer3D_clipHeight;
    @ObfuscatedName("r")
    static boolean field1729;
    @ObfuscatedName("e")
    @Export("lowMem")
    static boolean lowMem;
    @ObfuscatedName("af")
    @Export("COSINE")
    public static int[] COSINE;
    @ObfuscatedName("k")
    @Export("rasterClipY")
    static int[] rasterClipY;
    @ObfuscatedName("q")
    @Export("rasterGourandLowRes")
    public static boolean rasterGouraudLowRes;
    @ObfuscatedName("x")
    @Export("rasterClipX")
    static int rasterClipX;
    @ObfuscatedName("m")
    @Export("Rasterizer3D_zoom")
    public static int Rasterizer3D_zoom;
    @ObfuscatedName("o")
    @Export("SINE")
    public static int[] SINE;
    @ObfuscatedName("a")
    @Export("Rasterizer3D_clipNegativeMidY")
    static int Rasterizer3D_clipNegativeMidY;
    @ObfuscatedName("z")
    @Export("colorPalette")
    public static int[] colorPalette;
    @ObfuscatedName("c")
    @Export("rasterAlpha")
    static int rasterAlpha;
    @ObfuscatedName("t")
    @Export("Rasterizer3D_clipMidY2")
    static int Rasterizer3D_clipMidY2;
    @ObfuscatedName("y")
    static int[] field1751;
    @ObfuscatedName("d")
    @Export("centerX")
    static int centerX;
    @ObfuscatedName("j")
    @Export("centerY")
    static int centerY;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "Lex;"
    )
    @Export("textureLoader")
    public static ITextureLoader textureLoader;
    @ObfuscatedName("h")
    @Export("Rasterizer3D_clipNegativeMidX")
    static int Rasterizer3D_clipNegativeMidX;
    @ObfuscatedName("u")
    static int[] field1744;
    @ObfuscatedName("g")
    @Export("rasterClipEnable")
    static boolean rasterClipEnable;

    static {
        rasterClipEnable = false;
        field1729 = false;
        lowMem = false;
        rasterGouraudLowRes = true;
        rasterAlpha = 0;
        Rasterizer3D_zoom = 512;
        rasterClipY = new int[1024];
        colorPalette = new int[65536];
        field1751 = new int[512];
        field1744 = new int[2048];
        SINE = new int[2048];
        COSINE = new int[2048];

        int var0;
        for (var0 = 1; var0 < 512; ++var0) {
            field1751[var0] = 32768 / var0;
        }

        for (var0 = 1; var0 < 2048; ++var0) {
            field1744[var0] = 65536 / var0;
        }

        for (var0 = 0; var0 < 2048; ++var0) {
            SINE[var0] = (int) (65536.0D * Math.sin((double) var0 * 0.0030679615D));
            COSINE[var0] = (int) (65536.0D * Math.cos((double) var0 * 0.0030679615D));
        }

    }

    @Export("checkDepth")
    private static boolean checkDepth(int offset, int bufferOffset, float z1) {
        return z1 < Rasterizer2D.depthBuffer[offset] || z1 < Rasterizer2D.depthBuffer[offset] + bufferOffset;
    }

    @Export("rasterTextureAffineIcon")
    static final void rasterTextureAffineIcon(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18) {
        int[] var19 = textureLoader.vmethod5375(var18);
        int var20;
        if (var19 == null) {
            var20 = textureLoader.vmethod5363(var18);
            rasterGouraudIcon(var0, var1, var2, var3, var4, var5, method2579(var20, var6), method2579(var20, var7), method2579(var20, var8));
        } else {
            lowMem = textureLoader.vmethod5364(var18);
            field1729 = textureLoader.vmethod5366(var18);
            var20 = var4 - var3;
            int var21 = var1 - var0;
            int var22 = var5 - var3;
            int var23 = var2 - var0;
            int var24 = var7 - var6;
            int var25 = var8 - var6;
            int var26 = 0;
            if (var0 != var1) {
                var26 = (var4 - var3 << 14) / (var1 - var0);
            }

            int var27 = 0;
            if (var2 != var1) {
                var27 = (var5 - var4 << 14) / (var2 - var1);
            }

            int var28 = 0;
            if (var0 != var2) {
                var28 = (var3 - var5 << 14) / (var0 - var2);
            }

            int var29 = var20 * var23 - var22 * var21;
            if (var29 != 0) {
                int var30 = (var24 * var23 - var25 * var21 << 9) / var29;
                int var31 = (var25 * var20 - var24 * var22 << 9) / var29;
                var10 = var9 - var10;
                var13 = var12 - var13;
                var16 = var15 - var16;
                var11 -= var9;
                var14 -= var12;
                var17 -= var15;
                int var32 = var11 * var12 - var9 * var14 << 14;
                int var33 = (int) (((long) (var15 * var14 - var17 * var12) << 3 << 14) / (long) Rasterizer3D_zoom);
                int var34 = (int) (((long) (var17 * var9 - var11 * var15) << 14) / (long) Rasterizer3D_zoom);
                int var35 = var10 * var12 - var13 * var9 << 14;
                int var36 = (int) (((long) (var13 * var15 - var16 * var12) << 3 << 14) / (long) Rasterizer3D_zoom);
                int var37 = (int) (((long) (var16 * var9 - var10 * var15) << 14) / (long) Rasterizer3D_zoom);
                int var38 = var13 * var11 - var10 * var14 << 14;
                int var39 = (int) (((long) (var16 * var14 - var13 * var17) << 3 << 14) / (long) Rasterizer3D_zoom);
                int var40 = (int) (((long) (var17 * var10 - var11 * var16) << 14) / (long) Rasterizer3D_zoom);
                int var41;
                if (var0 <= var1 && var0 <= var2) {
                    if (var0 < Rasterizer3D_clipHeight) {
                        if (var1 > Rasterizer3D_clipHeight) {
                            var1 = Rasterizer3D_clipHeight;
                        }

                        if (var2 > Rasterizer3D_clipHeight) {
                            var2 = Rasterizer3D_clipHeight;
                        }

                        var6 = var30 + ((var6 << 9) - var3 * var30);
                        if (var1 < var2) {
                            var5 = var3 <<= 14;
                            if (var0 < 0) {
                                var5 -= var0 * var28;
                                var3 -= var0 * var26;
                                var6 -= var0 * var31;
                                var0 = 0;
                            }

                            var4 <<= 14;
                            if (var1 < 0) {
                                var4 -= var27 * var1;
                                var1 = 0;
                            }

                            var41 = var0 - centerY;
                            var32 += var34 * var41;
                            var35 += var37 * var41;
                            var38 += var40 * var41;
                            if (var0 != var1 && var28 < var26 || var0 == var1 && var28 > var27) {
                                var2 -= var1;
                                var1 -= var0;
                                var0 = rasterClipY[var0];

                                while (true) {
                                    --var1;
                                    if (var1 < 0) {
                                        while (true) {
                                            --var2;
                                            if (var2 < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var5 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                            var5 += var28;
                                            var4 += var27;
                                            var6 += var31;
                                            var0 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                    var5 += var28;
                                    var3 += var26;
                                    var6 += var31;
                                    var0 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            } else {
                                var2 -= var1;
                                var1 -= var0;
                                var0 = rasterClipY[var0];

                                while (true) {
                                    --var1;
                                    if (var1 < 0) {
                                        while (true) {
                                            --var2;
                                            if (var2 < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var4 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                            var5 += var28;
                                            var4 += var27;
                                            var6 += var31;
                                            var0 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                    var5 += var28;
                                    var3 += var26;
                                    var6 += var31;
                                    var0 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            }
                        } else {
                            var4 = var3 <<= 14;
                            if (var0 < 0) {
                                var4 -= var0 * var28;
                                var3 -= var0 * var26;
                                var6 -= var0 * var31;
                                var0 = 0;
                            }

                            var5 <<= 14;
                            if (var2 < 0) {
                                var5 -= var27 * var2;
                                var2 = 0;
                            }

                            var41 = var0 - centerY;
                            var32 += var34 * var41;
                            var35 += var37 * var41;
                            var38 += var40 * var41;
                            if ((var0 == var2 || var28 >= var26) && (var0 != var2 || var27 <= var26)) {
                                var1 -= var2;
                                var2 -= var0;
                                var0 = rasterClipY[var0];

                                while (true) {
                                    --var2;
                                    if (var2 < 0) {
                                        while (true) {
                                            --var1;
                                            if (var1 < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                            var5 += var27;
                                            var3 += var26;
                                            var6 += var31;
                                            var0 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var3 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                    var4 += var28;
                                    var3 += var26;
                                    var6 += var31;
                                    var0 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            } else {
                                var1 -= var2;
                                var2 -= var0;
                                var0 = rasterClipY[var0];

                                while (true) {
                                    --var2;
                                    if (var2 < 0) {
                                        while (true) {
                                            --var1;
                                            if (var1 < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                            var5 += var27;
                                            var3 += var26;
                                            var6 += var31;
                                            var0 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var4 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                    var4 += var28;
                                    var3 += var26;
                                    var6 += var31;
                                    var0 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            }
                        }
                    }
                } else if (var1 <= var2) {
                    if (var1 < Rasterizer3D_clipHeight) {
                        if (var2 > Rasterizer3D_clipHeight) {
                            var2 = Rasterizer3D_clipHeight;
                        }

                        if (var0 > Rasterizer3D_clipHeight) {
                            var0 = Rasterizer3D_clipHeight;
                        }

                        var7 = var30 + ((var7 << 9) - var30 * var4);
                        if (var2 < var0) {
                            var3 = var4 <<= 14;
                            if (var1 < 0) {
                                var3 -= var26 * var1;
                                var4 -= var27 * var1;
                                var7 -= var31 * var1;
                                var1 = 0;
                            }

                            var5 <<= 14;
                            if (var2 < 0) {
                                var5 -= var28 * var2;
                                var2 = 0;
                            }

                            var41 = var1 - centerY;
                            var32 += var34 * var41;
                            var35 += var37 * var41;
                            var38 += var40 * var41;
                            if (var2 != var1 && var26 < var27 || var2 == var1 && var26 > var28) {
                                var0 -= var2;
                                var2 -= var1;
                                var1 = rasterClipY[var1];

                                while (true) {
                                    --var2;
                                    if (var2 < 0) {
                                        while (true) {
                                            --var0;
                                            if (var0 < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var3 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                            var3 += var26;
                                            var5 += var28;
                                            var7 += var31;
                                            var1 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                    var3 += var26;
                                    var4 += var27;
                                    var7 += var31;
                                    var1 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            } else {
                                var0 -= var2;
                                var2 -= var1;
                                var1 = rasterClipY[var1];

                                while (true) {
                                    --var2;
                                    if (var2 < 0) {
                                        while (true) {
                                            --var0;
                                            if (var0 < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var5 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                            var3 += var26;
                                            var5 += var28;
                                            var7 += var31;
                                            var1 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                    var3 += var26;
                                    var4 += var27;
                                    var7 += var31;
                                    var1 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            }
                        } else {
                            var5 = var4 <<= 14;
                            if (var1 < 0) {
                                var5 -= var26 * var1;
                                var4 -= var27 * var1;
                                var7 -= var31 * var1;
                                var1 = 0;
                            }

                            var3 <<= 14;
                            if (var0 < 0) {
                                var3 -= var0 * var28;
                                var0 = 0;
                            }

                            var41 = var1 - centerY;
                            var32 += var34 * var41;
                            var35 += var37 * var41;
                            var38 += var40 * var41;
                            if (var26 < var27) {
                                var2 -= var0;
                                var0 -= var1;
                                var1 = rasterClipY[var1];

                                while (true) {
                                    --var0;
                                    if (var0 < 0) {
                                        while (true) {
                                            --var2;
                                            if (var2 < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                            var3 += var28;
                                            var4 += var27;
                                            var7 += var31;
                                            var1 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var5 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                    var5 += var26;
                                    var4 += var27;
                                    var7 += var31;
                                    var1 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            } else {
                                var2 -= var0;
                                var0 -= var1;
                                var1 = rasterClipY[var1];

                                while (true) {
                                    --var0;
                                    if (var0 < 0) {
                                        while (true) {
                                            --var2;
                                            if (var2 < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                            var3 += var28;
                                            var4 += var27;
                                            var7 += var31;
                                            var1 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var4 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                    var5 += var26;
                                    var4 += var27;
                                    var7 += var31;
                                    var1 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            }
                        }
                    }
                } else if (var2 < Rasterizer3D_clipHeight) {
                    if (var0 > Rasterizer3D_clipHeight) {
                        var0 = Rasterizer3D_clipHeight;
                    }

                    if (var1 > Rasterizer3D_clipHeight) {
                        var1 = Rasterizer3D_clipHeight;
                    }

                    var8 = (var8 << 9) - var5 * var30 + var30;
                    if (var0 < var1) {
                        var4 = var5 <<= 14;
                        if (var2 < 0) {
                            var4 -= var27 * var2;
                            var5 -= var28 * var2;
                            var8 -= var31 * var2;
                            var2 = 0;
                        }

                        var3 <<= 14;
                        if (var0 < 0) {
                            var3 -= var0 * var26;
                            var0 = 0;
                        }

                        var41 = var2 - centerY;
                        var32 += var34 * var41;
                        var35 += var37 * var41;
                        var38 += var40 * var41;
                        if (var27 < var28) {
                            var1 -= var0;
                            var0 -= var2;
                            var2 = rasterClipY[var2];

                            while (true) {
                                --var0;
                                if (var0 < 0) {
                                    while (true) {
                                        --var1;
                                        if (var1 < 0) {
                                            return;
                                        }

                                        rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var4 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                        var4 += var27;
                                        var3 += var26;
                                        var8 += var31;
                                        var2 += Rasterizer2D.graphicsPixelsWidth;
                                        var32 += var34;
                                        var35 += var37;
                                        var38 += var40;
                                    }
                                }

                                rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                var4 += var27;
                                var5 += var28;
                                var8 += var31;
                                var2 += Rasterizer2D.graphicsPixelsWidth;
                                var32 += var34;
                                var35 += var37;
                                var38 += var40;
                            }
                        } else {
                            var1 -= var0;
                            var0 -= var2;
                            var2 = rasterClipY[var2];

                            while (true) {
                                --var0;
                                if (var0 < 0) {
                                    while (true) {
                                        --var1;
                                        if (var1 < 0) {
                                            return;
                                        }

                                        rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var3 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                        var4 += var27;
                                        var3 += var26;
                                        var8 += var31;
                                        var2 += Rasterizer2D.graphicsPixelsWidth;
                                        var32 += var34;
                                        var35 += var37;
                                        var38 += var40;
                                    }
                                }

                                rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                var4 += var27;
                                var5 += var28;
                                var8 += var31;
                                var2 += Rasterizer2D.graphicsPixelsWidth;
                                var32 += var34;
                                var35 += var37;
                                var38 += var40;
                            }
                        }
                    } else {
                        var3 = var5 <<= 14;
                        if (var2 < 0) {
                            var3 -= var27 * var2;
                            var5 -= var28 * var2;
                            var8 -= var31 * var2;
                            var2 = 0;
                        }

                        var4 <<= 14;
                        if (var1 < 0) {
                            var4 -= var26 * var1;
                            var1 = 0;
                        }

                        var41 = var2 - centerY;
                        var32 += var34 * var41;
                        var35 += var37 * var41;
                        var38 += var40 * var41;
                        if (var27 < var28) {
                            var0 -= var1;
                            var1 -= var2;
                            var2 = rasterClipY[var2];

                            while (true) {
                                --var1;
                                if (var1 < 0) {
                                    while (true) {
                                        --var0;
                                        if (var0 < 0) {
                                            return;
                                        }

                                        rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                        var4 += var26;
                                        var5 += var28;
                                        var8 += var31;
                                        var2 += Rasterizer2D.graphicsPixelsWidth;
                                        var32 += var34;
                                        var35 += var37;
                                        var38 += var40;
                                    }
                                }

                                rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var3 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                var3 += var27;
                                var5 += var28;
                                var8 += var31;
                                var2 += Rasterizer2D.graphicsPixelsWidth;
                                var32 += var34;
                                var35 += var37;
                                var38 += var40;
                            }
                        } else {
                            var0 -= var1;
                            var1 -= var2;
                            var2 = rasterClipY[var2];

                            while (true) {
                                --var1;
                                if (var1 < 0) {
                                    while (true) {
                                        --var0;
                                        if (var0 < 0) {
                                            return;
                                        }

                                        rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                        var4 += var26;
                                        var5 += var28;
                                        var8 += var31;
                                        var2 += Rasterizer2D.graphicsPixelsWidth;
                                        var32 += var34;
                                        var35 += var37;
                                        var38 += var40;
                                    }
                                }

                                rasterTextureAffineLineIcon(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var5 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                var3 += var27;
                                var5 += var28;
                                var8 += var31;
                                var2 += Rasterizer2D.graphicsPixelsWidth;
                                var32 += var34;
                                var35 += var37;
                                var38 += var40;
                            }
                        }
                    }
                }
            }
        }
    }

    @Export("rasterTextureAffineLineIcon")
    static final void rasterTextureAffineLineIcon(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
        if (rasterClipEnable) {
            if (var6 > rasterClipX) {
                var6 = rasterClipX;
            }

            if (var5 < 0) {
                var5 = 0;
            }
        }

        if (var5 < var6) {
            var4 += var5;
            var7 += var5 * var8;
            int var17 = var6 - var5;
            int var15;
            int var16;
            int var10000;
            int var18;
            int var19;
            int var20;
            int var21;
            int var22;
            int var23;
            if (lowMem) {
                var23 = var5 - centerX;
                var9 += var23 * (var12 >> 3);
                var10 += (var13 >> 3) * var23;
                var11 += var23 * (var14 >> 3);
                var22 = var11 >> 12;
                if (var22 != 0) {
                    var18 = var9 / var22;
                    var19 = var10 / var22;
                    if (var18 < 0) {
                        var18 = 0;
                    } else if (var18 > 4032) {
                        var18 = 4032;
                    }
                } else {
                    var18 = 0;
                    var19 = 0;
                }

                var9 += var12;
                var10 += var13;
                var11 += var14;
                var22 = var11 >> 12;
                if (var22 != 0) {
                    var20 = var9 / var22;
                    var21 = var10 / var22;
                    if (var20 < 0) {
                        var20 = 0;
                    } else if (var20 > 4032) {
                        var20 = 4032;
                    }
                } else {
                    var20 = 0;
                    var21 = 0;
                }

                var2 = (var18 << 20) + var19;
                var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 20);
                var17 >>= 3;
                var8 <<= 3;
                var15 = var7 >> 8;
                if (field1729) {
                    if (var17 > 0) {
                        do {
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var10000 = var16 + var2;
                            var18 = var20;
                            var19 = var21;
                            var9 += var12;
                            var10 += var13;
                            var11 += var14;
                            var22 = var11 >> 12;
                            if (var22 != 0) {
                                var20 = var9 / var22;
                                var21 = var10 / var22;
                                if (var20 < 0) {
                                    var20 = 0;
                                } else if (var20 > 4032) {
                                    var20 = 4032;
                                }
                            } else {
                                var20 = 0;
                                var21 = 0;
                            }

                            var2 = (var18 << 20) + var19;
                            var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 20);
                            var7 += var8;
                            var15 = var7 >> 8;
                            --var17;
                        } while (var17 > 0);
                    }

                    var17 = var6 - var5 & 7;
                    if (var17 > 0) {
                        do {
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            --var17;
                        } while (var17 > 0);
                    }
                } else {
                    if (var17 > 0) {
                        do {
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var10000 = var16 + var2;
                            var18 = var20;
                            var19 = var21;
                            var9 += var12;
                            var10 += var13;
                            var11 += var14;
                            var22 = var11 >> 12;
                            if (var22 != 0) {
                                var20 = var9 / var22;
                                var21 = var10 / var22;
                                if (var20 < 0) {
                                    var20 = 0;
                                } else if (var20 > 4032) {
                                    var20 = 4032;
                                }
                            } else {
                                var20 = 0;
                                var21 = 0;
                            }

                            var2 = (var18 << 20) + var19;
                            var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 20);
                            var7 += var8;
                            var15 = var7 >> 8;
                            --var17;
                        } while (var17 > 0);
                    }

                    var17 = var6 - var5 & 7;
                    if (var17 > 0) {
                        do {
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            --var17;
                        } while (var17 > 0);
                    }
                }
            } else {
                var23 = var5 - centerX;
                var9 += var23 * (var12 >> 3);
                var10 += (var13 >> 3) * var23;
                var11 += var23 * (var14 >> 3);
                var22 = var11 >> 14;
                if (var22 != 0) {
                    var18 = var9 / var22;
                    var19 = var10 / var22;
                    if (var18 < 0) {
                        var18 = 0;
                    } else if (var18 > 16256) {
                        var18 = 16256;
                    }
                } else {
                    var18 = 0;
                    var19 = 0;
                }

                var9 += var12;
                var10 += var13;
                var11 += var14;
                var22 = var11 >> 14;
                if (var22 != 0) {
                    var20 = var9 / var22;
                    var21 = var10 / var22;
                    if (var20 < 0) {
                        var20 = 0;
                    } else if (var20 > 16256) {
                        var20 = 16256;
                    }
                } else {
                    var20 = 0;
                    var21 = 0;
                }

                var2 = (var18 << 18) + var19;
                var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 18);
                var17 >>= 3;
                var8 <<= 3;
                var15 = var7 >> 8;
                if (field1729) {
                    if (var17 > 0) {
                        do {
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var10000 = var16 + var2;
                            var18 = var20;
                            var19 = var21;
                            var9 += var12;
                            var10 += var13;
                            var11 += var14;
                            var22 = var11 >> 14;
                            if (var22 != 0) {
                                var20 = var9 / var22;
                                var21 = var10 / var22;
                                if (var20 < 0) {
                                    var20 = 0;
                                } else if (var20 > 16256) {
                                    var20 = 16256;
                                }
                            } else {
                                var20 = 0;
                                var21 = 0;
                            }

                            var2 = (var18 << 18) + var19;
                            var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 18);
                            var7 += var8;
                            var15 = var7 >> 8;
                            --var17;
                        } while (var17 > 0);
                    }

                    var17 = var6 - var5 & 7;
                    if (var17 > 0) {
                        do {
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            --var17;
                        } while (var17 > 0);
                    }
                } else {
                    if (var17 > 0) {
                        do {
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var10000 = var16 + var2;
                            var18 = var20;
                            var19 = var21;
                            var9 += var12;
                            var10 += var13;
                            var11 += var14;
                            var22 = var11 >> 14;
                            if (var22 != 0) {
                                var20 = var9 / var22;
                                var21 = var10 / var22;
                                if (var20 < 0) {
                                    var20 = 0;
                                } else if (var20 > 16256) {
                                    var20 = 16256;
                                }
                            } else {
                                var20 = 0;
                                var21 = 0;
                            }

                            var2 = (var18 << 18) + var19;
                            var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 18);
                            var7 += var8;
                            var15 = var7 >> 8;
                            --var17;
                        } while (var17 > 0);
                    }

                    var17 = var6 - var5 & 7;
                    if (var17 > 0) {
                        do {
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            --var17;
                        } while (var17 > 0);
                    }
                }
            }

        }
    }

    @ObfuscatedName("f")
    @Export("rasterTextureAffine")
    static final void rasterTextureAffine(int y_a, int y_b, int y_c, int x_a, int x_b, int x_c, int hsl1, int hsl2, int hsl3, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, float z_a, float z_b, float z_c, int bufferOffset) {
        if (!rasterGouraudLowRes) {
            rasterTextureAffineIcon(y_a, y_b, y_c, x_a, x_b, x_c, hsl1, hsl2, hsl3, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18);
            return;
        }
        int[] var19 = textureLoader.vmethod5375(var18);
        if (var19 == null) {
            int var20 = textureLoader.vmethod5363(var18);
            rasterGouraud(y_a, y_b, y_c, x_a, x_b, x_c, method2579(var20, hsl1), method2579(var20, hsl2), method2579(var20, hsl3), z_a, z_b, z_c, bufferOffset);
        } else {
            lowMem = textureLoader.vmethod5364(var18);
            field1729 = textureLoader.vmethod5366(var18);
            int b_aX = x_b - x_a;
            int b_aY = y_b - y_a;
            int c_aX = x_c - x_a;
            int c_aY = y_c - y_a;
            float b_aZ = z_b - z_a;
            float c_aZ = z_c - z_a;
            int var24 = hsl2 - hsl1;
            int var25 = hsl3 - hsl1;
            int a_to_b = 0;
            if (y_a != y_b) {
                a_to_b = (x_b - x_a << 14) / (y_b - y_a);
            }

            int b_to_c = 0;
            if (y_c != y_b) {
                b_to_c = (x_c - x_b << 14) / (y_c - y_b);
            }

            int c_to_a = 0;
            if (y_a != y_c) {
                c_to_a = (x_a - x_c << 14) / (y_a - y_c);
            }

            int div = b_aX * c_aY - c_aX * b_aY;
            if (div != 0) {
                int var30 = (var24 * c_aY - var25 * b_aY << 9) / div;
                int var31 = (var25 * b_aX - var24 * c_aX << 9) / div;
                float depth_slope = (b_aZ * c_aY - c_aZ * b_aY) / div;
                float depth_increment = (c_aZ * b_aX - b_aZ * c_aX) / div;
                var10 = var9 - var10;
                var13 = var12 - var13;
                var16 = var15 - var16;
                var11 -= var9;
                var14 -= var12;
                var17 -= var15;
                int var32 = var11 * var12 - var9 * var14 << 14;
                int var33 = (int) (((long) (var15 * var14 - var17 * var12) << 3 << 14) / (long) Rasterizer3D_zoom);
                int var34 = (int) (((long) (var17 * var9 - var11 * var15) << 14) / (long) Rasterizer3D_zoom);
                int var35 = var10 * var12 - var13 * var9 << 14;
                int var36 = (int) (((long) (var13 * var15 - var16 * var12) << 3 << 14) / (long) Rasterizer3D_zoom);
                int var37 = (int) (((long) (var16 * var9 - var10 * var15) << 14) / (long) Rasterizer3D_zoom);
                int var38 = var13 * var11 - var10 * var14 << 14;
                int var39 = (int) (((long) (var16 * var14 - var13 * var17) << 3 << 14) / (long) Rasterizer3D_zoom);
                int var40 = (int) (((long) (var17 * var10 - var11 * var16) << 14) / (long) Rasterizer3D_zoom);
                int var41;
                if (y_a <= y_b && y_a <= y_c) {
                    if (y_a < Rasterizer3D_clipHeight) {
                        if (y_b > Rasterizer3D_clipHeight) {
                            y_b = Rasterizer3D_clipHeight;
                        }

                        if (y_c > Rasterizer3D_clipHeight) {
                            y_c = Rasterizer3D_clipHeight;
                        }

                        hsl1 = var30 + ((hsl1 << 9) - x_a * var30);
                        z_a = z_a - depth_slope * x_a + depth_slope;
                        if (y_b < y_c) {
                            x_c = x_a <<= 14;
                            if (y_a < 0) {
                                x_c -= y_a * c_to_a;
                                x_a -= y_a * a_to_b;
                                hsl1 -= y_a * var31;
                                z_a -= depth_increment * y_a;
                                y_a = 0;
                            }

                            x_b <<= 14;
                            if (y_b < 0) {
                                x_b -= b_to_c * y_b;
                                y_b = 0;
                            }

                            var41 = y_a - centerY;
                            var32 += var34 * var41;
                            var35 += var37 * var41;
                            var38 += var40 * var41;
                            if (y_a != y_b && c_to_a < a_to_b || y_a == y_b && c_to_a > b_to_c) {
                                y_c -= y_b;
                                y_b -= y_a;
                                y_a = rasterClipY[y_a];

                                while (true) {
                                    --y_b;
                                    if (y_b < 0) {
                                        while (true) {
                                            --y_c;
                                            if (y_c < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_a, x_c >> 14, x_b >> 14, hsl1, var30, var32, var35, var38, var33, var36, var39, z_a, depth_slope, bufferOffset);
                                            x_c += c_to_a;
                                            x_b += b_to_c;
                                            hsl1 += var31;
                                            z_a += depth_increment;
                                            y_a += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_a, x_c >> 14, x_a >> 14, hsl1, var30, var32, var35, var38, var33, var36, var39, z_a, depth_slope, bufferOffset);
                                    x_c += c_to_a;
                                    x_a += a_to_b;
                                    hsl1 += var31;
                                    z_a += depth_increment;
                                    y_a += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            } else {
                                y_c -= y_b;
                                y_b -= y_a;
                                y_a = rasterClipY[y_a];

                                while (true) {
                                    --y_b;
                                    if (y_b < 0) {
                                        while (true) {
                                            --y_c;
                                            if (y_c < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_a, x_b >> 14, x_c >> 14, hsl1, var30, var32, var35, var38, var33, var36, var39, z_a, depth_slope, bufferOffset);
                                            x_c += c_to_a;
                                            x_b += b_to_c;
                                            hsl1 += var31;
                                            z_a += depth_increment;
                                            y_a += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_a, x_a >> 14, x_c >> 14, hsl1, var30, var32, var35, var38, var33, var36, var39, z_a, depth_slope, bufferOffset);
                                    x_c += c_to_a;
                                    x_a += a_to_b;
                                    hsl1 += var31;
                                    z_a += depth_increment;
                                    y_a += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            }
                        } else {
                            x_b = x_a <<= 14;
                            if (y_a < 0) {
                                x_b -= y_a * c_to_a;
                                x_a -= y_a * a_to_b;
                                hsl1 -= y_a * var31;
                                z_a -= depth_increment * y_a;
                                y_a = 0;
                            }

                            x_c <<= 14;
                            if (y_c < 0) {
                                x_c -= b_to_c * y_c;
                                y_c = 0;
                            }

                            var41 = y_a - centerY;
                            var32 += var34 * var41;
                            var35 += var37 * var41;
                            var38 += var40 * var41;
                            if ((y_a == y_c || c_to_a >= a_to_b) && (y_a != y_c || b_to_c <= a_to_b)) {
                                y_b -= y_c;
                                y_c -= y_a;
                                y_a = rasterClipY[y_a];

                                while (true) {
                                    --y_c;
                                    if (y_c < 0) {
                                        while (true) {
                                            --y_b;
                                            if (y_b < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_a, x_a >> 14, x_c >> 14, hsl1, var30, var32, var35, var38, var33, var36, var39, z_a, depth_slope, bufferOffset);
                                            x_c += b_to_c;
                                            x_a += a_to_b;
                                            hsl1 += var31;
                                            z_a += depth_increment;
                                            y_a += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_a, x_a >> 14, x_b >> 14, hsl1, var30, var32, var35, var38, var33, var36, var39, z_a, depth_slope, bufferOffset);
                                    x_b += c_to_a;
                                    x_a += a_to_b;
                                    hsl1 += var31;
                                    z_a += depth_increment;
                                    y_a += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            } else {
                                y_b -= y_c;
                                y_c -= y_a;
                                y_a = rasterClipY[y_a];

                                while (true) {
                                    --y_c;
                                    if (y_c < 0) {
                                        while (true) {
                                            --y_b;
                                            if (y_b < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_a, x_c >> 14, x_a >> 14, hsl1, var30, var32, var35, var38, var33, var36, var39, z_a, depth_slope, bufferOffset);
                                            x_c += b_to_c;
                                            x_a += a_to_b;
                                            hsl1 += var31;
                                            z_a += depth_increment;
                                            y_a += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_a, x_b >> 14, x_a >> 14, hsl1, var30, var32, var35, var38, var33, var36, var39, z_a, depth_slope, bufferOffset);
                                    x_b += c_to_a;
                                    x_a += a_to_b;
                                    hsl1 += var31;
                                    z_a += depth_increment;
                                    y_a += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            }
                        }
                    }
                } else if (y_b <= y_c) {
                    if (y_b < Rasterizer3D_clipHeight) {
                        if (y_c > Rasterizer3D_clipHeight) {
                            y_c = Rasterizer3D_clipHeight;
                        }

                        if (y_a > Rasterizer3D_clipHeight) {
                            y_a = Rasterizer3D_clipHeight;
                        }

                        hsl2 = var30 + ((hsl2 << 9) - var30 * x_b);
                        z_b = z_b - depth_slope * x_b + depth_slope;
                        if (y_c < y_a) {
                            x_a = x_b <<= 14;
                            if (y_b < 0) {
                                x_a -= a_to_b * y_b;
                                x_b -= b_to_c * y_b;
                                hsl2 -= var31 * y_b;
                                z_b -= depth_increment * y_b;
                                y_b = 0;
                            }

                            x_c <<= 14;
                            if (y_c < 0) {
                                x_c -= c_to_a * y_c;
                                y_c = 0;
                            }

                            var41 = y_b - centerY;
                            var32 += var34 * var41;
                            var35 += var37 * var41;
                            var38 += var40 * var41;
                            if (y_c != y_b && a_to_b < b_to_c || y_c == y_b && a_to_b > c_to_a) {
                                y_a -= y_c;
                                y_c -= y_b;
                                y_b = rasterClipY[y_b];

                                while (true) {
                                    --y_c;
                                    if (y_c < 0) {
                                        while (true) {
                                            --y_a;
                                            if (y_a < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_b, x_a >> 14, x_c >> 14, hsl2, var30, var32, var35, var38, var33, var36, var39, z_b, depth_slope, bufferOffset);
                                            x_a += a_to_b;
                                            x_c += c_to_a;
                                            hsl2 += var31;
                                            z_b += depth_increment;
                                            y_b += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_b, x_a >> 14, x_b >> 14, hsl2, var30, var32, var35, var38, var33, var36, var39, z_b, depth_slope, bufferOffset);
                                    x_a += a_to_b;
                                    x_b += b_to_c;
                                    hsl2 += var31;
                                    z_b += depth_increment;
                                    y_b += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            } else {
                                y_a -= y_c;
                                y_c -= y_b;
                                y_b = rasterClipY[y_b];

                                while (true) {
                                    --y_c;
                                    if (y_c < 0) {
                                        while (true) {
                                            --y_a;
                                            if (y_a < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_b, x_c >> 14, x_a >> 14, hsl2, var30, var32, var35, var38, var33, var36, var39, z_b, depth_slope, bufferOffset);
                                            x_a += a_to_b;
                                            x_c += c_to_a;
                                            hsl2 += var31;
                                            z_b += depth_increment;
                                            y_b += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_b, x_b >> 14, x_a >> 14, hsl2, var30, var32, var35, var38, var33, var36, var39, z_b, depth_slope, bufferOffset);
                                    x_a += a_to_b;
                                    x_b += b_to_c;
                                    hsl2 += var31;
                                    z_b += depth_increment;
                                    y_b += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            }
                        } else {
                            x_c = x_b <<= 14;
                            if (y_b < 0) {
                                x_c -= a_to_b * y_b;
                                x_b -= b_to_c * y_b;
                                hsl2 -= var31 * y_b;
                                z_b -= depth_increment * y_b;
                                y_b = 0;
                            }

                            x_a <<= 14;
                            if (y_a < 0) {
                                x_a -= y_a * c_to_a;
                                y_a = 0;
                            }

                            var41 = y_b - centerY;
                            var32 += var34 * var41;
                            var35 += var37 * var41;
                            var38 += var40 * var41;
                            if (a_to_b < b_to_c) {
                                y_c -= y_a;
                                y_a -= y_b;
                                y_b = rasterClipY[y_b];

                                while (true) {
                                    --y_a;
                                    if (y_a < 0) {
                                        while (true) {
                                            --y_c;
                                            if (y_c < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_b, x_a >> 14, x_b >> 14, hsl2, var30, var32, var35, var38, var33, var36, var39, z_b, depth_slope, bufferOffset);
                                            x_a += c_to_a;
                                            x_b += b_to_c;
                                            hsl2 += var31;
                                            z_b += depth_increment;
                                            y_b += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_b, x_c >> 14, x_b >> 14, hsl2, var30, var32, var35, var38, var33, var36, var39, z_b, depth_slope, bufferOffset);
                                    x_c += a_to_b;
                                    x_b += b_to_c;
                                    hsl2 += var31;
                                    z_b += depth_increment;
                                    y_b += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            } else {
                                y_c -= y_a;
                                y_a -= y_b;
                                y_b = rasterClipY[y_b];

                                while (true) {
                                    --y_a;
                                    if (y_a < 0) {
                                        while (true) {
                                            --y_c;
                                            if (y_c < 0) {
                                                return;
                                            }

                                            rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_b, x_b >> 14, x_a >> 14, hsl2, var30, var32, var35, var38, var33, var36, var39, z_b, depth_slope, bufferOffset);
                                            x_a += c_to_a;
                                            x_b += b_to_c;
                                            hsl2 += var31;
                                            z_b += depth_increment;
                                            y_b += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_b, x_b >> 14, x_c >> 14, hsl2, var30, var32, var35, var38, var33, var36, var39, z_b, depth_slope, bufferOffset);
                                    x_c += a_to_b;
                                    x_b += b_to_c;
                                    hsl2 += var31;
                                    z_b += depth_increment;
                                    y_b += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            }
                        }
                    }
                } else if (y_c < Rasterizer3D_clipHeight) {
                    if (y_a > Rasterizer3D_clipHeight) {
                        y_a = Rasterizer3D_clipHeight;
                    }

                    if (y_b > Rasterizer3D_clipHeight) {
                        y_b = Rasterizer3D_clipHeight;
                    }
                    z_c = z_c - depth_slope * x_c + depth_slope;
                    hsl3 = (hsl3 << 9) - x_c * var30 + var30;
                    if (y_a < y_b) {
                        x_b = x_c <<= 14;
                        if (y_c < 0) {
                            x_b -= b_to_c * y_c;
                            x_c -= c_to_a * y_c;
                            hsl3 -= var31 * y_c;
                            z_c -= depth_increment * y_c;
                            y_c = 0;
                        }

                        x_a <<= 14;
                        if (y_a < 0) {
                            x_a -= y_a * a_to_b;
                            y_a = 0;
                        }

                        var41 = y_c - centerY;
                        var32 += var34 * var41;
                        var35 += var37 * var41;
                        var38 += var40 * var41;
                        if (b_to_c < c_to_a) {
                            y_b -= y_a;
                            y_a -= y_c;
                            y_c = rasterClipY[y_c];

                            while (true) {
                                --y_a;
                                if (y_a < 0) {
                                    while (true) {
                                        --y_b;
                                        if (y_b < 0) {
                                            return;
                                        }

                                        rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_c, x_b >> 14, x_a >> 14, hsl3, var30, var32, var35, var38, var33, var36, var39, z_c, depth_slope, bufferOffset);
                                        x_b += b_to_c;
                                        x_a += a_to_b;
                                        hsl3 += var31;
                                        z_c += depth_increment;
                                        y_c += Rasterizer2D.graphicsPixelsWidth;
                                        var32 += var34;
                                        var35 += var37;
                                        var38 += var40;
                                    }
                                }

                                rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_c, x_b >> 14, x_c >> 14, hsl3, var30, var32, var35, var38, var33, var36, var39, z_c, depth_slope, bufferOffset);
                                x_b += b_to_c;
                                x_c += c_to_a;
                                hsl3 += var31;
                                z_c += depth_increment;
                                y_c += Rasterizer2D.graphicsPixelsWidth;
                                var32 += var34;
                                var35 += var37;
                                var38 += var40;
                            }
                        } else {
                            y_b -= y_a;
                            y_a -= y_c;
                            y_c = rasterClipY[y_c];

                            while (true) {
                                --y_a;
                                if (y_a < 0) {
                                    while (true) {
                                        --y_b;
                                        if (y_b < 0) {
                                            return;
                                        }

                                        rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_c, x_a >> 14, x_b >> 14, hsl3, var30, var32, var35, var38, var33, var36, var39, z_c, depth_slope, bufferOffset);
                                        x_b += b_to_c;
                                        x_a += a_to_b;
                                        hsl3 += var31;
                                        z_c += depth_increment;
                                        y_c += Rasterizer2D.graphicsPixelsWidth;
                                        var32 += var34;
                                        var35 += var37;
                                        var38 += var40;
                                    }
                                }

                                rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_c, x_c >> 14, x_b >> 14, hsl3, var30, var32, var35, var38, var33, var36, var39, z_c, depth_slope, bufferOffset);
                                x_b += b_to_c;
                                x_c += c_to_a;
                                hsl3 += var31;
                                z_c += depth_increment;
                                y_c += Rasterizer2D.graphicsPixelsWidth;
                                var32 += var34;
                                var35 += var37;
                                var38 += var40;
                            }
                        }
                    } else {
                        x_a = x_c <<= 14;
                        if (y_c < 0) {
                            x_a -= b_to_c * y_c;
                            x_c -= c_to_a * y_c;
                            hsl3 -= var31 * y_c;
                            z_c -= depth_increment * y_c;
                            y_c = 0;
                        }

                        x_b <<= 14;
                        if (y_b < 0) {
                            x_b -= a_to_b * y_b;
                            y_b = 0;
                        }

                        var41 = y_c - centerY;
                        var32 += var34 * var41;
                        var35 += var37 * var41;
                        var38 += var40 * var41;
                        if (b_to_c < c_to_a) {
                            y_a -= y_b;
                            y_b -= y_c;
                            y_c = rasterClipY[y_c];

                            while (true) {
                                --y_b;
                                if (y_b < 0) {
                                    while (true) {
                                        --y_a;
                                        if (y_a < 0) {
                                            return;
                                        }

                                        rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_c, x_b >> 14, x_c >> 14, hsl3, var30, var32, var35, var38, var33, var36, var39, z_c, depth_slope, bufferOffset);
                                        x_b += a_to_b;
                                        x_c += c_to_a;
                                        hsl3 += var31;
                                        z_c += depth_increment;
                                        y_c += Rasterizer2D.graphicsPixelsWidth;
                                        var32 += var34;
                                        var35 += var37;
                                        var38 += var40;
                                    }
                                }

                                rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_c, x_a >> 14, x_c >> 14, hsl3, var30, var32, var35, var38, var33, var36, var39, z_c, depth_slope, bufferOffset);
                                x_a += b_to_c;
                                x_c += c_to_a;
                                hsl3 += var31;
                                z_c += depth_increment;
                                y_c += Rasterizer2D.graphicsPixelsWidth;
                                var32 += var34;
                                var35 += var37;
                                var38 += var40;
                            }
                        } else {
                            y_a -= y_b;
                            y_b -= y_c;
                            y_c = rasterClipY[y_c];

                            while (true) {
                                --y_b;
                                if (y_b < 0) {
                                    while (true) {
                                        --y_a;
                                        if (y_a < 0) {
                                            return;
                                        }

                                        rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_c, x_c >> 14, x_b >> 14, hsl3, var30, var32, var35, var38, var33, var36, var39, z_c, depth_slope, bufferOffset);
                                        x_b += a_to_b;
                                        x_c += c_to_a;
                                        hsl3 += var31;
                                        z_c += depth_increment;
                                        y_c += Rasterizer2D.graphicsPixelsWidth;
                                        var32 += var34;
                                        var35 += var37;
                                        var38 += var40;
                                    }
                                }

                                rasterTextureAffineLine(Rasterizer2D.graphicsPixels, var19, 0, 0, y_c, x_c >> 14, x_a >> 14, hsl3, var30, var32, var35, var38, var33, var36, var39, z_c, depth_slope, bufferOffset);
                                x_a += b_to_c;
                                x_c += c_to_a;
                                hsl3 += var31;
                                z_c += depth_increment;
                                y_c += Rasterizer2D.graphicsPixelsWidth;
                                var32 += var34;
                                var35 += var37;
                                var38 += var40;
                            }
                        }
                    }
                }
            }
        }
    }

    @ObfuscatedName("a")
    @Export("rasterTextureAffineLine")
    static final void rasterTextureAffineLine(int[] dest, int[] texture, int loops, int var3, int dest_off, int x1, int x2, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, float z1, float z2, int bufferOffset) {
        if (rasterClipEnable) {
            if (x2 > rasterClipX) {
                x2 = rasterClipX;
            }

            if (x1 < 0) {
                x1 = 0;
            }
        }

        if (x1 < x2) {
            dest_off += x1;
            z1 += z2 * (float) x1;
            var7 += x1 * var8;
            int var17 = x2 - x1;
            int var15;
            int i_54_;
            int var10000;
            int var18;
            int var19;
            int var20;
            int var21;
            int var22;
            int var23;
            if (lowMem) {
                var23 = x1 - centerX;
                var9 += var23 * (var12 >> 3);
                var10 += (var13 >> 3) * var23;
                var11 += var23 * (var14 >> 3);
                var22 = var11 >> 12;
                if (var22 != 0) {
                    var18 = var9 / var22;
                    var19 = var10 / var22;
                    if (var18 < 0) {
                        var18 = 0;
                    } else if (var18 > 4032) {
                        var18 = 4032;
                    }
                } else {
                    var18 = 0;
                    var19 = 0;
                }

                var9 += var12;
                var10 += var13;
                var11 += var14;
                var22 = var11 >> 12;
                if (var22 != 0) {
                    var20 = var9 / var22;
                    var21 = var10 / var22;
                    if (var20 < 0) {
                        var20 = 0;
                    } else if (var20 > 4032) {
                        var20 = 4032;
                    }
                } else {
                    var20 = 0;
                    var21 = 0;
                }

                loops = (var18 << 20) + var19;
                i_54_ = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 20);
                var17 >>= 3;
                var8 <<= 3;
                var15 = var7 >> 8;
                if (field1729) {
                    if (var17 > 0) {
                        do {
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops >>> 26) + (loops & 4032)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops >>> 26) + (loops & 4032)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops >>> 26) + (loops & 4032)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops >>> 26) + (loops & 4032)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops >>> 26) + (loops & 4032)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops >>> 26) + (loops & 4032)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops >>> 26) + (loops & 4032)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops >>> 26) + (loops & 4032)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            //loops += i_54_;
                            var18 = var20;
                            var19 = var21;
                            var9 += var12;
                            var10 += var13;
                            var11 += var14;
                            var22 = var11 >> 12;
                            if (var22 != 0) {
                                var20 = var9 / var22;
                                var21 = var10 / var22;
                                if (var20 < 0) {
                                    var20 = 0;
                                } else if (var20 > 4032) {
                                    var20 = 4032;
                                }
                            } else {
                                var20 = 0;
                                var21 = 0;
                            }

                            loops = (var18 << 20) + var19;
                            i_54_ = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 20);
                            var7 += var8;
                            var15 = var7 >> 8;
                            --var17;
                        } while (var17 > 0);
                    }

                    var17 = x2 - x1 & 7;
                    if (var17 > 0) {
                        do {
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops >>> 26) + (loops & 4032)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            --var17;
                        } while (var17 > 0);
                    }
                } else {
                    if (var17 > 0) {
                        do {
                            if ((var3 = texture[(loops >>> 26) + (loops & 4032)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops >>> 26) + (loops & 4032)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops >>> 26) + (loops & 4032)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops >>> 26) + (loops & 4032)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops >>> 26) + (loops & 4032)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops >>> 26) + (loops & 4032)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops >>> 26) + (loops & 4032)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops >>> 26) + (loops & 4032)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            //loops += i_54_;
                            var18 = var20;
                            var19 = var21;
                            var9 += var12;
                            var10 += var13;
                            var11 += var14;
                            var22 = var11 >> 12;
                            if (var22 != 0) {
                                var20 = var9 / var22;
                                var21 = var10 / var22;
                                if (var20 < 0) {
                                    var20 = 0;
                                } else if (var20 > 4032) {
                                    var20 = 4032;
                                }
                            } else {
                                var20 = 0;
                                var21 = 0;
                            }

                            loops = (var18 << 20) + var19;
                            i_54_ = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 20);
                            var7 += var8;
                            var15 = var7 >> 8;
                            --var17;
                        } while (var17 > 0);
                    }

                    var17 = x2 - x1 & 7;
                    if (var17 > 0) {
                        do {
                            if ((var3 = texture[(loops >>> 26) + (loops & 4032)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            --var17;
                        } while (var17 > 0);
                    }
                }
            } else {
                var23 = x1 - centerX;
                var9 += var23 * (var12 >> 3);
                var10 += (var13 >> 3) * var23;
                var11 += var23 * (var14 >> 3);
                var22 = var11 >> 14;
                if (var22 != 0) {
                    var18 = var9 / var22;
                    var19 = var10 / var22;
                    if (var18 < 0) {
                        var18 = 0;
                    } else if (var18 > 16256) {
                        var18 = 16256;
                    }
                } else {
                    var18 = 0;
                    var19 = 0;
                }

                var9 += var12;
                var10 += var13;
                var11 += var14;
                var22 = var11 >> 14;
                if (var22 != 0) {
                    var20 = var9 / var22;
                    var21 = var10 / var22;
                    if (var20 < 0) {
                        var20 = 0;
                    } else if (var20 > 16256) {
                        var20 = 16256;
                    }
                } else {
                    var20 = 0;
                    var21 = 0;
                }

                loops = (var18 << 18) + var19;
                i_54_ = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 18);
                var17 >>= 3;
                var8 <<= 3;
                var15 = var7 >> 8;
                if (field1729) {
                    if (var17 > 0) {
                        do {
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops & 16256) + (loops >>> 25)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops & 16256) + (loops >>> 25)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops & 16256) + (loops >>> 25)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops & 16256) + (loops >>> 25)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops & 16256) + (loops >>> 25)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops & 16256) + (loops >>> 25)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops & 16256) + (loops >>> 25)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops & 16256) + (loops >>> 25)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            //loops += i_54_;
                            var18 = var20;
                            var19 = var21;
                            var9 += var12;
                            var10 += var13;
                            var11 += var14;
                            var22 = var11 >> 14;
                            if (var22 != 0) {
                                var20 = var9 / var22;
                                var21 = var10 / var22;
                                if (var20 < 0) {
                                    var20 = 0;
                                } else if (var20 > 16256) {
                                    var20 = 16256;
                                }
                            } else {
                                var20 = 0;
                                var21 = 0;
                            }

                            loops = (var18 << 18) + var19;
                            i_54_ = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 18);
                            var7 += var8;
                            var15 = var7 >> 8;
                            --var17;
                        } while (var17 > 0);
                    }

                    var17 = x2 - x1 & 7;
                    if (var17 > 0) {
                        do {
                            if (checkDepth(dest_off, bufferOffset, z1)) {
                                var3 = texture[(loops & 16256) + (loops >>> 25)];
                                dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                Rasterizer2D.depthBuffer[dest_off] = z1;
                            }
                            z1 += z2;
                            dest_off++;
                            loops += i_54_;
                            --var17;
                        } while (var17 > 0);
                    }
                } else {
                    if (var17 > 0) {
                        do {
                            if ((var3 = texture[(loops & 16256) + (loops >>> 25)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops & 16256) + (loops >>> 25)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops & 16256) + (loops >>> 25)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops & 16256) + (loops >>> 25)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops & 16256) + (loops >>> 25)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops & 16256) + (loops >>> 25)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops & 16256) + (loops >>> 25)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            if ((var3 = texture[(loops & 16256) + (loops >>> 25)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }
                            z1 += z2;
                            ++dest_off;
                            //loops += i_54_;
                            var18 = var20;
                            var19 = var21;
                            var9 += var12;
                            var10 += var13;
                            var11 += var14;
                            var22 = var11 >> 14;
                            if (var22 != 0) {
                                var20 = var9 / var22;
                                var21 = var10 / var22;
                                if (var20 < 0) {
                                    var20 = 0;
                                } else if (var20 > 16256) {
                                    var20 = 16256;
                                }
                            } else {
                                var20 = 0;
                                var21 = 0;
                            }

                            loops = (var18 << 18) + var19;
                            i_54_ = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 18);
                            var7 += var8;
                            var15 = var7 >> 8;
                            --var17;
                        } while (var17 > 0);
                    }

                    var17 = x2 - x1 & 7;
                    if (var17 > 0) {
                        do {
                            if ((var3 = texture[(loops & 16256) + (loops >>> 25)]) != 0) {
                                if (checkDepth(dest_off, bufferOffset, z1)) {
                                    dest[dest_off] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                                    Rasterizer2D.depthBuffer[dest_off] = z1;
                                }
                            }

                            z1 += z2;
                            ++dest_off;
                            loops += i_54_;
                            --var17;
                        } while (var17 > 0);
                    }
                }
            }

        }
    }

    @Export("rasterFlatIcon")
    public static final void rasterFlatIcon(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        int var7 = 0;
        if (var0 != var1) {
            var7 = (var4 - var3 << 14) / (var1 - var0);
        }

        int var8 = 0;
        if (var2 != var1) {
            var8 = (var5 - var4 << 14) / (var2 - var1);
        }

        int var9 = 0;
        if (var0 != var2) {
            var9 = (var3 - var5 << 14) / (var0 - var2);
        }

        if (var0 <= var1 && var0 <= var2) {
            if (var0 < Rasterizer3D_clipHeight) {
                if (var1 > Rasterizer3D_clipHeight) {
                    var1 = Rasterizer3D_clipHeight;
                }

                if (var2 > Rasterizer3D_clipHeight) {
                    var2 = Rasterizer3D_clipHeight;
                }

                if (var1 < var2) {
                    var5 = var3 <<= 14;
                    if (var0 < 0) {
                        var5 -= var0 * var9;
                        var3 -= var0 * var7;
                        var0 = 0;
                    }

                    var4 <<= 14;
                    if (var1 < 0) {
                        var4 -= var8 * var1;
                        var1 = 0;
                    }

                    if (var0 != var1 && var9 < var7 || var0 == var1 && var9 > var8) {
                        var2 -= var1;
                        var1 -= var0;
                        var0 = rasterClipY[var0];

                        while (true) {
                            --var1;
                            if (var1 < 0) {
                                while (true) {
                                    --var2;
                                    if (var2 < 0) {
                                        return;
                                    }

                                    rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var0, var6, 0, var5 >> 14, var4 >> 14);
                                    var5 += var9;
                                    var4 += var8;
                                    var0 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var0, var6, 0, var5 >> 14, var3 >> 14);
                            var5 += var9;
                            var3 += var7;
                            var0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        var2 -= var1;
                        var1 -= var0;
                        var0 = rasterClipY[var0];

                        while (true) {
                            --var1;
                            if (var1 < 0) {
                                while (true) {
                                    --var2;
                                    if (var2 < 0) {
                                        return;
                                    }

                                    rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var0, var6, 0, var4 >> 14, var5 >> 14);
                                    var5 += var9;
                                    var4 += var8;
                                    var0 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var0, var6, 0, var3 >> 14, var5 >> 14);
                            var5 += var9;
                            var3 += var7;
                            var0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                } else {
                    var4 = var3 <<= 14;
                    if (var0 < 0) {
                        var4 -= var0 * var9;
                        var3 -= var0 * var7;
                        var0 = 0;
                    }

                    var5 <<= 14;
                    if (var2 < 0) {
                        var5 -= var8 * var2;
                        var2 = 0;
                    }

                    if ((var0 == var2 || var9 >= var7) && (var0 != var2 || var8 <= var7)) {
                        var1 -= var2;
                        var2 -= var0;
                        var0 = rasterClipY[var0];

                        while (true) {
                            --var2;
                            if (var2 < 0) {
                                while (true) {
                                    --var1;
                                    if (var1 < 0) {
                                        return;
                                    }

                                    rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var0, var6, 0, var3 >> 14, var5 >> 14);
                                    var5 += var8;
                                    var3 += var7;
                                    var0 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var0, var6, 0, var3 >> 14, var4 >> 14);
                            var4 += var9;
                            var3 += var7;
                            var0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        var1 -= var2;
                        var2 -= var0;
                        var0 = rasterClipY[var0];

                        while (true) {
                            --var2;
                            if (var2 < 0) {
                                while (true) {
                                    --var1;
                                    if (var1 < 0) {
                                        return;
                                    }

                                    rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var0, var6, 0, var5 >> 14, var3 >> 14);
                                    var5 += var8;
                                    var3 += var7;
                                    var0 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var0, var6, 0, var4 >> 14, var3 >> 14);
                            var4 += var9;
                            var3 += var7;
                            var0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                }
            }
        } else if (var1 <= var2) {
            if (var1 < Rasterizer3D_clipHeight) {
                if (var2 > Rasterizer3D_clipHeight) {
                    var2 = Rasterizer3D_clipHeight;
                }

                if (var0 > Rasterizer3D_clipHeight) {
                    var0 = Rasterizer3D_clipHeight;
                }

                if (var2 < var0) {
                    var3 = var4 <<= 14;
                    if (var1 < 0) {
                        var3 -= var7 * var1;
                        var4 -= var8 * var1;
                        var1 = 0;
                    }

                    var5 <<= 14;
                    if (var2 < 0) {
                        var5 -= var9 * var2;
                        var2 = 0;
                    }

                    if (var2 != var1 && var7 < var8 || var2 == var1 && var7 > var9) {
                        var0 -= var2;
                        var2 -= var1;
                        var1 = rasterClipY[var1];

                        while (true) {
                            --var2;
                            if (var2 < 0) {
                                while (true) {
                                    --var0;
                                    if (var0 < 0) {
                                        return;
                                    }

                                    rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var1, var6, 0, var3 >> 14, var5 >> 14);
                                    var3 += var7;
                                    var5 += var9;
                                    var1 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var1, var6, 0, var3 >> 14, var4 >> 14);
                            var3 += var7;
                            var4 += var8;
                            var1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        var0 -= var2;
                        var2 -= var1;
                        var1 = rasterClipY[var1];

                        while (true) {
                            --var2;
                            if (var2 < 0) {
                                while (true) {
                                    --var0;
                                    if (var0 < 0) {
                                        return;
                                    }

                                    rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var1, var6, 0, var5 >> 14, var3 >> 14);
                                    var3 += var7;
                                    var5 += var9;
                                    var1 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var1, var6, 0, var4 >> 14, var3 >> 14);
                            var3 += var7;
                            var4 += var8;
                            var1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                } else {
                    var5 = var4 <<= 14;
                    if (var1 < 0) {
                        var5 -= var7 * var1;
                        var4 -= var8 * var1;
                        var1 = 0;
                    }

                    var3 <<= 14;
                    if (var0 < 0) {
                        var3 -= var0 * var9;
                        var0 = 0;
                    }

                    if (var7 < var8) {
                        var2 -= var0;
                        var0 -= var1;
                        var1 = rasterClipY[var1];

                        while (true) {
                            --var0;
                            if (var0 < 0) {
                                while (true) {
                                    --var2;
                                    if (var2 < 0) {
                                        return;
                                    }

                                    rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var1, var6, 0, var3 >> 14, var4 >> 14);
                                    var3 += var9;
                                    var4 += var8;
                                    var1 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var1, var6, 0, var5 >> 14, var4 >> 14);
                            var5 += var7;
                            var4 += var8;
                            var1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        var2 -= var0;
                        var0 -= var1;
                        var1 = rasterClipY[var1];

                        while (true) {
                            --var0;
                            if (var0 < 0) {
                                while (true) {
                                    --var2;
                                    if (var2 < 0) {
                                        return;
                                    }

                                    rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var1, var6, 0, var4 >> 14, var3 >> 14);
                                    var3 += var9;
                                    var4 += var8;
                                    var1 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var1, var6, 0, var4 >> 14, var5 >> 14);
                            var5 += var7;
                            var4 += var8;
                            var1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                }
            }
        } else if (var2 < Rasterizer3D_clipHeight) {
            if (var0 > Rasterizer3D_clipHeight) {
                var0 = Rasterizer3D_clipHeight;
            }

            if (var1 > Rasterizer3D_clipHeight) {
                var1 = Rasterizer3D_clipHeight;
            }

            if (var0 < var1) {
                var4 = var5 <<= 14;
                if (var2 < 0) {
                    var4 -= var8 * var2;
                    var5 -= var9 * var2;
                    var2 = 0;
                }

                var3 <<= 14;
                if (var0 < 0) {
                    var3 -= var0 * var7;
                    var0 = 0;
                }

                if (var8 < var9) {
                    var1 -= var0;
                    var0 -= var2;
                    var2 = rasterClipY[var2];

                    while (true) {
                        --var0;
                        if (var0 < 0) {
                            while (true) {
                                --var1;
                                if (var1 < 0) {
                                    return;
                                }

                                rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var2, var6, 0, var4 >> 14, var3 >> 14);
                                var4 += var8;
                                var3 += var7;
                                var2 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }

                        rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var2, var6, 0, var4 >> 14, var5 >> 14);
                        var4 += var8;
                        var5 += var9;
                        var2 += Rasterizer2D.graphicsPixelsWidth;
                    }
                } else {
                    var1 -= var0;
                    var0 -= var2;
                    var2 = rasterClipY[var2];

                    while (true) {
                        --var0;
                        if (var0 < 0) {
                            while (true) {
                                --var1;
                                if (var1 < 0) {
                                    return;
                                }

                                rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var2, var6, 0, var3 >> 14, var4 >> 14);
                                var4 += var8;
                                var3 += var7;
                                var2 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }

                        rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var2, var6, 0, var5 >> 14, var4 >> 14);
                        var4 += var8;
                        var5 += var9;
                        var2 += Rasterizer2D.graphicsPixelsWidth;
                    }
                }
            } else {
                var3 = var5 <<= 14;
                if (var2 < 0) {
                    var3 -= var8 * var2;
                    var5 -= var9 * var2;
                    var2 = 0;
                }

                var4 <<= 14;
                if (var1 < 0) {
                    var4 -= var7 * var1;
                    var1 = 0;
                }

                if (var8 < var9) {
                    var0 -= var1;
                    var1 -= var2;
                    var2 = rasterClipY[var2];

                    while (true) {
                        --var1;
                        if (var1 < 0) {
                            while (true) {
                                --var0;
                                if (var0 < 0) {
                                    return;
                                }

                                rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var2, var6, 0, var4 >> 14, var5 >> 14);
                                var4 += var7;
                                var5 += var9;
                                var2 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }

                        rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var2, var6, 0, var3 >> 14, var5 >> 14);
                        var3 += var8;
                        var5 += var9;
                        var2 += Rasterizer2D.graphicsPixelsWidth;
                    }
                } else {
                    var0 -= var1;
                    var1 -= var2;
                    var2 = rasterClipY[var2];

                    while (true) {
                        --var1;
                        if (var1 < 0) {
                            while (true) {
                                --var0;
                                if (var0 < 0) {
                                    return;
                                }

                                rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var2, var6, 0, var5 >> 14, var4 >> 14);
                                var4 += var7;
                                var5 += var9;
                                var2 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }

                        rasterFlatLineIcon(Rasterizer2D.graphicsPixels, var2, var6, 0, var5 >> 14, var3 >> 14);
                        var3 += var8;
                        var5 += var9;
                        var2 += Rasterizer2D.graphicsPixelsWidth;
                    }
                }
            }
        }
    }

    @Export("rasterFlatLineIcon")
    static final void rasterFlatLineIcon(int[] var0, int var1, int var2, int var3, int var4, int var5) {
        if (rasterClipEnable) {
            if (var5 > rasterClipX) {
                var5 = rasterClipX;
            }

            if (var4 < 0) {
                var4 = 0;
            }
        }

        if (var4 < var5) {
            var1 += var4;
            var3 = var5 - var4 >> 2;
            if (rasterAlpha != 0) {
                if (rasterAlpha == 254) {
                    while (true) {
                        --var3;
                        if (var3 < 0) {
                            var3 = var5 - var4 & 3;

                            while (true) {
                                --var3;
                                if (var3 < 0) {
                                    return;
                                }

                                var0[var1++] = var0[var1];
                            }
                        }

                        var0[var1++] = var0[var1];
                        var0[var1++] = var0[var1];
                        var0[var1++] = var0[var1];
                        var0[var1++] = var0[var1];
                    }
                } else {
                    int var6 = rasterAlpha;
                    int var7 = 256 - rasterAlpha;
                    var2 = (var7 * (var2 & 65280) >> 8 & 65280) + (var7 * (var2 & 16711935) >> 8 & 16711935);

                    while (true) {
                        --var3;
                        int var8;
                        if (var3 < 0) {
                            var3 = var5 - var4 & 3;

                            while (true) {
                                --var3;
                                if (var3 < 0) {
                                    return;
                                }

                                var8 = var0[var1];
                                var0[var1++] = ((var8 & 16711935) * var6 >> 8 & 16711935) + var2 + (var6 * (var8 & 65280) >> 8 & 65280);
                            }
                        }

                        var8 = var0[var1];
                        var0[var1++] = ((var8 & 16711935) * var6 >> 8 & 16711935) + var2 + (var6 * (var8 & 65280) >> 8 & 65280);
                        var8 = var0[var1];
                        var0[var1++] = ((var8 & 16711935) * var6 >> 8 & 16711935) + var2 + (var6 * (var8 & 65280) >> 8 & 65280);
                        var8 = var0[var1];
                        var0[var1++] = ((var8 & 16711935) * var6 >> 8 & 16711935) + var2 + (var6 * (var8 & 65280) >> 8 & 65280);
                        var8 = var0[var1];
                        var0[var1++] = ((var8 & 16711935) * var6 >> 8 & 16711935) + var2 + (var6 * (var8 & 65280) >> 8 & 65280);
                    }
                }
            } else {
                while (true) {
                    --var3;
                    if (var3 < 0) {
                        var3 = var5 - var4 & 3;

                        while (true) {
                            --var3;
                            if (var3 < 0) {
                                return;
                            }

                            var0[var1++] = var2;
                        }
                    }

                    var0[var1++] = var2;
                    var0[var1++] = var2;
                    var0[var1++] = var2;
                    var0[var1++] = var2;
                }
            }
        }
    }

    @ObfuscatedName("v")
    @Export("rasterFlat")
    static final void rasterFlat(int y_a, int y_b, int y_c, int x_a, int x_b, int x_c, int rgb, float z_a, float z_b, float z_c, int bufferOffset) {
        if (!rasterGouraudLowRes) {
            rasterFlatIcon(y_a, y_b, y_c, x_a, x_b, x_c, rgb);
            return;
        }
        int a_to_b = 0;
        if (y_b != y_a) {
            a_to_b = (x_b - x_a << 16) / (y_b - y_a);
        }
        int b_to_c = 0;
        if (y_c != y_b) {
            b_to_c = (x_c - x_b << 16) / (y_c - y_b);
        }
        int c_to_a = 0;
        if (y_c != y_a) {
            c_to_a = (x_a - x_c << 16) / (y_a - y_c);
        }

        float div = (x_b - x_a) * (y_c - y_a) - (x_c - x_a) * (y_b - y_a);
        float depth_slope = ((z_b - z_a) * (y_c - y_a) - (z_c - z_a) * (y_b - y_a)) / div;
        float depth_increment = ((z_c - z_a) * (x_b - x_a) - (z_b - z_a) * (x_c - x_a)) / div;

        if (y_a <= y_b && y_a <= y_c) {
            if (y_a < Rasterizer3D_clipHeight) {
                if (y_b > Rasterizer3D_clipHeight) {
                    y_b = Rasterizer3D_clipHeight;
                }
                if (y_c > Rasterizer3D_clipHeight) {
                    y_c = Rasterizer3D_clipHeight;
                }
                z_a = z_a - depth_slope * x_a + depth_slope;
                if (y_b < y_c) {
                    x_c = x_a <<= 16;
                    if (y_a < 0) {
                        x_c -= c_to_a * y_a;
                        x_a -= a_to_b * y_a;
                        z_a -= depth_increment * y_a;
                        y_a = 0;
                    }
                    x_b <<= 16;
                    if (y_b < 0) {
                        x_b -= b_to_c * y_b;
                        y_b = 0;
                    }
                    if (y_a != y_b && c_to_a < a_to_b || y_a == y_b && c_to_a > b_to_c) {
                        y_c -= y_b;
                        y_b -= y_a;
                        y_a = rasterClipY[y_a];
                        while (--y_b >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_a, rgb, 0, x_c >> 16, x_a >> 16, z_a, depth_slope, bufferOffset);
                            x_c += c_to_a;
                            x_a += a_to_b;
                            z_a += depth_increment;
                            y_a += Rasterizer2D.graphicsPixelsWidth;
                        }
                        while (--y_c >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_a, rgb, 0, x_c >> 16, x_b >> 16, z_a, depth_slope, bufferOffset);
                            x_c += c_to_a;
                            x_b += b_to_c;
                            z_a += depth_increment;
                            y_a += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        y_c -= y_b;
                        y_b -= y_a;
                        y_a = rasterClipY[y_a];
                        while (--y_b >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_a, rgb, 0, x_a >> 16, x_c >> 16, z_a, depth_slope, bufferOffset);
                            x_c += c_to_a;
                            x_a += a_to_b;
                            z_a += depth_increment;
                            y_a += Rasterizer2D.graphicsPixelsWidth;
                        }
                        while (--y_c >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_a, rgb, 0, x_b >> 16, x_c >> 16, z_a, depth_slope, bufferOffset);
                            x_c += c_to_a;
                            x_b += b_to_c;
                            z_a += depth_increment;
                            y_a += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                } else {
                    x_b = x_a <<= 16;
                    if (y_a < 0) {
                        x_b -= c_to_a * y_a;
                        x_a -= a_to_b * y_a;
                        z_a -= depth_increment * y_a;
                        y_a = 0;
                    }
                    x_c <<= 16;
                    if (y_c < 0) {
                        x_c -= b_to_c * y_c;
                        y_c = 0;
                    }
                    if (y_a != y_c && c_to_a < a_to_b || y_a == y_c && b_to_c > a_to_b) {
                        y_b -= y_c;
                        y_c -= y_a;
                        y_a = rasterClipY[y_a];
                        while (--y_c >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_a, rgb, 0, x_b >> 16, x_a >> 16, z_a, depth_slope, bufferOffset);
                            x_b += c_to_a;
                            x_a += a_to_b;
                            z_a += depth_increment;
                            y_a += Rasterizer2D.graphicsPixelsWidth;
                        }
                        while (--y_b >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_a, rgb, 0, x_c >> 16, x_a >> 16, z_a, depth_slope, bufferOffset);
                            x_c += b_to_c;
                            x_a += a_to_b;
                            z_a += depth_increment;
                            y_a += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        y_b -= y_c;
                        y_c -= y_a;
                        y_a = rasterClipY[y_a];
                        while (--y_c >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_a, rgb, 0, x_a >> 16, x_b >> 16, z_a, depth_slope, bufferOffset);
                            x_b += c_to_a;
                            x_a += a_to_b;
                            z_a += depth_increment;
                            y_a += Rasterizer2D.graphicsPixelsWidth;
                        }
                        while (--y_b >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_a, rgb, 0, x_a >> 16, x_c >> 16, z_a, depth_slope, bufferOffset);
                            x_c += b_to_c;
                            x_a += a_to_b;
                            z_a += depth_increment;
                            y_a += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                }
            }
        } else if (y_b <= y_c) {
            if (y_b < Rasterizer3D_clipHeight) {
                if (y_c > Rasterizer3D_clipHeight) {
                    y_c = Rasterizer3D_clipHeight;
                }
                if (y_a > Rasterizer3D_clipHeight) {
                    y_a = Rasterizer3D_clipHeight;
                }
                z_b = z_b - depth_slope * x_b + depth_slope;
                if (y_c < y_a) {
                    x_a = x_b <<= 16;
                    if (y_b < 0) {
                        x_a -= a_to_b * y_b;
                        x_b -= b_to_c * y_b;
                        z_b -= depth_increment * y_b;
                        y_b = 0;
                    }
                    x_c <<= 16;
                    if (y_c < 0) {
                        x_c -= c_to_a * y_c;
                        y_c = 0;
                    }
                    if (y_b != y_c && a_to_b < b_to_c || y_b == y_c && a_to_b > c_to_a) {
                        y_a -= y_c;
                        y_c -= y_b;
                        y_b = rasterClipY[y_b];
                        while (--y_c >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_b, rgb, 0, x_a >> 16, x_b >> 16, z_b, depth_slope, bufferOffset);
                            x_a += a_to_b;
                            x_b += b_to_c;
                            z_b += depth_increment;
                            y_b += Rasterizer2D.graphicsPixelsWidth;
                        }
                        while (--y_a >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_b, rgb, 0, x_a >> 16, x_c >> 16, z_b, depth_slope, bufferOffset);
                            x_a += a_to_b;
                            x_c += c_to_a;
                            z_b += depth_increment;
                            y_b += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        y_a -= y_c;
                        y_c -= y_b;
                        y_b = rasterClipY[y_b];
                        while (--y_c >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_b, rgb, 0, x_b >> 16, x_a >> 16, z_b, depth_slope, bufferOffset);
                            x_a += a_to_b;
                            x_b += b_to_c;
                            z_b += depth_increment;
                            y_b += Rasterizer2D.graphicsPixelsWidth;
                        }
                        while (--y_a >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_b, rgb, 0, x_c >> 16, x_a >> 16, z_b, depth_slope, bufferOffset);
                            x_a += a_to_b;
                            x_c += c_to_a;
                            z_b += depth_increment;
                            y_b += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                } else {
                    x_c = x_b <<= 16;
                    if (y_b < 0) {
                        x_c -= a_to_b * y_b;
                        x_b -= b_to_c * y_b;
                        z_b -= depth_increment * y_b;
                        y_b = 0;
                    }
                    x_a <<= 16;
                    if (y_a < 0) {
                        x_a -= c_to_a * y_a;
                        y_a = 0;
                    }
                    if (a_to_b < b_to_c) {
                        y_c -= y_a;
                        y_a -= y_b;
                        y_b = rasterClipY[y_b];
                        while (--y_a >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_b, rgb, 0, x_c >> 16, x_b >> 16, z_b, depth_slope, bufferOffset);
                            x_c += a_to_b;
                            x_b += b_to_c;
                            z_b += depth_increment;
                            y_b += Rasterizer2D.graphicsPixelsWidth;
                        }
                        while (--y_c >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_b, rgb, 0, x_a >> 16, x_b >> 16, z_b, depth_slope, bufferOffset);
                            x_a += c_to_a;
                            x_b += b_to_c;
                            z_b += depth_increment;
                            y_b += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        y_c -= y_a;
                        y_a -= y_b;
                        y_b = rasterClipY[y_b];
                        while (--y_a >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_b, rgb, 0, x_b >> 16, x_c >> 16, z_b, depth_slope, bufferOffset);
                            x_c += a_to_b;
                            x_b += b_to_c;
                            z_b += depth_increment;
                            y_b += Rasterizer2D.graphicsPixelsWidth;
                        }
                        while (--y_c >= 0) {
                            rasterFlatLine(Rasterizer2D.graphicsPixels, y_b, rgb, 0, x_b >> 16, x_a >> 16, z_b, depth_slope, bufferOffset);
                            x_a += c_to_a;
                            x_b += b_to_c;
                            z_b += depth_increment;
                            y_b += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                }
            }
        } else if (y_c < Rasterizer3D_clipHeight) {
            if (y_a > Rasterizer3D_clipHeight) {
                y_a = Rasterizer3D_clipHeight;
            }
            if (y_b > Rasterizer3D_clipHeight) {
                y_b = Rasterizer3D_clipHeight;
            }
            z_c = z_c - depth_slope * x_c + depth_slope;
            if (y_a < y_b) {
                x_b = x_c <<= 16;
                if (y_c < 0) {
                    x_b -= b_to_c * y_c;
                    x_c -= c_to_a * y_c;
                    z_c -= depth_increment * y_c;
                    y_c = 0;
                }
                x_a <<= 16;
                if (y_a < 0) {
                    x_a -= a_to_b * y_a;
                    y_a = 0;
                }
                if (b_to_c < c_to_a) {
                    y_b -= y_a;
                    y_a -= y_c;
                    y_c = rasterClipY[y_c];
                    while (--y_a >= 0) {
                        rasterFlatLine(Rasterizer2D.graphicsPixels, y_c, rgb, 0, x_b >> 16, x_c >> 16, z_c, depth_slope, bufferOffset);
                        x_b += b_to_c;
                        x_c += c_to_a;
                        z_c += depth_increment;
                        y_c += Rasterizer2D.graphicsPixelsWidth;
                    }
                    while (--y_b >= 0) {
                        rasterFlatLine(Rasterizer2D.graphicsPixels, y_c, rgb, 0, x_b >> 16, x_a >> 16, z_c, depth_slope, bufferOffset);
                        x_b += b_to_c;
                        x_a += a_to_b;
                        z_c += depth_increment;
                        y_c += Rasterizer2D.graphicsPixelsWidth;
                    }
                } else {
                    y_b -= y_a;
                    y_a -= y_c;
                    y_c = rasterClipY[y_c];
                    while (--y_a >= 0) {
                        rasterFlatLine(Rasterizer2D.graphicsPixels, y_c, rgb, 0, x_c >> 16, x_b >> 16, z_c, depth_slope, bufferOffset);
                        x_b += b_to_c;
                        x_c += c_to_a;
                        z_c += depth_increment;
                        y_c += Rasterizer2D.graphicsPixelsWidth;
                    }
                    while (--y_b >= 0) {
                        rasterFlatLine(Rasterizer2D.graphicsPixels, y_c, rgb, 0, x_a >> 16, x_b >> 16, z_c, depth_slope, bufferOffset);
                        x_b += b_to_c;
                        x_a += a_to_b;
                        z_c += depth_increment;
                        y_c += Rasterizer2D.graphicsPixelsWidth;
                    }
                }
            } else {
                x_a = x_c <<= 16;
                if (y_c < 0) {
                    x_a -= b_to_c * y_c;
                    x_c -= c_to_a * y_c;
                    z_c -= depth_increment * y_c;
                    y_c = 0;
                }
                x_b <<= 16;
                if (y_b < 0) {
                    x_b -= a_to_b * y_b;
                    y_b = 0;
                }
                if (b_to_c < c_to_a) {
                    y_a -= y_b;
                    y_b -= y_c;
                    y_c = rasterClipY[y_c];
                    while (--y_b >= 0) {
                        rasterFlatLine(Rasterizer2D.graphicsPixels, y_c, rgb, 0, x_a >> 16, x_c >> 16, z_c, depth_slope, bufferOffset);
                        x_a += b_to_c;
                        x_c += c_to_a;
                        z_c += depth_increment;
                        y_c += Rasterizer2D.graphicsPixelsWidth;
                    }
                    while (--y_a >= 0) {
                        rasterFlatLine(Rasterizer2D.graphicsPixels, y_c, rgb, 0, x_b >> 16, x_c >> 16, z_c, depth_slope, bufferOffset);
                        x_b += a_to_b;
                        x_c += c_to_a;
                        z_c += depth_increment;
                        y_c += Rasterizer2D.graphicsPixelsWidth;
                    }
                } else {
                    y_a -= y_b;
                    y_b -= y_c;
                    y_c = rasterClipY[y_c];
                    while (--y_b >= 0) {
                        rasterFlatLine(Rasterizer2D.graphicsPixels, y_c, rgb, 0, x_c >> 16, x_a >> 16, z_c, depth_slope, bufferOffset);
                        x_a += b_to_c;
                        x_c += c_to_a;
                        z_c += depth_increment;
                        y_c += Rasterizer2D.graphicsPixelsWidth;
                    }
                    while (--y_a >= 0) {
                        rasterFlatLine(Rasterizer2D.graphicsPixels, y_c, rgb, 0, x_c >> 16, x_b >> 16, z_c, depth_slope, bufferOffset);
                        x_b += a_to_b;
                        x_c += c_to_a;
                        z_c += depth_increment;
                        y_c += Rasterizer2D.graphicsPixelsWidth;
                    }
                }
            }
        }
    }

    @ObfuscatedName("h")
    @Export("rasterFlatLine")
    static final void rasterFlatLine(int[] dest, int dest_off, int rgb, int loops, int start_x, int end_x, float depth, float depth_slope, int bufferOffset) {
        if (rasterClipEnable) {
            if (end_x > rasterClipX) {
                end_x = rasterClipX;
            }
            if (start_x < 0) {
                start_x = 0;
            }
        }
        if (start_x < end_x) {
            dest_off += start_x;
            loops = end_x - start_x >> 2;
            depth += depth_slope * (float) start_x;
            if (rasterAlpha == 0) {
                while (--loops >= 0) {
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = rgb;
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = rgb;
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = rgb;
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = rgb;
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                }
                loops = end_x - start_x & 0x3;
                while (--loops >= 0) {
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = rgb;
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                }
            } else if (rasterAlpha == 254) {
                while (--loops >= 0) {
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = dest[dest_off];
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = dest[dest_off];
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = dest[dest_off];
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = dest[dest_off];
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                }
                loops = end_x - start_x & 0x3;
                while (--loops >= 0) {
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = dest[dest_off];
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                }
            } else {
                int src_alpha = rasterAlpha;
                int dest_alpha = 256 - rasterAlpha;
                rgb = ((rgb & 0xff00ff) * dest_alpha >> 8 & 0xff00ff) + ((rgb & 0xff00) * dest_alpha >> 8 & 0xff00);
                while (--loops >= 0) {
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = rgb + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00);
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = rgb + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00);
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = rgb + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00);
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = rgb + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00);
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                }
                loops = end_x - start_x & 0x3;
                while (--loops >= 0) {
                    if (checkDepth(dest_off, bufferOffset, depth)) {
                        dest[dest_off] = rgb + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00);
                        Rasterizer2D.depthBuffer[dest_off] = depth;
                    }
                    depth += depth_slope;
                    dest_off++;
                }
            }
        }
    }

    @ObfuscatedName("r")
    static final void method2562(int var0, int var1, int var2, int var3) {
        rasterClipX = var2 - var0;
        Rasterizer3D_clipHeight = var3 - var1;
        method2600();
        if (rasterClipY.length < Rasterizer3D_clipHeight) {
            rasterClipY = new int[TotalQuantityComparator.method1181(Rasterizer3D_clipHeight)];
        }

        int var4 = var0 + Rasterizer2D.graphicsPixelsWidth * var1;

        for (int var5 = 0; var5 < Rasterizer3D_clipHeight; ++var5) {
            rasterClipY[var5] = var4;
            var4 += Rasterizer2D.graphicsPixelsWidth;
        }

    }

    @ObfuscatedName("e")
    public static final void method2600() {
        centerX = rasterClipX / 2;
        centerY = Rasterizer3D_clipHeight / 2;
        Rasterizer3D_clipNegativeMidX = -centerX;
        Rasterizer3D_clipMidX2 = rasterClipX - centerX;
        Rasterizer3D_clipNegativeMidY = -centerY;
        Rasterizer3D_clipMidY2 = Rasterizer3D_clipHeight - centerY;
    }

    @ObfuscatedName("af")
    static final int method2583(int var0, int var1, int var2, int var3) {
        return var3 * var0 + var2 * var1 >> 16;
    }

    @ObfuscatedName("q")
    public static final void method2572(int var0, int var1) {
        int var2 = rasterClipY[0];
        int var3 = var2 / Rasterizer2D.graphicsPixelsWidth;
        int var4 = var2 - var3 * Rasterizer2D.graphicsPixelsWidth;
        centerX = var0 - var4;
        centerY = var1 - var3;
        Rasterizer3D_clipNegativeMidX = -centerX;
        Rasterizer3D_clipMidX2 = rasterClipX - centerX;
        Rasterizer3D_clipNegativeMidY = -centerY;
        Rasterizer3D_clipMidY2 = Rasterizer3D_clipHeight - centerY;
    }

    @ObfuscatedName("m")
    static int method2630(int var0, double var1) {
        double var3 = (double) (var0 >> 16) / 256.0D;
        double var5 = (double) (var0 >> 8 & 255) / 256.0D;
        double var7 = (double) (var0 & 255) / 256.0D;
        var3 = Math.pow(var3, var1);
        var5 = Math.pow(var5, var1);
        var7 = Math.pow(var7, var1);
        int var9 = (int) (var3 * 256.0D);
        int var10 = (int) (var5 * 256.0D);
        int var11 = (int) (var7 * 256.0D);
        return var11 + (var10 << 8) + (var9 << 16);
    }

    @ObfuscatedName("p")
    static final void method2568(double var0, int var2, int var3) {
        int var4 = var2 * 128;

        for (int var5 = var2; var5 < var3; ++var5) {
            double var6 = (double) (var5 >> 3) / 64.0D + 0.0078125D;
            double var8 = (double) (var5 & 7) / 8.0D + 0.0625D;

            for (int var10 = 0; var10 < 128; ++var10) {
                double var11 = (double) var10 / 128.0D;
                double var13 = var11;
                double var15 = var11;
                double var17 = var11;
                if (var8 != 0.0D) {
                    double var19;
                    if (var11 < 0.5D) {
                        var19 = var11 * (1.0D + var8);
                    } else {
                        var19 = var11 + var8 - var11 * var8;
                    }

                    double var21 = 2.0D * var11 - var19;
                    double var23 = var6 + 0.3333333333333333D;
                    if (var23 > 1.0D) {
                        --var23;
                    }

                    double var27 = var6 - 0.3333333333333333D;
                    if (var27 < 0.0D) {
                        ++var27;
                    }

                    if (6.0D * var23 < 1.0D) {
                        var13 = var21 + (var19 - var21) * 6.0D * var23;
                    } else if (2.0D * var23 < 1.0D) {
                        var13 = var19;
                    } else if (3.0D * var23 < 2.0D) {
                        var13 = var21 + (var19 - var21) * (0.6666666666666666D - var23) * 6.0D;
                    } else {
                        var13 = var21;
                    }

                    if (6.0D * var6 < 1.0D) {
                        var15 = var21 + (var19 - var21) * 6.0D * var6;
                    } else if (2.0D * var6 < 1.0D) {
                        var15 = var19;
                    } else if (3.0D * var6 < 2.0D) {
                        var15 = var21 + (var19 - var21) * (0.6666666666666666D - var6) * 6.0D;
                    } else {
                        var15 = var21;
                    }

                    if (6.0D * var27 < 1.0D) {
                        var17 = var21 + (var19 - var21) * 6.0D * var27;
                    } else if (2.0D * var27 < 1.0D) {
                        var17 = var19;
                    } else if (3.0D * var27 < 2.0D) {
                        var17 = var21 + (var19 - var21) * (0.6666666666666666D - var27) * 6.0D;
                    } else {
                        var17 = var21;
                    }
                }

                int var29 = (int) (var13 * 256.0D);
                int var20 = (int) (var15 * 256.0D);
                int var30 = (int) (var17 * 256.0D);
                int var22 = var30 + (var20 << 8) + (var29 << 16);
                var22 = method2630(var22, var0);
                if (var22 == 0) {
                    var22 = 1;
                }

                colorPalette[var4++] = var22;
            }
        }

    }

    @ObfuscatedName("o")
    static final int method2574(int var0, int var1, int var2, int var3) {
        return var0 * var2 - var3 * var1 >> 16;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(Lex;)V"
    )
    public static final void method2566(ITextureLoader var0) {
        textureLoader = var0;
    }

    @ObfuscatedName("t")
    @Export("rasterTexture")
    static final void rasterTexture(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18) {
        int[] var19 = textureLoader.vmethod5375(var18);
        int var20;
        if (var19 == null) {
            var20 = textureLoader.vmethod5363(var18);
            rasterGouraud(var0, var1, var2, var3, var4, var5, method2579(var20, var6), method2579(var20, var7), method2579(var20, var8), 0, 0, 0, 0);
        } else {
            lowMem = textureLoader.vmethod5364(var18);
            field1729 = textureLoader.vmethod5366(var18);
            var20 = var4 - var3;
            int var21 = var1 - var0;
            int var22 = var5 - var3;
            int var23 = var2 - var0;
            int var24 = var7 - var6;
            int var25 = var8 - var6;
            int var26 = 0;
            if (var0 != var1) {
                var26 = (var4 - var3 << 14) / (var1 - var0);
            }

            int var27 = 0;
            if (var2 != var1) {
                var27 = (var5 - var4 << 14) / (var2 - var1);
            }

            int var28 = 0;
            if (var0 != var2) {
                var28 = (var3 - var5 << 14) / (var0 - var2);
            }

            int var29 = var20 * var23 - var22 * var21;
            if (var29 != 0) {
                int var30 = (var24 * var23 - var25 * var21 << 9) / var29;
                int var31 = (var25 * var20 - var24 * var22 << 9) / var29;
                var10 = var9 - var10;
                var13 = var12 - var13;
                var16 = var15 - var16;
                var11 -= var9;
                var14 -= var12;
                var17 -= var15;
                int var32 = var11 * var12 - var9 * var14 << 14;
                int var33 = (int) (((long) (var15 * var14 - var17 * var12) << 14) / (long) Rasterizer3D_zoom);
                int var34 = (int) (((long) (var17 * var9 - var11 * var15) << 14) / (long) Rasterizer3D_zoom);
                int var35 = var10 * var12 - var13 * var9 << 14;
                int var36 = (int) (((long) (var13 * var15 - var16 * var12) << 14) / (long) Rasterizer3D_zoom);
                int var37 = (int) (((long) (var16 * var9 - var10 * var15) << 14) / (long) Rasterizer3D_zoom);
                int var38 = var13 * var11 - var10 * var14 << 14;
                int var39 = (int) (((long) (var16 * var14 - var13 * var17) << 14) / (long) Rasterizer3D_zoom);
                int var40 = (int) (((long) (var17 * var10 - var11 * var16) << 14) / (long) Rasterizer3D_zoom);
                int var41;
                if (var0 <= var1 && var0 <= var2) {
                    if (var0 < Rasterizer3D_clipHeight) {
                        if (var1 > Rasterizer3D_clipHeight) {
                            var1 = Rasterizer3D_clipHeight;
                        }

                        if (var2 > Rasterizer3D_clipHeight) {
                            var2 = Rasterizer3D_clipHeight;
                        }

                        var6 = var30 + ((var6 << 9) - var3 * var30);
                        if (var1 < var2) {
                            var5 = var3 <<= 14;
                            if (var0 < 0) {
                                var5 -= var0 * var28;
                                var3 -= var0 * var26;
                                var6 -= var0 * var31;
                                var0 = 0;
                            }

                            var4 <<= 14;
                            if (var1 < 0) {
                                var4 -= var27 * var1;
                                var1 = 0;
                            }

                            var41 = var0 - centerY;
                            var32 += var34 * var41;
                            var35 += var37 * var41;
                            var38 += var40 * var41;
                            if (var0 != var1 && var28 < var26 || var0 == var1 && var28 > var27) {
                                var2 -= var1;
                                var1 -= var0;
                                var0 = rasterClipY[var0];

                                while (true) {
                                    --var1;
                                    if (var1 < 0) {
                                        while (true) {
                                            --var2;
                                            if (var2 < 0) {
                                                return;
                                            }

                                            rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var5 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                            var5 += var28;
                                            var4 += var27;
                                            var6 += var31;
                                            var0 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                    var5 += var28;
                                    var3 += var26;
                                    var6 += var31;
                                    var0 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            } else {
                                var2 -= var1;
                                var1 -= var0;
                                var0 = rasterClipY[var0];

                                while (true) {
                                    --var1;
                                    if (var1 < 0) {
                                        while (true) {
                                            --var2;
                                            if (var2 < 0) {
                                                return;
                                            }

                                            rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var4 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                            var5 += var28;
                                            var4 += var27;
                                            var6 += var31;
                                            var0 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                    var5 += var28;
                                    var3 += var26;
                                    var6 += var31;
                                    var0 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            }
                        } else {
                            var4 = var3 <<= 14;
                            if (var0 < 0) {
                                var4 -= var0 * var28;
                                var3 -= var0 * var26;
                                var6 -= var0 * var31;
                                var0 = 0;
                            }

                            var5 <<= 14;
                            if (var2 < 0) {
                                var5 -= var27 * var2;
                                var2 = 0;
                            }

                            var41 = var0 - centerY;
                            var32 += var34 * var41;
                            var35 += var37 * var41;
                            var38 += var40 * var41;
                            if ((var0 == var2 || var28 >= var26) && (var0 != var2 || var27 <= var26)) {
                                var1 -= var2;
                                var2 -= var0;
                                var0 = rasterClipY[var0];

                                while (true) {
                                    --var2;
                                    if (var2 < 0) {
                                        while (true) {
                                            --var1;
                                            if (var1 < 0) {
                                                return;
                                            }

                                            rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                            var5 += var27;
                                            var3 += var26;
                                            var6 += var31;
                                            var0 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var3 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                    var4 += var28;
                                    var3 += var26;
                                    var6 += var31;
                                    var0 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            } else {
                                var1 -= var2;
                                var2 -= var0;
                                var0 = rasterClipY[var0];

                                while (true) {
                                    --var2;
                                    if (var2 < 0) {
                                        while (true) {
                                            --var1;
                                            if (var1 < 0) {
                                                return;
                                            }

                                            rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                            var5 += var27;
                                            var3 += var26;
                                            var6 += var31;
                                            var0 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var4 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                    var4 += var28;
                                    var3 += var26;
                                    var6 += var31;
                                    var0 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            }
                        }
                    }
                } else if (var1 <= var2) {
                    if (var1 < Rasterizer3D_clipHeight) {
                        if (var2 > Rasterizer3D_clipHeight) {
                            var2 = Rasterizer3D_clipHeight;
                        }

                        if (var0 > Rasterizer3D_clipHeight) {
                            var0 = Rasterizer3D_clipHeight;
                        }

                        var7 = var30 + ((var7 << 9) - var30 * var4);
                        if (var2 < var0) {
                            var3 = var4 <<= 14;
                            if (var1 < 0) {
                                var3 -= var26 * var1;
                                var4 -= var27 * var1;
                                var7 -= var31 * var1;
                                var1 = 0;
                            }

                            var5 <<= 14;
                            if (var2 < 0) {
                                var5 -= var28 * var2;
                                var2 = 0;
                            }

                            var41 = var1 - centerY;
                            var32 += var34 * var41;
                            var35 += var37 * var41;
                            var38 += var40 * var41;
                            if (var2 != var1 && var26 < var27 || var2 == var1 && var26 > var28) {
                                var0 -= var2;
                                var2 -= var1;
                                var1 = rasterClipY[var1];

                                while (true) {
                                    --var2;
                                    if (var2 < 0) {
                                        while (true) {
                                            --var0;
                                            if (var0 < 0) {
                                                return;
                                            }

                                            rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var3 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                            var3 += var26;
                                            var5 += var28;
                                            var7 += var31;
                                            var1 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                    var3 += var26;
                                    var4 += var27;
                                    var7 += var31;
                                    var1 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            } else {
                                var0 -= var2;
                                var2 -= var1;
                                var1 = rasterClipY[var1];

                                while (true) {
                                    --var2;
                                    if (var2 < 0) {
                                        while (true) {
                                            --var0;
                                            if (var0 < 0) {
                                                return;
                                            }

                                            rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var5 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                            var3 += var26;
                                            var5 += var28;
                                            var7 += var31;
                                            var1 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                    var3 += var26;
                                    var4 += var27;
                                    var7 += var31;
                                    var1 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            }
                        } else {
                            var5 = var4 <<= 14;
                            if (var1 < 0) {
                                var5 -= var26 * var1;
                                var4 -= var27 * var1;
                                var7 -= var31 * var1;
                                var1 = 0;
                            }

                            var3 <<= 14;
                            if (var0 < 0) {
                                var3 -= var0 * var28;
                                var0 = 0;
                            }

                            var41 = var1 - centerY;
                            var32 += var34 * var41;
                            var35 += var37 * var41;
                            var38 += var40 * var41;
                            if (var26 < var27) {
                                var2 -= var0;
                                var0 -= var1;
                                var1 = rasterClipY[var1];

                                while (true) {
                                    --var0;
                                    if (var0 < 0) {
                                        while (true) {
                                            --var2;
                                            if (var2 < 0) {
                                                return;
                                            }

                                            rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                            var3 += var28;
                                            var4 += var27;
                                            var7 += var31;
                                            var1 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var5 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                    var5 += var26;
                                    var4 += var27;
                                    var7 += var31;
                                    var1 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            } else {
                                var2 -= var0;
                                var0 -= var1;
                                var1 = rasterClipY[var1];

                                while (true) {
                                    --var0;
                                    if (var0 < 0) {
                                        while (true) {
                                            --var2;
                                            if (var2 < 0) {
                                                return;
                                            }

                                            rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                            var3 += var28;
                                            var4 += var27;
                                            var7 += var31;
                                            var1 += Rasterizer2D.graphicsPixelsWidth;
                                            var32 += var34;
                                            var35 += var37;
                                            var38 += var40;
                                        }
                                    }

                                    rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var4 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                    var5 += var26;
                                    var4 += var27;
                                    var7 += var31;
                                    var1 += Rasterizer2D.graphicsPixelsWidth;
                                    var32 += var34;
                                    var35 += var37;
                                    var38 += var40;
                                }
                            }
                        }
                    }
                } else if (var2 < Rasterizer3D_clipHeight) {
                    if (var0 > Rasterizer3D_clipHeight) {
                        var0 = Rasterizer3D_clipHeight;
                    }

                    if (var1 > Rasterizer3D_clipHeight) {
                        var1 = Rasterizer3D_clipHeight;
                    }

                    var8 = (var8 << 9) - var5 * var30 + var30;
                    if (var0 < var1) {
                        var4 = var5 <<= 14;
                        if (var2 < 0) {
                            var4 -= var27 * var2;
                            var5 -= var28 * var2;
                            var8 -= var31 * var2;
                            var2 = 0;
                        }

                        var3 <<= 14;
                        if (var0 < 0) {
                            var3 -= var0 * var26;
                            var0 = 0;
                        }

                        var41 = var2 - centerY;
                        var32 += var34 * var41;
                        var35 += var37 * var41;
                        var38 += var40 * var41;
                        if (var27 < var28) {
                            var1 -= var0;
                            var0 -= var2;
                            var2 = rasterClipY[var2];

                            while (true) {
                                --var0;
                                if (var0 < 0) {
                                    while (true) {
                                        --var1;
                                        if (var1 < 0) {
                                            return;
                                        }

                                        rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var4 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                        var4 += var27;
                                        var3 += var26;
                                        var8 += var31;
                                        var2 += Rasterizer2D.graphicsPixelsWidth;
                                        var32 += var34;
                                        var35 += var37;
                                        var38 += var40;
                                    }
                                }

                                rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                var4 += var27;
                                var5 += var28;
                                var8 += var31;
                                var2 += Rasterizer2D.graphicsPixelsWidth;
                                var32 += var34;
                                var35 += var37;
                                var38 += var40;
                            }
                        } else {
                            var1 -= var0;
                            var0 -= var2;
                            var2 = rasterClipY[var2];

                            while (true) {
                                --var0;
                                if (var0 < 0) {
                                    while (true) {
                                        --var1;
                                        if (var1 < 0) {
                                            return;
                                        }

                                        rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var3 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                        var4 += var27;
                                        var3 += var26;
                                        var8 += var31;
                                        var2 += Rasterizer2D.graphicsPixelsWidth;
                                        var32 += var34;
                                        var35 += var37;
                                        var38 += var40;
                                    }
                                }

                                rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                var4 += var27;
                                var5 += var28;
                                var8 += var31;
                                var2 += Rasterizer2D.graphicsPixelsWidth;
                                var32 += var34;
                                var35 += var37;
                                var38 += var40;
                            }
                        }
                    } else {
                        var3 = var5 <<= 14;
                        if (var2 < 0) {
                            var3 -= var27 * var2;
                            var5 -= var28 * var2;
                            var8 -= var31 * var2;
                            var2 = 0;
                        }

                        var4 <<= 14;
                        if (var1 < 0) {
                            var4 -= var26 * var1;
                            var1 = 0;
                        }

                        var41 = var2 - centerY;
                        var32 += var34 * var41;
                        var35 += var37 * var41;
                        var38 += var40 * var41;
                        if (var27 < var28) {
                            var0 -= var1;
                            var1 -= var2;
                            var2 = rasterClipY[var2];

                            while (true) {
                                --var1;
                                if (var1 < 0) {
                                    while (true) {
                                        --var0;
                                        if (var0 < 0) {
                                            return;
                                        }

                                        rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                        var4 += var26;
                                        var5 += var28;
                                        var8 += var31;
                                        var2 += Rasterizer2D.graphicsPixelsWidth;
                                        var32 += var34;
                                        var35 += var37;
                                        var38 += var40;
                                    }
                                }

                                rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var3 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                var3 += var27;
                                var5 += var28;
                                var8 += var31;
                                var2 += Rasterizer2D.graphicsPixelsWidth;
                                var32 += var34;
                                var35 += var37;
                                var38 += var40;
                            }
                        } else {
                            var0 -= var1;
                            var1 -= var2;
                            var2 = rasterClipY[var2];

                            while (true) {
                                --var1;
                                if (var1 < 0) {
                                    while (true) {
                                        --var0;
                                        if (var0 < 0) {
                                            return;
                                        }

                                        rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                        var4 += var26;
                                        var5 += var28;
                                        var8 += var31;
                                        var2 += Rasterizer2D.graphicsPixelsWidth;
                                        var32 += var34;
                                        var35 += var37;
                                        var38 += var40;
                                    }
                                }

                                rasterTextureLine(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var5 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                                var3 += var27;
                                var5 += var28;
                                var8 += var31;
                                var2 += Rasterizer2D.graphicsPixelsWidth;
                                var32 += var34;
                                var35 += var37;
                                var38 += var40;
                            }
                        }
                    }
                }
            }
        }
    }

    @ObfuscatedName("k")
    @Export("rasterTextureLine")
    static final void rasterTextureLine(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
        if (rasterClipEnable) {
            if (var6 > rasterClipX) {
                var6 = rasterClipX;
            }

            if (var5 < 0) {
                var5 = 0;
            }
        }

        if (var5 < var6) {
            var4 += var5;
            var7 += var5 * var8;
            int var17 = var6 - var5;
            int var15;
            int var16;
            int var18;
            int var19;
            int var20;
            int var21;
            int var22;
            int var23;
            if (lowMem) {
                var23 = var5 - centerX;
                var9 += var23 * var12;
                var10 += var13 * var23;
                var11 += var23 * var14;
                var22 = var11 >> 12;
                if (var22 != 0) {
                    var18 = var9 / var22;
                    var19 = var10 / var22;
                } else {
                    var18 = 0;
                    var19 = 0;
                }

                var9 += var17 * var12;
                var10 += var13 * var17;
                var11 += var17 * var14;
                var22 = var11 >> 12;
                if (var22 != 0) {
                    var20 = var9 / var22;
                    var21 = var10 / var22;
                } else {
                    var20 = 0;
                    var21 = 0;
                }

                var2 = (var18 << 20) + var19;
                var16 = (var21 - var19) / var17 + ((var20 - var18) / var17 << 20);
                var17 >>= 3;
                var8 <<= 3;
                var15 = var7 >> 8;
                if (field1729) {
                    if (var17 > 0) {
                        do {
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var7 += var8;
                            var15 = var7 >> 8;
                            --var17;
                        } while (var17 > 0);
                    }

                    var17 = var6 - var5 & 7;
                    if (var17 > 0) {
                        do {
                            var3 = var1[(var2 >>> 26) + (var2 & 4032)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            --var17;
                        } while (var17 > 0);
                    }
                } else {
                    if (var17 > 0) {
                        do {
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            var7 += var8;
                            var15 = var7 >> 8;
                            --var17;
                        } while (var17 > 0);
                    }

                    var17 = var6 - var5 & 7;
                    if (var17 > 0) {
                        do {
                            if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            --var17;
                        } while (var17 > 0);
                    }
                }
            } else {
                var23 = var5 - centerX;
                var9 += var23 * var12;
                var10 += var13 * var23;
                var11 += var23 * var14;
                var22 = var11 >> 14;
                if (var22 != 0) {
                    var18 = var9 / var22;
                    var19 = var10 / var22;
                } else {
                    var18 = 0;
                    var19 = 0;
                }

                var9 += var17 * var12;
                var10 += var13 * var17;
                var11 += var17 * var14;
                var22 = var11 >> 14;
                if (var22 != 0) {
                    var20 = var9 / var22;
                    var21 = var10 / var22;
                } else {
                    var20 = 0;
                    var21 = 0;
                }

                var2 = (var18 << 18) + var19;
                var16 = (var21 - var19) / var17 + ((var20 - var18) / var17 << 18);
                var17 >>= 3;
                var8 <<= 3;
                var15 = var7 >> 8;
                if (field1729) {
                    if (var17 > 0) {
                        do {
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            var7 += var8;
                            var15 = var7 >> 8;
                            --var17;
                        } while (var17 > 0);
                    }

                    var17 = var6 - var5 & 7;
                    if (var17 > 0) {
                        do {
                            var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                            var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            var2 += var16;
                            --var17;
                        } while (var17 > 0);
                    }
                } else {
                    if (var17 > 0) {
                        do {
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            var7 += var8;
                            var15 = var7 >> 8;
                            --var17;
                        } while (var17 > 0);
                    }

                    var17 = var6 - var5 & 7;
                    if (var17 > 0) {
                        do {
                            if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                                var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
                            }

                            ++var4;
                            var2 += var16;
                            --var17;
                        } while (var17 > 0);
                    }
                }
            }
        }
    }

    @ObfuscatedName("an")
    static final int method2584(int var0, int var1, int var2, int var3) {
        return var0 * var2 + var3 * var1 >> 16;
    }

    @ObfuscatedName("i")
    public static final void method2567(double var0) {
        method2568(var0, 0, 512);
    }

    @ObfuscatedName("y")
    static final int method2564(int var0, int var1, int var2, int var3) {
        return var0 * var2 + var3 * var1 >> 16;
    }

    @ObfuscatedName("ax")
    static final int method2598(int var0, int var1, int var2, int var3) {
        return var2 * var1 - var3 * var0 >> 16;
    }

    @ObfuscatedName("d")
    public static void method2570(int var0, int var1, int var2) {
        rasterClipEnable = var0 < 0 || var0 > rasterClipX || var1 < 0 || var1 > rasterClipX || var2 < 0 || var2 > rasterClipX;
    }

    @Export("rasterGouraudIcon")
    static final void rasterGouraudIcon(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9 = var4 - var3;
        int var10 = var1 - var0;
        int var11 = var5 - var3;
        int var12 = var2 - var0;
        int var13 = var7 - var6;
        int var14 = var8 - var6;
        int var15;
        if (var2 != var1) {
            var15 = (var5 - var4 << 14) / (var2 - var1);
        } else {
            var15 = 0;
        }

        int var16;
        if (var0 != var1) {
            var16 = (var9 << 14) / var10;
        } else {
            var16 = 0;
        }

        int var17;
        if (var0 != var2) {
            var17 = (var11 << 14) / var12;
        } else {
            var17 = 0;
        }

        int var18 = var9 * var12 - var11 * var10;
        if (var18 != 0) {
            int var19 = (var13 * var12 - var14 * var10 << 8) / var18;
            int var20 = (var14 * var9 - var13 * var11 << 8) / var18;
            if (var0 <= var1 && var0 <= var2) {
                if (var0 < Rasterizer3D_clipHeight) {
                    if (var1 > Rasterizer3D_clipHeight) {
                        var1 = Rasterizer3D_clipHeight;
                    }

                    if (var2 > Rasterizer3D_clipHeight) {
                        var2 = Rasterizer3D_clipHeight;
                    }

                    var6 = var19 + ((var6 << 8) - var3 * var19);
                    if (var1 < var2) {
                        var5 = var3 <<= 14;
                        if (var0 < 0) {
                            var5 -= var0 * var17;
                            var3 -= var0 * var16;
                            var6 -= var0 * var20;
                            var0 = 0;
                        }

                        var4 <<= 14;
                        if (var1 < 0) {
                            var4 -= var15 * var1;
                            var1 = 0;
                        }

                        if (var0 != var1 && var17 < var16 || var0 == var1 && var17 > var15) {
                            var2 -= var1;
                            var1 -= var0;
                            var0 = rasterClipY[var0];

                            while (true) {
                                --var1;
                                if (var1 < 0) {
                                    while (true) {
                                        --var2;
                                        if (var2 < 0) {
                                            return;
                                        }

                                        rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var0, 0, 0, var5 >> 14, var4 >> 14, var6, var19);
                                        var5 += var17;
                                        var4 += var15;
                                        var6 += var20;
                                        var0 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var0, 0, 0, var5 >> 14, var3 >> 14, var6, var19);
                                var5 += var17;
                                var3 += var16;
                                var6 += var20;
                                var0 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        } else {
                            var2 -= var1;
                            var1 -= var0;
                            var0 = rasterClipY[var0];

                            while (true) {
                                --var1;
                                if (var1 < 0) {
                                    while (true) {
                                        --var2;
                                        if (var2 < 0) {
                                            return;
                                        }

                                        rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var0, 0, 0, var4 >> 14, var5 >> 14, var6, var19);
                                        var5 += var17;
                                        var4 += var15;
                                        var6 += var20;
                                        var0 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var0, 0, 0, var3 >> 14, var5 >> 14, var6, var19);
                                var5 += var17;
                                var3 += var16;
                                var6 += var20;
                                var0 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }
                    } else {
                        var4 = var3 <<= 14;
                        if (var0 < 0) {
                            var4 -= var0 * var17;
                            var3 -= var0 * var16;
                            var6 -= var0 * var20;
                            var0 = 0;
                        }

                        var5 <<= 14;
                        if (var2 < 0) {
                            var5 -= var15 * var2;
                            var2 = 0;
                        }

                        if ((var0 == var2 || var17 >= var16) && (var0 != var2 || var15 <= var16)) {
                            var1 -= var2;
                            var2 -= var0;
                            var0 = rasterClipY[var0];

                            while (true) {
                                --var2;
                                if (var2 < 0) {
                                    while (true) {
                                        --var1;
                                        if (var1 < 0) {
                                            return;
                                        }

                                        rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var0, 0, 0, var3 >> 14, var5 >> 14, var6, var19);
                                        var5 += var15;
                                        var3 += var16;
                                        var6 += var20;
                                        var0 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var0, 0, 0, var3 >> 14, var4 >> 14, var6, var19);
                                var4 += var17;
                                var3 += var16;
                                var6 += var20;
                                var0 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        } else {
                            var1 -= var2;
                            var2 -= var0;
                            var0 = rasterClipY[var0];

                            while (true) {
                                --var2;
                                if (var2 < 0) {
                                    while (true) {
                                        --var1;
                                        if (var1 < 0) {
                                            return;
                                        }

                                        rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var0, 0, 0, var5 >> 14, var3 >> 14, var6, var19);
                                        var5 += var15;
                                        var3 += var16;
                                        var6 += var20;
                                        var0 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var0, 0, 0, var4 >> 14, var3 >> 14, var6, var19);
                                var4 += var17;
                                var3 += var16;
                                var6 += var20;
                                var0 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }
                    }
                }
            } else if (var1 <= var2) {
                if (var1 < Rasterizer3D_clipHeight) {
                    if (var2 > Rasterizer3D_clipHeight) {
                        var2 = Rasterizer3D_clipHeight;
                    }

                    if (var0 > Rasterizer3D_clipHeight) {
                        var0 = Rasterizer3D_clipHeight;
                    }

                    var7 = var19 + ((var7 << 8) - var19 * var4);
                    if (var2 < var0) {
                        var3 = var4 <<= 14;
                        if (var1 < 0) {
                            var3 -= var16 * var1;
                            var4 -= var15 * var1;
                            var7 -= var20 * var1;
                            var1 = 0;
                        }

                        var5 <<= 14;
                        if (var2 < 0) {
                            var5 -= var17 * var2;
                            var2 = 0;
                        }

                        if (var2 != var1 && var16 < var15 || var2 == var1 && var16 > var17) {
                            var0 -= var2;
                            var2 -= var1;
                            var1 = rasterClipY[var1];

                            while (true) {
                                --var2;
                                if (var2 < 0) {
                                    while (true) {
                                        --var0;
                                        if (var0 < 0) {
                                            return;
                                        }

                                        rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var1, 0, 0, var3 >> 14, var5 >> 14, var7, var19);
                                        var3 += var16;
                                        var5 += var17;
                                        var7 += var20;
                                        var1 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var1, 0, 0, var3 >> 14, var4 >> 14, var7, var19);
                                var3 += var16;
                                var4 += var15;
                                var7 += var20;
                                var1 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        } else {
                            var0 -= var2;
                            var2 -= var1;
                            var1 = rasterClipY[var1];

                            while (true) {
                                --var2;
                                if (var2 < 0) {
                                    while (true) {
                                        --var0;
                                        if (var0 < 0) {
                                            return;
                                        }

                                        rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var1, 0, 0, var5 >> 14, var3 >> 14, var7, var19);
                                        var3 += var16;
                                        var5 += var17;
                                        var7 += var20;
                                        var1 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var1, 0, 0, var4 >> 14, var3 >> 14, var7, var19);
                                var3 += var16;
                                var4 += var15;
                                var7 += var20;
                                var1 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }
                    } else {
                        var5 = var4 <<= 14;
                        if (var1 < 0) {
                            var5 -= var16 * var1;
                            var4 -= var15 * var1;
                            var7 -= var20 * var1;
                            var1 = 0;
                        }

                        var3 <<= 14;
                        if (var0 < 0) {
                            var3 -= var0 * var17;
                            var0 = 0;
                        }

                        if (var16 < var15) {
                            var2 -= var0;
                            var0 -= var1;
                            var1 = rasterClipY[var1];

                            while (true) {
                                --var0;
                                if (var0 < 0) {
                                    while (true) {
                                        --var2;
                                        if (var2 < 0) {
                                            return;
                                        }

                                        rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var1, 0, 0, var3 >> 14, var4 >> 14, var7, var19);
                                        var3 += var17;
                                        var4 += var15;
                                        var7 += var20;
                                        var1 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var1, 0, 0, var5 >> 14, var4 >> 14, var7, var19);
                                var5 += var16;
                                var4 += var15;
                                var7 += var20;
                                var1 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        } else {
                            var2 -= var0;
                            var0 -= var1;
                            var1 = rasterClipY[var1];

                            while (true) {
                                --var0;
                                if (var0 < 0) {
                                    while (true) {
                                        --var2;
                                        if (var2 < 0) {
                                            return;
                                        }

                                        rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var1, 0, 0, var4 >> 14, var3 >> 14, var7, var19);
                                        var3 += var17;
                                        var4 += var15;
                                        var7 += var20;
                                        var1 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var1, 0, 0, var4 >> 14, var5 >> 14, var7, var19);
                                var5 += var16;
                                var4 += var15;
                                var7 += var20;
                                var1 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }
                    }
                }
            } else if (var2 < Rasterizer3D_clipHeight) {
                if (var0 > Rasterizer3D_clipHeight) {
                    var0 = Rasterizer3D_clipHeight;
                }

                if (var1 > Rasterizer3D_clipHeight) {
                    var1 = Rasterizer3D_clipHeight;
                }

                var8 = var19 + ((var8 << 8) - var5 * var19);
                if (var0 < var1) {
                    var4 = var5 <<= 14;
                    if (var2 < 0) {
                        var4 -= var15 * var2;
                        var5 -= var17 * var2;
                        var8 -= var20 * var2;
                        var2 = 0;
                    }

                    var3 <<= 14;
                    if (var0 < 0) {
                        var3 -= var0 * var16;
                        var0 = 0;
                    }

                    if (var15 < var17) {
                        var1 -= var0;
                        var0 -= var2;
                        var2 = rasterClipY[var2];

                        while (true) {
                            --var0;
                            if (var0 < 0) {
                                while (true) {
                                    --var1;
                                    if (var1 < 0) {
                                        return;
                                    }

                                    rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var2, 0, 0, var4 >> 14, var3 >> 14, var8, var19);
                                    var4 += var15;
                                    var3 += var16;
                                    var8 += var20;
                                    var2 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var2, 0, 0, var4 >> 14, var5 >> 14, var8, var19);
                            var4 += var15;
                            var5 += var17;
                            var8 += var20;
                            var2 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        var1 -= var0;
                        var0 -= var2;
                        var2 = rasterClipY[var2];

                        while (true) {
                            --var0;
                            if (var0 < 0) {
                                while (true) {
                                    --var1;
                                    if (var1 < 0) {
                                        return;
                                    }

                                    rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var2, 0, 0, var3 >> 14, var4 >> 14, var8, var19);
                                    var4 += var15;
                                    var3 += var16;
                                    var8 += var20;
                                    var2 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var2, 0, 0, var5 >> 14, var4 >> 14, var8, var19);
                            var4 += var15;
                            var5 += var17;
                            var8 += var20;
                            var2 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                } else {
                    var3 = var5 <<= 14;
                    if (var2 < 0) {
                        var3 -= var15 * var2;
                        var5 -= var17 * var2;
                        var8 -= var20 * var2;
                        var2 = 0;
                    }

                    var4 <<= 14;
                    if (var1 < 0) {
                        var4 -= var16 * var1;
                        var1 = 0;
                    }

                    if (var15 < var17) {
                        var0 -= var1;
                        var1 -= var2;
                        var2 = rasterClipY[var2];

                        while (true) {
                            --var1;
                            if (var1 < 0) {
                                while (true) {
                                    --var0;
                                    if (var0 < 0) {
                                        return;
                                    }

                                    rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var2, 0, 0, var4 >> 14, var5 >> 14, var8, var19);
                                    var4 += var16;
                                    var5 += var17;
                                    var8 += var20;
                                    var2 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var2, 0, 0, var3 >> 14, var5 >> 14, var8, var19);
                            var3 += var15;
                            var5 += var17;
                            var8 += var20;
                            var2 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        var0 -= var1;
                        var1 -= var2;
                        var2 = rasterClipY[var2];

                        while (true) {
                            --var1;
                            if (var1 < 0) {
                                while (true) {
                                    --var0;
                                    if (var0 < 0) {
                                        return;
                                    }

                                    rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var2, 0, 0, var5 >> 14, var4 >> 14, var8, var19);
                                    var4 += var16;
                                    var5 += var17;
                                    var8 += var20;
                                    var2 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterGouraudLineIcon(Rasterizer2D.graphicsPixels, var2, 0, 0, var5 >> 14, var3 >> 14, var8, var19);
                            var3 += var15;
                            var5 += var17;
                            var8 += var20;
                            var2 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                }
            }
        }
    }

    @Export("rasterGouraudLineIcon")
    static final void rasterGouraudLineIcon(int[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        if (rasterClipEnable) {
            if (var5 > rasterClipX) {
                var5 = rasterClipX;
            }

            if (var4 < 0) {
                var4 = 0;
            }
        }

        if (var4 < var5) {
            var1 += var4;
            var6 += var4 * var7;
            int var8;
            int var9;
            int var10;
            if (rasterGouraudLowRes) {
                var3 = var5 - var4 >> 2;
                var7 <<= 2;
                if (rasterAlpha == 0) {
                    if (var3 > 0) {
                        do {
                            var2 = colorPalette[var6 >> 8];
                            var6 += var7;
                            var0[var1++] = var2;
                            var0[var1++] = var2;
                            var0[var1++] = var2;
                            var0[var1++] = var2;
                            --var3;
                        } while (var3 > 0);
                    }

                    var3 = var5 - var4 & 3;
                    if (var3 > 0) {
                        var2 = colorPalette[var6 >> 8];

                        do {
                            var0[var1++] = var2;
                            --var3;
                        } while (var3 > 0);
                    }
                } else {
                    var8 = rasterAlpha;
                    var9 = 256 - rasterAlpha;
                    if (var3 > 0) {
                        do {
                            var2 = colorPalette[var6 >> 8];
                            var6 += var7;
                            var2 = (var9 * (var2 & 65280) >> 8 & 65280) + (var9 * (var2 & 16711935) >> 8 & 16711935);
                            var10 = var0[var1];
                            var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
                            var10 = var0[var1];
                            var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
                            var10 = var0[var1];
                            var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
                            var10 = var0[var1];
                            var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
                            --var3;
                        } while (var3 > 0);
                    }

                    var3 = var5 - var4 & 3;
                    if (var3 > 0) {
                        var2 = colorPalette[var6 >> 8];
                        var2 = (var9 * (var2 & 65280) >> 8 & 65280) + (var9 * (var2 & 16711935) >> 8 & 16711935);

                        do {
                            var10 = var0[var1];
                            var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
                            --var3;
                        } while (var3 > 0);
                    }
                }

            } else {
                var3 = var5 - var4;
                if (rasterAlpha == 0) {
                    do {
                        var0[var1++] = colorPalette[var6 >> 8];
                        var6 += var7;
                        --var3;
                    } while (var3 > 0);
                } else {
                    var8 = rasterAlpha;
                    var9 = 256 - rasterAlpha;

                    do {
                        var2 = colorPalette[var6 >> 8];
                        var6 += var7;
                        var2 = (var9 * (var2 & 65280) >> 8 & 65280) + (var9 * (var2 & 16711935) >> 8 & 16711935);
                        var10 = var0[var1];
                        var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
                        --var3;
                    } while (var3 > 0);
                }

            }
        }
    }

    @ObfuscatedName("j")
    @Export("rasterGouraud")
    static final void rasterGouraud(int y_a, int y_b, int y_c, int x_a, int x_b, int x_c, int hsl1, int hsl2, int hsl3, float z_a, float z_b, float z_c, int bufferOffset) {
        if (!rasterGouraudLowRes) {
            rasterGouraudIcon(y_a, y_b, y_c, x_a, x_b, x_c, hsl1, hsl2, hsl3);
            return;
        }
        int b_aX = x_b - x_a;
        int b_aY = y_b - y_a;
        int c_aX = x_c - x_a;
        int c_aY = y_c - y_a;
        float b_aZ = z_b - z_a;
        float c_aZ = z_c - z_a;
        int grad1 = hsl2 - hsl1;
        int grad2 = hsl3 - hsl1;
        int i_178_;
        if (y_c != y_b) {
            i_178_ = (x_c - x_b << 14) / (y_c - y_b);
        } else {
            i_178_ = 0;
        }

        int var16;
        if (y_a != y_b) {
            var16 = (b_aX << 14) / b_aY;
        } else {
            var16 = 0;
        }

        int var17;
        if (y_a != y_c) {
            var17 = (c_aX << 14) / c_aY;
        } else {
            var17 = 0;
        }

        int div = b_aX * c_aY - c_aX * b_aY;
        float depth_slope = (b_aZ * c_aY - c_aZ * b_aY) / div;
        float depth_increment = (c_aZ * b_aX - b_aZ * c_aX) / div;

        if (div != 0) {
            int var19 = (grad1 * c_aY - grad2 * b_aY << 8) / div;
            int var20 = (grad2 * b_aX - grad1 * c_aX << 8) / div;
            if (y_a <= y_b && y_a <= y_c) {
                if (y_a < Rasterizer3D_clipHeight) {
                    if (y_b > Rasterizer3D_clipHeight) {
                        y_b = Rasterizer3D_clipHeight;
                    }

                    if (y_c > Rasterizer3D_clipHeight) {
                        y_c = Rasterizer3D_clipHeight;
                    }

                    hsl1 = var19 + ((hsl1 << 8) - x_a * var19);
                    z_a = z_a - depth_slope * x_a + depth_slope;
                    if (y_b < y_c) {
                        x_c = x_a <<= 14;
                        if (y_a < 0) {
                            x_c -= y_a * var17;
                            x_a -= y_a * var16;
                            hsl1 -= y_a * var20;
                            z_a -= depth_increment * y_a;
                            y_a = 0;
                        }

                        x_b <<= 14;
                        if (y_b < 0) {
                            x_b -= i_178_ * y_b;
                            y_b = 0;
                        }

                        if (y_a != y_b && var17 < var16 || y_a == y_b && var17 > i_178_) {
                            y_c -= y_b;
                            y_b -= y_a;
                            y_a = rasterClipY[y_a];

                            while (true) {
                                --y_b;
                                if (y_b < 0) {
                                    while (true) {
                                        --y_c;
                                        if (y_c < 0) {
                                            return;
                                        }

                                        rasterGouraudLine(Rasterizer2D.graphicsPixels, y_a, 0, 0, x_c >> 14, x_b >> 14, hsl1, var19, z_a, depth_slope, bufferOffset);
                                        x_c += var17;
                                        x_b += i_178_;
                                        hsl1 += var20;
                                        z_a += depth_increment;
                                        y_a += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLine(Rasterizer2D.graphicsPixels, y_a, 0, 0, x_c >> 14, x_a >> 14, hsl1, var19, z_a, depth_slope, bufferOffset);
                                x_c += var17;
                                x_a += var16;
                                hsl1 += var20;
                                z_a += depth_increment;
                                y_a += Rasterizer2D.graphicsPixelsWidth;
                            }
                        } else {
                            y_c -= y_b;
                            y_b -= y_a;
                            y_a = rasterClipY[y_a];

                            while (true) {
                                --y_b;
                                if (y_b < 0) {
                                    while (true) {
                                        --y_c;
                                        if (y_c < 0) {
                                            return;
                                        }

                                        rasterGouraudLine(Rasterizer2D.graphicsPixels, y_a, 0, 0, x_b >> 14, x_c >> 14, hsl1, var19, z_a, depth_slope, bufferOffset);
                                        x_c += var17;
                                        x_b += i_178_;
                                        hsl1 += var20;
                                        z_a += depth_increment;
                                        y_a += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLine(Rasterizer2D.graphicsPixels, y_a, 0, 0, x_a >> 14, x_c >> 14, hsl1, var19, z_a, depth_slope, bufferOffset);
                                x_c += var17;
                                x_a += var16;
                                hsl1 += var20;
                                z_a += depth_increment;
                                y_a += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }
                    } else {
                        x_b = x_a <<= 14;
                        if (y_a < 0) {
                            x_b -= y_a * var17;
                            x_a -= y_a * var16;
                            hsl1 -= y_a * var20;
                            z_a -= depth_increment * y_a;
                            y_a = 0;
                        }

                        x_c <<= 14;
                        if (y_c < 0) {
                            x_c -= i_178_ * y_c;
                            y_c = 0;
                        }

                        if ((y_a == y_c || var17 >= var16) && (y_a != y_c || i_178_ <= var16)) {
                            y_b -= y_c;
                            y_c -= y_a;
                            y_a = rasterClipY[y_a];

                            while (true) {
                                --y_c;
                                if (y_c < 0) {
                                    while (true) {
                                        --y_b;
                                        if (y_b < 0) {
                                            return;
                                        }

                                        rasterGouraudLine(Rasterizer2D.graphicsPixels, y_a, 0, 0, x_a >> 14, x_c >> 14, hsl1, var19, z_a, depth_slope, bufferOffset);
                                        x_c += i_178_;
                                        x_a += var16;
                                        hsl1 += var20;
                                        z_a += depth_increment;
                                        y_a += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLine(Rasterizer2D.graphicsPixels, y_a, 0, 0, x_a >> 14, x_b >> 14, hsl1, var19, z_a, depth_slope, bufferOffset);
                                x_b += var17;
                                x_a += var16;
                                hsl1 += var20;
                                z_a += depth_increment;
                                y_a += Rasterizer2D.graphicsPixelsWidth;
                            }
                        } else {
                            y_b -= y_c;
                            y_c -= y_a;
                            y_a = rasterClipY[y_a];

                            while (true) {
                                --y_c;
                                if (y_c < 0) {
                                    while (true) {
                                        --y_b;
                                        if (y_b < 0) {
                                            return;
                                        }

                                        rasterGouraudLine(Rasterizer2D.graphicsPixels, y_a, 0, 0, x_c >> 14, x_a >> 14, hsl1, var19, z_a, depth_slope, bufferOffset);
                                        x_c += i_178_;
                                        x_a += var16;
                                        hsl1 += var20;
                                        z_a += depth_increment;
                                        y_a += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLine(Rasterizer2D.graphicsPixels, y_a, 0, 0, x_b >> 14, x_a >> 14, hsl1, var19, z_a, depth_slope, bufferOffset);
                                x_b += var17;
                                x_a += var16;
                                hsl1 += var20;
                                z_a += depth_increment;
                                y_a += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }
                    }
                }
            } else if (y_b <= y_c) {
                if (y_b < Rasterizer3D_clipHeight) {
                    if (y_c > Rasterizer3D_clipHeight) {
                        y_c = Rasterizer3D_clipHeight;
                    }

                    if (y_a > Rasterizer3D_clipHeight) {
                        y_a = Rasterizer3D_clipHeight;
                    }

                    hsl2 = var19 + ((hsl2 << 8) - var19 * x_b);
                    z_b = z_b - depth_slope * x_b + depth_slope;
                    if (y_c < y_a) {
                        x_a = x_b <<= 14;
                        if (y_b < 0) {
                            x_a -= var16 * y_b;
                            x_b -= i_178_ * y_b;
                            hsl2 -= var20 * y_b;
                            z_b -= depth_increment * y_b;
                            y_b = 0;
                        }

                        x_c <<= 14;
                        if (y_c < 0) {
                            x_c -= var17 * y_c;
                            y_c = 0;
                        }

                        if (y_c != y_b && var16 < i_178_ || y_c == y_b && var16 > var17) {
                            y_a -= y_c;
                            y_c -= y_b;
                            y_b = rasterClipY[y_b];

                            while (true) {
                                --y_c;
                                if (y_c < 0) {
                                    while (true) {
                                        --y_a;
                                        if (y_a < 0) {
                                            return;
                                        }

                                        rasterGouraudLine(Rasterizer2D.graphicsPixels, y_b, 0, 0, x_a >> 14, x_c >> 14, hsl2, var19, z_b, depth_slope, bufferOffset);
                                        x_a += var16;
                                        x_c += var17;
                                        hsl2 += var20;
                                        z_b += depth_increment;
                                        y_b += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLine(Rasterizer2D.graphicsPixels, y_b, 0, 0, x_a >> 14, x_b >> 14, hsl2, var19, z_b, depth_slope, bufferOffset);
                                x_a += var16;
                                x_b += i_178_;
                                hsl2 += var20;
                                z_b += depth_increment;
                                y_b += Rasterizer2D.graphicsPixelsWidth;
                            }
                        } else {
                            y_a -= y_c;
                            y_c -= y_b;
                            y_b = rasterClipY[y_b];

                            while (true) {
                                --y_c;
                                if (y_c < 0) {
                                    while (true) {
                                        --y_a;
                                        if (y_a < 0) {
                                            return;
                                        }

                                        rasterGouraudLine(Rasterizer2D.graphicsPixels, y_b, 0, 0, x_c >> 14, x_a >> 14, hsl2, var19, z_b, depth_slope, bufferOffset);
                                        x_a += var16;
                                        x_c += var17;
                                        hsl2 += var20;
                                        z_b += depth_increment;
                                        y_b += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLine(Rasterizer2D.graphicsPixels, y_b, 0, 0, x_b >> 14, x_a >> 14, hsl2, var19, z_b, depth_slope, bufferOffset);
                                x_a += var16;
                                x_b += i_178_;
                                hsl2 += var20;
                                y_b += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }
                    } else {
                        x_c = x_b <<= 14;
                        if (y_b < 0) {
                            x_c -= var16 * y_b;
                            x_b -= i_178_ * y_b;
                            hsl2 -= var20 * y_b;
                            z_b -= depth_increment * y_b;
                            y_b = 0;
                        }

                        x_a <<= 14;
                        if (y_a < 0) {
                            x_a -= y_a * var17;
                            y_a = 0;
                        }

                        if (var16 < i_178_) {
                            y_c -= y_a;
                            y_a -= y_b;
                            y_b = rasterClipY[y_b];

                            while (true) {
                                --y_a;
                                if (y_a < 0) {
                                    while (true) {
                                        --y_c;
                                        if (y_c < 0) {
                                            return;
                                        }

                                        rasterGouraudLine(Rasterizer2D.graphicsPixels, y_b, 0, 0, x_a >> 14, x_b >> 14, hsl2, var19, z_b, depth_slope, bufferOffset);
                                        x_a += var17;
                                        x_b += i_178_;
                                        hsl2 += var20;
                                        z_b += depth_increment;
                                        y_b += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLine(Rasterizer2D.graphicsPixels, y_b, 0, 0, x_c >> 14, x_b >> 14, hsl2, var19, z_b, depth_slope, bufferOffset);
                                x_c += var16;
                                x_b += i_178_;
                                hsl2 += var20;
                                z_b += depth_increment;
                                y_b += Rasterizer2D.graphicsPixelsWidth;
                            }
                        } else {
                            y_c -= y_a;
                            y_a -= y_b;
                            y_b = rasterClipY[y_b];

                            while (true) {
                                --y_a;
                                if (y_a < 0) {
                                    while (true) {
                                        --y_c;
                                        if (y_c < 0) {
                                            return;
                                        }

                                        rasterGouraudLine(Rasterizer2D.graphicsPixels, y_b, 0, 0, x_b >> 14, x_a >> 14, hsl2, var19, z_b, depth_slope, bufferOffset);
                                        x_a += var17;
                                        x_b += i_178_;
                                        hsl2 += var20;
                                        z_b += depth_increment;
                                        y_b += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                rasterGouraudLine(Rasterizer2D.graphicsPixels, y_b, 0, 0, x_b >> 14, x_c >> 14, hsl2, var19, z_b, depth_slope, bufferOffset);
                                x_c += var16;
                                x_b += i_178_;
                                hsl2 += var20;
                                z_b += depth_increment;
                                y_b += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }
                    }
                }
            } else if (y_c < Rasterizer3D_clipHeight) {
                if (y_a > Rasterizer3D_clipHeight) {
                    y_a = Rasterizer3D_clipHeight;
                }

                if (y_b > Rasterizer3D_clipHeight) {
                    y_b = Rasterizer3D_clipHeight;
                }

                hsl3 = var19 + ((hsl3 << 8) - x_c * var19);
                z_c = z_c - depth_slope * x_c + depth_slope;
                if (y_a < y_b) {
                    x_b = x_c <<= 14;
                    if (y_c < 0) {
                        x_b -= i_178_ * y_c;
                        x_c -= var17 * y_c;
                        hsl3 -= var20 * y_c;
                        z_c -= depth_increment * y_c;
                        y_c = 0;
                    }

                    x_a <<= 14;
                    if (y_a < 0) {
                        x_a -= y_a * var16;
                        y_a = 0;
                    }

                    if (i_178_ < var17) {
                        y_b -= y_a;
                        y_a -= y_c;
                        y_c = rasterClipY[y_c];

                        while (true) {
                            --y_a;
                            if (y_a < 0) {
                                while (true) {
                                    --y_b;
                                    if (y_b < 0) {
                                        return;
                                    }

                                    rasterGouraudLine(Rasterizer2D.graphicsPixels, y_c, 0, 0, x_b >> 14, x_a >> 14, hsl3, var19, z_c, depth_slope, bufferOffset);
                                    x_b += i_178_;
                                    x_a += var16;
                                    hsl3 += var20;
                                    z_c += depth_increment;
                                    y_c += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterGouraudLine(Rasterizer2D.graphicsPixels, y_c, 0, 0, x_b >> 14, x_c >> 14, hsl3, var19, z_c, depth_slope, bufferOffset);
                            x_b += i_178_;
                            x_c += var17;
                            hsl3 += var20;
                            z_c += depth_increment;
                            y_c += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        y_b -= y_a;
                        y_a -= y_c;
                        y_c = rasterClipY[y_c];

                        while (true) {
                            --y_a;
                            if (y_a < 0) {
                                while (true) {
                                    --y_b;
                                    if (y_b < 0) {
                                        return;
                                    }

                                    rasterGouraudLine(Rasterizer2D.graphicsPixels, y_c, 0, 0, x_a >> 14, x_b >> 14, hsl3, var19, z_c, depth_slope, bufferOffset);
                                    x_b += i_178_;
                                    x_a += var16;
                                    hsl3 += var20;
                                    z_c += depth_increment;
                                    y_c += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterGouraudLine(Rasterizer2D.graphicsPixels, y_c, 0, 0, x_c >> 14, x_b >> 14, hsl3, var19, z_c, depth_slope, bufferOffset);
                            x_b += i_178_;
                            x_c += var17;
                            hsl3 += var20;
                            z_c += depth_increment;
                            y_c += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                } else {
                    x_a = x_c <<= 14;
                    if (y_c < 0) {
                        x_a -= i_178_ * y_c;
                        x_c -= var17 * y_c;
                        hsl3 -= var20 * y_c;
                        z_c -= depth_increment * y_c;
                        y_c = 0;
                    }

                    x_b <<= 14;
                    if (y_b < 0) {
                        x_b -= var16 * y_b;
                        y_b = 0;
                    }

                    if (i_178_ < var17) {
                        y_a -= y_b;
                        y_b -= y_c;
                        y_c = rasterClipY[y_c];

                        while (true) {
                            --y_b;
                            if (y_b < 0) {
                                while (true) {
                                    --y_a;
                                    if (y_a < 0) {
                                        return;
                                    }

                                    rasterGouraudLine(Rasterizer2D.graphicsPixels, y_c, 0, 0, x_b >> 14, x_c >> 14, hsl3, var19, z_c, depth_slope, bufferOffset);
                                    x_b += var16;
                                    x_c += var17;
                                    hsl3 += var20;
                                    z_c += depth_increment;
                                    y_c += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterGouraudLine(Rasterizer2D.graphicsPixels, y_c, 0, 0, x_a >> 14, x_c >> 14, hsl3, var19, z_c, depth_slope, bufferOffset);
                            x_a += i_178_;
                            x_c += var17;
                            hsl3 += var20;
                            z_c += depth_increment;
                            y_c += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        y_a -= y_b;
                        y_b -= y_c;
                        y_c = rasterClipY[y_c];

                        while (true) {
                            --y_b;
                            if (y_b < 0) {
                                while (true) {
                                    --y_a;
                                    if (y_a < 0) {
                                        return;
                                    }

                                    rasterGouraudLine(Rasterizer2D.graphicsPixels, y_c, 0, 0, x_c >> 14, x_b >> 14, hsl3, var19, z_c, depth_slope, bufferOffset);
                                    x_b += var16;
                                    x_c += var17;
                                    hsl3 += var20;
                                    z_c += depth_increment;
                                    y_c += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            rasterGouraudLine(Rasterizer2D.graphicsPixels, y_c, 0, 0, x_c >> 14, x_a >> 14, hsl3, var19, z_c, depth_slope, bufferOffset);
                            x_a += i_178_;
                            x_c += var17;
                            hsl3 += var20;
                            z_c += depth_increment;
                            y_c += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                }
            }
        }
    }

    @ObfuscatedName("x")
    @Export("rasterGouraudLine")
    static final void rasterGouraudLine(int[] dest, int offset, int var2, int var3, int x1, int x2, int var6, int var7, float depth, float depth_slope, int bufferOffset) {
        if (rasterClipEnable) {
            if (x2 > rasterClipX) {
                x2 = rasterClipX;
            }

            if (x1 < 0) {
                x1 = 0;
            }
        }

        if (x1 < x2) {
            offset += x1;
            depth += depth_slope * (float) x1;
            var6 += x1 * var7;
            int var8;
            int var9;
            int var10;
            if (rasterGouraudLowRes) {
                var3 = x2 - x1 >> 2;
                var7 <<= 2;
                if (rasterAlpha == 0) {
                    if (var3 > 0) {
                        do {
                            var2 = colorPalette[var6 >> 8];
                            var6 += var7;
                            if (checkDepth(offset, bufferOffset, depth)) {
                                Rasterizer2D.depthBuffer[offset] = depth;
                                dest[offset] = var2;
                            }
                            offset++;
                            depth += depth_slope;
                            if (checkDepth(offset, bufferOffset, depth)) {
                                Rasterizer2D.depthBuffer[offset] = depth;
                                dest[offset] = var2;
                            }
                            offset++;
                            depth += depth_slope;
                            if (checkDepth(offset, bufferOffset, depth)) {
                                Rasterizer2D.depthBuffer[offset] = depth;
                                dest[offset] = var2;
                            }
                            offset++;
                            depth += depth_slope;
                            if (checkDepth(offset, bufferOffset, depth)) {
                                Rasterizer2D.depthBuffer[offset] = depth;
                                dest[offset] = var2;
                            }
                            offset++;
                            depth += depth_slope;
                            --var3;
                        } while (var3 > 0);
                    }

                    var3 = x2 - x1 & 3;
                    if (var3 > 0) {
                        var2 = colorPalette[var6 >> 8];

                        do {
                            if (checkDepth(offset, bufferOffset, depth)) {
                                Rasterizer2D.depthBuffer[offset] = depth;
                                dest[offset] = var2;
                            }
                            offset++;
                            depth += depth_slope;
                            --var3;
                        } while (var3 > 0);
                    }
                } else {
                    var8 = rasterAlpha;
                    var9 = 256 - rasterAlpha;
                    if (var3 > 0) {
                        do {
                            var2 = colorPalette[var6 >> 8];
                            var6 += var7;
                            var2 = (var9 * (var2 & 65280) >> 8 & 65280) + (var9 * (var2 & 16711935) >> 8 & 16711935);
                            if (checkDepth(offset, bufferOffset, depth)) {
                                var10 = dest[offset];
                                Rasterizer2D.depthBuffer[offset] = depth;
                                dest[offset] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
                            }
                            offset++;
                            depth += depth_slope;
                            if (checkDepth(offset, bufferOffset, depth)) {
                                var10 = dest[offset];
                                Rasterizer2D.depthBuffer[offset] = depth;
                                dest[offset] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
                            }
                            offset++;
                            depth += depth_slope;
                            if (checkDepth(offset, bufferOffset, depth)) {
                                var10 = dest[offset];
                                Rasterizer2D.depthBuffer[offset] = depth;
                                dest[offset] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
                            }
                            offset++;
                            depth += depth_slope;
                            if (checkDepth(offset, bufferOffset, depth)) {
                                var10 = dest[offset];
                                Rasterizer2D.depthBuffer[offset] = depth;
                                dest[offset] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
                            }
                            offset++;
                            depth += depth_slope;
                            --var3;
                        } while (var3 > 0);
                    }

                    var3 = x2 - x1 & 3;
                    if (var3 > 0) {
                        var2 = colorPalette[var6 >> 8];
                        var2 = (var9 * (var2 & 65280) >> 8 & 65280) + (var9 * (var2 & 16711935) >> 8 & 16711935);

                        do {
                            if (checkDepth(offset, bufferOffset, depth)) {
                                var10 = dest[offset];
                                dest[offset] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
                            }
                            offset++;
                            depth += depth_slope;
                            --var3;
                        } while (var3 > 0);
                    }
                }

            } else {
                var3 = x2 - x1;
                if (rasterAlpha == 0) {
                    do {
                        if (checkDepth(offset, bufferOffset, depth)) {
                            dest[offset] = colorPalette[var6 >> 8];
                            Rasterizer2D.depthBuffer[offset] = depth;
                        }
                        depth += depth_slope;
                        offset++;
                        var6 += var7;
                        --var3;
                    } while (var3 > 0);
                } else {
                    var8 = rasterAlpha;
                    var9 = 256 - rasterAlpha;

                    do {
                        var2 = colorPalette[var6 >> 8];
                        var6 += var7;
                        var2 = (var9 * (var2 & 65280) >> 8 & 65280) + (var9 * (var2 & 16711935) >> 8 & 16711935);
                        if (checkDepth(offset, bufferOffset, depth)) {
                            var10 = dest[offset];
                            Rasterizer2D.depthBuffer[offset] = depth;
                            dest[offset] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
                        }
                        depth += depth_slope;
                        offset++;
                        --var3;
                    } while (var3 > 0);
                }

            }
        }
    }

    @ObfuscatedName("s")
    static final int method2579(int var0, int var1) {
        var1 = (var0 & 127) * var1 >> 7;
        if (var1 < 2) {
            var1 = 2;
        } else if (var1 > 126) {
            var1 = 126;
        }

        return (var0 & 65408) + var1;
    }

    @ObfuscatedName("u")
    static final int method2581(int var0, int var1, int var2, int var3) {
        return var2 * var1 - var3 * var0 >> 16;
    }

    @ObfuscatedName("g")
    public static final void method2586() {
        method2562(Rasterizer2D.draw_region_x, Rasterizer2D.drawingAreaTop, Rasterizer2D.drawingAreaBottom, Rasterizer2D.drawingAreaRight);
    }
}
