package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;

@ObfuscatedName("cf")
@Implements("ServerConnection")
public class ServerConnection {
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Lge;"
    )
    Bit clientPacket;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgb;"
    )
    CombatInfoList packetBufferNodes;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1445060355
    )
    int field1290;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 2027408005
    )
    int currentPacketSize;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgl;"
    )
    Packet serverPacket;
    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "Lfz;"
    )
    ServerProt field1295;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -1285333479
    )
    int field1288;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Lfz;"
    )
    ServerProt currentPacket;
    @ObfuscatedName("n")
    boolean field1286;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Lgt;"
    )
    public Isaac isaac;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 558809275
    )
    int field1287;
    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "Lfz;"
    )
    ServerProt field1284;
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "Lfz;"
    )
    ServerProt field1278;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lfh;"
    )
    class19 rssocket;

    ServerConnection() {
        this.packetBufferNodes = new CombatInfoList();
        this.field1290 = 0;
        this.serverPacket = new Packet(5000);
        this.clientPacket = new Bit(40000);
        this.currentPacket = null;
        this.currentPacketSize = 0;
        this.field1286 = true;
        this.field1287 = 0;
        this.field1288 = 0;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "674114064"
    )
    final void method5875() throws IOException {
        if (this.rssocket != null && this.field1290 > 0) {
            this.serverPacket.offset = 0;

            while (true) {
                TcpConnectionMessage var1 = (TcpConnectionMessage) this.packetBufferNodes.method4329();
                if (var1 == null || var1.field2333 > this.serverPacket.payload.length - this.serverPacket.offset) {
                    this.rssocket.vmethod5623(this.serverPacket.payload, 0, this.serverPacket.offset);
                    this.field1288 = 0;
                    break;
                }

                this.serverPacket.method6072(var1.packetBuffer.payload, 0, var1.field2333);
                this.field1290 -= var1.field2333;
                var1.method6469();
                var1.packetBuffer.method6061();
                var1.method1131();
            }
        }

    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lfm;I)V",
            garbageValue = "-799086353"
    )
    public final void method5881(TcpConnectionMessage var1) {
        this.packetBufferNodes.method4348(var1);
        var1.field2333 = var1.packetBuffer.offset;
        var1.packetBuffer.offset = 0;
        this.field1290 += var1.field2333;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lfh;I)V",
            garbageValue = "-2117622518"
    )
    void method5877(class19 var1) {
        this.rssocket = var1;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(B)Lfh;",
            garbageValue = "110"
    )
    class19 method5880() {
        return this.rssocket;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "63"
    )
    void method5878() {
        if (this.rssocket != null) {
            this.rssocket.vmethod5603();
            this.rssocket = null;
        }

    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-10"
    )
    void method5879() {
        this.rssocket = null;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-413634361"
    )
    final void method5882() {
        this.packetBufferNodes.method4346();
        this.field1290 = 0;
    }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "15"
    )
    public static void method5888() {
        ObjType.items.method952();
        ObjType.itemModelCache.method952();
        ObjType.itemSpriteCache.method952();
    }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            signature = "(ILcx;ZB)I",
            garbageValue = "-109"
    )
    static int method5898(int var0, class106 var1, boolean var2) {
        ComponentType var3;
        if (var0 == 2700) {
            var3 = WorldMapType1.method2440(class48.intStack[--class228.intStackSize]);
            class48.intStack[++class228.intStackSize - 1] = var3.linkObjType;
            return 1;
        } else if (var0 == 2701) {
            var3 = WorldMapType1.method2440(class48.intStack[--class228.intStackSize]);
            if (var3.linkObjType != -1) {
                class48.intStack[++class228.intStackSize - 1] = var3.linkObjCount;
            } else {
                class48.intStack[++class228.intStackSize - 1] = 0;
            }

            return 1;
        } else if (var0 == 2702) {
            int var5 = class48.intStack[--class228.intStackSize];
            SubInterface var4 = (SubInterface) client.subInterfaces.method380((long) var5);
            if (var4 != null) {
                class48.intStack[++class228.intStackSize - 1] = 1;
            } else {
                class48.intStack[++class228.intStackSize - 1] = 0;
            }

            return 1;
        } else if (var0 == 2706) {
            class48.intStack[++class228.intStackSize - 1] = client.toplevel;
            return 1;
        } else {
            return 2;
        }
    }
}
