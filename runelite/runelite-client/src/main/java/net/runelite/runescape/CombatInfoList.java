package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSCombatInfoList;
import net.runelite.rs.api.RSNode;

import java.util.Iterator;

@ObfuscatedName("gb")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable, RSCombatInfoList {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgy;"
    )
    Node current;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lgy;"
    )
    Node node;

    public CombatInfoList() {
        this.node = new Node();
        this.node.next = this.node;
        this.node.previous = this.node;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lgy;)V"
    )
    public void method4348(Node var1) {
        if (var1.previous != null) {
            var1.method6469();
        }

        var1.previous = this.node.previous;
        var1.next = this.node;
        var1.previous.next = var1;
        var1.next.previous = var1;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgy;)V"
    )
    public void method4325(Node var1) {
        if (var1.previous != null) {
            var1.method6469();
        }

        var1.previous = this.node;
        var1.next = this.node.next;
        var1.previous.next = var1;
        var1.next.previous = var1;
    }

    @ObfuscatedName("m")
    public boolean method4328() {
        return this.node.next == this.node;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "()Lgy;"
    )
    public Node method4327() {
        Node var1 = this.current;
        if (var1 == this.node) {
            this.current = null;
            return null;
        } else {
            this.current = var1.next;
            return var1;
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "()Lgy;"
    )
    public Node method4329() {
        return this.method4323((Node) null);
    }

    public Iterator iterator() {
        return new class289(this);
    }

    public RSNode getNode() {
        return this.node;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(Lgy;)Lgy;"
    )
    Node method4323(Node var1) {
        Node var2;
        if (var1 == null) {
            var2 = this.node.next;
        } else {
            var2 = var1;
        }

        if (var2 == this.node) {
            this.current = null;
            return null;
        } else {
            this.current = var2.next;
            return var2;
        }
    }

    @ObfuscatedName("g")
    public void method4346() {
        while (this.node.next != this.node) {
            this.node.next.method6469();
        }

    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgy;Lgy;)V"
    )
    public static void method4324(Node var0, Node var1) {
        if (var0.previous != null) {
            var0.method6469();
        }

        var0.previous = var1;
        var0.next = var1.next;
        var0.previous.next = var0;
        var0.next.previous = var0;
    }
}
