package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
public enum class101 implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3290(2, 0),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3291(1, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3296(0, 2);

   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -821866543
   )
   public final int field3292;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -368658495
   )
   final int field3294;

   class101(int var3, int var4) {
      this.field3292 = var3;
      this.field3294 = var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int vmethod5358() {
      return this.field3294;
   }

   @ObfuscatedName("kh")
   @ObfuscatedSignature(
      signature = "(Lhn;I)I",
      garbageValue = "2134482714"
   )
   static int method1704(ComponentType var0) {
      IntegerNode var1 = (IntegerNode) client.serverActiveProperties.method380(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.value:var0.activeProperties;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "8"
   )
   public static boolean method1706(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1163401710"
   )
   static void method1698(int var0, int var1) {
      if(client.field877 != 0 && var0 != -1) {
         class139.method2413(Isaac.jingles, var0, 0, client.field877, false);
         client.field879 = true;
      }

   }
}
