package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;

@ObfuscatedName("d")
@Implements("Size")
public class Size {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Ld;"
    )
    public static final Size field93;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Ld;"
    )
    public static final Size field94;
    @ObfuscatedName("er")
    static SecureRandom field100;
    @ObfuscatedName("gf")
    @ObfuscatedSignature(
            signature = "Lls;"
    )
    static SpritePixels mapedge;
    @ObfuscatedName("dv")
    @ObfuscatedSignature(
            signature = "Lih;"
    )
    static Js5 binary;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Ld;"
    )
    public static final Size field92;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -89581307
    )
    final int field96;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -596081859
    )
    final int field95;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -869467753
    )
    final int field97;

    static {
        field92 = new Size(2, 0, 4);
        field93 = new Size(1, 1, 2);
        field94 = new Size(0, 2, 0);
    }

    Size(int var1, int var2, int var3) {
        this.field95 = var1;
        this.field97 = var2;
        this.field96 = var3;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(FI)Z",
            garbageValue = "1643478829"
    )
    boolean method4692(float var1) {
        return var1 >= (float) this.field96;
    }

    @ObfuscatedName("fb")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "761124161"
    )
    static final void method4699() {
        int var0 = WorldMapType2.field266 * 128 + 64;
        int var1 = class170.field2361 * 128 + 64;
        int var2 = MilliTimer.method2824(var0, var1, class228.level) - UrlRequest.field1926;
        if (class166.cameraX < var0) {
            class166.cameraX = (var0 - class166.cameraX) * WorldMapManager.field314 / 1000 + class166.cameraX + ServerProt.field2206;
            if (class166.cameraX > var0) {
                class166.cameraX = var0;
            }
        }

        if (class166.cameraX > var0) {
            class166.cameraX -= WorldMapManager.field314 * (class166.cameraX - var0) / 1000 + ServerProt.field2206;
            if (class166.cameraX < var0) {
                class166.cameraX = var0;
            }
        }

        if (Packet.cameraZ < var2) {
            Packet.cameraZ = (var2 - Packet.cameraZ) * WorldMapManager.field314 / 1000 + Packet.cameraZ + ServerProt.field2206;
            if (Packet.cameraZ > var2) {
                Packet.cameraZ = var2;
            }
        }

        if (Packet.cameraZ > var2) {
            Packet.cameraZ -= WorldMapManager.field314 * (Packet.cameraZ - var2) / 1000 + ServerProt.field2206;
            if (Packet.cameraZ < var2) {
                Packet.cameraZ = var2;
            }
        }

        if (class98.cameraY < var1) {
            class98.cameraY = (var1 - class98.cameraY) * WorldMapManager.field314 / 1000 + class98.cameraY + ServerProt.field2206;
            if (class98.cameraY > var1) {
                class98.cameraY = var1;
            }
        }

        if (class98.cameraY > var1) {
            class98.cameraY -= WorldMapManager.field314 * (class98.cameraY - var1) / 1000 + ServerProt.field2206;
            if (class98.cameraY < var1) {
                class98.cameraY = var1;
            }
        }

        var0 = ClientOptions.field1027 * 128 + 64;
        var1 = class230.field1939 * 128 + 64;
        var2 = MilliTimer.method2824(var0, var1, class228.level) - class147.field208;
        int var3 = var0 - class166.cameraX;
        int var4 = var2 - Packet.cameraZ;
        int var5 = var1 - class98.cameraY;
        int var6 = (int) Math.sqrt((double) (var5 * var5 + var3 * var3));
        int var7 = (int) (Math.atan2((double) var4, (double) var6) * 325.949D) & 2047;
        int var8 = (int) (Math.atan2((double) var3, (double) var5) * -325.949D) & 2047;
        if (var7 < 128) {
            var7 = 128;
        }

        if (var7 > 383) {
            var7 = 383;
        }

        if (ScriptEvent.cameraPitch < var7) {
            ScriptEvent.cameraPitch = (var7 - ScriptEvent.cameraPitch) * class225.field3289 / 1000 + ScriptEvent.cameraPitch + World.field1026;
            client.onCameraPitchChanged(-1);
            if (ScriptEvent.cameraPitch > var7) {
                ScriptEvent.cameraPitch = var7;
                client.onCameraPitchChanged(-1);
            }
        }

        if (ScriptEvent.cameraPitch > var7) {
            ScriptEvent.cameraPitch -= class225.field3289 * (ScriptEvent.cameraPitch - var7) / 1000 + World.field1026;
            client.onCameraPitchChanged(-1);
            if (ScriptEvent.cameraPitch < var7) {
                ScriptEvent.cameraPitch = var7;
                client.onCameraPitchChanged(-1);
            }
        }

        int var9 = var8 - class39.cameraYaw;
        if (var9 > 1024) {
            var9 -= 2048;
        }

        if (var9 < -1024) {
            var9 += 2048;
        }

        if (var9 > 0) {
            class39.cameraYaw = var9 * class225.field3289 / 1000 + class39.cameraYaw + World.field1026;
            class39.cameraYaw &= 2047;
        }

        if (var9 < 0) {
            class39.cameraYaw -= -var9 * class225.field3289 / 1000 + World.field1026;
            class39.cameraYaw &= 2047;
        }

        int var10 = var8 - class39.cameraYaw;
        if (var10 > 1024) {
            var10 -= 2048;
        }

        if (var10 < -1024) {
            var10 += 2048;
        }

        if (var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
            class39.cameraYaw = var8;
        }

    }

    @ObfuscatedName("kp")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "86433056"
    )
    static void method4702() {
        if (client.camModeType == 1) {
            client.field726 = true;
        }

    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(II)Ld;",
            garbageValue = "2138411363"
    )
    static Size method4687(int var0) {
        Size[] var1 = method4685();

        for (int var2 = 0; var2 < var1.length; ++var2) {
            Size var3 = var1[var2];
            if (var0 == var3.field97) {
                return var3;
            }
        }

        return null;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;IB)V",
            garbageValue = "96"
    )
    public static void method4704(Packet var0, int var1) {
        ReflectionCheck var2 = new ReflectionCheck();
        var2.count = var0.readUnsignedByte();
        var2.field3845 = var0.getInt();
        var2.type = new int[var2.count];
        var2.errorIdentifiers = new int[var2.count];
        var2.fields = new Field[var2.count];
        var2.field3848 = new int[var2.count];
        var2.methods = new Method[var2.count];
        var2.args = new byte[var2.count][][];

        for (int var3 = 0; var3 < var2.count; ++var3) {
            try {
                int var4 = var0.readUnsignedByte();
                String var5;
                String var6;
                int var7;
                if (var4 != 0 && var4 != 1 && var4 != 2) {
                    if (var4 == 3 || var4 == 4) {
                        var5 = var0.readString();
                        var6 = var0.readString();
                        var7 = var0.readUnsignedByte();
                        String[] var8 = new String[var7];

                        for (int var9 = 0; var9 < var7; ++var9) {
                            var8[var9] = var0.readString();
                        }

                        String var20 = var0.readString();
                        byte[][] var10 = new byte[var7][];
                        int var12;
                        if (var4 == 3) {
                            for (int var11 = 0; var11 < var7; ++var11) {
                                var12 = var0.getInt();
                                var10[var11] = new byte[var12];
                                var0.method6090(var10[var11], 0, var12);
                            }
                        }

                        var2.type[var3] = var4;
                        Class[] var21 = new Class[var7];

                        for (var12 = 0; var12 < var7; ++var12) {
                            var21[var12] = class261.method5013(var8[var12]);
                        }

                        Class var22 = class261.method5013(var20);
                        if (class261.method5013(var5).getClassLoader() == null) {
                            throw new SecurityException();
                        }

                        Method[] var13 = class261.method5013(var5).getDeclaredMethods();
                        Method[] var14 = var13;

                        for (int var15 = 0; var15 < var14.length; ++var15) {
                            Method var16 = var14[var15];
                            if (var16.getName().equals(var6)) {
                                Class[] var17 = var16.getParameterTypes();
                                if (var21.length == var17.length) {
                                    boolean var18 = true;

                                    for (int var19 = 0; var19 < var21.length; ++var19) {
                                        if (var21[var19] != var17[var19]) {
                                            var18 = false;
                                            break;
                                        }
                                    }

                                    if (var18 && var22 == var16.getReturnType()) {
                                        var2.methods[var3] = var16;
                                    }
                                }
                            }
                        }

                        var2.args[var3] = var10;
                    }
                } else {
                    var5 = var0.readString();
                    var6 = var0.readString();
                    var7 = 0;
                    if (var4 == 1) {
                        var7 = var0.getInt();
                    }

                    var2.type[var3] = var4;
                    var2.field3848[var3] = var7;
                    if (class261.method5013(var5).getClassLoader() == null) {
                        throw new SecurityException();
                    }

                    var2.fields[var3] = class261.method5013(var5).getDeclaredField(var6);
                }
            } catch (ClassNotFoundException var24) {
                var2.errorIdentifiers[var3] = -1;
            } catch (SecurityException var25) {
                var2.errorIdentifiers[var3] = -2;
            } catch (NullPointerException var26) {
                var2.errorIdentifiers[var3] = -3;
            } catch (Exception var27) {
                var2.errorIdentifiers[var3] = -4;
            } catch (Throwable var28) {
                var2.errorIdentifiers[var3] = -5;
            }
        }

        class186.classInfos.method4348(var2);
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(Lhn;IS)V",
            garbageValue = "-9770"
    )
    static final void method4703(ComponentType var0, int var1) {
        if (var0.opKeys == null) {
            throw new RuntimeException();
        } else {
            if (var0.opKeysIgnoreHeld == null) {
                var0.opKeysIgnoreHeld = new int[var0.opKeys.length];
            }

            var0.opKeysIgnoreHeld[var1] = Integer.MAX_VALUE;
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1775551761"
    )
    static void method4688() {
        ItemContainer.itemContainers = new HashTable(32);
    }

    @ObfuscatedName("gf")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1896196282"
    )
    static boolean method4700() {
        return (client.playerNameMask & 1) != 0;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)[Ld;",
            garbageValue = "1694413832"
    )
    static Size[] method4685() {
        return new Size[]{field92, field94, field93};
    }
}
