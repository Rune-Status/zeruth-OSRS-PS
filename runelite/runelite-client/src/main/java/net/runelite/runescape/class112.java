package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class112 extends Node {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1838475019
   )
   int field2580;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 140417105
   )
   int field2568;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 114477921
   )
   int field2578;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   class196 field2571;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lct;"
   )
   RawAudioNode field2565;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1318406025
   )
   int field2569;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   class43 field2566;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1150554595
   )
   int field2577;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -690233925
   )
   int field2574;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1937218999
   )
   int field2573;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 841340885
   )
   int field2570;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   class266 field2581;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1864442519
   )
   int field2567;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1053330145
   )
   int field2586;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1945201277
   )
   int field2583;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -430930619
   )
   int field2576;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 241961673
   )
   int field2572;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 869368161
   )
   int field2575;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1421371783
   )
   int field2564;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1363786397
   )
   int field2579;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2102402217
   )
   int field2585;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1830692633"
   )
   void method1956() {
      this.field2571 = null;
      this.field2565 = null;
      this.field2566 = null;
      this.field2581 = null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1474359120"
   )
   static final void method1958() {
      class115.method2002("Your friend list is full. Max of 200 for free users, and 400 for members");
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljb;",
      garbageValue = "-1189840038"
   )
   public static HitmarkType method1959(int var0) {
      HitmarkType var1 = (HitmarkType)HitmarkType.hitmarkTypeCache.method951((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class92.field2355.method1516(32, var0, 1789634852);
         var1 = new HitmarkType();
         if(var2 != null) {
            var1.method2206(new Packet(var2));
         }

         HitmarkType.hitmarkTypeCache.method957(var1, (long)var0);
         return var1;
      }
   }
}
