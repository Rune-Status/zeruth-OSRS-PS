package org.arcanium.game.system.command;

import org.arcanium.ServerConstants;
import org.arcanium.cache.def.impl.ItemDefinition;
import org.arcanium.cache.def.impl.NPCDefinition;
import org.arcanium.game.component.Component;
import org.arcanium.game.container.impl.EquipmentContainer;
import org.arcanium.game.content.global.quest.Quest;
import org.arcanium.game.content.global.quest.QuestState;
import org.arcanium.game.content.skill.LevelUp;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.node.entity.combat.ImpactHandler.HitsplatType;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.info.Rights;
import org.arcanium.game.node.entity.player.link.TeleportManager;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.node.object.ObjectBuilder;
import org.arcanium.game.system.SystemLogger;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.map.Region;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.game.world.map.build.DynamicRegion;
import org.arcanium.game.world.update.flag.context.Graphics;

//sec

/**
 * Handles a player command.
 *
 * @author Vexia
 */
public final class PlayerCommands {

    /**
     * Gets an integer from the parameter
     *
     * @param args The parameters
     * @param slot The slot
     */
    private static int intParam(String[] args, int slot) {
        return Integer.parseInt(args[slot]);
    }

    public static boolean parse(Player player, String name, String[] arguments) {
        GameObject object = null;
        switch (name) {
            case "master":
                if (player.getDetails().getRights() != Rights.ADMINISTRATOR) {
                    if (player.inCombat() || player.getLocks().isInteractionLocked() || player.getSkullManager().isWilderness()) {
                        player.getPacketDispatch().sendMessage("You can't do that right now.");
                        return true;
                    }
                }
                for (int i = 0; i < Skills.SKILL_NAME.length; i++) {
                    player.getSkills().setLevel(i, 99);
                    player.getSkills().setStaticLevel(i, 99);
                }
                player.getSkills().updateCombatLevel();
                player.getAppearance().sync();
                LevelUp.levelup(player, 7);
                return true;
            case "damagetest":
                System.out.println("dmg");
                player.getImpactHandler().manualHit(player, 1, HitsplatType.NORMAL);
                return true;
            case "npc":
                final NPC npc = new NPC(Integer.parseInt(arguments[1]));
                npc.setLocation(player.getLocation());
                npc.init();
                return true;
            case "chatinterface":
                player.getInterfaceManager().openChatbox(Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]));

