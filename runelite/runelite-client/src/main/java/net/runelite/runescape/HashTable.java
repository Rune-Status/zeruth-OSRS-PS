package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSHashTable;
import net.runelite.rs.api.RSNode;

import java.util.ArrayList;
import java.util.Collection;

@ObfuscatedName("gq")
@Implements("HashTable")
public final class HashTable implements RSHashTable {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "[Lgy;"
    )
    Node[] buckets;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lgy;"
    )
    Node currentGet;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgy;"
    )
    Node current;
    @ObfuscatedName("c")
    int index;
    @ObfuscatedName("g")
    int size;

    public HashTable(int var1) {
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
    public void method382(Node var1, long var2) {
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
    void method383() {
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

        this.currentGet = null;
        this.current = null;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "()Lgy;"
    )
    public Node method391() {
        this.index = 0;
        return this.method385();
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "()Lgy;"
    )
    public Node method385() {
        Node var1;
        if (this.index > 0 && this.buckets[this.index - 1] != this.current) {
            var1 = this.current;
            this.current = var1.next;
            return var1;
        } else {
            do {
                if (this.index >= this.size) {
                    return null;
                }

                var1 = this.buckets[this.index++].next;
            } while (var1 == this.buckets[this.index - 1]);

            this.current = var1.next;
            return var1;
        }
    }

    public RSNode[] getBuckets() {
        return this.buckets;
    }

    public Collection getNodes() {
        ArrayList var1 = new ArrayList();
        RSNode[] var2 = this.getBuckets();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            RSNode var4 = var2[var3];

            for (net.runelite.api.Node var5 = var4.getNext(); var5 != var4; var5 = var5.getNext()) {
                var1.add(var5);
            }
        }

        return var1;
    }

    public int getSize() {
        return this.size;
    }

    public RSNode get(long var1) {
        return this.method380(var1);
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(J)Lgy;"
    )
    public Node method380(long var1) {
        Node var3 = this.buckets[(int) (var1 & (long) (this.size - 1))];

        for (this.currentGet = var3.next; var3 != this.currentGet; this.currentGet = this.currentGet.next) {
            if (this.currentGet.hash == var1) {
                Node var4 = this.currentGet;
                this.currentGet = this.currentGet.next;
                return var4;
            }
        }

        this.currentGet = null;
        return null;
    }
}
