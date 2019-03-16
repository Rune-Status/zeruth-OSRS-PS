package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class204 extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   static NodeCache field3298;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static Js5Index field3301;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1955032221
   )
   public int field3299;

   static {
      field3298 = new NodeCache(64);
   }

   class204() {
      this.field3299 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgl;I)V",
      garbageValue = "-532058353"
   )
   void method4083(Packet var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4085(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgl;II)V",
      garbageValue = "1767209492"
   )
   void method4085(Packet var1, int var2) {
      if(var2 == 2) {
         this.field3299 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILde;[Lfn;I)V",
      garbageValue = "537434701"
   )
   static final void method4096(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, SceneManager var8, CollisionData[] var9) {
      Packet var10 = new Packet(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method6093();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.readUSmart();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               LocType var21 = class225.method4485(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.width;
               int var28 = var21.length;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var2 + var23;
               int var32 = var16 & 7;
               int var33 = var15 & 7;
               int var35 = var21.width;
               int var36 = var21.length;
               int var37;
               if((var20 & 1) == 1) {
                  var37 = var35;
                  var35 = var36;
                  var36 = var37;
               }

               int var34 = var7 & 3;
               int var31;
               if(var34 == 0) {
                  var31 = var33;
               } else if(var34 == 1) {
                  var31 = 7 - var32 - (var35 - 1);
               } else if(var34 == 2) {
                  var31 = 7 - var33 - (var36 - 1);
               } else {
                  var31 = var32;
               }

               var37 = var3 + var31;
               if(var29 > 0 && var37 > 0 && var29 < 103 && var37 < 103) {
                  int var38 = var1;
                  if((class98.tileSettings[1][var29][var37] & 2) == 2) {
                     var38 = var1 - 1;
                  }

                  CollisionData var39 = null;
                  if(var38 >= 0) {
                     var39 = var9[var38];
                  }

                  WorldMapRegion.method4191(var1, var29, var37, var11, var20 + var7 & 3, var19, var8, var39);
               }
            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   static final void method4095(String var0) {
      TcpConnectionMessage var1 = FaceNormal.method5726(ClientProt.FRIENDLIST_ADD, client.serverConnection.isaac);
      var1.packetBuffer.putByte(AbstractSoundSystem.method338(var0));
      var1.packetBuffer.method6198(var0);
      client.serverConnection.method5881(var1);
   }
}
