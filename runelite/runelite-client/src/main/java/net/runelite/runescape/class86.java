package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class86 extends class127 {
   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "[Lls;"
   )
   static SpritePixels[] crossSprites;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = 1731517175
   )
   static int myWorldPort;
   @ObfuscatedName("g")
   final boolean field1946;

   public class86(boolean var1) {
      this.field1946 = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method1398((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;B)I",
      garbageValue = "-67"
   )
   int method1398(ChatPlayer var1, ChatPlayer var2) {
      if(var1.world != 0) {
         if(var2.world == 0) {
            return this.field1946?-1:1;
         }
      } else if(var2.world != 0) {
         return this.field1946?1:-1;
      }

      return this.method2141(var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IILfv;Lfn;I)Z",
      garbageValue = "-929669781"
   )
   public static final boolean method1405(int var0, int var1, class193 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class32.field2105[var6][var7] = 99;
      class32.field2103[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class32.field2106[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class32.field2110[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class32.field2106[var11];
         var5 = class32.field2110[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod4527(2, var4, var5, var3)) {
            class259.field2809 = var4;
            class32.field2107 = var5;
            return true;
         }

         int var15 = class32.field2103[var16][var17] + 1;
         if(var16 > 0 && class32.field2105[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class32.field2106[var18] = var4 - 1;
            class32.field2110[var18] = var5;
            var18 = var18 + 1 & 4095;
            class32.field2105[var16 - 1][var17] = 2;
            class32.field2103[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class32.field2105[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class32.field2106[var18] = var4 + 1;
            class32.field2110[var18] = var5;
            var18 = var18 + 1 & 4095;
            class32.field2105[var16 + 1][var17] = 8;
            class32.field2103[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class32.field2105[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class32.field2106[var18] = var4;
            class32.field2110[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class32.field2105[var16][var17 - 1] = 1;
            class32.field2103[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class32.field2105[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class32.field2106[var18] = var4;
            class32.field2110[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class32.field2105[var16][var17 + 1] = 4;
            class32.field2103[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class32.field2105[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class32.field2106[var18] = var4 - 1;
            class32.field2110[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class32.field2105[var16 - 1][var17 - 1] = 3;
            class32.field2103[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class32.field2105[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class32.field2106[var18] = var4 + 1;
            class32.field2110[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class32.field2105[var16 + 1][var17 - 1] = 9;
            class32.field2103[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class32.field2105[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class32.field2106[var18] = var4 - 1;
            class32.field2110[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class32.field2105[var16 - 1][var17 + 1] = 6;
            class32.field2103[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class32.field2105[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class32.field2106[var18] = var4 + 1;
            class32.field2110[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class32.field2105[var16 + 1][var17 + 1] = 12;
            class32.field2103[var16 + 1][var17 + 1] = var15;
         }
      }

      class259.field2809 = var4;
      class32.field2107 = var5;
      return false;
   }
}
