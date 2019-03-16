package net.runelite.runescape;

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lb")
public class class45 implements Comparator {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1927142231
   )
   public static int revision;
   @ObfuscatedName("g")
   final boolean field3832;

   public class45(boolean var1) {
      this.field3832 = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method656((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;B)I",
      garbageValue = "16"
   )
   int method656(Nameable var1, Nameable var2) {
      return this.field3832?var1.vmethod2733(var2):var2.vmethod2733(var1);
   }
}
