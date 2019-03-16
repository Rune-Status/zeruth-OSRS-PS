package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.util.LinkedList;

@ObfuscatedName("h")
public abstract class class310 {
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -271555773
    )
    int field148;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 1177948743
    )
    int field151;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1831434655
    )
    int field147;
    @ObfuscatedName("w")
    short[][][] field153;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 1629675391
    )
    int field149;
    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "[[[[Lt;"
    )
    WorldMapDecoration[][][][] decorations;
    @ObfuscatedName("b")
    short[][][] field152;
    @ObfuscatedName("n")
    byte[][][] field154;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 1789523387
    )
    int field150;
    @ObfuscatedName("i")
    byte[][][] field155;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 789142981
    )
    int field146;

    class310() {
        new LinkedList();
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "710652770"
    )
    int method5904(int var1, int var2) {
        return var1 >= 0 && var2 >= 0 ? (var1 < 64 && var2 < 64 ? this.field152[0][var1][var2] - 1 : -1) : -1;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(IILgl;IB)V",
            garbageValue = "104"
    )
    void method5903(int var1, int var2, Packet var3, int var4) {
        int var5 = ((var4 & 24) >> 3) + 1;
        boolean var6 = (var4 & 2) != 0;
        boolean var7 = (var4 & 4) != 0;
        this.field152[0][var1][var2] = (short) var3.readUnsignedByte();
        int var8;
        int var9;
        int var11;
        if (var6) {
            var8 = var3.readUnsignedByte();

            for (var9 = 0; var9 < var8; ++var9) {
                int var10 = var3.readUnsignedByte();
                if (var10 != 0) {
                    this.field153[var9][var1][var2] = (short) var10;
                    var11 = var3.readUnsignedByte();
                    this.field154[var9][var1][var2] = (byte) (var11 >> 2);
                    this.field155[var9][var1][var2] = (byte) (var11 & 3);
                }
            }
        }

        if (var7) {
            for (var8 = 0; var8 < var5; ++var8) {
                var9 = var3.readUnsignedByte();
                if (var9 != 0) {
                    WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

                    for (var11 = 0; var11 < var9; ++var11) {
                        int var12 = var3.method6207();
                        int var13 = var3.readUnsignedByte();
                        var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
                    }
                }
            }
        }

    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IILgl;I)V",
            garbageValue = "-979754326"
    )
    void method5901(int var1, int var2, Packet var3) {
        int var4 = var3.readUnsignedByte();
        if (var4 != 0) {
            if ((var4 & 1) != 0) {
                this.method5921(var1, var2, var3, var4);
            } else {
                this.method5903(var1, var2, var3, var4);
            }

        }
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(IILgl;II)V",
            garbageValue = "-109374768"
    )
    void method5921(int var1, int var2, Packet var3, int var4) {
        boolean var5 = (var4 & 2) != 0;
        if (var5) {
            this.field153[0][var1][var2] = (short) var3.readUnsignedByte();
        }

        this.field152[0][var1][var2] = (short) var3.readUnsignedByte();
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "836921053"
    )
    int method5924() {
        return this.field147;
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "-38"
    )
    int method5900() {
        return this.field149;
    }

    @ObfuscatedName("ek")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1194677662"
    )
    static void method5922(int var0) {
        if (var0 != client.gameState) {
            if (client.gameState == 0) {
                class166.clientInstance.method2998();
            }

            if (var0 == 20 || var0 == 40 || var0 == 45) {
                client.loginState = 0;
                client.field678 = 0;
                client.field679 = 0;
                client.field904.method2491(var0);
                if (var0 != 20) {
                    WorldMapManager.method945(false);
                }
            }

            if (var0 != 20 && var0 != 40 && class60.field524 != null) {
                class60.field524.vmethod5603();
                class60.field524 = null;
            }

            if (client.gameState == 25) {
                client.field700 = 0;
                client.field696 = 0;
                client.field697 = 1;
                client.field753 = 0;
                client.field909 = 1;
            }

            if (var0 != 5 && var0 != 10) {
                if (var0 == 20) {
                    WorldMapData.method1054(Size.binary, JagException.sprites, true, client.gameState == 11 ? 4 : 0);
                } else if (var0 == 11) {
                    WorldMapData.method1054(Size.binary, JagException.sprites, false, 4);
                } else if (class316.field1174) {
                    class316.field1149 = null;
                    class226.field3801 = null;
                    class116.runeSprites = null;
                    class316.field1145 = null;
                    class316.field1146 = null;
                    Varbit.logoSprite = null;
                    class316.titlemuteSprite = null;
                    class150.field2417 = null;
                    Frames.field1861 = null;
                    AttackOpPriority.field1137 = null;
                    CacheFile.slFlagSprites = null;
                    class113.slArrowSprites = null;
                    class98.slStarSprites = null;
                    class113.field77 = null;
                    class316.field1151 = null;
                    MouseRecorder.field583 = null;
                    class139.field2048 = null;
                    class4.field1047 = null;
                    OwnWorldComparator.field640 = null;
                    class284.field322 = null;
                    WorldMapDecoration.field182 = null;
                    WorldMapDecoration.field183 = null;
                    class170.method2866(2);
                    class311.method5933(true);
                    class316.field1174 = false;
                }
            } else {
                WorldMapData.method1054(Size.binary, JagException.sprites, true, 0);
            }

            client.gameState = var0;
            client.gameStateChanged(-1);
        }
    }

    @ObfuscatedName("kk")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1877553034"
    )
    static void method5902() {
        if (class82.field1933 != null) {
            client.field914 = client.gameCycle;
            class82.field1933.method4475();

            for (int var0 = 0; var0 < client.players.length; ++var0) {
                if (client.players[var0] != null) {
                    class82.field1933.method4474((client.players[var0].x >> 7) + class158.baseX, (client.players[var0].y >> 7) + class107.baseY);
                }
            }
        }

    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "2146209267"
    )
    public static int method5926(int var0) {
        int var1 = 0;
        if (var0 < 0 || var0 >= 65536) {
            var0 >>>= 16;
            var1 += 16;
        }

        if (var0 >= 256) {
            var0 >>>= 8;
            var1 += 8;
        }

        if (var0 >= 16) {
            var0 >>>= 4;
            var1 += 4;
        }

        if (var0 >= 4) {
            var0 >>>= 2;
            var1 += 2;
        }

        if (var0 >= 1) {
            var0 >>>= 1;
            ++var1;
        }

        return var0 + var1;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lfh;ZI)V",
            garbageValue = "61138025"
    )
    public static void method5927(class19 var0, boolean var1) {
        if (class258.NetCache_socket != null) {
            try {
                class258.NetCache_socket.vmethod5603();
            } catch (Exception var6) {
                ;
            }

            class258.NetCache_socket = null;
        }

        class258.NetCache_socket = var0;
        class311.method5933(var1);
        class258.NetCache_responseHeaderBuffer.offset = 0;
        class267.currentRequest = null;
        class258.NetCache_responseArchiveBuffer = null;
        class258.field3276 = 0;

        while (true) {
            FileRequest var2 = (FileRequest) class258.NetCache_pendingPriorityResponses.method391();
            if (var2 == null) {
                while (true) {
                    var2 = (FileRequest) class258.NetCache_pendingResponses.method391();
                    if (var2 == null) {
                        if (class258.field3279 != 0) {
                            try {
                                Packet var7 = new Packet(4);
                                var7.putByte(4);
                                var7.putByte(class258.field3279);
                                var7.putShort(0);
                                class258.NetCache_socket.vmethod5623(var7.payload, 0, 4);
                            } catch (IOException var5) {
                                try {
                                    class258.NetCache_socket.vmethod5603();
                                } catch (Exception var4) {
                                    ;
                                }

                                ++class258.field3278;
                                class258.NetCache_socket = null;
                            }
                        }

                        class258.field3272 = 0;
                        class258.field3260 = Tile.method4297();
                        return;
                    }

                    class258.NetCache_pendingWritesQueue.method2510(var2);
                    class258.NetCache_pendingWrites.method382(var2, var2.hash);
                    ++class258.NetCache_pendingWritesCount;
                    --class258.NetCache_pendingResponsesCount;
                }
            }

            class258.NetCache_pendingPriorityWrites.method382(var2, var2.hash);
            ++class258.NetCache_pendingPriorityWritesCount;
            --class258.NetCache_pendingPriorityResponsesCount;
        }
    }

    @ObfuscatedName("y")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "-394880618"
    )
    static int method5925(int var0, class106 var1, boolean var2) {
        ComponentType var3 = WorldMapType1.method2440(class48.intStack[--class228.intStackSize]);
        if (var0 == 2600) {
            class48.intStack[++class228.intStackSize - 1] = var3.scrollX;
            return 1;
        } else if (var0 == 2601) {
            class48.intStack[++class228.intStackSize - 1] = var3.scrollY;
            return 1;
        } else if (var0 == 2602) {
            class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3.text;
            return 1;
        } else if (var0 == 2603) {
            class48.intStack[++class228.intStackSize - 1] = var3.scrollWidth;
            return 1;
        } else if (var0 == 2604) {
            class48.intStack[++class228.intStackSize - 1] = var3.scrollHeight;
            return 1;
        } else if (var0 == 2605) {
            class48.intStack[++class228.intStackSize - 1] = var3.zoom2d;
            return 1;
        } else if (var0 == 2606) {
            class48.intStack[++class228.intStackSize - 1] = var3.xan2d;
            return 1;
        } else if (var0 == 2607) {
            class48.intStack[++class228.intStackSize - 1] = var3.zan2d;
            return 1;
        } else if (var0 == 2608) {
            class48.intStack[++class228.intStackSize - 1] = var3.yan2d;
            return 1;
        } else if (var0 == 2609) {
            class48.intStack[++class228.intStackSize - 1] = var3.trans;
            return 1;
        } else if (var0 == 2610) {
            class48.intStack[++class228.intStackSize - 1] = var3.field2699;
            return 1;
        } else if (var0 == 2611) {
            class48.intStack[++class228.intStackSize - 1] = var3.color;
            return 1;
        } else if (var0 == 2612) {
            class48.intStack[++class228.intStackSize - 1] = var3.field2693;
            return 1;
        } else if (var0 == 2613) {
            class48.intStack[++class228.intStackSize - 1] = var3.field2744.vmethod5358();
            return 1;
        } else if (var0 == 2614) {
            class48.intStack[++class228.intStackSize - 1] = var3.field2725 ? 1 : 0;
            return 1;
        } else {
            return 2;
        }
    }

    @ObfuscatedName("id")
    @ObfuscatedSignature(
            signature = "(IIIIII)V",
            garbageValue = "-2056806993"
    )
    static final void method5923(int var0, int var1, int var2, int var3, int var4) {
        class238.scrollbarSprites[0].method824(var0, var1);
        class238.scrollbarSprites[1].method824(var0, var3 + var1 - 16);
        Rasterizer2D.method449(var0, var1 + 16, 16, var3 - 32, client.field917);
        int var5 = var3 * (var3 - 32) / var4;
        if (var5 < 8) {
            var5 = 8;
        }

        int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
        Rasterizer2D.method449(var0, var6 + var1 + 16, 16, var5, client.field778);
        Rasterizer2D.method456(var0, var6 + var1 + 16, var5, client.field709);
        Rasterizer2D.method456(var0 + 1, var6 + var1 + 16, var5, client.field709);
        Rasterizer2D.method500(var0, var6 + var1 + 16, 16, client.field709);
        Rasterizer2D.method500(var0, var6 + var1 + 17, 16, client.field709);
        Rasterizer2D.method456(var0 + 15, var6 + var1 + 16, var5, client.field883);
        Rasterizer2D.method456(var0 + 14, var6 + var1 + 17, var5 - 1, client.field883);
        Rasterizer2D.method500(var0, var6 + var5 + var1 + 15, 16, client.field883);
        Rasterizer2D.method500(var0 + 1, var6 + var5 + var1 + 14, 15, client.field883);
    }
}
