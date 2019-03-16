package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lz")
public class class296 {
   @ObfuscatedName("l")
   String field3939;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 67966615
   )
   int field3937;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   Js5Index field3936;
   @ObfuscatedName("n")
   boolean loaded;

   @ObfuscatedSignature(
      signature = "(Liu;)V"
   )
   class296(Js5Index var1) {
      this.field3937 = 0;
      this.loaded = false;
      this.field3936 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-831040829"
   )
   int method5687() {
      if(this.field3937 < 25) {
         if(!this.field3936.method1538(MapCacheArchiveNames.field288.name, this.field3939)) {
            return this.field3937;
         }

         this.field3937 = 25;
      }

      if(this.field3937 == 25) {
         if(!this.field3936.method1538(this.field3939, MapCacheArchiveNames.field290.name)) {
            return 25 + this.field3936.method1530(this.field3939) * 25 / 100;
         }

         this.field3937 = 50;
      }

      if(this.field3937 == 50) {
         if(this.field3936.method1533(MapCacheArchiveNames.field289.name, this.field3939) && !this.field3936.method1538(MapCacheArchiveNames.field289.name, this.field3939)) {
            return 50;
         }

         this.field3937 = 75;
      }

      if(this.field3937 == 75) {
         if(!this.field3936.method1538(this.field3939, MapCacheArchiveNames.field292.name)) {
            return 75;
         }

         this.field3937 = 100;
         this.loaded = true;
      }

      return this.field3937;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   boolean method5688() {
      return this.loaded;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1854239508"
   )
   int method5697() {
      return this.field3937;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-94401394"
   )
   void method5686(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3939) {
            this.field3939 = var1;
            this.field3937 = 0;
            this.loaded = false;
            this.method5687();
         }
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-525992078"
   )
   static int method5693(int var0, class106 var1, boolean var2) {
      int var3;
      int var4;
      int var6;
      if(var0 == 3400) {
         class228.intStackSize -= 2;
         var3 = class48.intStack[class228.intStackSize];
         var4 = class48.intStack[class228.intStackSize + 1];
         Enum var5 = class106.method1885(var3);
         if(var5.valType != 's') {
            ;
         }

         for(var6 = 0; var6 < var5.size; ++var6) {
            if(var4 == var5.keys[var6]) {
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var5.stringVals[var6];
               var5 = null;
               break;
            }
         }

         if(var5 != null) {
            class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var5.defaultString;
         }

         return 1;
      } else if(var0 != 3408) {
         if(var0 == 3411) {
            var3 = class48.intStack[--class228.intStackSize];
            Enum var10 = class106.method1885(var3);
            class48.intStack[++class228.intStackSize - 1] = var10.method6511();
            return 1;
         } else {
            return 2;
         }
      } else {
         class228.intStackSize -= 4;
         var3 = class48.intStack[class228.intStackSize];
         var4 = class48.intStack[class228.intStackSize + 1];
         int var9 = class48.intStack[class228.intStackSize + 2];
         var6 = class48.intStack[class228.intStackSize + 3];
         Enum var7 = class106.method1885(var9);
         if(var3 == var7.keyType && var4 == var7.valType) {
            for(int var8 = 0; var8 < var7.size; ++var8) {
               if(var6 == var7.keys[var8]) {
                  if(var4 == 115) {
                     class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var7.stringVals[var8];
                  } else {
                     class48.intStack[++class228.intStackSize - 1] = var7.intVals[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var7.defaultString;
               } else {
                  class48.intStack[++class228.intStackSize - 1] = var7.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "null";
            } else {
               class48.intStack[++class228.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
