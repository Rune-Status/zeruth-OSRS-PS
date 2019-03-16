package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSName;

@ObfuscatedName("kg")
@Implements("Name")
public class Name implements Comparable, RSName {
    @ObfuscatedName("r")
    String cleanName;
    @ObfuscatedName("g")
    String name;

    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;Llq;)V"
    )
    public Name(String var1, JagexLoginType var2) {
        this.name = var1;
        this.cleanName = ComponentType.method268(var1, var2);
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "1276637347"
    )
    public boolean method4714() {
        return this.cleanName != null;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lkg;I)I",
            garbageValue = "1984606353"
    )
    public int method4717(Name var1) {
        return this.cleanName == null ? (var1.cleanName == null ? 0 : 1) : (var1.cleanName == null ? -1 : this.cleanName.compareTo(var1.cleanName));
    }

    public boolean equals(Object var1) {
        if (var1 instanceof Name) {
            Name var2 = (Name) var1;
            return this.cleanName == null ? var2.cleanName == null : (var2.cleanName == null ? false : (this.hashCode() != var2.hashCode() ? false : this.cleanName.equals(var2.cleanName)));
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.cleanName == null ? 0 : this.cleanName.hashCode();
    }

    public String toString() {
        return this.method4713();
    }

    public int compareTo(Object var1) {
        return this.method4717((Name) var1);
    }

    public String getName() {
        return this.name;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)Ljava/lang/String;",
            garbageValue = "-165222639"
    )
    public String method4713() {
        return this.name;
    }
}
