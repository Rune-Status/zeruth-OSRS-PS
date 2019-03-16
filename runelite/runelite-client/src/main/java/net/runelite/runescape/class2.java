package net.runelite.runescape;

import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class2 {
   @ObfuscatedName("qy")
   @ObfuscatedSignature(
      signature = "Lcn;"
   )
   static class184 field413;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      longValue = 4058981623060603261L
   )
   static long field411;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(Lbl;S)V",
      garbageValue = "24128"
   )
   static final void method19(PendingSpawn var0) {
      long var1 = 0L;
      int var3 = -1;
      int var4 = 0;
      int var5 = 0;
      if(var0.type == 0) {
         var1 = class131.sceneManager.method3821(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class131.sceneManager.method3822(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class131.sceneManager.method3823(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class131.sceneManager.method3920(var0.level, var0.x, var0.y);
      }

      if(0L != var1) {
         int var6 = class131.sceneManager.method3825(var0.level, var0.x, var0.y, var1);
         var3 = SubInterface.method2437(var1);
         var4 = var6 & 31;
         var5 = var6 >> 6 & 3;
      }

      var0.field923 = var3;
      var0.field924 = var4;
      var0.field935 = var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "776902865"
   )
   static final int method21(int var0, int var1) {
      int var2 = class232.method4573(var0 + 45365, var1 + 91923, 4) - 128 + (class232.method4573(var0 + 10294, var1 + 37821, 2) - 128 >> 1) + (class232.method4573(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Lgp;II)Lgp;",
      garbageValue = "1443720514"
   )
   public static Enumerated method20(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.vmethod5358()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)[Lcb;",
      garbageValue = "16"
   )
   static AttackOpPriority[] method16() {
      return new AttackOpPriority[]{AttackOpPriority.PRIORITISED, AttackOpPriority.HIDDEN, AttackOpPriority.UNPRIORITISED, AttackOpPriority.COMBAT_LEVEL_BASED};
   }
}
