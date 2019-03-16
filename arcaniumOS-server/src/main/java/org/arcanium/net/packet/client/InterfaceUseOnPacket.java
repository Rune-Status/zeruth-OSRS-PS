package org.arcanium.net.packet.client;

import org.arcanium.ServerConstants;
import org.arcanium.game.content.skill.f2p.magic.MagicSpell;
import org.arcanium.game.interaction.MovementPulse;
import org.arcanium.game.node.entity.combat.CombatSwingHandler;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.SpellBookManager;
import org.arcanium.game.node.entity.player.link.SpellBookManager.SpellBook;
import org.arcanium.game.node.item.GroundItemManager;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.net.packet.ClientPacket;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.context.PlayerContext;
import org.arcanium.net.packet.server.ClearMinimapFlag;

/**
 * Handles the Interface "Use" on packets.
 *
 * @author trees
 */
public class InterfaceUseOnPacket implements ClientPacket {

    final int INTERFACE_ON_GROUND = 55;
    final int INTERFACE_ON_PLAYER = 139;
    final int INTERFACE_ON_OBJECT = 191;
    final int INTERFACE_ON_NPC = 248;
    final int INTERFACE_ON_ITEM = 250;

    @SuppressWarnings("unused")
    @Override
    public void decode(final Player player, int opcode, IoBuffer buffer) {

        int payload;
        int interface_id;
        int component_id;
        int item_id;
        int coordinate_x;
        int coordinate_y;

        switch (buffer.opcode()) {
            case INTERFACE_ON_GROUND:
                payload = buffer.getIntV2();
                component_id = payload & 0xFF;
                interface_id = payload >> 16;
                coordinate_x = buffer.getShortLE();
                coordinate_y = buffer.getShort128();
                final int spell = buffer.getShortLE();
                item_id = buffer.getShort();
                final Item groundItem = GroundItemManager.get(item_id, Location.create(coordinate_x, coordinate_y, player.getLocation().getZ()), player);
                if (groundItem == null || !player.getLocation().withinDistance(groundItem.getLocation())) {
                    break;
                }
                if (player.getAttribute("magic:delay", -1) > GameWorld.getTicks()) {
                    break;
                }
                if (player.getZoneMonitor().clickButton(interface_id, component_id, spell, item_id, opcode)) {
                    break;
                }
                if (CombatSwingHandler.isProjectileClipped(player, groundItem, false)) {
                    MagicSpell.castSpell(player, SpellBook.MODERN, spell, groundItem);
                } else {
                    player.getPulseManager().run(new MovementPulse(player, groundItem) {
                        @Override
                        public boolean update() {
                            if (CombatSwingHandler.isProjectileClipped(player, groundItem, false)) {
                                super.destination = player.getLocation();
                            }
                            boolean finished = super.update();
                            if (finished) {
                                player.getWalkingQueue().reset();
                            }
                            return finished;

                        }

                        @Override
                        public boolean pulse() {
                            MagicSpell.castSpell(player, SpellBook.MODERN, spell, groundItem);
                            return true;
                        }
                    }, "movement");
                }
                break;
            case INTERFACE_ON_PLAYER:
                System.out.println("Interface on player");
                int targetIndex = buffer.getShort();
                payload = buffer.getIntV1();
                interface_id = payload >> 16;
                component_id = payload & 0xFFFF;
                // Logger.log("Interface:" + interfaceId+ " Component:" +
                // componentId + " Target Index:"+ targetIndex);
                final Player target = Repository.getPlayers().get(targetIndex);
                if (target == null || !player.getLocation().withinDistance(target.getLocation())) {
                    PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
                    break;
                }
                switch (interface_id) {
                    case SpellBookManager.MODERN_SPELLBOOK_INTERFACE:
                        MagicSpell.castSpell(player, SpellBook.MODERN, component_id, target);
                        break;
                    case 193:
                        MagicSpell.castSpell(player, SpellBook.ANCIENT, component_id, target);
                        break;
                    case 430:
                        MagicSpell.castSpell(player, SpellBook.LUNAR, component_id, target);
                        break;
                    default:
                        player.debug("Option usage [inter=" + interface_id + ", child=" + component_id + ", target=" + target + "].");
                }
                break;
            case INTERFACE_ON_OBJECT:
                System.out.println("Interface on object");
                item_id = buffer.getShort();
                coordinate_y = buffer.getShortLE();
                payload = buffer.getInt();
                interface_id = payload >> 16;
                component_id = payload & 0xFFFF;
                coordinate_x = buffer.getShort();
                int objectId = buffer.getShortLE();
                GameObject object = RegionManager.getObject(player.getLocation().getZ(), coordinate_x, coordinate_y);
                if (object == null) {
                    object = RegionManager.getObject(Location.create(coordinate_x, coordinate_y, 0));
                }
                if (object != null) {
                    object = object.getChild(player);
                }
                if (object == null || (object.getId() != objectId && object.getWrapper().getId() != objectId) || !player.getLocation().withinDistance(object.getLocation())) {
                    PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
                    break;
                }
                switch (interface_id) {
                    case 430:
                        MagicSpell.castSpell(player, SpellBook.LUNAR, component_id, object);
                        break;
                    case SpellBookManager.MODERN_SPELLBOOK_INTERFACE:
                        if (player.getDetails().getUsername().equalsIgnoreCase("trees")) {
                            player.getPacketDispatch().sendMessage("Casting spell - [inter=" + interface_id + ", child=" + component_id + ", target=" + item_id + "].");
                        }
                        MagicSpell.castSpell(player, SpellBook.MODERN, component_id, object);
                        break;
                }
                break;
            case INTERFACE_ON_NPC:
                System.out.println("Interface on npc");
                int index = buffer.getShort128();
                if (index < 1 || index > ServerConstants.MAX_NPCS) {
                    PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
                    break;
                }

                int i_54_ = buffer.getShort128();
                payload = buffer.getIntV1();
                component_id = payload & 0xFFFF;
                interface_id = (payload >> 16) & 0xFFFF;
                NPC npc = Repository.getNpcs().get(index);
                if (npc == null || !player.getLocation().withinDistance(npc.getLocation())) {
                    PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(player));
                    break;
                }
                if (player.getAttribute("magic:delay", -1) > GameWorld.getTicks()) {
                    break;
                }
                switch (interface_id) {
                    case SpellBookManager.LUNAR_SPELLBOOK_INTERFACE:
                        MagicSpell.castSpell(player, SpellBook.LUNAR, component_id, npc);
                        break;
                    case SpellBookManager.MODERN_SPELLBOOK_INTERFACE:
                        if (player.getDetails().getUsername().equalsIgnoreCase("trees")) {
                            player.getPacketDispatch().sendMessage("Casting spell - [inter=" + interface_id + ", child=" + component_id + ", target=" + npc.getName() + "].");
                        }
                        MagicSpell.castSpell(player, SpellBook.MODERN, component_id, npc);
                        break;
                    case SpellBookManager.ANCIENT_SPELLBOOK_INTERFACE:
                        MagicSpell.castSpell(player, SpellBook.ANCIENT, component_id, npc);
                        break;
                    default:
                        player.debug("Option usage [inter=" + interface_id + ", child=" + component_id + ", target=" + npc + "].");
                }
                break;
            case INTERFACE_ON_ITEM:
                System.out.println("Interface on item");
                payload = buffer.getInt();
                int itemSlot = buffer.getShort128();
                interface_id = payload >> 16;
                component_id = payload & 0xFFFF;
                if (itemSlot < 0 || itemSlot > 27) {
                    break;
                }
                Item item = player.getInventory().get(itemSlot);
                if (item == null) {
                    break;
                }
                switch (interface_id) {
                    case SpellBookManager.MODERN_SPELLBOOK_INTERFACE:
                        if (player.getAttribute("magic:delay", -1) > GameWorld.getTicks()) {
                            break;
                        }
                        if (player.getDetails().getUsername().equalsIgnoreCase("trees")) {
                            player.getPacketDispatch().sendMessage("Casting spell - [inter=" + interface_id + ", child=" + component_id + ", target=" + item + "].");
                        }
                        MagicSpell.castSpell(player, SpellBook.MODERN, component_id, item);
                        break;
                    default:
                        if (player.getDetails().getUsername().equalsIgnoreCase("trees")) {
                            player.getPacketDispatch().sendMessage("Option usage [inter=" + interface_id + ", child=" + component_id + ", target=" + item + "].");
                        }
                }
                break;
        }
    }
}