package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
public class class0 {
   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "[Lli;"
   )
   static IndexedSprite[] mapscene;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lli;I)V",
      garbageValue = "1227975411"
   )
   static final void method0(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < OwnWorldComparator.field640.length; ++var2) {
         OwnWorldComparator.field640[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         OwnWorldComparator.field640[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class284.field322[var5] = (OwnWorldComparator.field640[var5 - 128] + OwnWorldComparator.field640[var5 + 1] + OwnWorldComparator.field640[var5 + 128] + OwnWorldComparator.field640[var5 - 1]) / 4;
            }
         }

         int[] var8 = OwnWorldComparator.field640;
         OwnWorldComparator.field640 = class284.field322;
         class284.field322 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.width; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  OwnWorldComparator.field640[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "653071948"
   )
   static void method1(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var12 = DecorativeObject.method5023(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = DecorativeObject.method5023(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method1(var0, var7 - 1, var2, var3, var4, var5);
         method1(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
