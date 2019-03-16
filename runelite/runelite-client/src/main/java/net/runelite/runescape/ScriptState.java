package net.runelite.runescape;

import net.runelite.mapping.*;

import java.io.File;

@ObfuscatedName("aq")
@Implements("ScriptState")
public class ScriptState {
    @ObfuscatedName("c")
    @Export("cacheDirectory")
    static File cacheDirectory;
    @ObfuscatedName("la")
    @ObfuscatedSignature(
            signature = "Lbr;"
    )
    @Export("topContextMenuRow")
    static ContextMenuRow topContextMenuRow;
    public class106 field610;
    public int[] field603;
    public String[] field606;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 1287354019
    )
    @Export("invokedFromPc")
    int invokedFromPc;

    ScriptState() {
        this.invokedFromPc = -1;
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(Ldl;IIIB)Z",
            garbageValue = "5"
    )
    static final boolean method422(Model var0, int var1, int var2, int var3) {
        boolean var4 = class195.Viewport_containsMouse;
        if (!var4) {
            return false;
        } else {
            int var5;
            int var6;
            int var7;
            int var8;
            int var11;
            int var12;
            int var13;
            int var16;
            int var17;
            if (!class195.Viewport_false0) {
                var5 = SceneManager.pitchSin;
                var6 = SceneManager.pitchCos;
                var7 = SceneManager.yawSin;
                var8 = SceneManager.yawCos;
                byte var9 = 50;
                short var10 = 3500;
                var11 = (class195.Viewport_mouseX - Graphics3D.centerX) * var9 / Graphics3D.Rasterizer3D_zoom;
                var12 = (class195.Viewport_mouseY - Graphics3D.centerY) * var9 / Graphics3D.Rasterizer3D_zoom;
                var13 = (class195.Viewport_mouseX - Graphics3D.centerX) * var10 / Graphics3D.Rasterizer3D_zoom;
                int var14 = (class195.Viewport_mouseY - Graphics3D.centerY) * var10 / Graphics3D.Rasterizer3D_zoom;
                int var15 = Graphics3D.method2584(var12, var9, var6, var5);
                var16 = Graphics3D.method2598(var12, var9, var6, var5);
                var12 = var15;
                var15 = Graphics3D.method2584(var14, var10, var6, var5);
                var17 = Graphics3D.method2598(var14, var10, var6, var5);
                var14 = var15;
                var15 = Graphics3D.method2574(var11, var16, var8, var7);
                var16 = Graphics3D.method2583(var11, var16, var8, var7);
                var11 = var15;
                var15 = Graphics3D.method2574(var13, var17, var8, var7);
                var17 = Graphics3D.method2583(var13, var17, var8, var7);
                class195.field1709 = (var11 + var15) / 2;
                class306.field552 = (var14 + var12) / 2;
                class228.field605 = (var17 + var16) / 2;
                FileRequest.field3222 = (var15 - var11) / 2;
                Varcs.field1243 = (var14 - var12) / 2;
                ItemLayer.field1513 = (var17 - var16) / 2;
                Friend.field3725 = Math.abs(FileRequest.field3222);
                SoundTaskDataProvider.field396 = Math.abs(Varcs.field1243);
                FriendContainer.field3719 = Math.abs(ItemLayer.field1513);
            }

            var5 = var0.centerX + var1;
            var6 = var2 + var0.centerY;
            var7 = var3 + var0.centerZ;
            var8 = var0.extremeX;
            var16 = var0.extremeY;
            var17 = var0.extremeZ;
            var11 = class195.field1709 - var5;
            var12 = class306.field552 - var6;
            var13 = class228.field605 - var7;
            return Math.abs(var11) > var8 + Friend.field3725 ? false : (Math.abs(var12) > var16 + SoundTaskDataProvider.field396 ? false : (Math.abs(var13) > var17 + FriendContainer.field3719 ? false : (Math.abs(var13 * Varcs.field1243 - var12 * ItemLayer.field1513) > var17 * SoundTaskDataProvider.field396 + var16 * FriendContainer.field3719 ? false : (Math.abs(var11 * ItemLayer.field1513 - var13 * FileRequest.field3222) > var17 * Friend.field3725 + var8 * FriendContainer.field3719 ? false : Math.abs(var12 * FileRequest.field3222 - var11 * Varcs.field1243) <= var16 * Friend.field3725 + var8 * SoundTaskDataProvider.field396))));
        }
    }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1726630277"
    )
    public static void method423() {
        Sequence.sequences.method952();
        Sequence.skeletons.method952();
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(II)Lkf;",
            garbageValue = "-897441396"
    )
    public static class307 method421(int var0) {
        class307[] var1 = new class307[]{class307.field3806, class307.field3808, class307.field3805};
        class307[] var2 = var1;

        for (int var3 = 0; var3 < var2.length; ++var3) {
            class307 var4 = var2[var3];
            if (var0 == var4.field3807) {
                return var4;
            }
        }

        return null;
    }
}
