package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;

@ObfuscatedName("ec")
@Implements("UrlRequester")
public class UrlRequester implements Runnable {
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Liu;"
    )
    public static Js5Index field1911;
    @ObfuscatedName("ae")
    static FontMetrics field1917;
    @ObfuscatedName("ds")
    @ObfuscatedSignature(
            signature = "Lih;"
    )
    static Js5 clientscripts;
    @ObfuscatedName("gr")
    @ObfuscatedSignature(
            signature = "[Lls;"
    )
    static SpritePixels[] headIconsPrayer;
    @ObfuscatedName("r")
    volatile boolean isClosed;
    @ObfuscatedName("e")
    Queue requests;
    @ObfuscatedName("g")
    final Thread thread;

    public UrlRequester() {
        this.requests = new LinkedList();
        this.thread = new Thread(this);
        this.thread.setPriority(1);
        this.thread.start();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1163748948"
    )
    public void method4075() {
        this.isClosed = true;

        try {
            synchronized (this) {
                this.notify();
            }

            this.thread.join();
        } catch (InterruptedException var4) {
            ;
        }

    }

    public void run() {
        while (!this.isClosed) {
            try {
                UrlRequest var1;
                synchronized (this) {
                    var1 = (UrlRequest) this.requests.poll();
                    if (var1 == null) {
                        try {
                            this.wait();
                        } catch (InterruptedException var13) {
                            ;
                        }
                        continue;
                    }
                }

                DataInputStream var2 = null;
                URLConnection var3 = null;

                try {
                    var3 = var1.url.openConnection();
                    var3.setConnectTimeout(5000);
                    var3.setReadTimeout(5000);
                    var3.setUseCaches(false);
                    var3.setRequestProperty("Connection", "close");
                    int var7 = var3.getContentLength();
                    if (var7 >= 0) {
                        byte[] var5 = new byte[var7];
                        var2 = new DataInputStream(var3.getInputStream());
                        var2.readFully(var5);
                        var1.response0 = var5;
                    }

                    var1.isDone0 = true;
                } catch (IOException var14) {
                    var1.isDone0 = true;
                } finally {
                    if (var2 != null) {
                        var2.close();
                    }

                    if (var3 != null && var3 instanceof HttpURLConnection) {
                        ((HttpURLConnection) var3).disconnect();
                    }

                }
            } catch (Exception var17) {
                ProjectileAnimation.method5582((String) null, var17, 1743975076);
            }
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Ljava/net/URL;I)Leg;",
            garbageValue = "433596934"
    )
    public UrlRequest method4079(URL var1) {
        UrlRequest var2 = new UrlRequest(var1);
        synchronized (this) {
            this.requests.add(var2);
            this.notify();
            return var2;
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Liu;Liu;Liu;Lhg;B)Z",
            garbageValue = "84"
    )
    public static boolean method4081(Js5Index var0, Js5Index var1, Js5Index var2, class257 var3) {
        class120.field2535 = var0;
        class120.field2530 = var1;
        class120.field2531 = var2;
        class267.field2461 = var3;
        return true;
    }
}
