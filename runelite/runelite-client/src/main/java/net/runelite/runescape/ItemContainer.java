package net.runelite.runescape;

import net.runelite.api.events.ItemContainerChanged;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSItem;
import net.runelite.rs.api.RSItemContainer;

@ObfuscatedName("ba")
@Implements("ItemContainer")
public class ItemContainer extends Node implements RSItemContainer {
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lgq;"
    )
    static HashTable itemContainers;
    @ObfuscatedName("r")
    int[] itemIds;
    @ObfuscatedName("e")
    int[] stackSizes;
    public int rl$lastCycle;

    static {
        itemContainers = new HashTable(32);
    }

    ItemContainer() {
        this.itemIds = new int[]{-1};
        this.stackSizes = new int[]{0};
        this.stackSizesChanged(-1);
    }

    public int[] getItemIds() {
        return this.itemIds;
    }

    public int[] getStackSizes() {
        return this.stackSizes;
    }

    public void stackSizesChanged(int var1) {
        int var2 = class166.clientInstance.getGameCycle();
        if (var2 != this.rl$lastCycle) {
            this.rl$lastCycle = var2;
            ItemContainerChanged var3 = new ItemContainerChanged(this);
            class166.clientInstance.getCallbacks().postDeferred(var3);
        }
    }

    public net.runelite.api.Item[] getItems() {
        int[] var1 = this.getItemIds();
        int[] var2 = this.getStackSizes();
        net.runelite.api.Item[] var3 = new net.runelite.api.Item[var1.length];

        for (int var4 = 0; var4 < var1.length; ++var4) {
            RSItem var5 = class166.clientInstance.createItem();
            var5.setId(var1[var4]);
            var5.setQuantity(var2[var4]);
            var3[var4] = var5;
        }

        return var3;
    }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "1891084397"
    )
    static int method1931(int var0, class106 var1, boolean var2) {
        ComponentType var3;
        if (var0 >= 2000) {
            var0 -= 1000;
            var3 = WorldMapType1.method2440(class48.intStack[--class228.intStackSize]);
        } else {
            var3 = var2 ? class113.field75 : class48.field1080;
        }

        if (var0 == 1927) {
            if (class48.field1075 >= 10) {
                throw new RuntimeException();
            } else if (var3.onResizeListener == null) {
                return 0;
            } else {
                ScriptEvent var4 = new ScriptEvent();
                var4.source = var3;
                var4.params = var3.onResizeListener;
                var4.field572 = class48.field1075 + 1;
                client.field842.method4351(var4);
                return 1;
            }
        } else {
            return 2;
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/CharSequence;I)I",
            garbageValue = "1557015604"
    )
    public static int method1914(CharSequence var0) {
        int var1 = var0.length();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            var2 = (var2 << 5) - var2 + FaceNormal.method5725(var0.charAt(var3));
        }

        return var2;
    }
}
