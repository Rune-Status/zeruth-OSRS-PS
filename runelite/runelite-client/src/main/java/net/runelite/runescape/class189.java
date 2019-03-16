package net.runelite.runescape;

import java.io.File;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class189 extends class127 {
   @ObfuscatedName("g")
   final boolean field1941;

   public class189(boolean var1) {
      this.field1941 = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method3712((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;I)I",
      garbageValue = "2066152605"
   )
   int method3712(ChatPlayer var1, ChatPlayer var2) {
      return client.world == var1.world && var2.world == client.world?(this.field1941?var1.field3706 - var2.field3706:var2.field3706 - var1.field3706):this.method2141(var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Lim;",
      garbageValue = "-91"
   )
   public static VarPlayerType method3717(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.method951((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.varplayer_ref.method1516(16, var0, 1789634852);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.method5530(new Packet(var2));
         }

         VarPlayerType.varplayers.method957(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;B)V",
      garbageValue = "0"
   )
   static void method3718(File var0) {
      class226.field3802 = var0;
      if(!class226.field3802.exists()) {
         throw new RuntimeException("");
      } else {
         class76.field2043 = true;
      }
   }
}
