package net.runelite.runescape;

import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public enum class39 implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   field136(3, (byte)0),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   field135(1, (byte)1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   field144(0, (byte)2),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   field141(2, (byte)3);

   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 999670937
   )
   static int cameraYaw;
   @ObfuscatedName("l")
   final byte field139;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -532893323
   )
   final int worldMapType;

   class39(int var3, byte var4) {
      this.worldMapType = var3;
      this.field139 = var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int vmethod5358() {
      return this.field139;
   }

   @ObfuscatedName("hx")
   static final void method595(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7, int var8) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      MenuOptionClicked var9 = new MenuOptionClicked();
      var9.setActionParam(var0);
      var9.setMenuOption(var4);
      var9.setMenuTarget(var5);
      var9.setMenuAction(MenuAction.of(var2));
      var9.setId(var3);
      var9.setWidgetId(var1);
      class166.clientInstance.getCallbacks().post(var9);
      if(!var9.isConsumed()) {
         client.copy$menuAction(var0, var1, var2, var3, var4, var5, var6, var7, var8);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-29"
   )
   public static int method596(int var0) {
      return SubInterface.method2437(class195.field1714[var0]);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)[Lv;",
      garbageValue = "8313"
   )
   static class39[] method587() {
      return new class39[]{field136, field144, field141, field135};
   }
}
