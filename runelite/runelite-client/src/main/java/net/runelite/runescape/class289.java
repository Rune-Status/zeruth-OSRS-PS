package net.runelite.runescape;

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class289 implements Iterator {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   Node field2477;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   Node field2476;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   CombatInfoList field2478;

   @ObfuscatedSignature(
      signature = "(Lgb;)V"
   )
   class289(CombatInfoList var1) {
      this.field2476 = null;
      this.field2478 = var1;
      this.field2477 = this.field2478.node.next;
      this.field2476 = null;
   }

   public void remove() {
      this.field2476.method6469();
      this.field2476 = null;
   }

   public boolean hasNext() {
      return this.field2478.node != this.field2477;
   }

   public Object next() {
      Node var1 = this.field2477;
      if(var1 == this.field2478.node) {
         var1 = null;
         this.field2477 = null;
      } else {
         this.field2477 = var1.next;
      }

      this.field2476 = var1;
      return var1;
   }
}
