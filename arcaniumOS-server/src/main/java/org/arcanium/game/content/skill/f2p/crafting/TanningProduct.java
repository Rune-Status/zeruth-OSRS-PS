package org.arcanium.game.content.skill.f2p.crafting;

import org.arcanium.cache.def.impl.ItemDefinition;
import org.arcanium.game.component.Component;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;

/**
 * Represents a tanning product.
 * @author 'Vexia
 */
public enum TanningProduct {
    SOFT_LEATHER(148, 1739, 1741), HARD_LEATHER(149, 1739, 1743), SNAKESKIN(150, 6287, 6289), SNAKESKIN2(151, 6287, 6289), GREEN_DHIDE(152, 1753, 1745), BLUEDHIDE(153, 1751, 2505), REDDHIDE(154, 1749, 2507), BLACKDHIDE(155, 1747, 2509);

    /**
     * The button.
     */
    private final int button;

    /**
     * The item needed.
     */
    private final int item;

    /**
     * The product.
     */
    private final int product;

    /**
     * Constructs a new {@code TanningProduct} {@Code Object}
     * @param button the button.
     * @param item the item.
     * @param product the product.
     */
    TanningProduct(int button, int item, int product) {
	this.button = button;
	this.item = item;
	this.product = product;
    }

    /**
     * @return the button.
     */
    public int getButton() {
	return button;
    }

    /**
     * @return the item.
     */
    public int getItem() {
	return item;
    }

    /**
     * @return the product.
     */
    public int getProduct() {
	return product;
    }

    /**
     * Gets the product by the id.
     * @param id the id.
     * @return the product.
     */
    public static TanningProduct forId(int id) {
	for (TanningProduct def : TanningProduct.values()) {
	    if (def.getButton() == id) {
		return def;
	    }
	}
	return null;
    }

    /**
     * Gets the product by the id.
     * @param id the id.
     * @return te product.
     */
    public static TanningProduct forItemId(int id) {
	for (TanningProduct def : TanningProduct.values()) {
	    if (def.getItem() == id) {
		return def;
	    }
	}
	return null;
    }

