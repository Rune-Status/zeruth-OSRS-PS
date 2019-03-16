package net.runelite.runescape;

import net.runelite.mapping.*;
import net.runelite.rs.api.RSGameCanvas;

import java.awt.*;
import java.awt.event.FocusListener;

@ObfuscatedName("al")
@Implements("GameCanvas")
public final class GameCanvas extends Canvas implements RSGameCanvas {
    @ObfuscatedName("dg")
    @ObfuscatedSignature(
            signature = "Lih;"
    )
    @Export("bases")
    static Js5 bases;
    @Export("shouldNotHaveFocus")
    public static boolean shouldNotHaveFocus;
    @ObfuscatedName("bf")
    @ObfuscatedGetter(
            intValue = -850449209
    )
    static int field405;
    @ObfuscatedName("g")
    Component component;

    GameCanvas(Component var1) {
        this.component = var1;
    }

    @Export("update")
    public final void update(Graphics var1) {
        this.component.update(var1);
    }

    @Export("paint")
    public final void paint(Graphics var1) {
        this.component.paint(var1);
    }

    public void removeFocusListener(FocusListener var1) {
        super.removeFocusListener(var1);
        shouldNotHaveFocus = !this.hasFocus();
    }

    public void requestFocus() {
        if (!shouldNotHaveFocus) {
            this.requestFocusInWindow();
        }

    }

    public void setSize(int var1, int var2) {
        if (class166.clientInstance.isStretchedEnabled()) {
            super.setSize(class166.clientInstance.getStretchedDimensions().width, class166.clientInstance.getStretchedDimensions().height);
        } else {
            super.setSize(var1, var2);
        }

    }

    public void setLocation(int var1, int var2) {
        if (class166.clientInstance.isStretchedEnabled()) {
            super.setLocation((this.getParent().getWidth() - class166.clientInstance.getStretchedDimensions().width) / 2, 0);
        } else {
            super.setLocation(var1, var2);
        }

    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "-2058004406"
    )
    static final int method895(int var0, int var1) {
        if (var0 == -2) {
            return 12345678;
        } else if (var0 == -1) {
            if (var1 < 2) {
                var1 = 2;
            } else if (var1 > 126) {
                var1 = 126;
            }

            return var1;
        } else {
            var1 = (var0 & 127) * var1 / 128;
            if (var1 < 2) {
                var1 = 2;
            } else if (var1 > 126) {
                var1 = 126;
            }

            return (var0 & 65408) + var1;
        }
    }

    @ObfuscatedName("o")
    @ObfuscatedSignature(
            signature = "(ILcx;ZB)I",
            garbageValue = "52"
    )
    static int method896(int var0, class106 var1, boolean var2) {
        ComponentType var3 = WorldMapType1.method2440(class48.intStack[--class228.intStackSize]);
        if (var0 == 2800) {
            class48.intStack[++class228.intStackSize - 1] = class192.method3781(class101.method1704(var3));
            return 1;
        } else if (var0 != 2801) {
            if (var0 == 2802) {
                if (var3.opBase == null) {
                    class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                } else {
                    class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3.opBase;
                }

                return 1;
            } else {
                return 2;
            }
        } else {
            int var4 = class48.intStack[--class228.intStackSize];
            --var4;
            if (var3.ops != null && var4 < var3.ops.length && var3.ops[var4] != null) {
                class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3.ops[var4];
            } else {
                class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
            }

            return 1;
        }
    }

    @ObfuscatedName("kl")
    @ObfuscatedSignature(
            signature = "(Lhn;I)Z",
            garbageValue = "-217422136"
    )
    static boolean method894(ComponentType var0) {
        return var0.isHidden;
    }

    @ObfuscatedName("jg")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1952311603"
    )
    static final void method893() {
        TcpConnectionMessage var0 = FaceNormal.method5726(ClientProt.CLOSE_MODAL, client.serverConnection.isaac);
        client.serverConnection.method5881(var0);

        for (SubInterface var1 = (SubInterface) client.subInterfaces.method391(); var1 != null; var1 = (SubInterface) client.subInterfaces.method385()) {
            if (var1.mode == 0 || var1.mode == 3) {
                class116.method2007(var1, true);
            }
        }

        if (client.field880 != null) {
            class208.method4144(client.field880);
            client.field880 = null;
        }

    }
}
