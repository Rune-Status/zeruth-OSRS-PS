package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.EOFException;
import java.io.IOException;

@ObfuscatedName("dr")
@Implements("CacheFile")
public class CacheFile {
    @ObfuscatedName("bd")
    @ObfuscatedSignature(
            signature = "[Lli;"
    )
    static IndexedSprite[] slFlagSprites;
    @ObfuscatedName("gd")
    static byte[][] field1487;
    @ObfuscatedName("dk")
    @ObfuscatedSignature(
            signature = "Lfh;"
    )
    static class19 rssocket;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            longValue = -277200491994427015L
    )
    long field1485;
    @ObfuscatedName("r")
    byte[] readPayload;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            longValue = 1277770930526225981L
    )
    long field1479;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            longValue = -5186938574076129537L
    )
    long position;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = 1488999961
    )
    int field1480;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            longValue = -2308069962712316579L
    )
    long field1484;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -239280477
    )
    int field1483;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            longValue = -9066355691531523715L
    )
    long length;
    @ObfuscatedName("c")
    byte[] writePayload;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            longValue = 8433036264062733217L
    )
    long capacity;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Ldn;"
    )
    FileOnDisk accessFile;

    @ObfuscatedSignature(
            signature = "(Ldn;II)V"
    )
    public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
        this.field1479 = -1L;
        this.field1485 = -1L;
        this.field1483 = 0;
        this.accessFile = var1;
        this.capacity = this.length = var1.method148();
        this.readPayload = new byte[var2];
        this.writePayload = new byte[var3];
        this.position = 0L;
    }

    @ObfuscatedName("r")
    public void method2099(long var1) throws IOException {
        if (var1 < 0L) {
            throw new IOException("");
        } else {
            this.position = var1;
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(B)J",
            garbageValue = "1"
    )
    public long method2111() {
        return this.capacity;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "([BI)V",
            garbageValue = "-604403753"
    )
    public void method2101(byte[] var1) throws IOException {
        this.method2102(var1, 0, var1.length);
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "805418179"
    )
    void method2107() throws IOException {
        if (this.field1485 != -1L) {
            if (this.field1484 != this.field1485) {
                this.accessFile.method147(this.field1485);
                this.field1484 = this.field1485;
            }

            this.accessFile.method145(this.writePayload, 0, this.field1483);
            this.field1484 += (long) (this.field1483 * 136693003) * -239280477L;
            if (this.field1484 > this.length) {
                this.length = this.field1484;
            }

            long var1 = -1L;
            long var3 = -1L;
            if (this.field1485 >= this.field1479 && this.field1485 < this.field1479 + (long) this.field1480) {
                var1 = this.field1485;
            } else if (this.field1479 >= this.field1485 && this.field1479 < this.field1485 + (long) this.field1483) {
                var1 = this.field1479;
            }

            if ((long) this.field1483 + this.field1485 > this.field1479 && this.field1485 + (long) this.field1483 <= (long) this.field1480 + this.field1479) {
                var3 = (long) this.field1483 + this.field1485;
            } else if (this.field1479 + (long) this.field1480 > this.field1485 && this.field1479 + (long) this.field1480 <= (long) this.field1483 + this.field1485) {
                var3 = (long) this.field1480 + this.field1479;
            }

            if (var1 > -1L && var3 > var1) {
                int var5 = (int) (var3 - var1);
                System.arraycopy(this.writePayload, (int) (var1 - this.field1485), this.readPayload, (int) (var1 - this.field1479), var5);
            }

            this.field1485 = -1L;
            this.field1483 = 0;
        }

    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "([BIIB)V",
            garbageValue = "-1"
    )
    public void method2108(byte[] var1, int var2, int var3) throws IOException {
        try {
            if ((long) var3 + this.position > this.capacity) {
                this.capacity = this.position + (long) var3;
            }

            if (-1L != this.field1485 && (this.position < this.field1485 || this.position > (long) this.field1483 + this.field1485)) {
                this.method2107();
            }

            if (-1L != this.field1485 && (long) var3 + this.position > this.field1485 + (long) this.writePayload.length) {
                int var4 = (int) ((long) this.writePayload.length - (this.position - this.field1485));
                System.arraycopy(var1, var2, this.writePayload, (int) (this.position - this.field1485), var4);
                this.position += (long) var4;
                var2 += var4;
                var3 -= var4;
                this.field1483 = this.writePayload.length;
                this.method2107();
            }

            if (var3 <= this.writePayload.length) {
                if (var3 > 0) {
                    if (-1L == this.field1485) {
                        this.field1485 = this.position;
                    }

                    System.arraycopy(var1, var2, this.writePayload, (int) (this.position - this.field1485), var3);
                    this.position += (long) var3;
                    if (this.position - this.field1485 > (long) this.field1483) {
                        this.field1483 = (int) (this.position - this.field1485);
                    }

                }
            } else {
                if (this.position != this.field1484) {
                    this.accessFile.method147(this.position);
                    this.field1484 = this.position;
                }

                this.accessFile.method145(var1, var2, var3);
                this.field1484 += (long) var3;
                if (this.field1484 > this.length) {
                    this.length = this.field1484;
                }

                long var9 = -1L;
                long var6 = -1L;
                if (this.position >= this.field1479 && this.position < (long) this.field1480 + this.field1479) {
                    var9 = this.position;
                } else if (this.field1479 >= this.position && this.field1479 < this.position + (long) var3) {
                    var9 = this.field1479;
                }

                if ((long) var3 + this.position > this.field1479 && this.position + (long) var3 <= this.field1479 + (long) this.field1480) {
                    var6 = (long) var3 + this.position;
                } else if (this.field1479 + (long) this.field1480 > this.position && (long) this.field1480 + this.field1479 <= (long) var3 + this.position) {
                    var6 = this.field1479 + (long) this.field1480;
                }

                if (var9 > -1L && var6 > var9) {
                    int var8 = (int) (var6 - var9);
                    System.arraycopy(var1, (int) (var9 + (long) var2 - this.position), this.readPayload, (int) (var9 - this.field1479), var8);
                }

                this.position += (long) var3;
            }
        } catch (IOException var12) {
            this.field1484 = -1L;
            throw var12;
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "([BIII)V",
            garbageValue = "749697465"
    )
    public void method2102(byte[] var1, int var2, int var3) throws IOException {
        try {
            if (var3 + var2 > var1.length) {
                throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
            }

            if (-1L != this.field1485 && this.position >= this.field1485 && (long) var3 + this.position <= this.field1485 + (long) this.field1483) {
                System.arraycopy(this.writePayload, (int) (this.position - this.field1485), var1, var2, var3);
                this.position += (long) var3;
                return;
            }

            long var4 = this.position;
            int var7 = var3;
            int var8;
            if (this.position >= this.field1479 && this.position < this.field1479 + (long) this.field1480) {
                var8 = (int) ((long) this.field1480 - (this.position - this.field1479));
                if (var8 > var3) {
                    var8 = var3;
                }

                System.arraycopy(this.readPayload, (int) (this.position - this.field1479), var1, var2, var8);
                this.position += (long) var8;
                var2 += var8;
                var3 -= var8;
            }

            if (var3 > this.readPayload.length) {
                this.accessFile.method147(this.position);

                for (this.field1484 = this.position; var3 > 0; var3 -= var8) {
                    var8 = this.accessFile.method149(var1, var2, var3);
                    if (var8 == -1) {
                        break;
                    }

                    this.field1484 += (long) var8;
                    this.position += (long) var8;
                    var2 += var8;
                }
            } else if (var3 > 0) {
                this.method2103();
                var8 = var3;
                if (var3 > this.field1480) {
                    var8 = this.field1480;
                }

                System.arraycopy(this.readPayload, 0, var1, var2, var8);
                var2 += var8;
                var3 -= var8;
                this.position += (long) var8;
            }

            if (this.field1485 != -1L) {
                if (this.field1485 > this.position && var3 > 0) {
                    var8 = var2 + (int) (this.field1485 - this.position);
                    if (var8 > var3 + var2) {
                        var8 = var3 + var2;
                    }

                    while (var2 < var8) {
                        var1[var2++] = 0;
                        --var3;
                        ++this.position;
                    }
                }

                long var13 = -1L;
                long var10 = -1L;
                if (this.field1485 >= var4 && this.field1485 < var4 + (long) var7) {
                    var13 = this.field1485;
                } else if (var4 >= this.field1485 && var4 < this.field1485 + (long) this.field1483) {
                    var13 = var4;
                }

                if ((long) this.field1483 + this.field1485 > var4 && (long) this.field1483 + this.field1485 <= (long) var7 + var4) {
                    var10 = (long) this.field1483 + this.field1485;
                } else if ((long) var7 + var4 > this.field1485 && (long) var7 + var4 <= (long) this.field1483 + this.field1485) {
                    var10 = (long) var7 + var4;
                }

                if (var13 > -1L && var10 > var13) {
                    int var12 = (int) (var10 - var13);
                    System.arraycopy(this.writePayload, (int) (var13 - this.field1485), var1, (int) (var13 - var4) + var2, var12);
                    if (var10 > this.position) {
                        var3 = (int) ((long) var3 - (var10 - this.position));
                        this.position = var10;
                    }
                }
            }
        } catch (IOException var16) {
            this.field1484 = -1L;
            throw var16;
        }

        if (var3 > 0) {
            throw new EOFException();
        }
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-2121542963"
    )
    void method2103() throws IOException {
        this.field1480 = 0;
        if (this.field1484 != this.position) {
            this.accessFile.method147(this.position);
            this.field1484 = this.position;
        }

        int var1;
        for (this.field1479 = this.position; this.field1480 < this.readPayload.length; this.field1480 += var1) {
            var1 = this.accessFile.method149(this.readPayload, this.field1480, this.readPayload.length - this.field1480);
            if (var1 == -1) {
                break;
            }

            this.field1484 += (long) var1;
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "203747601"
    )
    public void method2098() throws IOException {
        this.method2107();
        this.accessFile.method146();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/Throwable;Ljava/lang/String;)Lef;"
    )
    public static JagException method2128(Throwable var0, String var1) {
        JagException var2;
        if (var0 instanceof JagException) {
            var2 = (JagException) var0;
            var2.field2001 = var2.field2001 + ' ' + var1;
        } else {
            var2 = new JagException(var0, var1);
        }

        return var2;
    }

    @ObfuscatedName("fi")
    @ObfuscatedSignature(
            signature = "(II)V",
            garbageValue = "-88617379"
    )
    static void method2129(int var0) {
        if (var0 == -3) {
            class150.method2560("Connection timed out.", "Please try using a different world.", "");
        } else if (var0 == -2) {
            class150.method2560("", "Error connecting to server.", "");
        } else if (var0 == -1) {
            class150.method2560("No response from server.", "Please try using a different world.", "");
        } else if (var0 == 3) {
            class316.loginIndex = 3;
            class316.field1161 = 1;
        } else if (var0 == 4) {
            class316.loginIndex = 12;
            class316.field1142 = 0;
        } else if (var0 == 5) {
            class316.field1161 = 2;
            class150.method2560("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
        } else if (var0 == 6 || !client.field770 && var0 == 68) {
            class150.method2560("RuneScape has been updated!", "Please reload this page.", "");
        } else if (var0 == 7) {
            class150.method2560("This world is full.", "Please use a different world.", "");
        } else if (var0 == 8) {
            class150.method2560("Unable to connect.", "Login server offline.", "");
        } else if (var0 == 9) {
            class150.method2560("Login limit exceeded.", "Too many connections from your address.", "");
        } else if (var0 == 10) {
            class150.method2560("Unable to connect.", "Bad session id.", "");
        } else if (var0 == 11) {
            class150.method2560("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
        } else if (var0 == 12) {
            class150.method2560("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
        } else if (var0 == 13) {
            class150.method2560("Could not complete login.", "Please try using a different world.", "");
        } else if (var0 == 14) {
            class150.method2560("The server is being updated.", "Please wait 1 minute and try again.", "");
        } else if (var0 == 16) {
            class150.method2560("Too many login attempts.", "Please wait a few minutes before trying again.", "");
        } else if (var0 == 17) {
            class150.method2560("You are standing in a members-only area.", "To play on this world move to a free area first", "");
        } else if (var0 == 18) {
            class316.loginIndex = 12;
            class316.field1142 = 1;
        } else if (var0 == 19) {
            class150.method2560("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
        } else if (var0 == 20) {
            class150.method2560("Invalid loginserver requested.", "Please try using a different world.", "");
        } else if (var0 == 22) {
            class150.method2560("Malformed login packet.", "Please try again.", "");
        } else if (var0 == 23) {
            class150.method2560("No reply from loginserver.", "Please wait 1 minute and try again.", "");
        } else if (var0 == 24) {
            class150.method2560("Error loading your profile.", "Please contact customer support.", "");
        } else if (var0 == 25) {
            class150.method2560("Unexpected loginserver response.", "Please try using a different world.", "");
        } else if (var0 == 26) {
            class150.method2560("This computers address has been blocked", "as it was used to break our rules.", "");
        } else if (var0 == 27) {
            class150.method2560("", "Service unavailable.", "");
        } else if (var0 == 31) {
            class150.method2560("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
        } else if (var0 == 32) {
            class150.method2560("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
        } else if (var0 == 37) {
            class150.method2560("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
        } else if (var0 == 38) {
            class150.method2560("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
        } else if (var0 == 55) {
            class316.loginIndex = 8;
        } else {
            if (var0 == 56) {
                class150.method2560("Enter the 6-digit code generated by your", "authenticator app.", "");
                class310.method5922(11);
                return;
            }

            if (var0 == 57) {
                class150.method2560("The code you entered was incorrect.", "Please try again.", "");
                class310.method5922(11);
                return;
            }

            if (var0 == 61) {
                class316.loginIndex = 7;
            } else {
                class150.method2560("Unexpected server response", "Please try using a different world.", "");
            }
        }

        class310.method5922(10);
    }
}
