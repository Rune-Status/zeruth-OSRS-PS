package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class150 {
   @ObfuscatedName("l")
   static byte[][] field2416;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -854642483
   )
   static int field2412;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2107553223
   )
   static int field2413;
   @ObfuscatedName("w")
   static int[] field2411;
   @ObfuscatedName("q")
   static byte[][] field2414;
   @ObfuscatedName("c")
   static byte[][] field2418;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lli;"
   )
   static IndexedSprite field2417;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1551156329
   )
   static int field2415;

   static {
      field2415 = 0;
      field2412 = 0;
      field2413 = 0;
      field2414 = new byte[1000][];
      field2418 = new byte[250][];
      field2416 = new byte[50][];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZI)[B",
      garbageValue = "136372879"
   )
   static synchronized byte[] method2553(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2415 > 0) {
         var2 = field2414[--field2415];
         field2414[field2415] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2412 > 0) {
         var2 = field2418[--field2412];
         field2418[field2412] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(field2413 > 0) {
         var2 = field2416[--field2413];
         field2416[field2413] = null;
         return var2;
      }

      if(class309.field3737 != null) {
         for(int var4 = 0; var4 < class134.field253.length; ++var4) {
            if(class134.field253[var4] != var0) {
               if(var0 < class134.field253[var4]) {
                  ;
               }
            } else if(field2411[var4] > 0) {
               byte[] var3 = class309.field3737[var4][--field2411[var4]];
               class309.field3737[var4][field2411[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "2133533907"
   )
   static void method2560(String var0, String var1, String var2) {
      class316.loginMessage1 = var0;
      class316.loginMessage2 = var1;
      class316.loginMessage3 = var2;
   }
}