                if (Integer.parseInt(arguments[1]) == 270) {
                    //player.getPacketDispatch().sendString("Choose a quantity, then click an item to begin.", 270, 4);
                    player.getConfigManager().sendVarp(544, 1021);
                    player.getPacketDispatch().sendCS2Script(2379, new Object[]{});//
                    player.getPacketDispatch().sendCS2Script(2046, new Object[]{0, "What would you like to make?|15 arrow shafts|15 javelin shafts|Shortbow|Longbow|Crossbow stock|||||", 1, 52, 19584, 50, 48, 9440, -1, -1, -1, -1, -1, 1});//isiooooooooooi
                }
                return true;
            case "stroutfit":
                setMaxedMeleeStr(player);
                return true;
            case "varp":
                player.getConfigManager().sendVarp(Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]));
                return true;
            case "varbit":
                player.getVarBitManager().sendVarBit(Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]));
                return true;
            case "interface":
                player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, Integer.parseInt(arguments[1]), false);
                return true;
            case "yeet":
                player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 12, false);
                return true;
            case "pos":
            case "coords":
            case "loc":
                final Location l = player.getLocation();
                final Region r = player.getViewport().getRegion();
                player.getPacketDispatch().sendMessage("Absolute: " + l + ", regional: [" + l.getLocalX() + ", " + l.getLocalY() + "], chunk: [" + l.getChunkOffsetX() + ", " + l.getChunkOffsetY() + "], flag: [" + RegionManager.isTeleportPermitted(l) + ", " + RegionManager.getClippingFlag(l) + ", " + RegionManager.isLandscape(l) + "].");
                player.getPacketDispatch().sendMessage("Region: [id=" + l.getRegionId() + ", active=" + r.isActive() + ", instanced=" + ((r instanceof DynamicRegion)) + "], obj=" + RegionManager.getObject(l) + ".");
                player.getPacketDispatch().sendMessage("Object: " + RegionManager.getObject(l) + ".");
                SystemLogger.log("Viewport: " + l.getSceneX(player.getPlayerFlags().getLastSceneGraph()) + "," + l.getSceneY(player.getPlayerFlags().getLastSceneGraph()));
                SystemLogger.log("Location.create(" + l.getX() + ", " + l.getY() + ", " + l.getZ() + "), " + player.getPlayerFlags().getLastSceneGraph() + ", " + l.getLocalX() + ", " + l.getLocalY());
                return true;
            case "skull":
                player.getSkullManager().setSkullIcon(Integer.parseInt(arguments[1]));
                return true;
            case "hi":
                player.getAppearance().setHeadIcon(Integer.parseInt(arguments[1]));
                player.getAppearance().sync();
                return true;
            case "object":
            case "obj":
                if (arguments.length < 2) {
                    player.debug("syntax error: id (optional) type rotation or rotation");
                    return true;
                }
                object = arguments.length > 3 ? new GameObject(Integer.parseInt(arguments[1]), player.getLocation(), Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3])) : arguments.length == 3 ? new GameObject(Integer.parseInt(arguments[1]), player.getLocation(), Integer.parseInt(arguments[2])) : new GameObject(Integer.parseInt(arguments[1]), player.getLocation());
                ObjectBuilder.add(object);
                SystemLogger.log("object = " + object);
                return true;
            case "pnpc":
                if (arguments.length < 2) {
                    player.debug("syntax error: id");
                    return true;
                }
                player.getAppearance().transformNPC(Integer.parseInt(arguments[1]));
                return true;
            case "npcn":
                if (arguments.length < 2) {
                    player.debug("syntax error: item-name (optional) amount");
                    return true;
                }
                String params1 = "";
                for (int i = 1; i < arguments.length; i++) {
                    params1 += i == arguments.length - 1 ? arguments[i] : arguments[i] + " ";
                }
                for (int i = 0; i < NPCDefinition.getDefinitions().size(); i++) {
                    NPCDefinition def1 = NPCDefinition.forId(i);
                    if (def1 != null && def1.getName().equalsIgnoreCase(params1.toLowerCase())) {
                        final NPC npc1 = new NPC(def1.getId());
                        npc1.setLocation(player.getLocation());
                        npc1.init();
                        player.getPacketDispatch().sendMessage("[npc=" + def1.getId() + ", " + def1.getName() + "].");
                        break;
                    }
                }
                return true;
            case "anim":
                player.getPacketDispatch().sendAnimation(Integer.parseInt(arguments[1]));
                return true;
            case "gfx":
                player.getPacketDispatch().sendPositionedGraphics(new Graphics(Integer.parseInt(arguments[1]), 0, 92), player.getLocation());
                return true;
            case "empty":
                for (Item i : player.getInventory().toArray()) {
                    if (i == null) {
                        continue;
                    }
                    player.getInventory().remove(i);
                }
                player.getInventory().refresh();
                return true;
            case "interfacetest":
                player.getPacketDispatch().sendCS2Script(2524, new Object[]{-1, -1});//ii
                player.getPacketDispatch().sendInterface(player.getInterfaceManager().getWindowsPane(), 21, 237, false);
                player.getPacketDispatch().sendCS2Script(799, new Object[]{118, "Ores and Bars"});//vs
                return true;
            case "item":
                int amount = (arguments.length < 3) ? 1 : Integer.parseInt(arguments[2]);
                player.getInventory().add(new Item(Integer.parseInt(arguments[1]), amount));
                return true;
            case "itemn":
                if (arguments.length < 2) {
                    player.debug("syntax error: item-name (optional) amount");
                    return true;
                }
                String params = "";
                for (int i = 1; i < arguments.length; i++) {
                    params += i == arguments.length - 1 ? arguments[i] : arguments[i] + " ";
                }
                for (int i = 0; i < ItemDefinition.getDefinitions().size(); i++) {
                    ItemDefinition def1 = ItemDefinition.forId(i);
                    if (def1 != null && def1.getName().equalsIgnoreCase(params.toLowerCase())) {
                        player.getInventory().add(new Item(i, 1));
                        player.getPacketDispatch().sendMessage("[item=" + def1.getId() + ", " + def1.getName() + "].");
                        break;
                    }
                }
                return true;
            case "to":
                if (player.getDetails().getRights() != Rights.ADMINISTRATOR) {
                    if (player.inCombat() || player.getLocks().isTeleportLocked()) {
                        player.getPacketDispatch().sendMessage("You can't teleport right now.");
                        return true;
                    }
                }
                Location destination = null;
                String place = getArgumentLine(arguments);
                for (Object[] data : ServerConstants.TELEPORT_DESTINATIONS) {
                    for (int i = 1; i < data.length; i++) {
                        if (place.equals(data[i])) {
                            destination = (Location) data[0];
                            break;
                        }
                    }
                }
                if (destination != null) {
                    player.getTeleporter().send(destination, TeleportManager.TeleportType.NORMAL);
                } else {
                    player.getPacketDispatch().sendMessage("Could not locate teleport destination [name=" + place + "]!");
                }
                return true;
            case "tele":
                if (arguments.length <= 2) {
                    player.debug("syntax error: x, y, (optional) z");
                    return false;
                }
                player.getProperties().setTeleportLocation(Location.create(Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]), arguments.length > 3 ? Integer.parseInt(arguments[3]) : 0));
                return true;
            case "teler": // Teleports to the center of the region.
                int regionId = Integer.parseInt(arguments[1]);
                int regx = 32;
                int regy = 32;
                if (arguments.length > 3) {
                    regx = intParam(arguments, 2);
                    regy = intParam(arguments, 3);
                }
                player.getProperties().setTeleportLocation(Location.create(((regionId >> 8) << 6) + regx, ((regionId & 0xFF) << 6) + regy, 0));
                player.debug("Current location=" + player.getProperties().getTeleportLocation());
                return true;
            case "telers": // Teleports to the start of the region.
                regionId = Integer.parseInt(arguments[1]);
                player.getProperties().setTeleportLocation(Location.create(((regionId >> 8) << 6), ((regionId & 0xFF) << 6), 0));
                player.debug("Current location=" + player.getProperties().getTeleportLocation());
                return true;
            case "telere": // Teleports to the end of the region.
                regionId = Integer.parseInt(arguments[1]);
                player.getProperties().setTeleportLocation(Location.create(((regionId >> 8) << 6) + 63, ((regionId & 0xFF) << 6) + 63, 0));
                player.debug("Current location=" + player.getProperties().getTeleportLocation());
                return true;
            case "telecs": // Client ctrl+shift teleport
                try {
                    Location loc = player.getPlayerFlags().getLastSceneGraph();
                    int x = ((loc.getRegionX() - 6) << 3) + Integer.parseInt(arguments[1]);
                    int y = ((loc.getRegionY() - 6) << 3) + Integer.parseInt(arguments[2]);
                    player.getPulseManager().clear();
                    player.getProperties().setTeleportLocation(Location.create(x, y, player.getLocation().getZ()));
                } catch (Throwable t) {
                    // region is changing
                    t.printStackTrace();
                }
                return true;
        }
        return false;

    }

    /**
     * Sends commands.
     *
     * @param player the player.
     */
    private void sendCommands(Player player) {
        if (player.getInterfaceManager().isOpened()) {
            player.sendMessage("Finish what you're currently doing.");
            return;
        }
        player.getInterfaceManager().close();
        player.getPacketDispatch().sendString("<u>" + GameWorld.getName() + " commands</u>", 239, 1);
        player.getPacketDispatch().sendString("::filter (completely toggles game messages)<br>::players (shows player count)<br>::doublexp (claims double xp)<br>::shop opens up a dialogue so you can use credits<br>::togglenews toggles the news broadcasts.", 239, 2);
        player.getPacketDispatch().sendString("", 239, 3);
        player.getPacketDispatch().sendString("", 239, 4);
        player.getPacketDispatch().sendString("", 239, 5);
        player.getInterfaceManager().openComponent(239);
    }

    /**
     * Sends the quests.
     *
     * @param player the player.
     */
    private void sendQuests(Player player) {
        player.getInterfaceManager().open(new Component(275));
        for (int i = 0; i < 257; i++) {
            player.getPacketDispatch().sendString("", 275, i);
        }
        String red = "<col=8A0808>";
        player.getPacketDispatch().sendString("<col=8A0808>" + "Quests" + "</col>", 275, 2);
        StringBuilder builder = new StringBuilder("");
        for (Quest q : player.getQuestRepository().getQuests().values()) {
            if (q.isInDevelopment()) {
                continue;
            }
            boolean completed = q.getState().equals(QuestState.COMPLETED);
            builder.append(completed ? red + "<str> " + q.getName() + " <br><br>" : red + " " + q.getName() + " <br><br>");
        }
        player.getPacketDispatch().sendString(builder.toString(), 275, 4);
    }

    /**
     * Gets the yell prefix for the given player.
     *
     * @param player The player.
     * @return The prefix used in yell.
     */
    private static String getYellPrefix(Player player) {
        String color = "<col=800080>";
        StringBuilder sb = new StringBuilder("[");
        if (player.getDetails().getRights().isVisible(player)) {
            Rights right = player.getAttribute("visible_rank", player.getDetails().getRights());
            switch (right) {
                case ADMINISTRATOR:
                    color = "<col=FFFF00>";
                    break;
                case PLAYER_MODERATOR:
                    color = "<col=81819B>";
                    break;
                default:
                    break;
            }
        }
        if (player.isDonator() && !player.isStaff()) {
            color = "<col=" + player.getDonatorType().getColor() + ">";
        }
        int icon = Rights.getChatIcon(player);
        if (icon > 0) {
            sb.append("<img=").append(icon - 1).append(">");
        }
        sb.append(color).append(player.getUsername()).append("</col>");
        sb.append("]: ").append(color);
        return sb.toString();
    }


    /**
     * Gets the argument line from the given arguments.
     *
     * @param args   The arguments.
     * @param offset The start index.
     * @param length The end index.
     * @return the line.
     */
    public static String getArgumentLine(String[] args, int offset, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = offset; i < length; i++) {
            if (i != offset) {
                sb.append(" ");
            }
            sb.append(args[i]);
        }
        return sb.toString();
    }

    /**
     * Gets the argument line (starting at index 1).
     *
     * @param args The arguments.
     * @return The argument line.
     */
    public static String getArgumentLine(String[] args) {
        return getArgumentLine(args, 1, args.length);
    }

    /**
     * Sets the player's armour to maximize melee strength.
     *
     * @param player The player.
     */
    public static void setMaxedMeleeStr(Player player) {
        player.getEquipment().replace(new Item(12931), EquipmentContainer.SLOT_HAT);
        player.getEquipment().replace(new Item(21295), EquipmentContainer.SLOT_CAPE);
        player.getEquipment().replace(new Item(19553), EquipmentContainer.SLOT_AMULET);
        player.getEquipment().replace(new Item(20368), EquipmentContainer.SLOT_WEAPON);
        player.getEquipment().replace(null, EquipmentContainer.SLOT_SHIELD);
        player.getEquipment().replace(new Item(10551), EquipmentContainer.SLOT_CHEST);
        player.getEquipment().replace(new Item(11834), EquipmentContainer.SLOT_LEGS);
        player.getEquipment().replace(new Item(7462), EquipmentContainer.SLOT_HANDS);
        player.getEquipment().replace(new Item(6737), EquipmentContainer.SLOT_RING);
        player.getEquipment().replace(new Item(11840), EquipmentContainer.SLOT_FEET);
    }
}
