package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class196 extends Node {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Lhb;"
   )
   class43[] field2606;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "[Lct;"
   )
   RawAudioNode[] field2602;
   @ObfuscatedName("e")
   short[] field2601;
   @ObfuscatedName("w")
   int[] field2608;
   @ObfuscatedName("q")
   byte[] field2604;
   @ObfuscatedName("b")
   byte[] field2607;
   @ObfuscatedName("c")
   byte[] field2612;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 94252731
   )
   int field2603;

   class196(byte[] var1) {
      this.field2602 = new RawAudioNode[128];
      this.field2601 = new short[128];
      this.field2604 = new byte[128];
      this.field2612 = new byte[128];
      this.field2606 = new class43[128];
      this.field2607 = new byte[128];
      this.field2608 = new int[128];
      Packet var2 = new Packet(var1);

      int var3;
      for(var3 = 0; var2.payload[var3 + var2.offset] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method6240();
      }

      ++var2.offset;
      ++var3;
      var5 = var2.offset;
      var2.offset += var3;

      int var6;
      for(var6 = 0; var2.payload[var6 + var2.offset] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method6240();
      }

      ++var2.offset;
      ++var6;
      var8 = var2.offset;
      var2.offset += var6;

      int var9;
      for(var9 = 0; var2.payload[var9 + var2.offset] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method6240();
      }

      ++var2.offset;
      ++var9;
      byte[] var38 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var38[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.readUnsignedByte();
            if(var15 == 0) {
               var13 = var12++;
            } else {
               if(var15 <= var13) {
                  --var15;
               }

               var13 = var15;
            }

            var38[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class43[] var39 = new class43[var12];

      class43 var40;
      for(var14 = 0; var14 < var39.length; ++var14) {
         var40 = var39[var14] = new class43();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var40.field2521 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var40.field2524 = new byte[var16 * 2 + 2];
            var40.field2524[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var47 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.readUnsignedByte();
      byte[] var41 = var14 > 0?new byte[var14 * 2]:null;

      int var17;
      for(var17 = 0; var2.payload[var17 + var2.offset] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method6240();
      }

      ++var2.offset;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2601[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2601[var20] = (short)(this.field2601[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; ++var23) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = var2.method6096();
         }

         this.field2601[var23] = (short)(this.field2601[var23] + ((var22 - 1 & 2) << 14));
         this.field2608[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2608[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2607[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2608[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2612[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class43 var42 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2608[var26] != 0) {
            if(var20 == 0) {
               var42 = var39[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2606[var26] = var42;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if(this.field2608[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2604[var27] = (byte)var26;
         --var20;
      }

      this.field2603 = var2.readUnsignedByte() + 1;

      class43 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2521 != null) {
            for(var29 = 1; var29 < var28.field2521.length; var29 += 2) {
               var28.field2521[var29] = var2.method6240();
            }
         }

         if(var28.field2524 != null) {
            for(var29 = 3; var29 < var28.field2524.length - 2; var29 += 2) {
               var28.field2524[var29] = var2.method6240();
            }
         }
      }

      if(var47 != null) {
         for(var27 = 1; var27 < var47.length; var27 += 2) {
            var47[var27] = var2.method6240();
         }
      }

      if(var41 != null) {
         for(var27 = 1; var27 < var41.length; var27 += 2) {
            var41[var27] = var2.method6240();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2524 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2524.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field2524[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2521 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2521.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field2521[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      int var44;
      byte var46;
      if(var47 != null) {
         var19 = var2.readUnsignedByte();
         var47[0] = (byte)var19;

         for(var27 = 2; var27 < var47.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var47[var27] = (byte)var19;
         }

         var46 = var47[0];
         byte var43 = var47[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field2604[var29] = (byte)(var43 * this.field2604[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var47.length; var29 += 2) {
            var30 = var47[var29];
            byte var31 = var47[var29 + 1];
            var32 = var43 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var35 = var30 - var46;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               this.field2604[var33] = (byte)(var34 * this.field2604[var33] + 32 >> 6);
               var32 += var31 - var43;
            }

            var46 = var30;
            var43 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field2604[var44] = (byte)(var43 * this.field2604[var44] + 32 >> 6);
         }

         var40 = null;
      }

      if(var41 != null) {
         var19 = var2.readUnsignedByte();
         var41[0] = (byte)var19;

         for(var27 = 2; var27 < var41.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var41[var27] = (byte)var19;
         }

         var46 = var41[0];
         int var49 = var41[1] << 1;

         for(var29 = 0; var29 < var46; ++var29) {
            var44 = var49 + (this.field2612[var29] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2612[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var41.length; var29 += 2) {
            var30 = var41[var29];
            var45 = var41[var29 + 1] << 1;
            var32 = var49 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var35 = var30 - var46;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = var34 + (this.field2612[var33] & 255);
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2612[var33] = (byte)var37;
               var32 += var45 - var49;
            }

            var46 = var30;
            var49 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = var49 + (this.field2612[var44] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2612[var44] = (byte)var45;
         }

         Object var48 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field2522 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2521 != null) {
            var28.field2528 = var2.readUnsignedByte();
         }

         if(var28.field2524 != null) {
            var28.field2527 = var2.readUnsignedByte();
         }

         if(var28.field2522 > 0) {
            var28.field2525 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field2523 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2523 > 0) {
            var28.field2526 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2526 > 0) {
            var28.field2520 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lci;[B[II)Z",
      garbageValue = "939473631"
   )
   boolean method4001(class224 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      RawAudioNode var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2608[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method4467(var8 >> 2, var3);
                  } else {
                     var6 = var1.method4470(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2602[var7] = var6;
                  this.field2608[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-659155621"
   )
   void method4002() {
      this.field2608 = null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-16713"
   )
   static final void method4010() {
      class115.method2002("You can\'t add yourself to your own friend list");
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "([Lhn;Lhn;ZI)V",
      garbageValue = "1658306306"
   )
   static void method4011(ComponentType[] var0, ComponentType var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      Timer.method5401(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         Timer.method5401(var1.children, var1.id, var3, var4, var2);
      }

      SubInterface var5 = (SubInterface) client.subInterfaces.method380((long)var1.id);
      if(var5 != null) {
         WorldMapManager.method904(var5.id, var3, var4, var2);
      }

      if(var1.clientcode == 1337) {
         ;
      }

   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1750193407"
   )
   static final void method4012(int var0) {
      WorldComparator.method6483();
      class257.method4975();
      int var1 = class189.method3717(var0).clientCode;
      if(var1 != 0) {
         int var2 = class311.clientVarps[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               Graphics3D.method2567(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).method2767(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.method2567(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).method2767(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.method2567(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).method2767(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.method2567(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).method2767(0.6D);
            }

            ObjType.itemSpriteCache.method952();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != client.field877) {
               if(client.field877 == 0 && client.field878 != -1) {
                  class139.method2413(ServerProt.music, client.field878, 0, var3, false);
                  client.field879 = false;
               } else if(var3 == 0) {
                  WorldMapRegion.method4152();
                  client.field879 = false;
               } else {
                  DecorativeObject.method5024(var3);
               }

               client.field877 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               client.field888 = 127;
            }

            if(var2 == 1) {
               client.field888 = 96;
            }

            if(var2 == 2) {
               client.field888 = 64;
            }

            if(var2 == 3) {
               client.field888 = 32;
            }

            if(var2 == 4) {
               client.field888 = 0;
            }
         }

         if(var1 == 5) {
            client.field866 = var2;
         }

         if(var1 == 6) {
            client.field807 = var2;
         }

         if(var1 == 9) {
            client.field808 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               client.field881 = 127;
            }

            if(var2 == 1) {
               client.field881 = 96;
            }

            if(var2 == 2) {
               client.field881 = 64;
            }

            if(var2 == 3) {
               client.field881 = 32;
            }

            if(var2 == 4) {
               client.field881 = 0;
            }
         }

         if(var1 == 17) {
            client.field813 = var2 & 65535;
         }

         if(var1 == 18) {
            client.playerAttackOpPriority = (AttackOpPriority)class2.method20(class2.method16(), var2);
            if(client.playerAttackOpPriority == null) {
               client.playerAttackOpPriority = AttackOpPriority.COMBAT_LEVEL_BASED;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               client.field769 = -1;
            } else {
               client.field769 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            client.npcAttackOpPriority = (AttackOpPriority)class2.method20(class2.method16(), var2);
            if(client.npcAttackOpPriority == null) {
               client.npcAttackOpPriority = AttackOpPriority.COMBAT_LEVEL_BASED;
            }
         }

      }
   }
}
