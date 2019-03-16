package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("ip")
@Implements("IndexStoreActionHandler")
public class IndexStoreActionHandler implements Runnable {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgi;"
    )
    static Deque IndexStoreActionHandler_responseQueue;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 2074866923
    )
    public static int field3243;
    @ObfuscatedName("q")
    public static Object IndexStoreActionHandler_lock;
    @ObfuscatedName("gs")
    static int[][] xteaKeys;
    @ObfuscatedName("c")
    static Thread IndexStoreActionHandler_thread;
    @ObfuscatedName("d")
    static boolean field3246;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lgi;"
    )
    static Deque IndexStoreActionHandler_requestQueue;

    static {
        IndexStoreActionHandler_requestQueue = new Deque();
        IndexStoreActionHandler_responseQueue = new Deque();
        field3243 = 0;
        IndexStoreActionHandler_lock = new Object();
    }

    public void run() {
        try {
            while (true) {
                Deque var2 = IndexStoreActionHandler_requestQueue;
                FileSystem var1;
                synchronized (IndexStoreActionHandler_requestQueue) {
                    var1 = (FileSystem) IndexStoreActionHandler_requestQueue.method4373();
                }

                Object var14;
                if (var1 != null) {
                    if (var1.type == 0) {
                        var1.index.method5675((int) var1.hash, var1.field3212, var1.field3212.length);
                        var2 = IndexStoreActionHandler_requestQueue;
                        synchronized (IndexStoreActionHandler_requestQueue) {
                            var1.method6469();
                        }
                    } else if (var1.type == 1) {
                        var1.field3212 = var1.index.method5680((int) var1.hash);
                        var2 = IndexStoreActionHandler_requestQueue;
                        synchronized (IndexStoreActionHandler_requestQueue) {
                            IndexStoreActionHandler_responseQueue.method4351(var1);
                        }
                    }

                    var14 = IndexStoreActionHandler_lock;
                    synchronized (IndexStoreActionHandler_lock) {
                        if (field3243 <= 1) {
                            field3243 = 0;
                            IndexStoreActionHandler_lock.notifyAll();
                            return;
                        }

                        field3243 = 600;
                    }
                } else {
                    class182.method3129(100L);
                    var14 = IndexStoreActionHandler_lock;
                    synchronized (IndexStoreActionHandler_lock) {
                        if (field3243 <= 1) {
                            field3243 = 0;
                            IndexStoreActionHandler_lock.notifyAll();
                            return;
                        }

                        --field3243;
                    }
                }
            }
        } catch (Exception var13) {
            ProjectileAnimation.method5582((String) null, var13, 1652089565);
        }
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)Ljx;",
            garbageValue = "1359660159"
    )
    public static Spotanim method5748(int var0) {
        Spotanim var1 = (Spotanim) Spotanim.spotanims.method951((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = Spotanim.SpotAnimationDefinition_indexCache.method1516(13, var0, 1789634852);
            var1 = new Spotanim();
            var1.id = var0;
            if (var2 != null) {
                var1.method5305(new Packet(var2));
            }

            Spotanim.spotanims.method957(var1, (long) var0);
            return var1;
        }
    }

    @ObfuscatedName("jm")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "16711935"
    )
    static final void method5750() {
        for (int var0 = 0; var0 < class254.highResolutionPlayerCount; ++var0) {
            PlayerEntity var1 = client.players[class254.highResolutionPlayerIndexes[var0]];
            var1.method2891();
        }

        Iterator var2 = class202.messages.iterator();

        while (var2.hasNext()) {
            ChatLine var3 = (ChatLine) var2.next();
            var3.method5652();
        }

        if (TotalQuantityComparator.clanMemberManager != null) {
            TotalQuantityComparator.clanMemberManager.method4636();
        }

    }
}
