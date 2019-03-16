package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSIgnoreContainer;

@ObfuscatedName("kb")
public class class215 extends NameableContainer implements RSIgnoreContainer {
   @ObfuscatedName("qb")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   static Resampler field3697;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   final JagexLoginType field3696;

   @ObfuscatedSignature(
      signature = "(Llq;)V"
   )
   public class215(JagexLoginType var1) {
      super(400);
      this.field3696 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)[Ljr;",
      garbageValue = "-1957564969"
   )
   Nameable[] vmethod5255(int var1) {
      return new Ignore[var1];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgl;II)V",
      garbageValue = "451663299"
   )
   public void method4310(Packet var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            Name var5 = new Name(var1.readString(), this.field3696);
            Name var6 = new Name(var1.readString(), this.field3696);
            var1.readString();
            if(var5 != null && var5.method4714()) {
               Ignore var7 = (Ignore)this.method5229(var5);
               if(var4) {
                  Ignore var8 = (Ignore)this.method5229(var6);
                  if(var8 != null && var7 != var8) {
                     if(var7 != null) {
                        this.method5280(var8);
                     } else {
                        var7 = var8;
                     }
                  }
               }

               if(var7 != null) {
                  this.method5230(var7, var5, var6);
                  continue;
               }

               if(this.method5225() < 400) {
                  int var9 = this.method5225();
                  var7 = (Ignore)this.method5233(var5, var6);
                  var7.field3705 = var9;
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Ljr;",
      garbageValue = "-1755896640"
   )
   Nameable vmethod5242() {
      return new Ignore();
   }
}
