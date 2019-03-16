package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;
import java.awt.Desktop.Action;
import java.net.URI;
import java.net.URL;

@ObfuscatedName("eg")
@Implements("UrlRequest")
public class UrlRequest {
    @ObfuscatedName("qx")
    @ObfuscatedGetter(
            intValue = -799568725
    )
    static int field1926;
    @ObfuscatedName("ft")
    @ObfuscatedSignature(
            signature = "Let;"
    )
    static Task field1924;
    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "Lli;"
    )
    static IndexedSprite field1925;
    @ObfuscatedName("r")
    volatile boolean isDone0;
    @ObfuscatedName("e")
    volatile byte[] response0;
    @ObfuscatedName("g")
    final URL url;

    UrlRequest(URL var1) {
        this.url = var1;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)[B",
            garbageValue = "-36"
    )
    public byte[] method5564() {
        return this.response0;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1584029153"
    )
    public boolean method5569() {
        return this.isDone0;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "-1620029902"
    )
    static int method5565(int var0, int var1) {
        ItemContainer var2 = (ItemContainer) ItemContainer.itemContainers.method380((long) var0);
        return var2 == null ? 0 : (var1 >= 0 && var1 < var2.stackSizes.length ? var2.stackSizes[var1] : 0);
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(Lbe;I)V",
            garbageValue = "-555531433"
    )
    static void method5575(World var0) {
        if (var0.method3719() != client.isMembers) {
            client.isMembers = var0.method3719();
            boolean var1 = var0.method3719();
            if (var1 != PlayerComposition.isMembersWorld) {
                ServerConnection.method5888();
                PlayerComposition.isMembersWorld = var1;
            }
        }

        class113.host = var0.address;
        client.world = var0.id;
        client.flags = var0.mask;
        class220.port1 = client.socketType == 0 ? 43594 : var0.id + 40000;
        GrandExchangeEvent.port2 = client.socketType == 0 ? 443 : var0.id + 50000;
        class86.myWorldPort = class220.port1;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;ZZS)V",
            garbageValue = "2500"
    )
    public static void method5574(String var0, boolean var1, boolean var2) {
        if (var1) {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI(var0));
                    return;
                } catch (Exception var4) {
                    ;
                }
            }

            if (class219.field420.startsWith("win")) {
                class233.method4580(var0, 0, "openjs");
            } else if (class219.field420.startsWith("mac")) {
                class233.method4580(var0, 1, "openjs");
            } else {
                class233.method4580(var0, 2, "openjs");
            }
        } else {
            class233.method4580(var0, 3, "openjs");
        }

    }
}
