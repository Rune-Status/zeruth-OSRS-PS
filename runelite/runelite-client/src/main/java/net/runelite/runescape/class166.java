package net.runelite.runescape;

import java.io.File;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class166 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 861082277
   )
   static int archiveCount;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1501963651
   )
   static int historicCacheId;
   @ObfuscatedName("q")
   static File cacheLocator;
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Js5 interfacesArchive;
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static client clientInstance;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Ldr;"
   )
   public static CacheFile[] cacheIndex;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   public static CacheFile uidDat;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   public static CacheFile cacheDat;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   public static CacheFile masterIndex;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -1604029815
   )
   static int cameraX;

   static {
      uidDat = null;
      cacheDat = null;
      masterIndex = null;
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(Lbk;B)Z",
      garbageValue = "-14"
   )
   static boolean method2806(PlayerEntity var0) {
      return client.playerNameMask == 0?false:(class4.localPlayer == var0?class77.method1150():World.method3762() || Size.method4700() && var0.method2890() || class117.method2026() && var0.method2893());
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-408591114"
   )
   static void method2810() {
      Iterator var0 = class202.messages.iterator();

      while(var0.hasNext()) {
         ChatLine var1 = (ChatLine)var0.next();
         var1.method5647();
      }

   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1023661486"
   )
   static final void method2813(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = MilliTimer.method2824(var0, var1, class228.level) - var2;
         var0 -= cameraX;
         var3 -= Packet.cameraZ;
         var1 -= class98.cameraY;
         int var4 = Graphics3D.SINE[ScriptEvent.cameraPitch];
         int var5 = Graphics3D.COSINE[ScriptEvent.cameraPitch];
         int var6 = Graphics3D.SINE[class39.cameraYaw];
         int var7 = Graphics3D.COSINE[class39.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
         if(var1 >= 50) {
            client.screenX = var0 * client.scale / var1 + client.viewportWidth / 2;
            client.screenY = client.viewportHeight / 2 + var8 * client.scale / var1;
         } else {
            client.screenX = -1;
            client.screenY = -1;
         }

      } else {
         client.screenX = -1;
         client.screenY = -1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Liu;I)V",
      garbageValue = "-1103470235"
   )
   public static void method2812(Js5Index var0) {
      VarPlayerType.varplayer_ref = var0;
      VarPlayerType.field3302 = VarPlayerType.varplayer_ref.method1574(16);
   }
}
