package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class224 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   Js5Index vorbis_index;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   HashTable field1395;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   HashTable field1396;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   Js5Index sfx_index;

   @ObfuscatedSignature(
      signature = "(Liu;Liu;)V"
   )
   public class224(Js5Index var1, Js5Index var2) {
      this.field1395 = new HashTable(256);
      this.field1396 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[IB)Lct;",
      garbageValue = "7"
   )
   RawAudioNode method4464(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      RawAudioNode var7 = (RawAudioNode)this.field1396.method380(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class237 var8 = (class237)this.field1395.method380(var5);
         if(var8 == null) {
            var8 = class237.method4593(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1395.method382(var8, var5);
         }

         var7 = var8.method4594(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.method6469();
            this.field1396.method382(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[II)Lct;",
      garbageValue = "-1877233226"
   )
   public RawAudioNode method4467(int var1, int[] var2) {
      if(this.sfx_index.method1526() == 1) {
         return this.method4463(0, var1, var2);
      } else if(this.sfx_index.method1574(var1) == 1) {
         return this.method4463(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[II)Lct;",
      garbageValue = "-1312593645"
   )
   public RawAudioNode method4470(int var1, int[] var2) {
      if(this.vorbis_index.method1526() == 1) {
         return this.method4464(0, var1, var2);
      } else if(this.vorbis_index.method1574(var1) == 1) {
         return this.method4464(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[II)Lct;",
      garbageValue = "1531393813"
   )
   RawAudioNode method4463(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      RawAudioNode var7 = (RawAudioNode)this.field1396.method380(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.method605(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method611();
            this.field1396.method382(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.audioBuffer.length;
            }

            return var7;
         }
      }
   }
}
