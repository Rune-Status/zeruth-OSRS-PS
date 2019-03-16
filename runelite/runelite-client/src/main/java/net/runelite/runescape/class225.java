package net.runelite.runescape;

import java.util.HashMap;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public class class225 {
   @ObfuscatedName("rj")
   @ObfuscatedGetter(
      intValue = -1679228603
   )
   static int field3289;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Llc;"
   )
   Bounds field3282;
   @ObfuscatedName("e")
   int[] field3281;
   @ObfuscatedName("q")
   int[] field3286;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1185594465
   )
   int field3285;
   @ObfuscatedName("g")
   final HashMap field3284;

   public class225() {
      this.field3284 = new HashMap();
      this.field3282 = new Bounds(0, 0);
      this.field3281 = new int[2048];
      this.field3286 = new int[2048];
      this.field3285 = 0;
      class147.field209 = new int[2000];
      int var1 = 0;
      int var2 = 240;

      int var4;
      for(byte var3 = 12; var1 < 16; var2 -= var3) {
         var4 = class116.method2019((double)((float)var2 / 360.0F), 0.9998999834060669D, (double)(0.075F + 0.425F * (float)var1 / 16.0F));
         class147.field209[var1] = var4;
         ++var1;
      }

      var2 = 48;

      for(int var6 = var2 / 6; var1 < class147.field209.length; var2 -= var6) {
         var4 = var1 * 2;

         for(int var5 = class116.method2019((double)((float)var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < class147.field209.length; ++var1) {
            class147.field209[var1] = var5;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IS)Lls;",
      garbageValue = "18593"
   )
   SpritePixels method4473(int var1) {
      if(!this.field3284.containsKey(Integer.valueOf(var1))) {
         this.method4472(var1);
      }

      return (SpritePixels)this.field3284.get(Integer.valueOf(var1));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1117895153"
   )
   public final void method4474(int var1, int var2) {
      if(this.field3285 < this.field3281.length) {
         this.field3281[this.field3285] = var1;
         this.field3286[this.field3285] = var2;
         ++this.field3285;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1251368617"
   )
   public final void method4475() {
      this.field3285 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IILls;FB)V",
      garbageValue = "42"
   )
   public final void method4476(int var1, int var2, SpritePixels var3, float var4) {
      int var5 = (int)(var4 * 18.0F);
      SpritePixels var6 = this.method4473(var5);
      int var7 = var5 * 2 + 1;
      Bounds var8 = new Bounds(0, 0, var3.width, var3.height);
      Bounds var9 = new Bounds(0, 0);
      this.field3282.method1090(var7, var7);
      System.nanoTime();

      int var10;
      int var11;
      int var12;
      for(var10 = 0; var10 < this.field3285; ++var10) {
         var11 = this.field3281[var10];
         var12 = this.field3286[var10];
         int var13 = (int)(var4 * (float)(var11 - var1)) - var5;
         int var14 = (int)((float)var3.height - (float)(var12 - var2) * var4) - var5;
         this.field3282.method1089(var13, var14);
         this.field3282.method1092(var8, var9);
         this.method4480(var6, var3, var9);
      }

      System.nanoTime();
      System.nanoTime();

      for(var10 = 0; var10 < var3.pixels.length; ++var10) {
         if(var3.pixels[var10] == 0) {
            var3.pixels[var10] = -16777216;
         } else {
            var11 = (var3.pixels[var10] + 64 - 1) / 256;
            if(var11 <= 0) {
               var3.pixels[var10] = -16777216;
            } else {
               if(var11 > class147.field209.length) {
                  var11 = class147.field209.length;
               }

               var12 = class147.field209[var11 - 1];
               var3.pixels[var10] = -16777216 | var12;
            }
         }
      }

      System.nanoTime();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lls;Lls;Llc;I)V",
      garbageValue = "2145334866"
   )
   void method4480(SpritePixels var1, SpritePixels var2, Bounds var3) {
      if(var3.field3837 != 0 && var3.field3838 != 0) {
         int var4 = 0;
         int var5 = 0;
         if(var3.field3836 == 0) {
            var4 = var1.width - var3.field3837;
         }

         if(var3.field3835 == 0) {
            var5 = var1.height - var3.field3838;
         }

         int var6 = var4 + var5 * var1.width;
         int var7 = var2.width * var3.field3835 + var3.field3836;

         for(int var8 = 0; var8 < var3.field3838; ++var8) {
            for(int var9 = 0; var9 < var3.field3837; ++var9) {
               int var10001 = var7++;
               var2.pixels[var10001] += var1.pixels[var6++];
            }

            var6 += var1.width - var3.field3837;
            var7 += var2.width - var3.field3837;
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-67983406"
   )
   void method4472(int var1) {
      int var2 = var1 * 2 + 1;
      double[] var3 = class244.method4683(0.0D, (double)((float)var1 / 3.0F), var1);
      double var4 = var3[var1] * var3[var1];
      int[] var6 = new int[var2 * var2];
      boolean var7 = false;

      for(int var8 = 0; var8 < var2; ++var8) {
         for(int var9 = 0; var9 < var2; ++var9) {
            int var10 = var6[var9 + var2 * var8] = (int)(var3[var9] * var3[var8] / var4 * 256.0D);
            if(!var7 && var10 > 0) {
               var7 = true;
            }
         }
      }

      SpritePixels var11 = new SpritePixels(var6, var2, var2);
      this.field3284.put(Integer.valueOf(var1), var11);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Ljd;",
      garbageValue = "-74"
   )
   public static LocType method4485(int var0) {
      LocType var1 = (LocType)LocType.objects.method951((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = LocType.objects_ref.method1516(6, var0, 1789634852);
         var1 = new LocType();
         var1.field3469 = var0;
         if(var2 != null) {
            var1.method1709(new Packet(var2));
         }

         var1.method1738();
         if(var1.isHollow) {
            var1.clipType = 0;
            var1.blocksProjectile = false;
         }

         LocType.objects.method957(var1, (long)var0);
         return var1;
      }
   }
}
