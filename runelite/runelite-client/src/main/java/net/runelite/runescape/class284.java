package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class284 {
   @ObfuscatedName("ax")
   static int[] field322;
   @ObfuscatedName("l")
   int[][] field319;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -542358189
   )
   int field320;
   @ObfuscatedName("e")
   int[][] field315;
   @ObfuscatedName("q")
   int[][] field318;
   @ObfuscatedName("c")
   int[][] field316;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -172387241
   )
   int field317;

   class284(int var1, int var2) {
      this.field317 = var1;
      this.field320 = var2;
      this.field315 = new int[var1][var2];
      this.field318 = new int[var1][var2];
      this.field316 = new int[var1][var2];
      this.field319 = new int[var1][var2];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-928050166"
   )
   int method5557(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field317 && var2 < this.field320) {
         if(this.field316[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field315[var1][var2] / this.field319[var1][var2];
            int var4 = this.field318[var1][var2] / this.field319[var1][var2];
            int var5 = this.field316[var1][var2] / this.field319[var1][var2];
            return class116.method2019((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILju;B)V",
      garbageValue = "6"
   )
   void method5559(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field317 && var2 - var3 <= this.field320) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field317, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field320, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field315[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field318[var9][var10] += var4.saturation;
                     this.field316[var9][var10] += var4.lightness;
                     ++this.field319[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1545928521"
   )
   static int method5563(int var0) {
      ChatLine var1 = (ChatLine)class202.messages.method2764((long)var0);
      return var1 == null?-1:(var1.previous == class202.field1247.sentinel?-1:((ChatLine)var1.previous).id);
   }
}
