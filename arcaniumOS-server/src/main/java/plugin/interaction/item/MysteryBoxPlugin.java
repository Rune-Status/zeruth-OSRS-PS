package plugin.interaction.item;

import org.arcanium.cache.def.impl.ItemDefinition;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.npc.drop.DropFrequency;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.ChanceItem;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.plugin.Plugin;
import org.arcanium.tools.RandomFunction;
import org.arcanium.tools.StringUtils;

/**
 * Handles the mystery box items.
 *
 * @author Vexia
 * @author Splinter
 * @uthor trees
 */
public final class MysteryBoxPlugin extends OptionHandler {

    /**
     * The rewards recieved from a mystery box.
     */
    private static final ChanceItem[] REWARDS = new ChanceItem[]{

            new ChanceItem(314, 218, 514, DropFrequency.COMMON),//feather
            new ChanceItem(8008, 2, 6, DropFrequency.COMMON),//lumbridge tab
            new ChanceItem(8007, 2, 6, DropFrequency.COMMON),//varrock tab
            new ChanceItem(8009, 2, 6, DropFrequency.COMMON),//falador tab
            new ChanceItem(8010, 2, 6, DropFrequency.COMMON),//camelot tab
            new ChanceItem(892, 100, 175, DropFrequency.COMMON),//rune arrows
            new ChanceItem(555, 100, 175, DropFrequency.COMMON),//water rune
            new ChanceItem(557, 100, 335, DropFrequency.COMMON),//earth rune
            new ChanceItem(565, 100, 175, DropFrequency.COMMON),//blood rune
            new ChanceItem(556, 100, 335, DropFrequency.COMMON),//air rune
            new ChanceItem(7937, 88, 150, DropFrequency.COMMON),//noted pure ess
            new ChanceItem(1331, 1, 1, DropFrequency.COMMON),//adamant scimitar
            new ChanceItem(208, 3, 9, DropFrequency.COMMON),//grimy ranarr noted
            new ChanceItem(1514, 15, 45, DropFrequency.COMMON),//magic logs noted
            new ChanceItem(1780, 65, 125, DropFrequency.COMMON),//flax noted
            new ChanceItem(232, 65, 125, DropFrequency.COMMON),//snape grass noted
            new ChanceItem(1122, 2, 3, DropFrequency.COMMON),//mithril plate
            new ChanceItem(1124, 1, 2, DropFrequency.COMMON),//addy platebody
            new ChanceItem(9243, 12, 19, DropFrequency.COMMON),//addy bolts e
            new ChanceItem(372, 25, 56, DropFrequency.COMMON),//raw swordfish
            new ChanceItem(378, 22, 45, DropFrequency.COMMON),//raw lobster
            new ChanceItem(1776, 19, 30, DropFrequency.COMMON),//molten glass
            new ChanceItem(3139, 12, 18, DropFrequency.COMMON),//potato cactus
            new ChanceItem(5983, 13, 19, DropFrequency.COMMON),//watermelon noted

            new ChanceItem(242, 15, 28, DropFrequency.COMMON),//dragon scale dust
            new ChanceItem(7947, 50, 125, DropFrequency.UNCOMMON),//raw monkfish noted
            new ChanceItem(1357, 1, 1, DropFrequency.UNCOMMON),//addy axe
            new ChanceItem(1074, 2, 3, DropFrequency.UNCOMMON),//addy legs
            new ChanceItem(1731, 1, 1, DropFrequency.UNCOMMON),//amulet of power
            new ChanceItem(1617, 1, 1, DropFrequency.UNCOMMON),//uncut dmnd
            new ChanceItem(995, 5500, 23000, DropFrequency.UNCOMMON),//coins
            new ChanceItem(1445, 3, 8, DropFrequency.UNCOMMON),//water tally
            new ChanceItem(454, 14, 28, DropFrequency.UNCOMMON),//noted coal
            new ChanceItem(5302, 9, 18, DropFrequency.UNCOMMON),//lantadyme seed
            new ChanceItem(5300, 6, 12, DropFrequency.UNCOMMON),//snap seed
            new ChanceItem(5297, 4, 11, DropFrequency.UNCOMMON),//irit seed
            new ChanceItem(12183, 2000, 10000, DropFrequency.UNCOMMON),//spirit shard
            new ChanceItem(228, 85, 300, DropFrequency.UNCOMMON),//vial of water noted
            new ChanceItem(11255, 1, 3, DropFrequency.UNCOMMON),//ninja impling jar noted
            new ChanceItem(441, 18, 21, DropFrequency.UNCOMMON),//iron ore noted
            new ChanceItem(2358, 10, 22, DropFrequency.UNCOMMON),//noted gold bar
            new ChanceItem(1750, 16, 19, DropFrequency.UNCOMMON),//red d'hide

            new ChanceItem(1333, 1, 1, DropFrequency.RARE),//rune scimitar
            new ChanceItem(9194, 4, 12, DropFrequency.RARE),//onyx bolt tips
            new ChanceItem(1601, 1, 1, DropFrequency.RARE),//cut diamond
            new ChanceItem(11876, 1, 1, DropFrequency.RARE),//splitbark set
            new ChanceItem(3122, 1, 1, DropFrequency.RARE),//granite shield
            new ChanceItem(563, 35, 100, DropFrequency.RARE),//law rune
            new ChanceItem(6688, 8, 17, DropFrequency.RARE),//sara brew(3) noted
            new ChanceItem(561, 50, 200, DropFrequency.RARE),//nature rune 
            new ChanceItem(4131, 1, 1, DropFrequency.RARE),//rune booties 
            new ChanceItem(1359, 1, 1, DropFrequency.RARE),//rune axe
            new ChanceItem(2363, 4, 9, DropFrequency.RARE),//rune bar
            new ChanceItem(1149, 1, 1, DropFrequency.RARE),//dragon med helm
            new ChanceItem(1319, 1, 1, DropFrequency.RARE),//rune 2h
            new ChanceItem(12032, 4, 8, DropFrequency.RARE),//war tort pouch
            new ChanceItem(5315, 1, 1, DropFrequency.RARE),//yew seed
            new ChanceItem(1201, 1, 1, DropFrequency.RARE),//rune kiteshield

            new ChanceItem(5315, 1, 3, DropFrequency.VERY_RARE),//yew seed
            new ChanceItem(5316, 1, 1, DropFrequency.VERY_RARE),//magic seed
            new ChanceItem(1127, 1, 1, DropFrequency.VERY_RARE),//rune pl8
            new ChanceItem(985, 1, 1, DropFrequency.VERY_RARE),//half key
            new ChanceItem(2651, 1, 1, DropFrequency.VERY_RARE),//pirate's hat
            new ChanceItem(987, 1, 1, DropFrequency.VERY_RARE),//half key
            new ChanceItem(989, 1, 1, DropFrequency.VERY_RARE),//full key
            new ChanceItem(1631, 1, 1, DropFrequency.VERY_RARE),//uncut dstone 
            new ChanceItem(2366, 1, 1, DropFrequency.VERY_RARE),//shield left half
            new ChanceItem(1305, 1, 1, DropFrequency.VERY_RARE),//dragon longsword
            new ChanceItem(4587, 1, 1, DropFrequency.VERY_RARE),//dragon scimitar
            new ChanceItem(3204, 1, 1, DropFrequency.VERY_RARE),//dragon halberd
            new ChanceItem(10394, 1, 1, DropFrequency.VERY_RARE),//flared trousers
            new ChanceItem(10392, 1, 1, DropFrequency.VERY_RARE),//powdered wig
            new ChanceItem(11838, 1, 1, DropFrequency.VERY_RARE),//rune armour set (l)
            new ChanceItem(11256, 1, 3, DropFrequency.VERY_RARE),//dragon impling jar noted
    };

