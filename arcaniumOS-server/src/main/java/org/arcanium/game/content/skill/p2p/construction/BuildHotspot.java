package org.arcanium.game.content.skill.p2p.construction;

/**
 * Represents a building hotspot.
 * @author Emperor
 */
public enum BuildHotspot {

    /**
     * Low level garden hotspots.
     */
    GARDEN_CENTREPIECE_1(15361, Decoration.PORTAL, Decoration.ROCK, Decoration.POND, Decoration.IMP_STATUE, Decoration.DUNGEON_ENTRANCE), GARDEN_BIG_TREE_1(15362, Decoration.BIG_DEAD_TREE, Decoration.BIG_TREE, Decoration.BIG_OAK_TREE, Decoration.BIG_WILLOW_TREE, Decoration.BIG_MAPLE_TREE, Decoration.BIG_YEW_TREE, Decoration.BIG_MAGIC_TREE), GARDEN_TREE_1(15363, Decoration.DEAD_TREE, Decoration.TREE, Decoration.OAK_TREE, Decoration.WILLOW_TREE, Decoration.MAPLE_TREE, Decoration.YEW_TREE, Decoration.MAGIC_TREE), GARDEN_SMALL_PLANTSPACE_1(15366, Decoration.PLANT, Decoration.SMALL_FERN, Decoration.FERN), GARDEN_SMALL_PLANTSPACE_2(15367, Decoration.DOCK_LEAF, Decoration.THISTLE, Decoration.REEDS), GARDEN_BIG_PLANTSPACE_1(15364, Decoration.FERN, Decoration.BUSH, Decoration.TALL_PLANT), GARDEN_BIG_PLANTSPACE_2(15365, Decoration.SHORT_PLANT, Decoration.LARGE_LEAF_PLANT, Decoration.HUGE_PLANT),

    /**
     * Parlour spots
     */
    PARLOUR_CHAIRSPACE_1(15410, Decoration.CRUDE_CHAIR, Decoration.WOODEN_CHAIR, Decoration.ROCKING_CHAIR, Decoration.OAK_CHAIR, Decoration.OAK_ARMCHAIR, Decoration.TEAK_ARMCHAIR, Decoration.MAHOGANY_ARMCHAIR), PARLOUR_CHAIRSPACE_2(15411, Decoration.CRUDE_CHAIR, Decoration.WOODEN_CHAIR, Decoration.ROCKING_CHAIR, Decoration.OAK_CHAIR, Decoration.OAK_ARMCHAIR, Decoration.TEAK_ARMCHAIR, Decoration.MAHOGANY_ARMCHAIR), PARLOUR_CHAIRSPACE_3(15412, Decoration.CRUDE_CHAIR, Decoration.WOODEN_CHAIR, Decoration.ROCKING_CHAIR, Decoration.OAK_CHAIR, Decoration.OAK_ARMCHAIR, Decoration.TEAK_ARMCHAIR, Decoration.MAHOGANY_ARMCHAIR), PARLOUR_FIREPLACESPACE(15418, Decoration.CLAY_FIREPLACE, Decoration.STONE_FIREPLACE, Decoration.MARBLE_FIREPLACE), PARLOUR_RUG_SPACE(15413, Decoration.BROWN_RUG, Decoration.RED_RUG, Decoration.OPULENT_RUG), PARLOUR_CURTAIN(15419, Decoration.TORN_CURTAINS, Decoration.CURTAINS, Decoration.OPULENT_CURTAINS), PARLOUR_BOOKCASE(15416, Decoration.WOODEN_BOOKCASE, Decoration.OAK_BOOKCASE, Decoration.MAHOGANY_BOOKCASE),

    /**
     * Kitchen hotspots
     */
    KITCHEN_TABLE_SPACE(15405, Decoration.KITCHEN_WOODEN_TABLE, Decoration.KITCHEN_OAK_TABLE, Decoration.KITCHEN_TEAK_TABLE), KITCHEN_CAT_SPACE(15402, Decoration.CAT_BLANKET, Decoration.CAT_BASKET, Decoration.CAST_BASKET_CUSHIONED), KITCHEN_STOVE(15398, Decoration.BASIC_FIREPIT, Decoration.FIREPIT_WITH_HOOK, Decoration.FIREPIT_WITH_POT, Decoration.SMALL_OVEN, Decoration.LARGE_OVEN, Decoration.BASIC_RANGE, Decoration.FANCY_RANGE), KITCHEN_SINK(15404, Decoration.PUMP_AND_TUB, Decoration.PUMP_AND_DRAIN, Decoration.SINK), KITCHEN_LARDER(15403, Decoration.WOODEN_LARDER, Decoration.OAK_LARDER, Decoration.TEAK_LARDER), KITCHEN_BARRELS(15401, Decoration.BASIC_BEER_BARREL, Decoration.CIDER_BARREL, Decoration.ASGARNIAN_ALE_BARREL, Decoration.GREENMANS_ALE_BARREL, Decoration.DRAGON_BITTER_BARREL, Decoration.CHEFS_DELIGHT_BARREL), KITCHEN_SHELVES(15400, Decoration.WOODEN_SHELVES_1, Decoration.WOODEN_SHELVES_2, Decoration.WOODEN_SHELVES_3, Decoration.OAK_SHELVES_1, Decoration.OAK_SHELVES_2, Decoration.TEAK_SHELVES_1, Decoration.TEAK_SHELVES_2),

