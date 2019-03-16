package net.runelite.runescape;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

import java.util.Arrays;

@ObfuscatedName("lh")
@Implements("Rasterizer2D")
public class Rasterizer2D extends CacheableNode {
    @ObfuscatedName("ae")
    @Export("drawingAreaTop")
    public static int drawingAreaTop;
    @ObfuscatedName("aj")
    @Export("drawingAreaBottom")
    protected static int drawingAreaBottom;
    @ObfuscatedName("aw")
    @Export("graphicsPixelsHeight")
    public static int graphicsPixelsHeight;
    @ObfuscatedName("an")
    @Export("graphicsPixels")
    public static int[] graphicsPixels;
    @ObfuscatedName("ax")
    @Export("graphicsPixelsWidth")
    public static int graphicsPixelsWidth;
    @ObfuscatedName("az")
    @Export("draw_region_x")
    public static int draw_region_x;
    @ObfuscatedName("ac")
    @Export("drawingAreaRight")
    public static int drawingAreaRight;
    @Export("depthBuffer")
    public static float[] depthBuffer;

    static {
        drawingAreaTop = 0;
        drawingAreaRight = 0;
        draw_region_x = 0;
        drawingAreaBottom = 0;
    }

    @ObfuscatedName("dn")
    public static void method497(int var0, int var1, int var2, int var3, int var4) {
        if (var4 != 0) {
            if (var4 == 256) {
                method446(var0, var1, var2, var3);
            } else {
                if (var2 < 0) {
                    var2 = -var2;
                }

                int var5 = 256 - var4;
                int var6 = (var3 >> 16 & 255) * var4;
                int var7 = (var3 >> 8 & 255) * var4;
                int var8 = var4 * (var3 & 255);
                int var12 = var1 - var2;
                if (var12 < drawingAreaTop) {
                    var12 = drawingAreaTop;
                }

                int var13 = var2 + var1 + 1;
                if (var13 > drawingAreaRight) {
                    var13 = drawingAreaRight;
                }

                int var14 = var12;
                int var15 = var2 * var2;
                int var16 = 0;
                int var17 = var1 - var12;
                int var18 = var17 * var17;
                int var19 = var18 - var17;
                if (var1 > var13) {
                    var1 = var13;
                }

                int var9;
                int var10;
                int var11;
                int var20;
                int var21;
                int var22;
                int var23;
                int var24;
                while (var14 < var1) {
                    while (var19 <= var15 || var18 <= var15) {
                        var18 = var18 + var16 + var16;
                        var19 += var16++ + var16;
                    }

                    var20 = var0 - var16 + 1;
                    if (var20 < draw_region_x) {
                        var20 = draw_region_x;
                    }

                    var21 = var0 + var16;
                    if (var21 > drawingAreaBottom) {
                        var21 = drawingAreaBottom;
                    }

                    var22 = var20 + var14 * graphicsPixelsWidth;

                    for (var23 = var20; var23 < var21; ++var23) {
                        var9 = var5 * (graphicsPixels[var22] >> 16 & 255);
                        var10 = (graphicsPixels[var22] >> 8 & 255) * var5;
                        var11 = var5 * (graphicsPixels[var22] & 255);
                        var24 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                        client.drawAlpha(graphicsPixels, var22++, var24, var4);
                    }

                    ++var14;
                    var18 -= var17-- + var17;
                    var19 -= var17 + var17;
                }

                var16 = var2;
                var17 = -var17;
                var19 = var15 + var17 * var17;
                var18 = var19 - var2;

                for (var19 -= var17; var14 < var13; var18 += var17++ + var17) {
                    while (var19 > var15 && var18 > var15) {
                        var19 -= var16-- + var16;
                        var18 -= var16 + var16;
                    }

                    var20 = var0 - var16;
                    if (var20 < draw_region_x) {
                        var20 = draw_region_x;
                    }

                    var21 = var0 + var16;
                    if (var21 > drawingAreaBottom - 1) {
                        var21 = drawingAreaBottom - 1;
                    }

                    var22 = var20 + var14 * graphicsPixelsWidth;

                    for (var23 = var20; var23 <= var21; ++var23) {
                        var9 = var5 * (graphicsPixels[var22] >> 16 & 255);
                        var10 = (graphicsPixels[var22] >> 8 & 255) * var5;
                        var11 = var5 * (graphicsPixels[var22] & 255);
                        var24 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                        client.drawAlpha(graphicsPixels, var22++, var24, var4);
                    }

                    ++var14;
                    var19 = var19 + var17 + var17;
                }

            }
        }
    }

