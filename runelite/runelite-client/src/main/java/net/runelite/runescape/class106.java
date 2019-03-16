package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSScript;

@ObfuscatedName("cx")
public class class106 extends CacheableNode implements RSScript {
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 1180822843
   )
   static int menuY;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   static NodeCache field1261;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1685761573
   )
   int localStringCount;
   @ObfuscatedName("r")
   int[] instructions;
   @ObfuscatedName("e")
   int[] intOperands;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2067321737
   )
   int stringStackCount;
   @ObfuscatedName("q")
   String[] stringOperands;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1755108641
   )
   int intStackCount;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lgr;"
   )
   IterableHashTable[] switches;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1376558093
   )
   int localIntCount;

   static {
      field1261 = new NodeCache(128);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)[Lgr;",
      garbageValue = "1546112737"
   )
   IterableHashTable[] method1870(int var1) {
      return new IterableHashTable[var1];
   }

   public int[] getInstructions() {
      return this.instructions;
   }

   public int[] getIntOperands() {
      return this.intOperands;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Ljj;",
      garbageValue = "1801855127"
   )
   public static Enum method1885(int var0) {
      Enum var1 = (Enum)Enum.field3414.method951((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.EnumDefinition_indexCache.method1516(8, var0, 1789634852);
         var1 = new Enum();
         if(var2 != null) {
            var1.method6509(new Packet(var2));
         }

         Enum.field3414.method957(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1830031577"
   )
   public static void method1884(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Lcx;",
      garbageValue = "79"
   )
   static class106 method1872(int var0, int var1) {
      class106 var2 = (class106)field1261.method951((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = UrlRequester.clientscripts.method1510(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = UrlRequester.clientscripts.method1520(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = ProjectileAnimation.method5593(var5);
               if(var2 != null) {
                  field1261.method957(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("km")
   @ObfuscatedSignature(
      signature = "(Lgl;II)V",
      garbageValue = "1427407129"
   )
   static void method1882(Packet var0, int var1) {
      byte[] var2 = var0.payload;
      if(client.field708 == null) {
         client.field708 = new byte[24];
      }

      class188.method3667(var2, var1, client.field708, 0, 24);
      if(class166.uidDat != null) {
         try {
            class166.uidDat.method2099(0L);
            class166.uidDat.method2108(var0.payload, var1, 24);
         } catch (Exception var4) {
            ;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lge;II)Z",
      garbageValue = "-202222013"
   )
   static boolean method1881(Bit var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            method1881(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class254.extendedInfoPlayerIndexes[++class254.extendedInfoPlayerCount - 1] = var1;
         }

         if(client.players[var1] != null) {
            throw new RuntimeException();
         } else {
            PlayerEntity var10000 = client.players[var1] = new PlayerEntity();
            client.cachedPlayersChanged(var1);
            PlayerEntity var6 = var10000;
            var6.playerId = var1;
            if(class254.appearances[var1] != null) {
               var6.method2889(class254.appearances[var1]);
            }

            var6.orientation = class254.facingCoords[var1];
            var6.interacting = class254.facingEntities[var1];
            var6.interactingChanged(-1);
            var7 = class254.coords[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.pathTraversed[0] = class254.moveSpeeds[var1];
            var6.field620 = (byte)var8;
            var6.method2927((var9 << 13) + var3 - class158.baseX, (var10 << 13) + var4 - class107.baseY);
            var6.field631 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class254.coords[var1];
         class254.coords[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class254.coords[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class254.coords[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class254.coords[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class254.coords[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("kg")
   @ObfuscatedSignature(
      signature = "(Lhn;I)Ljava/lang/String;",
      garbageValue = "1875176643"
   )
   static String method1886(ComponentType var0) {
      return class192.method3781(class101.method1704(var0)) == 0?null:(var0.targetVerb != null && var0.targetVerb.trim().length() != 0?var0.targetVerb:null);
   }
}