    /**
     * The dining room hotspots
     */
    DINING_TABLE_SPACE(15298, Decoration.DINING_TABLE_WOOD, Decoration.DINING_TABLE_OAK, Decoration.DINING_TABLE_CARVED_OAK, Decoration.DINING_TABLE_TEAK, Decoration.DINING_TABLE_CARVED_TEAK, Decoration.DINING_TABLE_MAHOGANY, Decoration.DINING_TABLE_OPULENT), DINING_ROOM_FIREPLACE(15301, Decoration.CLAY_FIREPLACE, Decoration.STONE_FIREPLACE, Decoration.MARBLE_FIREPLACE), DINING_ROOM_BELLPULL(15304, Decoration.ROPE_PULL, Decoration.BELL_PULL, Decoration.FANCY_BELL_PULL), DINING_ROOM_SEATING(15299, Decoration.BENCH_WOODEN, Decoration.BENCH_OAK, Decoration.BENCH_CARVED_OAK, Decoration.BENCH_TEAK, Decoration.BENCH_CARVED_TEAK, Decoration.BENCH_MAHOGANY, Decoration.BENCH_GILDED),
    
    /**
     * The Workshop hotspots
     */
    WORKSHOP_WORKBENCH_SPACE(15439, Decoration.WORKBENCH_WOODEN),

    /**
     * The bedroom hotspots
     */
    BEDROOM_BED_SPACE(15260, Decoration.WOODEN_BED),

    /**
     * The skill hall hotspots
     */
    SKILL_HALL_TROPHY_SPACE(15382, Decoration.CRAWLING_HAND),

    /**
     * The games room hotspots
     */
    GAMES_STONE_SPACE(15344, Decoration.CLAY_ATTACK_STONE),

    /**
     * The combat room hotspots
     */
    COMBAT_ROOM_STORAGE_SPACE(15296, Decoration.GLOVE_RACK),

    /**
     * The quest hall hotspots
     */
    QUEST_HALL_BOOKCASE(15397, Decoration.WOODEN_BOOKCASE),

    /**
     * The study hotspots //TODO asdfasdf
     */
    STUDY_LECTERN_SPACE(15420, Decoration.OAK_LECTERN),

    /**
     * The costume room hotspots
     */
    COSTUME_FANCY_DRESS_BOX(18814, Decoration.OAK_COSTUME_BOX),

    /**
     * The chapel room hotspots
     */
    CHAPEL_ALTAR_SPACE(15270, Decoration.OAK_ALTAR),

    /**
     * The chapel room hotspots
     */
    PORTAL_CHAMBER_CENTREPIECE_SPACE(15409),

    ;

    /**
     * The object id.
     */
    private final int objectId;

    /**
     * The decorations to build on this hotspot.
     */
    private final Decoration[] decorations;

    /**
     * Constructs a new {@code BuildHotspot} {@code Object}.
     * @param objectId The object id.
     * @param decorations The decoration.
     */
    private BuildHotspot(int objectId, Decoration... decorations) {
	this.objectId = objectId;
	this.decorations = decorations;
    }

    /**
     * Gets the building hotspot for the given object id.
     * @param id The object id.
     * @return The building hotspot.
     */
    public static BuildHotspot forId(int id) {
	for (BuildHotspot spot : values()) {
	    if (spot.getObjectId() == id) {
		return spot;
	    }
	}
	return null;
    }

    /**
     * Gets the decoration index.
     * @param deco The decoration.
     * @return The index.
     */
    public int getDecorationIndex(Decoration deco) {
	for (int i = 0; i < decorations.length; i++) {
	    if (decorations[i] == deco) {
		return i;
	    }
	}
	return -1;
    }

    /**
     * Gets the objectId.
     * @return The objectId.
     */
    public int getObjectId() {
	return objectId;
    }

    /**
     * Gets the decorations.
     * @return The decorations.
     */
    public Decoration[] getDecorations() {
	return decorations;
    }
}