    @ObfuscatedName("dh")
    public static void method452(int[] var0) {
        draw_region_x = var0[0];
        drawingAreaTop = var0[1];
        drawingAreaBottom = var0[2];
        drawingAreaRight = var0[3];
    }

    @ObfuscatedName("db")
    public static void method460(int var0, int var1, int var2, int[] var3, int[] var4) {
        int var5 = var0 + graphicsPixelsWidth * var1;

        for (var1 = 0; var1 < var3.length; ++var1) {
            int var6 = var5 + var3[var1];

            for (var0 = -var4[var1]; var0 < 0; ++var0) {
                graphicsPixels[var6++] = var2 | -16777216;
            }

            var5 += graphicsPixelsWidth;
        }

    }

    @ObfuscatedName("di")
    static void method459(int var0, int var1, int var2) {
        if (var0 >= draw_region_x && var1 >= drawingAreaTop && var0 < drawingAreaBottom && var1 < drawingAreaRight) {
            graphicsPixels[var0 + graphicsPixelsWidth * var1] = var2 | -16777216;
        }
    }

    @ObfuscatedName("dc")
    public static void method469(int var0, int var1, int var2, int var3) {
        if (var0 < 0) {
            var0 = 0;
        }

        if (var1 < 0) {
            var1 = 0;
        }

        if (var2 > graphicsPixelsWidth) {
            var2 = graphicsPixelsWidth;
        }

        if (var3 > graphicsPixelsHeight) {
            var3 = graphicsPixelsHeight;
        }

        draw_region_x = var0;
        drawingAreaTop = var1;
        drawingAreaBottom = var2;
        drawingAreaRight = var3;
    }

    @ObfuscatedName("du")
    public static void method454(int var0, int var1, int var2, int var3, int var4, int var5) {
        if (var2 > 0 && var3 > 0) {
            int var6 = 0;
            int var7 = 65536 / var3;
            if (var0 < draw_region_x) {
                var2 -= draw_region_x - var0;
                var0 = draw_region_x;
            }

            if (var1 < drawingAreaTop) {
                var6 += (drawingAreaTop - var1) * var7;
                var3 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var0 + var2 > drawingAreaBottom) {
                var2 = drawingAreaBottom - var0;
            }

            if (var3 + var1 > drawingAreaRight) {
                var3 = drawingAreaRight - var1;
            }

            int var8 = graphicsPixelsWidth - var2;
            int var9 = var0 + graphicsPixelsWidth * var1;

            for (int var10 = -var3; var10 < 0; ++var10) {
                int var11 = 65536 - var6 >> 8;
                int var12 = var6 >> 8;
                int var13 = (var12 * (var5 & 16711935) + var11 * (var4 & 16711935) & -16711936) + (var12 * (var5 & 65280) + var11 * (var4 & 65280) & 16711680) >>> 8;

                for (int var14 = -var2; var14 < 0; ++var14) {
                    graphicsPixels[var9++] = var13 | -16777216;
                }

                var9 += var8;
                var6 += var7;
            }

        }
    }

