package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
@Implements("TcpConnectionMessage")
public class TcpConnectionMessage extends Node {
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -789055411
    )
    static int field2335;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "[Lfm;"
    )
    static TcpConnectionMessage[] packetBufferNodes;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -724624983
    )
    int field2330;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lge;"
    )
    public Bit packetBuffer;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -250897465
    )
    public int field2333;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lfq;"
    )
    ClientProt clientPacket;

    static {
        packetBufferNodes = new TcpConnectionMessage[300];
        field2335 = 0;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(S)V",
            garbageValue = "3911"
    )
    public void method1131() {
        if (field2335 < packetBufferNodes.length) {
            packetBufferNodes[++field2335 - 1] = this;
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(Lge;IB)V",
            garbageValue = "83"
    )
    static void method1133(Bit var0, int var1) {
        boolean var2 = var0.getBits(1) == 1;
        if (var2) {
            class254.extendedInfoPlayerIndexes[++class254.extendedInfoPlayerCount - 1] = var1;
        }

        int var3 = var0.getBits(2);
        PlayerEntity var4 = client.players[var1];
        if (var3 == 0) {
            if (var2) {
                var4.field631 = false;
            } else if (client.localPlayerIndex == var1) {
                throw new RuntimeException();
            } else {
                class254.coords[var1] = (var4.field620 << 28) + (class107.baseY + var4.pathY[0] >> 13) + (class158.baseX + var4.pathX[0] >> 13 << 14);
                if (var4.facingCoord != -1) {
                    class254.facingCoords[var1] = var4.facingCoord;
                } else {
                    class254.facingCoords[var1] = var4.orientation;
                }

                class254.facingEntities[var1] = var4.interacting;
                client.players[var1] = null;
                client.cachedPlayersChanged(var1);
                if (var0.getBits(1) != 0) {
                    class106.method1881(var0, var1);
                }

            }
        } else {
            int var5;
            int var6;
            int var7;
            if (var3 == 1) {
                var5 = var0.getBits(3);
                var6 = var4.pathX[0];
                var7 = var4.pathY[0];
                if (var5 == 0) {
                    --var6;
                    --var7;
                } else if (var5 == 1) {
                    --var7;
                } else if (var5 == 2) {
                    ++var6;
                    --var7;
                } else if (var5 == 3) {
                    --var6;
                } else if (var5 == 4) {
                    ++var6;
                } else if (var5 == 5) {
                    --var6;
                    ++var7;
                } else if (var5 == 6) {
                    ++var7;
                } else if (var5 == 7) {
                    ++var6;
                    ++var7;
                }

                if (client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                    if (var2) {
                        var4.field631 = true;
                        var4.xInScene = var6;
                        var4.yInScene = var7;
                    } else {
                        var4.field631 = false;
                        var4.method2897(var6, var7, class254.moveSpeeds[var1]);
                    }
                } else {
                    var4.method2927(var6, var7);
                    var4.field631 = false;
                }

            } else if (var3 == 2) {
                var5 = var0.getBits(4);
                var6 = var4.pathX[0];
                var7 = var4.pathY[0];
                if (var5 == 0) {
                    var6 -= 2;
                    var7 -= 2;
                } else if (var5 == 1) {
                    --var6;
                    var7 -= 2;
                } else if (var5 == 2) {
                    var7 -= 2;
                } else if (var5 == 3) {
                    ++var6;
                    var7 -= 2;
                } else if (var5 == 4) {
                    var6 += 2;
                    var7 -= 2;
                } else if (var5 == 5) {
                    var6 -= 2;
                    --var7;
                } else if (var5 == 6) {
                    var6 += 2;
                    --var7;
                } else if (var5 == 7) {
                    var6 -= 2;
                } else if (var5 == 8) {
                    var6 += 2;
                } else if (var5 == 9) {
                    var6 -= 2;
                    ++var7;
                } else if (var5 == 10) {
                    var6 += 2;
                    ++var7;
                } else if (var5 == 11) {
                    var6 -= 2;
                    var7 += 2;
                } else if (var5 == 12) {
                    --var6;
                    var7 += 2;
                } else if (var5 == 13) {
                    var7 += 2;
                } else if (var5 == 14) {
                    ++var6;
                    var7 += 2;
                } else if (var5 == 15) {
                    var6 += 2;
                    var7 += 2;
                }

                if (client.localPlayerIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                    var4.method2927(var6, var7);
                    var4.field631 = false;
                } else if (var2) {
                    var4.field631 = true;
                    var4.xInScene = var6;
                    var4.yInScene = var7;
                } else {
                    var4.field631 = false;
                    var4.method2897(var6, var7, class254.moveSpeeds[var1]);
                }

            } else {
                var5 = var0.getBits(1);
                int var8;
                int var9;
                int var10;
                int var11;
                if (var5 == 0) {
                    var6 = var0.getBits(12);
                    var7 = var6 >> 10;
                    var8 = var6 >> 5 & 31;
                    if (var8 > 15) {
                        var8 -= 32;
                    }

                    var9 = var6 & 31;
                    if (var9 > 15) {
                        var9 -= 32;
                    }

                    var10 = var8 + var4.pathX[0];
                    var11 = var9 + var4.pathY[0];
                    if (client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                        if (var2) {
                            var4.field631 = true;
                            var4.xInScene = var10;
                            var4.yInScene = var11;
                        } else {
                            var4.field631 = false;
                            var4.method2897(var10, var11, class254.moveSpeeds[var1]);
                        }
                    } else {
                        var4.method2927(var10, var11);
                        var4.field631 = false;
                    }

                    var4.field620 = (byte) (var7 + var4.field620 & 3);
                    if (client.localPlayerIndex == var1) {
                        class228.level = var4.field620;
                    }

                } else {
                    var6 = var0.getBits(30);
                    var7 = var6 >> 28;
                    var8 = var6 >> 14 & 16383;
                    var9 = var6 & 16383;
                    var10 = (var8 + class158.baseX + var4.pathX[0] & 16383) - class158.baseX;
                    var11 = (var9 + class107.baseY + var4.pathY[0] & 16383) - class107.baseY;
                    if (client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                        if (var2) {
                            var4.field631 = true;
                            var4.xInScene = var10;
                            var4.yInScene = var11;
                        } else {
                            var4.field631 = false;
                            var4.method2897(var10, var11, class254.moveSpeeds[var1]);
                        }
                    } else {
                        var4.method2927(var10, var11);
                        var4.field631 = false;
                    }

                    var4.field620 = (byte) (var7 + var4.field620 & 3);
                    if (client.localPlayerIndex == var1) {
                        class228.level = var4.field620;
                    }

                }
            }
        }
    }
}
