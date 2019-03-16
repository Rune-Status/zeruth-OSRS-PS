package net.runelite.runescape;

import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSVarcs;

import java.io.EOFException;

@ObfuscatedName("cd")
@Implements("Varcs")
public class Varcs implements RSVarcs {
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = 1137197725
    )
    static int field1243;
    @ObfuscatedName("l")
    String[] varCStrings;
    @ObfuscatedName("e")
    boolean[] varcSerials;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            longValue = 6962625854855383849L
    )
    long field1245;
    @ObfuscatedName("q")
    boolean[] varcstringSerials;
    @ObfuscatedName("b")
    boolean changed;
    @ObfuscatedName("c")
    int[] varCInts;

    Varcs() {
        this.changed = false;
        this.varCInts = new int[class98.configs.method1574(19)];
        this.onVarCIntChanged(-1);
        this.varCStrings = new String[class98.configs.method1574(15)];
        this.onVarCStrChanged(-1);
        this.varcSerials = new boolean[this.varCInts.length];

        int var1;
        for (var1 = 0; var1 < this.varCInts.length; ++var1) {
            VarClientType var2 = Js5.method2679(var1);
            this.varcSerials[var1] = var2.serialize;
        }

        this.varcstringSerials = new boolean[this.varCStrings.length];

        for (var1 = 0; var1 < this.varCStrings.length; ++var1) {
            VarClientStringType var3 = WorldComparator.method6472(var1);
            this.varcstringSerials[var1] = var3.serialize;
        }

        for (var1 = 0; var1 < this.varCInts.length; ++var1) {
            this.varCInts[var1] = -1;
            this.onVarCIntChanged(var1);
        }

        this.method4738();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)I",
            garbageValue = "-193547956"
    )
    int method4736(int var1) {
        return this.varCInts[var1];
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(ILjava/lang/String;B)V",
            garbageValue = "39"
    )
    void method4751(int var1, String var2) {
        this.varCStrings[var1] = var2;
        this.onVarCStrChanged(var1);
        if (this.varcstringSerials[var1]) {
            this.changed = true;
        }

    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(II)Ljava/lang/String;",
            garbageValue = "1425514174"
    )
    String method4734(int var1) {
        return this.varCStrings[var1];
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-639739435"
    )
    void method4738() {
        FileOnDisk var1 = this.method4740(false);

        label204:
        {
            try {
                byte[] var2 = new byte[(int) var1.method148()];

                int var4;
                for (int var3 = 0; var3 < var2.length; var3 += var4) {
                    var4 = var1.method149(var2, var3, var2.length - var3);
                    if (var4 == -1) {
                        throw new EOFException();
                    }
                }

                Packet var13 = new Packet(var2);
                if (var13.payload.length - var13.offset < 1) {
                    return;
                }

                int var14 = var13.readUnsignedByte();
                if (var14 >= 0 && var14 <= 1) {
                    int var15 = var13.readUnsignedShort();

                    int var7;
                    int var8;
                    int var9;
                    for (var7 = 0; var7 < var15; ++var7) {
                        var8 = var13.readUnsignedShort();
                        var9 = var13.getInt();
                        if (this.varcSerials[var8]) {
                            this.varCInts[var8] = var9;
                            this.onVarCIntChanged(var8);
                        }
                    }

                    var7 = var13.readUnsignedShort();
                    var8 = 0;

                    while (true) {
                        if (var8 >= var7) {
                            break label204;
                        }

                        var9 = var13.readUnsignedShort();
                        String var10 = var13.readString();
                        if (this.varcstringSerials[var9]) {
                            this.varCStrings[var9] = var10;
                            this.onVarCStrChanged(var9);
                        }

                        ++var8;
                    }
                }
            } catch (Exception var24) {
                break label204;
            } finally {
                try {
                    var1.method146();
                } catch (Exception var23) {
                    ;
                }

            }

            return;
        }

        this.changed = false;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-788552448"
    )
    void method4741() {
        FileOnDisk var1 = this.method4740(true);

        try {
            int var2 = 3;
            int var3 = 0;

            int var4;
            for (var4 = 0; var4 < this.varCInts.length; ++var4) {
                if (this.varcSerials[var4] && this.varCInts[var4] != -1) {
                    var2 += 6;
                    ++var3;
                }
            }

            var2 += 2;
            var4 = 0;

            for (int var5 = 0; var5 < this.varCStrings.length; ++var5) {
                if (this.varcstringSerials[var5] && this.varCStrings[var5] != null) {
                    var2 += 2 + AbstractSoundSystem.method338(this.varCStrings[var5]);
                    ++var4;
                }
            }

            Packet var9 = new Packet(var2);
            var9.putByte(1);
            var9.putShort(var3);

            int var6;
            for (var6 = 0; var6 < this.varCInts.length; ++var6) {
                if (this.varcSerials[var6] && this.varCInts[var6] != -1) {
                    var9.putShort(var6);
                    var9.method6230(this.varCInts[var6]);
                }
            }

            var9.putShort(var4);

            for (var6 = 0; var6 < this.varCStrings.length; ++var6) {
                if (this.varcstringSerials[var6] && this.varCStrings[var6] != null) {
                    var9.putShort(var6);
                    var9.method6198(this.varCStrings[var6]);
                }
            }

            var1.method145(var9.payload, 0, var9.offset);
        } catch (Exception var17) {
            ;
        } finally {
            try {
                var1.method146();
            } catch (Exception var16) {
                ;
            }

        }

        this.changed = false;
        this.field1245 = Tile.method4297();
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1414439942"
    )
    void method4753() {
        int var1;
        for (var1 = 0; var1 < this.varCInts.length; ++var1) {
            if (!this.varcSerials[var1]) {
                this.varCInts[var1] = -1;
                this.onVarCIntChanged(var1);
            }
        }

        for (var1 = 0; var1 < this.varCStrings.length; ++var1) {
            if (!this.varcstringSerials[var1]) {
                this.varCStrings[var1] = null;
                this.onVarCStrChanged(var1);
            }
        }

    }

    public void onVarCStrChanged(int var1) {
        class166.clientInstance.getCallbacks().post(new VarClientStrChanged(var1));
    }

    public void onVarCIntChanged(int var1) {
        class166.clientInstance.getCallbacks().post(new VarClientIntChanged(var1));
    }

    public int[] getIntVarcs() {
        return this.varCInts;
    }

    public String[] getStrVarcs() {
        return this.varCStrings;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(ZI)Ldn;",
            garbageValue = "-1669314567"
    )
    FileOnDisk method4740(boolean var1) {
        return class70.method1076("2", client.field646.name, var1);
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1253575751"
    )
    void method4735() {
        if (this.changed && this.field1245 < Tile.method4297() - 60000L) {
            this.method4741();
        }

    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "1"
    )
    boolean method4744() {
        return this.changed;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(III)V",
            garbageValue = "-1482826901"
    )
    void method4759(int var1, int var2) {
        this.varCInts[var1] = var2;
        this.onVarCIntChanged(var1);
        if (this.varcSerials[var1]) {
            this.changed = true;
        }

    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(II)Ljw;",
            garbageValue = "-205103429"
    )
    public static ObjType method4770(int var0) {
        ObjType var1 = (ObjType) ObjType.items.method951((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = ObjType.item_ref.method1516(10, var0, 1789634852);
            var1 = new ObjType();
            var1.id = var0;
            if (var2 != null) {
                var1.method6358(new Packet(var2));
            }

            var1.method6305();
            if (var1.certTemplate != -1) {
                var1.method6308(method4770(var1.certTemplate), method4770(var1.certLink));
            }

            if (var1.boughtTemplate != -1) {
                var1.method6321(method4770(var1.boughtTemplate), method4770(var1.boughtLink));
            }

            if (var1.placeholderTemplate != -1) {
                var1.method6310(method4770(var1.placeholderTemplate), method4770(var1.placeholderLink));
            }

            if (!PlayerComposition.isMembersWorld && var1.members) {
                var1.name = "Members object";
                var1.stockmarket = false;
                var1.ops = null;
                var1.iops = null;
                var1.shiftClickIndex = -1;
                var1.team = 0;
                if (var1.params != null) {
                    boolean var3 = false;

                    for (Node var4 = var1.params.method2751(); var4 != null; var4 = var1.params.method2752()) {
                        ParamType var5 = class134.method2203((int) var4.hash);
                        if (var5.autoDisable) {
                            var4.method6469();
                        } else {
                            var3 = true;
                        }
                    }

                    if (!var3) {
                        var1.params = null;
                    }
                }
            }

            ObjType.items.method957(var1, (long) var0);
            return var1;
        }
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(CII)I",
            garbageValue = "324290877"
    )
    static int method4762(char var0, int var1) {
        int var2 = var0 << 4;
        if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
            var0 = Character.toLowerCase(var0);
            var2 = (var0 << 4) + 1;
        }

        return var2;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Liu;I)V",
            garbageValue = "-604810430"
    )
    public static void method4769(Js5Index var0) {
        Enum.EnumDefinition_indexCache = var0;
    }
}
