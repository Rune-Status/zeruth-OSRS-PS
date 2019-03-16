package net.runelite.runescape;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public final class class4 extends Node {
   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "Lbk;"
   )
   static PlayerEntity localPlayer;
   @ObfuscatedName("z")
   static int[] field1047;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1616715337
   )
   static int field1050;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static Deque field1051;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1948288479
   )
   int field1062;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   LocType field1061;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1596147421
   )
   int field1048;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1141355691
   )
   int field1053;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 983702787
   )
   int field1049;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   class266 field1060;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1116318313
   )
   int field1057;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1019869369
   )
   int field1056;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1685640657
   )
   int field1052;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -94333697
   )
   int field1054;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2819425
   )
   int field1059;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   class266 field1064;
   @ObfuscatedName("d")
   int[] field1058;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1020932217
   )
   int field1055;

   static {
      field1051 = new Deque();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-720032025"
   )
   void method33() {
      int var1 = this.field1054;
      LocType var2 = this.field1061.method1717();
      if(var2 != null) {
         this.field1054 = var2.ambientSoundId;
         this.field1053 = var2.int4 * 128;
         this.field1056 = var2.int5;
         this.field1057 = var2.int6;
         this.field1058 = var2.field3499;
      } else {
         this.field1054 = -1;
         this.field1053 = 0;
         this.field1056 = 0;
         this.field1057 = 0;
         this.field1058 = null;
      }

      if(var1 != this.field1054 && this.field1064 != null) {
         class2.field413.method3580(this.field1064);
         this.field1064 = null;
      }

   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "2"
   )
   static void method42(int var0) {
      if(var0 == -1 && !client.field879) {
         WorldMapRegion.method4152();
      } else if(var0 != -1 && var0 != client.field878 && client.field877 != 0 && !client.field879) {
         class134.method2202(2, ServerProt.music, var0, 0, client.field877, false);
      }

      client.field878 = var0;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lff;IIB)Lcq;",
      garbageValue = "-11"
   )
   public static final AbstractSoundSystem method41(Signlink var0, int var1, int var2) {
      if(AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = ClientOptions.soundTaskDataProvider.vmethod4668();
            var3.samples = new int[(class56.audioHighMemory?2:1) * 256];
            var3.field1367 = var2;
            var3.vmethod6410();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.vmethod6411(var3.offset);
            if(WorldMapDecoration.field189 > 0 && class37.task == null) {
               class37.task = new SoundTask();
               class316.field1155 = Executors.newScheduledThreadPool(1);
               class316.field1155.scheduleAtFixedRate(class37.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class37.task != null) {
               if(class37.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class37.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "800548389"
   )
   static final void method32(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.lowMemory && var0 != class228.level) {
            return;
         }

         long var7 = 0L;
         boolean var9 = true;
         boolean var10 = false;
         boolean var11 = false;
         if(var1 == 0) {
            var7 = class131.sceneManager.method3821(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class131.sceneManager.method3822(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class131.sceneManager.method3823(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class131.sceneManager.method3920(var0, var2, var3);
         }

         int var12;
         if(0L != var7) {
            var12 = class131.sceneManager.method3825(var0, var2, var3, var7);
            int var14 = SubInterface.method2437(var7);
            int var15 = var12 & 31;
            int var16 = var12 >> 6 & 3;
            LocType var13;
            if(var1 == 0) {
               class131.sceneManager.method3812(var0, var2, var3);
               var13 = class225.method4485(var14);
               if(var13.clipType != 0) {
                  client.collisionMaps[var0].method201(var2, var3, var15, var16, var13.blocksProjectile);
               }
            }

            if(var1 == 1) {
               class131.sceneManager.method3813(var0, var2, var3);
            }

            if(var1 == 2) {
               class131.sceneManager.method3814(var0, var2, var3);
               var13 = class225.method4485(var14);
               if(var2 + var13.width > 103 || var3 + var13.width > 103 || var2 + var13.length > 103 || var3 + var13.length > 103) {
                  return;
               }

               if(var13.clipType != 0) {
                  client.collisionMaps[var0].method202(var2, var3, var13.width, var13.length, var16, var13.blocksProjectile);
               }
            }

            if(var1 == 3) {
               class131.sceneManager.method3815(var0, var2, var3);
               var13 = class225.method4485(var14);
               if(var13.clipType == 1) {
                  client.collisionMaps[var0].method204(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var12 = var0;
            if(var0 < 3 && (class98.tileSettings[1][var2][var3] & 2) == 2) {
               var12 = var0 + 1;
            }

            TradingPost.method805(var0, var12, var2, var3, var4, var5, var6, class131.sceneManager, client.collisionMaps[var0]);
         }
      }

   }
}
