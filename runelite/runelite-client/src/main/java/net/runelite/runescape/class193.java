package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public abstract class class193 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1438729841
   )
   public int field2112;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 287307001
   )
   public int field2114;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1010477233
   )
   public int field2115;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1712465923
   )
   public int field2116;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILfn;I)Z",
      garbageValue = "-526885180"
   )
   public abstract boolean vmethod4527(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1248667532"
   )
   static void method3792() {
      if(class219.worldMap != null) {
         class219.worldMap.method1204(class228.level, (class4.localPlayer.x >> 7) + class158.baseX, (class4.localPlayer.y >> 7) + class107.baseY, false);
         class219.worldMap.method1220();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Liu;I)V",
      garbageValue = "1423625373"
   )
   public static void method3793(Js5Index var0) {
      Varbit.varbit_ref = var0;
   }
}
