package plugin.combat.special;

import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.combat.BattleState;
import org.arcanium.game.node.entity.combat.CombatStyle;
import org.arcanium.game.node.entity.combat.handlers.MeleeSwingHandler;
import org.arcanium.game.node.entity.impl.Animator;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.update.flag.context.Animation;
import org.arcanium.game.world.update.flag.context.Graphics;
import org.arcanium.plugin.Plugin;

/**
 * Handles the excalibur special attack.
 *
 * @author Emperor
 */
public final class ExcaliburSpecialHandler extends MeleeSwingHandler implements Plugin<Object> {

    /**
     * The special energy required.
     */
    private static final int SPECIAL_ENERGY = 100;

    /**
     * The attack animation.
     */
    private static final Animation ANIMATION = new Animation(1057, Animator.Priority.HIGH);

    /**
     * The graphic.
     */
    private static final Graphics GRAPHIC = new Graphics(247);

    @Override
    public Object fireEvent(String identifier, Object... args) {
        switch (identifier) {
            case "instant_spec":
            case "ncspec":
                return true;
        }
        return null;
    }

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        CombatStyle.MELEE.getSwingHandler().register(35, this);
        return this;
    }

    @Override
    public int swing(Entity entity, Entity victim, BattleState state) {
        Player p = (Player) entity;
        if (!p.getSettings().drainSpecial(SPECIAL_ENERGY))
            return -1;
        p.sendChat("For Camelot!");
        p.visualize(ANIMATION, GRAPHIC);
        p.getSkills().updateLevel(Skills.DEFENCE, 8, p.getSkills().getStaticLevel(Skills.DEFENCE) + 8);
        return -1;
    }

}