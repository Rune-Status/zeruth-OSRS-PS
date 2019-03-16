package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.io.OutputStream;

@ObfuscatedName("fe")
@Implements("GameSocket")
public class GameSocket implements Runnable {
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 863303983
    )
    int field2082;
    @ObfuscatedName("r")
    OutputStream field2077;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = -293827879
    )
    int field2079;
    @ObfuscatedName("w")
    boolean field2084;
    @ObfuscatedName("q")
    byte[] field2081;
    @ObfuscatedName("b")
    IOException field2083;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = 751418949
    )
    int field2085;
    @ObfuscatedName("g")
    Thread field2080;

    GameSocket(OutputStream var1, int var2) {
        this.field2085 = 0;
        this.field2082 = 0;
        this.field2077 = var1;
        this.field2079 = var2 + 1;
        this.field2081 = new byte[this.field2079];
        this.field2080 = new Thread(this);
        this.field2080.setDaemon(true);
        this.field2080.start();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "([BIII)V",
            garbageValue = "-374365232"
    )
    void method4285(byte[] var1, int var2, int var3) throws IOException {
        if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
            synchronized (this) {
                if (this.field2083 != null) {
                    throw new IOException(this.field2083.toString());
                } else {
                    int var5;
                    if (this.field2085 <= this.field2082) {
                        var5 = this.field2079 - this.field2082 + this.field2085 - 1;
                    } else {
                        var5 = this.field2085 - this.field2082 - 1;
                    }

                    if (var5 < var3) {
                        throw new IOException("");
                    } else {
                        if (var3 + this.field2082 <= this.field2079) {
                            System.arraycopy(var1, var2, this.field2081, this.field2082, var3);
                        } else {
                            int var6 = this.field2079 - this.field2082;
                            System.arraycopy(var1, var2, this.field2081, this.field2082, var6);
                            System.arraycopy(var1, var6 + var2, this.field2081, 0, var3 - var6);
                        }

                        this.field2082 = (var3 + this.field2082) % this.field2079;
                        this.notifyAll();
                    }
                }
            }
        } else {
            throw new IOException();
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "147196859"
    )
    void method4286() {
        synchronized (this) {
            this.field2084 = true;
            this.notifyAll();
        }

        try {
            this.field2080.join();
        } catch (InterruptedException var3) {
            ;
        }

    }

    public void run() {
        do {
            int var1;
            synchronized (this) {
                while (true) {
                    if (this.field2083 != null) {
                        return;
                    }

                    if (this.field2085 <= this.field2082) {
                        var1 = this.field2082 - this.field2085;
                    } else {
                        var1 = this.field2079 - this.field2085 + this.field2082;
                    }

                    if (var1 > 0) {
                        break;
                    }

                    try {
                        this.field2077.flush();
                    } catch (IOException var11) {
                        this.field2083 = var11;
                        return;
                    }

                    if (this.method4283()) {
                        return;
                    }

                    try {
                        this.wait();
                    } catch (InterruptedException var12) {
                        ;
                    }
                }
            }

            try {
                if (var1 + this.field2085 <= this.field2079) {
                    this.field2077.write(this.field2081, this.field2085, var1);
                } else {
                    int var7 = this.field2079 - this.field2085;
                    this.field2077.write(this.field2081, this.field2085, var7);
                    this.field2077.write(this.field2081, 0, var1 - var7);
                }
            } catch (IOException var10) {
                IOException var2 = var10;
                synchronized (this) {
                    this.field2083 = var2;
                    return;
                }
            }

            synchronized (this) {
                this.field2085 = (var1 + this.field2085) % this.field2079;
            }
        } while (!this.method4283());

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "1986657608"
    )
    boolean method4283() {
        if (this.field2084) {
            try {
                this.field2077.close();
                if (this.field2083 == null) {
                    this.field2083 = new IOException("");
                }
            } catch (IOException var2) {
                if (this.field2083 == null) {
                    this.field2083 = new IOException(var2);
                }
            }

            return true;
        } else {
            return false;
        }
    }

    @ObfuscatedName("r")
    public static String method4295(long var0) {
        if (var0 > 0L && var0 < 6582952005840035281L) {
            if (var0 % 37L == 0L) {
                return null;
            } else {
                int var2 = 0;

                for (long var3 = var0; 0L != var3; var3 /= 37L) {
                    ++var2;
                }

                StringBuilder var5 = new StringBuilder(var2);

                while (var0 != 0L) {
                    long var6 = var0;
                    var0 /= 37L;
                    var5.append(class13.field3791[(int) (var6 - var0 * 37L)]);
                }

                return var5.reverse().toString();
            }
        } else {
            return null;
        }
    }
}
