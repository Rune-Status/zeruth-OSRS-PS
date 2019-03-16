package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
    @ObfuscatedName("ny")
    @ObfuscatedSignature(
            signature = "[Lhn;"
    )
    static ComponentType[] field165;
    @ObfuscatedName("fy")
    @ObfuscatedSignature(
            signature = "Lkz;"
    )
    static Font fontPlain11;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -1802445527
    )
    int field169;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 335424621
    )
    int field164;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1392128691
    )
    int field166;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = -792087143
    )
    int field171;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -2035474347
    )
    int field177;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 848470811
    )
    int field167;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -282616471
    )
    int field172;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -1967716531
    )
    int field168;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 1176518925
    )
    int field173;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1446534039
    )
    int field174;

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IIIB)Z",
            garbageValue = "-81"
    )
    public boolean vmethod5812(int var1, int var2, int var3) {
        return var1 >= this.field174 && var1 < this.field164 + this.field174 ? var2 >> 6 >= this.field166 && var2 >> 6 <= this.field168 && var3 >> 6 >= this.field177 && var3 >> 6 <= this.field169 : false;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IIB)Z",
            garbageValue = "79"
    )
    public boolean vmethod5811(int var1, int var2) {
        return var1 >> 6 >= this.field167 && var1 >> 6 <= this.field172 && var2 >> 6 >= this.field171 && var2 >> 6 <= this.field173;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(IIII)[I",
            garbageValue = "-1381851995"
    )
    public int[] vmethod5814(int var1, int var2, int var3) {
        if (!this.vmethod5812(var1, var2, var3)) {
            return null;
        } else {
            int[] var4 = new int[]{this.field167 * 64 - this.field166 * 64 + var2, var3 + (this.field171 * 64 - this.field177 * 64)};
            return var4;
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "753243796"
    )
    void method2461() {
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IIB)Lhz;",
            garbageValue = "-126"
    )
    public Coordinates vmethod5817(int var1, int var2) {
        if (!this.vmethod5811(var1, var2)) {
            return null;
        } else {
            int var3 = this.field166 * 64 - this.field167 * 64 + var1;
            int var4 = this.field177 * 64 - this.field171 * 64 + var2;
            return new Coordinates(this.field174, var3, var4);
        }
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-821481708"
    )
    public void vmethod5829(Packet var1) {
        this.field174 = var1.readUnsignedByte();
        this.field164 = var1.readUnsignedByte();
        this.field166 = var1.readUnsignedShort();
        this.field177 = var1.readUnsignedShort();
        this.field168 = var1.readUnsignedShort();
        this.field169 = var1.readUnsignedShort();
        this.field167 = var1.readUnsignedShort();
        this.field171 = var1.readUnsignedShort();
        this.field172 = var1.readUnsignedShort();
        this.field173 = var1.readUnsignedShort();
        this.method2461();
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lk;B)V",
            garbageValue = "-126"
    )
    public void vmethod5820(WorldMapData var1) {
        if (var1.minX > this.field167) {
            var1.minX = this.field167;
        }

        if (var1.field199 < this.field172) {
            var1.field199 = this.field172;
        }

        if (var1.minY > this.field171) {
            var1.minY = this.field171;
        }

        if (var1.field203 < this.field173) {
            var1.field203 = this.field173;
        }

    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(ILcx;ZB)I",
            garbageValue = "12"
    )
    static int method2465(int var0, class106 var1, boolean var2) {
        ComponentType var3;
        if (var0 >= 2000) {
            var0 -= 1000;
            var3 = method2440(class48.intStack[--class228.intStackSize]);
        } else {
            var3 = var2 ? class113.field75 : class48.field1080;
        }

        String var4 = class48.scriptStringStack[--class48.scriptStringStackSize];
        int[] var5 = null;
        if (var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
            int var6 = class48.intStack[--class228.intStackSize];
            if (var6 > 0) {
                for (var5 = new int[var6]; var6-- > 0; var5[var6] = class48.intStack[--class228.intStackSize]) {
                    ;
                }
            }

            var4 = var4.substring(0, var4.length() - 1);
        }

        Object[] var8 = new Object[var4.length() + 1];

        int var7;
        for (var7 = var8.length - 1; var7 >= 1; --var7) {
            if (var4.charAt(var7 - 1) == 's') {
                var8[var7] = class48.scriptStringStack[--class48.scriptStringStackSize];
            } else {
                var8[var7] = new Integer(class48.intStack[--class228.intStackSize]);
            }
        }

        var7 = class48.intStack[--class228.intStackSize];
        if (var7 != -1) {
            var8[0] = new Integer(var7);
        } else {
            var8 = null;
        }

        if (var0 == 1400) {
            var3.onClickListener = var8;
        } else if (var0 == 1401) {
            var3.onHoldListener = var8;
        } else if (var0 == 1402) {
            var3.onReleaseListener = var8;
        } else if (var0 == 1403) {
            var3.onMouseOverListener = var8;
        } else if (var0 == 1404) {
            var3.onMouseLeaveListener = var8;
        } else if (var0 == 1405) {
            var3.onDragListener = var8;
        } else if (var0 == 1406) {
            var3.onTargetLeaveListener = var8;
        } else if (var0 == 1407) {
            var3.onVarTransmitListener = var8;
            var3.varTransmitTriggers = var5;
        } else if (var0 == 1408) {
            var3.onTimerListener = var8;
        } else if (var0 == 1409) {
            var3.onOpListener = var8;
        } else if (var0 == 1410) {
            var3.onDragCompleteListener = var8;
        } else if (var0 == 1411) {
            var3.onClickRepeatListener = var8;
        } else if (var0 == 1412) {
            var3.onMouseRepeatListener = var8;
        } else if (var0 == 1414) {
            var3.onInvTransmitListener = var8;
            var3.invTransmitTriggers = var5;
        } else if (var0 == 1415) {
            var3.onStatTransmitListener = var8;
            var3.statTransmitTriggers = var5;
        } else if (var0 == 1416) {
            var3.onTargetEnterListener = var8;
        } else if (var0 == 1417) {
            var3.onScrollWheelListener = var8;
        } else if (var0 == 1418) {
            var3.onChatTransmitListener = var8;
        } else if (var0 == 1419) {
            var3.onKeyListener = var8;
        } else if (var0 == 1420) {
            var3.onFriendTransmitListener = var8;
        } else if (var0 == 1421) {
            var3.onClanTransmitListener = var8;
        } else if (var0 == 1422) {
            var3.onMiscTransmitListener = var8;
        } else if (var0 == 1423) {
            var3.onDialogAbortListener = var8;
        } else if (var0 == 1424) {
            var3.onSubChangeListener = var8;
        } else if (var0 == 1425) {
            var3.onStockTransmitListener = var8;
        } else if (var0 == 1426) {
            var3.onCamFinishedListener = var8;
        } else {
            if (var0 != 1427) {
                return 2;
            }

            var3.onResizeListener = var8;
        }

        var3.hasHook = true;
        return 1;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)Lhn;",
            garbageValue = "-2072336047"
    )
    public static ComponentType method2440(int var0) {
        int var1 = var0 >> 16;
        int var2 = var0 & 65535;
        if (class36.interfaces[var1] == null || class36.interfaces[var1][var2] == null) {
            boolean var3 = class232.method4564(var1);
            if (!var3) {
                return null;
            }
        }

        return class36.interfaces[var1][var2];
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)V",
            garbageValue = "2131882265"
    )
    static final void method2464(String var0) {
        class115.method2002(var0 + " is already on your friend list");
    }

    @ObfuscatedName("ix")
    @ObfuscatedSignature(
            signature = "(Lhn;I)Z",
            garbageValue = "-2079901496"
    )
    static final boolean method2466(ComponentType var0) {
        if (var0.tableActions == null) {
            return false;
        } else {
            for (int var1 = 0; var1 < var0.tableActions.length; ++var1) {
                int var2 = class9.method130(var0, var1);
                int var3 = var0.field2778[var1];
                if (var0.tableActions[var1] == 2) {
                    if (var2 >= var3) {
                        return false;
                    }
                } else if (var0.tableActions[var1] == 3) {
                    if (var2 <= var3) {
                        return false;
                    }
                } else if (var0.tableActions[var1] == 4) {
                    if (var3 == var2) {
                        return false;
                    }
                } else if (var3 != var2) {
                    return false;
                }
            }

            return true;
        }
    }
}
