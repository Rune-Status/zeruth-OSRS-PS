package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -113193139
    )
    public static int sampleRate;
    @ObfuscatedName("f")
    @ObfuscatedGetter(
            intValue = 1989098769
    )
    int offset;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = 1846461907
    )
    int field1364;
    @ObfuscatedName("k")
    @ObfuscatedGetter(
            longValue = -7401164027559009597L
    )
    long field1369;
    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "Ldz;"
    )
    TaskDataNode field1363;
    @ObfuscatedName("aj")
    @ObfuscatedSignature(
            signature = "[Ldz;"
    )
    TaskDataNode[] field1376;
    @ObfuscatedName("o")
    boolean field1374;
    @ObfuscatedName("a")
    @ObfuscatedGetter(
            intValue = -1499859813
    )
    int field1367;
    @ObfuscatedName("z")
    @ObfuscatedGetter(
            intValue = 1140183165
    )
    int field1370;
    @ObfuscatedName("t")
    @ObfuscatedGetter(
            intValue = -499430941
    )
    int field1368;
    @ObfuscatedName("y")
    @ObfuscatedGetter(
            intValue = -155802851
    )
    int field1372;
    @ObfuscatedName("j")
    protected int[] samples;
    @ObfuscatedName("s")
    @ObfuscatedGetter(
            intValue = 1540441031
    )
    int field1371;
    @ObfuscatedName("az")
    @ObfuscatedSignature(
            signature = "[Ldz;"
    )
    TaskDataNode[] field1366;
    @ObfuscatedName("ac")
    @ObfuscatedGetter(
            intValue = -531912905
    )
    int field1379;
    @ObfuscatedName("h")
    @ObfuscatedGetter(
            longValue = 180102026293628505L
    )
    long field1361;
    @ObfuscatedName("u")
    @ObfuscatedGetter(
            longValue = -5542385769221022771L
    )
    long field1375;

    protected AbstractSoundSystem() {
        this.field1364 = 32;
        this.field1361 = Tile.method4297();
        this.field1369 = 0L;
        this.field1370 = 0;
        this.field1371 = 0;
        this.field1372 = 0;
        this.field1375 = 0L;
        this.field1374 = true;
        this.field1379 = 0;
        this.field1366 = new TaskDataNode[8];
        this.field1376 = new TaskDataNode[8];
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "-66"
    )
    protected void vmethod6411(int var1) throws Exception {
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-1047007902"
    )
    protected int vmethod6412() throws Exception {
        return this.offset;
    }

    @ObfuscatedName("ae")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-5"
    )
    public final synchronized void method280() {
        if (this.samples != null) {
            long var1 = Tile.method4297();

            try {
                if (0L != this.field1369) {
                    if (var1 < this.field1369) {
                        return;
                    }

                    this.vmethod6411(this.offset);
                    this.field1369 = 0L;
                    this.field1374 = true;
                }

                int var3 = this.vmethod6412();
                if (this.field1372 - var3 > this.field1370) {
                    this.field1370 = this.field1372 - var3;
                }

                int var4 = this.field1367 + this.field1368;
                if (var4 + 256 > 16384) {
                    var4 = 16128;
                }

                if (var4 + 256 > this.offset) {
                    this.offset += 1024;
                    if (this.offset > 16384) {
                        this.offset = 16384;
                    }

                    this.vmethod6419();
                    this.vmethod6411(this.offset);
                    var3 = 0;
                    this.field1374 = true;
                    if (var4 + 256 > this.offset) {
                        var4 = this.offset - 256;
                        this.field1368 = var4 - this.field1367;
                    }
                }

                while (var3 < var4) {
                    this.method285(this.samples, 256);
                    this.vmethod6413();
                    var3 += 256;
                }

                if (var1 > this.field1375) {
                    if (!this.field1374) {
                        if (this.field1370 == 0 && this.field1371 == 0) {
                            this.vmethod6419();
                            this.field1369 = var1 + 2000L;
                            return;
                        }

                        this.field1368 = Math.min(this.field1371, this.field1370);
                        this.field1371 = this.field1370;
                    } else {
                        this.field1374 = false;
                    }

                    this.field1370 = 0;
                    this.field1375 = 2000L + var1;
                }

                this.field1372 = var3;
            } catch (Exception var7) {
                this.vmethod6419();
                this.field1369 = var1 + 2000L;
            }

            try {
                if (var1 > 500000L + this.field1361) {
                    var1 = this.field1361;
                }

                while (var1 > this.field1361 + 5000L) {
                    this.method284(256);
                    this.field1361 += (long) (256000 / sampleRate);
                }
            } catch (Exception var6) {
                this.field1361 = var1;
            }

        }
    }

    @ObfuscatedName("q")
    protected void vmethod6413() throws Exception {
    }

    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1972649285"
    )
    final void method284(int var1) {
        this.field1379 -= var1;
        if (this.field1379 < 0) {
            this.field1379 = 0;
        }

        if (this.field1363 != null) {
            this.field1363.vmethod6450(var1);
        }

    }

    @ObfuscatedName("aj")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1899838514"
    )
    public final synchronized void method337() {
        if (class37.task != null) {
            boolean var1 = true;

            for (int var2 = 0; var2 < 2; ++var2) {
                if (this == class37.task.systems[var2]) {
                    class37.task.systems[var2] = null;
                }

                if (class37.task.systems[var2] != null) {
                    var1 = false;
                }
            }

            if (var1) {
                class316.field1155.shutdownNow();
                class316.field1155 = null;
                class37.task = null;
            }
        }

        this.vmethod6419();
        this.samples = null;
    }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            signature = "(Ldz;I)V",
            garbageValue = "1719730838"
    )
    public final synchronized void method330(TaskDataNode var1) {
        this.field1363 = var1;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1506242428"
    )
    protected void vmethod6419() {
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1925463504"
    )
    protected void vmethod6425() throws Exception {
    }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            signature = "(Ldz;II)V",
            garbageValue = "1263311551"
    )
    final void method286(TaskDataNode var1, int var2) {
        int var3 = var2 >> 5;
        TaskDataNode var4 = this.field1376[var3];
        if (var4 == null) {
            this.field1366[var3] = var1;
        } else {
            var4.field1444 = var1;
        }

        this.field1376[var3] = var1;
        var1.field1443 = var2;
    }

    @ObfuscatedName("az")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-455003753"
    )
    public final synchronized void method282() {
        this.field1374 = true;

        try {
            this.vmethod6425();
        } catch (Exception var2) {
            this.vmethod6419();
            this.field1369 = Tile.method4297() + 2000L;
        }

    }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-323052465"
    )
    public final void method281() {
        this.field1374 = true;
    }

    @ObfuscatedName("ab")
    final void method285(int[] var1, int var2) {
        int var3 = var2;
        if (class56.audioHighMemory) {
            var3 = var2 << 1;
        }

        class188.method3675(var1, 0, var3);
        this.field1379 -= var2;
        if (this.field1363 != null && this.field1379 <= 0) {
            this.field1379 += sampleRate >> 4;
            MouseRecorder.method2745(this.field1363);
            this.method286(this.field1363, this.field1363.vmethod6455());
            int var4 = 0;
            int var5 = 255;

            int var6;
            TaskDataNode var10;
            label104:
            for (var6 = 7; var5 != 0; --var6) {
                int var7;
                int var8;
                if (var6 < 0) {
                    var7 = var6 & 3;
                    var8 = -(var6 >> 2);
                } else {
                    var7 = var6;
                    var8 = 0;
                }

                for (int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
                    if ((var9 & 1) != 0) {
                        var5 &= ~(1 << var7);
                        var10 = null;
                        TaskDataNode var11 = this.field1366[var7];

                        label98:
                        while (true) {
                            while (true) {
                                if (var11 == null) {
                                    break label98;
                                }

                                AbstractIntegerNode0 var12 = var11.data;
                                if (var12 != null && var12.int1 > var8) {
                                    var5 |= 1 << var7;
                                    var10 = var11;
                                    var11 = var11.field1444;
                                } else {
                                    var11.field1445 = true;
                                    int var13 = var11.vmethod6465();
                                    var4 += var13;
                                    if (var12 != null) {
                                        var12.int1 += var13;
                                    }

                                    if (var4 >= this.field1364) {
                                        break label104;
                                    }

                                    TaskDataNode var14 = var11.vmethod6454();
                                    if (var14 != null) {
                                        for (int var15 = var11.field1443; var14 != null; var14 = var11.vmethod6446()) {
                                            this.method286(var14, var15 * var14.vmethod6455() >> 8);
                                        }
                                    }

                                    TaskDataNode var18 = var11.field1444;
                                    var11.field1444 = null;
                                    if (var10 == null) {
                                        this.field1366[var7] = var18;
                                    } else {
                                        var10.field1444 = var18;
                                    }

                                    if (var18 == null) {
                                        this.field1376[var7] = var10;
                                    }

                                    var11 = var18;
                                }
                            }
                        }
                    }

                    var7 += 4;
                    ++var8;
                }
            }

            for (var6 = 0; var6 < 8; ++var6) {
                TaskDataNode var16 = this.field1366[var6];
                TaskDataNode[] var17 = this.field1366;
                this.field1376[var6] = null;

                for (var17[var6] = null; var16 != null; var16 = var10) {
                    var10 = var16.field1444;
                    var16.field1444 = null;
                }
            }
        }

        if (this.field1379 < 0) {
            this.field1379 = 0;
        }

        if (this.field1363 != null) {
            this.field1363.vmethod6449(var1, 0, var2);
        }

        this.field1361 = Tile.method4297();
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-917925486"
    )
    protected void vmethod6410() throws Exception {
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)I",
            garbageValue = "1154977441"
    )
    public static int method338(String var0) {
        return var0.length() + 1;
    }

    @ObfuscatedName("io")
    @ObfuscatedSignature(
            signature = "([Lhn;IIIIIIIII)V",
            garbageValue = "-1790322757"
    )
    static final void method301(ComponentType[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        client.gameDraw(var0, var1, var2, var3, var4, var5, var6, var7, var8);
        Rasterizer2D.method469(var2, var3, var4, var5);
        Graphics3D.method2586();

        for (int var9 = 0; var9 < var0.length; ++var9) {
            ComponentType var10 = var0[var9];
            if (var10 != null && (var10.layer == var1 || var1 == -1412584499 && var10 == client.draggedWidget)) {
                int var11;
                if (var8 == -1) {
                    client.widgetPositionX[client.widgetCount] = var10.x + var6;
                    client.widgetPositionY[client.widgetCount] = var7 + var10.y;
                    client.widgetBoundsWidth[client.widgetCount] = var10.width;
                    client.widgetBoundsHeight[client.widgetCount] = var10.height;
                    var11 = ++client.widgetCount - 1;
                } else {
                    var11 = var8;
                }

                var10.boundsIndex = var11;
                var10.loopCycle = client.gameCycle;
                if (!var10.isIf3 || !GameCanvas.method894(var10)) {
                    if (var10.clientcode > 0) {
                        class208.method4142(var10);
                    }

                    int var12 = var10.x + var6;
                    int var13 = var7 + var10.y;
                    int var14 = var10.trans;
                    int var15;
                    int var16;
                    if (var10 == client.draggedWidget) {
                        if (var1 != -1412584499 && !var10.dragRenderBehavior) {
                            WorldMapType1.field165 = var0;
                            TradingPost.field12 = var6;
                            class139.field2051 = var7;
                            continue;
                        }

                        if (client.draggingWidget && client.field821) {
                            var15 = MouseInput.mouseLastX;
                            var16 = MouseInput.mouseLastY * -976212263;
                            var15 -= client.field906;
                            var16 -= client.field838;
                            if (var15 < client.field713) {
                                var15 = client.field713;
                            }

                            if (var15 + var10.width > client.field713 + client.field817.width) {
                                var15 = client.field713 + client.field817.width - var10.width;
                            }

                            if (var16 < client.field823) {
                                var16 = client.field823;
                            }

                            if (var16 + var10.height > client.field823 + client.field817.height) {
                                var16 = client.field823 + client.field817.height - var10.height;
                            }

                            var12 = var15;
                            var13 = var16;
                        }

                        if (!var10.dragRenderBehavior) {
                            var14 = 128;
                        }
                    }

                    int var17;
                    int var18;
                    int var19;
                    int var20;
                    int var21;
                    int var22;
                    if (var10.type == 2) {
                        var15 = var2;
                        var16 = var3;
                        var17 = var4;
                        var18 = var5;
                    } else if (var10.type == 9) {
                        var19 = var12;
                        var20 = var13;
                        var21 = var12 + var10.width;
                        var22 = var13 + var10.height;
                        if (var21 < var12) {
                            var19 = var21;
                            var21 = var12;
                        }

                        if (var22 < var13) {
                            var20 = var22;
                            var22 = var13;
                        }

                        ++var21;
                        ++var22;
                        var15 = var19 > var2 ? var19 : var2;
                        var16 = var20 > var3 ? var20 : var3;
                        var17 = var21 < var4 ? var21 : var4;
                        var18 = var22 < var5 ? var22 : var5;
                    } else {
                        var19 = var12 + var10.width;
                        var20 = var13 + var10.height;
                        var15 = var12 > var2 ? var12 : var2;
                        var16 = var13 > var3 ? var13 : var3;
                        var17 = var19 < var4 ? var19 : var4;
                        var18 = var20 < var5 ? var20 : var5;
                    }

                    if (!var10.isIf3 || var15 < var17 && var16 < var18) {
                        if (var10.clientcode != 0) {
                            if (var10.clientcode == 1336) {
                                if (client.displayFps) {
                                    var13 += 15;
                                    TotalQuantityComparator.font_p12full.method1781("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                                    var13 += 15;
                                    Runtime var42 = Runtime.getRuntime();
                                    var20 = (int) ((var42.totalMemory() - var42.freeMemory()) / 1024L);
                                    var21 = 16776960;
                                    if (var20 > 327680 && !client.lowMemory) {
                                        var21 = 16711680;
                                    }

                                    TotalQuantityComparator.font_p12full.method1781("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                                    var13 += 15;
                                }
                                continue;
                            }

                            if (var10.clientcode == 1337) {
                                client.field792 = var12;
                                client.field860 = var13;
                                class115.method1983(var12, var13, var10.width, var10.height);
                                client.field848[var10.boundsIndex] = true;
                                Rasterizer2D.method469(var2, var3, var4, var5);
                                continue;
                            }

                            if (var10.clientcode == 1338) {
                                ChatLineBuffer.method1944(var10, var12, var13, var11);
                                Rasterizer2D.method469(var2, var3, var4, var5);
                                continue;
                            }

                            if (var10.clientcode == 1339) {
                                Location.method2965(var10, var12, var13, var11);
                                Rasterizer2D.method469(var2, var3, var4, var5);
                                continue;
                            }

                            if (var10.clientcode == 1400) {
                                class219.worldMap.method1212(var12, var13, var10.width, var10.height, client.gameCycle);
                            }

                            if (var10.clientcode == 1401) {
                                class219.worldMap.method1365(var12, var13, var10.width, var10.height);
                            }
                        }

                        if (var10.type == 0) {
                            if (!var10.isIf3 && GameCanvas.method894(var10) && var10 != class133.field1993) {
                                continue;
                            }

                            if (!var10.isIf3) {
                                if (var10.scrollY > var10.scrollHeight - var10.height) {
                                    var10.scrollY = var10.scrollHeight - var10.height;
                                }

                                if (var10.scrollY < 0) {
                                    var10.scrollY = 0;
                                }
                            }

                            method301(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                            if (var10.children != null) {
                                method301(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                            }

                            SubInterface var30 = (SubInterface) client.subInterfaces.method380((long) var10.id);
                            if (var30 != null) {
                                class219.method4425(var30.id, var15, var16, var17, var18, var12, var13, var11);
                            }

                            Rasterizer2D.method469(var2, var3, var4, var5);
                            Graphics3D.method2586();
                        }

                        if (client.isResized || client.field706[var11] || client.gameDrawingMode > 1) {
                            if (var10.type == 0 && !var10.isIf3 && var10.scrollHeight > var10.height) {
                                class310.method5923(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                            }

                            if (var10.type != 1) {
                                int var23;
                                int var24;
                                int var25;
                                int var26;
                                if (var10.type == 2) {
                                    var19 = 0;

                                    for (var20 = 0; var20 < var10.sizeY; ++var20) {
                                        for (var21 = 0; var21 < var10.sizeX; ++var21) {
                                            var22 = var21 * (var10.paddingX + 32) + var12;
                                            var23 = var13 + var20 * (var10.paddingY + 32);
                                            if (var19 < 20) {
                                                var22 += var10.xSprites[var19];
                                                var23 += var10.field2737[var19];
                                            }

                                            if (var10.objIds[var19] <= 0) {
                                                if (var10.field2738 != null && var19 < 20) {
                                                    SpritePixels var46 = var10.method234(var19);
                                                    if (var46 != null) {
                                                        var46.method2253(var22, var23);
                                                    } else if (ComponentType.field2665) {
                                                        class208.method4144(var10);
                                                    }
                                                }
                                            } else {
                                                boolean var37 = false;
                                                boolean var38 = false;
                                                var26 = var10.objIds[var19] - 1;
                                                if (var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == World.field1025 && var19 == client.field751) {
                                                    SpritePixels var27;
                                                    if (client.itemSelectionState == 1 && var19 == MapLabel.selectedItemIndex && var10.id == ChatLineBuffer.field1276) {
                                                        var27 = MapCacheArchiveNames.method2148(var26, var10.objCounts[var19], 2, 0, 2, false);
                                                    } else {
                                                        var27 = MapCacheArchiveNames.method2148(var26, var10.objCounts[var19], 1, 3153952, 2, false);
                                                    }

                                                    if (var27 != null) {
                                                        if (var10 == World.field1025 && var19 == client.field751) {
                                                            var24 = MouseInput.mouseLastX - client.field752;
                                                            var25 = MouseInput.mouseLastY * -976212263 - client.field845;
                                                            if (var24 < 5 && var24 > -5) {
                                                                var24 = 0;
                                                            }

                                                            if (var25 < 5 && var25 > -5) {
                                                                var25 = 0;
                                                            }

                                                            if (client.itemPressedDuration < 5) {
                                                                var24 = 0;
                                                                var25 = 0;
                                                            }

                                                            var27.method2259(var22 + var24, var25 + var23, 128);
                                                            if (var1 != -1) {
                                                                ComponentType var28 = var0[var1 & 65535];
                                                                int var29;
                                                                if (var25 + var23 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                                    var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * client.field705 / 3;
                                                                    if (var29 > client.field705 * 10) {
                                                                        var29 = client.field705 * 10;
                                                                    }

                                                                    if (var29 > var28.scrollY) {
                                                                        var29 = var28.scrollY;
                                                                    }

                                                                    var28.scrollY -= var29;
                                                                    client.field845 += var29;
                                                                    class208.method4144(var28);
                                                                }

                                                                if (var25 + var23 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                                    var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * client.field705 / 3;
                                                                    if (var29 > client.field705 * 10) {
                                                                        var29 = client.field705 * 10;
                                                                    }

                                                                    if (var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                                        var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                                    }

                                                                    var28.scrollY += var29;
                                                                    client.field845 -= var29;
                                                                    class208.method4144(var28);
                                                                }
                                                            }
                                                        } else if (var10 == class92.field2357 && var19 == client.pressedItemIndex) {
                                                            var27.method2259(var22, var23, 128);
                                                        } else {
                                                            var27.method2253(var22, var23);
                                                        }
                                                    } else {
                                                        class208.method4144(var10);
                                                    }
                                                }
                                            }

                                            ++var19;
                                        }
                                    }
                                } else if (var10.type == 3) {
                                    if (WorldMapType1.method2466(var10)) {
                                        var19 = var10.field2693;
                                        if (var10 == class133.field1993 && var10.field2695 != 0) {
                                            var19 = var10.field2695;
                                        }
                                    } else {
                                        var19 = var10.color;
                                        if (var10 == class133.field1993 && var10.field2694 != 0) {
                                            var19 = var10.field2694;
                                        }
                                    }

                                    if (var10.filled) {
                                        switch (var10.field2744.field3868) {
                                            case 1:
                                                Rasterizer2D.method454(var12, var13, var10.width, var10.height, var10.color, var10.field2693);
                                                break;
                                            case 2:
                                                Rasterizer2D.method441(var12, var13, var10.width, var10.height, var10.color, var10.field2693, 255 - (var10.trans & 255), 255 - (var10.field2699 & 255));
                                                break;
                                            default:
                                                if (var14 == 0) {
                                                    Rasterizer2D.method449(var12, var13, var10.width, var10.height, var19);
                                                } else {
                                                    Rasterizer2D.method448(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                                }
                                        }
                                    } else if (var14 == 0) {
                                        Rasterizer2D.method518(var12, var13, var10.width, var10.height, var19);
                                    } else {
                                        Rasterizer2D.method453(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                    }
                                } else {
                                    Font var39;
                                    if (var10.type == 4) {
                                        var39 = var10.method233();
                                        if (var39 == null) {
                                            if (ComponentType.field2665) {
                                                class208.method4144(var10);
                                            }
                                        } else {
                                            String var44 = var10.text;
                                            if (WorldMapType1.method2466(var10)) {
                                                var20 = var10.field2693;
                                                if (var10 == class133.field1993 && var10.field2695 != 0) {
                                                    var20 = var10.field2695;
                                                }

                                                if (var10.string1.length() > 0) {
                                                    var44 = var10.string1;
                                                }
                                            } else {
                                                var20 = var10.color;
                                                if (var10 == class133.field1993 && var10.field2694 != 0) {
                                                    var20 = var10.field2694;
                                                }
                                            }

                                            if (var10.isIf3 && var10.linkObjType != -1) {
                                                ObjType var47 = Varcs.method4770(var10.linkObjType);
                                                var44 = var47.name;
                                                if (var44 == null) {
                                                    var44 = "null";
                                                }

                                                if ((var47.stackable == 1 || var10.linkObjCount != 1) && var10.linkObjCount != -1) {
                                                    var44 = class31.method548(16748608) + var44 + "</col>" + " " + 'x' + class157.method2694(var10.linkObjCount);
                                                }
                                            }

                                            if (var10 == client.field880) {
                                                var44 = "Please wait...";
                                                var20 = var10.color;
                                            }

                                            if (!var10.isIf3) {
                                                var44 = MapIconReference.method4836(var44, var10);
                                            }

                                            var39.method1774(var44, var12, var13, var10.width, var10.height, var20, var10.textShadow ? 0 : -1, var10.horizTextAlign, var10.vertTextAlign, var10.lineHeight);
                                        }
                                    } else if (var10.type == 5) {
                                        SpritePixels var40;
                                        if (!var10.isIf3) {
                                            var40 = var10.method266(WorldMapType1.method2466(var10), 2110349);
                                            if (var40 != null) {
                                                var40.method2253(var12, var13);
                                            } else if (ComponentType.field2665) {
                                                class208.method4144(var10);
                                            }
                                        } else {
                                            if (var10.linkObjType != -1) {
                                                var40 = MapCacheArchiveNames.method2148(var10.linkObjType, var10.linkObjCount, var10.outline, var10.shadow, var10.objNumMode, false);
                                            } else {
                                                var40 = var10.method266(false, -1150352216);
                                            }

                                            if (var40 == null) {
                                                if (ComponentType.field2665) {
                                                    class208.method4144(var10);
                                                }
                                            } else {
                                                var20 = var40.maxWidth;
                                                var21 = var40.maxHeight;
                                                if (!var10.tile) {
                                                    var22 = var10.width * 4096 / var20;
                                                    if (var10.angle2d != 0) {
                                                        var40.method2271(var10.width / 2 + var12, var10.height / 2 + var13, var10.angle2d, var22);
                                                    } else if (var14 != 0) {
                                                        var40.method2261(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                                    } else if (var20 == var10.width && var21 == var10.height) {
                                                        var40.method2253(var12, var13);
                                                    } else {
                                                        var40.method2255(var12, var13, var10.width, var10.height);
                                                    }
                                                } else {
                                                    Rasterizer2D.method443(var12, var13, var12 + var10.width, var13 + var10.height);
                                                    var22 = (var20 - 1 + var10.width) / var20;
                                                    var23 = (var21 - 1 + var10.height) / var21;

                                                    for (var24 = 0; var24 < var22; ++var24) {
                                                        for (var25 = 0; var25 < var23; ++var25) {
                                                            if (var10.angle2d != 0) {
                                                                var40.method2271(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var21 * var25, var10.angle2d, 4096);
                                                            } else if (var14 != 0) {
                                                                var40.method2259(var12 + var20 * var24, var13 + var25 * var21, 256 - (var14 & 255));
                                                            } else {
                                                                var40.method2253(var12 + var20 * var24, var13 + var21 * var25);
                                                            }
                                                        }
                                                    }

                                                    Rasterizer2D.method469(var2, var3, var4, var5);
                                                }
                                            }
                                        }
                                    } else {
                                        ObjType var32;
                                        if (var10.type == 6) {
                                            Rasterizer2D.resetDepthBuffer();
                                            boolean var36 = WorldMapType1.method2466(var10);
                                            if (var36) {
                                                var20 = var10.field2715;
                                            } else {
                                                var20 = var10.animation;
                                            }

                                            Model var41 = null;
                                            var22 = 0;
                                            if (var10.linkObjType != -1) {
                                                var32 = Varcs.method4770(var10.linkObjType);
                                                if (var32 != null) {
                                                    var32 = var32.method6356(var10.linkObjCount);
                                                    var41 = var32.method6333(1);
                                                    if (var41 != null) {
                                                        var41.method5457();
                                                        var22 = var41.modelHeight / 2;
                                                    } else {
                                                        class208.method4144(var10);
                                                    }
                                                }
                                            } else if (var10.modelType == 5) {
                                                if (var10.modelId == 0) {
                                                    var41 = client.field908.method625((Sequence) null, -1, (Sequence) null, -1);
                                                } else {
                                                    var41 = class4.localPlayer.vmethod5584(-2070069362);
                                                }
                                            } else if (var20 == -1) {
                                                var41 = var10.method235((Sequence) null, -1, var36, class4.localPlayer.composition);
                                                if (var41 == null && ComponentType.field2665) {
                                                    class208.method4144(var10);
                                                }
                                            } else {
                                                Sequence var45 = MapCacheArchiveNames.method2149(var20);
                                                var41 = var10.method235(var45, var10.field2795, var36, class4.localPlayer.composition);
                                                if (var41 == null && ComponentType.field2665) {
                                                    class208.method4144(var10);
                                                }
                                            }

                                            Graphics3D.method2572(var10.width / 2 + var12, var10.height / 2 + var13);
                                            var23 = Graphics3D.SINE[var10.xan2d] * var10.zoom2d >> 16;
                                            var24 = Graphics3D.COSINE[var10.xan2d] * var10.zoom2d >> 16;
                                            if (var41 != null) {
                                                if (!var10.isIf3) {
                                                    var41.method5509(0, var10.yan2d, 0, var10.xan2d, 0, var23, var24);
                                                } else {
                                                    var41.method5457();
                                                    if (var10.orthogonal) {
                                                        var41.method5471(0, var10.yan2d, var10.zan2d, var10.xan2d, var10.offsetX2d, var22 + var23 + var10.offsetY2d, var24 + var10.offsetY2d, var10.zoom2d);
                                                    } else {
                                                        var41.method5509(0, var10.yan2d, var10.zan2d, var10.xan2d, var10.offsetX2d, var23 + var22 + var10.offsetY2d, var24 + var10.offsetY2d);
                                                    }
                                                }
                                            }

                                            Graphics3D.method2600();
                                        } else {
                                            if (var10.type == 7) {
                                                var39 = var10.method233();
                                                if (var39 == null) {
                                                    if (ComponentType.field2665) {
                                                        class208.method4144(var10);
                                                    }
                                                    continue;
                                                }

                                                var20 = 0;

                                                for (var21 = 0; var21 < var10.sizeY; ++var21) {
                                                    for (var22 = 0; var22 < var10.sizeX; ++var22) {
                                                        if (var10.objIds[var20] > 0) {
                                                            var32 = Varcs.method4770(var10.objIds[var20] - 1);
                                                            String var34;
                                                            if (var32.stackable != 1 && var10.objCounts[var20] == 1) {
                                                                var34 = class31.method548(16748608) + var32.name + "</col>";
                                                            } else {
                                                                var34 = class31.method548(16748608) + var32.name + "</col>" + " " + 'x' + class157.method2694(var10.objCounts[var20]);
                                                            }

                                                            var25 = var12 + var22 * (var10.paddingX + 115);
                                                            var26 = var21 * (var10.paddingY + 12) + var13;
                                                            if (var10.horizTextAlign == 0) {
                                                                var39.method1828(var34, var25, var26, var10.color, var10.textShadow ? 0 : -1);
                                                            } else if (var10.horizTextAlign == 1) {
                                                                var39.method1862(var34, var10.width / 2 + var25, var26, var10.color, var10.textShadow ? 0 : -1);
                                                            } else {
                                                                var39.method1781(var34, var25 + var10.width - 1, var26, var10.color, var10.textShadow ? 0 : -1);
                                                            }
                                                        }

                                                        ++var20;
                                                    }
                                                }
                                            }

                                            if (var10.type == 8 && var10 == class98.field495 && client.field795 == client.field794) {
                                                var19 = 0;
                                                var20 = 0;
                                                Font var31 = TotalQuantityComparator.font_p12full;
                                                String var33 = var10.text;

                                                String var43;
                                                for (var33 = MapIconReference.method4836(var33, var10); var33.length() > 0; var20 = var20 + var31.verticalSpace + 1) {
                                                    var24 = var33.indexOf("<br>");
                                                    if (var24 != -1) {
                                                        var43 = var33.substring(0, var24);
                                                        var33 = var33.substring(var24 + 4);
                                                    } else {
                                                        var43 = var33;
                                                        var33 = "";
                                                    }

                                                    var25 = var31.method1775(var43);
                                                    if (var25 > var19) {
                                                        var19 = var25;
                                                    }
                                                }

                                                var19 += 6;
                                                var20 += 7;
                                                var24 = var12 + var10.width - 5 - var19;
                                                var25 = var13 + var10.height + 5;
                                                if (var24 < var12 + 5) {
                                                    var24 = var12 + 5;
                                                }

                                                if (var19 + var24 > var4) {
                                                    var24 = var4 - var19;
                                                }

                                                if (var25 + var20 > var5) {
                                                    var25 = var5 - var20;
                                                }

                                                Rasterizer2D.method449(var24, var25, var19, var20, 16777120);
                                                Rasterizer2D.method518(var24, var25, var19, var20, 0);
                                                var33 = var10.text;
                                                var26 = var25 + var31.verticalSpace + 2;

                                                for (var33 = MapIconReference.method4836(var33, var10); var33.length() > 0; var26 = var26 + var31.verticalSpace + 1) {
                                                    int var35 = var33.indexOf("<br>");
                                                    if (var35 != -1) {
                                                        var43 = var33.substring(0, var35);
                                                        var33 = var33.substring(var35 + 4);
                                                    } else {
                                                        var43 = var33;
                                                        var33 = "";
                                                    }

                                                    var31.method1828(var43, var24 + 3, var26, 0, -1);
                                                }
                                            }

                                            if (var10.type == 9) {
                                                if (var10.lineDirection) {
                                                    var19 = var12;
                                                    var20 = var13 + var10.height;
                                                    var21 = var12 + var10.width;
                                                    var22 = var13;
                                                } else {
                                                    var19 = var12;
                                                    var20 = var13;
                                                    var21 = var12 + var10.width;
                                                    var22 = var13 + var10.height;
                                                }

                                                if (var10.lineWidth == 1) {
                                                    Rasterizer2D.method457(var19, var20, var21, var22, var10.color);
                                                } else {
                                                    ClientProt.method6054(var19, var20, var21, var22, var10.color, var10.lineWidth);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(IB)I",
            garbageValue = "116"
    )
    public static int method339(int var0) {
        Varbit var1 = class79.method1158(var0);
        int var2 = var1.configId;
        int var3 = var1.leastSignificantBit;
        int var4 = var1.mostSignificantBit;
        int var5 = class311.varpsMasks[var4 - var3];
        return class311.clientVarps[var2] >> var3 & var5;
    }
}
