package net.runelite.runescape;

import net.runelite.mapping.*;

import java.util.Comparator;

@ObfuscatedName("g")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = -1428173449
    )
    public static int field0;

    @Export("equals")
    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    public int compare(Object var1, Object var2) {
        return this.method6473((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Le;Le;I)I",
            garbageValue = "-1058596839"
    )
    int method6473(GrandExchangeEvent var1, GrandExchangeEvent var2) {
        return var1.world < var2.world ? -1 : (var2.world == var1.world ? 0 : 1);
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IB)Lik;",
            garbageValue = "43"
    )
    public static VarClientStringType method6472(int var0) {
        VarClientStringType var1 = (VarClientStringType) VarClientStringType.field3339.method951((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = VarClientStringType.field3340.method1516(15, var0, 1789634852);
            var1 = new VarClientStringType();
            if (var2 != null) {
                var1.method177(new Packet(var2));
            }

            VarClientStringType.field3339.method957(var1, (long) var0);
            return var1;
        }
    }

    @ObfuscatedName("jd")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1200659683"
    )
    static void method6483() {
        for (SubInterface var0 = (SubInterface) client.subInterfaces.method391(); var0 != null; var0 = (SubInterface) client.subInterfaces.method385()) {
            int var1 = var0.id;
            if (class232.method4564(var1)) {
                boolean var2 = true;
                ComponentType[] var3 = class36.interfaces[var1];

                int var4;
                for (var4 = 0; var4 < var3.length; ++var4) {
                    if (var3[var4] != null) {
                        var2 = var3[var4].isIf3;
                        break;
                    }
                }

                if (!var2) {
                    var4 = (int) var0.hash;
                    ComponentType var5 = WorldMapType1.method2440(var4);
                    if (var5 != null) {
                        class208.method4144(var5);
                    }
                }
            }
        }

    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)Lbe;",
            garbageValue = "-1801251816"
    )
    static World method6474() {
        World.field1014 = 0;
        return WorldMapRectangle.method124();
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(IIIZII)J",
            garbageValue = "-332050576"
    )
    public static long method6484(int var0, int var1, int var2, boolean var3, int var4) {
        long var5 = (long) ((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long) var4 & 4294967295L) << 17;
        if (var3) {
            var5 |= 65536L;
        }

        return var5;
    }

    @ObfuscatedName("ji")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1389110339"
    )
    static void method6482(int var0) {
        ScriptState.topContextMenuRow = new ContextMenuRow();
        ScriptState.topContextMenuRow.param0 = client.menuActionParams0[var0];
        ScriptState.topContextMenuRow.param1 = client.menuActionParams1[var0];
        ScriptState.topContextMenuRow.type = client.menuTypes[var0];
        ScriptState.topContextMenuRow.identifier = client.menuIdentifiers[var0];
        ScriptState.topContextMenuRow.option = client.menuOptions[var0];
    }
}
