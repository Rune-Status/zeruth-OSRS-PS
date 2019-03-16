package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lx")
public enum class271 implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   field3866(0, 0),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   field3865(1, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   field3867(2, 2);

   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1503414731
   )
   public final int field3868;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 228825557
   )
   final int field3869;

   class271(int var3, int var4) {
      this.field3868 = var3;
      this.field3869 = var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int vmethod5358() {
      return this.field3869;
   }
}
