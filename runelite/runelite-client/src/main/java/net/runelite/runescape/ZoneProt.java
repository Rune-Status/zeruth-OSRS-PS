package net.runelite.runescape;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("ZoneProt")
public class ZoneProt {
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Lfc;"
    )
    @Export("SOUND_AREA")
    public static final ZoneProt SOUND_AREA;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lfc;"
    )
    public static final ZoneProt MAP_PROJANIM;
    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "Lfc;"
    )
    public static final ZoneProt field2318;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            signature = "Lfc;"
    )
    public static final ZoneProt GROUND_ITEM_REMOVE;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Lfc;"
    )
    public static final ZoneProt MAP_ANIM;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Lfc;"
    )
    @Export("LOC_DEL")
    public static final ZoneProt LOC_DEL;
    @ObfuscatedName("n")
    @ObfuscatedSignature(
            signature = "Lfc;"
    )
    public static final ZoneProt GROUND_ITEM_ADD;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Lfc;"
    )
    @Export("LOC_ANIM")
    public static final ZoneProt LOC_ANIM;
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "Lfc;"
    )
    @Export("LOC_ADD_CHANGE")
    public static final ZoneProt LOC_ADD_CHANGE;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lfc;"
    )
    @Export("ALTER_GROUND_ITEM")
    public static final ZoneProt ALTER_GROUND_ITEM;

    static {
        ALTER_GROUND_ITEM = new ZoneProt(7);
        MAP_PROJANIM = new ZoneProt(15);
        field2318 = new ZoneProt(14);
        MAP_ANIM = new ZoneProt(6);
        LOC_ANIM = new ZoneProt(4);
        SOUND_AREA = new ZoneProt(5);
        LOC_DEL = new ZoneProt(2);
        GROUND_ITEM_REMOVE = new ZoneProt(3);
        GROUND_ITEM_ADD = new ZoneProt(5);
        LOC_ADD_CHANGE = new ZoneProt(4);
    }

    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "7"
    )
    ZoneProt(int var1) {
    }
}
