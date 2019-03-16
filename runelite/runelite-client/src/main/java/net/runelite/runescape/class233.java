package net.runelite.runescape;

import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
public enum class233 implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3172(5, 0),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3163(6, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3164(1, 2),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3162(0, 3),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3166(4, 4),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3169(3, 5),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3168(2, 6),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3167(7, 7);

   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -855287373
   )
   public final int field3170;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 586269195
   )
   final int field3171;

   class233(int var3, int var4) {
      this.field3170 = var3;
      this.field3171 = var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int vmethod5358() {
      return this.field3171;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "31177252"
   )
   static boolean method4580(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class219.field420.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class256.method4842(class219.field419, var2, new Object[]{(new URL(class219.field419.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class219.field419.getAppletContext().showDocument(new URL(class219.field419.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class256.method4839(class219.field419, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class219.field419.getAppletContext().showDocument(new URL(class219.field419.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
