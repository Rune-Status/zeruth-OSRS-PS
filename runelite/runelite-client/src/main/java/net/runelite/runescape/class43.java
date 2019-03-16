package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ObfuscatedName("hb")
public class class43 {
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -783690389
    )
    int field2525;
    @ObfuscatedName("r")
    byte[] field2524;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 1735333931
    )
    int field2522;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 363606515
    )
    int field2523;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 1700212949
    )
    int field2528;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -381735215
    )
    int field2526;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = 1299657215
    )
    int field2520;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 2145532233
    )
    int field2527;
    @ObfuscatedName("g")
    byte[] field2521;

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lge;B)V",
            garbageValue = "38"
    )
    public static void method617(Bit var0) {
        ReflectionCheck var1 = (ReflectionCheck) class186.classInfos.method4329();
        if (var1 != null) {
            int var2 = var0.offset;
            var0.method6230(var1.field3845);

            for (int var3 = 0; var3 < var1.count; ++var3) {
                if (var1.errorIdentifiers[var3] != 0) {
                    var0.putByte(var1.errorIdentifiers[var3]);
                } else {
                    try {
                        int var4 = var1.type[var3];
                        Field var5;
                        int var6;
                        if (var4 == 0) {
                            var5 = var1.fields[var3];
                            var6 = var5.getInt((Object) null);
                            var0.putByte(0);
                            var0.method6230(var6);
                        } else if (var4 == 1) {
                            var5 = var1.fields[var3];
                            var5.setInt((Object) null, var1.field3848[var3]);
                            var0.putByte(0);
                        } else if (var4 == 2) {
                            var5 = var1.fields[var3];
                            var6 = var5.getModifiers();
                            var0.putByte(0);
                            var0.method6230(var6);
                        }

                        Method var25;
                        if (var4 != 3) {
                            if (var4 == 4) {
                                var25 = var1.methods[var3];
                                var6 = var25.getModifiers();
                                var0.putByte(0);
                                var0.method6230(var6);
                            }
                        } else {
                            var25 = var1.methods[var3];
                            byte[][] var10 = var1.args[var3];
                            Object[] var7 = new Object[var10.length];

                            for (int var8 = 0; var8 < var10.length; ++var8) {
                                ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                                var7[var8] = var9.readObject();
                            }

                            Object var11 = var25.invoke((Object) null, var7);
                            if (var11 == null) {
                                var0.putByte(0);
                            } else if (var11 instanceof Number) {
                                var0.putByte(1);
                                var0.method6067(((Number) var11).longValue());
                            } else if (var11 instanceof String) {
                                var0.putByte(2);
                                var0.method6198((String) var11);
                            } else {
                                var0.putByte(4);
                            }
                        }
                    } catch (ClassNotFoundException var13) {
                        var0.putByte(-10);
                    } catch (InvalidClassException var14) {
                        var0.putByte(-11);
                    } catch (StreamCorruptedException var15) {
                        var0.putByte(-12);
                    } catch (OptionalDataException var16) {
                        var0.putByte(-13);
                    } catch (IllegalAccessException var17) {
                        var0.putByte(-14);
                    } catch (IllegalArgumentException var18) {
                        var0.putByte(-15);
                    } catch (InvocationTargetException var19) {
                        var0.putByte(-16);
                    } catch (SecurityException var20) {
                        var0.putByte(-17);
                    } catch (IOException var21) {
                        var0.putByte(-18);
                    } catch (NullPointerException var22) {
                        var0.putByte(-19);
                    } catch (Exception var23) {
                        var0.putByte(-20);
                    } catch (Throwable var24) {
                        var0.putByte(-21);
                    }
                }
            }

            var0.method6059(var2);
            var1.method6469();
        }
    }

    @ObfuscatedName("fc")
    @ObfuscatedSignature(
            signature = "(Lhn;III)V",
            garbageValue = "1104472161"
    )
    static final void method615(ComponentType var0, int var1, int var2) {
        if (client.minimapRenderType == 0 || client.minimapRenderType == 3) {
            if (!client.isMenuOpen && (MouseInput.mouseLastButton == 1 || !WorldMapType3.middleMouseMovesCamera && MouseInput.mouseLastButton == 4)) {
                class96 var3 = var0.method270(true);
                if (var3 == null) {
                    return;
                }

                int var4 = MouseInput.mouseLastPressedX - var1;
                int var5 = MouseInput.mouseLastPressedY - var2;
                if (var3.method1622(var4, var5)) {
                    var4 -= var3.field2626 / 2;
                    var5 -= var3.field2621 / 2;
                    int var6 = client.mapAngle & 2047;
                    int var7 = Graphics3D.SINE[var6];
                    int var8 = Graphics3D.COSINE[var6];
                    int var9 = var4 * var8 + var5 * var7 >> 11;
                    int var10 = var5 * var8 - var7 * var4 >> 11;
                    int var11 = var9 + class4.localPlayer.x >> 7;
                    int var12 = class4.localPlayer.y - var10 >> 7;
                    TcpConnectionMessage var13 = FaceNormal.method5726(ClientProt.MOVE_MINIMAPCLICK, client.serverConnection.isaac);
                    var13.packetBuffer.putByte(18);
                    var13.packetBuffer.getShort128(var12 + class107.baseY);
                    var13.packetBuffer.getShort128(var11 + class158.baseX);
                    var13.packetBuffer.putByte128(KeyFocusListener.keyPressed[82] ? (KeyFocusListener.keyPressed[81] ? 2 : 1) : 0);
                    var13.packetBuffer.putByte(var4);
                    var13.packetBuffer.putByte(var5);
                    var13.packetBuffer.putShort(client.mapAngle);
                    var13.packetBuffer.putByte(57);
                    var13.packetBuffer.putByte(0);
                    var13.packetBuffer.putByte(0);
                    var13.packetBuffer.putByte(89);
                    var13.packetBuffer.putShort(class4.localPlayer.x);
                    var13.packetBuffer.putShort(class4.localPlayer.y);
                    var13.packetBuffer.putByte(63);
                    client.serverConnection.method5881(var13);
                    client.destinationX = var11;
                    client.destinationY = var12;
                }
            }

        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(II)Ljy;",
            garbageValue = "1947262272"
    )
    public static Overlay method616(int var0) {
        Overlay var1 = (Overlay) Overlay.overlays.method951((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = Overlay.overlay_ref.method1516(4, var0, 1789634852);
            var1 = new Overlay();
            if (var2 != null) {
                var1.method418(new Packet(var2), var0);
            }

            var1.method398();
            Overlay.overlays.method957(var1, (long) var0);
            return var1;
        }
    }
}
