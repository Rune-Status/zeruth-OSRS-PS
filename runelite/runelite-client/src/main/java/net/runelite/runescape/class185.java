package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class185 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   class155 field2504;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   class155 field2505;

   public class185() {
      this.field2505 = new class155();
      this.field2505.field2507 = this.field2505;
      this.field2505.field2506 = this.field2505;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "()Lhm;"
   )
   public class155 method3624() {
      class155 var1 = this.field2505.field2507;
      if(var1 == this.field2505) {
         this.field2504 = null;
         return null;
      } else {
         this.field2504 = var1.field2507;
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Lhm;"
   )
   public class155 method3625() {
      class155 var1 = this.field2504;
      if(var1 == this.field2505) {
         this.field2504 = null;
         return null;
      } else {
         this.field2504 = var1.field2507;
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lhm;)V"
   )
   public void method3623(class155 var1) {
      if(var1.field2506 != null) {
         var1.method2692();
      }

      var1.field2506 = this.field2505.field2506;
      var1.field2507 = this.field2505;
      var1.field2506.field2507 = var1;
      var1.field2507.field2506 = var1;
   }
}
