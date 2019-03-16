package net.runelite.runescape;

import net.runelite.api.widgets.Widget;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSScriptEvent;

@ObfuscatedName("bv")
@Implements("ScriptEvent")
public class ScriptEvent extends Node implements RSScriptEvent {
    @ObfuscatedName("hf")
    @ObfuscatedGetter(
            intValue = 964567305
    )
    static int cameraPitch;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 1828614909
    )
    int op;
    @ObfuscatedName("r")
    boolean field563;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lhn;"
    )
    ComponentType source;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = -1287066149
    )
    int typedKeyCode;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -1958354679
    )
    int mouseX;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = 1258746033
    )
    int field573;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -80903269
    )
    int field572;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Lhn;"
    )
    ComponentType target;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = 386878879
    )
    int typedKeyChar;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -2135918399
    )
    int mouseY;
    @ObfuscatedName("i")
    String opbase;
    @ObfuscatedName("g")
    Object[] params;

    public ScriptEvent() {
        this.field573 = 76;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-1103064193"
    )
    public void method4035(int var1) {
        this.field573 = var1;
    }

    public void setArguments(Object[] var1) {
        this.params = var1;
    }

    public Object[] getArguments() {
        return this.params;
    }

    public Widget getSource() {
        return this.source;
    }

    public int getOp() {
        return this.op;
    }

    public String getOpbase() {
        return this.opbase;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "([Ljava/lang/Object;B)V",
            garbageValue = "1"
    )
    public void method4033(Object[] var1) {
        this.params = var1;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(IZIZI)V",
            garbageValue = "-394444660"
    )
    static void method4036(int var0, boolean var1, int var2, boolean var3) {
        if (World.worldList != null) {
            class0.method1(0, World.worldList.length - 1, var0, var1, var2, var3);
        }

    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "-296833582"
    )
    static int method4044(int var0) {
        ChatLine var1 = (ChatLine) class202.messages.method2764((long) var0);
        return var1 == null ? -1 : (var1.next == class202.field1247.sentinel ? -1 : ((ChatLine) var1.next).id);
    }

    @ObfuscatedName("ff")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "-1174946118"
    )
    static void method4041(int var0, int var1) {
        int[] var2 = new int[9];

        for (int var3 = 0; var3 < var2.length; ++var3) {
            int var4 = var3 * 32 + 15 + 128;
            int var5 = var4 * 3 + 600;
            int var7 = Graphics3D.SINE[var4];
            int var9 = var1 - 334;
            if (var9 < 0) {
                var9 = 0;
            } else if (var9 > 100) {
                var9 = 100;
            }

            int var10 = (client.field898 - client.field897) * var9 / 100 + client.field897;
            int var8 = var10 * var5 / 256;
            var2[var3] = var7 * var8 >> 16;
        }

        SceneManager.method3906(var2, 500, 800, var0 * 334 / var1, 334);
    }
}
