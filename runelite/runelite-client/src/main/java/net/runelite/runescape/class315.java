package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class315 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   static final class315 field245;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   static final class315 field251;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 655233447
   )
   final int field247;

   static {
      field251 = new class315(0);
      field245 = new class315(1);
   }

   class315(int var1) {
      this.field247 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Lel;",
      garbageValue = "93"
   )
   static Frames method5967(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.method951((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         Js5Index var3 = Sequence.skel_ref;
         Js5Index var4 = Sequence.skin_ref;
         boolean var5 = true;
         int[] var6 = var3.method1524(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method1521(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method1521(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(var2 != null) {
            Sequence.skeletons.method957(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1345146658"
   )
   public static boolean method5965(char var0) {
      return var0 >= ' ' && var0 <= '~'?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lju;",
      garbageValue = "-855287373"
   )
   public static FloorUnderlayDefinition method5966(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.method951((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.method1516(1, var0, 1789634852);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.method5041(new Packet(var2), var0);
         }

         var1.method5026();
         FloorUnderlayDefinition.underlays.method957(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1864650036"
   )
   static void method5964(int var0) {
      client.camModeType = var0;
   }
}
