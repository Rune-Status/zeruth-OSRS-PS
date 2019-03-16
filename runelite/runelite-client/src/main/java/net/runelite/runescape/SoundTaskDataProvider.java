package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("SoundTaskDataProvider")
public class SoundTaskDataProvider implements class243 {
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = -829046195
    )
    static int field396;

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(B)Lcq;",
            garbageValue = "-34"
    )
    public AbstractSoundSystem vmethod4668() {
        return new SourceDataSoundSystem();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "1551244815"
    )
    public static void method2533(int var0, int var1) {
        Varbit var2 = class79.method1158(var0);
        int var3 = var2.configId;
        int var4 = var2.leastSignificantBit;
        int var5 = var2.mostSignificantBit;
        int var6 = class311.varpsMasks[var5 - var4];
        if (var1 < 0 || var1 > var6) {
            var1 = 0;
        }

        var6 <<= var4;
        class311.clientVarps[var3] = class311.clientVarps[var3] & ~var6 | var1 << var4 & var6;
        client.settingsChanged(var3);
    }

    @ObfuscatedName("fm")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;S)V",
            garbageValue = "17668"
    )
    static final void method2528(String var0) {
        if (var0.equalsIgnoreCase("toggleroof")) {
            GameEngine.options.hideRoofs = !GameEngine.options.hideRoofs;
            PlayerEntity.method2919();
            if (GameEngine.options.hideRoofs) {
                ChatLine.method5672(99, "", "Roofs are now all hidden");
            } else {
                ChatLine.method5672(99, "", "Roofs will only be removed selectively");
            }
        }

        if (var0.equalsIgnoreCase("displayfps")) {
            client.displayFps = !client.displayFps;
        }

        if (var0.equalsIgnoreCase("renderself")) {
            client.field762 = !client.field762;
        }

        if (var0.equalsIgnoreCase("mouseovertext")) {
            client.field791 = !client.field791;
        }

        if (client.staffModLevel >= 2) {
            if (var0.equalsIgnoreCase("errortest")) {
                throw new RuntimeException();
            }

            if (var0.equalsIgnoreCase("showcoord")) {
                class219.worldMap.field3994 = !class219.worldMap.field3994;
            }

            if (var0.equalsIgnoreCase("fpson")) {
                client.displayFps = true;
            }

            if (var0.equalsIgnoreCase("fpsoff")) {
                client.displayFps = false;
            }

            if (var0.equalsIgnoreCase("gc")) {
                System.gc();
            }

            if (var0.equalsIgnoreCase("clientdrop")) {
                WorldMapDecoration.method2943();
            }
        }

        TcpConnectionMessage var1 = FaceNormal.method5726(ClientProt.CLIENT_CHEAT, client.serverConnection.isaac);
        var1.packetBuffer.putByte(var0.length() + 1);
        var1.packetBuffer.method6198(var0);
        client.serverConnection.method5881(var1);
    }

    @ObfuscatedName("jo")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "99"
    )
    static final void method2527() {
        client.field837 = client.cycleCntr;
        MapLabel.field221 = true;
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "1"
    )
    public static final void method2531() {
        class195.Viewport_containsMouse = false;
        class195.Viewport_entityCountAtMouse = 0;
    }
}
