package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSCombatInfo1;

@ObfuscatedName("bg")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node implements RSCombatInfo1 {
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -2009843137
    )
    int healthRatio;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 27673533
    )
    int health;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -1594257837
    )
    int int2;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -538030707
    )
    int cycle;

    CombatInfo1(int var1, int var2, int var3, int var4) {
        this.cycle = var1;
        this.healthRatio = var2;
        this.health = var3;
        this.int2 = var4;
    }

    public int getHealthRatio() {
        return this.healthRatio;
    }

    public int getHealth() {
        return this.health;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(IIIII)V",
            garbageValue = "242544624"
    )
    void method1155(int var1, int var2, int var3, int var4) {
        this.cycle = var1;
        this.healthRatio = var2;
        this.health = var3;
        this.int2 = var4;
    }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            signature = "(IZII)V",
            garbageValue = "935134680"
    )
    public static final void method1156(int var0, boolean var1, int var2) {
        if (var0 >= 8000 && var0 <= 48000) {
            AbstractSoundSystem.sampleRate = var0;
            class56.audioHighMemory = var1;
            WorldMapDecoration.field189 = var2;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(IIB)I",
            garbageValue = "-28"
    )
    static int method1157(int var0, int var1) {
        Overlay var3 = (Overlay) Overlay.overlays.method951((long) var0);
        Overlay var2;
        if (var3 != null) {
            var2 = var3;
        } else {
            byte[] var4 = Overlay.overlay_ref.method1516(4, var0, 1789634852);
            var3 = new Overlay();
            if (var4 != null) {
                var3.method418(new Packet(var4), var0);
            }

            var3.method398();
            Overlay.overlays.method957(var3, (long) var0);
            var2 = var3;
        }

        if (var2 == null) {
            return var1;
        } else if (var2.otherRgbColor >= 0) {
            return var2.otherRgbColor | -16777216;
        } else if (var2.texture >= 0) {
            int var10 = VertexNormal.method2548(Graphics3D.textureLoader.vmethod5363(var2.texture), 96);
            return Graphics3D.colorPalette[var10] | -16777216;
        } else if (var2.color == 16711935) {
            return var1;
        } else {
            int var5 = var2.hue;
            int var6 = var2.saturation;
            int var7 = var2.lightness;
            if (var7 > 179) {
                var6 /= 2;
            }

            if (var7 > 192) {
                var6 /= 2;
            }

            if (var7 > 217) {
                var6 /= 2;
            }

            if (var7 > 243) {
                var6 /= 2;
            }

            int var8 = (var6 / 32 << 7) + var7 / 2 + (var5 / 4 << 10);
            int var9 = VertexNormal.method2548(var8, 96);
            return Graphics3D.colorPalette[var9] | -16777216;
        }
    }
}
