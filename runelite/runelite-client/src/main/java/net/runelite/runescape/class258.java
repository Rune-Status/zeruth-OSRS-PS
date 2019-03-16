package net.runelite.runescape;

import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public class class258 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static Packet NetCache_responseArchiveBuffer;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -180461495
   )
   static int field3272;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -2585974541463108913L
   )
   static long field3260;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lih;"
   )
   static Js5[] NetCache_indexCaches;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static Packet NetCache_responseHeaderBuffer;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 993783287
   )
   static int NetCache_pendingResponsesCount;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static HashTable NetCache_pendingResponses;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -987519185
   )
   static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("a")
   static CRC32 NetCache_crc;
   @ObfuscatedName("z")
   static byte field3279;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static HashTable NetCache_pendingWrites;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -381315601
   )
   static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 320805059
   )
   static int NetCache_pendingWritesCount;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -783345405
   )
   public static int field3278;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1476877337
   )
   public static int field3277;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 566468541
   )
   static int field3276;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static class19 NetCache_socket;

   static {
      field3272 = 0;
      NetCache_pendingPriorityWrites = new HashTable(4096);
      NetCache_pendingPriorityWritesCount = 0;
      NetCache_pendingPriorityResponses = new HashTable(32);
      NetCache_pendingPriorityResponsesCount = 0;
      NetCache_pendingWritesQueue = new Node2LinkedList();
      NetCache_pendingWrites = new HashTable(4096);
      NetCache_pendingWritesCount = 0;
      NetCache_pendingResponses = new HashTable(4096);
      NetCache_pendingResponsesCount = 0;
      NetCache_responseHeaderBuffer = new Packet(8);
      field3276 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new Js5[256];
      field3279 = 0;
      field3277 = 0;
      field3278 = 0;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "104"
   )
   static int method4991(int var0) {
      return (int)((Math.log((double)var0) / class48.field1081 - 7.0D) * 256.0D);
   }
}
