package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("MapIconReference")
public class MapIconReference {
    @ObfuscatedName("ni")
    @ObfuscatedSignature(
            signature = "Lcd;"
    )
    static Varcs varcs;
    @ObfuscatedName("cy")
    @ObfuscatedSignature(
            signature = "Lbq;"
    )
    static MouseRecorder mouseRecorder;
    @ObfuscatedName("gb")
    @ObfuscatedSignature(
            signature = "[Lli;"
    )
    static IndexedSprite[] modIconSprites;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lhz;"
    )
    public Coordinates field344;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lhz;"
    )
    public Coordinates field345;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -2049445249
    )
    public int areaId;

    @ObfuscatedSignature(
            signature = "(ILhz;Lhz;)V"
    )
    public MapIconReference(int var1, Coordinates var2, Coordinates var3) {
        this.areaId = var1;
        this.field344 = var2;
        this.field345 = var3;
    }

    @ObfuscatedName("fx")
    @ObfuscatedSignature(
            signature = "(IIII)V",
            garbageValue = "-557263979"
    )
    static void method4837(int var0, int var1, int var2) {
        if (client.field888 != 0 && var1 != 0 && client.queuedSoundEffectCount < 50) {
            client.queuedSoundEffectIDs[client.queuedSoundEffectCount] = var0;
            client.unknownSoundValues1[client.queuedSoundEffectCount] = var1;
            client.unknownSoundValues2[client.queuedSoundEffectCount] = var2;
            client.audioEffects[client.queuedSoundEffectCount] = null;
            client.soundLocations[client.queuedSoundEffectCount] = 0;
            ++client.queuedSoundEffectCount;
        }

    }

    @ObfuscatedName("iy")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;Lhn;I)Ljava/lang/String;",
            garbageValue = "-614678746"
    )
    static String method4836(String var0, ComponentType var1) {
        if (var0.indexOf("%") != -1) {
            for (int var2 = 1; var2 <= 5; ++var2) {
                while (true) {
                    int var3 = var0.indexOf("%" + var2);
                    if (var3 == -1) {
                        break;
                    }

                    var0 = var0.substring(0, var3) + Packet.method6303(class9.method130(var1, var2 - 1)) + var0.substring(var3 + 2);
                }
            }
        }

        return var0;
    }

    @ObfuscatedName("hs")
    @ObfuscatedSignature(
            signature = "(ILjava/lang/String;I)V",
            garbageValue = "-1790829652"
    )
    static void method4835(int var0, String var1) {
        int var2 = class254.highResolutionPlayerCount;
        int[] var3 = class254.highResolutionPlayerIndexes;
        boolean var4 = false;
        Name var5 = new Name(var1, client.loginType);

        for (int var6 = 0; var6 < var2; ++var6) {
            PlayerEntity var7 = client.players[var3[var6]];
            if (var7 != null && var7 != class4.localPlayer && var7.name != null && var7.name.equals(var5)) {
                TcpConnectionMessage var8;
                if (var0 == 1) {
                    var8 = FaceNormal.method5726(ClientProt.OPPLAYER1, client.serverConnection.isaac);
                    var8.packetBuffer.putShort(var3[var6]);
                    var8.packetBuffer.putByteC(0);
                    client.serverConnection.method5881(var8);
                } else if (var0 == 4) {
                    var8 = FaceNormal.method5726(ClientProt.OPPLAYER4, client.serverConnection.isaac);
                    var8.packetBuffer.putShortLEA(var3[var6]);
                    var8.packetBuffer.putByteC(0);
                    client.serverConnection.method5881(var8);
                } else if (var0 == 6) {
                    var8 = FaceNormal.method5726(ClientProt.OPPLAYER6, client.serverConnection.isaac);
                    var8.packetBuffer.getShort128(var3[var6]);
                    var8.packetBuffer.putByteS(0);
                    client.serverConnection.method5881(var8);
                } else if (var0 == 7) {
                    var8 = FaceNormal.method5726(ClientProt.OPPLAYER7, client.serverConnection.isaac);
                    var8.packetBuffer.putByteS(0);
                    var8.packetBuffer.putShortLE(var3[var6]);
                    client.serverConnection.method5881(var8);
                }

                var4 = true;
                break;
            }
        }

        if (!var4) {
            ChatLine.method5672(4, "", "Unable to find " + var1);
        }

    }
}
