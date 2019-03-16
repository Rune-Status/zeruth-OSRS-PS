package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
    @ObfuscatedName("qz")
    @ObfuscatedGetter(
            intValue = 950535133
    )
    static int field266;
    @ObfuscatedName("db")
    @ObfuscatedSignature(
            signature = "Lih;"
    )
    static Js5 vorbis;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 839230885
    )
    int field272;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 1138609309
    )
    int field267;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1663632963
    )
    int field268;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 1629117045
    )
    int field269;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 404408661
    )
    int field270;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 633169829
    )
    int field271;

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IIIB)Z",
            garbageValue = "-81"
    )
    public boolean vmethod5812(int var1, int var2, int var3) {
        return var1 >= this.field271 && var1 < this.field271 + this.field267 ? var2 >> 6 == this.field268 && var3 >> 6 == this.field269 : false;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IIB)Z",
            garbageValue = "79"
    )
    public boolean vmethod5811(int var1, int var2) {
        return var1 >> 6 == this.field270 && var2 >> 6 == this.field272;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(IIII)[I",
            garbageValue = "-1381851995"
    )
    public int[] vmethod5814(int var1, int var2, int var3) {
        if (!this.vmethod5812(var1, var2, var3)) {
            return null;
        } else {
            int[] var4 = new int[]{this.field270 * 64 - this.field268 * 64 + var2, var3 + (this.field272 * 64 - this.field269 * 64)};
            return var4;
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1802894795"
    )
    void method3136() {
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IIB)Lhz;",
            garbageValue = "-126"
    )
    public Coordinates vmethod5817(int var1, int var2) {
        if (!this.vmethod5811(var1, var2)) {
            return null;
        } else {
            int var3 = this.field268 * 64 - this.field270 * 64 + var1;
            int var4 = this.field269 * 64 - this.field272 * 64 + var2;
            return new Coordinates(this.field271, var3, var4);
        }
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-821481708"
    )
    public void vmethod5829(Packet var1) {
        this.field271 = var1.readUnsignedByte();
        this.field267 = var1.readUnsignedByte();
        this.field268 = var1.readUnsignedShort();
        this.field269 = var1.readUnsignedShort();
        this.field270 = var1.readUnsignedShort();
        this.field272 = var1.readUnsignedShort();
        this.method3136();
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lk;B)V",
            garbageValue = "-126"
    )
    public void vmethod5820(WorldMapData var1) {
        if (var1.minX > this.field270) {
            var1.minX = this.field270;
        }

        if (var1.field199 < this.field270) {
            var1.field199 = this.field270;
        }

        if (var1.minY > this.field272) {
            var1.minY = this.field272;
        }

        if (var1.field203 < this.field272) {
            var1.field203 = this.field272;
        }

    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "([BI)V",
            garbageValue = "996931143"
    )
    static synchronized void method3153(byte[] var0) {
        if (var0.length == 100 && class150.field2415 < 1000) {
            class150.field2414[++class150.field2415 - 1] = var0;
        } else if (var0.length == 5000 && class150.field2412 < 250) {
            class150.field2418[++class150.field2412 - 1] = var0;
        } else if (var0.length == 30000 && class150.field2413 < 50) {
            class150.field2416[++class150.field2413 - 1] = var0;
        } else {
            if (class309.field3737 != null) {
                for (int var1 = 0; var1 < class134.field253.length; ++var1) {
                    if (var0.length == class134.field253[var1] && class150.field2411[var1] < class309.field3737[var1].length) {
                        class309.field3737[var1][class150.field2411[var1]++] = var0;
                        return;
                    }
                }
            }

        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(IIIIB)V",
            garbageValue = "-42"
    )
    static void method3130(int var0, int var1, int var2, int var3) {
        ItemContainer var4 = (ItemContainer) ItemContainer.itemContainers.method380((long) var0);
        if (var4 == null) {
            var4 = new ItemContainer();
            ItemContainer.itemContainers.method382(var4, (long) var0);
        }

        if (var4.itemIds.length <= var1) {
            int[] var5 = new int[var1 + 1];
            int[] var6 = new int[var1 + 1];

            int var7;
            for (var7 = 0; var7 < var4.itemIds.length; ++var7) {
                var5[var7] = var4.itemIds[var7];
                var6[var7] = var4.stackSizes[var7];
            }

            for (var7 = var4.itemIds.length; var7 < var1; ++var7) {
                var5[var7] = -1;
                var6[var7] = 0;
            }

            var4.itemIds = var5;
            var4.stackSizes = var6;
            var4.stackSizesChanged(-1);
        }

        var4.itemIds[var1] = var2;
        var4.stackSizes[var1] = var3;
        var4.stackSizesChanged(var1);
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(ILiu;Ljava/lang/String;Ljava/lang/String;IZI)V",
            garbageValue = "507894573"
    )
    public static void method3154(int var0, Js5Index var1, String var2, String var3, int var4, boolean var5) {
        int var6 = var1.method1510(var2);
        int var7 = var1.method1532(var6, var3);
        class134.method2202(var0, var1, var6, var7, var4, var5);
    }

    @ObfuscatedName("gl")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "32"
    )
    static void method3151(int var0) {
        client.field870 = 0L;
        if (var0 >= 2) {
            client.isResized = true;
            client.resizeChanged(-1);
        } else {
            client.isResized = false;
            client.resizeChanged(-1);
        }

        if (WorldMapRectangle.method127() == 1) {
            class166.clientInstance.method3075(765, 503, (short) -4136);
        } else {
            class166.clientInstance.method3075(7680, 2160, (short) 5757);
        }

        if (client.gameState >= 25) {
            class48.method778();
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Liu;Liu;ZLkz;B)V",
            garbageValue = "31"
    )
    public static void method3155(Js5Index var0, Js5Index var1, boolean var2, Font var3) {
        ObjType.item_ref = var0;
        GrandExchangeOffer.ItemDefinition_modelIndexCache = var1;
        PlayerComposition.isMembersWorld = var2;
        class302.field3840 = ObjType.item_ref.method1574(10);
        class82.field1931 = var3;
    }
}
