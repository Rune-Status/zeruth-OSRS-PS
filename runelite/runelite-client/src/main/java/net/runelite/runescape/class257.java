package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class257 extends TaskDataNode {
   @ObfuscatedName("l")
   int[] field2541;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1781401461
   )
   int field2537;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -218741751
   )
   int field2538;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "[[Lho;"
   )
   class112[][] field2555;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -97174503
   )
   int field2559;
   @ObfuscatedName("k")
   int[] field2545;
   @ObfuscatedName("q")
   int[] field2551;
   @ObfuscatedName("m")
   int[] field2552;
   @ObfuscatedName("p")
   int[] field2543;
   @ObfuscatedName("b")
   int[] field2542;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   class218 field2562;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1397089985
   )
   int field2549;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[[Lho;"
   )
   class112[][] field2554;
   @ObfuscatedName("z")
   int[] field2550;
   @ObfuscatedName("n")
   int[] field2539;
   @ObfuscatedName("c")
   int[] field2536;
   @ObfuscatedName("t")
   int[] field2548;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   class319 field2556;
   @ObfuscatedName("i")
   int[] field2544;
   @ObfuscatedName("y")
   int[] field2553;
   @ObfuscatedName("ax")
   boolean field2547;
   @ObfuscatedName("d")
   int[] field2558;
   @ObfuscatedName("s")
   int[] field2540;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = -8786099303289301241L
   )
   long field2561;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      longValue = 1458773426898952009L
   )
   long field2560;
   @ObfuscatedName("u")
   int[] field2546;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   HashTable field2557;

   public class257() {
      this.field2537 = 256;
      this.field2538 = 1000000;
      this.field2551 = new int[16];
      this.field2536 = new int[16];
      this.field2541 = new int[16];
      this.field2542 = new int[16];
      this.field2539 = new int[16];
      this.field2544 = new int[16];
      this.field2543 = new int[16];
      this.field2552 = new int[16];
      this.field2558 = new int[16];
      this.field2548 = new int[16];
      this.field2545 = new int[16];
      this.field2550 = new int[16];
      this.field2540 = new int[16];
      this.field2553 = new int[16];
      this.field2546 = new int[16];
      this.field2554 = new class112[16][128];
      this.field2555 = new class112[16][128];
      this.field2556 = new class319();
      this.field2562 = new class218(this);
      this.field2557 = new HashTable(128);
      this.method4869();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2032006285"
   )
   void method4870(int var1) {
      if((this.field2548[var1] & 2) != 0) {
         for(class112 var2 = (class112)this.field2562.field2615.method4373(); var2 != null; var2 = (class112)this.field2562.field2615.method4358()) {
            if(var2.field2585 == var1 && this.field2554[var1][var2.field2568] == null && var2.field2577 < 0) {
               var2.field2577 = 0;
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "21"
   )
   public synchronized void method4857(int var1, int var2) {
      this.method4936(var1, var2);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lho;I)I",
      garbageValue = "-333629023"
   )
   int method4874(class112 var1) {
      int var2 = (var1.field2573 * var1.field2572 >> 12) + var1.field2586;
      var2 += (this.field2543[var1.field2585] - 8192) * this.field2550[var1.field2585] >> 12;
      class43 var3 = var1.field2566;
      int var4;
      if(var3.field2523 > 0 && (var3.field2526 > 0 || this.field2552[var1.field2585] > 0)) {
         var4 = var3.field2526 << 2;
         int var5 = var3.field2520 << 1;
         if(var1.field2579 < var5) {
            var4 = var4 * var1.field2579 / var5;
         }

         var4 += this.field2552[var1.field2585] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2580 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2565.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "27"
   )
   public synchronized void method4974() {
      this.field2556.method6050();
      this.method4869();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1703023185"
   )
   public int method4856() {
      return this.field2537;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lhh;Liu;Lci;II)Z",
      garbageValue = "1521934600"
   )
   synchronized boolean method4851(Track1 var1, Js5Index var2, class224 var3, int var4) {
      var1.method433();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2619.method391(); var7 != null; var7 = (ByteArrayNode)var1.field2619.method385()) {
         int var8 = (int)var7.hash;
         class196 var9 = (class196)this.field2557.method380((long)var8);
         if(var9 == null) {
            var9 = class56.method851(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2557.method382(var9, (long)var8);
         }

         if(!var9.method4001(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method438();
      }

      return var5;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-10"
   )
   void method4865(int var1, int var2) {
      this.field2543[var1] = var2;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(Lho;I)I",
      garbageValue = "2145976483"
   )
   int method4875(class112 var1) {
      class43 var2 = var1.field2566;
      int var3 = this.field2551[var1.field2585] * this.field2541[var1.field2585] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2570 + 16384 >> 15;
      var3 = var3 * this.field2537 + 128 >> 8;
      if(var2.field2522 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2522 * 1.953125E-5D * (double)var1.field2574) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2521 != null) {
         var4 = var1.field2575;
         var5 = var2.field2521[var1.field2564 + 1];
         if(var1.field2564 < var2.field2521.length - 2) {
            var6 = (var2.field2521[var1.field2564] & 255) << 8;
            var7 = (var2.field2521[var1.field2564 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2521[var1.field2564 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2577 > 0 && var2.field2524 != null) {
         var4 = var1.field2577;
         var5 = var2.field2524[var1.field2578 + 1];
         if(var1.field2578 < var2.field2524.length - 2) {
            var6 = (var2.field2524[var1.field2578] & 255) << 8;
            var7 = (var2.field2524[var1.field2578 + 2] & 255) << 8;
            var5 += (var2.field2524[var1.field2578 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1366988619"
   )
   void method4869() {
      this.method4866(-1);
      this.method4867(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2539[var1] = this.field2542[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2544[var1] = this.field2542[var1] & -128;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-90"
   )
   void method4860(int var1, int var2, int var3) {
      this.method4931(var1, var2, 64);
      if((this.field2548[var1] & 2) != 0) {
         for(class112 var4 = (class112)this.field2562.field2615.method4349(); var4 != null; var4 = (class112)this.field2562.field2615.method4370()) {
            if(var4.field2585 == var1 && var4.field2577 < 0) {
               this.field2554[var1][var4.field2568] = null;
               this.field2554[var1][var2] = var4;
               int var5 = (var4.field2572 * var4.field2573 >> 12) + var4.field2586;
               var4.field2586 += var2 - var4.field2568 << 8;
               var4.field2572 = var5 - var4.field2586;
               var4.field2573 = 4096;
               var4.field2568 = var2;
               return;
            }
         }
      }

      class196 var9 = (class196)this.field2557.method380((long)this.field2539[var1]);
      if(var9 != null) {
         RawAudioNode var8 = var9.field2602[var2];
         if(var8 != null) {
            class112 var6 = new class112();
            var6.field2585 = var1;
            var6.field2571 = var9;
            var6.field2565 = var8;
            var6.field2566 = var9.field2606[var2];
            var6.field2583 = var9.field2607[var2];
            var6.field2568 = var2;
            var6.field2570 = var3 * var3 * var9.field2604[var2] * var9.field2603 + 1024 >> 11;
            var6.field2569 = var9.field2612[var2] & 255;
            var6.field2586 = (var2 << 8) - (var9.field2601[var2] & 32767);
            var6.field2574 = 0;
            var6.field2575 = 0;
            var6.field2564 = 0;
            var6.field2577 = -1;
            var6.field2578 = 0;
            if(this.field2540[var1] == 0) {
               var6.field2581 = class266.method5057(var8, this.method4874(var6), this.method4875(var6), this.method4876(var6));
            } else {
               var6.field2581 = class266.method5057(var8, this.method4874(var6), 0, this.method4876(var6));
               this.method4861(var6, var9.field2601[var2] < 0);
            }

            if(var9.field2601[var2] < 0) {
               var6.field2581.method5059(-1);
            }

            if(var6.field2583 >= 0) {
               class112 var7 = this.field2555[var1][var6.field2583];
               if(var7 != null && var7.field2577 < 0) {
                  this.field2554[var1][var7.field2568] = null;
                  var7.field2577 = 0;
               }

               this.field2555[var1][var6.field2583] = var6;
            }

            this.field2562.field2615.method4351(var6);
            this.field2554[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(Lho;I)I",
      garbageValue = "1203682086"
   )
   int method4876(class112 var1) {
      int var2 = this.field2536[var1.field2585];
      return var2 < 8192?var2 * var1.field2569 + 32 >> 6:16384 - ((128 - var1.field2569) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "378390219"
   )
   synchronized void method4852() {
      for(class196 var1 = (class196)this.field2557.method391(); var1 != null; var1 = (class196)this.field2557.method385()) {
         var1.method4002();
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "999693395"
   )
   void method4873(int var1, int var2) {
      this.field2553[var1] = var2;
      this.field2546[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("x")
   protected synchronized void vmethod6450(int var1) {
      if(this.field2556.method5997()) {
         int var2 = this.field2556.field2588 * this.field2538 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = this.field2560 + (long)var1 * (long)var2;
            if(this.field2561 - var3 >= 0L) {
               this.field2560 = var3;
               break;
            }

            int var5 = (int)((this.field2561 - this.field2560 + (long)var2 - 1L) / (long)var2);
            this.field2560 += (long)var2 * (long)var5;
            this.field2562.vmethod6450(var5);
            var1 -= var5;
            this.method4888();
         } while(this.field2556.method5997());
      }

      this.field2562.vmethod6450(var1);
   }

   @ObfuscatedName("m")
   protected synchronized int vmethod6465() {
      return 0;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "553866713"
   )
   void method4888() {
      int var1 = this.field2549;
      int var2 = this.field2559;

      long var3;
      for(var3 = this.field2561; var2 == this.field2559; var3 = this.field2556.method6009(var2)) {
         while(var2 == this.field2556.field2591[var1]) {
            this.field2556.method6036(var1);
            int var5 = this.field2556.method6006(var1);
            if(var5 == 1) {
               this.field2556.method6004();
               this.field2556.method6003(var1);
               if(this.field2556.method6011()) {
                  if(!this.field2547 || var2 == 0) {
                     this.method4869();
                     this.field2556.method6050();
                     return;
                  }

                  this.field2556.method6002(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method4924(var5);
            }

            this.field2556.method6005(var1);
            this.field2556.method6003(var1);
         }

         var1 = this.field2556.method6041();
         var2 = this.field2556.field2591[var1];
      }

      this.field2549 = var1;
      this.field2559 = var2;
      this.field2561 = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected synchronized TaskDataNode vmethod6446() {
      return null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "115"
   )
   void method4849(int var1, int var2) {
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(Lho;[IIII)Z",
      garbageValue = "-625274437"
   )
   boolean method4961(class112 var1, int[] var2, int var3, int var4) {
      var1.field2576 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2577 < 0 || var1.field2581 != null && !var1.field2581.method5073()) {
         int var5 = var1.field2573;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2558[var1.field2585]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2573 = var5;
         }

         var1.field2581.method5068(this.method4874(var1));
         class43 var6 = var1.field2566;
         boolean var7 = false;
         ++var1.field2579;
         var1.field2580 += var6.field2523;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2568 - 60 << 8) + (var1.field2572 * var1.field2573 >> 12));
         if(var6.field2522 > 0) {
            if(var6.field2525 > 0) {
               var1.field2574 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2525 * var8) + 0.5D);
            } else {
               var1.field2574 += 128;
            }
         }

         if(var6.field2521 != null) {
            if(var6.field2528 > 0) {
               var1.field2575 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2528 * var8) + 0.5D);
            } else {
               var1.field2575 += 128;
            }

            while(var1.field2564 < var6.field2521.length - 2 && var1.field2575 > (var6.field2521[var1.field2564 + 2] & 255) << 8) {
               var1.field2564 += 2;
            }

            if(var6.field2521.length - 2 == var1.field2564 && var6.field2521[var1.field2564 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2577 >= 0 && var6.field2524 != null && (this.field2548[var1.field2585] & 1) == 0 && (var1.field2583 < 0 || var1 != this.field2555[var1.field2585][var1.field2583])) {
            if(var6.field2527 > 0) {
               var1.field2577 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2527) + 0.5D);
            } else {
               var1.field2577 += 128;
            }

            while(var1.field2578 < var6.field2524.length - 2 && var1.field2577 > (var6.field2524[var1.field2578 + 2] & 255) << 8) {
               var1.field2578 += 2;
            }

            if(var6.field2524.length - 2 == var1.field2578) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2581.method5070(var1.field2576);
            if(var2 != null) {
               var1.field2581.vmethod6449(var2, var3, var4);
            } else {
               var1.field2581.vmethod6450(var4);
            }

            if(var1.field2581.method5074()) {
               this.field2562.field2617.method3581(var1.field2581);
            }

            var1.method1956();
            if(var1.field2577 >= 0) {
               var1.method6469();
               if(var1.field2583 > 0 && var1 == this.field2555[var1.field2585][var1.field2583]) {
                  this.field2555[var1.field2585][var1.field2583] = null;
               }
            }

            return true;
         } else {
            var1.field2581.method5069(var1.field2576, this.method4875(var1), this.method4876(var1));
            return false;
         }
      } else {
         var1.method1956();
         var1.method6469();
         if(var1.field2583 > 0 && var1 == this.field2555[var1.field2585][var1.field2583]) {
            this.field2555[var1.field2585][var1.field2583] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "726768352"
   )
   void method4936(int var1, int var2) {
      this.field2542[var1] = var2;
      this.field2544[var1] = var2 & -128;
      this.method4859(var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public synchronized void method4929() {
      for(class196 var1 = (class196)this.field2557.method391(); var1 != null; var1 = (class196)this.field2557.method385()) {
         var1.method6469();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-119"
   )
   void method4859(int var1, int var2) {
      if(var2 != this.field2539[var1]) {
         this.field2539[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2555[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1869804534"
   )
   void method4871(int var1) {
      if((this.field2548[var1] & 4) != 0) {
         for(class112 var2 = (class112)this.field2562.field2615.method4373(); var2 != null; var2 = (class112)this.field2562.field2615.method4358()) {
            if(var2.field2585 == var1) {
               var2.field2567 = 0;
            }
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-428564190"
   )
   void method4866(int var1) {
      for(class112 var2 = (class112)this.field2562.field2615.method4373(); var2 != null; var2 = (class112)this.field2562.field2615.method4358()) {
         if(var1 < 0 || var2.field2585 == var1) {
            if(var2.field2581 != null) {
               var2.field2581.method5070(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2581.method5074()) {
                  this.field2562.field2617.method3581(var2.field2581);
               }

               var2.method1956();
            }

            if(var2.field2577 < 0) {
               this.field2554[var2.field2585][var2.field2568] = null;
            }

            var2.method6469();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected synchronized TaskDataNode vmethod6454() {
      return this.field2562;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "104"
   )
   void method4931(int var1, int var2, int var3) {
      class112 var4 = this.field2554[var1][var2];
      if(var4 != null) {
         this.field2554[var1][var2] = null;
         if((this.field2548[var1] & 2) != 0) {
            for(class112 var5 = (class112)this.field2562.field2615.method4373(); var5 != null; var5 = (class112)this.field2562.field2615.method4358()) {
               if(var4.field2585 == var5.field2585 && var5.field2577 < 0 && var4 != var5) {
                  var4.field2577 = 0;
                  break;
               }
            }
         } else {
            var4.field2577 = 0;
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-57"
   )
   void method4867(int var1) {
      if(var1 >= 0) {
         this.field2551[var1] = 12800;
         this.field2536[var1] = 8192;
         this.field2541[var1] = 16383;
         this.field2543[var1] = 8192;
         this.field2552[var1] = 0;
         this.field2558[var1] = 8192;
         this.method4870(var1);
         this.method4871(var1);
         this.field2548[var1] = 0;
         this.field2545[var1] = 32767;
         this.field2550[var1] = 256;
         this.field2540[var1] = 0;
         this.method4873(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method4867(var1);
         }

      }
   }

   @ObfuscatedName("d")
   protected synchronized void vmethod6449(int[] var1, int var2, int var3) {
      if(this.field2556.method5997()) {
         int var4 = this.field2556.field2588 * this.field2538 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = this.field2560 + (long)var4 * (long)var3;
            if(this.field2561 - var5 >= 0L) {
               this.field2560 = var5;
               break;
            }

            int var7 = (int)((this.field2561 - this.field2560 + (long)var4 - 1L) / (long)var4);
            this.field2560 += (long)var7 * (long)var4;
            this.field2562.vmethod6449(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method4888();
         } while(this.field2556.method5997());
      }

      this.field2562.vmethod6449(var1, var2, var3);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1811422661"
   )
   void method4949(int var1) {
      for(class112 var2 = (class112)this.field2562.field2615.method4373(); var2 != null; var2 = (class112)this.field2562.field2615.method4358()) {
         if((var1 < 0 || var2.field2585 == var1) && var2.field2577 < 0) {
            this.field2554[var2.field2585][var2.field2568] = null;
            var2.field2577 = 0;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lhh;ZI)V",
      garbageValue = "214285867"
   )
   synchronized void method4854(Track1 var1, boolean var2) {
      this.method4974();
      this.field2556.method5999(var1.field2620);
      this.field2547 = var2;
      this.field2560 = 0L;
      int var3 = this.field2556.method6040();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2556.method6036(var4);
         this.field2556.method6005(var4);
         this.field2556.method6003(var4);
      }

      this.field2549 = this.field2556.method6041();
      this.field2559 = this.field2556.field2591[this.field2549];
      this.field2561 = this.field2556.method6009(this.field2559);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lho;ZB)V",
      garbageValue = "2"
   )
   void method4861(class112 var1, boolean var2) {
      int var3 = var1.field2565.audioBuffer.length;
      int var4;
      if(var2 && var1.field2565.field1344) {
         int var5 = var3 + var3 - var1.field2565.startPosition;
         var4 = (int)((long)var5 * (long)this.field2540[var1.field2585] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2581.method5066();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2540[var1.field2585] >> 6);
      }

      var1.field2581.method5065(var4);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1491002908"
   )
   void method4924(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4931(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method4860(var3, var4, var5);
         } else {
            this.method4931(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4863(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2544[var3] = (var5 << 14) + (this.field2544[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2544[var3] = (var5 << 7) + (this.field2544[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2552[var3] = (var5 << 7) + (this.field2552[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2552[var3] = var5 + (this.field2552[var3] & -128);
         }

         if(var4 == 5) {
            this.field2558[var3] = (var5 << 7) + (this.field2558[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2558[var3] = var5 + (this.field2558[var3] & -128);
         }

         if(var4 == 7) {
            this.field2551[var3] = (var5 << 7) + (this.field2551[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2551[var3] = var5 + (this.field2551[var3] & -128);
         }

         if(var4 == 10) {
            this.field2536[var3] = (var5 << 7) + (this.field2536[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2536[var3] = var5 + (this.field2536[var3] & -128);
         }

         if(var4 == 11) {
            this.field2541[var3] = (var5 << 7) + (this.field2541[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2541[var3] = var5 + (this.field2541[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2548[var3] |= 1;
            } else {
               this.field2548[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2548[var3] |= 2;
            } else {
               this.method4870(var3);
               this.field2548[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2545[var3] = (var5 << 7) + (this.field2545[var3] & 127);
         }

         if(var4 == 98) {
            this.field2545[var3] = (this.field2545[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2545[var3] = (var5 << 7) + (this.field2545[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2545[var3] = (this.field2545[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method4866(var3);
         }

         if(var4 == 121) {
            this.method4867(var3);
         }

         if(var4 == 123) {
            this.method4949(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2545[var3];
            if(var6 == 16384) {
               this.field2550[var3] = (var5 << 7) + (this.field2550[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2545[var3];
            if(var6 == 16384) {
               this.field2550[var3] = var5 + (this.field2550[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2540[var3] = (var5 << 7) + (this.field2540[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2540[var3] = var5 + (this.field2540[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2548[var3] |= 4;
            } else {
               this.method4871(var3);
               this.field2548[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method4873(var3, (var5 << 7) + (this.field2553[var3] & -16257));
         }

         if(var4 == 49) {
            this.method4873(var3, var5 + (this.field2553[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4859(var3, var4 + this.field2544[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4849(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method4865(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method4869();
         }
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(Lho;I)Z",
      garbageValue = "1414307274"
   )
   boolean method4882(class112 var1) {
      if(var1.field2581 == null) {
         if(var1.field2577 >= 0) {
            var1.method6469();
            if(var1.field2583 > 0 && var1 == this.field2555[var1.field2585][var1.field2583]) {
               this.field2555[var1.field2585][var1.field2583] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-460345433"
   )
   public synchronized boolean method4945() {
      return this.field2556.method5997();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "913950898"
   )
   void method4863(int var1, int var2, int var3) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-86"
   )
   public synchronized void method4879(int var1) {
      this.field2537 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "13950"
   )
   static void method4975() {
      for(class4 var0 = (class4)class4.field1051.method4373(); var0 != null; var0 = (class4)class4.field1051.method4358()) {
         if(var0.field1061 != null) {
            var0.method33();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lfa;",
      garbageValue = "-805510551"
   )
   public static Timer method4976() {
      try {
         return new NanoTimer();
      } catch (Throwable var1) {
         return new MilliTimer();
      }
   }
}
