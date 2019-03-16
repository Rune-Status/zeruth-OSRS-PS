package plugin.combat.special;

import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.combat.BattleState;
import org.arcanium.game.node.entity.combat.CombatStyle;
import org.arcanium.game.node.entity.combat.handlers.MeleeSwingHandler;
import org.arcanium.game.node.entity.impl.Animator;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.audio.Audio;
import org.arcanium.game.world.update.flag.context.Animation;
import org.arcanium.game.world.update.flag.context.Graphics;
import org.arcanium.plugin.Plugin;
import org.arcanium.tools.RandomFunction;

/**
 * Handles the Saradomin sword special attack.
 *
 * @author Emperor
 */
public final class SaradominsLightningHandler extends MeleeSwingHandler implements Plugin<Object> {

    /**
     * The special energy required.
     */
    private static final int SPECIAL_ENERGY = 100;

    /**
     * The attack animation.
     */
    private static final Animation ANIMATION = new Animation(7072, Animator.Priority.HIGH);

    /**
     * The graphic.
     */
    private static final Graphics GRAPHIC = new Graphics(1224);

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        CombatStyle.MELEE.getSwingHandler().register(11838, this);
        return this;
    }

    @Override
    public int swing(Entity entity, Entity victim, BattleState state) {
        if (!((Player) entity).getSettings().drainSpecial(SPECIAL_ENERGY)) {
            return -1;
        }
        int hit = 0;
        int secondary = 0;
        if (isAccurateImpact(entity, victim, CombatStyle.MELEE, 1.10, 0.98)) {
            hit = RandomFunction.random(calculateHit(entity, victim, 1.1));
            secondary = 5 + RandomFunction.RANDOM.nextInt(14);
        }
        state.setEstimatedHit(hit);
        state.setSecondaryHit(secondary);
        entity.asPlayer().getAudioManager().send(new Audio(3853), true);
        return 1;
    }

    @Override
    public void impact(Entity entity, Entity victim, BattleState s) {
        int hit = s.getEstimatedHit();
        if (hit > -1) {
            victim.getImpactHandler().handleImpact(entity, hit, CombatStyle.MELEE, s);
        }
        hit = s.getSecondaryHit();
        if (hit > -1) {
            victim.graphics(Graphics.create(1194));
            victim.getImpactHandler().handleImpact(entity, hit, CombatStyle.MAGIC, s);
        }
    }

    @Override
    public void visualize(Entity entity, Entity victim, BattleState state) {
        entity.visualize(ANIMATION, GRAPHIC);
    }

    @Override
    public Object fireEvent(String identifier, Object... args) {
        return null;
    }
}