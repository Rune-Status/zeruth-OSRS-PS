package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lhy;"
    )
    CacheableNode sentinel;

    public Node2LinkedList() {
        this.sentinel = new CacheableNode();
        this.sentinel.previous = this.sentinel;
        this.sentinel.next = this.sentinel;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lhy;)V"
    )
    public void method2510(CacheableNode var1) {
        if (var1.next != null) {
            var1.method419();
        }

        var1.next = this.sentinel;
        var1.previous = this.sentinel.previous;
        var1.next.previous = var1;
        var1.previous.next = var1;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "()Lhy;"
    )
    CacheableNode method2512() {
        CacheableNode var1 = this.sentinel.previous;
        if (var1 == this.sentinel) {
            return null;
        } else {
            var1.method419();
            return var1;
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "()Lhy;"
    )
    public CacheableNode method2519() {
        CacheableNode var1 = this.sentinel.previous;
        return var1 == this.sentinel ? null : var1;
    }

    @ObfuscatedName("i")
    void method2508() {
        while (true) {
            CacheableNode var1 = this.sentinel.previous;
            if (var1 == this.sentinel) {
                return;
            }

            var1.method419();
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lhy;)V"
    )
    public void method2509(CacheableNode var1) {
        if (var1.next != null) {
            var1.method419();
        }

        var1.next = this.sentinel.next;
        var1.previous = this.sentinel;
        var1.next.previous = var1;
        var1.previous.next = var1;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lhy;Lhy;)V"
    )
    static void method2514(CacheableNode var0, CacheableNode var1) {
        if (var0.next != null) {
            var0.method419();
        }

        var0.next = var1;
        var0.previous = var1.previous;
        var0.next.previous = var0;
        var0.previous.next = var0;
    }
}
