package net.runelite.runescape;

import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public class class9 {
   @ObfuscatedName("l")
   static final BigInteger field1109;
   @ObfuscatedName("c")
   static final BigInteger field1104;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -1974466349
   )
   static int field1113;

   static {
      field1104 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1109 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(Lhn;II)I",
      garbageValue = "1939527040"
   )
   static final int method130(ComponentType var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = client.skillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = client.skillBaseLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = client.skillExperiences[var2[var4++]];
               }

               int var9;
               ComponentType var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = WorldMapType1.method2440(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!Varcs.method4770(var11).members || client.isMembers)) {
                     for(var12 = 0; var12 < var10.objIds.length; ++var12) {
                        if(var11 + 1 == var10.objIds[var12]) {
                           var7 += var10.objCounts[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class311.clientVarps[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class37.field2844[client.skillBaseLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class311.clientVarps[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = class4.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class37.field2842[var9]) {
                        var7 += client.skillBaseLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = WorldMapType1.method2440(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!Varcs.method4770(var11).members || client.isMembers)) {
                     for(var12 = 0; var12 < var10.objIds.length; ++var12) {
                        if(var11 + 1 == var10.objIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = client.energy;
               }

               if(var6 == 12) {
                  var7 = client.weight;
               }

               if(var6 == 13) {
                  var9 = class311.clientVarps[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = AbstractSoundSystem.method339(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class4.localPlayer.x >> 7) + class158.baseX;
               }

               if(var6 == 19) {
                  var7 = (class4.localPlayer.y >> 7) + class107.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1289869400"
   )
   static int method140(int var0, class106 var1, boolean var2) {
      if(var0 == 5630) {
         client.field725 = 250;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1460705646"
   )
   static final void method133() {
      client.serverConnection.method5878();
      SceneTilePaint.method668();
      class131.sceneManager.method3795();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.collisionMaps[var0].method196();
      }

      System.gc();
      class170.method2866(2);
      client.field878 = -1;
      client.field879 = false;
      AuthProt.method1669();
      class310.method5922(10);
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1738595403"
   )
   static void method139(boolean var0) {
      client.field790 = var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "2126661525"
   )
   public static String method142(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = FaceNormal.method5725(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
