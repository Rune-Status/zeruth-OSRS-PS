package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class155 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   class155 field2506;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   class155 field2507;

   @ObfuscatedName("g")
   public void method2692() {
      if(this.field2506 != null) {
         this.field2506.field2507 = this.field2507;
         this.field2507.field2506 = this.field2506;
         this.field2507 = null;
         this.field2506 = null;
      }
   }
}
