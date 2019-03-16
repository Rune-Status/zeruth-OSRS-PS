package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class82 extends class127 {
   @ObfuscatedName("sc")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   public static class225 field1933;
   @ObfuscatedName("c")
   static byte[][][] tileOverlayIds;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static Font field1931;
   @ObfuscatedName("g")
   final boolean field1934;

   public class82(boolean var1) {
      this.field1934 = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method1174((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;I)I",
      garbageValue = "-1022267585"
   )
   int method1174(ChatPlayer var1, ChatPlayer var2) {
      return client.world == var1.world && var2.world == client.world?(this.field1934?var1.method2067().method4717(var2.method2067()):var2.method2067().method4717(var1.method2067())):this.method2141(var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "49958749"
   )
   static int method1178(int var0, class106 var1, boolean var2) {
      return var0 < 1000?class98.method1634(var0, var1, var2):(var0 < 1100?CollisionData.method225(var0, var1, var2):(var0 < 1200?class56.method850(var0, var1, var2):(var0 < 1300?MapCacheArchiveNames.method2147(var0, var1, var2):(var0 < 1400?FriendContainer.method2424(var0, var1, var2):(var0 < 1500?WorldMapType1.method2465(var0, var1, var2):(var0 < 1600?Location.method2961(var0, var1, var2):(var0 < 1700?class17.method340(var0, var1, var2):(var0 < 1800?ChatLine.method5653(var0, var1, var2):(var0 < 1900?PendingSpawn.method5556(var0, var1, var2):(var0 < 2000?ItemContainer.method1931(var0, var1, var2):(var0 < 2100?CollisionData.method225(var0, var1, var2):(var0 < 2200?class56.method850(var0, var1, var2):(var0 < 2300?MapCacheArchiveNames.method2147(var0, var1, var2):(var0 < 2400?FriendContainer.method2424(var0, var1, var2):(var0 < 2500?WorldMapType1.method2465(var0, var1, var2):(var0 < 2600?GZipDecompressor.method5447(var0, var1, var2):(var0 < 2700?class310.method5925(var0, var1, var2):(var0 < 2800?ServerConnection.method5898(var0, var1, var2):(var0 < 2900?GameCanvas.method896(var0, var1, var2):(var0 < 3000?ItemContainer.method1931(var0, var1, var2):(var0 < 3200?class218.method4412(var0, var1, var2):(var0 < 3300?Sequence.method4813(var0, var1, var2):(var0 < 3400?class331.method6494(var0, var1, var2):(var0 < 3500?class296.method5693(var0, var1, var2):(var0 < 3700?VarPlayerType.method5548(var0, var1, var2):(var0 < 4000?class321.method6057(var0, var1, var2):(var0 < 4100?FontName.method1974(var0, var1, var2):(var0 < 4200?class139.method2416(var0, var1, var2):(var0 < 4300?class228.method4530(var0, var1, var2):(var0 < 5100?VarClientType.method5426(var0, var1, var2):(var0 < 5400?class147.method2535(var0, var1, var2):(var0 < 5600?class133.method2183(var0, var1, var2):(var0 < 5700?class9.method140(var0, var1, var2):(var0 < 6300?Spotanim.method5319(var0, var1, var2):(var0 < 6600?class19.method379(var0, var1, var2):(var0 < 6700?class70.method1086(var0, var1, var2):2))))))))))))))))))))))))))))))))))));
   }
}
