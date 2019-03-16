package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNode;

@ObfuscatedName("gy")
@Implements("Node")
public class Node implements RSNode {
    @ObfuscatedName("ck")
    public long hash;
    @ObfuscatedName("cp")
    @ObfuscatedSignature(
            signature = "Lgy;"
    )
    public Node next;
    @ObfuscatedName("ch")
    @ObfuscatedSignature(
            signature = "Lgy;"
    )
    Node previous;

    @ObfuscatedName("kj")
    public void method6469() {
        this.rl$unlink();
        if (this.previous != null) {
            this.previous.next = this.next;
            this.next.previous = this.previous;
            this.next = null;
            this.previous = null;
        }
    }

    @ObfuscatedName("kl")
    public boolean method6470() {
        return this.previous != null;
    }

    public void onUnlink() {
    }

    public void rl$unlink() {
        this.onUnlink();
    }

    public long getHash() {
        return this.hash;
    }

    public RSNode getNext() {
        return this.next;
    }

    public RSNode getPrevious() {
        return this.previous;
    }

    public void unlink() {
        this.method6469();
    }
}
