package net.runelite.runescape;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.runelite.api.Point;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.api.hooks.Callbacks;
import net.runelite.api.hooks.DrawCallbacks;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.Hooks;
import net.runelite.mapping.*;
import net.runelite.rs.api.*;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ObfuscatedName("client")
@Implements("client")
public final class client extends GameEngine implements class236, RSClient {
    @ObfuscatedName("pq")
    @ObfuscatedSignature(
            signature = "[Lls;"
    )
    static SpritePixels[] mapIcons;
    @ObfuscatedName("md")
    @ObfuscatedGetter(
            intValue = -1955796665
    )
    static int energy;
    @ObfuscatedName("mh")
    @ObfuscatedGetter(
            intValue = -433880071
    )
    static int weight;
    @ObfuscatedName("nv")
    static int[] changedSkills;
    @ObfuscatedName("rp")
    @ObfuscatedGetter(
            intValue = 1633696591
    )
    static int Viewport_xOffset;
    @ObfuscatedName("rx")
    @ObfuscatedGetter(
            intValue = 465381395
    )
    static int Viewport_yOffset;
    @ObfuscatedName("or")
    @ObfuscatedGetter(
            intValue = -1383444543
    )
    static int gameDrawingMode;
    @ObfuscatedName("re")
    @ObfuscatedGetter(
            intValue = 118479073
    )
    static int viewportHeight;
    @ObfuscatedName("rw")
    @ObfuscatedGetter(
            intValue = -1390189851
    )
    static int scale;
    @ObfuscatedName("sf")
    @ObfuscatedSignature(
            signature = "[Lc;"
    )
    static GrandExchangeOffer[] grandExchangeOffers;
    @ObfuscatedName("nq")
    static boolean draggingWidget;
    @ObfuscatedName("qk")
    static int[] queuedSoundEffectIDs;
    @ObfuscatedName("qm")
    @ObfuscatedSignature(
            signature = "[Lcp;"
    )
    static SoundEffect[] audioEffects;
    @ObfuscatedName("nz")
    @ObfuscatedGetter(
            intValue = 358128589
    )
    static int changedSkillsCount;
    @ObfuscatedName("nf")
    @ObfuscatedGetter(
            intValue = -906150819
    )
    static int chatCycle;
    @ObfuscatedName("qd")
    static int[] unknownSoundValues1;
    @ObfuscatedName("rl")
    @ObfuscatedGetter(
            intValue = 1000762981
    )
    static int viewportWidth;
    @ObfuscatedName("mo")
    @ObfuscatedSignature(
            signature = "Lhn;"
    )
    static ComponentType draggedOnWidget;
    @ObfuscatedName("qt")
    static int[] soundLocations;
    @ObfuscatedName("oj")
    static int[] widgetPositionX;
    @ObfuscatedName("qu")
    static int[] unknownSoundValues2;
    @ObfuscatedName("oh")
    static int[] widgetPositionY;
    @ObfuscatedName("oe")
    @ObfuscatedSignature(
            signature = "Lgq;"
    )
    static HashTable serverActiveProperties;
    @ObfuscatedName("np")
    @ObfuscatedGetter(
            intValue = -1611618327
    )
    static int cycleCntr;
    @ObfuscatedName("ob")
    static boolean isResized;
    @ObfuscatedName("mj")
    @ObfuscatedGetter(
            intValue = 2031502395
    )
    static int toplevel;
    @ObfuscatedName("pm")
    @ObfuscatedGetter(
            intValue = -71705243
    )
    static int destinationY;
    @ObfuscatedName("pa")
    @ObfuscatedGetter(
            intValue = 1910927777
    )
    static int destinationX;
    @ObfuscatedName("mq")
    @ObfuscatedSignature(
            signature = "Lhn;"
    )
    static ComponentType draggedWidget;
    @ObfuscatedName("qa")
    @ObfuscatedGetter(
            intValue = 838252469
    )
    static int queuedSoundEffectCount;
    @ObfuscatedName("mn")
    @ObfuscatedSignature(
            signature = "Lgq;"
    )
    static HashTable subInterfaces;
    @ObfuscatedName("oa")
    @ObfuscatedGetter(
            intValue = 768507181
    )
    static int widgetCount;
    @ObfuscatedName("ok")
    @ObfuscatedGetter(
            intValue = -718201431
    )
    static int field847;
    @ObfuscatedName("on")
    @ObfuscatedGetter(
            longValue = 334458010238181443L
    )
    static long field870;
    @ObfuscatedName("oy")
    static boolean[] field848;
    @ObfuscatedName("qo")
    static boolean field879;
    @ObfuscatedName("oo")
    static boolean[] field706;
    @ObfuscatedName("oc")
    static boolean[] field849;
    @ObfuscatedName("nm")
    static boolean field824;
    @ObfuscatedName("mz")
    static boolean field821;
    @ObfuscatedName("nh")
    @ObfuscatedGetter(
            intValue = -2041049403
    )
    static int lastFriendTransmit;
    @ObfuscatedName("qg")
    @ObfuscatedSignature(
            signature = "Lcq;"
    )
    static AbstractSoundSystem soundSystem0;
    @ObfuscatedName("sv")
    @ObfuscatedGetter(
            intValue = 1603210411
    )
    public static int field914;
    @ObfuscatedName("mt")
    @ObfuscatedGetter(
            intValue = 1134209347
    )
    static int field906;
    @ObfuscatedName("ml")
    @ObfuscatedGetter(
            intValue = 225210315
    )
    static int field838;
    @ObfuscatedName("mr")
    @ObfuscatedGetter(
            intValue = 1428748903
    )
    static int field713;
    @ObfuscatedName("mi")
    @ObfuscatedSignature(
            signature = "Lhn;"
    )
    static ComponentType field817;
    @ObfuscatedName("mc")
    @ObfuscatedSignature(
            signature = "Lhn;"
    )
    static ComponentType field815;
    @ObfuscatedName("oz")
    static int[] widgetBoundsWidth;
    @ObfuscatedName("ol")
    @ObfuscatedGetter(
            intValue = -700275435
    )
    static int publicChatMode;
    @ObfuscatedName("nd")
    @ObfuscatedGetter(
            intValue = 1799595835
    )
    static int field823;
    @ObfuscatedName("rb")
    @ObfuscatedSignature(
            signature = "Lhi;"
    )
    static PlayerComposition field908;
    @ObfuscatedName("mv")
    @ObfuscatedSignature(
            signature = "Lhn;"
    )
    static ComponentType field880;
    @ObfuscatedName("oi")
    static int[] widgetBoundsHeight;
    @ObfuscatedName("mu")
    @ObfuscatedGetter(
            intValue = 1302574455
    )
    static int staffModLevel;
    @ObfuscatedName("op")
    @ObfuscatedSignature(
            signature = "Lgi;"
    )
    static Deque field842;
    @ObfuscatedName("sx")
    @ObfuscatedSignature(
            signature = "Lbf;"
    )
    static final class228 field670;
    @ObfuscatedName("nb")
    @ObfuscatedGetter(
            intValue = 1703569799
    )
    static int field825;
    @ObfuscatedName("ne")
    @ObfuscatedGetter(
            intValue = 1456733273
    )
    static int field826;
    @ObfuscatedName("nr")
    @ObfuscatedGetter(
            intValue = 1096374037
    )
    static int lastMiscTransmit;
    @ObfuscatedName("qj")
    @ObfuscatedGetter(
            intValue = 1946534993
    )
    static int field878;
    @ObfuscatedName("le")
    @ObfuscatedGetter(
            intValue = -1838791305
    )
    static int field799;
    @ObfuscatedName("sn")
    static int[] field918;
    @ObfuscatedName("tp")
    static int[] field900;
    @ObfuscatedName("qq")
    @ObfuscatedGetter(
            intValue = -1420107885
    )
    static int field888;
    @ObfuscatedName("mw")
    static String targetVerb;
    @ObfuscatedName("nl")
    static int[] field831;
    @ObfuscatedName("ng")
    @ObfuscatedGetter(
            intValue = -1730491013
    )
    static int field832;
    @ObfuscatedName("mg")
    static String opBase;
    @ObfuscatedName("lm")
    @ObfuscatedGetter(
            intValue = -375275645
    )
    static int field734;
    @ObfuscatedName("og")
    @ObfuscatedGetter(
            intValue = -992481059
    )
    static int field841;
    @ObfuscatedName("rv")
    @ObfuscatedGetter(
            intValue = -533638085
    )
    static int field874;
    @ObfuscatedName("qv")
    @ObfuscatedGetter(
            intValue = -1571887487
    )
    static int field881;
    @ObfuscatedName("rk")
    @ObfuscatedGetter(
            intValue = -755250703
    )
    static int field910;
    @ObfuscatedName("qw")
    @ObfuscatedGetter(
            intValue = -483764559
    )
    static int field877;
    @ObfuscatedName("nu")
    @ObfuscatedGetter(
            intValue = 19380653
    )
    static int field830;
    @ObfuscatedName("sy")
    static ArrayList field915;
    @ObfuscatedName("qp")
    @ObfuscatedGetter(
            intValue = 118745147
    )
    static int minimapRenderType;
    @ObfuscatedName("se")
    @ObfuscatedGetter(
            intValue = -381597203
    )
    static int field765;
    @ObfuscatedName("ra")
    static short field897;
    @ObfuscatedName("rm")
    static short field899;
    @ObfuscatedName("ql")
    static boolean field889;
    @ObfuscatedName("mf")
    static boolean playermod;
    @ObfuscatedName("rq")
    static short field649;
    @ObfuscatedName("pd")
    @ObfuscatedGetter(
            intValue = -2087517625
    )
    static int tradeMode;
    @ObfuscatedName("pp")
    @ObfuscatedGetter(
            intValue = 328410633
    )
    static int field661;
    @ObfuscatedName("rz")
    static short field896;
    @ObfuscatedName("nt")
    @ObfuscatedGetter(
            intValue = -1893906185
    )
    static int field839;
    @ObfuscatedName("ry")
    static short field901;
    @ObfuscatedName("pw")
    @ObfuscatedGetter(
            longValue = 1714079795054395559L
    )
    static long field868;
    @ObfuscatedName("rr")
    static short field898;
    @ObfuscatedName("pi")
    static String field862;
    @ObfuscatedName("ma")
    @ObfuscatedGetter(
            intValue = -1700615285
    )
    static int field807;
    @ObfuscatedName("rn")
    static short field754;
    @ObfuscatedName("rt")
    static short field684;
    @ObfuscatedName("sq")
    @ObfuscatedSignature(
            signature = "Lbb;"
    )
    static OwnWorldComparator field913;
    @ObfuscatedName("mb")
    @ObfuscatedGetter(
            intValue = 1428426593
    )
    static int field808;
    @ObfuscatedName("mp")
    @ObfuscatedGetter(
            intValue = 1760102879
    )
    static int field805;
    @ObfuscatedName("me")
    @ObfuscatedGetter(
            intValue = -1662822667
    )
    static int field642;
    @ObfuscatedName("sw")
    @ObfuscatedSignature(
            signature = "Lla;"
    )
    static class313 field911;
    @ObfuscatedName("mk")
    @ObfuscatedGetter(
            intValue = -1597242117
    )
    static int field813;
    @ObfuscatedName("pn")
    @ObfuscatedGetter(
            intValue = -1176992767
    )
    static int field820;
    @ObfuscatedName("po")
    static int[] field871;
    @ObfuscatedName("py")
    static int[] field872;
    @ObfuscatedName("nw")
    static int[] field653;
    @ObfuscatedName("pb")
    @ObfuscatedGetter(
            intValue = -269674329
    )
    static int field865;
    @ObfuscatedName("rs")
    static boolean[] field890;
    @ObfuscatedName("pr")
    static int[] field867;
    @ObfuscatedName("pe")
    static int[] field846;
    @ObfuscatedName("nk")
    @ObfuscatedGetter(
            intValue = -38068377
    )
    static int field837;
    @ObfuscatedName("of")
    @ObfuscatedSignature(
            signature = "Lgi;"
    )
    static Deque field843;
    @ObfuscatedName("ot")
    @ObfuscatedSignature(
            signature = "Lgi;"
    )
    static Deque field844;
    @ObfuscatedName("ro")
    static int[] field892;
    @ObfuscatedName("rg")
    static int[] field891;
    @ObfuscatedName("rd")
    static int[] field893;
    @ObfuscatedName("ns")
    @ObfuscatedGetter(
            intValue = -1499277175
    )
    static int field858;
    @ObfuscatedName("rf")
    static int[] field894;
    @ObfuscatedName("ps")
    static long[] field840;
    @ObfuscatedName("pt")
    @ObfuscatedGetter(
            intValue = -627016849
    )
    static int field864;
    @ObfuscatedName("os")
    static int[] field859;
    @ObfuscatedName("jn")
    @ObfuscatedSignature(
            signature = "[Lbk;"
    )
    static PlayerEntity[] players;
    @ObfuscatedName("ck")
    static boolean displayFps;
    @ObfuscatedName("iq")
    static boolean field728;
    @ObfuscatedName("ik")
    @ObfuscatedGetter(
            intValue = -1761775113
    )
    static int lastLeftClickY;
    @ObfuscatedName("kk")
    static boolean isMenuOpen;
    @ObfuscatedName("hn")
    @ObfuscatedGetter(
            intValue = -2070717675
    )
    static int field857;
    @ObfuscatedName("cq")
    @ObfuscatedGetter(
            intValue = -1141720869
    )
    static int hintArrowX;
    @ObfuscatedName("jh")
    @ObfuscatedGetter(
            intValue = 1332995949
    )
    static int mouseCrosshair;
    @ObfuscatedName("fh")
    @ObfuscatedSignature(
            signature = "Lcf;"
    )
    public static final ServerConnection serverConnection;
    @ObfuscatedName("jy")
    @ObfuscatedGetter(
            intValue = 1865654495
    )
    static int field680;
    @ObfuscatedName("hy")
    @ObfuscatedGetter(
            intValue = 242264023
    )
    static int field883;
    @ObfuscatedName("aq")
    static boolean field856;
    @ObfuscatedName("dh")
    @ObfuscatedGetter(
            intValue = 10754561
    )
    static int js5State;
    @ObfuscatedName("hh")
    @ObfuscatedGetter(
            intValue = 505838891
    )
    static int camModeType;
    @ObfuscatedName("lh")
    static boolean field788;
    @ObfuscatedName("kw")
    @ObfuscatedSignature(
            signature = "Lgi;"
    )
    static Deque projectiles;
    @ObfuscatedName("ew")
    @ObfuscatedSignature(
            signature = "Lcl;"
    )
    static class159 field683;
    @ObfuscatedName("iw")
    @ObfuscatedGetter(
            intValue = -67331915
    )
    static int field659;
    @ObfuscatedName("gp")
    static int[][][] instanceTemplateChunks;
    @ObfuscatedName("cp")
    @ObfuscatedGetter(
            intValue = 139818543
    )
    static int rebootTimer;
    @ObfuscatedName("lb")
    static int[] menuActionParams1;
    @ObfuscatedName("fz")
    static HashMap fontsMap;
    @ObfuscatedName("il")
    @ObfuscatedGetter(
            intValue = 1919800613
    )
    static int overheadTextCount;
    @ObfuscatedName("kp")
    static int[] skillExperiences;
    @ObfuscatedName("kv")
    @ObfuscatedGetter(
            intValue = -1437784247
    )
    static int npcsToRemoveCount;
    @ObfuscatedName("li")
    static boolean field790;
    @ObfuscatedName("if")
    static int[] overheadTextsY;
    @ObfuscatedName("ef")
    static int[] highResolutionNpcIndexes;
    @ObfuscatedName("js")
    @ObfuscatedGetter(
            intValue = 388057435
    )
    static int field761;
    @ObfuscatedName("bs")
    @ObfuscatedGetter(
            intValue = -1912562147
    )
    public static int world;
    @ObfuscatedName("hc")
    @ObfuscatedGetter(
            intValue = -1807159593
    )
    static int field709;
    @ObfuscatedName("cv")
    @ObfuscatedGetter(
            intValue = 1635836375
    )
    static int hintArrowOffsetY;
    @ObfuscatedName("jm")
    static boolean field762;
    @ObfuscatedName("dc")
    @ObfuscatedGetter(
            intValue = -958492487
    )
    static int loadingStage;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            signature = "[Lfn;"
    )
    static CollisionData[] collisionMaps;
    @ObfuscatedName("el")
    @ObfuscatedGetter(
            intValue = 279424497
    )
    static int loginState;
    @ObfuscatedName("lc")
    static int[] menuIdentifiers;
    @ObfuscatedName("bz")
    @ObfuscatedGetter(
            intValue = 564638107
    )
    static int flags;
    @ObfuscatedName("ie")
    static boolean field726;
    @ObfuscatedName("ir")
    @ObfuscatedGetter(
            intValue = 579808443
    )
    static int field723;
    @ObfuscatedName("bg")
    static boolean field770;
    @ObfuscatedName("lg")
    @ObfuscatedGetter(
            intValue = 567295321
    )
    static int field794;
    @ObfuscatedName("ed")
    static boolean Login_isUsernameRemembered;
    @ObfuscatedName("ig")
    @ObfuscatedGetter(
            intValue = 404479131
    )
    static int field727;
    @ObfuscatedName("fu")
    @ObfuscatedGetter(
            intValue = 2100810001
    )
    static int field753;
    @ObfuscatedName("iu")
    static int[] field736;
    @ObfuscatedName("lu")
    @ObfuscatedGetter(
            intValue = -965472715
    )
    static int field792;
    @ObfuscatedName("hx")
    @ObfuscatedGetter(
            intValue = -1641321925
    )
    static int field719;
    @ObfuscatedName("ld")
    @ObfuscatedGetter(
            intValue = 2142030189
    )
    static int field860;
    @ObfuscatedName("ea")
    static byte[] field708;
    @ObfuscatedName("jd")
    @ObfuscatedGetter(
            intValue = 1453157279
    )
    static int field845;
    @ObfuscatedName("kx")
    static int[] skillLevels;
    @ObfuscatedName("cx")
    @ObfuscatedGetter(
            longValue = -918258204981993753L
    )
    static long mouseLastLastPressedTimeMillis;
    @ObfuscatedName("ja")
    static boolean field748;
    @ObfuscatedName("ca")
    @ObfuscatedGetter(
            intValue = 1356879543
    )
    static int field735;
    @ObfuscatedName("ka")
    @ObfuscatedGetter(
            intValue = -1539589433
    )
    static int playerNameMask;
    @ObfuscatedName("ho")
    @ObfuscatedGetter(
            intValue = -472987857
    )
    static int field714;
    @ObfuscatedName("km")
    @ObfuscatedSignature(
            signature = "[[[Lgi;"
    )
    static Deque[][][] groundItemDeque;
    @ObfuscatedName("fl")
    @ObfuscatedGetter(
            intValue = 1906688231
    )
    static int field700;
    @ObfuscatedName("cz")
    @ObfuscatedSignature(
            signature = "Lcb;"
    )
    static AttackOpPriority playerAttackOpPriority;
    @ObfuscatedName("em")
    @ObfuscatedSignature(
            signature = "Lea;"
    )
    static AuthProt field681;
    @ObfuscatedName("hl")
    @ObfuscatedGetter(
            intValue = 303086833
    )
    static int cameraPitchTarget;
    @ObfuscatedName("cj")
    @ObfuscatedGetter(
            intValue = 1754280253
    )
    static int hintArrowY;
    @ObfuscatedName("ij")
    static int[] overheadTextsX;
    @ObfuscatedName("ep")
    @ObfuscatedGetter(
            intValue = -732531845
    )
    static int highResolutionNpcCount;
    @ObfuscatedName("jb")
    @ObfuscatedGetter(
            intValue = 189066177
    )
    static int field752;
    @ObfuscatedName("ls")
    static boolean field791;
    @ObfuscatedName("kz")
    @ObfuscatedSignature(
            signature = "Lgi;"
    )
    static Deque spotAnimationDeque;
    @ObfuscatedName("ii")
    @ObfuscatedGetter(
            intValue = -1047645041
    )
    static int screenY;
    @ObfuscatedName("fi")
    @ObfuscatedGetter(
            intValue = -489237163
    )
    static int field725;
    @ObfuscatedName("kl")
    static final int[] playerMenuTypes;
    @ObfuscatedName("bp")
    @ObfuscatedSignature(
            signature = "Liz;"
    )
    static ModeGame field646;
    @ObfuscatedName("lf")
    @ObfuscatedGetter(
            intValue = -2125876273
    )
    static int itemSelectionState;
    @ObfuscatedName("ih")
    static int[] overheadTextsCyclesRemaining;
    @ObfuscatedName("lt")
    static boolean spellSelected;
    @ObfuscatedName("iv")
    @ObfuscatedGetter(
            intValue = -1060101713
    )
    static int field724;
    @ObfuscatedName("hm")
    @ObfuscatedGetter(
            intValue = 105521209
    )
    static int field802;
    @ObfuscatedName("jc")
    @ObfuscatedGetter(
            intValue = 161076255
    )
    static int localPlayerIndex;
    @ObfuscatedName("bc")
    @ObfuscatedGetter(
            intValue = 837733705
    )
    static int confClientType;
    @ObfuscatedName("ky")
    static boolean[] playerOptionsPriorities;
    @ObfuscatedName("bq")
    public static boolean isMembers;
    @ObfuscatedName("eb")
    @ObfuscatedGetter(
            intValue = 820990575
    )
    static int field787;
    @ObfuscatedName("eo")
    @ObfuscatedSignature(
            signature = "[Lbo;"
    )
    static NPCEntity[] npcs;
    @ObfuscatedName("ge")
    static final int[] field704;
    @ObfuscatedName("fj")
    @ObfuscatedGetter(
            intValue = 1942528687
    )
    static int field909;
    @ObfuscatedName("in")
    static int[] overheadTextsOffsetY;
    @ObfuscatedName("lq")
    @ObfuscatedGetter(
            intValue = 1162194059
    )
    static int field795;
    @ObfuscatedName("jk")
    @ObfuscatedGetter(
            intValue = -1204358569
    )
    static int pressedItemIndex;
    @ObfuscatedName("jq")
    static boolean field673;
    public static int tickCount;
    public static boolean interpolatePlayerAnimations;
    public static boolean interpolateNpcAnimations;
    public static boolean interpolateObjectAnimations;
    public static RSItem lastItemDespawn;
    public static boolean stretchedFast;
    public static boolean stretchedKeepAspectRatio;
    public static boolean stretchedEnabled;
    public static boolean isHidingEntities;
    public static boolean hidePlayers;
    public static boolean hideFriends;
    public static boolean hideLocalPlayer;
    public static boolean hideLocalPlayer2D;
    public static boolean hideNPCs;
    public static boolean hideProjectiles;
    public static int inventoryDragDelay;
    public static boolean stretchedIntegerScaling;
    public static int skyboxColor;
    public static boolean hidePlayers2D;
    public static boolean hideClanMates;
    public static boolean hideNPCs2D;
    public static Map widgetSpriteOverrides;
    public static int[] rl$modelViewportXs;
    public static Dimension cachedStretchedDimensions;
    public static Map spriteOverrides;
    public static Dimension cachedRealDimensions;
    public static boolean hideAttackers;
    // $FF: synthetic field
    public static boolean $assertionsDisabled;
    public static int oldMenuEntryCount;
    public static boolean pitchRelaxEnabled;
    public static double scalingFactor;
    public static boolean oldIsResized;
    public static int[] rl$modelViewportYs;
    public static RSScript currentScript;
    public static int lastPitch;
    public static int itemPressedDurationBuffer;
    public static RSPlayer[] oldPlayers;
    public static int lastPitchTarget;
    public static int currentScriptPC;
    @ObfuscatedName("cn")
    @ObfuscatedGetter(
            longValue = -22427112892901145L
    )
    static long field814;
    @ObfuscatedName("hk")
    static boolean field694;
    @ObfuscatedName("lk")
    static boolean[] menuBooleanArray;
    @ObfuscatedName("fk")
    @ObfuscatedGetter(
            intValue = -320888819
    )
    static int field697;
    @ObfuscatedName("be")
    @ObfuscatedGetter(
            intValue = -1223140969
    )
    static int gameState;
    @ObfuscatedName("hv")
    @ObfuscatedGetter(
            intValue = 394784197
    )
    static int field869;
    @ObfuscatedName("kt")
    @ObfuscatedGetter(
            intValue = 1180368845
    )
    static int menuOptionCount;
    @ObfuscatedName("it")
    static String lastSelectedItemName;
    @ObfuscatedName("bv")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    static JagexLoginType loginType;
    @ObfuscatedName("kc")
    @ObfuscatedSignature(
            signature = "Lgi;"
    )
    static Deque pendingSpawns;
    @ObfuscatedName("cc")
    @ObfuscatedGetter(
            intValue = -1161939727
    )
    static int gameCycle;
    @ObfuscatedName("ic")
    @ObfuscatedGetter(
            intValue = -1622795663
    )
    static int field741;
    @ObfuscatedName("ct")
    @ObfuscatedGetter(
            intValue = -1476248727
    )
    static int hintArrowNpcTargetIdx;
    @ObfuscatedName("et")
    @ObfuscatedGetter(
            intValue = 2072049977
    )
    static int extendedInfoNpcCount;
    @ObfuscatedName("gi")
    @ObfuscatedGetter(
            intValue = 940429823
    )
    static int field778;
    @ObfuscatedName("hp")
    @ObfuscatedGetter(
            intValue = -1003168221
    )
    static int field717;
    @ObfuscatedName("jl")
    static boolean field758;
    @ObfuscatedName("ff")
    static int[] extendedInfoNpcIndexes;
    @ObfuscatedName("lv")
    static int[] menuActionParams0;
    @ObfuscatedName("ci")
    @ObfuscatedGetter(
            intValue = -2145303317
    )
    static int hintArrowOffsetX;
    @ObfuscatedName("is")
    static int[][] field740;
    @ObfuscatedName("bf")
    @ObfuscatedGetter(
            intValue = -1993024725
    )
    static int languageId;
    @ObfuscatedName("go")
    static boolean isDynamicRegion;
    @ObfuscatedName("iy")
    @ObfuscatedGetter(
            intValue = 1867567725
    )
    static int field731;
    @ObfuscatedName("kh")
    static int[] npcIndexesToRemove;
    @ObfuscatedName("ch")
    @ObfuscatedGetter(
            intValue = -134866293
    )
    static int hintArrowTargetType;
    @ObfuscatedName("gh")
    @ObfuscatedGetter(
            intValue = 471070015
    )
    static int field705;
    @ObfuscatedName("ey")
    @ObfuscatedGetter(
            intValue = 1886499919
    )
    static int field679;
    @ObfuscatedName("ko")
    static int[] npcFacingDirections;
    @ObfuscatedName("co")
    static boolean field919;
    @ObfuscatedName("lw")
    static int[] menuTypes;
    @ObfuscatedName("dj")
    @ObfuscatedGetter(
            intValue = 1548684875
    )
    static int field682;
    @ObfuscatedName("hj")
    @ObfuscatedGetter(
            intValue = -1285967911
    )
    static int field707;
    @ObfuscatedName("hu")
    @ObfuscatedGetter(
            intValue = -1247102131
    )
    static int field721;
    @ObfuscatedName("kg")
    static String[] playerOptions;
    @ObfuscatedName("cd")
    static boolean field654;
    @ObfuscatedName("hg")
    @ObfuscatedGetter(
            intValue = 1070355435
    )
    static int mapAngle;
    @ObfuscatedName("id")
    static String[] overheadTexts;
    @ObfuscatedName("cu")
    @ObfuscatedGetter(
            intValue = 886809889
    )
    static int field668;
    @ObfuscatedName("eu")
    @ObfuscatedGetter(
            intValue = 657561619
    )
    static int field760;
    @ObfuscatedName("ju")
    @ObfuscatedGetter(
            intValue = 2130768331
    )
    static int cursorState;
    @ObfuscatedName("ku")
    @ObfuscatedGetter(
            intValue = -1193656921
    )
    static int field866;
    @ObfuscatedName("jx")
    @ObfuscatedGetter(
            intValue = 2107023703
    )
    static int field809;
    @ObfuscatedName("lx")
    static boolean field789;
    @ObfuscatedName("ex")
    @ObfuscatedGetter(
            intValue = -616937085
    )
    static int field678;
    @ObfuscatedName("fa")
    static boolean socketError;
    @ObfuscatedName("ia")
    @ObfuscatedGetter(
            intValue = -1849243845
    )
    static int lastLeftClickX;
    @ObfuscatedName("fo")
    @ObfuscatedGetter(
            intValue = 1552059529
    )
    static int field696;
    @ObfuscatedName("im")
    @ObfuscatedGetter(
            intValue = 526406567
    )
    static int screenX;
    @ObfuscatedName("bl")
    @ObfuscatedGetter(
            intValue = -2009426805
    )
    static int field650;
    @ObfuscatedName("fr")
    static boolean field822;
    @ObfuscatedName("lo")
    static String[] menuTargets;
    @ObfuscatedName("ib")
    static int[] overheadTextsOffsetX;
    @ObfuscatedName("bw")
    static boolean lowMemory;
    @ObfuscatedName("fp")
    @ObfuscatedSignature(
            signature = "Ljp;"
    )
    static class144 field904;
    @ObfuscatedName("ip")
    static int[] field737;
    @ObfuscatedName("ll")
    static String[] menuOptions;
    @ObfuscatedName("jv")
    @ObfuscatedGetter(
            intValue = 1042582895
    )
    static int itemPressedDuration;
    @ObfuscatedName("bi")
    @ObfuscatedGetter(
            intValue = -2116376601
    )
    static int socketType;
    @ObfuscatedName("cf")
    @ObfuscatedGetter(
            intValue = -677760571
    )
    static int field643;
    @ObfuscatedName("ks")
    @ObfuscatedGetter(
            intValue = -425138385
    )
    static int field769;
    @ObfuscatedName("cs")
    @ObfuscatedGetter(
            intValue = 239425513
    )
    static int hintArrowPlayerTargetIdx;
    @ObfuscatedName("io")
    @ObfuscatedGetter(
            intValue = 1414780731
    )
    static int field729;
    @ObfuscatedName("ht")
    @ObfuscatedGetter(
            intValue = 1899281913
    )
    static int field715;
    @ObfuscatedName("jw")
    @ObfuscatedGetter(
            intValue = -552062473
    )
    static int field797;
    @ObfuscatedName("dm")
    @ObfuscatedSignature(
            signature = "Lcb;"
    )
    static AttackOpPriority npcAttackOpPriority;
    @ObfuscatedName("gy")
    @ObfuscatedGetter(
            intValue = -586266321
    )
    static int field917;
    @ObfuscatedName("kr")
    static int[] skillBaseLevels;
    @ObfuscatedName("jj")
    @ObfuscatedGetter(
            intValue = -621689733
    )
    static int field751;
    @Inject
    @Named("Core Logger")
    public Logger logger;
    public DrawCallbacks drawCallbacks;
    public boolean gpu;
    @Inject
    public Callbacks callbacks;
    public Cache varbitCache;

    static {
        field856 = true;
        world = 1;
        flags = 0;
        socketType = 0;
        isMembers = false;
        lowMemory = false;
        languageId = 0;
        confClientType = -1;
        field770 = false;
        gameState = 0;
        field654 = true;
        gameCycle = 0;
        mouseLastLastPressedTimeMillis = -1L;
        field735 = -1;
        field643 = -1;
        field814 = -1L;
        field919 = true;
        displayFps = false;
        rebootTimer = 0;
        hintArrowTargetType = 0;
        hintArrowNpcTargetIdx = 0;
        hintArrowPlayerTargetIdx = 0;
        hintArrowX = 0;
        hintArrowY = 0;
        field668 = 0;
        hintArrowOffsetX = 0;
        hintArrowOffsetY = 0;
        playerAttackOpPriority = AttackOpPriority.HIDDEN;
        npcAttackOpPriority = AttackOpPriority.HIDDEN;
        loadingStage = 0;
        js5State = 0;
        field682 = 0;
        field787 = 0;
        loginState = 0;
        field678 = 0;
        field679 = 0;
        field760 = 0;
        field681 = AuthProt.field1964;
        Login_isUsernameRemembered = false;
        field683 = new class159();
        field708 = null;
        npcs = new NPCEntity['耀'];
        highResolutionNpcCount = 0;
        highResolutionNpcIndexes = new int['耀'];
        extendedInfoNpcCount = 0;
        extendedInfoNpcIndexes = new int[250];
        serverConnection = new ServerConnection();
        field725 = 0;
        socketError = false;
        field822 = true;
        field904 = new class144();
        fontsMap = new HashMap();
        field696 = 0;
        field697 = 1;
        field753 = 0;
        field909 = 1;
        field700 = 0;
        collisionMaps = new CollisionData[4];
        isDynamicRegion = false;
        instanceTemplateChunks = new int[4][13][13];
        field704 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        field705 = 0;
        field917 = 2301979;
        field778 = 5063219;
        field883 = 3353893;
        field709 = 7759444;
        field694 = false;
        field802 = 0;
        cameraPitchTarget = 128;
        mapAngle = 0;
        field714 = 0;
        field715 = 0;
        field869 = 0;
        field717 = 0;
        camModeType = 0;
        field719 = 50;
        field707 = 0;
        field721 = 0;
        field857 = 0;
        field723 = 12;
        field724 = 6;
        field659 = 0;
        field726 = false;
        field727 = 0;
        field728 = false;
        field729 = 0;
        overheadTextCount = 0;
        field731 = 50;
        overheadTextsX = new int[field731];
        overheadTextsY = new int[field731];
        overheadTextsOffsetY = new int[field731];
        overheadTextsOffsetX = new int[field731];
        field736 = new int[field731];
        field737 = new int[field731];
        overheadTextsCyclesRemaining = new int[field731];
        overheadTexts = new String[field731];
        field740 = new int[104][104];
        field741 = 0;
        screenX = -1;
        screenY = -1;
        lastLeftClickX = 0;
        lastLeftClickY = 0;
        field809 = 0;
        cursorState = 0;
        field748 = true;
        mouseCrosshair = 0;
        pressedItemIndex = 0;
        field751 = 0;
        field752 = 0;
        field845 = 0;
        field797 = 0;
        field673 = false;
        itemPressedDuration = 0;
        field680 = 0;
        field758 = true;
        players = new PlayerEntity[2048];
        localPlayerIndex = -1;
        field761 = 0;
        field762 = true;
        playerNameMask = 0;
        npcsToRemoveCount = 0;
        npcIndexesToRemove = new int[1000];
        playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
        playerOptions = new String[8];
        playerOptionsPriorities = new boolean[8];
        npcFacingDirections = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
        field769 = -1;
        groundItemDeque = new Deque[4][104][104];
        pendingSpawns = new Deque();
        projectiles = new Deque();
        spotAnimationDeque = new Deque();
        skillLevels = new int[25];
        skillBaseLevels = new int[25];
        skillExperiences = new int[25];
        field866 = 0;
        isMenuOpen = false;
        menuOptionCount = 0;
        menuActionParams0 = new int[500];
        menuActionParams1 = new int[500];
        menuTypes = new int[500];
        menuIdentifiers = new int[500];
        menuOptions = new String[500];
        menuTargets = new String[500];
        menuBooleanArray = new boolean[500];
        field788 = false;
        field789 = false;
        field790 = false;
        field791 = true;
        field792 = -1;
        field860 = -1;
        field794 = 0;
        field795 = 50;
        itemSelectionState = 0;
        lastSelectedItemName = null;
        spellSelected = false;
        field799 = -1;
        field734 = -1;
        targetVerb = null;
        opBase = null;
        toplevel = -1;
        subInterfaces = new HashTable(8);
        field805 = 0;
        field642 = -1;
        field807 = 0;
        field808 = 0;
        field880 = null;
        energy = 0;
        weight = 0;
        staffModLevel = 0;
        field813 = -1;
        playermod = false;
        field815 = null;
        draggedWidget = null;
        field817 = null;
        field906 = 0;
        field838 = 0;
        draggedOnWidget = null;
        field821 = false;
        field713 = -1;
        field823 = -1;
        field824 = false;
        field825 = -1;
        field826 = -1;
        draggingWidget = false;
        cycleCntr = 1;
        field653 = new int[32];
        field830 = 0;
        field831 = new int[32];
        field832 = 0;
        changedSkills = new int[32];
        changedSkillsCount = 0;
        chatCycle = 0;
        lastFriendTransmit = 0;
        field837 = 0;
        field858 = 0;
        field839 = 0;
        lastMiscTransmit = 0;
        field841 = 0;
        field842 = new Deque();
        field843 = new Deque();
        field844 = new Deque();
        serverActiveProperties = new HashTable(512);
        widgetCount = 0;
        field847 = -2;
        field848 = new boolean[100];
        field849 = new boolean[100];
        field706 = new boolean[100];
        widgetPositionX = new int[100];
        widgetPositionY = new int[100];
        widgetBoundsWidth = new int[100];
        widgetBoundsHeight = new int[100];
        gameDrawingMode = 0;
        field870 = 0L;
        isResized = true;
        field859 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
        publicChatMode = 0;
        tradeMode = 0;
        field862 = "";
        field840 = new long[100];
        field864 = 0;
        field865 = 0;
        field846 = new int[128];
        field867 = new int[128];
        field868 = -1L;
        field661 = -1;
        field820 = 0;
        field871 = new int[1000];
        field872 = new int[1000];
        mapIcons = new SpritePixels[1000];
        destinationX = 0;
        destinationY = 0;
        minimapRenderType = 0;
        field877 = 255;
        field878 = -1;
        field879 = false;
        field888 = 127;
        field881 = 127;
        queuedSoundEffectCount = 0;
        queuedSoundEffectIDs = new int[50];
        unknownSoundValues1 = new int[50];
        unknownSoundValues2 = new int[50];
        soundLocations = new int[50];
        audioEffects = new SoundEffect[50];
        field889 = false;
        field890 = new boolean[5];
        field891 = new int[5];
        field892 = new int[5];
        field893 = new int[5];
        field894 = new int[5];
        field649 = 256;
        field896 = 205;
        field897 = 256;
        field898 = 320;
        field899 = 1;
        field684 = 32767;
        field901 = 1;
        field754 = 32767;
        Viewport_xOffset = 0;
        Viewport_yOffset = 0;
        viewportWidth = 0;
        viewportHeight = 0;
        scale = 0;
        field908 = new PlayerComposition();
        field874 = -1;
        field910 = -1;
        field911 = new class97();
        grandExchangeOffers = new GrandExchangeOffer[8];
        field913 = new OwnWorldComparator();
        field914 = -1;
        field915 = new ArrayList(10);
        field765 = 0;
        field670 = new class228();
        field918 = new int[50];
        field900 = new int[50];
        rl$$clinit();
        rl$$clinit1();
        rl$$clinit2();
        rl$$clinit3();
        rl$$clinit4();
        rl$$clinit5();
    }

    public client() {
        this.rl$$init();
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-2048042933"
    )
    protected final void vmethod3170() {
        field870 = Tile.method4297() + 500L;
        this.method3281();
        if (toplevel != -1) {
            this.method3175(true);
        }

    }

    @ObfuscatedName("gk")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1117322195"
    )
    void method3281() {
        int var1 = FriendManager.canvasWidth;
        int var2 = class230.canvasHeight;
        if (super.field439 < var1) {
            var1 = super.field439;
        }

        if (super.field440 < var2) {
            var2 = super.field440;
        }

        if (GameEngine.options != null) {
            try {
                class256.method4842(class166.clientInstance, "resize", new Object[]{Integer.valueOf(WorldMapRectangle.method127())});
            } catch (Throwable var4) {
                ;
            }
        }

    }

    @ObfuscatedName("fn")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1444491960"
    )
    final void method3167() {
        if (rebootTimer > 1) {
            --rebootTimer;
        }

        if (field725 > 0) {
            --field725;
        }

        if (socketError) {
            socketError = false;
            WorldMapDecoration.method2943();
        } else {
            if (!isMenuOpen) {
                WorldMapType3.method1691();
            }

            int var1;
            for (var1 = 0; var1 < 100 && this.processPacket(serverConnection); ++var1) {
                ;
            }

            if (gameState == 30) {
                int var2;
                TcpConnectionMessage var14;
                while (ClientOptions.method6507()) {
                    var14 = FaceNormal.method5726(ClientProt.REFLECTION_CHECK_REPLY, serverConnection.isaac);
                    var14.packetBuffer.putByte(0);
                    var2 = var14.packetBuffer.offset;
                    class43.method617(var14.packetBuffer);
                    var14.packetBuffer.method6075(var14.packetBuffer.offset - var2);
                    serverConnection.method5881(var14);
                }

                if (field904.field3680) {
                    var14 = FaceNormal.method5726(ClientProt.field2257, serverConnection.isaac);
                    var14.packetBuffer.putByte(0);
                    var2 = var14.packetBuffer.offset;
                    field904.method2495(var14.packetBuffer);
                    var14.packetBuffer.method6075(var14.packetBuffer.offset - var2);
                    serverConnection.method5881(var14);
                    field904.method2493();
                }

                Object var32 = MapIconReference.mouseRecorder.lock;
                int var3;
                int var4;
                int var5;
                int var6;
                int var7;
                int var8;
                int var9;
                int var10;
                int var11;
                int var12;
                synchronized (MapIconReference.mouseRecorder.lock) {
                    if (!field856) {
                        MapIconReference.mouseRecorder.index = 0;
                    } else if (MouseInput.mouseLastButton != 0 || MapIconReference.mouseRecorder.index >= 40) {
                        TcpConnectionMessage var15 = null;
                        var3 = 0;
                        var4 = 0;
                        var5 = 0;
                        var6 = 0;

                        for (var7 = 0; var7 < MapIconReference.mouseRecorder.index && (var15 == null || var15.packetBuffer.offset - var3 < 246); ++var7) {
                            var4 = var7;
                            var8 = MapIconReference.mouseRecorder.ys[var7];
                            if (var8 < -1) {
                                var8 = -1;
                            } else if (var8 > 65534) {
                                var8 = 65534;
                            }

                            var9 = MapIconReference.mouseRecorder.xs[var7];
                            if (var9 < -1) {
                                var9 = -1;
                            } else if (var9 > 65534) {
                                var9 = 65534;
                            }

                            if (var9 != field735 || var8 != field643) {
                                if (var15 == null) {
                                    var15 = FaceNormal.method5726(ClientProt.EVENT_MOUSE_MOVE, serverConnection.isaac);
                                    var15.packetBuffer.putByte(0);
                                    var3 = var15.packetBuffer.offset;
                                    var15.packetBuffer.offset += 2;
                                    var5 = 0;
                                    var6 = 0;
                                }

                                if (-1L != field814) {
                                    var10 = var9 - field735;
                                    var11 = var8 - field643;
                                    var12 = (int) ((MapIconReference.mouseRecorder.field582[var7] - field814) / 20L);
                                    var5 = (int) ((long) var5 + (MapIconReference.mouseRecorder.field582[var7] - field814) % 20L);
                                } else {
                                    var10 = var9;
                                    var11 = var8;
                                    var12 = Integer.MAX_VALUE;
                                }

                                field735 = var9;
                                field643 = var8;
                                if (var12 < 8 && var10 >= -32 && var10 <= 31 && var11 >= -32 && var11 <= 31) {
                                    var10 += 32;
                                    var11 += 32;
                                    var15.packetBuffer.putShort((var12 << 12) + var11 + (var10 << 6));
                                } else if (var12 < 32 && var10 >= -128 && var10 <= 127 && var11 >= -128 && var11 <= 127) {
                                    var10 += 128;
                                    var11 += 128;
                                    var15.packetBuffer.putByte(var12 + 128);
                                    var15.packetBuffer.putShort(var11 + (var10 << 8));
                                } else if (var12 < 32) {
                                    var15.packetBuffer.putByte(var12 + 192);
                                    if (var9 != -1 && var8 != -1) {
                                        var15.packetBuffer.method6230(var9 | var8 << 16);
                                    } else {
                                        var15.packetBuffer.method6230(Integer.MIN_VALUE);
                                    }
                                } else {
                                    var15.packetBuffer.putShort((var12 & 8191) + 57344);
                                    if (var9 != -1 && var8 != -1) {
                                        var15.packetBuffer.method6230(var9 | var8 << 16);
                                    } else {
                                        var15.packetBuffer.method6230(Integer.MIN_VALUE);
                                    }
                                }

                                ++var6;
                                field814 = MapIconReference.mouseRecorder.field582[var7];
                            }
                        }

                        if (var15 != null) {
                            var15.packetBuffer.method6075(var15.packetBuffer.offset - var3);
                            var7 = var15.packetBuffer.offset;
                            var15.packetBuffer.offset = var3;
                            var15.packetBuffer.putByte(var5 / var6);
                            var15.packetBuffer.putByte(var5 % var6);
                            var15.packetBuffer.offset = var7;
                            serverConnection.method5881(var15);
                        }

                        if (var4 >= MapIconReference.mouseRecorder.index) {
                            MapIconReference.mouseRecorder.index = 0;
                        } else {
                            MapIconReference.mouseRecorder.index -= var4;
                            System.arraycopy(MapIconReference.mouseRecorder.xs, var4, MapIconReference.mouseRecorder.xs, 0, MapIconReference.mouseRecorder.index);
                            System.arraycopy(MapIconReference.mouseRecorder.ys, var4, MapIconReference.mouseRecorder.ys, 0, MapIconReference.mouseRecorder.index);
                            System.arraycopy(MapIconReference.mouseRecorder.field582, var4, MapIconReference.mouseRecorder.field582, 0, MapIconReference.mouseRecorder.index);
                        }
                    }
                }

                if (MouseInput.mouseLastButton == 1 || !WorldMapType3.middleMouseMovesCamera && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
                    long var16 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis) / 50L;
                    if (var16 > 4095L) {
                        var16 = 4095L;
                    }

                    mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis;
                    var3 = MouseInput.mouseLastPressedY;
                    if (var3 < 0) {
                        var3 = 0;
                    } else if (var3 > class230.canvasHeight) {
                        var3 = class230.canvasHeight;
                    }

                    var4 = MouseInput.mouseLastPressedX;
                    if (var4 < 0) {
                        var4 = 0;
                    } else if (var4 > FriendManager.canvasWidth) {
                        var4 = FriendManager.canvasWidth;
                    }

                    var5 = (int) var16;
                    TcpConnectionMessage var18 = FaceNormal.method5726(ClientProt.EVENT_MOUSE_CLICK, serverConnection.isaac);
                    var18.packetBuffer.putShort((MouseInput.mouseLastButton == 2 ? 1 : 0) + (var5 << 1));
                    var18.packetBuffer.putShort(var4);
                    var18.packetBuffer.putShort(var3);
                    serverConnection.method5881(var18);
                }

                if (KeyFocusListener.field387 > 0) {
                    var14 = FaceNormal.method5726(ClientProt.EVENT_KEYBOARD, serverConnection.isaac);
                    var14.packetBuffer.putShort(0);
                    var2 = var14.packetBuffer.offset;
                    long var19 = Tile.method4297();

                    for (var5 = 0; var5 < KeyFocusListener.field387; ++var5) {
                        long var21 = var19 - field868;
                        if (var21 > 16777215L) {
                            var21 = 16777215L;
                        }

                        field868 = var19;
                        var14.packetBuffer.putByteC(KeyFocusListener.field377[var5]);
                        var14.packetBuffer.method6064((int) var21);
                    }

                    var14.packetBuffer.method6074(var14.packetBuffer.offset - var2);
                    serverConnection.method5881(var14);
                }

                if (field727 > 0) {
                    --field727;
                }

                if (KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97] || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
                    field728 = true;
                }

                if (field728 && field727 <= 0) {
                    field727 = 20;
                    field728 = false;
                    var14 = FaceNormal.method5726(ClientProt.EVENT_CAMERA_POSITION, serverConnection.isaac);
                    var14.packetBuffer.putShortLEA(cameraPitchTarget);
                    var14.packetBuffer.putShortLE(mapAngle);
                    serverConnection.method5881(var14);
                }

                if (class32.field2111 && !field919) {
                    field919 = true;
                    var14 = FaceNormal.method5726(ClientProt.EVENT_APPLET_FOCUS, serverConnection.isaac);
                    var14.packetBuffer.putByte(1);
                    serverConnection.method5881(var14);
                }

                if (!class32.field2111 && field919) {
                    field919 = false;
                    var14 = FaceNormal.method5726(ClientProt.EVENT_APPLET_FOCUS, serverConnection.isaac);
                    var14.packetBuffer.putByte(0);
                    serverConnection.method5881(var14);
                }

                if (class219.worldMap != null) {
                    class219.worldMap.method1227();
                }

                if (MapLabel.field221) {
                    if (TotalQuantityComparator.clanMemberManager != null) {
                        TotalQuantityComparator.clanMemberManager.method5240();
                    }

                    for (var1 = 0; var1 < class254.highResolutionPlayerCount; ++var1) {
                        PlayerEntity var35 = players[class254.highResolutionPlayerIndexes[var1]];
                        var35.method2903();
                    }

                    MapLabel.field221 = false;
                }

                class260.method5008();
                if (gameState == 30) {
                    class134.method2200();

                    for (var1 = 0; var1 < queuedSoundEffectCount; ++var1) {
                        --unknownSoundValues2[var1];
                        if (unknownSoundValues2[var1] >= -10) {
                            SoundEffect var36 = audioEffects[var1];
                            if (var36 == null) {
                                Object var10000 = null;
                                var36 = SoundEffect.method605(class192.synths, queuedSoundEffectIDs[var1], 0);
                                if (var36 == null) {
                                    continue;
                                }

                                unknownSoundValues2[var1] += var36.method604();
                                audioEffects[var1] = var36;
                            }

                            if (unknownSoundValues2[var1] < 0) {
                                if (soundLocations[var1] != 0) {
                                    var4 = (soundLocations[var1] & 255) * 128;
                                    var5 = soundLocations[var1] >> 16 & 255;
                                    var6 = var5 * 128 + 64 - class4.localPlayer.x;
                                    if (var6 < 0) {
                                        var6 = -var6;
                                    }

                                    var7 = soundLocations[var1] >> 8 & 255;
                                    var8 = var7 * 128 + 64 - class4.localPlayer.y;
                                    if (var8 < 0) {
                                        var8 = -var8;
                                    }

                                    var9 = var8 + var6 - 128;
                                    if (var9 > var4) {
                                        unknownSoundValues2[var1] = -100;
                                        continue;
                                    }

                                    if (var9 < 0) {
                                        var9 = 0;
                                    }

                                    var3 = (var4 - var9) * field881 / var4;
                                } else {
                                    var3 = field888;
                                }

                                if (var3 > 0) {
                                    RawAudioNode var23 = var36.method611().method4097(class215.field3697);
                                    class266 var24 = class266.method5067(var23, 100, var3);
                                    var24.method5059(unknownSoundValues1[var1] - 1);
                                    class2.field413.method3581(var24);
                                }

                                unknownSoundValues2[var1] = -100;
                            }
                        } else {
                            --queuedSoundEffectCount;

                            for (var2 = var1; var2 < queuedSoundEffectCount; ++var2) {
                                queuedSoundEffectIDs[var2] = queuedSoundEffectIDs[var2 + 1];
                                audioEffects[var2] = audioEffects[var2 + 1];
                                unknownSoundValues1[var2] = unknownSoundValues1[var2 + 1];
                                unknownSoundValues2[var2] = unknownSoundValues2[var2 + 1];
                                soundLocations[var2] = soundLocations[var2 + 1];
                            }

                            --var1;
                        }
                    }

                    if (field879 && !class113.method1972()) {
                        if (field877 != 0 && field878 != -1) {
                            class139.method2413(ServerProt.music, field878, 0, field877, false);
                        }

                        field879 = false;
                    }

                    ++serverConnection.field1287;
                    if (serverConnection.field1287 > 750) {
                        WorldMapDecoration.method2943();
                    } else {
                        World.method3731();
                        ProjectileAnimation.method5594();
                        int[] var33 = class254.highResolutionPlayerIndexes;

                        for (var2 = 0; var2 < class254.highResolutionPlayerCount; ++var2) {
                            PlayerEntity var25 = players[var33[var2]];
                            if (var25 != null && var25.overheadTextCyclesRemaining > 0) {
                                --var25.overheadTextCyclesRemaining;
                                if (var25.overheadTextCyclesRemaining == 0) {
                                    var25.overhead = null;
                                }
                            }
                        }

                        for (var2 = 0; var2 < highResolutionNpcCount; ++var2) {
                            var3 = highResolutionNpcIndexes[var2];
                            NPCEntity var39 = npcs[var3];
                            if (var39 != null && var39.overheadTextCyclesRemaining > 0) {
                                --var39.overheadTextCyclesRemaining;
                                if (var39.overheadTextCyclesRemaining == 0) {
                                    var39.overhead = null;
                                }
                            }
                        }

                        ++field705;
                        if (cursorState != 0) {
                            field809 += 20;
                            if (field809 >= 400) {
                                cursorState = 0;
                            }
                        }

                        if (class92.field2357 != null) {
                            ++mouseCrosshair;
                            if (mouseCrosshair >= 15) {
                                class208.method4144(class92.field2357);
                                class92.field2357 = null;
                            }
                        }

                        ComponentType var34 = class133.field1993;
                        ComponentType var37 = class98.field495;
                        class133.field1993 = null;
                        class98.field495 = null;
                        draggedOnWidget = null;
                        field824 = false;
                        field821 = false;
                        field865 = 0;

                        while (ClanMember.method981() && field865 < 128) {
                            if (staffModLevel >= 2 && KeyFocusListener.keyPressed[82] && ChatLine.currentPressedKey == 66) {
                                String var40 = "";

                                ChatLine var38;
                                for (Iterator var41 = class202.messages.iterator(); var41.hasNext(); var40 = var40 + var38.name + ':' + var38.value + '\n') {
                                    var38 = (ChatLine) var41.next();
                                }

                                class166.clientInstance.method2988(var40);
                            } else if (camModeType != 1 || FaceNormal.currentTypedKey <= 0) {
                                field867[field865] = ChatLine.currentPressedKey;
                                field846[field865] = FaceNormal.currentTypedKey;
                                ++field865;
                            }
                        }

                        if (class60.method885() && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && field841 != 0) {
                            var3 = class4.localPlayer.field620 - field841;
                            if (var3 < 0) {
                                var3 = 0;
                            } else if (var3 > 3) {
                                var3 = 3;
                            }

                            if (var3 != class4.localPlayer.field620) {
                                class158.method2697(class4.localPlayer.pathX[0] + class158.baseX, class4.localPlayer.pathY[0] + class107.baseY, var3, false);
                            }

                            field841 = 0;
                        }

                        if (toplevel != -1) {
                            class116.method2022(toplevel, 0, 0, FriendManager.canvasWidth, class230.canvasHeight, 0, 0);
                        }

                        ++cycleCntr;
                        onCycleCntrChanged(-1);

                        while (true) {
                            ComponentType var42;
                            ComponentType var43;
                            ScriptEvent var44;
                            do {
                                var44 = (ScriptEvent) field843.method4354();
                                if (var44 == null) {
                                    while (true) {
                                        do {
                                            var44 = (ScriptEvent) field844.method4354();
                                            if (var44 == null) {
                                                while (true) {
                                                    do {
                                                        var44 = (ScriptEvent) field842.method4354();
                                                        if (var44 == null) {
                                                            this.method3256();
                                                            class193.method3792();
                                                            if (draggedWidget != null) {
                                                                this.method3272();
                                                            }

                                                            TcpConnectionMessage var45;
                                                            if (World.field1025 != null) {
                                                                class208.method4144(World.field1025);
                                                                ++itemPressedDuration;
                                                                itemPressedDurationChanged(-1);
                                                                if (MouseInput.mouseCurrentButton == 0) {
                                                                    if (field673) {
                                                                        if (World.field1025 == class260.field104 && field797 != field751) {
                                                                            ComponentType var46 = World.field1025;
                                                                            byte var29 = 0;
                                                                            if (field808 == 1 && var46.clientcode == 206) {
                                                                                var29 = 1;
                                                                            }

                                                                            if (var46.objIds[field797] <= 0) {
                                                                                var29 = 0;
                                                                            }

                                                                            if (ServerProt.method671(class101.method1704(var46))) {
                                                                                var5 = field751;
                                                                                var6 = field797;
                                                                                var46.objIds[var6] = var46.objIds[var5];
                                                                                var46.objCounts[var6] = var46.objCounts[var5];
                                                                                var46.objIds[var5] = -1;
                                                                                var46.objCounts[var5] = 0;
                                                                            } else if (var29 == 1) {
                                                                                var5 = field751;
                                                                                var6 = field797;

                                                                                while (var5 != var6) {
                                                                                    if (var5 > var6) {
                                                                                        var46.method231(var5 - 1, var5);
                                                                                        --var5;
                                                                                    } else if (var5 < var6) {
                                                                                        var46.method231(var5 + 1, var5);
                                                                                        ++var5;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                var46.method231(field797, field751);
                                                                            }

                                                                            var45 = FaceNormal.method5726(ClientProt.IF_BUTTOND2, serverConnection.isaac);
                                                                            var45.packetBuffer.putShort(field797);
                                                                            var45.packetBuffer.putShortLE(field751);
                                                                            var45.packetBuffer.method6230(World.field1025.id);
                                                                            var45.packetBuffer.putByteC(var29);
                                                                            serverConnection.method5881(var45);
                                                                        }
                                                                    } else if (this.method3173(-975793761)) {
                                                                        this.method3542(field752, field845);
                                                                    } else if (menuOptionCount > 0) {
                                                                        class219.method4423(field752, field845);
                                                                    }

                                                                    mouseCrosshair = 10;
                                                                    MouseInput.mouseLastButton = 0;
                                                                    World.field1025 = null;
                                                                } else if (itemPressedDuration >= 5 && (MouseInput.mouseLastX > field752 + 5 || MouseInput.mouseLastX < field752 - 5 || MouseInput.mouseLastY * -976212263 > field845 + 5 || MouseInput.mouseLastY * -976212263 < field845 - 5)) {
                                                                    field673 = true;
                                                                }
                                                            }

                                                            if (SceneManager.method3847()) {
                                                                var3 = SceneManager.selectedRegionTileX;
                                                                var4 = SceneManager.selectedRegionTileY;
                                                                var45 = FaceNormal.method5726(ClientProt.MOVE_GAMECLICK, serverConnection.isaac);
                                                                var45.packetBuffer.putByte(5);
                                                                var45.packetBuffer.getShort128(var4 + class107.baseY);
                                                                var45.packetBuffer.getShort128(var3 + class158.baseX);
                                                                var45.packetBuffer.putByte128(KeyFocusListener.keyPressed[82] ? (KeyFocusListener.keyPressed[81] ? 2 : 1) : 0);
                                                                serverConnection.method5881(var45);
                                                                SceneManager.method3835();
                                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                                cursorState = 1;
                                                                field809 = 0;
                                                                destinationX = var3;
                                                                destinationY = var4;
                                                            }

                                                            if (var34 != class133.field1993) {
                                                                if (var34 != null) {
                                                                    class208.method4144(var34);
                                                                }

                                                                if (class133.field1993 != null) {
                                                                    class208.method4144(class133.field1993);
                                                                }
                                                            }

                                                            if (var37 != class98.field495 && field795 == field794) {
                                                                if (var37 != null) {
                                                                    class208.method4144(var37);
                                                                }

                                                                if (class98.field495 != null) {
                                                                    class208.method4144(class98.field495);
                                                                }
                                                            }

                                                            if (class98.field495 != null) {
                                                                if (field794 < field795) {
                                                                    ++field794;
                                                                    if (field795 == field794) {
                                                                        class208.method4144(class98.field495);
                                                                    }
                                                                }
                                                            } else if (field794 > 0) {
                                                                --field794;
                                                            }

                                                            if (camModeType == 0) {
                                                                var3 = class4.localPlayer.x;
                                                                var4 = class4.localPlayer.y;
                                                                if (class192.field68 - var3 < -500 || class192.field68 - var3 > 500 || class192.field70 - var4 < -500 || class192.field70 - var4 > 500) {
                                                                    class192.field68 = var3;
                                                                    class192.field70 = var4;
                                                                }

                                                                if (var3 != class192.field68) {
                                                                    class192.field68 += (var3 - class192.field68) / 16;
                                                                }

                                                                if (var4 != class192.field70) {
                                                                    class192.field70 += (var4 - class192.field70) / 16;
                                                                }

                                                                var5 = class192.field68 >> 7;
                                                                var6 = class192.field70 >> 7;
                                                                var7 = MilliTimer.method2824(class192.field68, class192.field70, class228.level);
                                                                var8 = 0;
                                                                if (var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                                    for (var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                                        for (var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                                            var11 = class228.level;
                                                                            if (var11 < 3 && (class98.tileSettings[1][var9][var10] & 2) == 2) {
                                                                                ++var11;
                                                                            }

                                                                            var12 = var7 - class98.tileHeights[var11][var9][var10];
                                                                            if (var12 > var8) {
                                                                                var8 = var12;
                                                                            }
                                                                        }
                                                                    }
                                                                }

                                                                var9 = var8 * 192;
                                                                if (var9 > 98048) {
                                                                    var9 = 98048;
                                                                }

                                                                if (var9 < 32768) {
                                                                    var9 = 32768;
                                                                }

                                                                if (var9 > field729) {
                                                                    field729 += (var9 - field729) / 24;
                                                                } else if (var9 < field729) {
                                                                    field729 += (var9 - field729) / 80;
                                                                }

                                                                class195.field1717 = MilliTimer.method2824(class4.localPlayer.x, class4.localPlayer.y, class228.level) - field719;
                                                            } else if (camModeType == 1) {
                                                                if (field726 && class4.localPlayer != null) {
                                                                    var3 = class4.localPlayer.pathX[0];
                                                                    var4 = class4.localPlayer.pathY[0];
                                                                    if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                                                                        class192.field68 = class4.localPlayer.x;
                                                                        var5 = MilliTimer.method2824(class4.localPlayer.x, class4.localPlayer.y, class228.level) - field719;
                                                                        if (var5 < class195.field1717) {
                                                                            class195.field1717 = var5;
                                                                        }

                                                                        class192.field70 = class4.localPlayer.y;
                                                                        field726 = false;
                                                                    }
                                                                }

                                                                short var30 = -1;
                                                                if (KeyFocusListener.keyPressed[33]) {
                                                                    var30 = 0;
                                                                } else if (KeyFocusListener.keyPressed[49]) {
                                                                    var30 = 1024;
                                                                }

                                                                if (KeyFocusListener.keyPressed[48]) {
                                                                    if (var30 == 0) {
                                                                        var30 = 1792;
                                                                    } else if (var30 == 1024) {
                                                                        var30 = 1280;
                                                                    } else {
                                                                        var30 = 1536;
                                                                    }
                                                                } else if (KeyFocusListener.keyPressed[50]) {
                                                                    if (var30 == 0) {
                                                                        var30 = 256;
                                                                    } else if (var30 == 1024) {
                                                                        var30 = 768;
                                                                    } else {
                                                                        var30 = 512;
                                                                    }
                                                                }

                                                                byte var31 = 0;
                                                                if (KeyFocusListener.keyPressed[35]) {
                                                                    var31 = -1;
                                                                } else if (KeyFocusListener.keyPressed[51]) {
                                                                    var31 = 1;
                                                                }

                                                                var5 = 0;
                                                                if (var30 >= 0 || var31 != 0) {
                                                                    var5 = KeyFocusListener.keyPressed[81] ? field724 : field723;
                                                                    var5 *= 16;
                                                                    field721 = var30;
                                                                    field857 = var31;
                                                                }

                                                                if (field707 < var5) {
                                                                    field707 += var5 / 8;
                                                                    if (field707 > var5) {
                                                                        field707 = var5;
                                                                    }
                                                                } else if (field707 > var5) {
                                                                    field707 = field707 * 9 / 10;
                                                                }

                                                                if (field707 > 0) {
                                                                    var6 = field707 / 16;
                                                                    if (field721 >= 0) {
                                                                        var3 = field721 - class39.cameraYaw & 2047;
                                                                        var7 = Graphics3D.SINE[var3];
                                                                        var8 = Graphics3D.COSINE[var3];
                                                                        class192.field68 += var6 * var7 / 65536;
                                                                        class192.field70 += var6 * var8 / 65536;
                                                                    }

                                                                    if (field857 != 0) {
                                                                        class195.field1717 += var6 * field857;
                                                                        if (class195.field1717 > 0) {
                                                                            class195.field1717 = 0;
                                                                        }
                                                                    }
                                                                } else {
                                                                    field721 = -1;
                                                                    field857 = -1;
                                                                }

                                                                if (KeyFocusListener.keyPressed[13]) {
                                                                    serverConnection.method5881(FaceNormal.method5726(ClientProt.field2285, serverConnection.isaac));
                                                                    camModeType = 0;
                                                                }
                                                            }

                                                            if (MouseInput.mouseCurrentButton == 4 && WorldMapType3.middleMouseMovesCamera) {
                                                                var3 = MouseInput.mouseLastY * -976212263 - field717;
                                                                field715 = var3 * 2;
                                                                field717 = var3 != -1 && var3 != 1 ? (MouseInput.mouseLastY * -976212263 + field717) / 2 : MouseInput.mouseLastY * -976212263;
                                                                var4 = field869 - MouseInput.mouseLastX;
                                                                field714 = var4 * 2;
                                                                field869 = var4 != -1 && var4 != 1 ? (field869 + MouseInput.mouseLastX) / 2 : MouseInput.mouseLastX;
                                                            } else {
                                                                if (KeyFocusListener.keyPressed[96]) {
                                                                    field714 += (-24 - field714) / 2;
                                                                } else if (KeyFocusListener.keyPressed[97]) {
                                                                    field714 += (24 - field714) / 2;
                                                                } else {
                                                                    field714 /= 2;
                                                                }

                                                                if (KeyFocusListener.keyPressed[98]) {
                                                                    field715 += (12 - field715) / 2;
                                                                } else if (KeyFocusListener.keyPressed[99]) {
                                                                    field715 += (-12 - field715) / 2;
                                                                } else {
                                                                    field715 /= 2;
                                                                }

                                                                field717 = MouseInput.mouseLastY * -976212263;
                                                                field869 = MouseInput.mouseLastX;
                                                            }

                                                            mapAngle = field714 / 2 + mapAngle & 2047;
                                                            cameraPitchTarget += field715 / 2;
                                                            onCameraPitchTargetChanged(-1);
                                                            if (cameraPitchTarget < 128) {
                                                                cameraPitchTarget = 128;
                                                                onCameraPitchTargetChanged(-1);
                                                            }

                                                            if (cameraPitchTarget > 383) {
                                                                cameraPitchTarget = 383;
                                                                onCameraPitchTargetChanged(-1);
                                                            }

                                                            if (field889) {
                                                                Size.method4699();
                                                            }

                                                            for (var3 = 0; var3 < 5; ++var3) {
                                                                ++field894[var3];
                                                            }

                                                            MapIconReference.varcs.method4735();
                                                            var3 = ++MouseInput.mouseIdleTicks - 1;
                                                            var5 = KeyFocusListener.keyboardIdleTicks;
                                                            TcpConnectionMessage var26;
                                                            if (var3 > 15000 && var5 > 15000) {
                                                                field725 = 250;
                                                                class106.method1884(14500);
                                                                var26 = FaceNormal.method5726(ClientProt.EVENT_MOUSE_IDLE, serverConnection.isaac);
                                                                serverConnection.method5881(var26);
                                                            }

                                                            ServerProt.friendManager.method116();
                                                            ++serverConnection.field1288;
                                                            if (serverConnection.field1288 > 50) {
                                                                var26 = FaceNormal.method5726(ClientProt.NO_TIMEOUT, serverConnection.isaac);
                                                                serverConnection.method5881(var26);
                                                            }

                                                            try {
                                                                serverConnection.method5875();
                                                            } catch (IOException var27) {
                                                                WorldMapDecoration.method2943();
                                                            }

                                                            return;
                                                        }

                                                        var42 = var44.source;
                                                        if (var42.index < 0) {
                                                            break;
                                                        }

                                                        var43 = WorldMapType1.method2440(var42.layer);
                                                    } while (var43 == null || var43.children == null || var42.index >= var43.children.length || var42 != var43.children[var42.index]);

                                                    class73.method1124(var44);
                                                }
                                            }

                                            var42 = var44.source;
                                            if (var42.index < 0) {
                                                break;
                                            }

                                            var43 = WorldMapType1.method2440(var42.layer);
                                        } while (var43 == null || var43.children == null || var42.index >= var43.children.length || var42 != var43.children[var42.index]);

                                        class73.method1124(var44);
                                    }
                                }

                                var42 = var44.source;
                                if (var42.index < 0) {
                                    break;
                                }

                                var43 = WorldMapType1.method2440(var42.layer);
                            } while (var43 == null || var43.children == null || var42.index >= var43.children.length || var42 != var43.children[var42.index]);

                            class73.method1124(var44);
                        }
                    }
                }
            }
        }
    }

    @ObfuscatedName("fh")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-101"
    )
    final void method3166() {
        Object var1 = serverConnection.method5880();
        Bit var2 = serverConnection.clientPacket;

        try {
            if (loginState == 0) {
                if (Size.field100 == null && (field683.method2700() || field678 > 250)) {
                    Size.field100 = field683.method2701();
                    field683.method2699();
                    field683 = null;
                }

                if (Size.field100 != null) {
                    if (var1 != null) {
                        ((class19) var1).vmethod5603();
                        var1 = null;
                    }

                    UrlRequest.field1924 = null;
                    socketError = false;
                    field678 = 0;
                    loginState = 1;
                }
            }

            if (loginState == 1) {
                if (UrlRequest.field1924 == null) {
                    UrlRequest.field1924 = GameEngine.taskManager.method4438(class113.host, class86.myWorldPort);
                }

                if (UrlRequest.field1924.status == 2) {
                    throw new IOException();
                }

                if (UrlRequest.field1924.status == 1) {
                    if (field822) {
                        Socket var4 = (Socket) UrlRequest.field1924.value;
                        class139 var3 = new class139(var4, 40000, 5000);
                        var1 = var3;
                    } else {
                        var1 = new class288((Socket) UrlRequest.field1924.value, GameEngine.taskManager, 5000);
                    }

                    serverConnection.method5877((class19) var1);
                    UrlRequest.field1924 = null;
                    loginState = 2;
                }
            }

            if (loginState == 2) {
                serverConnection.method5882();
                TcpConnectionMessage var21 = class321.method6058();
                var21.packetBuffer.putByte(LoginProt.field2313.id);
                serverConnection.method5881(var21);
                serverConnection.method5875();
                var2.offset = 0;
                loginState = 3;
            }

            boolean var12;
            int var13;
            if (loginState == 3) {
                if (soundSystem0 != null) {
                    soundSystem0.method281();
                }

                if (class116.soundSystem1 != null) {
                    class116.soundSystem1.method281();
                }

                var12 = true;
                if (field822 && !((class19) var1).vmethod5599(1)) {
                    var12 = false;
                }

                if (var12) {
                    var13 = ((class19) var1).vmethod5607();
                    if (soundSystem0 != null) {
                        soundSystem0.method281();
                    }

                    if (class116.soundSystem1 != null) {
                        class116.soundSystem1.method281();
                    }

                    if (var13 != 0) {
                        CacheFile.method2129(var13);
                        return;
                    }

                    var2.offset = 0;
                    loginState = 4;
                }
            }

            int var33;
            if (loginState == 4) {
                if (var2.offset < 8) {
                    var33 = ((class19) var1).vmethod5598();
                    if (var33 > 8 - var2.offset) {
                        var33 = 8 - var2.offset;
                    }

                    if (var33 > 0) {
                        ((class19) var1).vmethod5600(var2.payload, var2.offset, var33);
                        var2.offset += var33;
                    }
                }

                if (var2.offset == 8) {
                    var2.offset = 0;
                    TradingPost.field6 = var2.method6084();
                    loginState = 5;
                }
            }

            int var7;
            int var9;
            int var14;
            if (loginState == 5) {
                serverConnection.clientPacket.offset = 0;
                serverConnection.method5882();
                Bit var22 = new Bit(500);
                int[] var24 = new int[]{Size.field100.nextInt(), Size.field100.nextInt(), Size.field100.nextInt(), Size.field100.nextInt()};
                var22.offset = 0;
                var22.putByte(1);
                var22.method6230(var24[0]);
                var22.method6230(var24[1]);
                var22.method6230(var24[2]);
                var22.method6230(var24[3]);
                var22.method6067(TradingPost.field6);
                int var10;
                if (gameState == 40) {
                    var22.method6230(class202.previousLoginXteaKeys[0]);
                    var22.method6230(class202.previousLoginXteaKeys[1]);
                    var22.method6230(class202.previousLoginXteaKeys[2]);
                    var22.method6230(class202.previousLoginXteaKeys[3]);
                } else {
                    var22.putByte(field681.vmethod5358());
                    switch (field681.field1968) {
                        case 0:
                        case 3:
                            var22.method6064(class228.authcode);
                            ++var22.offset;
                            break;
                        case 1:
                            var22.offset += 4;
                            break;
                        case 2:
                            LinkedHashMap var6 = GameEngine.options.authRememberTokens;
                            String var8 = class316.username;
                            var9 = var8.length();
                            var10 = 0;

                            for (int var11 = 0; var11 < var9; ++var11) {
                                var10 = (var10 << 5) - var10 + var8.charAt(var11);
                            }

                            var22.method6230(((Integer) var6.get(Integer.valueOf(var10))).intValue());
                    }

                    var22.putByte(class223.field3828.vmethod5358());
                    var22.method6198(class316.password);
                }

                var22.method6170(class79.RSA_EXPONENT, class79.RSA_MODULUS);
                class202.previousLoginXteaKeys = var24;
                TcpConnectionMessage var5 = class321.method6058();
                var5.packetBuffer.offset = 0;
                if (gameState == 40) {
                    var5.packetBuffer.putByte(LoginProt.field2312.id);
                } else {
                    var5.packetBuffer.putByte(LoginProt.field2311.id);
                }

                var5.packetBuffer.putShort(0);
                var14 = var5.packetBuffer.offset;
                var5.packetBuffer.method6230(177);
                var5.packetBuffer.method6230(1);
                var5.packetBuffer.putByte(confClientType);
                var5.packetBuffer.method6072(var22.payload, 0, var22.offset);
                var7 = var5.packetBuffer.offset;
                var5.packetBuffer.method6198(class316.username);
                var5.packetBuffer.putByte((isResized ? 1 : 0) << 1 | (lowMemory ? 1 : 0));
                var5.packetBuffer.putShort(FriendManager.canvasWidth);
                var5.packetBuffer.putShort(class230.canvasHeight);
                VarPlayerType.method5534(var5.packetBuffer);
                var5.packetBuffer.method6198(class116.sessionToken);
                var5.packetBuffer.method6230(field650);
                Packet var31 = new Packet(PlayerEntity.field634.method2131());
                PlayerEntity.field634.method2136(var31);
                var5.packetBuffer.method6072(var31.payload, 0, var31.payload.length);
                var5.packetBuffer.putByte(confClientType);
                var5.packetBuffer.method6230(0);
                var5.packetBuffer.method6230(WorldMapDecoration.anims.crc);
                var5.packetBuffer.method6230(GameCanvas.bases.crc);
                var5.packetBuffer.method6230(class98.configs.crc);
                var5.packetBuffer.method6230(class166.interfacesArchive.crc);
                var5.packetBuffer.method6230(class192.synths.crc);
                var5.packetBuffer.method6230(class239.maps.crc);
                var5.packetBuffer.method6230(ServerProt.music.crc);
                var5.packetBuffer.method6230(class113.models.crc);
                var5.packetBuffer.method6230(JagException.sprites.crc);
                var5.packetBuffer.method6230(WorldMapRectangle.textures.crc);
                var5.packetBuffer.method6230(Size.binary.crc);
                var5.packetBuffer.method6230(Isaac.jingles.crc);
                var5.packetBuffer.method6230(UrlRequester.clientscripts.crc);
                var5.packetBuffer.method6230(SpotAnimation.fontmetrics.crc);
                var5.packetBuffer.method6230(WorldMapType2.vorbis.crc);
                var5.packetBuffer.method6230(LocType.instruments.crc);
                var5.packetBuffer.method6230(class19.worldmapdata.crc);
                var5.packetBuffer.method6230(class36.defaults.crc);
                var5.packetBuffer.method6099(var24, var7, var5.packetBuffer.offset);
                var5.packetBuffer.method6074(var5.packetBuffer.offset - var14);
                serverConnection.method5881(var5);
                serverConnection.method5875();
                serverConnection.isaac = new Isaac(var24);
                int[] var15 = new int[4];

                for (var10 = 0; var10 < 4; ++var10) {
                    var15[var10] = var24[var10] + 50;
                }

                var2.method2831(var15);
                loginState = 6;
            }

            if (loginState == 6 && ((class19) var1).vmethod5598() > 0) {
                var33 = ((class19) var1).vmethod5607();
                if (var33 == 21 && gameState == 20) {
                    loginState = 9;
                } else if (var33 == 2) {
                    loginState = 11;
                } else if (var33 == 15 && gameState == 40) {
                    serverConnection.currentPacketSize = -1;
                    loginState = 16;
                } else if (var33 == 64) {
                    loginState = 7;
                } else if (var33 == 23 && field679 < 1) {
                    ++field679;
                    loginState = 0;
                } else {
                    if (var33 != 29) {
                        CacheFile.method2129(var33);
                        return;
                    }

                    loginState = 14;
                }
            }

            if (loginState == 7 && ((class19) var1).vmethod5598() > 0) {
                AbstractByteBuffer.field2438 = ((class19) var1).vmethod5607();
                loginState = 8;
            }

            if (loginState == 8 && ((class19) var1).vmethod5598() >= AbstractByteBuffer.field2438) {
                ((class19) var1).vmethod5600(var2.payload, 0, AbstractByteBuffer.field2438);
                var2.offset = 0;
                loginState = 6;
            }

            if (loginState == 9 && ((class19) var1).vmethod5598() > 0) {
                field760 = (((class19) var1).vmethod5607() + 3) * 60;
                loginState = 10;
            }

            if (loginState == 10) {
                field678 = 0;
                class150.method2560("You have only just left another world.", "Your profile will be transferred in:", field760 / 60 + " seconds.");
                if (--field760 <= 0) {
                    loginState = 0;
                }

            } else {
                if (loginState == 11 && ((class19) var1).vmethod5598() >= 1) {
                    ObjType.field3543 = ((class19) var1).vmethod5607();
                    loginState = 12;
                }

                boolean var34;
                if (loginState == 12 && ((class19) var1).vmethod5598() >= ObjType.field3543) {
                    var12 = ((class19) var1).vmethod5607() == 1;
                    ((class19) var1).vmethod5600(var2.payload, 0, 4);
                    var2.offset = 0;
                    var34 = false;
                    if (var12) {
                        var13 = var2.method2825() << 24;
                        var13 |= var2.method2825() << 16;
                        var13 |= var2.method2825() << 8;
                        var13 |= var2.method2825();
                        String var30 = class316.username;
                        var7 = var30.length();
                        int var16 = 0;
                        var9 = 0;

                        while (true) {
                            if (var9 >= var7) {
                                if (GameEngine.options.authRememberTokens.size() >= 10 && !GameEngine.options.authRememberTokens.containsKey(Integer.valueOf(var16))) {
                                    Iterator var32 = GameEngine.options.authRememberTokens.entrySet().iterator();
                                    var32.next();
                                    var32.remove();
                                }

                                GameEngine.options.authRememberTokens.put(Integer.valueOf(var16), Integer.valueOf(var13));
                                break;
                            }

                            var16 = (var16 << 5) - var16 + var30.charAt(var9);
                            ++var9;
                        }
                    }

                    if (Login_isUsernameRemembered) {
                        GameEngine.options.rememberedUsername = class316.username;
                    } else {
                        GameEngine.options.rememberedUsername = null;
                    }

                    PlayerEntity.method2919();
                    staffModLevel = ((class19) var1).vmethod5607();
                    playermod = ((class19) var1).vmethod5607() == 1;
                    localPlayerIndex = ((class19) var1).vmethod5607();
                    localPlayerIndex <<= 8;
                    localPlayerIndex += ((class19) var1).vmethod5607();
                    field761 = ((class19) var1).vmethod5607();
                    ((class19) var1).vmethod5600(var2.payload, 0, 1);
                    var2.offset = 0;
                    ServerProt[] var28 = PendingSpawn.method5554();
                    var14 = var2.method2830();
                    if (var14 < 0 || var14 >= var28.length) {
                        throw new IOException(var14 + " " + var2.offset);
                    }

                    serverConnection.currentPacket = var28[var14];
                    serverConnection.currentPacketSize = serverConnection.currentPacket.size;
                    ((class19) var1).vmethod5600(var2.payload, 0, 2);
                    var2.offset = 0;
                    serverConnection.currentPacketSize = var2.readUnsignedShort();

                    try {
                        class256.method4839(class166.clientInstance, "zap");
                    } catch (Throwable var19) {
                        ;
                    }

                    loginState = 13;
                }

                if (loginState != 13) {
                    if (loginState == 14 && ((class19) var1).vmethod5598() >= 2) {
                        var2.offset = 0;
                        ((class19) var1).vmethod5600(var2.payload, 0, 2);
                        var2.offset = 0;
                        TradingPost.field5 = var2.readUnsignedShort();
                        loginState = 15;
                    }

                    if (loginState == 15 && ((class19) var1).vmethod5598() >= TradingPost.field5) {
                        var2.offset = 0;
                        ((class19) var1).vmethod5600(var2.payload, 0, TradingPost.field5);
                        var2.offset = 0;
                        String var25 = var2.readString();
                        String var27 = var2.readString();
                        String var29 = var2.readString();
                        class150.method2560(var25, var27, var29);
                        class310.method5922(10);
                    }

                    if (loginState == 16) {
                        if (serverConnection.currentPacketSize == -1) {
                            if (((class19) var1).vmethod5598() < 2) {
                                return;
                            }

                            ((class19) var1).vmethod5600(var2.payload, 0, 2);
                            var2.offset = 0;
                            serverConnection.currentPacketSize = var2.readUnsignedShort();
                        }

                        if (((class19) var1).vmethod5598() >= serverConnection.currentPacketSize) {
                            ((class19) var1).vmethod5600(var2.payload, 0, serverConnection.currentPacketSize);
                            var2.offset = 0;
                            var33 = serverConnection.currentPacketSize;
                            field904.method2489();
                            GrandExchangeEvent.method812();
                            Spotanim.method5325(var2);
                            if (var33 != var2.offset) {
                                throw new RuntimeException();
                            }
                        }
                    } else {
                        ++field678;
                        if (field678 > 2000) {
                            if (field679 < 1) {
                                if (class220.port1 == class86.myWorldPort) {
                                    class86.myWorldPort = GrandExchangeEvent.port2;
                                } else {
                                    class86.myWorldPort = class220.port1;
                                }

                                ++field679;
                                loginState = 0;
                            } else {
                                CacheFile.method2129(-3);
                            }
                        }
                    }
                } else {
                    if (((class19) var1).vmethod5598() >= serverConnection.currentPacketSize) {
                        var2.offset = 0;
                        ((class19) var1).vmethod5600(var2.payload, 0, serverConnection.currentPacketSize);
                        field904.method2492();
                        mouseLastLastPressedTimeMillis = -1L;
                        MapIconReference.mouseRecorder.index = 0;
                        class32.field2111 = true;
                        field919 = true;
                        field868 = -1L;
                        FileSystem.method5640();
                        serverConnection.method5882();
                        serverConnection.clientPacket.offset = 0;
                        serverConnection.currentPacket = null;
                        serverConnection.field1295 = null;
                        serverConnection.field1284 = null;
                        serverConnection.field1278 = null;
                        serverConnection.currentPacketSize = 0;
                        serverConnection.field1287 = 0;
                        rebootTimer = 0;
                        field725 = 0;
                        hintArrowTargetType = 0;
                        menuOptionCount = 0;
                        onMenuOptionsChanged(-1);
                        isMenuOpen = false;
                        class106.method1884(0);
                        class202.chatLineMap.clear();
                        class202.messages.method2757();
                        class202.field1247.method5793();
                        class202.field1246 = 0;
                        itemSelectionState = 0;
                        spellSelected = false;
                        queuedSoundEffectCount = 0;
                        mapAngle = 0;
                        camModeType = 0;
                        class82.field1933 = null;
                        minimapRenderType = 0;
                        field661 = -1;
                        destinationX = 0;
                        destinationY = 0;
                        playerAttackOpPriority = AttackOpPriority.HIDDEN;
                        npcAttackOpPriority = AttackOpPriority.HIDDEN;
                        highResolutionNpcCount = 0;
                        OwnWorldComparator.method532();

                        for (var33 = 0; var33 < 2048; ++var33) {
                            players[var33] = null;
                            cachedPlayersChanged(var33);
                        }

                        for (var33 = 0; var33 < 32768; ++var33) {
                            npcs[var33] = null;
                            cachedNPCsChanged(var33);
                        }

                        field769 = -1;
                        projectiles.method4350();
                        spotAnimationDeque.method4350();

                        int var17;
                        for (var33 = 0; var33 < 4; ++var33) {
                            for (var13 = 0; var13 < 104; ++var13) {
                                for (var17 = 0; var17 < 104; ++var17) {
                                    groundItemDeque[var33][var13][var17] = null;
                                }
                            }
                        }

                        pendingSpawns = new Deque();
                        ServerProt.friendManager.method48();

                        for (var33 = 0; var33 < VarPlayerType.field3302; ++var33) {
                            VarPlayerType var26 = class189.method3717(var33);
                            if (var26 != null) {
                                class311.serverVarps[var33] = 0;
                                class311.clientVarps[var33] = 0;
                                settingsChanged(var33);
                            }
                        }

                        MapIconReference.varcs.method4753();
                        field813 = -1;
                        if (toplevel != -1) {
                            var33 = toplevel;
                            if (var33 != -1 && AuthProt.validInterfaces[var33]) {
                                ComponentType.componentIndex.method1528(var33);
                                if (class36.interfaces[var33] != null) {
                                    var34 = true;

                                    for (var17 = 0; var17 < class36.interfaces[var33].length; ++var17) {
                                        if (class36.interfaces[var33][var17] != null) {
                                            if (class36.interfaces[var33][var17].type != 2) {
                                                class36.interfaces[var33][var17] = null;
                                            } else {
                                                var34 = false;
                                            }
                                        }
                                    }

                                    if (var34) {
                                        class36.interfaces[var33] = null;
                                    }

                                    AuthProt.validInterfaces[var33] = false;
                                }
                            }
                        }

                        for (SubInterface var23 = (SubInterface) subInterfaces.method391(); var23 != null; var23 = (SubInterface) subInterfaces.method385()) {
                            class116.method2007(var23, true);
                        }

                        toplevel = -1;
                        subInterfaces = new HashTable(8);
                        field880 = null;
                        menuOptionCount = 0;
                        onMenuOptionsChanged(-1);
                        isMenuOpen = false;
                        field908.method619((int[]) null, new int[]{0, 0, 0, 0, 0}, false, -1);

                        for (var33 = 0; var33 < 8; ++var33) {
                            playerOptions[var33] = null;
                            playerOptionsChanged(var33);
                            playerOptionsPriorities[var33] = false;
                        }

                        Size.method4688();
                        field654 = true;

                        for (var33 = 0; var33 < 100; ++var33) {
                            field848[var33] = true;
                        }

                        class48.method778();
                        TotalQuantityComparator.clanMemberManager = null;
                        clanMemberManagerChanged(-1);

                        for (var33 = 0; var33 < 8; ++var33) {
                            grandExchangeOffers[var33] = new GrandExchangeOffer();
                            onGrandExchangeOffersChanged(var33);
                        }

                        ChatLine.tradingPost = null;
                        Spotanim.method5325(var2);
                        VertexNormal.field1727 = -1;
                        class107.method1888(false, var2);
                        serverConnection.currentPacket = null;
                    }

                }
            }
        } catch (IOException var20) {
            if (field679 < 1) {
                if (class86.myWorldPort == class220.port1) {
                    class86.myWorldPort = GrandExchangeEvent.port2;
                } else {
                    class86.myWorldPort = class220.port1;
                }

                ++field679;
                loginState = 0;
            } else {
                CacheFile.method2129(-2);
            }
        }
    }

    @ObfuscatedName("kw")
    @ObfuscatedSignature(
            signature = "(I)Lkg;",
            garbageValue = "-1250806061"
    )
    public Name vmethod4584() {
        return class4.localPlayer != null ? class4.localPlayer.name : null;
    }

    @ObfuscatedName("if")
    @ObfuscatedSignature(
            signature = "(ZI)V",
            garbageValue = "-1412898674"
    )
    final void method3175(boolean var1) {
        WorldMapManager.method904(toplevel, FriendManager.canvasWidth, class230.canvasHeight, var1);
    }

    @ObfuscatedName("ef")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "1016468132"
    )
    void method3165(int var1) {
        class260.socket = null;
        CacheFile.rssocket = null;
        js5State = 0;
        if (class86.myWorldPort == class220.port1) {
            class86.myWorldPort = GrandExchangeEvent.port2;
        } else {
            class86.myWorldPort = class220.port1;
        }

        ++field787;
        if (field787 >= 2 && (var1 == 7 || var1 == 9)) {
            if (gameState <= 5) {
                this.method2999("js5connect_full");
                gameState = 1000;
                gameStateChanged(-1);
            } else {
                field682 = 3000;
            }
        } else if (field787 >= 2 && var1 == 6) {
            this.method2999("js5connect_outofdate");
            gameState = 1000;
            gameStateChanged(-1);
        } else if (field787 >= 4) {
            if (gameState <= 5) {
                this.method2999("js5connect");
                gameState = 1000;
                gameStateChanged(-1);
            } else {
                field682 = 3000;
            }
        }

    }

    @ObfuscatedName("hc")
    @ObfuscatedSignature(
            signature = "(Lcf;I)Z",
            garbageValue = "-1570039626"
    )
    @Export("processPacket")
    final boolean processPacket(ServerConnection var1) {
        class19 var2 = var1.method5880();
        Bit buffer = var1.clientPacket;
        if (var2 == null) {
            return false;
        } else {
            String var17;
            int var18;
            try {
                int var5;
                if (var1.currentPacket == null) {
                    if (var1.field1286) {
                        if (!var2.vmethod5599(1)) {
                            return false;
                        }

                        var2.vmethod5600(var1.clientPacket.payload, 0, 1);
                        var1.field1287 = 0;
                        var1.field1286 = false;
                    }

                    buffer.offset = 0;
                    if (buffer.method2829()) {
                        if (!var2.vmethod5599(1)) {
                            return false;
                        }

                        var2.vmethod5600(var1.clientPacket.payload, 1, 1);
                        var1.field1287 = 0;
                    }

                    var1.field1286 = true;
                    ServerProt[] var4 = PendingSpawn.method5554();
                    var5 = buffer.method2830();
                    if (var5 < 0 || var5 >= var4.length) {
                        throw new IOException(var5 + " " + buffer.offset);
                    }

                    var1.currentPacket = var4[var5];
                    var1.currentPacketSize = var1.currentPacket.size;
                }

                if (var1.currentPacketSize == -1) {
                    if (!var2.vmethod5599(1)) {
                        return false;
                    }

                    var1.method5880().vmethod5600(buffer.payload, 0, 1);
                    var1.currentPacketSize = buffer.payload[0] & 255;
                }

                if (var1.currentPacketSize == -2) {
                    if (!var2.vmethod5599(2)) {
                        return false;
                    }

                    var1.method5880().vmethod5600(buffer.payload, 0, 2);
                    buffer.offset = 0;
                    var1.currentPacketSize = buffer.readUnsignedShort();
                }

                if (!var2.vmethod5599(var1.currentPacketSize)) {
                    return false;
                }

                buffer.offset = 0;
                var2.vmethod5600(buffer.payload, 0, var1.currentPacketSize);
                var1.field1287 = 0;
                field904.method2505();
                var1.field1278 = var1.field1284;
                var1.field1284 = var1.field1295;
                var1.field1295 = var1.currentPacket;
                if (ServerProt.STATIC_REGION == var1.currentPacket) {
                    class107.method1888(false, var1.clientPacket);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.LOGOUT == var1.currentPacket) {
                    class9.method133();
                    var1.currentPacket = null;
                    return false;
                }

                if (ServerProt.UPDATE_RUNENERGY == var1.currentPacket) {
                    WorldComparator.method6483();
                    energy = buffer.readUnsignedByte();
                    lastMiscTransmit = cycleCntr;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_RUNWEIGHT == var1.currentPacket) {
                    WorldComparator.method6483();
                    weight = buffer.method6123();
                    lastMiscTransmit = cycleCntr;
                    var1.currentPacket = null;
                    return true;
                }

                ComponentType var6;
                int var7;
                int var8;
                int var9;
                int var10;
                int var16;
                if (ServerProt.UPDATE_INV_FULL == var1.currentPacket) {
                    var16 = buffer.getInt();
                    var5 = buffer.readUnsignedShort();
                    if (var16 < -70000) {
                        var5 += 32768;
                    }

                    if (var16 >= 0) {
                        var6 = WorldMapType1.method2440(var16);
                    } else {
                        var6 = null;
                    }

                    if (var6 != null) {
                        for (var7 = 0; var7 < var6.objIds.length; ++var7) {
                            var6.objIds[var7] = 0;
                            var6.objCounts[var7] = 0;
                        }
                    }

                    SpotAnimation.method5442(var5);
                    var7 = buffer.readUnsignedShort();

                    for (var8 = 0; var8 < var7; ++var8) {
                        var9 = buffer.readUnsignedShort();
                        var10 = buffer.readUnsignedByte();
                        if (var10 == 255) {
                            var10 = buffer.getIntV2();
                        }

                        if (var6 != null && var8 < var6.objIds.length) {
                            var6.objIds[var8] = var9;
                            var6.objCounts[var8] = var10;
                        }

                        WorldMapType2.method3130(var5, var8, var9 - 1, var10);
                    }

                    if (var6 != null) {
                        class208.method4144(var6);
                    }

                    WorldComparator.method6483();
                    field831[++field832 - 1 & 31] = var5 & 32767;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_SETMODEL == var1.currentPacket) {
                    var16 = buffer.getIntV2();
                    var5 = buffer.readLEShortA();
                    var6 = WorldMapType1.method2440(var16);
                    if (var6.modelType != 1 || var5 != var6.modelId) {
                        var6.modelType = 1;
                        var6.modelId = var5;
                        class208.method4144(var6);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_SETTEXT == var1.currentPacket) {
                    var16 = buffer.getInt();
                    var17 = buffer.readString();
                    var6 = WorldMapType1.method2440(var16);
                    if (!var17.equals(var6.text)) {
                        var6.text = var17;
                        class208.method4144(var6);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.RESET_ANIMS == var1.currentPacket) {
                    for (var16 = 0; var16 < players.length; ++var16) {
                        if (players[var16] != null) {
                            players[var16].animation = -1;
                            players[var16].animationChanged(-1);
                        }
                    }

                    for (var16 = 0; var16 < npcs.length; ++var16) {
                        if (npcs[var16] != null) {
                            npcs[var16].animation = -1;
                            npcs[var16].animationChanged(-1);
                        }
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.SYNTH_SOUND == var1.currentPacket) {
                    var16 = buffer.readUnsignedShort();
                    var5 = buffer.readUnsignedByte();
                    var18 = buffer.readUnsignedShort();
                    MapIconReference.method4837(var16, var5, var18);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.SOUND_AREA == var1.currentPacket) {
                    class76.method1145(ZoneProt.SOUND_AREA);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.MAP_ANIM == var1.currentPacket) {
                    class76.method1145(ZoneProt.MAP_ANIM);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_PLAYER == var1.currentPacket) {
                    ClientOptions.method6506(buffer, var1.currentPacketSize);
                    class310.method5902();
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.LOGOUT_TRANSFER == var1.currentPacket) {
                    World var41 = new World();
                    var41.address = buffer.readString();
                    var41.id = buffer.readUnsignedShort();
                    var5 = buffer.getInt();
                    var41.mask = var5;
                    class310.method5922(45);
                    var2.vmethod5603();
                    var2 = null;
                    UrlRequest.method5575(var41);
                    var1.currentPacket = null;
                    return false;
                }

                if (ServerProt.UPDATE_INV_PARTIAL == var1.currentPacket) {
                    var16 = buffer.getInt();
                    var5 = buffer.readUnsignedShort();
                    if (var16 < -70000) {
                        var5 += 32768;
                    }

                    if (var16 >= 0) {
                        var6 = WorldMapType1.method2440(var16);
                    } else {
                        var6 = null;
                    }

                    for (; buffer.offset < var1.currentPacketSize; WorldMapType2.method3130(var5, var7, var8 - 1, var9)) {
                        var7 = buffer.readUSmart();
                        var8 = buffer.readUnsignedShort();
                        var9 = 0;
                        if (var8 != 0) {
                            var9 = buffer.readUnsignedByte();
                            if (var9 == 255) {
                                var9 = buffer.getInt();
                            }
                        }

                        if (var6 != null && var7 >= 0 && var7 < var6.objIds.length) {
                            var6.objIds[var7] = var8;
                            var6.objCounts[var7] = var9;
                        }
                    }

                    if (var6 != null) {
                        class208.method4144(var6);
                    }

                    WorldComparator.method6483();
                    field831[++field832 - 1 & 31] = var5 & 32767;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_ZONE_PARTIAL_FOLLOWS == var1.currentPacket) {
                    class91.updateZoneX = buffer.readN();
                    CombatInfoListHolder.updateZoneY = buffer.read128Byte();
                    var1.currentPacket = null;

                    System.out.println("[UPDATE_ZONE_PARTIAL_FOLLOWS] " + class91.updateZoneX);
                    System.out.println("[UPDATE_ZONE_PARTIAL_FOLLOWS] " + CombatInfoListHolder.updateZoneY);

                    return true;
                }

                if (ServerProt.UPDATE_INV_STOP_TRANSMIT == var1.currentPacket) {
                    var16 = buffer.readShortLE();
                    WorldMapManager.method943(var16);
                    field831[++field832 - 1 & 31] = var16 & 32767;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_UID192 == var1.currentPacket) {
                    buffer.offset += 28;
                    if (buffer.method6095()) {
                        class106.method1882(buffer, buffer.offset - 28);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.PLAY_SONG == var1.currentPacket) {
                    var16 = buffer.readLEShortA();
                    if (var16 == 65535) {
                        var16 = -1;
                    }

                    class4.method42(var16);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.MIDI_JINGLE == var1.currentPacket) {
                    var16 = buffer.method6121();
                    var5 = buffer.readShort128();
                    if (var5 == 65535) {
                        var5 = -1;
                    }

                    class101.method1698(var5, var16);
                    var1.currentPacket = null;
                    return true;
                }

                ComponentType var56;
                if (ServerProt.IF_SETPOSITION == var1.currentPacket) {
                    var16 = buffer.readNewVal();
                    var5 = buffer.method6120();
                    var18 = buffer.method6119();
                    var56 = WorldMapType1.method2440(var16);
                    if (var18 != var56.posX || var5 != var56.posY || var56.posXmode != 0 || var56.posYmode != 0) {
                        var56.posX = var18;
                        var56.posY = var5;
                        var56.posXmode = 0;
                        var56.posYmode = 0;
                        class208.method4144(var56);
                        this.method3499(var56);
                        if (var56.type == 0) {
                            class196.method4011(class36.interfaces[var16 >> 16], var56, false);
                        }
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.RESET_CLIENT_VARCACHE == var1.currentPacket) {
                    for (var16 = 0; var16 < VarPlayerType.field3302; ++var16) {
                        VarPlayerType var55 = class189.method3717(var16);
                        if (var55 != null) {
                            class311.serverVarps[var16] = 0;
                            class311.clientVarps[var16] = 0;
                            settingsChanged(var16);
                        }
                    }

                    WorldComparator.method6483();
                    field830 += 32;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_IGNORELIST == var1.currentPacket) {
                    ServerProt.friendManager.ignoreContainer.method4310(buffer, var1.currentPacketSize);
                    GrandExchangeEvent.method808();
                    lastFriendTransmit = cycleCntr;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_ZONE_PARTIAL_ENCLOSED == var1.currentPacket) {
                    CombatInfoListHolder.updateZoneY = buffer.read128Byte();
                    class91.updateZoneX = buffer.readN();

                    while (buffer.offset < var1.currentPacketSize) {
                        var16 = buffer.readUnsignedByte();
                        ZoneProt var54 = World.method3768()[var16];
                        class76.method1145(var54);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.TRIGGER_ONDIALOGABORT == var1.currentPacket) {
                    if (toplevel != -1) {
                        class124.method2087(toplevel, 0);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.REFLECTION_CHECKER == var1.currentPacket) {
                    Size.method4704(buffer, var1.currentPacketSize);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_SETANIM == var1.currentPacket) {
                    var16 = buffer.method6123();
                    var5 = buffer.getIntV2();
                    var6 = WorldMapType1.method2440(var5);
                    if (var16 != var6.animation || var16 == -1) {
                        var6.animation = var16;
                        var6.field2795 = 0;
                        var6.field2750 = 0;
                        class208.method4144(var6);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                boolean var51;
                if (ServerProt.field2181 == var1.currentPacket) {
                    var51 = buffer.readUnsignedByte() == 1;
                    if (var51) {
                        TextureProvider.field1511 = Tile.method4297() - buffer.method6084();
                        ChatLine.tradingPost = new TradingPost(buffer, true);
                    } else {
                        ChatLine.tradingPost = null;
                    }

                    field839 = cycleCntr;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.CAM_LOOKAT == var1.currentPacket) {
                    field889 = true;
                    WorldMapType2.field266 = buffer.readUnsignedByte();
                    class170.field2361 = buffer.readUnsignedByte();
                    UrlRequest.field1926 = buffer.readUnsignedShort();
                    ServerProt.field2206 = buffer.readUnsignedByte();
                    WorldMapManager.field314 = buffer.readUnsignedByte();
                    if (WorldMapManager.field314 >= 100) {
                        class166.cameraX = WorldMapType2.field266 * 128 + 64;
                        class98.cameraY = class170.field2361 * 128 + 64;
                        Packet.cameraZ = MilliTimer.method2824(class166.cameraX, class98.cameraY, class228.level) - UrlRequest.field1926;
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.LOC_CUSTOMISE == var1.currentPacket) {
                    class76.method1145(ZoneProt.LOC_ANIM);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.NPC_INFO_SMALL == var1.currentPacket) {
                    class73.updateNPCs(false, buffer);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.field2203 == var1.currentPacket) {
                    class76.method1145(ZoneProt.field2318);
                    var1.currentPacket = null;
                    return true;
                }

                SubInterface var19;
                ComponentType var20;
                if (ServerProt.IF_MOVESUB == var1.currentPacket) {
                    var16 = buffer.getInt();
                    var5 = buffer.getInt();
                    SubInterface var44 = (SubInterface) subInterfaces.method380((long) var5);
                    var19 = (SubInterface) subInterfaces.method380((long) var16);
                    if (var19 != null) {
                        class116.method2007(var19, var44 == null || var19.id != var44.id);
                    }

                    if (var44 != null) {
                        var44.method6469();
                        subInterfaces.method382(var44, (long) var16);
                    }

                    var20 = WorldMapType1.method2440(var5);
                    if (var20 != null) {
                        class208.method4144(var20);
                    }

                    var20 = WorldMapType1.method2440(var16);
                    if (var20 != null) {
                        class208.method4144(var20);
                        class196.method4011(class36.interfaces[var20.id >>> 16], var20, true);
                    }

                    if (toplevel != -1) {
                        class124.method2087(toplevel, 1);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.field2144 == var1.currentPacket) {
                    var16 = buffer.readUnsignedByte();
                    class315.method5964(var16);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.HINT_ARROW == var1.currentPacket) {
                    hintArrowTargetType = buffer.readUnsignedByte();
                    if (hintArrowTargetType == 1) {
                        hintArrowNpcTargetIdx = buffer.readUnsignedShort();
                    }

                    if (hintArrowTargetType >= 2 && hintArrowTargetType <= 6) {
                        if (hintArrowTargetType == 2) {
                            hintArrowOffsetX = 64;
                            hintArrowOffsetY = 64;
                        }

                        if (hintArrowTargetType == 3) {
                            hintArrowOffsetX = 0;
                            hintArrowOffsetY = 64;
                        }

                        if (hintArrowTargetType == 4) {
                            hintArrowOffsetX = 128;
                            hintArrowOffsetY = 64;
                        }

                        if (hintArrowTargetType == 5) {
                            hintArrowOffsetX = 64;
                            hintArrowOffsetY = 0;
                        }

                        if (hintArrowTargetType == 6) {
                            hintArrowOffsetX = 64;
                            hintArrowOffsetY = 128;
                        }

                        hintArrowTargetType = 2;
                        hintArrowX = buffer.readUnsignedShort();
                        hintArrowY = buffer.readUnsignedShort();
                        field668 = buffer.readUnsignedByte();
                    }

                    if (hintArrowTargetType == 10) {
                        hintArrowPlayerTargetIdx = buffer.readUnsignedShort();
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.SET_MAP_FLAG == var1.currentPacket) {
                    destinationX = buffer.readUnsignedByte();
                    if (destinationX == 255) {
                        destinationX = 0;
                    }

                    destinationY = buffer.readUnsignedByte();
                    if (destinationY == 255) {
                        destinationY = 0;
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_CLOSESUB == var1.currentPacket) {
                    var16 = buffer.getInt();
                    SubInterface var52 = (SubInterface) subInterfaces.method380((long) var16);
                    if (var52 != null) {
                        class116.method2007(var52, true);
                    }

                    if (field880 != null) {
                        class208.method4144(field880);
                        field880 = null;
                    }

                    var1.currentPacket = null;
                    return true;
                }

                ComponentType var49;
                if (ServerProt.IF_SETPLAYERHEAD == var1.currentPacket) {
                    var16 = buffer.getIntV2();
                    var49 = WorldMapType1.method2440(var16);
                    var49.modelType = 3;
                    var49.modelId = class4.localPlayer.composition.method627();
                    class208.method4144(var49);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.VARP_LARGE == var1.currentPacket) {
                    var16 = buffer.readUnsignedShort();
                    var5 = buffer.getInt();
                    class311.serverVarps[var16] = var5;
                    if (class311.clientVarps[var16] != var5) {
                        class311.clientVarps[var16] = var5;
                        settingsChanged(var16);
                    }

                    class196.method4012(var16);
                    field653[++field830 - 1 & 31] = var16;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.field2158 == var1.currentPacket) {
                    var16 = buffer.readShort128();
                    var5 = buffer.readShortLE();
                    var18 = buffer.readNewVal();
                    var56 = WorldMapType1.method2440(var18);
                    var56.field2723 = var16 + (var5 << 16);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.MAP_PROJANIM == var1.currentPacket) {
                    class76.method1145(ZoneProt.MAP_PROJANIM);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_SETNPCHEAD == var1.currentPacket) {
                    var16 = buffer.readLEShortA();
                    var5 = buffer.getIntV2();
                    var6 = WorldMapType1.method2440(var5);
                    if (var6.modelType != 2 || var16 != var6.modelId) {
                        var6.modelType = 2;
                        var6.modelId = var16;
                        class208.method4144(var6);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_SETOBJECT == var1.currentPacket) {
                    var16 = buffer.getInt();
                    var5 = buffer.readUnsignedShort();
                    if (var5 == 65535) {
                        var5 = -1;
                    }

                    var18 = buffer.getIntV2();
                    var56 = WorldMapType1.method2440(var16);
                    ObjType var58;
                    if (!var56.isIf3) {
                        if (var5 == -1) {
                            var56.modelType = 0;
                            var1.currentPacket = null;
                            return true;
                        }

                        var58 = Varcs.method4770(var5);
                        var56.modelType = 4;
                        var56.modelId = var5;
                        var56.xan2d = var58.xan2d;
                        var56.yan2d = var58.yan2d;
                        var56.zoom2d = var58.zoom2d * 100 / var18;
                        class208.method4144(var56);
                    } else {
                        var56.linkObjType = var5;
                        var56.linkObjCount = var18;
                        var58 = Varcs.method4770(var5);
                        var56.xan2d = var58.xan2d;
                        var56.yan2d = var58.yan2d;
                        var56.zan2d = var58.zan2d;
                        var56.offsetX2d = var58.xof2d;
                        var56.offsetY2d = var58.yof2d;
                        var56.zoom2d = var58.zoom2d;
                        if (var58.stackable == 1) {
                            var56.objNumMode = 1;
                        } else {
                            var56.objNumMode = 2;
                        }

                        if (var56.field2722 > 0) {
                            var56.zoom2d = var56.zoom2d * 32 / var56.field2722;
                        } else if (var56.sizeX > 0) {
                            var56.zoom2d = var56.zoom2d * 32 / var56.sizeX;
                        }

                        class208.method4144(var56);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                String var40;
                boolean var43;
                if (ServerProt.MESSAGE_GAME == var1.currentPacket) {
                    var16 = buffer.readUSmart();
                    var43 = buffer.readUnsignedByte() == 1;
                    var40 = "";
                    boolean var45 = false;
                    if (var43) {
                        var40 = buffer.readString();
                        if (ServerProt.friendManager.method96(new Name(var40, loginType))) {
                            var45 = true;
                        }
                    }

                    String var57 = buffer.readString();
                    if (!var45) {
                        ChatLine.method5672(var16, var40, var57);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.CAM_ANGLE == var1.currentPacket) {
                    field889 = true;
                    ClientOptions.field1027 = buffer.readUnsignedByte();
                    class230.field1939 = buffer.readUnsignedByte();
                    class147.field208 = buffer.readUnsignedShort();
                    World.field1026 = buffer.readUnsignedByte();
                    class225.field3289 = buffer.readUnsignedByte();
                    if (class225.field3289 >= 100) {
                        var16 = ClientOptions.field1027 * 128 + 64;
                        var5 = class230.field1939 * 128 + 64;
                        var18 = MilliTimer.method2824(var16, var5, class228.level) - class147.field208;
                        var7 = var16 - class166.cameraX;
                        var8 = var18 - Packet.cameraZ;
                        var9 = var5 - class98.cameraY;
                        var10 = (int) Math.sqrt((double) (var7 * var7 + var9 * var9));
                        ScriptEvent.cameraPitch = (int) (Math.atan2((double) var8, (double) var10) * 325.949D) & 2047;
                        onCameraPitchChanged(-1);
                        class39.cameraYaw = (int) (Math.atan2((double) var7, (double) var9) * -325.949D) & 2047;
                        if (ScriptEvent.cameraPitch < 128) {
                            ScriptEvent.cameraPitch = 128;
                            onCameraPitchChanged(-1);
                        }

                        if (ScriptEvent.cameraPitch > 383) {
                            ScriptEvent.cameraPitch = 383;
                            onCameraPitchChanged(-1);
                        }
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_SETSCROLLPOS == var1.currentPacket) {
                    var16 = buffer.getIntV2();
                    var5 = buffer.readLEShortA();
                    var6 = WorldMapType1.method2440(var16);
                    if (var6 != null && var6.type == 0) {
                        if (var5 > var6.scrollHeight - var6.height) {
                            var5 = var6.scrollHeight - var6.height;
                        }

                        if (var5 < 0) {
                            var5 = 0;
                        }

                        if (var5 != var6.scrollY) {
                            var6.scrollY = var5;
                            class208.method4144(var6);
                        }
                    }

                    var1.currentPacket = null;
                    return true;
                }

                String var38;
                if (ServerProt.RUNCLIENTSCRIPT == var1.currentPacket) {
                    var38 = buffer.readString();
                    Object[] var50 = new Object[var38.length() + 1];

                    for (var18 = var38.length() - 1; var18 >= 0; --var18) {
                        if (var38.charAt(var18) == 's') {
                            var50[var18 + 1] = buffer.readString();
                        } else {
                            var50[var18 + 1] = new Integer(buffer.getInt());
                        }
                    }

                    var50[0] = new Integer(buffer.getInt());
                    ScriptEvent var42 = new ScriptEvent();
                    var42.params = var50;
                    class73.method1124(var42);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_INV_CLEAR == var1.currentPacket) {
                    var16 = buffer.readNewVal();
                    var49 = WorldMapType1.method2440(var16);

                    for (var18 = 0; var18 < var49.objIds.length; ++var18) {
                        var49.objIds[var18] = -1;
                        var49.objIds[var18] = 0;
                    }

                    class208.method4144(var49);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.CHAT_FILTER_SETTINGS == var1.currentPacket) {
                    tradeMode = buffer.readN();
                    publicChatMode = buffer.readN();
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_SETANGLE == var1.currentPacket) {
                    var16 = buffer.readLEShortA();
                    var5 = buffer.readLEShortA();
                    var18 = buffer.readLEShortA();
                    var7 = buffer.getIntV2();
                    var20 = WorldMapType1.method2440(var7);
                    if (var16 != var20.xan2d || var18 != var20.yan2d || var5 != var20.zoom2d) {
                        var20.xan2d = var16;
                        var20.yan2d = var18;
                        var20.zoom2d = var5;
                        class208.method4144(var20);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.LOC_ADD_CHANGE == var1.currentPacket) {
                    System.out.println("DEBUG: LOC_ADD_CHANGE ACCESSED");
                    class76.method1145(ZoneProt.LOC_ADD_CHANGE);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.MINIMAP_TOGGLE == var1.currentPacket) {
                    minimapRenderType = buffer.readUnsignedByte();
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_SETCOLOUR == var1.currentPacket) {
                    var16 = buffer.readNewVal();
                    var5 = buffer.readShort128();
                    var18 = var5 >> 10 & 31;
                    var7 = var5 >> 5 & 31;
                    var8 = var5 & 31;
                    var9 = (var7 << 11) + (var18 << 19) + (var8 << 3);
                    ComponentType var59 = WorldMapType1.method2440(var16);
                    if (var9 != var59.color) {
                        var59.color = var9;
                        class208.method4144(var59);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                long var12;
                if (ServerProt.field2173 == var1.currentPacket) {
                    var16 = buffer.offset + var1.currentPacketSize;
                    var5 = buffer.readUnsignedShort();
                    var18 = buffer.readUnsignedShort();
                    if (var5 != toplevel) {
                        toplevel = var5;
                        this.method3175(false);
                        class76.method1149(toplevel);
                        class134.method2204(toplevel, -1869692911);

                        for (var7 = 0; var7 < 100; ++var7) {
                            field848[var7] = true;
                        }
                    }

                    SubInterface var21;
                    for (; var18-- > 0; var21.field555 = true) {
                        var7 = buffer.getInt();
                        var8 = buffer.readUnsignedShort();
                        var9 = buffer.readUnsignedByte();
                        var21 = (SubInterface) subInterfaces.method380((long) var7);
                        if (var21 != null && var8 != var21.id) {
                            class116.method2007(var21, true);
                            var21 = null;
                        }

                        if (var21 == null) {
                            var21 = WorldMapRectangle.method125(var7, var8, var9);
                        }
                    }

                    for (var19 = (SubInterface) subInterfaces.method391(); var19 != null; var19 = (SubInterface) subInterfaces.method385()) {
                        if (var19.field555) {
                            var19.field555 = false;
                        } else {
                            class116.method2007(var19, true);
                        }
                    }

                    serverActiveProperties = new HashTable(512);

                    while (buffer.offset < var16) {
                        var7 = buffer.getInt();
                        var8 = buffer.readUnsignedShort();
                        var9 = buffer.readUnsignedShort();
                        var10 = buffer.getInt();

                        for (int var11 = var8; var11 <= var9; ++var11) {
                            var12 = (long) var11 + ((long) var7 << 32);
                            serverActiveProperties.method382(new IntegerNode(var10), var12);
                        }
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.CAM_RESET == var1.currentPacket) {
                    field889 = false;

                    for (var16 = 0; var16 < 5; ++var16) {
                        field890[var16] = false;
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.OBJ_DEL == var1.currentPacket) {
                    class76.method1145(ZoneProt.GROUND_ITEM_REMOVE);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_OPEN_TOP == var1.currentPacket) {
                    var16 = buffer.readLEShortA();
                    toplevel = var16;
                    this.method3175(false);
                    class76.method1149(var16);
                    class134.method2204(toplevel, 1048567657);

                    for (var5 = 0; var5 < 100; ++var5) {
                        field848[var5] = true;
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER == var1.currentPacket) {
                    if (TotalQuantityComparator.clanMemberManager != null) {
                        TotalQuantityComparator.clanMemberManager.method4642(buffer);
                    }

                    SoundTaskDataProvider.method2527();
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_STAT == var1.currentPacket) {
                    WorldComparator.method6483();
                    var16 = buffer.method6125();
                    var5 = buffer.readN();
                    var18 = buffer.readUnsignedByte();
                    skillExperiences[var5] = var16;
                    experiencedChanged(var5);
                    skillLevels[var5] = var18;
                    boostedSkillLevelsChanged(var5);
                    skillBaseLevels[var5] = 1;

                    for (var7 = 0; var7 < 98; ++var7) {
                        if (var16 >= class37.field2844[var7]) {
                            skillBaseLevels[var5] = var7 + 2;
                        }
                    }

                    changedSkills[++changedSkillsCount - 1 & 31] = var5;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_SITESETTINGS == var1.currentPacket) {
                    class40.method597(buffer.readString());
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_FRIENDCHAT_CHANNEL_FULL == var1.currentPacket) {
                    if (var1.currentPacketSize == 0) {
                        TotalQuantityComparator.clanMemberManager = null;
                        clanMemberManagerChanged(-1);
                    } else {
                        if (TotalQuantityComparator.clanMemberManager == null) {
                            TotalQuantityComparator.clanMemberManager = new ClanMemberManager(loginType, class166.clientInstance);
                            clanMemberManagerChanged(-1);
                        }

                        TotalQuantityComparator.clanMemberManager.method4641(buffer);
                    }

                    SoundTaskDataProvider.method2527();
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.field2169 == var1.currentPacket) {
                    byte[] var39 = new byte[var1.currentPacketSize];
                    buffer.method2839(var39, 0, var39.length);
                    Packet var47 = new Packet(var39);
                    var40 = var47.readString();
                    UrlRequest.method5574(var40, true, false);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_GRANDEXCHANGE_OFFER == var1.currentPacket) {
                    var16 = buffer.readUnsignedByte();
                    if (buffer.readUnsignedByte() == 0) {
                        grandExchangeOffers[var16] = new GrandExchangeOffer();
                        onGrandExchangeOffersChanged(var16);
                        buffer.offset += 18;
                    } else {
                        --buffer.offset;
                        grandExchangeOffers[var16] = new GrandExchangeOffer(buffer, false);
                        onGrandExchangeOffersChanged(var16);
                    }

                    field858 = cycleCntr;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.FRIENDLIST_LOADED == var1.currentPacket) {
                    ServerProt.friendManager.method97();
                    lastFriendTransmit = cycleCntr;
                    var1.currentPacket = null;
                    return true;
                }

                long var22;
                long var24;
                if (ServerProt.MESSAGE_PRIVATE == var1.currentPacket) {
                    var38 = buffer.readString();
                    var22 = (long) buffer.readUnsignedShort();
                    var24 = (long) buffer.method6082();
                    ChatCrownType var26 = (ChatCrownType) class2.method20(class116.method2020(), buffer.readUnsignedByte());
                    long var27 = (var22 << 32) + var24;
                    boolean var29 = false;

                    for (int var13 = 0; var13 < 100; ++var13) {
                        if (field840[var13] == var27) {
                            var29 = true;
                            break;
                        }
                    }

                    if (ServerProt.friendManager.method96(new Name(var38, loginType))) {
                        var29 = true;
                    }

                    if (!var29 && field680 == 0) {
                        field840[field864] = var27;
                        field864 = (field864 + 1) % 100;
                        String var30 = FontTypeFace.method1779(WorldMapDecorationType.method2691(MapLabel.method5551(buffer)));
                        byte var46;
                        if (var26.moderator) {
                            var46 = 7;
                        } else {
                            var46 = 3;
                        }

                        if (var26.icon != -1) {
                            ChatLine.method5672(var46, WorldMapDecoration.method2945(var26.icon) + var38, var30);
                        } else {
                            ChatLine.method5672(var46, var38, var30);
                        }
                    }

                    var1.currentPacket = null;
                    return true;
                }

                long var31;
                if (ServerProt.MESSAGE_FRIENDCHANNEL == var1.currentPacket) {
                    var38 = buffer.readString();
                    var22 = buffer.method6084();
                    var24 = (long) buffer.readUnsignedShort();
                    var31 = (long) buffer.method6082();
                    ChatCrownType var60 = (ChatCrownType) class2.method20(class116.method2020(), buffer.readUnsignedByte());
                    var12 = (var24 << 32) + var31;
                    boolean var14 = false;

                    for (int var15 = 0; var15 < 100; ++var15) {
                        if (field840[var15] == var12) {
                            var14 = true;
                            break;
                        }
                    }

                    if (var60.ignorable && ServerProt.friendManager.method96(new Name(var38, loginType))) {
                        var14 = true;
                    }

                    if (!var14 && field680 == 0) {
                        field840[field864] = var12;
                        field864 = (field864 + 1) % 100;
                        String var34 = FontTypeFace.method1779(WorldMapDecorationType.method2691(MapLabel.method5551(buffer)));
                        if (var60.icon != -1) {
                            class192.method3787(9, WorldMapDecoration.method2945(var60.icon) + var38, var34, VarPlayerType.method5549(var22));
                        } else {
                            class192.method3787(9, var38, var34, VarPlayerType.method5549(var22));
                        }
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.MESSAGE_PRIVATE_ECHO == var1.currentPacket) {
                    var38 = buffer.readString();
                    var17 = FontTypeFace.method1779(WorldMapDecorationType.method2691(MapLabel.method5551(buffer)));
                    ChatLine.method5672(6, var38, var17);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.SYNC_CLIENT_VARCACHE == var1.currentPacket) {
                    for (var16 = 0; var16 < class311.clientVarps.length; ++var16) {
                        if (class311.serverVarps[var16] != class311.clientVarps[var16]) {
                            class311.clientVarps[var16] = class311.serverVarps[var16];
                            settingsChanged(var16);
                            class196.method4012(var16);
                            field653[++field830 - 1 & 31] = var16;
                        }
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.field2122 == var1.currentPacket) {
                    var16 = buffer.getInt();
                    if (var16 != field659) {
                        field659 = var16;
                        Size.method4702();
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.field2133 == var1.currentPacket) {
                    var51 = buffer.method6085();
                    if (var51) {
                        if (class82.field1933 == null) {
                            class82.field1933 = new class225();
                        }
                    } else {
                        class82.field1933 = null;
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.PING_STATISTICS_REQUEST == var1.currentPacket) {
                    var16 = buffer.getInt();
                    var5 = buffer.getInt();
                    var18 = GZipDecompressor.method5443();
                    TcpConnectionMessage var53 = FaceNormal.method5726(ClientProt.PING_STATISTICS, serverConnection.isaac);
                    var53.packetBuffer.putByteC(var18);
                    var53.packetBuffer.putByte(GameEngine.FPS);
                    var53.packetBuffer.putIntV1(var16);
                    var53.packetBuffer.putIntLE(var5);
                    serverConnection.method5881(var53);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.SET_PLAYER_OP == var1.currentPacket) {
                    var16 = buffer.getByte128();
                    var5 = buffer.getByte128();
                    var40 = buffer.readString();
                    if (var5 >= 1 && var5 <= 8) {
                        if (var40.equalsIgnoreCase("null")) {
                            var40 = null;
                        }

                        playerOptions[var5 - 1] = var40;
                        playerOptionsChanged(var5 - 1);
                        playerOptionsPriorities[var5 - 1] = var16 == 0;
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.VARP_SMALL == var1.currentPacket) {
                    byte var48 = buffer.readByte128();
                    var5 = buffer.readShort128();
                    class311.serverVarps[var5] = var48;
                    if (class311.clientVarps[var5] != var48) {
                        class311.clientVarps[var5] = var48;
                        settingsChanged(var5);
                    }

                    class196.method4012(var5);
                    field653[++field830 - 1 & 31] = var5;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_FRIENDLIST == var1.currentPacket) {
                    ServerProt.friendManager.method46(buffer, var1.currentPacketSize);
                    lastFriendTransmit = cycleCntr;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.OBJ_COUNT == var1.currentPacket) {
                    class76.method1145(ZoneProt.ALTER_GROUND_ITEM);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.LOC_DEL == var1.currentPacket) {
                    class76.method1145(ZoneProt.LOC_DEL);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_SETHIDE == var1.currentPacket) {
                    var16 = buffer.getInt();
                    var43 = buffer.readUnsignedByte() == 1;
                    var6 = WorldMapType1.method2440(var16);
                    if (var43 != var6.isHidden) {
                        var6.isHidden = var43;
                        var6.onHiddenChanged(-1);
                        class208.method4144(var6);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_OPEN_SUB == var1.currentPacket) {
                    var16 = buffer.getByte128();
                    var5 = buffer.readNewVal();
                    var18 = buffer.readLEShortA();
                    var19 = (SubInterface) subInterfaces.method380((long) var5);
                    if (var19 != null) {
                        class116.method2007(var19, var18 != var19.id);
                    }

                    WorldMapRectangle.method125(var5, var18, var16);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.OBJ_ADD == var1.currentPacket) {
                    class76.method1145(ZoneProt.GROUND_ITEM_ADD);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.REBUILD_REGION == var1.currentPacket) {
                    class107.method1888(true, var1.clientPacket);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_REBOOT_TIMER == var1.currentPacket) {
                    rebootTimer = buffer.readUnsignedShort() * 30;
                    lastMiscTransmit = cycleCntr;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.CAM_SHAKE == var1.currentPacket) {
                    var16 = buffer.readUnsignedByte();
                    var5 = buffer.readUnsignedByte();
                    var18 = buffer.readUnsignedByte();
                    var7 = buffer.readUnsignedByte();
                    field890[var16] = true;
                    field891[var16] = var5;
                    field892[var16] = var18;
                    field893[var16] = var7;
                    field894[var16] = 0;
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.NPC_INFO_LARGE == var1.currentPacket) {
                    class73.updateNPCs(true, buffer);
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.CHAT_FILTER_SETTINGS_PRIVATECHAT == var1.currentPacket) {
                    Overlay.field3613 = ScriptState.method421(buffer.readUnsignedByte());
                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.IF_SETTARGETPARAM == var1.currentPacket) {
                    var16 = buffer.method6125();
                    var5 = buffer.readShort128();
                    if (var5 == 65535) {
                        var5 = -1;
                    }

                    var18 = buffer.getIntV2();
                    var7 = buffer.readUnsignedShort();
                    if (var7 == 65535) {
                        var7 = -1;
                    }

                    for (var8 = var7; var8 <= var5; ++var8) {
                        var31 = ((long) var18 << 32) + (long) var8;
                        Node var33 = serverActiveProperties.method380(var31);
                        if (var33 != null) {
                            var33.method6469();
                        }

                        serverActiveProperties.method382(new IntegerNode(var16), var31);
                    }

                    var1.currentPacket = null;
                    return true;
                }

                if (ServerProt.UPDATE_ZONE_FULL_FOLLOWS == var1.currentPacket) {
                    CombatInfoListHolder.updateZoneY = buffer.readN();
                    class91.updateZoneX = buffer.readUnsignedByte();

                    for (var16 = class91.updateZoneX; var16 < class91.updateZoneX + 8; ++var16) {
                        for (var5 = CombatInfoListHolder.updateZoneY; var5 < CombatInfoListHolder.updateZoneY + 8; ++var5) {
                            if (groundItemDeque[class228.level][var16][var5] != null) {
                                groundItemDeque[class228.level][var16][var5] = null;
                                class89.method1487(var16, var5);
                            }
                        }
                    }

                    for (PendingSpawn var37 = (PendingSpawn) pendingSpawns.method4373(); var37 != null; var37 = (PendingSpawn) pendingSpawns.method4358()) {
                        if (var37.x >= class91.updateZoneX && var37.x < class91.updateZoneX + 8 && var37.y >= CombatInfoListHolder.updateZoneY && var37.y < CombatInfoListHolder.updateZoneY + 8 && var37.level == class228.level) {
                            var37.hitpoints = 0;
                        }
                    }

                    var1.currentPacket = null;
                    return true;
                }

                ProjectileAnimation.method5582("" + (var1.currentPacket != null ? var1.currentPacket.id : -1) + "," + (var1.field1284 != null ? var1.field1284.id : -1) + "," + (var1.field1278 != null ? var1.field1278.id : -1) + "," + var1.currentPacketSize, (Throwable) null, 1999033063);
                class9.method133();
            } catch (IOException var35) {
                WorldMapDecoration.method2943();
            } catch (Exception var36) {
                var17 = "" + (var1.currentPacket != null ? var1.currentPacket.id : -1) + "," + (var1.field1284 != null ? var1.field1284.id : -1) + "," + (var1.field1278 != null ? var1.field1278.id : -1) + "," + var1.currentPacketSize + "," + (class4.localPlayer.pathX[0] + class158.baseX) + "," + (class4.localPlayer.pathY[0] + class107.baseY) + ",";

                for (var18 = 0; var18 < var1.currentPacketSize && var18 < 50; ++var18) {
                    var17 = var17 + buffer.payload[var18] + ",";
                }

                ProjectileAnimation.method5582(var17, var36, 1974395110);
                class9.method133();
            }

            return true;
        }
    }

    @ObfuscatedName("ae")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "886624104"
    )
    protected final void vmethod3160() {
        ++gameCycle;
        this.method3163();
        MouseInput.method5785();

        int var1;
        try {
            if (class120.field2529 == 1) {
                var1 = class267.field2461.method4856();
                if (var1 > 0 && class267.field2461.method4945()) {
                    var1 -= WorldComparator.field0;
                    if (var1 < 0) {
                        var1 = 0;
                    }

                    class267.field2461.method4879(var1);
                } else {
                    class267.field2461.method4974();
                    class267.field2461.method4929();
                    if (UrlRequester.field1911 != null) {
                        class120.field2529 = 2;
                    } else {
                        class120.field2529 = 0;
                    }

                    GrandExchangeOffer.field39 = null;
                    class159.field1218 = null;
                }
            }
        } catch (Exception var64) {
            var64.printStackTrace();
            class267.field2461.method4974();
            class120.field2529 = 0;
            GrandExchangeOffer.field39 = null;
            class159.field1218 = null;
            UrlRequester.field1911 = null;
        }

        class76.method1147();
        KeyFocusListener var47 = KeyFocusListener.keyboard;
        int var2;
        synchronized (KeyFocusListener.keyboard) {
            ++KeyFocusListener.keyboardIdleTicks;
            KeyFocusListener.field388 = KeyFocusListener.field390;
            KeyFocusListener.field387 = 0;
            if (KeyFocusListener.field383 >= 0) {
                while (KeyFocusListener.field374 != KeyFocusListener.field383) {
                    var2 = KeyFocusListener.field381[KeyFocusListener.field374];
                    KeyFocusListener.field374 = KeyFocusListener.field374 + 1 & 127;
                    if (var2 < 0) {
                        KeyFocusListener.keyPressed[~var2] = false;
                    } else {
                        if (!KeyFocusListener.keyPressed[var2] && KeyFocusListener.field387 < KeyFocusListener.field377.length - 1) {
                            KeyFocusListener.field377[++KeyFocusListener.field387 - 1] = var2;
                        }

                        KeyFocusListener.keyPressed[var2] = true;
                    }
                }
            } else {
                for (var2 = 0; var2 < 112; ++var2) {
                    KeyFocusListener.keyPressed[var2] = false;
                }

                KeyFocusListener.field383 = KeyFocusListener.field374;
            }

            if (KeyFocusListener.field387 > 0) {
                KeyFocusListener.keyboardIdleTicks = 0;
            }

            KeyFocusListener.field390 = KeyFocusListener.field389;
        }

        MouseInput var75 = MouseInput.mouse;
        synchronized (MouseInput.mouse) {
            MouseInput.mouseCurrentButton = MouseInput.MouseHandler_currentButton;
            MouseInput.mouseLastX = MouseInput.mouseX;
            MouseInput.mouseLastY = MouseInput.mouseY * -1727565463;
            MouseInput.field472 = MouseInput.field468;
            MouseInput.mouseLastButton = MouseInput.MouseHandler_lastButton;
            MouseInput.mouseLastPressedX = MouseInput.MouseHandler_lastPressedX;
            MouseInput.mouseLastPressedY = MouseInput.MouseHandler_lastPressedY;
            MouseInput.mouseLastPressedTimeMillis = MouseInput.MouseHandler_lastPressedTimeMillis;
            MouseInput.MouseHandler_lastButton = 0;
        }

        if (IndexFile.mouseWheel != null) {
            var1 = IndexFile.mouseWheel.vmethod4533();
            field841 = var1;
        }

        if (gameState == 0) {
            class159.method2710();
            GameEngine.timer.vmethod5390();

            for (var1 = 0; var1 < 32; ++var1) {
                GameEngine.field429[var1] = 0L;
            }

            for (var1 = 0; var1 < 32; ++var1) {
                GameEngine.field444[var1] = 0L;
            }

            class117.field2363 = 0;
        } else if (gameState == 5) {
            ClientOptions.method6503(this);
            class159.method2710();
            GameEngine.timer.vmethod5390();

            for (var1 = 0; var1 < 32; ++var1) {
                GameEngine.field429[var1] = 0L;
            }

            for (var1 = 0; var1 < 32; ++var1) {
                GameEngine.field444[var1] = 0L;
            }

            class117.field2363 = 0;
        } else if (gameState != 10 && gameState != 11) {
            if (gameState == 20) {
                ClientOptions.method6503(this);
                this.method3166();
            } else if (gameState == 25) {
                NPCEntity.method2165(false);
                field696 = 0;
                boolean var67 = true;

                for (var2 = 0; var2 < Isaac.field2458.length; ++var2) {
                    if (class120.landMapFileIds[var2] != -1 && Isaac.field2458[var2] == null) {
                        Isaac.field2458[var2] = class239.maps.method1516(class120.landMapFileIds[var2], 0, 1789634852);
                        if (Isaac.field2458[var2] == null) {
                            var67 = false;
                            ++field696;
                        }
                    }

                    if (MapCacheArchiveNames.landRegionFileIds[var2] != -1 && CacheFile.field1487[var2] == null) {
                        CacheFile.field1487[var2] = class239.maps.method1554(MapCacheArchiveNames.landRegionFileIds[var2], 0, IndexStoreActionHandler.xteaKeys[var2]);
                        if (CacheFile.field1487[var2] == null) {
                            var67 = false;
                            ++field696;
                        }
                    }
                }

                if (!var67) {
                    field700 = 1;
                } else {
                    field753 = 0;
                    var67 = true;

                    int var5;
                    int var48;
                    for (var2 = 0; var2 < Isaac.field2458.length; ++var2) {
                        byte[] var3 = CacheFile.field1487[var2];
                        if (var3 != null) {
                            var48 = (class208.mapRegions[var2] >> 8) * 64 - class158.baseX;
                            var5 = (class208.mapRegions[var2] & 255) * 64 - class107.baseY;
                            if (isDynamicRegion) {
                                var48 = 10;
                                var5 = 10;
                            }

                            var67 &= class267.method5221(var3, var48, var5);
                        }
                    }

                    if (!var67) {
                        field700 = 2;
                    } else {
                        if (field700 != 0) {
                            MouseRecorder.method2747("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class76.method1147();
                        class131.sceneManager.method3795();

                        for (var2 = 0; var2 < 4; ++var2) {
                            collisionMaps[var2].method196();
                        }

                        int var49;
                        for (var2 = 0; var2 < 4; ++var2) {
                            for (var49 = 0; var49 < 104; ++var49) {
                                for (var48 = 0; var48 < 104; ++var48) {
                                    class98.tileSettings[var2][var49][var48] = 0;
                                }
                            }
                        }

                        class76.method1147();
                        class98.field493 = 99;
                        WorldMapDecoration.tileUnderlayIds = new byte[4][104][104];
                        class82.tileOverlayIds = new byte[4][104][104];
                        class98.tileOverlayPath = new byte[4][104][104];
                        class157.overlayRotations = new byte[4][104][104];
                        class306.field553 = new int[4][105][105];
                        class98.field503 = new byte[4][105][105];
                        class98.field496 = new int[105][105];
                        ModeGame.floorHues = new int[104];
                        class98.floorSaturations = new int[104];
                        Packet.field2408 = new int[104];
                        FontName.floorMultiplier = new int[104];
                        ChatPlayer.field3707 = new int[104];
                        var2 = Isaac.field2458.length;
                        AuthProt.method1669();
                        NPCEntity.method2165(true);
                        int var7;
                        int var8;
                        int var10;
                        int var11;
                        int var12;
                        int var13;
                        int var14;
                        int var15;
                        int var16;
                        int var17;
                        int var18;
                        int var19;
                        int var20;
                        int var21;
                        int var22;
                        int var51;
                        if (!isDynamicRegion) {
                            var49 = 0;

                            label1352:
                            while (true) {
                                byte[] var6;
                                if (var49 >= var2) {
                                    for (var49 = 0; var49 < var2; ++var49) {
                                        var48 = (class208.mapRegions[var49] >> 8) * 64 - class158.baseX;
                                        var5 = (class208.mapRegions[var49] & 255) * 64 - class107.baseY;
                                        var6 = Isaac.field2458[var49];
                                        if (var6 == null && IndexFile.field2075 < 800) {
                                            class76.method1147();
                                            class170.method2865(var48, var5, 64, 64);
                                        }
                                    }

                                    NPCEntity.method2165(true);
                                    var49 = 0;

                                    while (true) {
                                        if (var49 >= var2) {
                                            break label1352;
                                        }

                                        byte[] var4 = CacheFile.field1487[var49];
                                        if (var4 != null) {
                                            var5 = (class208.mapRegions[var49] >> 8) * 64 - class158.baseX;
                                            var51 = (class208.mapRegions[var49] & 255) * 64 - class107.baseY;
                                            class76.method1147();
                                            SceneManager var52 = class131.sceneManager;
                                            CollisionData[] var53 = collisionMaps;
                                            Packet var71 = new Packet(var4);
                                            var10 = -1;

                                            while (true) {
                                                var11 = var71.method6093();
                                                if (var11 == 0) {
                                                    break;
                                                }

                                                var10 += var11;
                                                var12 = 0;

                                                while (true) {
                                                    var13 = var71.readUSmart();
                                                    if (var13 == 0) {
                                                        break;
                                                    }

                                                    var12 += var13 - 1;
                                                    var14 = var12 & 63;
                                                    var15 = var12 >> 6 & 63;
                                                    var16 = var12 >> 12;
                                                    var17 = var71.readUnsignedByte();
                                                    var18 = var17 >> 2;
                                                    var19 = var17 & 3;
                                                    var20 = var15 + var5;
                                                    var21 = var51 + var14;
                                                    if (var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                                        var22 = var16;
                                                        if ((class98.tileSettings[1][var20][var21] & 2) == 2) {
                                                            var22 = var16 - 1;
                                                        }

                                                        CollisionData var23 = null;
                                                        if (var22 >= 0) {
                                                            var23 = var53[var22];
                                                        }

                                                        WorldMapRegion.method4191(var16, var20, var21, var10, var19, var18, var52, var23);
                                                    }
                                                }
                                            }
                                        }

                                        ++var49;
                                    }
                                }

                                var48 = (class208.mapRegions[var49] >> 8) * 64 - class158.baseX;
                                var5 = (class208.mapRegions[var49] & 255) * 64 - class107.baseY;
                                var6 = Isaac.field2458[var49];
                                if (var6 != null) {
                                    class76.method1147();
                                    var7 = VertexNormal.field1727 * 8 - 48;
                                    var8 = IndexFile.field2075 * 8 - 48;
                                    CollisionData[] var9 = collisionMaps;
                                    var10 = 0;

                                    label1349:
                                    while (true) {
                                        if (var10 >= 4) {
                                            Packet var50 = new Packet(var6);
                                            var11 = 0;

                                            while (true) {
                                                if (var11 >= 4) {
                                                    break label1349;
                                                }

                                                for (var12 = 0; var12 < 64; ++var12) {
                                                    for (var13 = 0; var13 < 64; ++var13) {
                                                        FrameMap.method553(var50, var11, var48 + var12, var5 + var13, var7, var8, 0);
                                                    }
                                                }

                                                ++var11;
                                            }
                                        }

                                        for (var11 = 0; var11 < 64; ++var11) {
                                            for (var12 = 0; var12 < 64; ++var12) {
                                                if (var11 + var48 > 0 && var11 + var48 < 103 && var5 + var12 > 0 && var12 + var5 < 103) {
                                                    var9[var10].flags[var11 + var48][var12 + var5] &= -16777217;
                                                }
                                            }
                                        }

                                        ++var10;
                                    }
                                }

                                ++var49;
                            }
                        }

                        int var54;
                        if (isDynamicRegion) {
                            var49 = 0;

                            label1285:
                            while (true) {
                                if (var49 >= 4) {
                                    for (var49 = 0; var49 < 13; ++var49) {
                                        for (var48 = 0; var48 < 13; ++var48) {
                                            var5 = instanceTemplateChunks[0][var49][var48];
                                            if (var5 == -1) {
                                                class170.method2865(var49 * 8, var48 * 8, 8, 8);
                                            }
                                        }
                                    }

                                    NPCEntity.method2165(true);
                                    var49 = 0;

                                    while (true) {
                                        if (var49 >= 4) {
                                            break label1285;
                                        }

                                        class76.method1147();

                                        for (var48 = 0; var48 < 13; ++var48) {
                                            for (var5 = 0; var5 < 13; ++var5) {
                                                var51 = instanceTemplateChunks[var49][var48][var5];
                                                if (var51 != -1) {
                                                    var7 = var51 >> 24 & 3;
                                                    var8 = var51 >> 1 & 3;
                                                    var54 = var51 >> 14 & 1023;
                                                    var10 = var51 >> 3 & 2047;
                                                    var11 = (var54 / 8 << 8) + var10 / 8;

                                                    for (var12 = 0; var12 < class208.mapRegions.length; ++var12) {
                                                        if (class208.mapRegions[var12] == var11 && CacheFile.field1487[var12] != null) {
                                                            class204.method4096(CacheFile.field1487[var12], var49, var48 * 8, var5 * 8, var7, (var54 & 7) * 8, (var10 & 7) * 8, var8, class131.sceneManager, collisionMaps);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        ++var49;
                                    }
                                }

                                class76.method1147();

                                for (var48 = 0; var48 < 13; ++var48) {
                                    for (var5 = 0; var5 < 13; ++var5) {
                                        boolean var76 = false;
                                        var7 = instanceTemplateChunks[var49][var48][var5];
                                        if (var7 != -1) {
                                            var8 = var7 >> 24 & 3;
                                            var54 = var7 >> 1 & 3;
                                            var10 = var7 >> 14 & 1023;
                                            var11 = var7 >> 3 & 2047;
                                            var12 = (var10 / 8 << 8) + var11 / 8;

                                            for (var13 = 0; var13 < class208.mapRegions.length; ++var13) {
                                                if (class208.mapRegions[var13] == var12 && Isaac.field2458[var13] != null) {
                                                    IDKType.method1908(Isaac.field2458[var13], var49, var48 * 8, var5 * 8, var8, (var10 & 7) * 8, (var11 & 7) * 8, var54, collisionMaps);
                                                    var76 = true;
                                                    break;
                                                }
                                            }
                                        }

                                        if (!var76) {
                                            var8 = var49;
                                            var54 = var48 * 8;
                                            var10 = var5 * 8;

                                            for (var11 = 0; var11 < 8; ++var11) {
                                                for (var12 = 0; var12 < 8; ++var12) {
                                                    class98.tileHeights[var8][var54 + var11][var12 + var10] = 0;
                                                }
                                            }

                                            if (var54 > 0) {
                                                for (var11 = 1; var11 < 8; ++var11) {
                                                    class98.tileHeights[var8][var54][var11 + var10] = class98.tileHeights[var8][var54 - 1][var11 + var10];
                                                }
                                            }

                                            if (var10 > 0) {
                                                for (var11 = 1; var11 < 8; ++var11) {
                                                    class98.tileHeights[var8][var54 + var11][var10] = class98.tileHeights[var8][var11 + var54][var10 - 1];
                                                }
                                            }

                                            if (var54 > 0 && class98.tileHeights[var8][var54 - 1][var10] != 0) {
                                                class98.tileHeights[var8][var54][var10] = class98.tileHeights[var8][var54 - 1][var10];
                                            } else if (var10 > 0 && class98.tileHeights[var8][var54][var10 - 1] != 0) {
                                                class98.tileHeights[var8][var54][var10] = class98.tileHeights[var8][var54][var10 - 1];
                                            } else if (var54 > 0 && var10 > 0 && class98.tileHeights[var8][var54 - 1][var10 - 1] != 0) {
                                                class98.tileHeights[var8][var54][var10] = class98.tileHeights[var8][var54 - 1][var10 - 1];
                                            }
                                        }
                                    }
                                }

                                ++var49;
                            }
                        }

                        NPCEntity.method2165(true);
                        class76.method1147();
                        SceneManager var65 = class131.sceneManager;
                        CollisionData[] var66 = collisionMaps;

                        for (var5 = 0; var5 < 4; ++var5) {
                            for (var51 = 0; var51 < 104; ++var51) {
                                for (var7 = 0; var7 < 104; ++var7) {
                                    if ((class98.tileSettings[var5][var51][var7] & 1) == 1) {
                                        var8 = var5;
                                        if ((class98.tileSettings[1][var51][var7] & 2) == 2) {
                                            var8 = var5 - 1;
                                        }

                                        if (var8 >= 0) {
                                            var66[var8].method199(var51, var7);
                                        }
                                    }
                                }
                            }
                        }

                        class98.field504 += (int) (Math.random() * 5.0D) - 2;
                        if (class98.field504 < -8) {
                            class98.field504 = -8;
                        }

                        if (class98.field504 > 8) {
                            class98.field504 = 8;
                        }

                        class98.field498 += (int) (Math.random() * 5.0D) - 2;
                        if (class98.field498 < -16) {
                            class98.field498 = -16;
                        }

                        if (class98.field498 > 16) {
                            class98.field498 = 16;
                        }

                        for (var5 = 0; var5 < 4; ++var5) {
                            byte[][] var68 = class98.field503[var5];
                            var12 = (int) Math.sqrt(5100.0D);
                            var13 = var12 * 768 >> 8;

                            int var55;
                            for (var14 = 1; var14 < 103; ++var14) {
                                for (var15 = 1; var15 < 103; ++var15) {
                                    var16 = class98.tileHeights[var5][var15 + 1][var14] - class98.tileHeights[var5][var15 - 1][var14];
                                    var17 = class98.tileHeights[var5][var15][var14 + 1] - class98.tileHeights[var5][var15][var14 - 1];
                                    var18 = (int) Math.sqrt((double) (var17 * var17 + var16 * var16 + 65536));
                                    var19 = (var16 << 8) / var18;
                                    var20 = 65536 / var18;
                                    var21 = (var17 << 8) / var18;
                                    var22 = (var19 * -50 + var21 * -50 + var20 * -10) / var13 + 96;
                                    var55 = (var68[var15 - 1][var14] >> 2) + (var68[var15][var14 - 1] >> 2) + (var68[var15 + 1][var14] >> 3) + (var68[var15][var14 + 1] >> 3) + (var68[var15][var14] >> 1);
                                    class98.field496[var15][var14] = var22 - var55;
                                }
                            }

                            for (var14 = 0; var14 < 104; ++var14) {
                                ModeGame.floorHues[var14] = 0;
                                class98.floorSaturations[var14] = 0;
                                Packet.field2408[var14] = 0;
                                FontName.floorMultiplier[var14] = 0;
                                ChatPlayer.field3707[var14] = 0;
                            }

                            for (var14 = -5; var14 < 109; ++var14) {
                                for (var15 = 0; var15 < 104; ++var15) {
                                    var16 = var14 + 5;
                                    if (var16 >= 0 && var16 < 104) {
                                        var17 = WorldMapDecoration.tileUnderlayIds[var5][var16][var15] & 255;
                                        if (var17 > 0) {
                                            FloorUnderlayDefinition var56 = class315.method5966(var17 - 1);
                                            ModeGame.floorHues[var15] += var56.hue;
                                            class98.floorSaturations[var15] += var56.saturation;
                                            Packet.field2408[var15] += var56.lightness;
                                            FontName.floorMultiplier[var15] += var56.hueMultiplier;
                                            ++ChatPlayer.field3707[var15];
                                        }
                                    }

                                    var17 = var14 - 5;
                                    if (var17 >= 0 && var17 < 104) {
                                        var18 = WorldMapDecoration.tileUnderlayIds[var5][var17][var15] & 255;
                                        if (var18 > 0) {
                                            FloorUnderlayDefinition var57 = class315.method5966(var18 - 1);
                                            ModeGame.floorHues[var15] -= var57.hue;
                                            class98.floorSaturations[var15] -= var57.saturation;
                                            Packet.field2408[var15] -= var57.lightness;
                                            FontName.floorMultiplier[var15] -= var57.hueMultiplier;
                                            --ChatPlayer.field3707[var15];
                                        }
                                    }
                                }

                                if (var14 >= 1 && var14 < 103) {
                                    var15 = 0;
                                    var16 = 0;
                                    var17 = 0;
                                    var18 = 0;
                                    var19 = 0;

                                    for (var20 = -5; var20 < 109; ++var20) {
                                        var21 = var20 + 5;
                                        if (var21 >= 0 && var21 < 104) {
                                            var15 += ModeGame.floorHues[var21];
                                            var16 += class98.floorSaturations[var21];
                                            var17 += Packet.field2408[var21];
                                            var18 += FontName.floorMultiplier[var21];
                                            var19 += ChatPlayer.field3707[var21];
                                        }

                                        var22 = var20 - 5;
                                        if (var22 >= 0 && var22 < 104) {
                                            var15 -= ModeGame.floorHues[var22];
                                            var16 -= class98.floorSaturations[var22];
                                            var17 -= Packet.field2408[var22];
                                            var18 -= FontName.floorMultiplier[var22];
                                            var19 -= ChatPlayer.field3707[var22];
                                        }

                                        if (var20 >= 1 && var20 < 103 && (!lowMemory || (class98.tileSettings[0][var14][var20] & 2) != 0 || (class98.tileSettings[var5][var14][var20] & 16) == 0)) {
                                            if (var5 < class98.field493) {
                                                class98.field493 = var5;
                                            }

                                            var55 = WorldMapDecoration.tileUnderlayIds[var5][var14][var20] & 255;
                                            int var24 = class82.tileOverlayIds[var5][var14][var20] & 255;
                                            if (var55 > 0 || var24 > 0) {
                                                int var25 = class98.tileHeights[var5][var14][var20];
                                                int var26 = class98.tileHeights[var5][var14 + 1][var20];
                                                int var27 = class98.tileHeights[var5][var14 + 1][var20 + 1];
                                                int var28 = class98.tileHeights[var5][var14][var20 + 1];
                                                int var29 = class98.field496[var14][var20];
                                                int var30 = class98.field496[var14 + 1][var20];
                                                int var31 = class98.field496[var14 + 1][var20 + 1];
                                                int var32 = class98.field496[var14][var20 + 1];
                                                int var33 = -1;
                                                int var34 = -1;
                                                int var35;
                                                int var36;
                                                int var37;
                                                if (var55 > 0) {
                                                    var35 = var15 * 256 / var18;
                                                    var36 = var16 / var19;
                                                    var37 = var17 / var19;
                                                    var33 = HitmarkType.method2210(var35, var36, var37);
                                                    var35 = var35 + class98.field504 & 255;
                                                    var37 += class98.field498;
                                                    if (var37 < 0) {
                                                        var37 = 0;
                                                    } else if (var37 > 255) {
                                                        var37 = 255;
                                                    }

                                                    var34 = HitmarkType.method2210(var35, var36, var37);
                                                }

                                                Overlay var38;
                                                if (var5 > 0) {
                                                    boolean var73 = true;
                                                    if (var55 == 0 && class98.tileOverlayPath[var5][var14][var20] != 0) {
                                                        var73 = false;
                                                    }

                                                    if (var24 > 0) {
                                                        var37 = var24 - 1;
                                                        var38 = (Overlay) Overlay.overlays.method951((long) var37);
                                                        Overlay var58;
                                                        if (var38 != null) {
                                                            var58 = var38;
                                                        } else {
                                                            byte[] var39 = Overlay.overlay_ref.method1516(4, var37, 1789634852);
                                                            var38 = new Overlay();
                                                            if (var39 != null) {
                                                                var38.method418(new Packet(var39), var37);
                                                            }

                                                            var38.method398();
                                                            Overlay.overlays.method957(var38, (long) var37);
                                                            var58 = var38;
                                                        }

                                                        if (!var58.isHidden) {
                                                            var73 = false;
                                                        }
                                                    }

                                                    if (var73 && var26 == var25 && var25 == var27 && var28 == var25) {
                                                        class306.field553[var5][var14][var20] |= 2340;
                                                    }
                                                }

                                                var35 = 0;
                                                if (var34 != -1) {
                                                    var35 = Graphics3D.colorPalette[class37.method577(var34, 96)];
                                                }

                                                if (var24 == 0) {
                                                    var65.method3800(var5, var14, var20, 0, 0, -1, var25, var26, var27, var28, class37.method577(var33, var29), class37.method577(var33, var30), class37.method577(var33, var31), class37.method577(var33, var32), 0, 0, 0, 0, var35, 0);
                                                } else {
                                                    var36 = class98.tileOverlayPath[var5][var14][var20] + 1;
                                                    byte var74 = class157.overlayRotations[var5][var14][var20];
                                                    int var59 = var24 - 1;
                                                    Overlay var40 = (Overlay) Overlay.overlays.method951((long) var59);
                                                    if (var40 != null) {
                                                        var38 = var40;
                                                    } else {
                                                        byte[] var41 = Overlay.overlay_ref.method1516(4, var59, 1789634852);
                                                        var40 = new Overlay();
                                                        if (var41 != null) {
                                                            var40.method418(new Packet(var41), var59);
                                                        }

                                                        var40.method398();
                                                        Overlay.overlays.method957(var40, (long) var59);
                                                        var38 = var40;
                                                    }

                                                    int var60 = var38.texture;
                                                    int var42;
                                                    int var43;
                                                    int var44;
                                                    int var45;
                                                    if (var60 >= 0) {
                                                        var43 = Graphics3D.textureLoader.vmethod5363(var60);
                                                        var42 = -1;
                                                    } else if (var38.color == 16711935) {
                                                        var42 = -2;
                                                        var60 = -1;
                                                        var43 = -2;
                                                    } else {
                                                        var42 = HitmarkType.method2210(var38.hue, var38.saturation, var38.lightness);
                                                        var44 = var38.hue + class98.field504 & 255;
                                                        var45 = var38.lightness + class98.field498;
                                                        if (var45 < 0) {
                                                            var45 = 0;
                                                        } else if (var45 > 255) {
                                                            var45 = 255;
                                                        }

                                                        var43 = HitmarkType.method2210(var44, var38.saturation, var45);
                                                    }

                                                    var44 = 0;
                                                    if (var43 != -2) {
                                                        var44 = Graphics3D.colorPalette[GameCanvas.method895(var43, 96)];
                                                    }

                                                    if (var38.otherRgbColor != -1) {
                                                        var45 = var38.otherHue + class98.field504 & 255;
                                                        int var46 = var38.otherLightness + class98.field498;
                                                        if (var46 < 0) {
                                                            var46 = 0;
                                                        } else if (var46 > 255) {
                                                            var46 = 255;
                                                        }

                                                        var43 = HitmarkType.method2210(var45, var38.otherSaturation, var46);
                                                        var44 = Graphics3D.colorPalette[GameCanvas.method895(var43, 96)];
                                                    }

                                                    var65.method3800(var5, var14, var20, var36, var74, var60, var25, var26, var27, var28, class37.method577(var33, var29), class37.method577(var33, var30), class37.method577(var33, var31), class37.method577(var33, var32), GameCanvas.method895(var42, var29), GameCanvas.method895(var42, var30), GameCanvas.method895(var42, var31), GameCanvas.method895(var42, var32), var35, var44);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            for (var14 = 1; var14 < 103; ++var14) {
                                for (var15 = 1; var15 < 103; ++var15) {
                                    if ((class98.tileSettings[var5][var15][var14] & 8) != 0) {
                                        var20 = 0;
                                    } else if (var5 > 0 && (class98.tileSettings[1][var15][var14] & 2) != 0) {
                                        var20 = var5 - 1;
                                    } else {
                                        var20 = var5;
                                    }

                                    var65.method3799(var5, var15, var14, var20);
                                }
                            }

                            WorldMapDecoration.tileUnderlayIds[var5] = null;
                            class82.tileOverlayIds[var5] = null;
                            class98.tileOverlayPath[var5] = null;
                            class157.overlayRotations[var5] = null;
                            class98.field503[var5] = null;
                        }

                        var65.method3895(-50, -10, -50);

                        for (var5 = 0; var5 < 104; ++var5) {
                            for (var51 = 0; var51 < 104; ++var51) {
                                if ((class98.tileSettings[1][var5][var51] & 2) == 2) {
                                    var65.method3797(var5, var51);
                                }
                            }
                        }

                        var5 = 1;
                        var51 = 2;
                        var7 = 4;

                        for (var8 = 0; var8 < 4; ++var8) {
                            if (var8 > 0) {
                                var5 <<= 3;
                                var51 <<= 3;
                                var7 <<= 3;
                            }

                            for (var54 = 0; var54 <= var8; ++var54) {
                                for (var10 = 0; var10 <= 104; ++var10) {
                                    for (var11 = 0; var11 <= 104; ++var11) {
                                        short var72;
                                        if ((class306.field553[var54][var11][var10] & var5) != 0) {
                                            var12 = var10;
                                            var13 = var10;
                                            var14 = var54;

                                            for (var15 = var54; var12 > 0 && (class306.field553[var54][var11][var12 - 1] & var5) != 0; --var12) {
                                                ;
                                            }

                                            while (var13 < 104 && (class306.field553[var54][var11][var13 + 1] & var5) != 0) {
                                                ++var13;
                                            }

                                            label936:
                                            while (var14 > 0) {
                                                for (var16 = var12; var16 <= var13; ++var16) {
                                                    if ((class306.field553[var14 - 1][var11][var16] & var5) == 0) {
                                                        break label936;
                                                    }
                                                }

                                                --var14;
                                            }

                                            label925:
                                            while (var15 < var8) {
                                                for (var16 = var12; var16 <= var13; ++var16) {
                                                    if ((class306.field553[var15 + 1][var11][var16] & var5) == 0) {
                                                        break label925;
                                                    }
                                                }

                                                ++var15;
                                            }

                                            var16 = (var13 - var12 + 1) * (var15 + 1 - var14);
                                            if (var16 >= 8) {
                                                var72 = 240;
                                                var18 = class98.tileHeights[var15][var11][var12] - var72;
                                                var19 = class98.tileHeights[var14][var11][var12];
                                                SceneManager.method3798(var8, 1, var11 * 128, var11 * 128, var12 * 128, var13 * 128 + 128, var18, var19);

                                                for (var20 = var14; var20 <= var15; ++var20) {
                                                    for (var21 = var12; var21 <= var13; ++var21) {
                                                        class306.field553[var20][var11][var21] &= ~var5;
                                                    }
                                                }
                                            }
                                        }

                                        if ((class306.field553[var54][var11][var10] & var51) != 0) {
                                            var12 = var11;
                                            var13 = var11;
                                            var14 = var54;

                                            for (var15 = var54; var12 > 0 && (class306.field553[var54][var12 - 1][var10] & var51) != 0; --var12) {
                                                ;
                                            }

                                            while (var13 < 104 && (class306.field553[var54][var13 + 1][var10] & var51) != 0) {
                                                ++var13;
                                            }

                                            label989:
                                            while (var14 > 0) {
                                                for (var16 = var12; var16 <= var13; ++var16) {
                                                    if ((class306.field553[var14 - 1][var16][var10] & var51) == 0) {
                                                        break label989;
                                                    }
                                                }

                                                --var14;
                                            }

                                            label978:
                                            while (var15 < var8) {
                                                for (var16 = var12; var16 <= var13; ++var16) {
                                                    if ((class306.field553[var15 + 1][var16][var10] & var51) == 0) {
                                                        break label978;
                                                    }
                                                }

                                                ++var15;
                                            }

                                            var16 = (var13 - var12 + 1) * (var15 + 1 - var14);
                                            if (var16 >= 8) {
                                                var72 = 240;
                                                var18 = class98.tileHeights[var15][var12][var10] - var72;
                                                var19 = class98.tileHeights[var14][var12][var10];
                                                SceneManager.method3798(var8, 2, var12 * 128, var13 * 128 + 128, var10 * 128, var10 * 128, var18, var19);

                                                for (var20 = var14; var20 <= var15; ++var20) {
                                                    for (var21 = var12; var21 <= var13; ++var21) {
                                                        class306.field553[var20][var21][var10] &= ~var51;
                                                    }
                                                }
                                            }
                                        }

                                        if ((class306.field553[var54][var11][var10] & var7) != 0) {
                                            var12 = var11;
                                            var13 = var11;
                                            var14 = var10;

                                            for (var15 = var10; var14 > 0 && (class306.field553[var54][var11][var14 - 1] & var7) != 0; --var14) {
                                                ;
                                            }

                                            while (var15 < 104 && (class306.field553[var54][var11][var15 + 1] & var7) != 0) {
                                                ++var15;
                                            }

                                            label1042:
                                            while (var12 > 0) {
                                                for (var16 = var14; var16 <= var15; ++var16) {
                                                    if ((class306.field553[var54][var12 - 1][var16] & var7) == 0) {
                                                        break label1042;
                                                    }
                                                }

                                                --var12;
                                            }

                                            label1031:
                                            while (var13 < 104) {
                                                for (var16 = var14; var16 <= var15; ++var16) {
                                                    if ((class306.field553[var54][var13 + 1][var16] & var7) == 0) {
                                                        break label1031;
                                                    }
                                                }

                                                ++var13;
                                            }

                                            if ((var13 - var12 + 1) * (var15 - var14 + 1) >= 4) {
                                                var16 = class98.tileHeights[var54][var12][var14];
                                                SceneManager.method3798(var8, 4, var12 * 128, var13 * 128 + 128, var14 * 128, var15 * 128 + 128, var16, var16);

                                                for (var17 = var12; var17 <= var13; ++var17) {
                                                    for (var18 = var14; var18 <= var15; ++var18) {
                                                        class306.field553[var54][var17][var18] &= ~var7;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        NPCEntity.method2165(true);
                        var5 = class98.field493;
                        if (var5 > class228.level) {
                            var5 = class228.level;
                        }

                        if (var5 < class228.level - 1) {
                            var5 = class228.level - 1;
                        }

                        if (lowMemory) {
                            class131.sceneManager.method3794(class98.field493);
                        } else {
                            class131.sceneManager.method3794(0);
                        }

                        for (var51 = 0; var51 < 104; ++var51) {
                            for (var7 = 0; var7 < 104; ++var7) {
                                class89.method1487(var51, var7);
                            }
                        }

                        class76.method1147();

                        for (PendingSpawn var69 = (PendingSpawn) pendingSpawns.method4373(); var69 != null; var69 = (PendingSpawn) pendingSpawns.method4358()) {
                            if (var69.hitpoints == -1) {
                                var69.delay = 0;
                                class2.method19(var69);
                            } else {
                                var69.method6469();
                            }
                        }

                        LocType.field3457.method952();
                        TcpConnectionMessage var70;
                        if (class166.clientInstance.method3002()) {
                            var70 = FaceNormal.method5726(ClientProt.DETECT_MODIFIED_CLIENT, serverConnection.isaac);
                            var70.packetBuffer.method6230(1057001181);
                            serverConnection.method5881(var70);
                        }

                        if (!isDynamicRegion) {
                            var51 = (VertexNormal.field1727 - 6) / 8;
                            var7 = (VertexNormal.field1727 + 6) / 8;
                            var8 = (IndexFile.field2075 - 6) / 8;
                            var54 = (IndexFile.field2075 + 6) / 8;

                            for (var10 = var51 - 1; var10 <= var7 + 1; ++var10) {
                                for (var11 = var8 - 1; var11 <= var54 + 1; ++var11) {
                                    if (var10 < var51 || var10 > var7 || var11 < var8 || var11 > var54) {
                                        class239.maps.method1513("m" + var10 + "_" + var11);
                                        class239.maps.method1513("l" + var10 + "_" + var11);
                                    }
                                }
                            }
                        }

                        class310.method5922(30);
                        class76.method1147();
                        WorldMapDecoration.tileUnderlayIds = null;
                        class82.tileOverlayIds = null;
                        class98.tileOverlayPath = null;
                        class157.overlayRotations = null;
                        class306.field553 = null;
                        class98.field503 = null;
                        class98.field496 = null;
                        ModeGame.floorHues = null;
                        class98.floorSaturations = null;
                        Packet.field2408 = null;
                        FontName.floorMultiplier = null;
                        ChatPlayer.field3707 = null;
                        var70 = FaceNormal.method5726(ClientProt.MAP_BUILD_COMPLETE, serverConnection.isaac);
                        serverConnection.method5881(var70);
                        GameEngine.timer.vmethod5390();

                        for (var7 = 0; var7 < 32; ++var7) {
                            GameEngine.field429[var7] = 0L;
                        }

                        for (var7 = 0; var7 < 32; ++var7) {
                            GameEngine.field444[var7] = 0L;
                        }

                        class117.field2363 = 0;
                    }
                }
            }
        } else {
            ClientOptions.method6503(this);
        }

        if (gameState == 30) {
            this.method3167();
        } else if (gameState == 40 || gameState == 45) {
            this.method3166();
        }

    }

    @ObfuscatedName("gd")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1609657926"
    )
    final void method3355() {
        int var1;
        if (toplevel != -1) {
            var1 = toplevel;
            if (class232.method4564(var1)) {
                class73.method1125(class36.interfaces[var1], -1);
            }
        }

        for (var1 = 0; var1 < widgetCount; ++var1) {
            if (field848[var1]) {
                field849[var1] = true;
            }

            field706[var1] = field848[var1];
            field848[var1] = false;
        }

        field847 = gameCycle;
        field792 = -1;
        field860 = -1;
        class260.field104 = null;
        if (toplevel != -1) {
            widgetCount = 0;
            class219.method4425(toplevel, 0, 0, FriendManager.canvasWidth, class230.canvasHeight, 0, 0, -1);
        }

        Hooks.drawAfterWidgets();
        Rasterizer2D.method439();
        if (field748) {
            if (cursorState == 1) {
                class86.crossSprites[field809 / 100].method2253(lastLeftClickX - 8, lastLeftClickY - 8);
            }

            if (cursorState == 2) {
                class86.crossSprites[field809 / 100 + 4].method2253(lastLeftClickX - 8, lastLeftClickY - 8);
            }
        }

        int var2;
        int var3;
        if (!isMenuOpen) {
            if (field792 != -1) {
                var1 = field792;
                var2 = field860;
                if ((menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) && field791) {
                    var3 = menuOptionCount - 1;
                    String var5;
                    if (itemSelectionState == 1 && menuOptionCount < 2) {
                        var5 = "Use" + " " + lastSelectedItemName + " " + "->";
                    } else if (spellSelected && menuOptionCount < 2) {
                        var5 = targetVerb + " " + opBase + " " + "->";
                    } else {
                        var5 = class115.method2003(var3);
                    }

                    if (menuOptionCount > 2) {
                        var5 = var5 + class31.method548(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
                    }

                    class288.fontBold12.method1810(var5, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
                }
            }
        } else {
            var1 = class288.menuX;
            var2 = class106.menuY;
            var3 = class9.field1113;
            int var4 = class31.field1838;
            int var11 = 6116423;
            Rasterizer2D.method449(var1, var2, var3, var4, var11);
            Rasterizer2D.method449(var1 + 1, var2 + 1, var3 - 2, 16, 0);
            Rasterizer2D.method518(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
            class288.fontBold12.method1828("Choose Option", var1 + 3, var2 + 14, var11, -1);
            int var6 = MouseInput.mouseLastX;
            int var7 = MouseInput.mouseLastY * -976212263;

            for (int var8 = 0; var8 < menuOptionCount; ++var8) {
                int var9 = var2 + (menuOptionCount - 1 - var8) * 15 + 31;
                int var10 = 16777215;
                if (var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
                    var10 = 16776960;
                }

                class288.fontBold12.method1828(class115.method2003(var8), var1 + 3, var9, var10, 0);
            }

            class311.method5932(class288.menuX, class106.menuY, class9.field1113, class31.field1838);
        }

        if (gameDrawingMode == 3) {
            for (var1 = 0; var1 < widgetCount; ++var1) {
                if (field706[var1]) {
                    Rasterizer2D.method448(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
                } else if (field849[var1]) {
                    Rasterizer2D.method448(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
                }
            }
        }

        class147.method2538(class228.level, class4.localPlayer.x, class4.localPlayer.y, field705);
        field705 = 0;
    }

    @ObfuscatedName("ho")
    final boolean method3173(int var1) {
        if (this.copy$shouldLeftClickOpenMenu(var1)) {
            return true;
        } else {
            int var2 = this.getMenuOptionCount();
            if (var2 > 0) {
                int var3 = this._protect$getMenuTypes()[var2 - 1];
                return var3 == MenuAction.RUNELITE_OVERLAY.getId();
            } else {
                return false;
            }
        }
    }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1626847641"
    )
    protected final void vmethod3405() {
        ModeGame.method4307(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
        class220.port1 = socketType == 0 ? 43594 : world + 40000;
        GrandExchangeEvent.port2 = socketType == 0 ? 443 : world + 50000;
        class86.myWorldPort = class220.port1;
        KeyFocusListener.colorsToFind = class248.field2650;
        VarPlayerType.colorsToReplace = class248.field2649;
        PlayerComposition.field2642 = class248.field2651;
        PlayerComposition.field2638 = class248.field2652;
        class208.urlRequester = new UrlRequester();
        this.method2969();
        this.method2975();
        IndexFile.mouseWheel = this.method2973();
        class306.indexStore255 = new IndexFile(255, class166.cacheDat, class166.masterIndex, 500000);
        FileOnDisk var2 = null;
        ClientOptions var3 = new ClientOptions();

        try {
            var2 = class70.method1076("", field646.name, false);
            byte[] var4 = new byte[(int) var2.method148()];

            int var6;
            for (int var5 = 0; var5 < var4.length; var5 += var6) {
                var6 = var2.method149(var4, var5, var4.length - var5);
                if (var6 == -1) {
                    throw new IOException();
                }
            }

            var3 = new ClientOptions(new Packet(var4));
        } catch (Exception var8) {
            ;
        }

        try {
            if (var2 != null) {
                var2.method146();
            }
        } catch (Exception var7) {
            ;
        }

        GameEngine.options = var3;
        this.method3043();
        String var9 = MapLabel.field222;
        class219.field419 = this;
        if (var9 != null) {
            class219.field420 = var9;
        }

        if (socketType != 0) {
            displayFps = true;
        }

        WorldMapType2.method3151(GameEngine.options.screenType);
        ServerProt.friendManager = new FriendManager(loginType);
    }

    @ObfuscatedName("ep")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1511323397"
    )
    void method3164() {
        if (class258.field3277 >= 4) {
            this.method2999("js5crc");
            gameState = 1000;
            gameStateChanged(-1);
        } else {
            if (class258.field3278 >= 4) {
                if (gameState <= 5) {
                    this.method2999("js5io");
                    gameState = 1000;
                    gameStateChanged(-1);
                    return;
                }

                field682 = 3000;
                class258.field3278 = 3;
            }

            if (--field682 + 1 <= 0) {
                try {
                    if (js5State == 0) {
                        class260.socket = GameEngine.taskManager.method4438(class113.host, class86.myWorldPort);
                        ++js5State;
                    }

                    if (js5State == 1) {
                        if (class260.socket.status == 2) {
                            this.method3165(-1);
                            return;
                        }

                        if (class260.socket.status == 1) {
                            ++js5State;
                        }
                    }

                    if (js5State == 2) {
                        if (field822) {
                            CacheFile.rssocket = PendingSpawn.method5555((Socket) class260.socket.value, 40000, 5000);
                        } else {
                            CacheFile.rssocket = new class288((Socket) class260.socket.value, GameEngine.taskManager, 5000);
                        }

                        Packet var1 = new Packet(5);
                        var1.putByte(15);
                        var1.method6230(177);
                        CacheFile.rssocket.vmethod5623(var1.payload, 0, 5);
                        ++js5State;
                        class2.field411 = Tile.method4297();
                    }

                    if (js5State == 3) {
                        if (CacheFile.rssocket.vmethod5598() > 0 || !field822 && gameState <= 5) {
                            int var2 = CacheFile.rssocket.vmethod5607();
                            if (var2 != 0) {
                                this.method3165(var2);
                                return;
                            }

                            ++js5State;
                        } else if (Tile.method4297() - class2.field411 > 30000L) {
                            this.method3165(-2);
                            return;
                        }
                    }

                    if (js5State == 4) {
                        class310.method5927(CacheFile.rssocket, gameState > 20);
                        class260.socket = null;
                        CacheFile.rssocket = null;
                        js5State = 0;
                        field787 = 0;
                    }
                } catch (IOException var3) {
                    this.method3165(-3);
                }

            }
        }
    }

    @ObfuscatedName("eo")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "94"
    )
    void method3163() {
        if (gameState != 1000) {
            boolean var1 = WallObject.method2814();
            if (!var1) {
                this.method3164();
            }

        }
    }

    @ObfuscatedName("in")
    @ObfuscatedSignature(
            signature = "(Lhn;I)V",
            garbageValue = "-794294536"
    )
    void method3499(ComponentType var1) {
        ComponentType var2 = var1.layer == -1 ? null : WorldMapType1.method2440(var1.layer);
        int var3;
        int var4;
        if (var2 == null) {
            var3 = FriendManager.canvasWidth;
            var4 = class230.canvasHeight;
        } else {
            var3 = var2.width;
            var4 = var2.height;
        }

        GameObject.method2037(var1, var3, var4, false);
        GroundObject.method4582(var1, var3, var4);
    }

    public RSSpritePixels drawInstanceMap(int var1) {
        RSSpritePixels var2 = this.createSpritePixels(new int[262144], 512, 512);
        RSSpritePixels var3 = this.getMinimapSprite();
        RSScene var4 = this.getScene();
        int[] var5 = var2.getPixels();
        byte[][][] var6 = this.getTileSettings();

        try {
            this.setMinimapSprite(var2);

            int var8;
            int var9;
            for (var8 = 1; var8 < 103; ++var8) {
                int var7 = (103 - var8) * 2048 + 24628;

                for (var9 = 1; var9 < 103; ++var9) {
                    if ((var6[var1][var9][var8] & 24) == 0) {
                        var4.drawTile(var5, var7, 512, var1, var9, var8);
                    }

                    if (var1 < 3 && (var6[var1 + 1][var9][var8] & 8) != 0) {
                        var4.drawTile(var5, var7, 512, var1 + 1, var9, var8);
                    }

                    var7 += 4;
                }
            }

            var8 = (238 + (int) (Math.random() * 20.0D) - 10 << 16) + (238 + (int) (Math.random() * 20.0D) - 10 << 8) + (238 + (int) (Math.random() * 20.0D) - 10);
            var9 = 238 + (int) (Math.random() * 20.0D) - 10 << 16;
            var2.setRaster();

            for (int var10 = 1; var10 < 103; ++var10) {
                for (int var11 = 1; var11 < 103; ++var11) {
                    if ((var6[var1][var11][var10] & 24) == 0) {
                        this.drawObject(var1, var11, var10, var8, var9);
                    }

                    if (var1 < 3 && (var6[var1 + 1][var11][var10] & 8) != 0) {
                        this.drawObject(var1 + 1, var11, var10, var8, var9);
                    }
                }
            }
        } finally {
            this.getBufferProvider().setRaster();
            this.setMinimapSprite(var3);
        }

        return var2;
    }

    public void playSoundEffect(int var1, int var2, int var3, int var4) {
        int var5 = ((var2 & 255) << 16) + ((var3 & 255) << 8) + (var4 & 255);
        int[] var6 = this.getQueuedSoundEffectIDs();
        int[] var7 = this.getUnknownSoundValues1();
        int[] var8 = this.getQueuedSoundEffectDelays();
        RSSoundEffect[] var9 = this.getAudioEffects();
        int[] var10 = this.getSoundLocations();
        int var11 = this.getQueuedSoundEffectCount();
        var6[var11] = var1;
        var7[var11] = 0;
        var8[var11] = 0;
        var9[var11] = null;
        var10[var11] = var5;
        this.setQueuedSoundEffectCount(var11 + 1);
    }

    public RSItemContainer getItemContainer(InventoryID var1) {
        RSHashTable var2 = this.getItemContainers();
        return (RSItemContainer) var2.get((long) var1.getId());
    }

    public void methodDraw(boolean var1) {
        this.callbacks.clientMainLoop();
    }

    public RSSpritePixels[] getSprites(IndexDataBase var1, int var2, int var3) {
        RSIndexDataBase var4 = (RSIndexDataBase) var1;
        byte[] var5 = var4.getConfigData(var2, var3);
        if (var5 == null) {
            return null;
        } else {
            this.decodeSprite(var5);
            int var6 = this.getIndexedSpriteCount();
            int var7 = this.getIndexedSpriteWidth();
            int var8 = this.getIndexedSpriteHeight();
            int[] var9 = this.getIndexedSpriteOffsetXs();
            int[] var10 = this.getIndexedSpriteOffsetYs();
            int[] var11 = this.getIndexSpriteWidths();
            int[] var12 = this.getIndexedSpriteHeights();
            byte[][] var13 = this.getSpritePixels();
            int[] var14 = this.getIndexedSpritePalette();
            RSSpritePixels[] var15 = new SpritePixels[var6];

            for (int var16 = 0; var16 < var6; ++var16) {
                int var17 = var11[var16];
                int var18 = var12[var16];
                byte[] var19 = var13[var16];
                int[] var20 = new int[var17 * var18];
                RSSpritePixels var21 = this.createSpritePixels(var20, var17, var18);
                var21.setMaxHeight(var8);
                var21.setMaxWidth(var7);
                var21.setOffsetX(var9[var16]);
                var21.setOffsetY(var10[var16]);

                for (int var22 = 0; var22 < var17 * var18; ++var22) {
                    var20[var22] = var14[var19[var22] & 255];
                }

                var15[var16] = var21;
            }

            this.setIndexedSpriteOffsetXs((int[]) null);
            this.setIndexedSpriteOffsetYs((int[]) null);
            this.setIndexSpriteWidths((int[]) null);
            this.setIndexedSpriteHeights((int[]) null);
            this.setIndexSpritePalette((int[]) null);
            this.setSpritePixels((byte[][]) null);
            return var15;
        }
    }

    public RSCollisionData[] getCollisionMaps() {
        if (this.isInInstancedRegion()) {
            return this._protect$getRsCollisionMaps();
        } else {
            RSPlayer var1 = this.getLocalPlayer();
            switch (var1.getWorldLocation().getRegionID()) {
                case 8280:
                case 8536:
                    return this._protect$getRsCollisionMaps();
                default:
                    return null;
            }
        }
    }

    public int getPlayerIndexesCount() {
        return class254.highResolutionPlayerCount;
    }

    public int getSelectedSceneTileX() {
        return SceneManager.selectedRegionTileX;
    }

    public void setRSModIcons(RSIndexedSprite[] var1) {
        FontTypeFace.modIcons = (IndexedSprite[]) var1;
    }

    public int getMouseX() {
        return MouseInput.mouseX;
    }

    public int getWidgetRoot() {
        return toplevel;
    }

    public int getCycleCntr() {
        return cycleCntr;
    }

    public int getDestinationX() {
        return destinationX;
    }

    public int getFlags() {
        return flags;
    }

    public void setLowMemory(boolean var1) {
        lowMemory = var1;
    }

    public int getRSGameState() {
        return gameState;
    }

    public int getNpcIndexesCount() {
        return highResolutionNpcCount;
    }

    public int[] getBoostedSkillLevels() {
        return skillLevels;
    }

    public int[] getRealSkillLevels() {
        return skillBaseLevels;
    }

    public int[] getSkillExperiences() {
        return skillExperiences;
    }

    public boolean isStretchedEnabled() {
        return stretchedEnabled;
    }

    public int[] getIntVarcs() {
        return this.getVarcs().getIntVarcs();
    }

    public String[] getStrVarcs() {
        return this.getVarcs().getStrVarcs();
    }

    public RSHashTable getItemContainers() {
        return ItemContainer.itemContainers;
    }

    public RSJagexLoginType getLoginType() {
        return loginType;
    }

    public boolean isInInstancedRegion() {
        return isDynamicRegion;
    }

    public HintArrowType getHintArrowType() {
        int var1 = class166.clientInstance.getHintArrowTargetType();
        return var1 == HintArrowType.NPC.getValue() ? HintArrowType.NPC : (var1 == HintArrowType.PLAYER.getValue() ? HintArrowType.PLAYER : (var1 == HintArrowType.WORLD_POSITION.getValue() ? HintArrowType.WORLD_POSITION : HintArrowType.NONE));
    }

    public void menuOpened(int var1, int var2) {
        MenuOpened var3 = new MenuOpened();
        var3.setMenuEntries(this.getMenuEntries());
        this.callbacks.post(var3);
    }

    public int getVar(Varbits var1) {
        int var2 = var1.getId();
        return this.getVarbitValue(this.getVarps(), var2);
    }

    public final boolean copy$shouldLeftClickOpenMenu(int var1) {
        int var2 = menuOptionCount - 1;
        boolean var4 = field866 == 1 && menuOptionCount > 2;
        if (!var4) {
            boolean var5;
            if (var2 < 0) {
                var5 = false;
            } else {
                int var6 = menuTypes[var2];
                if (var6 >= 2000) {
                    var6 -= 2000;
                }

                if (var6 == 1007) {
                    var5 = true;
                } else {
                    var5 = false;
                }
            }

            var4 = var5;
        }

        return var4 && !menuBooleanArray[var2];
    }

    public RSWidget[][] getWidgets() {
        return class36.interfaces;
    }

    public boolean isResized() {
        return isResized;
    }

    public RSClanMemberManager getClanMemberManager() {
        return TotalQuantityComparator.clanMemberManager;
    }

    public RSFriendManager getFriendManager() {
        return ServerProt.friendManager;
    }

    public RSSpritePixels createSpritePixels(int[] var1, int var2, int var3) {
        return new SpritePixels(var1, var2, var3);
    }

    public int[] getVarps() {
        return class311.clientVarps;
    }

    public RSVarcs getVarcs() {
        return MapIconReference.varcs;
    }

    public int getMenuOptionCount() {
        return menuOptionCount;
    }

    public String[] _protect$getMenuOptions/* $FF was: 1protect$getMenuOptions*/() {
        return menuOptions;
    }

    public void addChatMessage(int var1, String var2, String var3, String var4) {
        class192.method3787(var1, var2, var3, var4);
    }

    public void setMouseCanvasHoverPositionX(int var1) {
        SceneManager.mouseX2 = var1;
    }

    public RSDeque _protect$getProjectilesDeque/* $FF was: 1protect$getProjectilesDeque*/() {
        return projectiles;
    }

    public RSDeque getGraphicsObjectDeque() {
        return spotAnimationDeque;
    }

    public MenuEntry[] getMenuEntries() {
        int var1 = this.getMenuOptionCount();
        String[] var2 = this._protect$getMenuOptions();
        String[] var3 = this._protect$getMenuTargets();
        int[] var4 = this._protect$getMenuIdentifiers();
        int[] var5 = this._protect$getMenuTypes();
        int[] var6 = this._protect$getMenuActionParams0();
        int[] var7 = this._protect$getMenuActionParams1();
        boolean[] var8 = this.getMenuForceLeftClick();
        MenuEntry[] var9 = new MenuEntry[var1];

        for (int var10 = 0; var10 < var1; ++var10) {
            MenuEntry var11 = var9[var10] = new MenuEntry();
            var11.setOption(var2[var10]);
            var11.setTarget(var3[var10]);
            var11.setIdentifier(var4[var10]);
            var11.setType(var5[var10]);
            var11.setParam0(var6[var10]);
            var11.setParam1(var7[var10]);
            var11.setForceLeftClick(var8[var10]);
        }

        return var9;
    }

    private void rl$$init() {
        this.varbitCache = CacheBuilder.newBuilder().maximumSize(128L).build();
    }

    public int[] getPlayerIndices() {
        return class254.highResolutionPlayerIndexes;
    }

    public void setSceneLowMemory(boolean var1) {
        SceneManager.regionLowMemory = var1;
    }

    public int getSelectedSceneTileY() {
        return SceneManager.selectedRegionTileY;
    }

    public int getMouseY() {
        return MouseInput.mouseY;
    }

    public int getDestinationY() {
        return destinationY;
    }

    public void setChatCycle(int var1) {
        chatCycle = var1;
    }

    public int[] getNpcIndices() {
        return highResolutionNpcIndexes;
    }

    public RSName createName(String var1, RSJagexLoginType var2) {
        return new Name(var1, (JagexLoginType) var2);
    }

    public void _protect$menuAction/* $FF was: 1protect$menuAction*/(int var1, int var2, int var3, int var4, String var5, String var6, int var7, int var8) {
        class39.method595(var1, var2, var3, var4, var5, var6, var7, var8, -1692443790);
    }

    public void decodeSprite(byte[] var1) {
        SceneTilePaint.method667(var1);
    }

    public int get3dZoom() {
        return Graphics3D.Rasterizer3D_zoom;
    }

    public int[] getQueuedSoundEffectIDs() {
        return queuedSoundEffectIDs;
    }

    public RSSpritePixels getMinimapSprite() {
        return TotalQuantityComparator.minimapSprite;
    }

    public Widget getWidget(int var1, int var2) {
        RSWidget[][] var3 = this.getWidgets();
        if (var3 != null && var3.length > var1) {
            RSWidget[] var4 = var3[var1];
            return var4 != null && var4.length > var2 ? var4[var2] : null;
        } else {
            return null;
        }
    }

    public String[] _protect$getMenuTargets/* $FF was: 1protect$getMenuTargets*/() {
        return menuTargets;
    }

    public void setVarbitValue(int[] var1, int var2, int var3) {
        RSVarbit var4 = (RSVarbit) this.varbitCache.getIfPresent(Integer.valueOf(var2));
        if (var4 == null) {
            class166.clientInstance.getVarbit(var2);
            RSNodeCache var5 = class166.clientInstance.getVarbitCache();
            var4 = (RSVarbit) var5.get((long) var2);
            this.varbitCache.put(Integer.valueOf(var2), var4);
        }

        int var8 = var4.getLeastSignificantBit();
        int var6 = var4.getMostSignificantBit();
        int var7 = (1 << var6 - var8 + 1) - 1;
        var1[var4.getIndex()] = var1[var4.getIndex()] & ~(var7 << var8) | (var3 & var7) << var8;
    }

    public RSPlayer getLocalPlayer() {
        return class4.localPlayer;
    }

    public Widget getWidget(WidgetInfo var1) {
        int var2 = var1.getGroupId();
        int var3 = var1.getChildId();
        return this.getWidget(var2, var3);
    }

    public int getVarbitValue(int[] var1, int var2) {
        if (!$assertionsDisabled && !class166.clientInstance.isClientThread()) {
            throw new AssertionError();
        } else {
            RSVarbit var3 = (RSVarbit) this.varbitCache.getIfPresent(Integer.valueOf(var2));
            if (var3 == null) {
                class166.clientInstance.getVarbit(var2);
                RSNodeCache var4 = class166.clientInstance.getVarbitCache();
                var3 = (RSVarbit) var4.get((long) var2);
                this.varbitCache.put(Integer.valueOf(var2), var3);
            }

            if (var3.getIndex() == 0 && var3.getLeastSignificantBit() == 0 && var3.getMostSignificantBit() == 0) {
                throw new IndexOutOfBoundsException("Varbit " + var2 + " does not exist");
            } else {
                int var8 = var1[var3.getIndex()];
                int var5 = var3.getLeastSignificantBit();
                int var6 = var3.getMostSignificantBit();
                int var7 = (1 << var6 - var5 + 1) - 1;
                return var8 >> var5 & var7;
            }
        }
    }

    public RSCollisionData[] _protect$getRsCollisionMaps/* $FF was: 1protect$getRsCollisionMaps*/() {
        return collisionMaps;
    }

    public void setAudioHighMemory(boolean var1) {
        class56.audioHighMemory = var1;
    }

    public void setMouseCanvasHoverPositionY(int var1) {
        SceneManager.mouseY2 = var1;
    }

    public RSNPC[] getCachedNPCs() {
        return npcs;
    }

    public RSPlayer[] getCachedPlayers() {
        return players;
    }

    public int getIndexedSpriteCount() {
        return class95.indexedSpriteCount;
    }

    public int[] getUnknownSoundValues1() {
        return unknownSoundValues1;
    }

    public RSScene getScene() {
        return class131.sceneManager;
    }

    public void set3dZoom(int var1) {
        Graphics3D.Rasterizer3D_zoom = var1;
    }

    public int[] _protect$getMenuIdentifiers/* $FF was: 1protect$getMenuIdentifiers*/() {
        return menuIdentifiers;
    }

    public void setObjectCompositionLowDetail(boolean var1) {
        LocType.objectCompositionLowDetail = var1;
    }

    public int getIndexedSpriteWidth() {
        return class95.indexedSpriteWidth;
    }

    public RSSpritePixels createItemSprite(int var1, int var2, int var3, int var4, int var5, boolean var6) {
        return MapCacheArchiveNames.method2148(var1, var2, var3, var4, var5, var6);
    }

    public int[] getQueuedSoundEffectDelays() {
        return unknownSoundValues2;
    }

    public int[] _protect$getMenuTypes/* $FF was: 1protect$getMenuTypes*/() {
        return menuTypes;
    }

    public Dimension getRealDimensions() {
        if (!this.isStretchedEnabled()) {
            return this.getCanvas().getSize();
        } else {
            if (cachedRealDimensions == null) {
                if (this.isResized()) {
                    Container var1 = this.getCanvas().getParent();
                    int var2 = var1.getWidth();
                    int var3 = var1.getHeight();
                    int var4 = (int) ((double) var2 / scalingFactor);
                    int var5 = (int) ((double) var3 / scalingFactor);
                    if (var4 < 765 || var5 < 503) {
                        double var6 = (double) var2 / 765.0D;
                        double var8 = (double) var3 / 503.0D;
                        double var10 = Math.min(var6, var8);
                        var4 = (int) ((double) var2 / var10);
                        var5 = (int) ((double) var3 / var10);
                    }

                    cachedRealDimensions = new Dimension(var4, var5);
                } else {
                    cachedRealDimensions = Constants.GAME_FIXED_SIZE;
                }
            }

            return cachedRealDimensions;
        }
    }

    public byte[][][] getTileSettings() {
        return class98.tileSettings;
    }

    public RSScriptEvent createScriptEvent() {
        return new ScriptEvent();
    }

    public int getIndexedSpriteHeight() {
        return class95.indexedSpriteHeight;
    }

    public RSSoundEffect[] getAudioEffects() {
        return audioEffects;
    }

    public int[] _protect$getMenuActionParams0/* $FF was: 1protect$getMenuActionParams0*/() {
        return menuActionParams0;
    }

    public int getPlane() {
        return class228.level;
    }

    public RSBufferProvider getBufferProvider() {
        return WorldMapManager.rasterProvider;
    }

    public void setMinimapSprite(net.runelite.api.SpritePixels var1) {
        TotalQuantityComparator.minimapSprite = (SpritePixels) var1;
    }

    public boolean boundingboxCheck(net.runelite.api.Model var1, int var2, int var3, int var4) {
        int var5 = class166.clientInstance.getCameraPitch();
        int var6 = class166.clientInstance.getCameraYaw();
        int var7 = Perspective.SINE[var5];
        int var8 = Perspective.COSINE[var5];
        int var9 = Perspective.SINE[var6];
        int var10 = Perspective.COSINE[var6];
        int var11 = class166.clientInstance.getCenterX();
        int var12 = class166.clientInstance.getCenterY();
        int var13 = class166.clientInstance.getViewportMouseX();
        int var14 = class166.clientInstance.getViewportMouseY();
        int var15 = class166.clientInstance.get3dZoom();
        int var16 = (var13 - var11) * 50 / var15;
        int var17 = (var14 - var12) * 50 / var15;
        int var18 = (var13 - var11) * 3500 / var15;
        int var19 = (var14 - var12) * 3500 / var15;
        int var20 = rl$rot1(var17, 50, var8, var7);
        int var21 = rl$rot2(var17, 50, var8, var7);
        var17 = var20;
        var20 = rl$rot1(var19, 3500, var8, var7);
        int var22 = rl$rot2(var19, 3500, var8, var7);
        var19 = var20;
        var20 = rl$rot3(var16, var21, var10, var9);
        var21 = rl$rot4(var16, var21, var10, var9);
        var16 = var20;
        var20 = rl$rot3(var18, var22, var10, var9);
        var22 = rl$rot4(var18, var22, var10, var9);
        int var23 = (var20 - var16) / 2;
        int var24 = (var19 - var17) / 2;
        int var25 = (var22 - var21) / 2;
        int var26 = Math.abs(var23);
        int var27 = Math.abs(var24);
        int var28 = Math.abs(var25);
        int var29 = var2 + var1.getCenterX();
        int var30 = var3 + var1.getCenterY();
        int var31 = var4 + var1.getCenterZ();
        int var32 = var1.getExtremeX();
        int var33 = var1.getExtremeY();
        int var34 = var1.getExtremeZ();
        int var35 = (var16 + var20) / 2;
        int var36 = (var17 + var19) / 2;
        int var37 = (var22 + var21) / 2;
        int var38 = var35 - var29;
        int var39 = var36 - var30;
        int var40 = var37 - var31;
        boolean var41;
        if (Math.abs(var38) > var32 + var26) {
            var41 = false;
        } else if (Math.abs(var39) > var33 + var27) {
            var41 = false;
        } else if (Math.abs(var40) > var34 + var28) {
            var41 = false;
        } else if (Math.abs(var40 * var24 - var39 * var25) > var33 * var28 + var34 * var27) {
            var41 = false;
        } else if (Math.abs(var38 * var25 - var40 * var23) > var34 * var26 + var32 * var28) {
            var41 = false;
        } else if (Math.abs(var39 * var23 - var38 * var24) > var33 * var26 + var32 * var27) {
            var41 = false;
        } else {
            var41 = true;
        }

        return var41;
    }

    public int[] getIndexedSpriteOffsetXs() {
        return class95.indexedSpriteOffsetXs;
    }

    public int[] getSoundLocations() {
        return soundLocations;
    }

    public int[] _protect$getMenuActionParams1/* $FF was: 1protect$getMenuActionParams1*/() {
        return menuActionParams1;
    }

    public void runScript(RSScriptEvent var1, int var2) {
        method3577((ScriptEvent) var1, var2, 296778373);
    }

    public int[] getIndexedSpriteOffsetYs() {
        return class95.indexedSpriteOffsetYs;
    }

    public int getQueuedSoundEffectCount() {
        return queuedSoundEffectCount;
    }

    public boolean[] getMenuForceLeftClick() {
        return menuBooleanArray;
    }

    public int[] getIndexSpriteWidths() {
        return class95.indexSpriteWidths;
    }

    public void setMenuOptionCount(int var1) {
        menuOptionCount = var1;
    }

    @Override
    public String[] getMenuOptions() {
        return new String[0];
    }

    @Override
    public String[] getMenuTargets() {
        return new String[0];
    }

    @Override
    public int[] getMenuIdentifiers() {
        return new int[0];
    }

    @Override
    public int[] getMenuTypes() {
        return new int[0];
    }

    @Override
    public int[] getMenuActionParams0() {
        return new int[0];
    }

    @Override
    public int[] getMenuActionParams1() {
        return new int[0];
    }

    public int[] getIndexedSpriteHeights() {
        return VarClientType.indexedSpriteHeights;
    }

    public byte[][] getSpritePixels() {
        return class95.spritePixels;
    }

    public void addHashAtMouse(long var1) {
        long[] var3 = class166.clientInstance.getEntitiesAtMouse();
        int var4 = class166.clientInstance.getEntitiesAtMouseCount();
        if (var4 < 1000) {
            var3[var4] = var1;
            class166.clientInstance.setEntitiesAtMouseCount(var4 + 1);
        }

    }

    public int[] getIndexedSpritePalette() {
        return class95.indexedSpritePalette;
    }

    public void setQueuedSoundEffectCount(int var1) {
        queuedSoundEffectCount = var1;
    }

    public void setIndexedSpriteOffsetXs(int[] var1) {
        class95.indexedSpriteOffsetXs = var1;
    }

    public void setIndexedSpriteOffsetYs(int[] var1) {
        class95.indexedSpriteOffsetYs = var1;
    }

    public void setIndexSpriteWidths(int[] var1) {
        class95.indexSpriteWidths = var1;
    }

    public void setIndexedSpriteHeights(int[] var1) {
        VarClientType.indexedSpriteHeights = var1;
    }

    public void setIndexSpritePalette(int[] var1) {
        class95.indexedSpritePalette = var1;
    }

    public void setSpritePixels(byte[][] var1) {
        class95.spritePixels = var1;
    }

    public void drawObject(int var1, int var2, int var3, int var4, int var5) {
        GameObject.method2036(var1, var2, var3, var4, var5);
    }

    public final void init() {
        try {
            if (this.method2982()) {
                Parameters[] var1 = FrameMap.method554();

                for (int var2 = 0; var2 < var1.length; ++var2) {
                    Parameters var3 = var1[var2];
                    String var4 = this.getParameter(var3.key);
                    if (var4 != null) {
                        switch (Integer.parseInt(var3.key)) {
                            case 1:
                                field822 = Integer.parseInt(var4) != 0;
                            case 2:
                            case 11:
                            case 13:
                            case 16:
                            default:
                                break;
                            case 3:
                                if (var4.equalsIgnoreCase("true")) {
                                    isMembers = true;
                                } else {
                                    isMembers = false;
                                }
                                break;
                            case 4:
                                if (confClientType == -1) {
                                    confClientType = Integer.parseInt(var4);
                                }
                                break;
                            case 5:
                                flags = Integer.parseInt(var4);
                                break;
                            case 6:
                                languageId = Integer.parseInt(var4);
                                break;
                            case 7:
                                class232.field2441 = class261.method5014(Integer.parseInt(var4));
                                break;
                            case 8:
                                if (var4.equalsIgnoreCase("true")) {
                                    ;
                                }
                                break;
                            case 9:
                                class116.sessionToken = var4;
                                break;
                            case 10:
                                field646 = (ModeGame) class2.method20(FileSystem.method5639(), Integer.parseInt(var4));
                                if (ModeGame.OLDSCAPE == field646) {
                                    loginType = JagexLoginType.field4002;
                                } else {
                                    loginType = JagexLoginType.field4009;
                                }
                                break;
                            case 12:
                                world = Integer.parseInt(var4);
                                break;
                            case 14:
                                field650 = Integer.parseInt(var4);
                                break;
                            case 15:
                                socketType = Integer.parseInt(var4);
                                break;
                            case 17:
                                FileOnDisk.field1496 = var4;
                        }
                    }
                }

                ClientProt.method6051();
                class113.host = this.getCodeBase().getHost();
                String var7 = class232.field2441.identifier;
                byte var8 = 0;

                try {
                    class306.method5871("oldschool", var7, var8, 18);
                } catch (Exception var5) {
                    ProjectileAnimation.method5582((String) null, var5, 2103817937);
                }

                class166.clientInstance = this;
                class134.clientType = confClientType;
                this.method2980(765, 503, 177);
            }
        } catch (RuntimeException var6) {
            throw CacheFile.method2128(var6, "client.init(" + ')');
        }
    }

    public void setCameraPitchRelaxerEnabled(boolean var1) {
        if (pitchRelaxEnabled != var1) {
            pitchRelaxEnabled = var1;
            if (!var1) {
                int var2 = class166.clientInstance.getCameraPitchTarget();
                if (var2 > 383) {
                    class166.clientInstance.setCameraPitchTarget(383);
                }
            }

        }
    }

    public void checkClickbox(net.runelite.api.Model var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10) {
        RSModel var12 = (RSModel) var1;
        boolean var13 = var10 != 0L && (int) (var10 >>> 16 & 1L) != 1;
        boolean var14 = class166.clientInstance.getViewportContainsMouse();
        if (var13 && var14 && class166.clientInstance.getOculusOrbState() == 0) {
            boolean var15 = this.boundingboxCheck(var12, var7, var8, var9);
            if (var15) {
                if (Math.sqrt((double) (var7 * var7 + var9 * var9)) <= 4480.0D) {
                    if (var12.isClickable()) {
                        this.addHashAtMouse(var10);
                    } else {
                        int var16 = var12.getVerticesCount();
                        int var17 = var12.getTrianglesCount();
                        int[] var18 = var12.getVerticesX();
                        int[] var19 = var12.getVerticesY();
                        int[] var20 = var12.getVerticesZ();
                        int[] var21 = var12.getTrianglesX();
                        int[] var22 = var12.getTrianglesY();
                        int[] var23 = var12.getTrianglesZ();
                        int[] var24 = var12.getFaceColors3();
                        int var25 = class166.clientInstance.get3dZoom();
                        int var26 = class166.clientInstance.getCenterX();
                        int var27 = class166.clientInstance.getCenterY();
                        int var28 = 0;
                        int var29 = 0;
                        if (var2 != 0) {
                            var28 = Perspective.SINE[var2];
                            var29 = Perspective.COSINE[var2];
                        }

                        int var30;
                        int var31;
                        int var32;
                        int var33;
                        int var34;
                        for (var30 = 0; var30 < var16; ++var30) {
                            var31 = var18[var30];
                            var32 = var19[var30];
                            var33 = var20[var30];
                            if (var2 != 0) {
                                var34 = var33 * var28 + var31 * var29 >> 16;
                                var33 = var33 * var29 - var31 * var28 >> 16;
                                var31 = var34;
                            }

                            var31 += var7;
                            var32 += var8;
                            var33 += var9;
                            var34 = var31 * var6 + var5 * var33 >> 16;
                            var33 = var33 * var6 - var5 * var31 >> 16;
                            var31 = var34;
                            var34 = var32 * var4 - var3 * var33 >> 16;
                            var33 = var33 * var4 + var3 * var32 >> 16;
                            if (var33 >= 50) {
                                rl$modelViewportYs[var30] = var31 * var25 / var33 + var26;
                                rl$modelViewportXs[var30] = var34 * var25 / var33 + var27;
                            } else {
                                rl$modelViewportYs[var30] = -5000;
                            }
                        }

                        var30 = class166.clientInstance.getViewportMouseX();
                        var31 = class166.clientInstance.getViewportMouseY();

                        for (var32 = 0; var32 < var17; ++var32) {
                            if (var24[var32] != -2) {
                                var33 = var21[var32];
                                var34 = var22[var32];
                                int var35 = var23[var32];
                                int var36 = rl$modelViewportYs[var33];
                                int var37 = rl$modelViewportYs[var34];
                                int var38 = rl$modelViewportYs[var35];
                                int var39 = rl$modelViewportXs[var33];
                                int var40 = rl$modelViewportXs[var34];
                                int var41 = rl$modelViewportXs[var35];
                                if (var36 != -5000 && var37 != -5000 && var38 != -5000) {
                                    int var42 = var12.isClickable() ? 20 : 5;
                                    int var43 = var42 + var31;
                                    boolean var44;
                                    if (var43 < var39 && var43 < var40 && var43 < var41) {
                                        var44 = false;
                                    } else {
                                        var43 = var31 - var42;
                                        if (var43 > var39 && var43 > var40 && var43 > var41) {
                                            var44 = false;
                                        } else {
                                            var43 = var42 + var30;
                                            if (var43 < var36 && var43 < var37 && var43 < var38) {
                                                var44 = false;
                                            } else {
                                                var43 = var30 - var42;
                                                if (var43 > var36 && var43 > var37 && var43 > var38) {
                                                    var44 = false;
                                                } else {
                                                    var44 = true;
                                                }
                                            }
                                        }
                                    }

                                    if (var44) {
                                        this.addHashAtMouse(var10);
                                        break;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    public void setIsHidingEntities(boolean var1) {
        isHidingEntities = var1;
    }

    public void setPlayersHidden(boolean var1) {
        hidePlayers = var1;
    }

    public void setPlayersHidden2D(boolean var1) {
        hidePlayers2D = var1;
    }

    public void setFriendsHidden(boolean var1) {
        hideFriends = var1;
    }

    public void setClanMatesHidden(boolean var1) {
        hideClanMates = var1;
    }

    public void setLocalPlayerHidden(boolean var1) {
        hideLocalPlayer = var1;
    }

    public void setLocalPlayerHidden2D(boolean var1) {
        hideLocalPlayer2D = var1;
    }

    public void setNPCsHidden(boolean var1) {
        hideNPCs = var1;
    }

    public void setNPCsHidden2D(boolean var1) {
        hideNPCs2D = var1;
    }

    public void setAttackersHidden(boolean var1) {
        hideAttackers = var1;
    }

    public void setProjectilesHidden(boolean var1) {
        hideProjectiles = var1;
    }

    public void playSoundEffect(int var1) {
        this.playSoundEffect(var1, 0, 0, 0);
    }

    public Callbacks getCallbacks() {
        return this.callbacks;
    }

    public DrawCallbacks getDrawCallbacks() {
        return this.drawCallbacks;
    }

    public void setDrawCallbacks(DrawCallbacks var1) {
        this.drawCallbacks = var1;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public boolean isInterpolatePlayerAnimations() {
        return interpolatePlayerAnimations;
    }

    public void setInterpolatePlayerAnimations(boolean var1) {
        interpolatePlayerAnimations = var1;
    }

    public boolean isInterpolateNpcAnimations() {
        return interpolateNpcAnimations;
    }

    public void setInterpolateNpcAnimations(boolean var1) {
        interpolateNpcAnimations = var1;
    }

    public boolean isInterpolateObjectAnimations() {
        return interpolateObjectAnimations;
    }

    public void setInterpolateObjectAnimations(boolean var1) {
        interpolateObjectAnimations = var1;
    }

    public void setInventoryDragDelay(int var1) {
        inventoryDragDelay = var1;
    }

    public AccountType getAccountType() {
        int var1 = this.getVar(Varbits.ACCOUNT_TYPE);
        switch (var1) {
            case 1:
                return AccountType.IRONMAN;
            case 2:
                return AccountType.ULTIMATE_IRONMAN;
            case 3:
                return AccountType.HARDCORE_IRONMAN;
            default:
                return AccountType.NORMAL;
        }
    }

    public void setMouseCanvasHoverPosition(Point var1) {
        this.setMouseCanvasHoverPositionX(var1.getX());
        this.setMouseCanvasHoverPositionY(var1.getY());
    }

    public net.runelite.api.Tile getSelectedSceneTile() {
        int var1 = this.getSelectedSceneTileX();
        int var2 = this.getSelectedSceneTileY();
        return var1 != -1 && var2 != -1 ? this.getScene().getTiles()[this.getPlane()][var1][var2] : null;
    }

    public List getPlayers() {
        int var1 = this.getPlayerIndexesCount();
        int[] var2 = this.getPlayerIndices();
        RSPlayer[] var3 = this.getCachedPlayers();
        ArrayList var4 = new ArrayList(var1);

        for (int var5 = 0; var5 < var1; ++var5) {
            var4.add(var3[var2[var5]]);
        }

        return var4;
    }

    public List getNpcs() {
        int var1 = this.getNpcIndexesCount();
        int[] var2 = this.getNpcIndices();
        RSNPC[] var3 = this.getCachedNPCs();
        ArrayList var4 = new ArrayList(var1);

        for (int var5 = 0; var5 < var1; ++var5) {
            var4.add(var3[var2[var5]]);
        }

        return var4;
    }

    public int getBoostedSkillLevel(Skill var1) {
        int[] var2 = this.getBoostedSkillLevels();
        return var2[var1.ordinal()];
    }

    public int getRealSkillLevel(Skill var1) {
        int[] var2 = this.getRealSkillLevels();
        return var2[var1.ordinal()];
    }

    public int getTotalLevel() {
        int var1 = 0;
        int[] var2 = class166.clientInstance.getRealSkillLevels();
        int var3 = Skill.CONSTRUCTION.ordinal();

        for (int var4 = 0; var4 < var2.length; ++var4) {
            if (var4 <= var3) {
                var1 += var2[var4];
            }
        }

        return var1;
    }

    public void addChatMessage(ChatMessageType var1, String var2, String var3, String var4) {
        this.addChatMessage(var1.getType(), var2, var3, var4);
    }

    public GameState getGameState() {
        return GameState.of(this.getRSGameState());
    }

    public Point getMouseCanvasPosition() {
        return new Point(this.getMouseX(), this.getMouseY());
    }

    public Widget[] getWidgetRoots() {
        int var1 = this.getWidgetRoot();
        ArrayList var2 = new ArrayList();
        RSWidget[] var3 = this.getWidgets()[var1];
        int var4 = var3.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            RSWidget var6 = var3[var5];
            if (var6 != null && var6.getRSParentId() == -1) {
                var2.add(var6);
            }
        }

        return (Widget[]) var2.toArray(new Widget[var2.size()]);
    }

    public RSWidget[] getGroup(int var1) {
        RSWidget[][] var2 = this.getWidgets();
        return var2 != null && var1 >= 0 && var1 < var2.length && var2[var1] != null ? var2[var1] : null;
    }

    public int getVar(VarPlayer var1) {
        int[] var2 = this.getVarps();
        return var2[var1.getId()];
    }

    public int getVarpValue(int[] var1, int var2) {
        return var1[var2];
    }

    public void setVarpValue(int[] var1, int var2, int var3) {
        var1[var2] = var3;
    }

    public boolean isPrayerActive(Prayer var1) {
        return this.getVar(var1.getVarbit()) == 1;
    }

    public int getSkillExperience(Skill var1) {
        int[] var2 = this.getSkillExperiences();
        int var3;
        if (var1 != Skill.OVERALL) {
            var3 = var1.ordinal();
            return var3 >= var2.length ? -1 : var2[var3];
        } else {
            var3 = 0;
            int[] var4 = var2;
            int var5 = var2.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                int var7 = var4[var6];
                var3 += var7;
            }

            return var3;
        }
    }

    public void refreshChat() {
        this.setChatCycle(this.getCycleCntr());
    }

    public Widget getViewportWidget() {
        return this.isResized() ? (this.getVar(Varbits.SIDE_PANELS) == 1 ? this.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE) : this.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX)) : this.getWidget(WidgetInfo.FIXED_VIEWPORT);
    }

    public void setMenuEntries(MenuEntry[] var1) {
        int var2 = 0;
        String[] var3 = this._protect$getMenuOptions();
        String[] var4 = this._protect$getMenuTargets();
        int[] var5 = this._protect$getMenuIdentifiers();
        int[] var6 = this._protect$getMenuTypes();
        int[] var7 = this._protect$getMenuActionParams0();
        int[] var8 = this._protect$getMenuActionParams1();
        boolean[] var9 = this.getMenuForceLeftClick();
        MenuEntry[] var10 = var1;
        int var11 = var1.length;

        for (int var12 = 0; var12 < var11; ++var12) {
            MenuEntry var13 = var10[var12];
            int var14 = var13.getIdentifier();
            if ((var14 == MenuAction.NPC_THIRD_OPTION.getId() || var14 == MenuAction.NPC_FIFTH_OPTION.getId()) && class166.clientInstance.getLocalPlayer().getWorldLocation().getRegionID() == 13358) {
                var14 = MenuAction.CANCEL.getId();
            }

            var3[var2] = var13.getOption();
            var4[var2] = var13.getTarget();
            var5[var2] = var14;
            var6[var2] = var13.getType();
            var7[var2] = var13.getParam0();
            var8[var2] = var13.getParam1();
            var9[var2] = var13.isForceLeftClick();
            ++var2;
        }

        this.setMenuOptionCount(var2);
        oldMenuEntryCount = var2;
    }

    public List getProjectiles() {
        ArrayList var1 = new ArrayList();
        RSDeque var2 = this._protect$getProjectilesDeque();
        RSNode var3 = var2.getHead();
        net.runelite.api.Node var4 = var3.getNext();

        while (var4 != var3) {
            Projectile var5 = (Projectile) var4;
            switch (var5.getId()) {
                default:
                    var1.add(var5);
                case 1583:
                case 1596:
                case 1598:
                case 1662:
                case 1663:
                    var4 = var4.getNext();
            }
        }

        return var1;
    }

    public List getGraphicsObjects() {
        ArrayList var1 = new ArrayList();
        RSDeque var2 = this.getGraphicsObjectDeque();
        RSNode var3 = var2.getHead();

        for (net.runelite.api.Node var4 = var3.getNext(); var4 != var3; var4 = var4.getNext()) {
            var1.add((GraphicsObject) var4);
        }

        return var1;
    }

    public void setModIcons(net.runelite.api.IndexedSprite[] var1) {
        this.setRSModIcons((RSIndexedSprite[]) ((RSIndexedSprite[]) var1));
    }

    public LocalPoint getLocalDestinationLocation() {
        int var1 = this.getDestinationX();
        int var2 = this.getDestinationY();
        return var1 != 0 && var2 != 0 ? LocalPoint.fromScene(var1, var2) : null;
    }

    public void changeMemoryMode(boolean var1) {
        this.setLowMemory(var1);
        this.setSceneLowMemory(var1);
        this.setAudioHighMemory(true);
        this.setObjectCompositionLowDetail(var1);
    }

    public boolean isFriended(String var1, boolean var2) {
        RSName var3 = this.createName(var1, this.getLoginType());
        return this.getFriendManager().isFriended(var3, var2);
    }

    public int getClanChatCount() {
        RSClanMemberManager var1 = this.getClanMemberManager();
        return var1 != null ? var1.getCount() : 0;
    }

    public net.runelite.api.ClanMember[] getClanMembers() {
        RSClanMemberManager var1 = this.getClanMemberManager();
        return var1 != null ? (net.runelite.api.ClanMember[]) ((net.runelite.api.ClanMember[]) this.getClanMemberManager().getNameables()) : null;
    }

    public net.runelite.api.Friend[] getFriends() {
        RSFriendManager var1 = this.getFriendManager();
        if (var1 == null) {
            return null;
        } else {
            RSFriendContainer var2 = var1.getFriendContainer();
            if (var2 == null) {
                return null;
            } else {
                RSNameable[] var3 = var2.getNameables();
                return (net.runelite.api.Friend[]) ((net.runelite.api.Friend[]) var3);
            }
        }
    }

    public int getFriendsCount() {
        RSFriendManager var1 = this.getFriendManager();
        if (var1 == null) {
            return -1;
        } else {
            RSFriendContainer var2 = var1.getFriendContainer();
            return var2 == null ? -1 : var2.getCount();
        }
    }

    public net.runelite.api.Ignore[] getIgnores() {
        RSFriendManager var1 = this.getFriendManager();
        if (var1 == null) {
            return null;
        } else {
            RSIgnoreContainer var2 = var1.getIgnoreContainer();
            if (var2 == null) {
                return null;
            } else {
                RSNameable[] var3 = var2.getNameables();
                return (net.runelite.api.Ignore[]) ((net.runelite.api.Ignore[]) var3);
            }
        }
    }

    public int getIgnoreCount() {
        RSFriendManager var1 = this.getFriendManager();
        if (var1 == null) {
            return -1;
        } else {
            RSIgnoreContainer var2 = var1.getIgnoreContainer();
            return var2 == null ? -1 : var2.getCount();
        }
    }

    public boolean isClanMember(String var1) {
        RSClanMemberManager var2 = this.getClanMemberManager();
        return var2 != null && var2.isMember(this.createName(var1, this.getLoginType()));
    }

    public net.runelite.api.SpritePixels createItemSprite(int var1, int var2, int var3, int var4, int var5, boolean var6, int var7) {
        if (!$assertionsDisabled && !this.isClientThread()) {
            throw new AssertionError();
        } else {
            int var8 = this.get3dZoom();
            this.set3dZoom(var7);

            RSSpritePixels var9;
            try {
                var9 = this.createItemSprite(var1, var2, var3, var4, var5, var6);
            } finally {
                this.set3dZoom(var8);
            }

            return var9;
        }
    }

    public boolean hasHintArrow() {
        return class166.clientInstance.getHintArrowTargetType() != HintArrowType.NONE.getValue();
    }

    public void clearHintArrow() {
        class166.clientInstance.setHintArrowTargetType(HintArrowType.NONE.getValue());
    }

    public void setHintArrow(NPC var1) {
        class166.clientInstance.setHintArrowTargetType(HintArrowType.NPC.getValue());
        class166.clientInstance.setHintArrowNpcTargetIdx(var1.getIndex());
    }

    public void setHintArrow(Player var1) {
        class166.clientInstance.setHintArrowTargetType(HintArrowType.PLAYER.getValue());
        class166.clientInstance.setHintArrowPlayerTargetIdx(((RSPlayer) var1).getPlayerId());
    }

    public void setHintArrow(WorldPoint var1) {
        class166.clientInstance.setHintArrowTargetType(HintArrowType.WORLD_POSITION.getValue());
        class166.clientInstance.setHintArrowX(var1.getX());
        class166.clientInstance.setHintArrowY(var1.getY());
        class166.clientInstance.setHintArrowOffsetX(64);
        class166.clientInstance.setHintArrowOffsetY(64);
    }

    public WorldPoint getHintArrowPoint() {
        if (this.getHintArrowType() == HintArrowType.WORLD_POSITION) {
            int var1 = class166.clientInstance.getHintArrowX();
            int var2 = class166.clientInstance.getHintArrowY();
            return new WorldPoint(var1, var2, class166.clientInstance.getPlane());
        } else {
            return null;
        }
    }

    public Player getHintArrowPlayer() {
        if (this.getHintArrowType() == HintArrowType.PLAYER) {
            int var1 = class166.clientInstance.getHintArrowPlayerTargetIdx();
            RSPlayer[] var2 = class166.clientInstance.getCachedPlayers();
            return var1 >= 0 && var1 < var2.length ? var2[var1] : null;
        } else {
            return null;
        }
    }

    public NPC getHintArrowNpc() {
        if (this.getHintArrowType() == HintArrowType.NPC) {
            int var1 = class166.clientInstance.getHintArrowNpcTargetIdx();
            RSNPC[] var2 = class166.clientInstance.getCachedNPCs();
            return var1 >= 0 && var1 < var2.length ? var2[var1] : null;
        } else {
            return null;
        }
    }

    public int getTickCount() {
        return tickCount;
    }

    public void setTickCount(int var1) {
        tickCount = var1;
    }

    public EnumSet getWorldType() {
        int var1 = this.getFlags();
        return WorldType.fromMask(var1);
    }

    public RSItem getLastItemDespawn() {
        return lastItemDespawn;
    }

    public void setLastItemDespawn(RSItem var1) {
        lastItemDespawn = var1;
    }

    public boolean isGpu() {
        return this.gpu;
    }

    public void setGpu(boolean var1) {
        this.gpu = var1;
    }

    public void queueChangedSkill(Skill var1) {
        int[] var2 = class166.clientInstance.getChangedSkills();
        int var3 = class166.clientInstance.getChangedSkillsCount();
        ++var3;
        var2[var3 - 1 & 31] = var1.ordinal();
        class166.clientInstance.setChangedSkillsCount(var3);
    }

    public void setSkyboxColor(int var1) {
        skyboxColor = var1;
    }

    public int getSkyboxColor() {
        return skyboxColor;
    }

    public void runScript(int var1, Object... var2) {
        if (!$assertionsDisabled && !this.isClientThread()) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && currentScript != null) {
            throw new AssertionError();
        } else {
            Object[] var3 = new Object[var2.length + 1];
            var3[0] = Integer.valueOf(var1);
            System.arraycopy(var2, 0, var3, 1, var2.length);
            RSScriptEvent var4 = this.createScriptEvent();
            var4.setArguments(var3);
            this.runScript(var4, 5000000);
        }
    }

    public Map getSpriteOverrides() {
        return spriteOverrides;
    }

    public Map getWidgetSpriteOverrides() {
        return widgetSpriteOverrides;
    }

    public void setStretchedEnabled(boolean var1) {
        stretchedEnabled = var1;
    }

    public boolean isStretchedFast() {
        return stretchedFast;
    }

    public void setStretchedFast(boolean var1) {
        stretchedFast = var1;
    }

    public void setStretchedIntegerScaling(boolean var1) {
        stretchedIntegerScaling = var1;
    }

    public void setStretchedKeepAspectRatio(boolean var1) {
        stretchedKeepAspectRatio = var1;
    }

    public void setScalingFactor(int var1) {
        scalingFactor = 1.0D + (double) var1 / 100.0D;
    }

    public Dimension getStretchedDimensions() {
        if (cachedStretchedDimensions == null) {
            Container var1 = this.getCanvas().getParent();
            int var2 = var1.getWidth();
            int var3 = var1.getHeight();
            Dimension var4 = this.getRealDimensions();
            if (stretchedKeepAspectRatio) {
                double var5 = var4.getWidth() / var4.getHeight();
                int var7 = (int) ((double) var3 * var5);
                if (var7 > var2) {
                    var3 = (int) ((double) var2 / var5);
                } else {
                    var2 = var7;
                }
            }

            if (stretchedIntegerScaling) {
                if (var2 > var4.width) {
                    var2 -= var2 % var4.width;
                }

                if (var3 > var4.height) {
                    var3 -= var3 % var4.height;
                }
            }

            cachedStretchedDimensions = new Dimension(var2, var3);
        }

        return cachedStretchedDimensions;
    }

    public void invalidateStretching(boolean var1) {
        cachedRealDimensions = null;
        cachedStretchedDimensions = null;
        if (var1 && this.isResized()) {
            this.setResizeCanvasNextFrame(true);
        }

    }

    public void setSetting(Varbits var1, int var2) {
        int var3 = var1.getId();
        this.setVarbitValue(this.getVarps(), var3, var2);
    }

    public int getVar(VarClientInt var1) {
        return this.getIntVarcs()[var1.getIndex()];
    }

    public String getVar(VarClientStr var1) {
        return this.getStrVarcs()[var1.getIndex()];
    }

    public void setVar(VarClientStr var1, String var2) {
        String[] var3 = this.getStrVarcs();
        var3[var1.getIndex()] = var2;
    }

    public void setVar(VarClientInt var1, int var2) {
        int[] var3 = this.getIntVarcs();
        var3[var1.getIndex()] = var2;
    }

    public void openWorldHopper() {
        this._protect$menuAction(-1, WidgetInfo.WORLD_SWITCHER_BUTTON.getId(), MenuAction.WIDGET_DEFAULT.getId(), 1, "World Switcher", "", 658, 384);
    }

    public void hopToWorld(net.runelite.api.World var1) {
        int var2 = var1.getId();
        this._protect$menuAction(var2, WidgetInfo.WORLD_SWITCHER_LIST.getId(), MenuAction.WIDGET_DEFAULT.getId(), 1, "Switch", "<col=ff9040>" + (var2 - 300) + "</col>", 683, 244);
    }

    public RSIndexedSprite createIndexedSprite() {
        return new IndexedSprite();
    }

    public RSItem createItem() {
        return new Item();
    }

    public RSWidget createWidget() {
        return new ComponentType();
    }

    public RSWorld createWorld() {
        return new World();
    }

    public void setAnimOffsetX(int var1) {
        Model.animOffsetX = var1;
    }

    public void setAnimOffsetY(int var1) {
        Model.animOffsetY = var1;
    }

    public void setAnimOffsetZ(int var1) {
        Model.animOffsetZ = var1;
    }

    public void revalidateWidgetScroll(Widget[] var1, Widget var2, boolean var3) {
        class196.method4011((ComponentType[]) var1, (ComponentType) var2, var3);
    }

    @Override
    public void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {

    }

    public int getBaseY() {
        return class107.baseY;
    }

    public RSIndexDataBase getIndexScripts() {
        return UrlRequester.clientscripts;
    }

    public int[] getIntStack() {
        return class48.intStack;
    }

    public String[] getStringStack() {
        return class48.scriptStringStack;
    }

    public void setStringStackSize(int var1) {
        class48.scriptStringStackSize = var1;
    }

    public int getStringStackSize() {
        return class48.scriptStringStackSize;
    }

    public RSIndexedSprite[] getMapScene() {
        return class0.mapscene;
    }

    public RSMapElementConfig[] getMapElementConfigs() {
        return MapElementType.mapElementTypes;
    }

    public int getKeyboardIdleTicks() {
        return KeyFocusListener.keyboardIdleTicks;
    }

    public RSNodeCache getCachedModels2() {
        return LocType.field3473;
    }

    public int getRevision() {
        return class45.revision;
    }

    public RSItemComposition getItemDefinition(int var1) {
        return Varcs.method4770(var1);
    }

    public void setUsername(String var1) {
        class316.username = var1;
    }

    public String getUsername() {
        return class316.username;
    }

    public void setPassword(String var1) {
        class316.password = var1;
    }

    public int getCurrentLoginField() {
        return class316.currentLoginField;
    }

    public void changeWorld(net.runelite.api.World var1) {
        UrlRequest.method5575((World) var1);
    }

    public int getOculusOrbFocalPointX() {
        return class192.field68;
    }

    public int getOculusOrbFocalPointY() {
        return class192.field70;
    }

    public RSIndexDataBase getIndexSprites() {
        return JagException.sprites;
    }

    public RSFrames getFrames(int var1) {
        return class315.method5967(var1);
    }

    public int getCanvasHeight() {
        return class230.canvasHeight;
    }

    public RSRenderOverview getRenderOverview() {
        return class219.worldMap;
    }

    public int getBaseX() {
        return class158.baseX;
    }

    public void setIntStackSize(int var1) {
        class228.intStackSize = var1;
    }

    public int getIntStackSize() {
        return class228.intStackSize;
    }

    public Map getChatLineMap() {
        return class202.chatLineMap;
    }

    public RSIterableHashTable getMessages() {
        return class202.messages;
    }

    public int[][][] getTileHeights() {
        return class98.tileHeights;
    }

    public int getCameraY() {
        return class98.cameraY;
    }

    public int getCanvasWidth() {
        return FriendManager.canvasWidth;
    }

    public void setCompass(net.runelite.api.SpritePixels var1) {
        class306.compass = (SpritePixels) var1;
    }

    public RSNodeCache getVarbitCache() {
        return Varbit.varbits;
    }

    public void setTileUpdateCount(int var1) {
        SceneManager.tileUpdateCount = var1;
    }

    public int getTileUpdateCount() {
        return SceneManager.tileUpdateCount;
    }

    public void setScenePlane(int var1) {
        SceneManager.Scene_plane = var1;
    }

    public void setCycle(int var1) {
        SceneManager.cycle = var1;
    }

    public int getCycle() {
        return SceneManager.cycle;
    }

    public void setMinTileX(int var1) {
        SceneManager.minTileX = var1;
    }

    public void setMaxTileX(int var1) {
        SceneManager.maxTileX = var1;
    }

    public void setMinTileZ(int var1) {
        SceneManager.minTileZ = var1;
    }

    public void setMaxTileZ(int var1) {
        SceneManager.maxTileZ = var1;
    }

    public void setScreenCenterX(int var1) {
        SceneManager.screenCenterX = var1;
    }

    public void setScreenCenterZ(int var1) {
        SceneManager.screenCenterZ = var1;
    }

    public void setCameraX2(int var1) {
        SceneManager.cameraX2 = var1;
    }

    public int getCameraX2() {
        return SceneManager.cameraX2;
    }

    public void setCameraY2(int var1) {
        SceneManager.cameraY2 = var1;
    }

    public int getCameraY2() {
        return SceneManager.cameraY2;
    }

    public void setCameraZ2(int var1) {
        SceneManager.cameraZ2 = var1;
    }

    public int getCameraZ2() {
        return SceneManager.cameraZ2;
    }

    public void setPitchSin(int var1) {
        SceneManager.pitchSin = var1;
    }

    public void setPitchCos(int var1) {
        SceneManager.pitchCos = var1;
    }

    public void setYawSin(int var1) {
        SceneManager.yawSin = var1;
    }

    public void setYawCos(int var1) {
        SceneManager.yawCos = var1;
    }

    public void setCheckClick(boolean var1) {
        SceneManager.checkClick = var1;
    }

    public boolean isCheckClick() {
        return SceneManager.checkClick;
    }

    public int getMouseX2() {
        return SceneManager.mouseX2;
    }

    public int getMouseY2() {
        return SceneManager.mouseY2;
    }

    public void setSelectedSceneTileX(int var1) {
        SceneManager.selectedRegionTileX = var1;
    }

    public void setSelectedSceneTileY(int var1) {
        SceneManager.selectedRegionTileY = var1;
    }

    public boolean[][][][] getVisibilityMaps() {
        return SceneManager.visibilityMaps;
    }

    public void setRenderArea(boolean[][] var1) {
        SceneManager.renderArea = var1;
    }

    public boolean containsBounds(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        return SceneManager.method3919(var1, var2, var3, var4, var5, var6, var7, var8);
    }

    public int getVarbit(int var1) {
        return AbstractSoundSystem.method339(var1);
    }

    public RSWorld[] getWorldList() {
        return World.worldList;
    }

    public int[] getGraphicsPixels() {
        return Rasterizer2D.graphicsPixels;
    }

    public int getGraphicsPixelsWidth() {
        return Rasterizer2D.graphicsPixelsWidth;
    }

    public int getGraphicsPixelsHeight() {
        return Rasterizer2D.graphicsPixelsHeight;
    }

    public int getStartY() {
        return Rasterizer2D.drawingAreaTop;
    }

    public int getEndY() {
        return Rasterizer2D.drawingAreaRight;
    }

    public int getStartX() {
        return Rasterizer2D.draw_region_x;
    }

    public int getEndX() {
        return Rasterizer2D.drawingAreaBottom;
    }

    public void RasterizerFillRectangle(int var1, int var2, int var3, int var4, int var5) {
        Rasterizer2D.method449(var1, var2, var3, var4, var5);
    }

    public int[][] getXteaKeys() {
        return IndexStoreActionHandler.xteaKeys;
    }

    public RSNPCComposition getNpcDefinition(int var1) {
        return FileRequest.method4030(var1);
    }

    public RSIndexedSprite[] getModIcons() {
        return FontTypeFace.modIcons;
    }

    public int getCameraYaw() {
        return class39.cameraYaw;
    }

    public int getMouseIdleTicks() {
        return MouseInput.mouseIdleTicks;
    }

    public int getMouseCurrentButton() {
        return MouseInput.mouseCurrentButton;
    }

    public long getMouseLastPressedMillis() {
        return MouseInput.mouseLastPressedTimeMillis;
    }

    public int getCameraX() {
        return class166.cameraX;
    }

    public int getCameraZ() {
        return Packet.cameraZ;
    }

    public RSNodeCache getWidgetSpriteCache() {
        return ComponentType.field2661;
    }

    public RSObjectComposition getObjectDefinition(int var1) {
        return class225.method4485(var1);
    }

    public int[] getMapRegions() {
        return class208.mapRegions;
    }

    public int getCenterX() {
        return Graphics3D.centerX;
    }

    public int getCenterY() {
        return Graphics3D.centerY;
    }

    public int getRasterizer3D_clipNegativeMidX() {
        return Graphics3D.Rasterizer3D_clipNegativeMidX;
    }

    public int getRasterizer3D_clipMidX2() {
        return Graphics3D.Rasterizer3D_clipMidX2;
    }

    public int getRasterizer3D_clipNegativeMidY() {
        return Graphics3D.Rasterizer3D_clipNegativeMidY;
    }

    public int getRasterizer3D_clipMidY2() {
        return Graphics3D.Rasterizer3D_clipMidY2;
    }

    public RSTextureProvider getTextureProvider() {
        return class144.field3688;
    }

    public RSWidget getDraggedWidget() {
        return draggedWidget;
    }

    public RSHashTable getWidgetFlags() {
        return serverActiveProperties;
    }

    public RSHashTable getComponentTable() {
        return subInterfaces;
    }

    public int[] getWidgetPositionsX() {
        return widgetPositionX;
    }

    public void setGameDrawingMode(int var1) {
        gameDrawingMode = var1;
    }

    public int getGameDrawingMode() {
        return gameDrawingMode;
    }

    public int[] getWidgetPositionsY() {
        return widgetPositionY;
    }

    public int getEnergy() {
        return energy;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isDraggingWidget() {
        return draggingWidget;
    }

    public void setDraggedOnWidget(Widget var1) {
        draggedOnWidget = (ComponentType) var1;
    }

    public RSWidget getDraggedOnWidget() {
        return draggedOnWidget;
    }

    public RSSpritePixels[] getMapIcons() {
        return mapIcons;
    }

    public int getScale() {
        return scale;
    }

    public int getViewportWidth() {
        return viewportWidth;
    }

    public int getViewportHeight() {
        return viewportHeight;
    }

    public int[] getChangedSkills() {
        return changedSkills;
    }

    public RSGrandExchangeOffer[] getGrandExchangeOffers() {
        return grandExchangeOffers;
    }

    public int getViewportXOffset() {
        return Viewport_xOffset;
    }

    public void setChangedSkillsCount(int var1) {
        changedSkillsCount = var1;
    }

    public int getChangedSkillsCount() {
        return changedSkillsCount;
    }

    public int getViewportYOffset() {
        return Viewport_yOffset;
    }

    public int getWorld() {
        return world;
    }

    public int getGameCycle() {
        return gameCycle;
    }

    public void setHintArrowTargetType(int var1) {
        hintArrowTargetType = var1;
    }

    public int getHintArrowTargetType() {
        return hintArrowTargetType;
    }

    public void setHintArrowNpcTargetIdx(int var1) {
        hintArrowNpcTargetIdx = var1;
    }

    public int getHintArrowNpcTargetIdx() {
        return hintArrowNpcTargetIdx;
    }

    public void setHintArrowPlayerTargetIdx(int var1) {
        hintArrowPlayerTargetIdx = var1;
    }

    public int getHintArrowPlayerTargetIdx() {
        return hintArrowPlayerTargetIdx;
    }

    public void setHintArrowX(int var1) {
        hintArrowX = var1;
    }

    public int getHintArrowX() {
        return hintArrowX;
    }

    public void setHintArrowY(int var1) {
        hintArrowY = var1;
    }

    public int getHintArrowY() {
        return hintArrowY;
    }

    public void setHintArrowOffsetX(int var1) {
        hintArrowOffsetX = var1;
    }

    public void setHintArrowOffsetY(int var1) {
        hintArrowOffsetY = var1;
    }

    public int[][][] getInstanceTemplateChunks() {
        return instanceTemplateChunks;
    }

    public void setCameraPitchTarget(int var1) {
        cameraPitchTarget = var1;
    }

    public int getCameraPitchTarget() {
        return cameraPitchTarget;
    }

    public int getMapAngle() {
        return mapAngle;
    }

    public void setOculusOrbState(int var1) {
        camModeType = var1;
    }

    public int getOculusOrbState() {
        return camModeType;
    }

    public void setOculusOrbNormalSpeed(int var1) {
        field723 = var1;
    }

    public int[][] getOccupiedTilesTick() {
        return field740;
    }

    public void setItemPressedDuration(int var1) {
        itemPressedDuration = var1;
    }

    public int getItemPressedDuration() {
        return itemPressedDuration;
    }

    public int getLocalInteractingIndex() {
        return localPlayerIndex;
    }

    public int[] getPlayerMenuTypes() {
        return playerMenuTypes;
    }

    public String[] getPlayerOptions() {
        return playerOptions;
    }

    public boolean[] getPlayerOptionsPriorities() {
        return playerOptionsPriorities;
    }

    public RSDeque[][][] getGroundItemDeque() {
        return groundItemDeque;
    }

    @Override
    public RSDeque getProjectilesDeque() {
        return null;
    }

    public boolean isMenuOpen() {
        return isMenuOpen;
    }

    public void packetHandler() {
        this.vmethod3160();
    }

    public void revalidateWidget(Widget var1) {
        this.method3499((ComponentType) var1);
    }

    public boolean getViewportContainsMouse() {
        return class195.Viewport_containsMouse;
    }

    public int getViewportMouseX() {
        return class195.Viewport_mouseX;
    }

    public int getViewportMouseY() {
        return class195.Viewport_mouseY;
    }

    public void setEntitiesAtMouseCount(int var1) {
        class195.Viewport_entityCountAtMouse = var1;
    }

    public int getEntitiesAtMouseCount() {
        return class195.Viewport_entityCountAtMouse;
    }

    public long[] getEntitiesAtMouse() {
        return class195.field1714;
    }

    public void setCameraPitch(int var1) {
        ScriptEvent.cameraPitch = var1;
    }

    public int getCameraPitch() {
        return ScriptEvent.cameraPitch;
    }

    public RSPreferences getPreferences() {
        return GameEngine.options;
    }

    public int getFPS() {
        return GameEngine.FPS;
    }

    public RSSpritePixels[] getMapDots() {
        return GameEngine.mapDots;
    }

    @ObfuscatedName("je")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1017314199"
    )
    final void method3272() {
        class208.method4144(draggedWidget);
        ++class77.field2817;
        if (field824 && field821) {
            int var1 = MouseInput.mouseLastX;
            int var2 = MouseInput.mouseLastY * -976212263;
            var1 -= field906;
            var2 -= field838;
            if (var1 < field713) {
                var1 = field713;
            }

            if (var1 + draggedWidget.width > field713 + field817.width) {
                var1 = field713 + field817.width - draggedWidget.width;
            }

            if (var2 < field823) {
                var2 = field823;
            }

            if (var2 + draggedWidget.height > field823 + field817.height) {
                var2 = field823 + field817.height - draggedWidget.height;
            }

            int var3 = var1 - field825;
            int var4 = var2 - field826;
            int var5 = draggedWidget.dragDeadZone;
            if (class77.field2817 > draggedWidget.dragDeadTime && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
                draggingWidget = true;
                draggingWidgetChanged(-1);
            }

            int var6 = var1 - field713 + field817.scrollX;
            int var7 = var2 - field823 + field817.scrollY;
            ScriptEvent var8;
            if (draggedWidget.onDragListener != null && draggingWidget) {
                var8 = new ScriptEvent();
                var8.source = draggedWidget;
                var8.mouseX = var6;
                var8.mouseY = var7;
                var8.params = draggedWidget.onDragListener;
                class73.method1124(var8);
            }

            if (MouseInput.mouseCurrentButton == 0) {
                if (draggingWidget) {
                    if (draggedWidget.onDragCompleteListener != null) {
                        var8 = new ScriptEvent();
                        var8.source = draggedWidget;
                        var8.mouseX = var6;
                        var8.mouseY = var7;
                        var8.target = draggedOnWidget;
                        var8.params = draggedWidget.onDragCompleteListener;
                        class73.method1124(var8);
                    }

                    if (draggedOnWidget != null && ChatCrownType.method834(draggedWidget) != null) {
                        TcpConnectionMessage var9 = FaceNormal.method5726(ClientProt.IF_BUTTOND, serverConnection.isaac);
                        var9.packetBuffer.getShort128(draggedWidget.index);
                        var9.packetBuffer.getShort128(draggedOnWidget.linkObjType);
                        var9.packetBuffer.putShort(draggedOnWidget.index);
                        var9.packetBuffer.putIntLE(draggedWidget.id);
                        var9.packetBuffer.putIntV1(draggedOnWidget.id);
                        var9.packetBuffer.putShort(draggedWidget.linkObjType);
                        serverConnection.method5881(var9);
                    }
                } else if (this.method3173(170175048)) {
                    this.method3542(field906 + field825, field826 + field838);
                } else if (menuOptionCount > 0) {
                    class219.method4423(field906 + field825, field838 + field826);
                }

                draggedWidget = null;
            }

        } else {
            if (class77.field2817 > 1) {
                draggedWidget = null;
            }

        }
    }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-287340265"
    )
    protected final void vmethod3162() {
        if (MapIconReference.varcs.method4744()) {
            MapIconReference.varcs.method4741();
        }

        if (MapIconReference.mouseRecorder != null) {
            MapIconReference.mouseRecorder.isRunning = false;
        }

        MapIconReference.mouseRecorder = null;
        serverConnection.method5878();
        class89.method1488();
        if (MouseInput.mouse != null) {
            MouseInput var1 = MouseInput.mouse;
            synchronized (MouseInput.mouse) {
                MouseInput.mouse = null;
            }
        }

        IndexFile.mouseWheel = null;
        if (soundSystem0 != null) {
            soundSystem0.method337();
        }

        if (class116.soundSystem1 != null) {
            class116.soundSystem1.method337();
        }

        if (class258.NetCache_socket != null) {
            class258.NetCache_socket.vmethod5603();
        }

        Object var7 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
        synchronized (IndexStoreActionHandler.IndexStoreActionHandler_lock) {
            if (IndexStoreActionHandler.field3243 != 0) {
                IndexStoreActionHandler.field3243 = 1;

                try {
                    IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
                } catch (InterruptedException var4) {
                    ;
                }
            }
        }

        if (class208.urlRequester != null) {
            class208.urlRequester.method4075();
            class208.urlRequester = null;
        }

        FileOnDisk.method152();
    }

    @ObfuscatedName("am")
    @ObfuscatedSignature(
            signature = "(S)V",
            garbageValue = "-475"
    )
    protected final void vmethod3387() {
    }

    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            signature = "(ZI)V",
            garbageValue = "874565984"
    )
    protected final void vmethod3161(boolean var1) {
        this.methodDraw(var1);
        boolean var2 = class170.method2867();
        if (var2 && field879 && soundSystem0 != null) {
            soundSystem0.method282();
        }

        if ((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field870 && Tile.method4297() > field870) {
            WorldMapType2.method3151(WorldMapRectangle.method127());
        }

        int var3;
        if (var1) {
            for (var3 = 0; var3 < 100; ++var3) {
                field848[var3] = true;
            }
        }

        if (gameState == 0) {
            this.method2997(class316.loadingBarPercentage, class316.loadingText, var1);
        } else if (gameState == 5) {
            GameObject.method2034(class288.fontBold12, WorldMapType1.fontPlain11, TotalQuantityComparator.font_p12full, var1);
        } else if (gameState != 10 && gameState != 11) {
            if (gameState == 20) {
                GameObject.method2034(class288.fontBold12, WorldMapType1.fontPlain11, TotalQuantityComparator.font_p12full, var1);
            } else if (gameState == 25) {
                if (field700 == 1) {
                    if (field696 > field697) {
                        field697 = field696;
                    }

                    var3 = (field697 * 50 - field696 * 50) / field697;
                    MouseRecorder.method2747("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
                } else if (field700 == 2) {
                    if (field753 > field909) {
                        field909 = field753;
                    }

                    var3 = (field909 * 50 - field753 * 50) / field909 + 50;
                    MouseRecorder.method2747("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
                } else {
                    MouseRecorder.method2747("Loading - please wait.", false);
                }
            } else if (gameState == 30) {
                this.method3355();
            } else if (gameState == 40) {
                MouseRecorder.method2747("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
            } else if (gameState == 45) {
                MouseRecorder.method2747("Please wait...", false);
            }
        } else {
            GameObject.method2034(class288.fontBold12, WorldMapType1.fontPlain11, TotalQuantityComparator.font_p12full, var1);
        }

        if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
            for (var3 = 0; var3 < widgetCount; ++var3) {
                if (field849[var3]) {
                    WorldMapManager.rasterProvider.vmethod2950(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
                    field849[var3] = false;
                }
            }
        } else if (gameState > 0) {
            WorldMapManager.rasterProvider.vmethod2955(0, 0);

            for (var3 = 0; var3 < widgetCount; ++var3) {
                field849[var3] = false;
            }
        }

    }

    @ObfuscatedName("hg")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "6"
    )
    final void method3256() {
        boolean var1 = false;

        int var2;
        int var5;
        while (!var1) {
            var1 = true;

            for (var2 = 0; var2 < menuOptionCount - 1; ++var2) {
                if (menuTypes[var2] < 1000 && menuTypes[var2 + 1] > 1000) {
                    String var3 = menuTargets[var2];
                    menuTargets[var2] = menuTargets[var2 + 1];
                    menuTargets[var2 + 1] = var3;
                    String var4 = menuOptions[var2];
                    menuOptions[var2] = menuOptions[var2 + 1];
                    menuOptions[var2 + 1] = var4;
                    var5 = menuTypes[var2];
                    menuTypes[var2] = menuTypes[var2 + 1];
                    menuTypes[var2 + 1] = var5;
                    var5 = menuActionParams0[var2];
                    menuActionParams0[var2] = menuActionParams0[var2 + 1];
                    menuActionParams0[var2 + 1] = var5;
                    var5 = menuActionParams1[var2];
                    menuActionParams1[var2] = menuActionParams1[var2 + 1];
                    menuActionParams1[var2 + 1] = var5;
                    var5 = menuIdentifiers[var2];
                    menuIdentifiers[var2] = menuIdentifiers[var2 + 1];
                    menuIdentifiers[var2 + 1] = var5;
                    boolean var6 = menuBooleanArray[var2];
                    menuBooleanArray[var2] = menuBooleanArray[var2 + 1];
                    menuBooleanArray[var2 + 1] = var6;
                    var1 = false;
                }
            }
        }

        if (World.field1025 == null) {
            if (draggedWidget == null) {
                int var17;
                label318:
                {
                    int var16 = MouseInput.mouseLastButton;
                    int var9;
                    int var14;
                    if (isMenuOpen) {
                        int var7;
                        int var13;
                        int var18;
                        if (var16 != 1 && (WorldMapType3.middleMouseMovesCamera || var16 != 4)) {
                            var2 = MouseInput.mouseLastX;
                            var13 = MouseInput.mouseLastY * -976212263;
                            if (var2 < class288.menuX - 10 || var2 > class288.menuX + class9.field1113 + 10 || var13 < class106.menuY - 10 || var13 > class31.field1838 + class106.menuY + 10) {
                                isMenuOpen = false;
                                var14 = class288.menuX;
                                var5 = class106.menuY;
                                var17 = class9.field1113;
                                var7 = class31.field1838;

                                for (var18 = 0; var18 < widgetCount; ++var18) {
                                    if (widgetBoundsWidth[var18] + widgetPositionX[var18] > var14 && widgetPositionX[var18] < var17 + var14 && widgetPositionY[var18] + widgetBoundsHeight[var18] > var5 && widgetPositionY[var18] < var5 + var7) {
                                        field848[var18] = true;
                                    }
                                }
                            }
                        }

                        if (var16 == 1 || !WorldMapType3.middleMouseMovesCamera && var16 == 4) {
                            var2 = class288.menuX;
                            var13 = class106.menuY;
                            var14 = class9.field1113;
                            var5 = MouseInput.mouseLastPressedX;
                            var17 = MouseInput.mouseLastPressedY;
                            var7 = -1;

                            for (var18 = 0; var18 < menuOptionCount; ++var18) {
                                var9 = var13 + (menuOptionCount - 1 - var18) * 15 + 31;
                                if (var5 > var2 && var5 < var2 + var14 && var17 > var9 - 13 && var17 < var9 + 3) {
                                    var7 = var18;
                                }
                            }

                            if (var7 != -1) {
                                class115.method2006(var7);
                            }

                            isMenuOpen = false;
                            var18 = class288.menuX;
                            var9 = class106.menuY;
                            int var10 = class9.field1113;
                            int var11 = class31.field1838;

                            for (int var12 = 0; var12 < widgetCount; ++var12) {
                                if (widgetPositionX[var12] + widgetBoundsWidth[var12] > var18 && widgetPositionX[var12] < var18 + var10 && widgetBoundsHeight[var12] + widgetPositionY[var12] > var9 && widgetPositionY[var12] < var11 + var9) {
                                    field848[var12] = true;
                                }
                            }
                        }
                    } else {
                        var2 = menuOptionCount - 1;
                        if ((var16 == 1 || !WorldMapType3.middleMouseMovesCamera && var16 == 4) && var2 >= 0) {
                            var14 = menuTypes[var2];
                            if (var14 == 39 || var14 == 40 || var14 == 41 || var14 == 42 || var14 == 43 || var14 == 33 || var14 == 34 || var14 == 35 || var14 == 36 || var14 == 37 || var14 == 38 || var14 == 1005) {
                                var5 = menuActionParams0[var2];
                                var17 = menuActionParams1[var2];
                                ComponentType var15 = WorldMapType1.method2440(var17);
                                var9 = class101.method1704(var15);
                                boolean var8 = (var9 >> 28 & 1) != 0;
                                if (var8) {
                                    break label318;
                                }

                                Object var10000 = null;
                                if (ServerProt.method671(class101.method1704(var15))) {
                                    break label318;
                                }
                            }
                        }

                        if ((var16 == 1 || !WorldMapType3.middleMouseMovesCamera && var16 == 4) && this.method3173(440979574)) {
                            var16 = 2;
                        }

                        if ((var16 == 1 || !WorldMapType3.middleMouseMovesCamera && var16 == 4) && menuOptionCount > 0) {
                            class115.method2006(var2);
                        }

                        if (var16 == 2 && menuOptionCount > 0) {
                            this.method3542(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                        }
                    }

                    return;
                }

                if (World.field1025 != null && !field673 && menuOptionCount > 0 && !this.method3173(-2072816976)) {
                    class219.method4423(field752, field845);
                }

                field673 = false;
                itemPressedDuration = 0;
                itemPressedDurationChanged(-1);
                if (World.field1025 != null) {
                    class208.method4144(World.field1025);
                }

                World.field1025 = WorldMapType1.method2440(var17);
                field751 = var5;
                field752 = MouseInput.mouseLastPressedX;
                field845 = MouseInput.mouseLastPressedY;
                if (var2 >= 0) {
                    WorldComparator.method6482(var2);
                }

                class208.method4144(World.field1025);
            }
        }
    }

    @ObfuscatedName("ht")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "-1045755197"
    )
    final void method3542(int var1, int var2) {
        this.menuOpened(var1, var2);
        SubInterface.method2435(var1, var2);
        class131.sceneManager.method3818(class228.level, var1, var2, false);
        isMenuOpen = true;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lbv;II)V"
    )
    static void method3577(ScriptEvent var0, int var1, int var2) {
        Object[] var3 = var0.getArguments();
        if (var3 != null && var3.length > 0 && var3[0] instanceof JavaScriptCallback) {
            try {
                ((JavaScriptCallback) var3[0]).run(var0);
            } catch (Exception var8) {
                class166.clientInstance.getLogger().error("Error in JavaScriptCallback", var8);
            }

        } else {
            try {
                copy$runScript(var0, var1, var2);
            } finally {
                currentScript = null;
            }

        }
    }

    public static void onAddChatMessage(int var0, String var1, String var2, String var3) {
        Logger var4 = class166.clientInstance.getLogger();
        if (var4.isDebugEnabled()) {
            var4.debug("Chat message type {}: {}", ChatMessageType.of(var0), var2);
        }

        ChatMessageType var5 = ChatMessageType.of(var0);
        ChatMessage var6 = new ChatMessage(var5, var1, var2, var3);
        class166.clientInstance.getCallbacks().post(var6);
    }

    public static void copy$processClientError(String var0, Throwable var1, int var2) {
        try {
            String var3 = "";
            if (var1 != null) {
                var3 = TextureProvider.method2791(var1);
            }

            if (var0 != null) {
                if (var1 != null) {
                    if (var2 <= 1629670777) {
                        return;
                    }

                    var3 = var3 + " | ";
                }

                var3 = var3 + var0;
            }

            System.out.println("Error: " + var3);
            var3 = var3.replace(':', '.');
            var3 = var3.replace('@', '_');
            var3 = var3.replace('&', '_');
            var3 = var3.replace('#', '_');
            if (JagException.field1999 == null) {
                return;
            }

            URL var4 = new URL(JagException.field1999.getCodeBase(), "clienterror.ws?c=" + class45.revision + "&u=" + JagException.localPlayerUsername + "&v1=" + Signlink.javaVendor + "&v2=" + Signlink.javaVersion + "&ct=" + class134.clientType + "&e=" + var3);
            DataInputStream var5 = new DataInputStream(var4.openStream());
            var5.read();
            var5.close();
        } catch (Exception var6) {
            ;
        }

    }

    @ObfuscatedSignature(
            signature = "(Lbv;II)V"
    )
    public static void copy$runScript(ScriptEvent var0, int var1, int var2) {
        try {
            Object[] var3 = var0.params;
            Object var4;
            int var18;
            if (class31.method549(var0.field573)) {
                MilliTimer.scriptMapIconReference = (MapIconReference) var3[0];
                MapElementType var5 = Timer.method5389(MilliTimer.scriptMapIconReference.areaId);
                var4 = currentScript = WorldMapManager.method946(var0.field573, var5.id, var5.category);
            } else {
                var18 = currentScriptPC = ((Integer) var3[0]).intValue();
                var4 = currentScript = class192.method3782(var18);
            }

            if (var4 != null) {
                class228.intStackSize = 0;
                class48.scriptStringStackSize = 0;
                currentScriptPC = -1;
                var18 = -1;
                int[] var6 = ((class106) var4).instructions;
                int[] var7 = ((class106) var4).intOperands;
                byte var8 = -1;
                class48.scriptStackCount = 0;
                class48.field1078 = false;

                try {
                    int var11;
                    try {
                        class48.field845 = new int[((class106) var4).localIntCount];
                        int var9 = 0;
                        class48.field835 = new String[((class106) var4).localStringCount];
                        int var10 = 0;

                        int var12;
                        String var19;
                        for (var11 = 1; var11 < var3.length; ++var11) {
                            if (var3[var11] instanceof Integer) {
                                var12 = ((Integer) var3[var11]).intValue();
                                if (var12 == -2147483647) {
                                    var12 = var0.mouseX;
                                }

                                if (var12 == -2147483646) {
                                    var12 = var0.mouseY;
                                }

                                if (var12 == -2147483645) {
                                    var12 = var0.source != null ? var0.source.id : -1;
                                }

                                if (var12 == -2147483644) {
                                    var12 = var0.op;
                                }

                                if (var12 == -2147483643) {
                                    if (var2 >= 1713845009) {
                                        return;
                                    }

                                    var12 = var0.source != null ? var0.source.index : -1;
                                }

                                if (var12 == -2147483642) {
                                    var12 = var0.target != null ? var0.target.id : -1;
                                }

                                if (var12 == -2147483641) {
                                    var12 = var0.target != null ? var0.target.index : -1;
                                }

                                if (var12 == -2147483640) {
                                    var12 = var0.typedKeyCode;
                                }

                                if (var12 == -2147483639) {
                                    var12 = var0.typedKeyChar;
                                }

                                class48.field845[var9++] = var12;
                            } else if (var3[var11] instanceof String) {
                                var19 = (String) var3[var11];
                                if (var19.equals("event_opbase")) {
                                    var19 = var0.opbase;
                                }

                                class48.field835[var10++] = var19;
                            }
                        }

                        var11 = 0;
                        class48.field1075 = var0.field572;

                        while (true) {
                            ++var11;
                            if (var11 > var1) {
                                throw new RuntimeException();
                            }

                            int var32;
                            do {
                                ++var18;
                                currentScriptPC = var18;
                                var32 = var6[var18];
                            } while (vmExecuteOpcode(var32));

                            int var21;
                            if (var32 >= 100) {
                                boolean var36;
                                if (((class106) var4).intOperands[var18] == 1) {
                                    var36 = true;
                                } else {
                                    var36 = false;
                                }

                                var21 = class82.method1178(var32, (class106) var4, var36);
                                switch (var21) {
                                    case 0:
                                        return;
                                    case 1:
                                    default:
                                        break;
                                    case 2:
                                        throw new IllegalStateException();
                                }
                            } else {
                                if (var2 >= 1713845009) {
                                    return;
                                }

                                if (var32 == 0) {
                                    class48.intStack[++class228.intStackSize - 1] = var7[var18];
                                } else if (var32 == 1) {
                                    var12 = var7[var18];
                                    class48.intStack[++class228.intStackSize - 1] = class311.clientVarps[var12];
                                } else if (var32 == 2) {
                                    var12 = var7[var18];
                                    class311.clientVarps[var12] = class48.intStack[--class228.intStackSize];
                                    settingsChanged(var12);
                                    class196.method4012(var12);
                                } else if (var32 == 3) {
                                    class48.scriptStringStack[++class48.scriptStringStackSize - 1] = ((class106) var4).stringOperands[var18];
                                } else {
                                    int var10000;
                                    int var10001;
                                    if (var32 == 6) {
                                        var10001 = var7[var18];
                                        var10000 = var18 + var7[var18];
                                        currentScriptPC = var18 + var10001;
                                        var18 = var10000;
                                    } else if (var32 == 7) {
                                        class228.intStackSize -= 2;
                                        if (class48.intStack[class228.intStackSize] != class48.intStack[class228.intStackSize + 1]) {
                                            var10001 = var7[var18];
                                            var10000 = var18 + var7[var18];
                                            currentScriptPC = var18 + var10001;
                                            var18 = var10000;
                                        }
                                    } else if (var32 == 8) {
                                        class228.intStackSize -= 2;
                                        if (class48.intStack[class228.intStackSize] == class48.intStack[class228.intStackSize + 1]) {
                                            var10001 = var7[var18];
                                            var10000 = var18 + var7[var18];
                                            currentScriptPC = var18 + var10001;
                                            var18 = var10000;
                                        }
                                    } else if (var32 == 9) {
                                        class228.intStackSize -= 2;
                                        if (class48.intStack[class228.intStackSize] < class48.intStack[class228.intStackSize + 1]) {
                                            if (var2 >= 1713845009) {
                                                return;
                                            }

                                            var10001 = var7[var18];
                                            var10000 = var18 + var7[var18];
                                            currentScriptPC = var18 + var10001;
                                            var18 = var10000;
                                        }
                                    } else if (var32 == 10) {
                                        class228.intStackSize -= 2;
                                        if (class48.intStack[class228.intStackSize] > class48.intStack[class228.intStackSize + 1]) {
                                            var10001 = var7[var18];
                                            var10000 = var18 + var7[var18];
                                            currentScriptPC = var18 + var10001;
                                            var18 = var10000;
                                        }
                                    } else if (var32 == 21) {
                                        if (var2 >= 1713845009) {
                                            return;
                                        }

                                        if (class48.scriptStackCount == 0) {
                                            return;
                                        }

                                        ScriptState var37 = class48.scriptStack[--class48.scriptStackCount];
                                        var4 = currentScript = var37.field610;
                                        var6 = ((class106) var4).instructions;
                                        var7 = ((class106) var4).intOperands;
                                        var18 = currentScriptPC = var37.invokedFromPc;
                                        class48.field845 = var37.field603;
                                        class48.field835 = var37.field606;
                                    } else if (var32 == 25) {
                                        if (var2 >= 1713845009) {
                                            return;
                                        }

                                        var12 = var7[var18];
                                        class48.intStack[++class228.intStackSize - 1] = AbstractSoundSystem.method339(var12);
                                    } else if (var32 == 27) {
                                        var12 = var7[var18];
                                        SoundTaskDataProvider.method2533(var12, class48.intStack[--class228.intStackSize]);
                                    } else if (var32 == 31) {
                                        if (var2 >= 1713845009) {
                                            return;
                                        }

                                        class228.intStackSize -= 2;
                                        if (class48.intStack[class228.intStackSize] <= class48.intStack[class228.intStackSize + 1]) {
                                            var10001 = var7[var18];
                                            var10000 = var18 + var7[var18];
                                            currentScriptPC = var18 + var10001;
                                            var18 = var10000;
                                        }
                                    } else if (var32 == 32) {
                                        class228.intStackSize -= 2;
                                        if (class48.intStack[class228.intStackSize] >= class48.intStack[class228.intStackSize + 1]) {
                                            if (var2 >= 1713845009) {
                                                return;
                                            }

                                            var10001 = var7[var18];
                                            var10000 = var18 + var7[var18];
                                            currentScriptPC = var18 + var10001;
                                            var18 = var10000;
                                        }
                                    } else if (var32 == 33) {
                                        class48.intStack[++class228.intStackSize - 1] = class48.field845[var7[var18]];
                                    } else if (var32 == 34) {
                                        class48.field845[var7[var18]] = class48.intStack[--class228.intStackSize];
                                    } else if (var32 == 35) {
                                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = class48.field835[var7[var18]];
                                    } else if (var32 == 36) {
                                        if (var2 >= 1713845009) {
                                            return;
                                        }

                                        class48.field835[var7[var18]] = class48.scriptStringStack[--class48.scriptStringStackSize];
                                    } else if (var32 == 37) {
                                        var12 = var7[var18];
                                        class48.scriptStringStackSize -= var12;
                                        String var34 = class134.method2201(class48.scriptStringStack, class48.scriptStringStackSize, var12);
                                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var34;
                                    } else if (var32 == 38) {
                                        --class228.intStackSize;
                                    } else if (var32 == 39) {
                                        --class48.scriptStringStackSize;
                                    } else {
                                        int var16;
                                        if (var32 != 40) {
                                            if (var32 == 42) {
                                                class48.intStack[++class228.intStackSize - 1] = MapIconReference.varcs.method4736(var7[var18]);
                                            } else if (var32 == 43) {
                                                if (var2 >= 1713845009) {
                                                    return;
                                                }

                                                MapIconReference.varcs.method4759(var7[var18], class48.intStack[--class228.intStackSize]);
                                            } else if (var32 == 44) {
                                                if (var2 >= 1713845009) {
                                                    return;
                                                }

                                                var12 = var7[var18] >> 16;
                                                var21 = var7[var18] & 65535;
                                                int var22 = class48.intStack[--class228.intStackSize];
                                                if (var22 < 0 || var22 > 5000) {
                                                    throw new RuntimeException();
                                                }

                                                class48.scriptArrayLengths[var12] = var22;
                                                byte var23 = -1;
                                                if (var21 == 105) {
                                                    var23 = 0;
                                                }

                                                for (var16 = 0; var16 < var22; ++var16) {
                                                    class48.scriptArrays[var12][var16] = var23;
                                                }
                                            } else if (var32 == 45) {
                                                if (var2 >= 1713845009) {
                                                    return;
                                                }

                                                var12 = var7[var18];
                                                var21 = class48.intStack[--class228.intStackSize];
                                                if (var21 < 0) {
                                                    break;
                                                }

                                                if (var2 >= 1713845009) {
                                                    return;
                                                }

                                                if (var21 >= class48.scriptArrayLengths[var12]) {
                                                    break;
                                                }

                                                class48.intStack[++class228.intStackSize - 1] = class48.scriptArrays[var12][var21];
                                            } else if (var32 == 46) {
                                                var12 = var7[var18];
                                                class228.intStackSize -= 2;
                                                var21 = class48.intStack[class228.intStackSize];
                                                if (var21 < 0 || var21 >= class48.scriptArrayLengths[var12]) {
                                                    throw new RuntimeException();
                                                }

                                                class48.scriptArrays[var12][var21] = class48.intStack[class228.intStackSize + 1];
                                            } else if (var32 == 47) {
                                                if (var2 >= 1713845009) {
                                                    return;
                                                }

                                                var19 = MapIconReference.varcs.method4734(var7[var18]);
                                                if (var19 == null) {
                                                    var19 = "null";
                                                }

                                                class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var19;
                                            } else if (var32 == 48) {
                                                MapIconReference.varcs.method4751(var7[var18], class48.scriptStringStack[--class48.scriptStringStackSize]);
                                            } else {
                                                if (var32 != 60) {
                                                    throw new IllegalStateException();
                                                }

                                                IterableHashTable var35 = ((class106) var4).switches[var7[var18]];
                                                IntegerNode var33 = (IntegerNode) var35.method2764((long) class48.intStack[--class228.intStackSize]);
                                                if (var33 != null) {
                                                    var18 = currentScriptPC = var18 + var33.value;
                                                }
                                            }
                                        } else {
                                            var12 = var7[var18];
                                            class106 var13 = class192.method3782(var12);
                                            int[] var14 = new int[var13.localIntCount];
                                            String[] var15 = new String[var13.localStringCount];

                                            for (var16 = 0; var16 < var13.intStackCount; ++var16) {
                                                var14[var16] = class48.intStack[var16 + (class228.intStackSize - var13.intStackCount)];
                                            }

                                            for (var16 = 0; var16 < var13.stringStackCount; ++var16) {
                                                var15[var16] = class48.scriptStringStack[var16 + (class48.scriptStringStackSize - var13.stringStackCount)];
                                            }

                                            class228.intStackSize -= var13.intStackCount;
                                            class48.scriptStringStackSize -= var13.stringStackCount;
                                            ScriptState var20 = new ScriptState();
                                            var20.field610 = (class106) var4;
                                            var20.invokedFromPc = var18;
                                            var20.field603 = class48.field845;
                                            var20.field606 = class48.field835;
                                            class48.scriptStack[++class48.scriptStackCount - 1] = var20;
                                            currentScript = var13;
                                            var4 = var13;
                                            var6 = var13.instructions;
                                            var7 = var13.intOperands;
                                            currentScriptPC = -1;
                                            var18 = -1;
                                            class48.field845 = var14;
                                            class48.field835 = var15;
                                        }
                                    }
                                }
                            }
                        }

                        throw new RuntimeException();
                    } catch (Exception var29) {
                        StringBuilder var25 = new StringBuilder(30);
                        var25.append("").append(((Node) var4).hash).append(" ");

                        for (var11 = class48.scriptStackCount - 1; var11 >= 0; --var11) {
                            if (var2 >= 1713845009) {
                                return;
                            }

                            var25.append("").append(class48.scriptStack[var11].field610.hash).append(" ");
                        }

                        var25.append("").append(var8);
                        ProjectileAnimation.method5582(var25.toString(), var29, 1721189784);
                    }
                } finally {
                    if (class48.field1078) {
                        class48.field1079 = true;
                        GameCanvas.method893();
                        class48.field1079 = false;
                        class48.field1078 = false;
                    }

                }
            }
        } catch (RuntimeException var31) {
            throw CacheFile.method2128(var31, "client.r(" + ')');
        }
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public static void canvasWidthChanged(int var0) {
        class166.clientInstance.getCallbacks().post(new CanvasSizeChanged());
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public static void gameStateChanged(int var0) {
        GameStateChanged var1 = new GameStateChanged();
        var1.setGameState(class166.clientInstance.getGameState());
        class166.clientInstance.getCallbacks().post(var1);
    }

    @ObfuscatedSignature(
            signature = "(Liu;IIB)Lls;"
    )
    public static SpritePixels copy$getSpriteAsSpritePixels(Js5Index var0, int var1, int var2, byte var3) {
        return !WorldMapRectangle.method128(var0, var1, var2) ? null : FileRequest.method4031();
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public static void canvasHeightChanged(int var0) {
        class166.clientInstance.getCallbacks().post(new CanvasSizeChanged());
    }

    public static final void copy$menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7, int var8) {
        if (var2 >= 2000) {
            var2 -= 2000;
        }

        TcpConnectionMessage var9;
        if (var2 == 1) {
            if (var8 >= -1366111544) {
                return;
            }

            lastLeftClickX = var6;
            lastLeftClickY = var7;
            cursorState = 2;
            field809 = 0;
            destinationX = var0;
            destinationY = var1;
            var9 = FaceNormal.method5726(ClientProt.OPLOCU, serverConnection.isaac);
            var9.packetBuffer.putShortLEA(class107.baseY + var1);
            var9.packetBuffer.putShortLE(MapLabel.selectedItemIndex);
            var9.packetBuffer.putByte128(KeyFocusListener.keyPressed[82] ? 1 : 0);
            var9.packetBuffer.putIntLE(ChatLineBuffer.field1276);
            var9.packetBuffer.putShortLEA(var0 + class158.baseX);
            var9.packetBuffer.putShort(var3);
            var9.packetBuffer.putShortLE(class116.field51);
            serverConnection.method5881(var9);
        } else {
            Bit var10000;
            byte var10001;
            if (var2 == 2) {
                lastLeftClickX = var6;
                lastLeftClickY = var7;
                cursorState = 2;
                field809 = 0;
                destinationX = var0;
                destinationY = var1;
                var9 = FaceNormal.method5726(ClientProt.OPLOCT, serverConnection.isaac);
                var10000 = var9.packetBuffer;
                if (KeyFocusListener.keyPressed[82]) {
                    if (var8 >= -1366111544) {
                        return;
                    }

                    var10001 = 1;
                } else {
                    var10001 = 0;
                }

                var10000.putByte(var10001);
                var9.packetBuffer.putShort(var0 + class158.baseX);
                var9.packetBuffer.getShort128(var3);
                var9.packetBuffer.putIntV2(class174.field3796);
                var9.packetBuffer.putShort(field799);
                var9.packetBuffer.putShortLE(class107.baseY + var1);
                serverConnection.method5881(var9);
                /**
                 * OBJ option 1
                 */
            } else if (var2 == 3) {
                lastLeftClickX = var6;
                lastLeftClickY = var7;
                cursorState = 2;
                field809 = 0;
                destinationX = var0;
                destinationY = var1;
                var9 = FaceNormal.method5726(ClientProt.OPLOC1, serverConnection.isaac);
                var9.packetBuffer.putShort(class107.baseY + var1);
                var9.packetBuffer.putByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                var9.packetBuffer.getShort128(var3);
                var9.packetBuffer.putShortLEA(var0 + class158.baseX);
                serverConnection.method5881(var9);
                /**
                 * OBJ Option 2
                 */
            } else if (var2 == 4) {
                lastLeftClickX = var6;
                lastLeftClickY = var7;
                cursorState = 2;
                field809 = 0;
                destinationX = var0;
                destinationY = var1;
                var9 = FaceNormal.method5726(ClientProt.OPLOC2, serverConnection.isaac);
                var10000 = var9.packetBuffer;
                if (KeyFocusListener.keyPressed[82]) {
                    if (var8 >= -1366111544) {
                        return;
                    }

                    var10001 = 1;
                } else {
                    var10001 = 0;
                }

                var10000.putByte128(var10001);
                var9.packetBuffer.putShort(var3);
                var9.packetBuffer.putShort(class107.baseY + var1);
                var9.packetBuffer.putShort(var0 + class158.baseX);
                serverConnection.method5881(var9);
            } else if (var2 == 5) {
                lastLeftClickX = var6;
                lastLeftClickY = var7;
                cursorState = 2;
                field809 = 0;
                destinationX = var0;
                destinationY = var1;
                var9 = FaceNormal.method5726(ClientProt.OPLOC3, serverConnection.isaac);
                var9.packetBuffer.putShortLEA(var0 + class158.baseX);
                var9.packetBuffer.getShort128(var3);
                var9.packetBuffer.putShortLEA(class107.baseY + var1);
                var9.packetBuffer.putByte128(KeyFocusListener.keyPressed[82] ? 1 : 0);
                serverConnection.method5881(var9);
            } else if (var2 == 6) {
                lastLeftClickX = var6;
                lastLeftClickY = var7;
                cursorState = 2;
                field809 = 0;
                destinationX = var0;
                destinationY = var1;
                var9 = FaceNormal.method5726(ClientProt.OPLOC4, serverConnection.isaac);
                var9.packetBuffer.putByte128(KeyFocusListener.keyPressed[82] ? 1 : 0);
                var9.packetBuffer.getShort128(class107.baseY + var1);
                var9.packetBuffer.getShort128(var0 + class158.baseX);
                var9.packetBuffer.putShortLE(var3);
                serverConnection.method5881(var9);
            } else {
                TcpConnectionMessage var10;
                NPCEntity var14;
                if (var2 == 7) {
                    var14 = npcs[var3];
                    if (var14 != null) {
                        lastLeftClickX = var6;
                        lastLeftClickY = var7;
                        cursorState = 2;
                        field809 = 0;
                        destinationX = var0;
                        destinationY = var1;
                        var10 = FaceNormal.method5726(ClientProt.OPNPCU, serverConnection.isaac);
                        var10.packetBuffer.putShortLEA(class116.field51);
                        var10.packetBuffer.putShort(MapLabel.selectedItemIndex);
                        var10.packetBuffer.putShortLEA(var3);
                        var10000 = var10.packetBuffer;
                        if (KeyFocusListener.keyPressed[82]) {
                            if (var8 >= -1366111544) {
                                return;
                            }

                            var10001 = 1;
                        } else {
                            var10001 = 0;
                        }

                        var10000.putByteC(var10001);
                        var10.packetBuffer.method6230(ChatLineBuffer.field1276);
                        serverConnection.method5881(var10);
                    }
                } else if (var2 == 8) {
                    var14 = npcs[var3];
                    if (var14 != null) {
                        lastLeftClickX = var6;
                        lastLeftClickY = var7;
                        cursorState = 2;
                        field809 = 0;
                        destinationX = var0;
                        destinationY = var1;
                        var10 = FaceNormal.method5726(ClientProt.OPNPCT, serverConnection.isaac);
                        var10.packetBuffer.putShortLEA(var3);
                        var10000 = var10.packetBuffer;
                        if (KeyFocusListener.keyPressed[82]) {
                            if (var8 >= -1366111544) {
                                return;
                            }

                            var10001 = 1;
                        } else {
                            var10001 = 0;
                        }

                        var10000.putByteC(var10001);
                        var10.packetBuffer.putIntLE(class174.field3796);
                        var10.packetBuffer.getShort128(field799);
                        serverConnection.method5881(var10);
                    }
                } else {
                    label1268:
                    {
                        ComponentType var16;
                        label1203:
                        {
                            //npc talk
                            if (var2 == 9) {
                                var14 = npcs[var3];
                                if (var14 != null) {
                                    lastLeftClickX = var6;
                                    lastLeftClickY = var7;
                                    cursorState = 2;
                                    field809 = 0;
                                    destinationX = var0;
                                    destinationY = var1;
                                    var10 = FaceNormal.method5726(ClientProt.OPNPC1, serverConnection.isaac);
                                    var10.packetBuffer.putByteC(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                    var10.packetBuffer.putShortLE(var3);
                                    System.out.println(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                    System.out.println(var3);
                                    serverConnection.method5881(var10);
                                }
                            } else {
                                if (var2 == 10) {
                                    var14 = npcs[var3];
                                    if (var14 != null) {
                                        lastLeftClickX = var6;
                                        lastLeftClickY = var7;
                                        cursorState = 2;
                                        field809 = 0;
                                        destinationX = var0;
                                        destinationY = var1;
                                        var10 = FaceNormal.method5726(ClientProt.OPNPC2, serverConnection.isaac);
                                        var10.packetBuffer.getShort128(var3);
                                        var10.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                        serverConnection.method5881(var10);
                                    }
                                    break label1268;
                                }

                                if (var2 == 11) {
                                    var14 = npcs[var3];
                                    if (var14 != null) {
                                        lastLeftClickX = var6;
                                        lastLeftClickY = var7;
                                        cursorState = 2;
                                        field809 = 0;
                                        destinationX = var0;
                                        destinationY = var1;
                                        var10 = FaceNormal.method5726(ClientProt.OPNPC3, serverConnection.isaac);
                                        var10.packetBuffer.putShortLEA(var3);
                                        var10.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                        serverConnection.method5881(var10);
                                    }
                                    break label1268;
                                }

                                if (var2 == 12) {
                                    var14 = npcs[var3];
                                    if (var14 != null) {
                                        if (var8 >= -1366111544) {
                                            return;
                                        }

                                        lastLeftClickX = var6;
                                        lastLeftClickY = var7;
                                        cursorState = 2;
                                        field809 = 0;
                                        destinationX = var0;
                                        destinationY = var1;
                                        var10 = FaceNormal.method5726(ClientProt.OPNPC4, serverConnection.isaac);
                                        var10.packetBuffer.putShort(var3);

                                        System.out.println("[OPNPC4] Index: " + var3);
                                        var10000 = var10.packetBuffer;
                                        if (KeyFocusListener.keyPressed[82]) {
                                            if (var8 >= -1366111544) {
                                                return;
                                            }

                                            var10001 = 1;
                                        } else {
                                            var10001 = 0;
                                        }

                                        var10000.putByte128(var10001);
                                        serverConnection.method5881(var10);
                                    }
                                    break label1268;
                                }

                                if (var2 == 13) {
                                    var14 = npcs[var3];
                                    if (var14 != null) {
                                        lastLeftClickX = var6;
                                        lastLeftClickY = var7;
                                        cursorState = 2;
                                        field809 = 0;
                                        destinationX = var0;
                                        destinationY = var1;
                                        var10 = FaceNormal.method5726(ClientProt.OPNPC5, serverConnection.isaac);
                                        var10000 = var10.packetBuffer;
                                        if (KeyFocusListener.keyPressed[82]) {
                                            if (var8 >= -1366111544) {
                                                return;
                                            }

                                            var10001 = 1;
                                        } else {
                                            var10001 = 0;
                                        }

                                        var10000.putByte(var10001);
                                        var10.packetBuffer.getShort128(var3);
                                        serverConnection.method5881(var10);
                                    }
                                    break label1268;
                                }

                                PlayerEntity var17;
                                if (var2 == 14) {
                                    var17 = players[var3];
                                    if (var17 != null) {
                                        lastLeftClickX = var6;
                                        lastLeftClickY = var7;
                                        cursorState = 2;
                                        field809 = 0;
                                        destinationX = var0;
                                        destinationY = var1;
                                        var10 = FaceNormal.method5726(ClientProt.OPPLAYERU, serverConnection.isaac);
                                        var10.packetBuffer.putShortLEA(MapLabel.selectedItemIndex);
                                        var10.packetBuffer.putByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                        var10.packetBuffer.putIntV1(ChatLineBuffer.field1276);
                                        var10.packetBuffer.putShort(var3);
                                        var10.packetBuffer.putShort(class116.field51);
                                        serverConnection.method5881(var10);
                                    }
                                    break label1268;
                                }

                                if (var2 == 15) {
                                    var17 = players[var3];
                                    if (var17 != null) {
                                        if (var8 >= -1366111544) {
                                            return;
                                        }

                                        lastLeftClickX = var6;
                                        lastLeftClickY = var7;
                                        cursorState = 2;
                                        field809 = 0;
                                        destinationX = var0;
                                        destinationY = var1;
                                        var10 = FaceNormal.method5726(ClientProt.OPPLAYERT, serverConnection.isaac);
                                        var10.packetBuffer.putIntV2(class174.field3796);
                                        var10.packetBuffer.putByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                        var10.packetBuffer.getShort128(field799);
                                        var10.packetBuffer.putShort(var3);
                                        serverConnection.method5881(var10);
                                    }
                                    break label1268;
                                }

                                if (var2 == 16) {
                                    lastLeftClickX = var6;
                                    lastLeftClickY = var7;
                                    cursorState = 2;
                                    field809 = 0;
                                    destinationX = var0;
                                    destinationY = var1;
                                    var9 = FaceNormal.method5726(ClientProt.OPOBJU, serverConnection.isaac);
                                    var9.packetBuffer.putIntV1(ChatLineBuffer.field1276);
                                    var9.packetBuffer.putShortLEA(class116.field51);
                                    var9.packetBuffer.putByte128(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                    var9.packetBuffer.putShortLE(MapLabel.selectedItemIndex);
                                    var9.packetBuffer.putShortLEA(var3);
                                    var9.packetBuffer.putShortLEA(var0 + class158.baseX);
                                    var9.packetBuffer.putShortLE(class107.baseY + var1);
                                    serverConnection.method5881(var9);
                                    break label1268;
                                }

                                if (var2 == 17) {
                                    lastLeftClickX = var6;
                                    lastLeftClickY = var7;
                                    cursorState = 2;
                                    field809 = 0;
                                    destinationX = var0;
                                    destinationY = var1;
                                    var9 = FaceNormal.method5726(ClientProt.OPOBJT, serverConnection.isaac);
                                    var9.packetBuffer.putIntV1(class174.field3796);
                                    var9.packetBuffer.putShort(field799);
                                    var9.packetBuffer.getShort128(class107.baseY + var1);
                                    var9.packetBuffer.getShort128(var0 + class158.baseX);
                                    var9.packetBuffer.putByte128(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                    var9.packetBuffer.putShortLE(var3);
                                    serverConnection.method5881(var9);
                                    break label1268;
                                }

                                if (var2 == 18) {
                                    if (var8 >= -1366111544) {
                                        return;
                                    }

                                    lastLeftClickX = var6;
                                    lastLeftClickY = var7;
                                    cursorState = 2;
                                    field809 = 0;
                                    destinationX = var0;
                                    destinationY = var1;
                                    var9 = FaceNormal.method5726(ClientProt.OPOBJ1, serverConnection.isaac);
                                    var9.packetBuffer.putShortLEA(class107.baseY + var1);
                                    var9.packetBuffer.putShortLE(var3);
                                    var9.packetBuffer.putShortLE(var0 + class158.baseX);
                                    var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                    serverConnection.method5881(var9);
                                    break label1268;
                                }

                                if (var2 == 19) {
                                    lastLeftClickX = var6;
                                    lastLeftClickY = var7;
                                    cursorState = 2;
                                    field809 = 0;
                                    destinationX = var0;
                                    destinationY = var1;
                                    var9 = FaceNormal.method5726(ClientProt.OPOBJ2, serverConnection.isaac);
                                    var9.packetBuffer.putShortLEA(var3);
                                    var9.packetBuffer.getShort128(var0 + class158.baseX);
                                    var9.packetBuffer.putShort(class107.baseY + var1);
                                    var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                    serverConnection.method5881(var9);
                                    break label1268;
                                }

                                if (var2 == 20) {
                                    lastLeftClickX = var6;
                                    lastLeftClickY = var7;
                                    cursorState = 2;
                                    field809 = 0;
                                    destinationX = var0;
                                    destinationY = var1;
                                    var9 = FaceNormal.method5726(ClientProt.OPOBJ3, serverConnection.isaac);
                                    var9.packetBuffer.putShortLE(class107.baseY + var1);
                                    var9.packetBuffer.putByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                    var9.packetBuffer.putShortLE(var0 + class158.baseX);
                                    var9.packetBuffer.putShortLE(var3);
                                    serverConnection.method5881(var9);
                                    break label1268;
                                }

                                if (var2 == 21) {
                                    lastLeftClickX = var6;
                                    lastLeftClickY = var7;
                                    cursorState = 2;
                                    field809 = 0;
                                    destinationX = var0;
                                    destinationY = var1;
                                    var9 = FaceNormal.method5726(ClientProt.OPOBJ4, serverConnection.isaac);
                                    var9.packetBuffer.getShort128(class107.baseY + var1);
                                    var9.packetBuffer.putShortLE(var3);
                                    var9.packetBuffer.putShort(var0 + class158.baseX);
                                    var9.packetBuffer.putByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                    serverConnection.method5881(var9);
                                    break label1268;
                                }

                                if (var2 == 22) {
                                    lastLeftClickX = var6;
                                    lastLeftClickY = var7;
                                    cursorState = 2;
                                    field809 = 0;
                                    destinationX = var0;
                                    destinationY = var1;
                                    var9 = FaceNormal.method5726(ClientProt.OPOBJ5, serverConnection.isaac);
                                    var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                    var9.packetBuffer.putShortLEA(var3);
                                    var9.packetBuffer.getShort128(class107.baseY + var1);
                                    var9.packetBuffer.putShort(var0 + class158.baseX);
                                    serverConnection.method5881(var9);
                                    break label1268;
                                }

                                if (var2 == 23) {
                                    if (isMenuOpen) {
                                        if (var8 >= -1366111544) {
                                            return;
                                        }

                                        class131.sceneManager.method3833();
                                    } else {
                                        class131.sceneManager.method3818(class228.level, var0, var1, true);
                                    }
                                    break label1268;
                                }

                                TcpConnectionMessage var11;
                                if (var2 == 24) {
                                    if (var8 >= -1366111544) {
                                        return;
                                    }

                                    var16 = WorldMapType1.method2440(var1);
                                    boolean var12 = true;
                                    if (var16.clientcode > 0) {
                                        if (var8 >= -1366111544) {
                                            return;
                                        }

                                        var12 = WorldMapType3.method1673(var16);
                                    }

                                    if (var12) {
                                        if (var8 >= -1366111544) {
                                            return;
                                        }

                                        var11 = FaceNormal.method5726(ClientProt.BUTTON_CLICK, serverConnection.isaac);
                                        var11.packetBuffer.method6230(var1);
                                        serverConnection.method5881(var11);
                                    }
                                    break label1268;
                                }

                                if (var2 == 25) {
                                    if (var8 >= -1366111544) {
                                        return;
                                    }

                                    var16 = class192.method3785(var1, var0);
                                    if (var16 != null) {
                                        Occluder.method4635();
                                        OwnWorldComparator.method531(var1, var0, class192.method3781(class101.method1704(var16)), var16.linkObjType);
                                        itemSelectionState = 0;
                                        targetVerb = class106.method1886(var16);
                                        if (targetVerb == null) {
                                            targetVerb = "null";
                                        }

                                        if (var16.isIf3) {
                                            opBase = var16.opBase + class31.method548(16777215);
                                        } else {
                                            opBase = class31.method548(65280) + var16.spellName + class31.method548(16777215);
                                        }
                                    }

                                    return;
                                }

                                if (var2 == 26) {
                                    if (var8 >= -1366111544) {
                                        return;
                                    }

                                    GameCanvas.method893();
                                    break label1268;
                                }

                                int var13;
                                ComponentType var18;
                                if (var2 == 28) {
                                    if (var8 >= -1366111544) {
                                        return;
                                    }

                                    var9 = FaceNormal.method5726(ClientProt.BUTTON_CLICK, serverConnection.isaac);
                                    var9.packetBuffer.method6230(var1);
                                    serverConnection.method5881(var9);
                                    var18 = WorldMapType1.method2440(var1);
                                    if (var18.dynamicValues != null) {
                                        if (var8 >= -1366111544) {
                                            return;
                                        }

                                        if (var18.dynamicValues[0][0] == 5) {
                                            if (var8 >= -1366111544) {
                                                return;
                                            }

                                            var13 = var18.dynamicValues[0][1];
                                            class311.clientVarps[var13] = 1 - class311.clientVarps[var13];
                                            settingsChanged(var13);
                                            class196.method4012(var13);
                                        }
                                    }
                                    break label1268;
                                }

                                if (var2 == 29) {
                                    var9 = FaceNormal.method5726(ClientProt.BUTTON_CLICK, serverConnection.isaac);
                                    var9.packetBuffer.method6230(var1);
                                    serverConnection.method5881(var9);
                                    var18 = WorldMapType1.method2440(var1);
                                    if (var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
                                        var13 = var18.dynamicValues[0][1];
                                        if (class311.clientVarps[var13] != var18.field2778[0]) {
                                            class311.clientVarps[var13] = var18.field2778[0];
                                            settingsChanged(var13);
                                            class196.method4012(var13);
                                        }
                                    }
                                    break label1268;
                                }

                                if (var2 == 30) {
                                    if (field880 == null) {
                                        Sequence.method4796(var1, var0);
                                        field880 = class192.method3785(var1, var0);
                                        class208.method4144(field880);
                                    }
                                    break label1268;
                                }
                                // item on item
                                if (var2 == 31) {
                                    var9 = FaceNormal.method5726(ClientProt.OPHELDU, serverConnection.isaac);

                                    var9.packetBuffer.putIntV1(var1);
                                    var9.packetBuffer.putIntV2(ChatLineBuffer.field1276);
                                    var9.packetBuffer.putShortLEA(MapLabel.selectedItemIndex);
                                    var9.packetBuffer.putShortLE(class116.field51);
                                    var9.packetBuffer.putShortLE(var0);
                                    var9.packetBuffer.putShortLEA(var3);

                                    /*System.out.println("ITEM_ON_ITEM" + " putIntV1 " + var1); //interface hash
                                    System.out.println("ITEM_ON_ITEM" + " putIntV2 " + ChatLineBuffer.field1276); //interface id
                                    System.out.println("ITEM_ON_ITEM" + " putShortLEA " + MapLabel.selectedItemIndex);
                                    System.out.println("ITEM_ON_ITEM" + " putShortLE " + class116.field51); // item used
                                    System.out.println("ITEM_ON_ITEM" + " putShortLE " + var0); // slot used on
                                    System.out.println("ITEM_ON_ITEM" + " putShortLEA " + var3); // item used on*/

                                    serverConnection.method5881(var9);
                                    mouseCrosshair = 0;
                                    class92.field2357 = WorldMapType1.method2440(var1);
                                    pressedItemIndex = var0;
                                    break label1268;
                                }

                                if (var2 == 32) {
                                    var9 = FaceNormal.method5726(ClientProt.OPHELDT, serverConnection.isaac);
                                    var9.packetBuffer.putIntV1(class174.field3796);
                                    var9.packetBuffer.method6230(var1);
                                    var9.packetBuffer.putShort(var0);
                                    var9.packetBuffer.putShortLE(var3);
                                    var9.packetBuffer.putShortLE(field799);
                                    serverConnection.method5881(var9);
                                    mouseCrosshair = 0;
                                    class92.field2357 = WorldMapType1.method2440(var1);
                                    pressedItemIndex = var0;
                                    break label1268;
                                }

                                if (var2 == 33) {
                                    var9 = FaceNormal.method5726(ClientProt.OPHELD1, serverConnection.isaac);
                                    var9.packetBuffer.putShortLE(var3);
                                    var9.packetBuffer.putIntV1(var1);
                                    var9.packetBuffer.putShort(var0);

                                    System.out.println("[ItemActionPacket] [OPHELD1] " + var3);
                                    System.out.println("[ItemActionPacket] [OPHELD1] " + var1);
                                    System.out.println("[ItemActionPacket] [OPHELD1] " + var0);

                                    serverConnection.method5881(var9);
                                    mouseCrosshair = 0;
                                    class92.field2357 = WorldMapType1.method2440(var1);
                                    pressedItemIndex = var0;
                                    break label1268;
                                }

                                if (var2 == 34) {
                                    var9 = FaceNormal.method5726(ClientProt.OPHELD2, serverConnection.isaac);
                                    var9.packetBuffer.getShort128(var3);
                                    var9.packetBuffer.putIntV2(var1);
                                    var9.packetBuffer.putShortLEA(var0);
                                    serverConnection.method5881(var9);
                                    mouseCrosshair = 0;
                                    class92.field2357 = WorldMapType1.method2440(var1);
                                    pressedItemIndex = var0;
                                    break label1268;
                                }

                                if (var2 == 35) {
                                    if (var8 >= -1366111544) {
                                        return;
                                    }

                                    var9 = FaceNormal.method5726(ClientProt.OPHELD3, serverConnection.isaac);
                                    var9.packetBuffer.putIntLE(var1);
                                    var9.packetBuffer.putShortLEA(var0);
                                    var9.packetBuffer.putShortLEA(var3);
                                    serverConnection.method5881(var9);
                                    mouseCrosshair = 0;
                                    class92.field2357 = WorldMapType1.method2440(var1);
                                    pressedItemIndex = var0;
                                    break label1268;
                                }

                                if (var2 == 36) {
                                    var9 = FaceNormal.method5726(ClientProt.OPHELD4, serverConnection.isaac);
                                    var9.packetBuffer.putShortLEA(var3);
                                    var9.packetBuffer.method6230(var1);
                                    var9.packetBuffer.putShortLEA(var0);
                                    serverConnection.method5881(var9);
                                    mouseCrosshair = 0;
                                    class92.field2357 = WorldMapType1.method2440(var1);
                                    pressedItemIndex = var0;
                                    break label1268;
                                }

                                if (var2 == 37) {
                                    var9 = FaceNormal.method5726(ClientProt.OPHELD5, serverConnection.isaac);
                                    var9.packetBuffer.method6230(var1);
                                    var9.packetBuffer.putShort(var0);
                                    var9.packetBuffer.putShort(var3);
                                    serverConnection.method5881(var9);
                                    mouseCrosshair = 0;
                                    class92.field2357 = WorldMapType1.method2440(var1);
                                    pressedItemIndex = var0;
                                    break label1268;
                                }

                                if (var2 == 38) {
                                    Occluder.method4635();
                                    var16 = WorldMapType1.method2440(var1);
                                    itemSelectionState = 1;
                                    MapLabel.selectedItemIndex = var0;
                                    ChatLineBuffer.field1276 = var1;
                                    class116.field51 = var3;
                                    class208.method4144(var16);
                                    lastSelectedItemName = class31.method548(16748608) + Varcs.method4770(var3).name + class31.method548(16777215);
                                    if (lastSelectedItemName == null) {
                                        lastSelectedItemName = "null";
                                    }

                                    return;
                                }

                                if (var2 == 39) {
                                    if (var8 >= -1366111544) {
                                        return;
                                    }

                                    var9 = FaceNormal.method5726(ClientProt.IF1_BUTTON1, serverConnection.isaac);
                                    var9.packetBuffer.putShortLEA(var3);
                                    var9.packetBuffer.putIntV2(var1);
                                    var9.packetBuffer.putShortLE(var0);
                                    serverConnection.method5881(var9);
                                    mouseCrosshair = 0;
                                    class92.field2357 = WorldMapType1.method2440(var1);
                                    pressedItemIndex = var0;
                                    break label1268;
                                }

                                if (var2 == 40) {
                                    var9 = FaceNormal.method5726(ClientProt.IF1_BUTTON2, serverConnection.isaac);
                                    var9.packetBuffer.putIntV2(var1);
                                    var9.packetBuffer.putShortLE(var0);
                                    var9.packetBuffer.getShort128(var3);
                                    serverConnection.method5881(var9);
                                    mouseCrosshair = 0;
                                    class92.field2357 = WorldMapType1.method2440(var1);
                                    pressedItemIndex = var0;
                                    break label1268;
                                }

                                if (var2 == 41) {
                                    if (var8 >= -1366111544) {
                                        return;
                                    }

                                    var9 = FaceNormal.method5726(ClientProt.IF1_BUTTON3, serverConnection.isaac);
                                    var9.packetBuffer.putIntLE(var1);
                                    var9.packetBuffer.getShort128(var0);
                                    var9.packetBuffer.putShort(var3);
                                    serverConnection.method5881(var9);
                                    mouseCrosshair = 0;
                                    class92.field2357 = WorldMapType1.method2440(var1);
                                    pressedItemIndex = var0;
                                    break label1268;
                                }

                                if (var2 == 42) {
                                    var9 = FaceNormal.method5726(ClientProt.IF1_BUTTON4, serverConnection.isaac);
                                    var9.packetBuffer.method6230(var1);
                                    var9.packetBuffer.getShort128(var0);
                                    var9.packetBuffer.putShort(var3);
                                    serverConnection.method5881(var9);
                                    mouseCrosshair = 0;
                                    class92.field2357 = WorldMapType1.method2440(var1);
                                    pressedItemIndex = var0;
                                } else {
                                    if (var2 == 43) {
                                        var9 = FaceNormal.method5726(ClientProt.IF1_BUTTON5, serverConnection.isaac);
                                        var9.packetBuffer.putShort(var3);
                                        var9.packetBuffer.putIntV1(var1);
                                        var9.packetBuffer.putShort(var0);
                                        serverConnection.method5881(var9);
                                        mouseCrosshair = 0;
                                        class92.field2357 = WorldMapType1.method2440(var1);
                                        pressedItemIndex = var0;
                                        break label1268;
                                    }

                                    if (var2 == 44) {
                                        var17 = players[var3];
                                        if (var17 != null) {
                                            lastLeftClickX = var6;
                                            lastLeftClickY = var7;
                                            cursorState = 2;
                                            field809 = 0;
                                            destinationX = var0;
                                            destinationY = var1;
                                            var10 = FaceNormal.method5726(ClientProt.OPPLAYER1, serverConnection.isaac);
                                            var10.packetBuffer.putShort(var3);
                                            var10.packetBuffer.putByteC(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                            serverConnection.method5881(var10);
                                        }
                                        break label1268;
                                    }

                                    if (var2 == 45) {
                                        var17 = players[var3];
                                        if (var17 != null) {
                                            lastLeftClickX = var6;
                                            lastLeftClickY = var7;
                                            cursorState = 2;
                                            field809 = 0;
                                            destinationX = var0;
                                            destinationY = var1;
                                            var10 = FaceNormal.method5726(ClientProt.OPPLAYER2, serverConnection.isaac);
                                            var10.packetBuffer.putByte128(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                            var10.packetBuffer.getShort128(var3);
                                            serverConnection.method5881(var10);
                                        }
                                        break label1268;
                                    }

                                    if (var2 == 46) {
                                        var17 = players[var3];
                                        if (var17 != null) {
                                            lastLeftClickX = var6;
                                            lastLeftClickY = var7;
                                            cursorState = 2;
                                            field809 = 0;
                                            destinationX = var0;
                                            destinationY = var1;
                                            var10 = FaceNormal.method5726(ClientProt.OPPLAYER3, serverConnection.isaac);
                                            var10.packetBuffer.getShort128(var3);
                                            var10000 = var10.packetBuffer;
                                            if (KeyFocusListener.keyPressed[82]) {
                                                if (var8 >= -1366111544) {
                                                    return;
                                                }

                                                var10001 = 1;
                                            } else {
                                                var10001 = 0;
                                            }

                                            var10000.putByte(var10001);
                                            serverConnection.method5881(var10);
                                        }
                                        break label1268;
                                    }

                                    if (var2 == 47) {
                                        var17 = players[var3];
                                        if (var17 != null) {
                                            lastLeftClickX = var6;
                                            lastLeftClickY = var7;
                                            cursorState = 2;
                                            field809 = 0;
                                            destinationX = var0;
                                            destinationY = var1;
                                            var10 = FaceNormal.method5726(ClientProt.OPPLAYER4, serverConnection.isaac);
                                            var10.packetBuffer.putShortLEA(var3);
                                            var10.packetBuffer.putByteC(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                            serverConnection.method5881(var10);
                                        }
                                        break label1268;
                                    }

                                    if (var2 == 48) {
                                        var17 = players[var3];
                                        if (var17 != null) {
                                            lastLeftClickX = var6;
                                            lastLeftClickY = var7;
                                            cursorState = 2;
                                            field809 = 0;
                                            destinationX = var0;
                                            destinationY = var1;
                                            var10 = FaceNormal.method5726(ClientProt.OPPLAYER5, serverConnection.isaac);
                                            var10.packetBuffer.putByte128(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                            var10.packetBuffer.getShort128(var3);
                                            serverConnection.method5881(var10);
                                        }
                                        break label1268;
                                    }

                                    if (var2 == 49) {
                                        var17 = players[var3];
                                        if (var17 != null) {
                                            if (var8 >= -1366111544) {
                                                return;
                                            }

                                            lastLeftClickX = var6;
                                            lastLeftClickY = var7;
                                            cursorState = 2;
                                            field809 = 0;
                                            destinationX = var0;
                                            destinationY = var1;
                                            var10 = FaceNormal.method5726(ClientProt.OPPLAYER6, serverConnection.isaac);
                                            var10.packetBuffer.getShort128(var3);
                                            var10.packetBuffer.putByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                            serverConnection.method5881(var10);
                                        }
                                        break label1268;
                                    }

                                    if (var2 == 50) {
                                        var17 = players[var3];
                                        if (var17 != null) {
                                            lastLeftClickX = var6;
                                            lastLeftClickY = var7;
                                            cursorState = 2;
                                            field809 = 0;
                                            destinationX = var0;
                                            destinationY = var1;
                                            var10 = FaceNormal.method5726(ClientProt.OPPLAYER7, serverConnection.isaac);
                                            var10.packetBuffer.putByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                            var10.packetBuffer.putShortLE(var3);
                                            serverConnection.method5881(var10);
                                        }
                                        break label1268;
                                    }

                                    if (var2 == 51) {
                                        var17 = players[var3];
                                        if (var17 != null) {
                                            if (var8 >= -1366111544) {
                                                return;
                                            }

                                            lastLeftClickX = var6;
                                            lastLeftClickY = var7;
                                            cursorState = 2;
                                            field809 = 0;
                                            destinationX = var0;
                                            destinationY = var1;
                                            var10 = FaceNormal.method5726(ClientProt.OPPLAYER8, serverConnection.isaac);
                                            var10.packetBuffer.putByteC(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                            var10.packetBuffer.putShortLEA(var3);
                                            serverConnection.method5881(var10);
                                        }
                                        break label1268;
                                    }

                                    if (var2 == 57) {
                                        break label1203;
                                    }

                                    if (var2 == 58) {
                                        var16 = class192.method3785(var1, var0);
                                        if (var16 != null) {
                                            var10 = FaceNormal.method5726(ClientProt.IF_BUTTONT, serverConnection.isaac);
                                            var10.packetBuffer.putShortLE(field799);
                                            var10.packetBuffer.putIntV2(var1);
                                            var10.packetBuffer.putShortLE(field734);
                                            var10.packetBuffer.putShortLEA(var0);
                                            var10.packetBuffer.method6230(class174.field3796);
                                            var10.packetBuffer.putShortLEA(var16.linkObjType);
                                            serverConnection.method5881(var10);
                                        }
                                        break label1268;
                                    }

                                    if (var2 == 1001) {
                                        lastLeftClickX = var6;
                                        lastLeftClickY = var7;
                                        cursorState = 2;
                                        field809 = 0;
                                        destinationX = var0;
                                        destinationY = var1;
                                        var9 = FaceNormal.method5726(ClientProt.OPLOC5, serverConnection.isaac);
                                        var9.packetBuffer.putShort(var3);
                                        var9.packetBuffer.putByte128(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                        var9.packetBuffer.getShort128(var0 + class158.baseX);
                                        var9.packetBuffer.putShortLEA(class107.baseY + var1);
                                        serverConnection.method5881(var9);
                                        break label1268;
                                    }

                                    if (var2 == 1002) {
                                        lastLeftClickX = var6;
                                        lastLeftClickY = var7;
                                        cursorState = 2;
                                        field809 = 0;
                                        var9 = FaceNormal.method5726(ClientProt.OPLOC6, serverConnection.isaac);
                                        var9.packetBuffer.getShort128(var3);
                                        serverConnection.method5881(var9);
                                        break label1268;
                                    }

                                    if (var2 == 1003) {
                                        lastLeftClickX = var6;
                                        lastLeftClickY = var7;
                                        cursorState = 2;
                                        field809 = 0;
                                        var14 = npcs[var3];
                                        if (var14 != null) {
                                            NPCType var15 = var14.type;
                                            if (var15.multiNpcs != null) {
                                                var15 = var15.method5837();
                                            }

                                            if (var15 != null) {
                                                if (var8 >= -1366111544) {
                                                    return;
                                                }

                                                var11 = FaceNormal.method5726(ClientProt.OPNPC6, serverConnection.isaac);
                                                var11.packetBuffer.getShort128(var15.id);
                                                serverConnection.method5881(var11);
                                            }
                                        }
                                        break label1268;
                                    }

                                    if (var2 == 1004) {
                                        lastLeftClickX = var6;
                                        lastLeftClickY = var7;
                                        cursorState = 2;
                                        field809 = 0;
                                        var9 = FaceNormal.method5726(ClientProt.OPOBJ6, serverConnection.isaac);
                                        var9.packetBuffer.putShortLE(var3);
                                        serverConnection.method5881(var9);
                                        break label1268;
                                    }

                                    if (var2 == 1005) {
                                        label1063:
                                        {
                                            var16 = WorldMapType1.method2440(var1);
                                            if (var16 != null) {
                                                if (var8 >= -1366111544) {
                                                    return;
                                                }

                                                if (var16.objCounts[var0] >= 100000) {
                                                    ChatLine.method5672(27, "", var16.objCounts[var0] + " x " + Varcs.method4770(var3).name);
                                                    break label1063;
                                                }
                                            }

                                            var10 = FaceNormal.method5726(ClientProt.OPOBJ6, serverConnection.isaac);
                                            var10.packetBuffer.putShortLE(var3);
                                            serverConnection.method5881(var10);
                                        }

                                        mouseCrosshair = 0;
                                        class92.field2357 = WorldMapType1.method2440(var1);
                                        pressedItemIndex = var0;
                                        break label1268;
                                    }

                                    if (var2 == 1007) {
                                        break label1203;
                                    }

                                    if (var2 == 1011 || var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1012) {
                                        class219.worldMap.method1249(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                        break label1268;
                                    }
                                }
                            }

                            if (var8 >= -1366111544) {
                                return;
                            }

                            if (var8 >= -1366111544) {
                                return;
                            }
                            break label1268;
                        }

                        var16 = class192.method3785(var1, var0);
                        if (var16 != null) {
                            class324.method6406(var3, var1, var0, var16.linkObjType, var5);
                        }
                    }
                }
            }
        }

        if (itemSelectionState != 0) {
            itemSelectionState = 0;
            class208.method4144(WorldMapType1.method2440(ChatLineBuffer.field1276));
        }

        if (spellSelected) {
            Occluder.method4635();
        }

        if (class92.field2357 != null && mouseCrosshair == 0) {
            class208.method4144(class92.field2357);
        }

    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public static void onMenuOptionsChanged(int var0) {
        int var1 = oldMenuEntryCount;
        int var2 = class166.clientInstance.getMenuOptionCount();
        oldMenuEntryCount = var2;
        if (var2 == var1 + 1) {
            MenuEntryAdded var3 = new MenuEntryAdded(class166.clientInstance._protect$getMenuOptions()[var2 - 1], class166.clientInstance._protect$getMenuTargets()[var2 - 1], class166.clientInstance._protect$getMenuTypes()[var2 - 1], class166.clientInstance._protect$getMenuIdentifiers()[var2 - 1], class166.clientInstance._protect$getMenuActionParams0()[var2 - 1], class166.clientInstance._protect$getMenuActionParams1()[var2 - 1]);
            class166.clientInstance.getCallbacks().post(var3);
        }

    }

    public static void copy$raster2d7(int var0, int var1, int var2, int var3, int var4, int var5, byte[] var6, int var7, boolean var8) {
        if (var0 + var2 >= 0 && var3 + var1 >= 0) {
            if (var0 < Rasterizer2D.graphicsPixelsWidth && var1 < Rasterizer2D.graphicsPixelsHeight) {
                int var9 = 0;
                int var10 = 0;
                if (var0 < 0) {
                    var9 -= var0;
                    var2 += var0;
                }

                if (var1 < 0) {
                    var10 -= var1;
                    var3 += var1;
                }

                if (var0 + var2 > Rasterizer2D.graphicsPixelsWidth) {
                    var2 = Rasterizer2D.graphicsPixelsWidth - var0;
                }

                if (var3 + var1 > Rasterizer2D.graphicsPixelsHeight) {
                    var3 = Rasterizer2D.graphicsPixelsHeight - var1;
                }

                int var11 = var6.length / var7;
                int var12 = Rasterizer2D.graphicsPixelsWidth - var2;
                int var13 = var4 >>> 24;
                int var14 = var5 >>> 24;
                int var15;
                int var16;
                int var17;
                int var18;
                int var19;
                if (var8 && (var13 != 255 || var14 != 255)) {
                    var15 = var0 + var9 + (var10 + var1) * Rasterizer2D.graphicsPixelsWidth;

                    for (var16 = var10 + var1; var16 < var3 + var10 + var1; ++var16) {
                        for (var17 = var0 + var9; var17 < var0 + var9 + var2; ++var17) {
                            var18 = (var16 - var1) % var11;
                            var19 = (var17 - var0) % var7;
                            int var20 = var4;
                            if (var6[var19 + var18 * var7] != 0) {
                                var20 = var5;
                            }

                            int var21 = var20 >>> 24;
                            int var22 = 255 - var21;
                            int var23 = Rasterizer2D.graphicsPixels[var15];
                            int var24 = (var21 * (var20 & 65280) + var22 * (var23 & 65280) & 16711680) + ((var20 & 16711935) * var21 + (var23 & 16711935) * var22 & -16711936) >> 8;
                            Rasterizer2D.graphicsPixels[var15++] = var24;
                        }

                        var15 += var12;
                    }
                } else {
                    var15 = var0 + var9 + (var10 + var1) * Rasterizer2D.graphicsPixelsWidth;

                    for (var16 = var10 + var1; var16 < var3 + var10 + var1; ++var16) {
                        for (var17 = var0 + var9; var17 < var0 + var9 + var2; ++var17) {
                            var18 = (var16 - var1) % var11;
                            var19 = (var17 - var0) % var7;
                            if (var6[var19 + var18 * var7] != 0) {
                                Rasterizer2D.graphicsPixels[var15++] = var5;
                            } else {
                                Rasterizer2D.graphicsPixels[var15++] = var4;
                            }
                        }

                        var15 += var12;
                    }
                }

            }
        }
    }

    public static int rl$rot1(int var0, int var1, int var2, int var3) {
        return var0 * var2 + var3 * var1 >> 16;
    }

    public static int rl$rot2(int var0, int var1, int var2, int var3) {
        return var2 * var1 - var3 * var0 >> 16;
    }

    public static void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        Widget[] var9 = var0;
        int var10 = var0.length;

        for (int var11 = 0; var11 < var10; ++var11) {
            Widget var12 = var9[var11];
            RSWidget var13 = (RSWidget) var12;
            if (var13 != null && var13.getRSParentId() == var1) {
                if (var1 != -1) {
                    var13.setRenderParentId(var1);
                }

                var13.setRenderX(var6 + var13.getRelativeX());
                var13.setRenderY(var7 + var13.getRelativeY());
                RSHashTable var14 = class166.clientInstance.getComponentTable();
                WidgetNode var15 = (WidgetNode) var14.get((long) var13.getId());
                if (var15 != null) {
                    int var16 = var13.getId();
                    int var17 = var15.getId();
                    RSWidget[] var18 = class166.clientInstance.getWidgets()[var17];
                    RSWidget[] var19 = var18;
                    int var20 = var18.length;

                    for (int var21 = 0; var21 < var20; ++var21) {
                        RSWidget var22 = var19[var21];
                        if (var22.getRSParentId() == -1) {
                            var22.setRenderParentId(var16);
                        }
                    }
                }
            }
        }

    }

    public static int rl$rot3(int var0, int var1, int var2, int var3) {
        return var0 * var2 - var3 * var1 >> 16;
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public static void itemPressedDurationChanged(int var0) {
        if (class166.clientInstance.getItemPressedDuration() > 0) {
            ++itemPressedDurationBuffer;
            if (itemPressedDurationBuffer >= inventoryDragDelay) {
                class166.clientInstance.setItemPressedDuration(itemPressedDurationBuffer);
            } else {
                class166.clientInstance.setItemPressedDuration(0);
            }
        } else {
            itemPressedDurationBuffer = 0;
        }

    }

    public static int rl$rot4(int var0, int var1, int var2, int var3) {
        return var2 * var1 + var3 * var0 >> 16;
    }

    public static boolean vmExecuteOpcode(int var0) {
        if (var0 == 6599) {
            if (!$assertionsDisabled && currentScript.getInstructions()[currentScriptPC] != 6599) {
                throw new AssertionError();
            } else {
                int var1 = class166.clientInstance.getStringStackSize();
                String[] var10000 = class166.clientInstance.getStringStack();
                --var1;
                String var2 = var10000[var1];
                class166.clientInstance.setStringStackSize(var1);
                if ("debug".equals(var2)) {
                    int var3 = class166.clientInstance.getIntStackSize();
                    var10000 = class166.clientInstance.getStringStack();
                    --var1;
                    String var4 = var10000[var1];
                    StringBuffer var5 = new StringBuffer();
                    Matcher var6 = Pattern.compile("%(.)").matcher(var4);

                    while (var6.find()) {
                        var6.appendReplacement(var5, "");
                        switch (var6.group(1).charAt(0)) {
                            case 'd':
                            case 'i':
                                int[] var8 = class166.clientInstance.getIntStack();
                                --var3;
                                var5.append(var8[var3]);
                                break;
                            case 's':
                                String[] var10001 = class166.clientInstance.getStringStack();
                                --var1;
                                var5.append(var10001[var1]);
                                break;
                            default:
                                var5.append(var6.group(0)).append("=unknown");
                        }
                    }

                    var6.appendTail(var5);
                    class166.clientInstance.getLogger().debug(var5.toString());
                    class166.clientInstance.setStringStackSize(var1);
                    class166.clientInstance.setIntStackSize(var3);
                    return true;
                } else {
                    ScriptCallbackEvent var7 = new ScriptCallbackEvent();
                    var7.setScript(currentScript);
                    var7.setEventName(var2);
                    class166.clientInstance.getCallbacks().post(var7);
                    return true;
                }
            }
        } else {
            return false;
        }
    }

    public static void drawAlpha(int[] var0, int var1, int var2, int var3) {
        if (class166.clientInstance.isGpu() && var0 == class166.clientInstance.getBufferProvider().getPixels()) {
            int var4 = var3 + ((var0[var1] >>> 24) * (255 - var3) * 32897 >>> 23);
            var0[var1] = var2 & 16777215 | var4 << 24;
        } else {
            var0[var1] = var2;
        }
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public static void resizeChanged(int var0) {
        boolean var1 = class166.clientInstance.isResized();
        if (var1 != oldIsResized) {
            ResizeableChanged var2 = new ResizeableChanged();
            var2.setResized(var1);
            class166.clientInstance.getCallbacks().post(var2);
            oldIsResized = var1;
        }

    }

    public static void settingsChanged(int var0) {
        VarbitChanged var1 = new VarbitChanged();
        class166.clientInstance.getCallbacks().post(var1);
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public static void draggingWidgetChanged(int var0) {
        DraggingWidgetChanged var1 = new DraggingWidgetChanged();
        var1.setDraggingWidget(class166.clientInstance.isDraggingWidget());
        class166.clientInstance.getCallbacks().post(var1);
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public static void onCameraPitchTargetChanged(int var0) {
        int var1 = class166.clientInstance.getCameraPitchTarget();
        int var2 = var1;
        if (pitchRelaxEnabled && lastPitchTarget > 383 && var1 == 383) {
            var2 = lastPitchTarget;
            if (var2 > 512) {
                var2 = 512;
            }

            class166.clientInstance.setCameraPitchTarget(var2);
        }

        lastPitchTarget = var2;
    }

    public static void updateNpcs(boolean var0, PacketBuffer var1) {
        class166.clientInstance.getCallbacks().updateNpcs();
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public static void onUsernameChanged(int var0) {
        class166.clientInstance.getCallbacks().post(new UsernameChanged());
    }

    public static void cachedPlayersChanged(int var0) {
        RSPlayer[] var1 = class166.clientInstance.getCachedPlayers();
        if (var0 >= 0 && var0 < var1.length) {
            RSPlayer var2 = var1[var0];
            RSPlayer var3 = oldPlayers[var0];
            oldPlayers[var0] = var2;
            if (var3 != null) {
                class166.clientInstance.getCallbacks().post(new PlayerDespawned(var3));
            }

            if (var2 != null) {
                class166.clientInstance.getCallbacks().postDeferred(new PlayerSpawned(var2));
            }

        }
    }

    public static void cachedNPCsChanged(int var0) {
        RSNPC[] var1 = class166.clientInstance.getCachedNPCs();
        if (var0 >= 0 && var0 < var1.length) {
            RSNPC var2 = var1[var0];
            if (var2 != null) {
                var2.setIndex(var0);
                class166.clientInstance.getCallbacks().postDeferred(new NpcSpawned(var2));
            }

        }
    }

    public static void copy$drawGradientAlpha(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        if (var2 > 0 && var3 > 0) {
            int var8 = 0;
            int var9 = 65536 / var3;
            if (var0 < Rasterizer2D.draw_region_x) {
                var2 -= Rasterizer2D.draw_region_x - var0;
                var0 = Rasterizer2D.draw_region_x;
            }

            if (var1 < Rasterizer2D.drawingAreaTop) {
                var8 += (Rasterizer2D.drawingAreaTop - var1) * var9;
                var3 -= Rasterizer2D.drawingAreaTop - var1;
                var1 = Rasterizer2D.drawingAreaTop;
            }

            if (var0 + var2 > Rasterizer2D.drawingAreaBottom) {
                var2 = Rasterizer2D.drawingAreaBottom - var0;
            }

            if (var3 + var1 > Rasterizer2D.drawingAreaRight) {
                var3 = Rasterizer2D.drawingAreaRight - var1;
            }

            int var10 = Rasterizer2D.graphicsPixelsWidth - var2;
            int var11 = Rasterizer2D.graphicsPixelsWidth * var1 + var0;

            for (int var12 = -var3; var12 < 0; ++var12) {
                int var13 = 65536 - var8 >> 8;
                int var14 = var8 >> 8;
                int var15 = (var13 * var6 + var14 * var7 & 65280) >>> 8;
                if (var15 == 0) {
                    var11 += Rasterizer2D.graphicsPixelsWidth;
                    var8 += var9;
                } else {
                    int var16 = (var13 * (var4 & 65280) + var14 * (var5 & 65280) & 16711680) + (var13 * (var4 & 16711935) + var14 * (var5 & 16711935) & -16711936) >>> 8;
                    int var17 = 255 - var15;
                    int var18 = ((var16 & 16711935) * var15 >> 8 & 16711935) + (var15 * (var16 & 65280) >> 8 & 65280);

                    for (int var19 = -var2; var19 < 0; ++var19) {
                        int var20 = Rasterizer2D.graphicsPixels[var11];
                        if (var20 == 0) {
                            Rasterizer2D.graphicsPixels[var11++] = var18;
                        } else {
                            var20 = ((var20 & 16711935) * var17 >> 8 & 16711935) + (var17 * (var20 & 65280) >> 8 & 65280);
                            Rasterizer2D.graphicsPixels[var11++] = var18 + var20;
                        }
                    }

                    var11 += var10;
                    var8 += var9;
                }
            }

        }
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public static void onCycleCntrChanged(int var0) {
        class166.clientInstance.getCallbacks().post(new ClientTick());
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public static void onCameraPitchChanged(int var0) {
        int var1 = class166.clientInstance.getCameraPitch();
        int var2 = var1;
        if (pitchRelaxEnabled && lastPitch > 383 && var1 == 383) {
            var2 = lastPitch;
            if (var2 > 512) {
                var2 = 512;
            }

            class166.clientInstance.setCameraPitch(var2);
        }

        lastPitch = var2;
    }

    public static void copy$runWidgetOnLoadListener(int var0, int var1) {
        if (var0 == -1) {
            if (var1 != -131754801) {
                ;
            }
        } else if (!class232.method4564(var0)) {
            if (var1 != -131754801) {
                ;
            }
        } else {
            ComponentType[] var2 = class36.interfaces[var0];

            for (int var3 = 0; var3 < var2.length; ++var3) {
                ComponentType var4 = var2[var3];
                if (var4.onLoadListener != null) {
                    ScriptEvent var5 = new ScriptEvent();
                    var5.source = var4;
                    var5.params = var4.onLoadListener;
                    method3577(var5, 5000000, 1700616346);
                }
            }

        }
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public static void clanMemberManagerChanged(int var0) {
        class166.clientInstance.getCallbacks().post(new ClanChanged(class166.clientInstance.getClanMemberManager() != null));
    }

    public static void experiencedChanged(int var0) {
        ExperienceChanged var1 = new ExperienceChanged();
        Skill[] var2 = Skill.values();
        if (var0 < var2.length - 1) {
            Skill var3 = var2[var0];
            var1.setSkill(var3);
            class166.clientInstance.getCallbacks().post(var1);
        }

    }

    public static void boostedSkillLevelsChanged(int var0) {
        Skill[] var1 = Skill.values();
        if (var0 >= 0 && var0 < var1.length - 1) {
            Skill var2 = var1[var0];
            BoostedLevelChanged var3 = new BoostedLevelChanged();
            var3.setSkill(var2);
            class166.clientInstance.getCallbacks().post(var3);
        }

    }

    public static void onGrandExchangeOffersChanged(int var0) {
        if (var0 != -1) {
            RSGrandExchangeOffer var1 = class166.clientInstance.getGrandExchangeOffers()[var0];
            if (var1 != null) {
                GrandExchangeOfferChanged var2 = new GrandExchangeOfferChanged();
                var2.setOffer(var1);
                var2.setSlot(var0);
                class166.clientInstance.getCallbacks().post(var2);
            }
        }
    }

    public static void playerOptionsChanged(int var0) {
        MenuAction[] var1 = new MenuAction[]{MenuAction.PLAYER_FIRST_OPTION, MenuAction.PLAYER_SECOND_OPTION, MenuAction.PLAYER_THIRD_OPTION, MenuAction.PLAYER_FOURTH_OPTION, MenuAction.PLAYER_FIFTH_OPTION, MenuAction.PLAYER_SIXTH_OPTION, MenuAction.PLAYER_SEVENTH_OPTION, MenuAction.PLAYER_EIGTH_OPTION};
        if (var0 >= 0 && var0 < var1.length) {
            MenuAction var2 = var1[var0];
            class166.clientInstance.getPlayerMenuTypes()[var0] = var2.getId();
        }

        PlayerMenuOptionsChanged var3 = new PlayerMenuOptionsChanged();
        var3.setIndex(var0);
        class166.clientInstance.getCallbacks().post(var3);
    }

    private static void rl$$clinit() {
        pitchRelaxEnabled = false;
        lastPitch = 128;
        lastPitchTarget = 128;
    }

    private static void rl$$clinit1() {
        rl$modelViewportXs = new int[4700];
        rl$modelViewportYs = new int[4700];
    }

    private static void rl$$clinit2() {
        $assertionsDisabled = !client.class.desiredAssertionStatus();
        oldPlayers = new PlayerEntity[2048];
    }

    private static void rl$$clinit3() {
        $assertionsDisabled = !client.class.desiredAssertionStatus();
    }

    private static void rl$$clinit4() {
        spriteOverrides = new HashMap();
        widgetSpriteOverrides = new HashMap();
    }

    private static void rl$$clinit5() {
        $assertionsDisabled = !client.class.desiredAssertionStatus();
    }
}
