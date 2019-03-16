package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSName;
import net.runelite.rs.api.RSNameable;
import net.runelite.rs.api.RSNameableContainer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

@ObfuscatedName("kd")
@Implements("NameableContainer")
public abstract class NameableContainer implements RSNameableContainer {
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "[Ljr;"
    )
    Nameable[] nameables;
    @ObfuscatedName("w")
    HashMap field3702;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -1118297505
    )
    final int field3704;
    @ObfuscatedName("b")
    HashMap field3701;
    @ObfuscatedName("n")
    Comparator field3698;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -739955129
    )
    int count;

    NameableContainer(int var1) {
        this.count = 0;
        this.field3698 = null;
        this.field3704 = var1;
        this.nameables = this.vmethod5255(var1);
        this.field3701 = new HashMap(var1 / 8);
        this.field3702 = new HashMap(var1 / 8);
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "1"
    )
    public int method5225() {
        return this.count;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)[Ljr;",
            garbageValue = "-1957564969"
    )
    abstract Nameable[] vmethod5255(int var1);

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            signature = "(Lkg;I)Ljr;",
            garbageValue = "1175028138"
    )
    Nameable method5302(Name var1) {
        return this.method5233(var1, (Name) null);
    }

    @ObfuscatedName("ae")
    @ObfuscatedSignature(
            signature = "(Ljr;Lkg;Lkg;I)V",
            garbageValue = "-998867252"
    )
    final void method5230(Nameable var1, Name var2, Name var3) {
        this.method5238(var1);
        var1.method2070(var2, var3);
        this.method5227(var1);
    }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            signature = "(Lkg;I)Ljr;",
            garbageValue = "2037062881"
    )
    public Nameable method5228(Name var1) {
        Nameable var2 = this.method5229(var1);
        return var2 != null ? var2 : this.method5268(var1);
    }

    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            signature = "(Ljr;B)V",
            garbageValue = "1"
    )
    final void method5227(Nameable var1) {
        this.field3701.put(var1.name, var1);
        if (var1.prevName != null) {
            Nameable var2 = (Nameable) this.field3702.put(var1.prevName, var1);
            if (var2 != null && var2 != var1) {
                var2.prevName = null;
                var2.onPrevNameChanged(-1);
            }
        }

    }

    @ObfuscatedName("aj")
    @ObfuscatedSignature(
            signature = "(Ljr;I)V",
            garbageValue = "1684099917"
    )
    final void method5299(Nameable var1) {
        this.nameables[++this.count - 1] = var1;
    }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            signature = "(S)V",
            garbageValue = "710"
    )
    public final void method5240() {
        if (this.field3698 == null) {
            Arrays.sort(this.nameables, 0, this.count);
        } else {
            Arrays.sort(this.nameables, 0, this.count, this.field3698);
        }

    }

    @ObfuscatedName("o")
    @ObfuscatedSignature(
            signature = "(Ljr;I)V",
            garbageValue = "-458036019"
    )
    final void method5280(Nameable var1) {
        int var2 = this.method5237(var1);
        if (var2 != -1) {
            this.method5241(var2);
            this.method5238(var1);
        }
    }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "1"
    )
    public boolean method5226() {
        return this.field3704 == this.count;
    }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            signature = "(Lkg;B)Z",
            garbageValue = "40"
    )
    public boolean method5247(Name var1) {
        return !var1.method4714() ? false : (this.field3701.containsKey(var1) ? true : this.field3702.containsKey(var1));
    }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            signature = "(Lkg;Lkg;B)Ljr;",
            garbageValue = "-12"
    )
    Nameable method5233(Name var1, Name var2) {
        if (this.method5229(var1) != null) {
            throw new IllegalStateException();
        } else {
            Nameable var3 = this.vmethod5242();
            var3.method2070(var1, var2);
            this.method5299(var3);
            this.method5227(var3);
            return var3;
        }
    }

    public int getCount() {
        return this.count;
    }

    public RSNameable[] getNameables() {
        return this.nameables;
    }

    public boolean isMember(RSName var1) {
        return this.method5247((Name) var1);
    }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            signature = "(Ljava/util/Comparator;I)V",
            garbageValue = "1672281426"
    )
    public final void method5245(Comparator var1) {
        if (this.field3698 == null) {
            this.field3698 = var1;
        } else if (this.field3698 instanceof class127) {
            ((class127) this.field3698).method2137(var1);
        }

    }

    @ObfuscatedName("y")
    @ObfuscatedSignature(
            signature = "(Lkg;B)Ljr;",
            garbageValue = "-1"
    )
    Nameable method5268(Name var1) {
        return !var1.method4714() ? null : (Nameable) this.field3702.get(var1);
    }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            signature = "(II)Ljr;",
            garbageValue = "-2005277078"
    )
    public final Nameable method5234(int var1) {
        if (var1 >= 0 && var1 < this.count) {
            return this.nameables[var1];
        } else {
            throw new ArrayIndexOutOfBoundsException(var1);
        }
    }

    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-88"
    )
    public final void method5244() {
        this.field3698 = null;
    }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "(Lkg;I)Ljr;",
            garbageValue = "-266772152"
    )
    Nameable method5229(Name var1) {
        return !var1.method4714() ? null : (Nameable) this.field3701.get(var1);
    }

    @ObfuscatedName("az")
    @ObfuscatedSignature(
            signature = "(Ljr;I)V",
            garbageValue = "289313210"
    )
    final void method5238(Nameable var1) {
        if (this.field3701.remove(var1.name) == null) {
            throw new IllegalStateException();
        } else {
            if (var1.prevName != null) {
                this.field3702.remove(var1.prevName);
            }

        }
    }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            signature = "(Ljr;B)I",
            garbageValue = "-24"
    )
    final int method5237(Nameable var1) {
        for (int var2 = 0; var2 < this.count; ++var2) {
            if (this.nameables[var2] == var1) {
                return var2;
            }
        }

        return -1;
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-591560482"
    )
    public void method5224() {
        this.count = 0;
        Arrays.fill(this.nameables, (Object) null);
        this.field3701.clear();
        this.field3702.clear();
    }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            signature = "(Lkg;S)Z",
            garbageValue = "11715"
    )
    public final boolean method5231(Name var1) {
        Nameable var2 = this.method5229(var1);
        if (var2 == null) {
            return false;
        } else {
            this.method5280(var2);
            return true;
        }
    }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-55098367"
    )
    final void method5241(int var1) {
        --this.count;
        if (var1 < this.count) {
            System.arraycopy(this.nameables, var1 + 1, this.nameables, var1, this.count - var1);
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)Ljr;",
            garbageValue = "-1755896640"
    )
    abstract Nameable vmethod5242();
}
