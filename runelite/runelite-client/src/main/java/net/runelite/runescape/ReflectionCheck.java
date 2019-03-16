package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSClassInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@ObfuscatedName("lo")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node implements RSClassInfo {
    @ObfuscatedName("l")
    int[] field3848;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -1643803809
    )
    int count;
    @ObfuscatedName("e")
    int[] type;
    @ObfuscatedName("w")
    byte[][][] args;
    @ObfuscatedName("q")
    int[] errorIdentifiers;
    @ObfuscatedName("b")
    Method[] methods;
    @ObfuscatedName("c")
    Field[] fields;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1544626613
    )
    int field3845;

    public Field[] getFields() {
        return this.fields;
    }

    public Method[] getMethods() {
        return this.methods;
    }

    public byte[][][] getArgs() {
        return this.args;
    }
}
