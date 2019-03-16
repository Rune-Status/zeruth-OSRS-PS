package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;

@ObfuscatedName("im")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 440578075
    )
    public static int field3302;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    static NodeCache varplayers;
    @ObfuscatedName("w")
    public static short[][] colorsToReplace;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index varplayer_ref;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -187487451
    )
    public int clientCode;

    static {
        varplayers = new NodeCache(64);
    }

    VarPlayerType() {
        this.clientCode = 0;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "427124525"
    )
    void method5530(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method5531(var1, var2);
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "-411010868"
    )
    void method5531(Packet var1, int var2) {
        if (var2 == 5) {
            this.clientCode = var1.readUnsignedShort();
        }

    }

    @ObfuscatedName("e")
    public static String method5549(long var0) {
        if (var0 > 0L && var0 < 6582952005840035281L) {
            if (var0 % 37L == 0L) {
                return null;
            } else {
                int var2 = 0;

                for (long var3 = var0; 0L != var3; var3 /= 37L) {
                    ++var2;
                }

                StringBuilder var5;
                char var8;
                for (var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
                    long var6 = var0;
                    var0 /= 37L;
                    var8 = class13.field3791[(int) (var6 - 37L * var0)];
                    if (var8 == '_') {
                        int var9 = var5.length() - 1;
                        var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                        var8 = 160;
                    }
                }

                var5.reverse();
                var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
                return var5.toString();
            }
        } else {
            return null;
        }
    }

    @ObfuscatedName("ae")
    @ObfuscatedSignature(
            signature = "(ILcx;ZB)I",
            garbageValue = "10"
    )
    static int method5548(int var0, class106 var1, boolean var2) {
        if (var0 == 3600) {
            if (ServerProt.friendManager.state == 0) {
                class48.intStack[++class228.intStackSize - 1] = -2;
            } else if (ServerProt.friendManager.state == 1) {
                class48.intStack[++class228.intStackSize - 1] = -1;
            } else {
                class48.intStack[++class228.intStackSize - 1] = ServerProt.friendManager.friendContainer.method5225();
            }

            return 1;
        } else {
            int var3;
            if (var0 == 3601) {
                var3 = class48.intStack[--class228.intStackSize];
                if (ServerProt.friendManager.method44() && var3 >= 0 && var3 < ServerProt.friendManager.friendContainer.method5225()) {
                    Friend var8 = (Friend) ServerProt.friendManager.friendContainer.method5234(var3);
                    class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var8.method2073();
                    class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var8.method2069();
                } else {
                    class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                    class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                }

                return 1;
            } else if (var0 == 3602) {
                var3 = class48.intStack[--class228.intStackSize];
                if (ServerProt.friendManager.method44() && var3 >= 0 && var3 < ServerProt.friendManager.friendContainer.method5225()) {
                    class48.intStack[++class228.intStackSize - 1] = ((ChatPlayer) ServerProt.friendManager.friendContainer.method5234(var3)).world;
                } else {
                    class48.intStack[++class228.intStackSize - 1] = 0;
                }

                return 1;
            } else if (var0 == 3603) {
                var3 = class48.intStack[--class228.intStackSize];
                if (ServerProt.friendManager.method44() && var3 >= 0 && var3 < ServerProt.friendManager.friendContainer.method5225()) {
                    class48.intStack[++class228.intStackSize - 1] = ((ChatPlayer) ServerProt.friendManager.friendContainer.method5234(var3)).rank;
                } else {
                    class48.intStack[++class228.intStackSize - 1] = 0;
                }

                return 1;
            } else {
                String var5;
                if (var0 == 3604) {
                    var5 = class48.scriptStringStack[--class48.scriptStringStackSize];
                    int var6 = class48.intStack[--class228.intStackSize];
                    class80.method1166(var5, var6);
                    return 1;
                } else if (var0 == 3605) {
                    var5 = class48.scriptStringStack[--class48.scriptStringStackSize];
                    ServerProt.friendManager.method51(var5);
                    return 1;
                } else if (var0 == 3606) {
                    var5 = class48.scriptStringStack[--class48.scriptStringStackSize];
                    ServerProt.friendManager.method55(var5);
                    return 1;
                } else if (var0 == 3607) {
                    var5 = class48.scriptStringStack[--class48.scriptStringStackSize];
                    ServerProt.friendManager.method53(var5);
                    return 1;
                } else if (var0 == 3608) {
                    var5 = class48.scriptStringStack[--class48.scriptStringStackSize];
                    ServerProt.friendManager.method73(var5);
                    return 1;
                } else if (var0 == 3609) {
                    var5 = class48.scriptStringStack[--class48.scriptStringStackSize];
                    var5 = class202.method4069(var5);
                    class48.intStack[++class228.intStackSize - 1] = ServerProt.friendManager.method69(new Name(var5, client.loginType), false) ? 1 : 0;
                    return 1;
                } else if (var0 == 3611) {
                    if (TotalQuantityComparator.clanMemberManager != null) {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = TotalQuantityComparator.clanMemberManager.field3726;
                    } else {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                    }

                    return 1;
                } else if (var0 == 3612) {
                    if (TotalQuantityComparator.clanMemberManager != null) {
                        class48.intStack[++class228.intStackSize - 1] = TotalQuantityComparator.clanMemberManager.method5225();
                    } else {
                        class48.intStack[++class228.intStackSize - 1] = 0;
                    }

                    return 1;
                } else if (var0 == 3613) {
                    var3 = class48.intStack[--class228.intStackSize];
                    if (TotalQuantityComparator.clanMemberManager != null && var3 < TotalQuantityComparator.clanMemberManager.method5225()) {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = TotalQuantityComparator.clanMemberManager.method5234(var3).method2067().method4713();
                    } else {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                    }

                    return 1;
                } else if (var0 == 3614) {
                    var3 = class48.intStack[--class228.intStackSize];
                    if (TotalQuantityComparator.clanMemberManager != null && var3 < TotalQuantityComparator.clanMemberManager.method5225()) {
                        class48.intStack[++class228.intStackSize - 1] = ((ChatPlayer) TotalQuantityComparator.clanMemberManager.method5234(var3)).method793();
                    } else {
                        class48.intStack[++class228.intStackSize - 1] = 0;
                    }

                    return 1;
                } else if (var0 == 3615) {
                    var3 = class48.intStack[--class228.intStackSize];
                    if (TotalQuantityComparator.clanMemberManager != null && var3 < TotalQuantityComparator.clanMemberManager.method5225()) {
                        class48.intStack[++class228.intStackSize - 1] = ((ChatPlayer) TotalQuantityComparator.clanMemberManager.method5234(var3)).rank;
                    } else {
                        class48.intStack[++class228.intStackSize - 1] = 0;
                    }

                    return 1;
                } else if (var0 == 3616) {
                    class48.intStack[++class228.intStackSize - 1] = TotalQuantityComparator.clanMemberManager != null ? TotalQuantityComparator.clanMemberManager.field3731 : 0;
                    return 1;
                } else if (var0 == 3617) {
                    var5 = class48.scriptStringStack[--class48.scriptStringStackSize];
                    GrandExchangeOffer.method2874(var5);
                    return 1;
                } else if (var0 == 3618) {
                    class48.intStack[++class228.intStackSize - 1] = TotalQuantityComparator.clanMemberManager != null ? TotalQuantityComparator.clanMemberManager.field3732 : 0;
                    return 1;
                } else if (var0 == 3619) {
                    var5 = class48.scriptStringStack[--class48.scriptStringStackSize];
                    HitmarkType.method2227(var5);
                    return 1;
                } else if (var0 == 3620) {
                    class60.method877();
                    return 1;
                } else if (var0 == 3621) {
                    if (!ServerProt.friendManager.method44()) {
                        class48.intStack[++class228.intStackSize - 1] = -1;
                    } else {
                        class48.intStack[++class228.intStackSize - 1] = ServerProt.friendManager.ignoreContainer.method5225();
                    }

                    return 1;
                } else if (var0 == 3622) {
                    var3 = class48.intStack[--class228.intStackSize];
                    if (ServerProt.friendManager.method44() && var3 >= 0 && var3 < ServerProt.friendManager.ignoreContainer.method5225()) {
                        Ignore var4 = (Ignore) ServerProt.friendManager.ignoreContainer.method5234(var3);
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var4.method2073();
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var4.method2069();
                    } else {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                    }

                    return 1;
                } else if (var0 == 3623) {
                    var5 = class48.scriptStringStack[--class48.scriptStringStackSize];
                    var5 = class202.method4069(var5);
                    class48.intStack[++class228.intStackSize - 1] = ServerProt.friendManager.method96(new Name(var5, client.loginType)) ? 1 : 0;
                    return 1;
                } else if (var0 == 3624) {
                    var3 = class48.intStack[--class228.intStackSize];
                    if (TotalQuantityComparator.clanMemberManager != null && var3 < TotalQuantityComparator.clanMemberManager.method5225() && TotalQuantityComparator.clanMemberManager.method5234(var3).method2067().equals(class4.localPlayer.name)) {
                        class48.intStack[++class228.intStackSize - 1] = 1;
                    } else {
                        class48.intStack[++class228.intStackSize - 1] = 0;
                    }

                    return 1;
                } else if (var0 == 3625) {
                    if (TotalQuantityComparator.clanMemberManager != null && TotalQuantityComparator.clanMemberManager.field3730 != null) {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = TotalQuantityComparator.clanMemberManager.field3730;
                    } else {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                    }

                    return 1;
                } else if (var0 == 3626) {
                    var3 = class48.intStack[--class228.intStackSize];
                    if (TotalQuantityComparator.clanMemberManager != null && var3 < TotalQuantityComparator.clanMemberManager.method5225() && ((ClanMember) TotalQuantityComparator.clanMemberManager.method5234(var3)).method963()) {
                        class48.intStack[++class228.intStackSize - 1] = 1;
                    } else {
                        class48.intStack[++class228.intStackSize - 1] = 0;
                    }

                    return 1;
                } else if (var0 != 3627) {
                    if (var0 == 3628) {
                        ServerProt.friendManager.friendContainer.method5244();
                        return 1;
                    } else {
                        boolean var7;
                        if (var0 == 3629) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.friendContainer.method5245(new class45(var7));
                            return 1;
                        } else if (var0 == 3630) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.friendContainer.method5245(new class244(var7));
                            return 1;
                        } else if (var0 == 3631) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.friendContainer.method5245(new class36(var7));
                            return 1;
                        } else if (var0 == 3632) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.friendContainer.method5245(new class220(var7));
                            return 1;
                        } else if (var0 == 3633) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.friendContainer.method5245(new class86(var7));
                            return 1;
                        } else if (var0 == 3634) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.friendContainer.method5245(new class277(var7));
                            return 1;
                        } else if (var0 == 3635) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.friendContainer.method5245(new class314(var7));
                            return 1;
                        } else if (var0 == 3636) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.friendContainer.method5245(new class230(var7));
                            return 1;
                        } else if (var0 == 3637) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.friendContainer.method5245(new class82(var7));
                            return 1;
                        } else if (var0 == 3638) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.friendContainer.method5245(new class189(var7));
                            return 1;
                        } else if (var0 == 3639) {
                            ServerProt.friendManager.friendContainer.method5240();
                            return 1;
                        } else if (var0 == 3640) {
                            ServerProt.friendManager.ignoreContainer.method5244();
                            return 1;
                        } else if (var0 == 3641) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.ignoreContainer.method5245(new class45(var7));
                            return 1;
                        } else if (var0 == 3642) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.ignoreContainer.method5245(new class244(var7));
                            return 1;
                        } else if (var0 == 3643) {
                            ServerProt.friendManager.ignoreContainer.method5240();
                            return 1;
                        } else if (var0 == 3644) {
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5244();
                            }

                            return 1;
                        } else if (var0 == 3645) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5245(new class45(var7));
                            }

                            return 1;
                        } else if (var0 == 3646) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5245(new class244(var7));
                            }

                            return 1;
                        } else if (var0 == 3647) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5245(new class36(var7));
                            }

                            return 1;
                        } else if (var0 == 3648) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5245(new class220(var7));
                            }

                            return 1;
                        } else if (var0 == 3649) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5245(new class86(var7));
                            }

                            return 1;
                        } else if (var0 == 3650) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5245(new class277(var7));
                            }

                            return 1;
                        } else if (var0 == 3651) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5245(new class314(var7));
                            }

                            return 1;
                        } else if (var0 == 3652) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5245(new class230(var7));
                            }

                            return 1;
                        } else if (var0 == 3653) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5245(new class82(var7));
                            }

                            return 1;
                        } else if (var0 == 3654) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5245(new class189(var7));
                            }

                            return 1;
                        } else if (var0 == 3655) {
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5240();
                            }

                            return 1;
                        } else if (var0 == 3656) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            ServerProt.friendManager.friendContainer.method5245(new class80(var7));
                            return 1;
                        } else if (var0 == 3657) {
                            var7 = class48.intStack[--class228.intStackSize] == 1;
                            if (TotalQuantityComparator.clanMemberManager != null) {
                                TotalQuantityComparator.clanMemberManager.method5245(new class80(var7));
                            }

                            return 1;
                        } else {
                            return 2;
                        }
                    }
                } else {
                    var3 = class48.intStack[--class228.intStackSize];
                    if (TotalQuantityComparator.clanMemberManager != null && var3 < TotalQuantityComparator.clanMemberManager.method5225() && ((ClanMember) TotalQuantityComparator.clanMemberManager.method5234(var3)).method966()) {
                        class48.intStack[++class228.intStackSize - 1] = 1;
                    } else {
                        class48.intStack[++class228.intStackSize - 1] = 0;
                    }

                    return 1;
                }
            }
        }
    }

    @ObfuscatedName("kc")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-1909325574"
    )
    static void method5534(Packet var0) {
        if (client.field708 != null) {
            var0.method6072(client.field708, 0, client.field708.length);
        } else {
            byte[] var2 = new byte[24];

            try {
                class166.uidDat.method2099(0L);
                class166.uidDat.method2101(var2);

                int var3;
                for (var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
                    ;
                }

                if (var3 >= 24) {
                    throw new IOException();
                }
            } catch (Exception var6) {
                for (int var4 = 0; var4 < 24; ++var4) {
                    var2[var4] = -1;
                }
            }

            var0.method6072(var2, 0, var2.length);
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lfd;I)V",
            garbageValue = "1598346725"
    )
    public static void method5550(Huffman var0) {
        class331.huffman = var0;
    }
}
