package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMouseInput;

import java.awt.event.*;

@ObfuscatedName("ap")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener, RSMouseInput {
    @ObfuscatedName("f")
    @ObfuscatedGetter(
            intValue = -645036383
    )
    public static int mouseLastButton;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -599868155
    )
    public static volatile int MouseHandler_currentButton;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = 646061397
    )
    public static volatile int MouseHandler_lastPressedY;
    @ObfuscatedName("k")
    @ObfuscatedGetter(
            longValue = 9106305032909973425L
    )
    public static long mouseLastPressedTimeMillis;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 501178465
    )
    public static volatile int mouseY;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lap;"
    )
    public static MouseInput mouse;
    @ObfuscatedName("x")
    @ObfuscatedGetter(
            intValue = -892765135
    )
    public static volatile int MouseHandler_lastPressedX;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = -1366179445
    )
    public static int mouseLastY;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -976261951
    )
    public static int mouseLastX;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 1340496759
    )
    public static volatile int mouseX;
    @ObfuscatedName("a")
    @ObfuscatedGetter(
            intValue = 1260672621
    )
    public static int mouseLastPressedX;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            longValue = 122702987461086671L
    )
    public static volatile long field468;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 2106390029
    )
    public static volatile int mouseIdleTicks;
    @ObfuscatedName("t")
    @ObfuscatedGetter(
            intValue = 638817605
    )
    public static int mouseLastPressedY;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = -1024686381
    )
    public static int mouseCurrentButton;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            longValue = -8384975640775436831L
    )
    public static long field472;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = -406088729
    )
    public static volatile int MouseHandler_lastButton;
    @ObfuscatedName("h")
    @ObfuscatedGetter(
            longValue = 1173524072008386631L
    )
    public static volatile long MouseHandler_lastPressedTimeMillis;
    public int isInEvent;

    static {
        mouse = new MouseInput();
        mouseIdleTicks = 0;
        MouseHandler_currentButton = 0;
        mouseX = -1;
        mouseY = -1;
        field468 = -1L;
        mouseCurrentButton = 0;
        mouseLastX = 0;
        mouseLastY = 0;
        field472 = 0L;
        MouseHandler_lastButton = 0;
        MouseHandler_lastPressedX = 0;
        MouseHandler_lastPressedY = 0;
        MouseHandler_lastPressedTimeMillis = 0L;
        mouseLastButton = 0;
        mouseLastPressedX = 0;
        mouseLastPressedY = 0;
        mouseLastPressedTimeMillis = 0L;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Ljava/awt/event/MouseEvent;I)I",
            garbageValue = "-1173032679"
    )
    final int method5751(MouseEvent var1) {
        int var2 = var1.getButton();
        return !var1.isAltDown() && var2 != 2 ? (!var1.isMetaDown() && var2 != 3 ? 1 : 2) : 4;
    }

    public final synchronized void mouseMoved(MouseEvent var1) {
        if (this.isInEvent == 0) {
            var1 = class166.clientInstance.getCallbacks().mouseMoved(var1);
        }

        if (!var1.isConsumed()) {
            ++this.isInEvent;

            try {
                this.copy$mouseMoved(var1);
            } finally {
                --this.isInEvent;
            }
        }

    }

    public final void copy$mouseClicked(MouseEvent var1) {
        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final synchronized void copy$mousePressed(MouseEvent var1) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            MouseHandler_lastPressedX = var1.getX();
            MouseHandler_lastPressedY = var1.getY();
            MouseHandler_lastPressedTimeMillis = Tile.method4297();
            MouseHandler_lastButton = this.method5751(var1);
            if (MouseHandler_lastButton != 0) {
                MouseHandler_currentButton = MouseHandler_lastButton;
            }
        }

        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final synchronized void copy$mouseReleased(MouseEvent var1) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            MouseHandler_currentButton = 0;
        }

        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final synchronized void copy$mouseEntered(MouseEvent var1) {
        this.mouseMoved(var1);
    }

    public final synchronized void copy$mouseExited(MouseEvent var1) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            mouseX = -1;
            mouseY = -1;
            field468 = var1.getWhen();
        }

    }

    public final synchronized void copy$mouseDragged(MouseEvent var1) {
        this.mouseMoved(var1);
    }

    public final synchronized void copy$mouseMoved(MouseEvent var1) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            mouseX = var1.getX();
            mouseY = var1.getY();
            field468 = var1.getWhen();
        }

    }

    public final synchronized void mousePressed(MouseEvent var1) {
        if (this.isInEvent == 0) {
            var1 = class166.clientInstance.getCallbacks().mousePressed(var1);
        }

        if (!var1.isConsumed()) {
            ++this.isInEvent;

            try {
                this.copy$mousePressed(var1);
            } finally {
                --this.isInEvent;
            }
        }

    }

    public final synchronized void mouseReleased(MouseEvent var1) {
        if (this.isInEvent == 0) {
            var1 = class166.clientInstance.getCallbacks().mouseReleased(var1);
        }

        if (!var1.isConsumed()) {
            ++this.isInEvent;

            try {
                this.copy$mouseReleased(var1);
            } finally {
                --this.isInEvent;
            }
        }

    }

    public final void mouseClicked(MouseEvent var1) {
        var1 = class166.clientInstance.getCallbacks().mouseClicked(var1);
        if (!var1.isConsumed()) {
            this.copy$mouseClicked(var1);
        }

    }

    public final synchronized void mouseEntered(MouseEvent var1) {
        if (this.isInEvent == 0) {
            var1 = class166.clientInstance.getCallbacks().mouseEntered(var1);
        }

        if (!var1.isConsumed()) {
            ++this.isInEvent;

            try {
                this.copy$mouseEntered(var1);
            } finally {
                --this.isInEvent;
            }
        }

    }

    public final synchronized void mouseExited(MouseEvent var1) {
        if (this.isInEvent == 0) {
            var1 = class166.clientInstance.getCallbacks().mouseExited(var1);
        }

        if (!var1.isConsumed()) {
            ++this.isInEvent;

            try {
                this.copy$mouseExited(var1);
            } finally {
                --this.isInEvent;
            }
        }

    }

    public final synchronized void mouseDragged(MouseEvent var1) {
        if (this.isInEvent == 0) {
            var1 = class166.clientInstance.getCallbacks().mouseDragged(var1);
        }

        if (!var1.isConsumed()) {
            ++this.isInEvent;

            try {
                this.copy$mouseDragged(var1);
            } finally {
                --this.isInEvent;
            }
        }

    }

    public final synchronized void focusLost(FocusEvent var1) {
        if (mouse != null) {
            MouseHandler_currentButton = 0;
        }

    }

    public final void focusGained(FocusEvent var1) {
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "24"
    )
    public static void method5785() {
        while (true) {
            Deque var1 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            FileSystem var0;
            synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
                var0 = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.method4354();
            }

            if (var0 == null) {
                return;
            }

            var0.data.method2644(var0.index, (int) var0.hash, var0.field3212, false);
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(III)Lbw;",
            garbageValue = "-489490626"
    )
    static ChatLine method5755(int var0, int var1) {
        ChatLineBuffer var2 = (ChatLineBuffer) class202.chatLineMap.get(Integer.valueOf(var0));
        return var2.method1935(var1);
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "52"
    )
    public static void method5787() {
        Overlay.overlays.method952();
    }

    @ObfuscatedName("ks")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;ZB)V",
            garbageValue = "-114"
    )
    static void method5783(String var0, boolean var1) {
        var0 = var0.toLowerCase();
        short[] var2 = new short[16];
        int var3 = 0;

        for (int var4 = 0; var4 < class302.field3840; ++var4) {
            ObjType var5 = Varcs.method4770(var4);
            if ((!var1 || var5.stockmarket) && var5.certTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
                if (var3 >= 250) {
                    MilliTimer.field1983 = -1;
                    class124.field325 = null;
                    return;
                }

                if (var3 >= var2.length) {
                    short[] var6 = new short[var2.length * 2];

                    for (int var7 = 0; var7 < var3; ++var7) {
                        var6[var7] = var2[var7];
                    }

                    var2 = var6;
                }

                var2[var3++] = (short) var4;
            }
        }

        class124.field325 = var2;
        class192.field69 = 0;
        MilliTimer.field1983 = var3;
        String[] var8 = new String[MilliTimer.field1983];

        for (int var9 = 0; var9 < MilliTimer.field1983; ++var9) {
            var8[var9] = Varcs.method4770(var2[var9]).name;
        }

        short[] var10 = class124.field325;
        GZipDecompressor.method5444(var8, var10, 0, var8.length - 1);
    }
}
