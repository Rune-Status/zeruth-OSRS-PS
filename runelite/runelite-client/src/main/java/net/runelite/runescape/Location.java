package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDynamicObject;

@ObfuscatedName("cy")
@Implements("Location")
public class Location extends Entity implements RSDynamicObject {
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 1653421913
    )
    int sceneY;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -981205583
    )
    int type;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -54568097
    )
    int orientation;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 1697176731
    )
    int animFrame;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 2088221983
    )
    int level;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Ljg;"
    )
    Sequence animation;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -1253707747
    )
    int animCycleCount;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 940711893
    )
    int sceneX;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1351303971
    )
    int id;

    @ObfuscatedSignature(
            signature = "(IIIIIIIZLdd;)V"
    )
    Location(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Entity var9) {
        this.id = var1;
        this.type = var2;
        this.orientation = var3;
        this.level = var4;
        this.sceneX = var5;
        this.sceneY = var6;
        if (var7 != -1) {
            this.animation = MapCacheArchiveNames.method2149(var7);
            this.animFrame = 0;
            this.animCycleCount = client.gameCycle - 1;
            this.onAnimCycleCountChanged(-1);
            if (this.animation.replyMode == 0 && var9 != null && var9 instanceof Location) {
                Location var10 = (Location) var9;
                if (this.animation == var10.animation) {
                    this.animFrame = var10.animFrame;
                    this.animCycleCount = var10.animCycleCount;
                    this.onAnimCycleCountChanged(-1);
                    return;
                }
            }

            if (var8 && this.animation.frameStep != -1) {
                this.animFrame = (int) (Math.random() * (double) this.animation.frameIDs.length);
                this.animCycleCount -= (int) (Math.random() * (double) this.animation.frameLengths[this.animFrame]);
                this.onAnimCycleCountChanged(-1);
            }
        }

    }

    public int getAnimFrame() {
        return this.animFrame;
    }

    @ObfuscatedSignature(
            signature = "(I)Ldl;"
    )
    public final Model copy$getModel(int var1) {
        if (this.animation != null) {
            int var2 = client.gameCycle - this.animCycleCount;
            if (var2 > 100 && this.animation.frameStep > 0) {
                var2 = 100;
            }

            label53:
            {
                do {
                    do {
                        if (var2 <= this.animation.frameLengths[this.animFrame]) {
                            break label53;
                        }

                        var2 -= this.animation.frameLengths[this.animFrame];
                        ++this.animFrame;
                    } while (this.animFrame < this.animation.frameIDs.length);

                    this.animFrame -= this.animation.frameStep;
                } while (this.animFrame >= 0 && this.animFrame < this.animation.frameIDs.length);

                this.animation = null;
            }

            this.animCycleCount = client.gameCycle - var2;
            this.onAnimCycleCountChanged(-1);
        }

        LocType var13 = class225.method4485(this.id);
        if (var13.multiLocs != null) {
            var13 = var13.method1717();
        }

        if (var13 == null) {
            return null;
        } else {
            int var3;
            int var4;
            if (this.orientation != 1 && this.orientation != 3) {
                var3 = var13.width;
                var4 = var13.length;
            } else {
                var3 = var13.length;
                var4 = var13.width;
            }

            int var5 = (var3 >> 1) + this.sceneX;
            int var6 = (var3 + 1 >> 1) + this.sceneX;
            int var7 = (var4 >> 1) + this.sceneY;
            int var8 = (var4 + 1 >> 1) + this.sceneY;
            int[][] var9 = class98.tileHeights[this.level];
            int var10 = var9[var6][var8] + var9[var5][var7] + var9[var6][var7] + var9[var5][var8] >> 2;
            int var11 = (this.sceneX << 7) + (var3 << 6);
            int var12 = (this.sceneY << 7) + (var4 << 6);
            return var13.method1750(this.type, this.orientation, var9, var11, var10, var12, this.animation, this.animFrame);
        }
    }

    public void setAnimFrame(int var1) {
        this.animFrame = var1;
    }

    public int getAnimCycleCount() {
        return this.animCycleCount;
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public void onAnimCycleCountChanged(int var1) {
        if (class166.clientInstance.isInterpolateObjectAnimations()) {
            int var2 = class166.clientInstance.getGameCycle() - this.getAnimCycleCount();
            this.setAnimFrame(Integer.MIN_VALUE | var2 << 16 | this.getAnimFrame());
        }

    }

    public int getId() {
        return this.id;
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)Ldl;"
    )
    protected final Model vmethod5584(int var1) {
        boolean var8 = false;

        Model var3;
        try {
            var8 = true;
            int var2 = this.getAnimFrame();
            if (var2 < 0) {
                this.setAnimFrame((var2 ^ Integer.MIN_VALUE) & 65535);
            }

            var3 = this.copy$getModel(var1);
            var8 = false;
        } finally {
            if (var8) {
                int var6 = this.getAnimFrame();
                if (var6 < 0) {
                    this.setAnimFrame((var6 ^ Integer.MIN_VALUE) & 65535);
                }

            }
        }

        int var4 = this.getAnimFrame();
        if (var4 < 0) {
            this.setAnimFrame((var4 ^ Integer.MIN_VALUE) & 65535);
        }

        return (Model) var3;
    }

    @ObfuscatedName("jc")
    @ObfuscatedSignature(
            signature = "(Lhn;IIIB)V",
            garbageValue = "106"
    )
    static final void method2965(ComponentType var0, int var1, int var2, int var3) {
        class96 var4 = var0.method270(false);
        if (var4 != null) {
            if (client.minimapRenderType < 3) {
                class306.compass.method2269(var1, var2, var4.field2626, var4.field2621, 25, 25, client.mapAngle, 256, var4.field2623, var4.field2622);
            } else {
                Rasterizer2D.method460(var1, var2, 0, var4.field2623, var4.field2622);
            }

        }
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "267457117"
    )
    static int method2961(int var0, class106 var1, boolean var2) {
        ComponentType var3 = var2 ? class113.field75 : class48.field1080;
        if (var0 == 1500) {
            class48.intStack[++class228.intStackSize - 1] = var3.x;
            return 1;
        } else if (var0 == 1501) {
            class48.intStack[++class228.intStackSize - 1] = var3.y;
            return 1;
        } else if (var0 == 1502) {
            class48.intStack[++class228.intStackSize - 1] = var3.width;
            return 1;
        } else if (var0 == 1503) {
            class48.intStack[++class228.intStackSize - 1] = var3.height;
            return 1;
        } else if (var0 == 1504) {
            class48.intStack[++class228.intStackSize - 1] = var3.isHidden ? 1 : 0;
            return 1;
        } else if (var0 == 1505) {
            class48.intStack[++class228.intStackSize - 1] = var3.layer;
            return 1;
        } else {
            return 2;
        }
    }
}
