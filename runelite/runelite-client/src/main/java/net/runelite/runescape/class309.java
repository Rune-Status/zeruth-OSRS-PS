package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
public class class309 extends class155 {
   @ObfuscatedName("n")
   static byte[][][] field3737;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1082081929
   )
   public int field3736;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   public Name field3734;
   @ObfuscatedName("c")
   public short field3735;

   @ObfuscatedSignature(
      signature = "(Lkg;I)V"
   )
   class309(Name var1, int var2) {
      this.field3736 = (int)(Tile.method4297() / 1000L);
      this.field3734 = var1;
      this.field3735 = (short)var2;
   }
}
