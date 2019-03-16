package net.runelite.runescape;

import net.runelite.mapping.*;
import net.runelite.rs.api.RSIndexData;

import java.util.zip.CRC32;

@ObfuscatedName("ih")
@Implements("Js5")
public class Js5 extends Js5Index implements RSIndexData {
    @ObfuscatedName("ax")
    @Export("crc32")
    static CRC32 crc32;
    @ObfuscatedName("af")
    boolean field3252;
    @ObfuscatedName("ae")
    @ObfuscatedGetter(
            intValue = 351471151
    )
    @Export("indexReferenceVersion")
    int indexReferenceVersion;
    @ObfuscatedName("aw")
    @ObfuscatedGetter(
            intValue = -1453795143
    )
    @Export("crcValue")
    int crcValue;
    @ObfuscatedName("o")
    volatile boolean field3251;
    @ObfuscatedName("an")
    @Export("loadedGroups")
    volatile boolean[] loadedGroups;
    @ObfuscatedName("y")
    @ObfuscatedSignature(
            signature = "Lfp;"
    )
    @Export("masterIndex")
    IndexFile masterIndex;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "Lfp;"
    )
    @Export("index")
    IndexFile index;
    @ObfuscatedName("ac")
    @ObfuscatedGetter(
            intValue = 1885426687
    )
    int field3257;
    @ObfuscatedName("u")
    @ObfuscatedGetter(
            intValue = 456113227
    )
    @Export("id")
    int id;

    static {
        crc32 = new CRC32();
    }

    @ObfuscatedSignature(
            signature = "(Lfp;Lfp;IZZZ)V"
    )
    public Js5(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
        super(var4, var5);
        this.field3251 = false;
        this.field3252 = false;
        this.field3257 = -1;
        this.index = var1;
        this.masterIndex = var2;
        this.id = var3;
        this.field3252 = var6;
        int var8 = this.id;
        if (class316.NetCache_reference != null) {
            class316.NetCache_reference.offset = var8 * 8 + 5;
            int var9 = class316.NetCache_reference.getInt();
            int var10 = class316.NetCache_reference.getInt();
            this.method2658(var9, var10);
        } else {
            class48.method777((Js5) null, 255, 255, 0, (byte) 0, true);
            class258.NetCache_indexCaches[var8] = this;
        }

    }

    @ObfuscatedName("cq")
    @ObfuscatedSignature(
            signature = "(I[BZZB)V",
            garbageValue = "66"
    )
    void method2643(int var1, byte[] var2, boolean var3, boolean var4) {
        if (var3) {
            if (this.field3251) {
                throw new RuntimeException();
            }

            if (this.masterIndex != null) {
                FriendManager.method120(this.id, var2, this.masterIndex);
            }

            this.method1531(var2);
            this.method2642();
        } else {
            var2[var2.length - 2] = (byte) (super.groupVersions[var1] >> 8);
            var2[var2.length - 1] = (byte) super.groupVersions[var1];
            if (this.index != null) {
                FriendManager.method120(var1, var2, this.index);
                this.loadedGroups[var1] = true;
            }

            if (var4) {
                super.groups[var1] = class147.method2546(var2, false);
            }
        }

    }

    @ObfuscatedName("cw")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "408946940"
    )
    public int method2649() {
        int var1 = 0;
        int var2 = 0;

        int var3;
        for (var3 = 0; var3 < super.groups.length; ++var3) {
            if (super.groupFileCount[var3] > 0) {
                var1 += 100;
                var2 += this.vmethod2648(var3);
            }
        }

        if (var1 == 0) {
            return 100;
        } else {
            var3 = var2 * 100 / var1;
            return var3;
        }
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-894037768"
    )
    void vmethod2652(int var1) {
        int var2 = this.id;
        long var3 = (long) ((var2 << 16) + var1);
        FileRequest var5 = (FileRequest) class258.NetCache_pendingWrites.method380(var3);
        if (var5 != null) {
            class258.NetCache_pendingWritesQueue.method2510(var5);
        }

    }

    @ObfuscatedName("cv")
    @ObfuscatedSignature(
            signature = "(II)Z",
            garbageValue = "-1464037685"
    )
    public boolean method2677(int var1) {
        return this.method1524(var1) != null;
    }

    @ObfuscatedName("cj")
    @ObfuscatedSignature(
            signature = "(Lfp;I[BZB)V",
            garbageValue = "-13"
    )
    void method2644(IndexFile var1, int var2, byte[] var3, boolean var4) {
        int var5;
        if (var1 == this.masterIndex) {
            if (this.field3251) {
                throw new RuntimeException();
            } else if (var3 == null) {
                class48.method777(this, 255, this.id, this.crcValue, (byte) 0, true);
            } else {
                crc32.reset();
                crc32.update(var3, 0, var3.length);
                var5 = (int) crc32.getValue();
                if (var5 != this.crcValue) {
                    class48.method777(this, 255, this.id, this.crcValue, (byte) 0, true);
                } else {
                    Packet var9 = new Packet(class77.method1151(var3));
                    int var7 = var9.readUnsignedByte();
                    if (var7 != 5 && var7 != 6) {
                        throw new RuntimeException(var7 + "," + this.id + "," + var2);
                    } else {
                        int var8 = 0;
                        if (var7 >= 6) {
                            var8 = var9.getInt();
                        }

                        if (var8 != this.indexReferenceVersion) {
                            class48.method777(this, 255, this.id, this.crcValue, (byte) 0, true);
                        } else {
                            this.method1531(var3);
                            this.method2642();
                        }
                    }
                }
            }
        } else {
            if (!var4 && var2 == this.field3257) {
                this.field3251 = true;
            }

            if (var3 != null && var3.length > 2) {
                crc32.reset();
                crc32.update(var3, 0, var3.length - 2);
                var5 = (int) crc32.getValue();
                int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
                if (var5 == super.groupCrcs[var2] && var6 == super.groupVersions[var2]) {
                    this.loadedGroups[var2] = true;
                    if (var4) {
                        super.groups[var2] = class147.method2546(var3, false);
                    }

                } else {
                    this.loadedGroups[var2] = false;
                    if (this.field3252 || var4) {
                        class48.method777(this, this.id, var2, super.groupCrcs[var2], (byte) 2, var4);
                    }

                }
            } else {
                this.loadedGroups[var2] = false;
                if (this.field3252 || var4) {
                    class48.method777(this, this.id, var2, super.groupCrcs[var2], (byte) 2, var4);
                }

            }
        }
    }

    public int getIndex() {
        return this.id;
    }

    @ObfuscatedName("ct")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "12"
    )
    public int method2639() {
        if (this.field3251) {
            return 100;
        } else if (super.groups != null) {
            return 99;
        } else {
            int var1 = JagException.method855(255, this.id);
            if (var1 >= 100) {
                var1 = 99;
            }

            return var1;
        }
    }

    @ObfuscatedName("ci")
    @ObfuscatedSignature(
            signature = "(II)Z",
            garbageValue = "-506355403"
    )
    public boolean method2647(int var1) {
        return this.loadedGroups[var1];
    }

    @ObfuscatedName("ch")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "1719349983"
    )
    public boolean method2638() {
        return this.field3251;
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "1670694109"
    )
    int vmethod2648(int var1) {
        return super.groups[var1] != null ? 100 : (this.loadedGroups[var1] ? 100 : JagException.method855(this.id, var1));
    }

    @ObfuscatedName("cu")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1874473815"
    )
    void method2642() {
        this.loadedGroups = new boolean[super.groups.length];

        int var1;
        for (var1 = 0; var1 < this.loadedGroups.length; ++var1) {
            this.loadedGroups[var1] = false;
        }

        if (this.index == null) {
            this.field3251 = true;
        } else {
            this.field3257 = -1;

            for (var1 = 0; var1 < this.loadedGroups.length; ++var1) {
                if (super.groupFileCount[var1] > 0) {
                    IndexFile var2 = this.index;
                    FileSystem var4 = new FileSystem();
                    var4.type = 1;
                    var4.hash = (long) var1;
                    var4.index = var2;
                    var4.data = this;
                    Deque var5 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
                    synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
                        IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.method4351(var4);
                    }

                    Object var10 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
                    synchronized (IndexStoreActionHandler.IndexStoreActionHandler_lock) {
                        if (IndexStoreActionHandler.field3243 == 0) {
                            IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
                            IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
                            IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
                            IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
                        }

                        IndexStoreActionHandler.field3243 = 600;
                    }

                    this.field3257 = var1;
                }
            }

            if (this.field3257 == -1) {
                this.field3251 = true;
            }

        }
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "1000414175"
    )
    void vmethod2671(int var1) {
        if (this.index != null && this.loadedGroups != null && this.loadedGroups[var1]) {
            IndexFile var2 = this.index;
            byte[] var4 = null;
            Deque var5 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
                for (FileSystem var6 = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.method4373(); var6 != null; var6 = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.method4358()) {
                    if ((long) var1 == var6.hash && var2 == var6.index && var6.type == 0) {
                        var4 = var6.field3212;
                        break;
                    }
                }
            }

            if (var4 != null) {
                this.method2644(var2, var1, var4, true);
            } else {
                byte[] var9 = var2.method5680(var1);
                this.method2644(var2, var1, var9, true);
            }
        } else {
            class48.method777(this, this.id, var1, super.groupCrcs[var1], (byte) 2, true);
        }

    }

    @ObfuscatedName("cs")
    @ObfuscatedSignature(
            signature = "(IIS)V",
            garbageValue = "-23835"
    )
    void method2658(int var1, int var2) {
        this.crcValue = var1;
        this.indexReferenceVersion = var2;
        if (this.masterIndex != null) {
            int var3 = this.id;
            IndexFile var4 = this.masterIndex;
            byte[] var6 = null;
            Deque var7 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
                for (FileSystem var8 = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.method4373(); var8 != null; var8 = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.method4358()) {
                    if ((long) var3 == var8.hash && var4 == var8.index && var8.type == 0) {
                        var6 = var8.field3212;
                        break;
                    }
                }
            }

            if (var6 != null) {
                this.method2644(var4, var3, var6, true);
            } else {
                byte[] var11 = var4.method5680(var3);
                this.method2644(var4, var3, var11, true);
            }
        } else {
            class48.method777(this, 255, this.id, this.crcValue, (byte) 0, true);
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(II)Lia;",
            garbageValue = "-619599710"
    )
    public static VarClientType method2679(int var0) {
        VarClientType var1 = (VarClientType) VarClientType.field3335.method951((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = VarClientType.field3336.method1516(19, var0, 1789634852);
            var1 = new VarClientType();
            if (var2 != null) {
                var1.method5421(new Packet(var2));
            }

            VarClientType.field3335.method957(var1, (long) var0);
            return var1;
        }
    }
}
