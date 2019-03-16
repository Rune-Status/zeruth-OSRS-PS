package net.runelite.runescape;

import java.text.DecimalFormat;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class316 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 199867437
   )
   static int loginWindowX;
   @ObfuscatedName("aq")
   static String loginMessage2;
   @ObfuscatedName("bb")
   static boolean field1171;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lls;"
   )
   static SpritePixels field1145;
   @ObfuscatedName("bm")
   static boolean worldSelectShown;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1048301153
   )
   static int field1143;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lli;"
   )
   static IndexedSprite field1149;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -519018961
   )
   static int field1153;
   @ObfuscatedName("bs")
   static String loginMessage3;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 298189025
   )
   static int field1142;
   @ObfuscatedName("k")
   static int[] field1162;
   @ObfuscatedName("w")
   static ScheduledExecutorService field1155;
   @ObfuscatedName("bz")
   static String username;
   @ObfuscatedName("bg")
   static boolean field1172;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      longValue = -1798151601264494561L
   )
   static long field1178;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1458167475
   )
   static int field1164;
   @ObfuscatedName("au")
   static String loginMessage1;
   @ObfuscatedName("ba")
   static String password;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lli;"
   )
   static IndexedSprite field1148;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -683412213
   )
   static int field1157;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lls;"
   )
   static SpritePixels field1146;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -2026203849
   )
   static int field1156;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1077160203
   )
   static int field1152;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lli;"
   )
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("av")
   static String Login_response0;
   @ObfuscatedName("bk")
   static boolean field1170;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static Packet NetCache_reference;
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "Llc;"
   )
   static Bounds field1177;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -88006171
   )
   static int currentLoginField;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1856389737
   )
   static int field1161;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      longValue = 70445526910048995L
   )
   static long field1179;
   @ObfuscatedName("ar")
   static String loadingText;
   @ObfuscatedName("s")
   static int[] field1151;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 74399869
   )
   static int field1173;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1276746081
   )
   static int loginIndex;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1125970667
   )
   static int field1160;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1198123297
   )
   static int loadingBarPercentage;
   @ObfuscatedName("g")
   static boolean field1174;

   static {
      field1143 = 0;
      loginWindowX = field1143 + 202;
      field1162 = new int[256];
      field1152 = 0;
      field1153 = 0;
      field1160 = 0;
      field1173 = 0;
      field1156 = 0;
      field1157 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      field1142 = -1;
      field1161 = 1;
      loginIndex = 0;
      Login_response0 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1170 = false;
      field1171 = false;
      field1172 = true;
      currentLoginField = 0;
      worldSelectShown = false;
      field1164 = -1;
      new DecimalFormat("##0.00");
      new class321();
      field1178 = -1L;
      field1179 = -1L;
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "736184686"
   )
   public static final void method5992(String var0, String var1, int var2, int var3, int var4, int var5) {
      DState.method5638(var0, var1, var2, var3, var4, var5, false);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2145314583"
   )
   public static void method5989(int var0) {
      if(var0 != -1) {
         if(AuthProt.validInterfaces[var0]) {
            ComponentType.componentIndex.method1528(var0);
            if(class36.interfaces[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class36.interfaces[var0].length; ++var2) {
                  if(class36.interfaces[var0][var2] != null) {
                     if(class36.interfaces[var0][var2].type != 2) {
                        class36.interfaces[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class36.interfaces[var0] = null;
               }

               AuthProt.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-747992457"
   )
   static final int method5993(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 65280) * var2 + (var0 & 65280) * var3 & 16711680) + ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) >> 8;
   }
}
