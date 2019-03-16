package net.runelite.runescape;

import net.runelite.mapping.*;
import net.runelite.rs.api.RSPreferences;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

@ObfuscatedName("bj")
@Implements("ClientOptions")
public class ClientOptions implements RSPreferences {
    @ObfuscatedName("qn")
    @ObfuscatedGetter(
            intValue = 1299575453
    )
    static int field1027;
    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "Lco;"
    )
    @Export("soundTaskDataProvider")
    public static class243 soundTaskDataProvider;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 1864295733
    )
    static int field1030;
    @ObfuscatedName("l")
    @Export("rememberedUsername")
    String rememberedUsername;
    @ObfuscatedName("e")
    @Export("hideRoofs")
    boolean hideRoofs;
    @ObfuscatedName("w")
    @Export("authRememberTokens")
    LinkedHashMap authRememberTokens;
    @ObfuscatedName("q")
    @Export("muted")
    boolean muted;
    @ObfuscatedName("b")
    @Export("hideUsername")
    boolean hideUsername;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -1394809603
    )
    @Export("screenType")
    int screenType;

    static {
        field1030 = 6;
    }

    ClientOptions() {
        this.screenType = 1;
        this.rememberedUsername = null;
        this.hideUsername = false;
        this.authRememberTokens = new LinkedHashMap();
        this.method6497(true);
    }

    @ObfuscatedSignature(
            signature = "(Lgl;)V"
    )
    ClientOptions(Packet var1) {
        this.screenType = 1;
        this.rememberedUsername = null;
        this.hideUsername = false;
        this.authRememberTokens = new LinkedHashMap();
        if (var1 != null && var1.payload != null) {
            int var2 = var1.readUnsignedByte();
            if (var2 >= 0 && var2 <= field1030) {
                if (var1.readUnsignedByte() == 1) {
                    this.hideRoofs = true;
                }

                if (var2 > 1) {
                    this.muted = var1.readUnsignedByte() == 1;
                }

                if (var2 > 3) {
                    this.screenType = var1.readUnsignedByte();
                }

                if (var2 > 2) {
                    int var3 = var1.readUnsignedByte();

                    for (int var4 = 0; var4 < var3; ++var4) {
                        int var5 = var1.getInt();
                        int var6 = var1.getInt();
                        this.authRememberTokens.put(Integer.valueOf(var5), Integer.valueOf(var6));
                    }
                }

                if (var2 > 4) {
                    this.rememberedUsername = var1.method6086();
                }

                if (var2 > 5) {
                    this.hideUsername = var1.method6085();
                }
            } else {
                this.method6497(true);
            }
        } else {
            this.method6497(true);
        }

    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)Lgl;",
            garbageValue = "-1976129490"
    )
    Packet method6498() {
        Packet var1 = new Packet(100);
        var1.putByte(field1030);
        var1.putByte(this.hideRoofs ? 1 : 0);
        var1.putByte(this.muted ? 1 : 0);
        var1.putByte(this.screenType);
        var1.putByte(this.authRememberTokens.size());
        Iterator var2 = this.authRememberTokens.entrySet().iterator();

        while (var2.hasNext()) {
            Entry var3 = (Entry) var2.next();
            var1.method6230(((Integer) var3.getKey()).intValue());
            var1.method6230(((Integer) var3.getValue()).intValue());
        }

        var1.method6198(this.rememberedUsername != null ? this.rememberedUsername : "");
        var1.putBoolean(this.hideUsername);
        return var1;
    }

    public void setRememberedUsername(String var1) {
        this.rememberedUsername = var1;
    }

    public String getRememberedUsername() {
        return this.rememberedUsername;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(ZB)V",
            garbageValue = "54"
    )
    void method6497(boolean var1) {
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "72"
    )
    public static boolean method6507() {
        ReflectionCheck var0 = (ReflectionCheck) class186.classInfos.method4329();
        return var0 != null;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lge;II)V",
            garbageValue = "1408100742"
    )
    static final void method6506(Bit var0, int var1) {
        int var2 = var0.offset;
        class254.extendedInfoPlayerCount = 0;
        class113.method1970(var0);
        class133.playerUpdatingMasks(var0);
        if (var0.offset - var2 != var1) {
            throw new RuntimeException(var0.offset - var2 + " " + var1);
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lah;I)V",
            garbageValue = "-1578974438"
    )
    static void method6503(GameEngine var0) {
        int var4;
        if (class316.worldSelectShown) {
            if (MouseInput.mouseLastButton == 1 || !WorldMapType3.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
                int var1 = class316.field1143 + 280;
                if (MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                    class219.method4415(0, 0);
                } else if (MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                    class219.method4415(0, 1);
                } else {
                    int var2 = class316.field1143 + 390;
                    if (MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        class219.method4415(1, 0);
                    } else if (MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        class219.method4415(1, 1);
                    } else {
                        int var17 = class316.field1143 + 500;
                        if (MouseInput.mouseLastPressedX >= var17 && MouseInput.mouseLastPressedX <= var17 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                            class219.method4415(2, 0);
                        } else if (MouseInput.mouseLastPressedX >= var17 + 15 && MouseInput.mouseLastPressedX <= var17 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                            class219.method4415(2, 1);
                        } else {
                            var4 = class316.field1143 + 610;
                            if (MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var4 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                                class219.method4415(3, 0);
                            } else if (MouseInput.mouseLastPressedX >= var4 + 15 && MouseInput.mouseLastPressedX <= var4 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                                class219.method4415(3, 1);
                            } else if (MouseInput.mouseLastPressedX >= class316.field1143 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class316.field1143 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
                                class316.worldSelectShown = false;
                                class316.field1145.method2273(class316.field1143, 0);
                                class316.field1146.method2273(class316.field1143 + 382, 0);
                                Varbit.logoSprite.method824(class316.field1143 + 382 - Varbit.logoSprite.width / 2, 18);
                            } else if (class316.field1164 != -1) {
                                World var5 = World.worldList[class316.field1164];
                                UrlRequest.method5575(var5);
                                class316.worldSelectShown = false;
                                class316.field1145.method2273(class316.field1143, 0);
                                class316.field1146.method2273(class316.field1143 + 382, 0);
                                Varbit.logoSprite.method824(class316.field1143 + 382 - Varbit.logoSprite.width / 2, 18);
                            }
                        }
                    }
                }
            }

        } else {
            if ((MouseInput.mouseLastButton == 1 || !WorldMapType3.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= class316.field1143 + 765 - 50 && MouseInput.mouseLastPressedY >= 453) {
                GameEngine.options.muted = !GameEngine.options.muted;
                PlayerEntity.method2919();
                if (!GameEngine.options.muted) {
                    CombatInfoListHolder.method1500(ServerProt.music, "scape main", "", 255, false);
                } else {
                    WorldMapRegion.method4152();
                }
            }

            if (client.gameState != 5) {
                if (-1L == class316.field1178) {
                    class316.field1178 = Tile.method4297() + 1000L;
                }

                long var12 = Tile.method4297();
                boolean var3;
                if (client.field915 != null && client.field765 < client.field915.size()) {
                    while (true) {
                        if (client.field765 >= client.field915.size()) {
                            var3 = true;
                            break;
                        }

                        class73 var15 = (class73) client.field915.get(client.field765);
                        if (!var15.method1123()) {
                            var3 = false;
                            break;
                        }

                        ++client.field765;
                    }
                } else {
                    var3 = true;
                }

                if (var3 && class316.field1179 == -1L) {
                    class316.field1179 = var12;
                    if (class316.field1179 > class316.field1178) {
                        class316.field1178 = class316.field1179;
                    }
                }

                ++class316.field1156;
                if (client.gameState == 10 || client.gameState == 11) {
                    if (client.languageId == 0) {
                        if (MouseInput.mouseLastButton == 1 || !WorldMapType3.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
                            var4 = class316.field1143 + 5;
                            short var14 = 463;
                            byte var6 = 100;
                            byte var7 = 35;
                            if (MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var6 + var4 && MouseInput.mouseLastPressedY >= var14 && MouseInput.mouseLastPressedY <= var14 + var7) {
                                class70.method1080();
                                return;
                            }
                        }

                        if (World.listFetcher != null) {
                            class70.method1080();
                        }
                    }

                    var4 = MouseInput.mouseLastButton;
                    int var25 = MouseInput.mouseLastPressedX;
                    int var18 = MouseInput.mouseLastPressedY;
                    if (var4 == 0) {
                        var25 = MouseInput.mouseLastX;
                        var18 = MouseInput.mouseLastY * -976212263;
                    }

                    if (!WorldMapType3.middleMouseMovesCamera && var4 == 4) {
                        var4 = 1;
                    }

                    int var8;
                    short var9;
                    if (class316.loginIndex == 0) {
                        boolean var19 = false;

                        while (ClanMember.method981()) {
                            if (ChatLine.currentPressedKey == 84) {
                                var19 = true;
                            }
                        }

                        var8 = class260.field103 - 80;
                        var9 = 291;
                        if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
                            UrlRequest.method5574(SubInterface.method2436("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                        }

                        var8 = class260.field103 + 80;
                        if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20 || var19) {
                            if ((client.flags & 33554432) != 0) {
                                class316.Login_response0 = "";
                                class316.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                                class316.loginMessage2 = "Your normal account will not be affected.";
                                class316.loginMessage3 = "";
                                class316.loginIndex = 1;
                                if (client.Login_isUsernameRemembered && class316.username != null && class316.username.length() > 0) {
                                    class316.currentLoginField = 1;
                                } else {
                                    class316.currentLoginField = 0;
                                }
                            } else if ((client.flags & 4) != 0) {
                                if ((client.flags & 1024) != 0) {
                                    class316.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                                    class316.loginMessage2 = "Players can attack each other almost everywhere";
                                    class316.loginMessage3 = "and the Protect Item prayer won\'t work.";
                                } else {
                                    class316.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                                    class316.loginMessage2 = "Players can attack each other";
                                    class316.loginMessage3 = "almost everywhere.";
                                }

                                class316.Login_response0 = "Warning!";
                                class316.loginIndex = 1;
                                if (client.Login_isUsernameRemembered && class316.username != null && class316.username.length() > 0) {
                                    class316.currentLoginField = 1;
                                } else {
                                    class316.currentLoginField = 0;
                                }
                            } else if ((client.flags & 1024) != 0) {
                                class316.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                                class316.loginMessage2 = "The Protect Item prayer will";
                                class316.loginMessage3 = "not work on this world.";
                                class316.Login_response0 = "Warning!";
                                class316.loginIndex = 1;
                                if (client.Login_isUsernameRemembered && class316.username != null && class316.username.length() > 0) {
                                    class316.currentLoginField = 1;
                                } else {
                                    class316.currentLoginField = 0;
                                }
                            } else {
                                class158.method2698(false);
                            }
                        }
                    } else {
                        int var20;
                        short var22;
                        if (class316.loginIndex != 1) {
                            short var21;
                            if (class316.loginIndex == 2) {
                                var21 = 201;
                                var20 = var21 + 52;
                                if (var4 == 1 && var18 >= var20 - 12 && var18 < var20 + 2) {
                                    class316.currentLoginField = 0;
                                }

                                var20 += 15;
                                if (var4 == 1 && var18 >= var20 - 12 && var18 < var20 + 2) {
                                    class316.currentLoginField = 1;
                                }

                                var20 += 15;
                                var21 = 361;
                                if (class316.field1177 != null) {
                                    var8 = class316.field1177.field3837 / 2;
                                    if (var4 == 1 && var25 >= class316.field1177.field3836 - var8 && var25 <= var8 + class316.field1177.field3836 && var18 >= var21 - 15 && var18 < var21) {
                                        switch (class316.field1161) {
                                            case 1:
                                                class150.method2560("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                                class316.loginIndex = 5;
                                                return;
                                            case 2:
                                                UrlRequest.method5574("https://support.runescape.com/hc/en-gb", true, false);
                                        }
                                    }
                                }

                                var8 = class260.field103 - 80;
                                var9 = 321;
                                if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
                                    class316.username = class316.username.trim();
                                    client.onUsernameChanged(-1);
                                    if (class316.username.length() == 0) {
                                        class150.method2560("", "Please enter your username/email address.", "");
                                        return;
                                    }

                                    if (class316.password.length() == 0) {
                                        class150.method2560("", "Please enter your password.", "");
                                        return;
                                    }

                                    class150.method2560("", "Connecting to server...", "");
                                    WorldMapManager.method945(false);
                                    class310.method5922(20);
                                    return;
                                }

                                var8 = class316.loginWindowX + 180 + 80;
                                if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
                                    class316.loginIndex = 0;
                                    class316.username = "";
                                    client.onUsernameChanged(-1);
                                    class316.password = "";
                                    class228.authcode = 0;
                                    class113.field82 = "";
                                    class316.field1172 = true;
                                }

                                var8 = class260.field103 + -117;
                                var9 = 277;
                                class316.field1170 = var25 >= var8 && var25 < var8 + class4.field1050 && var18 >= var9 && var18 < var9 + GameCanvas.field405;
                                if (var4 == 1 && class316.field1170) {
                                    client.Login_isUsernameRemembered = !client.Login_isUsernameRemembered;
                                    if (!client.Login_isUsernameRemembered && GameEngine.options.rememberedUsername != null) {
                                        GameEngine.options.rememberedUsername = null;
                                        PlayerEntity.method2919();
                                    }
                                }

                                var8 = class260.field103 + 24;
                                var9 = 277;
                                class316.field1171 = var25 >= var8 && var25 < var8 + class4.field1050 && var18 >= var9 && var18 < var9 + GameCanvas.field405;
                                if (var4 == 1 && class316.field1171) {
                                    GameEngine.options.hideUsername = !GameEngine.options.hideUsername;
                                    if (!GameEngine.options.hideUsername) {
                                        class316.username = "";
                                        client.onUsernameChanged(-1);
                                        GameEngine.options.rememberedUsername = null;
                                        if (client.Login_isUsernameRemembered && class316.username != null && class316.username.length() > 0) {
                                            class316.currentLoginField = 1;
                                        } else {
                                            class316.currentLoginField = 0;
                                        }
                                    }

                                    PlayerEntity.method2919();
                                }

                                while (true) {
                                    while (ClanMember.method981()) {
                                        boolean var10 = false;

                                        for (int var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var11) {
                                            if (FaceNormal.currentTypedKey == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var11)) {
                                                var10 = true;
                                                break;
                                            }
                                        }

                                        if (ChatLine.currentPressedKey == 13) {
                                            class316.loginIndex = 0;
                                            class316.username = "";
                                            client.onUsernameChanged(-1);
                                            class316.password = "";
                                            class228.authcode = 0;
                                            class113.field82 = "";
                                            class316.field1172 = true;
                                        } else if (class316.currentLoginField == 0) {
                                            if (ChatLine.currentPressedKey == 85 && class316.username.length() > 0) {
                                                class316.username = class316.username.substring(0, class316.username.length() - 1);
                                                client.onUsernameChanged(-1);
                                            }

                                            if (ChatLine.currentPressedKey == 84 || ChatLine.currentPressedKey == 80) {
                                                class316.currentLoginField = 1;
                                            }

                                            if (var10 && class316.username.length() < 320) {
                                                class316.username = class316.username + FaceNormal.currentTypedKey;
                                                client.onUsernameChanged(-1);
                                            }
                                        } else if (class316.currentLoginField == 1) {
                                            if (ChatLine.currentPressedKey == 85 && class316.password.length() > 0) {
                                                class316.password = class316.password.substring(0, class316.password.length() - 1);
                                            }

                                            if (ChatLine.currentPressedKey == 84 || ChatLine.currentPressedKey == 80) {
                                                class316.currentLoginField = 0;
                                            }

                                            if (ChatLine.currentPressedKey == 84) {
                                                class316.username = class316.username.trim();
                                                client.onUsernameChanged(-1);
                                                if (class316.username.length() == 0) {
                                                    class150.method2560("", "Please enter your username/email address.", "");
                                                    return;
                                                }

                                                if (class316.password.length() == 0) {
                                                    class150.method2560("", "Please enter your password.", "");
                                                    return;
                                                }

                                                class150.method2560("", "Connecting to server...", "");
                                                WorldMapManager.method945(false);
                                                class310.method5922(20);
                                                return;
                                            }

                                            if (var10 && class316.password.length() < 20) {
                                                class316.password = class316.password + FaceNormal.currentTypedKey;
                                            }
                                        }
                                    }

                                    return;
                                }
                            } else if (class316.loginIndex == 3) {
                                var20 = class316.loginWindowX + 180;
                                var22 = 276;
                                if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                                    class158.method2698(false);
                                }

                                var20 = class316.loginWindowX + 180;
                                var22 = 326;
                                if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                                    class150.method2560("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                    class316.loginIndex = 5;
                                    return;
                                }
                            } else {
                                boolean var23;
                                int var24;
                                if (class316.loginIndex == 4) {
                                    var20 = class316.loginWindowX + 180 - 80;
                                    var22 = 321;
                                    if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                                        class113.field82.trim();
                                        if (class113.field82.length() != 6) {
                                            class150.method2560("", "Please enter a 6-digit PIN.", "");
                                            return;
                                        }

                                        class228.authcode = Integer.parseInt(class113.field82);
                                        class113.field82 = "";
                                        WorldMapManager.method945(true);
                                        class150.method2560("", "Connecting to server...", "");
                                        class310.method5922(20);
                                        return;
                                    }

                                    if (var4 == 1 && var25 >= class316.loginWindowX + 180 - 9 && var25 <= class316.loginWindowX + 180 + 130 && var18 >= 263 && var18 <= 296) {
                                        class316.field1172 = !class316.field1172;
                                    }

                                    if (var4 == 1 && var25 >= class316.loginWindowX + 180 - 34 && var25 <= class316.loginWindowX + 34 + 180 && var18 >= 351 && var18 <= 363) {
                                        UrlRequest.method5574(SubInterface.method2436("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                                    }

                                    var20 = class316.loginWindowX + 180 + 80;
                                    if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                                        class316.loginIndex = 0;
                                        class316.username = "";
                                        client.onUsernameChanged(-1);
                                        class316.password = "";
                                        class228.authcode = 0;
                                        class113.field82 = "";
                                    }

                                    while (ClanMember.method981()) {
                                        var23 = false;

                                        for (var24 = 0; var24 < "1234567890".length(); ++var24) {
                                            if (FaceNormal.currentTypedKey == "1234567890".charAt(var24)) {
                                                var23 = true;
                                                break;
                                            }
                                        }

                                        if (ChatLine.currentPressedKey == 13) {
                                            class316.loginIndex = 0;
                                            class316.username = "";
                                            client.onUsernameChanged(-1);
                                            class316.password = "";
                                            class228.authcode = 0;
                                            class113.field82 = "";
                                        } else {
                                            if (ChatLine.currentPressedKey == 85 && class113.field82.length() > 0) {
                                                class113.field82 = class113.field82.substring(0, class113.field82.length() - 1);
                                            }

                                            if (ChatLine.currentPressedKey == 84) {
                                                class113.field82.trim();
                                                if (class113.field82.length() != 6) {
                                                    class150.method2560("", "Please enter a 6-digit PIN.", "");
                                                    return;
                                                }

                                                class228.authcode = Integer.parseInt(class113.field82);
                                                class113.field82 = "";
                                                WorldMapManager.method945(true);
                                                class150.method2560("", "Connecting to server...", "");
                                                class310.method5922(20);
                                                return;
                                            }

                                            if (var23 && class113.field82.length() < 6) {
                                                class113.field82 = class113.field82 + FaceNormal.currentTypedKey;
                                            }
                                        }
                                    }
                                } else if (class316.loginIndex == 5) {
                                    var20 = class316.loginWindowX + 180 - 80;
                                    var22 = 321;
                                    if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                                        Timer.method5404();
                                        return;
                                    }

                                    var20 = class316.loginWindowX + 180 + 80;
                                    if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                                        class158.method2698(true);
                                    }

                                    while (ClanMember.method981()) {
                                        var23 = false;

                                        for (var24 = 0; var24 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var24) {
                                            if (FaceNormal.currentTypedKey == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var24)) {
                                                var23 = true;
                                                break;
                                            }
                                        }

                                        if (ChatLine.currentPressedKey == 13) {
                                            class158.method2698(true);
                                        } else {
                                            if (ChatLine.currentPressedKey == 85 && class316.username.length() > 0) {
                                                class316.username = class316.username.substring(0, class316.username.length() - 1);
                                                client.onUsernameChanged(-1);
                                            }

                                            if (ChatLine.currentPressedKey == 84) {
                                                Timer.method5404();
                                                return;
                                            }

                                            if (var23 && class316.username.length() < 320) {
                                                class316.username = class316.username + FaceNormal.currentTypedKey;
                                                client.onUsernameChanged(-1);
                                            }
                                        }
                                    }
                                } else if (class316.loginIndex == 6) {
                                    while (true) {
                                        do {
                                            if (!ClanMember.method981()) {
                                                var21 = 321;
                                                if (var4 == 1 && var18 >= var21 - 20 && var18 <= var21 + 20) {
                                                    class158.method2698(true);
                                                }

                                                return;
                                            }
                                        } while (ChatLine.currentPressedKey != 84 && ChatLine.currentPressedKey != 13);

                                        class158.method2698(true);
                                    }
                                } else if (class316.loginIndex == 7) {
                                    var20 = class316.loginWindowX + 180 - 80;
                                    var22 = 321;
                                    if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                                        UrlRequest.method5574(SubInterface.method2436("secure", true) + "m=dob/set_dob.ws", true, false);
                                        class150.method2560("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                        class316.loginIndex = 6;
                                        return;
                                    }

                                    var20 = class316.loginWindowX + 180 + 80;
                                    if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                                        class158.method2698(true);
                                    }
                                } else if (class316.loginIndex == 8) {
                                    var20 = class316.loginWindowX + 180 - 80;
                                    var22 = 321;
                                    if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                                        UrlRequest.method5574("https://www.jagex.com/terms/privacy/#eight", true, false);
                                        class150.method2560("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                        class316.loginIndex = 6;
                                        return;
                                    }

                                    var20 = class316.loginWindowX + 180 + 80;
                                    if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                                        class158.method2698(true);
                                    }
                                } else if (class316.loginIndex == 12) {
                                    String var16 = "";
                                    switch (class316.field1142) {
                                        case 0:
                                            var16 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
                                            break;
                                        case 1:
                                            var16 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
                                            break;
                                        default:
                                            class158.method2698(false);
                                    }

                                    var8 = class316.loginWindowX + 180;
                                    var9 = 276;
                                    if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
                                        UrlRequest.method5574(var16, true, false);
                                        class150.method2560("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                        class316.loginIndex = 6;
                                        return;
                                    }

                                    var8 = class316.loginWindowX + 180;
                                    var9 = 326;
                                    if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
                                        class158.method2698(false);
                                    }
                                }
                            }
                        } else {
                            while (ClanMember.method981()) {
                                if (ChatLine.currentPressedKey == 84) {
                                    class158.method2698(false);
                                } else if (ChatLine.currentPressedKey == 13) {
                                    class316.loginIndex = 0;
                                }
                            }

                            var20 = class260.field103 - 80;
                            var22 = 321;
                            if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                                class158.method2698(false);
                            }

                            var20 = class260.field103 + 80;
                            if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                                class316.loginIndex = 0;
                            }
                        }
                    }

                }
            }
        }
    }

    @ObfuscatedName("ie")
    @ObfuscatedSignature(
            signature = "(Ljv;IIII)V",
            garbageValue = "223122158"
    )
    static final void method6499(NPCType var0, int var1, int var2, int var3) {
        if (client.menuOptionCount < 400) {
            if (var0.multiNpcs != null) {
                var0 = var0.method5837();
            }

            if (var0 != null) {
                if (var0.isClickable) {
                    if (!var0.isLowPriorityOps || client.field813 == var1) {
                        String var4 = var0.name;
                        int var7;
                        int var8;
                        if (var0.level != 0) {
                            var7 = var0.level;
                            var8 = class4.localPlayer.combatLevel;
                            int var9 = var8 - var7;
                            String var6;
                            if (var9 < -9) {
                                var6 = class31.method548(16711680);
                            } else if (var9 < -6) {
                                var6 = class31.method548(16723968);
                            } else if (var9 < -3) {
                                var6 = class31.method548(16740352);
                            } else if (var9 < 0) {
                                var6 = class31.method548(16756736);
                            } else if (var9 > 9) {
                                var6 = class31.method548(65280);
                            } else if (var9 > 6) {
                                var6 = class31.method548(4259584);
                            } else if (var9 > 3) {
                                var6 = class31.method548(8453888);
                            } else if (var9 > 0) {
                                var6 = class31.method548(12648192);
                            } else {
                                var6 = class31.method548(16776960);
                            }

                            var4 = var4 + var6 + " " + " (" + "level-" + var0.level + ")";
                        }

                        if (var0.isLowPriorityOps && client.field788) {
                            class316.method5992("Examine", class31.method548(16776960) + var4, 1003, var1, var2, var3);
                        }

                        if (client.itemSelectionState == 1) {
                            class316.method5992("Use", client.lastSelectedItemName + " " + "->" + " " + class31.method548(16776960) + var4, 7, var1, var2, var3);
                        } else if (client.spellSelected) {
                            if ((FontName.ifTargetMask & 2) == 2) {
                                class316.method5992(client.targetVerb, client.opBase + " " + "->" + " " + class31.method548(16776960) + var4, 8, var1, var2, var3);
                            }
                        } else {
                            int var10 = var0.isLowPriorityOps && client.field788 ? 2000 : 0;
                            String[] var11 = var0.ops;
                            if (var11 != null) {
                                for (var7 = 4; var7 >= 0; --var7) {
                                    if (var11[var7] != null && !var11[var7].equalsIgnoreCase("Attack")) {
                                        var8 = 0;
                                        if (var7 == 0) {
                                            var8 = var10 + 9;
                                        }

                                        if (var7 == 1) {
                                            var8 = var10 + 10;
                                        }

                                        if (var7 == 2) {
                                            var8 = var10 + 11;
                                        }

                                        if (var7 == 3) {
                                            var8 = var10 + 12;
                                        }

                                        if (var7 == 4) {
                                            var8 = var10 + 13;
                                        }

                                        class316.method5992(var11[var7], class31.method548(16776960) + var4, var8, var1, var2, var3);
                                    }
                                }
                            }

                            if (var11 != null) {
                                for (var7 = 4; var7 >= 0; --var7) {
                                    if (var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                                        short var12 = 0;
                                        if (client.npcAttackOpPriority != AttackOpPriority.HIDDEN) {
                                            if (client.npcAttackOpPriority == AttackOpPriority.UNPRIORITISED || client.npcAttackOpPriority == AttackOpPriority.COMBAT_LEVEL_BASED && var0.level > class4.localPlayer.combatLevel) {
                                                var12 = 2000;
                                            }

                                            var8 = 0;
                                            if (var7 == 0) {
                                                var8 = var12 + 9;
                                            }

                                            if (var7 == 1) {
                                                var8 = var12 + 10;
                                            }

                                            if (var7 == 2) {
                                                var8 = var12 + 11;
                                            }

                                            if (var7 == 3) {
                                                var8 = var12 + 12;
                                            }

                                            if (var7 == 4) {
                                                var8 = var12 + 13;
                                            }

                                            class316.method5992(var11[var7], class31.method548(16776960) + var4, var8, var1, var2, var3);
                                        }
                                    }
                                }
                            }

                            if (!var0.isLowPriorityOps || !client.field788) {
                                class316.method5992("Examine", class31.method548(16776960) + var4, 1003, var1, var2, var3);
                            }
                        }

                    }
                }
            }
        }
    }
}
