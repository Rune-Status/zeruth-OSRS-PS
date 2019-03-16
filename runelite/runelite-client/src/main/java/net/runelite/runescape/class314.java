package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class314 extends class127 {
   @ObfuscatedName("g")
   final boolean field1942;

   public class314(boolean var1) {
      this.field1942 = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method5960((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;I)I",
      garbageValue = "2077126230"
   )
   int method5960(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field1942?var1.field3706 - var2.field3706:var2.field3706 - var1.field3706):this.method2141(var1, var2);
   }
}
