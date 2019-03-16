package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class260 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -661267581
   )
   static int field103;
   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static ComponentType field104;
   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   static Task socket;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   Coordinates field109;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1331233235
   )
   int field108;

   @ObfuscatedSignature(
      signature = "(ILhz;)V"
   )
   class260(int var1, Coordinates var2) {
      this.field108 = var1;
      this.field109 = var2;
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1754378417"
   )
   static final void method5008() {
      if(class228.level != client.field661) {
         client.field661 = class228.level;
         int var0 = class228.level;
         int[] var1 = TotalQuantityComparator.minimapSprite.pixels;
         int var2 = var1.length;

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            var1[var3] = 0;
         }

         int var4;
         int var5;
         for(var3 = 1; var3 < 103; ++var3) {
            var4 = (103 - var3) * 2048 + 24628;

            for(var5 = 1; var5 < 103; ++var5) {
               if((class98.tileSettings[var0][var5][var3] & 24) == 0) {
                  class131.sceneManager.method3829(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (class98.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
                  class131.sceneManager.method3829(var1, var4, 512, var0 + 1, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         TotalQuantityComparator.minimapSprite.method2244();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((class98.tileSettings[var0][var6][var5] & 24) == 0) {
                  GameObject.method2036(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (class98.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
                  GameObject.method2036(var0 + 1, var6, var5, var3, var4);
               }
            }
         }

         client.field820 = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               long var7 = class131.sceneManager.method3920(class228.level, var5, var6);
               if(var7 != 0L) {
                  int var9 = SubInterface.method2437(var7);
                  int var10 = class225.method4485(var9).mapIconId;
                  if(var10 >= 0) {
                     client.mapIcons[client.field820] = Timer.method5389(var10).method2386(false);
                     client.field871[client.field820] = var5;
                     client.field872[client.field820] = var6;
                     ++client.field820;
                  }
               }
            }
         }

         WorldMapManager.rasterProvider.method347();
      }

   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(Lhn;Ljw;IIZI)V",
      garbageValue = "1716253145"
   )
   static final void method5007(ComponentType var0, ObjType var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.iops;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         DState.method5638(var7, class31.method548(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
      }

   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1278936273"
   )
   static final void method5009(int var0, int var1, int var2, int var3) {
      client.field680 = 0;
      int var4 = (class4.localPlayer.x >> 7) + class158.baseX;
      int var5 = (class4.localPlayer.y >> 7) + class107.baseY;
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         client.field680 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         client.field680 = 1;
      }

      if(client.field680 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         client.field680 = 0;
      }

   }
}
