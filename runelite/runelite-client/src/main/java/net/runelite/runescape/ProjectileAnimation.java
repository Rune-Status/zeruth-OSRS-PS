package net.runelite.runescape;

import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSProjectile;
import net.runelite.rs.api.RSRunException;

@ObfuscatedName("cg")
@Implements("ProjectileAnimation")
public final class ProjectileAnimation extends Entity implements RSProjectile {
    @ObfuscatedName("f")
    double scalar;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -248138595
    )
    int endHeight;
    @ObfuscatedName("v")
    double velocityX;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 1695269347
    )
    int floor;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1742790625
    )
    int x1;
    @ObfuscatedName("k")
    @ObfuscatedGetter(
            intValue = 420233825
    )
    int rotationX;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = -1384488295
    )
    int endCycle;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -1508726873
    )
    int y1;
    @ObfuscatedName("x")
    double z;
    @ObfuscatedName("m")
    boolean isMoving;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = 2054764497
    )
    int interacting;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -1441123443
    )
    int startMovementCycle;
    @ObfuscatedName("a")
    double velocityZ;
    @ObfuscatedName("z")
    @ObfuscatedGetter(
            intValue = 789099579
    )
    int rotationY;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -962051755
    )
    int slope;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 275353017
    )
    int height;
    @ObfuscatedName("t")
    double heightOffset;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 1453517771
    )
    int startHeight;
    @ObfuscatedName("y")
    @ObfuscatedGetter(
            intValue = 320828657
    )
    int int7;
    @ObfuscatedName("d")
    double x;
    @ObfuscatedName("j")
    double y;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "Ljg;"
    )
    Sequence animationSequence;
    @ObfuscatedName("h")
    double velocityY;
    @ObfuscatedName("u")
    @ObfuscatedGetter(
            intValue = 355105801
    )
    int int6;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 334008271
    )
    int id;

    ProjectileAnimation(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
        this.isMoving = false;
        this.int7 = 0;
        this.int6 = 0;
        this.id = var1;
        this.floor = var2;
        this.x1 = var3;
        this.y1 = var4;
        this.height = var5;
        this.startMovementCycle = var6;
        this.endCycle = var7;
        this.slope = var8;
        this.startHeight = var9;
        this.interacting = var10;
        this.endHeight = var11;
        this.isMoving = false;
        int var12 = IndexStoreActionHandler.method5748(this.id).field3348;
        if (var12 != -1) {
            this.animationSequence = MapCacheArchiveNames.method2149(var12);
        } else {
            this.animationSequence = null;
        }

    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1214727271"
    )
    final void method5589(int var1) {
        this.isMoving = true;
        this.x += (double) var1 * this.velocityX;
        this.y += this.velocityY * (double) var1;
        this.z += this.velocityZ * (double) var1 + (double) var1 * 0.5D * this.heightOffset * (double) var1;
        this.velocityZ += this.heightOffset * (double) var1;
        this.rotationX = (int) (Math.atan2(this.velocityX, this.velocityY) * 325.949D) + 1024 & 2047;
        this.rotationY = (int) (Math.atan2(this.velocityZ, this.scalar) * 325.949D) & 2047;
        if (this.animationSequence != null) {
            this.int6 += var1;

            while (true) {
                do {
                    do {
                        if (this.int6 <= this.animationSequence.frameLengths[this.int7]) {
                            return;
                        }

                        this.int6 -= this.animationSequence.frameLengths[this.int7];
                        ++this.int7;
                    } while (this.int7 < this.animationSequence.frameIDs.length);

                    this.int7 -= this.animationSequence.frameStep;
                } while (this.int7 >= 0 && this.int7 < this.animationSequence.frameIDs.length);

                this.int7 = 0;
            }
        }
    }

    public int getId() {
        return this.id;
    }

    public void projectileMoved(int var1, int var2, int var3, int var4) {
        int var5 = this.getId();
        switch (var5) {
            case 280:
            case 315:
            case 319:
            case 366:
            case 501:
            case 551:
            case 660:
            case 1260:
            case 1293:
            case 1324:
            case 1327:
            case 1329:
            case 1435:
            case 1445:
            case 1481:
            case 1482:
            case 1483:
            case 1484:
            case 1491:
            case 1495:
            case 1583:
            case 1596:
            case 1598:
            case 1662:
            case 1663:
                return;
            default:
                LocalPoint var6 = new LocalPoint(var1, var2);
                ProjectileMoved var7 = new ProjectileMoved();
                var7.setProjectile(this);
                var7.setPosition(var6);
                var7.setZ(var3);
                class166.clientInstance.getCallbacks().post(var7);
        }
    }

    public int getEndCycle() {
        return this.endCycle;
    }

    public int getRemainingCycles() {
        int var1 = class166.clientInstance.getGameCycle();
        return this.getEndCycle() - var1;
    }

    public int getFloor() {
        return this.floor;
    }

    public int getX1() {
        return this.x1;
    }

    public int getY1() {
        return this.y1;
    }

    public int getHeight() {
        return this.height;
    }

    public int getEndHeight() {
        return this.endHeight;
    }

    public int getStartMovementCycle() {
        return this.startMovementCycle;
    }

    public int getSlope() {
        return this.slope;
    }

    public int getStartHeight() {
        return this.startHeight;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public double getVelocityX() {
        return this.velocityX;
    }

    public double getVelocityY() {
        return this.velocityY;
    }

    public double getScalar() {
        return this.scalar;
    }

    public double getVelocityZ() {
        return this.velocityZ;
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)Ldl;"
    )
    protected final Model vmethod5584(int var1) {
        Spotanim var2 = IndexStoreActionHandler.method5748(this.id);
        Model var3 = var2.method5304(this.int7);
        if (var3 == null) {
            return null;
        } else {
            var3.method5522(this.rotationY);
            return var3;
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(IIIII)V",
            garbageValue = "-1215482147"
    )
    final void method5583(int var1, int var2, int var3, int var4) {
        this.projectileMoved(var1, var2, var3, var4);
        double var5;
        if (!this.isMoving) {
            var5 = (double) (var1 - this.x1);
            double var7 = (double) (var2 - this.y1);
            double var9 = Math.sqrt(var7 * var7 + var5 * var5);
            this.x = (double) this.x1 + var5 * (double) this.startHeight / var9;
            this.y = (double) this.y1 + var7 * (double) this.startHeight / var9;
            this.z = (double) this.height;
        }

        var5 = (double) (this.endCycle + 1 - var4);
        this.velocityX = ((double) var1 - this.x) / var5;
        this.velocityY = ((double) var2 - this.y) / var5;
        this.scalar = Math.sqrt(this.velocityX * this.velocityX + this.velocityY * this.velocityY);
        if (!this.isMoving) {
            this.velocityZ = -this.scalar * Math.tan((double) this.slope * 0.02454369D);
        }

        this.heightOffset = 2.0D * ((double) var3 - this.z - var5 * this.velocityZ) / (var5 * var5);
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "([BB)Lcx;",
            garbageValue = "117"
    )
    static class106 method5593(byte[] var0) {
        class106 var1 = new class106();
        Packet var2 = new Packet(var0);
        var2.offset = var2.payload.length - 2;
        int var3 = var2.readUnsignedShort();
        int var4 = var2.payload.length - 2 - var3 - 12;
        var2.offset = var4;
        int var5 = var2.getInt();
        var1.localIntCount = var2.readUnsignedShort();
        var1.localStringCount = var2.readUnsignedShort();
        var1.intStackCount = var2.readUnsignedShort();
        var1.stringStackCount = var2.readUnsignedShort();
        int var6 = var2.readUnsignedByte();
        int var7;
        int var8;
        if (var6 > 0) {
            var1.switches = var1.method1870(var6);

            for (var7 = 0; var7 < var6; ++var7) {
                var8 = var2.readUnsignedShort();
                IterableHashTable var9 = new IterableHashTable(var8 > 0 ? TotalQuantityComparator.method1181(var8) : 1);
                var1.switches[var7] = var9;

                while (var8-- > 0) {
                    int var10 = var2.getInt();
                    int var11 = var2.getInt();
                    var9.method2749(new IntegerNode(var11), (long) var10);
                }
            }
        }

        var2.offset = 0;
        var2.method6086();
        var1.instructions = new int[var5];
        var1.intOperands = new int[var5];
        var1.stringOperands = new String[var5];

        for (var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
            var8 = var2.readUnsignedShort();
            if (var8 == 3) {
                var1.stringOperands[var7] = var2.readString();
            } else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
                var1.intOperands[var7] = var2.getInt();
            } else {
                var1.intOperands[var7] = var2.readUnsignedByte();
            }
        }

        return var1;
    }

    @ObfuscatedName("fo")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-48774980"
    )
    static final void method5594() {
        for (int var0 = 0; var0 < client.highResolutionNpcCount; ++var0) {
            int var1 = client.highResolutionNpcIndexes[var0];
            NPCEntity var2 = client.npcs[var1];
            if (var2 != null) {
                AuthProt.method1671(var2, var2.type.size);
            }
        }

    }

    @ObfuscatedName("g")
    public static void method5582(String var0, Throwable var1, int var2) {
        if (var1 != null) {
            Throwable var3 = var1;
            if (var1 instanceof RSRunException) {
                var3 = ((RSRunException) var1).getParent();
            }

            class166.clientInstance.getLogger().error("Game crash", var3);
            StackTraceElement[] var4 = var3.getStackTrace();
            StackTraceElement[] var5 = var4;
            int var6 = var4.length;

            for (int var7 = 0; var7 < var6; ++var7) {
                StackTraceElement var8 = var5[var7];
                if (var8.getClassName().contains("runelite")) {
                    return;
                }
            }
        }

        client.copy$processClientError(var0, var1, var2);
    }
}