    /**
     * The spawn rewards.
     */
    private static final ChanceItem[] SPAWN_REWARDS = new ChanceItem[]{new ChanceItem(10420, 1, 1, DropFrequency.UNCOMMON),// white
            // ele
            new ChanceItem(10422, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10400, 1, 1, DropFrequency.RARE),// black
            // ele
            new ChanceItem(10402, 1, 1, DropFrequency.RARE), new ChanceItem(10416, 1, 1, DropFrequency.UNCOMMON),// purple
            // ele
            new ChanceItem(10418, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10436, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10438, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10404, 1, 1, DropFrequency.UNCOMMON),// red
            // ele
            // shirt
            new ChanceItem(10406, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10424, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10426, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10408, 1, 1, DropFrequency.UNCOMMON),// blue
            // ele
            // shirt
            new ChanceItem(10410, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10428, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10430, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10412, 1, 1, DropFrequency.UNCOMMON),// green
            // ele
            // shirt
            new ChanceItem(10414, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10432, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10434, 1, 1, DropFrequency.UNCOMMON),

            new ChanceItem(7319, 1, 1, DropFrequency.UNCOMMON),// Boaters
            new ChanceItem(7321, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(7323, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(7325, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(7327, 1, 1, DropFrequency.UNCOMMON),

            // Riu's items

            new ChanceItem(10939, 1, 1, DropFrequency.RARE), // lumberjack
            new ChanceItem(10940, 1, 1, DropFrequency.RARE), new ChanceItem(10941, 1, 1, DropFrequency.RARE),

            new ChanceItem(6199, 1, 1, DropFrequency.UNCOMMON), // Mbox

            new ChanceItem(6335, 1, 1, DropFrequency.UNCOMMON), // tribal masks
            new ChanceItem(6337, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(13109, 1, 1, DropFrequency.RARE), // animal
            // masks
            new ChanceItem(13111, 1, 1, DropFrequency.COMMON), new ChanceItem(13113, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(13115, 1, 1, DropFrequency.RARE),

            new ChanceItem(9925, 1, 1, DropFrequency.RARE), // skele set
            new ChanceItem(9924, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(9923, 1, 1, DropFrequency.UNCOMMON),

            new ChanceItem(11021, 1, 1, DropFrequency.RARE), new ChanceItem(11020, 1, 1, DropFrequency.RARE), new ChanceItem(11022, 1, 1, DropFrequency.RARE), new ChanceItem(11019, 1, 1, DropFrequency.RARE), // chicken

            new ChanceItem(6188, 1, 1, DropFrequency.COMMON),

            new ChanceItem(6858, 1, 1, DropFrequency.COMMON), // woolywooly
            new ChanceItem(6862, 1, 1, DropFrequency.COMMON),

            new ChanceItem(8928, 1, 1, DropFrequency.RARE), // Misc
            new ChanceItem(12595, 1, 1, DropFrequency.RARE), new ChanceItem(13101, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(5607, 1, 1, DropFrequency.VERY_RARE),

            new ChanceItem(6859, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10836, 1, 1, DropFrequency.RARE), new ChanceItem(10837, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10838, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10839, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(10840, 1, 1, DropFrequency.RARE), new ChanceItem(6857, 1, 1, DropFrequency.UNCOMMON), new ChanceItem(12645, 1, 1, DropFrequency.COMMON),

            new ChanceItem(7806, 1, 1, DropFrequency.VERY_RARE), new ChanceItem(7807, 1, 1, DropFrequency.VERY_RARE), new ChanceItem(7808, 1, 1, DropFrequency.VERY_RARE), new ChanceItem(7809, 1, 1, DropFrequency.VERY_RARE)};

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        ItemDefinition.forId(6199).getConfigurations().put("option:open", this);
        return this;
    }

    @Override
    public boolean handle(Player player, Node node, String option) {
        final ChanceItem item = RandomFunction.getChanceItem(GameWorld.isEconomyWorld() ? REWARDS : SPAWN_REWARDS);
        final String name = item.getName().toLowerCase();
        final Item box = (Item) node;
        if (player.getInventory().remove(box, box.getSlot(), true)) {
            player.lock(1);
            player.getInventory().add(new Item(item.getId(), RandomFunction.random(item.getMinimumAmount(), item.getMaximumAmount())));
            player.sendMessage("Inside the box you find " + (item.getId() == 995 ? "some" : (StringUtils.isPlusN(name) ? "an" : "a")) + " " + name + "!");
            if (item.getDropFrequency().equals(DropFrequency.VERY_RARE)) {
                Repository.sendNews(player.getUsername() + " has recieved " + item.getAmount() + "x " + item.getName() + " from a mystery box.");
            }
        }
        return true;
    }

    @Override
    public boolean isWalk() {
        return false;
    }

}
