package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class113 extends class310 {
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "[Lli;"
   )
   static IndexedSprite[] slArrowSprites;
   @ObfuscatedName("bc")
   static String field82;
   @ObfuscatedName("ec")
   static String host;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static ComponentType field75;
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "Lli;"
   )
   static IndexedSprite field77;
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Js5 models;

   public boolean equals(Object var1) {
      if(!(var1 instanceof class113)) {
         return false;
      } else {
         class113 var2 = (class113)var1;
         return var2.field147 == super.field147 && var2.field149 == super.field149;
      }
   }

   public int hashCode() {
      return super.field147 | super.field149 << 8;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgl;Lgl;I)V",
      garbageValue = "1266482310"
   )
   void method1961(Packet var1, Packet var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class134.field258.field254) {
         throw new IllegalStateException("");
      } else {
         super.field150 = var2.readUnsignedByte();
         super.field148 = var2.readUnsignedByte();
         super.field146 = var2.readUnsignedShort();
         super.field151 = var2.readUnsignedShort();
         super.field147 = var2.readUnsignedShort();
         super.field149 = var2.readUnsignedShort();
         super.field148 = Math.min(super.field148, 4);
         super.field152 = new short[1][64][64];
         super.field153 = new short[super.field148][64][64];
         super.field154 = new byte[super.field148][64][64];
         super.field155 = new byte[super.field148][64][64];
         super.decorations = new WorldMapDecoration[super.field148][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class315.field251.field247) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field147 && var5 == super.field149) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method5901(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-107"
   )
   public static int method1965(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lge;I)V",
      garbageValue = "274930270"
   )
   static final void method1970(Bit var0) {
      int var1 = 0;
      var0.method2837();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class254.highResolutionPlayerCount; ++var2) {
         var3 = class254.highResolutionPlayerIndexes[var2];
         if((class254.skipHistory[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class254.skipHistory[var3] = (byte)(class254.skipHistory[var3] | 2);
            } else {
               var4 = var0.getBits(1);
               if(var4 == 0) {
                  var1 = MapLabel.method5552(var0);
                  class254.skipHistory[var3] = (byte)(class254.skipHistory[var3] | 2);
               } else {
                  TcpConnectionMessage.method1133(var0, var3);
               }
            }
         }
      }

      var0.method2834();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2837();

         for(var2 = 0; var2 < class254.highResolutionPlayerCount; ++var2) {
            var3 = class254.highResolutionPlayerIndexes[var2];
            if((class254.skipHistory[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class254.skipHistory[var3] = (byte)(class254.skipHistory[var3] | 2);
               } else {
                  var4 = var0.getBits(1);
                  if(var4 == 0) {
                     var1 = MapLabel.method5552(var0);
                     class254.skipHistory[var3] = (byte)(class254.skipHistory[var3] | 2);
                  } else {
                     TcpConnectionMessage.method1133(var0, var3);
                  }
               }
            }
         }

         var0.method2834();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2837();

            for(var2 = 0; var2 < class254.lowResolutionPlayerCount; ++var2) {
               var3 = class254.lowResolutionPlayerIndexes[var2];
               if((class254.skipHistory[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class254.skipHistory[var3] = (byte)(class254.skipHistory[var3] | 2);
                  } else {
                     var4 = var0.getBits(1);
                     if(var4 == 0) {
                        var1 = MapLabel.method5552(var0);
                        class254.skipHistory[var3] = (byte)(class254.skipHistory[var3] | 2);
                     } else if(class106.method1881(var0, var3)) {
                        class254.skipHistory[var3] = (byte)(class254.skipHistory[var3] | 2);
                     }
                  }
               }
            }

            var0.method2834();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2837();

               for(var2 = 0; var2 < class254.lowResolutionPlayerCount; ++var2) {
                  var3 = class254.lowResolutionPlayerIndexes[var2];
                  if((class254.skipHistory[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class254.skipHistory[var3] = (byte)(class254.skipHistory[var3] | 2);
                     } else {
                        var4 = var0.getBits(1);
                        if(var4 == 0) {
                           var1 = MapLabel.method5552(var0);
                           class254.skipHistory[var3] = (byte)(class254.skipHistory[var3] | 2);
                        } else if(class106.method1881(var0, var3)) {
                           class254.skipHistory[var3] = (byte)(class254.skipHistory[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2834();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class254.highResolutionPlayerCount = 0;
                  class254.lowResolutionPlayerCount = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class254.skipHistory[var2] = (byte)(class254.skipHistory[var2] >> 1);
                     PlayerEntity var5 = client.players[var2];
                     if(var5 != null) {
                        class254.highResolutionPlayerIndexes[++class254.highResolutionPlayerCount - 1] = var2;
                     } else {
                        class254.lowResolutionPlayerIndexes[++class254.lowResolutionPlayerCount - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1304326593"
   )
   public static boolean method1972() {
      return class120.field2529 != 0?true:class267.field2461.method4945();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lls;IIII)V",
      garbageValue = "-1368490287"
   )
   static void method1969(SpritePixels var0, int var1, int var2, int var3) {
      class299 var4 = WorldMapRegion.field235;
      long var6 = (long)(var3 << 16 | var1 << 8 | var2);
      var4.method5732(var0, var6, var0.pixels.length * 4);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IB)I",
      garbageValue = "-31"
   )
   public static int method1971(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = class192.method3783(var9);
         var8 = class192.method3783(var10);
         var9 = SoundTask.method5017(var9, var2);
         var10 = SoundTask.method5017(var10, var2);
         if(var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var10 != var9) {
               return Varcs.method4762(var9, var2) - Varcs.method4762(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var11 != var12 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var11 != var12) {
               return Varcs.method4762(var11, var2) - Varcs.method4762(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var13 != var12) {
               return Varcs.method4762(var12, var2) - Varcs.method4762(var13, var2);
            }
         }

         return 0;
      }
   }
}
