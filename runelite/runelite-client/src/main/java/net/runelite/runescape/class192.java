package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class192 {
   @ObfuscatedName("st")
   @ObfuscatedGetter(
      intValue = -294209173
   )
   static int field69;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 249775407
   )
   static int field70;
   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Js5 synths;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -1428641971
   )
   static int field68;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "38"
   )
   static void method3787(int var0, String var1, String var2, String var3) {
      client.onAddChatMessage(var0, var1, var2, var3);
      ChatLineBuffer var4 = (ChatLineBuffer)class202.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class202.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      ChatLine var5 = var4.method1933(var0, var1, var2, var3);
      class202.messages.method2749(var5, (long)var5.id);
      class202.field1247.method5799(var5);
      client.chatCycle = client.cycleCntr;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Lhn;",
      garbageValue = "-1832191649"
   )
   public static ComponentType method3785(int var0, int var1) {
      ComponentType var2 = WorldMapType1.method2440(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "1861109886"
   )
   static char method3783(char var0) {
      return (char)(var0 == 198?69:(var0 == 230?101:(var0 == 223?115:(var0 == 338?69:(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Lcx;",
      garbageValue = "0"
   )
   static class106 method3782(int var0) {
      class106 var1 = (class106)class106.field1261.method951((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = UrlRequester.clientscripts.method1516(var0, 0, 1789634852);
         if(var2 == null) {
            return null;
         } else {
            var1 = ProjectileAnimation.method5593(var2);
            class106.field1261.method957(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "19"
   )
   public static int method3781(int var0) {
      return var0 >> 11 & 63;
   }
}
