package net.runelite.runescape;

import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class311 {
   @ObfuscatedName("r")
   public static int[] serverVarps;
   @ObfuscatedName("e")
   public static int[] clientVarps;
   @ObfuscatedName("g")
   static int[] varpsMasks;

   static {
      varpsMasks = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         varpsMasks[var1] = var0 - 1;
         var0 += var0;
      }

      serverVarps = new int[4000];
      clientVarps = new int[4000];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-714835684"
   )
   public static void method5933(boolean var0) {
      if(class258.NetCache_socket != null) {
         try {
            Packet var1 = new Packet(4);
            var1.putByte(var0?2:3);
            var1.method6064(0);
            class258.NetCache_socket.vmethod5623(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class258.NetCache_socket.vmethod5603();
            } catch (Exception var3) {
               ;
            }

            ++class258.field3278;
            class258.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "0"
   )
   static final void method5932(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.widgetCount; ++var4) {
         if(client.widgetBoundsWidth[var4] + client.widgetPositionX[var4] > var0 && client.widgetPositionX[var4] < var0 + var2 && client.widgetBoundsHeight[var4] + client.widgetPositionY[var4] > var1 && client.widgetPositionY[var4] < var3 + var1) {
            client.field849[var4] = true;
         }
      }

   }
}
