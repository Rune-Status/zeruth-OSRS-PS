package plugin.entity.player.skills.magic;

import org.arcanium.ServerConstants;
import org.arcanium.game.content.skill.f2p.magic.MagicSpell;
import org.arcanium.game.content.skill.f2p.magic.Runes;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.combat.equipment.SpellType;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.SpellBookManager.SpellBook;
import org.arcanium.game.node.entity.player.link.TeleportManager;
import org.arcanium.game.node.entity.player.link.diary.DiaryType;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.map.Location;
import org.arcanium.plugin.Plugin;
import org.arcanium.tools.RandomFunction;

/**
 * Represents the plugin to handle all teleport spells in the modern book.
 *
 * @author 'Vexia
 * @version 1.0
 */
public final class ModernTeleportPlugin extends MagicSpell {

    /**
     * Represents the location to teleport to.
     */
    private Location location;

    /**
     * Constructs a new {@code ModernTeleportPlugin} {@code Object}.
     */
    public ModernTeleportPlugin() {
        /**
         * empty.
         */
    }

    /**
     * Constructs a new {@code ModernTeleportPlugin.java} {@code Object}.
     *
     * @param level      the level.
     * @param experience the experience.
     * @param items      the items.
     */
    public ModernTeleportPlugin(final int level, final double experience, final Location location, final Item... items) {
        super(SpellBook.MODERN, level, experience, null, null, null, items);
        this.location = location;
    }

    @Override
    public boolean cast(Entity entity, Node target) {
        if (entity.getLocks().isTeleportLocked() || !super.meetsRequirements(entity, true, false)) {
            return false;
        }
        if (entity.getTeleporter().send(location.transform(0, RandomFunction.random(3), 0), getSpellId() == 0 ? TeleportManager.TeleportType.HOME : TeleportManager.TeleportType.NORMAL)) {
            if (!super.meetsRequirements(entity, true, true)) {
                entity.getTeleporter().getCurrentTeleport().stop();
                return false;
            }
            if (entity.isPlayer() && location.getX() == 3213 && !entity.asPlayer().getAchievementDiaryManager().getDiary(DiaryType.VARROCK).isComplete(1, 4)) {
                entity.asPlayer().getAchievementDiaryManager().getDiary(DiaryType.VARROCK).updateTask(entity.asPlayer(), 1, 4, true);
            }
            if (entity.isPlayer() && location.getX() == 3221 && location.getY() == 3219) {
                Player player = entity.asPlayer();
                if (!player.getAchievementDiaryManager().getDiary(DiaryType.LUMBRIDGE).isComplete(1, 2)) {
                    player.getAchievementDiaryManager().updateTask(player, DiaryType.LUMBRIDGE, 1, 2, true);
                }
            }
            entity.setAttribute("teleport:items", super.runes);
            entity.setAttribute("magic-delay", GameWorld.getTicks() + 5);
            return true;
        }
        return false;
    }

    @Override
    public Plugin<SpellType> newInstance(SpellType arg) throws Throwable {
        //home
        SpellBook.MODERN.register(1, new ModernTeleportPlugin(0, 0, Location.create(3088, 3504, 0), new Item(Runes.LAW_RUNE.getId(), 0)));
        //varrock
        SpellBook.MODERN.register(16, new ModernTeleportPlugin(25, 35, Location.create(3211, 3422, 0), new Item(Runes.LAW_RUNE.getId(), 1), new Item(Runes.AIR_RUNE.getId(), 3), new Item(Runes.FIRE_RUNE.getId())));
        //lumby
        SpellBook.MODERN.register(19, new ModernTeleportPlugin(31, 41, Location.create(3225, 3218, 0), new Item(Runes.LAW_RUNE.getId(), 1), new Item(Runes.AIR_RUNE.getId(), 3), new Item(Runes.EARTH_RUNE.getId())));
        //fally
        SpellBook.MODERN.register(22, new ModernTeleportPlugin(37, 47, Location.create(2965, 3378, 0), new Item(Runes.LAW_RUNE.getId(), 1), new Item(Runes.AIR_RUNE.getId(), 3), new Item(Runes.WATER_RUNE.getId())));
        //house
        SpellBook.MODERN.register(24, new ModernTeleportPlugin(40, 50, ServerConstants.getHomeLocation(), new Item(Runes.LAW_RUNE.getId()), new Item(Runes.AIR_RUNE.getId(), 1), new Item(Runes.EARTH_RUNE.getId(), 1)));
        //camelot
        SpellBook.MODERN.register(27, new ModernTeleportPlugin(45, 55.5, Location.create(2758, 3478, 0), new Item(Runes.LAW_RUNE.getId(), 1), new Item(Runes.AIR_RUNE.getId(), 5)));
        //ardougne
        SpellBook.MODERN.register(33, new ModernTeleportPlugin(51, 61, Location.create(2662, 3307, 0), new Item(Runes.LAW_RUNE.getId(), 2), new Item(Runes.WATER_RUNE.getId(), 2)));
        //watchtower
        SpellBook.MODERN.register(38, new ModernTeleportPlugin(58, 68, Location.create(2549, 3112, 0), new Item(Runes.LAW_RUNE.getId(), 2), new Item(Runes.EARTH_RUNE.getId(), 2)));
        //trollheim
        SpellBook.MODERN.register(45, new ModernTeleportPlugin(61, 68, Location.create(2891, 3678, 0), new Item(Runes.LAW_RUNE.getId(), 2), new Item(Runes.FIRE_RUNE.getId(), 2)));
        //ape atol
        SpellBook.MODERN.register(48, new ModernTeleportPlugin(64, 74, Location.create(2754, 2784, 0), new Item(1963, 1), new Item(Runes.LAW_RUNE.getId(), 2), new Item(Runes.WATER_RUNE.getId(), 2), new Item(Runes.FIRE_RUNE.getId(), 2)));
        //Kourend
        SpellBook.MODERN.register(53, new ModernTeleportPlugin(69, 82, Location.create(1633, 3678, 0), new Item(Runes.LAW_RUNE.getId(), 2), new Item(Runes.SOUL_RUNE.getId(), 2), new Item(Runes.WATER_RUNE.getId(), 4), new Item(Runes.FIRE_RUNE.getId(), 5)));
        return this;
    }

}
