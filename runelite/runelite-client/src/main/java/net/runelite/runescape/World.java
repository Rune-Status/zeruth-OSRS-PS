package net.runelite.runescape;

import net.runelite.api.WorldType;
import net.runelite.api.events.WorldListLoad;
import net.runelite.mapping.*;
import net.runelite.rs.api.RSWorld;

import java.util.EnumSet;

@ObfuscatedName("be")
@Implements("World")
public class World implements RSWorld {
    @ObfuscatedName("rc")
    @ObfuscatedGetter(
            intValue = -399734509
    )
    static int field1026;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -1259213789
    )
    @Export("worldCount")
    static int worldCount;
    @ObfuscatedName("w")
    static int[] field1018;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -1595651663
    )
    static int field1014;
    @ObfuscatedName("n")
    static int[] field1016;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "[Lbe;"
    )
    @Export("worldList")
    static World[] worldList;
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "Leg;"
    )
    @Export("listFetcher")
    static UrlRequest listFetcher;
    @ObfuscatedName("je")
    @ObfuscatedSignature(
            signature = "Lhn;"
    )
    static ComponentType field1025;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = -1680372661
    )
    @Export("location")
    int location;
    @ObfuscatedName("x")
    @Export("activity")
    String activity;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = -1374022727
    )
    @Export("mask")
    int mask;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -1862972557
    )
    @Export("id")
    int id;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = -410084011
    )
    @Export("playerCount")
    int playerCount;
    @ObfuscatedName("j")
    @Export("address")
    String address;
    @ObfuscatedName("h")
    @ObfuscatedGetter(
            intValue = 1298569925
    )
    int index;

    static {
        worldCount = 0;
        field1014 = 0;
        field1018 = new int[]{1, 1, 1, 1};
        field1016 = new int[]{0, 1, 2, 3};
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1365937152"
    )
    boolean method3721() {
        return (33554432 & this.mask) != 0;
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1400916508"
    )
    boolean method3766() {
        return (8 & this.mask) != 0;
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "-96"
    )
    boolean method3722() {
        return (4 & this.mask) != 0;
    }

    public int getMask() {
        return this.mask;
    }

    public void setMask(int var1) {
        this.mask = var1;
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public void playerCountChanged(int var1) {
        RSWorld[] var2 = class166.clientInstance.getWorldList();
        if (var2 != null && var2.length > 0 && this == var2[var2.length - 1]) {
            WorldListLoad var3 = new WorldListLoad(var2);
            class166.clientInstance.getCallbacks().post(var3);
        }

    }

    public EnumSet getTypes() {
        return WorldType.fromMask(this.getMask());
    }

    public void setTypes(EnumSet var1) {
        this.setMask(WorldType.toMask(var1));
    }

    public void setId(int var1) {
        this.id = var1;
    }

    public int getId() {
        return this.id;
    }

    public void setPlayerCount(int var1) {
        this.playerCount = var1;
    }

    public int getPlayerCount() {
        return this.playerCount;
    }

    public void setAddress(String var1) {
        this.address = var1;
    }

    public String getAddress() {
        return this.address;
    }

    public void setActivity(String var1) {
        this.activity = var1;
    }

    public String getActivity() {
        return this.activity;
    }

    public void setLocation(int var1) {
        this.location = var1;
    }

    public int getLocation() {
        return this.location;
    }

    public void setIndex(int var1) {
        this.index = var1;
    }

    public int getIndex() {
        return this.index;
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1158560872"
    )
    boolean method3719() {
        return (1 & this.mask) != 0;
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(S)Z",
            garbageValue = "5159"
    )
    boolean method3769() {
        return (2 & this.mask) != 0;
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "1605624169"
    )
    boolean method3724() {
        return (536870912 & this.mask) != 0;
    }

    @ObfuscatedName("iw")
    @ObfuscatedSignature(
            signature = "(IIIII)V",
            garbageValue = "-1629270818"
    )
    static final void method3742(int var0, int var1, int var2, int var3) {
        if (client.itemSelectionState == 0 && !client.spellSelected) {
            class316.method5992("Walk here", "", 23, 0, var0 - var2, var1 - var3);
        }

        long var4 = -1L;
        long var6 = -1L;
        int var8 = 0;

        while (true) {
            int var10 = class195.Viewport_entityCountAtMouse;
            if (var8 >= var10) {
                if (-1L != var4) {
                    var8 = MapLabel.method5553(var4);
                    int var9 = class202.method4050(var4);
                    PlayerEntity var26 = client.players[client.field769];
                    class230.method4544(var26, client.field769, var8, var9);
                }

                return;
            }

            long var11 = class195.field1714[var8];
            if (var6 != var11) {
                label333:
                {
                    var6 = var11;
                    int var15 = Friend.method2731(var8);
                    int var16 = class202.method4050(class195.field1714[var8]);
                    int var17 = var16;
                    int var18 = class324.method6372(var8);
                    int var19 = class39.method596(var8);
                    if (var18 == 2 && class131.sceneManager.method3825(class228.level, var15, var16, var11) >= 0) {
                        LocType var20 = class225.method4485(var19);
                        if (var20.multiLocs != null) {
                            var20 = var20.method1717();
                        }

                        if (var20 == null) {
                            break label333;
                        }

                        if (client.itemSelectionState == 1) {
                            class316.method5992("Use", client.lastSelectedItemName + " " + "->" + " " + class31.method548(65535) + var20.name, 1, var19, var15, var16);
                        } else if (client.spellSelected) {
                            if ((FontName.ifTargetMask & 4) == 4) {
                                class316.method5992(client.targetVerb, client.opBase + " " + "->" + " " + class31.method548(65535) + var20.name, 2, var19, var15, var16);
                            }
                        } else {
                            String[] var27 = var20.actions;
                            if (var27 != null) {
                                for (int var28 = 4; var28 >= 0; --var28) {
                                    if (var27[var28] != null) {
                                        short var23 = 0;
                                        if (var28 == 0) {
                                            var23 = 3;
                                        }

                                        if (var28 == 1) {
                                            var23 = 4;
                                        }

                                        if (var28 == 2) {
                                            var23 = 5;
                                        }

                                        if (var28 == 3) {
                                            var23 = 6;
                                        }

                                        if (var28 == 4) {
                                            var23 = 1001;
                                        }

                                        class316.method5992(var27[var28], class31.method548(65535) + var20.name, var23, var19, var15, var17);
                                    }
                                }
                            }

                            class316.method5992("Examine", class31.method548(65535) + var20.name, 1002, var20.field3469, var15, var17);
                        }
                    }

                    int var21;
                    NPCEntity var22;
                    PlayerEntity var24;
                    int[] var34;
                    int var36;
                    if (var18 == 1) {
                        NPCEntity var31 = client.npcs[var19];
                        if (var31 == null) {
                            break label333;
                        }

                        if (var31.type.size == 1 && (var31.x & 127) == 64 && (var31.y & 127) == 64) {
                            for (var21 = 0; var21 < client.highResolutionNpcCount; ++var21) {
                                var22 = client.npcs[client.highResolutionNpcIndexes[var21]];
                                if (var22 != null && var22 != var31 && var22.type.size == 1 && var22.x == var31.x && var22.y == var31.y) {
                                    ClientOptions.method6499(var22.type, client.highResolutionNpcIndexes[var21], var15, var17);
                                }
                            }

                            var21 = class254.highResolutionPlayerCount;
                            var34 = class254.highResolutionPlayerIndexes;

                            for (var36 = 0; var36 < var21; ++var36) {
                                var24 = client.players[var34[var36]];
                                if (var24 != null && var24.x == var31.x && var31.y == var24.y) {
                                    class230.method4544(var24, var34[var36], var15, var17);
                                }
                            }
                        }

                        ClientOptions.method6499(var31.type, var19, var15, var17);
                    }

                    if (var18 == 0) {
                        PlayerEntity var32 = client.players[var19];
                        if (var32 == null) {
                            break label333;
                        }

                        if ((var32.x & 127) == 64 && (var32.y & 127) == 64) {
                            for (var21 = 0; var21 < client.highResolutionNpcCount; ++var21) {
                                var22 = client.npcs[client.highResolutionNpcIndexes[var21]];
                                if (var22 != null && var22.type.size == 1 && var32.x == var22.x && var32.y == var22.y) {
                                    ClientOptions.method6499(var22.type, client.highResolutionNpcIndexes[var21], var15, var17);
                                }
                            }

                            var21 = class254.highResolutionPlayerCount;
                            var34 = class254.highResolutionPlayerIndexes;

                            for (var36 = 0; var36 < var21; ++var36) {
                                var24 = client.players[var34[var36]];
                                if (var24 != null && var32 != var24 && var24.x == var32.x && var24.y == var32.y) {
                                    class230.method4544(var24, var34[var36], var15, var17);
                                }
                            }
                        }

                        if (var19 != client.field769) {
                            class230.method4544(var32, var19, var15, var17);
                        } else {
                            var4 = var11;
                        }
                    }

                    if (var18 == 3) {
                        Deque var33 = client.groundItemDeque[class228.level][var15][var17];
                        if (var33 != null) {
                            for (Item var37 = (Item) var33.method4349(); var37 != null; var37 = (Item) var33.method4370()) {
                                ObjType var35 = Varcs.method4770(var37.id);
                                if (client.itemSelectionState == 1) {
                                    class316.method5992("Use", client.lastSelectedItemName + " " + "->" + " " + class31.method548(16748608) + var35.name, 16, var37.id, var15, var17);
                                } else if (client.spellSelected) {
                                    if ((FontName.ifTargetMask & 1) == 1) {
                                        class316.method5992(client.targetVerb, client.opBase + " " + "->" + " " + class31.method548(16748608) + var35.name, 17, var37.id, var15, var17);
                                    }
                                } else {
                                    String[] var29 = var35.ops;

                                    for (int var30 = 4; var30 >= 0; --var30) {
                                        if (var29 != null && var29[var30] != null) {
                                            byte var25 = 0;
                                            if (var30 == 0) {
                                                var25 = 18;
                                            }

                                            if (var30 == 1) {
                                                var25 = 19;
                                            }

                                            if (var30 == 2) {
                                                var25 = 20;
                                            }

                                            if (var30 == 3) {
                                                var25 = 21;
                                            }

                                            if (var30 == 4) {
                                                var25 = 22;
                                            }

                                            class316.method5992(var29[var30], class31.method548(16748608) + var35.name, var25, var37.id, var15, var17);
                                        } else if (var30 == 2) {
                                            class316.method5992("Take", class31.method548(16748608) + var35.name, 20, var37.id, var15, var17);
                                        }
                                    }

                                    class316.method5992("Examine", class31.method548(16748608) + var35.name, 1004, var37.id, var15, var17);
                                }
                            }
                        }
                    }
                }
            }

            ++var8;
        }
    }

    @ObfuscatedName("gn")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "-101"
    )
    static boolean method3762() {
        return (client.playerNameMask & 4) != 0;
    }

    @ObfuscatedName("gt")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-17"
    )
    static void method3770() {
        if (client.field762) {
            PlayerEntity.method2924(class4.localPlayer, false);
        }

    }

    @ObfuscatedName("fd")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "668319697"
    )
    static final void method3731() {
        int var0 = class254.highResolutionPlayerCount;
        int[] var1 = class254.highResolutionPlayerIndexes;

        for (int var2 = 0; var2 < var0; ++var2) {
            PlayerEntity var3 = client.players[var1[var2]];
            if (var3 != null) {
                AuthProt.method1671(var3, 1);
            }
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)[Lfc;",
            garbageValue = "2144968091"
    )
    public static ZoneProt[] method3768() {
        return new ZoneProt[]{ZoneProt.ALTER_GROUND_ITEM, ZoneProt.MAP_PROJANIM, ZoneProt.field2318, ZoneProt.MAP_ANIM, ZoneProt.LOC_ANIM, ZoneProt.SOUND_AREA, ZoneProt.LOC_DEL, ZoneProt.GROUND_ITEM_REMOVE, ZoneProt.GROUND_ITEM_ADD, ZoneProt.LOC_ADD_CHANGE};
    }
}
