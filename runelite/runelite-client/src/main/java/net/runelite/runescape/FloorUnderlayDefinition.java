package net.runelite.runescape;

import net.runelite.mapping.*;

@ObfuscatedName("ju")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    @Export("underlays")
    public static NodeCache underlays;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    @Export("underlay_ref")
    public static Js5Index underlay_ref;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -1200290925
    )
    @Export("lightness")
    public int lightness;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 867137581
    )
    @Export("rgbColor")
    int rgbColor;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 1729162871
    )
    @Export("hue")
    public int hue;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 334138523
    )
    @Export("hueMultiplier")
    public int hueMultiplier;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 139090123
    )
    @Export("saturation")
    public int saturation;

    static {
        underlays = new NodeCache(64);
    }

    FloorUnderlayDefinition() {
        this.rgbColor = 0;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-8"
    )
    void method5026() {
        this.method5029(this.rgbColor);
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;IB)V",
            garbageValue = "2"
    )
    void method5041(Packet var1, int var2) {
        while (true) {
            int var3 = var1.readUnsignedByte();
            if (var3 == 0) {
                return;
            }

            this.method5028(var1, var3, var2);
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;III)V",
            garbageValue = "-325585794"
    )
    void method5028(Packet var1, int var2, int var3) {
        if (var2 == 1) {
            this.rgbColor = var1.method6082();
        }

    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-2085846449"
    )
    void method5029(int var1) {
        double var2 = (double) (var1 >> 16 & 255) / 256.0D;
        double var4 = (double) (var1 >> 8 & 255) / 256.0D;
        double var6 = (double) (var1 & 255) / 256.0D;
        double var8 = var2;
        if (var4 < var2) {
            var8 = var4;
        }

        if (var6 < var8) {
            var8 = var6;
        }

        double var10 = var2;
        if (var4 > var2) {
            var10 = var4;
        }

        if (var6 > var10) {
            var10 = var6;
        }

        double var12 = 0.0D;
        double var14 = 0.0D;
        double var16 = (var8 + var10) / 2.0D;
        if (var8 != var10) {
            if (var16 < 0.5D) {
                var14 = (var10 - var8) / (var10 + var8);
            }

            if (var16 >= 0.5D) {
                var14 = (var10 - var8) / (2.0D - var10 - var8);
            }

            if (var10 == var2) {
                var12 = (var4 - var6) / (var10 - var8);
            } else if (var4 == var10) {
                var12 = 2.0D + (var6 - var2) / (var10 - var8);
            } else if (var6 == var10) {
                var12 = (var2 - var4) / (var10 - var8) + 4.0D;
            }
        }

        var12 /= 6.0D;
        this.saturation = (int) (256.0D * var14);
        this.lightness = (int) (var16 * 256.0D);
        if (this.saturation < 0) {
            this.saturation = 0;
        } else if (this.saturation > 255) {
            this.saturation = 255;
        }

        if (this.lightness < 0) {
            this.lightness = 0;
        } else if (this.lightness > 255) {
            this.lightness = 255;
        }

        if (var16 > 0.5D) {
            this.hueMultiplier = (int) ((1.0D - var16) * var14 * 512.0D);
        } else {
            this.hueMultiplier = (int) (512.0D * var14 * var16);
        }

        if (this.hueMultiplier < 1) {
            this.hueMultiplier = 1;
        }

        this.hue = (int) ((double) this.hueMultiplier * var12);
    }

    @ObfuscatedName("fu")
    @ObfuscatedSignature(
            signature = "(Lbc;I)V",
            garbageValue = "-1658114909"
    )
    static final void method5033(PathingEntity var0) {
        var0.poseAnimation = var0.idlePoseAnimation;
        if (var0.queueSize == 0) {
            var0.field955 = 0;
        } else {
            if (var0.animation != -1 && var0.actionAnimationDisable == 0) {
                Sequence var1 = MapCacheArchiveNames.method2149(var0.animation);
                if (var0.field959 > 0 && var1.precedenceAnimating == 0) {
                    ++var0.field955;
                    return;
                }

                if (var0.field959 <= 0 && var1.priority == 0) {
                    ++var0.field955;
                    return;
                }
            }

            int var10 = var0.x;
            int var2 = var0.y;
            int var3 = var0.pathX[var0.queueSize - 1] * 128 + var0.size * 64;
            int var4 = var0.pathY[var0.queueSize - 1] * 128 + var0.size * 64;
            if (var10 < var3) {
                if (var2 < var4) {
                    var0.orientation = 1280;
                } else if (var2 > var4) {
                    var0.orientation = 1792;
                } else {
                    var0.orientation = 1536;
                }
            } else if (var10 > var3) {
                if (var2 < var4) {
                    var0.orientation = 768;
                } else if (var2 > var4) {
                    var0.orientation = 256;
                } else {
                    var0.orientation = 512;
                }
            } else if (var2 < var4) {
                var0.orientation = 1024;
            } else if (var2 > var4) {
                var0.orientation = 0;
            }

            byte var5 = var0.pathTraversed[var0.queueSize - 1];
            if (var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
                int var6 = var0.orientation - var0.angle & 2047;
                if (var6 > 1024) {
                    var6 -= 2048;
                }

                int var7 = var0.rotate180Anim;
                if (var6 >= -256 && var6 <= 256) {
                    var7 = var0.walkAnim;
                } else if (var6 >= 256 && var6 < 768) {
                    var7 = var0.rotate270Anim;
                } else if (var6 >= -768 && var6 <= -256) {
                    var7 = var0.rotate90Anim;
                }

                if (var7 == -1) {
                    var7 = var0.walkAnim;
                }

                var0.poseAnimation = var7;
                int var8 = 4;
                boolean var9 = true;
                if (var0 instanceof NPCEntity) {
                    var9 = ((NPCEntity) var0).type.isClippedMovement;
                }

                if (var9) {
                    if (var0.angle != var0.orientation && var0.interacting == -1 && var0.direction != 0) {
                        var8 = 2;
                    }

                    if (var0.queueSize > 2) {
                        var8 = 6;
                    }

                    if (var0.queueSize > 3) {
                        var8 = 8;
                    }

                    if (var0.field955 > 0 && var0.queueSize > 1) {
                        var8 = 8;
                        --var0.field955;
                    }
                } else {
                    if (var0.queueSize > 1) {
                        var8 = 6;
                    }

                    if (var0.queueSize > 2) {
                        var8 = 8;
                    }

                    if (var0.field955 > 0 && var0.queueSize > 1) {
                        var8 = 8;
                        --var0.field955;
                    }
                }

                if (var5 == 2) {
                    var8 <<= 1;
                }

                if (var8 >= 8 && var0.poseAnimation == var0.walkAnim && var0.field951 != -1) {
                    var0.poseAnimation = var0.field951;
                }

                if (var10 != var3 || var4 != var2) {
                    if (var10 < var3) {
                        var0.x += var8;
                        if (var0.x > var3) {
                            var0.x = var3;
                        }
                    } else if (var10 > var3) {
                        var0.x -= var8;
                        if (var0.x < var3) {
                            var0.x = var3;
                        }
                    }

                    if (var2 < var4) {
                        var0.y += var8;
                        if (var0.y > var4) {
                            var0.y = var4;
                        }
                    } else if (var2 > var4) {
                        var0.y -= var8;
                        if (var0.y < var4) {
                            var0.y = var4;
                        }
                    }
                }

                if (var3 == var0.x && var4 == var0.y) {
                    --var0.queueSize;
                    if (var0.field959 > 0) {
                        --var0.field959;
                    }
                }

            } else {
                var0.x = var3;
                var0.y = var4;
                --var0.queueSize;
                if (var0.field959 > 0) {
                    --var0.field959;
                }

            }
        }
    }
}
