package net.runelite.runescape;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public final class class288 extends class19 implements Runnable {
   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static Font fontBold12;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -12564955
   )
   static int menuX;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   Task field2061;
   @ObfuscatedName("r")
   OutputStream field2054;
   @ObfuscatedName("e")
   Socket field2056;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1099464589
   )
   int field2058;
   @ObfuscatedName("q")
   boolean field2057;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1032923919
   )
   final int field2065;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -64563747
   )
   final int field2064;
   @ObfuscatedName("b")
   byte[] field2062;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1167930105
   )
   int field2060;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   Signlink field2059;
   @ObfuscatedName("i")
   boolean field2063;
   @ObfuscatedName("g")
   InputStream field2055;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lff;I)V"
   )
   public class288(Socket var1, Signlink var2, int var3) throws IOException {
      this.field2057 = false;
      this.field2058 = 0;
      this.field2060 = 0;
      this.field2063 = false;
      this.field2059 = var2;
      this.field2056 = var1;
      this.field2064 = var3;
      this.field2065 = var3 - 100;
      this.field2056.setSoTimeout(30000);
      this.field2056.setTcpNoDelay(true);
      this.field2056.setReceiveBufferSize(65536);
      this.field2056.setSendBufferSize(65536);
      this.field2055 = this.field2056.getInputStream();
      this.field2054 = this.field2056.getOutputStream();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1086705871"
   )
   public boolean vmethod5599(int var1) throws IOException {
      return this.field2057?false:this.field2055.available() >= var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "106"
   )
   public int vmethod5598() throws IOException {
      return this.field2057?0:this.field2055.available();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-254118928"
   )
   public int vmethod5607() throws IOException {
      return this.field2057?0:this.field2055.read();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-636832531"
   )
   public void vmethod5603() {
      if(!this.field2057) {
         synchronized(this) {
            this.field2057 = true;
            this.notifyAll();
         }

         if(this.field2061 != null) {
            while(this.field2061.status == 0) {
               class182.method3129(1L);
            }

            if(this.field2061.status == 1) {
               try {
                  ((Thread)this.field2061.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2061 = null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-860102320"
   )
   public int vmethod5600(byte[] var1, int var2, int var3) throws IOException {
      if(this.field2057) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.field2055.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   protected void finalize() {
      this.vmethod5603();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2060 == this.field2058) {
                     if(this.field2057) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2058;
                  if(this.field2060 >= this.field2058) {
                     var1 = this.field2060 - this.field2058;
                  } else {
                     var1 = this.field2064 - this.field2058;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2054.write(this.field2062, var2, var1);
               } catch (IOException var9) {
                  this.field2063 = true;
               }

               this.field2058 = (var1 + this.field2058) % this.field2064;

               try {
                  if(this.field2058 == this.field2060) {
                     this.field2054.flush();
                  }
               } catch (IOException var8) {
                  this.field2063 = true;
               }
               continue;
            }

            try {
               if(this.field2055 != null) {
                  this.field2055.close();
               }

               if(this.field2054 != null) {
                  this.field2054.close();
               }

               if(this.field2056 != null) {
                  this.field2056.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2062 = null;
            break;
         }
      } catch (Exception var12) {
         ProjectileAnimation.method5582((String)null, var12, 1685178833);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2088230859"
   )
   public void vmethod5623(byte[] var1, int var2, int var3) throws IOException {
      this.method5601(var1, var2, var3);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "75"
   )
   void method5601(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2057) {
         if(this.field2063) {
            this.field2063 = false;
            throw new IOException();
         } else {
            if(this.field2062 == null) {
               this.field2062 = new byte[this.field2064];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2062[this.field2060] = var1[var5 + var2];
                  this.field2060 = (this.field2060 + 1) % this.field2064;
                  if((this.field2058 + this.field2065) % this.field2064 == this.field2060) {
                     throw new IOException();
                  }
               }

               if(this.field2061 == null) {
                  this.field2061 = this.field2059.method4451(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }
}
