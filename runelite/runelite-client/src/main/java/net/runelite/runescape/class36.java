package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSSpritePixels;

@ObfuscatedName("ew")
public class class36 extends class127 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[[Lhn;"
   )
   public static ComponentType[][] interfaces;
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Js5 defaults;
   @ObfuscatedName("g")
   final boolean field1950;

   public class36(boolean var1) {
      this.field1950 = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method570((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;B)I",
      garbageValue = "-23"
   )
   int method570(ChatPlayer var1, ChatPlayer var2) {
      return var2.world != var1.world?(this.field1950?var1.world - var2.world:var2.world - var1.world):this.method2141(var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Liu;IIB)Lls;"
   )
   public static SpritePixels method576(Js5Index var0, int var1, int var2, byte var3) {
      net.runelite.api.SpritePixels var4 = (net.runelite.api.SpritePixels) client.spriteOverrides.get(Integer.valueOf(var1));
      return var4 != null?(SpritePixels)((RSSpritePixels)var4):(SpritePixels) client.copy$getSpriteAsSpritePixels(var0, var1, var2, var3);
   }
}
