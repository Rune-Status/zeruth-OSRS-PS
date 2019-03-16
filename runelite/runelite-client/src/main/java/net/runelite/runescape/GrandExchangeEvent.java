package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
    @ObfuscatedName("ez")
    @ObfuscatedGetter(
            intValue = -651470897
    )
    static int port2;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            longValue = -6223239709977332663L
    )
    public final long field16;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lc;"
    )
    public final GrandExchangeOffer grandExchangeOffer;
    @ObfuscatedName("q")
    String string1;
    @ObfuscatedName("c")
    String string2;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 269597171
    )
    public final int world;

    @ObfuscatedSignature(
            signature = "(Lgl;BI)V"
    )
    GrandExchangeEvent(Packet var1, byte var2, int var3) {
        this.string1 = var1.readString();
        this.string2 = var1.readString();
        this.world = var1.readUnsignedShort();
        this.field16 = var1.method6084();
        int var4 = var1.getInt();
        int var5 = var1.getInt();
        this.grandExchangeOffer = new GrandExchangeOffer();
        this.grandExchangeOffer.method2887(2);
        this.grandExchangeOffer.method2869(var2);
        this.grandExchangeOffer.price = var4;
        this.grandExchangeOffer.totalQuantity = var5;
        this.grandExchangeOffer.quantitySold = 0;
        this.grandExchangeOffer.spent = 0;
        this.grandExchangeOffer.itemId = var3;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)Ljava/lang/String;",
            garbageValue = "-1458167475"
    )
    public String method807() {
        return this.string2;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)Ljava/lang/String;",
            garbageValue = "-1729189061"
    )
    public String method806() {
        return this.string1;
    }

    @ObfuscatedName("fg")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "613630657"
    )
    static void method812() {
        client.serverConnection.method5882();
        client.serverConnection.clientPacket.offset = 0;
        client.serverConnection.currentPacket = null;
        client.serverConnection.field1295 = null;
        client.serverConnection.field1284 = null;
        client.serverConnection.field1278 = null;
        client.serverConnection.currentPacketSize = 0;
        client.serverConnection.field1287 = 0;
        client.rebootTimer = 0;
        client.menuOptionCount = 0;
        client.onMenuOptionsChanged(-1);
        client.isMenuOpen = false;
        client.minimapRenderType = 0;
        client.destinationX = 0;

        int var0;
        for (var0 = 0; var0 < 2048; ++var0) {
            client.players[var0] = null;
            client.cachedPlayersChanged(var0);
        }

        class4.localPlayer = null;

        for (var0 = 0; var0 < client.npcs.length; ++var0) {
            NPCEntity var1 = client.npcs[var0];
            if (var1 != null) {
                var1.interacting = -1;
                var1.interactingChanged(-1);
                var1.field966 = false;
            }
        }

        Size.method4688();
        class310.method5922(30);

        for (var0 = 0; var0 < 100; ++var0) {
            client.field848[var0] = true;
        }

        class48.method778();
    }

    @ObfuscatedName("jr")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "0"
    )
    static final void method808() {
        class166.method2810();
        if (TotalQuantityComparator.clanMemberManager != null) {
            TotalQuantityComparator.clanMemberManager.method4644();
        }

    }
}
