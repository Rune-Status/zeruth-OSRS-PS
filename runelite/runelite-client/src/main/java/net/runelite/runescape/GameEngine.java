package net.runelite.runescape;

import net.runelite.api.events.FocusChanged;
import net.runelite.api.hooks.DrawCallbacks;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGameEngine;

import java.applet.Applet;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.net.URL;

@ObfuscatedName("ah")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener, RSGameEngine {
    @ObfuscatedName("sg")
    @ObfuscatedSignature(
            signature = "Lbj;"
    )
    static ClientOptions options;
    @ObfuscatedName("v")
    @ObfuscatedGetter(
            intValue = -494277179
    )
    static int field437;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lah;"
    )
    static GameEngine shell;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -1750255325
    )
    static int shellCount;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            longValue = -985472409328970187L
    )
    static long field436;
    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "Lfa;"
    )
    protected static Timer timer;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = 1777817437
    )
    protected static int FPS;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -418602829
    )
    static int field432;
    @ObfuscatedName("c")
    static boolean field430;
    @ObfuscatedName("ah")
    @ObfuscatedGetter(
            longValue = -2832259321663324803L
    )
    static long garbageCollectorLastCollectionTime;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = -1708131921
    )
    static int field438;
    @ObfuscatedName("j")
    protected static long[] field429;
    @ObfuscatedName("gz")
    @ObfuscatedSignature(
            signature = "[Lls;"
    )
    static SpritePixels[] mapDots;
    @ObfuscatedName("ap")
    @ObfuscatedGetter(
            longValue = -3416656003449891619L
    )
    static long garbageCollectorLastCheckTimeMs;
    @ObfuscatedName("h")
    protected static long[] field444;
    @ObfuscatedName("ab")
    @ObfuscatedGetter(
            intValue = -1609477479
    )
    static int field450;
    @ObfuscatedName("ao")
    static volatile boolean focused;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lff;"
    )
    protected static Signlink taskManager;
    @ObfuscatedName("ak")
    final EventQueue eventQueue;
    @ObfuscatedName("l")
    boolean hasErrored;
    @ObfuscatedName("af")
    @ObfuscatedGetter(
            intValue = 1348931183
    )
    int field458;
    @ObfuscatedName("al")
    Clipboard clipboard;
    @ObfuscatedName("k")
    @ObfuscatedGetter(
            intValue = -998227245
    )
    int field442;
    @ObfuscatedName("aj")
    volatile boolean field449;
    @ObfuscatedName("o")
    @ObfuscatedGetter(
            intValue = 1159994123
    )
    int field443;
    @ObfuscatedName("a")
    @ObfuscatedGetter(
            intValue = 1222050607
    )
    protected int field439;
    @ObfuscatedName("z")
    @ObfuscatedGetter(
            intValue = -522084293
    )
    int field441;
    @ObfuscatedName("t")
    @ObfuscatedGetter(
            intValue = -1694487907
    )
    protected int field440;
    @ObfuscatedName("an")
    @ObfuscatedGetter(
            intValue = -177676737
    )
    int field445;
    public Thread thread;
    @ObfuscatedName("at")
    volatile boolean field452;
    @ObfuscatedName("as")
    @ObfuscatedGetter(
            longValue = 5280913469187108349L
    )
    volatile long field453;
    @ObfuscatedName("ax")
    @ObfuscatedGetter(
            intValue = 2088440245
    )
    int field446;
    @ObfuscatedName("ar")
    boolean field451;
    @ObfuscatedName("ad")
    @ObfuscatedSignature(
            signature = "Las;"
    )
    MouseWheelHandler mouseWheelHandler;
    @ObfuscatedName("az")
    Canvas canvas;
    @ObfuscatedName("ac")
    java.awt.Frame frame;

    static {
        shell = null;
        shellCount = 0;
        field436 = 0L;
        field430 = false;
        field432 = 20;
        field438 = 1;
        FPS = 0;
        field429 = new long[32];
        field444 = new long[32];
        field450 = 500;
        focused = true;
        garbageCollectorLastCollectionTime = -1L;
        garbageCollectorLastCheckTimeMs = -1L;
    }

    protected GameEngine() {
        this.hasErrored = false;
        this.field442 = 0;
        this.field441 = 0;
        this.field449 = true;
        this.field451 = false;
        this.field452 = false;
        this.onReplaceCanvasNextFrameChanged(-1);
        this.field453 = 0L;
        EventQueue var1 = null;

        try {
            var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
        } catch (Throwable var3) {
            ;
        }

        this.eventQueue = var1;
        SoundTaskDataProvider var2 = new SoundTaskDataProvider();
        ClientOptions.soundTaskDataProvider = var2;
    }

    @ObfuscatedName("ak")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1185681992"
    )
    protected final boolean method3002() {
        return this.frame != null;
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-2048042933"
    )
    protected abstract void vmethod3170();

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "487807714"
    )
    protected final void method2975() {
        WorldMapManager.method947(this.canvas);
    }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "0"
    )
    final void method2976() {
        Bounds var1 = this.method3001();
        if (var1.field3837 != this.field439 || var1.field3838 != this.field440 || this.field451) {
            this.method3060((byte) -41);
            this.field451 = false;
        }

    }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            signature = "(I)Llc;",
            garbageValue = "1778052188"
    )
    Bounds method3001() {
        Container var1 = this.method3008();
        int var2 = Math.max(var1.getWidth(), this.field443);
        int var3 = Math.max(var1.getHeight(), this.field458);
        if (this.frame != null) {
            Insets var4 = this.frame.getInsets();
            var2 -= var4.left + var4.right;
            var3 -= var4.bottom + var4.top;
        }

        return new Bounds(var2, var3);
    }

    @ObfuscatedName("ae")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "886624104"
    )
    protected abstract void vmethod3160();

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            signature = "(IIII)V",
            garbageValue = "2108469264"
    )
    protected final void method2980(int var1, int var2, int var3) {
        try {
            if (shell != null) {
                ++shellCount;
                if (shellCount >= 3) {
                    this.method2999("alreadyloaded");
                    return;
                }

                this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
                return;
            }

            shell = this;
            FriendManager.canvasWidth = var1;
            client.canvasWidthChanged(-1);
            class230.canvasHeight = var2;
            client.canvasHeightChanged(-1);
            class45.revision = var3;
            JagException.field1999 = this;
            if (taskManager == null) {
                taskManager = new Signlink();
            }

            taskManager.method4451(this, 1);
        } catch (Exception var5) {
            ProjectileAnimation.method5582((String) null, var5, 1787681899);
            this.method2999("crash");
        }

    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1411045424"
    )
    protected final void method2969() {
        class48.method779();
        WorldMapManager.method942(this.canvas);
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(B)Lft;",
            garbageValue = "0"
    )
    protected class81 method2973() {
        if (this.mouseWheelHandler == null) {
            this.mouseWheelHandler = new MouseWheelHandler();
            this.mouseWheelHandler.method4531(this.canvas);
        }

        return this.mouseWheelHandler;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/Object;I)V",
            garbageValue = "1314283977"
    )
    final void method2970(Object var1) {
        this.onPost(var1);
        if (this.eventQueue != null) {
            for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
                class182.method3129(1L);
            }

            if (var1 != null) {
                this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
            }

        }
    }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1626847641"
    )
    protected abstract void vmethod3405();

    @ObfuscatedName("o")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "0"
    )
    void method2984() {
        Container var1 = this.method3008();
        long var2 = Tile.method4297();
        long var4 = field429[field437];
        field429[field437] = var2;
        field437 = field437 + 1 & 31;
        if (0L != var4 && var2 > var4) {
            int var6 = (int) (var2 - var4);
            FPS = ((var6 >> 1) + 32000) / var6;
        }

        if (++field450 - 1 > 50) {
            field450 -= 50;
            this.field449 = true;
            this.canvas.setSize(FriendManager.canvasWidth, class230.canvasHeight);
            this.canvas.setVisible(true);
            if (var1 == this.frame) {
                Insets var7 = this.frame.getInsets();
                this.canvas.setLocation(var7.left + this.field442, var7.top + this.field441);
            } else {
                this.canvas.setLocation(this.field442, this.field441);
            }
        }

        if (this.field452) {
            this.method2979();
        }

        this.method2976();
        this.vmethod3161(this.field449);
        if (this.field449) {
            this.method3106();
        }

        this.field449 = false;
    }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-439442551"
    )
    void method3106() {
        int var1 = this.field442;
        int var2 = this.field441;
        int var3 = this.field439 - FriendManager.canvasWidth - var1;
        int var4 = this.field440 - class230.canvasHeight - var2;
        if (var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
            try {
                Container var5 = this.method3008();
                int var6 = 0;
                int var7 = 0;
                if (var5 == this.frame) {
                    Insets var8 = this.frame.getInsets();
                    var6 = var8.left;
                    var7 = var8.top;
                }

                Graphics var10 = var5.getGraphics();
                var10.setColor(Color.black);
                if (var1 > 0) {
                    var10.fillRect(var6, var7, var1, this.field440);
                }

                if (var2 > 0) {
                    var10.fillRect(var6, var7, this.field439, var2);
                }

                if (var3 > 0) {
                    var10.fillRect(var6 + this.field439 - var3, var7, var3, this.field440);
                }

                if (var4 > 0) {
                    var10.fillRect(var6, var7 + this.field440 - var4, this.field439, var4);
                }
            } catch (Exception var9) {
                ;
            }
        }

    }

    @ObfuscatedName("ai")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)V",
            garbageValue = "-958117475"
    )
    protected void method2999(String var1) {
        if (!this.hasErrored) {
            this.hasErrored = true;
            System.out.println("error_game_" + var1);

            try {
                this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
            } catch (Exception var3) {
                ;
            }

        }
    }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "82"
    )
    final void method2979() {
        class202.method4068(this.canvas);
        Canvas var1 = this.canvas;
        var1.removeMouseListener(MouseInput.mouse);
        var1.removeMouseMotionListener(MouseInput.mouse);
        var1.removeFocusListener(MouseInput.mouse);
        MouseInput.MouseHandler_currentButton = 0;
        if (this.mouseWheelHandler != null) {
            this.mouseWheelHandler.method4537(this.canvas);
        }

        this.method3056();
        WorldMapManager.method942(this.canvas);
        WorldMapManager.method947(this.canvas);
        if (this.mouseWheelHandler != null) {
            this.mouseWheelHandler.method4531(this.canvas);
        }

        this.method2992();
    }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "73"
    )
    final void method2992() {
        this.field451 = true;
    }

    public final synchronized void paint(Graphics var1) {
        if (this == shell && !field430) {
            this.field449 = true;
            if (Tile.method4297() - this.field453 > 1000L) {
                Rectangle var2 = var1.getClipBounds();
                if (var2 == null || var2.width >= FriendManager.canvasWidth && var2.height >= class230.canvasHeight) {
                    this.field452 = true;
                    this.onReplaceCanvasNextFrameChanged(-1);
                }
            }

        }
    }

    public final void destroy() {
        if (this == shell && !field430) {
            field436 = Tile.method4297();
            class182.method3129(5000L);
            this.method2987();
        }
    }

    public void onRun() {
        this.thread = Thread.currentThread();
    }

    public void onFocusGained(FocusEvent var1) {
        FocusChanged var2 = new FocusChanged();
        var2.setFocused(true);
        class166.clientInstance.getCallbacks().post(var2);
    }

    public void onPost(Object var1) {
        DrawCallbacks var2 = class166.clientInstance.getDrawCallbacks();
        if (var2 != null) {
            var2.draw();
        }

    }

    public boolean isClientThread() {
        return this.thread == Thread.currentThread();
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public final void copy$setMaxCanvasSize(int var1, int var2, short var3) {
        if (this.field445 != var1 || var2 != this.field446) {
            this.method2992();
        }

        this.field445 = var1;
        this.field446 = var2;
    }

    public final void copy$resizeCanvas(byte var1) {
        Container var2 = this.method3008();
        if (var2 != null) {
            Bounds var3 = this.method3001();
            this.field439 = Math.max(var3.field3837, this.field443);
            this.field440 = Math.max(var3.field3838, this.field458);
            if (this.field439 <= 0) {
                this.field439 = 1;
            }

            if (this.field440 <= 0) {
                this.field440 = 1;
            }

            FriendManager.canvasWidth = Math.min(this.field439, this.field445);
            client.canvasWidthChanged(-1);
            class230.canvasHeight = Math.min(this.field440, this.field446);
            client.canvasHeightChanged(-1);
            this.field442 = (this.field439 - FriendManager.canvasWidth) / 2;
            this.field441 = 0;
            this.canvas.setSize(FriendManager.canvasWidth, class230.canvasHeight);
            WorldMapManager.rasterProvider = new MainBufferProvider(FriendManager.canvasWidth, class230.canvasHeight, this.canvas);
            if (var2 == this.frame) {
                Insets var4 = this.frame.getInsets();
                this.canvas.setLocation(this.field442 + var4.left, var4.top + this.field441);
            } else {
                this.canvas.setLocation(this.field442, this.field441);
            }

            this.field449 = true;
            this.vmethod3170();
        }
    }

    public boolean isReplaceCanvasNextFrame() {
        return this.field452;
    }

    public void setReplaceCanvasNextFrame(boolean var1) {
        this.field452 = var1;
    }

    public void setResizeCanvasNextFrame(boolean var1) {
        this.field451 = var1;
    }

    public void setMaxCanvasWidth(int var1) {
        this.field445 = var1;
    }

    public void setMaxCanvasHeight(int var1) {
        this.field446 = var1;
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public void onReplaceCanvasNextFrameChanged(int var1) {
        if (class166.clientInstance != null && class166.clientInstance.isGpu() && this.isReplaceCanvasNextFrame()) {
            this.setReplaceCanvasNextFrame(false);
            this.setResizeCanvasNextFrame(true);
        }

    }

    public void run() {
        this.onRun();

        try {
            if (Signlink.javaVendor != null) {
                String var1 = Signlink.javaVendor.toLowerCase();
                if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
                    String var2 = Signlink.javaVersion;
                    if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                        this.method2999("wrongjava");
                        return;
                    }

                    if (var2.startsWith("1.6.0_")) {
                        int var3;
                        for (var3 = 6; var3 < var2.length() && class7.method129(var2.charAt(var3)); ++var3) {
                            ;
                        }

                        String var4 = var2.substring(6, var3);
                        if (class120.method2043(var4) && LoginProt.method871(var4) < 10) {
                            this.method2999("wrongjava");
                            return;
                        }
                    }

                    field438 = 5;
                }
            }

            this.setFocusCycleRoot(true);
            this.method3056();
            this.vmethod3405();
            timer = class257.method4976();

            while (0L == field436 || Tile.method4297() < field436) {
                class117.field2363 = timer.vmethod5391(field432, field438);

                for (int var5 = 0; var5 < class117.field2363; ++var5) {
                    this.method2983();
                }

                this.method2984();
                this.method2970(this.canvas);
            }
        } catch (Exception var6) {
            ProjectileAnimation.method5582((String) null, var6, 2020977669);
            this.method2999("crash");
        }

        this.method2987();
    }

    public final void start() {
        if (this == shell && !field430) {
            field436 = 0L;
        }
    }

    public final void focusGained(FocusEvent var1) {
        this.onFocusGained(var1);
        focused = true;
        this.field449 = true;
    }

    public final void focusLost(FocusEvent var1) {
        focused = false;
    }

    public final void windowActivated(WindowEvent var1) {
    }

    public final void windowClosed(WindowEvent var1) {
    }

    public final void windowClosing(WindowEvent var1) {
        this.destroy();
    }

    public final void windowDeiconified(WindowEvent var1) {
    }

    public final void windowIconified(WindowEvent var1) {
    }

    public final void windowOpened(WindowEvent var1) {
    }

    public abstract void init();

    public final void update(Graphics var1) {
        this.paint(var1);
    }

    public final void stop() {
        if (this == shell && !field430) {
            field436 = Tile.method4297() + 4000L;
        }
    }

    public final void windowDeactivated(WindowEvent var1) {
    }

    public Thread getClientThread() {
        return this.thread;
    }

    public boolean isResizeCanvasNextFrame() {
        return this.field451;
    }

    public void post(Object var1) {
        this.method2970(var1);
    }

    public void resizeCanvas() {
        this.method3060((byte) -41);
    }

    @ObfuscatedName("i")
    protected final void method3075(int var1, int var2, short var3) {
        if (!class166.clientInstance.isStretchedEnabled() || !class166.clientInstance.isResized()) {
            this.copy$setMaxCanvasSize(var1, var2, var3);
        }
    }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-287340265"
    )
    protected abstract void vmethod3162();

    @ObfuscatedName("y")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-774884881"
    )
    protected final boolean method2982() {
        String var1 = this.getDocumentBase().getHost().toLowerCase();
        if (!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
            if (!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
                if (var1.endsWith("127.0.0.1")) {
                    return true;
                } else {
                    while (var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
                        var1 = var1.substring(0, var1.length() - 1);
                    }

                    if (var1.endsWith("192.168.1.")) {
                        return true;
                    } else {
                        this.method2999("invalidhost");
                        return false;
                    }
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    @ObfuscatedName("am")
    @ObfuscatedSignature(
            signature = "(S)V",
            garbageValue = "-475"
    )
    protected abstract void vmethod3387();

    @ObfuscatedName("as")
    @ObfuscatedSignature(
            signature = "(ILjava/lang/String;ZI)V",
            garbageValue = "6388472"
    )
    protected final void method2997(int var1, String var2, boolean var3) {
        try {
            Graphics var4 = this.canvas.getGraphics();
            if (class277.field1963 == null) {
                class277.field1963 = new java.awt.Font("Helvetica", 1, 13);
                UrlRequester.field1917 = this.canvas.getFontMetrics(class277.field1963);
            }

            if (var3) {
                var4.setColor(Color.black);
                var4.fillRect(0, 0, FriendManager.canvasWidth, class230.canvasHeight);
            }

            Color var5 = new Color(140, 17, 17);

            try {
                if (GameObject.field1892 == null) {
                    GameObject.field1892 = this.canvas.createImage(304, 34);
                }

                Graphics var6 = GameObject.field1892.getGraphics();
                var6.setColor(var5);
                var6.drawRect(0, 0, 303, 33);
                var6.fillRect(2, 2, var1 * 3, 30);
                var6.setColor(Color.black);
                var6.drawRect(1, 1, 301, 31);
                var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
                var6.setFont(class277.field1963);
                var6.setColor(Color.white);
                var6.drawString(var2, (304 - UrlRequester.field1917.stringWidth(var2)) / 2, 22);
                var4.drawImage(GameObject.field1892, FriendManager.canvasWidth / 2 - 152, class230.canvasHeight / 2 - 18, (ImageObserver) null);
            } catch (Exception var9) {
                int var7 = FriendManager.canvasWidth / 2 - 152;
                int var8 = class230.canvasHeight / 2 - 18;
                var4.setColor(var5);
                var4.drawRect(var7, var8, 303, 33);
                var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
                var4.setColor(Color.black);
                var4.drawRect(var7 + 1, var8 + 1, 301, 31);
                var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
                var4.setFont(class277.field1963);
                var4.setColor(Color.white);
                var4.drawString(var2, var7 + (304 - UrlRequester.field1917.stringWidth(var2)) / 2, var8 + 22);
            }
        } catch (Exception var10) {
            this.canvas.repaint();
        }

    }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "65591887"
    )
    final synchronized void method2987() {
        if (!field430) {
            field430 = true;

            try {
                this.canvas.removeFocusListener(this);
            } catch (Exception var5) {
                ;
            }

            try {
                this.vmethod3162();
            } catch (Exception var4) {
                ;
            }

            if (this.frame != null) {
                try {
                    System.exit(0);
                } catch (Throwable var3) {
                    ;
                }
            }

            if (taskManager != null) {
                try {
                    taskManager.method4441();
                } catch (Exception var2) {
                    ;
                }
            }

            this.vmethod3387();
        }
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "641500723"
    )
    protected void method3043() {
        this.clipboard = this.getToolkit().getSystemClipboard();
    }

    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            signature = "(ZI)V",
            garbageValue = "874565984"
    )
    protected abstract void vmethod3161(boolean var1);

    @ObfuscatedName("ad")
    @ObfuscatedSignature(
            signature = "(I)Ljava/awt/Container;",
            garbageValue = "-1208313330"
    )
    Container method3008() {
        return (Container) (this.frame != null ? this.frame : this);
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)V",
            garbageValue = "-1782360205"
    )
    protected void method2988(String var1) {
        this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner) null);
    }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "787938515"
    )
    protected final void method2998() {
        GameObject.field1892 = null;
        class277.field1963 = null;
        UrlRequester.field1917 = null;
    }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-363224551"
    )
    final synchronized void method3056() {
        Container var1 = this.method3008();
        if (this.canvas != null) {
            this.canvas.removeFocusListener(this);
            var1.remove(this.canvas);
        }

        FriendManager.canvasWidth = Math.max(var1.getWidth(), this.field443);
        client.canvasWidthChanged(-1);
        class230.canvasHeight = Math.max(var1.getHeight(), this.field458);
        client.canvasHeightChanged(-1);
        Insets var2;
        if (this.frame != null) {
            var2 = this.frame.getInsets();
            FriendManager.canvasWidth -= var2.right + var2.left;
            client.canvasWidthChanged(-1);
            class230.canvasHeight -= var2.bottom + var2.top;
            client.canvasHeightChanged(-1);
        }

        this.canvas = new GameCanvas(this);
        var1.setBackground(Color.BLACK);
        var1.setLayout((LayoutManager) null);
        var1.add(this.canvas);
        this.canvas.setSize(FriendManager.canvasWidth, class230.canvasHeight);
        this.canvas.setVisible(true);
        this.canvas.setBackground(Color.BLACK);
        if (var1 == this.frame) {
            var2 = this.frame.getInsets();
            this.canvas.setLocation(var2.left + this.field442, this.field441 + var2.top);
        } else {
            this.canvas.setLocation(this.field442, this.field441);
        }

        this.canvas.addFocusListener(this);
        this.canvas.requestFocus();
        this.field449 = true;
        if (WorldMapManager.rasterProvider != null && FriendManager.canvasWidth == WorldMapManager.rasterProvider.width && class230.canvasHeight == WorldMapManager.rasterProvider.height) {
            ((MainBufferProvider) WorldMapManager.rasterProvider).method2948(this.canvas);
            WorldMapManager.rasterProvider.vmethod2955(0, 0);
        } else {
            WorldMapManager.rasterProvider = new MainBufferProvider(FriendManager.canvasWidth, class230.canvasHeight, this.canvas);
        }

        this.field452 = false;
        this.onReplaceCanvasNextFrameChanged(-1);
        this.field453 = Tile.method4297();
    }

    @ObfuscatedName("h")
    final void method3060(byte var1) {
        if (class166.clientInstance.isStretchedEnabled()) {
            class166.clientInstance.invalidateStretching(false);
            if (class166.clientInstance.isResized()) {
                Dimension var2 = class166.clientInstance.getRealDimensions();
                this.setMaxCanvasWidth(var2.width);
                this.setMaxCanvasHeight(var2.height);
            }
        }

        this.copy$resizeCanvas(var1);
    }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "19"
    )
    void method2983() {
        long var1 = Tile.method4297();
        long var3 = field444[BufferProvider.field3863];
        field444[BufferProvider.field3863] = var1;
        BufferProvider.field3863 = BufferProvider.field3863 + 1 & 31;
        if (0L != var3 && var1 > var3) {
            ;
        }

        synchronized (this) {
            class32.field2111 = focused;
        }

        this.vmethod3160();
    }
}
