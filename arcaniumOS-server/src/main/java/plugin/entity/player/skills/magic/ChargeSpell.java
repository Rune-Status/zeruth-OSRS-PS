package plugin.entity.player.skills.magic;

import org.arcanium.game.content.skill.f2p.magic.MagicSpell;
import org.arcanium.game.content.skill.f2p.magic.Runes;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.combat.equipment.SpellType;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.SpellBookManager;
import org.arcanium.game.node.entity.state.EntityState;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.world.update.flag.context.Animation;
import org.arcanium.game.world.update.flag.context.Graphics;
import org.arcanium.plugin.Plugin;

/**
 * Represents the charge spell magic spell.
 *
 * @author Emperor
 */
public final class ChargeSpell extends MagicSpell {

    /**
     * Constructs a new {@code ChargeSpell} {@code Object}.
     */
    public ChargeSpell() {
        super(SpellBookManager.SpellBook.MODERN, 80, 180, Animation.create(811), new Graphics(6, 96), null, new Item[]{Runes.FIRE_RUNE.getItem(3), Runes.BLOOD_RUNE.getItem(3), Runes.AIR_RUNE.getItem(3)});
    }

    @Override
    public Plugin<SpellType> newInstance(SpellType arg) throws Throwable {
        SpellBookManager.SpellBook.MODERN.register(58, this);
        return this;
    }

    @Override
    public boolean cast(Entity entity, Node target) {
        final Player p = (Player) entity;
        if (p.getLocks().isLocked("charge_cast")) {
            p.getPacketDispatch().sendMessage("You need to wait for the spell to recharge.");
            return false;
        }
        if (!meetsRequirements(entity, true, true)) {
            return false;
        }
        p.getLocks().lock("charge_cast", 100);
        visualize(entity, target);
        p.getStateManager().set(EntityState.CHARGED);
        p.getPacketDispatch().sendMessage("You feel charged with magic power.");
        return true;
    }

}