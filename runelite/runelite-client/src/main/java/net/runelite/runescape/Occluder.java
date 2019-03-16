package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("Occluder")
public final class Occluder {
    @ObfuscatedName("f")
    @ObfuscatedGetter(
            intValue = 540645209
    )
    int maxNormalY;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 1030991453
    )
    int minX;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = 405620347
    )
    int maxNormalX;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -1340784751
    )
    int maxTIleX;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -64947147
    )
    int minTileZ;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = -1726630277
    )
    int minZ;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -1584335085
    )
    int maxTileZ;
    @ObfuscatedName("x")
    @ObfuscatedGetter(
            intValue = -1182015331
    )
    int minNormalX;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = 620452521
    )
    int testDirection;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -789725613
    )
    int maxY;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 322686953
    )
    int maxX;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = 392608351
    )
    int maxZ;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 702836457
    )
    int type;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 1261788411
    )
    int minY;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = -693292763
    )
    int field1863;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = -1810033401
    )
    int field1875;
    @ObfuscatedName("h")
    @ObfuscatedGetter(
            intValue = -1438211613
    )
    int minNormalY;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 64804221
    )
    int minTileX;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(IB)I",
            garbageValue = "111"
    )
    public static int method4634(int var0) {
        return var0 > 0 ? 1 : (var0 < 0 ? -1 : 0);
    }

    @ObfuscatedName("hi")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1996217068"
    )
    static void method4635() {
        if (client.spellSelected) {
            ComponentType var0 = class192.method3785(class174.field3796, client.field799);
            if (var0 != null && var0.onTargetLeaveListener != null) {
                ScriptEvent var1 = new ScriptEvent();
                var1.source = var0;
                var1.params = var0.onTargetLeaveListener;
                class73.method1124(var1);
            }

            client.spellSelected = false;
            class208.method4144(var0);
        }
    }

    @ObfuscatedName("ft")
    @ObfuscatedSignature(
            signature = "(IZZZB)Lih;",
            garbageValue = "79"
    )
    static Js5 method4632(int var0, boolean var1, boolean var2, boolean var3) {
        IndexFile var4 = null;
        if (class166.cacheDat != null) {
            var4 = new IndexFile(var0, class166.cacheDat, class166.cacheIndex[var0], 1000000);
        }

        return new Js5(var4, class306.indexStore255, var0, var1, var2, var3);
    }

    @ObfuscatedName("jk")
    @ObfuscatedSignature(
            signature = "(Lhn;III)V",
            garbageValue = "468651930"
    )
    static final void method4633(ComponentType var0, int var1, int var2) {
        if (client.draggedWidget == null && !client.isMenuOpen) {
            if (var0 != null) {
                ComponentType var4 = ChatCrownType.method834(var0);
                if (var4 == null) {
                    var4 = var0.dragParent;
                }

                if (var4 != null) {
                    client.draggedWidget = var0;
                    var4 = ChatCrownType.method834(var0);
                    if (var4 == null) {
                        var4 = var0.dragParent;
                    }

                    client.field817 = var4;
                    client.field906 = var1;
                    client.field838 = var2;
                    class77.field2817 = 0;
                    client.draggingWidget = false;
                    client.draggingWidgetChanged(-1);
                    int var6 = client.menuOptionCount - 1;
                    if (var6 != -1) {
                        WorldComparator.method6482(var6);
                    }

                    return;
                }
            }

        }
    }
}
