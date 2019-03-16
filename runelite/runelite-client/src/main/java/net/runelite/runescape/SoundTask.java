package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("SoundTask")
public class SoundTask implements Runnable {
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "[Lcq;"
    )
    volatile AbstractSoundSystem[] systems;

    SoundTask() {
        this.systems = new AbstractSoundSystem[2];
    }

    public void run() {
        try {
            for (int var1 = 0; var1 < 2; ++var1) {
                AbstractSoundSystem var2 = this.systems[var1];
                if (var2 != null) {
                    var2.method280();
                }
            }
        } catch (Exception var4) {
            ProjectileAnimation.method5582((String) null, var4, 1672520275);
        }

    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(CII)C",
            garbageValue = "-1412869221"
    )
    static char method5017(char var0, int var1) {
        if (var0 >= 192 && var0 <= 255) {
            if (var0 >= 192 && var0 <= 198) {
                return 'A';
            }

            if (var0 == 199) {
                return 'C';
            }

            if (var0 >= 200 && var0 <= 203) {
                return 'E';
            }

            if (var0 >= 204 && var0 <= 207) {
                return 'I';
            }

            if (var0 >= 210 && var0 <= 214) {
                return 'O';
            }

            if (var0 >= 217 && var0 <= 220) {
                return 'U';
            }

            if (var0 == 221) {
                return 'Y';
            }

            if (var0 == 223) {
                return 's';
            }

            if (var0 >= 224 && var0 <= 230) {
                return 'a';
            }

            if (var0 == 231) {
                return 'c';
            }

            if (var0 >= 232 && var0 <= 235) {
                return 'e';
            }

            if (var0 >= 236 && var0 <= 239) {
                return 'i';
            }

            if (var0 >= 242 && var0 <= 246) {
                return 'o';
            }

            if (var0 >= 249 && var0 <= 252) {
                return 'u';
            }

            if (var0 == 253 || var0 == 255) {
                return 'y';
            }
        }

        return var0 == 338 ? 'O' : (var0 == 339 ? 'o' : (var0 == 376 ? 'Y' : var0));
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(CS)C",
            garbageValue = "11873"
    )
    static char method5022(char var0) {
        switch (var0) {
            case ' ':
            case '-':
            case '_':
            case ' ':
                return '_';
            case '#':
            case '[':
            case ']':
                return var0;
            case 'À':
            case 'Á':
            case 'Â':
            case 'Ã':
            case 'Ä':
            case 'à':
            case 'á':
            case 'â':
            case 'ã':
            case 'ä':
                return 'a';
            case 'Ç':
            case 'ç':
                return 'c';
            case 'È':
            case 'É':
            case 'Ê':
            case 'Ë':
            case 'è':
            case 'é':
            case 'ê':
            case 'ë':
                return 'e';
            case 'Í':
            case 'Î':
            case 'Ï':
            case 'í':
            case 'î':
            case 'ï':
                return 'i';
            case 'Ñ':
            case 'ñ':
                return 'n';
            case 'Ò':
            case 'Ó':
            case 'Ô':
            case 'Õ':
            case 'Ö':
            case 'ò':
            case 'ó':
            case 'ô':
            case 'õ':
            case 'ö':
                return 'o';
            case 'Ù':
            case 'Ú':
            case 'Û':
            case 'Ü':
            case 'ù':
            case 'ú':
            case 'û':
            case 'ü':
                return 'u';
            case 'ß':
                return 'b';
            case 'ÿ':
            case 'Ÿ':
                return 'y';
            default:
                return Character.toLowerCase(var0);
        }
    }
}
