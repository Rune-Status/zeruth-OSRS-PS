package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class37 {
   @ObfuscatedName("r")
   public static final boolean[] field2842;
   @ObfuscatedName("e")
   public static int[] field2844;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lcu;"
   )
   static SoundTask task;

   static {
      field2842 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2844 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2844[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1049257367"
   )
   static final int method577(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
