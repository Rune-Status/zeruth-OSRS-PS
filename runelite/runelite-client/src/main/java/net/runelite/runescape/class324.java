package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class324 {
    @ObfuscatedName("r")
    byte[][][] field340;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1991430177
    )
    int field342;

    class324(int var1) {
        this.field342 = var1;
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1102634812"
    )
    void method6378() {
        byte[] var1 = new byte[this.field342 * this.field342];
        boolean var2 = false;
        var1 = new byte[this.field342 * this.field342];
        int var5 = 0;

        int var3;
        int var4;
        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 >= var3 - this.field342 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.field340[7][0] = var1;
        var1 = new byte[this.field342 * this.field342];
        var5 = 0;

        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 >= var3 - this.field342 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.field340[7][1] = var1;
        var1 = new byte[this.field342 * this.field342];
        var5 = 0;

        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = this.field342 - 1; var4 >= 0; --var4) {
                if (var4 >= var3 - this.field342 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.field340[7][2] = var1;
        var1 = new byte[this.field342 * this.field342];
        var5 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = this.field342 - 1; var4 >= 0; --var4) {
                if (var4 >= var3 - this.field342 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.field340[7][3] = var1;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "-1104372319"
    )
    int method6369(int var1, int var2) {
        if (var2 == 9) {
            var1 = var1 + 1 & 3;
        }

        if (var2 == 10) {
            var1 = var1 + 3 & 3;
        }

        if (var2 == 11) {
            var1 = var1 + 3 & 3;
        }

        return var1;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IS)I",
            garbageValue = "18077"
    )
    int method6393(int var1) {
        return var1 != 9 && var1 != 10 ? (var1 == 11 ? 8 : var1) : 1;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "721557946"
    )
    void method6370() {
        if (this.field340 == null) {
            this.field340 = new byte[8][4][];
            this.method6383();
            this.method6367();
            this.method6392();
            this.method6374();
            this.method6375();
            this.method6380();
            this.method6407();
            this.method6378();
        }
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1335590161"
    )
    void method6407() {
        byte[] var1 = new byte[this.field342 * this.field342];
        boolean var2 = false;
        var1 = new byte[this.field342 * this.field342];
        int var5 = 0;

        int var3;
        int var4;
        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 <= var3 - this.field342 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.field340[6][0] = var1;
        var1 = new byte[this.field342 * this.field342];
        var5 = 0;

        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 <= var3 - this.field342 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.field340[6][1] = var1;
        var1 = new byte[this.field342 * this.field342];
        var5 = 0;

        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = this.field342 - 1; var4 >= 0; --var4) {
                if (var4 <= var3 - this.field342 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.field340[6][2] = var1;
        var1 = new byte[this.field342 * this.field342];
        var5 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = this.field342 - 1; var4 >= 0; --var4) {
                if (var4 <= var3 - this.field342 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.field340[6][3] = var1;
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1036338620"
    )
    void method6374() {
        byte[] var1 = new byte[this.field342 * this.field342];
        int var2 = 0;

        int var3;
        int var4;
        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 >= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[3][0] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 <= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[3][1] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = this.field342 - 1; var4 >= 0; --var4) {
                if (var4 >= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[3][2] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = this.field342 - 1; var4 >= 0; --var4) {
                if (var4 <= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[3][3] = var1;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1570917245"
    )
    void method6392() {
        byte[] var1 = new byte[this.field342 * this.field342];
        int var2 = 0;

        int var3;
        int var4;
        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = this.field342 - 1; var4 >= 0; --var4) {
                if (var4 <= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[2][0] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 >= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[2][1] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 <= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[2][2] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = this.field342 - 1; var4 >= 0; --var4) {
                if (var4 >= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[2][3] = var1;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1640638568"
    )
    void method6383() {
        byte[] var1 = new byte[this.field342 * this.field342];
        int var2 = 0;

        int var3;
        int var4;
        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 <= var3) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[0][0] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 <= var3) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[0][1] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 >= var3) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[0][2] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 >= var3) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[0][3] = var1;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-676844424"
    )
    void method6367() {
        byte[] var1 = new byte[this.field342 * this.field342];
        int var2 = 0;

        int var3;
        int var4;
        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 <= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[1][0] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var2 >= 0 && var2 < var1.length) {
                    if (var4 >= var3 << 1) {
                        var1[var2] = -1;
                    }

                    ++var2;
                } else {
                    ++var2;
                }
            }
        }

        this.field340[1][1] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = this.field342 - 1; var4 >= 0; --var4) {
                if (var4 <= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[1][2] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = this.field342 - 1; var4 >= 0; --var4) {
                if (var4 >= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[1][3] = var1;
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-48"
    )
    void method6375() {
        byte[] var1 = new byte[this.field342 * this.field342];
        int var2 = 0;

        int var3;
        int var4;
        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = this.field342 - 1; var4 >= 0; --var4) {
                if (var4 >= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[4][0] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = this.field342 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 <= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[4][1] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 >= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[4][2] = var1;
        var1 = new byte[this.field342 * this.field342];
        var2 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = this.field342 - 1; var4 >= 0; --var4) {
                if (var4 <= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.field340[4][3] = var1;
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "37"
    )
    void method6380() {
        byte[] var1 = new byte[this.field342 * this.field342];
        boolean var2 = false;
        var1 = new byte[this.field342 * this.field342];
        int var5 = 0;

        int var3;
        int var4;
        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 <= this.field342 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.field340[5][0] = var1;
        var1 = new byte[this.field342 * this.field342];
        var5 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var3 <= this.field342 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.field340[5][1] = var1;
        var1 = new byte[this.field342 * this.field342];
        var5 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var4 >= this.field342 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.field340[5][2] = var1;
        var1 = new byte[this.field342 * this.field342];
        var5 = 0;

        for (var3 = 0; var3 < this.field342; ++var3) {
            for (var4 = 0; var4 < this.field342; ++var4) {
                if (var3 >= this.field342 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.field340[5][3] = var1;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(IIIIIIIII)V",
            garbageValue = "1760882168"
    )
    void method6408(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        if (var7 != 0 && this.field342 != 0 && this.field340 != null) {
            var8 = this.method6369(var8, var7);
            var7 = this.method6393(var7);
            Rasterizer2D.method451(var1, var2, var5, var6, var3, var4, this.field340[var7 - 1][var8], this.field342, true);
        }
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "-1426711154"
    )
    public static int method6372(int var0) {
        long var2 = class195.field1714[var0];
        int var1 = (int) (var2 >>> 14 & 3L);
        return var1;
    }

    @ObfuscatedName("hu")
    @ObfuscatedSignature(
            signature = "(IIIILjava/lang/String;S)V",
            garbageValue = "251"
    )
    static void method6406(int var0, int var1, int var2, int var3, String var4) {
        ComponentType var5 = class192.method3785(var1, var2);
        if (var5 != null) {
            if (var5.onOpListener != null) {
                ScriptEvent var6 = new ScriptEvent();
                var6.source = var5;
                var6.op = var0;
                var6.opbase = var4;
                var6.params = var5.onOpListener;
                class73.method1124(var6);
            }

            boolean var11 = true;
            if (var5.clientcode > 0) {
                var11 = WorldMapType3.method1673(var5);
            }

            if (var11) {
                int var8 = class101.method1704(var5);
                int var9 = var0 - 1;
                boolean var7 = (var8 >> var9 + 1 & 1) != 0;
                if (var7) {
                    TcpConnectionMessage var10;
                    if (var0 == 1) {
                        var10 = FaceNormal.method5726(ClientProt.IF_BUTTON1, client.serverConnection.isaac);
                        var10.packetBuffer.method6230(var1);
                        var10.packetBuffer.putShort(var2);
                        var10.packetBuffer.putShort(var3);
                        client.serverConnection.method5881(var10);
                    }

                    if (var0 == 2) {
                        var10 = FaceNormal.method5726(ClientProt.IF_BUTTON2, client.serverConnection.isaac);
                        var10.packetBuffer.method6230(var1);
                        var10.packetBuffer.putShort(var2);
                        var10.packetBuffer.putShort(var3);
                        client.serverConnection.method5881(var10);
                    }

                    if (var0 == 3) {
                        var10 = FaceNormal.method5726(ClientProt.IF_BUTTON3, client.serverConnection.isaac);
                        var10.packetBuffer.method6230(var1);
                        var10.packetBuffer.putShort(var2);
                        var10.packetBuffer.putShort(var3);
                        client.serverConnection.method5881(var10);
                    }

                    if (var0 == 4) {
                        var10 = FaceNormal.method5726(ClientProt.IF_BUTTON4, client.serverConnection.isaac);
                        var10.packetBuffer.method6230(var1);
                        var10.packetBuffer.putShort(var2);
                        var10.packetBuffer.putShort(var3);
                        client.serverConnection.method5881(var10);
                    }

                    if (var0 == 5) {
                        var10 = FaceNormal.method5726(ClientProt.IF_BUTTON5, client.serverConnection.isaac);
                        var10.packetBuffer.method6230(var1);
                        var10.packetBuffer.putShort(var2);
                        var10.packetBuffer.putShort(var3);
                        client.serverConnection.method5881(var10);
                    }

                    if (var0 == 6) {
                        var10 = FaceNormal.method5726(ClientProt.IF_BUTTON6, client.serverConnection.isaac);
                        var10.packetBuffer.method6230(var1);
                        var10.packetBuffer.putShort(var2);
                        var10.packetBuffer.putShort(var3);
                        client.serverConnection.method5881(var10);
                    }

                    if (var0 == 7) {
                        var10 = FaceNormal.method5726(ClientProt.IF_BUTTON7, client.serverConnection.isaac);
                        var10.packetBuffer.method6230(var1);
                        var10.packetBuffer.putShort(var2);
                        var10.packetBuffer.putShort(var3);
                        client.serverConnection.method5881(var10);
                    }

                    if (var0 == 8) {
                        var10 = FaceNormal.method5726(ClientProt.IF_BUTTON8, client.serverConnection.isaac);
                        var10.packetBuffer.method6230(var1);
                        var10.packetBuffer.putShort(var2);
                        var10.packetBuffer.putShort(var3);
                        client.serverConnection.method5881(var10);
                    }

                    if (var0 == 9) {
                        var10 = FaceNormal.method5726(ClientProt.IF_BUTTON9, client.serverConnection.isaac);
                        var10.packetBuffer.method6230(var1);
                        var10.packetBuffer.putShort(var2);
                        var10.packetBuffer.putShort(var3);
                        client.serverConnection.method5881(var10);
                    }

                    if (var0 == 10) {
                        var10 = FaceNormal.method5726(ClientProt.IF_BUTTON10, client.serverConnection.isaac);
                        var10.packetBuffer.method6230(var1);
                        var10.packetBuffer.putShort(var2);
                        var10.packetBuffer.putShort(var3);
                        client.serverConnection.method5881(var10);
                    }

                }
            }
        }
    }
}
