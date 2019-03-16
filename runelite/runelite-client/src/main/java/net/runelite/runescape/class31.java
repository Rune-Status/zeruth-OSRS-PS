package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class31 {
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 1775659029
   )
   static int field1838;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2025168103"
   )
   static String method548(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1048301153"
   )
   public static boolean method549(int var0) {
      return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
   }
}
