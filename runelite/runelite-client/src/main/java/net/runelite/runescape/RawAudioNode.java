package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("RawAudioNode")
public class RawAudioNode extends AbstractIntegerNode0 {
    @ObfuscatedName("r")
    public byte[] audioBuffer;
    @ObfuscatedName("e")
    public int startPosition;
    @ObfuscatedName("q")
    int endPosition;
    @ObfuscatedName("c")
    public boolean field1344;
    @ObfuscatedName("g")
    public int sampleRate;

    RawAudioNode(int var1, byte[] var2, int var3, int var4) {
        this.sampleRate = var1;
        this.audioBuffer = var2;
        this.startPosition = var3;
        this.endPosition = var4;
    }

    RawAudioNode(int var1, byte[] var2, int var3, int var4, boolean var5) {
        this.sampleRate = var1;
        this.audioBuffer = var2;
        this.startPosition = var3;
        this.endPosition = var4;
        this.field1344 = var5;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Ldm;)Lct;"
    )
    public RawAudioNode method4097(Resampler var1) {
        this.audioBuffer = var1.method6432(this.audioBuffer);
        this.sampleRate = var1.method6437(this.sampleRate);
        if (this.startPosition == this.endPosition) {
            this.startPosition = this.endPosition = var1.method6433(this.startPosition);
        } else {
            this.startPosition = var1.method6433(this.startPosition);
            this.endPosition = var1.method6433(this.endPosition);
            if (this.startPosition == this.endPosition) {
                --this.startPosition;
            }
        }

        return this;
    }
}
