package net.runelite.runescape;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import net.runelite.api.overlay.OverlayIndex;
import net.runelite.mapping.*;
import net.runelite.rs.api.RSIndexData;
import net.runelite.rs.api.RSIndexDataBase;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@ObfuscatedName("iu")
@Implements("Js5Index")
public abstract class Js5Index implements RSIndexDataBase {
    @ObfuscatedName("f")
    @ObfuscatedGetter(
            intValue = -1374086747
    )
    static int field3223;
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "Lfo;"
    )
    @Export("gzip")
    static GZipDecompressor gzip;
    @ObfuscatedName("l")
    @Export("groupCrcs")
    int[] groupCrcs;
    @ObfuscatedName("v")
    @Export("releaseGroupBuffers")
    boolean releaseGroupBuffers;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -1646490865
    )
    @Export("groupCount")
    int groupCount;
    @ObfuscatedName("e")
    @Export("groupIds")
    int[] groupIds;
    @ObfuscatedName("w")
    @Export("groupFileCount")
    int[] groupFileCount;
    @ObfuscatedName("q")
    @Export("groupNames")
    int[] groupNames;
    @ObfuscatedName("x")
    @ObfuscatedGetter(
            intValue = -1466263935
    )
    @Export("crc")
    public int crc;
    @ObfuscatedName("m")
    @Export("groups")
    Object[] groups;
    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "[Lgw;"
    )
    @Export("groupFilesNameTable")
    NameHashTable[] groupFilesNameTable;
    @ObfuscatedName("b")
    int[] groupVersions;
    @ObfuscatedName("n")
    int[][] groupFileIds;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Lgw;"
    )
    @Export("groupNameTable")
    NameHashTable groupNameTable;
    public boolean overlayOutdated;
    @ObfuscatedName("i")
    @Export("groupFileNames")
    int[][] groupFileNames;
    @ObfuscatedName("d")
    @Export("files")
    Object[][] files;
    @ObfuscatedName("h")
    @Export("releaseFileBuffers")
    boolean releaseFileBuffers;

    static {
        gzip = new GZipDecompressor();
        field3223 = 0;
    }

    Js5Index(boolean var1, boolean var2) {
        this.releaseGroupBuffers = var1;
        this.releaseFileBuffers = var2;
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(II)[I",
            garbageValue = "-1155394537"
    )
    public int[] method1524(int var1) {
        return this.groupFileIds[var1];
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(II)[B",
            garbageValue = "-2072591117"
    )
    public byte[] method1522(int var1) {
        if (this.files.length == 1) {
            return this.method1521(0, var1);
        } else if (this.files[var1].length == 1) {
            return this.method1521(var1, 0);
        } else {
            throw new RuntimeException();
        }
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-894037768"
    )
    void vmethod2652(int var1) {
    }

    @ObfuscatedName("e")
    public byte[] method1516(int var1, int var2, int var3) {
        byte[] var4 = this.copy$getConfigData(var1, var2, var3);
        RSIndexData var5 = (RSIndexData) this;
        if (!OverlayIndex.hasOverlay(var5.getIndex(), var1)) {
            return var4;
        } else {
            Logger var6 = class166.clientInstance.getLogger();
            InputStream var7 = this.getClass().getResourceAsStream("/runelite/" + var5.getIndex() + "/" + var1);
            if (var7 == null) {
                var6.warn("Missing overlay data for {}/{}", Integer.valueOf(var5.getIndex()), Integer.valueOf(var1));
                return var4;
            } else {
                InputStream var8 = this.getClass().getResourceAsStream("/runelite/" + var5.getIndex() + "/" + var1 + ".hash");
                if (var4 == null) {
                    if (var8 != null) {
                        var6.warn("Hash file for non existing archive {}/{}", Integer.valueOf(var5.getIndex()), Integer.valueOf(var1));
                        return null;
                    } else {
                        var6.debug("Adding archive {}/{}", Integer.valueOf(var5.getIndex()), Integer.valueOf(var1));

                        try {
                            return ByteStreams.toByteArray(var7);
                        } catch (IOException var12) {
                            var6.warn("error loading archive replacement", var12);
                            return null;
                        }
                    }
                } else if (var8 == null) {
                    var6.warn("Missing hash file for {}/{}", Integer.valueOf(var5.getIndex()), Integer.valueOf(var1));
                    return var4;
                } else {
                    HashCode var9 = Hashing.sha256().hashBytes(var4);
                    String var10 = BaseEncoding.base16().encode(var9.asBytes());

                    try {
                        String var11 = CharStreams.toString(new InputStreamReader(var8));
                        if (var11.equals(var10)) {
                            var6.debug("Replacing archive {}/{}", Integer.valueOf(var5.getIndex()), Integer.valueOf(var1));
                            return ByteStreams.toByteArray(var7);
                        }

                        var6.warn("Mismatch in overlaid cache archive hash for {}/{}: {} != {}", new Object[]{Integer.valueOf(var5.getIndex()), Integer.valueOf(var1), var11, var10});
                        this.overlayOutdated = true;
                    } catch (IOException var13) {
                        var6.warn("error checking hash", var13);
                    }

                    return var4;
                }
            }
        }
    }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            signature = "(ILjava/lang/String;I)I",
            garbageValue = "-849196060"
    )
    public int method1532(int var1, String var2) {
        var2 = var2.toLowerCase();
        return this.groupFilesNameTable[var1].method568(ItemContainer.method1914(var2));
    }

    @ObfuscatedName("ae")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)Z",
            garbageValue = "-2107594785"
    )
    public boolean method1536(String var1) {
        var1 = var1.toLowerCase();
        int var2 = this.groupNameTable.method568(ItemContainer.method1914(var1));
        return this.method1517(var2);
    }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "2131555798"
    )
    public void method1527() {
        for (int var1 = 0; var1 < this.groups.length; ++var1) {
            this.groups[var1] = null;
        }

    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(II[II)[B",
            garbageValue = "-473032235"
    )
    public byte[] method1554(int var1, int var2, int[] var3) {
        if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
            if (this.files[var1][var2] == null) {
                boolean var4 = this.method1548(var1, var3);
                if (!var4) {
                    this.vmethod2671(var1);
                    var4 = this.method1548(var1, var3);
                    if (!var4) {
                        return null;
                    }
                }
            }

            byte[] var5 = Timer.method5403(this.files[var1][var2], false);
            if (this.releaseFileBuffers) {
                this.files[var1][var2] = null;
            }

            return var5;
        } else {
            return null;
        }
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(III)[B",
            garbageValue = "2050923780"
    )
    public byte[] method1521(int var1, int var2) {
        if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
            if (this.files[var1][var2] == null) {
                boolean var3 = this.method1548(var1, (int[]) null);
                if (!var3) {
                    this.vmethod2671(var1);
                    var3 = this.method1548(var1, (int[]) null);
                    if (!var3) {
                        return null;
                    }
                }
            }

            byte[] var4 = Timer.method5403(this.files[var1][var2], false);
            return var4;
        } else {
            return null;
        }
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "5"
    )
    public boolean method1589() {
        boolean var1 = true;

        for (int var2 = 0; var2 < this.groupIds.length; ++var2) {
            int var3 = this.groupIds[var2];
            if (this.groups[var3] == null) {
                this.vmethod2671(var3);
                if (this.groups[var3] == null) {
                    var1 = false;
                }
            }
        }

        return var1;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(IB)Z",
            garbageValue = "-23"
    )
    public boolean method1517(int var1) {
        if (this.groups[var1] != null) {
            return true;
        } else {
            this.vmethod2671(var1);
            return this.groups[var1] != null;
        }
    }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
            garbageValue = "331727990"
    )
    public boolean method1538(String var1, String var2) {
        var1 = var1.toLowerCase();
        var2 = var2.toLowerCase();
        int var3 = this.groupNameTable.method568(ItemContainer.method1914(var1));
        int var4 = this.groupFilesNameTable[var3].method568(ItemContainer.method1914(var2));
        return this.method1515(var3, var4);
    }

    @ObfuscatedName("o")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)I",
            garbageValue = "1011742774"
    )
    public int method1510(String var1) {
        var1 = var1.toLowerCase();
        return this.groupNameTable.method568(ItemContainer.method1914(var1));
    }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "1064669026"
    )
    public int method1574(int var1) {
        return this.files[var1].length;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IIB)Z",
            garbageValue = "-99"
    )
    public boolean method1515(int var1, int var2) {
        if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
            if (this.files[var1][var2] != null) {
                return true;
            } else if (this.groups[var1] != null) {
                return true;
            } else {
                this.vmethod2671(var1);
                return this.groups[var1] != null;
            }
        } else {
            return false;
        }
    }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "8"
    )
    public int method1526() {
        return this.files.length;
    }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;Ljava/lang/String;S)Z",
            garbageValue = "-6199"
    )
    public boolean method1533(String var1, String var2) {
        var1 = var1.toLowerCase();
        var2 = var2.toLowerCase();
        int var3 = this.groupNameTable.method568(ItemContainer.method1914(var1));
        if (var3 < 0) {
            return false;
        } else {
            int var4 = this.groupFilesNameTable[var3].method568(ItemContainer.method1914(var2));
            return var4 >= 0;
        }
    }

    public byte[] copy$getConfigData(int var1, int var2, int var3) {
        return this.method1554(var1, var2, (int[]) null);
    }

    public boolean isOverlayOutdated() {
        return this.overlayOutdated;
    }

    public byte[] getConfigData(int var1, int var2) {
        return this.method1516(var1, var2, 1789634852);
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(II)Z",
            garbageValue = "-1629304314"
    )
    public boolean method1514(int var1) {
        if (this.files.length == 1) {
            return this.method1515(0, var1);
        } else if (this.files[var1].length == 1) {
            return this.method1515(var1, 0);
        } else {
            throw new RuntimeException();
        }
    }

    @ObfuscatedName("y")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1354114415"
    )
    public void method1529() {
        for (int var1 = 0; var1 < this.files.length; ++var1) {
            if (this.files[var1] != null) {
                for (int var2 = 0; var2 < this.files[var1].length; ++var2) {
                    this.files[var1][var2] = null;
                }
            }
        }

    }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
            garbageValue = "821665515"
    )
    public byte[] method1534(String var1, String var2) {
        var1 = var1.toLowerCase();
        var2 = var2.toLowerCase();
        int var3 = this.groupNameTable.method568(ItemContainer.method1914(var1));
        int var4 = this.groupFilesNameTable[var3].method568(ItemContainer.method1914(var2));
        return this.method1516(var3, var4, 1789634852);
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "1670694109"
    )
    int vmethod2648(int var1) {
        return this.groups[var1] != null ? 100 : 0;
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(IS)[B",
            garbageValue = "-625"
    )
    public byte[] method1520(int var1) {
        if (this.files.length == 1) {
            return this.method1516(0, var1, 1789634852);
        } else if (this.files[var1].length == 1) {
            return this.method1516(var1, 0, 1789634852);
        } else {
            throw new RuntimeException();
        }
    }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-2078847420"
    )
    public void method1528(int var1) {
        for (int var2 = 0; var2 < this.files[var1].length; ++var2) {
            this.files[var1][var2] = null;
        }

    }

    @ObfuscatedName("az")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)I",
            garbageValue = "29775380"
    )
    public int method1530(String var1) {
        var1 = var1.toLowerCase();
        int var2 = this.groupNameTable.method568(ItemContainer.method1914(var1));
        return this.vmethod2648(var2);
    }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)V",
            garbageValue = "-883235884"
    )
    public void method1513(String var1) {
        var1 = var1.toLowerCase();
        int var2 = this.groupNameTable.method568(ItemContainer.method1914(var1));
        if (var2 >= 0) {
            this.vmethod2652(var2);
        }
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "1000414175"
    )
    void vmethod2671(int var1) {
    }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            signature = "(I[IB)Z",
            garbageValue = "0"
    )
    boolean method1548(int var1, int[] var2) {
        if (this.groups[var1] == null) {
            return false;
        } else {
            int var3 = this.groupFileCount[var1];
            int[] var4 = this.groupFileIds[var1];
            Object[] var5 = this.files[var1];
            boolean var6 = true;

            for (int var7 = 0; var7 < var3; ++var7) {
                if (var5[var4[var7]] == null) {
                    var6 = false;
                    break;
                }
            }

            if (var6) {
                return true;
            } else {
                byte[] var18;
                if (var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
                    var18 = Timer.method5403(this.groups[var1], false);
                } else {
                    var18 = Timer.method5403(this.groups[var1], true);
                    Packet var8 = new Packet(var18);
                    var8.method6100(var2, 5, var8.payload.length);
                }

                byte[] var20 = class77.method1151(var18);
                if (this.releaseGroupBuffers) {
                    this.groups[var1] = null;
                }

                if (var3 > 1) {
                    int var9 = var20.length;
                    --var9;
                    int var10 = var20[var9] & 255;
                    var9 -= var10 * var3 * 4;
                    Packet var11 = new Packet(var20);
                    int[] var12 = new int[var3];
                    var11.offset = var9;

                    int var14;
                    int var15;
                    for (int var13 = 0; var13 < var10; ++var13) {
                        var14 = 0;

                        for (var15 = 0; var15 < var3; ++var15) {
                            var14 += var11.getInt();
                            var12[var15] += var14;
                        }
                    }

                    byte[][] var19 = new byte[var3][];

                    for (var14 = 0; var14 < var3; ++var14) {
                        var19[var14] = new byte[var12[var14]];
                        var12[var14] = 0;
                    }

                    var11.offset = var9;
                    var14 = 0;

                    for (var15 = 0; var15 < var10; ++var15) {
                        int var16 = 0;

                        for (int var17 = 0; var17 < var3; ++var17) {
                            var16 += var11.getInt();
                            System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                            var12[var17] += var16;
                            var14 += var16;
                        }
                    }

                    for (var15 = 0; var15 < var3; ++var15) {
                        if (!this.releaseFileBuffers) {
                            var5[var4[var15]] = class147.method2546(var19[var15], false);
                        } else {
                            var5[var4[var15]] = var19[var15];
                        }
                    }
                } else if (!this.releaseFileBuffers) {
                    var5[var4[0]] = class147.method2546(var20, false);
                } else {
                    var5[var4[0]] = var20;
                }

                return true;
            }
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "([BB)V",
            garbageValue = "-119"
    )
    void method1531(byte[] var1) {
        int var3 = var1.length;
        int var2 = NPCEntity.method2151(var1, 0, var3);
        this.crc = var2;
        Packet var4 = new Packet(class77.method1151(var1));
        int var5 = var4.readUnsignedByte();
        if (var5 >= 5 && var5 <= 7) {
            if (var5 >= 6) {
                var4.getInt();
            }

            int var6 = var4.readUnsignedByte();
            if (var5 >= 7) {
                this.groupCount = var4.method6094();
            } else {
                this.groupCount = var4.readUnsignedShort();
            }

            int var7 = 0;
            int var8 = -1;
            this.groupIds = new int[this.groupCount];
            int var9;
            if (var5 >= 7) {
                for (var9 = 0; var9 < this.groupCount; ++var9) {
                    this.groupIds[var9] = var7 += var4.method6094();
                    if (this.groupIds[var9] > var8) {
                        var8 = this.groupIds[var9];
                    }
                }
            } else {
                for (var9 = 0; var9 < this.groupCount; ++var9) {
                    this.groupIds[var9] = var7 += var4.readUnsignedShort();
                    if (this.groupIds[var9] > var8) {
                        var8 = this.groupIds[var9];
                    }
                }
            }

            this.groupCrcs = new int[var8 + 1];
            this.groupVersions = new int[var8 + 1];
            this.groupFileCount = new int[var8 + 1];
            this.groupFileIds = new int[var8 + 1][];
            this.groups = new Object[var8 + 1];
            this.files = new Object[var8 + 1][];
            if (var6 != 0) {
                this.groupNames = new int[var8 + 1];

                for (var9 = 0; var9 < this.groupCount; ++var9) {
                    this.groupNames[this.groupIds[var9]] = var4.getInt();
                }

                this.groupNameTable = new NameHashTable(this.groupNames);
            }

            for (var9 = 0; var9 < this.groupCount; ++var9) {
                this.groupCrcs[this.groupIds[var9]] = var4.getInt();
            }

            for (var9 = 0; var9 < this.groupCount; ++var9) {
                this.groupVersions[this.groupIds[var9]] = var4.getInt();
            }

            for (var9 = 0; var9 < this.groupCount; ++var9) {
                this.groupFileCount[this.groupIds[var9]] = var4.readUnsignedShort();
            }

            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            if (var5 >= 7) {
                for (var9 = 0; var9 < this.groupCount; ++var9) {
                    var10 = this.groupIds[var9];
                    var11 = this.groupFileCount[var10];
                    var7 = 0;
                    var12 = -1;
                    this.groupFileIds[var10] = new int[var11];

                    for (var13 = 0; var13 < var11; ++var13) {
                        var14 = this.groupFileIds[var10][var13] = var7 += var4.method6094();
                        if (var14 > var12) {
                            var12 = var14;
                        }
                    }

                    this.files[var10] = new Object[var12 + 1];
                }
            } else {
                for (var9 = 0; var9 < this.groupCount; ++var9) {
                    var10 = this.groupIds[var9];
                    var11 = this.groupFileCount[var10];
                    var7 = 0;
                    var12 = -1;
                    this.groupFileIds[var10] = new int[var11];

                    for (var13 = 0; var13 < var11; ++var13) {
                        var14 = this.groupFileIds[var10][var13] = var7 += var4.readUnsignedShort();
                        if (var14 > var12) {
                            var12 = var14;
                        }
                    }

                    this.files[var10] = new Object[var12 + 1];
                }
            }

            if (var6 != 0) {
                this.groupFileNames = new int[var8 + 1][];
                this.groupFilesNameTable = new NameHashTable[var8 + 1];

                for (var9 = 0; var9 < this.groupCount; ++var9) {
                    var10 = this.groupIds[var9];
                    var11 = this.groupFileCount[var10];
                    this.groupFileNames[var10] = new int[this.files[var10].length];

                    for (var12 = 0; var12 < var11; ++var12) {
                        this.groupFileNames[var10][this.groupFileIds[var10][var12]] = var4.getInt();
                    }

                    this.groupFilesNameTable[var10] = new NameHashTable(this.groupFileNames[var10]);
                }
            }

        } else {
            throw new RuntimeException("");
        }
    }
}
