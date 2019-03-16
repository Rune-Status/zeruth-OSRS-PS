package plugin.interaction.inter;

import org.arcanium.game.component.Component;
import org.arcanium.game.component.ComponentDefinition;
import org.arcanium.game.component.ComponentPlugin;
import org.arcanium.game.node.entity.combat.CombatStyle;
import org.arcanium.game.node.entity.combat.CombatSwingHandler;
import org.arcanium.game.node.entity.combat.equipment.WeaponInterface;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.system.task.Pulse;
import org.arcanium.game.world.GameWorld;
import org.arcanium.plugin.Plugin;

/**
 * Represents the combat tab interface.
 *
 * @author Emperor
 * @author Vexia'
 * @version 1.0
 */
public class CombatTabInterface extends ComponentPlugin {

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
        ComponentDefinition.put(593, this);
        return this;
    }

    @Override
    public boolean handle(final Player p, Component component, int opcode, int button, int slot, int itemId) {
        System.out.println("[CombatTabInterface] Button=" + button);
        switch (button) {

            case 3:
            case 24:
            case 20:
                System.out.println("[CombatTabInterface] lulbutton20/24");
                WeaponInterface inter = p.getExtension(WeaponInterface.class);
                if (inter == null) {
                    System.out.println("[CombatTabInterface] Interface is null");
                    return false;
                }
                System.out.println("[CombatTabInterface] setting attack style");
                if (inter.setAttackStyle(button)) {
                    System.out.println("[CombatTabInterface] Selecting style button=" + button);
                    if (button == 24 || button == 20) {
                        System.out.println("[CombatTabInterface] Selecting autocast");
                        inter.openAutocastSelect();
                    } else if (p.getProperties().getAutocastSpell() != null) {
                        inter.selectAutoSpell(-1, false);
                    }
                    return true;
                }
                return true;

            case 27:
                GameWorld.submit(new Pulse(1, p) {
                    @Override
                    public boolean pulse() {
                        p.getSettings().toggleRetaliating();
                        return true;
                    }
                });
                break;
            case 30:
                GameWorld.submit(new Pulse(1, p) {
                    @Override
                    public boolean pulse() {
                        WeaponInterface inter = p.getExtension(WeaponInterface.class);
                        if (inter != null && inter.isSpecialBar()) {
                            p.getSettings().toggleSpecialBar();
                            if (p.getSettings().isSpecialToggled()) {
                                CombatSwingHandler handler;
                                if ((handler = CombatStyle.MELEE.getSwingHandler().getSpecial(p.getEquipment().getNew(3).getId())) != null) {
                                    @SuppressWarnings("unchecked")
                                    Plugin<Object> plugin = (Plugin<Object>) ((Object) handler);
                                    if (plugin.fireEvent("instant_spec", p) == Boolean.TRUE) {
                                        handleInstantSpec(p, handler, plugin);
                                    }
                                }
                            }
                        }
                        return true;
                    }
                });
                break;
            //case 0:
            default:

                return false;
        }
        return true;
    }

    /**
     * Method used to handle an instance special attack.
     *
     * @param p       the player.
     * @param handler the handler.
     * @param plugin  the plugin.
     */
    private static void handleInstantSpec(Player p, CombatSwingHandler handler, Plugin<Object> plugin) {
        handler.swing(p, p.getProperties().getCombatPulse().getVictim(), null);
    }
}
