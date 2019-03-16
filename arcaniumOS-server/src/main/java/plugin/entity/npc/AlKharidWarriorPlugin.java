/*
 * Copyright (c) 2018.
 */

package plugin.entity.npc;

import org.arcanium.cache.def.impl.NPCDefinition;
import org.arcanium.game.interaction.OptionHandler;
import org.arcanium.game.node.Node;
import org.arcanium.game.node.entity.npc.AbstractNPC;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.system.task.Pulse;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.plugin.Plugin;

/**
 * Handles the Al-Kharid Warrior NPC.
 * @author Emperor
 * @version 1.0
 */
public final class AlKharidWarriorPlugin extends AbstractNPC {

    /**
     * The NPC ids of NPCs using this plugin.
     */
    private static final int[] ID = { 18 };

    /**
     * Constructs a new {@code AlKharidWarriorPlugin} {@code Object}.
     */
    public AlKharidWarriorPlugin() {
	super(18, Location.create(3299, 3174, 0), true);
    }

    /**
     * Constructs a new {@code AlKharidWarriorPlugin} {@code Object}.
     * @param id The NPC id.
     * @param location The location.
     */
    private AlKharidWarriorPlugin(int id, Location location) {
	super(id, location);
    }

    @Override
    public AbstractNPC construct(int id, Location location, Object... objects) {
	return new AlKharidWarriorPlugin(id, location);
    }

    @Override
    public void tick() {
	super.tick();
    }

    @Override
    public Plugin<Object> newInstance(Object arg) throws Throwable {
	new WarriorOptionPlugin().newInstance(arg);
	return super.newInstance(arg);
    }

    @Override
    public int[] getIds() {
	return ID;
    }

    /**
     * Represents the option plugin used for the warriors.s
     * @author 'Vexia
     * @version 1.0
     */
    public final class WarriorOptionPlugin extends OptionHandler {

	@Override
	public Plugin<Object> newInstance(Object arg) throws Throwable {
	    for (int id : ID) {
		NPCDefinition.forId(id).getConfigurations().put("option:attack", this);
	    }
	    return this;
	}

	@Override
	public boolean handle(final Player player, final Node node, String option) {
	    GameWorld.submit(new Pulse(1, player) {
		@Override
		public boolean pulse() {
		    for (NPC n : RegionManager.getLocalNpcs(((NPC) node), 5)) {
			if (n == node || n.getProperties().getCombatPulse().isAttacking() || n.getLocks().isInteractionLocked()) {
			    continue;
			}
			if (n.getId() == 18) {
			    n.sendChat("Brother, I will help thee with this infidel!");
			    n.getProperties().getCombatPulse().attack(player);
			}
		    }
		    return true;
		}
	    });
	    player.getProperties().getCombatPulse().attack(node);
	    return true;
	}

	@Override
	public boolean isWalk() {
	    return false;
	}
    }
}
