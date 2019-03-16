package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class117 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2040503433
   )
   protected static int field2363;

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1022302201"
   )
   static boolean method2026() {
      return (client.playerNameMask & 2) != 0;
   }
}
