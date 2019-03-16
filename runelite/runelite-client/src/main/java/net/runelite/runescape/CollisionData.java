package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSCollisionData;

@ObfuscatedName("fn")
@Implements("CollisionData")
public class CollisionData implements RSCollisionData {
    @ObfuscatedName("ag")
    @ObfuscatedGetter(
            intValue = 1481745527
    )
    public int y;
    @ObfuscatedName("aj")
    @ObfuscatedGetter(
            intValue = 1200659683
    )
    public int x;
    @ObfuscatedName("at")
    public int[][] flags;
    @ObfuscatedName("ar")
    @ObfuscatedGetter(
            intValue = -460972299
    )
    int height;
    @ObfuscatedName("ab")
    @ObfuscatedGetter(
            intValue = -809222703
    )
    int width;

    public CollisionData(int var1, int var2) {
        this.x = 0;
        this.y = 0;
        this.width = var1;
        this.height = var2;
        this.flags = new int[this.width][this.height];
        this.method196();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IIIIZI)V",
            garbageValue = "-691898352"
    )
    public void method197(int var1, int var2, int var3, int var4, boolean var5) {
        var1 -= this.x;
        var2 -= this.y;
        if (var3 == 0) {
            if (var4 == 0) {
                this.method219(var1, var2, 128);
                this.method219(var1 - 1, var2, 8);
            }

            if (var4 == 1) {
                this.method219(var1, var2, 2);
                this.method219(var1, var2 + 1, 32);
            }

            if (var4 == 2) {
                this.method219(var1, var2, 8);
                this.method219(var1 + 1, var2, 128);
            }

            if (var4 == 3) {
                this.method219(var1, var2, 32);
                this.method219(var1, var2 - 1, 2);
            }
        }

        if (var3 == 1 || var3 == 3) {
            if (var4 == 0) {
                this.method219(var1, var2, 1);
                this.method219(var1 - 1, var2 + 1, 16);
            }

            if (var4 == 1) {
                this.method219(var1, var2, 4);
                this.method219(var1 + 1, var2 + 1, 64);
            }

            if (var4 == 2) {
                this.method219(var1, var2, 16);
                this.method219(var1 + 1, var2 - 1, 1);
            }

            if (var4 == 3) {
                this.method219(var1, var2, 64);
                this.method219(var1 - 1, var2 - 1, 4);
            }
        }

        if (var3 == 2) {
            if (var4 == 0) {
                this.method219(var1, var2, 130);
                this.method219(var1 - 1, var2, 8);
                this.method219(var1, var2 + 1, 32);
            }

            if (var4 == 1) {
                this.method219(var1, var2, 10);
                this.method219(var1, var2 + 1, 32);
                this.method219(var1 + 1, var2, 128);
            }

            if (var4 == 2) {
                this.method219(var1, var2, 40);
                this.method219(var1 + 1, var2, 128);
                this.method219(var1, var2 - 1, 2);
            }

            if (var4 == 3) {
                this.method219(var1, var2, 160);
                this.method219(var1, var2 - 1, 2);
                this.method219(var1 - 1, var2, 8);
            }
        }

        if (var5) {
            if (var3 == 0) {
                if (var4 == 0) {
                    this.method219(var1, var2, 65536);
                    this.method219(var1 - 1, var2, 4096);
                }

                if (var4 == 1) {
                    this.method219(var1, var2, 1024);
                    this.method219(var1, var2 + 1, 16384);
                }

                if (var4 == 2) {
                    this.method219(var1, var2, 4096);
                    this.method219(var1 + 1, var2, 65536);
                }

                if (var4 == 3) {
                    this.method219(var1, var2, 16384);
                    this.method219(var1, var2 - 1, 1024);
                }
            }

            if (var3 == 1 || var3 == 3) {
                if (var4 == 0) {
                    this.method219(var1, var2, 512);
                    this.method219(var1 - 1, var2 + 1, 8192);
                }

                if (var4 == 1) {
                    this.method219(var1, var2, 2048);
                    this.method219(var1 + 1, var2 + 1, 32768);
                }

                if (var4 == 2) {
                    this.method219(var1, var2, 8192);
                    this.method219(var1 + 1, var2 - 1, 512);
                }

                if (var4 == 3) {
                    this.method219(var1, var2, 32768);
                    this.method219(var1 - 1, var2 - 1, 2048);
                }
            }

            if (var3 == 2) {
                if (var4 == 0) {
                    this.method219(var1, var2, 66560);
                    this.method219(var1 - 1, var2, 4096);
                    this.method219(var1, var2 + 1, 16384);
                }

                if (var4 == 1) {
                    this.method219(var1, var2, 5120);
                    this.method219(var1, var2 + 1, 16384);
                    this.method219(var1 + 1, var2, 65536);
                }

                if (var4 == 2) {
                    this.method219(var1, var2, 20480);
                    this.method219(var1 + 1, var2, 65536);
                    this.method219(var1, var2 - 1, 1024);
                }

                if (var4 == 3) {
                    this.method219(var1, var2, 81920);
                    this.method219(var1, var2 - 1, 1024);
                    this.method219(var1 - 1, var2, 4096);
                }
            }
        }

    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IIIIZI)V",
            garbageValue = "-170376128"
    )
    public void method223(int var1, int var2, int var3, int var4, boolean var5) {
        int var6 = 256;
        if (var5) {
            var6 += 131072;
        }

        var1 -= this.x;
        var2 -= this.y;

        for (int var7 = var1; var7 < var3 + var1; ++var7) {
            if (var7 >= 0 && var7 < this.width) {
                for (int var8 = var2; var8 < var2 + var4; ++var8) {
                    if (var8 >= 0 && var8 < this.height) {
                        this.method219(var7, var8, var6);
                    }
                }
            }
        }

    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "-2092847794"
    )
    public void method199(int var1, int var2) {
        var1 -= this.x;
        var2 -= this.y;
        this.flags[var1][var2] |= 2097152;
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(IIIIIZI)V",
            garbageValue = "-953462773"
    )
    public void method202(int var1, int var2, int var3, int var4, int var5, boolean var6) {
        int var7 = 256;
        if (var6) {
            var7 += 131072;
        }

        var1 -= this.x;
        var2 -= this.y;
        int var8;
        if (var5 == 1 || var5 == 3) {
            var8 = var3;
            var3 = var4;
            var4 = var8;
        }

        for (var8 = var1; var8 < var3 + var1; ++var8) {
            if (var8 >= 0 && var8 < this.width) {
                for (int var9 = var2; var9 < var2 + var4; ++var9) {
                    if (var9 >= 0 && var9 < this.height) {
                        this.method203(var8, var9, var7);
                    }
                }
            }
        }

    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(IIIIZI)V",
            garbageValue = "1072376862"
    )
    public void method201(int var1, int var2, int var3, int var4, boolean var5) {
        var1 -= this.x;
        var2 -= this.y;
        if (var3 == 0) {
            if (var4 == 0) {
                this.method203(var1, var2, 128);
                this.method203(var1 - 1, var2, 8);
            }

            if (var4 == 1) {
                this.method203(var1, var2, 2);
                this.method203(var1, var2 + 1, 32);
            }

            if (var4 == 2) {
                this.method203(var1, var2, 8);
                this.method203(var1 + 1, var2, 128);
            }

            if (var4 == 3) {
                this.method203(var1, var2, 32);
                this.method203(var1, var2 - 1, 2);
            }
        }

        if (var3 == 1 || var3 == 3) {
            if (var4 == 0) {
                this.method203(var1, var2, 1);
                this.method203(var1 - 1, var2 + 1, 16);
            }

            if (var4 == 1) {
                this.method203(var1, var2, 4);
                this.method203(var1 + 1, var2 + 1, 64);
            }

            if (var4 == 2) {
                this.method203(var1, var2, 16);
                this.method203(var1 + 1, var2 - 1, 1);
            }

            if (var4 == 3) {
                this.method203(var1, var2, 64);
                this.method203(var1 - 1, var2 - 1, 4);
            }
        }

        if (var3 == 2) {
            if (var4 == 0) {
                this.method203(var1, var2, 130);
                this.method203(var1 - 1, var2, 8);
                this.method203(var1, var2 + 1, 32);
            }

            if (var4 == 1) {
                this.method203(var1, var2, 10);
                this.method203(var1, var2 + 1, 32);
                this.method203(var1 + 1, var2, 128);
            }

            if (var4 == 2) {
                this.method203(var1, var2, 40);
                this.method203(var1 + 1, var2, 128);
                this.method203(var1, var2 - 1, 2);
            }

            if (var4 == 3) {
                this.method203(var1, var2, 160);
                this.method203(var1, var2 - 1, 2);
                this.method203(var1 - 1, var2, 8);
            }
        }

        if (var5) {
            if (var3 == 0) {
                if (var4 == 0) {
                    this.method203(var1, var2, 65536);
                    this.method203(var1 - 1, var2, 4096);
                }

                if (var4 == 1) {
                    this.method203(var1, var2, 1024);
                    this.method203(var1, var2 + 1, 16384);
                }

                if (var4 == 2) {
                    this.method203(var1, var2, 4096);
                    this.method203(var1 + 1, var2, 65536);
                }

                if (var4 == 3) {
                    this.method203(var1, var2, 16384);
                    this.method203(var1, var2 - 1, 1024);
                }
            }

            if (var3 == 1 || var3 == 3) {
                if (var4 == 0) {
                    this.method203(var1, var2, 512);
                    this.method203(var1 - 1, var2 + 1, 8192);
                }

                if (var4 == 1) {
                    this.method203(var1, var2, 2048);
                    this.method203(var1 + 1, var2 + 1, 32768);
                }

                if (var4 == 2) {
                    this.method203(var1, var2, 8192);
                    this.method203(var1 + 1, var2 - 1, 512);
                }

                if (var4 == 3) {
                    this.method203(var1, var2, 32768);
                    this.method203(var1 - 1, var2 - 1, 2048);
                }
            }

            if (var3 == 2) {
                if (var4 == 0) {
                    this.method203(var1, var2, 66560);
                    this.method203(var1 - 1, var2, 4096);
                    this.method203(var1, var2 + 1, 16384);
                }

                if (var4 == 1) {
                    this.method203(var1, var2, 5120);
                    this.method203(var1, var2 + 1, 16384);
                    this.method203(var1 + 1, var2, 65536);
                }

                if (var4 == 2) {
                    this.method203(var1, var2, 20480);
                    this.method203(var1 + 1, var2, 65536);
                    this.method203(var1, var2 - 1, 1024);
                }

                if (var4 == 3) {
                    this.method203(var1, var2, 81920);
                    this.method203(var1, var2 - 1, 1024);
                    this.method203(var1 - 1, var2, 4096);
                }
            }
        }

    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "-1485077149"
    )
    public void method198(int var1, int var2) {
        var1 -= this.x;
        var2 -= this.y;
        this.flags[var1][var2] |= 262144;
    }

    public int[][] getFlags() {
        return this.flags;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(IIII)V",
            garbageValue = "-1379765951"
    )
    void method219(int var1, int var2, int var3) {
        this.flags[var1][var2] |= var3;
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(IIII)V",
            garbageValue = "-1422883307"
    )
    void method203(int var1, int var2, int var3) {
        this.flags[var1][var2] &= ~var3;
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(IIB)V",
            garbageValue = "-97"
    )
    public void method204(int var1, int var2) {
        var1 -= this.x;
        var2 -= this.y;
        this.flags[var1][var2] &= -262145;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1613750531"
    )
    public void method196() {
        for (int var1 = 0; var1 < this.width; ++var1) {
            for (int var2 = 0; var2 < this.height; ++var2) {
                if (var1 != 0 && var2 != 0 && var1 < this.width - 5 && var2 < this.height - 5) {
                    this.flags[var1][var2] = 16777216;
                } else {
                    this.flags[var1][var2] = 16777215;
                }
            }
        }

    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "-1709627966"
    )
    static int method225(int var0, class106 var1, boolean var2) {
        int var3 = -1;
        ComponentType var4;
        if (var0 >= 2000) {
            var0 -= 1000;
            var3 = class48.intStack[--class228.intStackSize];
            var4 = WorldMapType1.method2440(var3);
        } else {
            var4 = var2 ? class113.field75 : class48.field1080;
        }

        if (var0 == 1000) {
            class228.intStackSize -= 4;
            var4.posX = class48.intStack[class228.intStackSize];
            var4.posY = class48.intStack[class228.intStackSize + 1];
            var4.posXmode = class48.intStack[class228.intStackSize + 2];
            var4.posYmode = class48.intStack[class228.intStackSize + 3];
            class208.method4144(var4);
            class166.clientInstance.method3499(var4);
            if (var3 != -1 && var4.type == 0) {
                class196.method4011(class36.interfaces[var3 >> 16], var4, false);
            }

            return 1;
        } else if (var0 == 1001) {
            class228.intStackSize -= 4;
            var4.sizeX = class48.intStack[class228.intStackSize];
            var4.sizeY = class48.intStack[class228.intStackSize + 1];
            var4.sizeXmode = class48.intStack[class228.intStackSize + 2];
            var4.sizeYmode = class48.intStack[class228.intStackSize + 3];
            class208.method4144(var4);
            class166.clientInstance.method3499(var4);
            if (var3 != -1 && var4.type == 0) {
                class196.method4011(class36.interfaces[var3 >> 16], var4, false);
            }

            return 1;
        } else if (var0 == 1003) {
            boolean var5 = class48.intStack[--class228.intStackSize] == 1;
            if (var5 != var4.isHidden) {
                var4.isHidden = var5;
                var4.onHiddenChanged(-1);
                class208.method4144(var4);
            }

            return 1;
        } else if (var0 == 1005) {
            var4.noClickThrough = class48.intStack[--class228.intStackSize] == 1;
            return 1;
        } else if (var0 == 1006) {
            var4.noScrollThrough = class48.intStack[--class228.intStackSize] == 1;
            return 1;
        } else {
            return 2;
        }
    }
}
