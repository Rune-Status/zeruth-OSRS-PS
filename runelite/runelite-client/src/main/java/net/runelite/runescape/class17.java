package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
public class class17 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "5990714"
   )
   static int method340(int var0, class106 var1, boolean var2) {
      ComponentType var3 = var2?class113.field75:class48.field1080;
      if(var0 == 1600) {
         class48.intStack[++class228.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class48.intStack[++class228.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class48.intStack[++class228.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class48.intStack[++class228.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class48.intStack[++class228.intStackSize - 1] = var3.zoom2d;
         return 1;
      } else if(var0 == 1606) {
         class48.intStack[++class228.intStackSize - 1] = var3.xan2d;
         return 1;
      } else if(var0 == 1607) {
         class48.intStack[++class228.intStackSize - 1] = var3.zan2d;
         return 1;
      } else if(var0 == 1608) {
         class48.intStack[++class228.intStackSize - 1] = var3.yan2d;
         return 1;
      } else if(var0 == 1609) {
         class48.intStack[++class228.intStackSize - 1] = var3.trans;
         return 1;
      } else if(var0 == 1610) {
         class48.intStack[++class228.intStackSize - 1] = var3.field2699;
         return 1;
      } else if(var0 == 1611) {
         class48.intStack[++class228.intStackSize - 1] = var3.color;
         return 1;
      } else if(var0 == 1612) {
         class48.intStack[++class228.intStackSize - 1] = var3.field2693;
         return 1;
      } else if(var0 == 1613) {
         class48.intStack[++class228.intStackSize - 1] = var3.field2744.vmethod5358();
         return 1;
      } else if(var0 == 1614) {
         class48.intStack[++class228.intStackSize - 1] = var3.field2725?1:0;
         return 1;
      } else {
         return 2;
      }
   }
}
