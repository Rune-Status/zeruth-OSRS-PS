package org.arcanium.cache.def;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.arcanium.cache.def.impl.NPCDefinition;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.world.map.Direction;
import org.arcanium.game.world.map.Location;

import java.util.Objects;


/**
 * The {@link JsonLoader} implementation that loads all npc nodes.
 *
 * @author lare96 <http://github.com/lare96>
 * @author trees
 */
public final class NpcNodeLoader extends JsonLoader {

    /**
     * Creates a new {@link NpcNodeLoader}.
     */
    public NpcNodeLoader() {
        super("./data/json/npcs/npc_nodes.json");
    }

    private static void addNpc(NPC npc) {
        npc.init();
    }

    int slot = 0;

    public void load(JsonObject reader, Gson builder) {
        spawns = new NpcNodeLoader[10000];
        int id = reader.get("id").getAsInt();
        Location position = Objects.requireNonNull(builder.fromJson(reader.get("position").getAsJsonObject(), Location.class));
        int height = Objects.requireNonNull(builder.fromJson(reader.get("position").getAsJsonObject(), Location.class).getZ());
        String facing = reader.get("facing").getAsString();
        int radius = reader.get("radius").getAsInt();
        NPCDefinition definition = NPCDefinition.forId(id);
        final NPC npc = new NPC(definition.getId());
        spawns[slot] = new NpcNodeLoader();
        Location location = Location.create(position.getX(), position.getY(), height);
        npc.setLocation(location);
        npc.setDirection(getDirection(facing));
        npc.setWalkRadius(radius);
        npc.setAttribute("spawned:npc", true);
        addNpc(npc);
        slot++;
    }

    public Direction getDirection(String facing) {
        Direction dir = Direction.SOUTH;
        if (facing.equals("NORTH")) {
            dir = Direction.NORTH;
        } else if (facing.equals("EAST")) {
            dir = Direction.EAST;
        } else if (facing.equals("WEST")) {
            dir = Direction.WEST;
        }
        return dir;
    }

    /**
     * The spawn definitions
     */
    public static NpcNodeLoader[] spawns = null;

    public static NpcNodeLoader forId(int id) {
        NpcNodeLoader d = spawns[id];
        if (d == null) {
            d = new NpcNodeLoader();
        }
        return d;
    }

    /**
     * The npc id
     */
    private int id;

    /**
     * The spawn x axis
     */
    private int x;

    /**
     * The spawn y axis
     */
    private int y;

    /**
     * The spawn heightLevel
     */
    private byte height;

    /**
     * Should npc walk
     */
    private boolean canWalk = true;

    /**
     * How far before npc begins to walk home.
     */
    private byte followRange = 5;

    @SuppressWarnings("unchecked")
    /**
     * Gets the npc id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the x axis
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y axis
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the height
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the walking type
     *
     * @return the walk
     */
    public boolean shouldWalk() {
        return canWalk;
    }

    /**
     * True to walk; false to not.
     *
     * @param walk
     */
    public void setWalking(boolean walk) {
        this.canWalk = walk;
    }

    public Location getMaximum() {
        return Location.create(x + 2, y + 2, getHeight());
    }

    public Location getMinimum() {
        return Location.create(x - 2, y - 2, getHeight());
    }

    public int getFollowRange() {
        return followRange;
    }

    public void setFollowRange(int followRange) {
        this.followRange = (byte) followRange;
    }


    public static int getSpawnsSize() {
        return spawns.length;
    }

    public static NpcNodeLoader[] getSpawns() {
        return spawns;
    }


}
