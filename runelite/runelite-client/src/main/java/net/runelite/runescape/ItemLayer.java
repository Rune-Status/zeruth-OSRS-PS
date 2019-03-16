package net.runelite.runescape;

import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSItemLayer;
import net.runelite.rs.api.RSRenderable;

import java.awt.*;
import java.awt.geom.Area;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

@ObfuscatedName("dt")
@Implements("ItemLayer")
public final class ItemLayer implements RSItemLayer {
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 727370075
    )
    static int field1513;
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Ldd;"
    )
    Entity top;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -1307830787
    )
    int x;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -896412033
    )
    int y;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = -635973513
    )
    int height;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Ldd;"
    )
    Entity bottom;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            longValue = 3257235868918752959L
    )
    long hash;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Ldd;"
    )
    Entity middle;
    public int itemLayerPlane;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1012722693
    )
    int tileHeight;

    public Point getCanvasLocation(int var1) {
        return Perspective.localToCanvas(class166.clientInstance, this.getLocalLocation(), this.getPlane(), var1);
    }

    public long getHash() {
        return this.hash;
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

    public int getPlane() {
        return this.itemLayerPlane;
    }

    public void setPlane(int var1) {
        this.itemLayerPlane = var1;
    }

    public Area getClickbox() {
        throw new UnsupportedOperationException();
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

    public RSRenderable getBottom() {
        return this.bottom;
    }

    public RSRenderable getMiddle() {
        return this.middle;
    }

    public RSRenderable getTop() {
        return this.top;
    }

    public int getHeight() {
        return this.height;
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(III)Z",
            garbageValue = "1752301276"
    )
    static final boolean method2793(int var0, int var1) {
        LocType var2 = class225.method4485(var0);
        if (var1 == 11) {
            var1 = 10;
        }

        if (var1 >= 5 && var1 <= 8) {
            var1 = 4;
        }

        return var2.method1739(var1);
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(JLjava/lang/String;I)I",
            garbageValue = "1442617160"
    )
    static final int method2792(long var0, String var2) {
        Random var3 = new Random();
        Packet var4 = new Packet(128);
        Packet var5 = new Packet(128);
        int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int) (var0 >> 32), (int) var0};
        var4.putByte(10);

        int var7;
        for (var7 = 0; var7 < 4; ++var7) {
            var4.method6230(var3.nextInt());
        }

        var4.method6230(var6[0]);
        var4.method6230(var6[1]);
        var4.method6067(var0);
        var4.method6067(0L);

        for (var7 = 0; var7 < 4; ++var7) {
            var4.method6230(var3.nextInt());
        }

        var4.method6170(class9.field1104, class9.field1109);
        var5.putByte(10);

        for (var7 = 0; var7 < 3; ++var7) {
            var5.method6230(var3.nextInt());
        }

        var5.method6067(var3.nextLong());
        var5.method6066(var3.nextLong());
        VarPlayerType.method5534(var5);
        var5.method6067(var3.nextLong());
        var5.method6170(class9.field1104, class9.field1109);
        var7 = AbstractSoundSystem.method338(var2);
        if (var7 % 8 != 0) {
            var7 += 8 - var7 % 8;
        }

        Packet var8 = new Packet(var7);
        var8.method6198(var2);
        var8.offset = var7;
        var8.method6097(var6);
        Packet var9 = new Packet(var5.offset + var4.offset + var8.offset + 5);
        var9.putByte(2);
        var9.putByte(var4.offset);
        var9.method6072(var4.payload, 0, var4.offset);
        var9.putByte(var5.offset);
        var9.method6072(var5.payload, 0, var5.offset);
        var9.putShort(var8.offset);
        var9.method6072(var8.payload, 0, var8.offset);
        byte[] var11 = var9.payload;
        String var10 = ChatLineBuffer.method1932(var11, 0, var11.length);
        String var12 = var10;

        try {
            URL var13 = new URL(SubInterface.method2436("services", false) + "m=accountappeal/login.ws");
            URLConnection var14 = var13.openConnection();
            var14.setDoInput(true);
            var14.setDoOutput(true);
            var14.setConnectTimeout(5000);
            OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
            var15.write("data2=" + class9.method142(var12) + "&dest=" + class9.method142("passwordchoice.ws"));
            var15.flush();
            InputStream var16 = var14.getInputStream();
            var9 = new Packet(new byte[1000]);

            do {
                int var17 = var16.read(var9.payload, var9.offset, 1000 - var9.offset);
                if (var17 == -1) {
                    var15.close();
                    var16.close();
                    String var18 = new String(var9.payload);
                    if (var18.startsWith("OFFLINE")) {
                        return 4;
                    } else if (var18.startsWith("WRONG")) {
                        return 7;
                    } else if (var18.startsWith("RELOAD")) {
                        return 3;
                    } else if (var18.startsWith("Not permitted for social network accounts.")) {
                        return 6;
                    } else {
                        var9.method6227(var6);

                        while (var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                            --var9.offset;
                        }

                        var18 = new String(var9.payload, 0, var9.offset);
                        if (PlayerEntity.method2935(var18)) {
                            UrlRequest.method5574(var18, true, false);
                            return 2;
                        } else {
                            return 5;
                        }
                    }
                }

                var9.offset += var17;
            } while (var9.offset < 1000);

            return 5;
        } catch (Throwable var19) {
            var19.printStackTrace();
            return 5;
        }
    }
}
