package net.runelite.runescape;

import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDecorativeObject;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSRenderable;

import java.awt.*;
import java.awt.geom.Area;

@ObfuscatedName("eu")
@Implements("DecorativeObject")
public final class DecorativeObject implements RSDecorativeObject {
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 812989961
    )
    int offsetX;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 1521487609
    )
    int x;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 496741139
    )
    int y;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            signature = "Ldd;"
    )
    public Entity entity1;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -1551737045
    )
    int renderFlag;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -119235577
    )
    int renderInfoBitPacked;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -1696947891
    )
    int offsetY;
    @ObfuscatedName("n")
    @ObfuscatedSignature(
            signature = "Ldd;"
    )
    public Entity entity2;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 623941603
    )
    int rotation;
    public int decorativeObjectPlane;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            longValue = 7113371623354119133L
    )
    public long hash;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 1652165997
    )
    int floor;

    DecorativeObject() {
        this.hash = 0L;
        this.renderInfoBitPacked = 0;
    }

    public Point getCanvasLocation(int var1) {
        return Perspective.localToCanvas(class166.clientInstance, this.getLocalLocation(), this.getPlane(), var1);
    }

    public long getHash() {
        return this.hash;
    }

    public RSModel getModel() {
        RSRenderable var1 = this.getRenderable();
        if (var1 == null) {
            return null;
        } else {
            RSModel var2;
            if (var1 instanceof net.runelite.api.Model) {
                var2 = (RSModel) var1;
            } else {
                var2 = var1.getModel();
            }

            return var2;
        }
    }

    public RSRenderable getRenderable() {
        return this.entity1;
    }

    public int getX() {
        return this.x;
    }

    public LocalPoint getLocalLocation() {
        return new LocalPoint(this.getX(), this.getY());
    }

    public int getY() {
        return this.y;
    }

    public int getOrientation() {
        return this.rotation;
    }

    public int getPlane() {
        return this.decorativeObjectPlane;
    }

    public void setPlane(int var1) {
        this.decorativeObjectPlane = var1;
    }

    public Area getClickbox() {
        return Perspective.getClickbox(class166.clientInstance, this.getModel(), this.getOrientation(), this.getLocalLocation());
    }

    public Polygon getConvexHull() {
        RSModel var1 = this.getModel();
        return var1 == null ? null : var1.getConvexHull(this.getX(), this.getY(), this.getOrientation());
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

    public RSRenderable getRenderable2() {
        return this.entity2;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "0"
    )
    public static void method5024(int var0) {
        if (class120.field2529 != 0) {
            class186.field3851 = var0;
        } else {
            class267.field2461.method4879(var0);
        }

    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(Lbe;Lbe;IZI)I",
            garbageValue = "-565177887"
    )
    static int method5023(World var0, World var1, int var2, boolean var3) {
        if (var2 == 1) {
            int var4 = var0.playerCount;
            int var5 = var1.playerCount;
            if (!var3) {
                if (var4 == -1) {
                    var4 = 2001;
                }

                if (var5 == -1) {
                    var5 = 2001;
                }
            }

            return var4 - var5;
        } else {
            return var2 == 2 ? var0.location - var1.location : (var2 == 3 ? (var0.activity.equals("-") ? (var1.activity.equals("-") ? 0 : (var3 ? -1 : 1)) : (var1.activity.equals("-") ? (var3 ? 1 : -1) : var0.activity.compareTo(var1.activity))) : (var2 == 4 ? (var0.method3766() ? (var1.method3766() ? 0 : 1) : (var1.method3766() ? -1 : 0)) : (var2 == 5 ? (var0.method3769() ? (var1.method3769() ? 0 : 1) : (var1.method3769() ? -1 : 0)) : (var2 == 6 ? (var0.method3722() ? (var1.method3722() ? 0 : 1) : (var1.method3722() ? -1 : 0)) : (var2 == 7 ? (var0.method3719() ? (var1.method3719() ? 0 : 1) : (var1.method3719() ? -1 : 0)) : var0.id - var1.id)))));
        }
    }
}
