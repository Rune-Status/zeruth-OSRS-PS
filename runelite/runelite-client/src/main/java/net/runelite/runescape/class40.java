package net.runelite.runescape;

import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("jz")
public class class40 {
   @ObfuscatedName("ko")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "110"
   )
   static void method597(String var0) {
      class116.sessionToken = var0;

      try {
         String var1 = class166.clientInstance.getParameter(Parameters.field3671.key);
         String var2 = class166.clientInstance.getParameter(Parameters.field3674.key);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         String var5;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = Tile.method4297() + 94608000000L;
            class238.field2463.setTime(new Date(var6));
            int var8 = class238.field2463.get(7);
            int var9 = class238.field2463.get(5);
            int var10 = class238.field2463.get(2);
            int var11 = class238.field2463.get(1);
            int var12 = class238.field2463.get(11);
            int var13 = class238.field2463.get(12);
            int var14 = class238.field2463.get(13);
            var5 = class238.field2466[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class238.field2464[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         client var16 = class166.clientInstance;
         var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var16).eval(var5);
      } catch (Throwable var15) {
         ;
      }

   }
}
