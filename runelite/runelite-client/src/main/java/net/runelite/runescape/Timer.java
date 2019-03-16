package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;
import java.io.IOException;

@ObfuscatedName("fa")
@Implements("Timer")
public abstract class Timer {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(III)I",
            garbageValue = "-191189521"
    )
    public abstract int vmethod5391(int var1, int var2);

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "2124397224"
    )
    public abstract void vmethod5390();

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Ljava/io/File;Ljava/io/File;I)V",
            garbageValue = "88922872"
    )
    static void method5394(File var0, File var1) {
        try {
            FileOnDisk var2 = new FileOnDisk(class166.cacheLocator, "rw", 10000L);
            Packet var3 = new Packet(500);
            var3.putByte(3);
            var3.putByte(var1 != null ? 1 : 0);
            var3.method6298(var0.getPath());
            if (var1 != null) {
                var3.method6298("");
            }

            var2.method145(var3.payload, 0, var3.offset);
            var2.method146();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/Object;ZB)[B",
            garbageValue = "-89"
    )
    public static byte[] method5403(Object var0, boolean var1) {
        if (var0 == null) {
            return null;
        } else if (var0 instanceof byte[]) {
            byte[] var6 = (byte[]) ((byte[]) var0);
            if (var1) {
                int var4 = var6.length;
                byte[] var5 = new byte[var4];
                System.arraycopy(var6, 0, var5, 0, var4);
                return var5;
            } else {
                return var6;
            }
        } else if (var0 instanceof AbstractByteBuffer) {
            AbstractByteBuffer var2 = (AbstractByteBuffer) var0;
            return var2.vmethod5407();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1145854110"
    )
    static void method5404() {
        class316.username = class316.username.trim();
        client.onUsernameChanged(-1);
        if (class316.username.length() == 0) {
            class150.method2560("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
        } else {
            long var1 = Enum.method6508();
            int var0;
            if (var1 == 0L) {
                var0 = 5;
            } else {
                var0 = ItemLayer.method2792(var1, class316.username);
            }

            switch (var0) {
                case 2:
                    class150.method2560(class7.field2943, class7.field3118, class7.field3081);
                    class316.loginIndex = 6;
                    break;
                case 3:
                    class150.method2560("", "Error connecting to server.", "");
                    break;
                case 4:
                    class150.method2560("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
                    break;
                case 5:
                    class150.method2560("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
                    break;
                case 6:
                    class150.method2560("", "Error connecting to server.", "");
                    break;
                case 7:
                    class150.method2560("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
            }

        }
    }

    @ObfuscatedName("it")
    @ObfuscatedSignature(
            signature = "([Lhn;IIIZB)V",
            garbageValue = "86"
    )
    static void method5401(ComponentType[] var0, int var1, int var2, int var3, boolean var4) {
        for (int var5 = 0; var5 < var0.length; ++var5) {
            ComponentType var6 = var0[var5];
            if (var6 != null && var6.layer == var1) {
                GameObject.method2037(var6, var2, var3, var4);
                GroundObject.method4582(var6, var2, var3);
                if (var6.scrollX > var6.scrollWidth - var6.width) {
                    var6.scrollX = var6.scrollWidth - var6.width;
                }

                if (var6.scrollX < 0) {
                    var6.scrollX = 0;
                }

                if (var6.scrollY > var6.scrollHeight - var6.height) {
                    var6.scrollY = var6.scrollHeight - var6.height;
                }

                if (var6.scrollY < 0) {
                    var6.scrollY = 0;
                }

                if (var6.type == 0) {
                    class196.method4011(var0, var6, var4);
                }
            }
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(II)Lii;",
            garbageValue = "32768"
    )
    public static MapElementType method5389(int var0) {
        return var0 >= 0 && var0 < MapElementType.mapElementTypes.length && MapElementType.mapElementTypes[var0] != null ? MapElementType.mapElementTypes[var0] : new MapElementType(var0);
    }
}
