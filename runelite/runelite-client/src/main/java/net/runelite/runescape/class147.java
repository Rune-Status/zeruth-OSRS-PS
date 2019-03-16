package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public final class class147 {
   @ObfuscatedName("ru")
   @ObfuscatedGetter(
      intValue = 2128898713
   )
   static int field208;
   @ObfuscatedName("n")
   static int[] field209;
   @ObfuscatedName("s")
   static String homeDir;
   @ObfuscatedName("r")
   final int[] field207;

   class147() {
      this.field207 = new int[4096];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "70"
   )
   final int method2537(int var1, int var2) {
      return this.field207[var1 * 64 + var2];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1027273501"
   )
   final void method2536(class284 var1) {
      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field207[var2 * 64 + var3] = var1.method5557(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "671784664"
   )
   static void method2538(int var0, int var1, int var2, int var3) {
      for(class4 var4 = (class4)class4.field1051.method4373(); var4 != null; var4 = (class4)class4.field1051.method4358()) {
         if(var4.field1054 != -1 || var4.field1058 != null) {
            int var5 = 0;
            if(var1 > var4.field1062) {
               var5 += var1 - var4.field1062;
            } else if(var1 < var4.field1049) {
               var5 += var4.field1049 - var1;
            }

            if(var2 > var4.field1052) {
               var5 += var2 - var4.field1052;
            } else if(var2 < var4.field1059) {
               var5 += var4.field1059 - var2;
            }

            if(var5 - 64 <= var4.field1053 && client.field881 != 0 && var0 == var4.field1048) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field1053 - var5) * client.field881 / var4.field1053;
               if(var4.field1064 == null) {
                  if(var4.field1054 >= 0) {
                     SoundEffect var7 = SoundEffect.method605(class192.synths, var4.field1054, 0);
                     if(var7 != null) {
                        RawAudioNode var8 = var7.method611().method4097(class215.field3697);
                        class266 var9 = class266.method5067(var8, 100, var6);
                        var9.method5059(-1);
                        class2.field413.method3581(var9);
                        var4.field1064 = var9;
                     }
                  }
               } else {
                  var4.field1064.method5060(var6);
               }

               if(var4.field1060 == null) {
                  if(var4.field1058 != null && (var4.field1055 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field1058.length);
                     SoundEffect var12 = SoundEffect.method605(class192.synths, var4.field1058[var11], 0);
                     if(var12 != null) {
                        RawAudioNode var13 = var12.method611().method4097(class215.field3697);
                        class266 var10 = class266.method5067(var13, 100, var6);
                        var10.method5059(0);
                        class2.field413.method3581(var10);
                        var4.field1060 = var10;
                        var4.field1055 = var4.field1056 + (int)(Math.random() * (double)(var4.field1057 - var4.field1056));
                     }
                  }
               } else {
                  var4.field1060.method5060(var6);
                  if(!var4.field1060.method6470()) {
                     var4.field1060 = null;
                  }
               }
            } else {
               if(var4.field1064 != null) {
                  class2.field413.method3580(var4.field1064);
                  var4.field1064 = null;
               }

               if(var4.field1060 != null) {
                  class2.field413.method3580(var4.field1060);
                  var4.field1060 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1809476914"
   )
   static int method2535(int var0, class106 var1, boolean var2) {
      if(var0 == 5306) {
         class48.intStack[++class228.intStackSize - 1] = WorldMapRectangle.method127();
         return 1;
      } else {
         int var3;
         if(var0 == 5307) {
            var3 = class48.intStack[--class228.intStackSize];
            if(var3 == 1 || var3 == 2) {
               WorldMapType2.method3151(var3);
            }

            return 1;
         } else if(var0 == 5308) {
            class48.intStack[++class228.intStackSize - 1] = GameEngine.options.screenType;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var3 = class48.intStack[--class228.intStackSize];
            if(var3 == 1 || var3 == 2) {
               GameEngine.options.screenType = var3;
               PlayerEntity.method2919();
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-1957451003"
   )
   public static Object method2546(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.directBufferUnavailable) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.vmethod5416(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.directBufferUnavailable = true;
            }
         }

         return var0;
      }
   }
}
