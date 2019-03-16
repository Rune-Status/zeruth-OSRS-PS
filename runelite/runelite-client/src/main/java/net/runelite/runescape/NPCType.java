package net.runelite.runescape;

import net.runelite.api.HeadIcon;
import net.runelite.api.events.NpcActionChanged;
import net.runelite.mapping.*;
import net.runelite.rs.api.RSNPCComposition;

import java.security.SecureRandom;

@ObfuscatedName("jv")
@Implements("NPCType")
public class NPCType extends CacheableNode implements RSNPCComposition {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index NpcDefinition_modelIndexCache;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache npcTypeCache;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache npcModelCache;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index NpcDefinition_indexCache;
    @ObfuscatedName("f")
    short[] recolD;
    @ObfuscatedName("l")
    public String name;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = 1724585217
    )
    public int rotate270Anim;
    @ObfuscatedName("af")
    @ObfuscatedGetter(
            intValue = -322635073
    )
    int ambient;
    @ObfuscatedName("ae")
    public int[] multiNpcs;
    @ObfuscatedName("k")
    public String[] ops;
    @ObfuscatedName("w")
    int[] models;
    @ObfuscatedName("x")
    @ObfuscatedGetter(
            intValue = 1370405807
    )
    public int rotate90Anim;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = 348590113
    )
    public int field3575;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -1817620687
    )
    public int field3580;
    @ObfuscatedName("ag")
    public boolean isClippedMovement;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 162183627
    )
    public int size;
    @ObfuscatedName("aj")
    public boolean isClickable;
    @ObfuscatedName("aw")
    @ObfuscatedGetter(
            intValue = -1361505899
    )
    public int rotation;
    @ObfuscatedName("o")
    public boolean isVisible;
    @ObfuscatedName("a")
    short[] retexS;
    @ObfuscatedName("z")
    public boolean isMinimapVisible;
    @ObfuscatedName("n")
    int[] headModels;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -707361121
    )
    public int id;
    @ObfuscatedName("t")
    short[] retexD;
    @ObfuscatedName("an")
    @ObfuscatedGetter(
            intValue = 744895979
    )
    int contrast;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 451219839
    )
    public int idleAnim;
    @ObfuscatedName("y")
    @ObfuscatedGetter(
            intValue = 1153330095
    )
    int widthScale;
    @ObfuscatedName("ax")
    @ObfuscatedGetter(
            intValue = -1951381565
    )
    public int headIcon;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = -1643561501
    )
    public int walkAnim;
    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            signature = "Lgr;"
    )
    IterableHashTable params;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = 1479941137
    )
    public int rotate180Anim;
    @ObfuscatedName("s")
    @ObfuscatedGetter(
            intValue = -1467551395
    )
    public int level;
    @ObfuscatedName("az")
    @ObfuscatedGetter(
            intValue = -1502298367
    )
    int multiNpcVarp;
    @ObfuscatedName("ac")
    @ObfuscatedGetter(
            intValue = 1238895135
    )
    int multiNpcVarbit;
    @ObfuscatedName("h")
    short[] recolS;
    @ObfuscatedName("u")
    @ObfuscatedGetter(
            intValue = -372914157
    )
    int heightScale;
    @ObfuscatedName("ab")
    public boolean isLowPriorityOps;

    static {
        npcTypeCache = new NodeCache(64);
        npcModelCache = new NodeCache(50);
    }

    NPCType() {
        this.name = "null";
        this.size = 1;
        this.idleAnim = -1;
        this.field3580 = -1;
        this.field3575 = -1;
        this.walkAnim = -1;
        this.rotate180Anim = -1;
        this.rotate90Anim = -1;
        this.rotate270Anim = -1;
        this.ops = new String[5];
        this.actionsHook(-1);
        this.isMinimapVisible = true;
        this.level = -1;
        this.widthScale = 128;
        this.heightScale = 128;
        this.isVisible = false;
        this.ambient = 0;
        this.contrast = 0;
        this.headIcon = -1;
        this.rotation = 32;
        this.multiNpcVarbit = -1;
        this.multiNpcVarp = -1;
        this.isClickable = true;
        this.isClippedMovement = true;
        this.isLowPriorityOps = false;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-46"
    )
    void method5832() {
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-1697913779"
    )
    void method5857(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.decode(var1, var2);
        }
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(ILjava/lang/String;I)Ljava/lang/String;",
            garbageValue = "582721737"
    )
    public String method5840(int var1, String var2) {
        return AuthProt.method1670(this.params, var1, var2);
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(B)Ljv;",
            garbageValue = "70"
    )
    public final NPCType method5837() {
        int var1 = -1;
        if (this.multiNpcVarbit != -1) {
            var1 = AbstractSoundSystem.method339(this.multiNpcVarbit);
        } else if (this.multiNpcVarp != -1) {
            var1 = class311.clientVarps[this.multiNpcVarp];
        }

        int var2;
        if (var1 >= 0 && var1 < this.multiNpcs.length - 1) {
            var2 = this.multiNpcs[var1];
        } else {
            var2 = this.multiNpcs[this.multiNpcs.length - 1];
        }

        return var2 != -1 ? FileRequest.method4030(var2) : null;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)Ldu;",
            garbageValue = "-26261165"
    )
    public final ModelData method5870() {
        if (this.multiNpcs != null) {
            NPCType var1 = this.method5837();
            return var1 == null ? null : var1.method5870();
        } else if (this.headModels == null) {
            return null;
        } else {
            boolean var5 = false;

            for (int var2 = 0; var2 < this.headModels.length; ++var2) {
                if (!NpcDefinition_modelIndexCache.method1515(this.headModels[var2], 0)) {
                    var5 = true;
                }
            }

            if (var5) {
                return null;
            } else {
                ModelData[] var6 = new ModelData[this.headModels.length];

                for (int var3 = 0; var3 < this.headModels.length; ++var3) {
                    var6[var3] = ModelData.method1479(NpcDefinition_modelIndexCache, this.headModels[var3], 0);
                }

                ModelData var7;
                if (var6.length == 1) {
                    var7 = var6[0];
                } else {
                    var7 = new ModelData(var6, var6.length);
                }

                int var4;
                if (this.recolS != null) {
                    for (var4 = 0; var4 < this.recolS.length; ++var4) {
                        var7.method1411(this.recolS[var4], this.recolD[var4]);
                    }
                }

                if (this.retexS != null) {
                    for (var4 = 0; var4 < this.retexS.length; ++var4) {
                        var7.method1421(this.retexS[var4], this.retexD[var4]);
                    }
                }

                return var7;
            }
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "2023890200"
    )
    @Export("decode")
    void decode(Packet var1, int var2) {
        int var3;
        int var4;
        if (var2 == 1) {
            var3 = var1.readUnsignedByte();
            this.models = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.models[var4] = var1.readUnsignedShort();
            }
        } else if (var2 == 2) {
            this.name = var1.readString();
        } else if (var2 == 12) {
            this.size = var1.readUnsignedByte();
        } else if (var2 == 13) {
            this.idleAnim = var1.readUnsignedShort();
        } else if (var2 == 14) {
            this.walkAnim = var1.readUnsignedShort();
        } else if (var2 == 15) {
            this.field3580 = var1.readUnsignedShort();
        } else if (var2 == 16) {
            this.field3575 = var1.readUnsignedShort();
        } else if (var2 == 17) {
            this.walkAnim = var1.readUnsignedShort();
            this.rotate180Anim = var1.readUnsignedShort();
            this.rotate90Anim = var1.readUnsignedShort();
            this.rotate270Anim = var1.readUnsignedShort();
        } else if (var2 >= 30 && var2 < 35) {
            this.ops[var2 - 30] = var1.readString();
            this.actionsHook(var2 - 30);
            if (this.ops[var2 - 30].equalsIgnoreCase("Hidden")) {
                this.ops[var2 - 30] = null;
                this.actionsHook(var2 - 30);
            }
        } else if (var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.recolS = new short[var3];
            this.recolD = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.recolS[var4] = (short) var1.readUnsignedShort();
                this.recolD[var4] = (short) var1.readUnsignedShort();
            }
        } else if (var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.retexS = new short[var3];
            this.retexD = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.retexS[var4] = (short) var1.readUnsignedShort();
                this.retexD[var4] = (short) var1.readUnsignedShort();
            }
        } else if (var2 == 60) {
            var3 = var1.readUnsignedByte();
            this.headModels = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.headModels[var4] = var1.readUnsignedShort();
            }
        } else if (var2 == 93) {
            this.isMinimapVisible = false;
        } else if (var2 == 95) {
            this.level = var1.readUnsignedShort();
        } else if (var2 == 97) {
            this.widthScale = var1.readUnsignedShort();
        } else if (var2 == 98) {
            this.heightScale = var1.readUnsignedShort();
        } else if (var2 == 99) {
            this.isVisible = true;
        } else if (var2 == 100) {
            this.ambient = var1.method6240();
        } else if (var2 == 101) {
            this.contrast = var1.method6240() * 5;
        } else if (var2 == 102) {
            this.headIcon = var1.readUnsignedShort();
        } else if (var2 == 103) {
            this.rotation = var1.readUnsignedShort();
        } else if (var2 != 106 && var2 != 118) {
            if (var2 == 107) {
                this.isClickable = false;
            } else if (var2 == 109) {
                this.isClippedMovement = false;
            } else if (var2 == 111) {
                this.isLowPriorityOps = true;
            } else if (var2 == 249) {
                this.params = class96.method1621(var1, this.params);
            }
        } else {
            this.multiNpcVarbit = var1.readUnsignedShort();
            if (this.multiNpcVarbit == 65535) {
                this.multiNpcVarbit = -1;
            }

            this.multiNpcVarp = var1.readUnsignedShort();
            if (this.multiNpcVarp == 65535) {
                this.multiNpcVarp = -1;
            }

            var3 = -1;
            if (var2 == 118) {
                var3 = var1.readUnsignedShort();
                if (var3 == 65535) {
                    var3 = -1;
                }
            }

            var4 = var1.readUnsignedByte();
            this.multiNpcs = new int[var4 + 2];

            for (int var5 = 0; var5 <= var4; ++var5) {
                this.multiNpcs[var5] = var1.readUnsignedShort();
                if (this.multiNpcs[var5] == 65535) {
                    this.multiNpcs[var5] = -1;
                }
            }

            this.multiNpcs[var4 + 1] = var3;
        }

    }

    public int getRsOverheadIcon() {
        return this.headIcon;
    }

    public void actionsHook(int var1) {
        NpcActionChanged var2 = new NpcActionChanged();
        var2.setNpcComposition(this);
        var2.setIdx(var1);
        class166.clientInstance.getCallbacks().post(var2);
    }

    public HeadIcon getOverheadIcon() {
        switch (this.getRsOverheadIcon()) {
            case 0:
                return HeadIcon.MELEE;
            case 1:
                return HeadIcon.RANGED;
            case 2:
                return HeadIcon.MAGIC;
            case 3:
            case 4:
            case 5:
            default:
                return null;
            case 6:
                return HeadIcon.RANGE_MAGE;
        }
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public int[] getModels() {
        return this.models;
    }

    public String[] getActions() {
        return this.ops;
    }

    public boolean isMinimapVisable() {
        return this.isMinimapVisible;
    }

    public int getCombatLevel() {
        return this.level;
    }

    public boolean isVisable() {
        return this.isVisible;
    }

    public int[] getConfigs() {
        return this.multiNpcs;
    }

    public boolean isClickable() {
        return this.isClippedMovement;
    }

    public RSNPCComposition transform() {
        return this.method5837();
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(Ljg;ILjg;II)Ldl;",
            garbageValue = "391625709"
    )
    public final Model method5854(Sequence var1, int var2, Sequence var3, int var4) {
        if (this.multiNpcs != null) {
            NPCType var12 = this.method5837();
            return var12 == null ? null : var12.method5854(var1, var2, var3, var4);
        } else {
            Model var5 = (Model) npcModelCache.method951((long) this.id);
            if (var5 == null) {
                boolean var6 = false;

                for (int var7 = 0; var7 < this.models.length; ++var7) {
                    if (!NpcDefinition_modelIndexCache.method1515(this.models[var7], 0)) {
                        var6 = true;
                    }
                }

                if (var6) {
                    return null;
                }

                ModelData[] var8 = new ModelData[this.models.length];

                int var9;
                for (var9 = 0; var9 < this.models.length; ++var9) {
                    var8[var9] = ModelData.method1479(NpcDefinition_modelIndexCache, this.models[var9], 0);
                }

                ModelData var11;
                if (var8.length == 1) {
                    var11 = var8[0];
                } else {
                    var11 = new ModelData(var8, var8.length);
                }

                if (this.recolS != null) {
                    for (var9 = 0; var9 < this.recolS.length; ++var9) {
                        var11.method1411(this.recolS[var9], this.recolD[var9]);
                    }
                }

                if (this.retexS != null) {
                    for (var9 = 0; var9 < this.retexS.length; ++var9) {
                        var11.method1421(this.retexS[var9], this.retexD[var9]);
                    }
                }

                var5 = var11.method1408(this.ambient + 64, this.contrast + 850, -30, -50, -30);
                npcModelCache.method957(var5, (long) this.id);
            }

            Model var10;
            if (var1 != null && var3 != null) {
                var10 = var1.method4781(var5, var2, var3, var4, -2120673223);
            } else if (var1 != null) {
                var10 = var1.method4779(var5, var2, -1140097691);
            } else if (var3 != null) {
                var10 = var3.method4779(var5, var4, -1140097691);
            } else {
                var10 = var5.method5453(true);
            }

            if (this.widthScale != 128 || this.heightScale != 128) {
                var10.method5462(this.widthScale, this.heightScale, this.widthScale);
            }

            return var10;
        }
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "207776887"
    )
    public boolean method5838() {
        if (this.multiNpcs == null) {
            return true;
        } else {
            int var1 = -1;
            if (this.multiNpcVarbit != -1) {
                var1 = AbstractSoundSystem.method339(this.multiNpcVarbit);
            } else if (this.multiNpcVarp != -1) {
                var1 = class311.clientVarps[this.multiNpcVarp];
            }

            return var1 >= 0 && var1 < this.multiNpcs.length ? this.multiNpcs[var1] != -1 : this.multiNpcs[this.multiNpcs.length - 1] != -1;
        }
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "-810084815"
    )
    public int method5839(int var1, int var2) {
        return AuthProt.method1664(this.params, var1, var2);
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)Ljava/security/SecureRandom;",
            garbageValue = "-786347934"
    )
    static SecureRandom method5843() {
        SecureRandom var0 = new SecureRandom();
        var0.nextInt();
        return var0;
    }
}
