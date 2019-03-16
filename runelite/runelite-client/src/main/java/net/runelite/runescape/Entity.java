package net.runelite.runescape;

import net.runelite.mapping.*;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSRenderable;

@ObfuscatedName("dd")
@Implements("Entity")
public abstract class Entity extends CacheableNode implements RSRenderable {
    @ObfuscatedName("co")
    @ObfuscatedGetter(
            intValue = -1806935189
    )
    @Export("modelHeight")
    public int modelHeight;

    protected Entity() {
        this.modelHeight = 1000;
    }

    @Export("getModel")
    public RSModel getModel() {
        return this.vmethod5584(-2070069362);
    }

    @Export("setModelHeight")
    public void setModelHeight(int var1) {
        this.modelHeight = var1;
    }

    @Export("getModelHeight")
    public int getModelHeight() {
        return this.modelHeight;
    }

    @Export("draw")
    public void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9, int bufferOffset) {
        this.vmethod5472(var1, var2, var3, var4, var5, var6, var7, var8, var9, bufferOffset);
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)Ldl;"
    )
    protected Model vmethod5584(int var1) {
        return null;
    }

    @ObfuscatedName("cf")
    void vmethod5472(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9, int bufferOffset) {
        Model var11 = this.vmethod5584(-1785592773);
        if (var11 != null) {
            this.modelHeight = var11.modelHeight;
            var11.vmethod5472(var1, var2, var3, var4, var5, var6, var7, var8, var9, bufferOffset);
        }

    }
}
