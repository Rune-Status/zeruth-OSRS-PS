package net.runelite.runescape;

import net.runelite.api.IndexDataBase;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSTexture;
import net.runelite.rs.api.RSTextureProvider;

import java.io.*;

@ObfuscatedName("dg")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader, RSTextureProvider {
    @ObfuscatedName("sa")
    @ObfuscatedGetter(
            longValue = -380971225571932671L
    )
    static long field1511;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -334322773
    )
    int width;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgi;"
    )
    Deque deque;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -598632167
    )
    int maxSize;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 1139140653
    )
    int size;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    Js5Index sprites;
    @ObfuscatedName("c")
    double brightness;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "[Ldx;"
    )
    Texture[] textures;

    @ObfuscatedSignature(
            signature = "(Liu;Liu;IDI)V"
    )
    public TextureProvider(Js5Index var1, Js5Index var2, int var3, double var4, int var6) {
        this.deque = new Deque();
        this.size = 0;
        this.brightness = 1.0D;
        this.width = 128;
        this.sprites = var2;
        this.maxSize = var3;
        this.size = this.maxSize;
        this.brightness = var4;
        this.width = var6;
        int[] var7 = var1.method1524(0);
        int var8 = var7.length;
        this.textures = new Texture[var1.method1574(0)];

        for (int var9 = 0; var9 < var8; ++var9) {
            Packet var10 = new Packet(var1.method1516(0, var7[var9], 1789634852));
            this.textures[var7[var9]] = new Texture(var10);
        }

        this.rl$init(var1, var2, var3, var4, var6);
    }

    @ObfuscatedName("r")
    public void method2767(double var1) {
        this.brightness = var1;
        this.method2787();
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IB)[I",
            garbageValue = "40"
    )
    public int[] vmethod5375(int var1) {
        Texture var2 = this.textures[var1];
        if (var2 != null) {
            if (var2.pixels != null) {
                this.deque.method4352(var2);
                var2.loaded = true;
                return var2.pixels;
            }

            boolean var3 = var2.method5378(this.brightness, this.width, this.sprites);
            if (var3) {
                if (this.size == 0) {
                    Texture var4 = (Texture) this.deque.method4355();
                    var4.method5379();
                } else {
                    --this.size;
                }

                this.deque.method4352(var2);
                var2.loaded = true;
                return var2.pixels;
            }
        }

        return null;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "1901823043"
    )
    public int vmethod5363(int var1) {
        return this.textures[var1] != null ? this.textures[var1].field1593 : 0;
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "-26"
    )
    public void method2772(int var1) {
        for (int var2 = 0; var2 < this.textures.length; ++var2) {
            Texture var3 = this.textures[var2];
            if (var3 != null && var3.field1599 != 0 && var3.loaded) {
                var3.method5380(var1);
                var3.loaded = false;
            }
        }

        this.checkTextures(var1);
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1398303545"
    )
    public void method2787() {
        for (int var1 = 0; var1 < this.textures.length; ++var1) {
            if (this.textures[var1] != null) {
                this.textures[var1].method5379();
            }
        }

        this.deque = new Deque();
        this.size = this.maxSize;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IB)Z",
            garbageValue = "-59"
    )
    public boolean vmethod5366(int var1) {
        return this.textures[var1].field1602;
    }

    public void setMaxSize(int var1) {
        this.maxSize = var1;
    }

    public void setSize(int var1) {
        this.size = var1;
    }

    public void checkTextures(int var1) {
        class166.clientInstance.getCallbacks().drawAboveOverheads();
    }

    public void rl$init(IndexDataBase var1, IndexDataBase var2, int var3, double var4, int var6) {
        this.setMaxSize(64);
        this.setSize(64);
    }

    public RSTexture[] getTextures() {
        return this.textures;
    }

    public double getBrightness() {
        return this.brightness;
    }

    public void setBrightness(double var1) {
        this.method2767(var1);
    }

    public int[] load(int var1) {
        return this.vmethod5375(var1);
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(II)Z",
            garbageValue = "844577854"
    )
    public boolean vmethod5364(int var1) {
        return this.width == 64;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "1447723466"
    )
    public int method2766() {
        int var1 = 0;
        int var2 = 0;
        Texture[] var3 = this.textures;

        for (int var4 = 0; var4 < var3.length; ++var4) {
            Texture var5 = var3[var4];
            if (var5 != null && var5.fileIds != null) {
                var1 += var5.fileIds.length;
                int[] var6 = var5.fileIds;

                for (int var7 = 0; var7 < var6.length; ++var7) {
                    int var8 = var6[var7];
                    if (this.sprites.method1514(var8)) {
                        ++var2;
                    }
                }
            }
        }

        if (var1 == 0) {
            return 0;
        } else {
            return var2 * 100 / var1;
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
            garbageValue = "899022447"
    )
    static String method2791(Throwable var0) throws IOException {
        String var1;
        if (var0 instanceof JagException) {
            JagException var2 = (JagException) var0;
            var1 = var2.field2001 + " | ";
            var0 = var2.parent;
        } else {
            var1 = "";
        }

        StringWriter var12 = new StringWriter();
        PrintWriter var3 = new PrintWriter(var12);
        var0.printStackTrace(var3);
        var3.close();
        String var4 = var12.toString();
        BufferedReader var5 = new BufferedReader(new StringReader(var4));
        String var6 = var5.readLine();

        while (true) {
            while (true) {
                String var7 = var5.readLine();
                if (var7 == null) {
                    var1 = var1 + "| " + var6;
                    return var1;
                }

                int var8 = var7.indexOf(40);
                int var9 = var7.indexOf(41, var8 + 1);
                if (var8 >= 0 && var9 >= 0) {
                    String var10 = var7.substring(var8 + 1, var9);
                    int var11 = var10.indexOf(".java:");
                    if (var11 >= 0) {
                        var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                        var1 = var1 + var10 + ' ';
                        continue;
                    }

                    var7 = var7.substring(0, var8);
                }

                var7 = var7.trim();
                var7 = var7.substring(var7.lastIndexOf(32) + 1);
                var7 = var7.substring(var7.lastIndexOf(9) + 1);
                var1 = var1 + var7 + ' ';
            }
        }
    }
}
