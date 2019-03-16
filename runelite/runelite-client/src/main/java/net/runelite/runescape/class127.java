package net.runelite.runescape;

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
public abstract class class127 implements Comparator {
   @ObfuscatedName("r")
   Comparator field3694;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;I)V",
      garbageValue = "1461286313"
   )
   final void method2137(Comparator var1) {
      if(this.field3694 == null) {
         this.field3694 = var1;
      } else if(this.field3694 instanceof class127) {
         ((class127)this.field3694).method2137(var1);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;B)I",
      garbageValue = "30"
   )
   protected final int method2141(Nameable var1, Nameable var2) {
      return this.field3694 == null?0:this.field3694.compare(var1, var2);
   }
}
