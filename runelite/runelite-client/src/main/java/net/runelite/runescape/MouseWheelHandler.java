package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMouseWheelHandler;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

@ObfuscatedName("as")
@Implements("MouseWheelHandler")
public final class MouseWheelHandler implements class81, MouseWheelListener, RSMouseWheelHandler {
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1433733739
    )
    int rotation;

    MouseWheelHandler() {
        this.rotation = 0;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Ljava/awt/Component;S)V",
            garbageValue = "1300"
    )
    void method4537(Component var1) {
        var1.removeMouseWheelListener(this);
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "49"
    )
    public synchronized int vmethod4533() {
        int var1 = this.rotation;
        this.rotation = 0;
        return var1;
    }

    public synchronized void copy$mouseWheelMoved(MouseWheelEvent var1) {
        this.rotation += var1.getWheelRotation();
    }

    public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
        var1 = class166.clientInstance.getCallbacks().mouseWheelMoved(var1);
        if (!var1.isConsumed()) {
            this.copy$mouseWheelMoved(var1);
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Ljava/awt/Component;I)V",
            garbageValue = "1285201948"
    )
    void method4531(Component var1) {
        var1.addMouseWheelListener(this);
    }
}
