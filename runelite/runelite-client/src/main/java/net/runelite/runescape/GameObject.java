package net.runelite.runescape;

import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.Angle;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGameObject;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSRenderable;

import java.awt.*;
import java.awt.geom.Area;

@ObfuscatedName("em")
@Implements("GameObject")
public final class GameObject implements RSGameObject {
    @ObfuscatedName("ag")
    static Image field1892;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 654530969
    )
    int orientation;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -1216523107
    )
    int height;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1770116491
    )
    int x;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = -1083446131
    )
    int offsetX;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -1722715155
    )
    int y;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = 1389634387
    )
    int cycle;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -620931109
    )
    int drawPriority;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 957627089
    )
    int relativeX;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -290340699
    )
    int relativeY;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Ldd;"
    )
    public Entity entity;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 192344141
    )
    int offsetY;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            longValue = 5315810707999832723L
    )
    public long hash;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = -1367215323
    )
    int flags;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1271604365
    )
    int plane;

    GameObject() {
        this.hash = 0L;
        this.flags = 0;
    }

    public Point getCanvasLocation(int var1) {
        return Perspective.localToCanvas(class166.clientInstance, this.getLocalLocation(), this.getPlane(), var1);
    }

    public int getRelativeX() {
        return this.relativeX;
    }

    public int getOffsetX() {
        return this.offsetX;
    }

    public long getHash() {
        return this.hash;
    }

    public RSModel getModel() {
        RSRenderable var1 = this.getRenderable();
        return var1 == null ? null : (var1 instanceof RSModel ? (RSModel) var1 : var1.getModel());
    }

    public RSRenderable getRenderable() {
        return this.entity;
    }

    public int getRsOrientation() {
        return this.orientation;
    }

    public int getX() {
        return this.x;
    }

    public LocalPoint getLocalLocation() {
        return new LocalPoint(this.getX(), this.getY());
    }

    public int getRelativeY() {
        return this.relativeY;
    }

    public int getOffsetY() {
        return this.offsetY;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getY() {
        return this.y;
    }

    public int getPlane() {
        return this.plane;
    }

    public Point getSceneMinLocation() {
        return new Point(this.getRelativeX(), this.getRelativeY());
    }

    public Point getSceneMaxLocation() {
        return new Point(this.getOffsetX(), this.getOffsetY());
    }

    public Area getClickbox() {
        return Perspective.getClickbox(class166.clientInstance, this.getModel(), this.getRsOrientation(), this.getLocalLocation());
    }

    public Polygon getConvexHull() {
        RSModel var1 = this.getModel();
        return var1 == null ? null : var1.getConvexHull(this.getX(), this.getY(), this.getRsOrientation());
    }

    public Angle getOrientation() {
        int var1 = this.getRsOrientation();
        int var2 = this.getFlags() >> 6 & 3;
        return new Angle(var1 + var2 * 512);
    }

    public int getId() {
        long var1 = this.getHash();
        return (int) (var1 >>> 17 & 4294967295L);
    }

    public WorldPoint getWorldLocation() {
        return WorldPoint.fromLocal(class166.clientInstance, this.getX(), this.getY(), this.getPlane());
    }

    public Point getCanvasLocation() {
        return this.getCanvasLocation(0);
    }

    public Polygon getCanvasTilePoly() {
        return Perspective.getCanvasTilePoly(class166.clientInstance, this.getLocalLocation());
    }

    public Point getCanvasTextLocation(Graphics2D var1, String var2, int var3) {
        return Perspective.getCanvasTextLocation(class166.clientInstance, var1, this.getLocalLocation(), var2, var3);
    }

    public Point getMinimapLocation() {
        return Perspective.localToMinimap(class166.clientInstance, this.getLocalLocation());
    }

    public int getHeight() {
        return this.height;
    }

    @ObfuscatedName("hy")
    @ObfuscatedSignature(
            signature = "(IIIIII)V",
            garbageValue = "887536558"
    )
    static final void method2036(int var0, int var1, int var2, int var3, int var4) {
        long var5 = class131.sceneManager.method3821(var0, var1, var2);
        int var7;
        int var8;
        int var9;
        int var10;
        int var12;
        int var13;
        if (0L != var5) {
            var7 = class131.sceneManager.method3825(var0, var1, var2, var5);
            var8 = var7 >> 6 & 3;
            var9 = var7 & 31;
            var10 = var3;
            if (WorldMapDecoration.method2946(var5)) {
                var10 = var4;
            }

            int[] var11 = TotalQuantityComparator.minimapSprite.pixels;
            var12 = var1 * 4 + (103 - var2) * 2048 + 24624;
            var13 = SubInterface.method2437(var5);
            LocType var14 = class225.method4485(var13);
            if (var14.mapSceneId != -1) {
                IndexedSprite var15 = class0.mapscene[var14.mapSceneId];
                if (var15 != null) {
                    int var16 = (var14.width * 4 - var15.width) / 2;
                    int var17 = (var14.length * 4 - var15.height) / 2;
                    var15.method824(var16 + var1 * 4 + 48, (104 - var2 - var14.length) * 4 + var17 + 48);
                }
            } else {
                if (var9 == 0 || var9 == 2) {
                    if (var8 == 0) {
                        var11[var12] = var10;
                        var11[var12 + 512] = var10;
                        var11[var12 + 1024] = var10;
                        var11[var12 + 1536] = var10;
                    } else if (var8 == 1) {
                        var11[var12] = var10;
                        var11[var12 + 1] = var10;
                        var11[var12 + 2] = var10;
                        var11[var12 + 3] = var10;
                    } else if (var8 == 2) {
                        var11[var12 + 3] = var10;
                        var11[var12 + 512 + 3] = var10;
                        var11[var12 + 1024 + 3] = var10;
                        var11[var12 + 1536 + 3] = var10;
                    } else if (var8 == 3) {
                        var11[var12 + 1536] = var10;
                        var11[var12 + 1536 + 1] = var10;
                        var11[var12 + 1536 + 2] = var10;
                        var11[var12 + 1536 + 3] = var10;
                    }
                }

                if (var9 == 3) {
                    if (var8 == 0) {
                        var11[var12] = var10;
                    } else if (var8 == 1) {
                        var11[var12 + 3] = var10;
                    } else if (var8 == 2) {
                        var11[var12 + 1536 + 3] = var10;
                    } else if (var8 == 3) {
                        var11[var12 + 1536] = var10;
                    }
                }

                if (var9 == 2) {
                    if (var8 == 3) {
                        var11[var12] = var10;
                        var11[var12 + 512] = var10;
                        var11[var12 + 1024] = var10;
                        var11[var12 + 1536] = var10;
                    } else if (var8 == 0) {
                        var11[var12] = var10;
                        var11[var12 + 1] = var10;
                        var11[var12 + 2] = var10;
                        var11[var12 + 3] = var10;
                    } else if (var8 == 1) {
                        var11[var12 + 3] = var10;
                        var11[var12 + 512 + 3] = var10;
                        var11[var12 + 1024 + 3] = var10;
                        var11[var12 + 1536 + 3] = var10;
                    } else if (var8 == 2) {
                        var11[var12 + 1536] = var10;
                        var11[var12 + 1536 + 1] = var10;
                        var11[var12 + 1536 + 2] = var10;
                        var11[var12 + 1536 + 3] = var10;
                    }
                }
            }
        }

        var5 = class131.sceneManager.method3823(var0, var1, var2);
        if (var5 != 0L) {
            var7 = class131.sceneManager.method3825(var0, var1, var2, var5);
            var8 = var7 >> 6 & 3;
            var9 = var7 & 31;
            var10 = SubInterface.method2437(var5);
            LocType var24 = class225.method4485(var10);
            int var19;
            if (var24.mapSceneId != -1) {
                IndexedSprite var18 = class0.mapscene[var24.mapSceneId];
                if (var18 != null) {
                    var13 = (var24.width * 4 - var18.width) / 2;
                    var19 = (var24.length * 4 - var18.height) / 2;
                    var18.method824(var13 + var1 * 4 + 48, var19 + (104 - var2 - var24.length) * 4 + 48);
                }
            } else if (var9 == 9) {
                var12 = 15658734;
                if (WorldMapDecoration.method2946(var5)) {
                    var12 = 15597568;
                }

                int[] var23 = TotalQuantityComparator.minimapSprite.pixels;
                var19 = var1 * 4 + (103 - var2) * 2048 + 24624;
                if (var8 != 0 && var8 != 2) {
                    var23[var19] = var12;
                    var23[var19 + 1 + 512] = var12;
                    var23[var19 + 1024 + 2] = var12;
                    var23[var19 + 1536 + 3] = var12;
                } else {
                    var23[var19 + 1536] = var12;
                    var23[var19 + 1 + 1024] = var12;
                    var23[var19 + 512 + 2] = var12;
                    var23[var19 + 3] = var12;
                }
            }
        }

        var5 = class131.sceneManager.method3920(var0, var1, var2);
        if (var5 != 0L) {
            var7 = SubInterface.method2437(var5);
            LocType var20 = class225.method4485(var7);
            if (var20.mapSceneId != -1) {
                IndexedSprite var21 = class0.mapscene[var20.mapSceneId];
                if (var21 != null) {
                    var10 = (var20.width * 4 - var21.width) / 2;
                    int var22 = (var20.length * 4 - var21.height) / 2;
                    var21.method824(var1 * 4 + var10 + 48, var22 + (104 - var2 - var20.length) * 4 + 48);
                }
            }
        }

    }

    @ObfuscatedName("iu")
    @ObfuscatedSignature(
            signature = "(Lhn;IIZB)V",
            garbageValue = "58"
    )
    static void method2037(ComponentType var0, int var1, int var2, boolean var3) {
        int var4 = var0.width;
        int var5 = var0.height;
        if (var0.sizeXmode == 0) {
            var0.width = var0.sizeX;
        } else if (var0.sizeXmode == 1) {
            var0.width = var1 - var0.sizeX;
        } else if (var0.sizeXmode == 2) {
            var0.width = var0.sizeX * var1 >> 14;
        }

        if (var0.sizeYmode == 0) {
            var0.height = var0.sizeY;
        } else if (var0.sizeYmode == 1) {
            var0.height = var2 - var0.sizeY;
        } else if (var0.sizeYmode == 2) {
            var0.height = var2 * var0.sizeY >> 14;
        }

        if (var0.sizeXmode == 4) {
            var0.width = var0.height * var0.field2684 / var0.field2668;
        }

        if (var0.sizeYmode == 4) {
            var0.height = var0.width * var0.field2668 / var0.field2684;
        }

        if (var0.clientcode == 1337) {
            client.field815 = var0;
        }

        if (var3 && var0.onResizeListener != null && (var4 != var0.width || var5 != var0.height)) {
            ScriptEvent var6 = new ScriptEvent();
            var6.source = var0;
            var6.params = var0.onResizeListener;
            client.field842.method4351(var6);
        }

    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(Lkz;Lkz;Lkz;ZB)V",
            garbageValue = "-30"
    )
    static void method2034(Font var0, Font var1, Font var2, boolean var3) {
        if (var3) {
            class316.field1143 = (FriendManager.canvasWidth - 765) / 2;
            class316.loginWindowX = class316.field1143 + 202;
            class260.field103 = class316.loginWindowX + 180;
        }

        int var7;
        int var12;
        int var13;
        boolean var15;
        int var16;
        byte var22;
        int var23;
        int var26;
        int var32;
        int var34;
        int var35;
        int var36;
        int var38;
        int var40;
        if (class316.worldSelectShown) {
            if (AttackOpPriority.field1137 == null) {
                AttackOpPriority.field1137 = class61.method887(JagException.sprites, "sl_back", "");
            }

            IndexedSprite[] var8;
            Js5 var31;
            if (CacheFile.slFlagSprites == null) {
                var31 = JagException.sprites;
                var32 = var31.method1510("sl_flags");
                var7 = var31.method1532(var32, "");
                if (!WorldMapRectangle.method128(var31, var32, var7)) {
                    var8 = null;
                } else {
                    var8 = GraphicsDefaults.method4016();
                }

                CacheFile.slFlagSprites = var8;
            }

            if (class113.slArrowSprites == null) {
                var31 = JagException.sprites;
                var32 = var31.method1510("sl_arrows");
                var7 = var31.method1532(var32, "");
                if (!WorldMapRectangle.method128(var31, var32, var7)) {
                    var8 = null;
                } else {
                    var8 = GraphicsDefaults.method4016();
                }

                class113.slArrowSprites = var8;
            }

            if (class98.slStarSprites == null) {
                var31 = JagException.sprites;
                var32 = var31.method1510("sl_stars");
                var7 = var31.method1532(var32, "");
                if (!WorldMapRectangle.method128(var31, var32, var7)) {
                    var8 = null;
                } else {
                    var8 = GraphicsDefaults.method4016();
                }

                class98.slStarSprites = var8;
            }

            Rasterizer2D.method449(class316.field1143, 23, 765, 480, 0);
            Rasterizer2D.method454(class316.field1143, 0, 125, 23, 12425273, 9135624);
            Rasterizer2D.method454(class316.field1143 + 125, 0, 640, 23, 5197647, 2697513);
            var0.method1862("Select a world", class316.field1143 + 62, 15, 0, -1);
            if (class98.slStarSprites != null) {
                class98.slStarSprites[1].method824(class316.field1143 + 140, 1);
                var1.method1828("Members only world", class316.field1143 + 152, 10, 16777215, -1);
                class98.slStarSprites[0].method824(class316.field1143 + 140, 12);
                var1.method1828("Free world", class316.field1143 + 152, 21, 16777215, -1);
            }

            if (class113.slArrowSprites != null) {
                var40 = class316.field1143 + 280;
                if (World.field1016[0] == 0 && World.field1018[0] == 0) {
                    class113.slArrowSprites[2].method824(var40, 4);
                } else {
                    class113.slArrowSprites[0].method824(var40, 4);
                }

                if (World.field1016[0] == 0 && World.field1018[0] == 1) {
                    class113.slArrowSprites[3].method824(var40 + 15, 4);
                } else {
                    class113.slArrowSprites[1].method824(var40 + 15, 4);
                }

                var0.method1828("World", var40 + 32, 17, 16777215, -1);
                var23 = class316.field1143 + 390;
                if (World.field1016[0] == 1 && World.field1018[0] == 0) {
                    class113.slArrowSprites[2].method824(var23, 4);
                } else {
                    class113.slArrowSprites[0].method824(var23, 4);
                }

                if (World.field1016[0] == 1 && World.field1018[0] == 1) {
                    class113.slArrowSprites[3].method824(var23 + 15, 4);
                } else {
                    class113.slArrowSprites[1].method824(var23 + 15, 4);
                }

                var0.method1828("Players", var23 + 32, 17, 16777215, -1);
                var32 = class316.field1143 + 500;
                if (World.field1016[0] == 2 && World.field1018[0] == 0) {
                    class113.slArrowSprites[2].method824(var32, 4);
                } else {
                    class113.slArrowSprites[0].method824(var32, 4);
                }

                if (World.field1016[0] == 2 && World.field1018[0] == 1) {
                    class113.slArrowSprites[3].method824(var32 + 15, 4);
                } else {
                    class113.slArrowSprites[1].method824(var32 + 15, 4);
                }

                var0.method1828("Location", var32 + 32, 17, 16777215, -1);
                var7 = class316.field1143 + 610;
                if (World.field1016[0] == 3 && World.field1018[0] == 0) {
                    class113.slArrowSprites[2].method824(var7, 4);
                } else {
                    class113.slArrowSprites[0].method824(var7, 4);
                }

                if (World.field1016[0] == 3 && World.field1018[0] == 1) {
                    class113.slArrowSprites[3].method824(var7 + 15, 4);
                } else {
                    class113.slArrowSprites[1].method824(var7 + 15, 4);
                }

                var0.method1828("Type", var7 + 32, 17, 16777215, -1);
            }

            Rasterizer2D.method449(class316.field1143 + 708, 4, 50, 16, 0);
            var1.method1862("Cancel", class316.field1143 + 708 + 25, 16, 16777215, -1);
            class316.field1164 = -1;
            if (AttackOpPriority.field1137 != null) {
                var22 = 88;
                byte var44 = 19;
                var32 = 765 / (var22 + 1);
                var7 = 480 / (var44 + 1);

                do {
                    var26 = var7;
                    var34 = var32;
                    if (var7 * (var32 - 1) >= World.worldCount) {
                        --var32;
                    }

                    if (var32 * (var7 - 1) >= World.worldCount) {
                        --var7;
                    }

                    if (var32 * (var7 - 1) >= World.worldCount) {
                        --var7;
                    }
                } while (var26 != var7 || var34 != var32);

                var26 = (765 - var32 * var22) / (var32 + 1);
                if (var26 > 5) {
                    var26 = 5;
                }

                var34 = (480 - var44 * var7) / (var7 + 1);
                if (var34 > 5) {
                    var34 = 5;
                }

                var35 = (765 - var22 * var32 - var26 * (var32 - 1)) / 2;
                var36 = (480 - var44 * var7 - var34 * (var7 - 1)) / 2;
                var12 = var36 + 23;
                var13 = var35 + class316.field1143;
                var38 = 0;
                var15 = false;

                for (var16 = 0; var16 < World.worldCount; ++var16) {
                    World var17 = World.worldList[var16];
                    boolean var18 = true;
                    String var19 = Integer.toString(var17.playerCount);
                    if (var17.playerCount == -1) {
                        var19 = "OFF";
                        var18 = false;
                    } else if (var17.playerCount > 1980) {
                        var19 = "FULL";
                        var18 = false;
                    }

                    int var21 = 0;
                    byte var20;
                    if (var17.method3721()) {
                        if (var17.method3719()) {
                            var20 = 7;
                        } else {
                            var20 = 6;
                        }
                    } else if (var17.method3724()) {
                        var21 = 16711680;
                        if (var17.method3719()) {
                            var20 = 5;
                        } else {
                            var20 = 4;
                        }
                    } else if (var17.method3722()) {
                        if (var17.method3719()) {
                            var20 = 3;
                        } else {
                            var20 = 2;
                        }
                    } else if (var17.method3719()) {
                        var20 = 1;
                    } else {
                        var20 = 0;
                    }

                    if (MouseInput.mouseLastX >= var13 && MouseInput.mouseLastY * -976212263 >= var12 && MouseInput.mouseLastX < var22 + var13 && MouseInput.mouseLastY * -976212263 < var44 + var12 && var18) {
                        class316.field1164 = var16;
                        AttackOpPriority.field1137[var20].method2288(var13, var12, 128, 16777215);
                        var15 = true;
                    } else {
                        AttackOpPriority.field1137[var20].method2273(var13, var12);
                    }

                    if (CacheFile.slFlagSprites != null) {
                        CacheFile.slFlagSprites[(var17.method3719() ? 8 : 0) + var17.location].method824(var13 + 29, var12);
                    }

                    var0.method1862(Integer.toString(var17.id), var13 + 15, var44 / 2 + var12 + 5, var21, -1);
                    var1.method1862(var19, var13 + 60, var44 / 2 + var12 + 5, 268435455, -1);
                    var12 = var12 + var34 + var44;
                    ++var38;
                    if (var38 >= var7) {
                        var12 = var36 + 23;
                        var13 = var13 + var22 + var26;
                        var38 = 0;
                    }
                }

                if (var15) {
                    var16 = var1.method1775(World.worldList[class316.field1164].activity) + 6;
                    int var43 = var1.verticalSpace + 8;
                    Rasterizer2D.method449(MouseInput.mouseLastX - var16 / 2, MouseInput.mouseLastY * -976212263 + 20 + 5, var16, var43, 16777120);
                    Rasterizer2D.method518(MouseInput.mouseLastX - var16 / 2, MouseInput.mouseLastY * -976212263 + 20 + 5, var16, var43, 0);
                    var1.method1862(World.worldList[class316.field1164].activity, MouseInput.mouseLastX, MouseInput.mouseLastY * -976212263 + var1.verticalSpace + 20 + 5 + 4, 0, -1);
                }
            }

            WorldMapManager.rasterProvider.vmethod2955(0, 0);
        } else {
            if (var3) {
                class316.field1145.method2273(class316.field1143, 0);
                class316.field1146.method2273(class316.field1143 + 382, 0);
                Varbit.logoSprite.method824(class316.field1143 + 382 - Varbit.logoSprite.width / 2, 18);
            }

            if (client.gameState == 0 || client.gameState == 5) {
                var22 = 20;
                var0.method1862("RuneScape is loading - please wait...", class316.loginWindowX + 180, 245 - var22, 16777215, -1);
                var23 = 253 - var22;
                Rasterizer2D.method518(class316.loginWindowX + 180 - 152, var23, 304, 34, 9179409);
                Rasterizer2D.method518(class316.loginWindowX + 180 - 151, var23 + 1, 302, 32, 0);
                Rasterizer2D.method449(class316.loginWindowX + 180 - 150, var23 + 2, class316.loadingBarPercentage * 3, 30, 9179409);
                Rasterizer2D.method449(class316.loadingBarPercentage * 3 + (class316.loginWindowX + 180 - 150), var23 + 2, 300 - class316.loadingBarPercentage * 3, 30, 0);
                var0.method1862(class316.loadingText, class316.loginWindowX + 180, 276 - var22, 16777215, -1);
            }

            String var24;
            String var25;
            short var39;
            short var41;
            if (client.gameState == 20) {
                class316.field1149.method824(class316.loginWindowX + 180 - class316.field1149.width / 2, 271 - class316.field1149.height / 2);
                var39 = 201;
                var0.method1862(class316.loginMessage1, class316.loginWindowX + 180, var39, 16776960, 0);
                var40 = var39 + 15;
                var0.method1862(class316.loginMessage2, class316.loginWindowX + 180, var40, 16776960, 0);
                var40 += 15;
                var0.method1862(class316.loginMessage3, class316.loginWindowX + 180, var40, 16776960, 0);
                var40 += 15;
                var40 += 7;
                if (class316.loginIndex != 4) {
                    var0.method1828("Login: ", class316.loginWindowX + 180 - 110, var40, 16777215, 0);
                    var41 = 200;
                    var24 = GameEngine.options.hideUsername ? FileSystem.method5641(class316.username) : class316.username;

                    for (var25 = var24; var0.method1775(var25) > var41; var25 = var25.substring(0, var25.length() - 1)) {
                        ;
                    }

                    var0.method1828(FontTypeFace.method1779(var25), class316.loginWindowX + 180 - 70, var40, 16777215, 0);
                    var40 += 15;
                    var0.method1828("Password: " + FileSystem.method5641(class316.password), class316.loginWindowX + 180 - 108, var40, 16777215, 0);
                    var40 += 15;
                }
            }

            if (client.gameState == 10 || client.gameState == 11) {
                class316.field1149.method824(class316.loginWindowX, 171);
                short var6;
                if (class316.loginIndex == 0) {
                    var39 = 251;
                    var0.method1862("Welcome to RuneScape", class316.loginWindowX + 180, var39, 16776960, 0);
                    var40 = var39 + 30;
                    var23 = class316.loginWindowX + 180 - 80;
                    var6 = 291;
                    class226.field3801.method824(var23 - 73, var6 - 20);
                    var0.method1774("New User", var23 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
                    var23 = class316.loginWindowX + 180 + 80;
                    class226.field3801.method824(var23 - 73, var6 - 20);
                    var0.method1774("Existing User", var23 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
                } else if (class316.loginIndex == 1) {
                    var0.method1862(class316.Login_response0, class316.loginWindowX + 180, 201, 16776960, 0);
                    var39 = 236;
                    var0.method1862(class316.loginMessage1, class316.loginWindowX + 180, var39, 16777215, 0);
                    var40 = var39 + 15;
                    var0.method1862(class316.loginMessage2, class316.loginWindowX + 180, var40, 16777215, 0);
                    var40 += 15;
                    var0.method1862(class316.loginMessage3, class316.loginWindowX + 180, var40, 16777215, 0);
                    var40 += 15;
                    var23 = class316.loginWindowX + 180 - 80;
                    var6 = 321;
                    class226.field3801.method824(var23 - 73, var6 - 20);
                    var0.method1862("Continue", var23, var6 + 5, 16777215, 0);
                    var23 = class316.loginWindowX + 180 + 80;
                    class226.field3801.method824(var23 - 73, var6 - 20);
                    var0.method1862("Cancel", var23, var6 + 5, 16777215, 0);
                } else if (class316.loginIndex == 2) {
                    var39 = 201;
                    var0.method1862(class316.loginMessage1, class260.field103, var39, 16776960, 0);
                    var40 = var39 + 15;
                    var0.method1862(class316.loginMessage2, class260.field103, var40, 16776960, 0);
                    var40 += 15;
                    var0.method1862(class316.loginMessage3, class260.field103, var40, 16776960, 0);
                    var40 += 15;
                    var40 += 7;
                    var0.method1828("Login: ", class260.field103 - 110, var40, 16777215, 0);
                    var41 = 200;
                    var24 = GameEngine.options.hideUsername ? FileSystem.method5641(class316.username) : class316.username;

                    for (var25 = var24; var0.method1775(var25) > var41; var25 = var25.substring(1)) {
                        ;
                    }

                    var0.method1828(FontTypeFace.method1779(var25) + (class316.currentLoginField == 0 & client.gameCycle % 40 < 20 ? class31.method548(16776960) + "|" : ""), class260.field103 - 70, var40, 16777215, 0);
                    var40 += 15;
                    var0.method1828("Password: " + FileSystem.method5641(class316.password) + (class316.currentLoginField == 1 & client.gameCycle % 40 < 20 ? class31.method548(16776960) + "|" : ""), class260.field103 - 108, var40, 16777215, 0);
                    var40 += 15;
                    var39 = 277;
                    var26 = class260.field103 + -117;
                    boolean var10 = client.Login_isUsernameRemembered;
                    boolean var11 = class316.field1170;
                    IndexedSprite var28 = var10 ? (var11 ? UrlRequest.field1925 : Frames.field1861) : (var11 ? class316.field1148 : class150.field2417);
                    var28.method824(var26, var39);
                    var26 = var26 + var28.width + 5;
                    var1.method1828("Remember username", var26, var39 + 13, 16776960, 0);
                    var26 = class260.field103 + 24;
                    boolean var14 = GameEngine.options.hideUsername;
                    var15 = class316.field1171;
                    IndexedSprite var30 = var14 ? (var15 ? UrlRequest.field1925 : Frames.field1861) : (var15 ? class316.field1148 : class150.field2417);
                    var30.method824(var26, var39);
                    var26 = var26 + var30.width + 5;
                    var1.method1828("Hide username", var26, var39 + 13, 16776960, 0);
                    var40 = var39 + 15;
                    var16 = class260.field103 - 80;
                    short var27 = 321;
                    class226.field3801.method824(var16 - 73, var27 - 20);
                    var0.method1862("Login", var16, var27 + 5, 16777215, 0);
                    var16 = class260.field103 + 80;
                    class226.field3801.method824(var16 - 73, var27 - 20);
                    var0.method1862("Cancel", var16, var27 + 5, 16777215, 0);
                    var39 = 357;
                    switch (class316.field1161) {
                        case 2:
                            class96.field2624 = "Having trouble logging in?";
                            break;
                        default:
                            class96.field2624 = "Forgotten your password? <col=ffffff>Click here.";
                    }

                    class316.field1177 = new Bounds(class260.field103, var39, var1.method1775(class96.field2624), 11);
                    var1.method1862(class96.field2624, class260.field103, var39, 16777215, 0);
                } else if (class316.loginIndex == 3) {
                    var39 = 201;
                    var0.method1862("Invalid username or password.", class316.loginWindowX + 180, var39, 16776960, 0);
                    var40 = var39 + 20;
                    var1.method1862("For accounts created after 24th November 2010, please use your", class316.loginWindowX + 180, var40, 16776960, 0);
                    var40 += 15;
                    var1.method1862("email address to login. Otherwise please login with your username.", class316.loginWindowX + 180, var40, 16776960, 0);
                    var40 += 15;
                    var23 = class316.loginWindowX + 180;
                    var6 = 276;
                    class226.field3801.method824(var23 - 73, var6 - 20);
                    var2.method1862("Try again", var23, var6 + 5, 16777215, 0);
                    var23 = class316.loginWindowX + 180;
                    var6 = 326;
                    class226.field3801.method824(var23 - 73, var6 - 20);
                    var2.method1862("Forgotten password?", var23, var6 + 5, 16777215, 0);
                } else {
                    short var9;
                    if (class316.loginIndex == 4) {
                        var0.method1862("Authenticator", class316.loginWindowX + 180, 201, 16776960, 0);
                        var39 = 236;
                        var0.method1862(class316.loginMessage1, class316.loginWindowX + 180, var39, 16777215, 0);
                        var40 = var39 + 15;
                        var0.method1862(class316.loginMessage2, class316.loginWindowX + 180, var40, 16777215, 0);
                        var40 += 15;
                        var0.method1862(class316.loginMessage3, class316.loginWindowX + 180, var40, 16777215, 0);
                        var40 += 15;
                        var0.method1828("PIN: " + FileSystem.method5641(class113.field82) + (client.gameCycle % 40 < 20 ? class31.method548(16776960) + "|" : ""), class316.loginWindowX + 180 - 108, var40, 16777215, 0);
                        var40 -= 8;
                        var0.method1828("Trust this computer", class316.loginWindowX + 180 - 9, var40, 16776960, 0);
                        var40 += 15;
                        var0.method1828("for 30 days: ", class316.loginWindowX + 180 - 9, var40, 16776960, 0);
                        var23 = class316.loginWindowX + 180 - 9 + var0.method1775("for 30 days: ") + 15;
                        var32 = var40 - var0.verticalSpace;
                        IndexedSprite var42;
                        if (class316.field1172) {
                            var42 = Frames.field1861;
                        } else {
                            var42 = class150.field2417;
                        }

                        var42.method824(var23, var32);
                        var40 += 15;
                        var26 = class316.loginWindowX + 180 - 80;
                        var9 = 321;
                        class226.field3801.method824(var26 - 73, var9 - 20);
                        var0.method1862("Continue", var26, var9 + 5, 16777215, 0);
                        var26 = class316.loginWindowX + 180 + 80;
                        class226.field3801.method824(var26 - 73, var9 - 20);
                        var0.method1862("Cancel", var26, var9 + 5, 16777215, 0);
                        var1.method1862("<u=ff>Can\'t Log In?</u>", class316.loginWindowX + 180, var9 + 36, 255, 0);
                    } else if (class316.loginIndex == 5) {
                        var0.method1862("Forgotten your password?", class316.loginWindowX + 180, 201, 16776960, 0);
                        var39 = 221;
                        var2.method1862(class316.loginMessage1, class316.loginWindowX + 180, var39, 16776960, 0);
                        var40 = var39 + 15;
                        var2.method1862(class316.loginMessage2, class316.loginWindowX + 180, var40, 16776960, 0);
                        var40 += 15;
                        var2.method1862(class316.loginMessage3, class316.loginWindowX + 180, var40, 16776960, 0);
                        var40 += 15;
                        var40 += 14;
                        var0.method1828("Username/email: ", class316.loginWindowX + 180 - 145, var40, 16777215, 0);
                        var41 = 174;
                        var24 = GameEngine.options.hideUsername ? FileSystem.method5641(class316.username) : class316.username;

                        for (var25 = var24; var0.method1775(var25) > var41; var25 = var25.substring(1)) {
                            ;
                        }

                        var0.method1828(FontTypeFace.method1779(var25) + (client.gameCycle % 40 < 20 ? class31.method548(16776960) + "|" : ""), class316.loginWindowX + 180 - 34, var40, 16777215, 0);
                        var40 += 15;
                        var26 = class316.loginWindowX + 180 - 80;
                        var9 = 321;
                        class226.field3801.method824(var26 - 73, var9 - 20);
                        var0.method1862("Recover", var26, var9 + 5, 16777215, 0);
                        var26 = class316.loginWindowX + 180 + 80;
                        class226.field3801.method824(var26 - 73, var9 - 20);
                        var0.method1862("Back", var26, var9 + 5, 16777215, 0);
                    } else if (class316.loginIndex == 6) {
                        var39 = 201;
                        var0.method1862(class316.loginMessage1, class316.loginWindowX + 180, var39, 16776960, 0);
                        var40 = var39 + 15;
                        var0.method1862(class316.loginMessage2, class316.loginWindowX + 180, var40, 16776960, 0);
                        var40 += 15;
                        var0.method1862(class316.loginMessage3, class316.loginWindowX + 180, var40, 16776960, 0);
                        var40 += 15;
                        var23 = class316.loginWindowX + 180;
                        var6 = 321;
                        class226.field3801.method824(var23 - 73, var6 - 20);
                        var0.method1862("Back", var23, var6 + 5, 16777215, 0);
                    } else if (class316.loginIndex == 7) {
                        var39 = 216;
                        var0.method1862("Your date of birth isn\'t set.", class316.loginWindowX + 180, var39, 16776960, 0);
                        var40 = var39 + 15;
                        var2.method1862("Please verify your account status by", class316.loginWindowX + 180, var40, 16776960, 0);
                        var40 += 15;
                        var2.method1862("setting your date of birth.", class316.loginWindowX + 180, var40, 16776960, 0);
                        var40 += 15;
                        var23 = class316.loginWindowX + 180 - 80;
                        var6 = 321;
                        class226.field3801.method824(var23 - 73, var6 - 20);
                        var0.method1862("Set Date of Birth", var23, var6 + 5, 16777215, 0);
                        var23 = class316.loginWindowX + 180 + 80;
                        class226.field3801.method824(var23 - 73, var6 - 20);
                        var0.method1862("Back", var23, var6 + 5, 16777215, 0);
                    } else if (class316.loginIndex == 8) {
                        var39 = 216;
                        var0.method1862("Sorry, but your account is not eligible to play.", class316.loginWindowX + 180, var39, 16776960, 0);
                        var40 = var39 + 15;
                        var2.method1862("For more information, please take a look at", class316.loginWindowX + 180, var40, 16776960, 0);
                        var40 += 15;
                        var2.method1862("our privacy policy.", class316.loginWindowX + 180, var40, 16776960, 0);
                        var40 += 15;
                        var23 = class316.loginWindowX + 180 - 80;
                        var6 = 321;
                        class226.field3801.method824(var23 - 73, var6 - 20);
                        var0.method1862("Privacy Policy", var23, var6 + 5, 16777215, 0);
                        var23 = class316.loginWindowX + 180 + 80;
                        class226.field3801.method824(var23 - 73, var6 - 20);
                        var0.method1862("Back", var23, var6 + 5, 16777215, 0);
                    } else if (class316.loginIndex == 12) {
                        var39 = 201;
                        String var5 = "";
                        var24 = "";
                        var25 = "";
                        switch (class316.field1142) {
                            case 0:
                                var5 = "Your account has been disabled.";
                                var24 = class7.field2909;
                                var25 = "";
                                break;
                            case 1:
                                var5 = "Account locked as we suspect it has been stolen.";
                                var24 = class7.field2948;
                                var25 = "";
                                break;
                            default:
                                class158.method2698(false);
                        }

                        var0.method1862(var5, class316.loginWindowX + 180, var39, 16776960, 0);
                        var40 = var39 + 15;
                        var2.method1862(var24, class316.loginWindowX + 180, var40, 16776960, 0);
                        var40 += 15;
                        var2.method1862(var25, class316.loginWindowX + 180, var40, 16776960, 0);
                        var40 += 15;
                        var26 = class316.loginWindowX + 180;
                        var9 = 276;
                        class226.field3801.method824(var26 - 73, var9 - 20);
                        var0.method1862("Support Page", var26, var9 + 5, 16777215, 0);
                        var26 = class316.loginWindowX + 180;
                        var9 = 326;
                        class226.field3801.method824(var26 - 73, var9 - 20);
                        var0.method1862("Back", var26, var9 + 5, 16777215, 0);
                    }
                }
            }

            if (class316.field1156 > 0) {
                var40 = class316.field1156;
                var41 = 256;
                class316.field1160 += var40 * 128;
                if (class316.field1160 > OwnWorldComparator.field640.length) {
                    class316.field1160 -= OwnWorldComparator.field640.length;
                    var32 = (int) (Math.random() * 12.0D);
                    class0.method0(class116.runeSprites[var32]);
                }

                var32 = 0;
                var7 = var40 * 128;
                var26 = (var41 - var40) * 128;

                for (var34 = 0; var34 < var26; ++var34) {
                    var35 = WorldMapDecoration.field182[var7 + var32] - OwnWorldComparator.field640[var32 + class316.field1160 & OwnWorldComparator.field640.length - 1] * var40 / 6;
                    if (var35 < 0) {
                        var35 = 0;
                    }

                    WorldMapDecoration.field182[var32++] = var35;
                }

                for (var34 = var41 - var40; var34 < var41; ++var34) {
                    var35 = var34 * 128;

                    for (var36 = 0; var36 < 128; ++var36) {
                        var12 = (int) (Math.random() * 100.0D);
                        if (var12 < 50 && var36 > 10 && var36 < 118) {
                            WorldMapDecoration.field182[var36 + var35] = 255;
                        } else {
                            WorldMapDecoration.field182[var35 + var36] = 0;
                        }
                    }
                }

                if (class316.field1152 > 0) {
                    class316.field1152 -= var40 * 4;
                }

                if (class316.field1153 > 0) {
                    class316.field1153 -= var40 * 4;
                }

                if (class316.field1152 == 0 && class316.field1153 == 0) {
                    var34 = (int) (Math.random() * (double) (2000 / var40));
                    if (var34 == 0) {
                        class316.field1152 = 1024;
                    }

                    if (var34 == 1) {
                        class316.field1153 = 1024;
                    }
                }

                for (var34 = 0; var34 < var41 - var40; ++var34) {
                    class316.field1162[var34] = class316.field1162[var34 + var40];
                }

                for (var34 = var41 - var40; var34 < var41; ++var34) {
                    class316.field1162[var34] = (int) (Math.sin((double) class316.field1157 / 14.0D) * 16.0D + Math.sin((double) class316.field1157 / 15.0D) * 14.0D + Math.sin((double) class316.field1157 / 16.0D) * 12.0D);
                    ++class316.field1157;
                }

                class316.field1173 += var40;
                var34 = (var40 + (client.gameCycle & 1)) / 2;
                if (var34 > 0) {
                    for (var35 = 0; var35 < class316.field1173 * 100; ++var35) {
                        var36 = (int) (Math.random() * 124.0D) + 2;
                        var12 = (int) (Math.random() * 128.0D) + 128;
                        WorldMapDecoration.field182[var36 + (var12 << 7)] = 192;
                    }

                    class316.field1173 = 0;
                    var35 = 0;

                    label744:
                    while (true) {
                        if (var35 >= var41) {
                            var35 = 0;

                            while (true) {
                                if (var35 >= 128) {
                                    break label744;
                                }

                                var36 = 0;

                                for (var12 = -var34; var12 < var41; ++var12) {
                                    var13 = var12 * 128;
                                    if (var34 + var12 < var41) {
                                        var36 += WorldMapDecoration.field183[var35 + var13 + var34 * 128];
                                    }

                                    if (var12 - (var34 + 1) >= 0) {
                                        var36 -= WorldMapDecoration.field183[var13 + var35 - (var34 + 1) * 128];
                                    }

                                    if (var12 >= 0) {
                                        WorldMapDecoration.field182[var35 + var13] = var36 / (var34 * 2 + 1);
                                    }
                                }

                                ++var35;
                            }
                        }

                        var36 = 0;
                        var12 = var35 * 128;

                        for (var13 = -var34; var13 < 128; ++var13) {
                            if (var34 + var13 < 128) {
                                var36 += WorldMapDecoration.field182[var13 + var12 + var34];
                            }

                            if (var13 - (var34 + 1) >= 0) {
                                var36 -= WorldMapDecoration.field182[var12 + var13 - (var34 + 1)];
                            }

                            if (var13 >= 0) {
                                WorldMapDecoration.field183[var13 + var12] = var36 / (var34 * 2 + 1);
                            }
                        }

                        ++var35;
                    }
                }

                class316.field1156 = 0;
            }

            var39 = 256;
            if (class316.field1152 > 0) {
                for (var23 = 0; var23 < 256; ++var23) {
                    if (class316.field1152 > 768) {
                        class4.field1047[var23] = class316.method5993(class316.field1151[var23], MouseRecorder.field583[var23], 1024 - class316.field1152);
                    } else if (class316.field1152 > 256) {
                        class4.field1047[var23] = MouseRecorder.field583[var23];
                    } else {
                        class4.field1047[var23] = class316.method5993(MouseRecorder.field583[var23], class316.field1151[var23], 256 - class316.field1152);
                    }
                }
            } else if (class316.field1153 > 0) {
                for (var23 = 0; var23 < 256; ++var23) {
                    if (class316.field1153 > 768) {
                        class4.field1047[var23] = class316.method5993(class316.field1151[var23], class139.field2048[var23], 1024 - class316.field1153);
                    } else if (class316.field1153 > 256) {
                        class4.field1047[var23] = class139.field2048[var23];
                    } else {
                        class4.field1047[var23] = class316.method5993(class139.field2048[var23], class316.field1151[var23], 256 - class316.field1153);
                    }
                }
            } else {
                for (var23 = 0; var23 < 256; ++var23) {
                    class4.field1047[var23] = class316.field1151[var23];
                }
            }

            Rasterizer2D.method469(class316.field1143, 9, class316.field1143 + 128, var39 + 7);
            class316.field1145.method2273(class316.field1143, 0);
            Rasterizer2D.method439();
            var23 = 0;
            var32 = WorldMapManager.rasterProvider.width * 9 + class316.field1143;

            for (var7 = 1; var7 < var39 - 1; ++var7) {
                var26 = class316.field1162[var7] * (var39 - var7) / var39;
                var34 = var26 + 22;
                if (var34 < 0) {
                    var34 = 0;
                }

                var23 += var34;

                for (var35 = var34; var35 < 128; ++var35) {
                    var36 = WorldMapDecoration.field182[var23++];
                    if (var36 != 0) {
                        var12 = var36;
                        var13 = 256 - var36;
                        var36 = class4.field1047[var36];
                        var38 = WorldMapManager.rasterProvider.pixels[var32];
                        WorldMapManager.rasterProvider.pixels[var32++] = ((var36 & 16711935) * var12 + (var38 & 16711935) * var13 & -16711936) + (var13 * (var38 & 65280) + var12 * (var36 & 65280) & 16711680) >> 8;
                    } else {
                        ++var32;
                    }
                }

                var32 += var34 + WorldMapManager.rasterProvider.width - 128;
            }

            Rasterizer2D.method469(class316.field1143 + 765 - 128, 9, class316.field1143 + 765, var39 + 7);
            class316.field1146.method2273(class316.field1143 + 382, 0);
            Rasterizer2D.method439();
            var23 = 0;
            var32 = WorldMapManager.rasterProvider.width * 9 + class316.field1143 + 637 + 24;

            for (var7 = 1; var7 < var39 - 1; ++var7) {
                var26 = class316.field1162[var7] * (var39 - var7) / var39;
                var34 = 103 - var26;
                var32 += var26;

                for (var35 = 0; var35 < var34; ++var35) {
                    var36 = WorldMapDecoration.field182[var23++];
                    if (var36 != 0) {
                        var12 = var36;
                        var13 = 256 - var36;
                        var36 = class4.field1047[var36];
                        var38 = WorldMapManager.rasterProvider.pixels[var32];
                        WorldMapManager.rasterProvider.pixels[var32++] = (var13 * (var38 & 65280) + var12 * (var36 & 65280) & 16711680) + ((var38 & 16711935) * var13 + (var36 & 16711935) * var12 & -16711936) >> 8;
                    } else {
                        ++var32;
                    }
                }

                var23 += 128 - var34;
                var32 += WorldMapManager.rasterProvider.width - var34 - var26;
            }

            class316.titlemuteSprite[GameEngine.options.muted ? 1 : 0].method824(class316.field1143 + 765 - 40, 463);
            if (client.gameState > 5 && client.languageId == 0) {
                if (class113.field77 != null) {
                    var40 = class316.field1143 + 5;
                    var41 = 463;
                    byte var37 = 100;
                    byte var33 = 35;
                    class113.field77.method824(var40, var41);
                    var0.method1862("World" + " " + client.world, var37 / 2 + var40, var33 / 2 + var41 - 2, 16777215, 0);
                    if (World.listFetcher != null) {
                        var1.method1862("Loading...", var37 / 2 + var40, var33 / 2 + var41 + 12, 16777215, 0);
                    } else {
                        var1.method1862("Click to switch", var37 / 2 + var40, var33 / 2 + var41 + 12, 16777215, 0);
                    }
                } else {
                    class113.field77 = MapElementType.method2369(JagException.sprites, "sl_button", "");
                }
            }

        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)[Llx;",
            garbageValue = "-535730210"
    )
    public static class271[] method2038() {
        return new class271[]{class271.field3865, class271.field3866, class271.field3867};
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Liu;I)V",
            garbageValue = "-1614523838"
    )
    public static void method2035(Js5Index var0) {
        StructType.field3411 = var0;
    }
}
