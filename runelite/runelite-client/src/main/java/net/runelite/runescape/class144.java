package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
public class class144 {
    @ObfuscatedName("jg")
    @ObfuscatedSignature(
            signature = "Ldg;"
    )
    static TextureProvider field3688;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            longValue = 8351344282591730985L
    )
    long field3679;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            longValue = 388906557533113327L
    )
    long loginAttemptTimeStart;
    @ObfuscatedName("e")
    public boolean field3680;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 145394263
    )
    int field3685;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            longValue = 5088993818342166059L
    )
    long elapsedLoginAttemptTime;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -471569399
    )
    int gameState;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -416310385
    )
    int loginAttempts;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            longValue = -2175764574268115639L
    )
    long elapsedLastPackedReceivedTime;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 258447615
    )
    int field3687;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            longValue = 5257425705691971607L
    )
    long lastPacketReceivedTime;

    public class144() {
        this.lastPacketReceivedTime = -1L;
        this.loginAttemptTimeStart = -1L;
        this.field3680 = false;
        this.elapsedLoginAttemptTime = 0L;
        this.elapsedLastPackedReceivedTime = 0L;
        this.field3679 = 0L;
        this.gameState = 0;
        this.field3685 = 0;
        this.loginAttempts = 0;
        this.field3687 = 0;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1898107601"
    )
    public void method2490() {
        if (-1L != this.lastPacketReceivedTime) {
            this.elapsedLastPackedReceivedTime = Tile.method4297() - this.lastPacketReceivedTime;
            this.lastPacketReceivedTime = -1L;
        }

    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "43"
    )
    public void method2491(int var1) {
        this.loginAttemptTimeStart = Tile.method4297();
        this.gameState = var1;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "701070702"
    )
    public void method2492() {
        if (this.loginAttemptTimeStart != -1L) {
            this.elapsedLoginAttemptTime = Tile.method4297() - this.loginAttemptTimeStart;
            this.loginAttemptTimeStart = -1L;
        }

        ++this.loginAttempts;
        this.field3680 = true;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(Lgl;B)V",
            garbageValue = "110"
    )
    public void method2495(Packet var1) {
        long var2 = this.elapsedLastPackedReceivedTime;
        var2 /= 10L;
        if (var2 < 0L) {
            var2 = 0L;
        } else if (var2 > 65535L) {
            var2 = 65535L;
        }

        var1.putShort((int) var2);
        long var4 = this.elapsedLoginAttemptTime;
        var4 /= 10L;
        if (var4 < 0L) {
            var4 = 0L;
        } else if (var4 > 65535L) {
            var4 = 65535L;
        }

        var1.putShort((int) var4);
        long var6 = this.field3679;
        var6 /= 10L;
        if (var6 < 0L) {
            var6 = 0L;
        } else if (var6 > 65535L) {
            var6 = 65535L;
        }

        var1.putShort((int) var6);
        var1.putShort(this.gameState);
        var1.putShort(this.field3685);
        var1.putShort(this.loginAttempts);
        var1.putShort(this.field3687);
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1613481433"
    )
    public void method2493() {
        this.field3680 = false;
        this.field3685 = 0;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "1"
    )
    public void method2489() {
        this.method2492();
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1610452923"
    )
    public void method2505() {
        this.lastPacketReceivedTime = Tile.method4297();
    }
}
