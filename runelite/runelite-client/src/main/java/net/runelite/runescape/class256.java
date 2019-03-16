package net.runelite.runescape;

import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ad")
public class class256 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;[Ljava/lang/Object;I)Ljava/lang/Object;",
      garbageValue = "-1634288679"
   )
   public static Object method4842(Applet var0, String var1, Object[] var2) throws Throwable {
      return JSObject.getWindow(var0).call(var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)Ljava/lang/Object;",
      garbageValue = "1244070819"
   )
   public static Object method4839(Applet var0, String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }
}
