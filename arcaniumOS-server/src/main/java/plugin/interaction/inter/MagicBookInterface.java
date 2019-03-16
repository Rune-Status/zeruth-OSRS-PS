package plugin.interaction.inter;

import org.arcanium.game.component.Component;
import org.arcanium.game.component.ComponentDefinition;
import org.arcanium.game.component.ComponentPlugin;
import org.arcanium.game.content.skill.f2p.magic.MagicSpell;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.SpellBookManager;
import org.arcanium.game.world.GameWorld;
import org.arcanium.plugin.Plugin;

/**
 * Represents the magic book interface handling of non-combat spells.
 *
 * @author 'Vexia
 */
public final class MagicBookInterface extends ComponentPlugin {

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        ComponentDefinition.put(218, this);
        return this;
    }

    @Override
    public boolean handle(final Player player, Component component, int opcode, int button, int slot, int itemId) {
        if (GameWorld.getTicks() < player.getAttribute("magic:delay", -1)) {
            return true;
        }
        return MagicSpell.castSpell(player, SpellBookManager.SpellBook.forConfig(player.getSpellBookManager().getSpellBook()), button, player);
    }
}
