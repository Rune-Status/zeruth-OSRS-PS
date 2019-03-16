package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("VarClientType")
public class VarClientType extends CacheableNode {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    static NodeCache field3335;
    @ObfuscatedName("b")
    public static int[] indexedSpriteHeights;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    public static Js5Index field3336;
    @ObfuscatedName("e")
    public boolean serialize;

    static {
        field3335 = new NodeCache(64);
    }

    VarClientType() {
        this.serialize = false;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "1124634790"
    )
    void method5421(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method5422(var1, var2);
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "465607737"
    )
    void method5422(Packet var1, int var2) {
        if (var2 == 2) {
            this.serialize = true;
        }

    }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "870951228"
    )
    static int method5426(int var0, class106 var1, boolean var2) {
        if (var0 == 5000) {
            class48.intStack[++class228.intStackSize - 1] = client.publicChatMode;
            return 1;
        } else if (var0 == 5001) {
            class228.intStackSize -= 3;
            client.publicChatMode = class48.intStack[class228.intStackSize];
            Overlay.field3613 = ScriptState.method421(class48.intStack[class228.intStackSize + 1]);
            if (Overlay.field3613 == null) {
                Overlay.field3613 = class307.field3805;
            }

            client.tradeMode = class48.intStack[class228.intStackSize + 2];
            TcpConnectionMessage var18 = FaceNormal.method5726(ClientProt.CHAT_SETMODE, client.serverConnection.isaac);
            var18.packetBuffer.putByte(client.publicChatMode);
            var18.packetBuffer.putByte(Overlay.field3613.field3807);
            var18.packetBuffer.putByte(client.tradeMode);
            client.serverConnection.method5881(var18);
            return 1;
        } else {
            String var3;
            int var4;
            if (var0 == 5002) {
                var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                class228.intStackSize -= 2;
                var4 = class48.intStack[class228.intStackSize];
                int var5 = class48.intStack[class228.intStackSize + 1];
                TcpConnectionMessage var6 = FaceNormal.method5726(ClientProt.PLAYER_REPORT, client.serverConnection.isaac);
                var6.packetBuffer.putByte(AbstractSoundSystem.method338(var3) + 2);
                var6.packetBuffer.method6198(var3);
                var6.packetBuffer.putByte(var4 - 1);
                var6.packetBuffer.putByte(var5);
                client.serverConnection.method5881(var6);
                return 1;
            } else {
                int var10;
                if (var0 == 5003) {
                    class228.intStackSize -= 2;
                    var10 = class48.intStack[class228.intStackSize];
                    var4 = class48.intStack[class228.intStackSize + 1];
                    ChatLine var15 = MouseInput.method5755(var10, var4);
                    if (var15 != null) {
                        class48.intStack[++class228.intStackSize - 1] = var15.id;
                        class48.intStack[++class228.intStackSize - 1] = var15.tick;
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var15.name != null ? var15.name : "";
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var15.clan != null ? var15.clan : "";
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var15.value != null ? var15.value : "";
                        class48.intStack[++class228.intStackSize - 1] = var15.method5645() ? 1 : (var15.method5642() ? 2 : 0);
                    } else {
                        class48.intStack[++class228.intStackSize - 1] = -1;
                        class48.intStack[++class228.intStackSize - 1] = 0;
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                        class48.intStack[++class228.intStackSize - 1] = 0;
                    }

                    return 1;
                } else if (var0 == 5004) {
                    var10 = class48.intStack[--class228.intStackSize];
                    ChatLine var16 = class107.method1887(var10);
                    if (var16 != null) {
                        class48.intStack[++class228.intStackSize - 1] = var16.type;
                        class48.intStack[++class228.intStackSize - 1] = var16.tick;
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var16.name != null ? var16.name : "";
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var16.clan != null ? var16.clan : "";
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var16.value != null ? var16.value : "";
                        class48.intStack[++class228.intStackSize - 1] = var16.method5645() ? 1 : (var16.method5642() ? 2 : 0);
                    } else {
                        class48.intStack[++class228.intStackSize - 1] = -1;
                        class48.intStack[++class228.intStackSize - 1] = 0;
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                        class48.intStack[++class228.intStackSize - 1] = 0;
                    }

                    return 1;
                } else if (var0 == 5005) {
                    if (Overlay.field3613 == null) {
                        class48.intStack[++class228.intStackSize - 1] = -1;
                    } else {
                        class48.intStack[++class228.intStackSize - 1] = Overlay.field3613.field3807;
                    }

                    return 1;
                } else if (var0 == 5008) {
                    var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                    var4 = class48.intStack[--class228.intStackSize];
                    String var14 = var3.toLowerCase();
                    byte var17 = 0;
                    if (var14.startsWith("yellow:")) {
                        var17 = 0;
                        var3 = var3.substring("yellow:".length());
                    } else if (var14.startsWith("red:")) {
                        var17 = 1;
                        var3 = var3.substring("red:".length());
                    } else if (var14.startsWith("green:")) {
                        var17 = 2;
                        var3 = var3.substring("green:".length());
                    } else if (var14.startsWith("cyan:")) {
                        var17 = 3;
                        var3 = var3.substring("cyan:".length());
                    } else if (var14.startsWith("purple:")) {
                        var17 = 4;
                        var3 = var3.substring("purple:".length());
                    } else if (var14.startsWith("white:")) {
                        var17 = 5;
                        var3 = var3.substring("white:".length());
                    } else if (var14.startsWith("flash1:")) {
                        var17 = 6;
                        var3 = var3.substring("flash1:".length());
                    } else if (var14.startsWith("flash2:")) {
                        var17 = 7;
                        var3 = var3.substring("flash2:".length());
                    } else if (var14.startsWith("flash3:")) {
                        var17 = 8;
                        var3 = var3.substring("flash3:".length());
                    } else if (var14.startsWith("glow1:")) {
                        var17 = 9;
                        var3 = var3.substring("glow1:".length());
                    } else if (var14.startsWith("glow2:")) {
                        var17 = 10;
                        var3 = var3.substring("glow2:".length());
                    } else if (var14.startsWith("glow3:")) {
                        var17 = 11;
                        var3 = var3.substring("glow3:".length());
                    } else if (client.languageId != 0) {
                        if (var14.startsWith("yellow:")) {
                            var17 = 0;
                            var3 = var3.substring("yellow:".length());
                        } else if (var14.startsWith("red:")) {
                            var17 = 1;
                            var3 = var3.substring("red:".length());
                        } else if (var14.startsWith("green:")) {
                            var17 = 2;
                            var3 = var3.substring("green:".length());
                        } else if (var14.startsWith("cyan:")) {
                            var17 = 3;
                            var3 = var3.substring("cyan:".length());
                        } else if (var14.startsWith("purple:")) {
                            var17 = 4;
                            var3 = var3.substring("purple:".length());
                        } else if (var14.startsWith("white:")) {
                            var17 = 5;
                            var3 = var3.substring("white:".length());
                        } else if (var14.startsWith("flash1:")) {
                            var17 = 6;
                            var3 = var3.substring("flash1:".length());
                        } else if (var14.startsWith("flash2:")) {
                            var17 = 7;
                            var3 = var3.substring("flash2:".length());
                        } else if (var14.startsWith("flash3:")) {
                            var17 = 8;
                            var3 = var3.substring("flash3:".length());
                        } else if (var14.startsWith("glow1:")) {
                            var17 = 9;
                            var3 = var3.substring("glow1:".length());
                        } else if (var14.startsWith("glow2:")) {
                            var17 = 10;
                            var3 = var3.substring("glow2:".length());
                        } else if (var14.startsWith("glow3:")) {
                            var17 = 11;
                            var3 = var3.substring("glow3:".length());
                        }
                    }

                    var14 = var3.toLowerCase();
                    byte var7 = 0;
                    if (var14.startsWith("wave:")) {
                        var7 = 1;
                        var3 = var3.substring("wave:".length());
                    } else if (var14.startsWith("wave2:")) {
                        var7 = 2;
                        var3 = var3.substring("wave2:".length());
                    } else if (var14.startsWith("shake:")) {
                        var7 = 3;
                        var3 = var3.substring("shake:".length());
                    } else if (var14.startsWith("scroll:")) {
                        var7 = 4;
                        var3 = var3.substring("scroll:".length());
                    } else if (var14.startsWith("slide:")) {
                        var7 = 5;
                        var3 = var3.substring("slide:".length());
                    } else if (client.languageId != 0) {
                        if (var14.startsWith("wave:")) {
                            var7 = 1;
                            var3 = var3.substring("wave:".length());
                        } else if (var14.startsWith("wave2:")) {
                            var7 = 2;
                            var3 = var3.substring("wave2:".length());
                        } else if (var14.startsWith("shake:")) {
                            var7 = 3;
                            var3 = var3.substring("shake:".length());
                        } else if (var14.startsWith("scroll:")) {
                            var7 = 4;
                            var3 = var3.substring("scroll:".length());
                        } else if (var14.startsWith("slide:")) {
                            var7 = 5;
                            var3 = var3.substring("slide:".length());
                        }
                    }

                    TcpConnectionMessage var8 = FaceNormal.method5726(ClientProt.MESSAGE_PUBLIC, client.serverConnection.isaac);
                    var8.packetBuffer.putByte(0);
                    int var9 = var8.packetBuffer.offset;
                    var8.packetBuffer.putByte(var4);
                    var8.packetBuffer.putByte(var17);
                    var8.packetBuffer.putByte(var7);
                    class321.method6055(var8.packetBuffer, var3);
                    var8.packetBuffer.method6075(var8.packetBuffer.offset - var9);
                    client.serverConnection.method5881(var8);
                    return 1;
                } else if (var0 == 5009) {
                    class48.scriptStringStackSize -= 2;
                    var3 = class48.scriptStringStack[class48.scriptStringStackSize];
                    String var12 = class48.scriptStringStack[class48.scriptStringStackSize + 1];
                    TcpConnectionMessage var11 = FaceNormal.method5726(ClientProt.MESSAGE_PRIVATE, client.serverConnection.isaac);
                    var11.packetBuffer.putShort(0);
                    int var13 = var11.packetBuffer.offset;
                    var11.packetBuffer.method6198(var3);
                    class321.method6055(var11.packetBuffer, var12);
                    var11.packetBuffer.method6074(var11.packetBuffer.offset - var13);
                    client.serverConnection.method5881(var11);
                    return 1;
                } else if (var0 != 5015) {
                    if (var0 == 5016) {
                        class48.intStack[++class228.intStackSize - 1] = client.tradeMode;
                        return 1;
                    } else if (var0 == 5017) {
                        var10 = class48.intStack[--class228.intStackSize];
                        class48.intStack[++class228.intStackSize - 1] = class202.method4072(var10);
                        return 1;
                    } else if (var0 == 5018) {
                        var10 = class48.intStack[--class228.intStackSize];
                        class48.intStack[++class228.intStackSize - 1] = class284.method5563(var10);
                        return 1;
                    } else if (var0 == 5019) {
                        var10 = class48.intStack[--class228.intStackSize];
                        class48.intStack[++class228.intStackSize - 1] = ScriptEvent.method4044(var10);
                        return 1;
                    } else if (var0 == 5020) {
                        var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                        SoundTaskDataProvider.method2528(var3);
                        return 1;
                    } else if (var0 == 5021) {
                        client.field862 = class48.scriptStringStack[--class48.scriptStringStackSize].toLowerCase().trim();
                        return 1;
                    } else if (var0 == 5022) {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = client.field862;
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    if (class4.localPlayer != null && class4.localPlayer.name != null) {
                        var3 = class4.localPlayer.name.method4713();
                    } else {
                        var3 = "";
                    }

                    class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3;
                    return 1;
                }
            }
        }
    }
}