    @ObfuscatedName("dr")
    static void method446(int var0, int var1, int var2, int var3) {
        if (var2 == 0) {
            method459(var0, var1, var3);
        } else {
            if (var2 < 0) {
                var2 = -var2;
            }

            int var4 = var1 - var2;
            if (var4 < drawingAreaTop) {
                var4 = drawingAreaTop;
            }

            int var5 = var2 + var1 + 1;
            if (var5 > drawingAreaRight) {
                var5 = drawingAreaRight;
            }

            int var6 = var4;
            int var7 = var2 * var2;
            int var8 = 0;
            int var9 = var1 - var4;
            int var10 = var9 * var9;
            int var11 = var10 - var9;
            if (var1 > var5) {
                var1 = var5;
            }

            int var12;
            int var13;
            int var14;
            int var15;
            while (var6 < var1) {
                while (var11 <= var7 || var10 <= var7) {
                    var10 = var10 + var8 + var8;
                    var11 += var8++ + var8;
                }

                var12 = var0 - var8 + 1;
                if (var12 < draw_region_x) {
                    var12 = draw_region_x;
                }

                var13 = var0 + var8;
                if (var13 > drawingAreaBottom) {
                    var13 = drawingAreaBottom;
                }

                var14 = var12 + var6 * graphicsPixelsWidth;

                for (var15 = var12; var15 < var13; ++var15) {
                    graphicsPixels[var14++] = var3 | -16777216;
                }

                ++var6;
                var10 -= var9-- + var9;
                var11 -= var9 + var9;
            }

            var8 = var2;
            var9 = var6 - var1;
            var11 = var7 + var9 * var9;
            var10 = var11 - var2;

            for (var11 -= var9; var6 < var5; var10 += var9++ + var9) {
                while (var11 > var7 && var10 > var7) {
                    var11 -= var8-- + var8;
                    var10 -= var8 + var8;
                }

                var12 = var0 - var8;
                if (var12 < draw_region_x) {
                    var12 = draw_region_x;
                }

                var13 = var0 + var8;
                if (var13 > drawingAreaBottom - 1) {
                    var13 = drawingAreaBottom - 1;
                }

                var14 = var12 + var6 * graphicsPixelsWidth;

                for (var15 = var12; var15 <= var13; ++var15) {
                    graphicsPixels[var14++] = var3 | -16777216;
                }

                ++var6;
                var11 = var11 + var9 + var9;
            }

        }
    }

    @ObfuscatedName("df")
    static void method472(int var0, int var1, int var2, int var3, int var4) {
        if (var0 >= draw_region_x && var0 < drawingAreaBottom) {
            if (var1 < drawingAreaTop) {
                var2 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var2 + var1 > drawingAreaRight) {
                var2 = drawingAreaRight - var1;
            }

            int var5 = 256 - var4;
            int var6 = (var3 >> 16 & 255) * var4;
            int var7 = (var3 >> 8 & 255) * var4;
            int var8 = var4 * (var3 & 255);
            int var12 = var0 + graphicsPixelsWidth * var1;

            for (int var13 = 0; var13 < var2; ++var13) {
                int var9 = var5 * (graphicsPixels[var12] >> 16 & 255);
                int var10 = (graphicsPixels[var12] >> 8 & 255) * var5;
                int var11 = var5 * (graphicsPixels[var12] & 255);
                int var14 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                client.drawAlpha(graphicsPixels, var12, var14, var4);
                var12 += graphicsPixelsWidth;
            }

        }
    }

    @ObfuscatedName("ds")
    public static void method457(int var0, int var1, int var2, int var3, int var4) {
        var2 -= var0;
        var3 -= var1;
        if (var3 == 0) {
            if (var2 >= 0) {
                method500(var0, var1, var2 + 1, var4);
            } else {
                method500(var0 + var2, var1, -var2 + 1, var4);
            }

        } else if (var2 == 0) {
            if (var3 >= 0) {
                method456(var0, var1, var3 + 1, var4);
            } else {
                method456(var0, var3 + var1, -var3 + 1, var4);
            }

        } else {
            if (var3 + var2 < 0) {
                var0 += var2;
                var2 = -var2;
                var1 += var3;
                var3 = -var3;
            }

            int var5;
            int var6;
            if (var2 > var3) {
                var1 <<= 16;
                var1 += 32768;
                var3 <<= 16;
                var5 = (int) Math.floor((double) var3 / (double) var2 + 0.5D);
                var2 += var0;
                if (var0 < draw_region_x) {
                    var1 += var5 * (draw_region_x - var0);
                    var0 = draw_region_x;
                }

                if (var2 >= drawingAreaBottom) {
                    var2 = drawingAreaBottom - 1;
                }

                while (var0 <= var2) {
                    var6 = var1 >> 16;
                    if (var6 >= drawingAreaTop && var6 < drawingAreaRight) {
                        graphicsPixels[var0 + var6 * graphicsPixelsWidth] = var4 | -16777216;
                    }

                    var1 += var5;
                    ++var0;
                }
            } else {
                var0 <<= 16;
                var0 += 32768;
                var2 <<= 16;
                var5 = (int) Math.floor((double) var2 / (double) var3 + 0.5D);
                var3 += var1;
                if (var1 < drawingAreaTop) {
                    var0 += (drawingAreaTop - var1) * var5;
                    var1 = drawingAreaTop;
                }

                if (var3 >= drawingAreaRight) {
                    var3 = drawingAreaRight - 1;
                }

                while (var1 <= var3) {
                    var6 = var0 >> 16;
                    if (var6 >= draw_region_x && var6 < drawingAreaBottom) {
                        graphicsPixels[var6 + graphicsPixelsWidth * var1] = var4 | -16777216;
                    }

                    var0 += var5;
                    ++var1;
                }
            }

        }
    }

