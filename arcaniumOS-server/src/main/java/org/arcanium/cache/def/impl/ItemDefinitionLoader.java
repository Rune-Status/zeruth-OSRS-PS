package org.arcanium.cache.def.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.arcanium.cache.def.JsonLoader;
import org.arcanium.game.world.update.flag.context.Animation;
import org.arcanium.parser.item.ItemConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The {@link JsonLoader} implementation that loads all osrs item definitions.
 *
 * @author trees (www.rune-server.ee/members/trees)>
 */
public final class ItemDefinitionLoader extends JsonLoader {

    /**
     * The players equipment slots
     */
    final int HELMET_SLOT = 0;
    final int CAPE_SLOT = 1;
    final int AMULET_SLOT = 2;
    final int WEAPON_SLOT = 3;
    final int PLATEBODY_SLOT = 4;
    final int SHIELD_SLOT = 5;
    final int LEGS_SLOT = 7;
    final int GLOVES_SLOT = 9;
    final int BOOTS_SLOT = 10;
    final int RING_SLOT = 12;
    final int ARROW_SLOT = 13;

    /**
     * Creates a new {@link ItemDefinitionLoader}.
     */
    public ItemDefinitionLoader() {
        super("./data/json/items/inferno_item_definitions.json");
    }

    @Override
    public void load(JsonObject reader, Gson builder) {

        /**
         * Reader
         */
        int index = reader.get("id").getAsInt();
        String name = Objects.requireNonNull(reader.get("name").getAsString());
        String examine = Objects.requireNonNull(reader.get("examine").getAsString());
        String equipmentType = Objects.requireNonNull(reader.get("equipmentType").getAsString());
        boolean twohanded = reader.get("doubleHanded").getAsBoolean();
        boolean stackable = reader.get("stackable").getAsBoolean();
        boolean dropable = reader.get("dropable").getAsBoolean();
        boolean sellable = reader.get("sellable").getAsBoolean();
        boolean noted = reader.get("noted").getAsBoolean();
        int value = reader.get("value").getAsInt();
        int specialPrice = reader.get("specialPrice") != null ? reader.get("specialPrice").getAsInt() : -1;
        int highAlch = reader.get("highAlch").getAsInt();
        int lowAlch = reader.get("lowAlch").getAsInt();
        int dropValue = reader.get("dropValue").getAsInt();
        int noteId = reader.get("noteId").getAsInt();
        int attackAnim = reader.get("attackAnim") != null ? reader.get("attackAnim").getAsInt() : -1;
        int blockAnim = reader.get("blockAnim").getAsInt();
        int standAnim = reader.get("standAnim").getAsInt();
        int walkAnim = reader.get("walkAnim").getAsInt();
        int runAnim = reader.get("runAnim").getAsInt();
        int standTurnAnim = reader.get("standTurnAnim").getAsInt();
        int turn180Anim = reader.get("turn180Anim").getAsInt();
        int turn90CWAnim = reader.get("turn90CWAnim").getAsInt();
        int turn90CCWAnim = reader.get("turn90CCWAnim").getAsInt();

        double weight = reader.get("weight").getAsDouble();
        double[] bonus = reader.get("bonuses") == null ? null : builder.fromJson(reader.get("bonuses").getAsJsonArray(), double[].class);
        int[] requirements = reader.get("requirements") == null ? null : builder.fromJson(reader.get("requirements").getAsJsonArray(), int[].class);

        /**
         * Builder; Overwrites
         */
        ItemDefinition item = ItemDefinition.forId(index);
        item.setValue(value);
        item.setName(name);
        item.setExamine(examine);
        item.getConfigurations().put(ItemConfiguration.EXAMINE, examine);
        item.setStackable(stackable);

        item.getConfigurations().remove(ItemConfiguration.EQUIP_SLOT);
        item.getConfigurations().remove(ItemConfiguration.REMOVE_HEAD);
        item.getConfigurations().remove(ItemConfiguration.REMOVE_BEARD);
        item.getConfigurations().remove(ItemConfiguration.REMOVE_SLEEVES);

        switch (equipmentType) {
            case "HELMET":
                item.getConfigurations().put(ItemConfiguration.REMOVE_HEAD, false);
                item.getConfigurations().put(ItemConfiguration.REMOVE_BEARD, false);
                item.getConfigurations().put(ItemConfiguration.EQUIP_SLOT, HELMET_SLOT);
                break;
            case "FULLHELMET":
                item.getConfigurations().put(ItemConfiguration.REMOVE_HEAD, true);
                item.getConfigurations().put(ItemConfiguration.REMOVE_BEARD, true);
                item.getConfigurations().put(ItemConfiguration.EQUIP_SLOT, HELMET_SLOT);
                break;
            case "CAPE":
                item.getConfigurations().put(ItemConfiguration.EQUIP_SLOT, CAPE_SLOT);
                break;
            case "AMULET":
                item.getConfigurations().put(ItemConfiguration.EQUIP_SLOT, AMULET_SLOT);
                break;
            case "WEAPON":
                item.getConfigurations().put(ItemConfiguration.EQUIP_SLOT, WEAPON_SLOT);
                break;
            case "PLATEBODY":
                item.getConfigurations().put(ItemConfiguration.EQUIP_SLOT, PLATEBODY_SLOT);
                item.getConfigurations().put(ItemConfiguration.REMOVE_SLEEVES, true);
                break;
            case "SHIELD":
                item.getConfigurations().put(ItemConfiguration.EQUIP_SLOT, SHIELD_SLOT);
                break;
            case "LEGS":
                item.getConfigurations().put(ItemConfiguration.EQUIP_SLOT, LEGS_SLOT);
                break;
            case "GLOVES":
                item.getConfigurations().put(ItemConfiguration.EQUIP_SLOT, GLOVES_SLOT);
                break;
            case "RING":
                item.getConfigurations().put(ItemConfiguration.EQUIP_SLOT, RING_SLOT);
                break;
            case "ARROWS":
                item.getConfigurations().put(ItemConfiguration.EQUIP_SLOT, ARROW_SLOT);
                break;
            case "BOOTS":
                item.getConfigurations().put(ItemConfiguration.EQUIP_SLOT, BOOTS_SLOT);
                break;
        }

        if (requirements != null) {
            Map<Integer, Integer> reqs;
            for (int i = 0; i < requirements.length; i++) {
                if (requirements[i] > 0) {
                    item.getConfigurations().put(ItemConfiguration.REQUIREMENTS, reqs = new HashMap<>());
                    reqs.put(i, requirements[i]);
                }
            }
        }

        if (bonus != null) {
            int[] bonuses = new int[13];
            for (int i = 0; i < bonuses.length; i++) {
                bonuses[i] = (int) bonus[i];
                item.getConfigurations().put(ItemConfiguration.BONUS, bonuses);
            }
        }

        item.getConfigurations().put(ItemConfiguration.GE_PRICE, value);
        item.getConfigurations().put(ItemConfiguration.WEIGHT, weight);
        item.getConfigurations().put(ItemConfiguration.EXAMINE, examine);
        item.getConfigurations().put(ItemConfiguration.TWO_HANDED, twohanded);

        item.getConfigurations().put(ItemConfiguration.ATTACK_ANIMS, new Animation[]{Animation.create(attackAnim)});
        item.getConfigurations().put(ItemConfiguration.STAND_ANIM, standAnim);
        item.getConfigurations().put(ItemConfiguration.STAND_TURN_ANIM, standTurnAnim);
        item.getConfigurations().put(ItemConfiguration.RUN_ANIM, runAnim);
        item.getConfigurations().put(ItemConfiguration.WALK_ANIM, walkAnim);
    }
}