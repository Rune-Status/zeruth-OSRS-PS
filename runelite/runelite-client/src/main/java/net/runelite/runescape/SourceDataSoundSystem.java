package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

@ObfuscatedName("ao")
@Implements("SourceDataSoundSystem")
public class SourceDataSoundSystem extends AbstractSoundSystem {
    @ObfuscatedName("r")
    SourceDataLine source;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 1936204333
    )
    int size;
    @ObfuscatedName("q")
    byte[] bytes;
    @ObfuscatedName("g")
    AudioFormat audioFormat;

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IB)V",
            garbageValue = "-66"
    )
    protected void vmethod6411(int var1) throws LineUnavailableException {
        try {
            Info var2 = new Info(SourceDataLine.class, this.audioFormat, var1 << (class56.audioHighMemory ? 2 : 1));
            this.source = (SourceDataLine) AudioSystem.getLine(var2);
            this.source.open();
            this.source.start();
            this.size = var1;
        } catch (LineUnavailableException var3) {
            if (class60.method883(var1) != 1) {
                this.vmethod6411(TotalQuantityComparator.method1181(var1));
            } else {
                this.source = null;
                throw var3;
            }
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-1047007902"
    )
    protected int vmethod6412() {
        return this.size - (this.source.available() >> (class56.audioHighMemory ? 2 : 1));
    }

    @ObfuscatedName("q")
    protected void vmethod6413() {
        int var1 = 256;
        if (class56.audioHighMemory) {
            var1 <<= 1;
        }

        for (int var2 = 0; var2 < var1; ++var2) {
            int var3 = super.samples[var2];
            if ((var3 + 8388608 & -16777216) != 0) {
                var3 = 8388607 ^ var3 >> 31;
            }

            this.bytes[var2 * 2] = (byte) (var3 >> 8);
            this.bytes[var2 * 2 + 1] = (byte) (var3 >> 16);
        }

        this.source.write(this.bytes, 0, var1 << 1);
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1506242428"
    )
    protected void vmethod6419() {
        if (this.source != null) {
            this.source.close();
            this.source = null;
        }

    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1925463504"
    )
    protected void vmethod6425() {
        this.source.flush();
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-917925486"
    )
    protected void vmethod6410() {
        this.audioFormat = new AudioFormat((float) sampleRate, 16, class56.audioHighMemory ? 2 : 1, true, false);
        this.bytes = new byte[256 << (class56.audioHighMemory ? 2 : 1)];
    }
}
