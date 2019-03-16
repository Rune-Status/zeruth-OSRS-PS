package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lv")
public enum class223 implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   field3828(1, 0),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   field3824(2, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   field3826(0, 2),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   field3827(4, 3),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   field3825(3, 4);

   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -369638935
   )
   final int field3829;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 403002277
   )
   final int field3830;

   class223(int var3, int var4) {
      this.field3829 = var3;
      this.field3830 = var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int vmethod5358() {
      return this.field3830;
   }
}
