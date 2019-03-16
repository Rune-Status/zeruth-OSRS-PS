package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("hf")
@Implements("IterableDualNodeQueue")
public class IterableDualNodeQueue implements Iterable {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lhy;"
    )
    CacheableNode field2519;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lhy;"
    )
    public CacheableNode sentinel;

    public IterableDualNodeQueue() {
        this.sentinel = new CacheableNode();
        this.sentinel.previous = this.sentinel;
        this.sentinel.next = this.sentinel;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lhy;)V"
    )
    public void method5799(CacheableNode var1) {
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
            signature = "()Lhy;"
    )
    CacheableNode method5801() {
        CacheableNode var1 = this.sentinel.previous;
        if (var1 == this.sentinel) {
            return null;
        } else {
            var1.method419();
            return var1;
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "()Lhy;"
    )
    CacheableNode method5794() {
        return this.method5795((CacheableNode) null);
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(Lhy;)Lhy;"
    )
    CacheableNode method5795(CacheableNode var1) {
        CacheableNode var2;
        if (var1 == null) {
            var2 = this.sentinel.previous;
        } else {
            var2 = var1;
        }

        if (var2 == this.sentinel) {
            this.field2519 = null;
            return null;
        } else {
            this.field2519 = var2.previous;
            return var2;
        }
    }

    public Iterator iterator() {
        return new class246(this);
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "()Lhy;"
    )
    CacheableNode method5798() {
        CacheableNode var1 = this.field2519;
        if (var1 == this.sentinel) {
            this.field2519 = null;
            return null;
        } else {
            this.field2519 = var1.previous;
            return var1;
        }
    }

    @ObfuscatedName("g")
    public void method5793() {
        while (this.sentinel.previous != this.sentinel) {
            this.sentinel.previous.method419();
        }

    }
}
