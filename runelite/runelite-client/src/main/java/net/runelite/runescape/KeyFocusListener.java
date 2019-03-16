package net.runelite.runescape;

import net.runelite.api.events.FocusChanged;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSKeyFocusListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@ObfuscatedName("aa")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener, RSKeyFocusListener {
    @ObfuscatedName("ck")
    static char[] field384;
    @ObfuscatedName("cq")
    @ObfuscatedGetter(
            intValue = 873003153
    )
    public static int field389;
    @ObfuscatedName("cp")
    static int[] field369;
    @ObfuscatedName("cx")
    public static boolean[] keyPressed;
    @ObfuscatedName("b")
    public static short[] colorsToFind;
    @ObfuscatedName("cj")
    @ObfuscatedGetter(
            intValue = 1994763465
    )
    public static int field390;
    @ObfuscatedName("cn")
    @ObfuscatedGetter(
            intValue = 320037265
    )
    public static int field374;
    @ObfuscatedName("ct")
    @ObfuscatedGetter(
            intValue = 11169981
    )
    public static int field387;
    @ObfuscatedName("ci")
    static int[] KeyHandler_keyCodes;
    @ObfuscatedName("ch")
    public static int[] field377;
    @ObfuscatedName("co")
    @ObfuscatedGetter(
            intValue = 883242299
    )
    public static int field383;
    @ObfuscatedName("cu")
    @ObfuscatedGetter(
            intValue = -2016536901
    )
    public static volatile int keyboardIdleTicks;
    @ObfuscatedName("cf")
    public static int[] field381;
    @ObfuscatedName("cs")
    @ObfuscatedGetter(
            intValue = 1445485061
    )
    public static int field388;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Laa;"
    )
    public static KeyFocusListener keyboard;

    static {
        keyboard = new KeyFocusListener();
        keyPressed = new boolean[112];
        field381 = new int[128];
        field374 = 0;
        field383 = 0;
        field384 = new char[128];
        field369 = new int[128];
        field377 = new int[128];
        field387 = 0;
        field388 = 0;
        field389 = 0;
        field390 = 0;
        keyboardIdleTicks = 0;
        KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    public void onFocusLost(FocusEvent var1) {
        FocusChanged var2 = new FocusChanged();
        var2.setFocused(false);
        class166.clientInstance.getCallbacks().post(var2);
    }

    public final synchronized void copy$keyPressed(KeyEvent var1) {
        if (keyboard != null) {
            int var2 = var1.getKeyCode();
            if (var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
                var2 = KeyHandler_keyCodes[var2];
                if ((var2 & 128) != 0) {
                    var2 = -1;
                }
            } else {
                var2 = -1;
            }

            if (field383 >= 0 && var2 >= 0) {
                field381[field383] = var2;
                field383 = field383 + 1 & 127;
                if (field383 == field374) {
                    field383 = -1;
                }
            }

            int var3;
            if (var2 >= 0) {
                var3 = field389 + 1 & 127;
                if (var3 != field388) {
                    field369[field389] = var2;
                    field384[field389] = 0;
                    field389 = var3;
                }
            }

            var3 = var1.getModifiers();
            if ((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
                var1.consume();
            }
        }

    }

    public final synchronized void copy$keyReleased(KeyEvent var1) {
        if (keyboard != null) {
            int var2 = var1.getKeyCode();
            if (var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
                var2 = KeyHandler_keyCodes[var2] & -129;
            } else {
                var2 = -1;
            }

            if (field383 >= 0 && var2 >= 0) {
                field381[field383] = ~var2;
                field383 = field383 + 1 & 127;
                if (field374 == field383) {
                    field383 = -1;
                }
            }
        }

        var1.consume();
    }

    public final void copy$keyTyped(KeyEvent var1) {
        if (keyboard != null) {
            char var2 = var1.getKeyChar();
            if (var2 != 0 && var2 != '\uffff') {
                boolean var3;
                if (var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
                    var3 = true;
                } else {
                    label60:
                    {
                        if (var2 != 0) {
                            char[] var7 = class50.cp1252AsciiExtension;

                            for (int var5 = 0; var5 < var7.length; ++var5) {
                                char var6 = var7[var5];
                                if (var6 == var2) {
                                    var3 = true;
                                    break label60;
                                }
                            }
                        }

                        var3 = false;
                    }
                }

                if (var3) {
                    int var4 = field389 + 1 & 127;
                    if (var4 != field388) {
                        field369[field389] = -1;
                        field384[field389] = var2;
                        field389 = var4;
                    }
                }
            }
        }

        var1.consume();
    }

    public final synchronized void keyPressed(KeyEvent var1) {
        class166.clientInstance.getCallbacks().keyPressed(var1);
        if (!var1.isConsumed()) {
            this.copy$keyPressed(var1);
        }

    }

    public final synchronized void keyReleased(KeyEvent var1) {
        class166.clientInstance.getCallbacks().keyReleased(var1);
        if (!var1.isConsumed()) {
            this.copy$keyReleased(var1);
        }

    }

    public final void keyTyped(KeyEvent var1) {
        class166.clientInstance.getCallbacks().keyTyped(var1);
        if (!var1.isConsumed()) {
            this.copy$keyTyped(var1);
        }

    }

    public final synchronized void focusLost(FocusEvent var1) {
        this.onFocusLost(var1);
        if (keyboard != null) {
            field383 = -1;
        }

    }

    public final void focusGained(FocusEvent var1) {
    }

    @ObfuscatedName("fj")
    @ObfuscatedSignature(
            signature = "(Lbc;S)V",
            garbageValue = "-5111"
    )
    static final void method5352(PathingEntity var0) {
        if (var0.direction != 0) {
            if (var0.interacting != -1) {
                Object var1 = null;
                if (var0.interacting < 32768) {
                    var1 = client.npcs[var0.interacting];
                } else if (var0.interacting >= 32768) {
                    var1 = client.players[var0.interacting - 32768];
                }

                if (var1 != null) {
                    int var2 = var0.x - ((PathingEntity) var1).x;
                    int var3 = var0.y - ((PathingEntity) var1).y;
                    if (var2 != 0 || var3 != 0) {
                        var0.orientation = (int) (Math.atan2((double) var2, (double) var3) * 325.949D) & 2047;
                    }
                } else if (var0.field966) {
                    var0.interacting = -1;
                    var0.interactingChanged(-1);
                    var0.field966 = false;
                }
            }

            if (var0.facingCoord != -1 && (var0.queueSize == 0 || var0.field955 > 0)) {
                var0.orientation = var0.facingCoord;
                var0.facingCoord = -1;
            }

            int var4 = var0.orientation - var0.angle & 2047;
            if (var4 == 0 && var0.field966) {
                var0.interacting = -1;
                var0.interactingChanged(-1);
                var0.field966 = false;
            }

            if (var4 != 0) {
                ++var0.field991;
                boolean var6;
                if (var4 > 1024) {
                    var0.angle -= var0.direction;
                    var6 = true;
                    if (var4 < var0.direction || var4 > 2048 - var0.direction) {
                        var0.angle = var0.orientation;
                        var6 = false;
                    }

                    if (var0.poseAnimation == var0.idlePoseAnimation && (var0.field991 > 25 || var6)) {
                        if (var0.field945 != -1) {
                            var0.poseAnimation = var0.field945;
                        } else {
                            var0.poseAnimation = var0.walkAnim;
                        }
                    }
                } else {
                    var0.angle += var0.direction;
                    var6 = true;
                    if (var4 < var0.direction || var4 > 2048 - var0.direction) {
                        var0.angle = var0.orientation;
                        var6 = false;
                    }

                    if (var0.poseAnimation == var0.idlePoseAnimation && (var0.field991 > 25 || var6)) {
                        if (var0.field957 != -1) {
                            var0.poseAnimation = var0.field957;
                        } else {
                            var0.poseAnimation = var0.walkAnim;
                        }
                    }
                }

                var0.angle &= 2047;
            } else {
                var0.field991 = 0;
            }

        }
    }
}
