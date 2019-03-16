package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClanMemberManager;

@ObfuscatedName("ko")
@Implements("ClanMemberManager")
public class ClanMemberManager extends NameableContainer implements RSClanMemberManager {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    final JagexLoginType field3727;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lkh;"
    )
    final class236 field3728;
    @ObfuscatedName("m")
    public byte field3731;
    @ObfuscatedName("p")
    public String field3730;
    @ObfuscatedName("i")
    public String field3726;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = 924566637
    )
    public int field3732;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = -1580090135
    )
    int field3729;

    @ObfuscatedSignature(
            signature = "(Llq;Lkh;)V"
    )
    public ClanMemberManager(JagexLoginType var1, class236 var2) {
        super(100);
        this.field3726 = null;
        this.field3730 = null;
        this.field3729 = 1;
        this.field3727 = var1;
        this.field3728 = var2;
    }

    @ObfuscatedName("ck")
    @ObfuscatedSignature(
            signature = "(Ljm;B)V",
            garbageValue = "14"
    )
    final void method4645(ClanMember var1) {
        if (var1.method2067().equals(this.field3728.vmethod4584())) {
            this.field3732 = var1.rank;
        }

    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1219113165"
    )
    public final void method4636() {
        for (int var1 = 0; var1 < this.method5225(); ++var1) {
            ((ClanMember) this.method5234(var1)).method962();
        }

    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)[Ljr;",
            garbageValue = "-1957564969"
    )
    Nameable[] vmethod5255(int var1) {
        return new ClanMember[var1];
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)V",
            garbageValue = "-737489793"
    )
    final void method4639(String var1) {
        this.field3726 = Nameable.method2083(var1);
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(Lgl;B)V",
            garbageValue = "0"
    )
    public final void method4642(Packet var1) {
        Name var2 = new Name(var1.readString(), this.field3727);
        int var3 = var1.readUnsignedShort();
        byte var4 = var1.method6240();
        boolean var5 = false;
        if (var4 == -128) {
            var5 = true;
        }

        ClanMember var6;
        if (var5) {
            if (this.method5225() == 0) {
                return;
            }

            var6 = (ClanMember) this.method5229(var2);
            if (var6 != null && var6.method793() == var3) {
                this.method5280(var6);
            }
        } else {
            var1.readString();
            var6 = (ClanMember) this.method5229(var2);
            if (var6 == null) {
                if (this.method5225() > super.field3704) {
                    return;
                }

                var6 = (ClanMember) this.method5302(var2);
            }

            var6.method794(var3, ++this.field3729 - 1);
            var6.rank = var4;
            this.method4645(var6);
        }

    }

    @ObfuscatedName("co")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-2054970382"
    )
    public final void method4644() {
        for (int var1 = 0; var1 < this.method5225(); ++var1) {
            ((ClanMember) this.method5234(var1)).method965();
        }

    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)V",
            garbageValue = "-48607896"
    )
    final void method4663(String var1) {
        this.field3730 = Nameable.method2083(var1);
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-1049135699"
    )
    public final void method4641(Packet var1) {
        this.method4663(var1.readString());
        long var2 = var1.method6084();
        this.method4639(GameSocket.method4295(var2));
        this.field3731 = var1.method6240();
        int var4 = var1.readUnsignedByte();
        if (var4 != 255) {
            this.method5224();

            for (int var5 = 0; var5 < var4; ++var5) {
                ClanMember var6 = (ClanMember) this.method5302(new Name(var1.readString(), this.field3727));
                int var7 = var1.readUnsignedShort();
                var6.method794(var7, ++this.field3729 - 1);
                var6.rank = var1.method6240();
                var1.readString();
                this.method4645(var6);
            }

        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)Ljr;",
            garbageValue = "-1755896640"
    )
    Nameable vmethod5242() {
        return new ClanMember();
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/CharSequence;IZI)Z",
            garbageValue = "-2145241596"
    )
    static boolean method4657(CharSequence var0, int var1, boolean var2) {
        if (var1 >= 2 && var1 <= 36) {
            boolean var3 = false;
            boolean var4 = false;
            int var5 = 0;
            int var6 = var0.length();

            for (int var7 = 0; var7 < var6; ++var7) {
                char var8 = var0.charAt(var7);
                if (var7 == 0) {
                    if (var8 == '-') {
                        var3 = true;
                        continue;
                    }

                    if (var8 == '+') {
                        continue;
                    }
                }

                int var10;
                if (var8 >= '0' && var8 <= '9') {
                    var10 = var8 - '0';
                } else if (var8 >= 'A' && var8 <= 'Z') {
                    var10 = var8 - '7';
                } else {
                    if (var8 < 'a' || var8 > 'z') {
                        return false;
                    }

                    var10 = var8 - 'W';
                }

                if (var10 >= var1) {
                    return false;
                }

                if (var3) {
                    var10 = -var10;
                }

                int var9 = var10 + var5 * var1;
                if (var9 / var1 != var5) {
                    return false;
                }

                var5 = var9;
                var4 = true;
            }

            return var4;
        } else {
            throw new IllegalArgumentException("");
        }
    }
}
