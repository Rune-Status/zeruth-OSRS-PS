package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFriendContainer;

@ObfuscatedName("kl")
@Implements("FriendContainer")
public class FriendContainer extends NameableContainer implements RSFriendContainer {
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = -2088850883
    )
    static int field3719;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    final JagexLoginType field3716;
    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "Lhk;"
    )
    public class185 field3717;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = -668014565
    )
    int field3718;

    @ObfuscatedSignature(
            signature = "(Llq;)V"
    )
    public FriendContainer(JagexLoginType var1) {
        super(400);
        this.field3718 = 1;
        this.field3717 = new class185();
        this.field3716 = var1;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)[Ljr;",
            garbageValue = "-1957564969"
    )
    Nameable[] vmethod5255(int var1) {
        return new Friend[var1];
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lkg;ZI)Z",
            garbageValue = "-709116424"
    )
    public boolean method2421(Name var1, boolean var2) {
        Friend var3 = (Friend) this.method5228(var1);
        return var3 == null ? false : !var2 || var3.world != 0;
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(Lgl;IB)V",
            garbageValue = "113"
    )
    public void method2422(Packet var1, int var2) {
        while (true) {
            if (var1.offset < var2) {
                boolean var3 = var1.readUnsignedByte() == 1;
                Name var4 = new Name(var1.readString(), this.field3716);
                Name var5 = new Name(var1.readString(), this.field3716);
                int var6 = var1.readUnsignedShort();
                int var7 = var1.readUnsignedByte();
                int var8 = var1.readUnsignedByte();
                boolean var9 = (var8 & 2) != 0;
                boolean var10 = (var8 & 1) != 0;
                if (var6 > 0) {
                    var1.readString();
                    var1.readUnsignedByte();
                    var1.getInt();
                }

                var1.readString();
                if (var4 != null && var4.method4714()) {
                    Friend var11 = (Friend) this.method5229(var4);
                    if (var3) {
                        Friend var12 = (Friend) this.method5229(var5);
                        if (var12 != null && var12 != var11) {
                            if (var11 != null) {
                                this.method5280(var12);
                            } else {
                                var11 = var12;
                            }
                        }
                    }

                    if (var11 != null) {
                        this.method5230(var11, var4, var5);
                        if (var6 != var11.world) {
                            boolean var14 = true;

                            for (class309 var13 = (class309) this.field3717.method3624(); var13 != null; var13 = (class309) this.field3717.method3625()) {
                                if (var13.field3734.equals(var4)) {
                                    if (var6 != 0 && var13.field3735 == 0) {
                                        var13.method2692();
                                        var14 = false;
                                    } else if (var6 == 0 && var13.field3735 != 0) {
                                        var13.method2692();
                                        var14 = false;
                                    }
                                }
                            }

                            if (var14) {
                                this.field3717.method3623(new class309(var4, var6));
                            }
                        }
                    } else {
                        if (this.method5225() >= 400) {
                            continue;
                        }

                        var11 = (Friend) this.method5233(var4, var5);
                    }

                    if (var6 != var11.world) {
                        var11.field3706 = ++this.field3718 - 1;
                        if (var11.world == -1 && var6 == 0) {
                            var11.field3706 = -(var11.field3706 * -602300361) * 845682055;
                        }

                        var11.world = var6;
                    }

                    var11.rank = var7;
                    var11.field3723 = var9;
                    var11.field3724 = var10;
                    continue;
                }

                throw new IllegalStateException();
            }

            this.method5240();
            return;
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)Ljr;",
            garbageValue = "-1755896640"
    )
    Nameable vmethod5242() {
        return new Friend();
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "-496649045"
    )
    static int method2424(int var0, class106 var1, boolean var2) {
        boolean var3 = true;
        ComponentType var4;
        if (var0 >= 2000) {
            var0 -= 1000;
            var4 = WorldMapType1.method2440(class48.intStack[--class228.intStackSize]);
            var3 = false;
        } else {
            var4 = var2 ? class113.field75 : class48.field1080;
        }

        int var11;
        if (var0 == 1300) {
            var11 = class48.intStack[--class228.intStackSize] - 1;
            if (var11 >= 0 && var11 <= 9) {
                var4.method236(var11, class48.scriptStringStack[--class48.scriptStringStackSize]);
                return 1;
            } else {
                --class48.scriptStringStackSize;
                return 1;
            }
        } else {
            int var6;
            if (var0 == 1301) {
                class228.intStackSize -= 2;
                var11 = class48.intStack[class228.intStackSize];
                var6 = class48.intStack[class228.intStackSize + 1];
                var4.dragParent = class192.method3785(var11, var6);
                return 1;
            } else if (var0 == 1302) {
                var4.dragRenderBehavior = class48.intStack[--class228.intStackSize] == 1;
                return 1;
            } else if (var0 == 1303) {
                var4.dragDeadZone = class48.intStack[--class228.intStackSize];
                return 1;
            } else if (var0 == 1304) {
                var4.dragDeadTime = class48.intStack[--class228.intStackSize];
                return 1;
            } else if (var0 == 1305) {
                var4.opBase = class48.scriptStringStack[--class48.scriptStringStackSize];
                return 1;
            } else if (var0 == 1306) {
                var4.targetVerb = class48.scriptStringStack[--class48.scriptStringStackSize];
                return 1;
            } else if (var0 == 1307) {
                var4.ops = null;
                return 1;
            } else {
                int var7;
                byte[] var9;
                if (var0 != 1350) {
                    byte var5;
                    if (var0 == 1351) {
                        class228.intStackSize -= 2;
                        var5 = 10;
                        var9 = new byte[]{(byte) class48.intStack[class228.intStackSize]};
                        byte[] var10 = new byte[]{(byte) class48.intStack[class228.intStackSize + 1]};
                        class60.method884(var4, var5, var9, var10);
                        return 1;
                    } else if (var0 == 1352) {
                        class228.intStackSize -= 3;
                        var11 = class48.intStack[class228.intStackSize] - 1;
                        var6 = class48.intStack[class228.intStackSize + 1];
                        var7 = class48.intStack[class228.intStackSize + 2];
                        if (var11 >= 0 && var11 <= 9) {
                            FriendManager.method91(var4, var11, var6, var7);
                            return 1;
                        } else {
                            throw new RuntimeException();
                        }
                    } else if (var0 == 1353) {
                        var5 = 10;
                        var6 = class48.intStack[--class228.intStackSize];
                        var7 = class48.intStack[--class228.intStackSize];
                        FriendManager.method91(var4, var5, var6, var7);
                        return 1;
                    } else if (var0 == 1354) {
                        --class228.intStackSize;
                        var11 = class48.intStack[class228.intStackSize] - 1;
                        if (var11 >= 0 && var11 <= 9) {
                            Size.method4703(var4, var11);
                            return 1;
                        } else {
                            throw new RuntimeException();
                        }
                    } else if (var0 == 1355) {
                        var5 = 10;
                        Size.method4703(var4, var5);
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    byte[] var8 = null;
                    var9 = null;
                    if (var3) {
                        class228.intStackSize -= 10;

                        for (var7 = 0; var7 < 10 && class48.intStack[var7 + class228.intStackSize] >= 0; var7 += 2) {
                            ;
                        }

                        if (var7 > 0) {
                            var8 = new byte[var7 / 2];
                            var9 = new byte[var7 / 2];

                            for (var7 -= 2; var7 >= 0; var7 -= 2) {
                                var8[var7 / 2] = (byte) class48.intStack[var7 + class228.intStackSize];
                                var9[var7 / 2] = (byte) class48.intStack[var7 + class228.intStackSize + 1];
                            }
                        }
                    } else {
                        class228.intStackSize -= 2;
                        var8 = new byte[]{(byte) class48.intStack[class228.intStackSize]};
                        var9 = new byte[]{(byte) class48.intStack[class228.intStackSize + 1]};
                    }

                    var7 = class48.intStack[--class228.intStackSize] - 1;
                    if (var7 >= 0 && var7 <= 9) {
                        class60.method884(var4, var7, var8, var9);
                        return 1;
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
        }
    }
}
