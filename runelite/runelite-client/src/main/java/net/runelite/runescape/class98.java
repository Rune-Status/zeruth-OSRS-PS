package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public final class class98 {
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "[Lli;"
   )
   static IndexedSprite[] slStarSprites;
   @ObfuscatedName("l")
   static byte[][][] tileOverlayPath;
   @ObfuscatedName("r")
   static byte[][][] tileSettings;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -935206517
   )
   static int field493;
   @ObfuscatedName("k")
   static final int[] field497;
   @ObfuscatedName("w")
   static byte[][][] field503;
   @ObfuscatedName("p")
   static int[] floorSaturations;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 275237055
   )
   static int field498;
   @ObfuscatedName("a")
   static final int[] field491;
   @ObfuscatedName("z")
   static final int[] field501;
   @ObfuscatedName("n")
   static int[][] field496;
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Js5 configs;
   @ObfuscatedName("t")
   static final int[] field499;
   @ObfuscatedName("y")
   static final int[] field507;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = -414697091
   )
   static int cameraY;
   @ObfuscatedName("s")
   static final int[] field502;
   @ObfuscatedName("lz")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static ComponentType field495;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -768994373
   )
   static int field504;
   @ObfuscatedName("g")
   static int[][][] tileHeights;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field493 = 99;
      field491 = new int[]{1, 2, 4, 8};
      field499 = new int[]{16, 32, 64, 128};
      field497 = new int[]{1, 0, -1, 0};
      field501 = new int[]{0, -1, 0, 1};
      field502 = new int[]{1, -1, -1, 1};
      field507 = new int[]{-1, -1, 1, 1};
      field504 = (int)(Math.random() * 17.0D) - 8;
      field498 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILcx;ZB)I",
      garbageValue = "-28"
   )
   static int method1634(int var0, class106 var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         class228.intStackSize -= 3;
         var3 = class48.intStack[class228.intStackSize];
         var4 = class48.intStack[class228.intStackSize + 1];
         int var5 = class48.intStack[class228.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            ComponentType var6 = WorldMapType1.method2440(var3);
            if(var6.children == null) {
               var6.children = new ComponentType[var5 + 1];
            }

            if(var6.children.length <= var5) {
               ComponentType[] var7 = new ComponentType[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               ComponentType var12 = new ComponentType();
               var12.type = var4;
               var12.layer = var12.id = var6.id;
               var12.index = var5;
               var12.isIf3 = true;
               var6.children[var5] = var12;
               if(var2) {
                  class113.field75 = var12;
               } else {
                  class48.field1080 = var12;
               }

               class208.method4144(var6);
               return 1;
            }
         }
      } else {
         ComponentType var9;
         if(var0 == 101) {
            var9 = var2?class113.field75:class48.field1080;
            ComponentType var10 = WorldMapType1.method2440(var9.id);
            var10.children[var9.index] = null;
            class208.method4144(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = WorldMapType1.method2440(class48.intStack[--class228.intStackSize]);
            var9.children = null;
            class208.method4144(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = WorldMapType1.method2440(class48.intStack[--class228.intStackSize]);
               if(var9 != null) {
                  class48.intStack[++class228.intStackSize - 1] = 1;
                  if(var2) {
                     class113.field75 = var9;
                  } else {
                     class48.field1080 = var9;
                  }
               } else {
                  class48.intStack[++class228.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class228.intStackSize -= 2;
            var3 = class48.intStack[class228.intStackSize];
            var4 = class48.intStack[class228.intStackSize + 1];
            ComponentType var11 = class192.method3785(var3, var4);
            if(var11 != null && var4 != -1) {
               class48.intStack[++class228.intStackSize - 1] = 1;
               if(var2) {
                  class113.field75 = var11;
               } else {
                  class48.field1080 = var11;
               }
            } else {
               class48.intStack[++class228.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZZB)I",
      garbageValue = "30"
   )
   public static int method1661(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class258.NetCache_pendingPriorityWritesCount + class258.NetCache_pendingPriorityResponsesCount;
      return var3;
   }
}
