package net.runelite.runescape;

import net.runelite.mapping.*;
import net.runelite.rs.api.RSFrames;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSSequence;

@ObfuscatedName("jg")
@Implements("Sequence")
public class Sequence extends CacheableNode implements RSSequence {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    @Export("skel_ref")
    static Js5Index skel_ref;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    @Export("skin_ref")
    static Js5Index skin_ref;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    @Export("sequences")
    static NodeCache sequences;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    @Export("skeletons")
    static NodeCache skeletons;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    @Export("seq_ref")
    static Js5Index seq_ref;
    @ObfuscatedName("f")
    @ObfuscatedGetter(
            intValue = 1056575283
    )
    @Export("priority")
    public int priority;
    @ObfuscatedName("l")
    @Export("frameIDs")
    public int[] frameIDs;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = -1583363981
    )
    @Export("maxLoops")
    public int maxLoops;
    @ObfuscatedName("w")
    @Export("frameLengths")
    public int[] frameLengths;
    @ObfuscatedName("x")
    @ObfuscatedGetter(
            intValue = -1470185279
    )
    @Export("rightHandItem")
    public int rightHandItem;
    @ObfuscatedName("m")
    @Export("stretches")
    public boolean stretches;
    @ObfuscatedName("p")
    @Export("interleaveLeave")
    int[] interleaveLeave;
    @ObfuscatedName("b")
    int[] field3621;
    @ObfuscatedName("a")
    @ObfuscatedGetter(
            intValue = -1913970027
    )
    @Export("replyMode")
    public int replyMode;
    @ObfuscatedName("n")
    public int[] field3620;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = -1357081299
    )
    @Export("frameStep")
    public int frameStep;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = 1292572981
    )
    @Export("forcedPriority")
    public int forcedPriority;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = 1067710599
    )
    @Export("leftHandItem")
    public int leftHandItem;
    @ObfuscatedName("h")
    @ObfuscatedGetter(
            intValue = 304760401
    )
    @Export("precedenceAnimating")
    public int precedenceAnimating;

    static {
        sequences = new NodeCache(64);
        skeletons = new NodeCache(100);
    }

    Sequence() {
        this.frameStep = -1;
        this.stretches = false;
        this.forcedPriority = 5;
        this.leftHandItem = -1;
        this.rightHandItem = -1;
        this.maxLoops = 99;
        this.precedenceAnimating = -1;
        this.priority = -1;
        this.replyMode = 2;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-1690168982"
    )
    void method4786(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.decode(var1, var2);
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "1917758889"
    )
    @Export("decode")
    void decode(Packet var1, int var2) {
        int var3;
        int var4;
        if (var2 == 1) {
            var3 = var1.readUnsignedShort();
            this.frameLengths = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameLengths[var4] = var1.readUnsignedShort();
            }

            this.frameIDs = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameIDs[var4] = var1.readUnsignedShort();
            }

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameIDs[var4] += var1.readUnsignedShort() << 16;
            }
        } else if (var2 == 2) {
            this.frameStep = var1.readUnsignedShort();
        } else if (var2 == 3) {
            var3 = var1.readUnsignedByte();
            this.interleaveLeave = new int[var3 + 1];

            for (var4 = 0; var4 < var3; ++var4) {
                this.interleaveLeave[var4] = var1.readUnsignedByte();
            }

            this.interleaveLeave[var3] = 9999999;
        } else if (var2 == 4) {
            this.stretches = true;
        } else if (var2 == 5) {
            this.forcedPriority = var1.readUnsignedByte();
        } else if (var2 == 6) {
            this.leftHandItem = var1.readUnsignedShort();
        } else if (var2 == 7) {
            this.rightHandItem = var1.readUnsignedShort();
        } else if (var2 == 8) {
            this.maxLoops = var1.readUnsignedByte();
        } else if (var2 == 9) {
            this.precedenceAnimating = var1.readUnsignedByte();
        } else if (var2 == 10) {
            this.priority = var1.readUnsignedByte();
        } else if (var2 == 11) {
            this.replyMode = var1.readUnsignedByte();
        } else if (var2 == 12) {
            var3 = var1.readUnsignedByte();
            this.field3621 = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.field3621[var4] = var1.readUnsignedShort();
            }

            for (var4 = 0; var4 < var3; ++var4) {
                this.field3621[var4] += var1.readUnsignedShort() << 16;
            }
        } else if (var2 == 13) {
            var3 = var1.readUnsignedByte();
            this.field3620 = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.field3620[var4] = var1.method6082();
            }
        }

        if (replyMode != 2) {
            System.out.println("Replay Mode: " + replyMode);
        }

    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(Ldl;II)Ldl;"
    )
    Model method4808(Model var1, int var2, int var3) {
        if (var2 < 0) {
            int var4 = var2 ^ Integer.MIN_VALUE;
            int var5 = var4 >> 16;
            var2 = var4 & 65535;
            int var6 = var2 + 1;
            if (var6 >= this.getFrameIDs().length) {
                var6 = -1;
            }

            int[] var7 = this.getFrameIDs();
            int var8 = var7[var2];
            RSFrames var9 = class166.clientInstance.getFrames(var8 >> 16);
            int var10 = var8 & 65535;
            int var11 = -1;
            RSFrames var12 = null;
            if (var6 != -1) {
                int var13 = var7[var6];
                var12 = class166.clientInstance.getFrames(var13 >> 16);
                var11 = var13 & 65535;
            }

            if (var9 == null) {
                return (Model) var1.toSharedSpotAnimModel(true);
            } else {
                RSModel var14 = var1.toSharedSpotAnimModel(!var9.getFrames()[var10].isShowing());
                var14.interpolateFrames(var9, var10, var12, var11, var5, this.getFrameLenths()[var2]);
                return (Model) var14;
            }
        } else {
            return (Model) this.copy$transformSpotAnimModel(var1, var2, var3);
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(Ldl;III)Ldl;"
    )
    Model method4780(Model var1, int var2, int var3, int var4) {
        if (var2 < 0) {
            int var5 = var2 ^ Integer.MIN_VALUE;
            int var6 = var5 >> 16;
            var2 = var5 & 65535;
            int var7 = var2 + 1;
            if (var7 >= this.getFrameIDs().length) {
                var7 = -1;
            }

            int[] var8 = this.getFrameIDs();
            int var9 = var8[var2];
            RSFrames var10 = class166.clientInstance.getFrames(var9 >> 16);
            int var11 = var9 & 65535;
            int var12 = -1;
            RSFrames var13 = null;
            if (var7 != -1) {
                int var14 = var8[var7];
                var13 = class166.clientInstance.getFrames(var14 >> 16);
                var12 = var14 & 65535;
            }

            if (var10 == null) {
                return (Model) var1.toSharedModel(true);
            } else {
                RSModel var15 = var1.toSharedModel(!var10.getFrames()[var11].isShowing());
                var3 &= 3;
                if (var3 == 1) {
                    var15.rotateY270Ccw();
                } else if (var3 == 2) {
                    var15.rotateY180Ccw();
                } else if (var3 == 3) {
                    var15.rotateY90Ccw();
                }

                var15.interpolateFrames(var10, var11, var13, var12, var6, this.getFrameLenths()[var2]);
                if (var3 == 1) {
                    var15.rotateY90Ccw();
                } else if (var3 == 2) {
                    var15.rotateY180Ccw();
                } else if (var3 == 3) {
                    var15.rotateY270Ccw();
                }

                return (Model) var15;
            }
        } else {
            return (Model) this.copy$transformObjectModel(var1, var2, var3, var4);
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-2062242357"
    )
    void method4778() {
        if (this.precedenceAnimating == -1) {
            if (this.interleaveLeave != null) {
                this.precedenceAnimating = 2;
            } else {
                this.precedenceAnimating = 0;
            }
        }

        if (this.priority == -1) {
            if (this.interleaveLeave != null) {
                this.priority = 2;
            } else {
                this.priority = 0;
            }
        }

    }

    @ObfuscatedSignature(
            signature = "(Ldl;III)Ldl;"
    )
    @Export("copy$transformObjectModel")
    public Model copy$transformObjectModel(Model var1, int var2, int var3, int var4) {
        var2 = this.frameIDs[var2];
        Frames var5 = class315.method5967(var2 >> 16);
        var2 &= 65535;
        if (var5 == null) {
            return var1.method5453(true);
        } else {
            Model var6 = var1.method5453(!var5.method1087(var2));
            var3 &= 3;
            if (var3 == 1) {
                var6.method5480();
            } else if (var3 == 2) {
                var6.method5468();
            } else if (var3 == 3) {
                var6.method5464();
            }

            var6.method5454(var5, var2);
            if (var3 == 1) {
                var6.method5464();
            } else if (var3 == 2) {
                var6.method5468();
            } else if (var3 == 3) {
                var6.method5480();
            }

            return var6;
        }
    }

    @ObfuscatedSignature(
            signature = "(Ldl;II)Ldl;"
    )
    @Export("copy$transformSpotAnimModel")
    public Model copy$transformSpotAnimModel(Model var1, int var2, int var3) {
        var2 = this.frameIDs[var2];
        Frames var4 = class315.method5967(var2 >> 16);
        var2 &= 65535;
        if (var4 == null) {
            return var1.method5465(true);
        } else {
            Model var5 = var1.method5465(!var4.method1087(var2));
            var5.method5454(var4, var2);
            return var5;
        }
    }

    @ObfuscatedSignature(
            signature = "(Ldl;II)Ldl;"
    )
    @Export("copy$transformActorModel")
    public Model copy$transformActorModel(Model var1, int var2, int var3) {
        var2 = this.frameIDs[var2];
        Frames var4 = class315.method5967(var2 >> 16);
        var2 &= 65535;
        if (var4 == null) {
            return var1.method5453(true);
        } else {
            Model var5 = var1.method5453(!var4.method1087(var2));
            var5.method5454(var4, var2);
            return var5;
        }
    }

    @ObfuscatedSignature(
            signature = "(Ldl;ILjg;II)Ldl;"
    )
    @Export("copy$applyTransformations")
    public Model copy$applyTransformations(Model var1, int var2, Sequence var3, int var4, int var5) {
        var2 = this.frameIDs[var2];
        Frames var6 = class315.method5967(var2 >> 16);
        var2 &= 65535;
        if (var6 == null) {
            return var3.method4779(var1, var4, -1140097691);
        } else {
            var4 = var3.frameIDs[var4];
            Frames var7 = class315.method5967(var4 >> 16);
            var4 &= 65535;
            Model var8;
            if (var7 == null) {
                var8 = var1.method5453(!var6.method1087(var2));
                var8.method5454(var6, var2);
                return var8;
            } else {
                var8 = var1.method5453(!var6.method1087(var2) & !var7.method1087(var4));
                var8.method5470(var6, var2, var7, var4, this.interleaveLeave);
                return var8;
            }
        }
    }

    public int[] getFrameIDs() {
        return this.frameIDs;
    }

    public int[] getFrameLenths() {
        return this.frameLengths;
    }

    public int[] getInterleaveLeave() {
        return this.interleaveLeave;
    }

    public boolean getStretches() {
        return this.stretches;
    }

    public int getMaxLoops() {
        return this.maxLoops;
    }

    public int getPrecedenceAnimating() {
        return this.precedenceAnimating;
    }

    public int getReplyMode() {
        return this.replyMode;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(Ldl;II)Ldl;"
    )
    public Model method4779(Model var1, int var2, int var3) {
        if (var2 < 0) {
            int var4 = var2 ^ Integer.MIN_VALUE;
            int var5 = var4 >> 16;
            var2 = var4 & 65535;
            int var6 = var2 + 1;
            if (var6 >= this.getFrameIDs().length) {
                var6 = -1;
            }

            int[] var7 = this.getFrameIDs();
            int var8 = var7[var2];
            RSFrames var9 = class166.clientInstance.getFrames(var8 >> 16);
            int var10 = var8 & 65535;
            int var11 = -1;
            RSFrames var12 = null;
            if (var6 != -1) {
                int var13 = var7[var6];
                var12 = class166.clientInstance.getFrames(var13 >> 16);
                var11 = var13 & 65535;
            }

            if (var9 == null) {
                return (Model) var1.toSharedModel(true);
            } else {
                RSModel var14 = var1.toSharedModel(!var9.getFrames()[var10].isShowing());
                var14.interpolateFrames(var9, var10, var12, var11, var5, this.getFrameLenths()[var2]);
                return (Model) var14;
            }
        } else {
            return (Model) this.copy$transformActorModel(var1, var2, var3);
        }
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(Ldl;ILjg;II)Ldl;"
    )
    public Model method4781(Model var1, int var2, Sequence var3, int var4, int var5) {
        int var6;
        if (var2 < 0) {
            var6 = var2 ^ Integer.MIN_VALUE;
            var2 = var6 & 65535;
        }

        if (var4 < 0) {
            var6 = var4 ^ Integer.MIN_VALUE;
            var4 = var6 & 65535;
        }

        return (Model) this.copy$applyTransformations(var1, var2, var3, var4, var5);
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(Ldl;II)Ldl;",
            garbageValue = "-2066035701"
    )
    public Model method4775(Model var1, int var2) {
        int var3 = this.frameIDs[var2];
        Frames var4 = class315.method5967(var3 >> 16);
        var3 &= 65535;
        if (var4 == null) {
            return var1.method5453(true);
        } else {
            Frames var5 = null;
            int var6 = 0;
            if (this.field3621 != null && var2 < this.field3621.length) {
                var6 = this.field3621[var2];
                var5 = class315.method5967(var6 >> 16);
                var6 &= 65535;
            }

            Model var7;
            if (var5 != null && var6 != 65535) {
                var7 = var1.method5453(!var4.method1087(var3) & !var5.method1087(var6));
                var7.method5454(var4, var3);
                var7.method5454(var5, var6);
                return var7;
            } else {
                var7 = var1.method5453(!var4.method1087(var3));
                var7.method5454(var4, var3);
                return var7;
            }
        }
    }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            signature = "(ILcx;ZS)I",
            garbageValue = "10020"
    )
    static int method4813(int var0, class106 var1, boolean var2) {
        if (var0 == 3200) {
            class228.intStackSize -= 3;
            MapIconReference.method4837(class48.intStack[class228.intStackSize], class48.intStack[class228.intStackSize + 1], class48.intStack[class228.intStackSize + 2]);
            return 1;
        } else if (var0 == 3201) {
            class4.method42(class48.intStack[--class228.intStackSize]);
            return 1;
        } else if (var0 == 3202) {
            class228.intStackSize -= 2;
            class101.method1698(class48.intStack[class228.intStackSize], class48.intStack[class228.intStackSize + 1]);
            return 1;
        } else {
            return 2;
        }
    }

    @ObfuscatedName("hj")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "-719831937"
    )
    static void method4796(int var0, int var1) {
        TcpConnectionMessage var2 = FaceNormal.method5726(ClientProt.RESUME_PAUSEBUTTON, client.serverConnection.isaac);
        var2.packetBuffer.putIntV2(var0);
        var2.packetBuffer.getShort128(var1);
        client.serverConnection.method5881(var2);
    }
}
