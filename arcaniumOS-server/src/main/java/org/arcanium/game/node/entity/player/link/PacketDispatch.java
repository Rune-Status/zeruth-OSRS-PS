package org.arcanium.game.node.entity.player.link;

import lombok.val;
import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.system.task.Pulse;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.game.world.update.flag.chunk.AnimateObjectUpdateFlag;
import org.arcanium.game.world.update.flag.context.Animation;
import org.arcanium.game.world.update.flag.context.Graphics;
import org.arcanium.game.world.update.flag.player.AnimationFlag;
import org.arcanium.game.world.update.flag.player.GraphicFlag;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.net.packet.PacketRepository;
import org.arcanium.net.packet.ServerProt;
import org.arcanium.net.packet.context.*;
import org.arcanium.net.packet.server.*;
import org.arcanium.net.packet.server.zone.UpdateZonePartialFollows;

/**
 * Represents the class used to dispatching packets.
 *
 * @author Emperor
 * @author Vexia
 */
public final class PacketDispatch {

    /**
     * The instance of the {@code Player}.
     */
    private final Player player;

    /**
     * The player context.
     */
    private final PlayerContext context;

    /**
     * Constructs a new {@code PacketDispatch} {@code Object}.
     *
     * @param player the player.
     */
    public PacketDispatch(Player player) {
        this.player = player;
        this.context = new PlayerContext(player);
    }

    /**
     * Send a game message.
     *
     * @param message The game message.
     */
    public void sendMessage(String message) {
        if (message == null) {
            return;
        }
        if (player.getAttribute("chat_filter") != null && !message.contains("<col=CC6600>") && !message.contains("<col=FFFF00>")) {
            return;
        }
        if (message.length() > 255) {
            System.err.println("Message length out of bounds (" + message + ")!");
            message = message.substring(0, 255);
        }
        PacketRepository.send(GameMessage.class, new GameMessageContext(player, message));
    }

    public void sendInterface(int root, int child, int interfaceId, boolean clickable) {
        PacketRepository.send(Interface.class, new InterfaceContext(player, root, child, interfaceId, clickable));
    }

    public void sendInterfaceSettings(int root, int component, int from, int to, int settings) {
        sendAccessMask(settings, component, root, from, to);
    }

    public void sendCS2Script(int id, Object[] params) {
        sendRunScript(id, getDescriptor(params), params);
    }

    public void sendInterfaceSet(int fromRoot, int fromChild, int toRoot, int toChild) {
        PacketRepository.send(InterfaceSet.class, new InterfaceSetContext(player, fromRoot, fromChild, toRoot, toChild));
    }

    public static String getDescriptor(Object[] params) {
        String desc = "";
        if (params == null) {
            return "";
        }
        for (int index = 0; index < params.length; index++) {
            if (params[index] instanceof String) {
                desc += "s";
            } else {
                desc += "i";
            }
        }
        return desc;
    }

    /**
     * Sends game messages.
     *
     * @param messages the messages.
     */
    public void sendMessages(final String... messages) {
        for (String message : messages) {
            sendMessage(message);
        }
    }

    /**
     * Method used to send a game message on a tick.
     *
     * @param message the message.
     * @param ticks   the ticks.
     */
    public void sendMessage(final String message, int ticks) {
        GameWorld.submit(new Pulse(ticks, player) {
            @Override
            public boolean pulse() {
                sendMessage(message);
                return true;
            }
        });
    }

    /**
     * Send a access mask.
     *
     * @param id          The access mask id.
     * @param childId     The access mask child id.
     * @param interfaceId The access mask interface Id.
     * @param offset      The access mask off set.
     * @param length      The access mask length.
     */
    public void sendAccessMask(int id, int childId, int interfaceId, int offset, int length) {
        PacketRepository.send(AccessMask.class, new AccessMaskContext(player, id, childId, interfaceId, offset, length));
    }

    /**
     * Send a windowns pane.
     *
     * @param windowId The windows pane id.
     * @param type     The windowns pane type.
     */
    public void sendWindowsPane(int windowId, int type) {
        PacketRepository.send(WindowsPane.class, new WindowsPaneContext(player, windowId));
    }

    public void sendWindowsPane(int windowId) {
        PacketRepository.send(WindowsPane.class, new WindowsPaneContext(player, windowId));
    }

    /**
     * sends the system update packet.
     *
     * @param time the amount of time.
     */
    public void sendSystemUpdate(int time) {
        PacketRepository.send(SystemUpdatePacket.class, new SystemUpdateContext(player, time));
    }

    /**
     * Sends music packet.
     *
     * @param musicId The music id.
     */
    public void sendMusic(int musicId) {
        PacketRepository.send(MusicPacket.class, new MusicContext(player, musicId));
    }

    /**
     * Sends the temporary music packet.
     *
     * @param musicId The music id.
     */
    public void sendTempMusic(int musicId) {
        PacketRepository.send(MusicPacket.class, new MusicContext(player, musicId, true));
    }

