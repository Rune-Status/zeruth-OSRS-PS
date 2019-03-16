package net.runelite.runescape;

import net.runelite.api.Point;
import net.runelite.api.WidgetNode;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetPositioned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@ObfuscatedName("hn")
@Implements("ComponentType")
public class ComponentType extends Node implements RSWidget {
    @ObfuscatedName("v")
    public static boolean field2665;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    public static Js5Index componentIndex;
    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache field2664;
    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache field2661;
    // $FF: synthetic field
    public static boolean $assertionsDisabled;
    public static int rl$widgetLastPosChanged;
    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache componentModelCache;
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    public static NodeCache componentFontCache;
    @ObfuscatedName("ak")
    @ObfuscatedGetter(
            intValue = -325575893
    )
    public int field2693;
    @ObfuscatedName("ek")
    @ObfuscatedGetter(
            intValue = -1905311775
    )
    public int linkObjCount;
    @ObfuscatedName("by")
    @ObfuscatedGetter(
            intValue = 2142098573
    )
    public int yan2d;
    @ObfuscatedName("bh")
    @ObfuscatedGetter(
            intValue = 1021965
    )
    public int xan2d;
    @ObfuscatedName("f")
    @ObfuscatedGetter(
            intValue = 696118001
    )
    public int id;
    @ObfuscatedName("bn")
    public boolean orthogonal;
    @ObfuscatedName("dn")
    public Object[] onClickListener;
    @ObfuscatedName("cq")
    public int[] opKeyRates;
    @ObfuscatedName("fh")
    @ObfuscatedGetter(
            intValue = 1543061857
    )
    public int field2802;
    @ObfuscatedName("aq")
    public boolean lineDirection;
    @ObfuscatedName("dh")
    public String targetVerb;
    @ObfuscatedName("eq")
    public int[] objCounts;
    @ObfuscatedName("bb")
    @ObfuscatedGetter(
            intValue = 855253673
    )
    int field2687;
    @ObfuscatedName("dy")
    public int[] statTransmitTriggers;
    @ObfuscatedName("db")
    public int[] invTransmitTriggers;
    @ObfuscatedName("ew")
    @ObfuscatedGetter(
            intValue = -828224351
    )
    public int field2788;
    @ObfuscatedName("di")
    public Object[] onInvTransmitListener;
    @ObfuscatedName("bm")
    @ObfuscatedGetter(
            intValue = 30895243
    )
    public int zan2d;
    @ObfuscatedName("af")
    @ObfuscatedGetter(
            intValue = 1864898849
    )
    public int posX;
    @ObfuscatedName("ef")
    @ObfuscatedSignature(
            signature = "[Lhn;"
    )
    public ComponentType[] children;
    @ObfuscatedName("bs")
    @ObfuscatedGetter(
            intValue = 907931641
    )
    public int graphic;
    @ObfuscatedName("al")
    @ObfuscatedGetter(
            intValue = -1361071379
    )
    public int color;
    @ObfuscatedName("ae")
    @ObfuscatedGetter(
            intValue = -1664963415
    )
    public int x;
    @ObfuscatedName("k")
    @ObfuscatedGetter(
            intValue = 1429953277
    )
    public int buttonType;
    @ObfuscatedName("dc")
    @ObfuscatedGetter(
            intValue = 432230929
    )
    public int dragDeadZone;
    @ObfuscatedName("el")
    public Object[] onChatTransmitListener;
    @ObfuscatedName("bz")
    @ObfuscatedGetter(
            intValue = -1066879207
    )
    public int field2703;
    @ObfuscatedName("fg")
    @ObfuscatedGetter(
            intValue = -1702465919
    )
    public int field2735;
    @ObfuscatedName("bg")
    @ObfuscatedGetter(
            intValue = 590120945
    )
    public int field2715;
    @ObfuscatedName("bt")
    @ObfuscatedGetter(
            intValue = 1002425369
    )
    public int fontId;
    @ObfuscatedName("er")
    public String spellName;
    @ObfuscatedName("ft")
    @ObfuscatedGetter(
            intValue = 1101894003
    )
    public int field2801;
    @ObfuscatedName("ee")
    public Object[] onStockTransmitListener;
    @ObfuscatedName("dd")
    public Object[] onTimerListener;
    @ObfuscatedName("ed")
    public int[] field2778;
    @ObfuscatedName("br")
    @ObfuscatedGetter(
            intValue = 466178695
    )
    public int objNumMode;
    @ObfuscatedName("du")
    public Object[] onHoldListener;
    @ObfuscatedName("bd")
    @ObfuscatedGetter(
            intValue = -1723492419
    )
    public int field2722;
    @ObfuscatedName("au")
    @ObfuscatedGetter(
            intValue = -1064040161
    )
    public int lineWidth;
    @ObfuscatedName("ea")
    public int[] objIds;
    @ObfuscatedName("cx")
    public int[] xSprites;
    @ObfuscatedName("ba")
    @ObfuscatedGetter(
            intValue = -1470168529
    )
    public int angle2d;
    @ObfuscatedName("ca")
    public int[] field2738;
    @ObfuscatedName("ag")
    @ObfuscatedGetter(
            intValue = -917375071
    )
    public int field2684;
    @ObfuscatedName("cz")
    public String opBase;
    @ObfuscatedName("em")
    public Object[] onMiscTransmitListener;
    @ObfuscatedName("cm")
    @ObfuscatedGetter(
            intValue = 746061609
    )
    public int horizTextAlign;
    @ObfuscatedName("aj")
    @ObfuscatedGetter(
            intValue = 1802193923
    )
    public int height;
    @ObfuscatedName("dr")
    public Object[] onLoadListener;
    @ObfuscatedName("aw")
    @ObfuscatedGetter(
            intValue = 1489227841
    )
    public int sizeY;
    @ObfuscatedName("bo")
    @ObfuscatedGetter(
            intValue = -1247893073
    )
    public int field2723;
    @ObfuscatedName("cj")
    public int[] field2745;
    @ObfuscatedName("ep")
    @ObfuscatedGetter(
            intValue = 1632954823
    )
    public int field2750;
    @ObfuscatedName("o")
    @ObfuscatedGetter(
            intValue = 1425143017
    )
    public int sizeYmode;
    @ObfuscatedName("fi")
    @ObfuscatedGetter(
            intValue = 1793337659
    )
    public int boundsIndex;
    @ObfuscatedName("bp")
    @ObfuscatedGetter(
            intValue = 84398225
    )
    public int outline;
    @ObfuscatedName("a")
    @ObfuscatedGetter(
            intValue = -1904429175
    )
    public int index;
    @ObfuscatedName("ai")
    @ObfuscatedGetter(
            intValue = 250752673
    )
    public int scrollWidth;
    @ObfuscatedName("z")
    @ObfuscatedGetter(
            intValue = 1953628677
    )
    public int clientcode;
    @ObfuscatedName("df")
    public Object[] onVarTransmitListener;
    @ObfuscatedName("ds")
    public int[] varTransmitTriggers;
    @ObfuscatedName("av")
    @ObfuscatedGetter(
            intValue = 436126017
    )
    public int field2699;
    @ObfuscatedName("cl")
    @ObfuscatedGetter(
            intValue = 1190355705
    )
    public int vertTextAlign;
    @ObfuscatedName("bc")
    @ObfuscatedGetter(
            intValue = 470346601
    )
    public int animation;
    @ObfuscatedName("bq")
    public boolean vflip;
    @ObfuscatedName("dg")
    public Object[] onClickRepeatListener;
    @ObfuscatedName("dt")
    public Object[] onReleaseListener;
    @ObfuscatedName("fw")
    @ObfuscatedGetter(
            intValue = -569810793
    )
    public int field2800;
    @ObfuscatedName("eb")
    public Object[] onOpListener;
    @ObfuscatedName("eo")
    @ObfuscatedGetter(
            intValue = 1774159465
    )
    public int field2795;
    @ObfuscatedName("bk")
    @ObfuscatedGetter(
            intValue = 6594339
    )
    public int modelId;
    @ObfuscatedName("dk")
    public boolean dragRenderBehavior;
    @ObfuscatedName("t")
    @ObfuscatedGetter(
            intValue = -502932991
    )
    public int type;
    @ObfuscatedName("ay")
    public boolean filled;
    @ObfuscatedName("cy")
    public int[] field2737;
    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            signature = "Llx;"
    )
    public class271 field2744;
    @ObfuscatedName("an")
    @ObfuscatedGetter(
            intValue = -362475851
    )
    public int posY;
    public int rl$x;
    public int rl$y;
    public int rl$parentId;
    @ObfuscatedName("cn")
    @ObfuscatedGetter(
            intValue = -2056532645
    )
    public int activeProperties;
    @ObfuscatedName("en")
    public int[][] dynamicValues;
    @ObfuscatedName("be")
    @ObfuscatedGetter(
            intValue = -944862475
    )
    public int offsetX2d;
    @ObfuscatedName("de")
    public Object[] onStatTransmitListener;
    @ObfuscatedName("dv")
    public Object[] onTargetLeaveListener;
    @ObfuscatedName("bv")
    @ObfuscatedGetter(
            intValue = 1627635657
    )
    public int shadow;
    @ObfuscatedName("cc")
    @ObfuscatedGetter(
            intValue = 1402010303
    )
    public int paddingY;
    @ObfuscatedName("ec")
    public Object[] onDialogAbortListener;
    @ObfuscatedName("ct")
    public byte[][] opKeys;
    @ObfuscatedName("at")
    public boolean isHidden;
    @ObfuscatedName("y")
    @ObfuscatedGetter(
            intValue = -1570465005
    )
    public int posYmode;
    @ObfuscatedName("et")
    public boolean field2798;
    @ObfuscatedName("fe")
    public boolean noScrollThrough;
    @ObfuscatedName("dp")
    public Object[] onMouseOverListener;
    @ObfuscatedName("dw")
    public Object[] onDragCompleteListener;
    @ObfuscatedName("am")
    @ObfuscatedGetter(
            intValue = 949681885
    )
    public int field2695;
    @ObfuscatedName("ez")
    public Object[] onResizeListener;
    @ObfuscatedName("ff")
    public boolean field2669;
    @ObfuscatedName("bf")
    @ObfuscatedGetter(
            intValue = 1007971767
    )
    public int modelType;
    @ObfuscatedName("as")
    @ObfuscatedGetter(
            intValue = 506972141
    )
    public int scrollX;
    @ObfuscatedName("es")
    public Object[] onCamFinishedListener;
    @ObfuscatedName("ax")
    @ObfuscatedGetter(
            intValue = -125360395
    )
    public int sizeX;
    @ObfuscatedName("dq")
    public Object[] onMouseRepeatListener;
    @ObfuscatedName("cb")
    public String text;
    @ObfuscatedName("ey")
    public Object[] onFriendTransmitListener;
    @ObfuscatedName("co")
    public boolean field2724;
    @ObfuscatedName("dj")
    public boolean hasHook;
    @ObfuscatedName("cd")
    @ObfuscatedGetter(
            intValue = 507021643
    )
    public int paddingX;
    @ObfuscatedName("cr")
    public boolean textShadow;
    @ObfuscatedName("ar")
    @ObfuscatedGetter(
            intValue = 599220707
    )
    public int layer;
    @ObfuscatedName("ad")
    @ObfuscatedGetter(
            intValue = 1461286313
    )
    public int scrollHeight;
    @ObfuscatedName("bu")
    public boolean field2725;
    @ObfuscatedName("eu")
    public Object[] onClanTransmitListener;
    @ObfuscatedName("da")
    @ObfuscatedSignature(
            signature = "Lhn;"
    )
    public ComponentType dragParent;
    @ObfuscatedName("aa")
    @ObfuscatedGetter(
            intValue = 22200319
    )
    public int scrollY;
    @ObfuscatedName("ex")
    public Object[] onKeyListener;
    @ObfuscatedName("dx")
    public Object[] onMouseLeaveListener;
    @ObfuscatedName("fa")
    @ObfuscatedGetter(
            intValue = 1855012147
    )
    public int loopCycle;
    @ObfuscatedName("ej")
    public String tooltip;
    @ObfuscatedName("bx")
    @ObfuscatedGetter(
            intValue = -1963771203
    )
    public int zoom2d;
    @ObfuscatedName("dl")
    public Object[] onTargetEnterListener;
    @ObfuscatedName("s")
    @ObfuscatedGetter(
            intValue = -924788349
    )
    public int posXmode;
    @ObfuscatedName("bl")
    @ObfuscatedGetter(
            intValue = 11017437
    )
    int field2692;
    @ObfuscatedName("az")
    @ObfuscatedGetter(
            intValue = 1703863427
    )
    public int width;
    @ObfuscatedName("eg")
    public Object[] onSubChangeListener;
    @ObfuscatedName("cg")
    @ObfuscatedGetter(
            intValue = -1307207289
    )
    public int lineHeight;
    @ObfuscatedName("fr")
    public int[] opKeysIgnoreHeld;
    @ObfuscatedName("do")
    public Object[] onDragListener;
    @ObfuscatedName("bw")
    public boolean hflip;
    @ObfuscatedName("fp")
    public boolean noClickThrough;
    @ObfuscatedName("ei")
    public Object[] onScrollWheelListener;
    @ObfuscatedName("ap")
    @ObfuscatedGetter(
            intValue = 6532117
    )
    public int trans;
    @ObfuscatedName("ac")
    @ObfuscatedGetter(
            intValue = -1822854351
    )
    public int y;
    @ObfuscatedName("bi")
    public boolean tile;
    @ObfuscatedName("cf")
    public String[] if1Ops;
    @ObfuscatedName("h")
    public boolean isIf3;
    @ObfuscatedName("cs")
    public byte[][] opKeyModifiers;
    @ObfuscatedName("ev")
    public int[] tableActions;
    @ObfuscatedName("u")
    @ObfuscatedGetter(
            intValue = 175746743
    )
    public int sizeXmode;
    @ObfuscatedName("ce")
    public String string1;
    @ObfuscatedName("eh")
    @ObfuscatedGetter(
            intValue = -1365167471
    )
    public int linkObjType;
    @ObfuscatedName("ab")
    @ObfuscatedGetter(
            intValue = -1005174581
    )
    public int field2668;
    @ObfuscatedName("ao")
    @ObfuscatedGetter(
            intValue = -1567341845
    )
    public int field2694;
    @ObfuscatedName("dm")
    public String[] ops;
    @ObfuscatedName("dz")
    @ObfuscatedGetter(
            intValue = 979493751
    )
    public int dragDeadTime;
    @ObfuscatedName("bj")
    @ObfuscatedGetter(
            intValue = 1570513795
    )
    public int offsetY2d;

    static {
        field2661 = new NodeCache(200);
        componentModelCache = new NodeCache(50);
        componentFontCache = new NodeCache(20);
        field2664 = new NodeCache(8);
        field2665 = false;
        rl$$clinit();
    }

    public ComponentType() {
        this.isIf3 = false;
        this.id = -1;
        this.index = -1;
        this.buttonType = 0;
        this.clientcode = 0;
        this.posXmode = 0;
        this.posYmode = 0;
        this.sizeXmode = 0;
        this.sizeYmode = 0;
        this.posX = 0;
        this.posY = 0;
        this.sizeX = 0;
        this.sizeY = 0;
        this.x = 0;
        this.y = 0;
        this.onPositionChanged(-1);
        this.width = 0;
        this.height = 0;
        this.field2684 = 1;
        this.field2668 = 1;
        this.layer = -1;
        this.isHidden = false;
        this.onHiddenChanged(-1);
        this.scrollX = 0;
        this.scrollY = 0;
        this.scrollWidth = 0;
        this.scrollHeight = 0;
        this.color = 0;
        this.field2693 = 0;
        this.field2694 = 0;
        this.field2695 = 0;
        this.filled = false;
        this.field2744 = class271.field3866;
        this.trans = 0;
        this.field2699 = 0;
        this.lineWidth = 1;
        this.lineDirection = false;
        this.graphic = -1;
        this.field2703 = -1;
        this.angle2d = 0;
        this.tile = false;
        this.outline = 0;
        this.shadow = 0;
        this.modelType = 1;
        this.modelId = -1;
        this.field2687 = 1;
        this.field2692 = -1;
        this.animation = -1;
        this.field2715 = -1;
        this.offsetX2d = 0;
        this.offsetY2d = 0;
        this.xan2d = 0;
        this.yan2d = 0;
        this.zan2d = 0;
        this.zoom2d = 100;
        this.field2722 = 0;
        this.field2723 = 0;
        this.orthogonal = false;
        this.field2725 = false;
        this.objNumMode = 2;
        this.fontId = -1;
        this.text = "";
        this.string1 = "";
        this.lineHeight = 0;
        this.horizTextAlign = 0;
        this.vertTextAlign = 0;
        this.textShadow = false;
        this.paddingX = 0;
        this.paddingY = 0;
        this.activeProperties = 0;
        this.field2724 = false;
        this.opBase = "";
        this.dragParent = null;
        this.dragDeadZone = 0;
        this.dragDeadTime = 0;
        this.dragRenderBehavior = false;
        this.targetVerb = "";
        this.hasHook = false;
        this.field2788 = -1;
        this.spellName = "";
        this.tooltip = "Ok";
        this.linkObjType = -1;
        this.linkObjCount = 0;
        this.field2795 = 0;
        this.field2750 = 0;
        this.field2798 = false;
        this.field2669 = false;
        this.field2800 = -1;
        this.field2801 = 0;
        this.field2802 = 0;
        this.field2735 = 0;
        this.boundsIndex = -1;
        this.loopCycle = -1;
        this.noClickThrough = false;
        this.noScrollThrough = false;
        this.rl$$init();
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(Ljg;IZLhi;B)Ldl;",
            garbageValue = "70"
    )
    public Model method235(Sequence var1, int var2, boolean var3, PlayerComposition var4) {
        field2665 = false;
        int var5;
        int var6;
        if (var3) {
            var5 = this.field2687;
            var6 = this.field2692;
        } else {
            var5 = this.modelType;
            var6 = this.modelId;
        }

        if (var5 == 0) {
            return null;
        } else if (var5 == 1 && var6 == -1) {
            return null;
        } else {
            Model var7 = (Model) componentModelCache.method951((long) (var6 + (var5 << 16)));
            if (var7 == null) {
                ModelData var8;
                if (var5 == 1) {
                    var8 = ModelData.method1479(Frames.field1858, var6, 0);
                    if (var8 == null) {
                        field2665 = true;
                        return null;
                    }

                    var7 = var8.method1408(64, 768, -50, -10, -50);
                }

                if (var5 == 2) {
                    var8 = FileRequest.method4030(var6).method5870();
                    if (var8 == null) {
                        field2665 = true;
                        return null;
                    }

                    var7 = var8.method1408(64, 768, -50, -10, -50);
                }

                if (var5 == 3) {
                    if (var4 == null) {
                        return null;
                    }

                    var8 = var4.method626();
                    if (var8 == null) {
                        field2665 = true;
                        return null;
                    }

                    var7 = var8.method1408(64, 768, -50, -10, -50);
                }

                if (var5 == 4) {
                    ObjType var9 = Varcs.method4770(var6);
                    var8 = var9.method6364(10);
                    if (var8 == null) {
                        field2665 = true;
                        return null;
                    }

                    var7 = var8.method1408(var9.ambient + 64, var9.contrast * 5 + 768, -50, -10, -50);
                }

                componentModelCache.method957(var7, (long) (var6 + (var5 << 16)));
            }

            if (var1 != null) {
                var7 = var1.method4775(var7, var2);
            }

            return var7;
        }
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(I)Lkz;",
            garbageValue = "-600287239"
    )
    public Font method233() {
        field2665 = false;
        if (this.fontId == -1) {
            return null;
        } else {
            Font var1 = (Font) componentFontCache.method951((long) this.fontId);
            if (var1 != null) {
                return var1;
            } else {
                Js5Index var3 = ChatPlayer.field3709;
                Js5Index var4 = MapIcon.field282;
                int var5 = this.fontId;
                Font var2;
                if (!WorldMapRectangle.method128(var3, var5, 0)) {
                    var2 = null;
                } else {
                    byte[] var7 = var4.method1516(var5, 0, 1789634852);
                    Font var6;
                    if (var7 == null) {
                        var6 = null;
                    } else {
                        Font var8 = new Font(var7, class95.indexedSpriteOffsetXs, class95.indexedSpriteOffsetYs, class95.indexSpriteWidths, VarClientType.indexedSpriteHeights, class95.indexedSpritePalette, class95.spritePixels);
                        class95.indexedSpriteOffsetXs = null;
                        class95.indexedSpriteOffsetYs = null;
                        class95.indexSpriteWidths = null;
                        VarClientType.indexedSpriteHeights = null;
                        class95.indexedSpritePalette = null;
                        class95.spritePixels = null;
                        var6 = var8;
                    }

                    var2 = var6;
                }

                if (var2 != null) {
                    componentFontCache.method957(var2, (long) this.fontId);
                } else {
                    field2665 = true;
                }

                return var2;
            }
        }
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(ZI)Lls;"
    )
    public SpritePixels method266(boolean var1, int var2) {
        if (this.getSpriteId() != -1) {
            net.runelite.api.SpritePixels var3 = (net.runelite.api.SpritePixels) client.widgetSpriteOverrides.get(Integer.valueOf(this.getId()));
            if (var3 != null) {
                return (SpritePixels) ((RSSpritePixels) var3);
            }
        }

        return (SpritePixels) this.copy$getWidgetSprite(var1, var2);
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(Lgl;I)[Ljava/lang/Object;",
            garbageValue = "1475274853"
    )
    Object[] method229(Packet var1) {
        int var2 = var1.readUnsignedByte();
        if (var2 == 0) {
            return null;
        } else {
            Object[] var3 = new Object[var2];

            for (int var4 = 0; var4 < var2; ++var4) {
                int var5 = var1.readUnsignedByte();
                if (var5 == 0) {
                    var3[var4] = new Integer(var1.getInt());
                } else if (var5 == 1) {
                    var3[var4] = var1.readString();
                }
            }

            this.hasHook = true;
            return var3;
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "1861759842"
    )
    void method226(Packet var1) {
        var1.readUnsignedByte();
        this.isIf3 = true;
        this.type = var1.readUnsignedByte();
        this.clientcode = var1.readUnsignedShort();
        this.posX = var1.method6123();
        this.posY = var1.method6123();
        this.sizeX = var1.readUnsignedShort();
        if (this.type == 9) {
            this.sizeY = var1.method6123();
        } else {
            this.sizeY = var1.readUnsignedShort();
        }

        this.sizeXmode = var1.method6240();
        this.sizeYmode = var1.method6240();
        this.posXmode = var1.method6240();
        this.posYmode = var1.method6240();
        this.layer = var1.readUnsignedShort();
        if (this.layer == 65535) {
            this.layer = -1;
        } else {
            this.layer += this.id & -65536;
        }

        this.isHidden = var1.readUnsignedByte() == 1;
        this.onHiddenChanged(-1);
        if (this.type == 0) {
            this.scrollWidth = var1.readUnsignedShort();
            this.scrollHeight = var1.readUnsignedShort();
            this.noClickThrough = var1.readUnsignedByte() == 1;
        }

        if (this.type == 5) {
            this.graphic = var1.getInt();
            this.angle2d = var1.readUnsignedShort();
            this.tile = var1.readUnsignedByte() == 1;
            this.trans = var1.readUnsignedByte();
            this.outline = var1.readUnsignedByte();
            this.shadow = var1.getInt();
            this.vflip = var1.readUnsignedByte() == 1;
            this.hflip = var1.readUnsignedByte() == 1;
        }

        if (this.type == 6) {
            this.modelType = 1;
            this.modelId = var1.readUnsignedShort();
            if (this.modelId == 65535) {
                this.modelId = -1;
            }

            this.offsetX2d = var1.method6123();
            this.offsetY2d = var1.method6123();
            this.xan2d = var1.readUnsignedShort();
            this.yan2d = var1.readUnsignedShort();
            this.zan2d = var1.readUnsignedShort();
            this.zoom2d = var1.readUnsignedShort();
            this.animation = var1.readUnsignedShort();
            if (this.animation == 65535) {
                this.animation = -1;
            }

            this.orthogonal = var1.readUnsignedByte() == 1;
            var1.readUnsignedShort();
            if (this.sizeXmode != 0) {
                this.field2722 = var1.readUnsignedShort();
            }

            if (this.sizeYmode != 0) {
                var1.readUnsignedShort();
            }
        }

        if (this.type == 4) {
            this.fontId = var1.readUnsignedShort();
            if (this.fontId == 65535) {
                this.fontId = -1;
            }

            this.text = var1.readString();
            this.lineHeight = var1.readUnsignedByte();
            this.horizTextAlign = var1.readUnsignedByte();
            this.vertTextAlign = var1.readUnsignedByte();
            this.textShadow = var1.readUnsignedByte() == 1;
            this.color = var1.getInt();
        }

        if (this.type == 3) {
            this.color = var1.getInt();
            this.filled = var1.readUnsignedByte() == 1;
            this.trans = var1.readUnsignedByte();
        }

        if (this.type == 9) {
            this.lineWidth = var1.readUnsignedByte();
            this.color = var1.getInt();
            this.lineDirection = var1.readUnsignedByte() == 1;
        }

        this.activeProperties = var1.method6082();
        this.opBase = var1.readString();
        int var2 = var1.readUnsignedByte();
        if (var2 > 0) {
            this.ops = new String[var2];

            for (int var3 = 0; var3 < var2; ++var3) {
                this.ops[var3] = var1.readString();
            }
        }

        this.dragDeadZone = var1.readUnsignedByte();
        this.dragDeadTime = var1.readUnsignedByte();
        this.dragRenderBehavior = var1.readUnsignedByte() == 1;
        this.targetVerb = var1.readString();
        this.onLoadListener = this.method229(var1);
        this.onMouseOverListener = this.method229(var1);
        this.onMouseLeaveListener = this.method229(var1);
        this.onTargetLeaveListener = this.method229(var1);
        this.onTargetEnterListener = this.method229(var1);
        this.onVarTransmitListener = this.method229(var1);
        this.onInvTransmitListener = this.method229(var1);
        this.onStatTransmitListener = this.method229(var1);
        this.onTimerListener = this.method229(var1);
        this.onOpListener = this.method229(var1);
        this.onMouseRepeatListener = this.method229(var1);
        this.onClickListener = this.method229(var1);
        this.onClickRepeatListener = this.method229(var1);
        this.onReleaseListener = this.method229(var1);
        this.onHoldListener = this.method229(var1);
        this.onDragListener = this.method229(var1);
        this.onDragCompleteListener = this.method229(var1);
        this.onScrollWheelListener = this.method229(var1);
        this.varTransmitTriggers = this.method228(var1);
        this.invTransmitTriggers = this.method228(var1);
        this.statTransmitTriggers = this.method228(var1);
    }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(ZI)Lhx;",
            garbageValue = "-748743892"
    )
    public class96 method270(boolean var1) {
        if (this.field2703 == -1) {
            var1 = false;
        }

        int var2 = var1 ? this.field2703 : this.graphic;
        if (var2 == -1) {
            return null;
        } else {
            long var3 = ((long) this.shadow << 40) + ((this.hflip ? 1L : 0L) << 39) + ((this.vflip ? 1L : 0L) << 38) + (long) var2 + ((long) this.outline << 36);
            class96 var5 = (class96) field2664.method951(var3);
            if (var5 != null) {
                return var5;
            } else {
                SpritePixels var6 = this.method266(var1, -827486195);
                if (var6 == null) {
                    return null;
                } else {
                    SpritePixels var7 = var6.method2243();
                    int[] var8 = new int[var7.height];
                    int[] var9 = new int[var7.height];

                    for (int var10 = 0; var10 < var7.height; ++var10) {
                        int var11 = 0;
                        int var12 = var7.width;

                        int var13;
                        for (var13 = 0; var13 < var7.width; ++var13) {
                            if (var7.pixels[var13 + var10 * var7.width] == 0) {
                                var11 = var13;
                                break;
                            }
                        }

                        for (var13 = var7.width - 1; var13 >= var11; --var13) {
                            if (var7.pixels[var13 + var10 * var7.width] == 0) {
                                var12 = var13 + 1;
                                break;
                            }
                        }

                        var8[var10] = var11;
                        var9[var10] = var12 - var11;
                    }

                    var5 = new class96(var7.width, var7.height, var9, var8, var2);
                    field2664.method957(var5, var3);
                    return var5;
                }
            }
        }
    }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            signature = "(ILjava/lang/String;B)V",
            garbageValue = "32"
    )
    public void method236(int var1, String var2) {
        if (this.ops == null || this.ops.length <= var1) {
            String[] var3 = new String[var1 + 1];
            if (this.ops != null) {
                for (int var4 = 0; var4 < this.ops.length; ++var4) {
                    var3[var4] = this.ops[var4];
                }
            }

            this.ops = var3;
        }

        this.ops[var1] = var2;
    }

    public Rectangle getBounds() {
        Point var1 = this.getCanvasLocation();
        return new Rectangle(var1.getX(), var1.getY(), this.getWidth(), this.getHeight());
    }

    public String getRSText() {
        return this.text;
    }

    public String getRSName() {
        return this.opBase;
    }

    public int getParentId() {
        if (!$assertionsDisabled && !class166.clientInstance.isClientThread()) {
            throw new AssertionError();
        } else {
            int var1 = this.getRSParentId();
            if (var1 != -1) {
                return var1;
            } else {
                int var2 = this.getId();
                if (WidgetInfo.TO_GROUP(var2) == class166.clientInstance.getWidgetRoot()) {
                    return -1;
                } else {
                    int var3 = this.rl$parentId;
                    if (var3 != -1) {
                        RSHashTable var4 = class166.clientInstance.getComponentTable();
                        WidgetNode var5 = (WidgetNode) var4.get((long) var3);
                        if (var5 != null && var5.getId() == WidgetInfo.TO_GROUP(var2)) {
                            return var3;
                        }

                        this.rl$parentId = -1;
                    }

                    int var13 = WidgetInfo.TO_GROUP(this.getId());
                    RSHashTable var14 = class166.clientInstance.getComponentTable();
                    RSNode[] var6 = var14.getBuckets();
                    RSNode[] var7 = var6;
                    int var8 = var6.length;

                    for (int var9 = 0; var9 < var8; ++var9) {
                        RSNode var10 = var7[var9];

                        for (Object var11 = var10.getNext(); var11 != var10; var11 = ((net.runelite.api.Node) var11).getNext()) {
                            WidgetNode var12 = (WidgetNode) var11;
                            if (var13 == var12.getId()) {
                                return (int) var12.getHash();
                            }
                        }
                    }

                    return -1;
                }
            }
        }
    }

    public int[] getItemIds() {
        return this.objIds;
    }

    public Point getCanvasLocation() {
        return new Point(this.rl$x, this.rl$y);
    }

    public int getSpriteId() {
        return this.graphic;
    }

    public RSWidget[] getChildren() {
        return this.children;
    }

    public int getRSParentId() {
        return this.layer;
    }

    public int getId() {
        return this.id;
    }

    public void setRSName(String var1) {
        this.opBase = var1;
    }

    public int[] getItemQuantities() {
        return this.objCounts;
    }

    public boolean isSelfHidden() {
        return this.isHidden;
    }

    public Widget getParent() {
        int var1 = this.getParentId();
        return var1 == -1 ? null : class166.clientInstance.getWidget(WidgetInfo.TO_GROUP(var1), WidgetInfo.TO_CHILD(var1));
    }

    @ObfuscatedSignature(
            signature = "(ZI)Lls;"
    )
    public SpritePixels copy$getWidgetSprite(boolean var1, int var2) {
        field2665 = false;
        int var3;
        if (var1) {
            var3 = this.field2703;
        } else {
            var3 = this.graphic;
        }

        if (var3 == -1) {
            return null;
        } else {
            long var4 = ((long) this.shadow << 40) + ((this.hflip ? 1L : 0L) << 39) + ((this.vflip ? 1L : 0L) << 38) + ((long) this.outline << 36) + (long) var3;
            SpritePixels var6 = (SpritePixels) field2661.method951(var4);
            if (var6 != null) {
                return var6;
            } else {
                var6 = class36.method576(ChatPlayer.field3709, var3, 0, (byte) -16);
                if (var6 == null) {
                    field2665 = true;
                    return null;
                } else {
                    if (this.vflip) {
                        var6.method2270();
                    }

                    if (this.hflip) {
                        var6.method2248();
                    }

                    if (this.outline > 0) {
                        var6.method2246(this.outline);
                    }

                    if (this.outline >= 1) {
                        var6.method2249(1);
                    }

                    if (this.outline >= 2) {
                        var6.method2249(16777215);
                    }

                    if (this.shadow != 0) {
                        var6.method2250(this.shadow);
                    }

                    field2661.method957(var6, var4);
                    return var6;
                }
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public WidgetItem getWidgetItem(int var1) {
        int[] var2 = this.getItemIds();
        int[] var3 = this.getItemQuantities();
        if (var2 != null && var3 != null) {
            int var4 = this.getWidth();
            int var5 = this.getXPitch();
            int var6 = this.getYPitch();
            int var7 = var2[var1];
            int var8 = var3[var1];
            Point var9 = this.getCanvasLocation();
            if (var7 > 0 && var8 > 0 && var4 > 0) {
                int var10 = var1 / var4;
                int var11 = var1 % var4;
                int var12 = var9.getX() + (32 + var5) * var11;
                int var13 = var9.getY() + (32 + var6) * var10;
                Rectangle var14 = new Rectangle(var12 - 1, var13 - 1, 32, 32);
                return new WidgetItem(var7 - 1, var8, var1, var14);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public int getXPitch() {
        return this.paddingX;
    }

    public Widget[] getNestedChildren() {
        if (!$assertionsDisabled && !class166.clientInstance.isClientThread()) {
            throw new AssertionError();
        } else if (this.getRSParentId() == this.getId()) {
            return new Widget[0];
        } else {
            RSHashTable var1 = class166.clientInstance.getComponentTable();
            WidgetNode var2 = (WidgetNode) var1.get((long) this.getId());
            if (var2 == null) {
                return new ComponentType[0];
            } else {
                int var3 = var2.getId();
                ArrayList var4 = new ArrayList();
                RSWidget[] var5 = class166.clientInstance.getGroup(var3);
                int var6 = var5.length;

                for (int var7 = 0; var7 < var6; ++var7) {
                    RSWidget var8 = var5[var7];
                    if (var8 != null && var8.getRSParentId() == -1) {
                        var4.add(var8);
                    }
                }

                return (Widget[]) var4.toArray(new ComponentType[var4.size()]);
            }
        }
    }

    public int getYPitch() {
        return this.paddingY;
    }

    public void broadcastHidden(boolean var1) {
        WidgetHiddenChanged var2 = new WidgetHiddenChanged();
        var2.setWidget(this);
        var2.setHidden(var1);
        class166.clientInstance.getCallbacks().post(var2);
        RSWidget[] var3 = this.getChildren();
        int var6;
        if (var3 != null) {
            RSWidget[] var4 = var3;
            int var5 = var3.length;

            for (var6 = 0; var6 < var5; ++var6) {
                RSWidget var7 = var4[var6];
                if (var7 != null && !var7.isSelfHidden()) {
                    var7.broadcastHidden(var1);
                }
            }
        }

        Widget[] var11 = this.getNestedChildren();
        Widget[] var9 = var11;
        var6 = var11.length;

        for (int var10 = 0; var10 < var6; ++var10) {
            Widget var8 = var9[var10];
            if (var8 != null && !var8.isSelfHidden()) {
                ((RSWidget) var8).broadcastHidden(var1);
            }
        }

    }

    public void setChildren(Widget[] var1) {
        this.children = (ComponentType[]) var1;
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public void onPositionChanged(int var1) {
        int var2 = this.getId();
        if (var2 != -1) {
            int var3 = class166.clientInstance.getGameCycle();
            if (var3 != rl$widgetLastPosChanged) {
                rl$widgetLastPosChanged = var3;
                class166.clientInstance.getLogger().trace("Posting widget position changed");
                WidgetPositioned var4 = new WidgetPositioned();
                class166.clientInstance.getCallbacks().postDeferred(var4);
            }
        }
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public void onHiddenChanged(int var1) {
        int var2 = this.getId();
        if (var2 != -1) {
            Widget var3 = this.getParent();
            if (var3 != null) {
                if (var3.isHidden()) {
                    return;
                }
            } else if (WidgetInfo.TO_GROUP(var2) != class166.clientInstance.getWidgetRoot()) {
                return;
            }

            this.broadcastHidden(this.isSelfHidden());
        }
    }

    private void rl$$init() {
        this.rl$parentId = -1;
        this.rl$x = -1;
        this.rl$y = -1;
    }

    public void setRenderParentId(int var1) {
        this.rl$parentId = var1;
    }

    public void setRenderX(int var1) {
        this.rl$x = var1;
    }

    public void setRenderY(int var1) {
        this.rl$y = var1;
    }

    public String getText() {
        return this.getRSText().replace(' ', ' ');
    }

    public String getName() {
        return this.getRSName().replace(' ', ' ');
    }

    public void setName(String var1) {
        this.setRSName(var1.replace(' ', ' '));
    }

    public boolean isHidden() {
        if (!$assertionsDisabled && !class166.clientInstance.isClientThread()) {
            throw new AssertionError();
        } else if (this.isSelfHidden()) {
            return true;
        } else {
            Widget var1 = this.getParent();
            if (var1 == null) {
                if (WidgetInfo.TO_GROUP(this.getId()) != class166.clientInstance.getWidgetRoot()) {
                    return true;
                }
            } else if (var1.isHidden()) {
                return true;
            }

            return false;
        }
    }

    public Collection getWidgetItems() {
        int[] var1 = this.getItemIds();
        if (var1 == null) {
            return null;
        } else {
            ArrayList var2 = new ArrayList(var1.length);

            for (int var3 = 0; var3 < var1.length; ++var3) {
                WidgetItem var4 = this.getWidgetItem(var3);
                if (var4 != null) {
                    var2.add(var4);
                }
            }

            return var2;
        }
    }

    public Widget getChild(int var1) {
        RSWidget[] var2 = this.getChildren();
        return var2 != null && var2[var1] != null ? var2[var1] : null;
    }

    public Widget[] getDynamicChildren() {
        RSWidget[] var1 = this.getChildren();
        if (var1 == null) {
            return new Widget[0];
        } else {
            ArrayList var2 = new ArrayList();
            RSWidget[] var3 = var1;
            int var4 = var1.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                RSWidget var6 = var3[var5];
                if (var6 != null && var6.getRSParentId() == this.getId()) {
                    var2.add(var6);
                }
            }

            return (Widget[]) var2.toArray(new Widget[var2.size()]);
        }
    }

    public Widget[] getStaticChildren() {
        if (this.getRSParentId() == this.getId()) {
            return new Widget[0];
        } else {
            ArrayList var1 = new ArrayList();
            RSWidget[] var2 = class166.clientInstance.getGroup(WidgetInfo.TO_GROUP(this.getId()));
            int var3 = var2.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                RSWidget var5 = var2[var4];
                if (var5 != null && var5.getRSParentId() == this.getId()) {
                    var1.add(var5);
                }
            }

            return (Widget[]) var1.toArray(new ComponentType[var1.size()]);
        }
    }

    public boolean contains(Point var1) {
        Rectangle var2 = this.getBounds();
        return var2 != null && var2.contains(new java.awt.Point(var1.getX(), var1.getY()));
    }

    public Widget createChild(int var1, int var2) {
        if (!$assertionsDisabled && !class166.clientInstance.isClientThread()) {
            throw new AssertionError();
        } else {
            RSWidget var3 = class166.clientInstance.createWidget();
            var3.setType(var2);
            var3.setParentId(this.getId());
            var3.setId(this.getId());
            var3.setIsIf3(true);
            Object var4 = this.getChildren();
            if (var1 < 0) {
                if (var4 == null) {
                    var1 = 0;
                } else {
                    var1 = ((Object[]) var4).length;
                }
            }

            if (var4 == null) {
                var4 = new ComponentType[var1 + 1];
                this.setChildren((Widget[]) var4);
            } else if (((Object[]) var4).length <= var1) {
                ComponentType[] var5 = new ComponentType[var1 + 1];
                System.arraycopy(var4, 0, var5, 0, ((Object[]) var4).length);
                var4 = var5;
                this.setChildren(var5);
            }

            ((Object[]) var4)[var1] = var3;
            var3.setIndex(var1);
            return var3;
        }
    }

    public void revalidate() {
        if (!$assertionsDisabled && !class166.clientInstance.isClientThread()) {
            throw new AssertionError();
        } else {
            class166.clientInstance.revalidateWidget(this);
        }
    }

    public void revalidateScroll() {
        if (!$assertionsDisabled && !class166.clientInstance.isClientThread()) {
            throw new AssertionError();
        } else {
            class166.clientInstance.revalidateWidget(this);
            class166.clientInstance.revalidateWidgetScroll(class166.clientInstance.getWidgets()[WidgetInfo.TO_GROUP(this.getId())], this, false);
        }
    }

    public void deleteAllChildren() {
        if (this.getChildren() != null) {
            Arrays.fill(this.getChildren(), (Object) null);
        }

    }

    public void setIsIf3(boolean var1) {
        this.isIf3 = var1;
    }

    public boolean isIf3() {
        return this.isIf3;
    }

    public void setId(int var1) {
        this.id = var1;
    }

    public void setIndex(int var1) {
        this.index = var1;
    }

    public int getIndex() {
        return this.index;
    }

    public void setType(int var1) {
        this.type = var1;
    }

    public int getType() {
        return this.type;
    }

    public void setContentType(int var1) {
        this.clientcode = var1;
    }

    public int getContentType() {
        return this.clientcode;
    }

    public void setXPositionMode(int var1) {
        this.posXmode = var1;
    }

    public int getXPositionMode() {
        return this.posXmode;
    }

    public void setYPositionMode(int var1) {
        this.posYmode = var1;
    }

    public int getYPositionMode() {
        return this.posYmode;
    }

    public void setWidthMode(int var1) {
        this.sizeXmode = var1;
    }

    public int getWidthMode() {
        return this.sizeXmode;
    }

    public void setHeightMode(int var1) {
        this.sizeYmode = var1;
    }

    public int getHeightMode() {
        return this.sizeYmode;
    }

    public void setOriginalX(int var1) {
        this.posX = var1;
    }

    public int getOriginalX() {
        return this.posX;
    }

    public void setOriginalY(int var1) {
        this.posY = var1;
    }

    public int getOriginalY() {
        return this.posY;
    }

    public void setOriginalWidth(int var1) {
        this.sizeX = var1;
    }

    public int getOriginalWidth() {
        return this.sizeX;
    }

    public void setOriginalHeight(int var1) {
        this.sizeY = var1;
    }

    public int getOriginalHeight() {
        return this.sizeY;
    }

    public void setRelativeX(int var1) {
        this.x = var1;
    }

    public int getRelativeX() {
        return this.x;
    }

    public void setRelativeY(int var1) {
        this.y = var1;
    }

    public int getRelativeY() {
        return this.y;
    }

    public void setWidth(int var1) {
        this.width = var1;
    }

    public void setHeight(int var1) {
        this.height = var1;
    }

    public void setParentId(int var1) {
        this.layer = var1;
    }

    public void setHidden(boolean var1) {
        this.isHidden = var1;
    }

    public void setScrollX(int var1) {
        this.scrollX = var1;
    }

    public int getScrollX() {
        return this.scrollX;
    }

    public void setScrollY(int var1) {
        this.scrollY = var1;
    }

    public int getScrollY() {
        return this.scrollY;
    }

    public void setScrollWidth(int var1) {
        this.scrollWidth = var1;
    }

    public int getScrollWidth() {
        return this.scrollWidth;
    }

    public void setScrollHeight(int var1) {
        this.scrollHeight = var1;
    }

    public int getScrollHeight() {
        return this.scrollHeight;
    }

    public void setTextColor(int var1) {
        this.color = var1;
    }

    public int getTextColor() {
        return this.color;
    }

    public void setFilled(boolean var1) {
        this.filled = var1;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setOpacity(int var1) {
        this.trans = var1;
    }

    public int getOpacity() {
        return this.trans;
    }

    public void setSpriteId(int var1) {
        this.graphic = var1;
    }

    public void setBorderType(int var1) {
        this.outline = var1;
    }

    public int getBorderType() {
        return this.outline;
    }

    public int getModelType() {
        return this.modelType;
    }

    public int getModelId() {
        return this.modelId;
    }

    public int getRotationX() {
        return this.xan2d;
    }

    public int getRotationZ() {
        return this.yan2d;
    }

    public int getRotationY() {
        return this.zan2d;
    }

    public void setItemQuantityMode(int var1) {
        this.objNumMode = var1;
    }

    public int getItemQuantityMode() {
        return this.objNumMode;
    }

    public void setFontId(int var1) {
        this.fontId = var1;
    }

    public int getFontId() {
        return this.fontId;
    }

    public void setText(String var1) {
        this.text = var1;
    }

    public void setXTextAlignment(int var1) {
        this.horizTextAlign = var1;
    }

    public int getXTextAlignment() {
        return this.horizTextAlign;
    }

    public void setYTextAlignment(int var1) {
        this.vertTextAlign = var1;
    }

    public int getYTextAlignment() {
        return this.vertTextAlign;
    }

    public void setTextShadowed(boolean var1) {
        this.textShadow = var1;
    }

    public boolean getTextShadowed() {
        return this.textShadow;
    }

    public void setClickMask(int var1) {
        this.activeProperties = var1;
    }

    public int getClickMask() {
        return this.activeProperties;
    }

    public String[] getActions() {
        return this.ops;
    }

    public void setDragDeadZone(int var1) {
        this.dragDeadZone = var1;
    }

    public int getDragDeadZone() {
        return this.dragDeadZone;
    }

    public void setDragDeadTime(int var1) {
        this.dragDeadTime = var1;
    }

    public int getDragDeadTime() {
        return this.dragDeadTime;
    }

    public void setHasListener(boolean var1) {
        this.hasHook = var1;
    }

    public boolean hasListener() {
        return this.hasHook;
    }

    public Object[] getOnLoadListener() {
        return this.onLoadListener;
    }

    public void setOnMouseOverListener(Object[] var1) {
        this.onMouseOverListener = var1;
    }

    public void setOnMouseLeaveListener(Object[] var1) {
        this.onMouseLeaveListener = var1;
    }

    public void setOnTimerListener(Object[] var1) {
        this.onTimerListener = var1;
    }

    public void setOnOpListener(Object[] var1) {
        this.onOpListener = var1;
    }

    public void setOnKeyListener(Object[] var1) {
        this.onKeyListener = var1;
    }

    public Object[] getOnKeyListener() {
        return this.onKeyListener;
    }

    public void setOnDialogAbortListener(Object[] var1) {
        this.onDialogAbortListener = var1;
    }

    public void setItemId(int var1) {
        this.linkObjType = var1;
    }

    public int getItemId() {
        return this.linkObjType;
    }

    public void setItemQuantity(int var1) {
        this.linkObjCount = var1;
    }

    public int getItemQuantity() {
        return this.linkObjCount;
    }

    public int getBoundsIndex() {
        return this.boundsIndex;
    }

    public RSFontTypeFace getFont() {
        return this.method233();
    }

    public void setAction(int var1, String var2) {
        this.method236(var1, var2);
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-1422883307"
    )
    void method227(Packet var1) {
        this.isIf3 = false;
        this.type = var1.readUnsignedByte();
        this.buttonType = var1.readUnsignedByte();
        this.clientcode = var1.readUnsignedShort();
        this.posX = var1.method6123();
        this.posY = var1.method6123();
        this.sizeX = var1.readUnsignedShort();
        this.sizeY = var1.readUnsignedShort();
        this.trans = var1.readUnsignedByte();
        this.layer = var1.readUnsignedShort();
        if (this.layer == 65535) {
            this.layer = -1;
        } else {
            this.layer += this.id & -65536;
        }

        this.field2788 = var1.readUnsignedShort();
        if (this.field2788 == 65535) {
            this.field2788 = -1;
        }

        int var2 = var1.readUnsignedByte();
        int var3;
        if (var2 > 0) {
            this.tableActions = new int[var2];
            this.field2778 = new int[var2];

            for (var3 = 0; var3 < var2; ++var3) {
                this.tableActions[var3] = var1.readUnsignedByte();
                this.field2778[var3] = var1.readUnsignedShort();
            }
        }

        var3 = var1.readUnsignedByte();
        int var4;
        int var5;
        int var6;
        if (var3 > 0) {
            this.dynamicValues = new int[var3][];

            for (var4 = 0; var4 < var3; ++var4) {
                var5 = var1.readUnsignedShort();
                this.dynamicValues[var4] = new int[var5];

                for (var6 = 0; var6 < var5; ++var6) {
                    this.dynamicValues[var4][var6] = var1.readUnsignedShort();
                    if (this.dynamicValues[var4][var6] == 65535) {
                        this.dynamicValues[var4][var6] = -1;
                    }
                }
            }
        }

        if (this.type == 0) {
            this.scrollHeight = var1.readUnsignedShort();
            this.isHidden = var1.readUnsignedByte() == 1;
            this.onHiddenChanged(-1);
        }

        if (this.type == 1) {
            var1.readUnsignedShort();
            var1.readUnsignedByte();
        }

        if (this.type == 2) {
            this.objIds = new int[this.sizeX * this.sizeY];
            this.objCounts = new int[this.sizeY * this.sizeX];
            var4 = var1.readUnsignedByte();
            if (var4 == 1) {
                this.activeProperties |= 268435456;
            }

            var5 = var1.readUnsignedByte();
            if (var5 == 1) {
                this.activeProperties |= 1073741824;
            }

            var6 = var1.readUnsignedByte();
            if (var6 == 1) {
                this.activeProperties |= Integer.MIN_VALUE;
            }

            int var7 = var1.readUnsignedByte();
            if (var7 == 1) {
                this.activeProperties |= 536870912;
            }

            this.paddingX = var1.readUnsignedByte();
            this.paddingY = var1.readUnsignedByte();
            this.xSprites = new int[20];
            this.field2737 = new int[20];
            this.field2738 = new int[20];

            int var8;
            for (var8 = 0; var8 < 20; ++var8) {
                int var9 = var1.readUnsignedByte();
                if (var9 == 1) {
                    this.xSprites[var8] = var1.method6123();
                    this.field2737[var8] = var1.method6123();
                    this.field2738[var8] = var1.getInt();
                } else {
                    this.field2738[var8] = -1;
                }
            }

            this.if1Ops = new String[5];

            for (var8 = 0; var8 < 5; ++var8) {
                String var10 = var1.readString();
                if (var10.length() > 0) {
                    this.if1Ops[var8] = var10;
                    this.activeProperties |= 1 << var8 + 23;
                }
            }
        }

        if (this.type == 3) {
            this.filled = var1.readUnsignedByte() == 1;
        }

        if (this.type == 4 || this.type == 1) {
            this.horizTextAlign = var1.readUnsignedByte();
            this.vertTextAlign = var1.readUnsignedByte();
            this.lineHeight = var1.readUnsignedByte();
            this.fontId = var1.readUnsignedShort();
            if (this.fontId == 65535) {
                this.fontId = -1;
            }

            this.textShadow = var1.readUnsignedByte() == 1;
        }

        if (this.type == 4) {
            this.text = var1.readString();
            this.string1 = var1.readString();
        }

        if (this.type == 1 || this.type == 3 || this.type == 4) {
            this.color = var1.getInt();
        }

        if (this.type == 3 || this.type == 4) {
            this.field2693 = var1.getInt();
            this.field2694 = var1.getInt();
            this.field2695 = var1.getInt();
        }

        if (this.type == 5) {
            this.graphic = var1.getInt();
            this.field2703 = var1.getInt();
        }

        if (this.type == 6) {
            this.modelType = 1;
            this.modelId = var1.readUnsignedShort();
            if (this.modelId == 65535) {
                this.modelId = -1;
            }

            this.field2687 = 1;
            this.field2692 = var1.readUnsignedShort();
            if (this.field2692 == 65535) {
                this.field2692 = -1;
            }

            this.animation = var1.readUnsignedShort();
            if (this.animation == 65535) {
                this.animation = -1;
            }

            this.field2715 = var1.readUnsignedShort();
            if (this.field2715 == 65535) {
                this.field2715 = -1;
            }

            this.zoom2d = var1.readUnsignedShort();
            this.xan2d = var1.readUnsignedShort();
            this.yan2d = var1.readUnsignedShort();
        }

        if (this.type == 7) {
            this.objIds = new int[this.sizeX * this.sizeY];
            this.objCounts = new int[this.sizeX * this.sizeY];
            this.horizTextAlign = var1.readUnsignedByte();
            this.fontId = var1.readUnsignedShort();
            if (this.fontId == 65535) {
                this.fontId = -1;
            }

            this.textShadow = var1.readUnsignedByte() == 1;
            this.color = var1.getInt();
            this.paddingX = var1.method6123();
            this.paddingY = var1.method6123();
            var4 = var1.readUnsignedByte();
            if (var4 == 1) {
                this.activeProperties |= 1073741824;
            }

            this.if1Ops = new String[5];

            for (var5 = 0; var5 < 5; ++var5) {
                String var11 = var1.readString();
                if (var11.length() > 0) {
                    this.if1Ops[var5] = var11;
                    this.activeProperties |= 1 << var5 + 23;
                }
            }
        }

        if (this.type == 8) {
            this.text = var1.readString();
        }

        if (this.buttonType == 2 || this.type == 2) {
            this.targetVerb = var1.readString();
            this.spellName = var1.readString();
            var4 = var1.readUnsignedShort() & 63;
            this.activeProperties |= var4 << 11;
        }

        if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
            this.tooltip = var1.readString();
            if (this.tooltip.length() == 0) {
                if (this.buttonType == 1) {
                    this.tooltip = "Ok";
                }

                if (this.buttonType == 4) {
                    this.tooltip = "Select";
                }

                if (this.buttonType == 5) {
                    this.tooltip = "Select";
                }

                if (this.buttonType == 6) {
                    this.tooltip = "Continue";
                }
            }
        }

        if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
            this.activeProperties |= 4194304;
        }

        if (this.buttonType == 6) {
            this.activeProperties |= 1;
        }

    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(Lgl;I)[I",
            garbageValue = "1860958215"
    )
    int[] method228(Packet var1) {
        int var2 = var1.readUnsignedByte();
        if (var2 == 0) {
            return null;
        } else {
            int[] var3 = new int[var2];

            for (int var4 = 0; var4 < var2; ++var4) {
                var3[var4] = var1.getInt();
            }

            return var3;
        }
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(IIB)V",
            garbageValue = "-106"
    )
    public void method231(int var1, int var2) {
        int var3 = this.objIds[var2];
        this.objIds[var2] = this.objIds[var1];
        this.objIds[var1] = var3;
        var3 = this.objCounts[var2];
        this.objCounts[var2] = this.objCounts[var1];
        this.objCounts[var1] = var3;
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(II)Lls;",
            garbageValue = "214380669"
    )
    public SpritePixels method234(int var1) {
        field2665 = false;
        if (var1 >= 0 && var1 < this.field2738.length) {
            int var2 = this.field2738[var1];
            if (var2 == -1) {
                return null;
            } else {
                SpritePixels var3 = (SpritePixels) field2661.method951((long) var2);
                if (var3 != null) {
                    return var3;
                } else {
                    var3 = class36.method576(ChatPlayer.field3709, var2, 0, (byte) -37);
                    if (var3 != null) {
                        field2661.method957(var3, (long) var2);
                    } else {
                        field2665 = true;
                    }

                    return var3;
                }
            }
        } else {
            return null;
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/CharSequence;Llq;B)Ljava/lang/String;",
            garbageValue = "11"
    )
    public static String method268(CharSequence var0, JagexLoginType var1) {
        if (var0 == null) {
            return null;
        } else {
            int var2 = 0;

            int var3;
            for (var3 = var0.length(); var2 < var3 && StructType.method5723(var0.charAt(var2)); ++var2) {
                ;
            }

            while (var3 > var2 && StructType.method5723(var0.charAt(var3 - 1))) {
                --var3;
            }

            int var4 = var3 - var2;
            if (var4 >= 1 && var4 <= class157.method2695(var1)) {
                StringBuilder var5 = new StringBuilder(var4);

                for (int var6 = var2; var6 < var3; ++var6) {
                    char var7 = var0.charAt(var6);
                    boolean var8;
                    if (Character.isISOControl(var7)) {
                        var8 = false;
                    } else if (class101.method1706(var7)) {
                        var8 = true;
                    } else {
                        char[] var9 = class265.field3788;
                        int var10 = 0;

                        label73:
                        while (true) {
                            char var11;
                            if (var10 >= var9.length) {
                                var9 = class265.field3789;

                                for (var10 = 0; var10 < var9.length; ++var10) {
                                    var11 = var9[var10];
                                    if (var11 == var7) {
                                        var8 = true;
                                        break label73;
                                    }
                                }

                                var8 = false;
                                break;
                            }

                            var11 = var9[var10];
                            if (var7 == var11) {
                                var8 = true;
                                break;
                            }

                            ++var10;
                        }
                    }

                    if (var8) {
                        char var12 = SoundTask.method5022(var7);
                        if (var12 != 0) {
                            var5.append(var12);
                        }
                    }
                }

                if (var5.length() == 0) {
                    return null;
                } else {
                    return var5.toString();
                }
            } else {
                return null;
            }
        }
    }

    private static void rl$$clinit() {
        $assertionsDisabled = !client.class.desiredAssertionStatus();
    }
}
