package net.runelite.runescape;

import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.GraphicsObjectCreated;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGraphicsObject;

@ObfuscatedName("bx")
@Implements("SpotAnimation")
public final class SpotAnimation extends Entity implements RSGraphicsObject {
    @ObfuscatedName("di")
    @ObfuscatedSignature(
            signature = "Lih;"
    )
    static Js5 fontmetrics;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 363271655
    )
    int height;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -1651212881
    )
    int startCycle;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1635763877
    )
    int level;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = -1481994629
    )
    int field1084;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -538215099
    )
    int x;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Ljg;"
    )
    Sequence field1090;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = 2143243713
    )
    int field1094;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -677291095
    )
    int y;
    @ObfuscatedName("i")
    boolean finished;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 1722620293
    )
    int id;

    SpotAnimation(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        this.field1084 = 0;
        this.field1094 = 0;
        this.finished = false;
        this.id = var1;
        this.level = var2;
        this.x = var3;
        this.y = var4;
        this.height = var5;
        this.startCycle = var7 + var6;
        int var8 = IndexStoreActionHandler.method5748(this.id).field3348;
        if (var8 != -1) {
            this.finished = false;
            this.field1090 = MapCacheArchiveNames.method2149(var8);
        } else {
            this.finished = true;
        }

        this.rl$$init();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    private void rl$$init() {
        GraphicsObjectCreated var1 = new GraphicsObjectCreated(this);
        class166.clientInstance.getCallbacks().post(var1);
    }

    public LocalPoint getLocation() {
        return new LocalPoint(this.getX(), this.getY());
    }

    public int getId() {
        return this.id;
    }

    public int getStartCycle() {
        return this.startCycle;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHeight() {
        return this.height;
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)Ldl;"
    )
    protected final Model vmethod5584(int var1) {
        Spotanim var2 = IndexStoreActionHandler.method5748(this.id);
        Model var3;
        if (!this.finished) {
            var3 = var2.method5304(this.field1084);
        } else {
            var3 = var2.method5304(-1);
        }

        return var3 == null ? null : var3;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "0"
    )
    final void method5439(int var1) {
        if (!this.finished) {
            this.field1094 += var1;

            while (this.field1094 > this.field1090.frameLengths[this.field1084]) {
                this.field1094 -= this.field1090.frameLengths[this.field1084];
                ++this.field1084;
                if (this.field1084 >= this.field1090.frameIDs.length) {
                    this.finished = true;
                    break;
                }
            }

        }
    }

    @ObfuscatedName("ii")
    @ObfuscatedSignature(
            signature = "(Lhn;III)V",
            garbageValue = "754256415"
    )
    static final void method5435(ComponentType var0, int var1, int var2) {
        if (var0.buttonType == 1) {
            class316.method5992(var0.tooltip, "", 24, 0, 0, var0.id);
        }

        String var3;
        if (var0.buttonType == 2 && !client.spellSelected) {
            var3 = class106.method1886(var0);
            if (var3 != null) {
                class316.method5992(var3, class31.method548(65280) + var0.spellName, 25, 0, -1, var0.id);
            }
        }

        if (var0.buttonType == 3) {
            class316.method5992("Close", "", 26, 0, 0, var0.id);
        }

        if (var0.buttonType == 4) {
            class316.method5992(var0.tooltip, "", 28, 0, 0, var0.id);
        }

        if (var0.buttonType == 5) {
            class316.method5992(var0.tooltip, "", 29, 0, 0, var0.id);
        }

        if (var0.buttonType == 6 && client.field880 == null) {
            class316.method5992(var0.tooltip, "", 30, 0, -1, var0.id);
        }

        int var4;
        int var5;
        int var6;
        int var7;
        int var15;
        if (var0.type == 2) {
            var15 = 0;

            for (var4 = 0; var4 < var0.height; ++var4) {
                for (var5 = 0; var5 < var0.width; ++var5) {
                    var6 = (var0.paddingX + 32) * var5;
                    var7 = (var0.paddingY + 32) * var4;
                    if (var15 < 20) {
                        var6 += var0.xSprites[var15];
                        var7 += var0.field2737[var15];
                    }

                    if (var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                        client.field797 = var15;
                        class260.field104 = var0;
                        if (var0.objIds[var15] > 0) {
                            ObjType var8 = Varcs.method4770(var0.objIds[var15] - 1);
                            if (client.itemSelectionState == 1 && LoginProt.method870(class101.method1704(var0))) {
                                if (var0.id != ChatLineBuffer.field1276 || var15 != MapLabel.selectedItemIndex) {
                                    class316.method5992("Use", client.lastSelectedItemName + " " + "->" + " " + class31.method548(16748608) + var8.name, 31, var8.id, var15, var0.id);
                                }
                            } else if (client.spellSelected && LoginProt.method870(class101.method1704(var0))) {
                                if ((FontName.ifTargetMask & 16) == 16) {
                                    class316.method5992(client.targetVerb, client.opBase + " " + "->" + " " + class31.method548(16748608) + var8.name, 32, var8.id, var15, var0.id);
                                }
                            } else {
                                String[] var9 = var8.iops;
                                int var10 = -1;
                                boolean var11;
                                if (client.field789) {
                                    var11 = client.field790 || KeyFocusListener.keyPressed[81];
                                    if (var11) {
                                        var10 = var8.method6319(982890618);
                                    }
                                }

                                if (LoginProt.method870(class101.method1704(var0))) {
                                    for (int var22 = 4; var22 >= 3; --var22) {
                                        if (var10 != var22) {
                                            class260.method5007(var0, var8, var15, var22, false);
                                        }
                                    }
                                }

                                int var12 = class101.method1704(var0);
                                var11 = (var12 >> 31 & 1) != 0;
                                if (var11) {
                                    class316.method5992("Use", class31.method548(16748608) + var8.name, 38, var8.id, var15, var0.id);
                                }

                                Object var10000 = null;
                                int var13;
                                if (LoginProt.method870(class101.method1704(var0))) {
                                    for (var13 = 2; var13 >= 0; --var13) {
                                        if (var13 != var10) {
                                            class260.method5007(var0, var8, var15, var13, false);
                                        }
                                    }

                                    if (var10 >= 0) {
                                        class260.method5007(var0, var8, var15, var10, true);
                                    }
                                }

                                var9 = var0.if1Ops;
                                if (var9 != null) {
                                    for (var13 = 4; var13 >= 0; --var13) {
                                        if (var9[var13] != null) {
                                            byte var14 = 0;
                                            if (var13 == 0) {
                                                var14 = 39;
                                            }

                                            if (var13 == 1) {
                                                var14 = 40;
                                            }

                                            if (var13 == 2) {
                                                var14 = 41;
                                            }

                                            if (var13 == 3) {
                                                var14 = 42;
                                            }

                                            if (var13 == 4) {
                                                var14 = 43;
                                            }

                                            class316.method5992(var9[var13], class31.method548(16748608) + var8.name, var14, var8.id, var15, var0.id);
                                        }
                                    }
                                }

                                class316.method5992("Examine", class31.method548(16748608) + var8.name, 1005, var8.id, var15, var0.id);
                            }
                        }
                    }

                    ++var15;
                }
            }
        }

        if (var0.isIf3) {
            if (client.spellSelected) {
                var4 = class101.method1704(var0);
                boolean var23 = (var4 >> 21 & 1) != 0;
                if (var23 && (FontName.ifTargetMask & 32) == 32) {
                    class316.method5992(client.targetVerb, client.opBase + " " + "->" + " " + var0.opBase, 58, 0, var0.index, var0.id);
                }
            } else {
                for (var15 = 9; var15 >= 5; --var15) {
                    var6 = class101.method1704(var0);
                    boolean var19 = (var6 >> var15 + 1 & 1) != 0;
                    String var16;
                    if (!var19 && var0.onOpListener == null) {
                        var16 = null;
                    } else if (var0.ops != null && var0.ops.length > var15 && var0.ops[var15] != null && var0.ops[var15].trim().length() != 0) {
                        var16 = var0.ops[var15];
                    } else {
                        var16 = null;
                    }

                    if (var16 != null) {
                        class316.method5992(var16, var0.opBase, 1007, var15 + 1, var0.index, var0.id);
                    }
                }

                var3 = class106.method1886(var0);
                if (var3 != null) {
                    class316.method5992(var3, var0.opBase, 25, 0, var0.index, var0.id);
                }

                for (var4 = 4; var4 >= 0; --var4) {
                    var7 = class101.method1704(var0);
                    boolean var21 = (var7 >> var4 + 1 & 1) != 0;
                    String var17;
                    if (!var21 && var0.onOpListener == null) {
                        var17 = null;
                    } else if (var0.ops != null && var0.ops.length > var4 && var0.ops[var4] != null && var0.ops[var4].trim().length() != 0) {
                        var17 = var0.ops[var4];
                    } else {
                        var17 = null;
                    }

                    if (var17 != null) {
                        class316.method5992(var17, var0.opBase, 57, var4 + 1, var0.index, var0.id);
                    }
                }

                var5 = class101.method1704(var0);
                boolean var20 = (var5 & 1) != 0;
                if (var20) {
                    class316.method5992("Continue", "", 30, 0, var0.index, var0.id);
                }
            }
        }

    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "42"
    )
    static void method5442(int var0) {
        ItemContainer var1 = (ItemContainer) ItemContainer.itemContainers.method380((long) var0);
        if (var1 != null) {
            for (int var2 = 0; var2 < var1.itemIds.length; ++var2) {
                var1.itemIds[var2] = -1;
                var1.stackSizes[var2] = 0;
                var1.stackSizesChanged(var2);
            }

        }
    }
}
