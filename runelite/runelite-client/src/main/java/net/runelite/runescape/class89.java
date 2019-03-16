package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public class class89 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2129784942"
   )
   public static void method1488() {
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var0 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1423162969"
   )
   static final void method1487(int var0, int var1) {
      Deque var2 = client.groundItemDeque[class228.level][var0][var1];
      if(var2 == null) {
         class131.sceneManager.method3816(class228.level, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method4373(); var6 != null; var6 = (Item)var2.method4358()) {
            ObjType var7 = Varcs.method4770(var6.id);
            long var8 = (long)var7.cost;
            if(var7.stackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class131.sceneManager.method3816(class228.level, var0, var1);
         } else {
            var2.method4352(var5);
            Item var12 = null;
            Item var11 = null;

            for(var6 = (Item)var2.method4373(); var6 != null; var6 = (Item)var2.method4358()) {
               if(var5.id != var6.id) {
                  if(var12 == null) {
                     var12 = var6;
                  }

                  if(var6.id != var12.id && var11 == null) {
                     var11 = var6;
                  }
               }
            }

            long var9 = WorldComparator.method6484(var0, var1, 3, false, 0);
            class131.sceneManager.method3802(class228.level, var0, var1, MilliTimer.method2824(var0 * 128 + 64, var1 * 128 + 64, class228.level), var5, var9, var12, var11);
         }
      }
   }
}
