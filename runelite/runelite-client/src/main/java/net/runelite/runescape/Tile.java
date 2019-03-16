package net.runelite.runescape;

import net.runelite.api.Actor;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.mapping.*;
import net.runelite.rs.api.*;

import java.util.ArrayList;
import java.util.List;

@ObfuscatedName("dw")
@Implements("Tile")
public final class Tile extends Node implements RSTile {
    public static RSDeque[][][] lastGroundItems;
    public static net.runelite.api.GameObject lastGameObject;
    @ObfuscatedName("f")
    @Export("drawEntities")
    boolean drawEntities;
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Ldp;"
    )
    @Export("overlay")
    SceneTileModel overlay;
    @ObfuscatedName("v")
    @Export("draw")
    boolean draw;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 61030149
    )
    @Export("x")
    int x;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -839377731
    )
    @Export("y")
    int y;
    @ObfuscatedName("k")
    @ObfuscatedGetter(
            intValue = 1417475735
    )
    @Export("wallCullOppositeDirection")
    int wallCullOppositeDirection;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            signature = "Leu;"
    )
    @Export("decorativeObject")
    DecorativeObject decorativeObject;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -516271731
    )
    @Export("renderLevel")
    int renderLevel;
    @ObfuscatedName("x")
    @ObfuscatedGetter(
            intValue = -931998313
    )
    @Export("physicalLevel")
    int physicalLevel;
    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "[Lem;"
    )
    @Export("objects")
    GameObject[] objects;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = 746515257
    )
    @Export("entityCount")
    int entityCount;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Leb;"
    )
    @Export("wallObject")
    WallObject wallObject;
    @ObfuscatedName("a")
    @ObfuscatedGetter(
            intValue = 2087141383
    )
    @Export("wallCullDirection")
    int wallCullDirection;
    @ObfuscatedName("z")
    @ObfuscatedGetter(
            intValue = -1666767949
    )
    @Export("wallDrawFlags")
    int wallDrawFlags;
    @ObfuscatedName("n")
    @ObfuscatedSignature(
            signature = "Ldq;"
    )
    @Export("groundObject")
    GroundObject groundObject;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Ldi;"
    )
    @Export("paint")
    SceneTilePaint paint;
    @ObfuscatedName("t")
    @ObfuscatedGetter(
            intValue = 1006703407
    )
    @Export("wallUncullDirection")
    int wallUncullDirection;
    public net.runelite.api.WallObject previousWallObject;
    public net.runelite.api.DecorativeObject previousDecorativeObject;
    public net.runelite.api.GroundObject previousGroundObject;
    public net.runelite.api.GameObject[] previousGameObjects;
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "Ldt;"
    )
    @Export("itemLayer")
    ItemLayer itemLayer;
    @ObfuscatedName("d")
    @Export("entityFlags")
    int[] entityFlags;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = -1613750531
    )
    @Export("flags")
    int flags;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "Ldw;"
    )
    @Export("bridge")
    Tile bridge;
    @ObfuscatedName("h")
    @Export("visible")
    boolean visible;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1756290485
    )
    @Export("level")
    int level;

    static {
        lastGroundItems = new RSDeque[4][104][104];
    }

    Tile(int var1, int var2, int var3) {
        this.objects = new GameObject[5];
        this.gameObjectsChanged(-1);
        this.entityFlags = new int[5];
        this.flags = 0;
        this.renderLevel = this.level = var1;
        this.x = var2;
        this.y = var3;
    }

    @Export("getPlane")
    public int getPlane() {
        return this.level;
    }

    @Export("getX")
    public int getX() {
        return this.x;
    }

    @Export("getItemLayer")
    public net.runelite.api.ItemLayer getItemLayer() {
        return this.itemLayer;
    }

    public net.runelite.api.WallObject getWallObject() {
        return this.wallObject;
    }

    public net.runelite.api.DecorativeObject getDecorativeObject() {
        return this.decorativeObject;
    }

    public net.runelite.api.GroundObject getGroundObject() {
        return this.groundObject;
    }

    @Export("getY")
    public int getY() {
        return this.y;
    }

    @Export("gameObjectsChanged")
    public void gameObjectsChanged(int var1) {
        if (var1 != -1) {
            if (this.previousGameObjects == null) {
                this.previousGameObjects = new net.runelite.api.GameObject[5];
            }

            net.runelite.api.GameObject var2 = this.previousGameObjects[var1];
            RSGameObject var3 = (RSGameObject) this.getGameObjects()[var1];
            net.runelite.api.GameObject var4 = lastGameObject;
            lastGameObject = var3;
            this.previousGameObjects[var1] = var3;
            if (var3 == null || !var3.equals(var4)) {
                if (var3 == null || !(var3.getRenderable() instanceof Actor)) {
                    if (var3 == null && var2 != null) {
                        GameObjectDespawned var7 = new GameObjectDespawned();
                        var7.setTile(this);
                        var7.setGameObject(var2);
                        class166.clientInstance.getCallbacks().post(var7);
                    } else if (var3 != null && var2 == null) {
                        GameObjectSpawned var6 = new GameObjectSpawned();
                        var6.setTile(this);
                        var6.setGameObject(var3);
                        class166.clientInstance.getCallbacks().post(var6);
                    } else if (var3 != null && var2 != null) {
                        GameObjectChanged var5 = new GameObjectChanged();
                        var5.setTile(this);
                        var5.setPrevious(var2);
                        var5.setGameObject(var3);
                        class166.clientInstance.getCallbacks().post(var5);
                    }
                }

            }
        }
    }

    public net.runelite.api.GameObject[] getGameObjects() {
        return this.objects;
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    @Export("wallObjectChanged")
    public void wallObjectChanged(int var1) {
        net.runelite.api.WallObject var2 = this.previousWallObject;
        net.runelite.api.WallObject var3 = this.getWallObject();
        this.previousWallObject = var3;
        if (var3 == null && var2 != null) {
            WallObjectDespawned var6 = new WallObjectDespawned();
            var6.setTile(this);
            var6.setWallObject(var2);
            class166.clientInstance.getCallbacks().post(var6);
        } else if (var3 != null && var2 == null) {
            WallObjectSpawned var5 = new WallObjectSpawned();
            var5.setTile(this);
            var5.setWallObject(var3);
            class166.clientInstance.getCallbacks().post(var5);
        } else if (var3 != null && var2 != null) {
            WallObjectChanged var4 = new WallObjectChanged();
            var4.setTile(this);
            var4.setPrevious(var2);
            var4.setWallObject(var3);
            class166.clientInstance.getCallbacks().post(var4);
        }

    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    @Export("decorativeObjectChanged")
    public void decorativeObjectChanged(int var1) {
        net.runelite.api.DecorativeObject var2 = this.previousDecorativeObject;
        net.runelite.api.DecorativeObject var3 = this.getDecorativeObject();
        this.previousDecorativeObject = var3;
        if (var3 == null && var2 != null) {
            DecorativeObjectDespawned var6 = new DecorativeObjectDespawned();
            var6.setTile(this);
            var6.setDecorativeObject(var2);
            class166.clientInstance.getCallbacks().post(var6);
        } else if (var3 != null && var2 == null) {
            DecorativeObjectSpawned var5 = new DecorativeObjectSpawned();
            var5.setTile(this);
            var5.setDecorativeObject(var3);
            class166.clientInstance.getCallbacks().post(var5);
        } else if (var3 != null && var2 != null) {
            DecorativeObjectChanged var4 = new DecorativeObjectChanged();
            var4.setTile(this);
            var4.setPrevious(var2);
            var4.setDecorativeObject(var3);
            class166.clientInstance.getCallbacks().post(var4);
        }

    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    @Export("groundObjectChanged")
    public void groundObjectChanged(int var1) {
        net.runelite.api.GroundObject var2 = this.previousGroundObject;
        net.runelite.api.GroundObject var3 = this.getGroundObject();
        this.previousGroundObject = var3;
        if (var3 == null && var2 != null) {
            GroundObjectDespawned var6 = new GroundObjectDespawned();
            var6.setTile(this);
            var6.setGroundObject(var2);
            class166.clientInstance.getCallbacks().post(var6);
        } else if (var3 != null && var2 == null) {
            GroundObjectSpawned var5 = new GroundObjectSpawned();
            var5.setTile(this);
            var5.setGroundObject(var3);
            class166.clientInstance.getCallbacks().post(var5);
        } else if (var3 != null && var2 != null) {
            GroundObjectChanged var4 = new GroundObjectChanged();
            var4.setTile(this);
            var4.setPrevious(var2);
            var4.setGroundObject(var3);
            class166.clientInstance.getCallbacks().post(var4);
        }

    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    @Export("itemLayerChanged")
    public void itemLayerChanged(int var1) {
        int var2 = this.getX();
        int var3 = this.getY();
        int var4 = class166.clientInstance.getPlane();
        RSDeque[][][] var5 = class166.clientInstance.getGroundItemDeque();
        RSDeque var6 = lastGroundItems[var4][var2][var3];
        RSDeque var7 = var5[var4][var2][var3];
        ItemDespawned var11;
        if (var6 != var7) {
            if (var6 != null) {
                RSNode var8 = var6.getHead();

                for (RSNode var9 = var8.getNext(); var9 != var8; var9 = var9.getNext()) {
                    RSItem var10 = (RSItem) var9;
                    var11 = new ItemDespawned(this, var10);
                    class166.clientInstance.getCallbacks().post(var11);
                }
            }

            lastGroundItems[var4][var2][var3] = var7;
        }

        RSItem var18 = class166.clientInstance.getLastItemDespawn();
        if (var18 != null) {
            class166.clientInstance.setLastItemDespawn((RSItem) null);
        }

        RSItemLayer var19 = (RSItemLayer) this.getItemLayer();
        if (var19 == null) {
            if (var18 != null) {
                ItemDespawned var20 = new ItemDespawned(this, var18);
                class166.clientInstance.getCallbacks().post(var20);
            }

        } else if (var7 == null) {
            if (var18 != null) {
                var11 = new ItemDespawned(this, var18);
                class166.clientInstance.getCallbacks().post(var11);
            }

        } else {
            RSNode var21 = var7.getHead();
            Object var12 = null;
            RSNode var13 = var21.getPrevious();
            boolean var14 = false;
            if (var21 != var13) {
                RSItem var15 = (RSItem) var13;
                if (var2 != var15.getX() || var3 != var15.getY()) {
                    var12 = var15;
                }
            }

            RSNode var22 = var21.getNext();
            RSItem var16;
            if (var12 == null && var21 != var22) {
                var16 = (RSItem) var22;
                if (var2 != var16.getX() || var3 != var16.getY()) {
                    var12 = var16;
                    var14 = true;
                }
            }

            if (var18 != null && var18 != var13 && var18 != var22) {
                ItemDespawned var23 = new ItemDespawned(this, var18);
                class166.clientInstance.getCallbacks().post(var23);
            }

            if (var12 != null) {
                do {
                    var16 = (RSItem) var12;
                    var16.setX(var2);
                    var16.setY(var3);
                    ItemSpawned var17 = new ItemSpawned(this, var16);
                    class166.clientInstance.getCallbacks().post(var17);
                    var12 = var14 ? ((RSNode) var12).getNext() : ((RSNode) var12).getPrevious();
                } while (var12 != var21 && (((RSItem) var12).getX() != var2 || ((RSItem) var12).getY() != var3));

            }
        }
    }

    @Export("getSceneLocation")
    public Point getSceneLocation() {
        return new Point(this.getX(), this.getY());
    }

    @Export("getWorldLocation")
    public WorldPoint getWorldLocation() {
        return WorldPoint.fromScene(class166.clientInstance, this.getX(), this.getY(), this.getPlane());
    }

    @Export("getLocalLocation")
    public LocalPoint getLocalLocation() {
        return LocalPoint.fromScene(this.getX(), this.getY());
    }

    @Export("hasLineOfSightTo")
    public boolean hasLineOfSightTo(net.runelite.api.Tile var1) {
        if (this.getPlane() != var1.getPlane()) {
            return false;
        } else {
            net.runelite.api.CollisionData[] var2 = class166.clientInstance.getCollisionMaps();
            if (var2 == null) {
                return false;
            } else {
                int var3 = this.getPlane();
                int[][] var4 = var2[var3].getFlags();
                Point var5 = this.getSceneLocation();
                Point var6 = var1.getSceneLocation();
                if (var5.getX() == var6.getX() && var5.getY() == var6.getY()) {
                    return true;
                } else {
                    int var7 = var6.getX() - var5.getX();
                    int var8 = var6.getY() - var5.getY();
                    int var9 = Math.abs(var7);
                    int var10 = Math.abs(var8);
                    int var11 = 131072;
                    int var12 = 131072;
                    if (var7 < 0) {
                        var11 |= 4096;
                    } else {
                        var11 |= 65536;
                    }

                    if (var8 < 0) {
                        var12 |= 1024;
                    } else {
                        var12 |= 16384;
                    }

                    int var13;
                    int var14;
                    int var15;
                    int var16;
                    int var17;
                    int var18;
                    if (var9 > var10) {
                        var13 = var5.getX();
                        var14 = var5.getY() << 16;
                        var15 = (var8 << 16) / var9;
                        var14 += 32768;
                        if (var8 < 0) {
                            --var14;
                        }

                        var16 = var7 < 0 ? -1 : 1;

                        while (var13 != var6.getX()) {
                            var13 += var16;
                            var17 = var14 >>> 16;
                            if ((var4[var13][var17] & var11) != 0) {
                                return false;
                            }

                            var14 += var15;
                            var18 = var14 >>> 16;
                            if (var18 != var17 && (var4[var13][var18] & var12) != 0) {
                                return false;
                            }
                        }
                    } else {
                        var13 = var5.getY();
                        var14 = var5.getX() << 16;
                        var15 = (var7 << 16) / var10;
                        var14 += 32768;
                        if (var7 < 0) {
                            --var14;
                        }

                        var16 = var8 < 0 ? -1 : 1;

                        while (var13 != var6.getY()) {
                            var13 += var16;
                            var17 = var14 >>> 16;
                            if ((var4[var17][var13] & var12) != 0) {
                                return false;
                            }

                            var14 += var15;
                            var18 = var14 >>> 16;
                            if (var18 != var17 && (var4[var18][var13] & var11) != 0) {
                                return false;
                            }
                        }
                    }

                    return true;
                }
            }
        }
    }

    @Export("getGroundItems")
    public List getGroundItems() {
        net.runelite.api.ItemLayer var1 = this.getItemLayer();
        if (var1 == null) {
            return null;
        } else {
            ArrayList var2 = new ArrayList();

            for (Object var3 = var1.getBottom(); var3 instanceof net.runelite.api.Item; var3 = ((net.runelite.api.Node) var3).getNext()) {
                var2.add((net.runelite.api.Item) var3);
            }

            return var2;
        }
    }

    @Export("getRenderLevel")
    public int getRenderLevel() {
        return this.renderLevel;
    }

    public net.runelite.api.SceneTilePaint getSceneTilePaint() {
        return this.paint;
    }

    public net.runelite.api.SceneTileModel getSceneTileModel() {
        return this.overlay;
    }

    @Export("getFlags")
    public int getFlags() {
        return this.flags;
    }

    @Export("getPhysicalLevel")
    public int getPhysicalLevel() {
        return this.physicalLevel;
    }

    @Export("setDraw")
    public void setDraw(boolean var1) {
        this.draw = var1;
    }

    @Export("isDraw")
    public boolean isDraw() {
        return this.draw;
    }

    @Export("setVisible")
    public void setVisible(boolean var1) {
        this.visible = var1;
    }

    @Export("isVisible")
    public boolean isVisible() {
        return this.visible;
    }

    @Export("setDrawEntities")
    public void setDrawEntities(boolean var1) {
        this.drawEntities = var1;
    }

    @Export("setWallCullDirection")
    public void setWallCullDirection(int var1) {
        this.wallCullDirection = var1;
    }

    @Export("getBridge")
    public RSTile getBridge() {
        return this.bridge;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;IS)Ljava/lang/String;",
            garbageValue = "3996"
    )
    static String method4296(Packet var0, int var1) {
        try {
            int var2 = var0.readUSmart();
            if (var2 > var1) {
                var2 = var1;
            }

            byte[] var3 = new byte[var2];
            var0.offset += class331.huffman.method4771(var0.payload, var0.offset, var3, 0, var2);
            String var4 = Isaac.method4024(var3, 0, var2);
            return var4;
        } catch (Exception var6) {
            return "Cabbage";
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(S)J",
            garbageValue = "3133"
    )
    public static synchronized long method4297() {
        long var0 = System.currentTimeMillis();
        if (var0 < class11.field2420) {
            class11.field2419 += class11.field2420 - var0;
        }

        class11.field2420 = var0;
        return class11.field2419 + var0;
    }
}
