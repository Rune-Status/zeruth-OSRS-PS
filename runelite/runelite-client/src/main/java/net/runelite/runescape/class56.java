package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class56 {
   @ObfuscatedName("l")
   protected static boolean audioHighMemory;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "363997811"
   )
   static int method850(int var0, class106 var1, boolean var2) {
      int var4 = -1;
      ComponentType var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class48.intStack[--class228.intStackSize];
         var3 = WorldMapType1.method2440(var4);
      } else {
         var3 = var2?class113.field75:class48.field1080;
      }

      if(var0 == 1100) {
         class228.intStackSize -= 2;
         var3.scrollX = class48.intStack[class228.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class48.intStack[class228.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class208.method4144(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.color = class48.intStack[--class228.intStackSize];
         class208.method4144(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class48.intStack[--class228.intStackSize] == 1;
         class208.method4144(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.trans = class48.intStack[--class228.intStackSize];
         class208.method4144(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class48.intStack[--class228.intStackSize];
         class208.method4144(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.graphic = class48.intStack[--class228.intStackSize];
         class208.method4144(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.angle2d = class48.intStack[--class228.intStackSize];
         class208.method4144(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.tile = class48.intStack[--class228.intStackSize] == 1;
         class208.method4144(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class48.intStack[--class228.intStackSize];
         class208.method4144(var3);
         return 1;
      } else if(var0 == 1109) {
         class228.intStackSize -= 6;
         var3.offsetX2d = class48.intStack[class228.intStackSize];
         var3.offsetY2d = class48.intStack[class228.intStackSize + 1];
         var3.xan2d = class48.intStack[class228.intStackSize + 2];
         var3.yan2d = class48.intStack[class228.intStackSize + 3];
         var3.zan2d = class48.intStack[class228.intStackSize + 4];
         var3.zoom2d = class48.intStack[class228.intStackSize + 5];
         class208.method4144(var3);
         return 1;
      } else {
         int var8;
         if(var0 == 1110) {
            var8 = class48.intStack[--class228.intStackSize];
            if(var8 != var3.animation) {
               var3.animation = var8;
               var3.field2795 = 0;
               var3.field2750 = 0;
               class208.method4144(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.orthogonal = class48.intStack[--class228.intStackSize] == 1;
            class208.method4144(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = class48.scriptStringStack[--class48.scriptStringStackSize];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               class208.method4144(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class48.intStack[--class228.intStackSize];
            class208.method4144(var3);
            return 1;
         } else if(var0 == 1114) {
            class228.intStackSize -= 3;
            var3.horizTextAlign = class48.intStack[class228.intStackSize];
            var3.vertTextAlign = class48.intStack[class228.intStackSize + 1];
            var3.lineHeight = class48.intStack[class228.intStackSize + 2];
            class208.method4144(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadow = class48.intStack[--class228.intStackSize] == 1;
            class208.method4144(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.outline = class48.intStack[--class228.intStackSize];
            class208.method4144(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.shadow = class48.intStack[--class228.intStackSize];
            class208.method4144(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.vflip = class48.intStack[--class228.intStackSize] == 1;
            class208.method4144(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.hflip = class48.intStack[--class228.intStackSize] == 1;
            class208.method4144(var3);
            return 1;
         } else if(var0 == 1120) {
            class228.intStackSize -= 2;
            var3.scrollWidth = class48.intStack[class228.intStackSize];
            var3.scrollHeight = class48.intStack[class228.intStackSize + 1];
            class208.method4144(var3);
            if(var4 != -1 && var3.type == 0) {
               class196.method4011(class36.interfaces[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            Sequence.method4796(var3.id, var3.index);
            client.field880 = var3;
            class208.method4144(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2703 = class48.intStack[--class228.intStackSize];
            class208.method4144(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2693 = class48.intStack[--class228.intStackSize];
            class208.method4144(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2699 = class48.intStack[--class228.intStackSize];
            class208.method4144(var3);
            return 1;
         } else if(var0 == 1125) {
            var8 = class48.intStack[--class228.intStackSize];
            class271 var6 = (class271)class2.method20(GameObject.method2038(), var8);
            if(var6 != null) {
               var3.field2744 = var6;
               class208.method4144(var3);
            }

            return 1;
         } else {
            boolean var5;
            if(var0 == 1126) {
               var5 = class48.intStack[--class228.intStackSize] == 1;
               var3.lineDirection = var5;
               return 1;
            } else if(var0 == 1127) {
               var5 = class48.intStack[--class228.intStackSize] == 1;
               var3.field2725 = var5;
               return 1;
            } else {
               return 2;
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Liu;II)Lhv;",
      garbageValue = "-779833062"
   )
   static class196 method851(Js5Index var0, int var1) {
      byte[] var2 = var0.method1520(var1);
      return var2 == null?null:new class196(var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "16711680"
   )
   public static int method852(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & '?');
         } else {
            var0[var4++] = (byte)(224 | var6 >> '\f');
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & '?');
         }
      }

      return var4 - var1;
   }
}
