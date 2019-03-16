package net.runelite.runescape;

import net.runelite.api.MessageNode;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSChatLineBuffer;

@ObfuscatedName("ca")
@Implements("ChatLineBuffer")
public class ChatLineBuffer implements RSChatLineBuffer {
    @ObfuscatedName("ix")
    @ObfuscatedGetter(
            intValue = -157363969
    )
    static int field1276;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "[Lbw;"
    )
    ChatLine[] lines;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 304420989
    )
    int length;

    ChatLineBuffer() {
        this.lines = new ChatLine[100];
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)Lbw;",
            garbageValue = "-914643719"
    )
    ChatLine method1935(int var1) {
        return var1 >= 0 && var1 < this.length ? this.lines[var1] : null;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-1455380015"
    )
    int method1939() {
        return this.length;
    }

    public MessageNode[] getLines() {
        return this.lines;
    }

    public int getLength() {
        return this.length;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbw;",
            garbageValue = "1852825408"
    )
    ChatLine method1933(int var1, String var2, String var3, String var4) {
        ChatLine var5 = this.lines[99];

        for (int var6 = this.length; var6 > 0; --var6) {
            if (var6 != 100) {
                this.lines[var6] = this.lines[var6 - 1];
            }
        }

        if (var5 == null) {
            var5 = new ChatLine(var1, var2, var4, var3);
        } else {
            var5.method6469();
            var5.method419();
            var5.method5643(var1, var2, var4, var3);
        }

        this.lines[0] = var5;
        if (this.length < 100) {
            ++this.length;
        }

        return var5;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(II)[B",
            garbageValue = "936861169"
    )
    static synchronized byte[] method1943(int var0) {
        return class150.method2553(var0, false);
    }

    @ObfuscatedName("jt")
    @ObfuscatedSignature(
            signature = "(Lhn;IIIB)V",
            garbageValue = "2"
    )
    static final void method1944(ComponentType var0, int var1, int var2, int var3) {
        class76.method1147();
        class96 var4 = var0.method270(false);
        if (var4 != null) {
            Rasterizer2D.method469(var1, var2, var4.field2626 + var1, var2 + var4.field2621);
            if (client.minimapRenderType != 2 && client.minimapRenderType != 5) {
                int var5 = client.mapAngle & 2047;
                int var6 = class4.localPlayer.x / 32 + 48;
                int var7 = 464 - class4.localPlayer.y / 32;
                TotalQuantityComparator.minimapSprite.method2269(var1, var2, var4.field2626, var4.field2621, var6, var7, var5, 256, var4.field2623, var4.field2622);

                int var8;
                int var9;
                int var10;
                for (var8 = 0; var8 < client.field820; ++var8) {
                    var9 = client.field871[var8] * 4 + 2 - class4.localPlayer.x / 32;
                    var10 = client.field872[var8] * 4 + 2 - class4.localPlayer.y / 32;
                    SubInterface.method2438(var1, var2, var9, var10, client.mapIcons[var8], var4);
                }

                int var11;
                int var12;
                for (var8 = 0; var8 < 104; ++var8) {
                    for (var9 = 0; var9 < 104; ++var9) {
                        Deque var15 = client.groundItemDeque[class228.level][var8][var9];
                        if (var15 != null) {
                            var11 = var8 * 4 + 2 - class4.localPlayer.x / 32;
                            var12 = var9 * 4 + 2 - class4.localPlayer.y / 32;
                            SubInterface.method2438(var1, var2, var11, var12, GameEngine.mapDots[0], var4);
                        }
                    }
                }

                for (var8 = 0; var8 < client.highResolutionNpcCount; ++var8) {
                    NPCEntity var16 = client.npcs[client.highResolutionNpcIndexes[var8]];
                    if (var16 != null && var16.vmethod2900()) {
                        NPCType var18 = var16.type;
                        if (var18 != null && var18.multiNpcs != null) {
                            var18 = var18.method5837();
                        }

                        if (var18 != null && var18.isMinimapVisible && var18.isClickable) {
                            var11 = var16.x / 32 - class4.localPlayer.x / 32;
                            var12 = var16.y / 32 - class4.localPlayer.y / 32;
                            SubInterface.method2438(var1, var2, var11, var12, GameEngine.mapDots[1], var4);
                        }
                    }
                }

                var8 = class254.highResolutionPlayerCount;
                int[] var19 = class254.highResolutionPlayerIndexes;

                for (var10 = 0; var10 < var8; ++var10) {
                    PlayerEntity var17 = client.players[var19[var10]];
                    if (var17 != null && var17.vmethod2900() && !var17.hidden && var17 != class4.localPlayer) {
                        var12 = var17.x / 32 - class4.localPlayer.x / 32;
                        int var13 = var17.y / 32 - class4.localPlayer.y / 32;
                        boolean var14 = false;
                        if (class4.localPlayer.team != 0 && var17.team != 0 && var17.team == class4.localPlayer.team) {
                            var14 = true;
                        }

                        if (var17.method2890()) {
                            SubInterface.method2438(var1, var2, var12, var13, GameEngine.mapDots[3], var4);
                        } else if (var14) {
                            SubInterface.method2438(var1, var2, var12, var13, GameEngine.mapDots[4], var4);
                        } else if (var17.method2893()) {
                            SubInterface.method2438(var1, var2, var12, var13, GameEngine.mapDots[5], var4);
                        } else {
                            SubInterface.method2438(var1, var2, var12, var13, GameEngine.mapDots[2], var4);
                        }
                    }
                }

                if (client.hintArrowTargetType != 0 && client.gameCycle % 20 < 10) {
                    if (client.hintArrowTargetType == 1 && client.hintArrowNpcTargetIdx >= 0 && client.hintArrowNpcTargetIdx < client.npcs.length) {
                        NPCEntity var20 = client.npcs[client.hintArrowNpcTargetIdx];
                        if (var20 != null) {
                            var11 = var20.x / 32 - class4.localPlayer.x / 32;
                            var12 = var20.y / 32 - class4.localPlayer.y / 32;
                            MapElementType.method2387(var1, var2, var11, var12, class11.mapMarkers[1], var4);
                        }
                    }

                    if (client.hintArrowTargetType == 2) {
                        var10 = client.hintArrowX * 4 - class158.baseX * 4 + 2 - class4.localPlayer.x / 32;
                        var11 = client.hintArrowY * 4 - class107.baseY * 4 + 2 - class4.localPlayer.y / 32;
                        MapElementType.method2387(var1, var2, var10, var11, class11.mapMarkers[1], var4);
                    }

                    if (client.hintArrowTargetType == 10 && client.hintArrowPlayerTargetIdx >= 0 && client.hintArrowPlayerTargetIdx < client.players.length) {
                        PlayerEntity var21 = client.players[client.hintArrowPlayerTargetIdx];
                        if (var21 != null) {
                            var11 = var21.x / 32 - class4.localPlayer.x / 32;
                            var12 = var21.y / 32 - class4.localPlayer.y / 32;
                            MapElementType.method2387(var1, var2, var11, var12, class11.mapMarkers[1], var4);
                        }
                    }
                }

                if (client.destinationX != 0) {
                    var10 = client.destinationX * 4 + 2 - class4.localPlayer.x / 32;
                    var11 = client.destinationY * 4 + 2 - class4.localPlayer.y / 32;
                    SubInterface.method2438(var1, var2, var10, var11, class11.mapMarkers[0], var4);
                }

                if (!class4.localPlayer.hidden) {
                    Rasterizer2D.method449(var4.field2626 / 2 + var1 - 1, var4.field2621 / 2 + var2 - 1, 3, 3, 16777215);
                }
            } else {
                Rasterizer2D.method460(var1, var2, 0, var4.field2623, var4.field2622);
            }

            client.field849[var3] = true;
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "([BIII)Ljava/lang/String;",
            garbageValue = "1245513971"
    )
    public static String method1932(byte[] var0, int var1, int var2) {
        StringBuilder var3 = new StringBuilder();

        for (int var4 = var1; var4 < var2 + var1; var4 += 3) {
            int var5 = var0[var4] & 255;
            var3.append(class174.field3800[var5 >>> 2]);
            if (var4 < var2 - 1) {
                int var6 = var0[var4 + 1] & 255;
                var3.append(class174.field3800[(var5 & 3) << 4 | var6 >>> 4]);
                if (var4 < var2 - 2) {
                    int var7 = var0[var4 + 2] & 255;
                    var3.append(class174.field3800[(var6 & 15) << 2 | var7 >>> 6]).append(class174.field3800[var7 & 63]);
                } else {
                    var3.append(class174.field3800[(var6 & 15) << 2]).append("=");
                }
            } else {
                var3.append(class174.field3800[(var5 & 3) << 4]).append("==");
            }
        }

        return var3.toString();
    }
}
