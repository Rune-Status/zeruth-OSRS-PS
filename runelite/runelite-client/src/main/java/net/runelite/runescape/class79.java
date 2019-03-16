package net.runelite.runescape;

import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class79 {
   @ObfuscatedName("r")
   static final BigInteger RSA_MODULUS;
   @ObfuscatedName("g")
   static final BigInteger RSA_EXPONENT;

   static {
      RSA_EXPONENT = new BigInteger("10001", 16);
      RSA_MODULUS = new BigInteger("165865706435016682110653568563251120094278686912987295809145491806194715902716739338411927793058925228087565434562948389222225588420069703784252638483569608159614392485969864899137973999614056797405232846059198315441808544524190866210655169682670028293787208173603935453834899795395794572295868565624049196373");
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Ljk;",
      garbageValue = "99"
   )
   public static Varbit method1158(int var0) {
      Varbit var1 = (Varbit)Varbit.varbits.method951((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Varbit.varbit_ref.method1516(14, var0, 1789634852);
         var1 = new Varbit();
         if(var2 != null) {
            var1.method3111(new Packet(var2));
         }

         Varbit.varbits.method957(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-533880111"
   )
   static int method1159() {
      return 11;
   }
}
