package plugin.combat.special;

import org.arcanium.game.content.skill.Skills;
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

/**
 * Handles the Rampage special attack.
 *
 * @author Emperor
 */
public final class RampageSpecialHandler extends MeleeSwingHandler implements Plugin<Object> {

    /**
     * The special energy required.
     */
    private static final int SPECIAL_ENERGY = 100;

    /**
     * The attack animation.
     */
    private static final Animation ANIMATION = new Animation(1056, Animator.Priority.HIGH);

    /**
     * The graphic.
     */
    private static final Graphics GRAPHIC = new Graphics(246);

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
        CombatStyle.MELEE.getSwingHandler().register(1377, this);
        return this;
    }

    @Override
    public int swing(Entity entity, Entity victim, BattleState state) {
        Player p = (Player) entity;
        if (!p.getSettings().drainSpecial(SPECIAL_ENERGY)) {
            return -1;
        }
        p.sendChat("Raarrrrrgggggghhhhhhh!");
        p.visualize(ANIMATION, GRAPHIC);
        @SuppressWarnings("unused")
        int boost = 0;
        for (int i = 0; i < 6; i++) {
            if (i == 2 || i == 3 || i == 5) {
                continue;
            }
            double drain = p.getSkills().getLevel(i) * 0.1;
            boost += drain;
            p.getSkills().updateLevel(i, (int) -drain, (int) (p.getSkills().getStaticLevel(i) - drain));
        }
        boost *= 0.25;
        p.getSkills().updateLevel(Skills.STRENGTH, (int) (p.getSkills().getStaticLevel(Skills.STRENGTH) * 0.20));
        p.getAudioManager().send(new Audio(386), true);
        return -1;
    }

}