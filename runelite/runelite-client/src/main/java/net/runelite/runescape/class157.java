package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class157 {
   @ObfuscatedName("f")
   static String[] historicCacheDirectories;
   @ObfuscatedName("b")
   static byte[][][] overlayRotations;

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1676983438"
   )
   static final String method2694(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class31.method548(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class31.method548(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class31.method548(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Llq;B)I",
      garbageValue = "-39"
   )
   static final int method2695(JagexLoginType var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field4001) {
         case 3:
            return 20;
         default:
            return 12;
         }
      }
   }
}
