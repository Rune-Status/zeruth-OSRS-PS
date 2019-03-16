package net.runelite.runescape;

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
final class class116 implements Comparator {
   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("bb")
   static String sessionToken;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[Lli;"
   )
   static IndexedSprite[] runeSprites;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -1408131799
   )
   static int field51;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static Js5Index field49;

   public int compare(Object var1, Object var2) {
      return this.method2008((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Le;Le;B)I",
      garbageValue = "-54"
   )
   int method2008(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method806().compareTo(var2.method806());
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(Lbp;ZS)V",
      garbageValue = "180"
   )
   static final void method2007(SubInterface var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.method6469();
      if(var1) {
         class316.method5989(var2);
      }

      class248.method4712(var2);
      ComponentType var4 = WorldMapType1.method2440(var3);
      if(var4 != null) {
         class208.method4144(var4);
      }

      for(int var5 = 0; var5 < client.menuOptionCount; ++var5) {
         if(VarClientStringType.method184(client.menuTypes[var5])) {
            if(var5 < client.menuOptionCount - 1) {
               for(int var6 = var5; var6 < client.menuOptionCount - 1; ++var6) {
                  client.menuOptions[var6] = client.menuOptions[var6 + 1];
                  client.menuTargets[var6] = client.menuTargets[var6 + 1];
                  client.menuTypes[var6] = client.menuTypes[var6 + 1];
                  client.menuIdentifiers[var6] = client.menuIdentifiers[var6 + 1];
                  client.menuActionParams0[var6] = client.menuActionParams0[var6 + 1];
                  client.menuActionParams1[var6] = client.menuActionParams1[var6 + 1];
                  client.menuBooleanArray[var6] = client.menuBooleanArray[var6 + 1];
               }
            }

            --var5;
            --client.menuOptionCount;
            client.onMenuOptionsChanged(-1);
         }
      }

      class261.method5015();
      if(client.toplevel != -1) {
         class124.method2087(client.toplevel, 1);
      }

   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1188891119"
   )
   static final void method2022(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class232.method4564(var0)) {
         class219.method4424(class36.interfaces[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)[Lif;",
      garbageValue = "-523285600"
   )
   public static ChatCrownType[] method2020() {
      return new ChatCrownType[]{ChatCrownType.STAFF_MOD, ChatCrownType.HARDCORE_IRONMAN, ChatCrownType.IRONMAN, ChatCrownType.NONE, ChatCrownType.PLAYER_MOD, ChatCrownType.ULTIMATE_IRONMAN};
   }

   @ObfuscatedName("g")
   public static final int method2019(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(var2 != 0.0D) {
         double var12;
         if(var4 < 0.5D) {
            var12 = var4 * (1.0D + var2);
         } else {
            var12 = var2 + var4 - var4 * var2;
         }

         double var14 = var4 * 2.0D - var12;
         double var16 = var0 + 0.3333333333333333D;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = var14 + 6.0D * (var12 - var14) * var16;
         } else if(2.0D * var16 < 1.0D) {
            var6 = var12;
         } else if(var16 * 3.0D < 2.0D) {
            var6 = var14 + (0.6666666666666666D - var16) * (var12 - var14) * 6.0D;
         } else {
            var6 = var14;
         }

         if(6.0D * var0 < 1.0D) {
            var8 = var14 + var0 * (var12 - var14) * 6.0D;
         } else if(2.0D * var0 < 1.0D) {
            var8 = var12;
         } else if(var0 * 3.0D < 2.0D) {
            var8 = var14 + 6.0D * (0.6666666666666666D - var0) * (var12 - var14);
         } else {
            var8 = var14;
         }

         if(6.0D * var20 < 1.0D) {
            var10 = var14 + var20 * 6.0D * (var12 - var14);
         } else if(2.0D * var20 < 1.0D) {
            var10 = var12;
         } else if(var20 * 3.0D < 2.0D) {
            var10 = var14 + 6.0D * (var12 - var14) * (0.6666666666666666D - var20);
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(var6 * 256.0D);
      int var13 = (int)(256.0D * var8);
      int var23 = (int)(var10 * 256.0D);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)[Lfs;",
      garbageValue = "-90"
   )
   static LoginProt[] method2010() {
      return new LoginProt[]{LoginProt.field2310, LoginProt.field2315, LoginProt.field2313, LoginProt.field2311, LoginProt.field2312};
   }
}
