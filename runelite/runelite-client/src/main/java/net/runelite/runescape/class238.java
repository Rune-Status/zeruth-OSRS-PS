package net.runelite.runescape;

import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class238 {
   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "[Lli;"
   )
   static IndexedSprite[] scrollbarSprites;
   @ObfuscatedName("r")
   public static final String[] field2466;
   @ObfuscatedName("e")
   public static Calendar field2463;
   @ObfuscatedName("g")
   public static final String[][] field2464;

   static {
      field2464 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2466 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2463 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
