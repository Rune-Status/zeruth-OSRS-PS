package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class267 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static class257 field2461;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static FileRequest currentRequest;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIIB)Z",
      garbageValue = "-42"
   )
   static final boolean method5221(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Packet var4 = new Packet(var0);
      int var5 = -1;

      label68:
      while(true) {
         int var6 = var4.method6093();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.readUSmart();
               if(var9 == 0) {
                  continue label68;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  LocType var15 = class225.method4485(var5);
                  if(var12 != 22 || !client.lowMemory || var15.field3470 != 0 || var15.clipType == 1 || var15.obstructsGround) {
                     if(!var15.method1712()) {
                        ++client.field753;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.readUSmart();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }
}
