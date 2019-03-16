package net.runelite.runescape;

import net.runelite.api.GrandExchangeOfferState;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGrandExchangeOffer;

@ObfuscatedName("c")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer implements RSGrandExchangeOffer {
    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "Lhh;"
    )
    public static Track1 field39;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index ItemDefinition_modelIndexCache;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 1721558647
    )
    public int spent;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -1538626863
    )
    public int itemId;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1891512287
    )
    public int price;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -2085806687
    )
    public int totalQuantity;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -1048697559
    )
    public int quantitySold;
    @ObfuscatedName("g")
    byte state;

    public GrandExchangeOffer() {
    }

    @ObfuscatedSignature(
            signature = "(Lgl;Z)V",
            garbageValue = "0"
    )
    public GrandExchangeOffer(Packet var1, boolean var2) {
        this.state = var1.method6240();
        this.itemId = var1.readUnsignedShort();
        this.price = var1.getInt();
        this.totalQuantity = var1.getInt();
        this.quantitySold = var1.getInt();
        this.spent = var1.getInt();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "33"
    )
    public int method2871() {
        return this.state & 7;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-87060706"
    )
    public int method2872() {
        return (this.state & 8) == 8 ? 1 : 0;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-2026990615"
    )
    void method2887(int var1) {
        this.state &= -8;
        this.state = (byte) (this.state | var1 & 7);
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "-95"
    )
    void method2869(int var1) {
        this.state &= -9;
        if (var1 == 1) {
            this.state = (byte) (this.state | 8);
        }

    }

    public byte getRSState() {
        return this.state;
    }

    public int getQuantitySold() {
        return this.quantitySold;
    }

    public int getTotalQuantity() {
        return this.totalQuantity;
    }

    public GrandExchangeOfferState getState() {
        byte var1 = this.getRSState();
        boolean var2 = (var1 & 8) == 8;
        boolean var3 = (var1 & 4) == 4;
        return var1 == 0 ? GrandExchangeOfferState.EMPTY : (var3 && this.getQuantitySold() < this.getTotalQuantity() ? (var2 ? GrandExchangeOfferState.CANCELLED_SELL : GrandExchangeOfferState.CANCELLED_BUY) : (var2 ? (var3 ? GrandExchangeOfferState.SOLD : GrandExchangeOfferState.SELLING) : (var3 ? GrandExchangeOfferState.BOUGHT : GrandExchangeOfferState.BUYING)));
    }

    public int getItemId() {
        return this.itemId;
    }

    public int getPrice() {
        return this.price;
    }

    public int getSpent() {
        return this.spent;
    }

    @ObfuscatedName("kb")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)V",
            garbageValue = "-1815800189"
    )
    static final void method2874(String var0) {
        if (TotalQuantityComparator.clanMemberManager != null) {
            TcpConnectionMessage var1 = FaceNormal.method5726(ClientProt.CLAN_KICKUSER, client.serverConnection.isaac);
            var1.packetBuffer.putByte(AbstractSoundSystem.method338(var0));
            var1.packetBuffer.method6198(var0);
            client.serverConnection.method5881(var1);
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "-139350520"
    )
    static int method2886(int var0, int var1) {
        ItemContainer var2 = (ItemContainer) ItemContainer.itemContainers.method380((long) var0);
        return var2 == null ? -1 : (var1 >= 0 && var1 < var2.itemIds.length ? var2.itemIds[var1] : -1);
    }
}
