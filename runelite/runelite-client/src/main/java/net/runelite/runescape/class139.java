package net.runelite.runescape;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class139 extends class19 {
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = -88168043
   )
   static int field2051;
   @ObfuscatedName("u")
   static int[] field2048;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   class133 field2049;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   GameSocket field2046;
   @ObfuscatedName("g")
   Socket field2047;

   public class139(Socket var1, int var2, int var3) throws IOException {
      this.field2047 = var1;
      this.field2047.setSoTimeout(30000);
      this.field2047.setTcpNoDelay(true);
      this.field2047.setReceiveBufferSize(65536);
      this.field2047.setSendBufferSize(65536);
      this.field2049 = new class133(this.field2047.getInputStream(), var2);
      this.field2046 = new GameSocket(this.field2047.getOutputStream(), var3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1086705871"
   )
   public boolean vmethod5599(int var1) throws IOException {
      return this.field2049.method2186(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "106"
   )
   public int vmethod5598() throws IOException {
      return this.field2049.method2184();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-254118928"
   )
   public int vmethod5607() throws IOException {
      return this.field2049.method2185();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-636832531"
   )
   public void vmethod5603() {
      this.field2046.method4286();

      try {
         this.field2047.close();
      } catch (IOException var2) {
         ;
      }

      this.field2049.method2192();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-860102320"
   )
   public int vmethod5600(byte[] var1, int var2, int var3) throws IOException {
      return this.field2049.method2194(var1, var2, var3);
   }

   protected void finalize() {
      this.vmethod5603();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2088230859"
   )
   public void vmethod5623(byte[] var1, int var2, int var3) throws IOException {
      this.field2046.method4285(var1, var2, var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Liu;IIIZB)V",
      garbageValue = "0"
   )
   public static void method2413(Js5Index var0, int var1, int var2, int var3, boolean var4) {
      class120.field2529 = 1;
      UrlRequester.field1911 = var0;
      class120.field2533 = var1;
      IndexFile.field2073 = var2;
      class186.field3851 = var3;
      class120.field2534 = var4;
      WorldComparator.field0 = 10000;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1866349763"
   )
   static int method2416(int var0, class106 var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
         var4 = class48.intStack[--class228.intStackSize];
         class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var9;
         if(var0 == 4101) {
            class48.scriptStringStackSize -= 2;
            var3 = class48.scriptStringStack[class48.scriptStringStackSize];
            var9 = class48.scriptStringStack[class48.scriptStringStackSize + 1];
            class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3 + var9;
            return 1;
         } else if(var0 == 4102) {
            var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
            var4 = class48.intStack[--class228.intStackSize];
            class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3 + class124.method2096(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
            class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var6;
            int var10;
            if(var0 == 4104) {
               var10 = class48.intStack[--class228.intStackSize];
               long var11 = (11745L + (long)var10) * 86400000L;
               class48.LOCAL_CALENDAR.setTime(new Date(var11));
               var6 = class48.LOCAL_CALENDAR.get(5);
               int var16 = class48.LOCAL_CALENDAR.get(2);
               int var8 = class48.LOCAL_CALENDAR.get(1);
               class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var6 + "-" + class48.field1071[var16] + "-" + var8;
               return 1;
            } else if(var0 != 4105) {
               if(var0 == 4106) {
                  var10 = class48.intStack[--class228.intStackSize];
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = Integer.toString(var10);
                  return 1;
               } else if(var0 == 4107) {
                  class48.scriptStringStackSize -= 2;
                  class48.intStack[++class228.intStackSize - 1] = Occluder.method4634(class113.method1971(class48.scriptStringStack[class48.scriptStringStackSize], class48.scriptStringStack[class48.scriptStringStackSize + 1], client.languageId));
                  return 1;
               } else {
                  int var5;
                  byte[] var13;
                  Font var14;
                  if(var0 == 4108) {
                     var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                     class228.intStackSize -= 2;
                     var4 = class48.intStack[class228.intStackSize];
                     var5 = class48.intStack[class228.intStackSize + 1];
                     var13 = SpotAnimation.fontmetrics.method1516(var5, 0, 1789634852);
                     var14 = new Font(var13);
                     class48.intStack[++class228.intStackSize - 1] = var14.method1778(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                     class228.intStackSize -= 2;
                     var4 = class48.intStack[class228.intStackSize];
                     var5 = class48.intStack[class228.intStackSize + 1];
                     var13 = SpotAnimation.fontmetrics.method1516(var5, 0, 1789634852);
                     var14 = new Font(var13);
                     class48.intStack[++class228.intStackSize - 1] = var14.method1777(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     class48.scriptStringStackSize -= 2;
                     var3 = class48.scriptStringStack[class48.scriptStringStackSize];
                     var9 = class48.scriptStringStack[class48.scriptStringStackSize + 1];
                     if(class48.intStack[--class228.intStackSize] == 1) {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3;
                     } else {
                        class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var9;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                     class48.scriptStringStack[++class48.scriptStringStackSize - 1] = FontTypeFace.method1779(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                     var4 = class48.intStack[--class228.intStackSize];
                     class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if(var0 == 4113) {
                     var10 = class48.intStack[--class228.intStackSize];
                     class48.intStack[++class228.intStackSize - 1] = class315.method5965((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4114) {
                     var10 = class48.intStack[--class228.intStackSize];
                     class48.intStack[++class228.intStackSize - 1] = class101.method1706((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4115) {
                     var10 = class48.intStack[--class228.intStackSize];
                     class48.intStack[++class228.intStackSize - 1] = ModeGame.method4305((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4116) {
                     var10 = class48.intStack[--class228.intStackSize];
                     class48.intStack[++class228.intStackSize - 1] = class7.method129((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4117) {
                     var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                     if(var3 != null) {
                        class48.intStack[++class228.intStackSize - 1] = var3.length();
                     } else {
                        class48.intStack[++class228.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 4118) {
                     var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                     class228.intStackSize -= 2;
                     var4 = class48.intStack[class228.intStackSize];
                     var5 = class48.intStack[class228.intStackSize + 1];
                     class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3.substring(var4, var5);
                     return 1;
                  } else if(var0 == 4119) {
                     var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                     StringBuilder var17 = new StringBuilder(var3.length());
                     boolean var15 = false;

                     for(var6 = 0; var6 < var3.length(); ++var6) {
                        char var7 = var3.charAt(var6);
                        if(var7 == '<') {
                           var15 = true;
                        } else if(var7 == '>') {
                           var15 = false;
                        } else if(!var15) {
                           var17.append(var7);
                        }
                     }

                     class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var17.toString();
                     return 1;
                  } else if(var0 == 4120) {
                     var3 = class48.scriptStringStack[--class48.scriptStringStackSize];
                     var4 = class48.intStack[--class228.intStackSize];
                     class48.intStack[++class228.intStackSize - 1] = var3.indexOf(var4);
                     return 1;
                  } else if(var0 == 4121) {
                     class48.scriptStringStackSize -= 2;
                     var3 = class48.scriptStringStack[class48.scriptStringStackSize];
                     var9 = class48.scriptStringStack[class48.scriptStringStackSize + 1];
                     var5 = class48.intStack[--class228.intStackSize];
                     class48.intStack[++class228.intStackSize - 1] = var3.indexOf(var9, var5);
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               class48.scriptStringStackSize -= 2;
               var3 = class48.scriptStringStack[class48.scriptStringStackSize];
               var9 = class48.scriptStringStack[class48.scriptStringStackSize + 1];
               if(class4.localPlayer.composition != null && class4.localPlayer.composition.isFemale) {
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var9;
               } else {
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "2110567404"
   )
   public static int method2417(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
