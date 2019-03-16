package net.runelite.runescape;

import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class219 {
   @ObfuscatedName("sb")
   @ObfuscatedSignature(
      signature = "Llg;"
   )
   static WorldMap worldMap;
   @ObfuscatedName("r")
   public static String field420;
   @ObfuscatedName("g")
   public static Applet field419;

   static {
      field419 = null;
      field420 = "";
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "105"
   )
   static final void method4425(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class232.method4564(var0)) {
         WorldMapType1.field165 = null;
         AbstractSoundSystem.method301(class36.interfaces[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(WorldMapType1.field165 != null) {
            AbstractSoundSystem.method301(WorldMapType1.field165, -1412584499, var1, var2, var3, var4, TradingPost.field12, class139.field2051, var7);
            WorldMapType1.field165 = null;
         }

      } else {
         if(var7 != -1) {
            client.field848[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field848[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "613916939"
   )
   static void method4415(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1016[var5] != var0) {
            var2[var4] = World.field1016[var5];
            var3[var4] = World.field1018[var5];
            ++var4;
         }
      }

      World.field1016 = var2;
      World.field1018 = var3;
      class13.method190(World.worldList, 0, World.worldList.length - 1, World.field1016, World.field1018);
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "([Lhn;IIIIIIII)V",
      garbageValue = "-936583816"
   )
   static final void method4424(ComponentType[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         ComponentType var9 = var0[var8];
         if(var9 != null && var9.layer == var1 && (!var9.isIf3 || var9.type == 0 || var9.hasHook || class101.method1704(var9) != 0 || var9 == client.field817 || var9.clientcode == 1338)) {
            if(var9.isIf3) {
               if(GameCanvas.method894(var9)) {
                  continue;
               }
            } else if(var9.type == 0 && var9 != class133.field1993 && GameCanvas.method894(var9)) {
               continue;
            }

            int var10 = var9.x + var6;
            int var11 = var7 + var9.y;
            int var12;
            int var13;
            int var14;
            int var15;
            int var17;
            int var18;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else {
               int var16;
               if(var9.type == 9) {
                  var16 = var10;
                  var17 = var11;
                  var18 = var10 + var9.width;
                  int var19 = var11 + var9.height;
                  if(var18 < var10) {
                     var16 = var18;
                     var18 = var10;
                  }

                  if(var19 < var11) {
                     var17 = var19;
                     var19 = var11;
                  }

                  ++var18;
                  ++var19;
                  var12 = var16 > var2?var16:var2;
                  var13 = var17 > var3?var17:var3;
                  var14 = var18 < var4?var18:var4;
                  var15 = var19 < var5?var19:var5;
               } else {
                  var16 = var10 + var9.width;
                  var17 = var11 + var9.height;
                  var12 = var10 > var2?var10:var2;
                  var13 = var11 > var3?var11:var3;
                  var14 = var16 < var4?var16:var4;
                  var15 = var17 < var5?var17:var5;
               }
            }

            if(var9 == client.draggedWidget) {
               client.field824 = true;
               client.field825 = var10;
               client.field826 = var11;
            }

            boolean var32 = false;
            if(var9.field2724) {
               switch(client.field805) {
               case 0:
                  var32 = true;
               case 1:
               default:
                  break;
               case 2:
                  if(client.field642 == var9.id >>> 16) {
                     var32 = true;
                  }
                  break;
               case 3:
                  if(var9.id == client.field642) {
                     var32 = true;
                  }
               }
            }

            if(var32 || !var9.isIf3 || var12 < var14 && var13 < var15) {
               if(var9.isIf3) {
                  ScriptEvent var26;
                  if(var9.noClickThrough) {
                     if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY * -976212263 >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY * -976212263 < var15) {
                        for(var26 = (ScriptEvent) client.field842.method4373(); var26 != null; var26 = (ScriptEvent) client.field842.method4358()) {
                           if(var26.field563) {
                              var26.method6469();
                              var26.source.field2798 = false;
                           }
                        }

                        if(class77.field2817 == 0) {
                           client.draggedWidget = null;
                           client.field817 = null;
                        }

                        if(!client.isMenuOpen) {
                           WorldMapType3.method1691();
                        }
                     }
                  } else if(var9.noScrollThrough && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY * -976212263 >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY * -976212263 < var15) {
                     for(var26 = (ScriptEvent) client.field842.method4373(); var26 != null; var26 = (ScriptEvent) client.field842.method4358()) {
                        if(var26.field563 && var26.source.onScrollWheelListener == var26.params) {
                           var26.method6469();
                        }
                     }
                  }
               }

               var17 = MouseInput.mouseLastX;
               var18 = MouseInput.mouseLastY * -976212263;
               if(MouseInput.mouseLastButton != 0) {
                  var17 = MouseInput.mouseLastPressedX;
                  var18 = MouseInput.mouseLastPressedY;
               }

               boolean var33 = var17 >= var12 && var18 >= var13 && var17 < var14 && var18 < var15;
               if(var9.clientcode == 1337) {
                  if(!client.field654 && !client.isMenuOpen && var33) {
                     World.method3742(var17, var18, var12, var13);
                  }
               } else if(var9.clientcode == 1338) {
                  class43.method615(var9, var10, var11);
               } else {
                  if(var9.clientcode == 1400) {
                     worldMap.method1194(MouseInput.mouseLastX, MouseInput.mouseLastY * -976212263, var33, var10, var11, var9.width, var9.height);
                  }

                  if(!client.isMenuOpen && var33) {
                     if(var9.clientcode == 1400) {
                        worldMap.method1293(var10, var11, var9.width, var9.height, var17, var18);
                     } else {
                        SpotAnimation.method5435(var9, var17 - var10, var18 - var11);
                     }
                  }

                  boolean var21;
                  int var23;
                  if(var32) {
                     for(int var20 = 0; var20 < var9.opKeys.length; ++var20) {
                        var21 = false;
                        boolean var22 = false;
                        if(!var21 && var9.opKeys[var20] != null) {
                           for(var23 = 0; var23 < var9.opKeys[var20].length; ++var23) {
                              boolean var24 = false;
                              if(var9.opKeysIgnoreHeld != null) {
                                 var24 = KeyFocusListener.keyPressed[var9.opKeys[var20][var23]];
                              }

                              if(WorldMapDecoration.method2944(var9.opKeys[var20][var23]) || var24) {
                                 var21 = true;
                                 if(var9.opKeysIgnoreHeld != null && var9.opKeysIgnoreHeld[var20] > client.gameCycle) {
                                    break;
                                 }

                                 byte var25 = var9.opKeyModifiers[var20][var23];
                                 if(var25 == 0 || ((var25 & 8) == 0 || !KeyFocusListener.keyPressed[86] && !KeyFocusListener.keyPressed[82] && !KeyFocusListener.keyPressed[81]) && ((var25 & 2) == 0 || KeyFocusListener.keyPressed[86]) && ((var25 & 1) == 0 || KeyFocusListener.keyPressed[82]) && ((var25 & 4) == 0 || KeyFocusListener.keyPressed[81])) {
                                    var22 = true;
                                    break;
                                 }
                              }
                           }
                        }

                        if(var22) {
                           if(var20 < 10) {
                              class324.method6406(var20 + 1, var9.id, var9.index, var9.linkObjType, "");
                           } else if(var20 == 10) {
                              Occluder.method4635();
                              OwnWorldComparator.method531(var9.id, var9.index, class192.method3781(class101.method1704(var9)), var9.linkObjType);
                              client.targetVerb = class106.method1886(var9);
                              if(client.targetVerb == null) {
                                 client.targetVerb = "null";
                              }

                              client.opBase = var9.opBase + class31.method548(16777215);
                           }

                           var23 = var9.opKeyRates[var20];
                           if(var9.opKeysIgnoreHeld == null) {
                              var9.opKeysIgnoreHeld = new int[var9.opKeys.length];
                           }

                           if(var9.field2745 == null) {
                              var9.field2745 = new int[var9.opKeys.length];
                           }

                           if(var23 != 0) {
                              if(var9.opKeysIgnoreHeld[var20] == 0) {
                                 var9.opKeysIgnoreHeld[var20] = var23 + client.gameCycle + var9.field2745[var20];
                              } else {
                                 var9.opKeysIgnoreHeld[var20] = var23 + client.gameCycle;
                              }
                           } else {
                              var9.opKeysIgnoreHeld[var20] = Integer.MAX_VALUE;
                           }
                        }

                        if(!var21 && var9.opKeysIgnoreHeld != null) {
                           var9.opKeysIgnoreHeld[var20] = 0;
                        }
                     }
                  }

                  if(var9.isIf3) {
                     if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY * -976212263 >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY * -976212263 < var15) {
                        var33 = true;
                     } else {
                        var33 = false;
                     }

                     boolean var34 = false;
                     if((MouseInput.mouseCurrentButton == 1 || !WorldMapType3.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) && var33) {
                        var34 = true;
                     }

                     var21 = false;
                     if((MouseInput.mouseLastButton == 1 || !WorldMapType3.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                        var21 = true;
                     }

                     if(var21) {
                        Occluder.method4633(var9, MouseInput.mouseLastPressedX - var10, MouseInput.mouseLastPressedY - var11);
                     }

                     if(var9.clientcode == 1400) {
                        worldMap.method1354(var17, var18, var33 & var34, var33 & var21);
                     }

                     if(client.draggedWidget != null && var9 != client.draggedWidget && var33 && class11.method173(class101.method1704(var9))) {
                        client.draggedOnWidget = var9;
                     }

                     if(var9 == client.field817) {
                        client.field821 = true;
                        client.field713 = var10;
                        client.field823 = var11;
                     }

                     if(var9.hasHook) {
                        ScriptEvent var27;
                        if(var33 && client.field841 != 0 && var9.onScrollWheelListener != null) {
                           var27 = new ScriptEvent();
                           var27.field563 = true;
                           var27.source = var9;
                           var27.mouseY = client.field841;
                           var27.params = var9.onScrollWheelListener;
                           client.field842.method4351(var27);
                        }

                        if(client.draggedWidget != null || World.field1025 != null || client.isMenuOpen) {
                           var21 = false;
                           var34 = false;
                           var33 = false;
                        }

                        if(!var9.field2669 && var21) {
                           var9.field2669 = true;
                           if(var9.onClickListener != null) {
                              var27 = new ScriptEvent();
                              var27.field563 = true;
                              var27.source = var9;
                              var27.mouseX = MouseInput.mouseLastPressedX - var10;
                              var27.mouseY = MouseInput.mouseLastPressedY - var11;
                              var27.params = var9.onClickListener;
                              client.field842.method4351(var27);
                           }
                        }

                        if(var9.field2669 && var34 && var9.onClickRepeatListener != null) {
                           var27 = new ScriptEvent();
                           var27.field563 = true;
                           var27.source = var9;
                           var27.mouseX = MouseInput.mouseLastX - var10;
                           var27.mouseY = MouseInput.mouseLastY * -976212263 - var11;
                           var27.params = var9.onClickRepeatListener;
                           client.field842.method4351(var27);
                        }

                        if(var9.field2669 && !var34) {
                           var9.field2669 = false;
                           if(var9.onReleaseListener != null) {
                              var27 = new ScriptEvent();
                              var27.field563 = true;
                              var27.source = var9;
                              var27.mouseX = MouseInput.mouseLastX - var10;
                              var27.mouseY = MouseInput.mouseLastY * -976212263 - var11;
                              var27.params = var9.onReleaseListener;
                              client.field844.method4351(var27);
                           }
                        }

                        if(var34 && var9.onHoldListener != null) {
                           var27 = new ScriptEvent();
                           var27.field563 = true;
                           var27.source = var9;
                           var27.mouseX = MouseInput.mouseLastX - var10;
                           var27.mouseY = MouseInput.mouseLastY * -976212263 - var11;
                           var27.params = var9.onHoldListener;
                           client.field842.method4351(var27);
                        }

                        if(!var9.field2798 && var33) {
                           var9.field2798 = true;
                           if(var9.onMouseOverListener != null) {
                              var27 = new ScriptEvent();
                              var27.field563 = true;
                              var27.source = var9;
                              var27.mouseX = MouseInput.mouseLastX - var10;
                              var27.mouseY = MouseInput.mouseLastY * -976212263 - var11;
                              var27.params = var9.onMouseOverListener;
                              client.field842.method4351(var27);
                           }
                        }

                        if(var9.field2798 && var33 && var9.onMouseRepeatListener != null) {
                           var27 = new ScriptEvent();
                           var27.field563 = true;
                           var27.source = var9;
                           var27.mouseX = MouseInput.mouseLastX - var10;
                           var27.mouseY = MouseInput.mouseLastY * -976212263 - var11;
                           var27.params = var9.onMouseRepeatListener;
                           client.field842.method4351(var27);
                        }

                        if(var9.field2798 && !var33) {
                           var9.field2798 = false;
                           if(var9.onMouseLeaveListener != null) {
                              var27 = new ScriptEvent();
                              var27.field563 = true;
                              var27.source = var9;
                              var27.mouseX = MouseInput.mouseLastX - var10;
                              var27.mouseY = MouseInput.mouseLastY * -976212263 - var11;
                              var27.params = var9.onMouseLeaveListener;
                              client.field844.method4351(var27);
                           }
                        }

                        if(var9.onTimerListener != null) {
                           var27 = new ScriptEvent();
                           var27.source = var9;
                           var27.params = var9.onTimerListener;
                           client.field843.method4351(var27);
                        }

                        ScriptEvent var28;
                        int var35;
                        int var36;
                        if(var9.onVarTransmitListener != null && client.field830 > var9.field2801) {
                           if(var9.varTransmitTriggers != null && client.field830 - var9.field2801 <= 32) {
                              label873:
                              for(var35 = var9.field2801; var35 < client.field830; ++var35) {
                                 var23 = client.field653[var35 & 31];

                                 for(var36 = 0; var36 < var9.varTransmitTriggers.length; ++var36) {
                                    if(var23 == var9.varTransmitTriggers[var36]) {
                                       var28 = new ScriptEvent();
                                       var28.source = var9;
                                       var28.params = var9.onVarTransmitListener;
                                       client.field842.method4351(var28);
                                       break label873;
                                    }
                                 }
                              }
                           } else {
                              var27 = new ScriptEvent();
                              var27.source = var9;
                              var27.params = var9.onVarTransmitListener;
                              client.field842.method4351(var27);
                           }

                           var9.field2801 = client.field830;
                        }

                        if(var9.onInvTransmitListener != null && client.field832 > var9.field2802) {
                           if(var9.invTransmitTriggers != null && client.field832 - var9.field2802 <= 32) {
                              label849:
                              for(var35 = var9.field2802; var35 < client.field832; ++var35) {
                                 var23 = client.field831[var35 & 31];

                                 for(var36 = 0; var36 < var9.invTransmitTriggers.length; ++var36) {
                                    if(var23 == var9.invTransmitTriggers[var36]) {
                                       var28 = new ScriptEvent();
                                       var28.source = var9;
                                       var28.params = var9.onInvTransmitListener;
                                       client.field842.method4351(var28);
                                       break label849;
                                    }
                                 }
                              }
                           } else {
                              var27 = new ScriptEvent();
                              var27.source = var9;
                              var27.params = var9.onInvTransmitListener;
                              client.field842.method4351(var27);
                           }

                           var9.field2802 = client.field832;
                        }

                        if(var9.onStatTransmitListener != null && client.changedSkillsCount > var9.field2735) {
                           if(var9.statTransmitTriggers != null && client.changedSkillsCount - var9.field2735 <= 32) {
                              label825:
                              for(var35 = var9.field2735; var35 < client.changedSkillsCount; ++var35) {
                                 var23 = client.changedSkills[var35 & 31];

                                 for(var36 = 0; var36 < var9.statTransmitTriggers.length; ++var36) {
                                    if(var23 == var9.statTransmitTriggers[var36]) {
                                       var28 = new ScriptEvent();
                                       var28.source = var9;
                                       var28.params = var9.onStatTransmitListener;
                                       client.field842.method4351(var28);
                                       break label825;
                                    }
                                 }
                              }
                           } else {
                              var27 = new ScriptEvent();
                              var27.source = var9;
                              var27.params = var9.onStatTransmitListener;
                              client.field842.method4351(var27);
                           }

                           var9.field2735 = client.changedSkillsCount;
                        }

                        if(client.chatCycle > var9.field2800 && var9.onChatTransmitListener != null) {
                           var27 = new ScriptEvent();
                           var27.source = var9;
                           var27.params = var9.onChatTransmitListener;
                           client.field842.method4351(var27);
                        }

                        if(client.lastFriendTransmit > var9.field2800 && var9.onFriendTransmitListener != null) {
                           var27 = new ScriptEvent();
                           var27.source = var9;
                           var27.params = var9.onFriendTransmitListener;
                           client.field842.method4351(var27);
                        }

                        if(client.field837 > var9.field2800 && var9.onClanTransmitListener != null) {
                           var27 = new ScriptEvent();
                           var27.source = var9;
                           var27.params = var9.onClanTransmitListener;
                           client.field842.method4351(var27);
                        }

                        if(client.field858 > var9.field2800 && var9.onStockTransmitListener != null) {
                           var27 = new ScriptEvent();
                           var27.source = var9;
                           var27.params = var9.onStockTransmitListener;
                           client.field842.method4351(var27);
                        }

                        if(client.field839 > var9.field2800 && var9.onCamFinishedListener != null) {
                           var27 = new ScriptEvent();
                           var27.source = var9;
                           var27.params = var9.onCamFinishedListener;
                           client.field842.method4351(var27);
                        }

                        if(client.lastMiscTransmit > var9.field2800 && var9.onMiscTransmitListener != null) {
                           var27 = new ScriptEvent();
                           var27.source = var9;
                           var27.params = var9.onMiscTransmitListener;
                           client.field842.method4351(var27);
                        }

                        var9.field2800 = client.cycleCntr;
                        if(var9.onKeyListener != null) {
                           for(var35 = 0; var35 < client.field865; ++var35) {
                              ScriptEvent var31 = new ScriptEvent();
                              var31.source = var9;
                              var31.typedKeyCode = client.field867[var35];
                              var31.typedKeyChar = client.field846[var35];
                              var31.params = var9.onKeyListener;
                              client.field842.method4351(var31);
                           }
                        }
                     }
                  }

                  if(!var9.isIf3) {
                     if(client.draggedWidget != null || World.field1025 != null || client.isMenuOpen) {
                        continue;
                     }

                     if((var9.field2788 >= 0 || var9.field2694 != 0) && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY * -976212263 >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY * -976212263 < var15) {
                        if(var9.field2788 >= 0) {
                           class133.field1993 = var0[var9.field2788];
                        } else {
                           class133.field1993 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY * -976212263 >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY * -976212263 < var15) {
                        class98.field495 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class73.method1128(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseInput.mouseLastX, MouseInput.mouseLastY * -976212263);
                     }
                  }

                  if(var9.type == 0) {
                     method4424(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method4424(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     SubInterface var29 = (SubInterface) client.subInterfaces.method380((long)var9.id);
                     if(var29 != null) {
                        if(var29.mode == 0 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY * -976212263 >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY * -976212263 < var15 && !client.isMenuOpen) {
                           for(ScriptEvent var30 = (ScriptEvent) client.field842.method4373(); var30 != null; var30 = (ScriptEvent) client.field842.method4358()) {
                              if(var30.field563) {
                                 var30.method6469();
                                 var30.source.field2798 = false;
                              }
                           }

                           if(class77.field2817 == 0) {
                              client.draggedWidget = null;
                              client.field817 = null;
                           }

                           if(!client.isMenuOpen) {
                              WorldMapType3.method1691();
                           }
                        }

                        class116.method2022(var29.id, var12, var13, var14, var15, var10, var11);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1259821027"
   )
   static void method4423(int var0, int var1) {
      ContextMenuRow var2 = ScriptState.topContextMenuRow;
      class39.method595(var2.param0, var2.param1, var2.type, var2.identifier, var2.option, var2.option, var0, var1, -1692443790);
      ScriptState.topContextMenuRow = null;
   }
}
