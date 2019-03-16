package net.runelite.runescape;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;

@ObfuscatedName("bm")
public class class48 {
    public static int[] field845;
    public static String[] field835;
    @ObfuscatedName("f")
    static boolean field1078;
    @ObfuscatedName("l")
    static int[][] scriptArrays;
    @ObfuscatedName("v")
    static final String[] field1071;
    @ObfuscatedName("x")
    @Export("LOCAL_CALENDAR")
    static Calendar LOCAL_CALENDAR;
    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "[Laq;"
    )
    static ScriptState[] scriptStack;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -615501969
    )
    static int scriptStackCount;
    @ObfuscatedName("b")
    static int[] intStack;
    @ObfuscatedName("a")
    static boolean field1079;
    @ObfuscatedName("n")
    static String[] scriptStringStack;
    @ObfuscatedName("c")
    static int[] scriptArrayLengths;
    @ObfuscatedName("t")
    @ObfuscatedGetter(
            intValue = -1748251295
    )
    static int field1075;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 303129437
    )
    static int scriptStringStackSize;
    @ObfuscatedName("y")
    static final double field1081;
    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "Lhn;"
    )
    static ComponentType field1080;

    static {
        scriptArrayLengths = new int[5];
        scriptArrays = new int[5][5000];
        intStack = new int[1000];
        scriptStringStack = new String[1000];
        scriptStackCount = 0;
        scriptStack = new ScriptState[50];
        LOCAL_CALENDAR = Calendar.getInstance();
        field1071 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        field1078 = false;
        field1079 = false;
        field1075 = 0;
        field1081 = Math.log(2.0D);
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lih;IIIBZI)V",
            garbageValue = "87474936"
    )
    static void method777(Js5 var0, int var1, int var2, int var3, byte var4, boolean var5) {
        long var6 = (long) ((var1 << 16) + var2);
        FileRequest var8 = (FileRequest) class258.NetCache_pendingPriorityWrites.method380(var6);
        if (var8 == null) {
            var8 = (FileRequest) class258.NetCache_pendingPriorityResponses.method380(var6);
            if (var8 == null) {
                var8 = (FileRequest) class258.NetCache_pendingWrites.method380(var6);
                if (var8 != null) {
                    if (var5) {
                        var8.method419();
                        class258.NetCache_pendingPriorityWrites.method382(var8, var6);
                        --class258.NetCache_pendingWritesCount;
                        ++class258.NetCache_pendingPriorityWritesCount;
                    }

                } else {
                    if (!var5) {
                        var8 = (FileRequest) class258.NetCache_pendingResponses.method380(var6);
                        if (var8 != null) {
                            return;
                        }
                    }

                    var8 = new FileRequest();
                    var8.index = var0;
                    var8.crc = var3;
                    var8.padding = var4;
                    if (var5) {
                        class258.NetCache_pendingPriorityWrites.method382(var8, var6);
                        ++class258.NetCache_pendingPriorityWritesCount;
                    } else {
                        class258.NetCache_pendingWritesQueue.method2509(var8);
                        class258.NetCache_pendingWrites.method382(var8, var6);
                        ++class258.NetCache_pendingWritesCount;
                    }

                }
            }
        }
    }

    @ObfuscatedName("gs")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-904353438"
    )
    static void method778() {
        TcpConnectionMessage var0 = FaceNormal.method5726(ClientProt.WINDOW_STATUS, client.serverConnection.isaac);
        var0.packetBuffer.putByte(WorldMapRectangle.method127());
        var0.packetBuffer.putShort(FriendManager.canvasWidth);
        var0.packetBuffer.putShort(class230.canvasHeight);
        client.serverConnection.method5881(var0);
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1145405442"
    )
    static void method779() {
        if (Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
            KeyFocusListener.KeyHandler_keyCodes[186] = 57;
            KeyFocusListener.KeyHandler_keyCodes[187] = 27;
            KeyFocusListener.KeyHandler_keyCodes[188] = 71;
            KeyFocusListener.KeyHandler_keyCodes[189] = 26;
            KeyFocusListener.KeyHandler_keyCodes[190] = 72;
            KeyFocusListener.KeyHandler_keyCodes[191] = 73;
            KeyFocusListener.KeyHandler_keyCodes[192] = 58;
            KeyFocusListener.KeyHandler_keyCodes[219] = 42;
            KeyFocusListener.KeyHandler_keyCodes[220] = 74;
            KeyFocusListener.KeyHandler_keyCodes[221] = 43;
            KeyFocusListener.KeyHandler_keyCodes[222] = 59;
            KeyFocusListener.KeyHandler_keyCodes[223] = 28;
        } else {
            KeyFocusListener.KeyHandler_keyCodes[44] = 71;
            KeyFocusListener.KeyHandler_keyCodes[45] = 26;
            KeyFocusListener.KeyHandler_keyCodes[46] = 72;
            KeyFocusListener.KeyHandler_keyCodes[47] = 73;
            KeyFocusListener.KeyHandler_keyCodes[59] = 57;
            KeyFocusListener.KeyHandler_keyCodes[61] = 27;
            KeyFocusListener.KeyHandler_keyCodes[91] = 42;
            KeyFocusListener.KeyHandler_keyCodes[92] = 74;
            KeyFocusListener.KeyHandler_keyCodes[93] = 43;
            KeyFocusListener.KeyHandler_keyCodes[192] = 28;
            KeyFocusListener.KeyHandler_keyCodes[222] = 58;
            KeyFocusListener.KeyHandler_keyCodes[520] = 59;
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "([BI)Lls;",
            garbageValue = "272914243"
    )
    public static final SpritePixels method776(byte[] var0) {
        BufferedImage var1 = null;

        try {
            var1 = ImageIO.read(new ByteArrayInputStream(var0));
            int var2 = var1.getWidth();
            int var3 = var1.getHeight();
            int[] var4 = new int[var3 * var2];
            PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
            var5.grabPixels();
            return new SpritePixels(var4, var2, var3);
        } catch (IOException var7) {
            ;
        } catch (InterruptedException var8) {
            ;
        }

        return new SpritePixels(0, 0);
    }
}
