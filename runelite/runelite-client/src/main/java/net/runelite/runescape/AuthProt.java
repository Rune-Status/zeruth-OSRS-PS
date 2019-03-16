package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("AuthProt")
public enum AuthProt implements Enumerated {
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lea;"
    )
    field1967(2, 0),
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lea;"
    )
    field1965(0, 1),
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lea;"
    )
    field1964(1, 2),
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lea;"
    )
    field1966(3, 3);

    @ObfuscatedName("b")
    public static boolean[] validInterfaces;
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = 577485007
    )
    final int field1969;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -881347115
    )
    public final int field1968;

    AuthProt(int var3, int var4) {
        this.field1968 = var3;
        this.field1969 = var4;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(B)I",
            garbageValue = "1"
    )
    public int vmethod5358() {
        return this.field1969;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(Lgr;IIB)I",
            garbageValue = "55"
    )
    static int method1664(IterableHashTable var0, int var1, int var2) {
        if (var0 == null) {
            return var2;
        } else {
            IntegerNode var3 = (IntegerNode) var0.method2764((long) var1);
            return var3 == null ? var2 : var3.value;
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgr;ILjava/lang/String;S)Ljava/lang/String;",
            garbageValue = "3129"
    )
    static String method1670(IterableHashTable var0, int var1, String var2) {
        if (var0 == null) {
            return var2;
        } else {
            ObjectNode var3 = (ObjectNode) var0.method2764((long) var1);
            return var3 == null ? var2 : (String) var3.value;
        }
    }

    @ObfuscatedName("fk")
    @ObfuscatedSignature(
            signature = "(Lbc;IB)V",
            garbageValue = "7"
    )
    static final void method1671(PathingEntity var0, int var1) {
        int var2;
        int var3;
        int var4;
        if (var0.field985 > client.gameCycle) {
            var2 = var0.field985 - client.gameCycle;
            var3 = var0.field983 * 128 + var0.size * 64;
            var4 = var0.field995 * 128 + var0.size * 64;
            var0.x += (var3 - var0.x) / var2;
            var0.y += (var4 - var0.y) / var2;
            var0.field955 = 0;
            var0.orientation = var0.field997;
        } else if (var0.field977 >= client.gameCycle) {
            if (var0.field977 == client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.actionFrameCycle + 1 > MapCacheArchiveNames.method2149(var0.animation).frameLengths[var0.actionFrame]) {
                var2 = var0.field977 - var0.field985;
                var3 = client.gameCycle - var0.field985;
                var4 = var0.field983 * 128 + var0.size * 64;
                int var5 = var0.field995 * 128 + var0.size * 64;
                int var6 = var0.field982 * 128 + var0.size * 64;
                int var7 = var0.field984 * 128 + var0.size * 64;
                var0.x = (var6 * var3 + var4 * (var2 - var3)) / var2;
                var0.y = (var7 * var3 + var5 * (var2 - var3)) / var2;
            }

            var0.field955 = 0;
            var0.orientation = var0.field997;
            var0.angle = var0.orientation;
        } else {
            FloorUnderlayDefinition.method5033(var0);
        }

        if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
            var0.animation = -1;
            var0.animationChanged(-1);
            var0.graphic = -1;
            var0.graphicChanged(-1);
            var0.field985 = 0;
            var0.field977 = 0;
            var0.x = var0.pathX[0] * 128 + var0.size * 64;
            var0.y = var0.pathY[0] * 128 + var0.size * 64;
            var0.method2712();
        }

        if (class4.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
            var0.animation = -1;
            var0.animationChanged(-1);
            var0.graphic = -1;
            var0.graphicChanged(-1);
            var0.field985 = 0;
            var0.field977 = 0;
            var0.x = var0.pathX[0] * 128 + var0.size * 64;
            var0.y = var0.pathY[0] * 128 + var0.size * 64;
            var0.method2712();
        }

        KeyFocusListener.method5352(var0);
        var0.field941 = false;
        Sequence var8;
        if (var0.poseAnimation != -1) {
            var8 = MapCacheArchiveNames.method2149(var0.poseAnimation);
            if (var8 != null && var8.frameIDs != null) {
                ++var0.poseFrameCycle;
                if (var0.poseFrame < var8.frameIDs.length && var0.poseFrameCycle > var8.frameLengths[var0.poseFrame]) {
                    var0.poseFrameCycle = 1;
                    ++var0.poseFrame;
                    Huffman.method4772(var8, var0.poseFrame, var0.x, var0.y);
                }

                if (var0.poseFrame >= var8.frameIDs.length) {
                    var0.poseFrameCycle = 0;
                    var0.poseFrame = 0;
                    Huffman.method4772(var8, var0.poseFrame, var0.x, var0.y);
                }
            } else {
                var0.poseAnimation = -1;
            }
        }

        if (var0.graphic != -1 && client.gameCycle >= var0.graphicsDelay) {
            if (var0.spotAnimFrame < 0) {
                var0.spotAnimFrame = 0;
            }

            var2 = IndexStoreActionHandler.method5748(var0.graphic).field3348;
            if (var2 != -1) {
                Sequence var9 = MapCacheArchiveNames.method2149(var2);
                if (var9 != null && var9.frameIDs != null) {
                    ++var0.spotAnimFrameCycle;
                    if (var0.spotAnimFrame < var9.frameIDs.length && var0.spotAnimFrameCycle > var9.frameLengths[var0.spotAnimFrame]) {
                        var0.spotAnimFrameCycle = 1;
                        ++var0.spotAnimFrame;
                        Huffman.method4772(var9, var0.spotAnimFrame, var0.x, var0.y);
                    }

                    if (var0.spotAnimFrame >= var9.frameIDs.length && (var0.spotAnimFrame < 0 || var0.spotAnimFrame >= var9.frameIDs.length)) {
                        var0.graphic = -1;
                        var0.graphicChanged(-1);
                    }
                } else {
                    var0.graphic = -1;
                    var0.graphicChanged(-1);
                }
            } else {
                var0.graphic = -1;
                var0.graphicChanged(-1);
            }
        }

        if (var0.animation != -1 && var0.actionAnimationDisable <= 1) {
            var8 = MapCacheArchiveNames.method2149(var0.animation);
            if (var8.precedenceAnimating == 1 && var0.field959 > 0 && var0.field985 <= client.gameCycle && var0.field977 < client.gameCycle) {
                var0.actionAnimationDisable = 1;
                return;
            }
        }

        if (var0.animation != -1 && var0.actionAnimationDisable == 0) {
            var8 = MapCacheArchiveNames.method2149(var0.animation);
            if (var8 != null && var8.frameIDs != null) {
                ++var0.actionFrameCycle;
                if (var0.actionFrame < var8.frameIDs.length && var0.actionFrameCycle > var8.frameLengths[var0.actionFrame]) {
                    var0.actionFrameCycle = 1;
                    ++var0.actionFrame;
                    Huffman.method4772(var8, var0.actionFrame, var0.x, var0.y);
                }

                if (var0.actionFrame >= var8.frameIDs.length) {
                    var0.actionFrame -= var8.frameStep;
                    ++var0.field975;
                    if (var0.field975 >= var8.maxLoops) {
                        var0.animation = -1;
                        var0.animationChanged(-1);
                    } else if (var0.actionFrame >= 0 && var0.actionFrame < var8.frameIDs.length) {
                        Huffman.method4772(var8, var0.actionFrame, var0.x, var0.y);
                    } else {
                        var0.animation = -1;
                        var0.animationChanged(-1);
                    }
                }

                var0.field941 = var8.stretches;
            } else {
                var0.animation = -1;
                var0.animationChanged(-1);
            }
        }

        if (var0.actionAnimationDisable > 0) {
            --var0.actionAnimationDisable;
        }

    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1407192095"
    )
    static void method1669() {
        for (class4 var0 = (class4) class4.field1051.method4373(); var0 != null; var0 = (class4) class4.field1051.method4358()) {
            if (var0.field1064 != null) {
                class2.field413.method3580(var0.field1064);
                var0.field1064 = null;
            }

            if (var0.field1060 != null) {
                class2.field413.method3580(var0.field1060);
                var0.field1060 = null;
            }
        }

        class4.field1051.method4350();
    }
}
