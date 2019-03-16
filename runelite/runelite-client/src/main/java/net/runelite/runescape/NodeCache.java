package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSCacheableNode;
import net.runelite.rs.api.RSNodeCache;

@ObfuscatedName("gv")
@Implements("NodeCache")
public final class NodeCache implements RSNodeCache {
    @ObfuscatedName("r")
    int capacity;
    @ObfuscatedName("e")
    int remainingCapacity;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lgq;"
    )
    HashTable table;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Lgf;"
    )
    Node2LinkedList list;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lhy;"
    )
    CacheableNode field2481;

    public NodeCache(int var1) {
        this.field2481 = new CacheableNode();
        this.list = new Node2LinkedList();
        this.capacity = var1;
        this.remainingCapacity = var1;

        int var2;
        for (var2 = 1; var2 + var2 < var1; var2 += var2) {
            ;
        }

        this.table = new HashTable(var2);
    }

    @ObfuscatedName("r")
    public void method950(long var1) {
        CacheableNode var3 = (CacheableNode) this.table.method380(var1);
        if (var3 != null) {
            var3.method6469();
            var3.method419();
            ++this.remainingCapacity;
        }

    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lhy;J)V"
    )
    public void method957(CacheableNode var1, long var2) {
        if (this.remainingCapacity == 0) {
            CacheableNode var4 = this.list.method2512();
            var4.method6469();
            var4.method419();
            if (var4 == this.field2481) {
                var4 = this.list.method2512();
                var4.method6469();
                var4.method419();
            }
        } else {
            --this.remainingCapacity;
        }

        this.table.method382(var1, var2);
        this.list.method2509(var1);
    }

    @ObfuscatedName("q")
    public void method952() {
        this.list.method2508();
        this.table.method383();
        this.field2481 = new CacheableNode();
        this.remainingCapacity = this.capacity;
    }

    public void setCapacity(int var1) {
        this.capacity = var1;
    }

    public void setRemainingCapacity(int var1) {
        this.remainingCapacity = var1;
    }

    public RSCacheableNode get(long var1) {
        return this.method951(var1);
    }

    public void reset() {
        this.method952();
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(J)Lhy;"
    )
    public CacheableNode method951(long var1) {
        CacheableNode var3 = (CacheableNode) this.table.method380(var1);
        if (var3 != null) {
            this.list.method2509(var3);
        }

        return var3;
    }
}
