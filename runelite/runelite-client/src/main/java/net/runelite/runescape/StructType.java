package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("StructType")
public class StructType extends CacheableNode {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    static NodeCache structTypeCache;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index field3411;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lgr;"
    )
    IterableHashTable params;

    static {
        structTypeCache = new NodeCache(64);
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-440344671"
    )
    void method5699() {
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;B)V",
            garbageValue = "17"
    )
    void method5702(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method5721(var1, var2);
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(ILjava/lang/String;I)Ljava/lang/String;",
            garbageValue = "-1799102162"
    )
    public String method5703(int var1, String var2) {
        return AuthProt.method1670(this.params, var1, var2);
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(Lgl;IB)V",
            garbageValue = "0"
    )
    void method5721(Packet var1, int var2) {
        if (var2 == 249) {
            this.params = class96.method1621(var1, this.params);
        }

    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "-1838954230"
    )
    public int method5698(int var1, int var2) {
        return AuthProt.method1664(this.params, var1, var2);
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(CI)Z",
            garbageValue = "-2143990061"
    )
    static final boolean method5723(char var0) {
        return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
    }

    @ObfuscatedName("hf")
    @ObfuscatedSignature(
            signature = "(Lbk;IIBI)V",
            garbageValue = "-1140391296"
    )
    static final void method5724(PlayerEntity var0, int var1, int var2, byte var3) {
        int var4 = var0.pathX[0];
        int var5 = var0.pathY[0];
        int var6 = var0.method2895();
        if (var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
            if (var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
                int var8 = var0.method2895();
                client.field670.field2116 = var1;
                client.field670.field2112 = var2;
                client.field670.field2114 = 1;
                client.field670.field2115 = 1;
                class228 var9 = client.field670;
                class228 var10 = var9;
                CollisionData var11 = client.collisionMaps[var0.field620];
                int[] var12 = client.field918;
                int[] var13 = client.field900;

                int var14;
                int var15;
                for (var14 = 0; var14 < 128; ++var14) {
                    for (var15 = 0; var15 < 128; ++var15) {
                        class32.field2105[var14][var15] = 0;
                        class32.field2103[var14][var15] = 99999999;
                    }
                }

                int var16;
                int var17;
                byte var18;
                byte var19;
                int var20;
                int var21;
                byte var22;
                int var23;
                int[][] var24;
                int var25;
                int var26;
                int var27;
                int var28;
                boolean var34;
                boolean var35;
                int var36;
                int var37;
                int var39;
                if (var8 == 1) {
                    var16 = var4;
                    var17 = var5;
                    var18 = 64;
                    var19 = 64;
                    var20 = var4 - var18;
                    var21 = var5 - var19;
                    class32.field2105[var18][var19] = 99;
                    class32.field2103[var18][var19] = 0;
                    var22 = 0;
                    var23 = 0;
                    class32.field2106[var22] = var4;
                    var39 = var22 + 1;
                    class32.field2110[var22] = var5;
                    var24 = var11.flags;

                    while (true) {
                        if (var39 == var23) {
                            class259.field2809 = var16;
                            class32.field2107 = var17;
                            var35 = false;
                            break;
                        }

                        var16 = class32.field2106[var23];
                        var17 = class32.field2110[var23];
                        var23 = var23 + 1 & 4095;
                        var36 = var16 - var20;
                        var37 = var17 - var21;
                        var25 = var16 - var11.x;
                        var26 = var17 - var11.y;
                        if (var10.vmethod4527(1, var16, var17, var11)) {
                            class259.field2809 = var16;
                            class32.field2107 = var17;
                            var35 = true;
                            break;
                        }

                        var27 = class32.field2103[var36][var37] + 1;
                        if (var36 > 0 && class32.field2105[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136776) == 0) {
                            class32.field2106[var39] = var16 - 1;
                            class32.field2110[var39] = var17;
                            var39 = var39 + 1 & 4095;
                            class32.field2105[var36 - 1][var37] = 2;
                            class32.field2103[var36 - 1][var37] = var27;
                        }

                        if (var36 < 127 && class32.field2105[var36 + 1][var37] == 0 && (var24[var25 + 1][var26] & 19136896) == 0) {
                            class32.field2106[var39] = var16 + 1;
                            class32.field2110[var39] = var17;
                            var39 = var39 + 1 & 4095;
                            class32.field2105[var36 + 1][var37] = 8;
                            class32.field2103[var36 + 1][var37] = var27;
                        }

                        if (var37 > 0 && class32.field2105[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                            class32.field2106[var39] = var16;
                            class32.field2110[var39] = var17 - 1;
                            var39 = var39 + 1 & 4095;
                            class32.field2105[var36][var37 - 1] = 1;
                            class32.field2103[var36][var37 - 1] = var27;
                        }

                        if (var37 < 127 && class32.field2105[var36][var37 + 1] == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                            class32.field2106[var39] = var16;
                            class32.field2110[var39] = var17 + 1;
                            var39 = var39 + 1 & 4095;
                            class32.field2105[var36][var37 + 1] = 4;
                            class32.field2103[var36][var37 + 1] = var27;
                        }

                        if (var36 > 0 && var37 > 0 && class32.field2105[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                            class32.field2106[var39] = var16 - 1;
                            class32.field2110[var39] = var17 - 1;
                            var39 = var39 + 1 & 4095;
                            class32.field2105[var36 - 1][var37 - 1] = 3;
                            class32.field2103[var36 - 1][var37 - 1] = var27;
                        }

                        if (var36 < 127 && var37 > 0 && class32.field2105[var36 + 1][var37 - 1] == 0 && (var24[var25 + 1][var26 - 1] & 19136899) == 0 && (var24[var25 + 1][var26] & 19136896) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                            class32.field2106[var39] = var16 + 1;
                            class32.field2110[var39] = var17 - 1;
                            var39 = var39 + 1 & 4095;
                            class32.field2105[var36 + 1][var37 - 1] = 9;
                            class32.field2103[var36 + 1][var37 - 1] = var27;
                        }

                        if (var36 > 0 && var37 < 127 && class32.field2105[var36 - 1][var37 + 1] == 0 && (var24[var25 - 1][var26 + 1] & 19136824) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                            class32.field2106[var39] = var16 - 1;
                            class32.field2110[var39] = var17 + 1;
                            var39 = var39 + 1 & 4095;
                            class32.field2105[var36 - 1][var37 + 1] = 6;
                            class32.field2103[var36 - 1][var37 + 1] = var27;
                        }

                        if (var36 < 127 && var37 < 127 && class32.field2105[var36 + 1][var37 + 1] == 0 && (var24[var25 + 1][var26 + 1] & 19136992) == 0 && (var24[var25 + 1][var26] & 19136896) == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                            class32.field2106[var39] = var16 + 1;
                            class32.field2110[var39] = var17 + 1;
                            var39 = var39 + 1 & 4095;
                            class32.field2105[var36 + 1][var37 + 1] = 12;
                            class32.field2103[var36 + 1][var37 + 1] = var27;
                        }
                    }

                    var34 = var35;
                } else if (var8 == 2) {
                    var34 = class86.method1405(var4, var5, var9, var11);
                } else {
                    var16 = var4;
                    var17 = var5;
                    var18 = 64;
                    var19 = 64;
                    var20 = var4 - var18;
                    var21 = var5 - var19;
                    class32.field2105[var18][var19] = 99;
                    class32.field2103[var18][var19] = 0;
                    var22 = 0;
                    var23 = 0;
                    class32.field2106[var22] = var4;
                    var39 = var22 + 1;
                    class32.field2110[var22] = var5;
                    var24 = var11.flags;

                    label641:
                    while (true) {
                        label639:
                        while (true) {
                            do {
                                do {
                                    do {
                                        label616:
                                        do {
                                            if (var23 == var39) {
                                                class259.field2809 = var16;
                                                class32.field2107 = var17;
                                                var35 = false;
                                                break label641;
                                            }

                                            var16 = class32.field2106[var23];
                                            var17 = class32.field2110[var23];
                                            var23 = var23 + 1 & 4095;
                                            var36 = var16 - var20;
                                            var37 = var17 - var21;
                                            var25 = var16 - var11.x;
                                            var26 = var17 - var11.y;
                                            if (var10.vmethod4527(var8, var16, var17, var11)) {
                                                class259.field2809 = var16;
                                                class32.field2107 = var17;
                                                var35 = true;
                                                break label641;
                                            }

                                            var27 = class32.field2103[var36][var37] + 1;
                                            if (var36 > 0 && class32.field2105[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136782) == 0 && (var24[var25 - 1][var26 + var8 - 1] & 19136824) == 0) {
                                                var28 = 1;

                                                while (true) {
                                                    if (var28 >= var8 - 1) {
                                                        class32.field2106[var39] = var16 - 1;
                                                        class32.field2110[var39] = var17;
                                                        var39 = var39 + 1 & 4095;
                                                        class32.field2105[var36 - 1][var37] = 2;
                                                        class32.field2103[var36 - 1][var37] = var27;
                                                        break;
                                                    }

                                                    if ((var24[var25 - 1][var28 + var26] & 19136830) != 0) {
                                                        break;
                                                    }

                                                    ++var28;
                                                }
                                            }

                                            if (var36 < 128 - var8 && class32.field2105[var36 + 1][var37] == 0 && (var24[var25 + var8][var26] & 19136899) == 0 && (var24[var8 + var25][var26 + var8 - 1] & 19136992) == 0) {
                                                var28 = 1;

                                                while (true) {
                                                    if (var28 >= var8 - 1) {
                                                        class32.field2106[var39] = var16 + 1;
                                                        class32.field2110[var39] = var17;
                                                        var39 = var39 + 1 & 4095;
                                                        class32.field2105[var36 + 1][var37] = 8;
                                                        class32.field2103[var36 + 1][var37] = var27;
                                                        break;
                                                    }

                                                    if ((var24[var8 + var25][var26 + var28] & 19136995) != 0) {
                                                        break;
                                                    }

                                                    ++var28;
                                                }
                                            }

                                            if (var37 > 0 && class32.field2105[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136782) == 0 && (var24[var25 + var8 - 1][var26 - 1] & 19136899) == 0) {
                                                var28 = 1;

                                                while (true) {
                                                    if (var28 >= var8 - 1) {
                                                        class32.field2106[var39] = var16;
                                                        class32.field2110[var39] = var17 - 1;
                                                        var39 = var39 + 1 & 4095;
                                                        class32.field2105[var36][var37 - 1] = 1;
                                                        class32.field2103[var36][var37 - 1] = var27;
                                                        break;
                                                    }

                                                    if ((var24[var28 + var25][var26 - 1] & 19136911) != 0) {
                                                        break;
                                                    }

                                                    ++var28;
                                                }
                                            }

                                            if (var37 < 128 - var8 && class32.field2105[var36][var37 + 1] == 0 && (var24[var25][var8 + var26] & 19136824) == 0 && (var24[var25 + var8 - 1][var8 + var26] & 19136992) == 0) {
                                                var28 = 1;

                                                while (true) {
                                                    if (var28 >= var8 - 1) {
                                                        class32.field2106[var39] = var16;
                                                        class32.field2110[var39] = var17 + 1;
                                                        var39 = var39 + 1 & 4095;
                                                        class32.field2105[var36][var37 + 1] = 4;
                                                        class32.field2103[var36][var37 + 1] = var27;
                                                        break;
                                                    }

                                                    if ((var24[var28 + var25][var26 + var8] & 19137016) != 0) {
                                                        break;
                                                    }

                                                    ++var28;
                                                }
                                            }

                                            if (var36 > 0 && var37 > 0 && class32.field2105[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0) {
                                                var28 = 1;

                                                while (true) {
                                                    if (var28 >= var8) {
                                                        class32.field2106[var39] = var16 - 1;
                                                        class32.field2110[var39] = var17 - 1;
                                                        var39 = var39 + 1 & 4095;
                                                        class32.field2105[var36 - 1][var37 - 1] = 3;
                                                        class32.field2103[var36 - 1][var37 - 1] = var27;
                                                        break;
                                                    }

                                                    if ((var24[var25 - 1][var28 + (var26 - 1)] & 19136830) != 0 || (var24[var28 + (var25 - 1)][var26 - 1] & 19136911) != 0) {
                                                        break;
                                                    }

                                                    ++var28;
                                                }
                                            }

                                            if (var36 < 128 - var8 && var37 > 0 && class32.field2105[var36 + 1][var37 - 1] == 0 && (var24[var25 + var8][var26 - 1] & 19136899) == 0) {
                                                var28 = 1;

                                                while (true) {
                                                    if (var28 >= var8) {
                                                        class32.field2106[var39] = var16 + 1;
                                                        class32.field2110[var39] = var17 - 1;
                                                        var39 = var39 + 1 & 4095;
                                                        class32.field2105[var36 + 1][var37 - 1] = 9;
                                                        class32.field2103[var36 + 1][var37 - 1] = var27;
                                                        break;
                                                    }

                                                    if ((var24[var25 + var8][var28 + (var26 - 1)] & 19136995) != 0 || (var24[var25 + var28][var26 - 1] & 19136911) != 0) {
                                                        break;
                                                    }

                                                    ++var28;
                                                }
                                            }

                                            if (var36 > 0 && var37 < 128 - var8 && class32.field2105[var36 - 1][var37 + 1] == 0 && (var24[var25 - 1][var8 + var26] & 19136824) == 0) {
                                                for (var28 = 1; var28 < var8; ++var28) {
                                                    if ((var24[var25 - 1][var26 + var28] & 19136830) != 0 || (var24[var28 + (var25 - 1)][var26 + var8] & 19137016) != 0) {
                                                        continue label616;
                                                    }
                                                }

                                                class32.field2106[var39] = var16 - 1;
                                                class32.field2110[var39] = var17 + 1;
                                                var39 = var39 + 1 & 4095;
                                                class32.field2105[var36 - 1][var37 + 1] = 6;
                                                class32.field2103[var36 - 1][var37 + 1] = var27;
                                            }
                                        } while (var36 >= 128 - var8);
                                    } while (var37 >= 128 - var8);
                                } while (class32.field2105[var36 + 1][var37 + 1] != 0);
                            } while ((var24[var25 + var8][var26 + var8] & 19136992) != 0);

                            for (var28 = 1; var28 < var8; ++var28) {
                                if ((var24[var25 + var28][var8 + var26] & 19137016) != 0 || (var24[var8 + var25][var28 + var26] & 19136995) != 0) {
                                    continue label639;
                                }
                            }

                            class32.field2106[var39] = var16 + 1;
                            class32.field2110[var39] = var17 + 1;
                            var39 = var39 + 1 & 4095;
                            class32.field2105[var36 + 1][var37 + 1] = 12;
                            class32.field2103[var36 + 1][var37 + 1] = var27;
                        }
                    }

                    var34 = var35;
                }

                int var7;
                label697:
                {
                    var15 = var4 - 64;
                    var16 = var5 - 64;
                    var17 = class259.field2809;
                    var36 = class32.field2107;
                    if (!var34) {
                        var37 = Integer.MAX_VALUE;
                        var20 = Integer.MAX_VALUE;
                        byte var38 = 10;
                        var39 = var10.field2116;
                        var23 = var10.field2112;
                        int var33 = var10.field2114;
                        var25 = var10.field2115;

                        for (var26 = var39 - var38; var26 <= var39 + var38; ++var26) {
                            for (var27 = var23 - var38; var27 <= var23 + var38; ++var27) {
                                var28 = var26 - var15;
                                int var29 = var27 - var16;
                                if (var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class32.field2103[var28][var29] < 100) {
                                    int var30 = 0;
                                    if (var26 < var39) {
                                        var30 = var39 - var26;
                                    } else if (var26 > var33 + var39 - 1) {
                                        var30 = var26 - (var39 + var33 - 1);
                                    }

                                    int var31 = 0;
                                    if (var27 < var23) {
                                        var31 = var23 - var27;
                                    } else if (var27 > var25 + var23 - 1) {
                                        var31 = var27 - (var23 + var25 - 1);
                                    }

                                    int var32 = var30 * var30 + var31 * var31;
                                    if (var32 < var37 || var32 == var37 && class32.field2103[var28][var29] < var20) {
                                        var37 = var32;
                                        var20 = class32.field2103[var28][var29];
                                        var17 = var26;
                                        var36 = var27;
                                    }
                                }
                            }
                        }

                        if (var37 == Integer.MAX_VALUE) {
                            var7 = -1;
                            break label697;
                        }
                    }

                    if (var17 == var4 && var5 == var36) {
                        var7 = 0;
                    } else {
                        var19 = 0;
                        class32.field2106[var19] = var17;
                        var37 = var19 + 1;
                        class32.field2110[var19] = var36;

                        for (var20 = var21 = class32.field2105[var17 - var15][var36 - var16]; var17 != var4 || var36 != var5; var20 = class32.field2105[var17 - var15][var36 - var16]) {
                            if (var21 != var20) {
                                var21 = var20;
                                class32.field2106[var37] = var17;
                                class32.field2110[var37++] = var36;
                            }

                            if ((var20 & 2) != 0) {
                                ++var17;
                            } else if ((var20 & 8) != 0) {
                                --var17;
                            }

                            if ((var20 & 1) != 0) {
                                ++var36;
                            } else if ((var20 & 4) != 0) {
                                --var36;
                            }
                        }

                        var39 = 0;

                        while (var37-- > 0) {
                            var12[var39] = class32.field2106[var37];
                            var13[var39++] = class32.field2110[var37];
                            if (var39 >= var12.length) {
                                break;
                            }
                        }

                        var7 = var39;
                    }
                }

                var14 = var7;
                if (var7 >= 1) {
                    for (var15 = 0; var15 < var14 - 1; ++var15) {
                        var0.method2912(client.field918[var15], client.field900[var15], var3);
                    }

                }
            }
        }
    }
}
