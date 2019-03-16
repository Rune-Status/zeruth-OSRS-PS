package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
public class class331 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   static Huffman huffman;

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-944627353"
   )
   static int method6494(int var0, class106 var1, boolean var2) {
      if(var0 == 3300) {
         class48.intStack[++class228.intStackSize - 1] = client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         if(var0 == 3301) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = GrandExchangeOffer.method2886(var3, var4);
            return 1;
         } else if(var0 == 3302) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = UrlRequest.method5565(var3, var4);
            return 1;
         } else if(var0 == 3303) {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            class48.intStack[++class228.intStackSize - 1] = PlayerEntity.method2936(var3, var4);
            return 1;
         } else if(var0 == 3304) {
            var3 = class48.intStack[--class228.intStackSize];
            class48.intStack[++class228.intStackSize - 1] = class91.method1502(var3).field3299;
            return 1;
         } else if(var0 == 3305) {
            var3 = class48.intStack[--class228.intStackSize];
            class48.intStack[++class228.intStackSize - 1] = client.skillLevels[var3];
            return 1;
         } else if(var0 == 3306) {
            var3 = class48.intStack[--class228.intStackSize];
            class48.intStack[++class228.intStackSize - 1] = client.skillBaseLevels[var3];
            return 1;
         } else if(var0 == 3307) {
            var3 = class48.intStack[--class228.intStackSize];
            class48.intStack[++class228.intStackSize - 1] = client.skillExperiences[var3];
            return 1;
         } else {
            int var5;
            if(var0 == 3308) {
               var3 = class228.level;
               var4 = (class4.localPlayer.x >> 7) + class158.baseX;
               var5 = (class4.localPlayer.y >> 7) + class107.baseY;
               class48.intStack[++class228.intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
               return 1;
            } else if(var0 == 3309) {
               var3 = class48.intStack[--class228.intStackSize];
               class48.intStack[++class228.intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if(var0 == 3310) {
               var3 = class48.intStack[--class228.intStackSize];
               class48.intStack[++class228.intStackSize - 1] = var3 >> 28;
               return 1;
            } else if(var0 == 3311) {
               var3 = class48.intStack[--class228.intStackSize];
               class48.intStack[++class228.intStackSize - 1] = var3 & 16383;
               return 1;
            } else if(var0 == 3312) {
               class48.intStack[++class228.intStackSize - 1] = client.isMembers?1:0;
               return 1;
            } else if(var0 == 3313) {
               class228.intStackSize -= 2;
               var3 = class48.intStack[class228.intStackSize] + 32768;
               var4 = class48.intStack[class228.intStackSize + 1];
               class48.intStack[++class228.intStackSize - 1] = GrandExchangeOffer.method2886(var3, var4);
               return 1;
            } else if(var0 == 3314) {
               class228.intStackSize -= 2;
               var3 = class48.intStack[class228.intStackSize] + 32768;
               var4 = class48.intStack[class228.intStackSize + 1];
               class48.intStack[++class228.intStackSize - 1] = UrlRequest.method5565(var3, var4);
               return 1;
            } else if(var0 == 3315) {
               class228.intStackSize -= 2;
               var3 = class48.intStack[class228.intStackSize] + 32768;
               var4 = class48.intStack[class228.intStackSize + 1];
               class48.intStack[++class228.intStackSize - 1] = PlayerEntity.method2936(var3, var4);
               return 1;
            } else if(var0 == 3316) {
               if(client.staffModLevel >= 2) {
                  class48.intStack[++class228.intStackSize - 1] = client.staffModLevel;
               } else {
                  class48.intStack[++class228.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3317) {
               class48.intStack[++class228.intStackSize - 1] = client.rebootTimer;
               return 1;
            } else if(var0 == 3318) {
               class48.intStack[++class228.intStackSize - 1] = client.world;
               return 1;
            } else if(var0 == 3321) {
               class48.intStack[++class228.intStackSize - 1] = client.energy;
               return 1;
            } else if(var0 == 3322) {
               class48.intStack[++class228.intStackSize - 1] = client.weight;
               return 1;
            } else if(var0 == 3323) {
               if(client.playermod) {
                  class48.intStack[++class228.intStackSize - 1] = 1;
               } else {
                  class48.intStack[++class228.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3324) {
               class48.intStack[++class228.intStackSize - 1] = client.flags;
               return 1;
            } else if(var0 == 3325) {
               class228.intStackSize -= 4;
               var3 = class48.intStack[class228.intStackSize];
               var4 = class48.intStack[class228.intStackSize + 1];
               var5 = class48.intStack[class228.intStackSize + 2];
               int var6 = class48.intStack[class228.intStackSize + 3];
               var3 += var4 << 14;
               var3 += var5 << 28;
               var3 += var6;
               class48.intStack[++class228.intStackSize - 1] = var3;
               return 1;
            } else {
               return 2;
            }
         }
      }
   }
}
