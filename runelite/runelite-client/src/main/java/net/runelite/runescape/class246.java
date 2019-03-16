package net.runelite.runescape;

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class246 implements Iterator {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   CacheableNode field2515;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   CacheableNode field2517;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   IterableDualNodeQueue field2516;

   @ObfuscatedSignature(
      signature = "(Lhf;)V"
   )
   class246(IterableDualNodeQueue var1) {
      this.field2517 = null;
      this.field2516 = var1;
      this.field2515 = this.field2516.sentinel.previous;
      this.field2517 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2515;
      if(var1 == this.field2516.sentinel) {
         var1 = null;
         this.field2515 = null;
      } else {
         this.field2515 = var1.previous;
      }

      this.field2517 = var1;
      return var1;
   }

   public void remove() {
      this.field2517.method419();
      this.field2517 = null;
   }

   public boolean hasNext() {
      return this.field2516.sentinel != this.field2515;
   }
}
