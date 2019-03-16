package net.runelite.runescape;

import net.runelite.mapping.*;

@ObfuscatedName("x")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
    @ObfuscatedName("cw")
    @Export("middleMouseMovesCamera")
    static boolean middleMouseMovesCamera;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -1072962457
    )
    int field130;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 2038208157
    )
    int field117;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 2136397627
    )
    int field118;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = 495568535
    )
    int field123;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -837057375
    )
    int field119;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = 1883922977
    )
    int field121;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = 1468726651
    )
    int field126;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -672017989
    )
    int field122;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = 1850323365
    )
    int field129;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -786046417
    )
    int field120;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = -26174179
    )
    int field124;
    @ObfuscatedName("d")
    @ObfuscatedGetter(
            intValue = 136906579
    )
    int field131;
    @ObfuscatedName("j")
    @ObfuscatedGetter(
            intValue = 1813525733
    )
    int field133;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1570746793
    )
    int field125;

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(IIIB)Z",
            garbageValue = "-81"
    )
    public boolean vmethod5812(int var1, int var2, int var3) {
        return var1 >= this.field125 && var1 < this.field117 + this.field125 ? var2 >= (this.field118 << 6) + (this.field122 << 3) && var2 <= (this.field118 << 6) + (this.field129 << 3) + 7 && var3 >= (this.field119 << 6) + (this.field123 << 3) && var3 <= (this.field119 << 6) + (this.field124 << 3) + 7 : false;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IIB)Z",
            garbageValue = "79"
    )
    public boolean vmethod5811(int var1, int var2) {
        return var1 >= (this.field120 << 6) + (this.field126 << 3) && var1 <= (this.field120 << 6) + (this.field131 << 3) + 7 && var2 >= (this.field130 << 6) + (this.field121 << 3) && var2 <= (this.field130 << 6) + (this.field133 << 3) + 7;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(IIII)[I",
            garbageValue = "-1381851995"
    )
    public int[] vmethod5814(int var1, int var2, int var3) {
        if (!this.vmethod5812(var1, var2, var3)) {
            return null;
        } else {
            int[] var4 = new int[]{this.field120 * 64 - this.field118 * 64 + var2 + (this.field126 * 8 - this.field122 * 8), var3 + (this.field130 * 64 - this.field119 * 64) + (this.field121 * 8 - this.field123 * 8)};
            return var4;
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-414697091"
    )
    void method1696() {
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IIB)Lhz;",
            garbageValue = "-126"
    )
    public Coordinates vmethod5817(int var1, int var2) {
        if (!this.vmethod5811(var1, var2)) {
            return null;
        } else {
            int var3 = this.field118 * 64 - this.field120 * 64 + (this.field122 * 8 - this.field126 * 8) + var1;
            int var4 = this.field119 * 64 - this.field130 * 64 + var2 + (this.field123 * 8 - this.field121 * 8);
            return new Coordinates(this.field125, var3, var4);
        }
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(Lgl;I)V",
            garbageValue = "-821481708"
    )
    public void vmethod5829(Packet var1) {
        this.field125 = var1.readUnsignedByte();
        this.field117 = var1.readUnsignedByte();
        this.field118 = var1.readUnsignedShort();
        this.field122 = var1.readUnsignedByte();
        this.field129 = var1.readUnsignedByte();
        this.field119 = var1.readUnsignedShort();
        this.field123 = var1.readUnsignedByte();
        this.field124 = var1.readUnsignedByte();
        this.field120 = var1.readUnsignedShort();
        this.field126 = var1.readUnsignedByte();
        this.field131 = var1.readUnsignedByte();
        this.field130 = var1.readUnsignedShort();
        this.field121 = var1.readUnsignedByte();
        this.field133 = var1.readUnsignedByte();
        this.method1696();
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lk;B)V",
            garbageValue = "-126"
    )
    public void vmethod5820(WorldMapData var1) {
        if (var1.minX > this.field120) {
            var1.minX = this.field120;
        }

        if (var1.field199 < this.field120) {
            var1.field199 = this.field120;
        }

        if (var1.minY > this.field130) {
            var1.minY = this.field130;
        }

        if (var1.field203 < this.field130) {
            var1.field203 = this.field130;
        }

    }

    @ObfuscatedName("jn")
    @ObfuscatedSignature(
            signature = "(Lhn;I)Z",
            garbageValue = "-925112087"
    )
    static final boolean method1673(ComponentType var0) {
        int var1 = var0.clientcode;
        if (var1 == 205) {
            client.field725 = 250;
            return true;
        } else {
            int var2;
            int var3;
            if (var1 >= 300 && var1 <= 313) {
                var2 = (var1 - 300) / 2;
                var3 = var1 & 1;
                client.field908.method620(var2, var3 == 1);
            }

            if (var1 >= 314 && var1 <= 323) {
                var2 = (var1 - 314) / 2;
                var3 = var1 & 1;
                client.field908.method621(var2, var3 == 1);
            }

            if (var1 == 324) {
                client.field908.method622(false);
            }

            if (var1 == 325) {
                client.field908.method622(true);
            }

            if (var1 == 326) {
                TcpConnectionMessage var4 = FaceNormal.method5726(ClientProt.UPDATE_APPEARANCE, client.serverConnection.isaac);
                client.field908.method623(var4.packetBuffer);
                client.serverConnection.method5881(var4);
                return true;
            } else {
                return false;
            }
        }
    }

    @ObfuscatedName("hb")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "103740146"
    )
    static void method1691() {
        client.menuOptionCount = 0;
        client.onMenuOptionsChanged(-1);
        client.isMenuOpen = false;
        client.menuOptions[0] = "Cancel";
        client.menuTargets[0] = "";
        client.menuTypes[0] = 1006;
        client.menuBooleanArray[0] = false;
        client.menuOptionCount = 1;
        client.onMenuOptionsChanged(-1);
    }
}
