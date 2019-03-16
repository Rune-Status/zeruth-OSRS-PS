package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public class class218 extends TaskDataNode {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgi;"
    )
    Deque field2615;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lcn;"
    )
    class184 field2617;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lhg;"
    )
    class257 field2616;

    @ObfuscatedSignature(
            signature = "(Lhg;)V"
    )
    class218(class257 var1) {
        this.field2615 = new Deque();
        this.field2617 = new class184();
        this.field2616 = var1;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lho;II)V",
            garbageValue = "-1802288935"
    )
    void method4390(class112 var1, int var2) {
        if ((this.field2616.field2548[var1.field2585] & 4) != 0 && var1.field2577 < 0) {
            int var3 = this.field2616.field2546[var1.field2585] / AbstractSoundSystem.sampleRate;
            int var4 = (var3 + 1048575 - var1.field2567) / var3;
            var1.field2567 = var3 * var2 + var1.field2567 & 1048575;
            if (var4 <= var2) {
                if (this.field2616.field2540[var1.field2585] == 0) {
                    var1.field2581 = class266.method5057(var1.field2565, var1.field2581.method5054(), var1.field2581.method5063(), var1.field2581.method5064());
                } else {
                    var1.field2581 = class266.method5057(var1.field2565, var1.field2581.method5054(), 0, var1.field2581.method5064());
                    this.field2616.method4861(var1, var1.field2571.field2601[var1.field2568] < 0);
                }

                if (var1.field2571.field2601[var1.field2568] < 0) {
                    var1.field2581.method5059(-1);
                }

                var2 = var1.field2567 / var3;
            }
        }

        var1.field2581.vmethod6450(var2);
    }

    @ObfuscatedName("x")
    protected void vmethod6450(int var1) {
        this.field2617.vmethod6450(var1);

        for (class112 var3 = (class112) this.field2615.method4373(); var3 != null; var3 = (class112) this.field2615.method4358()) {
            if (!this.field2616.method4882(var3)) {
                int var2 = var1;

                do {
                    if (var2 <= var3.field2576) {
                        this.method4390(var3, var2);
                        var3.field2576 -= var2;
                        break;
                    }

                    this.method4390(var3, var3.field2576);
                    var2 -= var3.field2576;
                } while (!this.field2616.method4961(var3, (int[]) null, 0, var2));
            }
        }

    }

    @ObfuscatedName("m")
    protected int vmethod6465() {
        return 0;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "()Ldz;"
    )
    protected TaskDataNode vmethod6446() {
        class112 var1;
        do {
            var1 = (class112) this.field2615.method4358();
            if (var1 == null) {
                return null;
            }
        } while (var1.field2581 == null);

        return var1.field2581;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "()Ldz;"
    )
    protected TaskDataNode vmethod6454() {
        class112 var1 = (class112) this.field2615.method4373();
        return (TaskDataNode) (var1 == null ? null : (var1.field2581 != null ? var1.field2581 : this.vmethod6446()));
    }

    @ObfuscatedName("d")
    protected void vmethod6449(int[] var1, int var2, int var3) {
        this.field2617.vmethod6449(var1, var2, var3);

        for (class112 var6 = (class112) this.field2615.method4373(); var6 != null; var6 = (class112) this.field2615.method4358()) {
            if (!this.field2616.method4882(var6)) {
                int var4 = var2;
                int var5 = var3;

                do {
                    if (var5 <= var6.field2576) {
                        this.method4387(var6, var1, var4, var5, var4 + var5);
                        var6.field2576 -= var5;
                        break;
                    }

                    this.method4387(var6, var1, var4, var6.field2576, var4 + var5);
                    var4 += var6.field2576;
                    var5 -= var6.field2576;
                } while (!this.field2616.method4961(var6, var1, var4, var5));
            }
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lho;[IIIII)V",
            garbageValue = "617494299"
    )
    void method4387(class112 var1, int[] var2, int var3, int var4, int var5) {
        if ((this.field2616.field2548[var1.field2585] & 4) != 0 && var1.field2577 < 0) {
            int var6 = this.field2616.field2546[var1.field2585] / AbstractSoundSystem.sampleRate;

            while (true) {
                int var7 = (var6 + 1048575 - var1.field2567) / var6;
                if (var7 > var4) {
                    var1.field2567 += var6 * var4;
                    break;
                }

                var1.field2581.vmethod6449(var2, var3, var7);
                var3 += var7;
                var4 -= var7;
                var1.field2567 += var7 * var6 - 1048576;
                int var8 = AbstractSoundSystem.sampleRate / 100;
                int var9 = 262144 / var6;
                if (var9 < var8) {
                    var8 = var9;
                }

                class266 var10 = var1.field2581;
                if (this.field2616.field2540[var1.field2585] == 0) {
                    var1.field2581 = class266.method5057(var1.field2565, var10.method5054(), var10.method5063(), var10.method5064());
                } else {
                    var1.field2581 = class266.method5057(var1.field2565, var10.method5054(), 0, var10.method5064());
                    this.field2616.method4861(var1, var1.field2571.field2601[var1.field2568] < 0);
                    var1.field2581.method5160(var8, var10.method5063());
                }

                if (var1.field2571.field2601[var1.field2568] < 0) {
                    var1.field2581.method5059(-1);
                }

                var10.method5070(var8);
                var10.vmethod6449(var2, var3, var5 - var3);
                if (var10.method5074()) {
                    this.field2617.method3581(var10);
                }
            }
        }

        var1.field2581.vmethod6449(var2, var3, var4);
    }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            signature = "(ILcx;ZB)I",
            garbageValue = "-103"
    )
    static int method4412(int var0, class106 var1, boolean var2) {
        String var3;
        if (var0 == 3100) {
            var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
            ChatLine.method5672(0, "", var3);
            return 1;
        } else if (var0 == 3101) {
            class228.intStackSize -= 2;
            class115.method1976(class4.localPlayer, class48.intStack[class228.intStackSize], class48.intStack[class228.intStackSize + 1]);
            return 1;
        } else if (var0 == 3103) {
            if (!class48.field1079) {
                class48.field1078 = true;
            }

            return 1;
        } else {
            int var10;
            if (var0 == 3104) {
                var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                var10 = 0;
                if (class120.method2043(var3)) {
                    var10 = LoginProt.method871(var3);
                }

                TcpConnectionMessage var12 = FaceNormal.method5726(ClientProt.RESUME_P_COUNTDIALOG, client.serverConnection.isaac);
                var12.packetBuffer.method6230(var10);
                client.serverConnection.method5881(var12);
                return 1;
            } else {
                TcpConnectionMessage var14;
                if (var0 == 3105) {
                    var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                    var14 = FaceNormal.method5726(ClientProt.RESUME_P_NAMEDIALOG, client.serverConnection.isaac);
                    var14.packetBuffer.putByte(var3.length() + 1);
                    var14.packetBuffer.method6198(var3);
                    client.serverConnection.method5881(var14);
                    return 1;
                } else if (var0 == 3106) {
                    var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                    var14 = FaceNormal.method5726(ClientProt.RESUME_P_STRINGDIALOG, client.serverConnection.isaac);
                    var14.packetBuffer.putByte(var3.length() + 1);
                    var14.packetBuffer.method6198(var3);
                    client.serverConnection.method5881(var14);
                    return 1;
                } else {
                    String var7;
                    int var15;
                    if (var0 == 3107) {
                        var15 = class48.intStack[--class228.intStackSize];
                        var7 = class48.scriptStringStack[--class48.scriptStringStackSize];
                        MapIconReference.method4835(var15, var7);
                        return 1;
                    } else if (var0 == 3108) {
                        class228.intStackSize -= 3;
                        var15 = class48.intStack[class228.intStackSize];
                        var10 = class48.intStack[class228.intStackSize + 1];
                        int var9 = class48.intStack[class228.intStackSize + 2];
                        ComponentType var13 = WorldMapType1.method2440(var9);
                        Occluder.method4633(var13, var15, var10);
                        return 1;
                    } else if (var0 == 3109) {
                        class228.intStackSize -= 2;
                        var15 = class48.intStack[class228.intStackSize];
                        var10 = class48.intStack[class228.intStackSize + 1];
                        ComponentType var11 = var2 ? class113.field75 : class48.field1080;
                        Occluder.method4633(var11, var15, var10);
                        return 1;
                    } else if (var0 == 3110) {
                        WorldMapType3.middleMouseMovesCamera = class48.intStack[--class228.intStackSize] == 1;
                        return 1;
                    } else if (var0 == 3111) {
                        class48.intStack[++class228.intStackSize - 1] = GameEngine.options.hideRoofs ? 1 : 0;
                        return 1;
                    } else if (var0 == 3112) {
                        GameEngine.options.hideRoofs = class48.intStack[--class228.intStackSize] == 1;
                        PlayerEntity.method2919();
                        return 1;
                    } else if (var0 == 3113) {
                        var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                        boolean var4 = class48.intStack[--class228.intStackSize] == 1;
                        UrlRequest.method5574(var3, var4, false);
                        return 1;
                    } else if (var0 == 3115) {
                        var15 = class48.intStack[--class228.intStackSize];
                        var14 = FaceNormal.method5726(ClientProt.RESUME_P_OBJDIALOG, client.serverConnection.isaac);
                        var14.packetBuffer.putShort(var15);
                        client.serverConnection.method5881(var14);
                        return 1;
                    } else if (var0 == 3116) {
                        var15 = class48.intStack[--class228.intStackSize];
                        class48.scriptStringStackSize -= 2;
                        var7 = class48.scriptStringStack[class48.scriptStringStackSize];
                        String var5 = class48.scriptStringStack[class48.scriptStringStackSize + 1];
                        if (var7.length() > 500) {
                            return 1;
                        } else if (var5.length() > 500) {
                            return 1;
                        } else {
                            TcpConnectionMessage var6 = FaceNormal.method5726(ClientProt.BUG_REPORT, client.serverConnection.isaac);
                            var6.packetBuffer.putShort(1 + AbstractSoundSystem.method338(var7) + AbstractSoundSystem.method338(var5));
                            var6.packetBuffer.method6198(var7);
                            var6.packetBuffer.putByte(var15);
                            var6.packetBuffer.method6198(var5);
                            client.serverConnection.method5881(var6);
                            return 1;
                        }
                    } else if (var0 == 3117) {
                        client.field789 = class48.intStack[--class228.intStackSize] == 1;
                        return 1;
                    } else if (var0 == 3118) {
                        client.field791 = class48.intStack[--class228.intStackSize] == 1;
                        return 1;
                    } else if (var0 == 3119) {
                        client.field762 = class48.intStack[--class228.intStackSize] == 1;
                        return 1;
                    } else if (var0 == 3120) {
                        if (class48.intStack[--class228.intStackSize] == 1) {
                            client.playerNameMask |= 1;
                        } else {
                            client.playerNameMask &= -2;
                        }

                        return 1;
                    } else if (var0 == 3121) {
                        if (class48.intStack[--class228.intStackSize] == 1) {
                            client.playerNameMask |= 2;
                        } else {
                            client.playerNameMask &= -3;
                        }

                        return 1;
                    } else if (var0 == 3122) {
                        if (class48.intStack[--class228.intStackSize] == 1) {
                            client.playerNameMask |= 4;
                        } else {
                            client.playerNameMask &= -5;
                        }

                        return 1;
                    } else if (var0 == 3123) {
                        if (class48.intStack[--class228.intStackSize] == 1) {
                            client.playerNameMask |= 8;
                        } else {
                            client.playerNameMask &= -9;
                        }

                        return 1;
                    } else if (var0 == 3124) {
                        client.playerNameMask = 0;
                        return 1;
                    } else if (var0 == 3125) {
                        client.field748 = class48.intStack[--class228.intStackSize] == 1;
                        return 1;
                    } else if (var0 == 3126) {
                        client.field758 = class48.intStack[--class228.intStackSize] == 1;
                        return 1;
                    } else if (var0 == 3127) {
                        class9.method139(class48.intStack[--class228.intStackSize] == 1);
                        return 1;
                    } else if (var0 == 3128) {
                        class48.intStack[++class228.intStackSize - 1] = ChatLine.method5673() ? 1 : 0;
                        return 1;
                    } else if (var0 == 3129) {
                        class228.intStackSize -= 2;
                        client.field723 = class48.intStack[class228.intStackSize];
                        client.field724 = class48.intStack[class228.intStackSize + 1];
                        return 1;
                    } else if (var0 == 3130) {
                        class228.intStackSize -= 2;
                        return 1;
                    } else if (var0 == 3131) {
                        --class228.intStackSize;
                        return 1;
                    } else if (var0 == 3132) {
                        class48.intStack[++class228.intStackSize - 1] = FriendManager.canvasWidth;
                        class48.intStack[++class228.intStackSize - 1] = class230.canvasHeight;
                        return 1;
                    } else if (var0 == 3133) {
                        --class228.intStackSize;
                        return 1;
                    } else if (var0 == 3134) {
                        return 1;
                    } else if (var0 == 3135) {
                        class228.intStackSize -= 2;
                        return 1;
                    } else if (var0 == 3136) {
                        client.field805 = 3;
                        client.field642 = class48.intStack[--class228.intStackSize];
                        return 1;
                    } else if (var0 == 3137) {
                        client.field805 = 2;
                        client.field642 = class48.intStack[--class228.intStackSize];
                        return 1;
                    } else if (var0 == 3138) {
                        client.field805 = 0;
                        return 1;
                    } else if (var0 == 3139) {
                        client.field805 = 1;
                        return 1;
                    } else if (var0 == 3140) {
                        client.field805 = 3;
                        client.field642 = var2 ? class113.field75.id : class48.field1080.id;
                        return 1;
                    } else {
                        boolean var8;
                        if (var0 == 3141) {
                            var8 = class48.intStack[--class228.intStackSize] == 1;
                            GameEngine.options.hideUsername = var8;
                            PlayerEntity.method2919();
                            return 1;
                        } else if (var0 == 3142) {
                            class48.intStack[++class228.intStackSize - 1] = GameEngine.options.hideUsername ? 1 : 0;
                            return 1;
                        } else if (var0 == 3143) {
                            var8 = class48.intStack[--class228.intStackSize] == 1;
                            client.Login_isUsernameRemembered = var8;
                            if (!var8) {
                                GameEngine.options.rememberedUsername = "";
                                PlayerEntity.method2919();
                            }

                            return 1;
                        } else if (var0 == 3144) {
                            class48.intStack[++class228.intStackSize - 1] = client.Login_isUsernameRemembered ? 1 : 0;
                            return 1;
                        } else {
                            return var0 == 3145 ? 1 : 2;
                        }
                    }
                }
            }
        }
    }
}
