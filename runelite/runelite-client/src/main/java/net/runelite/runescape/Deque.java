package net.runelite.runescape;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDeque;
import net.runelite.rs.api.RSNode;

@ObfuscatedName("gi")
@Implements("Deque")
public class Deque implements RSDeque {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lgy;"
    )
    @Export("current")
    Node current;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lgy;"
    )
    @Export("head")
    public Node head;

    public Deque() {
        this.head = new Node();
        this.head.next = this.head;
        this.head.previous = this.head;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lgy;)V"
    )
    public void method4351(Node var1) {
        if (var1.previous != null) {
            var1.method6469();
        }

        var1.previous = this.head.previous;
        var1.next = this.head;
        var1.previous.next = var1;
        var1.next.previous = var1;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgy;)V"
    )
    public void method4352(Node var1) {
        if (var1.previous != null) {
            var1.method6469();
        }

        var1.previous = this.head;
        var1.next = this.head.next;
        var1.previous.next = var1;
        var1.next.previous = var1;
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "()Lgy;"
    )
    public Node method4349() {
        Node var1 = this.head.previous;
        if (var1 == this.head) {
            this.current = null;
            return null;
        } else {
            this.current = var1.previous;
            return var1;
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "()Lgy;"
    )
    public Node method4373() {
        Node var1 = this.head.next;
        if (var1 == this.head) {
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
    public Node method4354() {
        Node var1 = this.head.next;
        if (var1 == this.head) {
            return null;
        } else {
            var1.method6469();
            return var1;
        }
    }

    public RSNode getHead() {
        return this.head;
    }

    public RSNode getCurrent() {
        return this.current;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "()Lgy;"
    )
    public Node method4355() {
        Node var1 = this.head.previous;
        if (var1 == this.head) {
            return null;
        } else {
            var1.method6469();
            return var1;
        }
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "()Lgy;"
    )
    public Node method4358() {
        Node var1 = this.current;
        if (var1 == this.head) {
            this.current = null;
            return null;
        } else {
            this.current = var1.next;
            return var1;
        }
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "()Lgy;"
    )
    public Node method4370() {
        Node var1 = this.current;
        if (var1 == this.head) {
            this.current = null;
            return null;
        } else {
            this.current = var1.previous;
            return var1;
        }
    }

    @ObfuscatedName("g")
    public void method4350() {
        while (true) {
            Node var1 = this.head.next;
            if (var1 == this.head) {
                this.current = null;
                return;
            }

            var1.method6469();
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Lgy;Lgy;)V"
    )
    public static void method4382(Node var0, Node var1) {
        if (var0.previous != null) {
            var0.method6469();
        }

        var0.previous = var1.previous;
        var0.next = var1;
        var0.previous.next = var0;
        var0.next.previous = var0;
    }
}