    @ObfuscatedName("dg")
    public static void method448(int var0, int var1, int var2, int var3, int var4, int var5) {
        if (var0 < draw_region_x) {
            var2 -= draw_region_x - var0;
            var0 = draw_region_x;
        }

        if (var1 < drawingAreaTop) {
            var3 -= drawingAreaTop - var1;
            var1 = drawingAreaTop;
        }

        if (var0 + var2 > drawingAreaBottom) {
            var2 = drawingAreaBottom - var0;
        }

        if (var3 + var1 > drawingAreaRight) {
            var3 = drawingAreaRight - var1;
        }

        var4 = (var5 * (var4 & 16711935) >> 8 & 16711935) + (var5 * (var4 & 65280) >> 8 & 65280);
        int var6 = 256 - var5;
        int var7 = graphicsPixelsWidth - var2;
        int var8 = var0 + graphicsPixelsWidth * var1;

        for (int var9 = 0; var9 < var3; ++var9) {
            for (int var10 = -var2; var10 < 0; ++var10) {
                int var11 = graphicsPixels[var8];
                var11 = ((var11 & 16711935) * var6 >> 8 & 16711935) + (var6 * (var11 & 65280) >> 8 & 65280);
                client.drawAlpha(graphicsPixels, var8++, var11 + var4, var5);
            }

            var8 += var7;
        }

    }

    @ObfuscatedName("dt")
    public static void method449(int var0, int var1, int var2, int var3, int var4) {
        if (var0 < draw_region_x) {
            var2 -= draw_region_x - var0;
            var0 = draw_region_x;
        }

        if (var1 < drawingAreaTop) {
            var3 -= drawingAreaTop - var1;
            var1 = drawingAreaTop;
        }

        if (var0 + var2 > drawingAreaBottom) {
            var2 = drawingAreaBottom - var0;
        }

        if (var3 + var1 > drawingAreaRight) {
            var3 = drawingAreaRight - var1;
        }

        int var5 = graphicsPixelsWidth - var2;
        int var6 = var0 + graphicsPixelsWidth * var1;

        for (int var7 = -var3; var7 < 0; ++var7) {
            for (int var8 = -var2; var8 < 0; ++var8) {
                graphicsPixels[var6++] = var4 | -16777216;
            }

            var6 += var5;
        }

    }

    @ObfuscatedName("dk")
    public static void method512(int[] var0) {
        var0[0] = draw_region_x;
        var0[1] = drawingAreaTop;
        var0[2] = drawingAreaBottom;
        var0[3] = drawingAreaRight;
    }

    @ObfuscatedName("dv")
    public static void method456(int var0, int var1, int var2, int var3) {
        if (var0 >= draw_region_x && var0 < drawingAreaBottom) {
            if (var1 < drawingAreaTop) {
                var2 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var2 + var1 > drawingAreaRight) {
                var2 = drawingAreaRight - var1;
            }

            int var4 = var0 + graphicsPixelsWidth * var1;

            for (int var5 = 0; var5 < var2; ++var5) {
                graphicsPixels[var4 + var5 * graphicsPixelsWidth] = var3 | -16777216;
            }

        }
    }

