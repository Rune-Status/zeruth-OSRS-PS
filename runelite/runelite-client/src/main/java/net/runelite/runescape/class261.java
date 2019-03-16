package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class261 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lin;",
      garbageValue = "1828989608"
   )
   public static ModeWhere method5014(int var0) {
      ModeWhere[] var1 = LoginProt.method866();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         ModeWhere var3 = var1[var2];
         if(var0 == var3.field3197) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "56810822"
   )
   static Class method5013(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-120"
   )
   static void method5015() {
      SubInterface.method2435(class9.field1113 / 2 + class288.menuX, class106.menuY);
   }
}
