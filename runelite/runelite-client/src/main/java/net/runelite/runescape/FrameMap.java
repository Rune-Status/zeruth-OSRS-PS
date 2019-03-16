package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFrameMap;

@ObfuscatedName("db")
@Implements("FrameMap")
public class FrameMap extends Node implements RSFrameMap {
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 911585539
    )
    int count;
    @ObfuscatedName("e")
    int[] types;
    @ObfuscatedName("q")
    int[][] list;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 517613211
    )
    int id;

    FrameMap(int var1, byte[] var2) {
        this.id = var1;
        Packet var3 = new Packet(var2);
        this.count = var3.readUnsignedByte();
        this.types = new int[this.count];
        this.list = new int[this.count][];

        int var4;
        for (var4 = 0; var4 < this.count; ++var4) {
            this.types[var4] = var3.readUnsignedByte();
        }

        for (var4 = 0; var4 < this.count; ++var4) {
            this.list[var4] = new int[var3.readUnsignedByte()];
        }

        for (var4 = 0; var4 < this.count; ++var4) {
            for (int var5 = 0; var5 < this.list[var4].length; ++var5) {
                this.list[var4][var5] = var3.readUnsignedByte();
            }
        }

    }

    public int getCount() {
        return this.count;
    }

    public int[] getTypes() {
        return this.types;
    }

    public int[][] getList() {
        return this.list;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/CharSequence;I)[B",
            garbageValue = "-1473228892"
    )
    public static byte[] method555(CharSequence var0) {
        int var1 = var0.length();
        byte[] var2 = new byte[var1];

        for (int var3 = 0; var3 < var1; ++var3) {
            char var4 = var0.charAt(var3);
            if (var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
                var2[var3] = (byte) var4;
            } else if (var4 == 8364) {
                var2[var3] = -128;
            } else if (var4 == 8218) {
                var2[var3] = -126;
            } else if (var4 == 402) {
                var2[var3] = -125;
            } else if (var4 == 8222) {
                var2[var3] = -124;
            } else if (var4 == 8230) {
                var2[var3] = -123;
            } else if (var4 == 8224) {
                var2[var3] = -122;
            } else if (var4 == 8225) {
                var2[var3] = -121;
            } else if (var4 == 710) {
                var2[var3] = -120;
            } else if (var4 == 8240) {
                var2[var3] = -119;
            } else if (var4 == 352) {
                var2[var3] = -118;
            } else if (var4 == 8249) {
                var2[var3] = -117;
            } else if (var4 == 338) {
                var2[var3] = -116;
            } else if (var4 == 381) {
                var2[var3] = -114;
            } else if (var4 == 8216) {
                var2[var3] = -111;
            } else if (var4 == 8217) {
                var2[var3] = -110;
            } else if (var4 == 8220) {
                var2[var3] = -109;
            } else if (var4 == 8221) {
                var2[var3] = -108;
            } else if (var4 == 8226) {
                var2[var3] = -107;
            } else if (var4 == 8211) {
                var2[var3] = -106;
            } else if (var4 == 8212) {
                var2[var3] = -105;
            } else if (var4 == 732) {
                var2[var3] = -104;
            } else if (var4 == 8482) {
                var2[var3] = -103;
            } else if (var4 == 353) {
                var2[var3] = -102;
            } else if (var4 == 8250) {
                var2[var3] = -101;
            } else if (var4 == 339) {
                var2[var3] = -100;
            } else if (var4 == 382) {
                var2[var3] = -98;
            } else if (var4 == 376) {
                var2[var3] = -97;
            } else {
                var2[var3] = 63;
            }
        }

        return var2;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;IIIIIIB)V",
            garbageValue = "-41"
    )
    static final void method553(Packet var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        int var7;
        if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
            class98.tileSettings[var1][var2][var3] = 0;

            while (true) {
                var7 = var0.readUnsignedByte();
                if (var7 == 0) {
                    if (var1 == 0) {
                        class98.tileHeights[0][var2][var3] = -class2.method21(var4 + 932731 + var2, var5 + 556238 + var3) * 8;
                    } else {
                        class98.tileHeights[var1][var2][var3] = class98.tileHeights[var1 - 1][var2][var3] - 240;
                    }
                    break;
                }

                if (var7 == 1) {
                    int var8 = var0.readUnsignedByte();
                    if (var8 == 1) {
                        var8 = 0;
                    }

                    if (var1 == 0) {
                        class98.tileHeights[0][var2][var3] = -var8 * 8;
                    } else {
                        class98.tileHeights[var1][var2][var3] = class98.tileHeights[var1 - 1][var2][var3] - var8 * 8;
                    }
                    break;
                }

                if (var7 <= 49) {
                    class82.tileOverlayIds[var1][var2][var3] = var0.method6240();
                    class98.tileOverlayPath[var1][var2][var3] = (byte) ((var7 - 2) / 4);
                    class157.overlayRotations[var1][var2][var3] = (byte) (var7 - 2 + var6 & 3);
                } else if (var7 <= 81) {
                    class98.tileSettings[var1][var2][var3] = (byte) (var7 - 49);
                } else {
                    WorldMapDecoration.tileUnderlayIds[var1][var2][var3] = (byte) (var7 - 81);
                }
            }
        } else {
            while (true) {
                var7 = var0.readUnsignedByte();
                if (var7 == 0) {
                    break;
                }

                if (var7 == 1) {
                    var0.readUnsignedByte();
                    break;
                }

                if (var7 <= 49) {
                    var0.readUnsignedByte();
                }
            }
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(B)[Ljs;",
            garbageValue = "40"
    )
    public static Parameters[] method554() {
        return new Parameters[]{Parameters.field3669, Parameters.field3660, Parameters.field3676, Parameters.field3664, Parameters.field3667, Parameters.field3668, Parameters.field3666, Parameters.field3662, Parameters.field3670, Parameters.field3665, Parameters.field3659, Parameters.field3675, Parameters.field3674, Parameters.field3663, Parameters.field3673, Parameters.field3671, Parameters.field3672, Parameters.field3661};
    }
}
