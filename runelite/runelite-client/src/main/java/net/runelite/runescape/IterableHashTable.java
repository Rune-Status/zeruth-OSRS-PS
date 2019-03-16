package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSIterableHashTable;
import net.runelite.rs.api.RSNode;

import java.util.Iterator;

@ObfuscatedName("gr")
@Implements("IterableHashTable")
public final class IterableHashTable implements Iterable, RSIterableHashTable {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "[Lgy;"
    )
    Node[] buckets;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lgy;"
    )
    Node head;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgy;"
    )
    Node tail;
    @ObfuscatedName("c")
    int index;
    @ObfuscatedName("g")
    int size;

    public IterableHashTable(int var1) {
        this.index = 0;
        this.size = var1;
        this.buckets = new Node[var1];

        for (int var2 = 0; var2 < var1; ++var2) {
            Node var3 = this.buckets[var2] = new Node();
            var3.next = var3;
            var3.previous = var3;
        }

    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lgy;J)V"
    )
    public void method2749(Node var1, long var2) {
        if (var1.previous != null) {
            var1.method6469();
        }

        Node var4 = this.buckets[(int) (var2 & (long) (this.size - 1))];
        var1.previous = var4.previous;
        var1.next = var4;
        var1.previous.next = var1;
        var1.next.previous = var1;
        var1.hash = var2;
    }

    @ObfuscatedName("e")
    public void method2757() {
        for (int var1 = 0; var1 < this.size; ++var1) {
            Node var2 = this.buckets[var1];

            while (true) {
                Node var3 = var2.next;
                if (var3 == var2) {
                    break;
                }

                var3.method6469();
            }
        }

        this.head = null;
        this.tail = null;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "()Lgy;"
    )
    public Node method2751() {
        this.index = 0;
        return this.method2752();
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "()Lgy;"
    )
    public Node method2752() {
        Node var1;
        if (this.index > 0 && this.buckets[this.index - 1] != this.tail) {
            var1 = this.tail;
            this.tail = var1.next;
            return var1;
        } else {
            do {
                if (this.index >= this.size) {
                    return null;
                }

                var1 = this.buckets[this.index++].next;
            } while (var1 == this.buckets[this.index - 1]);

            this.tail = var1.next;
            return var1;
        }
    }

    public Iterator iterator() {
        return new HashTableIterator(this);
    }

    public RSNode get(long var1) {
        return this.method2764(var1);
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(J)Lgy;"
    )
    public Node method2764(long var1) {
        Node var3 = this.buckets[(int) (var1 & (long) (this.size - 1))];

        for (this.head = var3.next; var3 != this.head; this.head = this.head.next) {
            if (this.head.hash == var1) {
                Node var4 = this.head;
                this.head = this.head.next;
                return var4;
            }
        }

        this.head = null;
        return null;
    }
}
