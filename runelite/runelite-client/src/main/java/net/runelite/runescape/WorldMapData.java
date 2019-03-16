package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapData;

import java.util.Iterator;
import java.util.LinkedList;

@ObfuscatedName("k")
@Implements("WorldMapData")
public class WorldMapData implements RSWorldMapData {
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Lhz;"
    )
    Coordinates field197;
    @ObfuscatedName("r")
    String identifier;
    @ObfuscatedName("e")
    String name;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = -818600847
    )
    int field199;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -212693339
    )
    int field195;
    @ObfuscatedName("m")
    LinkedList field193;
    @ObfuscatedName("p")
    boolean field202;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = 1188891119
    )
    int minX;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = 1756355463
    )
    int minY;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -307821243
    )
    int initialMapSurfaceZoom;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = 1499815225
    )
    int field203;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 1297509397
    )
    int fileId;

    public WorldMapData() {
        this.fileId = -1;
        this.field195 = -1;
        this.initialMapSurfaceZoom = -1;
        this.field197 = null;
        this.minX = Integer.MAX_VALUE;
        this.field199 = 0;
        this.minY = Integer.MAX_VALUE;
        this.field203 = 0;
        this.field202 = false;
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "115"
    )
    public int method1017() {
        return this.minX;
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-1730655048"
    )
    int method994() {
        return this.field195;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lgl;I)Lac;",
            garbageValue = "-2104615271"
    )
    WorldMapSectionBase method984(Packet var1) {
        int var2 = var1.readUnsignedByte();
        class39 var3 = (class39) class2.method20(class39.method587(), var2);
        Object var4 = null;
        switch (var3.worldMapType) {
            case 0:
                var4 = new WorldMapType3();
                break;
            case 1:
                var4 = new WorldMapType2();
                break;
            case 2:
                var4 = new class208();
                break;
            case 3:
                var4 = new WorldMapType1();
                break;
            default:
                throw new IllegalStateException("");
        }

        ((WorldMapSectionBase) var4).vmethod5829(var1);
        return (WorldMapSectionBase) var4;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(IIII)Z",
            garbageValue = "37007514"
    )
    public boolean method985(int var1, int var2, int var3) {
        Iterator var4 = this.field193.iterator();

        WorldMapSectionBase var5;
        do {
            if (!var4.hasNext()) {
                return false;
            }

            var5 = (WorldMapSectionBase) var4.next();
        } while (!var5.vmethod5812(var1, var2, var3));

        return true;
    }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "100"
    )
    public int method1008() {
        return this.field203;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(IIB)Z",
            garbageValue = "-9"
    )
    public boolean method986(int var1, int var2) {
        int var3 = var1 / 64;
        int var4 = var2 / 64;
        if (var3 >= this.minX && var3 <= this.field199) {
            if (var4 >= this.minY && var4 <= this.field203) {
                Iterator var5 = this.field193.iterator();

                WorldMapSectionBase var6;
                do {
                    if (!var5.hasNext()) {
                        return false;
                    }

                    var6 = (WorldMapSectionBase) var5.next();
                } while (!var6.vmethod5811(var1, var2));

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(I)Ljava/lang/String;",
            garbageValue = "-367314643"
    )
    public String method1004() {
        return this.name;
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "41"
    )
    public int method990() {
        return this.fileId;
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "1851803046"
    )
    void method1026() {
        Iterator var1 = this.field193.iterator();

        while (var1.hasNext()) {
            WorldMapSectionBase var2 = (WorldMapSectionBase) var1.next();
            var2.vmethod5820(this);
        }

    }

    @ObfuscatedName("o")
    @ObfuscatedSignature(
            signature = "(B)Lhz;",
            garbageValue = "-97"
    )
    public Coordinates method1003() {
        return new Coordinates(this.field197);
    }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-232468976"
    )
    public int method997() {
        return this.field199;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(IIII)[I",
            garbageValue = "-1422622969"
    )
    public int[] method987(int var1, int var2, int var3) {
        Iterator var4 = this.field193.iterator();

        WorldMapSectionBase var5;
        do {
            if (!var4.hasNext()) {
                return null;
            }

            var5 = (WorldMapSectionBase) var4.next();
        } while (!var5.vmethod5812(var1, var2, var3));

        return var5.vmethod5814(var1, var2, var3);
    }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "26"
    )
    public int method988() {
        return this.minY;
    }

    public boolean surfaceContainsPosition(int var1, int var2) {
        return this.method986(var1, var2);
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(III)Lhz;",
            garbageValue = "-795573811"
    )
    public Coordinates method1016(int var1, int var2) {
        Iterator var3 = this.field193.iterator();

        WorldMapSectionBase var4;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            var4 = (WorldMapSectionBase) var3.next();
        } while (!var4.vmethod5811(var1, var2));

        return var4.vmethod5817(var1, var2);
    }

    @ObfuscatedName("y")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "1114907635"
    )
    public int method993() {
        return this.field197.plane;
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "1654111669"
    )
    public boolean method991() {
        return this.field202;
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(B)Ljava/lang/String;",
            garbageValue = "-67"
    )
    public String method1001() {
        return this.identifier;
    }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "85718924"
    )
    public int method1040() {
        return this.field197.worldX;
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "41"
    )
    public int method995() {
        return this.initialMapSurfaceZoom;
    }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "1882739851"
    )
    public int method1002() {
        return this.field197.worldY;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Lgl;II)V",
            garbageValue = "-1579235046"
    )
    public void method999(Packet var1, int var2) {
        this.fileId = var2;
        this.identifier = var1.readString();
        this.name = var1.readString();
        this.field197 = new Coordinates(var1.getInt());
        this.field195 = var1.getInt();
        var1.readUnsignedByte();
        this.field202 = var1.readUnsignedByte() == 1;
        this.initialMapSurfaceZoom = var1.readUnsignedByte();
        int var3 = var1.readUnsignedByte();
        this.field193 = new LinkedList();

        for (int var4 = 0; var4 < var3; ++var4) {
            this.field193.add(this.method984(var1));
        }

        this.method1026();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Liu;Liu;ZIB)V",
            garbageValue = "27"
    )
    static void method1054(Js5Index var0, Js5Index var1, boolean var2, int var3) {
        if (class316.field1174) {
            if (var3 == 4) {
                class316.loginIndex = 4;
            }

        } else {
            class316.loginIndex = var3;
            Rasterizer2D.method445();
            byte[] var4 = var0.method1534("title.jpg", "");
            class316.field1145 = class48.method776(var4);
            class316.field1146 = class316.field1145.method2242();
            if ((client.flags & 536870912) != 0) {
                Varbit.logoSprite = MapElementType.method2369(var1, "logo_deadman_mode", "");
            } else {
                Varbit.logoSprite = MapElementType.method2369(var1, "logo", "");
            }

            class316.field1149 = MapElementType.method2369(var1, "titlebox", "");
            class226.field3801 = MapElementType.method2369(var1, "titlebutton", "");
            int var6 = var1.method1510("runes");
            int var7 = var1.method1532(var6, "");
            IndexedSprite[] var8;
            if (!WorldMapRectangle.method128(var1, var6, var7)) {
                var8 = null;
            } else {
                var8 = GraphicsDefaults.method4016();
            }

            class116.runeSprites = var8;
            var7 = var1.method1510("title_mute");
            int var10 = var1.method1532(var7, "");
            IndexedSprite[] var9;
            if (!WorldMapRectangle.method128(var1, var7, var10)) {
                var9 = null;
            } else {
                var9 = GraphicsDefaults.method4016();
            }

            class316.titlemuteSprite = var9;
            class150.field2417 = MapElementType.method2369(var1, "options_radio_buttons,0", "");
            class316.field1148 = MapElementType.method2369(var1, "options_radio_buttons,4", "");
            Frames.field1861 = MapElementType.method2369(var1, "options_radio_buttons,2", "");
            UrlRequest.field1925 = MapElementType.method2369(var1, "options_radio_buttons,6", "");
            class4.field1050 = class150.field2417.width;
            GameCanvas.field405 = class150.field2417.height;
            class316.field1151 = new int[256];

            for (var7 = 0; var7 < 64; ++var7) {
                class316.field1151[var7] = var7 * 262144;
            }

            for (var7 = 0; var7 < 64; ++var7) {
                class316.field1151[var7 + 64] = var7 * 1024 + 16711680;
            }

            for (var7 = 0; var7 < 64; ++var7) {
                class316.field1151[var7 + 128] = var7 * 4 + 16776960;
            }

            for (var7 = 0; var7 < 64; ++var7) {
                class316.field1151[var7 + 192] = 16777215;
            }

            MouseRecorder.field583 = new int[256];

            for (var7 = 0; var7 < 64; ++var7) {
                MouseRecorder.field583[var7] = var7 * 1024;
            }

            for (var7 = 0; var7 < 64; ++var7) {
                MouseRecorder.field583[var7 + 64] = var7 * 4 + 65280;
            }

            for (var7 = 0; var7 < 64; ++var7) {
                MouseRecorder.field583[var7 + 128] = var7 * 262144 + 65535;
            }

            for (var7 = 0; var7 < 64; ++var7) {
                MouseRecorder.field583[var7 + 192] = 16777215;
            }

            class139.field2048 = new int[256];

            for (var7 = 0; var7 < 64; ++var7) {
                class139.field2048[var7] = var7 * 4;
            }

            for (var7 = 0; var7 < 64; ++var7) {
                class139.field2048[var7 + 64] = var7 * 262144 + 255;
            }

            for (var7 = 0; var7 < 64; ++var7) {
                class139.field2048[var7 + 128] = var7 * 1024 + 16711935;
            }

            for (var7 = 0; var7 < 64; ++var7) {
                class139.field2048[var7 + 192] = 16777215;
            }

            class4.field1047 = new int[256];
            OwnWorldComparator.field640 = new int['耀'];
            class284.field322 = new int['耀'];
            class0.method0((IndexedSprite) null);
            WorldMapDecoration.field182 = new int['耀'];
            WorldMapDecoration.field183 = new int['耀'];
            if (var2) {
                class316.username = "";
                client.onUsernameChanged(-1);
                class316.password = "";
            }

            class228.authcode = 0;
            class113.field82 = "";
            class316.field1172 = true;
            class316.worldSelectShown = false;
            if (!GameEngine.options.muted) {
                WorldMapType2.method3154(2, ServerProt.music, "scape main", "", 255, false);
            } else {
                class170.method2866(2);
            }

            class311.method5933(false);
            class316.field1174 = true;
            class316.field1143 = (FriendManager.canvasWidth - 765) / 2;
            class316.loginWindowX = class316.field1143 + 202;
            class260.field103 = class316.loginWindowX + 180;
            class316.field1145.method2273(class316.field1143, 0);
            class316.field1146.method2273(class316.field1143 + 382, 0);
            Varbit.logoSprite.method824(class316.field1143 + 382 - Varbit.logoSprite.width / 2, 18);
        }
    }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;B)V",
            garbageValue = "-100"
    )
    static final void method1055(String var0) {
        class115.method2002("Please remove " + var0 + " from your friend list first");
    }
}
