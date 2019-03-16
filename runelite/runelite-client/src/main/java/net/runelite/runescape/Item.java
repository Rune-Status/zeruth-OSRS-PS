package net.runelite.runescape;

import net.runelite.api.events.ItemQuantityChanged;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSItem;
import net.runelite.rs.api.RSTile;

@ObfuscatedName("cm")
@Implements("Item")
public final class Item extends Entity implements RSItem {
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -426893281
    )
    int quantity;
    public int rl$sceneY;
    public int rl$sceneX;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -53271901
    )
    int id;

    Item() {
        this.rl$$init();
    }

    public void onUnlink() {
        if (this.rl$sceneX != -1 && class166.clientInstance.getLastItemDespawn() == null) {
            class166.clientInstance.setLastItemDespawn(this);
        }

    }

    private void rl$$init() {
        this.rl$sceneX = -1;
        this.rl$sceneY = -1;
    }

    public int getId() {
        return this.id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public net.runelite.api.Tile getTile() {
        int var1 = this.rl$sceneX;
        int var2 = this.rl$sceneY;
        if (var1 != -1 && var2 != -1) {
            RSTile[][][] var3 = class166.clientInstance.getScene().getTiles();
            RSTile var4 = var3[class166.clientInstance.getPlane()][var1][var2];
            return var4;
        } else {
            return null;
        }
    }

    public void quantityChanged(int var1) {
        if (this.rl$sceneX != -1) {
            class166.clientInstance.getLogger().debug("Item quantity changed: {} ({} -> {})", new Object[]{Integer.valueOf(this.getId()), Integer.valueOf(this.getQuantity()), Integer.valueOf(var1)});
            ItemQuantityChanged var2 = new ItemQuantityChanged(this, this.getTile(), this.getQuantity(), var1);
            class166.clientInstance.getCallbacks().post(var2);
        }

    }

    public int getX() {
        return this.rl$sceneX;
    }

    public void setX(int var1) {
        this.rl$sceneX = var1;
    }

    public int getY() {
        return this.rl$sceneY;
    }

    public void setY(int var1) {
        this.rl$sceneY = var1;
    }

    public void setId(int var1) {
        this.id = var1;
    }

    public void setQuantity(int var1) {
        this.quantity = var1;
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            signature = "(I)Ldl;"
    )
    protected final Model vmethod5584(int var1) {
        return Varcs.method4770(this.id).method6333(this.quantity);
    }
}
