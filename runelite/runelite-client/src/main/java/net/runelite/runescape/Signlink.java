package net.runelite.runescape;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

@ObfuscatedName("ff")
@Implements("Signlink")
public class Signlink implements Runnable {
    @ObfuscatedName("r")
    @Export("javaVersion")
    public static String javaVersion;
    @ObfuscatedName("g")
    @Export("javaVendor")
    public static String javaVendor;
    @ObfuscatedName("l")
    boolean closed;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Let;"
    )
    Task currentTask;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Let;"
    )
    @Export("cachedTask")
    Task cachedTask;
    @ObfuscatedName("c")
    @Export("sysEventQueue")
    Thread sysEventQueue;

    public Signlink() {
        this.currentTask = null;
        this.cachedTask = null;
        this.closed = false;
        javaVendor = "Unknown";
        javaVersion = "1.6";

        try {
            javaVendor = System.getProperty("java.vendor");
            javaVersion = System.getProperty("java.version");
        } catch (Exception var2) {
            ;
        }

        this.closed = false;
        this.sysEventQueue = new Thread(this);
        this.sysEventQueue.setPriority(10);
        this.sysEventQueue.setDaemon(true);
        this.sysEventQueue.start();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IIILjava/lang/Object;I)Let;",
            garbageValue = "1997676403"
    )
    final Task method4440(int var1, int var2, int var3, Object var4) {
        Task var5 = new Task();
        var5.type = var1;
        var5.intArgument = var2;
        var5.objectArgument = var4;
        synchronized (this) {
            if (this.cachedTask != null) {
                this.cachedTask.task = var5;
                this.cachedTask = var5;
            } else {
                this.cachedTask = this.currentTask = var5;
            }

            this.notify();
            return var5;
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;II)Let;",
            garbageValue = "1279574555"
    )
    public final Task method4438(String var1, int var2) {
        return this.method4440(1, var2, 0, var1);
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/Runnable;IB)Let;",
            garbageValue = "-104"
    )
    public final Task method4451(Runnable var1, int var2) {
        return this.method4440(2, var2, 0, var1);
    }

    public final void run() {
        while (true) {
            Task var1;
            synchronized (this) {
                while (true) {
                    if (this.closed) {
                        return;
                    }

                    if (this.currentTask != null) {
                        var1 = this.currentTask;
                        this.currentTask = this.currentTask.task;
                        if (this.currentTask == null) {
                            this.cachedTask = null;
                        }
                        break;
                    }

                    try {
                        this.wait();
                    } catch (InterruptedException var8) {
                        ;
                    }
                }
            }

            try {
                int var5 = var1.type;
                if (var5 == 1) {
                    var1.value = new Socket(InetAddress.getByName((String) var1.objectArgument), var1.intArgument);
                } else if (var5 == 2) {
                    Thread var3 = new Thread((Runnable) var1.objectArgument);
                    var3.setDaemon(true);
                    var3.start();
                    var3.setPriority(var1.intArgument);
                    var1.value = var3;
                } else if (var5 == 4) {
                    var1.value = new DataInputStream(((URL) var1.objectArgument).openStream());
                }

                var1.status = 1;
            } catch (ThreadDeath var6) {
                throw var6;
            } catch (Throwable var7) {
                var1.status = 2;
            }
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-2140513690"
    )
    public final void method4441() {
        synchronized (this) {
            this.closed = true;
            this.notifyAll();
        }

        try {
            this.sysEventQueue.join();
        } catch (InterruptedException var3) {
            ;
        }

    }

    @ObfuscatedName("gy")
    @ObfuscatedSignature(
            signature = "(IIZB)V",
            garbageValue = "-124"
    )
    static final void method4454(int var0, int var1, boolean var2) {
        if (!var2 || var0 != VertexNormal.field1727 || IndexFile.field2075 != var1) {
            VertexNormal.field1727 = var0;
            IndexFile.field2075 = var1;
            class310.method5922(25);
            MouseRecorder.method2747("Loading - please wait.", true);
            int var3 = class158.baseX;
            int var4 = class107.baseY;
            class158.baseX = (var0 - 6) * 8;
            class107.baseY = (var1 - 6) * 8;
            int var5 = class158.baseX - var3;
            int var6 = class107.baseY - var4;
            var3 = class158.baseX;
            var4 = class107.baseY;

            int var7;
            int var9;
            for (var7 = 0; var7 < 32768; ++var7) {
                NPCEntity var8 = client.npcs[var7];
                if (var8 != null) {
                    for (var9 = 0; var9 < 10; ++var9) {
                        var8.pathX[var9] -= var5;
                        var8.pathY[var9] -= var6;
                    }

                    var8.x -= var5 * 128;
                    var8.y -= var6 * 128;
                }
            }

            for (var7 = 0; var7 < 2048; ++var7) {
                PlayerEntity var21 = client.players[var7];
                if (var21 != null) {
                    for (var9 = 0; var9 < 10; ++var9) {
                        var21.pathX[var9] -= var5;
                        var21.pathY[var9] -= var6;
                    }

                    var21.x -= var5 * 128;
                    var21.y -= var6 * 128;
                }
            }

            byte var20 = 0;
            byte var18 = 104;
            byte var22 = 1;
            if (var5 < 0) {
                var20 = 103;
                var18 = -1;
                var22 = -1;
            }

            byte var10 = 0;
            byte var11 = 104;
            byte var12 = 1;
            if (var6 < 0) {
                var10 = 103;
                var11 = -1;
                var12 = -1;
            }

            int var14;
            for (int var13 = var20; var13 != var18; var13 += var22) {
                for (var14 = var10; var14 != var11; var14 += var12) {
                    int var15 = var13 + var5;
                    int var16 = var14 + var6;

                    for (int var17 = 0; var17 < 4; ++var17) {
                        if (var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                            client.groundItemDeque[var17][var13][var14] = client.groundItemDeque[var17][var15][var16];
                        } else {
                            client.groundItemDeque[var17][var13][var14] = null;
                        }
                    }
                }
            }

            for (PendingSpawn var19 = (PendingSpawn) client.pendingSpawns.method4373(); var19 != null; var19 = (PendingSpawn) client.pendingSpawns.method4358()) {
                var19.x -= var5;
                var19.y -= var6;
                if (var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
                    var19.method6469();
                }
            }

            if (client.destinationX != 0) {
                client.destinationX -= var5;
                client.destinationY -= var6;
            }

            client.queuedSoundEffectCount = 0;
            client.field889 = false;
            class166.cameraX -= var5 << 7;
            class98.cameraY -= var6 << 7;
            class192.field68 -= var5 << 7;
            class192.field70 -= var6 << 7;
            client.field661 = -1;
            client.spotAnimationDeque.method4350();
            client.projectiles.method4350();

            for (var14 = 0; var14 < 4; ++var14) {
                client.collisionMaps[var14].method196();
            }

        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Liu;III)Lli;",
            garbageValue = "-1799882533"
    )
    static IndexedSprite method4455(Js5Index var0, int var1, int var2) {
        byte[] var4 = var0.method1516(var1, var2, 1789634852);
        boolean var3;
        if (var4 == null) {
            var3 = false;
        } else {
            SceneTilePaint.method667(var4);
            var3 = true;
        }

        return !var3 ? null : Overlay.method405();
    }
}
