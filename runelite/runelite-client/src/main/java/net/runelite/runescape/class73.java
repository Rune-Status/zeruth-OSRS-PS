package net.runelite.runescape;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNPCComposition;

@ObfuscatedName("bz")
public class class73 {
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 645679591
    )
    final int field529;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1664334997
    )
    int field530;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lih;"
    )
    final Js5 field528;

    @ObfuscatedSignature(
            signature = "(Lih;Ljava/lang/String;)V"
    )
    class73(Js5 var1, String var2) {
        this.field530 = 0;
        this.field528 = var1;
        this.field529 = var1.method1526();
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1238623850"
    )
    boolean method1123() {
        this.field530 = 0;

        for (int var1 = 0; var1 < this.field529; ++var1) {
            if (!this.field528.method2677(var1) || this.field528.method2647(var1)) {
                ++this.field530;
            }
        }

        return this.field530 >= this.field529;
    }

    @ObfuscatedName("ih")
    @ObfuscatedSignature(
            signature = "(Lhn;IIIIIII)V",
            garbageValue = "130276367"
    )
    static final void method1128(ComponentType var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        if (client.field694) {
            client.field802 = 32;
        } else {
            client.field802 = 0;
        }

        client.field694 = false;
        int var7;
        if (MouseInput.mouseCurrentButton == 1 || !WorldMapType3.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) {
            if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
                var0.scrollY -= 4;
                class208.method4144(var0);
            } else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
                var0.scrollY += 4;
                class208.method4144(var0);
            } else if (var5 >= var1 - client.field802 && var5 < client.field802 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
                var7 = var3 * (var3 - 32) / var4;
                if (var7 < 8) {
                    var7 = 8;
                }

                int var8 = var6 - var2 - 16 - var7 / 2;
                int var9 = var3 - 32 - var7;
                var0.scrollY = var8 * (var4 - var3) / var9;
                class208.method4144(var0);
                client.field694 = true;
            }
        }

        if (client.field841 != 0) {
            var7 = var0.width;
            if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
                var0.scrollY += client.field841 * 45;
                class208.method4144(var0);
            }
        }

    }

    @ObfuscatedName("jq")
    @ObfuscatedSignature(
            signature = "([Lhn;IB)V",
            garbageValue = "35"
    )
    static final void method1125(ComponentType[] var0, int var1) {
        for (int var2 = 0; var2 < var0.length; ++var2) {
            ComponentType var3 = var0[var2];
            if (var3 != null && var3.layer == var1 && (!var3.isIf3 || !GameCanvas.method894(var3))) {
                int var5;
                if (var3.type == 0) {
                    if (!var3.isIf3 && GameCanvas.method894(var3) && var3 != class133.field1993) {
                        continue;
                    }

                    method1125(var0, var3.id);
                    if (var3.children != null) {
                        method1125(var3.children, var3.id);
                    }

                    SubInterface var4 = (SubInterface) client.subInterfaces.method380((long) var3.id);
                    if (var4 != null) {
                        var5 = var4.id;
                        if (class232.method4564(var5)) {
                            method1125(class36.interfaces[var5], -1);
                        }
                    }
                }

                if (var3.type == 6) {
                    if (var3.animation != -1 || var3.field2715 != -1) {
                        boolean var7 = WorldMapType1.method2466(var3);
                        if (var7) {
                            var5 = var3.field2715;
                        } else {
                            var5 = var3.animation;
                        }

                        if (var5 != -1) {
                            Sequence var6 = MapCacheArchiveNames.method2149(var5);

                            for (var3.field2750 += client.field705; var3.field2750 > var6.frameLengths[var3.field2795]; class208.method4144(var3)) {
                                var3.field2750 -= var6.frameLengths[var3.field2795];
                                ++var3.field2795;
                                if (var3.field2795 >= var6.frameIDs.length) {
                                    var3.field2795 -= var6.frameStep;
                                    if (var3.field2795 < 0 || var3.field2795 >= var6.frameIDs.length) {
                                        var3.field2795 = 0;
                                    }
                                }
                            }
                        }
                    }

                    if (var3.field2723 != 0 && !var3.isIf3) {
                        int var8 = var3.field2723 >> 16;
                        var5 = var3.field2723 << 16 >> 16;
                        var8 *= client.field705;
                        var5 *= client.field705;
                        var3.xan2d = var8 + var3.xan2d & 2047;
                        var3.yan2d = var5 + var3.yan2d & 2047;
                        class208.method4144(var3);
                    }
                }
            }
        }

    }

    @ObfuscatedName("hw")
    @ObfuscatedSignature(
            signature = "(ZLge;B)V",
            garbageValue = "4"
    )
    @Export("updateNPCs")
    static final void updateNPCs(boolean var0, Bit var1) {
        client.updateNpcs(var0, var1);
        client.npcsToRemoveCount = 0;
        client.extendedInfoNpcCount = 0;
        Bit var2 = client.serverConnection.clientPacket;
        var2.method2837();
        int var3 = var2.getBits(8);
        int var4;
        if (var3 < client.highResolutionNpcCount) {
            for (var4 = var3; var4 < client.highResolutionNpcCount; ++var4) {
                client.npcIndexesToRemove[++client.npcsToRemoveCount - 1] = client.highResolutionNpcIndexes[var4];
            }
        }

        if (var3 > client.highResolutionNpcCount) {
            throw new RuntimeException("");
        } else {
            client.highResolutionNpcCount = 0;

            int var5;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            for (var4 = 0; var4 < var3; ++var4) {
                var5 = client.highResolutionNpcIndexes[var4];
                NPCEntity var6 = client.npcs[var5];
                var7 = var2.getBits(1);
                if (var7 == 0) {
                    client.highResolutionNpcIndexes[++client.highResolutionNpcCount - 1] = var5;
                    var6.lastUpdatedAt = client.gameCycle;
                } else {
                    var8 = var2.getBits(2);
                    if (var8 == 0) {
                        client.highResolutionNpcIndexes[++client.highResolutionNpcCount - 1] = var5;
                        var6.lastUpdatedAt = client.gameCycle;
                        client.extendedInfoNpcIndexes[++client.extendedInfoNpcCount - 1] = var5;
                    } else if (var8 == 1) {
                        client.highResolutionNpcIndexes[++client.highResolutionNpcCount - 1] = var5;
                        var6.lastUpdatedAt = client.gameCycle;
                        var9 = var2.getBits(3);
                        var6.method2152(var9, (byte) 1);
                        var10 = var2.getBits(1);
                        if (var10 == 1) {
                            client.extendedInfoNpcIndexes[++client.extendedInfoNpcCount - 1] = var5;
                        }
                    } else if (var8 == 2) {
                        client.highResolutionNpcIndexes[++client.highResolutionNpcCount - 1] = var5;
                        var6.lastUpdatedAt = client.gameCycle;
                        var9 = var2.getBits(3);
                        var6.method2152(var9, (byte) 2);
                        var10 = var2.getBits(3);
                        var6.method2152(var10, (byte) 2);
                        var11 = var2.getBits(1);
                        if (var11 == 1) {
                            client.extendedInfoNpcIndexes[++client.extendedInfoNpcCount - 1] = var5;
                        }
                    } else if (var8 == 3) {
                        client.npcIndexesToRemove[++client.npcsToRemoveCount - 1] = var5;
                        System.out.println("[NPC Update] Remove NPC from region.");
                    }
                }
            }

            int var14;
            NPCEntity var15;
            int var16;
            NPCType var10001;
            while (var1.method2835(client.serverConnection.currentPacketSize) >= 27) {
                var14 = var1.getBits(15);
                if (var14 == 32767) {
                    break;
                }

                boolean var17 = false;
                if (client.npcs[var14] == null) {
                    client.npcs[var14] = new NPCEntity();
                    client.cachedNPCsChanged(var14);
                    var17 = true;
                }

                var15 = client.npcs[var14];
                client.highResolutionNpcIndexes[++client.highResolutionNpcCount - 1] = var14;
                var15.lastUpdatedAt = client.gameCycle;
                if (var0) {
                    var5 = var1.getBits(8);
                    if (var5 > 127) {
                        var5 -= 256;
                    }
                } else {
                    var5 = var1.getBits(5);
                    if (var5 > 15) {
                        var5 -= 32;
                    }
                }

                var16 = var1.getBits(1);
                var7 = client.npcFacingDirections[var1.getBits(3)];
                if (var17) {
                    var15.orientation = var15.angle = var7;
                }

                var8 = var1.getBits(1);
                if (var8 == 1) {
                    client.extendedInfoNpcIndexes[++client.extendedInfoNpcCount - 1] = var14;
                }

                if (var0) {
                    var9 = var1.getBits(8);
                    if (var9 > 127) {
                        var9 -= 256;
                    }
                } else {
                    var9 = var1.getBits(5);
                    if (var9 > 15) {
                        var9 -= 32;
                    }
                }

                var10001 = FileRequest.method4030(var1.getBits(14));
                var15.onCompositionChanged((RSNPCComposition) var10001);
                var15.type = var10001;
                var15.size = var15.type.size;
                var15.direction = var15.type.rotation;
                if (var15.direction == 0) {
                    var15.angle = 0;
                }

                var15.walkAnim = var15.type.walkAnim;
                var15.rotate180Anim = var15.type.rotate180Anim;
                var15.rotate90Anim = var15.type.rotate90Anim;
                var15.rotate270Anim = var15.type.rotate270Anim;
                var15.idlePoseAnimation = var15.type.idleAnim;
                var15.field945 = var15.type.field3580;
                var15.field957 = var15.type.field3575;
                var15.method2164(class4.localPlayer.pathX[0] + var5, class4.localPlayer.pathY[0] + var9, var16 == 1);
            }

            var1.method2834();

            for (var14 = 0; var14 < client.extendedInfoNpcCount; ++var14) {
                var3 = client.extendedInfoNpcIndexes[var14];
                var15 = client.npcs[var3];
                var5 = var1.readUnsignedByte();

                //1, 64, 32, 4, 16, 8, 2

                //face entity
                if ((var5 & 1) != 0) {
                    var15.interacting = var1.readShortLE();
                    var15.interactingChanged(-1);
                    if (var15.interacting == 65535) {
                        var15.interacting = -1;
                        var15.interactingChanged(-1);
                    }
                }

                //face position
                if ((var5 & 64) != 0) {
                    var16 = var1.readLEShortA();
                    var7 = var1.readLEShortA();
                    var8 = var15.x - (var16 - class158.baseX - class158.baseX) * 64;
                    var9 = var15.y - (var7 - class107.baseY - class107.baseY) * 64;
                    if (var8 != 0 || var9 != 0) {
                        var15.facingCoord = (int) (Math.atan2((double) var8, (double) var9) * 325.949D) & 2047;
                    }
                }

                //animations
                if ((var5 & 32) != 0) {
                    var16 = var1.readUnsignedShort();
                    if (var16 == 65535) {
                        var16 = -1;
                    }

                    var7 = var1.read128Byte();
                    if (var16 == var15.animation && var16 != -1) {
                        var8 = MapCacheArchiveNames.method2149(var16).replyMode;
                        if (var8 == 1) {
                            var15.actionFrame = 0;
                            var15.actionFrameCycle = 0;
                            var15.actionAnimationDisable = var7;
                            var15.field975 = 0;
                        }

                        if (var8 == 2) {
                            var15.field975 = 0;
                        }
                    } else if (var16 == -1 || var15.animation == -1 || MapCacheArchiveNames.method2149(var16).forcedPriority >= MapCacheArchiveNames.method2149(var15.animation).forcedPriority) {
                        var15.animation = var16;
                        var15.animationChanged(-1);
                        var15.actionFrame = 0;
                        var15.actionFrameCycle = 0;
                        var15.actionAnimationDisable = var7;
                        var15.field975 = 0;
                        var15.field959 = var15.queueSize;
                    }
                }

                //transform
                if ((var5 & 4) != 0) {
                    var10001 = FileRequest.method4030(var1.readUnsignedShort());
                    var15.onCompositionChanged((RSNPCComposition) var10001);
                    var15.type = var10001;
                    var15.size = var15.type.size;
                    var15.direction = var15.type.rotation;
                    var15.walkAnim = var15.type.walkAnim;
                    var15.rotate180Anim = var15.type.rotate180Anim;
                    var15.rotate90Anim = var15.type.rotate90Anim;
                    var15.rotate270Anim = var15.type.rotate270Anim;
                    var15.idlePoseAnimation = var15.type.idleAnim;
                    var15.field945 = var15.type.field3580;
                    var15.field957 = var15.type.field3575;
                }

                //hitmasks
                if ((var5 & 16) != 0) {
                    var16 = var1.readN();
                    int var12;
                    if (var16 > 0) {
                        for (var7 = 0; var7 < var16; ++var7) {
                            var9 = -1;
                            var10 = -1;
                            var11 = -1;
                            var8 = var1.readUSmart();
                            if (var8 == 32767) {
                                var8 = var1.readUSmart();
                                var10 = var1.readUSmart();
                                var9 = var1.readUSmart();
                                var11 = var1.readUSmart();
                            } else if (var8 != 32766) {
                                var10 = var1.readUSmart();
                            } else {
                                var8 = -1;
                            }

                            var12 = var1.readUSmart();
                            var15.method2727(var8, var10, var9, var11, client.gameCycle, var12);
                        }
                    }

                    var7 = var1.getByte128();
                    if (var7 > 0) {
                        for (var8 = 0; var8 < var7; ++var8) {
                            var9 = var1.readUSmart();
                            var10 = var1.readUSmart();
                            if (var10 != 32767) {
                                var11 = var1.readUSmart();
                                var12 = var1.readUnsignedByte();
                                int var13 = var10 > 0 ? var1.read128Byte() : var12;
                                var15.method2729(var9, client.gameCycle, var10, var11, var12, var13);
                            } else {
                                var15.method2715(var9);
                            }
                        }
                    }
                    System.err.println("hitmask done");
                }

                //gfx
                if ((var5 & 8) != 0) {
                    var15.graphic = var1.readShortLE();
                    var15.graphicChanged(-1);
                    var16 = var1.readNewVal();
                    var15.field980 = var16 >> 16;
                    var15.graphicsDelay = (var16 & 65535) + client.gameCycle;
                    var15.spotAnimFrame = 0;
                    var15.spotAnimFrameCycle = 0;
                    if (var15.graphicsDelay > client.gameCycle) {
                        var15.spotAnimFrame = -1;
                    }

                    if (var15.graphic == 65535) {
                        var15.graphic = -1;
                        var15.graphicChanged(-1);
                    }
                }

                //force chat
                if ((var5 & 2) != 0) {
                    var15.overhead = var1.readString();
                    var15.overheadTextCyclesRemaining = 100;
                }
            }

            for (var14 = 0; var14 < client.npcsToRemoveCount; ++var14) {
                var3 = client.npcIndexesToRemove[var14];
                if (client.npcs[var3].lastUpdatedAt != client.gameCycle) {
                    NPCEntity var10000 = client.npcs[var3];
                    client.npcs[var3].onCompositionChanged((RSNPCComposition) null);
                    var10000.type = null;
                    client.npcs[var3] = null;
                    client.cachedNPCsChanged(var3);
                }
            }

            if (var1.offset != client.serverConnection.currentPacketSize) {
                System.err.println("RECEIVED " + var1.offset + ", EXPECTED " + client.serverConnection.currentPacketSize);
                throw new RuntimeException(var1.offset + "," + client.serverConnection.currentPacketSize);

            } else {
                for (var14 = 0; var14 < client.highResolutionNpcCount; ++var14) {
                    if (client.npcs[client.highResolutionNpcIndexes[var14]] == null) {
                        throw new RuntimeException(var14 + "," + client.highResolutionNpcCount);
                    }
                }

            }
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lbv;I)V",
            garbageValue = "-1225442608"
    )
    public static void method1124(ScriptEvent var0) {
        client.method3577(var0, 500000, 296778373);
    }
}
