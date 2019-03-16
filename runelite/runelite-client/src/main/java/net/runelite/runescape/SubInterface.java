package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWidgetNode;

@ObfuscatedName("bp")
@Implements("SubInterface")
public class SubInterface extends Node implements RSWidgetNode {
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -669718059
    )
    int mode;
    @ObfuscatedName("e")
    boolean field555;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 2064335519
    )
    int id;

    SubInterface() {
        this.field555 = false;
    }

    public int getId() {
        return this.id;
    }

    @ObfuscatedName("m")
    public static int method2437(long var0) {
        return (int) (var0 >>> 17 & 4294967295L);
    }

    @ObfuscatedName("jp")
    @ObfuscatedSignature(
            signature = "(IIIILls;Lhx;I)V",
            garbageValue = "1982591191"
    )
    static final void method2438(int var0, int var1, int var2, int var3, SpritePixels var4, class96 var5) {
        if (var4 != null) {
            int var6 = client.mapAngle & 2047;
            int var7 = var3 * var3 + var2 * var2;
            if (var7 <= 6400) {
                int var8 = Graphics3D.SINE[var6];
                int var9 = Graphics3D.COSINE[var6];
                int var10 = var9 * var2 + var3 * var8 >> 16;
                int var11 = var3 * var9 - var8 * var2 >> 16;
                if (var7 > 2500) {
                    var4.method2268(var10 + var5.field2626 / 2 - var4.maxWidth / 2, var5.field2621 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2626, var5.field2621, var5.field2623, var5.field2622);
                } else {
                    var4.method2253(var0 + var10 + var5.field2626 / 2 - var4.maxWidth / 2, var5.field2621 / 2 + var1 - var11 - var4.maxHeight / 2);
                }

            }
        }
    }

    @ObfuscatedName("ky")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
            garbageValue = "0"
    )
    static String method2436(String var0, boolean var1) {
        String var2 = var1 ? "https://" : "http://";
        if (client.socketType == 1) {
            var0 = var0 + "-wtrc";
        } else if (client.socketType == 2) {
            var0 = var0 + "-wtqa";
        } else if (client.socketType == 3) {
            var0 = var0 + "-wtwip";
        } else if (client.socketType == 5) {
            var0 = var0 + "-wti";
        } else if (client.socketType == 4) {
            var0 = "local";
        }

        String var3 = "";
        if (class116.sessionToken != null) {
            var3 = "/p=" + class116.sessionToken;
        }

        String var4 = "runescape.com";
        return var2 + var0 + "." + var4 + "/l=" + client.languageId + "/a=" + client.field650 + var3 + "/";
    }

    @ObfuscatedName("hp")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "-1996878906"
    )
    static void method2435(int var0, int var1) {
        int var2 = class288.fontBold12.method1775("Choose Option");

        int var3;
        int var4;
        for (var3 = 0; var3 < client.menuOptionCount; ++var3) {
            var4 = class288.fontBold12.method1775(class115.method2003(var3));
            if (var4 > var2) {
                var2 = var4;
            }
        }

        var2 += 8;
        var3 = client.menuOptionCount * 15 + 22;
        var4 = var0 - var2 / 2;
        if (var4 + var2 > FriendManager.canvasWidth) {
            var4 = FriendManager.canvasWidth - var2;
        }

        if (var4 < 0) {
            var4 = 0;
        }

        int var5 = var1;
        if (var1 + var3 > class230.canvasHeight) {
            var5 = class230.canvasHeight - var3;
        }

        if (var5 < 0) {
            var5 = 0;
        }

        class288.menuX = var4;
        class106.menuY = var5;
        class9.field1113 = var2;
        class31.field1838 = client.menuOptionCount * 15 + 22;
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-27"
    )
    public static void method2439() {
        PlayerComposition.field2636.method952();
    }
}
