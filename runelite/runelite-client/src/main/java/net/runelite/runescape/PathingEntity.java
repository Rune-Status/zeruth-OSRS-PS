package net.runelite.runescape;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.Hitsplat.HitsplatType;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.mapping.*;
import net.runelite.rs.api.*;

import java.awt.*;
import java.awt.image.BufferedImage;

@ObfuscatedName("bc")
@Implements("PathingEntity")
public abstract class PathingEntity extends Entity implements RSActor {
    @ObfuscatedName("ak")
    @Export("overhead")
    String overhead;
    @ObfuscatedName("by")
    @ObfuscatedGetter(
            intValue = 526436443
    )
    @Export("spotAnimFrame")
    int spotAnimFrame;
    @ObfuscatedName("bh")
    @ObfuscatedGetter(
            intValue = 1020866043
    )
    @Export("graphic")
    int graphic;
    @ObfuscatedName("bn")
    @ObfuscatedGetter(
            intValue = 1447552453
    )
    int field982;
    @ObfuscatedName("aq")
    int[] hitsplatTypes;
    @ObfuscatedName("bb")
    @ObfuscatedGetter(
            intValue = -1760259499
    )
    int poseFrameCycle;
    @ObfuscatedName("bm")
    @ObfuscatedGetter(
            intValue = -40447171
    )
    int spotAnimFrameCycle;
    @ObfuscatedName("bs")
    int[] hitsplatValues;
    @ObfuscatedName("al")
    @ObfuscatedGetter(
            intValue = 1927938121
    )
    int field951;
    @ObfuscatedName("ae")
    @ObfuscatedGetter(
            intValue = -24202613
    )
    int x;
    @ObfuscatedName("bz")
    int[] hitsplatCycles;
    @ObfuscatedName("bg")
    @ObfuscatedGetter(
            intValue = 631282913
    )
    int actionFrameCycle;
    @ObfuscatedName("bt")
    @ObfuscatedGetter(
            intValue = 864157637
    )
    int field985;
    @ObfuscatedName("br")
    @ObfuscatedGetter(
            intValue = -726785641
    )
    int field984;
    @ObfuscatedName("bd")
    @ObfuscatedGetter(
            intValue = 2135921609
    )
    int field980;
    @ObfuscatedName("au")
    byte field938;
    @ObfuscatedName("cx")
    int[] pathX;
    @ObfuscatedName("ba")
    int[] field962;
    @ObfuscatedName("ca")
    byte[] pathTraversed;
    @ObfuscatedName("ag")
    @ObfuscatedGetter(
            intValue = 398632319
    )
    int field943;
    @ObfuscatedName("cm")
    @ObfuscatedGetter(
            intValue = -1945063659
    )
    int logicalHeight;
    @ObfuscatedName("aj")
    @ObfuscatedGetter(
            intValue = -1868216729
    )
    int size;
    @ObfuscatedName("bo")
    @ObfuscatedGetter(
            intValue = -413246047
    )
    int field983;
    @ObfuscatedName("bp")
    @ObfuscatedSignature(
            signature = "Lgb;"
    )
    CombatInfoList combatInfoList;
    @ObfuscatedName("ai")
    @ObfuscatedGetter(
            intValue = 1990495603
    )
    int rotate90Anim;
    @ObfuscatedName("cl")
    @ObfuscatedGetter(
            intValue = 452040911
    )
    int orientation;
    @ObfuscatedName("bc")
    @ObfuscatedGetter(
            intValue = 268020747
    )
    int actionFrame;
    @ObfuscatedName("bq")
    boolean field966;
    @ObfuscatedName("bk")
    @ObfuscatedGetter(
            intValue = 392725029
    )
    int poseFrame;
    @ObfuscatedName("ay")
    @ObfuscatedGetter(
            intValue = 1596833851
    )
    int overheadTextCyclesRemaining;
    @ObfuscatedName("cy")
    int[] pathY;
    @ObfuscatedName("ah")
    @ObfuscatedGetter(
            intValue = -1474705629
    )
    int field956;
    @ObfuscatedName("an")
    boolean field941;
    @ObfuscatedName("cn")
    @ObfuscatedGetter(
            intValue = 1634276535
    )
    int field959;
    @ObfuscatedName("be")
    @ObfuscatedGetter(
            intValue = -2124742131
    )
    int actionAnimationDisable;
    @ObfuscatedName("bv")
    @ObfuscatedGetter(
            intValue = -432155069
    )
    int interacting;
    @ObfuscatedName("cc")
    @ObfuscatedGetter(
            intValue = -623364045
    )
    int queueSize;
    @ObfuscatedName("at")
    @ObfuscatedGetter(
            intValue = -1128777647
    )
    int field957;
    @ObfuscatedName("am")
    boolean overheadFiltered;
    @ObfuscatedName("bf")
    @ObfuscatedGetter(
            intValue = -397485855
    )
    int poseAnimation;
    @ObfuscatedName("as")
    @ObfuscatedGetter(
            intValue = 360618217
    )
    int walkAnim;
    @ObfuscatedName("cb")
    @ObfuscatedGetter(
            intValue = -1892819399
    )
    int field977;
    @ObfuscatedName("cd")
    @ObfuscatedGetter(
            intValue = -451792057
    )
    int direction;
    @ObfuscatedName("cr")
    @ObfuscatedGetter(
            intValue = -319179321
    )
    int field991;
    @ObfuscatedName("ar")
    @ObfuscatedGetter(
            intValue = 1476385065
    )
    int field945;
    @ObfuscatedName("ad")
    @ObfuscatedGetter(
            intValue = 377819913
    )
    int rotate270Anim;
    @ObfuscatedName("bu")
    @ObfuscatedGetter(
            intValue = -1373093721
    )
    int field995;
    @ObfuscatedName("aa")
    @ObfuscatedGetter(
            intValue = 2075976071
    )
    int rotate180Anim;
    @ObfuscatedName("bx")
    @ObfuscatedGetter(
            intValue = -944052239
    )
    int graphicsDelay;
    @ObfuscatedName("bl")
    @ObfuscatedGetter(
            intValue = -70132809
    )
    int animation;
    @ObfuscatedName("az")
    @ObfuscatedGetter(
            intValue = 595798711
    )
    int angle;
    @ObfuscatedName("cg")
    @ObfuscatedGetter(
            intValue = 385055961
    )
    int lastUpdatedAt;
    @ObfuscatedName("bw")
    @ObfuscatedGetter(
            intValue = 1469516823
    )
    int facingCoord;
    @ObfuscatedName("ap")
    @ObfuscatedGetter(
            intValue = -1260337869
    )
    int field974;
    @ObfuscatedName("ac")
    @ObfuscatedGetter(
            intValue = 2109067129
    )
    int y;
    @ObfuscatedName("bi")
    int[] field963;
    @ObfuscatedName("cf")
    @ObfuscatedGetter(
            intValue = -1506666549
    )
    int field955;
    @ObfuscatedName("ce")
    @ObfuscatedGetter(
            intValue = 900647809
    )
    int field997;
    @ObfuscatedName("ab")
    @ObfuscatedGetter(
            intValue = 1653048843
    )
    int idlePoseAnimation;
    @ObfuscatedName("ao")
    boolean field958;
    @ObfuscatedName("bj")
    @ObfuscatedGetter(
            intValue = 527026085
    )
    int field975;

