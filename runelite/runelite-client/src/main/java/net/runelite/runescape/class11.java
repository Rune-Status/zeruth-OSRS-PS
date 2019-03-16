package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class11 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -5277989372420888043L
   )
   static long field2419;
   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "[Lls;"
   )
   static SpritePixels[] mapMarkers;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -6979353868859175691L
   )
   static long field2420;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "256"
   )
   public static boolean method173(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1409681026"
   )
   public static void method171() {
      Spotanim.spotanims.method952();
      Spotanim.SpotAnimationDefinition_cachedModels.method952();
   }
}
