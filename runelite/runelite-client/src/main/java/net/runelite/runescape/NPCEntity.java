package net.runelite.runescape;

import net.runelite.api.NPCComposition;
import net.runelite.api.events.NpcDespawned;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSNPCComposition;

import java.io.IOException;

@ObfuscatedName("bo")
@Implements("NPCEntity")
public final class NPCEntity extends PathingEntity implements RSNPC {
    public int npcIndex;
    public boolean dead;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Ljv;"
    )
    NPCType type;

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IIZI)V",
            garbageValue = "1165000296"
    )
    final void method2164(int var1, int var2, boolean var3) {
        if (super.animation != -1 && MapCacheArchiveNames.method2149(super.animation).priority == 1) {
            super.animation = -1;
            this.animationChanged(-1);
        }

        if (!var3) {
            int var4 = var1 - super.pathX[0];
            int var5 = var2 - super.pathY[0];
            if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
                if (super.queueSize < 9) {
                    ++super.queueSize;
                }

                for (int var6 = super.queueSize; var6 > 0; --var6) {
                    super.pathX[var6] = super.pathX[var6 - 1];
                    super.pathY[var6] = super.pathY[var6 - 1];
                    super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
                }

                super.pathX[0] = var1;
                super.pathY[0] = var2;
                super.pathTraversed[0] = 1;
                return;
            }
        }

        super.queueSize = 0;
        super.field959 = 0;
        super.field955 = 0;
        super.pathX[0] = var1;
        super.pathY[0] = var2;
        super.x = super.size * 64 + super.pathX[0] * 128;
        super.y = super.size * 64 + super.pathY[0] * 128;
    }

    public RSNPCComposition getComposition() {
        return this.type;
    }

    @ObfuscatedSignature(
            signature = "(I)Ldl;"
    )
    @Export("copy$getModel")
    public final Model copy$getModel(int var1) {
        if (this.type == null) {
            return null;
        } else {
            Sequence var2 = super.animation != -1 && super.actionAnimationDisable == 0 ? MapCacheArchiveNames.method2149(super.animation) : null;
            Sequence var3 = super.poseAnimation != -1 && (super.idlePoseAnimation != super.poseAnimation || var2 == null) ? MapCacheArchiveNames.method2149(super.poseAnimation) : null;
            Model var4 = this.type.method5854(var2, super.actionFrame, var3, super.poseFrame);
            if (var4 == null) {
                return null;
            } else {
                var4.method5457();
                super.logicalHeight = var4.modelHeight;
                if (super.graphic != -1 && super.spotAnimFrame != -1) {
                    Model var5 = IndexStoreActionHandler.method5748(super.graphic).method5304(super.spotAnimFrame);
                    if (var5 != null) {
                        var5.method5469(0, -super.field980, 0);
                        Model[] var6 = new Model[]{var4, var5};
                        var4 = new Model(var6, 2);
                    }
                }

                if (this.type.size == 1) {
                    var4.field1664 = true;
                }

                return var4;
            }
        }
    }

    public void onCompositionChanged(RSNPCComposition var1) {
        if (var1 == null) {
            class166.clientInstance.getCallbacks().post(new NpcDespawned(this));
        }

    }

    public int getId() {
        RSNPCComposition var1 = this.getComposition();
        if (var1 != null && var1.getConfigs() != null) {
            var1 = var1.transform();
        }

        return var1 == null ? -1 : var1.getId();
    }

    public String getName() {
        RSNPCComposition var1 = this.getComposition();
        if (var1 != null && var1.getConfigs() != null) {
            var1 = var1.transform();
        }

        return var1 == null ? null : var1.getName().replace(' ', ' ');
    }

    public int getCombatLevel() {
        RSNPCComposition var1 = this.getComposition();
        if (var1 != null && var1.getConfigs() != null) {
            var1 = var1.transform();
        }

        return var1 == null ? -1 : var1.getCombatLevel();
    }

    public int getIndex() {
        return this.npcIndex;
    }

    public void setIndex(int var1) {
        this.npcIndex = var1;
    }

    public NPCComposition getTransformedComposition() {
        RSNPCComposition var1 = this.getComposition();
        if (var1 != null && var1.getConfigs() != null) {
            var1 = var1.transform();
        }

        return var1;
    }

    public boolean isDead() {
        return this.dead;
    }

    public void setDead(boolean var1) {
        this.dead = var1;
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)Ldl;"
    )
    protected final Model vmethod5584(int var1) {
        if (class166.clientInstance.isInterpolateNpcAnimations() && this.getAnimation() != 6566) {
            int var2 = this.getActionFrame();
            int var3 = this.getPoseFrame();
            int var4 = this.getSpotAnimFrame();

            Model var5;
            try {
                this.setActionFrame(Integer.MIN_VALUE | this.getActionFrameCycle() << 16 | var2);
                this.setPoseFrame(Integer.MIN_VALUE | this.getPoseFrameCycle() << 16 | var3);
                this.setSpotAnimFrame(Integer.MIN_VALUE | this.getSpotAnimFrameCycle() << 16 | var4);
                var5 = this.copy$getModel(var1);
            } finally {
                this.setActionFrame(var2);
                this.setPoseFrame(var3);
                this.setSpotAnimFrame(var4);
            }

            return (Model) var5;
        } else {
            return (Model) this.copy$getModel(var1);
        }
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "1563766353"
    )
    final boolean vmethod2900() {
        return this.type != null;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(IBI)V",
            garbageValue = "-2016432421"
    )
    final void method2152(int var1, byte var2) {
        int var3 = super.pathX[0];
        int var4 = super.pathY[0];
        if (var1 == 0) {
            --var3;
            ++var4;
        }

        if (var1 == 1) {
            ++var4;
        }

        if (var1 == 2) {
            ++var3;
            ++var4;
        }

        if (var1 == 3) {
            --var3;
        }

        if (var1 == 4) {
            ++var3;
        }

        if (var1 == 5) {
            --var3;
            --var4;
        }

        if (var1 == 6) {
            --var4;
        }

        if (var1 == 7) {
            ++var3;
            --var4;
        }

        if (super.animation != -1 && MapCacheArchiveNames.method2149(super.animation).priority == 1) {
            super.animation = -1;
            this.animationChanged(-1);
        }

        if (super.queueSize < 9) {
            ++super.queueSize;
        }

        for (int var5 = super.queueSize; var5 > 0; --var5) {
            super.pathX[var5] = super.pathX[var5 - 1];
            super.pathY[var5] = super.pathY[var5 - 1];
            super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
        }

        super.pathX[0] = var3;
        super.pathY[0] = var4;
        super.pathTraversed[0] = var2;
    }

    @ObfuscatedName("gi")
    @ObfuscatedSignature(
            signature = "(ZI)V",
            garbageValue = "1157110077"
    )
    static final void method2165(boolean var0) {
        class76.method1147();
        ++client.serverConnection.field1288;
        if (client.serverConnection.field1288 >= 50 || var0) {
            client.serverConnection.field1288 = 0;
            if (!client.socketError && client.serverConnection.method5880() != null) {
                TcpConnectionMessage var1 = FaceNormal.method5726(ClientProt.NO_TIMEOUT, client.serverConnection.isaac);
                client.serverConnection.method5881(var1);

                try {
                    client.serverConnection.method5875();
                } catch (IOException var3) {
                    client.socketError = true;
                }
            }

        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "([BIIB)I",
            garbageValue = "-11"
    )
    public static int method2151(byte[] var0, int var1, int var2) {
        int var3 = -1;

        for (int var4 = var1; var4 < var2; ++var4) {
            var3 = var3 >>> 8 ^ Packet.crc32Table[(var3 ^ var0[var4]) & 255];
        }

        var3 = ~var3;
        return var3;
    }
}