    /**
     * Send a run script.
     *
     * @param id      The run script id.
     * @param string  The run script string.
     * @param objects The run scripts objects.
     */
    public void sendRunScript(int id, String string, Object... objects) {
        PacketRepository.send(CS2Script.class, new RunScriptContext(player, id, string, objects));
    }

    /**
     * Send a StringPacket.
     *
     * @param string      The string.
     * @param interfaceId The interface id.
     * @param lineId      The line id.
     */
    public void sendString(String string, int interfaceId, int lineId) {
        PacketRepository.send(StringPacket.class, new StringContext(player, string, interfaceId, lineId));
    }

    /**
     * Send a update packet for the amount of run energy.
     */
    public void sendRunEnergy() {
        PacketRepository.send(RunEnergy.class, getContext());
    }

    /**
     * Send the logout packet.
     */
    public void sendLogout() {
        PacketRepository.send(Logout.class, getContext());
    }

    /**
     * Send the interface animation packet.
     *
     * @param animationId The animation id.
     * @param interfaceId The interface id.
     * @param childId     The child id.
     */
    public void sendAnimationInterface(int animationId, int interfaceId, int childId) {
        PacketRepository.send(AnimateInterface.class, new AnimateInterfaceContext(player, animationId, interfaceId, childId));
    }

    /**
     * Send the player on interface packet.
     *
     * @param interfaceId The interface id.
     * @param childId     The child id.
     */
    public void sendPlayerOnInterface(int interfaceId, int childId) {
        PacketRepository.send(DisplayModel.class, new DisplayModelContext(player, interfaceId, childId));
    }

    /**
     * Send the non-player character on interface packet.
     *
     * @param npcId       The non-player character's id.
     * @param interfaceId The interface id.
     * @param childId     The child id.
     */
    public void sendNpcOnInterface(int npcId, int interfaceId, int childId) {
        PacketRepository.send(DisplayModel.class, new DisplayModelContext(player, npcId, interfaceId, childId));
    }

    /**
     * Send the item on interface packet.
     *
     * @param itemId      The item id.
     * @param amount      The item amount.
     * @param interfaceId The interface id.
     * @param childId     The child id.
     */
    public void sendItemOnInterface(int itemId, int amount, int interfaceId, int childId) {
        PacketRepository.send(DisplayModel.class, new DisplayModelContext(player, DisplayModelContext.ModelType.ITEM, itemId, amount, interfaceId, childId));
    }

    /**
     * Send the item on interface packet.
     *
     * @param itemId      The item id.
     * @param zoom        the zoom.
     * @param interfaceId The interface id.
     * @param childId     The child id.
     */
    public void sendItemZoomOnInterface(int itemId, int zoom, int interfaceId, int childId) {
        PacketRepository.send(DisplayModel.class, new DisplayModelContext(player, DisplayModelContext.ModelType.ITEM, itemId, zoom, interfaceId, childId, zoom));
    }

    /**
     * Send the item on interface packet.
     *
     * @param itemId      The item id.
     * @param amount      The amount.
     * @param zoom        the zoom.
     * @param interfaceId The interface id.
     * @param childId     The child id.
     */
    public void sendItemZoomOnInterface(int itemId, int amount, int zoom, int interfaceId, int childId) {
        PacketRepository.send(DisplayModel.class, new DisplayModelContext(player, DisplayModelContext.ModelType.ITEM, itemId, amount, interfaceId, childId, zoom));
    }

    /**
     * Send the interface config packet.
     *
     * @param interfaceId The interface id.
     * @param childId     The child id.
     * @param hide        If the component should be hidden.
     */
    public void sendInterfaceConfig(int interfaceId, int childId, boolean hide) {
        PacketRepository.send(InterfaceConfig.class, new InterfaceConfigContext(player, interfaceId, childId, hide));
    }

    /**
     * Send a animation update flag mask.
     *
     * @param id The animation id.
     */
    public void sendAnimation(int id) {
        player.getUpdateMasks().register(new AnimationFlag(new Animation(id)));
    }

    /**
     * Send a animation update flag mask.
     *
     * @param id    The animation id.
     * @param delay The animation delay.
     */
    public void sendAnimation(int id, int delay) {
        player.getUpdateMasks().register(new AnimationFlag(new Animation(id, delay)));
    }

    /**
     * Send a graphic update flag mask.
     *
     * @param id The graphic id.
     */
    public void sendGraphic(int id) {
        player.getUpdateMasks().register(new GraphicFlag(new Graphics(id)));
    }

    /**
     * Sends the positioned graphic.
     *
     * @param id       the id.
     * @param height   the height.
     * @param delay    the delay.
     * @param location the location.
     */
    public void sendPositionedGraphic(int id, int height, int delay, Location location) {
        PacketRepository.send(PositionedGraphic.class, new PositionedGraphicContext(player, new Graphics(id, height, delay), location));
    }

    /**
     * Sends a global graphic.
     *
     * @param id       the id.
     * @param location the location.
     */
    public void sendGlobalPositionGrapicc(int id, Location location) {
        for (Player player : RegionManager.getLocalPlayers(location)) {
            player.getPacketDispatch().sendPositionedGraphic(id, 0, 0, location);
        }
    }

