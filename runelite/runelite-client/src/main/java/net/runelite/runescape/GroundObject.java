package net.runelite.runescape;

import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.mapping.*;
import net.runelite.rs.api.RSGroundObject;
import net.runelite.rs.api.RSRenderable;

import java.awt.*;
import java.awt.geom.Area;

@ObfuscatedName("dq")
@Implements("GroundObject")
public final class GroundObject implements RSGroundObject {
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 1156764199
    )
    @Export("renderInfoBitPacked")
    int renderInfoBitPacked;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 40244083
    )
    @Export("x")
    int x;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 31533849
    )
    @Export("y")
    int y;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Ldd;"
    )
    @Export("entity")
    public Entity entity;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            longValue = -1194098363387875825L
    )
    @Export("hash")
    public long hash;
    public int groundObjectPlane;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1632307547
    )
    @Export("floor")
    int floor;

    public Point getCanvasLocation(int var1) {
        return Perspective.localToCanvas(class166.clientInstance, this.getLocalLocation(), this.getPlane(), var1);
    }

    public long getHash() {
        return this.hash;
    }

    public RSRenderable getRenderable() {
        return this.entity;
    }

    public int getX() {
        return this.x;
    }

    public net.runelite.api.Model getModel() {
        RSRenderable var1 = this.getRenderable();
        return var1 == null ? null : (var1 instanceof net.runelite.api.Model ? (net.runelite.api.Model) var1 : var1.getModel());
    }

    public LocalPoint getLocalLocation() {
        return new LocalPoint(this.getX(), this.getY());
    }

    public int getY() {
        return this.y;
    }

    public int getPlane() {
        return this.groundObjectPlane;
    }

    public void setPlane(int var1) {
        this.groundObjectPlane = var1;
    }

    public Area getClickbox() {
        return Perspective.getClickbox(class166.clientInstance, this.getModel(), 0, this.getLocalLocation());
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

    @ObfuscatedName("gh")
    @ObfuscatedSignature(
            signature = "(ZI)V",
            garbageValue = "-1542277702"
    )
    static final void method4581(boolean var0) {
        for (int var1 = 0; var1 < client.highResolutionNpcCount; ++var1) {
            NPCEntity var2 = client.npcs[client.highResolutionNpcIndexes[var1]];
            if (var2 != null && var2.vmethod2900() && var2.type.isVisible == var0 && var2.type.method5838()) {
                int var3 = var2.x >> 7;
                int var4 = var2.y >> 7;
                if (var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
                    if (var2.size == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                        if (client.field740[var3][var4] == client.field741) {
                            continue;
                        }

                        client.field740[var3][var4] = client.field741;
                    }

                    long var5 = WorldComparator.method6484(0, 0, 1, !var2.type.isClickable, client.highResolutionNpcIndexes[var1]);
                    var2.field943 = client.gameCycle;
                    class131.sceneManager.method3830(class228.level, var2.x, var2.y, MilliTimer.method2824(var2.size * 64 - 64 + var2.x, var2.size * 64 - 64 + var2.y, class228.level), var2.size * 64 - 64 + 60, var2, var2.angle, var5, var2.field941);
                }
            }
        }

    }

    @ObfuscatedName("ip")
    @ObfuscatedSignature(
            signature = "(Lhn;III)V",
            garbageValue = "-1195551250"
    )
    static void method4582(ComponentType var0, int var1, int var2) {
        if (var0.posXmode == 0) {
            var0.x = var0.posX;
        } else if (var0.posXmode == 1) {
            var0.x = var0.posX + (var1 - var0.width) / 2;
        } else if (var0.posXmode == 2) {
            var0.x = var1 - var0.width - var0.posX;
        } else if (var0.posXmode == 3) {
            var0.x = var0.posX * var1 >> 14;
        } else if (var0.posXmode == 4) {
            var0.x = (var0.posX * var1 >> 14) + (var1 - var0.width) / 2;
        } else {
            var0.x = var1 - var0.width - (var0.posX * var1 >> 14);
        }

        if (var0.posYmode == 0) {
            var0.y = var0.posY;
            var0.onPositionChanged(-1);
        } else if (var0.posYmode == 1) {
            var0.y = (var2 - var0.height) / 2 + var0.posY;
            var0.onPositionChanged(-1);
        } else if (var0.posYmode == 2) {
            var0.y = var2 - var0.height - var0.posY;
            var0.onPositionChanged(-1);
        } else if (var0.posYmode == 3) {
            var0.y = var2 * var0.posY >> 14;
            var0.onPositionChanged(-1);
        } else if (var0.posYmode == 4) {
            var0.y = (var2 - var0.height) / 2 + (var2 * var0.posY >> 14);
            var0.onPositionChanged(-1);
        } else {
            var0.y = var2 - var0.height - (var2 * var0.posY >> 14);
            var0.onPositionChanged(-1);
        }

    }
}
