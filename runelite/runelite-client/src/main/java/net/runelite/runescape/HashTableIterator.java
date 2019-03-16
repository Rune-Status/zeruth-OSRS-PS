package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("ha")
@Implements("HashTableIterator")
public class HashTableIterator implements Iterator {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgy;"
    )
    Node tail;
    @ObfuscatedName("e")
    int index;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgy;"
    )
    Node head;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lgr;"
    )
    IterableHashTable table;

    @ObfuscatedSignature(
            signature = "(Lgr;)V"
    )
    HashTableIterator(IterableHashTable var1) {
        this.head = null;
        this.table = var1;
        this.method1760();
    }

    @ObfuscatedName("m")
    void method1760() {
        this.tail = this.table.buckets[0].next;
        this.index = 1;
        this.head = null;
    }

    public boolean hasNext() {
        if (this.table.buckets[this.index - 1] != this.tail) {
            return true;
        } else {
            while (this.index < this.table.size) {
                if (this.table.buckets[this.index++].next != this.table.buckets[this.index - 1]) {
                    this.tail = this.table.buckets[this.index - 1].next;
                    return true;
                }

                this.tail = this.table.buckets[this.index - 1];
            }

            return false;
        }
    }

    public Object next() {
        Node var1;
        if (this.table.buckets[this.index - 1] != this.tail) {
            var1 = this.tail;
            this.tail = var1.next;
            this.head = var1;
            return var1;
        } else {
            do {
                if (this.index >= this.table.size) {
                    return null;
                }

                var1 = this.table.buckets[this.index++].next;
            } while (var1 == this.table.buckets[this.index - 1]);

            this.tail = var1.next;
            this.head = var1;
            return var1;
        }
    }

    public void remove() {
        this.head.method6469();
        this.head = null;
    }
}
