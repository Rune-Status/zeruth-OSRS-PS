package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class254 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1533648353
   )
   static int highResolutionPlayerCount;
   @ObfuscatedName("e")
   static byte[] skipHistory;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1642381515
   )
   static int lowResolutionPlayerCount;
   @ObfuscatedName("q")
   static byte[] moveSpeeds;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static Packet messageBuffer;
   @ObfuscatedName("m")
   static int[] facingEntities;
   @ObfuscatedName("p")
   static int[] facingCoords;
   @ObfuscatedName("b")
   static int[] highResolutionPlayerIndexes;
   @ObfuscatedName("n")
   static int[] lowResolutionPlayerIndexes;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[Lgl;"
   )
   static Packet[] appearances;
   @ObfuscatedName("i")
   static int[] coords;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -406246291
   )
   static int extendedInfoPlayerCount;
   @ObfuscatedName("j")
   static int[] extendedInfoPlayerIndexes;

   static {
      skipHistory = new byte[2048];
      moveSpeeds = new byte[2048];
      appearances = new Packet[2048];
      highResolutionPlayerCount = 0;
      highResolutionPlayerIndexes = new int[2048];
      lowResolutionPlayerCount = 0;
      lowResolutionPlayerIndexes = new int[2048];
      coords = new int[2048];
      facingCoords = new int[2048];
      facingEntities = new int[2048];
      extendedInfoPlayerCount = 0;
      extendedInfoPlayerIndexes = new int[2048];
      messageBuffer = new Packet(new byte[5000]);
   }
}
