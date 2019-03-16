package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Hashtable;

@ObfuscatedName("fg")
public class class76 {
    @ObfuscatedName("e")
    static Hashtable field2040;
    @ObfuscatedName("g")
    static boolean field2043;

    static {
        field2043 = false;
        field2040 = new Hashtable(16);
    }

    @ObfuscatedName("fy")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "102"
    )
    static final void method1147() {
        if (class116.soundSystem1 != null) {
            class116.soundSystem1.method280();
        }

        if (client.soundSystem0 != null) {
            client.soundSystem0.method280();
        }

    }

    @ObfuscatedName("hk")
    @ObfuscatedSignature(
            signature = "(Lfc;B)V",
            garbageValue = "85"
    )
    static final void method1145(ZoneProt var0) {
        Bit var1 = client.serverConnection.clientPacket;
        int var2;
        int var3;
        int var4;
        int var5;
        int var6;
        int var7;
        if (ZoneProt.MAP_ANIM == var0) {
            var2 = var1.readUnsignedShort();
            var3 = var1.getByte128();
            var4 = var1.readShort128();
            var5 = var1.readUnsignedByte();
            var6 = (var5 >> 4 & 7) + class91.updateZoneX;
            var7 = (var5 & 7) + CombatInfoListHolder.updateZoneY;
            if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                var6 = var6 * 128 + 64;
                var7 = var7 * 128 + 64;
                SpotAnimation var39 = new SpotAnimation(var2, class228.level, var6, var7, MilliTimer.method2824(var6, var7, class228.level) - var3, var4, client.gameCycle);
                client.spotAnimationDeque.method4351(var39);
            }

        } else {
            int var31;
            if (ZoneProt.LOC_DEL == var0) {
                var2 = var1.read128Byte();
                var3 = var2 >> 2;
                var4 = var2 & 3;
                var5 = client.field704[var3];
                var6 = var1.read128Byte();
                var7 = (var6 >> 4 & 7) + class91.updateZoneX;
                var31 = (var6 & 7) + CombatInfoListHolder.updateZoneY;
                if (var7 >= 0 && var31 >= 0 && var7 < 104 && var31 < 104) {
                    class77.method1152(class228.level, var7, var31, var5, -1, var3, var4, 0, -1);
                }

                System.out.println("[DestructObject] " + var2);
                System.out.println("[DestructObject] " + var6);

            } else if (ZoneProt.ALTER_GROUND_ITEM == var0) {
                var2 = var1.readShortLE();
                var3 = var1.readLEShortA();
                var4 = var1.readShortLE();
                var5 = var1.getByte128();

                var6 = (var5 >> 4 & 7) + class91.updateZoneX;
                var7 = (var5 & 7) + CombatInfoListHolder.updateZoneY;
                if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                    Deque var8 = client.groundItemDeque[class228.level][var6][var7];
                    if (var8 != null) {
                        for (Item var9 = (Item) var8.method4373(); var9 != null; var9 = (Item) var8.method4358()) {
                            if ((var2 & 32767) == var9.id && var4 == var9.quantity) {
                                var9.quantityChanged(var3);
                                var9.quantity = var3;
                                break;
                            }
                        }

                        class89.method1487(var6, var7);
                    }
                }

            } else {
                int var32;
                if (ZoneProt.LOC_ADD_CHANGE == var0) {
                    var2 = var1.getByte128();
                    var3 = (var2 >> 4 & 7) + class91.updateZoneX;
                    var4 = (var2 & 7) + CombatInfoListHolder.updateZoneY;
                    var5 = var1.read128Byte();
                    var6 = var5 >> 2;
                    var7 = var5 & 3;
                    var31 = client.field704[var6];
                    var32 = var1.readShort128();

                    System.out.println("[ConstructObject] " + var2);
                    System.out.println("[ConstructObject] " + var5);
                    System.out.println("[ConstructObject] " + var32);

                    if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                        class77.method1152(class228.level, var3, var4, var31, var32, var6, var7, 0, -1);
                    }

                } else {
                    int var10;
                    if (ZoneProt.SOUND_AREA == var0) {
                        var2 = var1.readUnsignedByte();
                        var3 = (var2 >> 4 & 7) + class91.updateZoneX;
                        var4 = (var2 & 7) + CombatInfoListHolder.updateZoneY;
                        var5 = var1.read128Byte();
                        var6 = var1.getByte128();
                        var7 = var6 >> 4 & 15;
                        var31 = var6 & 7;
                        var32 = var1.readLEShortA();
                        if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                            var10 = var7 + 1;
                            if (class4.localPlayer.pathX[0] >= var3 - var10 && class4.localPlayer.pathX[0] <= var10 + var3 && class4.localPlayer.pathY[0] >= var4 - var10 && class4.localPlayer.pathY[0] <= var4 + var10 && client.field881 != 0 && var31 > 0 && client.queuedSoundEffectCount < 50) {
                                client.queuedSoundEffectIDs[client.queuedSoundEffectCount] = var32;
                                client.unknownSoundValues1[client.queuedSoundEffectCount] = var31;
                                client.unknownSoundValues2[client.queuedSoundEffectCount] = var5;
                                client.audioEffects[client.queuedSoundEffectCount] = null;
                                client.soundLocations[client.queuedSoundEffectCount] = var7 + (var4 << 8) + (var3 << 16);
                                ++client.queuedSoundEffectCount;
                            }
                        }
                    }

                    int var40;
                    if (ZoneProt.LOC_ANIM == var0) {
                        var2 = var1.read128Byte();
                        var3 = var2 >> 2;
                        var4 = var2 & 3;
                        var5 = client.field704[var3];
                        var6 = var1.readN();
                        var7 = (var6 >> 4 & 7) + class91.updateZoneX;
                        var31 = (var6 & 7) + CombatInfoListHolder.updateZoneY;
                        var32 = var1.readUnsignedShort();
                        if (var7 >= 0 && var31 >= 0 && var7 < 103 && var31 < 103) {
                            if (var5 == 0) {
                                WallObject var33 = class131.sceneManager.method3845(class228.level, var7, var31);
                                if (var33 != null) {
                                    var40 = SubInterface.method2437(var33.hash);
                                    if (var3 == 2) {
                                        var33.entity1 = new Location(var40, 2, var4 + 4, class228.level, var7, var31, var32, false, var33.entity1);
                                        var33.entity2 = new Location(var40, 2, var4 + 1 & 3, class228.level, var7, var31, var32, false, var33.entity2);
                                    } else {
                                        var33.entity1 = new Location(var40, var3, var4, class228.level, var7, var31, var32, false, var33.entity1);
                                    }
                                }
                            }

                            if (var5 == 1) {
                                DecorativeObject var43 = class131.sceneManager.method3968(class228.level, var7, var31);
                                if (var43 != null) {
                                    var40 = SubInterface.method2437(var43.hash);
                                    if (var3 != 4 && var3 != 5) {
                                        if (var3 == 6) {
                                            var43.entity1 = new Location(var40, 4, var4 + 4, class228.level, var7, var31, var32, false, var43.entity1);
                                        } else if (var3 == 7) {
                                            var43.entity1 = new Location(var40, 4, (var4 + 2 & 3) + 4, class228.level, var7, var31, var32, false, var43.entity1);
                                        } else if (var3 == 8) {
                                            var43.entity1 = new Location(var40, 4, var4 + 4, class228.level, var7, var31, var32, false, var43.entity1);
                                            var43.entity2 = new Location(var40, 4, (var4 + 2 & 3) + 4, class228.level, var7, var31, var32, false, var43.entity2);
                                        }
                                    } else {
                                        var43.entity1 = new Location(var40, 4, var4, class228.level, var7, var31, var32, false, var43.entity1);
                                    }
                                }
                            }

                            if (var5 == 2) {
                                GameObject var44 = class131.sceneManager.method3819(class228.level, var7, var31);
                                if (var3 == 11) {
                                    var3 = 10;
                                }

                                if (var44 != null) {
                                    var44.entity = new Location(SubInterface.method2437(var44.hash), var3, var4, class228.level, var7, var31, var32, false, var44.entity);
                                }
                            }

                            if (var5 == 3) {
                                GroundObject var45 = class131.sceneManager.method3855(class228.level, var7, var31);
                                if (var45 != null) {
                                    var45.entity = new Location(SubInterface.method2437(var45.hash), 22, var4, class228.level, var7, var31, var32, false, var45.entity);
                                }
                            }
                        }

                    } else {
                        int var12;
                        byte var13;
                        int var14;
                        if (ZoneProt.MAP_PROJANIM == var0) {
                            var2 = var1.read128Byte() * 4;
                            var3 = var1.readUnsignedShort();
                            var4 = var1.readShort128();
                            var5 = var1.read128Byte() * 4;
                            var6 = var1.method6119();
                            var7 = var1.readUnsignedByte();
                            var31 = var1.read128Byte();
                            var32 = var1.readShortLE();
                            var10 = var1.getByte128();
                            var40 = (var10 >> 4 & 7) + class91.updateZoneX;
                            var12 = (var10 & 7) + CombatInfoListHolder.updateZoneY;
                            var13 = var1.readByte128();
                            byte var41 = var1.method6111();
                            var14 = var41 + var40;
                            int var42 = var13 + var12;
                            if (var40 >= 0 && var12 >= 0 && var40 < 104 && var12 < 104 && var14 >= 0 && var42 >= 0 && var14 < 104 && var42 < 104 && var4 != 65535) {
                                var40 = var40 * 128 + 64;
                                var12 = var12 * 128 + 64;
                                var14 = var14 * 128 + 64;
                                var42 = var42 * 128 + 64;
                                ProjectileAnimation var15 = new ProjectileAnimation(var4, class228.level, var40, var12, MilliTimer.method2824(var40, var12, class228.level) - var5, var32 + client.gameCycle, var3 + client.gameCycle, var7, var31, var6, var2);
                                var15.method5583(var14, var42, MilliTimer.method2824(var14, var42, class228.level) - var2, var32 + client.gameCycle);
                                client.projectiles.method4351(var15);
                            }

                        } else {
                            Item var35;
                            if (ZoneProt.GROUND_ITEM_REMOVE == var0) {
                                var2 = var1.getByte128();
                                var3 = (var2 >> 4 & 7) + class91.updateZoneX;
                                var4 = (var2 & 7) + CombatInfoListHolder.updateZoneY;
                                var5 = var1.readLEShortA();

                                System.out.println("[ClearGroundItem] " + var2);
                                System.out.println("[ClearGroundItem] " + var5);

                                if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                                    Deque var34 = client.groundItemDeque[class228.level][var3][var4];
                                    if (var34 != null) {
                                        for (var35 = (Item) var34.method4373(); var35 != null; var35 = (Item) var34.method4358()) {
                                            if ((var5 & 32767) == var35.id) {
                                                var35.method6469();
                                                break;
                                            }
                                        }

                                        if (var34.method4373() == null) {
                                            client.groundItemDeque[class228.level][var3][var4] = null;
                                        }

                                        class89.method1487(var3, var4);
                                    }
                                }

                            } else {
                                if (ZoneProt.field2318 == var0) {
                                    byte var37 = var1.method6111();
                                    var3 = var1.readLEShortA();
                                    byte var38 = var1.method6111();
                                    var5 = var1.readShort128();
                                    var6 = var1.readUnsignedShort();
                                    var7 = var1.getByte128();
                                    var31 = var7 >> 2;
                                    var32 = var7 & 3;
                                    var10 = client.field704[var31];
                                    byte var11 = var1.readByte128();
                                    var12 = var1.readShortLE();
                                    var13 = var1.method6111();
                                    var14 = var1.readN();
                                    int var36 = (var14 >> 4 & 7) + class91.updateZoneX;
                                    int var16 = (var14 & 7) + CombatInfoListHolder.updateZoneY;
                                    PlayerEntity var17;
                                    if (var12 == client.localPlayerIndex) {
                                        var17 = class4.localPlayer;
                                    } else {
                                        var17 = client.players[var12];
                                    }

                                    if (var17 != null) {
                                        LocType var18 = class225.method4485(var5);
                                        int var19;
                                        int var20;
                                        if (var32 != 1 && var32 != 3) {
                                            var19 = var18.width;
                                            var20 = var18.length;
                                        } else {
                                            var19 = var18.length;
                                            var20 = var18.width;
                                        }

                                        int var21 = var36 + (var19 >> 1);
                                        int var22 = var36 + (var19 + 1 >> 1);
                                        int var23 = var16 + (var20 >> 1);
                                        int var24 = var16 + (var20 + 1 >> 1);
                                        int[][] var25 = class98.tileHeights[class228.level];
                                        int var26 = var25[var22][var24] + var25[var22][var23] + var25[var21][var23] + var25[var21][var24] >> 2;
                                        int var27 = (var36 << 7) + (var19 << 6);
                                        int var28 = (var16 << 7) + (var20 << 6);
                                        Model var29 = var18.method1714(var31, var32, var25, var27, var26, var28);
                                        if (var29 != null) {
                                            class77.method1152(class228.level, var36, var16, var10, -1, 0, 0, var6 + 1, var3 + 1);
                                            var17.animationCycleStart = var6 + client.gameCycle;
                                            var17.animationCycleEnd = var3 + client.gameCycle;
                                            var17.model = var29;
                                            var17.field616 = var36 * 128 + var19 * 64;
                                            var17.field612 = var16 * 128 + var20 * 64;
                                            var17.field610 = var26;
                                            byte var30;
                                            if (var37 > var13) {
                                                var30 = var37;
                                                var37 = var13;
                                                var13 = var30;
                                            }

                                            if (var11 > var38) {
                                                var30 = var11;
                                                var11 = var38;
                                                var38 = var30;
                                            }

                                            var17.field608 = var36 + var37;
                                            var17.field621 = var36 + var13;
                                            var17.field606 = var11 + var16;
                                            var17.field623 = var38 + var16;
                                        }
                                    }
                                }

                                if (ZoneProt.GROUND_ITEM_ADD == var0) {
                                    var2 = var1.readShort128();//
                                    var3 = var1.readLEShortA();//
                                    var4 = var1.getByte128();//byte

                                    System.out.println("GROUND_ITEM_ADD" + var2);
                                    System.out.println("GROUND_ITEM_ADD" + var3);
                                    System.out.println("GROUND_ITEM_ADD" + var4);

                                    var5 = (var4 >> 4 & 7) + class91.updateZoneX;
                                    var6 = (var4 & 7) + CombatInfoListHolder.updateZoneY;
                                    if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                                        var35 = new Item();
                                        var35.id = var3;
                                        var35.quantityChanged(var2);
                                        var35.quantity = var2;
                                        if (client.groundItemDeque[class228.level][var5][var6] == null) {
                                            client.groundItemDeque[class228.level][var5][var6] = new Deque();
                                        }

                                        client.groundItemDeque[class228.level][var5][var6].method4351(var35);
                                        class89.method1487(var5, var6);
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @ObfuscatedName("jw")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "30895243"
    )
    static final void method1149(int var0) {
        if (class232.method4564(var0)) {
            ComponentType[] var1 = class36.interfaces[var0];

            for (int var2 = 0; var2 < var1.length; ++var2) {
                ComponentType var3 = var1[var2];
                if (var3 != null) {
                    var3.field2795 = 0;
                    var3.field2750 = 0;
                }
            }

        }
    }
}
