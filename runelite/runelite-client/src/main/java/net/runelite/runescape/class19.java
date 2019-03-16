package net.runelite.runescape;

import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public abstract class class19 {
   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Js5 worldmapdata;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1086705871"
   )
   public abstract boolean vmethod5599(int var1) throws IOException;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "106"
   )
   public abstract int vmethod5598() throws IOException;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-254118928"
   )
   public abstract int vmethod5607() throws IOException;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-636832531"
   )
   public abstract void vmethod5603();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-860102320"
   )
   public abstract int vmethod5600(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2088230859"
   )
   public abstract void vmethod5623(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "2073714027"
   )
   static int method379(int var0, class106 var1, boolean var2) {
      if(var0 == 6500) {
         class48.intStack[++class228.intStackSize - 1] = class107.method1889()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            var3 = WorldComparator.method6474();
            if(var3 != null) {
               class48.intStack[++class228.intStackSize - 1] = var3.id;
               class48.intStack[++class228.intStackSize - 1] = var3.mask;
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3.activity;
               class48.intStack[++class228.intStackSize - 1] = var3.location;
               class48.intStack[++class228.intStackSize - 1] = var3.playerCount;
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3.address;
            } else {
               class48.intStack[++class228.intStackSize - 1] = -1;
               class48.intStack[++class228.intStackSize - 1] = 0;
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
               class48.intStack[++class228.intStackSize - 1] = 0;
               class48.intStack[++class228.intStackSize - 1] = 0;
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            var3 = WorldMapRectangle.method124();
            if(var3 != null) {
               class48.intStack[++class228.intStackSize - 1] = var3.id;
               class48.intStack[++class228.intStackSize - 1] = var3.mask;
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3.activity;
               class48.intStack[++class228.intStackSize - 1] = var3.location;
               class48.intStack[++class228.intStackSize - 1] = var3.playerCount;
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3.address;
            } else {
               class48.intStack[++class228.intStackSize - 1] = -1;
               class48.intStack[++class228.intStackSize - 1] = 0;
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
               class48.intStack[++class228.intStackSize - 1] = 0;
               class48.intStack[++class228.intStackSize - 1] = 0;
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var7;
            if(var0 == 6506) {
               var7 = class48.intStack[--class228.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var7 == World.worldList[var5].id) {
                     var4 = World.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class48.intStack[++class228.intStackSize - 1] = var4.id;
                  class48.intStack[++class228.intStackSize - 1] = var4.mask;
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var4.activity;
                  class48.intStack[++class228.intStackSize - 1] = var4.location;
                  class48.intStack[++class228.intStackSize - 1] = var4.playerCount;
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var4.address;
               } else {
                  class48.intStack[++class228.intStackSize - 1] = -1;
                  class48.intStack[++class228.intStackSize - 1] = 0;
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                  class48.intStack[++class228.intStackSize - 1] = 0;
                  class48.intStack[++class228.intStackSize - 1] = 0;
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class228.intStackSize -= 4;
               var7 = class48.intStack[class228.intStackSize];
               boolean var10 = class48.intStack[class228.intStackSize + 1] == 1;
               var5 = class48.intStack[class228.intStackSize + 2];
               boolean var6 = class48.intStack[class228.intStackSize + 3] == 1;
               ScriptEvent.method4036(var7, var10, var5, var6);
               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  client.field788 = class48.intStack[--class228.intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  ParamType var9;
                  if(var0 == 6513) {
                     class228.intStackSize -= 2;
                     var7 = class48.intStack[class228.intStackSize];
                     var8 = class48.intStack[class228.intStackSize + 1];
                     var9 = class134.method2203(var8);
                     if(var9.method4102()) {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = FileRequest.method4030(var7).method5840(var8, var9.defaultStr);
                     } else {
                        class48.intStack[++class228.intStackSize - 1] = FileRequest.method4030(var7).method5839(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     class228.intStackSize -= 2;
                     var7 = class48.intStack[class228.intStackSize];
                     var8 = class48.intStack[class228.intStackSize + 1];
                     var9 = class134.method2203(var8);
                     if(var9.method4102()) {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = class225.method4485(var7).method1719(var8, var9.defaultStr);
                     } else {
                        class48.intStack[++class228.intStackSize - 1] = class225.method4485(var7).method1718(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     class228.intStackSize -= 2;
                     var7 = class48.intStack[class228.intStackSize];
                     var8 = class48.intStack[class228.intStackSize + 1];
                     var9 = class134.method2203(var8);
                     if(var9.method4102()) {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = Varcs.method4770(var7).method6318(var8, var9.defaultStr);
                     } else {
                        class48.intStack[++class228.intStackSize - 1] = Varcs.method4770(var7).method6343(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     class228.intStackSize -= 2;
                     var7 = class48.intStack[class228.intStackSize];
                     var8 = class48.intStack[class228.intStackSize + 1];
                     var9 = class134.method2203(var8);
                     if(var9.method4102()) {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = class220.method4431(var7).method5703(var8, var9.defaultStr);
                     } else {
                        class48.intStack[++class228.intStackSize - 1] = class220.method4431(var7).method5698(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class48.intStack[++class228.intStackSize - 1] = client.field770?1:0;
                     return 1;
                  } else if(var0 == 6519) {
                     class48.intStack[++class228.intStackSize - 1] = client.confClientType & 3;
                     return 1;
                  } else if(var0 == 6520) {
                     return 1;
                  } else if(var0 == 6521) {
                     return 1;
                  } else if(var0 == 6522) {
                     --class48.scriptStringStackSize;
                     --class228.intStackSize;
                     return 1;
                  } else if(var0 == 6523) {
                     --class48.scriptStringStackSize;
                     --class228.intStackSize;
                     return 1;
                  } else if(var0 == 6524) {
                     class48.intStack[++class228.intStackSize - 1] = -1;
                     return 1;
                  } else if(var0 == 6525) {
                     class48.intStack[++class228.intStackSize - 1] = 1;
                     return 1;
                  } else if(var0 == 6526) {
                     class48.intStack[++class228.intStackSize - 1] = 1;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var7 = class48.intStack[--class228.intStackSize];
               if(var7 >= 0 && var7 < World.worldCount) {
                  var4 = World.worldList[var7];
                  class48.intStack[++class228.intStackSize - 1] = var4.id;
                  class48.intStack[++class228.intStackSize - 1] = var4.mask;
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var4.activity;
                  class48.intStack[++class228.intStackSize - 1] = var4.location;
                  class48.intStack[++class228.intStackSize - 1] = var4.playerCount;
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var4.address;
               } else {
                  class48.intStack[++class228.intStackSize - 1] = -1;
                  class48.intStack[++class228.intStackSize - 1] = 0;
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                  class48.intStack[++class228.intStackSize - 1] = 0;
                  class48.intStack[++class228.intStackSize - 1] = 0;
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }
}
