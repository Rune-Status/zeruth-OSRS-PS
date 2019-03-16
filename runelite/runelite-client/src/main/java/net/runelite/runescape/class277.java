package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class277 extends class127 {
   @ObfuscatedName("aw")
   static java.awt.Font field1963;
   @ObfuscatedName("g")
   final boolean field1961;

   public class277(boolean var1) {
      this.field1961 = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method5430((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;I)I",
      garbageValue = "-1463350425"
   )
   int method5430(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field1961?var1.method2067().method4717(var2.method2067()):var2.method2067().method4717(var1.method2067())):this.method2141(var1, var2);
   }
}
