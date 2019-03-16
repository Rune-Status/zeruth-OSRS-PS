package net.runelite.runescape;

import java.util.concurrent.Callable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class60 implements Callable {
   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   static class19 field524;

   public Object call() {
      return NPCType.method5843();
   }

   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-45"
   )
   public static boolean method885() {
      return client.staffModLevel >= 2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2095812020"
   )
   public static void method886() {
      StructType.structTypeCache.method952();
   }

   @ObfuscatedName("ka")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1669330682"
   )
   static final void method877() {
      TcpConnectionMessage var0 = FaceNormal.method5726(ClientProt.CLAN_JOINCHAT_LEAVECHAT, client.serverConnection.isaac);
      var0.packetBuffer.putByte(0);
      client.serverConnection.method5881(var0);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lhn;I[B[BI)V",
      garbageValue = "1837958195"
   )
   static final void method884(ComponentType var0, int var1, byte[] var2, byte[] var3) {
      if(var0.opKeys == null) {
         if(var2 == null) {
            return;
         }

         var0.opKeys = new byte[11][];
         var0.opKeyModifiers = new byte[11][];
         var0.opKeyRates = new int[11];
         var0.field2745 = new int[11];
      }

      var0.opKeys[var1] = var2;
      if(var2 != null) {
         var0.field2724 = true;
      } else {
         var0.field2724 = false;

         for(int var4 = 0; var4 < var0.opKeys.length; ++var4) {
            if(var0.opKeys[var4] != null) {
               var0.field2724 = true;
               break;
            }
         }
      }

      var0.opKeyModifiers[var1] = var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2044193390"
   )
   public static int method883(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }
}
