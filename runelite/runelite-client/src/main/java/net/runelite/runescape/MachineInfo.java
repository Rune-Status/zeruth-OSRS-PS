package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lr")
@Implements("MachineInfo")
public class MachineInfo extends Node {
    @ObfuscatedName("ak")
    @ObfuscatedGetter(
            intValue = 1650175933
    )
    int field3917;
    @ObfuscatedName("aq")
    @ObfuscatedGetter(
            intValue = -1615087425
    )
    int field3925;
    @ObfuscatedName("bs")
    @ObfuscatedGetter(
            intValue = 1261326391
    )
    int field3927;
    @ObfuscatedName("bz")
    String field3926;
    @ObfuscatedName("au")
    @ObfuscatedGetter(
            intValue = 1060422817
    )
    int field3900;
    @ObfuscatedName("ba")
    String field3928;
    @ObfuscatedName("ag")
    @ObfuscatedGetter(
            intValue = -503252367
    )
    int osVersionType;
    @ObfuscatedName("aj")
    boolean os64Bit;
    @ObfuscatedName("bp")
    @ObfuscatedGetter(
            intValue = -1973873973
    )
    int field3930;
    @ObfuscatedName("ai")
    @ObfuscatedGetter(
            intValue = 1902827613
    )
    int maxMemoryMB;
    @ObfuscatedName("av")
    @ObfuscatedGetter(
            intValue = -1466849513
    )
    int field3921;
    @ObfuscatedName("ay")
    String field3920;
    @ObfuscatedName("ah")
    String field3909;
    @ObfuscatedName("bv")
    String field3912;
    @ObfuscatedName("at")
    @ObfuscatedGetter(
            intValue = 723452171
    )
    int javaVersionMinor;
    @ObfuscatedName("am")
    String field3919;
    @ObfuscatedName("as")
    @ObfuscatedGetter(
            intValue = 867973029
    )
    int javaVersionPatch;
    @ObfuscatedName("ar")
    @ObfuscatedGetter(
            intValue = -1564711793
    )
    int javaVersionMajor;
    @ObfuscatedName("ad")
    @ObfuscatedGetter(
            intValue = 474580335
    )
    int field3916;
    @ObfuscatedName("aa")
    boolean field3914;
    @ObfuscatedName("az")
    @ObfuscatedGetter(
            intValue = -1201024477
    )
    int osType;
    @ObfuscatedName("ap")
    String field3922;
    @ObfuscatedName("bi")
    int[] field3929;
    @ObfuscatedName("ab")
    @ObfuscatedGetter(
            intValue = 543336245
    )
    int javaVendorType;
    @ObfuscatedName("ao")
    @ObfuscatedGetter(
            intValue = 2064391445
    )
    int field3923;

    MachineInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25) {
        this.field3929 = new int[3];
        this.osType = var1;
        this.os64Bit = var2;
        this.osVersionType = var3;
        this.javaVendorType = var4;
        this.javaVersionMajor = var5;
        this.javaVersionMinor = var6;
        this.javaVersionPatch = var7;
        this.field3914 = var8;
        this.maxMemoryMB = var9;
        this.field3916 = var10;
        this.field3917 = var11;
        this.field3923 = var12;
        this.field3919 = var13;
        this.field3920 = var14;
        this.field3909 = var15;
        this.field3922 = var16;
        this.field3921 = var17;
        this.field3900 = var18;
        this.field3925 = var19;
        this.field3927 = var20;
        this.field3926 = var21;
        this.field3928 = var22;
        this.field3929 = var23;
        this.field3930 = var24;
        this.field3912 = var25;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "767632853"
    )
    public int method2131() {
        byte var1 = 38;
        String var4 = this.field3919;
        int var3 = var4.length() + 2;
        int var23 = var1 + var3;
        String var7 = this.field3920;
        int var6 = var7.length() + 2;
        var23 += var6;
        String var10 = this.field3909;
        int var9 = var10.length() + 2;
        var23 += var9;
        String var13 = this.field3922;
        int var12 = var13.length() + 2;
        var23 += var12;
        String var16 = this.field3926;
        int var15 = var16.length() + 2;
        var23 += var15;
        String var19 = this.field3928;
        int var18 = var19.length() + 2;
        var23 += var18;
        String var22 = this.field3912;
        int var21 = var22.length() + 2;
        var23 += var21;
        return var23;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "1328377164"
    )
    public void method2136(Packet var1) {
        var1.putByte(7);
        var1.putByte(this.osType);
        var1.putByte(this.os64Bit ? 1 : 0);
        var1.putByte(this.osVersionType);
        var1.putByte(this.javaVendorType);
        var1.putByte(this.javaVersionMajor);
        var1.putByte(this.javaVersionMinor);
        var1.putByte(this.javaVersionPatch);
        var1.putByte(this.field3914 ? 1 : 0);
        var1.putShort(this.maxMemoryMB);
        var1.putByte(this.field3916);
        var1.method6064(this.field3917);
        var1.putShort(this.field3923);
        var1.method6265(this.field3919);
        var1.method6265(this.field3920);
        var1.method6265(this.field3909);
        var1.method6265(this.field3922);
        var1.putByte(this.field3900);
        var1.putShort(this.field3921);
        var1.method6265(this.field3926);
        var1.method6265(this.field3928);
        var1.putByte(this.field3925);
        var1.putByte(this.field3927);

        for (int var2 = 0; var2 < this.field3929.length; ++var2) {
            var1.method6230(this.field3929[var2]);
        }

        var1.method6230(this.field3930);
        var1.method6265(this.field3912);
    }
}
