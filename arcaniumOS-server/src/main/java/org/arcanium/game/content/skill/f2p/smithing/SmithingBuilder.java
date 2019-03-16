package org.arcanium.game.content.skill.f2p.smithing;

import org.arcanium.game.component.Component;
import org.arcanium.game.container.access.InterfaceContainer;
import org.arcanium.game.content.global.tutorial.TutorialSession;
import org.arcanium.game.content.global.tutorial.TutorialStage;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.content.skill.f2p.smithing.smelting.Bar;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.tools.StringUtils;

/**
 * Represents the builder class to view the correct information, on the
 * interface of smithing, ie, the items amount, and name.
 * @author 'Vexia
 */
public final class SmithingBuilder {

    /**
     * The bar type.
     */
    private BarType type;

    /**
     * The bar used.
     */
    private Bar bar;

    /**
     * Constructs a new {@code SmithingBuilder.java} {@code Object}.
     * @param item the item.
     */
    public SmithingBuilder(Item item) {
	this.bar = Bar.forId(item.getId());
	this.type = BarType.getBarTypeForId(item.getId());
    }

    /**
     * Builds the interface of the smithing.
     * @param player the player.
     */
    public void build(Player player) {
	player.getGameAttributes().removeAttribute("smith-type");
	player.getGameAttributes().setAttribute("smith-type", type);
	player.getPacketDispatch().sendInterfaceConfig(300, 267, false);// pickaxe
	final Bars bars[] = Bars.getBars(type);
	for (int i = 0; i < bars.length; i++) {
	    if (bars[i].getSmithingType() == SmithingType.TYPE_GRAPPLE_TIP) {
		player.getPacketDispatch().sendInterfaceConfig(300, 170, false);
	    }
	    if (bars[i].getSmithingType() == SmithingType.TYPE_DART_TIP) {
		player.getPacketDispatch().sendInterfaceConfig(300, 66, false);
	    }
	    if (bars[i].getSmithingType() == SmithingType.TYPE_SPIT_IRON || bars[i].getSmithingType() == SmithingType.TYPE_WIRE) {
		player.getPacketDispatch().sendInterfaceConfig(300, 90, false);
	    }
	    if (bars[i].getSmithingType() == SmithingType.TYPE_CLAWS) {
		player.getPacketDispatch().sendInterfaceConfig(300, 210, false);
	    }
	    if (bars[i].getSmithingType() == SmithingType.TYPE_LANTERN) {
		player.getPacketDispatch().sendInterfaceConfig(300, 162, false);
	    }
	    if (bars[i].getSmithingType() == SmithingType.TYPE_STUDS) {
		player.getPacketDispatch().sendInterfaceConfig(300, 170, false);
	    }
	    String color = "";
	    if (player.getSkills().getLevel(Skills.SMITHING) < bars[i].getLevel()) {
	    } else {
		color = "<col=FFFFFF>";
	    }
	    player.getPacketDispatch().sendString(color + StringUtils.formatDisplayName(bars[i].getSmithingType().name().replace("TYPE_", "")), 300, bars[i].getSmithingType().getName() + 1);
	    if (player.getInventory().contains(bars[i].getBarType().getBarType(), bars[i].getSmithingType().getRequired())) {
		color = "<col=2DE120>";
	    } else {
		color = null;
	    }
	    if (color != null) {
		String amt = bars[i].getSmithingType().getRequired() > 1 ? "s" : "";
		player.getPacketDispatch().sendString(color + String.valueOf(bars[i].getSmithingType().getRequired()) + " Bar" + amt, 300, bars[i].getSmithingType().getName() + 2);
	    }
	    InterfaceContainer.generateItems(player, new Item[] { new Item(bars[i].getProduct(), bars[i].getSmithingType().getProductAmount()) }, new String[] { "" }, 300, bars[i].getSmithingType().getChild());
	    InterfaceContainer.generateItems(player, new Item[] { new Item(bars[i].getProduct(), bars[i].getSmithingType().getProductAmount()) }, new String[] { "" }, 300, bars[i].getSmithingType().getChild());
	}
	player.getPacketDispatch().sendString(type.getBarName(), 300, 15);
	player.getInterfaceManager().open(new Component(300));
	if (TutorialSession.getExtension(player).getStage() == 41) {
	    TutorialStage.load(player, 42, false);
	}
    }

    /**
     * Gets the type.
     * @return the type.
     */
    public BarType getType() {
	return type;
    }

    /**
     * Gets the bar.
     * @return the bar.
     */
    public Bar getBar() {
	return bar;
    }

}
