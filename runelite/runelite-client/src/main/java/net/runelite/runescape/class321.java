package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class321 implements class26 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgl;Ljava/lang/String;I)I",
      garbageValue = "-1488886735"
   )
   public static int method6055(Packet var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = FrameMap.method555(var1);
      var0.pSmart1or2(var3.length);
      var0.offset += class331.huffman.method4773(var3, 0, var3.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1919796182"
   )
   public static boolean method6056(int var0) {
      return var0 == WorldMapDecorationType.field2840.rsOrdinal;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lfm;",
      garbageValue = "-1430107657"
   )
   public static TcpConnectionMessage method6058() {
      TcpConnectionMessage var0 = ClientProt.method6052();
      var0.clientPacket = null;
      var0.field2330 = 0;
      var0.packetBuffer = new Bit(5000);
      return var0;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(ILcx;ZB)I",
      garbageValue = "107"
   )
   static int method6057(int var0, class106 var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class48.intStack[--class228.intStackSize];
         class48.intStack[++class228.intStackSize - 1] = client.grandExchangeOffers[var3].method2872();
         return 1;
      } else if(var0 == 3904) {
         var3 = class48.intStack[--class228.intStackSize];
         class48.intStack[++class228.intStackSize - 1] = client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class48.intStack[--class228.intStackSize];
         class48.intStack[++class228.intStackSize - 1] = client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class48.intStack[--class228.intStackSize];
         class48.intStack[++class228.intStackSize - 1] = client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class48.intStack[--class228.intStackSize];
         class48.intStack[++class228.intStackSize - 1] = client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class48.intStack[--class228.intStackSize];
         class48.intStack[++class228.intStackSize - 1] = client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class48.intStack[--class228.intStackSize];
            var12 = client.grandExchangeOffers[var3].method2871();
            class48.intStack[++class228.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class48.intStack[--class228.intStackSize];
            var12 = client.grandExchangeOffers[var3].method2871();
            class48.intStack[++class228.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class48.intStack[--class228.intStackSize];
            var12 = client.grandExchangeOffers[var3].method2871();
            class48.intStack[++class228.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class48.intStack[--class228.intStackSize];
            var12 = client.grandExchangeOffers[var3].method2871();
            class48.intStack[++class228.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class48.intStack[--class228.intStackSize] == 1;
               if(ChatLine.tradingPost != null) {
                  ChatLine.tradingPost.method803(TradingPost.field10, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class48.intStack[--class228.intStackSize] == 1;
               if(ChatLine.tradingPost != null) {
                  ChatLine.tradingPost.method803(TradingPost.field3, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class228.intStackSize -= 2;
               var13 = class48.intStack[class228.intStackSize] == 1;
               boolean var4 = class48.intStack[class228.intStackSize + 1] == 1;
               if(ChatLine.tradingPost != null) {
                  client.field913.field636 = var4;
                  ChatLine.tradingPost.method803(client.field913, var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class48.intStack[--class228.intStackSize] == 1;
               if(ChatLine.tradingPost != null) {
                  ChatLine.tradingPost.method803(TradingPost.field4, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class48.intStack[--class228.intStackSize] == 1;
               if(ChatLine.tradingPost != null) {
                  ChatLine.tradingPost.method803(TradingPost.field7, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class48.intStack[++class228.intStackSize - 1] = ChatLine.tradingPost == null?0:ChatLine.tradingPost.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if(var0 == 3920) {
                  var3 = class48.intStack[--class228.intStackSize];
                  var11 = (GrandExchangeEvent)ChatLine.tradingPost.events.get(var3);
                  class48.intStack[++class228.intStackSize - 1] = var11.world;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class48.intStack[--class228.intStackSize];
                  var11 = (GrandExchangeEvent)ChatLine.tradingPost.events.get(var3);
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var11.method806();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class48.intStack[--class228.intStackSize];
                  var11 = (GrandExchangeEvent)ChatLine.tradingPost.events.get(var3);
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var11.method807();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class48.intStack[--class228.intStackSize];
                  var11 = (GrandExchangeEvent)ChatLine.tradingPost.events.get(var3);
                  long var5 = Tile.method4297() - TextureProvider.field1511 - var11.field16;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class48.intStack[--class228.intStackSize];
                  var11 = (GrandExchangeEvent)ChatLine.tradingPost.events.get(var3);
                  class48.intStack[++class228.intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class48.intStack[--class228.intStackSize];
                  var11 = (GrandExchangeEvent)ChatLine.tradingPost.events.get(var3);
                  class48.intStack[++class228.intStackSize - 1] = var11.grandExchangeOffer.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class48.intStack[--class228.intStackSize];
                  var11 = (GrandExchangeEvent)ChatLine.tradingPost.events.get(var3);
                  class48.intStack[++class228.intStackSize - 1] = var11.grandExchangeOffer.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
