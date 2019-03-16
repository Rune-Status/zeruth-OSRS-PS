package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class228 extends class193 {
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 305214507
   )
   static int level;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1157110077
   )
   static int intStackSize;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -494678709
   )
   static int field605;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -203870391
   )
   static int authcode;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILfn;I)Z",
      garbageValue = "-526885180"
   )
   public boolean vmethod4527(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2116 && var3 == super.field2112;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "2081859532"
   )
   static int method4530(int var0, class106 var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class48.intStack[--intStackSize];
         class48.scriptStringStack[++class48.scriptStringStackSize - 1] = Varcs.method4770(var3).name;
         return 1;
      } else {
         int var4;
         ObjType var5;
         if(var0 == 4201) {
            intStackSize -= 2;
            var3 = class48.intStack[intStackSize];
            var4 = class48.intStack[intStackSize + 1];
            var5 = Varcs.method4770(var3);
            if(var4 >= 1 && var4 <= 5 && var5.ops[var4 - 1] != null) {
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var5.ops[var4 - 1];
            } else {
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            intStackSize -= 2;
            var3 = class48.intStack[intStackSize];
            var4 = class48.intStack[intStackSize + 1];
            var5 = Varcs.method4770(var3);
            if(var4 >= 1 && var4 <= 5 && var5.iops[var4 - 1] != null) {
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var5.iops[var4 - 1];
            } else {
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class48.intStack[--intStackSize];
            class48.intStack[++intStackSize - 1] = Varcs.method4770(var3).cost;
            return 1;
         } else if(var0 == 4204) {
            var3 = class48.intStack[--intStackSize];
            class48.intStack[++intStackSize - 1] = Varcs.method4770(var3).stackable == 1?1:0;
            return 1;
         } else {
            ObjType var6;
            if(var0 == 4205) {
               var3 = class48.intStack[--intStackSize];
               var6 = Varcs.method4770(var3);
               if(var6.certTemplate == -1 && var6.certLink >= 0) {
                  class48.intStack[++intStackSize - 1] = var6.certLink;
               } else {
                  class48.intStack[++intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class48.intStack[--intStackSize];
               var6 = Varcs.method4770(var3);
               if(var6.certTemplate >= 0 && var6.certLink >= 0) {
                  class48.intStack[++intStackSize - 1] = var6.certLink;
               } else {
                  class48.intStack[++intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class48.intStack[--intStackSize];
               class48.intStack[++intStackSize - 1] = Varcs.method4770(var3).members?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class48.intStack[--intStackSize];
               var6 = Varcs.method4770(var3);
               if(var6.placeholderTemplate == -1 && var6.placeholderLink >= 0) {
                  class48.intStack[++intStackSize - 1] = var6.placeholderLink;
               } else {
                  class48.intStack[++intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class48.intStack[--intStackSize];
               var6 = Varcs.method4770(var3);
               if(var6.placeholderTemplate >= 0 && var6.placeholderLink >= 0) {
                  class48.intStack[++intStackSize - 1] = var6.placeholderLink;
               } else {
                  class48.intStack[++intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var7 = class48.scriptStringStack[--class48.scriptStringStackSize];
               var4 = class48.intStack[--intStackSize];
               MouseInput.method5783(var7, var4 == 1);
               class48.intStack[++intStackSize - 1] = MilliTimer.field1983;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  class192.field69 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(class124.field325 != null && class192.field69 < MilliTimer.field1983) {
                  class48.intStack[++intStackSize - 1] = class124.field325[++class192.field69 - 1] & '\uffff';
               } else {
                  class48.intStack[++intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "105487488"
   )
   public static void method4529() {
      VarPlayerType.varplayers.method952();
   }
}
