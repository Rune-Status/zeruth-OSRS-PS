package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSCacheableNode;

@ObfuscatedName("hy")
@Implements("CacheableNode")
public class CacheableNode extends Node implements RSCacheableNode {
    @ObfuscatedName("cq")
    @ObfuscatedSignature(
            signature = "Lhy;"
    )
    public CacheableNode next;
    @ObfuscatedName("ct")
    long field2501;
    @ObfuscatedName("cs")
    @ObfuscatedSignature(
            signature = "Lhy;"
    )
    public CacheableNode previous;

    @ObfuscatedName("ck")
    public void method419() {
        if (this.next != null) {
            this.next.previous = this.previous;
            this.previous.next = this.next;
            this.previous = null;
            this.next = null;
        }
    }
}
