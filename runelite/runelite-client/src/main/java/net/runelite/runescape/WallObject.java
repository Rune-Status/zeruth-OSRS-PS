package net.runelite.runescape;

import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSRenderable;
import net.runelite.rs.api.RSWallObject;

import java.awt.*;
import java.awt.geom.Area;
import java.io.IOException;

@ObfuscatedName("eb")
@Implements("WallObject")
public final class WallObject implements RSWallObject {
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Ldd;"
    )
    public Entity entity1;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -1660560955
    )
    int x;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1252000353
    )
    int y;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            longValue = 9104809330043936295L
    )
    public long hash;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 374361987
    )
    int orientationA;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Ldd;"
    )
    public Entity entity2;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -1817793527
    )
    int config;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 489908597
    )
    int orientationB;
    public int wallPlane;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1968744851
    )
    int floor;

    WallObject() {
        this.hash = 0L;
        this.config = 0;
    }

    public Point getCanvasLocation(int var1) {
        return Perspective.localToCanvas(class166.clientInstance, this.getLocalLocation(), this.getPlane(), var1);
    }

    public long getHash() {
        return this.hash;
    }

    public RSRenderable getRenderable1() {
        return this.entity1;
    }

    public RSRenderable getRenderable2() {
        return this.entity2;
    }

    public int getX() {
        return this.x;
    }

    public LocalPoint getLocalLocation() {
        return new LocalPoint(this.getX(), this.getY());
    }

    public net.runelite.api.Model getModelA() {
        RSRenderable var1 = this.getRenderable1();
        return var1 == null ? null : (var1 instanceof net.runelite.api.Model ? (net.runelite.api.Model) var1 : var1.getModel());
    }

    public int getY() {
        return this.y;
    }

    public int getPlane() {
        return this.wallPlane;
    }

    public int getOrientationA() {
        return this.orientationA;
    }

    public net.runelite.api.Model getModelB() {
        RSRenderable var1 = this.getRenderable2();
        return var1 == null ? null : (var1 instanceof net.runelite.api.Model ? (net.runelite.api.Model) var1 : var1.getModel());
    }

    public int getOrientationB() {
        return this.orientationB;
    }

    public void setPlane(int var1) {
        this.wallPlane = var1;
    }

    public Area getClickbox() {
        Area var1 = new Area();
        Area var2 = Perspective.getClickbox(class166.clientInstance, this.getModelA(), this.getOrientationA(), this.getLocalLocation());
        Area var3 = Perspective.getClickbox(class166.clientInstance, this.getModelB(), this.getOrientationB(), this.getLocalLocation());
        if (var2 == null && var3 == null) {
            return null;
        } else {
            if (var2 != null) {
                var1.add(var2);
            }

            if (var3 != null) {
                var1.add(var3);
            }

            return var1;
        }
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

    public int getConfig() {
        return this.config;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "42"
    )
    public static boolean method2814() {
        long var0 = Tile.method4297();
        int var2 = (int) (var0 - class258.field3260);
        class258.field3260 = var0;
        if (var2 > 200) {
            var2 = 200;
        }

        class258.field3272 += var2;
        if (class258.NetCache_pendingResponsesCount == 0 && class258.NetCache_pendingPriorityResponsesCount == 0 && class258.NetCache_pendingWritesCount == 0 && class258.NetCache_pendingPriorityWritesCount == 0) {
            return true;
        } else if (class258.NetCache_socket == null) {
            return false;
        } else {
            try {
                if (class258.field3272 > 30000) {
                    throw new IOException();
                } else {
                    FileRequest var3;
                    Packet var4;
                    while (class258.NetCache_pendingPriorityResponsesCount < 200 && class258.NetCache_pendingPriorityWritesCount > 0) {
                        var3 = (FileRequest) class258.NetCache_pendingPriorityWrites.method391();
                        var4 = new Packet(4);
                        var4.putByte(1);
                        var4.method6064((int) var3.hash);
                        class258.NetCache_socket.vmethod5623(var4.payload, 0, 4);
                        class258.NetCache_pendingPriorityResponses.method382(var3, var3.hash);
                        --class258.NetCache_pendingPriorityWritesCount;
                        ++class258.NetCache_pendingPriorityResponsesCount;
                    }

                    while (class258.NetCache_pendingResponsesCount < 200 && class258.NetCache_pendingWritesCount > 0) {
                        var3 = (FileRequest) class258.NetCache_pendingWritesQueue.method2519();
                        var4 = new Packet(4);
                        var4.putByte(0);
                        var4.method6064((int) var3.hash);
                        class258.NetCache_socket.vmethod5623(var4.payload, 0, 4);
                        var3.method419();
                        class258.NetCache_pendingResponses.method382(var3, var3.hash);
                        --class258.NetCache_pendingWritesCount;
                        ++class258.NetCache_pendingResponsesCount;
                    }

                    for (int var15 = 0; var15 < 100; ++var15) {
                        int var16 = class258.NetCache_socket.vmethod5598();
                        if (var16 < 0) {
                            throw new IOException();
                        }

                        if (var16 == 0) {
                            break;
                        }

                        class258.field3272 = 0;
                        byte var5 = 0;
                        if (class267.currentRequest == null) {
                            var5 = 8;
                        } else if (class258.field3276 == 0) {
                            var5 = 1;
                        }

                        int var6;
                        int var7;
                        int var8;
                        int var10;
                        if (var5 > 0) {
                            var6 = var5 - class258.NetCache_responseHeaderBuffer.offset;
                            if (var6 > var16) {
                                var6 = var16;
                            }

                            class258.NetCache_socket.vmethod5600(class258.NetCache_responseHeaderBuffer.payload, class258.NetCache_responseHeaderBuffer.offset, var6);
                            if (class258.field3279 != 0) {
                                for (var7 = 0; var7 < var6; ++var7) {
                                    class258.NetCache_responseHeaderBuffer.payload[var7 + class258.NetCache_responseHeaderBuffer.offset] ^= class258.field3279;
                                }
                            }

                            class258.NetCache_responseHeaderBuffer.offset += var6;
                            if (class258.NetCache_responseHeaderBuffer.offset < var5) {
                                break;
                            }

                            if (class267.currentRequest == null) {
                                class258.NetCache_responseHeaderBuffer.offset = 0;
                                var7 = class258.NetCache_responseHeaderBuffer.readUnsignedByte();
                                var8 = class258.NetCache_responseHeaderBuffer.readUnsignedShort();
                                int var9 = class258.NetCache_responseHeaderBuffer.readUnsignedByte();
                                var10 = class258.NetCache_responseHeaderBuffer.getInt();
                                long var11 = (long) (var8 + (var7 << 16));
                                FileRequest var13 = (FileRequest) class258.NetCache_pendingPriorityResponses.method380(var11);
                                IndexStoreActionHandler.field3246 = true;
                                if (var13 == null) {
                                    var13 = (FileRequest) class258.NetCache_pendingResponses.method380(var11);
                                    IndexStoreActionHandler.field3246 = false;
                                }

                                if (var13 == null) {
                                    throw new IOException();
                                }

                                int var14 = var9 == 0 ? 5 : 9;
                                class267.currentRequest = var13;
                                class258.NetCache_responseArchiveBuffer = new Packet(var10 + var14 + class267.currentRequest.padding);
                                class258.NetCache_responseArchiveBuffer.putByte(var9);
                                class258.NetCache_responseArchiveBuffer.method6230(var10);
                                class258.field3276 = 8;
                                class258.NetCache_responseHeaderBuffer.offset = 0;
                            } else if (class258.field3276 == 0) {
                                if (class258.NetCache_responseHeaderBuffer.payload[0] == -1) {
                                    class258.field3276 = 1;
                                    class258.NetCache_responseHeaderBuffer.offset = 0;
                                } else {
                                    class267.currentRequest = null;
                                }
                            }
                        } else {
                            var6 = class258.NetCache_responseArchiveBuffer.payload.length - class267.currentRequest.padding;
                            var7 = 512 - class258.field3276;
                            if (var7 > var6 - class258.NetCache_responseArchiveBuffer.offset) {
                                var7 = var6 - class258.NetCache_responseArchiveBuffer.offset;
                            }

                            if (var7 > var16) {
                                var7 = var16;
                            }

                            class258.NetCache_socket.vmethod5600(class258.NetCache_responseArchiveBuffer.payload, class258.NetCache_responseArchiveBuffer.offset, var7);
                            if (class258.field3279 != 0) {
                                for (var8 = 0; var8 < var7; ++var8) {
                                    class258.NetCache_responseArchiveBuffer.payload[class258.NetCache_responseArchiveBuffer.offset + var8] ^= class258.field3279;
                                }
                            }

                            class258.NetCache_responseArchiveBuffer.offset += var7;
                            class258.field3276 += var7;
                            if (var6 == class258.NetCache_responseArchiveBuffer.offset) {
                                if (class267.currentRequest.hash == 16711935L) {
                                    class316.NetCache_reference = class258.NetCache_responseArchiveBuffer;

                                    for (var8 = 0; var8 < 256; ++var8) {
                                        Js5 var17 = class258.NetCache_indexCaches[var8];
                                        if (var17 != null) {
                                            class316.NetCache_reference.offset = var8 * 8 + 5;
                                            var10 = class316.NetCache_reference.getInt();
                                            int var18 = class316.NetCache_reference.getInt();
                                            var17.method2658(var10, var18);
                                        }
                                    }
                                } else {
                                    class258.NetCache_crc.reset();
                                    class258.NetCache_crc.update(class258.NetCache_responseArchiveBuffer.payload, 0, var6);
                                    var8 = (int) class258.NetCache_crc.getValue();
                                    if (var8 != class267.currentRequest.crc) {
                                        try {
                                            class258.NetCache_socket.vmethod5603();
                                        } catch (Exception var20) {
                                            ;
                                        }

                                        ++class258.field3277;
                                        class258.NetCache_socket = null;
                                        class258.field3279 = (byte) ((int) (Math.random() * 255.0D + 1.0D));
                                        return false;
                                    }

                                    class258.field3277 = 0;
                                    class258.field3278 = 0;
                                    class267.currentRequest.index.method2643((int) (class267.currentRequest.hash & 65535L), class258.NetCache_responseArchiveBuffer.payload, 16711680L == (class267.currentRequest.hash & 16711680L), IndexStoreActionHandler.field3246);
                                }

                                class267.currentRequest.method6469();
                                if (IndexStoreActionHandler.field3246) {
                                    --class258.NetCache_pendingPriorityResponsesCount;
                                } else {
                                    --class258.NetCache_pendingResponsesCount;
                                }

                                class258.field3276 = 0;
                                class267.currentRequest = null;
                                class258.NetCache_responseArchiveBuffer = null;
                            } else {
                                if (class258.field3276 != 512) {
                                    break;
                                }

                                class258.field3276 = 0;
                            }
                        }
                    }

                    return true;
                }
            } catch (IOException var21) {
                try {
                    class258.NetCache_socket.vmethod5603();
                } catch (Exception var19) {
                    ;
                }

                ++class258.field3278;
                class258.NetCache_socket = null;
                return false;
            }
        }
    }
}