    @ObfuscatedName("dp")
    public static void method441(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        int var8 = class166.clientInstance.getGraphicsPixelsWidth();
        int var9 = class166.clientInstance.getStartX();
        int var10 = class166.clientInstance.getStartY();
        int var11 = class166.clientInstance.getEndX();
        int var12 = class166.clientInstance.getEndY();
        int[] var13 = class166.clientInstance.getGraphicsPixels();
        if (!class166.clientInstance.isGpu()) {
            client.copy$drawGradientAlpha(var0, var1, var2, var3, var4, var5, var6, var7);
        } else {
            if (var2 > 0 && var3 > 0) {
                int var14 = 0;
                int var15 = 65536 / var3;
                if (var0 < var9) {
                    var2 -= var9 - var0;
                    var0 = var9;
                }

                if (var1 < var10) {
                    var14 += (var10 - var1) * var15;
                    var3 -= var10 - var1;
                    var1 = var10;
                }

                if (var0 + var2 > var11) {
                    var2 = var11 - var0;
                }

                if (var3 + var1 > var12) {
                    var3 = var12 - var1;
                }

                int var16 = var8 - var2;
                int var17 = var0 + var8 * var1;

                for (int var18 = -var3; var18 < 0; ++var18) {
                    int var19 = 65536 - var14 >> 8;
                    int var20 = var14 >> 8;
                    int var21 = (var19 * var6 + var20 * var7 & 65280) >>> 8;
                    if (var21 == 0) {
                        var17 += var8;
                        var14 += var15;
                    } else {
                        int var22 = (var19 * (var4 & 65280) + var20 * (var5 & 65280) & 16711680) + (var19 * (var4 & 16711935) + var20 * (var5 & 16711935) & -16711936) >>> 8;
                        int var23 = 255 - var21;
                        int var24 = ((var22 & 16711935) * var21 >> 8 & 16711935) + (var21 * (var22 & 65280) >> 8 & 65280);

                        for (int var25 = -var2; var25 < 0; ++var25) {
                            int var26 = var13[var17];
                            var26 = ((var26 & 16711935) * var23 >> 8 & 16711935) + (var23 * (var26 & 65280) >> 8 & 65280);
                            client.drawAlpha(var13, var17++, var24 + var26, var21);
                        }

                        var17 += var16;
                        var14 += var15;
                    }
                }
            }

        }
    }

    @ObfuscatedName("dw")
    public static void method500(int var0, int var1, int var2, int var3) {
        if (var1 >= drawingAreaTop && var1 < drawingAreaRight) {
            if (var0 < draw_region_x) {
                var2 -= draw_region_x - var0;
                var0 = draw_region_x;
            }

            if (var0 + var2 > drawingAreaBottom) {
                var2 = drawingAreaBottom - var0;
            }

            int var4 = var0 + graphicsPixelsWidth * var1;

            for (int var5 = 0; var5 < var2; ++var5) {
                graphicsPixels[var4 + var5] = var3 | -16777216;
            }

        }
    }

    @ObfuscatedName("dq")
    public static void method451(int var0, int var1, int var2, int var3, int var4, int var5, byte[] var6, int var7, boolean var8) {
        int var9 = class166.clientInstance.getGraphicsPixelsWidth();
        int var10 = class166.clientInstance.getGraphicsPixelsHeight();
        int[] var11 = class166.clientInstance.getGraphicsPixels();
        if (!class166.clientInstance.isGpu()) {
            client.copy$raster2d7(var0, var1, var2, var3, var4, var5, var6, var7, var8);
        } else {
            if (var0 + var2 >= 0 && var3 + var1 >= 0 && var0 < var9 && var1 < var10) {
                int var12 = 0;
                int var13 = 0;
                if (var0 < 0) {
                    var12 -= var0;
                    var2 += var0;
                }

                if (var1 < 0) {
                    var13 -= var1;
                    var3 += var1;
                }

                if (var0 + var2 > var9) {
                    var2 = var9 - var0;
                }

                if (var3 + var1 > var10) {
                    var3 = var10 - var1;
                }

                int var14 = var6.length / var7;
                int var15 = var9 - var2;
                int var16 = var4 >>> 24;
                int var17 = var5 >>> 24;
                int var18;
                int var19;
                int var20;
                int var21;
                int var22;
                if (var16 == 255 && var17 == 255) {
                    var18 = var0 + var12 + var9 * (var13 + var1);

                    for (var19 = var13 + var1; var19 < var3 + var13 + var1; ++var19) {
                        for (var20 = var0 + var12; var20 < var0 + var12 + var2; ++var20) {
                            var21 = (var19 - var1) % var14;
                            var22 = (var20 - var0) % var7;
                            if (var6[var22 + var21 * var7] != 0) {
                                var11[var18++] = var5;
                            } else {
                                var11[var18++] = var4;
                            }
                        }

                        var18 += var15;
                    }
                } else {
                    var18 = var0 + var12 + var9 * (var13 + var1);

                    for (var19 = var13 + var1; var19 < var3 + var13 + var1; ++var19) {
                        for (var20 = var0 + var12; var20 < var0 + var12 + var2; ++var20) {
                            var21 = (var19 - var1) % var14;
                            var22 = (var20 - var0) % var7;
                            int var23 = var4;
                            if (var6[var22 + var21 * var7] != 0) {
                                var23 = var5;
                            }

                            int var24 = var23 >>> 24;
                            int var25 = 255 - var24;
                            int var26 = var11[var18];
                            int var27 = (var24 * (var23 & 65280) + var25 * (var26 & 65280) & 16711680) + ((var23 & 16711935) * var24 + (var26 & 16711935) * var25 & -16711936) >> 8;
                            client.drawAlpha(var11, var18++, var27, var24);
                        }

                        var18 += var15;
                    }
                }
            }

        }
    }

