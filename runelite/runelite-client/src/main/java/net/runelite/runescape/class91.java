package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class91 {
   @ObfuscatedName("p")
   static final int[] field2432;
   @ObfuscatedName("i")
   static final int[] field2431;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -120282663
   )
   static int updateZoneX;

   static {
      field2431 = new int[2048];
      field2432 = new int[2048];
      double var0 = 0.0030679615757712823D;

      for(int var2 = 0; var2 < 2048; ++var2) {
         field2431[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
         field2432[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lic;",
      garbageValue = "-1758970395"
   )
   public static class204 method1502(int var0) {
      class204 var1 = (class204)class204.field3298.method951((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class204.field3301.method1516(5, var0, 1789634852);
         var1 = new class204();
         if(var2 != null) {
            var1.method4083(new Packet(var2));
         }

         class204.field3298.method957(var1, (long)var0);
         return var1;
      }
   }
}
