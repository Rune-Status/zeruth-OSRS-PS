package net.runelite.runescape;

import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.client.callback.Hooks;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class115 extends class310 {
   @ObfuscatedName("u")
   static int[] tt;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -441352875
   )
   int field329;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -301983929
   )
   int field333;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1597492589
   )
   int field336;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1334613619
   )
   int field330;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "762092377"
   )
   boolean method1977(int var1, int var2) {
      return var1 < this.field330 * 8?false:(var2 < this.field329 * 8?false:(var1 >= this.field330 * 8 + 8?false:var2 < this.field329 * 8 + 8));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-288780430"
   )
   int method1986() {
      return this.field333;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-19"
   )
   int method1979() {
      return this.field336;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class115)) {
         return false;
      } else {
         class115 var2 = (class115)var1;
         return super.field147 == var2.field147 && super.field149 == var2.field149?var2.field330 == this.field330 && var2.field329 == this.field329:false;
      }
   }

   public int hashCode() {
      return super.field147 | super.field149 << 8 | this.field330 << 16 | this.field329 << 24;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-598334366"
   )
   int method1981() {
      return this.field329;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1977249711"
   )
   int method1980() {
      return this.field330;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgl;Lgl;I)V",
      garbageValue = "1833285735"
   )
   void method1990(Packet var1, Packet var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class134.field252.field254) {
         throw new IllegalStateException("");
      } else {
         super.field150 = var2.readUnsignedByte();
         super.field148 = var2.readUnsignedByte();
         super.field146 = var2.readUnsignedShort();
         super.field151 = var2.readUnsignedShort();
         this.field333 = var2.readUnsignedByte();
         this.field336 = var2.readUnsignedByte();
         super.field147 = var2.readUnsignedShort();
         super.field149 = var2.readUnsignedShort();
         this.field330 = var2.readUnsignedByte();
         this.field329 = var2.readUnsignedByte();
         super.field148 = Math.min(super.field148, 4);
         super.field152 = new short[1][64][64];
         super.field153 = new short[super.field148][64][64];
         super.field154 = new byte[super.field148][64][64];
         super.field155 = new byte[super.field148][64][64];
         super.decorations = new WorldMapDecoration[super.field148][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class315.field245.field247) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field147 && var5 == super.field149 && var6 == this.field330 && var7 == this.field329) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method5901(var8 + this.field330 * 8, var9 + this.field329 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "702125233"
   )
   static final void method2006(int var0) {
      if(var0 >= 0) {
         int var1 = client.menuActionParams0[var0];
         int var2 = client.menuActionParams1[var0];
         int var3 = client.menuTypes[var0];
         int var4 = client.menuIdentifiers[var0];
         String var5 = client.menuOptions[var0];
         String var6 = client.menuTargets[var0];
         class39.method595(var1, var2, var3, var4, var5, var6, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY, -2119291913);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-247190777"
   )
   static File method2004(String var0) {
      if(!class76.field2043) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class76.field2040.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class226.field3802, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class76.field2040.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-117"
   )
   static String method2003(int var0) {
      return var0 < 0?"":(client.menuTargets[var0].length() > 0? client.menuOptions[var0] + " " + client.menuTargets[var0]: client.menuOptions[var0]);
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(Lbk;III)V",
      garbageValue = "-683909322"
   )
   static void method1976(PlayerEntity var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = MapCacheArchiveNames.method2149(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.actionFrameCycle = 0;
            var0.actionAnimationDisable = var2;
            var0.field975 = 0;
         }

         if(var3 == 2) {
            var0.field975 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || MapCacheArchiveNames.method2149(var1).forcedPriority >= MapCacheArchiveNames.method2149(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.animationChanged(-1);
         var0.actionFrame = 0;
         var0.actionFrameCycle = 0;
         var0.actionAnimationDisable = var2;
         var0.field975 = 0;
         var0.field959 = var0.queueSize;
      }

   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "57"
   )
   static final void method1983(int var0, int var1, int var2, int var3) {
      ++client.field741;
      Enum.method6514();
      World.method3770();
      if(client.field769 >= 0 && client.players[client.field769] != null) {
         PlayerEntity.method2924(client.players[client.field769], false);
      }

      GroundObject.method4581(true);
      int var4 = class254.highResolutionPlayerCount;
      int[] var5 = class254.highResolutionPlayerIndexes;

      int var6;
      for(var6 = 0; var6 < var4; ++var6) {
         if(var5[var6] != client.field769 && var5[var6] != client.localPlayerIndex) {
            PlayerEntity.method2924(client.players[var5[var6]], true);
         }
      }

      GroundObject.method4581(false);

      for(ProjectileAnimation var28 = (ProjectileAnimation) client.projectiles.method4373(); var28 != null; var28 = (ProjectileAnimation) client.projectiles.method4358()) {
         if(var28.floor == class228.level && client.gameCycle <= var28.endCycle) {
            if(client.gameCycle >= var28.startMovementCycle) {
               if(var28.interacting > 0) {
                  NPCEntity var33 = client.npcs[var28.interacting - 1];
                  if(var33 != null && var33.x >= 0 && var33.x < 13312 && var33.y >= 0 && var33.y < 13312) {
                     var28.method5583(var33.x, var33.y, MilliTimer.method2824(var33.x, var33.y, var28.floor) - var28.endHeight, client.gameCycle);
                  }
               }

               if(var28.interacting < 0) {
                  var6 = -var28.interacting - 1;
                  PlayerEntity var34;
                  if(var6 == client.localPlayerIndex) {
                     var34 = class4.localPlayer;
                  } else {
                     var34 = client.players[var6];
                  }

                  if(var34 != null && var34.x >= 0 && var34.x < 13312 && var34.y >= 0 && var34.y < 13312) {
                     var28.method5583(var34.x, var34.y, MilliTimer.method2824(var34.x, var34.y, var28.floor) - var28.endHeight, client.gameCycle);
                  }
               }

               var28.method5589(client.field705);
               class131.sceneManager.method3830(class228.level, (int)var28.x, (int)var28.y, (int)var28.z, 60, var28, var28.rotationX, -1L, false);
            }
         } else {
            var28.method6469();
         }
      }

      for(SpotAnimation var36 = (SpotAnimation) client.spotAnimationDeque.method4373(); var36 != null; var36 = (SpotAnimation) client.spotAnimationDeque.method4358()) {
         if(var36.level == class228.level && !var36.finished) {
            if(client.gameCycle >= var36.startCycle) {
               var36.method5439(client.field705);
               if(var36.finished) {
                  var36.method6469();
               } else {
                  class131.sceneManager.method3830(var36.level, var36.x, var36.y, var36.height, 60, var36, 0, -1L, false);
               }
            }
         } else {
            var36.method6469();
         }
      }

      TotalQuantityComparator.method1189(var0, var1, var2, var3, true);
      var0 = client.Viewport_xOffset;
      var1 = client.Viewport_yOffset;
      var2 = client.viewportWidth;
      var3 = client.viewportHeight;
      Rasterizer2D.method469(var0, var1, var0 + var2, var3 + var1);
      Graphics3D.method2586();
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var18;
      int var19;
      int var29;
      if(!client.field889) {
         var4 = client.cameraPitchTarget;
         if(client.field729 / 256 > var4) {
            var4 = client.field729 / 256;
         }

         if(client.field890[4] && client.field892[4] + 128 > var4) {
            var4 = client.field892[4] + 128;
         }

         var29 = client.mapAngle & 2047;
         var6 = class192.field68;
         var7 = class195.field1717;
         var8 = class192.field70;
         var9 = var4 * 3 + 600;
         var12 = var3 - 334;
         if(var12 < 0) {
            var12 = 0;
         } else if(var12 > 100) {
            var12 = 100;
         }

         var13 = (client.field898 - client.field897) * var12 / 100 + client.field897;
         var11 = var13 * var9 / 256;
         var12 = 2048 - var4 & 2047;
         var13 = 2048 - var29 & 2047;
         var14 = 0;
         var15 = 0;
         var16 = var11;
         int var17;
         if(var12 != 0) {
            var17 = Graphics3D.SINE[var12];
            var18 = Graphics3D.COSINE[var12];
            var19 = var18 * var15 - var17 * var11 >> 16;
            var16 = var17 * var15 + var18 * var11 >> 16;
            var15 = var19;
         }

         if(var13 != 0) {
            var17 = Graphics3D.SINE[var13];
            var18 = Graphics3D.COSINE[var13];
            var19 = var16 * var17 + var18 * var14 >> 16;
            var16 = var18 * var16 - var17 * var14 >> 16;
            var14 = var19;
         }

         class166.cameraX = var6 - var14;
         Packet.cameraZ = var7 - var15;
         class98.cameraY = var8 - var16;
         ScriptEvent.cameraPitch = var4;
         client.onCameraPitchChanged(-1);
         class39.cameraYaw = var29;
         if(client.camModeType == 1 && client.staffModLevel >= 2 && client.gameCycle % 50 == 0 && (class192.field68 >> 7 != class4.localPlayer.x >> 7 || class192.field70 >> 7 != class4.localPlayer.y >> 7)) {
            var17 = class4.localPlayer.field620;
            var18 = (class192.field68 >> 7) + class158.baseX;
            var19 = (class192.field70 >> 7) + class107.baseY;
            class158.method2697(var18, var19, var17, true);
         }
      }

      int var10;
      if(!client.field889) {
         if(GameEngine.options.hideRoofs) {
            var29 = class228.level;
         } else {
            label804: {
               var6 = 3;
               if(ScriptEvent.cameraPitch < 310) {
                  if(client.camModeType == 1) {
                     var7 = class192.field68 >> 7;
                     var8 = class192.field70 >> 7;
                  } else {
                     var7 = class4.localPlayer.x >> 7;
                     var8 = class4.localPlayer.y >> 7;
                  }

                  var9 = class166.cameraX >> 7;
                  var10 = class98.cameraY >> 7;
                  if(var9 < 0 || var10 < 0 || var9 >= 104 || var10 >= 104) {
                     var29 = class228.level;
                     break label804;
                  }

                  if(var7 < 0 || var8 < 0 || var7 >= 104 || var8 >= 104) {
                     var29 = class228.level;
                     break label804;
                  }

                  if((class98.tileSettings[class228.level][var9][var10] & 4) != 0) {
                     var6 = class228.level;
                  }

                  if(var7 > var9) {
                     var11 = var7 - var9;
                  } else {
                     var11 = var9 - var7;
                  }

                  if(var8 > var10) {
                     var12 = var8 - var10;
                  } else {
                     var12 = var10 - var8;
                  }

                  if(var11 > var12) {
                     var13 = var12 * 65536 / var11;
                     var14 = 32768;

                     while(var9 != var7) {
                        if(var9 < var7) {
                           ++var9;
                        } else if(var9 > var7) {
                           --var9;
                        }

                        if((class98.tileSettings[class228.level][var9][var10] & 4) != 0) {
                           var6 = class228.level;
                        }

                        var14 += var13;
                        if(var14 >= 65536) {
                           var14 -= 65536;
                           if(var10 < var8) {
                              ++var10;
                           } else if(var10 > var8) {
                              --var10;
                           }

                           if((class98.tileSettings[class228.level][var9][var10] & 4) != 0) {
                              var6 = class228.level;
                           }
                        }
                     }
                  } else if(var12 > 0) {
                     var13 = var11 * 65536 / var12;
                     var14 = 32768;

                     while(var8 != var10) {
                        if(var10 < var8) {
                           ++var10;
                        } else if(var10 > var8) {
                           --var10;
                        }

                        if((class98.tileSettings[class228.level][var9][var10] & 4) != 0) {
                           var6 = class228.level;
                        }

                        var14 += var13;
                        if(var14 >= 65536) {
                           var14 -= 65536;
                           if(var9 < var7) {
                              ++var9;
                           } else if(var9 > var7) {
                              --var9;
                           }

                           if((class98.tileSettings[class228.level][var9][var10] & 4) != 0) {
                              var6 = class228.level;
                           }
                        }
                     }
                  }
               }

               if(class4.localPlayer.x >= 0 && class4.localPlayer.y >= 0 && class4.localPlayer.x < 13312 && class4.localPlayer.y < 13312) {
                  if((class98.tileSettings[class228.level][class4.localPlayer.x >> 7][class4.localPlayer.y >> 7] & 4) != 0) {
                     var6 = class228.level;
                  }

                  var29 = var6;
               } else {
                  var29 = class228.level;
               }
            }
         }

         var4 = var29;
      } else {
         if(GameEngine.options.hideRoofs) {
            var29 = class228.level;
         } else {
            var6 = MilliTimer.method2824(class166.cameraX, class98.cameraY, class228.level);
            if(var6 - Packet.cameraZ < 800 && (class98.tileSettings[class228.level][class166.cameraX >> 7][class98.cameraY >> 7] & 4) != 0) {
               var29 = class228.level;
            } else {
               var29 = 3;
            }
         }

         var4 = var29;
      }

      var29 = class166.cameraX;
      var6 = Packet.cameraZ;
      var7 = class98.cameraY;
      var8 = ScriptEvent.cameraPitch;
      var9 = class39.cameraYaw;

      for(var10 = 0; var10 < 5; ++var10) {
         if(client.field890[var10]) {
            var11 = (int)(Math.random() * (double)(client.field891[var10] * 2 + 1) - (double) client.field891[var10] + Math.sin((double) client.field893[var10] / 100.0D * (double) client.field894[var10]) * (double) client.field892[var10]);
            if(var10 == 0) {
               class166.cameraX += var11;
            }

            if(var10 == 1) {
               Packet.cameraZ += var11;
            }

            if(var10 == 2) {
               class98.cameraY += var11;
            }

            if(var10 == 3) {
               class39.cameraYaw = var11 + class39.cameraYaw & 2047;
            }

            if(var10 == 4) {
               ScriptEvent.cameraPitch += var11;
               client.onCameraPitchChanged(-1);
               if(ScriptEvent.cameraPitch < 128) {
                  ScriptEvent.cameraPitch = 128;
                  client.onCameraPitchChanged(-1);
               }

               if(ScriptEvent.cameraPitch > 383) {
                  ScriptEvent.cameraPitch = 383;
                  client.onCameraPitchChanged(-1);
               }
            }
         }
      }

      var10 = MouseInput.mouseLastX;
      var11 = MouseInput.mouseLastY * -976212263;
      if(MouseInput.mouseLastButton != 0) {
         var10 = MouseInput.mouseLastPressedX;
         var11 = MouseInput.mouseLastPressedY;
      }

      if(var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
         var12 = var10 - var0;
         var13 = var11 - var1;
         class195.Viewport_mouseX = var12;
         class195.Viewport_mouseY = var13;
         class195.Viewport_containsMouse = true;
         class195.Viewport_entityCountAtMouse = 0;
         class195.Viewport_false0 = false;
      } else {
         SoundTaskDataProvider.method2531();
      }

      class76.method1147();
      Hooks.clearColorBuffer(var0, var1, var2, var3, 0);
      class76.method1147();
      var12 = Graphics3D.Rasterizer3D_zoom;
      Graphics3D.Rasterizer3D_zoom = client.scale;
      class131.sceneManager.method3836(class166.cameraX, Packet.cameraZ, class98.cameraY, ScriptEvent.cameraPitch, class39.cameraYaw, var4);
      Graphics3D.Rasterizer3D_zoom = var12;
      class76.method1147();
      class131.sceneManager.method3809();
      client.overheadTextCount = 0;
      boolean var35 = false;
      var14 = -1;
      var15 = -1;
      var16 = class254.highResolutionPlayerCount;
      int[] var30 = class254.highResolutionPlayerIndexes;

      for(var18 = 0; var18 < var16 + client.highResolutionNpcCount; ++var18) {
         Object var31;
         if(var18 < var16) {
            var31 = client.players[var30[var18]];
            if(var30[var18] == client.field769) {
               var35 = true;
               var14 = var18;
               continue;
            }

            if(var31 == class4.localPlayer) {
               var15 = var18;
               continue;
            }
         } else {
            var31 = client.npcs[client.highResolutionNpcIndexes[var18 - var16]];
         }

         FriendManager.method121((PathingEntity)var31, var18, var0, var1, var2, var3, -1365633758);
      }

      if(client.field762 && var15 != -1) {
         FriendManager.method121(class4.localPlayer, var15, var0, var1, var2, var3, -577288766);
      }

      if(var35) {
         FriendManager.method121(client.players[client.field769], var14, var0, var1, var2, var3, -1669401018);
      }

      for(var18 = 0; var18 < client.overheadTextCount; ++var18) {
         var19 = client.overheadTextsX[var18];
         int var20 = client.overheadTextsY[var18];
         int var21 = client.overheadTextsOffsetX[var18];
         int var22 = client.overheadTextsOffsetY[var18];
         boolean var23 = true;

         while(var23) {
            var23 = false;

            for(int var24 = 0; var24 < var18; ++var24) {
               if(var20 + 2 > client.overheadTextsY[var24] - client.overheadTextsOffsetY[var24] && var20 - var22 < client.overheadTextsY[var24] + 2 && var19 - var21 < client.overheadTextsOffsetX[var24] + client.overheadTextsX[var24] && var21 + var19 > client.overheadTextsX[var24] - client.overheadTextsOffsetX[var24] && client.overheadTextsY[var24] - client.overheadTextsOffsetY[var24] < var20) {
                  var20 = client.overheadTextsY[var24] - client.overheadTextsOffsetY[var24];
                  var23 = true;
               }
            }
         }

         client.screenX = client.overheadTextsX[var18];
         client.screenY = client.overheadTextsY[var18] = var20;
         String var32 = client.overheadTexts[var18];
         if(client.field807 == 0) {
            int var25 = 16776960;
            if(client.field736[var18] < 6) {
               var25 = client.field859[client.field736[var18]];
            }

            if(client.field736[var18] == 6) {
               var25 = client.field741 % 20 < 10?16711680:16776960;
            }

            if(client.field736[var18] == 7) {
               var25 = client.field741 % 20 < 10?255:'\uffff';
            }

            if(client.field736[var18] == 8) {
               var25 = client.field741 % 20 < 10?'뀀':8454016;
            }

            int var26;
            if(client.field736[var18] == 9) {
               var26 = 150 - client.overheadTextsCyclesRemaining[var18];
               if(var26 < 50) {
                  var25 = var26 * 1280 + 16711680;
               } else if(var26 < 100) {
                  var25 = 16776960 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = (var26 - 100) * 5 + 65280;
               }
            }

            if(client.field736[var18] == 10) {
               var26 = 150 - client.overheadTextsCyclesRemaining[var18];
               if(var26 < 50) {
                  var25 = var26 * 5 + 16711680;
               } else if(var26 < 100) {
                  var25 = 16711935 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = (var26 - 100) * 327680 + 255 - (var26 - 100) * 5;
               }
            }

            if(client.field736[var18] == 11) {
               var26 = 150 - client.overheadTextsCyclesRemaining[var18];
               if(var26 < 50) {
                  var25 = 16777215 - var26 * 327685;
               } else if(var26 < 100) {
                  var25 = (var26 - 50) * 327685 + 65280;
               } else if(var26 < 150) {
                  var25 = 16777215 - (var26 - 100) * 327680;
               }
            }

            if(client.field737[var18] == 0) {
               class288.fontBold12.method1862(var32, var0 + client.screenX, client.screenY + var1, var25, 0);
            }

            if(client.field737[var18] == 1) {
               class288.fontBold12.method1784(var32, var0 + client.screenX, client.screenY + var1, var25, 0, client.field741);
            }

            if(client.field737[var18] == 2) {
               class288.fontBold12.method1785(var32, var0 + client.screenX, client.screenY + var1, var25, 0, client.field741);
            }

            if(client.field737[var18] == 3) {
               class288.fontBold12.method1802(var32, var0 + client.screenX, client.screenY + var1, var25, 0, client.field741, 150 - client.overheadTextsCyclesRemaining[var18]);
            }

            if(client.field737[var18] == 4) {
               var26 = (150 - client.overheadTextsCyclesRemaining[var18]) * (class288.fontBold12.method1775(var32) + 100) / 150;
               Rasterizer2D.method443(var0 + client.screenX - 50, var1, var0 + client.screenX + 50, var3 + var1);
               class288.fontBold12.method1828(var32, var0 + client.screenX + 50 - var26, client.screenY + var1, var25, 0);
               Rasterizer2D.method469(var0, var1, var0 + var2, var3 + var1);
            }

            if(client.field737[var18] == 5) {
               var26 = 150 - client.overheadTextsCyclesRemaining[var18];
               int var27 = 0;
               if(var26 < 25) {
                  var27 = var26 - 25;
               } else if(var26 > 125) {
                  var27 = var26 - 125;
               }

               Rasterizer2D.method443(var0, client.screenY + var1 - class288.fontBold12.verticalSpace - 1, var0 + var2, client.screenY + var1 + 5);
               class288.fontBold12.method1862(var32, var0 + client.screenX, var27 + client.screenY + var1, var25, 0);
               Rasterizer2D.method469(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class288.fontBold12.method1862(var32, var0 + client.screenX, client.screenY + var1, 16776960, 0);
         }
      }

      if(client.hintArrowTargetType == 2) {
         class166.method2813((client.hintArrowX - class158.baseX << 7) + client.hintArrowOffsetX, (client.hintArrowY - class107.baseY << 7) + client.hintArrowOffsetY, client.field668 * 2);
         if(client.screenX > -1 && client.gameCycle % 20 < 10) {
            class158.headIconsHint[0].method2253(var0 + client.screenX - 12, client.screenY + var1 - 28);
         }
      }

      ((TextureProvider)Graphics3D.textureLoader).method2772(client.field705);
      class260.method5009(var0, var1, var2, var3);
      class166.cameraX = var29;
      Packet.cameraZ = var6;
      class98.cameraY = var7;
      ScriptEvent.cameraPitch = var8;
      client.onCameraPitchChanged(-1);
      class39.cameraYaw = var9;
      if(client.field654 && class98.method1661(true, false) == 0) {
         client.field654 = false;
      }

      if(client.field654) {
         Rasterizer2D.method449(var0, var1, var2, var3, 0);
         MouseRecorder.method2747("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1475323091"
   )
   static final void method2002(String var0) {
      ChatLine.method5672(30, "", var0);
   }
}
