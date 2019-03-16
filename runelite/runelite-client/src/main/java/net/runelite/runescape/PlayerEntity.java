package net.runelite.runescape;

import net.runelite.api.HeadIcon;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.SkullIcon;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.model.Triangle;
import net.runelite.api.model.Vertex;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSName;
import net.runelite.rs.api.RSPlayer;
import net.runelite.rs.api.RSPlayerComposition;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ObfuscatedName("bk")
@Implements("PlayerEntity")
public final class PlayerEntity extends PathingEntity implements RSPlayer {
    @ObfuscatedName("so")
    @ObfuscatedSignature(
            signature = "Llr;"
    )
    static MachineInfo field634;
    @ObfuscatedName("gu")
    @ObfuscatedSignature(
            signature = "[Lls;"
    )
    static SpritePixels[] headIconsPk;
    @ObfuscatedName("f")
    @ObfuscatedGetter(
            intValue = -904103747
    )
    int field621;
    @ObfuscatedName("l")
    String[] tagFragments;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = 749185145
    )
    int field608;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lhi;"
    )
    PlayerComposition composition;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -830317817
    )
    int skullIcon;
    @ObfuscatedName("af")
    boolean field631;
    @ObfuscatedName("k")
    @ObfuscatedGetter(
            intValue = -1155707111
    )
    int team;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = -1034386739
    )
    int totalLevel;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 1965661975
    )
    int overheadIcon;
    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "Ldl;"
    )
    Model model;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = 1987323419
    )
    int field616;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -1702505993
    )
    int animationCycleEnd;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -453697303
    )
    int combatLevel;
    @ObfuscatedName("aw")
    @ObfuscatedGetter(
            intValue = -1612023909
    )
    int yInScene;
    @ObfuscatedName("o")
    @ObfuscatedSignature(
            signature = "Lkj;"
    )
    class132 field618;
    @ObfuscatedName("a")
    @ObfuscatedGetter(
            intValue = -626130891
    )
    int field623;
    @ObfuscatedName("z")
    boolean hidden;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = 1512657857
    )
    int field613;
    @ObfuscatedName("t")
    boolean isLowDetail;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = -634896257
    )
    int animationCycleStart;
    @ObfuscatedName("y")
    @ObfuscatedGetter(
            intValue = -608452623
    )
    int playerId;
    @ObfuscatedName("ax")
    @ObfuscatedGetter(
            intValue = 1204818179
    )
    int xInScene;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = 828370233
    )
    int field610;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = -1891695379
    )
    int field612;
    @ObfuscatedName("s")
    @ObfuscatedGetter(
            intValue = -1298600591
    )
    int field620;
    @ObfuscatedName("h")
    @ObfuscatedGetter(
            intValue = 297845551
    )
    int field606;
    @ObfuscatedName("u")
    @ObfuscatedSignature(
            signature = "Lkj;"
    )
    class132 field607;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lkg;"
    )
    Name name;

    PlayerEntity() {
        this.skullIcon = -1;
        this.overheadIcon = -1;
        this.tagFragments = new String[3];

        for (int var1 = 0; var1 < 3; ++var1) {
            this.tagFragments[var1] = "";
        }

        this.combatLevel = 0;
        this.totalLevel = 0;
        this.animationCycleStart = 0;
        this.animationCycleEnd = 0;
        this.isLowDetail = false;
        this.team = 0;
        this.hidden = false;
        this.field607 = class132.UNSET;
        this.field618 = class132.UNSET;
        this.field631 = false;
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(IIBI)V",
            garbageValue = "1910801327"
    )
    final void method2912(int var1, int var2, byte var3) {
        if (super.queueSize < 9) {
            ++super.queueSize;
        }

        for (int var4 = super.queueSize; var4 > 0; --var4) {
            super.pathX[var4] = super.pathX[var4 - 1];
            super.pathY[var4] = super.pathY[var4 - 1];
            super.pathTraversed[var4] = super.pathTraversed[var4 - 1];
        }

        super.pathX[0] = var1;
        super.pathY[0] = var2;
        super.pathTraversed[0] = var3;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-922368349"
    )
    boolean method2890() {
        if (this.field607 == class132.UNSET) {
            this.method2892();
        }

        return this.field607 == class132.CONTAINS;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "9"
    )
    void method2891() {
        this.field607 = class132.UNSET;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1489578028"
    )
    void method2892() {
        this.field607 = ServerProt.friendManager.method57(this.name) ? class132.CONTAINS : class132.NOT_CONTAINS;
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "1367949802"
    )
    void method2927(int var1, int var2) {
        super.queueSize = 0;
        super.field959 = 0;
        super.field955 = 0;
        super.pathX[0] = var1;
        super.pathY[0] = var2;
        int var3 = this.method2895();
        super.x = super.pathX[0] * 128 + var3 * 64;
        super.y = var3 * 64 + super.pathY[0] * 128;
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "-87"
    )
    int method2895() {
        return this.composition != null && this.composition.transformedNpcId != -1 ? FileRequest.method4030(this.composition.transformedNpcId).size : 1;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "972255123"
    )
    void method2894() {
        this.field618 = TotalQuantityComparator.clanMemberManager != null && TotalQuantityComparator.clanMemberManager.method5247(this.name) ? class132.CONTAINS : class132.NOT_CONTAINS;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "0"
    )
    boolean method2893() {
        if (this.field618 == class132.UNSET) {
            this.method2894();
        }

        return this.field618 == class132.CONTAINS;
    }

    public RSName getRsName() {
        return this.name;
    }

    public int getRsOverheadIcon() {
        return this.overheadIcon;
    }

    @Override
    public int getRsSkullIcon() {
        return 0;
    }

    public int _protect$getRsSkullIcon/* $FF was: 1protect$getRsSkullIcon*/() {
        return this.skullIcon;
    }

    @ObfuscatedSignature(
            signature = "(I)Ldl;"
    )
    public final Model copy$getModel(int var1) {
        if (this.composition == null) {
            return null;
        } else {
            Sequence var2 = super.animation != -1 && super.actionAnimationDisable == 0 ? MapCacheArchiveNames.method2149(super.animation) : null;
            Sequence var3 = super.poseAnimation != -1 && !this.isLowDetail && (super.idlePoseAnimation != super.poseAnimation || var2 == null) ? MapCacheArchiveNames.method2149(super.poseAnimation) : null;
            Model var4 = this.composition.method625(var2, super.actionFrame, var3, super.poseFrame);
            if (var4 == null) {
                return null;
            } else {
                var4.method5457();
                super.logicalHeight = var4.modelHeight;
                Model var5;
                Model[] var6;
                if (!this.isLowDetail && super.graphic != -1 && super.spotAnimFrame != -1) {
                    var5 = IndexStoreActionHandler.method5748(super.graphic).method5304(super.spotAnimFrame);
                    if (var5 != null) {
                        var5.method5469(0, -super.field980, 0);
                        var6 = new Model[]{var4, var5};
                        var4 = new Model(var6, 2);
                    }
                }

                if (!this.isLowDetail && this.model != null) {
                    if (client.gameCycle >= this.animationCycleEnd) {
                        this.model = null;
                    }

                    if (client.gameCycle >= this.animationCycleStart && client.gameCycle < this.animationCycleEnd) {
                        var5 = this.model;
                        var5.method5469(this.field616 - super.x, this.field610 - this.field613, this.field612 - super.y);
                        if (super.orientation == 512) {
                            var5.method5464();
                            var5.method5464();
                            var5.method5464();
                        } else if (super.orientation == 1024) {
                            var5.method5464();
                            var5.method5464();
                        } else if (super.orientation == 1536) {
                            var5.method5464();
                        }

                        var6 = new Model[]{var4, var5};
                        var4 = new Model(var6, 2);
                        if (super.orientation == 512) {
                            var5.method5464();
                        } else if (super.orientation == 1024) {
                            var5.method5464();
                            var5.method5464();
                        } else if (super.orientation == 1536) {
                            var5.method5464();
                            var5.method5464();
                            var5.method5464();
                        }

                        var5.method5469(super.x - this.field616, this.field613 - this.field610, super.y - this.field612);
                    }
                }

                var4.field1664 = true;
                return var4;
            }
        }
    }

    public List rotate(List var1, int var2) {
        ArrayList var3 = new ArrayList();
        Iterator var4 = var1.iterator();

        while (var4.hasNext()) {
            Triangle var5 = (Triangle) var4.next();
            Vertex var6 = var5.getA();
            Vertex var7 = var5.getB();
            Vertex var8 = var5.getC();
            Triangle var9 = new Triangle(var6.rotate(var2), var7.rotate(var2), var8.rotate(var2));
            var3.add(var9);
        }

        return var3;
    }

    public String getName() {
        RSName var1 = this.getRsName();
        if (var1 == null) {
            return null;
        } else {
            String var2 = var1.getName();
            return var2 == null ? null : var2.replace(' ', ' ');
        }
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
                return HeadIcon.RETRIBUTION;
            case 4:
                return HeadIcon.SMITE;
            case 5:
                return HeadIcon.REDEMPTION;
            default:
                return null;
        }
    }

    public SkullIcon getSkullIcon() {
        if (this != class166.clientInstance.getLocalPlayer()) {
            return null;
        } else {
            switch (this._protect$getRsSkullIcon()) {
                case 0:
                    return SkullIcon.SKULL;
                case 1:
                    return SkullIcon.SKULL_FIGHT_PIT;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    return null;
                case 8:
                    return SkullIcon.DEAD_MAN_FIVE;
                case 9:
                    return SkullIcon.DEAD_MAN_FOUR;
                case 10:
                    return SkullIcon.DEAD_MAN_THREE;
                case 11:
                    return SkullIcon.DEAD_MAN_TWO;
                case 12:
                    return SkullIcon.DEAD_MAN_ONE;
            }
        }
    }

    public Polygon[] getPolygons() {
        RSModel var1 = this.getModel();
        if (var1 == null) {
            return null;
        } else {
            int var2 = this.getX();
            int var3 = this.getY();
            int var4 = this.getOrientation();
            List var5 = var1.getTriangles();
            var5 = this.rotate(var5, var4);
            ArrayList var6 = new ArrayList();
            Iterator var7 = var5.iterator();

            while (var7.hasNext()) {
                Triangle var8 = (Triangle) var7.next();
                Vertex var9 = var8.getA();
                Vertex var10 = var8.getB();
                Vertex var11 = var8.getC();
                Point var12 = Perspective.localToCanvas(class166.clientInstance, new LocalPoint(var2 - var9.getX(), var3 - var9.getZ()), class166.clientInstance.getPlane(), -var9.getY());
                Point var13 = Perspective.localToCanvas(class166.clientInstance, new LocalPoint(var2 - var10.getX(), var3 - var10.getZ()), class166.clientInstance.getPlane(), -var10.getY());
                Point var14 = Perspective.localToCanvas(class166.clientInstance, new LocalPoint(var2 - var11.getX(), var3 - var11.getZ()), class166.clientInstance.getPlane(), -var11.getY());
                int[] var15 = new int[]{var12.getX(), var13.getX(), var14.getX()};
                int[] var16 = new int[]{var12.getY(), var13.getY(), var14.getY()};
                var6.add(new Polygon(var15, var16, 3));
            }

            return (Polygon[]) var6.toArray(new Polygon[var6.size()]);
        }
    }

    public RSPlayerComposition getPlayerComposition() {
        return this.composition;
    }

    public int getCombatLevel() {
        return this.combatLevel;
    }

    public int getTotalLevel() {
        return this.totalLevel;
    }

    public int getTeam() {
        return this.team;
    }

    public int getPlayerId() {
        return this.playerId;
    }

    public boolean isFriend() {
        return this.method2890();
    }

    public boolean isClanMember() {
        return this.method2893();
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "3"
    )
    void method2903() {
        this.field618 = class132.UNSET;
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)Ldl;"
    )
    protected final Model vmethod5584(int var1) {
        if (!class166.clientInstance.isInterpolatePlayerAnimations()) {
            return (Model) this.copy$getModel(var1);
        } else {
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
        }
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(IIBB)V",
            garbageValue = "50"
    )
    final void method2897(int var1, int var2, byte var3) {
        if (super.animation != -1 && MapCacheArchiveNames.method2149(super.animation).priority == 1) {
            super.animation = -1;
            this.animationChanged(-1);
        }

        super.facingCoord = -1;
        if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
            if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
                if (var3 == 2) {
                    StructType.method5724(this, var1, var2, (byte) 2);
                }

                this.method2912(var1, var2, var3);
            } else {
                this.method2927(var1, var2);
            }
        } else {
            this.method2927(var1, var2);
        }

    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "1563766353"
    )
    final boolean vmethod2900() {
        return this.composition != null;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lgl;S)V",
            garbageValue = "5987"
    )
    final void method2889(Packet var1) {
        var1.offset = 0;
        int var2 = var1.readUnsignedByte();
        this.skullIcon = var1.method6240();
        this.overheadIcon = var1.method6240();
        int var3 = -1;
        this.team = 0;
        int[] var4 = new int[12];

        int var6;
        int var7;
        for (int var5 = 0; var5 < 12; ++var5) {
            var6 = var1.readUnsignedByte();
            if (var6 == 0) {
                var4[var5] = 0;
            } else {
                var7 = var1.readUnsignedByte();
                var4[var5] = var7 + (var6 << 8);
                if (var5 == 0 && var4[0] == 65535) {
                    var3 = var1.readUnsignedShort();
                    break;
                }

                if (var4[var5] >= 512) {
                    int var8 = Varcs.method4770(var4[var5] - 512).team;
                    if (var8 != 0) {
                        this.team = var8;
                    }
                }
            }
        }

        int[] var9 = new int[5];

        for (var6 = 0; var6 < 5; ++var6) {
            var7 = var1.readUnsignedByte();
            if (var7 < 0 || var7 >= VarPlayerType.colorsToReplace[var6].length) {
                var7 = 0;
            }

            var9[var6] = var7;
        }

        super.idlePoseAnimation = var1.readUnsignedShort();
        if (super.idlePoseAnimation == 65535) {
            super.idlePoseAnimation = -1;
        }

        super.field945 = var1.readUnsignedShort();
        if (super.field945 == 65535) {
            super.field945 = -1;
        }

        super.field957 = super.field945;
        super.walkAnim = var1.readUnsignedShort();
        if (super.walkAnim == 65535) {
            super.walkAnim = -1;
        }

        super.rotate180Anim = var1.readUnsignedShort();
        if (super.rotate180Anim == 65535) {
            super.rotate180Anim = -1;
        }

        super.rotate90Anim = var1.readUnsignedShort();
        if (super.rotate90Anim == 65535) {
            super.rotate90Anim = -1;
        }

        super.rotate270Anim = var1.readUnsignedShort();
        if (super.rotate270Anim == 65535) {
            super.rotate270Anim = -1;
        }

        super.field951 = var1.readUnsignedShort();
        if (super.field951 == 65535) {
            super.field951 = -1;
        }

        this.name = new Name(var1.readString(), client.loginType);
        this.method2891();
        this.method2903();
        if (this == class4.localPlayer) {
            JagException.localPlayerUsername = this.name.method4713();
        }

        this.combatLevel = var1.readUnsignedByte();
        this.totalLevel = var1.readUnsignedShort();
        this.hidden = var1.readUnsignedByte() == 1;
        if (client.socketType == 0 && client.staffModLevel >= 2) {
            this.hidden = false;
        }

        if (this.composition == null) {
            this.composition = new PlayerComposition();
        }

        this.composition.method619(var4, var9, var2 == 1, var3);
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-982450776"
    )
    static void method2919() {
        FileOnDisk var0 = null;

        try {
            var0 = class70.method1076("", client.field646.name, true);
            Packet var1 = GameEngine.options.method6498();
            var0.method145(var1.payload, 0, var1.offset);
        } catch (Exception var3) {
            ;
        }

        try {
            if (var0 != null) {
                var0.method169(true);
            }
        } catch (Exception var2) {
            ;
        }

    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "1540177752"
    )
    static int method2936(int var0, int var1) {
        ItemContainer var2 = (ItemContainer) ItemContainer.itemContainers.method380((long) var0);
        if (var2 == null) {
            return 0;
        } else if (var1 == -1) {
            return 0;
        } else {
            int var3 = 0;

            for (int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
                if (var2.itemIds[var4] == var1) {
                    var3 += var2.stackSizes[var4];
                }
            }

            return var3;
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)Z",
            garbageValue = "-1938910227"
    )
    static boolean method2935(String var0) {
        if (var0 == null) {
            return false;
        } else {
            try {
                new URL(var0);
                return true;
            } catch (MalformedURLException var2) {
                return false;
            }
        }
    }

    @ObfuscatedName("gx")
    @ObfuscatedSignature(
            signature = "(Lbk;ZB)V",
            garbageValue = "28"
    )
    static void method2924(PlayerEntity var0, boolean var1) {
        if (var0 != null && var0.vmethod2900() && !var0.hidden) {
            var0.isLowDetail = false;
            if ((client.lowMemory && class254.highResolutionPlayerCount > 50 || class254.highResolutionPlayerCount > 200) && var1 && var0.poseAnimation == var0.idlePoseAnimation) {
                var0.isLowDetail = true;
            }

            int var2 = var0.x >> 7;
            int var3 = var0.y >> 7;
            if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
                long var4 = WorldComparator.method6484(0, 0, 0, false, var0.playerId);
                if (var0.model != null && client.gameCycle >= var0.animationCycleStart && client.gameCycle < var0.animationCycleEnd) {
                    var0.isLowDetail = false;
                    var0.field613 = MilliTimer.method2824(var0.x, var0.y, class228.level);
                    var0.field943 = client.gameCycle;
                    class131.sceneManager.method3807(class228.level, var0.x, var0.y, var0.field613, 60, var0, var0.angle, var4, var0.field608, var0.field606, var0.field621, var0.field623);
                } else {
                    if ((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                        if (client.field740[var2][var3] == client.field741) {
                            return;
                        }

                        client.field740[var2][var3] = client.field741;
                    }

                    var0.field613 = MilliTimer.method2824(var0.x, var0.y, class228.level);
                    var0.field943 = client.gameCycle;
                    class131.sceneManager.method3830(class228.level, var0.x, var0.y, var0.field613, 60, var0, var0.angle, var4, var0.field941);
                }
            }
        }

    }
}