    /**
     * Method used to open the tanning interface.
     */
    public static void open(final Player player, final int npc) {
	player.getInterfaceManager().open(new Component(324));
	int index = 0;
	for (int i = 100; i < 108; i++) {
	    player.getPacketDispatch().sendItemZoomOnInterface(TanningProduct.values()[index].getItem(), 190, 324, i);
	    index++;
	}
	if (player.getInventory().contains(SOFT_LEATHER.getItem(), 1)) {
	    player.getPacketDispatch().sendString("Soft leather", 324, 108);
	    player.getPacketDispatch().sendString("1 coins", 324, 116);
	    player.getPacketDispatch().sendString("Hard leather", 324, 109);
	    player.getPacketDispatch().sendString("3 coins", 324, 117);
	} else {
	    player.getPacketDispatch().sendString("<col=FF0000>Soft leather", 324, 108);
	    player.getPacketDispatch().sendString("<col=FF0000>1 coins", 324, 116);
	    player.getPacketDispatch().sendString("<col=FF0000>Hard leather", 324, 109);
	    player.getPacketDispatch().sendString("<col=FF0000>3 coins", 324, 117);
	}
	if (player.getInventory().contains(SNAKESKIN.getItem(), 1)) {
	    player.getPacketDispatch().sendString("Snakeskin", 324, 110);
	    player.getPacketDispatch().sendString("20 coins", 324, 118);
	} else {
	    player.getPacketDispatch().sendString("<col=FF0000>Snakeskin", 324, 110);
	    player.getPacketDispatch().sendString("<col=FF0000>20 coins", 324, 118);
	}
	if (player.getInventory().contains(SNAKESKIN2.getItem(), 1)) {
	    player.getPacketDispatch().sendString("Snakeskin", 324, 111);
	    player.getPacketDispatch().sendString("15 coins", 324, 119);
	} else {
	    player.getPacketDispatch().sendString("<col=FF0000>Snakeskin", 324, 111);
	    player.getPacketDispatch().sendString("<col=FF0000>15 coins", 324, 119);
	}
	if (player.getInventory().contains(GREEN_DHIDE.getItem(), 1)) {
	    player.getPacketDispatch().sendString("Green d'hide", 324, 112);
	    player.getPacketDispatch().sendString("20 coins", 324, 120);
	} else {
	    player.getPacketDispatch().sendString("<col=FF0000>Green d'hide", 324, 112);
	    player.getPacketDispatch().sendString("<col=FF0000>20 coins", 324, 120);
	}
	if (player.getInventory().contains(BLUEDHIDE.getItem(), 1)) {
	    player.getPacketDispatch().sendString("Blue d'hide", 324, 113);
	    player.getPacketDispatch().sendString("20 coins", 324, 121);
	} else {
	    player.getPacketDispatch().sendString("<col=FF0000>Blue d'hide", 324, 113);
	    player.getPacketDispatch().sendString("<col=FF0000>20 coins", 324, 121);
	}
	if (player.getInventory().contains(REDDHIDE.getItem(), 1)) {
	    player.getPacketDispatch().sendString("Red d'hide", 324, 114);
	    player.getPacketDispatch().sendString("20 coins", 324, 122);
	} else {
	    player.getPacketDispatch().sendString("<col=FF0000>Red d'hide", 324, 114);
	    player.getPacketDispatch().sendString("<col=FF0000>20 coins", 324, 122);
	}
	if (player.getInventory().contains(BLACKDHIDE.getItem(), 1)) {
	    player.getPacketDispatch().sendString("Black d'hide", 324, 115);
	    player.getPacketDispatch().sendString("20 coins", 324, 123);
	} else {
	    player.getPacketDispatch().sendString("<col=FF0000>Black d'hide", 324, 115);
	    player.getPacketDispatch().sendString("<col=FF0000>20 coins", 324, 123);
	}
    }

    /**
     * Method used to tan the hide.
     * @param player the player.
     * @param amount the amount.
     */
    public static void tan(final Player player, int amount, TanningProduct def) {
	if (amount > player.getInventory().getAmount(new Item(def.getItem()))) {
	    amount = player.getInventory().getAmount(new Item(def.getItem()));
	}
	int coins = 0;
	if (def == SOFT_LEATHER) {
	    coins = 1;
	} else if (def == HARD_LEATHER) {
	    coins = 3;
	} else if (def == SNAKESKIN) {
	    coins = 20;
	} else if (def == SNAKESKIN2) {
	    coins = 15;
	} else {
	    coins = 20;
	}
	if (amount == 0) {
	    return;
	}
	if (!player.getInventory().contains(def.getItem(), amount)) {
	    player.getPacketDispatch().sendMessage("You don't have any " + ItemDefinition.forId(def.getItem()).getName().toLowerCase() + " to tan.");
	    return;
	}
	player.getInterfaceManager().close();
	if (!player.getInventory().contains(995, coins * amount)) {
	    player.getPacketDispatch().sendMessage("You don't have enough coins to tan that many.");
	    return;
	}
	if (player.getInventory().remove(new Item(995, coins * amount)) && player.getInventory().remove(new Item(def.getItem(), amount))) {
	    player.getInventory().add(new Item(def.getProduct(), amount));
	    if (amount > 1) {
		player.getPacketDispatch().sendMessage("The tanner tans " + amount + " " + ItemDefinition.forId(def.getItem()).getName().toLowerCase() + "s for you.");
	    } else {
		player.getPacketDispatch().sendMessage("The tanner tans your " + ItemDefinition.forId(def.getItem()).getName().toLowerCase() + ".");
	    }
	} else {
	    player.getPacketDispatch().sendMessage("You don't have enough coins to tan that many.");
	}
    }
}
