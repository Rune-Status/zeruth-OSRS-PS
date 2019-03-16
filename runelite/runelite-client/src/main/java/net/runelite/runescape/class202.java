package net.runelite.runescape;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class202 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   static final IterableHashTable messages;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   static final IterableDualNodeQueue field1247;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -977061203
   )
   static int field1246;
   @ObfuscatedName("ej")
   static int[] previousLoginXteaKeys;
   @ObfuscatedName("g")
   static final Map chatLineMap;

   static {
      chatLineMap = new HashMap();
      messages = new IterableHashTable(1024);
      field1247 = new IterableDualNodeQueue();
      field1246 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1487164387"
   )
   static void method4068(Component var0) {
      var0.removeKeyListener(KeyFocusListener.keyboard);
      var0.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field383 = -1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1475978689"
   )
   static int method4072(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1939();
   }

   @ObfuscatedName("c")
   public static int method4050(long var0) {
      return (int)(var0 >>> 7 & 127L);
   }

   @ObfuscatedName("ku")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "438985548"
   )
   static String method4069(String var0) {
      ChatCrownType[] var1 = class116.method2020();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         ChatCrownType var3 = var1[var2];
         if(var3.icon != -1 && var0.startsWith(WorldMapDecoration.method2945(var3.icon))) {
            var0 = var0.substring(6 + Integer.toString(var3.icon).length());
            break;
         }
      }

      return var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Liu;Liu;B)V",
      garbageValue = "-99"
   )
   public static void method4070(Js5Index var0, Js5Index var1) {
      Spotanim.SpotAnimationDefinition_indexCache = var0;
      Spotanim.SpotAnimationDefinition_modelIndexCache = var1;
   }
}
