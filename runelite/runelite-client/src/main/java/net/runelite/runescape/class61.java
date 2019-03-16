package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
public class class61 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Liu;Ljava/lang/String;Ljava/lang/String;I)[Lls;",
      garbageValue = "-2027075443"
   )
   public static SpritePixels[] method887(Js5Index var0, String var1, String var2) {
      int var3 = var0.method1510(var1);
      int var4 = var0.method1532(var3, var2);
      byte[] var7 = var0.method1516(var3, var4, 1789634852);
      boolean var6;
      if(var7 == null) {
         var6 = false;
      } else {
         SceneTilePaint.method667(var7);
         var6 = true;
      }

      SpritePixels[] var5;
      if(!var6) {
         var5 = null;
      } else {
         SpritePixels[] var8 = new SpritePixels[class95.indexedSpriteCount];

         for(int var9 = 0; var9 < class95.indexedSpriteCount; ++var9) {
            SpritePixels var10 = var8[var9] = new SpritePixels();
            var10.maxWidth = class95.indexedSpriteWidth;
            var10.maxHeight = class95.indexedSpriteHeight;
            var10.offsetX = class95.indexedSpriteOffsetXs[var9];
            var10.offsetY = class95.indexedSpriteOffsetYs[var9];
            var10.width = class95.indexSpriteWidths[var9];
            var10.height = VarClientType.indexedSpriteHeights[var9];
            int var11 = var10.width * var10.height;
            byte[] var12 = class95.spritePixels[var9];
            var10.pixels = new int[var11];

            for(int var13 = 0; var13 < var11; ++var13) {
               var10.pixels[var13] = class95.indexedSpritePalette[var12[var13] & 255];
            }
         }

         class95.indexedSpriteOffsetXs = null;
         class95.indexedSpriteOffsetYs = null;
         class95.indexSpriteWidths = null;
         VarClientType.indexedSpriteHeights = null;
         class95.indexedSpritePalette = null;
         class95.spritePixels = null;
         var5 = var8;
      }

      return var5;
   }
}
