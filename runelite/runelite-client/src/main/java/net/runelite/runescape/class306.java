package net.runelite.runescape;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class306 {
   @ObfuscatedName("sz")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   static IndexFile indexStore255;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -12923849
   )
   static int field552;
   @ObfuscatedName("x")
   static int[][][] field553;
   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "Lls;"
   )
   static SpritePixels compass;

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(ILhz;ZB)V",
      garbageValue = "1"
   )
   static void method5872(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = class70.method1079().method1222(var0);
      int var4 = class4.localPlayer.field620;
      int var5 = (class4.localPlayer.x >> 7) + class158.baseX;
      int var6 = (class4.localPlayer.y >> 7) + class107.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      class70.method1079().method1210(var3, var7, var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-1664343996"
   )
   public static void method5871(String var0, String var1, int var2, int var3) throws IOException {
      class166.archiveCount = var3;
      class166.historicCacheId = var2;

      try {
         class80.osNameRaw = System.getProperty("os.name");
      } catch (Exception var29) {
         class80.osNameRaw = "Unknown";
      }

      MapIcon.osName = class80.osNameRaw.toLowerCase();

      try {
         class147.homeDir = System.getProperty("user.home");
         if(class147.homeDir != null) {
            class147.homeDir = class147.homeDir + "/";
         }
      } catch (Exception var28) {
         ;
      }

      try {
         if(MapIcon.osName.startsWith("win")) {
            if(class147.homeDir == null) {
               class147.homeDir = System.getenv("USERPROFILE");
            }
         } else if(class147.homeDir == null) {
            class147.homeDir = System.getenv("HOME");
         }

         if(class147.homeDir != null) {
            class147.homeDir = class147.homeDir + "/";
         }
      } catch (Exception var27) {
         ;
      }

      if(class147.homeDir == null) {
         class147.homeDir = "~/";
      }

      PlayerComposition.historicCacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class147.homeDir, "/tmp/", ""};
      class157.historicCacheDirectories = new String[]{".jagex_cache_" + class166.historicCacheId, ".file_store_" + class166.historicCacheId};
      int var18 = 0;

      label278:
      while(var18 < 4) {
         String var6 = var18 == 0?"":"" + var18;
         class166.cacheLocator = new File(class147.homeDir, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         File var36;
         if(class166.cacheLocator.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class166.cacheLocator, "rw", 10000L);

               Packet var11;
               int var12;
               for(var11 = new Packet((int)var10.method148()); var11.offset < var11.payload.length; var11.offset += var12) {
                  var12 = var10.method149(var11.payload, var11.offset, var11.payload.length - var11.offset);
                  if(var12 == -1) {
                     throw new IOException();
                  }
               }

               var11.offset = 0;
               var12 = var11.readUnsignedByte();
               if(var12 < 1 || var12 > 3) {
                  throw new IOException("" + var12);
               }

               int var13 = 0;
               if(var12 > 1) {
                  var13 = var11.readUnsignedByte();
               }

               if(var12 <= 2) {
                  var7 = var11.method6088();
                  if(var13 == 1) {
                     var8 = var11.method6088();
                  }
               } else {
                  var7 = var11.method6089();
                  if(var13 == 1) {
                     var8 = var11.method6089();
                  }
               }

               var10.method146();
            } catch (IOException var32) {
               var32.printStackTrace();
            }

            if(var7 != null) {
               var36 = new File(var7);
               if(!var36.exists()) {
                  var7 = null;
               }
            }

            if(var7 != null) {
               var36 = new File(var7, "test.dat");
               if(!AbstractByteBuffer.method5408(var36, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var18 == 0) {
            label253:
            for(int var19 = 0; var19 < class157.historicCacheDirectories.length; ++var19) {
               for(int var20 = 0; var20 < PlayerComposition.historicCacheLocations.length; ++var20) {
                  File var21 = new File(PlayerComposition.historicCacheLocations[var20] + class157.historicCacheDirectories[var19] + File.separatorChar + var0 + File.separatorChar);
                  if(var21.exists() && AbstractByteBuffer.method5408(new File(var21, "test.dat"), true)) {
                     var7 = var21.toString();
                     var9 = true;
                     break label253;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = class147.homeDir + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         if(var8 != null) {
            File var35 = new File(var8);
            var36 = new File(var7);

            try {
               File[] var39 = var35.listFiles();
               File[] var22 = var39;

               for(int var14 = 0; var14 < var22.length; ++var14) {
                  File var15 = var22[var14];
                  File var16 = new File(var36, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if(!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var31) {
               var31.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            Timer.method5394(new File(var7), (File)null);
         }

         File var5 = new File(var7);
         ScriptState.cacheDirectory = var5;
         if(!ScriptState.cacheDirectory.exists()) {
            ScriptState.cacheDirectory.mkdirs();
         }

         File[] var34 = ScriptState.cacheDirectory.listFiles();
         if(var34 != null) {
            File[] var37 = var34;

            for(int var23 = 0; var23 < var37.length; ++var23) {
               File var24 = var37[var23];
               if(!AbstractByteBuffer.method5408(var24, false)) {
                  ++var18;
                  continue label278;
               }
            }
         }
         break;
      }

      class189.method3718(ScriptState.cacheDirectory);

      try {
         File var4 = new File(class147.homeDir, "random.dat");
         int var26;
         if(var4.exists()) {
            class166.uidDat = new CacheFile(new FileOnDisk(var4, "rw", 25L), 24, 0);
         } else {
            label206:
            for(int var25 = 0; var25 < class157.historicCacheDirectories.length; ++var25) {
               for(var26 = 0; var26 < PlayerComposition.historicCacheLocations.length; ++var26) {
                  File var38 = new File(PlayerComposition.historicCacheLocations[var26] + class157.historicCacheDirectories[var25] + File.separatorChar + "random.dat");
                  if(var38.exists()) {
                     class166.uidDat = new CacheFile(new FileOnDisk(var38, "rw", 25L), 24, 0);
                     break label206;
                  }
               }
            }
         }

         if(class166.uidDat == null) {
            RandomAccessFile var33 = new RandomAccessFile(var4, "rw");
            var26 = var33.read();
            var33.seek(0L);
            var33.write(var26);
            var33.seek(0L);
            var33.close();
            class166.uidDat = new CacheFile(new FileOnDisk(var4, "rw", 25L), 24, 0);
         }
      } catch (IOException var30) {
         ;
      }

      class166.cacheDat = new CacheFile(new FileOnDisk(class115.method2004("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class166.masterIndex = new CacheFile(new FileOnDisk(class115.method2004("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      class166.cacheIndex = new CacheFile[class166.archiveCount];

      for(var18 = 0; var18 < class166.archiveCount; ++var18) {
         class166.cacheIndex[var18] = new CacheFile(new FileOnDisk(class115.method2004("main_file_cache.idx" + var18), "rw", 1048576L), 6000, 0);
      }

   }
}
