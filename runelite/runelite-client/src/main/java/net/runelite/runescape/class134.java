package net.runelite.runescape;

import net.runelite.api.events.WidgetLoaded;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWidget;

@ObfuscatedName("o")
public class class134 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   static final class134 field252;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1709901579
   )
   public static int clientType;
   @ObfuscatedName("b")
   static int[] field253;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   static final class134 field258;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 580827833
   )
   final int field254;

   static {
      field258 = new class134(0);
      field252 = new class134(1);
   }

   class134(int var1) {
      this.field254 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILiu;IIIZI)V",
      garbageValue = "-1253991395"
   )
   public static void method2202(int var0, Js5Index var1, int var2, int var3, int var4, boolean var5) {
      class120.field2529 = 1;
      UrlRequester.field1911 = var1;
      class120.field2533 = var2;
      IndexFile.field2073 = var3;
      class186.field3851 = var4;
      class120.field2534 = var5;
      WorldComparator.field0 = var0;
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1527680135"
   )
   static final void method2200() {
      for(PendingSpawn var0 = (PendingSpawn) client.pendingSpawns.method4373(); var0 != null; var0 = (PendingSpawn) client.pendingSpawns.method4358()) {
         if(var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         if(var0.hitpoints == 0) {
            if(var0.field923 < 0 || ItemLayer.method2793(var0.field923, var0.field924)) {
               class4.method32(var0.level, var0.type, var0.x, var0.y, var0.field923, var0.field935, var0.field924);
               var0.method6469();
            }
         } else {
            if(var0.delay > 0) {
               --var0.delay;
            }

            if(var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102 && (var0.id < 0 || ItemLayer.method2793(var0.id, var0.field931))) {
               class4.method32(var0.level, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field931);
               var0.delay = -1;
               if(var0.field923 == var0.id && var0.field923 == -1) {
                  var0.method6469();
               } else if(var0.id == var0.field923 && var0.orientation == var0.field935 && var0.field931 == var0.field924) {
                  var0.method6469();
               }
            }
         }
      }

   }

   @ObfuscatedName("ao")
   static void method2204(int var0, int var1) {
      client.copy$runWidgetOnLoadListener(var0, var1);
      RSWidget[][] var2 = class166.clientInstance.getWidgets();
      boolean var3 = var2 != null && var2[var0] != null;
      if(var3) {
         WidgetLoaded var4 = new WidgetLoaded();
         var4.setGroupId(var0);
         class166.clientInstance.getCallbacks().post(var4);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Lje;",
      garbageValue = "-25"
   )
   public static ParamType method2203(int var0) {
      ParamType var1 = (ParamType)ParamType.paramTypeCache.method951((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class116.field49.method1516(11, var0, 1789634852);
         var1 = new ParamType();
         if(var2 != null) {
            var1.method4098(new Packet(var2));
         }

         var1.method4108();
         ParamType.paramTypeCache.method957(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
      garbageValue = "922841529"
   )
   public static String method2201(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null?"null":var3.toString();
      } else {
         int var8 = var2 + var1;
         int var4 = 0;

         for(int var5 = var1; var5 < var8; ++var5) {
            CharSequence var6 = var0[var5];
            if(var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var9 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var8; ++var10) {
            CharSequence var7 = var0[var10];
            if(var7 == null) {
               var9.append("null");
            } else {
               var9.append(var7);
            }
         }

         return var9.toString();
      }
   }
}
