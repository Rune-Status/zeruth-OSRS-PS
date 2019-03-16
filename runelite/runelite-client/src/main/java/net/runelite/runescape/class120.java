package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public class class120 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   static Js5Index field2530;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   static Js5Index field2531;
   @ObfuscatedName("p")
   static boolean field2534;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -171494185
   )
   static int field2533;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2131220885
   )
   public static int field2529;
   @ObfuscatedName("gj")
   static int[] landMapFileIds;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   static Js5Index field2535;

   static {
      field2529 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Z",
      garbageValue = "-14"
   )
   public static boolean method2043(CharSequence var0) {
      return ClanMemberManager.method4657(var0, 10, true);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1928379558"
   )
   public static int method2061(int var0, int var1) {
      return (var0 << 8) + var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Liu;Liu;Liu;Liu;I)V",
      garbageValue = "-1953204466"
   )
   public static void method2040(Js5Index var0, Js5Index var1, Js5Index var2, Js5Index var3) {
      ComponentType.componentIndex = var0;
      Frames.field1858 = var1;
      ChatPlayer.field3709 = var2;
      MapIcon.field282 = var3;
      class36.interfaces = new ComponentType[ComponentType.componentIndex.method1526()][];
      AuthProt.validInterfaces = new boolean[ComponentType.componentIndex.method1526()];
   }
}
