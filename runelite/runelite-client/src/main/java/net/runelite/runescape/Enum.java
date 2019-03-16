package net.runelite.runescape;

import net.runelite.mapping.*;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

@ObfuscatedName("jj")
@Implements("Enum")
public class Enum extends CacheableNode {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgv;"
    )
    static NodeCache field3414;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    static Js5Index EnumDefinition_indexCache;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 39045461
    )
    @Export("defaultInt")
    public int defaultInt;
    @ObfuscatedName("e")
    @Export("keyType")
    public char keyType;
    @ObfuscatedName("w")
    @Export("keys")
    public int[] keys;
    @ObfuscatedName("q")
    @Export("valType")
    public char valType;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 911875267
    )
    @Export("size")
    public int size;
    @ObfuscatedName("n")
    @Export("intVals")
    public int[] intVals;
    @ObfuscatedName("c")
    @Export("defaultString")
    public String defaultString;
    @ObfuscatedName("i")
    @Export("stringVals")
    public String[] stringVals;

    static {
        field3414 = new NodeCache(64);
    }

    Enum() {
        this.defaultString = "null";
        this.size = 0;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "448568525"
    )
    void method6509(Packet var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method6510(var1, var2);
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "1776134117"
    )
    void method6510(Packet var1, int var2) {
        if (var2 == 1) {
            this.keyType = (char) var1.readUnsignedByte();
        } else if (var2 == 2) {
            this.valType = (char) var1.readUnsignedByte();
        } else if (var2 == 3) {
            this.defaultString = var1.readString();
        } else if (var2 == 4) {
            this.defaultInt = var1.getInt();
        } else {
            int var3;
            if (var2 == 5) {
                this.size = var1.readUnsignedShort();
                this.keys = new int[this.size];
                this.stringVals = new String[this.size];

                for (var3 = 0; var3 < this.size; ++var3) {
                    this.keys[var3] = var1.getInt();
                    this.stringVals[var3] = var1.readString();
                }
            } else if (var2 == 6) {
                this.size = var1.readUnsignedShort();
                this.keys = new int[this.size];
                this.intVals = new int[this.size];

                for (var3 = 0; var3 < this.size; ++var3) {
                    this.keys[var3] = var1.getInt();
                    this.intVals[var3] = var1.getInt();
                }
            }
        }

    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "2"
    )
    public int method6511() {
        return this.size;
    }

    @ObfuscatedName("ge")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "21"
    )
    static void method6514() {
        if (class4.localPlayer.x >> 7 == client.destinationX && class4.localPlayer.y >> 7 == client.destinationY) {
            client.destinationX = 0;
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)J",
            garbageValue = "1787196199"
    )
    static long method6508() {
        try {
            URL var0 = new URL(SubInterface.method2436("services", false) + "m=accountappeal/login.ws");
            URLConnection var1 = var0.openConnection();
            var1.setRequestProperty("connection", "close");
            var1.setDoInput(true);
            var1.setDoOutput(true);
            var1.setConnectTimeout(5000);
            OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
            var2.write("data1=req");
            var2.flush();
            InputStream var3 = var1.getInputStream();
            Packet var4 = new Packet(new byte[1000]);

            do {
                int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
                if (var5 == -1) {
                    var4.offset = 0;
                    long var7 = var4.method6084();
                    return var7;
                }

                var4.offset += var5;
            } while (var4.offset < 1000);

            return 0L;
        } catch (Exception var9) {
            return 0L;
        }
    }
}
