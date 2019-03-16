package net.runelite.runescape;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class159 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lci;"
   )
   public static class224 field1218;
   @ObfuscatedName("r")
   Future field1216;
   @ObfuscatedName("g")
   ExecutorService field1219;

   class159() {
      this.field1219 = Executors.newSingleThreadExecutor();
      this.field1216 = this.field1219.submit(new class60());
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "16"
   )
   boolean method2700() {
      return this.field1216.isDone();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Ljava/security/SecureRandom;",
      garbageValue = "11"
   )
   SecureRandom method2701() {
      try {
         return (SecureRandom)this.field1216.get();
      } catch (Exception var4) {
         SecureRandom var3 = new SecureRandom();
         var3.nextInt();
         return var3;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1772925853"
   )
   void method2699() {
      this.field1219.shutdown();
      this.field1219 = null;
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-41"
   )
   static void method2710() {
      int var0;
      if(client.loadingStage == 0) {
         class131.sceneManager = new SceneManager(4, 104, 104, class98.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         TotalQuantityComparator.minimapSprite = new SpritePixels(512, 512);
         class316.loadingText = "Starting game engine...";
         class316.loadingBarPercentage = 5;
         client.loadingStage = 20;
      } else if(client.loadingStage == 20) {
         class316.loadingText = "Prepared visibility map";
         class316.loadingBarPercentage = 10;
         client.loadingStage = 30;
      } else if(client.loadingStage == 30) {
         WorldMapDecoration.anims = Occluder.method4632(0, false, true, true);
         GameCanvas.bases = Occluder.method4632(1, false, true, true);
         class98.configs = Occluder.method4632(2, true, false, true);
         class166.interfacesArchive = Occluder.method4632(3, false, true, true);
         class192.synths = Occluder.method4632(4, false, true, true);
         class239.maps = Occluder.method4632(5, true, true, true);
         ServerProt.music = Occluder.method4632(6, true, true, true);
         class113.models = Occluder.method4632(7, false, true, true);
         JagException.sprites = Occluder.method4632(8, false, true, true);
         WorldMapRectangle.textures = Occluder.method4632(9, false, true, true);
         Size.binary = Occluder.method4632(10, false, true, true);
         Isaac.jingles = Occluder.method4632(11, false, true, true);
         UrlRequester.clientscripts = Occluder.method4632(12, false, true, true);
         SpotAnimation.fontmetrics = Occluder.method4632(13, true, false, true);
         WorldMapType2.vorbis = Occluder.method4632(14, false, true, true);
         LocType.instruments = Occluder.method4632(15, false, true, true);
         class19.worldmapdata = Occluder.method4632(16, true, true, true);
         class36.defaults = Occluder.method4632(17, true, true, true);
         class316.loadingText = "Connecting to update server";
         class316.loadingBarPercentage = 20;
         client.loadingStage = 40;
      } else if(client.loadingStage == 40) {
         byte var28 = 0;
         var0 = var28 + WorldMapDecoration.anims.method2639() * 4 / 100;
         var0 += GameCanvas.bases.method2639() * 4 / 100;
         var0 += class98.configs.method2639() * 2 / 100;
         var0 += class166.interfacesArchive.method2639() * 2 / 100;
         var0 += class192.synths.method2639() * 6 / 100;
         var0 += class239.maps.method2639() * 4 / 100;
         var0 += ServerProt.music.method2639() * 2 / 100;
         var0 += class113.models.method2639() * 57 / 100;
         var0 += JagException.sprites.method2639() * 2 / 100;
         var0 += WorldMapRectangle.textures.method2639() * 2 / 100;
         var0 += Size.binary.method2639() * 2 / 100;
         var0 += Isaac.jingles.method2639() * 2 / 100;
         var0 += UrlRequester.clientscripts.method2639() * 2 / 100;
         var0 += SpotAnimation.fontmetrics.method2639() * 2 / 100;
         var0 += WorldMapType2.vorbis.method2639() * 2 / 100;
         var0 += LocType.instruments.method2639() * 2 / 100;
         var0 += class19.worldmapdata.method2639() * 2 / 100;
         var0 += class36.defaults.method2638() && class36.defaults.method1589()?1:0;
         if(var0 != 100) {
            if(var0 != 0) {
               class316.loadingText = "Checking for updates - " + var0 + "%";
            }

            class316.loadingBarPercentage = 30;
         } else {
            class259.method4993(WorldMapDecoration.anims, "Animations");
            class259.method4993(GameCanvas.bases, "Skeletons");
            class259.method4993(class192.synths, "Sound FX");
            class259.method4993(class239.maps, "Maps");
            class259.method4993(ServerProt.music, "Music Tracks");
            class259.method4993(class113.models, "Models");
            class259.method4993(JagException.sprites, "Sprites");
            class259.method4993(Isaac.jingles, "Music Jingles");
            class259.method4993(WorldMapType2.vorbis, "Music Samples");
            class259.method4993(LocType.instruments, "Music Patches");
            class259.method4993(class19.worldmapdata, "World Map");
            TradingPost.graphicsDefaults = new GraphicsDefaults();
            TradingPost.graphicsDefaults.method4013(class36.defaults);
            class316.loadingText = "Loaded update list";
            class316.loadingBarPercentage = 30;
            client.loadingStage = 45;
         }
      } else if(client.loadingStage == 45) {
         CombatInfo1.method1156(22050, !client.lowMemory, 2);
         class257 var34 = new class257();
         var34.method4857(9, 128);
         client.soundSystem0 = class4.method41(GameEngine.taskManager, 0, 22050);
         client.soundSystem0.method330(var34);
         UrlRequester.method4081(LocType.instruments, WorldMapType2.vorbis, class192.synths, var34);
         class116.soundSystem1 = class4.method41(GameEngine.taskManager, 1, 2048);
         class2.field413 = new class184();
         class116.soundSystem1.method330(class2.field413);
         class215.field3697 = new Resampler(22050, AbstractSoundSystem.sampleRate);
         class316.loadingText = "Prepared sound engine";
         class316.loadingBarPercentage = 35;
         client.loadingStage = 50;
         FontName.fonts = new Fonts(JagException.sprites, SpotAnimation.fontmetrics);
      } else {
         int var1;
         if(client.loadingStage == 50) {
            FontName[] var33 = new FontName[]{FontName.FontName_plain12, FontName.FontName_bold12, FontName.field3741, FontName.field3743, FontName.field3742, FontName.FontName_plain11};
            var1 = var33.length;
            Fonts var25 = FontName.fonts;
            FontName[] var24 = new FontName[]{FontName.FontName_plain12, FontName.FontName_bold12, FontName.field3741, FontName.field3743, FontName.field3742, FontName.FontName_plain11};
            client.fontsMap = var25.method4045(var24);
            if(client.fontsMap.size() < var1) {
               class316.loadingText = "Loading fonts - " + client.fontsMap.size() * 100 / var1 + "%";
               class316.loadingBarPercentage = 40;
            } else {
               WorldMapType1.fontPlain11 = (Font) client.fontsMap.get(FontName.FontName_plain11);
               TotalQuantityComparator.font_p12full = (Font) client.fontsMap.get(FontName.FontName_plain12);
               class288.fontBold12 = (Font) client.fontsMap.get(FontName.FontName_bold12);
               PlayerEntity.field634 = client.field911.vmethod5955();
               class316.loadingText = "Loaded fonts";
               class316.loadingBarPercentage = 40;
               client.loadingStage = 60;
            }
         } else {
            Js5 var2;
            int var18;
            int var31;
            Js5 var36;
            if(client.loadingStage == 60) {
               var36 = Size.binary;
               var2 = JagException.sprites;
               var18 = 0;
               if(var36.method1538("title.jpg", "")) {
                  ++var18;
               }

               if(var2.method1538("logo", "")) {
                  ++var18;
               }

               if(var2.method1538("logo_deadman_mode", "")) {
                  ++var18;
               }

               if(var2.method1538("titlebox", "")) {
                  ++var18;
               }

               if(var2.method1538("titlebutton", "")) {
                  ++var18;
               }

               if(var2.method1538("runes", "")) {
                  ++var18;
               }

               if(var2.method1538("title_mute", "")) {
                  ++var18;
               }

               if(var2.method1538("options_radio_buttons,0", "")) {
                  ++var18;
               }

               if(var2.method1538("options_radio_buttons,2", "")) {
                  ++var18;
               }

               if(var2.method1538("options_radio_buttons,4", "")) {
                  ++var18;
               }

               if(var2.method1538("options_radio_buttons,6", "")) {
                  ++var18;
               }

               var2.method1538("sl_back", "");
               var2.method1538("sl_flags", "");
               var2.method1538("sl_arrows", "");
               var2.method1538("sl_stars", "");
               var2.method1538("sl_button", "");
               var31 = class79.method1159();
               if(var18 < var31) {
                  class316.loadingText = "Loading title screen - " + var18 * 100 / var31 + "%";
                  class316.loadingBarPercentage = 50;
               } else {
                  class316.loadingText = "Loaded title screen";
                  class316.loadingBarPercentage = 50;
                  class310.method5922(5);
                  client.loadingStage = 70;
               }
            } else if(client.loadingStage == 70) {
               if(!class98.configs.method1589()) {
                  class316.loadingText = "Loading config - " + class98.configs.method2649() + "%";
                  class316.loadingBarPercentage = 60;
               } else {
                  Js5 var32 = class98.configs;
                  Overlay.overlay_ref = var32;
                  var36 = class98.configs;
                  FloorUnderlayDefinition.underlay_ref = var36;
                  var2 = class98.configs;
                  Js5 var3 = class113.models;
                  IDKType.identKit_ref = var2;
                  IDKType.field3367 = var3;
                  IDKType.field3368 = IDKType.identKit_ref.method1574(3);
                  MapElementType.method2388(class98.configs, class113.models, client.lowMemory);
                  class34.method556(class98.configs, class113.models);
                  GameObject.method2035(class98.configs);
                  WorldMapType2.method3155(class98.configs, class113.models, client.isMembers, WorldMapType1.fontPlain11);
                  MouseRecorder.method2746(class98.configs, WorldMapDecoration.anims, GameCanvas.bases);
                  class202.method4070(class98.configs, class113.models);
                  class193.method3793(class98.configs);
                  class166.method2812(class98.configs);
                  class120.method2040(class166.interfacesArchive, class113.models, JagException.sprites, SpotAnimation.fontmetrics);
                  Js5 var19 = class98.configs;
                  class204.field3301 = var19;
                  Varcs.method4769(class98.configs);
                  Js5 var26 = class98.configs;
                  VarClientType.field3336 = var26;
                  ModeWhere.method2940(class98.configs);
                  Js5 var27 = class98.configs;
                  class116.field49 = var27;
                  MapIconReference.varcs = new Varcs();
                  Js5 var7 = class98.configs;
                  Js5 var29 = JagException.sprites;
                  Js5 var9 = SpotAnimation.fontmetrics;
                  class92.field2355 = var7;
                  HitmarkType.field3447 = var29;
                  HitmarkType.field3439 = var9;
                  Js5 var30 = class98.configs;
                  Js5 var11 = JagException.sprites;
                  HeadbarType.field3389 = var30;
                  HeadbarType.field3380 = var11;
                  Js5 var12 = class98.configs;
                  Js5 var13 = JagException.sprites;
                  MapElementType.field3309 = var13;
                  if(var12.method1589()) {
                     MapElementType.field3331 = var12.method1574(35);
                     MapElementType.mapElementTypes = new MapElementType[MapElementType.field3331];

                     for(int var14 = 0; var14 < MapElementType.field3331; ++var14) {
                        byte[] var15 = var12.method1516(35, var14, 1789634852);
                        MapElementType.mapElementTypes[var14] = new MapElementType(var14);
                        if(var15 != null) {
                           MapElementType.mapElementTypes[var14].method2375(new Packet(var15));
                           MapElementType.mapElementTypes[var14].method2365();
                        }
                     }
                  }

                  class316.loadingText = "Loaded config";
                  class316.loadingBarPercentage = 60;
                  client.loadingStage = 80;
               }
            } else if(client.loadingStage == 80) {
               var0 = 0;
               if(class306.compass == null) {
                  class306.compass = class36.method576(JagException.sprites, TradingPost.graphicsDefaults.field3816, 0, (byte)-19);
               } else {
                  ++var0;
               }

               if(Size.mapedge == null) {
                  Size.mapedge = class36.method576(JagException.sprites, TradingPost.graphicsDefaults.field3817, 0, (byte)47);
               } else {
                  ++var0;
               }

               IndexedSprite[] var17;
               if(class0.mapscene == null) {
                  var2 = JagException.sprites;
                  var18 = TradingPost.graphicsDefaults.field3815;
                  if(!WorldMapRectangle.method128(var2, var18, 0)) {
                     var17 = null;
                  } else {
                     var17 = GraphicsDefaults.method4016();
                  }

                  class0.mapscene = var17;
               } else {
                  ++var0;
               }

               boolean var4;
               byte[] var5;
               SpritePixels[] var6;
               SpritePixels var8;
               byte[] var10;
               int var20;
               int var21;
               int var22;
               SpritePixels[] var35;
               if(PlayerEntity.headIconsPk == null) {
                  var2 = JagException.sprites;
                  var18 = TradingPost.graphicsDefaults.field3818;
                  var5 = var2.method1516(var18, 0, 1789634852);
                  if(var5 == null) {
                     var4 = false;
                  } else {
                     SceneTilePaint.method667(var5);
                     var4 = true;
                  }

                  if(!var4) {
                     var35 = null;
                  } else {
                     var6 = new SpritePixels[class95.indexedSpriteCount];
                     var20 = 0;

                     while(true) {
                        if(var20 >= class95.indexedSpriteCount) {
                           class95.indexedSpriteOffsetXs = null;
                           class95.indexedSpriteOffsetYs = null;
                           class95.indexSpriteWidths = null;
                           VarClientType.indexedSpriteHeights = null;
                           class95.indexedSpritePalette = null;
                           class95.spritePixels = null;
                           var35 = var6;
                           break;
                        }

                        var8 = var6[var20] = new SpritePixels();
                        var8.maxWidth = class95.indexedSpriteWidth;
                        var8.maxHeight = class95.indexedSpriteHeight;
                        var8.offsetX = class95.indexedSpriteOffsetXs[var20];
                        var8.offsetY = class95.indexedSpriteOffsetYs[var20];
                        var8.width = class95.indexSpriteWidths[var20];
                        var8.height = VarClientType.indexedSpriteHeights[var20];
                        var21 = var8.height * var8.width;
                        var10 = class95.spritePixels[var20];
                        var8.pixels = new int[var21];

                        for(var22 = 0; var22 < var21; ++var22) {
                           var8.pixels[var22] = class95.indexedSpritePalette[var10[var22] & 255];
                        }

                        ++var20;
                     }
                  }

                  PlayerEntity.headIconsPk = var35;
               } else {
                  ++var0;
               }

               if(UrlRequester.headIconsPrayer == null) {
                  var2 = JagException.sprites;
                  var18 = TradingPost.graphicsDefaults.field3813;
                  var5 = var2.method1516(var18, 0, 1789634852);
                  if(var5 == null) {
                     var4 = false;
                  } else {
                     SceneTilePaint.method667(var5);
                     var4 = true;
                  }

                  if(!var4) {
                     var35 = null;
                  } else {
                     var6 = new SpritePixels[class95.indexedSpriteCount];
                     var20 = 0;

                     while(true) {
                        if(var20 >= class95.indexedSpriteCount) {
                           class95.indexedSpriteOffsetXs = null;
                           class95.indexedSpriteOffsetYs = null;
                           class95.indexSpriteWidths = null;
                           VarClientType.indexedSpriteHeights = null;
                           class95.indexedSpritePalette = null;
                           class95.spritePixels = null;
                           var35 = var6;
                           break;
                        }

                        var8 = var6[var20] = new SpritePixels();
                        var8.maxWidth = class95.indexedSpriteWidth;
                        var8.maxHeight = class95.indexedSpriteHeight;
                        var8.offsetX = class95.indexedSpriteOffsetXs[var20];
                        var8.offsetY = class95.indexedSpriteOffsetYs[var20];
                        var8.width = class95.indexSpriteWidths[var20];
                        var8.height = VarClientType.indexedSpriteHeights[var20];
                        var21 = var8.height * var8.width;
                        var10 = class95.spritePixels[var20];
                        var8.pixels = new int[var21];

                        for(var22 = 0; var22 < var21; ++var22) {
                           var8.pixels[var22] = class95.indexedSpritePalette[var10[var22] & 255];
                        }

                        ++var20;
                     }
                  }

                  UrlRequester.headIconsPrayer = var35;
               } else {
                  ++var0;
               }

               if(class158.headIconsHint == null) {
                  var2 = JagException.sprites;
                  var18 = TradingPost.graphicsDefaults.field3814;
                  var5 = var2.method1516(var18, 0, 1789634852);
                  if(var5 == null) {
                     var4 = false;
                  } else {
                     SceneTilePaint.method667(var5);
                     var4 = true;
                  }

                  if(!var4) {
                     var35 = null;
                  } else {
                     var6 = new SpritePixels[class95.indexedSpriteCount];
                     var20 = 0;

                     while(true) {
                        if(var20 >= class95.indexedSpriteCount) {
                           class95.indexedSpriteOffsetXs = null;
                           class95.indexedSpriteOffsetYs = null;
                           class95.indexSpriteWidths = null;
                           VarClientType.indexedSpriteHeights = null;
                           class95.indexedSpritePalette = null;
                           class95.spritePixels = null;
                           var35 = var6;
                           break;
                        }

                        var8 = var6[var20] = new SpritePixels();
                        var8.maxWidth = class95.indexedSpriteWidth;
                        var8.maxHeight = class95.indexedSpriteHeight;
                        var8.offsetX = class95.indexedSpriteOffsetXs[var20];
                        var8.offsetY = class95.indexedSpriteOffsetYs[var20];
                        var8.width = class95.indexSpriteWidths[var20];
                        var8.height = VarClientType.indexedSpriteHeights[var20];
                        var21 = var8.height * var8.width;
                        var10 = class95.spritePixels[var20];
                        var8.pixels = new int[var21];

                        for(var22 = 0; var22 < var21; ++var22) {
                           var8.pixels[var22] = class95.indexedSpritePalette[var10[var22] & 255];
                        }

                        ++var20;
                     }
                  }

                  class158.headIconsHint = var35;
               } else {
                  ++var0;
               }

               if(class11.mapMarkers == null) {
                  var2 = JagException.sprites;
                  var18 = TradingPost.graphicsDefaults.field3819;
                  var5 = var2.method1516(var18, 0, 1789634852);
                  if(var5 == null) {
                     var4 = false;
                  } else {
                     SceneTilePaint.method667(var5);
                     var4 = true;
                  }

                  if(!var4) {
                     var35 = null;
                  } else {
                     var6 = new SpritePixels[class95.indexedSpriteCount];
                     var20 = 0;

                     while(true) {
                        if(var20 >= class95.indexedSpriteCount) {
                           class95.indexedSpriteOffsetXs = null;
                           class95.indexedSpriteOffsetYs = null;
                           class95.indexSpriteWidths = null;
                           VarClientType.indexedSpriteHeights = null;
                           class95.indexedSpritePalette = null;
                           class95.spritePixels = null;
                           var35 = var6;
                           break;
                        }

                        var8 = var6[var20] = new SpritePixels();
                        var8.maxWidth = class95.indexedSpriteWidth;
                        var8.maxHeight = class95.indexedSpriteHeight;
                        var8.offsetX = class95.indexedSpriteOffsetXs[var20];
                        var8.offsetY = class95.indexedSpriteOffsetYs[var20];
                        var8.width = class95.indexSpriteWidths[var20];
                        var8.height = VarClientType.indexedSpriteHeights[var20];
                        var21 = var8.height * var8.width;
                        var10 = class95.spritePixels[var20];
                        var8.pixels = new int[var21];

                        for(var22 = 0; var22 < var21; ++var22) {
                           var8.pixels[var22] = class95.indexedSpritePalette[var10[var22] & 255];
                        }

                        ++var20;
                     }
                  }

                  class11.mapMarkers = var35;
               } else {
                  ++var0;
               }

               if(class86.crossSprites == null) {
                  var2 = JagException.sprites;
                  var18 = TradingPost.graphicsDefaults.field3820;
                  var5 = var2.method1516(var18, 0, 1789634852);
                  if(var5 == null) {
                     var4 = false;
                  } else {
                     SceneTilePaint.method667(var5);
                     var4 = true;
                  }

                  if(!var4) {
                     var35 = null;
                  } else {
                     var6 = new SpritePixels[class95.indexedSpriteCount];
                     var20 = 0;

                     while(true) {
                        if(var20 >= class95.indexedSpriteCount) {
                           class95.indexedSpriteOffsetXs = null;
                           class95.indexedSpriteOffsetYs = null;
                           class95.indexSpriteWidths = null;
                           VarClientType.indexedSpriteHeights = null;
                           class95.indexedSpritePalette = null;
                           class95.spritePixels = null;
                           var35 = var6;
                           break;
                        }

                        var8 = var6[var20] = new SpritePixels();
                        var8.maxWidth = class95.indexedSpriteWidth;
                        var8.maxHeight = class95.indexedSpriteHeight;
                        var8.offsetX = class95.indexedSpriteOffsetXs[var20];
                        var8.offsetY = class95.indexedSpriteOffsetYs[var20];
                        var8.width = class95.indexSpriteWidths[var20];
                        var8.height = VarClientType.indexedSpriteHeights[var20];
                        var21 = var8.width * var8.height;
                        var10 = class95.spritePixels[var20];
                        var8.pixels = new int[var21];

                        for(var22 = 0; var22 < var21; ++var22) {
                           var8.pixels[var22] = class95.indexedSpritePalette[var10[var22] & 255];
                        }

                        ++var20;
                     }
                  }

                  class86.crossSprites = var35;
               } else {
                  ++var0;
               }

               if(GameEngine.mapDots == null) {
                  var2 = JagException.sprites;
                  var18 = TradingPost.graphicsDefaults.field3821;
                  var5 = var2.method1516(var18, 0, 1789634852);
                  if(var5 == null) {
                     var4 = false;
                  } else {
                     SceneTilePaint.method667(var5);
                     var4 = true;
                  }

                  if(!var4) {
                     var35 = null;
                  } else {
                     var6 = new SpritePixels[class95.indexedSpriteCount];
                     var20 = 0;

                     while(true) {
                        if(var20 >= class95.indexedSpriteCount) {
                           class95.indexedSpriteOffsetXs = null;
                           class95.indexedSpriteOffsetYs = null;
                           class95.indexSpriteWidths = null;
                           VarClientType.indexedSpriteHeights = null;
                           class95.indexedSpritePalette = null;
                           class95.spritePixels = null;
                           var35 = var6;
                           break;
                        }

                        var8 = var6[var20] = new SpritePixels();
                        var8.maxWidth = class95.indexedSpriteWidth;
                        var8.maxHeight = class95.indexedSpriteHeight;
                        var8.offsetX = class95.indexedSpriteOffsetXs[var20];
                        var8.offsetY = class95.indexedSpriteOffsetYs[var20];
                        var8.width = class95.indexSpriteWidths[var20];
                        var8.height = VarClientType.indexedSpriteHeights[var20];
                        var21 = var8.height * var8.width;
                        var10 = class95.spritePixels[var20];
                        var8.pixels = new int[var21];

                        for(var22 = 0; var22 < var21; ++var22) {
                           var8.pixels[var22] = class95.indexedSpritePalette[var10[var22] & 255];
                        }

                        ++var20;
                     }
                  }

                  GameEngine.mapDots = var35;
               } else {
                  ++var0;
               }

               if(class238.scrollbarSprites == null) {
                  var2 = JagException.sprites;
                  var18 = TradingPost.graphicsDefaults.field3822;
                  var5 = var2.method1516(var18, 0, 1789634852);
                  if(var5 == null) {
                     var4 = false;
                  } else {
                     SceneTilePaint.method667(var5);
                     var4 = true;
                  }

                  if(!var4) {
                     var17 = null;
                  } else {
                     var17 = GraphicsDefaults.method4016();
                  }

                  class238.scrollbarSprites = var17;
               } else {
                  ++var0;
               }

               if(MapIconReference.modIconSprites == null) {
                  var2 = JagException.sprites;
                  var18 = TradingPost.graphicsDefaults.field3823;
                  var5 = var2.method1516(var18, 0, 1789634852);
                  if(var5 == null) {
                     var4 = false;
                  } else {
                     SceneTilePaint.method667(var5);
                     var4 = true;
                  }

                  if(!var4) {
                     var17 = null;
                  } else {
                     var17 = GraphicsDefaults.method4016();
                  }

                  MapIconReference.modIconSprites = var17;
               } else {
                  ++var0;
               }

               if(var0 < 11) {
                  class316.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class316.loadingBarPercentage = 70;
               } else {
                  FontTypeFace.modIcons = MapIconReference.modIconSprites;
                  Size.mapedge.method2311();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  int var23 = (int)(Math.random() * 21.0D) - 10;
                  var18 = (int)(Math.random() * 21.0D) - 10;
                  var31 = (int)(Math.random() * 41.0D) - 20;
                  class0.mapscene[0].method828(var31 + var1, var23 + var31, var18 + var31);
                  class316.loadingText = "Loaded sprites";
                  class316.loadingBarPercentage = 70;
                  client.loadingStage = 90;
               }
            } else if(client.loadingStage == 90) {
               if(!WorldMapRectangle.textures.method1589()) {
                  class316.loadingText = "Loading textures - " + "0%";
                  class316.loadingBarPercentage = 90;
               } else {
                  class144.field3688 = new TextureProvider(WorldMapRectangle.textures, JagException.sprites, 20, 0.8D, client.lowMemory?64:128);
                  Graphics3D.method2566(class144.field3688);
                  Graphics3D.method2567(0.8D);
                  client.loadingStage = 100;
               }
            } else if(client.loadingStage == 100) {
               var0 = class144.field3688.method2766();
               if(var0 < 100) {
                  class316.loadingText = "Loading textures - " + var0 + "%";
                  class316.loadingBarPercentage = 90;
               } else {
                  class316.loadingText = "Loaded textures";
                  class316.loadingBarPercentage = 90;
                  client.loadingStage = 110;
               }
            } else if(client.loadingStage == 110) {
               MapIconReference.mouseRecorder = new MouseRecorder();
               GameEngine.taskManager.method4451(MapIconReference.mouseRecorder, 10);
               class316.loadingText = "Loaded input handler";
               class316.loadingBarPercentage = 92;
               client.loadingStage = 120;
            } else if(client.loadingStage == 120) {
               if(!Size.binary.method1538("huffman", "")) {
                  class316.loadingText = "Loading wordpack - " + 0 + "%";
                  class316.loadingBarPercentage = 94;
               } else {
                  Huffman var16 = new Huffman(Size.binary.method1534("huffman", ""));
                  VarPlayerType.method5550(var16);
                  class316.loadingText = "Loaded wordpack";
                  class316.loadingBarPercentage = 94;
                  client.loadingStage = 130;
               }
            } else if(client.loadingStage == 130) {
               if(!class166.interfacesArchive.method1589()) {
                  class316.loadingText = "Loading interfaces - " + class166.interfacesArchive.method2649() * 4 / 5 + "%";
                  class316.loadingBarPercentage = 96;
               } else if(!UrlRequester.clientscripts.method1589()) {
                  class316.loadingText = "Loading interfaces - " + (80 + UrlRequester.clientscripts.method2649() / 6) + "%";
                  class316.loadingBarPercentage = 96;
               } else if(!SpotAnimation.fontmetrics.method1589()) {
                  class316.loadingText = "Loading interfaces - " + (96 + SpotAnimation.fontmetrics.method2649() / 50) + "%";
                  class316.loadingBarPercentage = 96;
               } else {
                  class316.loadingText = "Loaded interfaces";
                  class316.loadingBarPercentage = 98;
                  client.loadingStage = 140;
               }
            } else if(client.loadingStage == 140) {
               class316.loadingBarPercentage = 100;
               if(!class19.worldmapdata.method1536(MapCacheArchiveNames.field291.name)) {
                  class316.loadingText = "Loading world map - " + class19.worldmapdata.method1530(MapCacheArchiveNames.field291.name) / 10 + "%";
               } else {
                  if(class219.worldMap == null) {
                     class219.worldMap = new WorldMap();
                     class219.worldMap.method1192(class19.worldmapdata, class288.fontBold12, client.fontsMap, class0.mapscene);
                  }

                  var0 = class219.worldMap.method1196();
                  if(var0 < 100) {
                     class316.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                  } else {
                     class316.loadingText = "Loaded world map";
                     client.loadingStage = 150;
                  }
               }
            } else if(client.loadingStage == 150) {
               class310.method5922(10);
            }
         }
      }
   }
}
