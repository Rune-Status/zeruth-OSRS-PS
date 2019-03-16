package org.arcanium.cache.def;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.arcanium.cache.def.impl.NPCDefinition;

import java.util.Objects;

/**
 * The {@link JsonLoader} implementation that loads all npc definitions.
 *
 * @author lare96 <http://github.com/lare96>
 */
public final class NPCDefinitionLoader extends JsonLoader {

    int count = 0;

    /**
     * Creates a new {@link NPCDefinitionLoader}.
     */
    public NPCDefinitionLoader() {

        super("./data/json/npcs/npc_definitions.json");
    }

    @Override
    public void load(JsonObject reader, Gson builder) {
        int index = reader.get("id").getAsInt();
        String name = Objects.toString(reader.get("name").getAsString());
        String description = Objects.toString(reader.get("examine").getAsString());
        int combatLevel = reader.get("combat").getAsInt();
        int size = reader.get("size").getAsInt();
        boolean attackable = reader.get("attackable").getAsBoolean();
        boolean aggressive = reader.get("aggressive").getAsBoolean();
        boolean retreats = reader.get("retreats").getAsBoolean();
        boolean poisonous = reader.get("poisonous").getAsBoolean();
        int respawnTime = reader.get("respawn").getAsInt();
        int maxHit = reader.get("maxHit").getAsInt();
        int hitpoints = reader.get("hitpoints").getAsInt();
        int attackSpeed = reader.get("attackSpeed").getAsInt();
        int attackAnim = reader.get("attackAnim").getAsInt();
        int defenceAnim = reader.get("defenceAnim").getAsInt();
        int deathAnim = reader.get("deathAnim").getAsInt();
        int attackBonus = reader.get("attackBonus").getAsInt();
        int meleeDefence = reader.get("defenceMelee").getAsInt();
        int rangedDefence = reader.get("defenceRange").getAsInt();
        int magicDefence = reader.get("defenceMage").getAsInt();

        NPCDefinition npc_def = NPCDefinition.forId(index);
        npc_def.setName(name);
        npc_def.setCombatLevel(combatLevel);
		npc_def.setDescription(description);
		npc_def.setAttackable(attackable);
		npc_def.setAggressive(aggressive);
		npc_def.setRetreats(retreats);
		npc_def.setPoisonous(poisonous);
        npc_def.setSize(size);
        npc_def.setSpeed(attackSpeed);
        npc_def.setHitpoints(hitpoints);
		npc_def.setMaxHit(maxHit);
		npc_def.setRespawnTime(respawnTime);
		npc_def.setAttackBonus(attackBonus);
		npc_def.setMeleeDefence(meleeDefence);
		npc_def.setRangedDefence(rangedDefence);
		npc_def.setMagicDefence(magicDefence);
        npc_def.setCombatAnimations(attackAnim, -1, -1, defenceAnim, deathAnim);

        if (attackAnim != 422) {
            count++;
            //System.out.println("Set combat animations for (" + index + ") " + NPCDefinition.forId(index).getName() + " : attackanim=" + attackAnim + " defenceanim=" + defenceAnim + " deathanim=" + deathAnim);
        }
        if (index == 7893) {
            //SystemLogger.log("Created " + count + " non humaniod combat animation definitions");
        }
    }
}