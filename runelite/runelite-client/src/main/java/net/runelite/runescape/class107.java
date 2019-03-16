package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.net.URL;

@ObfuscatedName("m")
public class class107 {
    @ObfuscatedName("fm")
    @ObfuscatedGetter(
            intValue = 411930487
    )
    static int baseY;

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(IB)Lbw;",
            garbageValue = "-102"
    )
    static ChatLine method1887(int var0) {
        return (ChatLine) class202.messages.method2764((long) var0);
    }

    @ObfuscatedName("gb")
    @ObfuscatedSignature(
            signature = "(ZLge;I)V",
            garbageValue = "442724531"
    )
    static final void method1888(boolean var0, Bit var1) {
        client.isDynamicRegion = var0;
        int var2;
        int var3;
        int var5;
        int var6;
        int var7;
        int var8;
        if (!client.isDynamicRegion) {
            var2 = var1.readLEShortA();
            var3 = var1.readShort128();
            int var4 = var1.readUnsignedShort();
            IndexStoreActionHandler.xteaKeys = new int[var4][4];

            for (var5 = 0; var5 < var4; ++var5) {
                for (var6 = 0; var6 < 4; ++var6) {
                    IndexStoreActionHandler.xteaKeys[var5][var6] = var1.getInt();
                }
            }

            class208.mapRegions = new int[var4];
            class120.landMapFileIds = new int[var4];
            MapCacheArchiveNames.landRegionFileIds = new int[var4];
            Isaac.field2458 = new byte[var4][];
            CacheFile.field1487 = new byte[var4][];
            boolean var16 = false;
            if ((var3 / 8 == 48 || var3 / 8 == 49) && var2 / 8 == 48) {
                var16 = true;
            }

            if (var3 / 8 == 48 && var2 / 8 == 148) {
                var16 = true;
            }

            var4 = 0;

            for (var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
                for (var7 = (var2 - 6) / 8; var7 <= (var2 + 6) / 8; ++var7) {
                    var8 = var7 + (var6 << 8);
                    if (!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
                        class208.mapRegions[var4] = var8;
                        class120.landMapFileIds[var4] = class239.maps.method1510("m" + var6 + "_" + var7);
                        MapCacheArchiveNames.landRegionFileIds[var4] = class239.maps.method1510("l" + var6 + "_" + var7);
                        ++var4;
                    }
                }
            }

            Signlink.method4454(var3, var2, true);
        } else {
            var2 = var1.readShort128();
            var3 = var1.readLEShortA();
            boolean var15 = var1.readUnsignedByte() == 1;
            var5 = var1.readUnsignedShort();
            var1.method2837();

            int var9;
            for (var6 = 0; var6 < 4; ++var6) {
                for (var7 = 0; var7 < 13; ++var7) {
                    for (var8 = 0; var8 < 13; ++var8) {
                        var9 = var1.getBits(1);
                        if (var9 == 1) {
                            client.instanceTemplateChunks[var6][var7][var8] = var1.getBits(26);
                        } else {
                            client.instanceTemplateChunks[var6][var7][var8] = -1;
                        }
                    }
                }
            }

            var1.method2834();
            IndexStoreActionHandler.xteaKeys = new int[var5][4];

            for (var6 = 0; var6 < var5; ++var6) {
                for (var7 = 0; var7 < 4; ++var7) {
                    IndexStoreActionHandler.xteaKeys[var6][var7] = var1.getInt();
                }
            }

            class208.mapRegions = new int[var5];
            class120.landMapFileIds = new int[var5];
            MapCacheArchiveNames.landRegionFileIds = new int[var5];
            Isaac.field2458 = new byte[var5][];
            CacheFile.field1487 = new byte[var5][];
            var5 = 0;

            for (var6 = 0; var6 < 4; ++var6) {
                for (var7 = 0; var7 < 13; ++var7) {
                    for (var8 = 0; var8 < 13; ++var8) {
                        var9 = client.instanceTemplateChunks[var6][var7][var8];
                        if (var9 != -1) {
                            int var10 = var9 >> 14 & 1023;
                            int var11 = var9 >> 3 & 2047;
                            int var12 = (var10 / 8 << 8) + var11 / 8;

                            int var13;
                            for (var13 = 0; var13 < var5; ++var13) {
                                if (class208.mapRegions[var13] == var12) {
                                    var12 = -1;
                                    break;
                                }
                            }

                            if (var12 != -1) {
                                class208.mapRegions[var5] = var12;
                                var13 = var12 >> 8 & 255;
                                int var14 = var12 & 255;
                                class120.landMapFileIds[var5] = class239.maps.method1510("m" + var13 + "_" + var14);
                                MapCacheArchiveNames.landRegionFileIds[var5] = class239.maps.method1510("l" + var13 + "_" + var14);
                                ++var5;
                            }
                        }
                    }
                }
            }

            Signlink.method4454(var3, var2, !var15);
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1585143280"
    )
    static boolean method1889() {
        try {
            if (World.listFetcher == null) {
                World.listFetcher = class208.urlRequester.method4079(new URL(FileOnDisk.field1496));
            } else if (World.listFetcher.method5569()) {
                byte[] var0 = World.listFetcher.method5564();
                Packet var1 = new Packet(var0);
                var1.getInt();
                World.worldCount = var1.readUnsignedShort();
                World.worldList = new World[World.worldCount];

                World var3;
                for (int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
                    var3 = World.worldList[var2] = new World();
                    var3.id = var1.readUnsignedShort();
                    var3.mask = var1.getInt();
                    var3.address = var1.readString();
                    var3.activity = var1.readString();
                    var3.location = var1.readUnsignedByte();
                    var3.playerCount = var1.method6123();
                    var3.playerCountChanged(-1);
                }

                class13.method190(World.worldList, 0, World.worldList.length - 1, World.field1016, World.field1018);
                World.listFetcher = null;
                return true;
            }
        } catch (Exception var4) {
            var4.printStackTrace();
            World.listFetcher = null;
        }

        return false;
    }
}