    @Export("resetDepthBuffer")
    public static void resetDepthBuffer() {
        if (depthBuffer == null || depthBuffer.length != graphicsPixelsWidth * graphicsPixelsHeight) {
            depthBuffer = new float[graphicsPixels.length];
        }
        Arrays.fill(depthBuffer, graphicsPixels.length);
    }

    @ObfuscatedName("dj")
    public static void method445() {
        int var0 = 0;

        int var1;
        for (var1 = graphicsPixelsWidth * graphicsPixelsHeight - 7; var0 < var1; graphicsPixels[var0++] = 0) {
            graphicsPixels[var0++] = 0;
            graphicsPixels[var0++] = 0;
            graphicsPixels[var0++] = 0;
            graphicsPixels[var0++] = 0;
            graphicsPixels[var0++] = 0;
            graphicsPixels[var0++] = 0;
            graphicsPixels[var0++] = 0;
        }

        for (var1 += 7; var0 < var1; graphicsPixels[var0++] = 0) {
            ;
        }

    }

    @ObfuscatedName("da")
    public static void method439() {
        draw_region_x = 0;
        drawingAreaTop = 0;
        drawingAreaBottom = graphicsPixelsWidth;
        drawingAreaRight = graphicsPixelsHeight;
    }

    @ObfuscatedName("dx")
    public static void method518(int var0, int var1, int var2, int var3, int var4) {
        method500(var0, var1, var2, var4);
        method500(var0, var3 + var1 - 1, var2, var4);
        method456(var0, var1, var3, var4);
        method456(var0 + var2 - 1, var1, var3, var4);
    }

    @ObfuscatedName("dl")
    static void method455(int var0, int var1, int var2, int var3, int var4) {
        if (var1 >= drawingAreaTop && var1 < drawingAreaRight) {
            if (var0 < draw_region_x) {
                var2 -= draw_region_x - var0;
                var0 = draw_region_x;
            }

            if (var0 + var2 > drawingAreaBottom) {
                var2 = drawingAreaBottom - var0;
            }

            int var5 = 256 - var4;
            int var6 = (var3 >> 16 & 255) * var4;
            int var7 = (var3 >> 8 & 255) * var4;
            int var8 = var4 * (var3 & 255);
            int var12 = var0 + graphicsPixelsWidth * var1;

            for (int var13 = 0; var13 < var2; ++var13) {
                int var9 = var5 * (graphicsPixels[var12] >> 16 & 255);
                int var10 = (graphicsPixels[var12] >> 8 & 255) * var5;
                int var11 = var5 * (graphicsPixels[var12] & 255);
                int var14 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                client.drawAlpha(graphicsPixels, var12++, var14, var4);
            }

        }
    }

    @ObfuscatedName("do")
    public static void method453(int var0, int var1, int var2, int var3, int var4, int var5) {
        method455(var0, var1, var2, var4, var5);
        method455(var0, var3 + var1 - 1, var2, var4, var5);
        if (var3 >= 3) {
            method472(var0, var1 + 1, var3 - 2, var4, var5);
            method472(var0 + var2 - 1, var1 + 1, var3 - 2, var4, var5);
        }

    }

    @ObfuscatedName("dm")
    public static void method440(int[] var0, int var1, int var2) {
        graphicsPixels = var0;
        graphicsPixelsWidth = var1;
        graphicsPixelsHeight = var2;
        method469(0, 0, var1, var2);
    }

    @ObfuscatedName("dz")
    public static void method443(int var0, int var1, int var2, int var3) {
        if (draw_region_x < var0) {
            draw_region_x = var0;
        }

        if (drawingAreaTop < var1) {
            drawingAreaTop = var1;
        }

        if (drawingAreaBottom > var2) {
            drawingAreaBottom = var2;
        }

        if (drawingAreaRight > var3) {
            drawingAreaRight = var3;
        }

    }
}
