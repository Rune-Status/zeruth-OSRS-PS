package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class170 {
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 1988832279
   )
   static int field2361;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1136890378"
   )
   public static void method2868() {
      WorldMapRegion.field235.method5735(5);
      WorldMapRegion.field232.method5735(5);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1344959189"
   )
   public static void method2866(int var0) {
      class120.field2529 = 1;
      UrlRequester.field1911 = null;
      class120.field2533 = -1;
      IndexFile.field2073 = -1;
      class186.field3851 = 0;
      class120.field2534 = false;
      WorldComparator.field0 = var0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1861885701"
   )
   public static boolean method2867() {
      try {
         if(class120.field2529 == 2) {
            if(GrandExchangeOffer.field39 == null) {
               GrandExchangeOffer.field39 = Track1.method431(UrlRequester.field1911, class120.field2533, IndexFile.field2073);
               if(GrandExchangeOffer.field39 == null) {
                  return false;
               }
            }

            if(class159.field1218 == null) {
               class159.field1218 = new class224(class120.field2531, class120.field2530);
            }

            if(class267.field2461.method4851(GrandExchangeOffer.field39, class120.field2535, class159.field1218, 22050)) {
               class267.field2461.method4852();
               class267.field2461.method4879(class186.field3851);
               class267.field2461.method4854(GrandExchangeOffer.field39, class120.field2534);
               class120.field2529 = 0;
               GrandExchangeOffer.field39 = null;
               class159.field1218 = null;
               UrlRequester.field1911 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class267.field2461.method4974();
         class120.field2529 = 0;
         GrandExchangeOffer.field39 = null;
         class159.field1218 = null;
         UrlRequester.field1911 = null;
      }

      return false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2054229378"
   )
   static final void method2865(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class98.field503[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class98.tileHeights[0][var5][var4] = class98.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class98.tileHeights[0][var5][var4] = class98.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class98.tileHeights[0][var5][var4] = class98.tileHeights[0][var5][var4 - 1];
               }

               if(var3 + var1 == var4 && var4 < 103) {
                  class98.tileHeights[0][var5][var4] = class98.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