    PathingEntity() {
        this.field941 = false;
        this.size = 1;
        this.idlePoseAnimation = -1;
        this.field945 = -1;
        this.field957 = -1;
        this.walkAnim = -1;
        this.rotate180Anim = -1;
        this.rotate90Anim = -1;
        this.rotate270Anim = -1;
        this.field951 = -1;
        this.overhead = null;
        this.overheadFiltered = false;
        this.overheadTextCyclesRemaining = 100;
        this.field956 = 0;
        this.field974 = 0;
        this.field938 = 0;
        this.hitsplatTypes = new int[4];
        this.hitsplatValues = new int[4];
        this.hitsplatCycles = new int[4];
        this.field962 = new int[4];
        this.field963 = new int[4];
        this.combatInfoList = new CombatInfoList();
        this.interacting = -1;
        this.interactingChanged(-1);
        this.field966 = false;
        this.facingCoord = -1;
        this.poseAnimation = -1;
        this.poseFrame = 0;
        this.poseFrameCycle = 0;
        this.animation = -1;
        this.animationChanged(-1);
        this.actionFrame = 0;
        this.actionFrameCycle = 0;
        this.actionAnimationDisable = 0;
        this.field975 = 0;
        this.graphic = -1;
        this.graphicChanged(-1);
        this.spotAnimFrame = 0;
        this.spotAnimFrameCycle = 0;
        this.lastUpdatedAt = 0;
        this.logicalHeight = 200;
        this.field991 = 0;
        this.direction = 32;
        this.queueSize = 0;
        this.pathX = new int[10];
        this.pathY = new int[10];
        this.pathTraversed = new byte[10];
        this.field955 = 0;
        this.field959 = 0;
    }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "1"
    )
    final void method2712() {
        this.queueSize = 0;
        this.field959 = 0;
    }

    @ObfuscatedName("bs")
    @ObfuscatedSignature(
            signature = "(IIIIIII)V",
            garbageValue = "1556935178"
    )
    final void method2727(int var1, int var2, int var3, int var4, int var5, int var6) {
        boolean var7 = true;
        boolean var8 = true;

        int var9;
        for (var9 = 0; var9 < 4; ++var9) {
            if (this.hitsplatCycles[var9] > var5) {
                var7 = false;
            } else {
                var8 = false;
            }
        }

        var9 = -1;
        int var10 = -1;
        int var11 = 0;
        if (var1 >= 0) {
            HitmarkType var12 = class112.method1959(var1);
            var10 = var12.field3445;
            var11 = var12.field3428;
        }

        int var14;
        if (var8) {
            if (var10 == -1) {
                this.applyActorHitsplat(var1, var2, var3, var4, var5, var6);
                return;
            }

            var9 = 0;
            var14 = 0;
            if (var10 == 0) {
                var14 = this.hitsplatCycles[0];
            } else if (var10 == 1) {
                var14 = this.hitsplatValues[0];
            }

            for (int var13 = 1; var13 < 4; ++var13) {
                if (var10 == 0) {
                    if (this.hitsplatCycles[var13] < var14) {
                        var9 = var13;
                        var14 = this.hitsplatCycles[var13];
                    }
                } else if (var10 == 1 && this.hitsplatValues[var13] < var14) {
                    var9 = var13;
                    var14 = this.hitsplatValues[var13];
                }
            }

            if (var10 == 1 && var14 >= var2) {
                this.applyActorHitsplat(var1, var2, var3, var4, var5, var6);
                return;
            }
        } else {
            if (var7) {
                this.field938 = 0;
            }

            for (var14 = 0; var14 < 4; ++var14) {
                byte var15 = this.field938;
                this.field938 = (byte) ((this.field938 + 1) % 4);
                if (this.hitsplatCycles[var15] <= var5) {
                    var9 = var15;
                    break;
                }
            }
        }

        if (var9 < 0) {
            this.applyActorHitsplat(var1, var2, var3, var4, var5, var6);
        } else {
            this.hitsplatTypes[var9] = var1;
            this.hitsplatValues[var9] = var2;
            this.field962[var9] = var3;
            this.field963[var9] = var4;
            this.hitsplatCycles[var9] = var5 + var11 + var6;
            this.applyActorHitsplat(var1, var2, var3, var4, var5, var6);
        }
    }

    @ObfuscatedName("bz")
    @ObfuscatedSignature(
            signature = "(IIIIIII)V",
            garbageValue = "-49087894"
    )
    final void method2729(int var1, int var2, int var3, int var4, int var5, int var6) {
        this.setCombatInfo(var1, var2, var3, var4, var5, var6);
        HeadbarType var7 = class208.method4121(var1);
        CombatInfoListHolder var8 = null;
        CombatInfoListHolder var9 = null;
        int var10 = var7.field3386;
        int var11 = 0;

        CombatInfoListHolder var12;
        for (var12 = (CombatInfoListHolder) this.combatInfoList.method4329(); var12 != null; var12 = (CombatInfoListHolder) this.combatInfoList.method4327()) {
            ++var11;
            if (var12.headbar.field3383 == var7.field3383) {
                var12.method1492(var2 + var4, var5, var6, var3);
                return;
            }

            if (var12.headbar.field3391 <= var7.field3391) {
                var8 = var12;
            }

            if (var12.headbar.field3386 > var10) {
                var9 = var12;
                var10 = var12.headbar.field3386;
            }
        }

        if (var9 != null || var11 < 4) {
            var12 = new CombatInfoListHolder(var7);
            if (var8 == null) {
                this.combatInfoList.method4325(var12);
            } else {
                CombatInfoList.method4324(var12, var8);
            }

            var12.method1492(var2 + var4, var5, var6, var3);
            if (var11 >= 4) {
                var9.method6469();
            }

        }
    }

    @ObfuscatedName("ba")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-171357995"
    )
    final void method2715(int var1) {
        HeadbarType var2 = class208.method4121(var1);

        for (CombatInfoListHolder var3 = (CombatInfoListHolder) this.combatInfoList.method4329(); var3 != null; var3 = (CombatInfoListHolder) this.combatInfoList.method4327()) {
            if (var2 == var3.headbar) {
                var3.method6469();
                return;
            }
        }

    }

    public void setCombatInfo(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (var5 == 0) {
            if (this == class166.clientInstance.getLocalPlayer()) {
                class166.clientInstance.getLogger().debug("You died!");
                LocalPlayerDeath var7 = new LocalPlayerDeath();
                class166.clientInstance.getCallbacks().post(var7);
            } else if (this instanceof RSNPC) {
                ((RSNPC) this).setDead(true);
            }
        }

    }

    public RSCombatInfoList getCombatInfoList() {
        return this.combatInfoList;
    }

    public int getRSInteracting() {
        return this.interacting;
    }

    public int _protect$getRsAnimation/* $FF was: 1protect$getRsAnimation*/() {
        return this.animation;
    }

    public int getX() {
        return this.x;
    }

    public Actor getInteracting() {
        int var1 = this.getRSInteracting();
        if (var1 != -1 && var1 != 65535) {
            if (var1 < 32768) {
                RSNPC[] var3 = class166.clientInstance.getCachedNPCs();
                return var3[var1];
            } else {
                var1 -= 32768;
                RSPlayer[] var2 = class166.clientInstance.getCachedPlayers();
                return var2[var1];
            }
        } else {
            return null;
        }
    }

    public int[] getPathX() {
        return this.pathX;
    }

    public WorldPoint getWorldLocation() {
        return WorldPoint.fromLocal(class166.clientInstance, this.getPathX()[0] * 128 + 64, this.getPathY()[0] * 128 + 64, class166.clientInstance.getPlane());
    }

    public LocalPoint getLocalLocation() {
        return new LocalPoint(this.getX(), this.getY());
    }

    public int getY() {
        return this.y;
    }

    public int getAnimation() {
        int var1 = this._protect$getRsAnimation();
        switch (var1) {
            case 7952:
            case 7953:
            case 8059:
            case 8123:
            case 8124:
            case 8125:
            case 8126:
            case 8127:
            case 8234:
            case 8235:
            case 8236:
            case 8237:
            case 8238:
            case 8241:
            case 8242:
            case 8243:
            case 8244:
            case 8245:
            case 8248:
            case 8249:
            case 8250:
            case 8251:
            case 8252:
            case 8255:
            case 8256:
            case 8257:
            case 8258:
                return -1;
            default:
                return var1;
        }
    }

    public int getActionFrame() {
        return this.actionFrame;
    }

    public void applyActorHitsplat(int var1, int var2, int var3, int var4, int var5, int var6) {
        Hitsplat var7 = new Hitsplat(HitsplatType.fromInteger(var1), var2, var5 + var6);
        HitsplatApplied var8 = new HitsplatApplied();
        var8.setActor(this);
        var8.setHitsplat(var7);
        class166.clientInstance.getCallbacks().post(var8);
    }

    public int[] getPathY() {
        return this.pathY;
    }

    public int getPoseFrame() {
        return this.poseFrame;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public int getSpotAnimFrame() {
        return this.spotAnimFrame;
    }

    public int getActionFrameCycle() {
        return this.actionFrameCycle;
    }

    public void setActionFrame(int var1) {
        this.actionFrame = var1;
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public void animationChanged(int var1) {
        if (this instanceof RSNPC) {
            int var2 = ((RSNPC) this).getId();
            switch (var2) {
                case 8615:
                case 8616:
                case 8617:
                case 8618:
                case 8619:
                case 8620:
                case 8621:
                case 8622:
                    return;
            }
        }

        AnimationChanged var3 = new AnimationChanged();
        var3.setActor(this);
        class166.clientInstance.getCallbacks().post(var3);
    }

    public void setPoseFrame(int var1) {
        this.poseFrame = var1;
    }

    public int getPoseFrameCycle() {
        return this.poseFrameCycle;
    }

    public void setSpotAnimFrame(int var1) {
        this.spotAnimFrame = var1;
    }

    public int getSpotAnimFrameCycle() {
        return this.spotAnimFrameCycle;
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public void interactingChanged(int var1) {
        InteractingChanged var2 = new InteractingChanged(this, this.getInteracting());
        class166.clientInstance.getCallbacks().post(var2);
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public void graphicChanged(int var1) {
        if (this == class166.clientInstance.getLocalPlayer()) {
            GraphicChanged var2 = new GraphicChanged();
            var2.setActor(this);
            class166.clientInstance.getCallbacks().post(var2);
        }
    }

    public int getHealthRatio() {
        RSCombatInfoList var1 = this.getCombatInfoList();
        if (var1 != null) {
            RSNode var2 = var1.getNode();
            RSNode var3 = var2.getNext();
            if (var3 instanceof RSCombatInfoListHolder) {
                RSCombatInfoListHolder var4 = (RSCombatInfoListHolder) var3;
                RSCombatInfoList var5 = var4.getCombatInfo1();
                RSNode var6 = var5.getNode();
                RSNode var7 = var6.getNext();
                if (var7 instanceof RSCombatInfo1) {
                    RSCombatInfo1 var8 = (RSCombatInfo1) var7;
                    return var8.getHealthRatio();
                }
            }
        }

        return -1;
    }

    public int getHealth() {
        RSCombatInfoList var1 = this.getCombatInfoList();
        if (var1 != null) {
            RSNode var2 = var1.getNode();
            RSNode var3 = var2.getNext();
            if (var3 instanceof RSCombatInfoListHolder) {
                RSCombatInfoListHolder var4 = (RSCombatInfoListHolder) var3;
                RSCombatInfo2 var5 = var4.getCombatInfo2();
                return var5.getHealthScale();
            }
        }

        return -1;
    }

    public Polygon getCanvasTilePoly() {
        return Perspective.getCanvasTilePoly(class166.clientInstance, this.getLocalLocation());
    }

    public Point getCanvasTextLocation(Graphics2D var1, String var2, int var3) {
        return Perspective.getCanvasTextLocation(class166.clientInstance, var1, this.getLocalLocation(), var2, var3);
    }

    public Point getCanvasImageLocation(BufferedImage var1, int var2) {
        return Perspective.getCanvasImageLocation(class166.clientInstance, this.getLocalLocation(), var1, var2);
    }

    public Point getCanvasSpriteLocation(net.runelite.api.SpritePixels var1, int var2) {
        return Perspective.getCanvasSpriteLocation(class166.clientInstance, this.getLocalLocation(), var1, var2);
    }

    public Point getMinimapLocation() {
        return Perspective.localToMinimap(class166.clientInstance, this.getLocalLocation());
    }

    public Polygon getConvexHull() {
        RSModel var1 = this.getModel();
        return var1 == null ? null : var1.getConvexHull(this.getX(), this.getY(), this.getOrientation());
    }

    public WorldArea getWorldArea() {
        int var1 = 1;
        if (this instanceof NPC) {
            NPCComposition var2 = ((NPC) this).getComposition();
            if (var2 != null && var2.getConfigs() != null) {
                var2 = var2.transform();
            }

            if (var2 != null) {
                var1 = var2.getSize();
            }
        }

        return new WorldArea(this.getWorldLocation(), var1, var1);
    }

    public void setIdlePoseAnimation(int var1) {
        this.idlePoseAnimation = var1;
    }

    public String getOverhead() {
        return this.overhead;
    }

    public int[] getHitsplatTypes() {
        return this.hitsplatTypes;
    }

    public int[] getHitsplatValues() {
        return this.hitsplatValues;
    }

    public int[] getHitsplatCycles() {
        return this.hitsplatCycles;
    }

    public void setPoseAnimation(int var1) {
        this.poseAnimation = var1;
    }

    public void setAnimation(int var1) {
        this.animation = var1;
    }

    public void setGraphic(int var1) {
        this.graphic = var1;
    }

    public int getGraphic() {
        return this.graphic;
    }

    public int getLogicalHeight() {
        return this.logicalHeight;
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "1563766353"
    )
    boolean vmethod2900() {
        return false;
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "701091352"
    )
    static final int method2730() {
        return class195.Viewport_mouseY;
    }
}
