package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public final class class158 {
    @ObfuscatedName("gw")
    @ObfuscatedSignature(
            signature = "[Lls;"
    )
    static SpritePixels[] headIconsHint;
    @ObfuscatedName("fc")
    @ObfuscatedGetter(
            intValue = -1553660369
    )
    static int baseX;

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(ZI)V",
            garbageValue = "-739710107"
    )
    static void method2698(boolean var0) {
        class316.loginMessage1 = "";
        class316.loginMessage2 = "Enter your username/email & password.";
        class316.loginMessage3 = "";
        class316.loginIndex = 2;
        if (var0) {
            class316.password = "";
        }

        if (class316.username == null || class316.username.length() <= 0) {
            if (GameEngine.options.rememberedUsername != null) {
                class316.username = GameEngine.options.rememberedUsername;
                client.onUsernameChanged(-1);
                client.Login_isUsernameRemembered = true;
            } else {
                client.Login_isUsernameRemembered = false;
            }
        }

        if (client.Login_isUsernameRemembered && class316.username != null && class316.username.length() > 0) {
            class316.currentLoginField = 1;
        } else {
            class316.currentLoginField = 0;
        }

    }

    @ObfuscatedName("kz")
    @ObfuscatedSignature(
            signature = "(IIIZI)V",
            garbageValue = "-1440028749"
    )
    public static void method2697(int var0, int var1, int var2, boolean var3) {
        TcpConnectionMessage var4 = FaceNormal.method5726(ClientProt.field2211, client.serverConnection.isaac);
        var4.packetBuffer.putIntV1(var3 ? client.field659 : 0);
        var4.packetBuffer.putShortLE(var1);
        var4.packetBuffer.putByteC(var2);
        var4.packetBuffer.putShort(var0);
        client.serverConnection.method5881(var4);
    }
}
