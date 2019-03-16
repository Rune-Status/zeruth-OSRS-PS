package net.runelite.runescape;

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lw")
public class class244 implements Comparator {
   @ObfuscatedName("g")
   final boolean field3834;

   public class244(boolean var1) {
      this.field3834 = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method4684((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;B)I",
      garbageValue = "117"
   )
   int method4684(Nameable var1, Nameable var2) {
      return this.field3834?var1.method2067().method4717(var2.method2067()):var2.method2067().method4717(var1.method2067());
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(DDII)[D",
      garbageValue = "-1180705805"
   )
   public static double[] method4683(double var0, double var2, int var4) {
      int var5 = var4 * 2 + 1;
      double[] var6 = new double[var5];
      int var7 = -var4;

      for(int var8 = 0; var7 <= var4; ++var8) {
         double var11 = HitmarkType.method2239(((double)var7 - var0) / var2) / var2;
         var6[var8] = var11;
         ++var7;
      }

      return var6;
   }
}
