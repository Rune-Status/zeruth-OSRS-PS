package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class208 implements WorldMapSectionBase {
   @ObfuscatedName("gc")
   static int[] mapRegions;
   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   static UrlRequester urlRequester;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1246505141
   )
   int field353;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -601864749
   )
   int field360;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1089735413
   )
   int field354;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1404547311
   )
   int field357;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 547192817
   )
   int field355;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -819804171
   )
   int field358;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1099647611
   )
   int field359;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -47648493
   )
   int field356;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1012541829
   )
   int field364;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1531566421
   )
   int field361;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-81"
   )
   public boolean vmethod5812(int var1, int var2, int var3) {
      return var1 >= this.field361 && var1 < this.field360 + this.field361?var2 >= (this.field354 << 6) + (this.field358 << 3) && var2 <= (this.field354 << 6) + (this.field358 << 3) + 7 && var3 >= (this.field355 << 6) + (this.field357 << 3) && var3 <= (this.field355 << 6) + (this.field357 << 3) + 7:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "79"
   )
   public boolean vmethod5811(int var1, int var2) {
      return var1 >= (this.field356 << 6) + (this.field359 << 3) && var1 <= (this.field356 << 6) + (this.field359 << 3) + 7 && var2 >= (this.field353 << 6) + (this.field364 << 3) && var2 <= (this.field353 << 6) + (this.field364 << 3) + 7;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1381851995"
   )
   public int[] vmethod5814(int var1, int var2, int var3) {
      if(!this.vmethod5812(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field356 * 64 - this.field354 * 64 + var2 + (this.field359 * 8 - this.field358 * 8), var3 + (this.field353 * 64 - this.field355 * 64) + (this.field364 * 8 - this.field357 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "857882639"
   )
   void method4123() {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)Lhz;",
      garbageValue = "-126"
   )
   public Coordinates vmethod5817(int var1, int var2) {
      if(!this.vmethod5811(var1, var2)) {
         return null;
      } else {
         int var3 = this.field354 * 64 - this.field356 * 64 + (this.field358 * 8 - this.field359 * 8) + var1;
         int var4 = this.field355 * 64 - this.field353 * 64 + var2 + (this.field357 * 8 - this.field364 * 8);
         return new Coordinates(this.field361, var3, var4);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgl;I)V",
      garbageValue = "-821481708"
   )
   public void vmethod5829(Packet var1) {
      this.field361 = var1.readUnsignedByte();
      this.field360 = var1.readUnsignedByte();
      this.field354 = var1.readUnsignedShort();
      this.field358 = var1.readUnsignedByte();
      this.field355 = var1.readUnsignedShort();
      this.field357 = var1.readUnsignedByte();
      this.field356 = var1.readUnsignedShort();
      this.field359 = var1.readUnsignedByte();
      this.field353 = var1.readUnsignedShort();
      this.field364 = var1.readUnsignedByte();
      this.method4123();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lk;B)V",
      garbageValue = "-126"
   )
   public void vmethod5820(WorldMapData var1) {
      if(var1.minX > this.field356) {
         var1.minX = this.field356;
      }

      if(var1.field199 < this.field356) {
         var1.field199 = this.field356;
      }

      if(var1.minY > this.field353) {
         var1.minY = this.field353;
      }

      if(var1.field203 < this.field353) {
         var1.field203 = this.field353;
      }

   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Lhn;I)V",
      garbageValue = "-93485703"
   )
   static final void method4142(ComponentType var0) {
      int var1 = var0.clientcode;
      if(var1 == 324) {
         if(client.field874 == -1) {
            client.field874 = var0.graphic;
            client.field910 = var0.field2703;
         }

         if(client.field908.isFemale) {
            var0.graphic = client.field874;
         } else {
            var0.graphic = client.field910;
         }

      } else if(var1 == 325) {
         if(client.field874 == -1) {
            client.field874 = var0.graphic;
            client.field910 = var0.field2703;
         }

         if(client.field908.isFemale) {
            var0.graphic = client.field910;
         } else {
            var0.graphic = client.field874;
         }

      } else if(var1 == 327) {
         var0.xan2d = 150;
         var0.yan2d = (int)(Math.sin((double) client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.xan2d = 150;
         var0.yan2d = (int)(Math.sin((double) client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(Lhn;I)V",
      garbageValue = "1238023037"
   )
   static void method4144(ComponentType var0) {
      if(var0.loopCycle == client.field847) {
         client.field848[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljf;",
      garbageValue = "-1684545804"
   )
   public static HeadbarType method4121(int var0) {
      HeadbarType var1 = (HeadbarType)HeadbarType.field3385.method951((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = HeadbarType.field3389.method1516(33, var0, 1789634852);
         var1 = new HeadbarType();
         if(var2 != null) {
            var1.method4514(new Packet(var2));
         }

         HeadbarType.field3385.method957(var1, (long)var0);
         return var1;
      }
   }
}
