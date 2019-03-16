package net.runelite.runescape;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
final class class70 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1075((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Le;Le;I)I",
      garbageValue = "-681698410"
   )
   int method1075(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.field16 < var2.field16?-1:(var1.field16 == var2.field16?0:1);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "204236202"
   )
   static int method1086(int var0, class106 var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = class228.level;
         int var9 = (class4.localPlayer.x >> 7) + class158.baseX;
         int var5 = (class4.localPlayer.y >> 7) + class107.baseY;
         method1079().method1204(var3, var9, var5, true);
         return 1;
      } else {
         WorldMapData var11;
         if(var0 == 6601) {
            var3 = class48.intStack[--class228.intStackSize];
            String var16 = "";
            var11 = method1079().method1222(var3);
            if(var11 != null) {
               var16 = var11.method1004();
            }

            class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var16;
            return 1;
         } else if(var0 == 6602) {
            var3 = class48.intStack[--class228.intStackSize];
            method1079().method1205(var3);
            return 1;
         } else if(var0 == 6603) {
            class48.intStack[++class228.intStackSize - 1] = method1079().method1264();
            return 1;
         } else if(var0 == 6604) {
            var3 = class48.intStack[--class228.intStackSize];
            method1079().method1199(var3);
            return 1;
         } else if(var0 == 6605) {
            class48.intStack[++class228.intStackSize - 1] = method1079().method1201()?1:0;
            return 1;
         } else {
            Coordinates var15;
            if(var0 == 6606) {
               var15 = new Coordinates(class48.intStack[--class228.intStackSize]);
               method1079().method1361(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6607) {
               var15 = new Coordinates(class48.intStack[--class228.intStackSize]);
               method1079().method1312(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6608) {
               var15 = new Coordinates(class48.intStack[--class228.intStackSize]);
               method1079().method1225(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6609) {
               var15 = new Coordinates(class48.intStack[--class228.intStackSize]);
               method1079().method1226(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6610) {
               class48.intStack[++class228.intStackSize - 1] = method1079().method1242();
               class48.intStack[++class228.intStackSize - 1] = method1079().method1228();
               return 1;
            } else {
               WorldMapData var13;
               if(var0 == 6611) {
                  var3 = class48.intStack[--class228.intStackSize];
                  var13 = method1079().method1222(var3);
                  if(var13 == null) {
                     class48.intStack[++class228.intStackSize - 1] = 0;
                  } else {
                     class48.intStack[++class228.intStackSize - 1] = var13.method1003().method2471();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class48.intStack[--class228.intStackSize];
                  var13 = method1079().method1222(var3);
                  if(var13 == null) {
                     class48.intStack[++class228.intStackSize - 1] = 0;
                     class48.intStack[++class228.intStackSize - 1] = 0;
                  } else {
                     class48.intStack[++class228.intStackSize - 1] = (var13.method997() - var13.method1017() + 1) * 64;
                     class48.intStack[++class228.intStackSize - 1] = (var13.method1008() - var13.method988() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class48.intStack[--class228.intStackSize];
                  var13 = method1079().method1222(var3);
                  if(var13 == null) {
                     class48.intStack[++class228.intStackSize - 1] = 0;
                     class48.intStack[++class228.intStackSize - 1] = 0;
                     class48.intStack[++class228.intStackSize - 1] = 0;
                     class48.intStack[++class228.intStackSize - 1] = 0;
                  } else {
                     class48.intStack[++class228.intStackSize - 1] = var13.method1017() * 64;
                     class48.intStack[++class228.intStackSize - 1] = var13.method988() * 64;
                     class48.intStack[++class228.intStackSize - 1] = var13.method997() * 64 + 64 - 1;
                     class48.intStack[++class228.intStackSize - 1] = var13.method1008() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class48.intStack[--class228.intStackSize];
                  var13 = method1079().method1222(var3);
                  if(var13 == null) {
                     class48.intStack[++class228.intStackSize - 1] = -1;
                  } else {
                     class48.intStack[++class228.intStackSize - 1] = var13.method995();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var15 = method1079().method1229();
                  if(var15 == null) {
                     class48.intStack[++class228.intStackSize - 1] = -1;
                     class48.intStack[++class228.intStackSize - 1] = -1;
                  } else {
                     class48.intStack[++class228.intStackSize - 1] = var15.worldX;
                     class48.intStack[++class228.intStackSize - 1] = var15.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class48.intStack[++class228.intStackSize - 1] = method1079().method1211();
                  return 1;
               } else if(var0 == 6617) {
                  var15 = new Coordinates(class48.intStack[--class228.intStackSize]);
                  var13 = method1079().method1207();
                  if(var13 == null) {
                     class48.intStack[++class228.intStackSize - 1] = -1;
                     class48.intStack[++class228.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var14 = var13.method987(var15.plane, var15.worldX, var15.worldY);
                     if(var14 == null) {
                        class48.intStack[++class228.intStackSize - 1] = -1;
                        class48.intStack[++class228.intStackSize - 1] = -1;
                     } else {
                        class48.intStack[++class228.intStackSize - 1] = var14[0];
                        class48.intStack[++class228.intStackSize - 1] = var14[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var7;
                  if(var0 == 6618) {
                     var15 = new Coordinates(class48.intStack[--class228.intStackSize]);
                     var13 = method1079().method1207();
                     if(var13 == null) {
                        class48.intStack[++class228.intStackSize - 1] = -1;
                        class48.intStack[++class228.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var7 = var13.method1016(var15.worldX, var15.worldY);
                        if(var7 == null) {
                           class48.intStack[++class228.intStackSize - 1] = -1;
                        } else {
                           class48.intStack[++class228.intStackSize - 1] = var7.method2471();
                        }

                        return 1;
                     }
                  } else {
                     Coordinates var12;
                     if(var0 == 6619) {
                        class228.intStackSize -= 2;
                        var3 = class48.intStack[class228.intStackSize];
                        var12 = new Coordinates(class48.intStack[class228.intStackSize + 1]);
                        class306.method5872(var3, var12, false);
                        return 1;
                     } else if(var0 == 6620) {
                        class228.intStackSize -= 2;
                        var3 = class48.intStack[class228.intStackSize];
                        var12 = new Coordinates(class48.intStack[class228.intStackSize + 1]);
                        class306.method5872(var3, var12, true);
                        return 1;
                     } else if(var0 == 6621) {
                        class228.intStackSize -= 2;
                        var3 = class48.intStack[class228.intStackSize];
                        var12 = new Coordinates(class48.intStack[class228.intStackSize + 1]);
                        var11 = method1079().method1222(var3);
                        if(var11 == null) {
                           class48.intStack[++class228.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class48.intStack[++class228.intStackSize - 1] = var11.method985(var12.plane, var12.worldX, var12.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class48.intStack[++class228.intStackSize - 1] = method1079().method1230();
                        class48.intStack[++class228.intStackSize - 1] = method1079().method1231();
                        return 1;
                     } else if(var0 == 6623) {
                        var15 = new Coordinates(class48.intStack[--class228.intStackSize]);
                        var13 = method1079().method1203(var15.plane, var15.worldX, var15.worldY);
                        if(var13 == null) {
                           class48.intStack[++class228.intStackSize - 1] = -1;
                        } else {
                           class48.intStack[++class228.intStackSize - 1] = var13.method990();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        method1079().method1232(class48.intStack[--class228.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        method1079().method1233();
                        return 1;
                     } else if(var0 == 6626) {
                        method1079().method1234(class48.intStack[--class228.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        method1079().method1235();
                        return 1;
                     } else {
                        boolean var10;
                        if(var0 == 6628) {
                           var10 = class48.intStack[--class228.intStackSize] == 1;
                           method1079().method1289(var10);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class48.intStack[--class228.intStackSize];
                           method1079().method1250(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class48.intStack[--class228.intStackSize];
                           method1079().method1238(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           method1079().method1239();
                           return 1;
                        } else if(var0 == 6632) {
                           var10 = class48.intStack[--class228.intStackSize] == 1;
                           method1079().method1367(var10);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              class228.intStackSize -= 2;
                              var3 = class48.intStack[class228.intStackSize];
                              var4 = class48.intStack[class228.intStackSize + 1] == 1;
                              method1079().method1198(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              class228.intStackSize -= 2;
                              var3 = class48.intStack[class228.intStackSize];
                              var4 = class48.intStack[class228.intStackSize + 1] == 1;
                              method1079().method1195(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class48.intStack[++class228.intStackSize - 1] = method1079().method1243()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class48.intStack[--class228.intStackSize];
                              class48.intStack[++class228.intStackSize - 1] = method1079().method1245(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class48.intStack[--class228.intStackSize];
                              class48.intStack[++class228.intStackSize - 1] = method1079().method1247(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              class228.intStackSize -= 2;
                              var3 = class48.intStack[class228.intStackSize];
                              var12 = new Coordinates(class48.intStack[class228.intStackSize + 1]);
                              var7 = method1079().method1248(var3, var12);
                              if(var7 == null) {
                                 class48.intStack[++class228.intStackSize - 1] = -1;
                              } else {
                                 class48.intStack[++class228.intStackSize - 1] = var7.method2471();
                              }

                              return 1;
                           } else {
                              MapIcon var8;
                              if(var0 == 6639) {
                                 var8 = method1079().method1381();
                                 if(var8 == null) {
                                    class48.intStack[++class228.intStackSize - 1] = -1;
                                    class48.intStack[++class228.intStackSize - 1] = -1;
                                 } else {
                                    class48.intStack[++class228.intStackSize - 1] = var8.areaId;
                                    class48.intStack[++class228.intStackSize - 1] = var8.field277.method2471();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var8 = method1079().method1251();
                                 if(var8 == null) {
                                    class48.intStack[++class228.intStackSize - 1] = -1;
                                    class48.intStack[++class228.intStackSize - 1] = -1;
                                 } else {
                                    class48.intStack[++class228.intStackSize - 1] = var8.areaId;
                                    class48.intStack[++class228.intStackSize - 1] = var8.field277.method2471();
                                 }

                                 return 1;
                              } else {
                                 MapElementType var6;
                                 if(var0 == 6693) {
                                    var3 = class48.intStack[--class228.intStackSize];
                                    var6 = Timer.method5389(var3);
                                    if(var6.text == null) {
                                       class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                                    } else {
                                       class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var6.text;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class48.intStack[--class228.intStackSize];
                                    var6 = Timer.method5389(var3);
                                    class48.intStack[++class228.intStackSize - 1] = var6.textSize;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class48.intStack[--class228.intStackSize];
                                    var6 = Timer.method5389(var3);
                                    if(var6 == null) {
                                       class48.intStack[++class228.intStackSize - 1] = -1;
                                    } else {
                                       class48.intStack[++class228.intStackSize - 1] = var6.category;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class48.intStack[--class228.intStackSize];
                                    var6 = Timer.method5389(var3);
                                    if(var6 == null) {
                                       class48.intStack[++class228.intStackSize - 1] = -1;
                                    } else {
                                       class48.intStack[++class228.intStackSize - 1] = var6.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class48.intStack[++class228.intStackSize - 1] = MilliTimer.scriptMapIconReference.areaId;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class48.intStack[++class228.intStackSize - 1] = MilliTimer.scriptMapIconReference.field344.method2471();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class48.intStack[++class228.intStackSize - 1] = MilliTimer.scriptMapIconReference.field345.method2471();
                                    return 1;
                                 } else {
                                    return 2;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Ldn;",
      garbageValue = "-1657603693"
   )
   public static FileOnDisk method1076(String var0, String var1, boolean var2) {
      File var3 = new File(ScriptState.cacheDirectory, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class166.historicCacheId == 33) {
         var4 = "_rc";
      } else if(class166.historicCacheId == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class147.homeDir, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "(I)Llg;",
      garbageValue = "-1184928285"
   )
   static WorldMap method1079() {
      return class219.worldMap;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "467437481"
   )
   static void method1080() {
      if(class107.method1889()) {
         class316.worldSelectShown = true;
      }

   }
}
