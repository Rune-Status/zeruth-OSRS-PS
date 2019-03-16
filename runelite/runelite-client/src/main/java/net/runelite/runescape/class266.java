package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class266 extends TaskDataNode {
   @ObfuscatedName("l")
   int field1420;
   @ObfuscatedName("v")
   int field1429;
   @ObfuscatedName("r")
   int field1415;
   @ObfuscatedName("e")
   int field1417;
   @ObfuscatedName("q")
   int field1418;
   @ObfuscatedName("x")
   int field1428;
   @ObfuscatedName("m")
   boolean field1419;
   @ObfuscatedName("p")
   int endPosition;
   @ObfuscatedName("b")
   int field1421;
   @ObfuscatedName("n")
   int field1422;
   @ObfuscatedName("c")
   int field1416;
   @ObfuscatedName("i")
   int startPosition;
   @ObfuscatedName("d")
   int field1426;
   @ObfuscatedName("j")
   int field1427;
   @ObfuscatedName("g")
   int field1423;

   @ObfuscatedSignature(
      signature = "(Lct;III)V"
   )
   class266(RawAudioNode var1, int var2, int var3, int var4) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1419 = var1.field1344;
      this.field1415 = var2;
      this.field1417 = var3;
      this.field1418 = var4;
      this.field1423 = 0;
      this.method5058();
   }

   @ObfuscatedSignature(
      signature = "(Lct;II)V"
   )
   class266(RawAudioNode var1, int var2, int var3) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1419 = var1.field1344;
      this.field1415 = var2;
      this.field1417 = var3;
      this.field1418 = 8192;
      this.field1423 = 0;
      this.method5058();
   }

   @ObfuscatedName("ak")
   int method5080(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1426 > 0) {
            int var6 = var2 + this.field1426;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1426 += var2;
            if(this.field1415 == 256 && (this.field1423 & 255) == 0) {
               if(class56.audioHighMemory) {
                  var2 = method5097(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1420, this.field1421, this.field1428, this.field1429, 0, var6, var3, this);
               } else {
                  var2 = method5091(((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1416, this.field1427, 0, var6, var3, this);
               }
            } else if(class56.audioHighMemory) {
               var2 = method5096(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1420, this.field1421, this.field1428, this.field1429, 0, var6, var3, this, this.field1415, var5);
            } else {
               var2 = method5095(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1416, this.field1427, 0, var6, var3, this, this.field1415, var5);
            }

            this.field1426 -= var2;
            if(this.field1426 != 0) {
               return var2;
            }

            if(!this.method5082()) {
               continue;
            }

            return var4;
         }

         if(this.field1415 == 256 && (this.field1423 & 255) == 0) {
            if(class56.audioHighMemory) {
               return method5084(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1420, this.field1421, 0, var4, var3, this);
            }

            return method5092(((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1416, 0, var4, var3, this);
         }

         if(class56.audioHighMemory) {
            return method5158(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1420, this.field1421, 0, var4, var3, this, this.field1415, var5);
         }

         return method5087(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1416, 0, var4, var3, this, this.field1415, var5);
      }
   }

   @ObfuscatedName("f")
   synchronized void method5200(int var1, int var2) {
      this.field1417 = var1;
      this.field1418 = var2;
      this.field1426 = 0;
      this.method5058();
   }

   @ObfuscatedName("v")
   public synchronized void method5060(int var1) {
      this.method5200(var1 << 6, this.method5064());
   }

   @ObfuscatedName("af")
   public synchronized void method5070(int var1) {
      if(var1 == 0) {
         this.method5061(0);
         this.method6469();
      } else if(this.field1420 == 0 && this.field1421 == 0) {
         this.field1426 = 0;
         this.field1417 = 0;
         this.field1416 = 0;
         this.method6469();
      } else {
         int var2 = -this.field1416;
         if(this.field1416 > var2) {
            var2 = this.field1416;
         }

         if(-this.field1420 > var2) {
            var2 = -this.field1420;
         }

         if(this.field1420 > var2) {
            var2 = this.field1420;
         }

         if(-this.field1421 > var2) {
            var2 = -this.field1421;
         }

         if(this.field1421 > var2) {
            var2 = this.field1421;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1426 = var1;
         this.field1417 = Integer.MIN_VALUE;
         this.field1427 = -this.field1416 / var1;
         this.field1428 = -this.field1420 / var1;
         this.field1429 = -this.field1421 / var1;
      }
   }

   @ObfuscatedName("al")
   public boolean method5074() {
      return this.field1426 != 0;
   }

   @ObfuscatedName("k")
   public synchronized void method5065(int var1) {
      int var2 = ((RawAudioNode)super.data).audioBuffer.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1423 = var1;
   }

   @ObfuscatedName("x")
   public synchronized void vmethod6450(int var1) {
      if(this.field1426 > 0) {
         if(var1 >= this.field1426) {
            if(this.field1417 == Integer.MIN_VALUE) {
               this.field1417 = 0;
               this.field1421 = 0;
               this.field1420 = 0;
               this.field1416 = 0;
               this.method6469();
               var1 = this.field1426;
            }

            this.field1426 = 0;
            this.method5058();
         } else {
            this.field1416 += this.field1427 * var1;
            this.field1420 += this.field1428 * var1;
            this.field1421 += this.field1429 * var1;
            this.field1426 -= var1;
         }
      }

      RawAudioNode var2 = (RawAudioNode)super.data;
      int var3 = this.startPosition << 8;
      int var4 = this.endPosition << 8;
      int var5 = var2.audioBuffer.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1422 = 0;
      }

      if(this.field1423 < 0) {
         if(this.field1415 <= 0) {
            this.method5205();
            this.method6469();
            return;
         }

         this.field1423 = 0;
      }

      if(this.field1423 >= var5) {
         if(this.field1415 >= 0) {
            this.method5205();
            this.method6469();
            return;
         }

         this.field1423 = var5 - 1;
      }

      this.field1423 += this.field1415 * var1;
      if(this.field1422 < 0) {
         if(!this.field1419) {
            if(this.field1415 < 0) {
               if(this.field1423 >= var3) {
                  return;
               }

               this.field1423 = var4 - 1 - (var4 - 1 - this.field1423) % var6;
            } else {
               if(this.field1423 < var4) {
                  return;
               }

               this.field1423 = var3 + (this.field1423 - var3) % var6;
            }

         } else {
            if(this.field1415 < 0) {
               if(this.field1423 >= var3) {
                  return;
               }

               this.field1423 = var3 + var3 - 1 - this.field1423;
               this.field1415 = -this.field1415;
            }

            while(this.field1423 >= var4) {
               this.field1423 = var4 + var4 - 1 - this.field1423;
               this.field1415 = -this.field1415;
               if(this.field1423 >= var3) {
                  return;
               }

               this.field1423 = var3 + var3 - 1 - this.field1423;
               this.field1415 = -this.field1415;
            }

         }
      } else {
         if(this.field1422 > 0) {
            if(this.field1419) {
               label136: {
                  if(this.field1415 < 0) {
                     if(this.field1423 >= var3) {
                        return;
                     }

                     this.field1423 = var3 + var3 - 1 - this.field1423;
                     this.field1415 = -this.field1415;
                     if(--this.field1422 == 0) {
                        break label136;
                     }
                  }

                  do {
                     if(this.field1423 < var4) {
                        return;
                     }

                     this.field1423 = var4 + var4 - 1 - this.field1423;
                     this.field1415 = -this.field1415;
                     if(--this.field1422 == 0) {
                        break;
                     }

                     if(this.field1423 >= var3) {
                        return;
                     }

                     this.field1423 = var3 + var3 - 1 - this.field1423;
                     this.field1415 = -this.field1415;
                  } while(--this.field1422 != 0);
               }
            } else {
               label168: {
                  int var7;
                  if(this.field1415 < 0) {
                     if(this.field1423 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1423) / var6;
                     if(var7 >= this.field1422) {
                        this.field1423 += var6 * this.field1422;
                        this.field1422 = 0;
                        break label168;
                     }

                     this.field1423 += var6 * var7;
                     this.field1422 -= var7;
                  } else {
                     if(this.field1423 < var4) {
                        return;
                     }

                     var7 = (this.field1423 - var3) / var6;
                     if(var7 >= this.field1422) {
                        this.field1423 -= var6 * this.field1422;
                        this.field1422 = 0;
                        break label168;
                     }

                     this.field1423 -= var6 * var7;
                     this.field1422 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1415 < 0) {
            if(this.field1423 < 0) {
               this.field1423 = -1;
               this.method5205();
               this.method6469();
            }
         } else if(this.field1423 >= var5) {
            this.field1423 = var5;
            this.method5205();
            this.method6469();
         }

      }
   }

   @ObfuscatedName("m")
   protected int vmethod6465() {
      return this.field1417 == 0 && this.field1426 == 0?0:1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected TaskDataNode vmethod6446() {
      return null;
   }

   @ObfuscatedName("o")
   public synchronized void method5069(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method5200(var2, var3);
      } else {
         int var4 = method5173(var2, var3);
         int var5 = method5129(var2, var3);
         if(var4 == this.field1420 && var5 == this.field1421) {
            this.field1426 = 0;
         } else {
            int var6 = var2 - this.field1416;
            if(this.field1416 - var2 > var6) {
               var6 = this.field1416 - var2;
            }

            if(var4 - this.field1420 > var6) {
               var6 = var4 - this.field1420;
            }

            if(this.field1420 - var4 > var6) {
               var6 = this.field1420 - var4;
            }

            if(var5 - this.field1421 > var6) {
               var6 = var5 - this.field1421;
            }

            if(this.field1421 - var5 > var6) {
               var6 = this.field1421 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1426 = var1;
            this.field1417 = var2;
            this.field1418 = var3;
            this.field1427 = (var2 - this.field1416) / var1;
            this.field1428 = (var4 - this.field1420) / var1;
            this.field1429 = (var5 - this.field1421) / var1;
         }
      }
   }

   @ObfuscatedName("a")
   public synchronized int method5063() {
      return this.field1417 == Integer.MIN_VALUE?0:this.field1417;
   }

   @ObfuscatedName("av")
   int vmethod6455() {
      int var1 = this.field1416 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1422 == 0) {
         var1 -= var1 * this.field1423 / (((RawAudioNode)super.data).audioBuffer.length << 8);
      } else if(this.field1422 >= 0) {
         var1 -= var1 * this.startPosition / ((RawAudioNode)super.data).audioBuffer.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("c")
   void method5058() {
      this.field1416 = this.field1417;
      this.field1420 = method5173(this.field1417, this.field1418);
      this.field1421 = method5129(this.field1417, this.field1418);
   }

   @ObfuscatedName("t")
   public synchronized int method5064() {
      return this.field1418 < 0?-1:this.field1418;
   }

   @ObfuscatedName("ah")
   int method5081(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1426 > 0) {
            int var6 = var2 + this.field1426;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1426 += var2;
            if(this.field1415 == -256 && (this.field1423 & 255) == 0) {
               if(class56.audioHighMemory) {
                  var2 = method5195(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1420, this.field1421, this.field1428, this.field1429, 0, var6, var3, this);
               } else {
                  var2 = method5146(((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1416, this.field1427, 0, var6, var3, this);
               }
            } else if(class56.audioHighMemory) {
               var2 = method5098(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1420, this.field1421, this.field1428, this.field1429, 0, var6, var3, this, this.field1415, var5);
            } else {
               var2 = method5149(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1416, this.field1427, 0, var6, var3, this, this.field1415, var5);
            }

            this.field1426 -= var2;
            if(this.field1426 != 0) {
               return var2;
            }

            if(!this.method5082()) {
               continue;
            }

            return var4;
         }

         if(this.field1415 == -256 && (this.field1423 & 255) == 0) {
            if(class56.audioHighMemory) {
               return method5086(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1420, this.field1421, 0, var4, var3, this);
            }

            return method5085(((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1416, 0, var4, var3, this);
         }

         if(class56.audioHighMemory) {
            return method5113(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1420, this.field1421, 0, var4, var3, this, this.field1415, var5);
         }

         return method5089(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1423, var2, this.field1416, 0, var4, var3, this, this.field1415, var5);
      }
   }

   @ObfuscatedName("an")
   public synchronized void method5068(int var1) {
      if(this.field1415 < 0) {
         this.field1415 = -var1;
      } else {
         this.field1415 = var1;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected TaskDataNode vmethod6454() {
      return null;
   }

   @ObfuscatedName("y")
   void method5205() {
      if(this.field1426 != 0) {
         if(this.field1417 == Integer.MIN_VALUE) {
            this.field1417 = 0;
         }

         this.field1426 = 0;
         this.method5058();
      }

   }

   @ObfuscatedName("ax")
   public synchronized int method5054() {
      return this.field1415 < 0?-this.field1415:this.field1415;
   }

   @ObfuscatedName("d")
   public synchronized void vmethod6449(int[] var1, int var2, int var3) {
      if(this.field1417 == 0 && this.field1426 == 0) {
         this.vmethod6450(var3);
      } else {
         RawAudioNode var4 = (RawAudioNode)super.data;
         int var5 = this.startPosition << 8;
         int var6 = this.endPosition << 8;
         int var7 = var4.audioBuffer.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1422 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1423 < 0) {
            if(this.field1415 <= 0) {
               this.method5205();
               this.method6469();
               return;
            }

            this.field1423 = 0;
         }

         if(this.field1423 >= var7) {
            if(this.field1415 >= 0) {
               this.method5205();
               this.method6469();
               return;
            }

            this.field1423 = var7 - 1;
         }

         if(this.field1422 < 0) {
            if(this.field1419) {
               if(this.field1415 < 0) {
                  var9 = this.method5081(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1423 >= var5) {
                     return;
                  }

                  this.field1423 = var5 + var5 - 1 - this.field1423;
                  this.field1415 = -this.field1415;
               }

               while(true) {
                  var9 = this.method5080(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1423 < var6) {
                     return;
                  }

                  this.field1423 = var6 + var6 - 1 - this.field1423;
                  this.field1415 = -this.field1415;
                  var9 = this.method5081(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1423 >= var5) {
                     return;
                  }

                  this.field1423 = var5 + var5 - 1 - this.field1423;
                  this.field1415 = -this.field1415;
               }
            } else if(this.field1415 < 0) {
               while(true) {
                  var9 = this.method5081(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1423 >= var5) {
                     return;
                  }

                  this.field1423 = var6 - 1 - (var6 - 1 - this.field1423) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method5080(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1423 < var6) {
                     return;
                  }

                  this.field1423 = var5 + (this.field1423 - var5) % var8;
               }
            }
         } else {
            if(this.field1422 > 0) {
               if(this.field1419) {
                  label158: {
                     if(this.field1415 < 0) {
                        var9 = this.method5081(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1423 >= var5) {
                           return;
                        }

                        this.field1423 = var5 + var5 - 1 - this.field1423;
                        this.field1415 = -this.field1415;
                        if(--this.field1422 == 0) {
                           break label158;
                        }
                     }

                     do {
                        var9 = this.method5080(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1423 < var6) {
                           return;
                        }

                        this.field1423 = var6 + var6 - 1 - this.field1423;
                        this.field1415 = -this.field1415;
                        if(--this.field1422 == 0) {
                           break;
                        }

                        var9 = this.method5081(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1423 >= var5) {
                           return;
                        }

                        this.field1423 = var5 + var5 - 1 - this.field1423;
                        this.field1415 = -this.field1415;
                     } while(--this.field1422 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1415 < 0) {
                     while(true) {
                        var9 = this.method5081(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1423 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1423) / var8;
                        if(var10 >= this.field1422) {
                           this.field1423 += var8 * this.field1422;
                           this.field1422 = 0;
                           break;
                        }

                        this.field1423 += var8 * var10;
                        this.field1422 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method5080(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1423 < var6) {
                           return;
                        }

                        var10 = (this.field1423 - var5) / var8;
                        if(var10 >= this.field1422) {
                           this.field1423 -= var8 * this.field1422;
                           this.field1422 = 0;
                           break;
                        }

                        this.field1423 -= var8 * var10;
                        this.field1422 -= var10;
                     }
                  }
               }
            }

            if(this.field1415 < 0) {
               this.method5081(var1, var9, 0, var3, 0);
               if(this.field1423 < 0) {
                  this.field1423 = -1;
                  this.method5205();
                  this.method6469();
               }
            } else {
               this.method5080(var1, var9, var7, var3, 0);
               if(this.field1423 >= var7) {
                  this.field1423 = var7;
                  this.method5205();
                  this.method6469();
               }
            }

         }
      }
   }

   @ObfuscatedName("ad")
   public boolean method5073() {
      return this.field1423 < 0 || this.field1423 >= ((RawAudioNode)super.data).audioBuffer.length << 8;
   }

   @ObfuscatedName("j")
   public synchronized void method5059(int var1) {
      this.field1422 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method5066() {
      this.field1415 = (this.field1415 ^ this.field1415 >> 31) + (this.field1415 >>> 31);
      this.field1415 = -this.field1415;
   }

   @ObfuscatedName("ap")
   boolean method5082() {
      int var1 = this.field1417;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method5173(var1, this.field1418);
         var3 = method5129(var1, this.field1418);
      }

      if(var1 == this.field1416 && var2 == this.field1420 && var3 == this.field1421) {
         if(this.field1417 == Integer.MIN_VALUE) {
            this.field1417 = 0;
            this.field1421 = 0;
            this.field1420 = 0;
            this.field1416 = 0;
            this.method6469();
            return true;
         } else {
            this.method5058();
            return false;
         }
      } else {
         if(this.field1416 < var1) {
            this.field1427 = 1;
            this.field1426 = var1 - this.field1416;
         } else if(this.field1416 > var1) {
            this.field1427 = -1;
            this.field1426 = this.field1416 - var1;
         } else {
            this.field1427 = 0;
         }

         if(this.field1420 < var2) {
            this.field1428 = 1;
            if(this.field1426 == 0 || this.field1426 > var2 - this.field1420) {
               this.field1426 = var2 - this.field1420;
            }
         } else if(this.field1420 > var2) {
            this.field1428 = -1;
            if(this.field1426 == 0 || this.field1426 > this.field1420 - var2) {
               this.field1426 = this.field1420 - var2;
            }
         } else {
            this.field1428 = 0;
         }

         if(this.field1421 < var3) {
            this.field1429 = 1;
            if(this.field1426 == 0 || this.field1426 > var3 - this.field1421) {
               this.field1426 = var3 - this.field1421;
            }
         } else if(this.field1421 > var3) {
            this.field1429 = -1;
            if(this.field1426 == 0 || this.field1426 > this.field1421 - var3) {
               this.field1426 = this.field1421 - var3;
            }
         } else {
            this.field1429 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("h")
   synchronized void method5061(int var1) {
      this.method5200(var1, this.method5064());
   }

   @ObfuscatedName("u")
   public synchronized void method5160(int var1, int var2) {
      this.method5069(var1, var2, this.method5064());
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILda;)I"
   )
   static int method5084(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class266 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var4 + var9 - var3) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      var10.field1423 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILda;II)I"
   )
   static int method5095(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class266 var11, int var12, int var13) {
      var11.field1420 -= var11.field1428 * var5;
      var11.field1421 -= var11.field1429 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var14;
      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1420 += var11.field1428 * var5;
      var11.field1421 += var11.field1429 * var5;
      var11.field1416 = var6;
      var11.field1423 = var4;
      return var5;
   }

   @ObfuscatedName("r")
   static int method5129(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lct;II)Lda;"
   )
   public static class266 method5067(RawAudioNode var0, int var1, int var2) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class266(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILda;)I"
   )
   static int method5085(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class266 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var2 - (var7 - 1)) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
         var10001 = var3++;
      }

      var8.field1423 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILda;)I"
   )
   static int method5086(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class266 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var3 + var4 - (var9 - 1)) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      var10.field1423 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILda;II)I"
   )
   static int method5098(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class266 var13, int var14, int var15) {
      var13.field1416 -= var5 * var13.field1427;
      if(var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var16 = var2[var1 - 1];
         var0 = (var2[var1] - var16) * (var4 & 255) + (var16 << 8);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1416 += var13.field1427 * var5;
      var13.field1420 = var6;
      var13.field1421 = var7;
      var13.field1423 = var4;
      return var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lct;III)Lda;"
   )
   public static class266 method5057(RawAudioNode var0, int var1, int var2, int var3) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class266(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILda;)I"
   )
   static int method5092(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class266 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var7 - var2) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
         var10001 = var3++;
      }

      var8.field1423 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILda;II)I"
   )
   static int method5087(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class266 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
         var7 = var8;
      }

      for(var1 = var12; var5 < var7; var4 += var11) {
         var13 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1423 = var4;
      return var5;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILda;II)I"
   )
   static int method5089(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class266 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
         var7 = var8;
      }

      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         byte var13 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
         var7 = var8;
      }

      var0 = var12;

      for(var1 = var11; var5 < var7; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1423 = var4;
      return var5;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILda;II)I"
   )
   static int method5149(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class266 var11, int var12, int var13) {
      var11.field1420 -= var11.field1428 * var5;
      var11.field1421 -= var11.field1429 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var0 = var13;

      for(var1 = var12; var5 < var8; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1420 += var11.field1428 * var5;
      var11.field1421 += var11.field1429 * var5;
      var11.field1416 = var6;
      var11.field1423 = var4;
      return var5;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILda;)I"
   )
   static int method5091(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class266 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1420 += var9.field1428 * (var6 - var3);
      var9.field1421 += var9.field1429 * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
      }

      var9.field1416 = var4 >> 2;
      var9.field1423 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILda;)I"
   )
   static int method5195(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class266 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1416 += var12.field1427 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field1420 = var5 >> 2;
      var12.field1421 = var6 >> 2;
      var12.field1423 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILda;II)I"
   )
   static int method5113(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class266 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var0 = (var2[var1] - var14) * (var4 & 255) + (var14 << 8);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field1423 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILda;)I"
   )
   static int method5146(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class266 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1420 += var9.field1428 * (var6 - var3);
      var9.field1421 += var9.field1429 * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
      }

      var9.field1416 = var4 >> 2;
      var9.field1423 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILda;II)I"
   )
   static int method5096(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class266 var13, int var14, int var15) {
      var13.field1416 -= var5 * var13.field1427;
      if(var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var16 = var2[var4 >> 8];
         var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1416 += var13.field1427 * var5;
      var13.field1420 = var6;
      var13.field1421 = var7;
      var13.field1423 = var4;
      return var5;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILda;)I"
   )
   static int method5097(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class266 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1416 += var12.field1427 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field1420 = var5 >> 2;
      var12.field1421 = var6 >> 2;
      var12.field1423 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILda;II)I"
   )
   static int method5158(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class266 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field1423 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("g")
   static int method5173(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }
}
