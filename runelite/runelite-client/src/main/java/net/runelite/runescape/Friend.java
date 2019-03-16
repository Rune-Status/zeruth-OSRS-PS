package net.runelite.runescape;

import net.runelite.mapping.*;
import net.runelite.rs.api.RSFriend;
import net.runelite.rs.api.RSName;

@ObfuscatedName("ky")
@Implements("Friend")
public class Friend extends ChatPlayer implements RSFriend {
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -1665373209
    )
    static int field3725;
    @ObfuscatedName("r")
    boolean field3724;
    @ObfuscatedName("g")
    boolean field3723;

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            signature = "(Ljr;I)I",
            garbageValue = "889054617"
    )
    public int vmethod2733(Nameable var1) {
        return this.method2732((Friend) var1);
    }

    @Export("compareTo")
    public int compareTo(Object var1) {
        return this.method2732((Friend) var1);
    }

    @Export("getName")
    public String getName() {
        return this.getRsName().getName();
    }

    @Export("getPrevName")
    public String getPrevName() {
        RSName var1 = this.getRsPrevName();
        return var1 == null ? null : var1.getName();
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lky;I)I",
            garbageValue = "1165791195"
    )
    int method2732(Friend var1) {
        return super.world == client.world && client.world != var1.world ? -1 : (client.world == var1.world && super.world != client.world ? 1 : (super.world != 0 && var1.world == 0 ? -1 : (var1.world != 0 && super.world == 0 ? 1 : (this.field3723 && !var1.field3723 ? -1 : (!this.field3723 && var1.field3723 ? 1 : (this.field3724 && !var1.field3724 ? -1 : (!this.field3724 && var1.field3724 ? 1 : (super.world != 0 ? super.field3706 - var1.field3706 : var1.field3706 - super.field3706))))))));
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "-1048301153"
    )
    public static int method2731(int var0) {
        return MapLabel.method5553(class195.field1714[var0]);
    }
}
