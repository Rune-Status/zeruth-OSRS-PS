package net.runelite.runescape;

import java.lang.ref.SoftReference;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hc")
public class class63 extends class286 {
   @ObfuscatedName("g")
   SoftReference field2503;

   class63(Object var1, int var2) {
      super(var2);
      this.field2503 = new SoftReference(var1);
   }

   @ObfuscatedName("r")
   boolean vmethod5578() {
      return true;
   }

   @ObfuscatedName("g")
   Object vmethod5577() {
      return this.field2503.get();
   }
}
