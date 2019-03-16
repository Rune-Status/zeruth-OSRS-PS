package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class232 {
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   static ModeWhere field2441;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1156425740"
   )
   public static boolean method4564(int var0) {
      if(AuthProt.validInterfaces[var0]) {
         return true;
      } else if(!ComponentType.componentIndex.method1517(var0)) {
         return false;
      } else {
         int var1 = ComponentType.componentIndex.method1574(var0);
         if(var1 == 0) {
            AuthProt.validInterfaces[var0] = true;
            return true;
         } else {
            if(class36.interfaces[var0] == null) {
               class36.interfaces[var0] = new ComponentType[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class36.interfaces[var0][var2] == null) {
                  byte[] var3 = ComponentType.componentIndex.method1516(var0, var2, 1789634852);
                  if(var3 != null) {
                     class36.interfaces[var0][var2] = new ComponentType();
                     class36.interfaces[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class36.interfaces[var0][var2].method226(new Packet(var3));
                     } else {
                        class36.interfaces[var0][var2].method227(new Packet(var3));
                     }
                  }
               }
            }

            AuthProt.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "120115909"
   )
   static final int method4573(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = GZipDecompressor.method5450(var3, var5);
      int var8 = GZipDecompressor.method5450(var3 + 1, var5);
      int var9 = GZipDecompressor.method5450(var3, var5 + 1);
      int var10 = GZipDecompressor.method5450(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var8 * var12 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = ((65536 - var14) * var9 >> 16) + (var14 * var10 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
      return var15;
   }
}
