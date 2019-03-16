package net.runelite.runescape;

import net.runelite.api.events.NameableNameChanged;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSName;
import net.runelite.rs.api.RSNameable;

@ObfuscatedName("jr")
@Implements("Nameable")
public class Nameable implements Comparable, RSNameable {
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lkg;"
    )
    Name name;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lkg;"
    )
    Name prevName;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            signature = "(I)Ljava/lang/String;",
            garbageValue = "-678646739"
    )
    public String method2073() {
        return this.name == null ? "" : this.name.method4713();
    }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            signature = "(Ljr;I)I",
            garbageValue = "889054617"
    )
    public int vmethod2733(Nameable var1) {
        return this.name.method4717(var1.name);
    }

    @ObfuscatedName("o")
    @ObfuscatedSignature(
            signature = "(B)Lkg;",
            garbageValue = "-2"
    )
    public Name method2067() {
        return this.name;
    }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            signature = "(I)Ljava/lang/String;",
            garbageValue = "-417976815"
    )
    public String method2069() {
        return this.prevName == null ? "" : this.prevName.method4713();
    }

    public RSName getRsPrevName() {
        return this.prevName;
    }

    public RSName getRsName() {
        return this.name;
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1"
    )
    public void onPrevNameChanged(int var1) {
        NameableNameChanged var2 = new NameableNameChanged(this);
        class166.clientInstance.getCallbacks().post(var2);
    }

    public int compareTo(Object var1) {
        return this.vmethod2733((Nameable) var1);
    }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            signature = "(Lkg;Lkg;B)V",
            garbageValue = "0"
    )
    void method2070(Name var1, Name var2) {
        if (var1 == null) {
            throw new NullPointerException();
        } else {
            this.name = var1;
            this.prevName = var2;
            this.onPrevNameChanged(-1);
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
            garbageValue = "463310943"
    )
    public static String method2083(CharSequence var0) {
        String var1 = VarPlayerType.method5549(Coordinates.method2470(var0));
        if (var1 == null) {
            var1 = "";
        }

        return var1;
    }
}
