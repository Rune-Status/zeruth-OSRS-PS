package net.runelite.runescape;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

@ObfuscatedName("ep")
public class class133 implements Runnable {
    @ObfuscatedName("lr")
    @ObfuscatedSignature(
            signature = "Lhn;"
    )
    static ComponentType field1993;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 396480503
    )
    int field1991;
    @ObfuscatedName("r")
    InputStream field1986;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -2058365487
    )
    int field1990;
    @ObfuscatedName("q")
    byte[] field1989;
    @ObfuscatedName("b")
    IOException field1992;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -1375325895
    )
    int field1987;
    @ObfuscatedName("g")
    Thread field1988;

    class133(InputStream var1, int var2) {
        this.field1987 = 0;
        this.field1991 = 0;
        this.field1986 = var1;
        this.field1990 = var2 + 1;
        this.field1989 = new byte[this.field1990];
        this.field1988 = new Thread(this);
        this.field1988.setDaemon(true);
        this.field1988.start();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-1324460418"
    )
    int method2184() throws IOException {
        synchronized (this) {
            int var2;
            if (this.field1987 <= this.field1991) {
                var2 = this.field1991 - this.field1987;
            } else {
                var2 = this.field1990 - this.field1987 + this.field1991;
            }

            if (var2 <= 0 && this.field1992 != null) {
                throw new IOException(this.field1992.toString());
            } else {
                this.notifyAll();
                return var2;
            }
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "1512568386"
    )
    int method2185() throws IOException {
        synchronized (this) {
            if (this.field1991 == this.field1987) {
                if (this.field1992 != null) {
                    throw new IOException(this.field1992.toString());
                } else {
                    return -1;
                }
            } else {
                int var2 = this.field1989[this.field1987] & 255;
                this.field1987 = (this.field1987 + 1) % this.field1990;
                this.notifyAll();
                return var2;
            }
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "([BIII)I",
            garbageValue = "-1422883307"
    )
    int method2194(byte[] var1, int var2, int var3) throws IOException {
        if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
            synchronized (this) {
                int var5;
                if (this.field1987 <= this.field1991) {
                    var5 = this.field1991 - this.field1987;
                } else {
                    var5 = this.field1990 - this.field1987 + this.field1991;
                }

                if (var3 > var5) {
                    var3 = var5;
                }

                if (var3 == 0 && this.field1992 != null) {
                    throw new IOException(this.field1992.toString());
                } else {
                    if (var3 + this.field1987 <= this.field1990) {
                        System.arraycopy(this.field1989, this.field1987, var1, var2, var3);
                    } else {
                        int var6 = this.field1990 - this.field1987;
                        System.arraycopy(this.field1989, this.field1987, var1, var2, var6);
                        System.arraycopy(this.field1989, 0, var1, var6 + var2, var3 - var6);
                    }

                    this.field1987 = (var3 + this.field1987) % this.field1990;
                    this.notifyAll();
                    return var3;
                }
            }
        } else {
            throw new IOException();
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1914551564"
    )
    void method2192() {
        synchronized (this) {
            if (this.field1992 == null) {
                this.field1992 = new IOException("");
            }

            this.notifyAll();
        }

        try {
            this.field1988.join();
        } catch (InterruptedException var3) {
            ;
        }

    }

    public void run() {
        while (true) {
            int var1;
            synchronized (this) {
                while (true) {
                    if (this.field1992 != null) {
                        return;
                    }

                    if (this.field1987 == 0) {
                        var1 = this.field1990 - this.field1991 - 1;
                    } else if (this.field1987 <= this.field1991) {
                        var1 = this.field1990 - this.field1991;
                    } else {
                        var1 = this.field1987 - this.field1991 - 1;
                    }

                    if (var1 > 0) {
                        break;
                    }

                    try {
                        this.wait();
                    } catch (InterruptedException var10) {
                        ;
                    }
                }
            }

            int var7;
            try {
                var7 = this.field1986.read(this.field1989, this.field1991, var1);
                if (var7 == -1) {
                    throw new EOFException();
                }
            } catch (IOException var11) {
                IOException var3 = var11;
                synchronized (this) {
                    this.field1992 = var3;
                    return;
                }
            }

            synchronized (this) {
                this.field1991 = (var7 + this.field1991) % this.field1990;
            }
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(II)Z",
            garbageValue = "-1894124897"
    )
    boolean method2186(int var1) throws IOException {
        if (var1 == 0) {
            return true;
        } else if (var1 > 0 && var1 < this.field1990) {
            synchronized (this) {
                int var3;
                if (this.field1987 <= this.field1991) {
                    var3 = this.field1991 - this.field1987;
                } else {
                    var3 = this.field1990 - this.field1987 + this.field1991;
                }

                if (var3 < var1) {
                    if (this.field1992 != null) {
                        throw new IOException(this.field1992.toString());
                    } else {
                        this.notifyAll();
                        return false;
                    }
                } else {
                    return true;
                }
            }
        } else {
            throw new IOException();
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(Lge;I)V",
            garbageValue = "-1494980532"
    )
    @Export("playerUpdatingMasks")
    static final void playerUpdatingMasks(Bit var0) {
        for (int var1 = 0; var1 < class254.extendedInfoPlayerCount; ++var1) {
            int var2 = class254.extendedInfoPlayerIndexes[var1];
            PlayerEntity var3 = client.players[var2];
            int var4 = var0.readUnsignedByte();
            if ((var4 & 8) != 0) {
                var4 += var0.readUnsignedByte() << 8;
            }

            byte var5 = -1;
            int var6;
            int var7;
            int var9;
            int var10;
            int var13;
            //256 = contextmenus, 1 = appearance, 128 = animation, 4 = face direction,
            //2 = face entity, 512 = gfx, 16 = chat, 64 = hitmask, 1024 = forced movement, 32 = force chat, 2048 = temp movement, 4096 = movement

            //64, 512, 4096, 1024, 32, 4, 1, 2, 2048, 16, 256, 128

            //hitmask
            if ((var4 & 64) != 0) {
                var6 = var0.getByte128();
                int var8;
                int var11;
                int var12;
                if (var6 > 0) {
                    for (var7 = 0; var7 < var6; ++var7) {
                        var9 = -1;
                        var10 = -1;
                        var11 = -1;
                        var8 = var0.readUSmart();
                        if (var8 == 32767) {
                            var8 = var0.readUSmart();
                            var10 = var0.readUSmart();
                            var9 = var0.readUSmart();
                            var11 = var0.readUSmart();
                        } else if (var8 != 32766) {
                            var10 = var0.readUSmart();
                        } else {
                            var8 = -1;
                        }

                        var12 = var0.readUSmart();
                        var3.method2727(var8, var10, var9, var11, client.gameCycle, var12);
                    }
                }

                var7 = var0.readN();
                if (var7 > 0) {
                    for (var8 = 0; var8 < var7; ++var8) {
                        var9 = var0.readUSmart();
                        var10 = var0.readUSmart();
                        if (var10 != 32767) {
                            var11 = var0.readUSmart();
                            var12 = var0.getByte128();
                            var13 = var10 > 0 ? var0.readUnsignedByte() : var12;
                            var3.method2729(var9, client.gameCycle, var10, var11, var12, var13);
                        } else {
                            var3.method2715(var9);
                        }
                    }
                }
                //System.err.println("hitmask done");
            }

            //gfx
            if ((var4 & 512) != 0) {
                var3.graphic = var0.readLEShortA();
                var3.graphicChanged(-1);
                var6 = var0.readNewVal();
                var3.field980 = var6 >> 16;
                var3.graphicsDelay = (var6 & 65535) + client.gameCycle;
                var3.spotAnimFrame = 0;
                var3.spotAnimFrameCycle = 0;
                if (var3.graphicsDelay > client.gameCycle) {
                    var3.spotAnimFrame = -1;
                }

                if (var3.graphic == 65535) {
                    var3.graphic = -1;
                    var3.graphicChanged(-1);
                }
                //System.err.println("gfx done");
            }

            //movement
            if ((var4 & 4096) != 0) {
                var5 = var0.readByte128();
                //System.err.println("movement done");
            }

            //forced movement
            if ((var4 & 1024) != 0) {
                var3.field983 = var0.method6112();
                var3.field995 = var0.readByte128();
                var3.field982 = var0.readByte128();
                var3.field984 = var0.method6112();
                var3.field985 = var0.readShort128() + client.gameCycle;
                var3.field977 = var0.readShortLE() + client.gameCycle;
                var3.field997 = var0.readUnsignedShort();
                if (var3.field631) {
                    var3.field983 += var3.xInScene;
                    var3.field995 += var3.yInScene;
                    var3.field982 += var3.xInScene;
                    var3.field984 += var3.yInScene;
                    var3.queueSize = 0;
                } else {
                    var3.field983 += var3.pathX[0];
                    var3.field995 += var3.pathY[0];
                    var3.field982 += var3.pathX[0];
                    var3.field984 += var3.pathY[0];
                    var3.queueSize = 1;
                }

                var3.field959 = 0;
                //System.err.println("forced movement done");
            }

            //forced chat
            if ((var4 & 32) != 0) {
                var3.overhead = var0.readString();
                if (var3.overhead.charAt(0) == '~') {
                    var3.overhead = var3.overhead.substring(1);
                    ChatLine.method5672(2, var3.name.method4713(), var3.overhead);
                } else if (var3 == class4.localPlayer) {
                    ChatLine.method5672(2, var3.name.method4713(), var3.overhead);
                }

                var3.field958 = false;
                var3.field956 = 0;
                var3.field974 = 0;
                var3.overheadTextCyclesRemaining = 150;
                //System.err.println("forced chat done");
            }

            //face direction
            if ((var4 & 4) != 0) {
                var3.facingCoord = var0.readShortLE();
                if (var3.queueSize == 0) {
                    var3.orientation = var3.facingCoord;
                    var3.facingCoord = -1;
                }
                //System.err.println("face direction done");
            }

            //appearance
            if ((var4 & 1) != 0) {
                var6 = var0.read128Byte();
                byte[] var14 = new byte[var6];
                Packet var15 = new Packet(var14);
                var0.method6228(var14, 0, var6);
                class254.appearances[var2] = var15;
                var3.method2889(var15);
                //System.err.println("appearance done");
            }

            //face entity
            if ((var4 & 2) != 0) {
                var3.interacting = var0.readShort128();
                var3.interactingChanged(-1);
                if (var3.interacting == 65535) {
                    var3.interacting = -1;
                    var3.interactingChanged(-1);
                }
                //System.err.println("face entity done");
            }

            //tempmovement
            if ((var4 & 2048) != 0) {
                class254.moveSpeeds[var2] = var0.readByte128();
                //System.err.println("tempmovement done");
            }

            //chat
            if ((var4 & 16) != 0) {
                var6 = var0.readShort128();
                ChatCrownType var20 = (ChatCrownType) class2.method20(class116.method2020(), var0.readUnsignedByte());
                boolean var18 = var0.readN() == 1;
                var9 = var0.readUnsignedByte();
                var10 = var0.offset;
                if (var3.name != null && var3.composition != null) {
                    boolean var19 = false;
                    if (var20.ignorable && ServerProt.friendManager.method96(var3.name)) {
                        var19 = true;
                    }

                    if (!var19 && client.field680 == 0 && !var3.hidden) {
                        class254.messageBuffer.offset = 0;
                        var0.method6090(class254.messageBuffer.payload, 0, var9);
                        class254.messageBuffer.offset = 0;
                        String var16 = FontTypeFace.method1779(WorldMapDecorationType.method2691(MapLabel.method5551(class254.messageBuffer)));
                        var3.overhead = var16.trim();
                        var3.field956 = var6 >> 8;
                        var3.field974 = var6 & 255;
                        var3.overheadTextCyclesRemaining = 150;
                        var3.field958 = var18;
                        var3.overheadFiltered = var3 != class4.localPlayer && var20.ignorable && "" != client.field862 && var16.toLowerCase().indexOf(client.field862) == -1;
                        if (var20.moderator) {
                            var13 = var18 ? 91 : 1;
                        } else {
                            var13 = var18 ? 90 : 2;
                        }

                        if (var20.icon != -1) {
                            ChatLine.method5672(var13, WorldMapDecoration.method2945(var20.icon) + var3.name.method4713(), var16);
                        } else {
                            ChatLine.method5672(var13, var3.name.method4713(), var16);
                        }
                    }
                }

                var0.offset = var10 + var9;
                //System.err.println("chat done");
            }

            //contextmenus
            if ((var4 & 256) != 0) {
                for (var6 = 0; var6 < 3; ++var6) {
                    var3.tagFragments[var6] = var0.readString();
                }
                //System.err.println("contextmenus done");
            }

            //animation
            if ((var4 & 128) != 0) {
                var6 = var0.readUnsignedShort();
                if (var6 == 65535) {
                    var6 = -1;
                }

                var7 = var0.readUnsignedByte();
                class115.method1976(var3, var6, var7);
                //System.err.println("animation done");
            }

            if (var3.field631) {
                if (var5 == 127) {
                    var3.method2927(var3.xInScene, var3.yInScene);
                } else {
                    byte var17;
                    if (var5 != -1) {
                        var17 = var5;
                    } else {
                        var17 = class254.moveSpeeds[var2];
                    }

                    var3.method2897(var3.xInScene, var3.yInScene, var17);
                }
            }
        }

    }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "-2062120202"
    )
    static int method2183(int var0, class106 var1, boolean var2) {
        int var3;
        if (var0 == 5504) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            int var4 = class48.intStack[class228.intStackSize + 1];
            if (!client.field889) {
                client.cameraPitchTarget = var3;
                client.onCameraPitchTargetChanged(-1);
                client.mapAngle = var4;
            }

            return 1;
        } else if (var0 == 5505) {
            class48.intStack[++class228.intStackSize - 1] = client.cameraPitchTarget;
            return 1;
        } else if (var0 == 5506) {
            class48.intStack[++class228.intStackSize - 1] = client.mapAngle;
            return 1;
        } else if (var0 == 5530) {
            var3 = class48.intStack[--class228.intStackSize];
            if (var3 < 0) {
                var3 = 0;
            }

            client.field719 = var3;
            return 1;
        } else if (var0 == 5531) {
            class48.intStack[++class228.intStackSize - 1] = client.field719;
            return 1;
        } else {
            return 2;
        }
    }
}