    /**
     * Sends the positioned graphic.
     *
     * @param graphics the graphics.
     * @param location the location.
     */
    public void sendPositionedGraphics(Graphics graphics, Location location) {
        PacketRepository.send(PositionedGraphic.class, new PositionedGraphicContext(player, graphics, location));

    }

    /**
     * Method used to send an object animation.
     *
     * @param object    the object.
     * @param animation the animation.
     */
    public void sendObjectAnimation(GameObject object, Animation animation) {
        animation = new Animation(animation.getId(), animation.getDelay(), animation.getPriority());
        animation.setObject(object);
        RegionManager.getRegionChunk(object.getLocation()).flag(new AnimateObjectUpdateFlag(animation));
    }

    public void sendObjectCreateChange(GameObject object) {
        IoBuffer regBuffer = new UpdateZonePartialFollows().getBuffer(player, object.getLocation().getChunkBase());
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.LOC_ADD_CHANGE.getPacketId());
        int srcHash = ((object.getLocation().getX() & 0x7) << 4) | (object.getLocation().getY() & 0x7);
        buffer.putByte128(srcHash);
        buffer.put128Byte((object.getType() << 2) | (object.getRotation() & 0x3));
        buffer.putShort128(object.getId());

        player.getSession().write(regBuffer);
        player.getSession().write(buffer);

        System.out.println("[ConstructObject] " + srcHash);
        System.out.println("[ConstructObject] " + ((object.getType() << 2) | (object.getRotation() & 0x7)));
        System.out.println("[ConstructObject] " + object.getId());
    }

    public void sendVar(int id, int value) {
        if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE)
            sendVarpLarge(id, value);
        else
            sendVarpSmall(id, value);
    }

    // packet should be VARP_SMALL
    public void sendVarpSmall(int id, int value) {
        IoBuffer stream = new IoBuffer(ServerProt.ServerPackets.VARP_SMALL.getPacketId());
        stream.putByte128(value);
        stream.putShort128(id);
        player.getSession().write(stream);
    }

    //PACKET SHOULD BE VARP_LARGE
    public void sendVarpLarge(int id, int value) {
        IoBuffer stream = new IoBuffer(ServerProt.ServerPackets.SET_VARP_LARGE.getPacketId());
        stream.putShort(id);
        stream.putInt(value);
        player.getSession().write(stream);
    }

    public void sendRegionUpdate(GameObject object) {
        IoBuffer regBuffer = UpdateZonePartialFollows.getBuffer(player, object.getLocation());
        player.getSession().write(regBuffer);
    }

    public void sendRegionUpdate(Entity e) {
        IoBuffer regBuffer = UpdateZonePartialFollows.getBuffer(player, e.getLocation());
        player.getSession().write(regBuffer);
    }

    public void sendObjectDelete(GameObject object) {
        IoBuffer regBuffer = new UpdateZonePartialFollows().getBuffer(player, object.getLocation().getChunkBase());
        IoBuffer buffer = new IoBuffer(ServerProt.ServerPackets.LOC_DEL.getPacketId());
        int srcHash = ((object.getLocation().getX() & 0x7) << 4) | (object.getLocation().getY() & 0x7);
        buffer.put128Byte((object.getType() << 2) | (object.getRotation() & 3));
        buffer.put128Byte(srcHash);

        player.getSession().write(regBuffer);
        player.getSession().write(buffer);

        System.out.println("[DestructObject] " + srcHash);
        System.out.println("[DestructObject] " + ((object.getType() << 2) | (object.getRotation() & 0x7)));
    }

    public void sendGroundObjectAdd(Item item) {
        val buffer = new UpdateZonePartialFollows().getBuffer(player, item.getLocation().getChunkBase());
        val l = item.getLocation();
        val itemBuf = new IoBuffer(ServerProt.ServerPackets.OBJ_ADD.getPacketId());
        itemBuf.putShort128(item.getAmount());
        itemBuf.putLEShortA(item.getId());
        itemBuf.putByte128((l.getChunkOffsetX() & 0x7) << 4 | (l.getChunkOffsetY() & 0x7));
        player.getDetails().getSession().write(buffer);
        player.getDetails().getSession().write(itemBuf);
    }

    /**
     * Method used to send an object animation.
     *
     * @param object    the object.
     * @param animation the animation.
     * @param global    if the animation is global or not.
     */
    public void sendObjectAnimation(GameObject object, Animation animation, boolean global) {
        if (global) {
            sendObjectAnimation(object, animation);
            return;
        }
        animation.setObject(object);
        PacketRepository.send(AnimateObjectPacket.class, new AnimateObjectContext(player, animation));
    }

    /**
     * Send a graphic update flag mask.
     *
     * @param id     The graphic id.
     * @param height The graphic height.
     */
    public void sendGraphic(int id, int height) {
        player.getUpdateMasks().register(new GraphicFlag(new Graphics(id, height)));
    }

    /**
     * Gets the player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the context.
     *
     * @return The context.
     */
    public PlayerContext getContext() {
        return context;
    }

}
