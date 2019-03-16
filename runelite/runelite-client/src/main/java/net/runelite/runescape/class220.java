package net.runelite.runescape;

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class220 implements Comparator {
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -1117226937
   )
   static int port1;
   @ObfuscatedName("g")
   final boolean field1929;

   public class220(boolean var1) {
      this.field1929 = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method4427((ChatPlayer)var1, (ChatPlayer)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;B)I",
      garbageValue = "-43"
   )
   int method4427(ChatPlayer var1, ChatPlayer var2) {
      return this.field1929?var1.field3706 - var2.field3706:var2.field3706 - var1.field3706;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lji;",
      garbageValue = "-160716252"
   )
   public static StructType method4431(int var0) {
      StructType var1 = (StructType)StructType.structTypeCache.method951((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = StructType.field3411.method1516(34, var0, 1789634852);
         var1 = new StructType();
         if(var2 != null) {
            var1.method5702(new Packet(var2));
         }

         var1.method5699();
         StructType.structTypeCache.method957(var1, (long)var0);
         return var1;
      }
   }
}
