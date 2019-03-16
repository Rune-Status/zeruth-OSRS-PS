package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class184 extends TaskDataNode {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   Deque field1296;
   @ObfuscatedName("e")
   int field1298;
   @ObfuscatedName("q")
   int field1299;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   Deque field1297;

   public class184() {
      this.field1297 = new Deque();
      this.field1296 = new Deque();
      this.field1298 = 0;
      this.field1299 = -1;
   }

   @ObfuscatedName("v")
   void method3607(int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1297.method4373(); var2 != null; var2 = (TaskDataNode)this.field1297.method4358()) {
         var2.vmethod6450(var1);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ldz;)V"
   )
   public final synchronized void method3580(TaskDataNode var1) {
      var1.method6469();
   }

   @ObfuscatedName("e")
   void method3582() {
      if(this.field1298 > 0) {
         for(class38 var1 = (class38)this.field1296.method4373(); var1 != null; var1 = (class38)this.field1296.method4358()) {
            var1.field1401 -= this.field1298;
         }

         this.field1299 -= this.field1298;
         this.field1298 = 0;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;Lcw;)V"
   )
   void method3579(Node var1, class38 var2) {
      while(this.field1296.head != var1 && ((class38)var1).field1401 <= var2.field1401) {
         var1 = var1.next;
      }

      Deque.method4382(var2, var1);
      this.field1299 = ((class38)this.field1296.head.next).field1401;
   }

   @ObfuscatedName("x")
   public final synchronized void vmethod6450(int var1) {
      do {
         if(this.field1299 < 0) {
            this.method3607(var1);
            return;
         }

         if(this.field1298 + var1 < this.field1299) {
            this.field1298 += var1;
            this.method3607(var1);
            return;
         }

         int var2 = this.field1299 - this.field1298;
         this.method3607(var2);
         var1 -= var2;
         this.field1298 += var2;
         this.method3582();
         class38 var3 = (class38)this.field1296.method4373();
         synchronized(var3) {
            int var5 = var3.method580();
            if(var5 < 0) {
               var3.field1401 = 0;
               this.method3605(var3);
            } else {
               var3.field1401 = var5;
               this.method3579(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("m")
   protected int vmethod6465() {
      return 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected TaskDataNode vmethod6446() {
      return (TaskDataNode)this.field1297.method4358();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lcw;)V"
   )
   void method3605(class38 var1) {
      var1.method6469();
      var1.method579();
      Node var2 = this.field1296.head.next;
      if(var2 == this.field1296.head) {
         this.field1299 = -1;
      } else {
         this.field1299 = ((class38)var2).field1401;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected TaskDataNode vmethod6454() {
      return (TaskDataNode)this.field1297.method4373();
   }

   @ObfuscatedName("d")
   public final synchronized void vmethod6449(int[] var1, int var2, int var3) {
      do {
         if(this.field1299 < 0) {
            this.method3587(var1, var2, var3);
            return;
         }

         if(var3 + this.field1298 < this.field1299) {
            this.field1298 += var3;
            this.method3587(var1, var2, var3);
            return;
         }

         int var4 = this.field1299 - this.field1298;
         this.method3587(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1298 += var4;
         this.method3582();
         class38 var5 = (class38)this.field1296.method4373();
         synchronized(var5) {
            int var7 = var5.method580();
            if(var7 < 0) {
               var5.field1401 = 0;
               this.method3605(var5);
            } else {
               var5.field1401 = var7;
               this.method3579(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("j")
   void method3587(int[] var1, int var2, int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1297.method4373(); var4 != null; var4 = (TaskDataNode)this.field1297.method4358()) {
         var4.method6448(var1, var2, var3);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ldz;)V"
   )
   public final synchronized void method3581(TaskDataNode var1) {
      this.field1297.method4352(var1);
   }
}
