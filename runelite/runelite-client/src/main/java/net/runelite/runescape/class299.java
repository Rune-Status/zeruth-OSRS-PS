package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public final class class299 {
   @ObfuscatedName("r")
   int field2485;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   IterableHashTable field2487;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   IterableDualNodeQueue field2484;
   @ObfuscatedName("g")
   int field2486;

   public class299(int var1, int var2) {
      this.field2484 = new IterableDualNodeQueue();
      this.field2486 = var1;
      this.field2485 = var1;

      int var3;
      for(var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
         ;
      }

      this.field2487 = new IterableHashTable(var3);
   }

   @ObfuscatedName("r")
   void method5729(long var1) {
      class286 var3 = (class286)this.field2487.method2764(var1);
      this.method5730(var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lhr;)V"
   )
   void method5730(class286 var1) {
      if(var1 != null) {
         var1.method6469();
         var1.method419();
         this.field2485 += var1.field2513;
      }

   }

   @ObfuscatedName("q")
   public void method5731(Object var1, long var2) {
      this.method5732(var1, var2, 1);
   }

   @ObfuscatedName("p")
   public void method5738() {
      this.field2484.method5793();
      this.field2487.method2757();
      this.field2485 = this.field2486;
   }

   @ObfuscatedName("c")
   public void method5732(Object var1, long var2, int var4) {
      if(var4 > this.field2486) {
         throw new IllegalStateException();
      } else {
         this.method5729(var2);
         this.field2485 -= var4;

         while(this.field2485 < 0) {
            class286 var5 = (class286)this.field2484.method5801();
            this.method5730(var5);
         }

         class93 var6 = new class93(var1, var4);
         this.field2487.method2749(var6, var2);
         this.field2484.method5799(var6);
         var6.field2501 = 0L;
      }
   }

   @ObfuscatedName("i")
   public void method5735(int var1) {
      for(class286 var2 = (class286)this.field2484.method5794(); var2 != null; var2 = (class286)this.field2484.method5798()) {
         if(var2.vmethod5578()) {
            if(var2.vmethod5577() == null) {
               var2.method6469();
               var2.method419();
               this.field2485 += var2.field2513;
            }
         } else if(++var2.field2501 > (long)var1) {
            class63 var3 = new class63(var2.vmethod5577(), var2.field2513);
            this.field2487.method2749(var3, var2.hash);
            Node2LinkedList.method2514(var3, var2);
            var2.method6469();
            var2.method419();
         }
      }

   }

   @ObfuscatedName("g")
   public Object method5733(long var1) {
      class286 var3 = (class286)this.field2487.method2764(var1);
      if(var3 == null) {
         return null;
      } else {
         Object var4 = var3.vmethod5577();
         if(var4 == null) {
            var3.method6469();
            var3.method419();
            this.field2485 += var3.field2513;
            return null;
         } else {
            if(var3.vmethod5578()) {
               class93 var5 = new class93(var4, var3.field2513);
               this.field2487.method2749(var5, var3.hash);
               this.field2484.method5799(var5);
               var5.field2501 = 0L;
               var3.method6469();
               var3.method419();
            } else {
               this.field2484.method5799(var3);
               var3.field2501 = 0L;
            }

            return var4;
         }
      }
   }
}
