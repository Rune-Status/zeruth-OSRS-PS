package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
public enum class182 implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljq;"
   )
   field3563(0, 0),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljq;"
   )
   field3559(1, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljq;"
   )
   field3560(2, 2);

   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1411562493
   )
   public final int field3562;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1748229439
   )
   final int field3561;

   class182(int var3, int var4) {
      this.field3562 = var3;
      this.field3561 = var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int vmethod5358() {
      return this.field3561;
   }

   @ObfuscatedName("g")
   public static final void method3129(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }
}
