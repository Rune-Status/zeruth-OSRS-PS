package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class80 extends class127 {
   @ObfuscatedName("z")
   static String osNameRaw;
   @ObfuscatedName("g")
   final boolean field1956;

   public class80(boolean var1) {
      this.field1956 = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method1160((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;I)I",
      garbageValue = "-628508580"
   )
   int method1160(ChatPlayer var1, ChatPlayer var2) {
      return var2.rank != var1.rank?(this.field1956?var1.rank - var2.rank:var2.rank - var1.rank):this.method2141(var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-1994298062"
   )
   static final void method1166(String var0, int var1) {
      TcpConnectionMessage var2 = FaceNormal.method5726(ClientProt.FRIEND_SETRANK, client.serverConnection.isaac);
      var2.packetBuffer.putByte(AbstractSoundSystem.method338(var0) + 1);
      var2.packetBuffer.method6198(var0);
      var2.packetBuffer.putByte(var1);
      client.serverConnection.method5881(var2);
   }
}
