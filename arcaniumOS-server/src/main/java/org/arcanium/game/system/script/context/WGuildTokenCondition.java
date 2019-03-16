package org.arcanium.game.system.script.context;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.system.script.ScriptContext;

/**
 * Script condition for checking if a player has warrior guild tokens.
 * @author 'Vexia
 */
public final class WGuildTokenCondition extends ScriptContext {

    /**
     * Constructs a new {@code WGuildTokenCondition} {@code Object}.
     */
    public WGuildTokenCondition() {
	super("hasWarriorTokens");
    }

    @Override
    public boolean execute(Object... args) {
	return ((Player) args[0]).getSavedData().getActivityData().getWarriorGuildTokens() > 0;
    }

    @Override
    public ScriptContext parse(Object... params) {
	ScriptContext context = new WGuildTokenCondition();
	context.setParameters(params);
	return context;
    }
}