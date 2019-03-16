package org.arcanium.net.packet;

import org.arcanium.net.packet.client.*;
import org.arcanium.net.packet.client.util.PacketRetriever;
import org.arcanium.net.packet.server.*;
import org.arcanium.net.packet.server.zone.UpdateZoneFullFollows;
import org.arcanium.net.packet.server.zone.UpdateZonePartialFollows;

import java.util.HashMap;
import java.util.Map;

/**
 * The packet repository.
 *
 * @author Emperor
 */
public final class PacketRepository {

    /**
     * The outgoing packets mapping.
     */
    private final static Map<Class<?>, ServerPacket<? extends Context>> SERVER_PACKETS = new HashMap<>();

    /**
     * The incoming packets mapping.
     */
    private final static Map<Integer, ClientPacket> CLIENT_PACKETS = new HashMap<>();

    /**
     * Populate the mappings.
     */
    static {
        SERVER_PACKETS.put(LoginPacket.class, new LoginPacket());
        SERVER_PACKETS.put(UpdateSceneGraph.class, new UpdateSceneGraph());
        SERVER_PACKETS.put(WindowsPane.class, new WindowsPane());
        SERVER_PACKETS.put(Interface.class, new Interface());
        SERVER_PACKETS.put(StringPacket.class, new StringPacket());
        SERVER_PACKETS.put(MusicPacket.class, new MusicPacket());
        SERVER_PACKETS.put(CloseInterface.class, new CloseInterface());
        SERVER_PACKETS.put(Varp.class, new Varp());
        SERVER_PACKETS.put(CS2Script.class, new CS2Script());
        SERVER_PACKETS.put(GameMessage.class, new GameMessage());
        SERVER_PACKETS.put(InterfaceSet.class, new InterfaceSet());
        SERVER_PACKETS.put(Logout.class, new Logout());
        SERVER_PACKETS.put(RunEnergy.class, new RunEnergy());
        SERVER_PACKETS.put(SkillLevel.class, new SkillLevel());
        SERVER_PACKETS.put(ClearMinimapFlag.class, new ClearMinimapFlag());
        SERVER_PACKETS.put(InterfaceConfig.class, new InterfaceConfig());
        SERVER_PACKETS.put(ClearContainerPacket.class, new ClearContainerPacket());
        SERVER_PACKETS.put(PartialContainerPacket.class, new PartialContainerPacket());
        SERVER_PACKETS.put(FullContainerPacket.class, new FullContainerPacket());
        SERVER_PACKETS.put(InteractionOption.class, new InteractionOption());
        SERVER_PACKETS.put(AccessMask.class, new AccessMask());
        SERVER_PACKETS.put(AudioPacket.class, new AudioPacket());
        SERVER_PACKETS.put(WeightUpdate.class, new WeightUpdate());
        SERVER_PACKETS.put(ContactPackets.class, new ContactPackets());

        SERVER_PACKETS.put(UpdateZonePartialFollows.class, new UpdateZonePartialFollows());
        SERVER_PACKETS.put(UpdateZoneFullFollows.class, new UpdateZoneFullFollows());

        SERVER_PACKETS.put(ConstructObject.class, new ConstructObject());
        SERVER_PACKETS.put(ClearObject.class, new ClearObject());
        SERVER_PACKETS.put(ClearGroundItem.class, new ClearGroundItem()); //prob has issues
        SERVER_PACKETS.put(ConstructGroundItem.class, new ConstructGroundItem());
        SERVER_PACKETS.put(UpdateGroundItemAmount.class, new UpdateGroundItemAmount()); //has issues

        CLIENT_PACKETS.put(ClientProt.ClientPackets.MESSAGE_PUBLIC.getPacketId(), new ChatPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.CLIENT_CHEAT.getPacketId(), new CommandPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.MOVE_GAMECLICK.getPacketId(), new MovePacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.MOVE_MINIMAPCLICK.getPacketId(), new MovePacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.TELEPORT.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF_BUTTON1.getPacketId(), new ActionButtonPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF_BUTTON2.getPacketId(), new ActionButtonPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF_BUTTON3.getPacketId(), new ActionButtonPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF_BUTTON4.getPacketId(), new ActionButtonPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF_BUTTON5.getPacketId(), new ActionButtonPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF_BUTTON6.getPacketId(), new ActionButtonPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF_BUTTON7.getPacketId(), new ActionButtonPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF_BUTTON8.getPacketId(), new ActionButtonPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF_BUTTON9.getPacketId(), new ActionButtonPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF_BUTTON10.getPacketId(), new ActionButtonPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPHELDT.getPacketId(), new PacketRetriever());//ItemActionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPHELDD.getPacketId(), new PacketRetriever());//ItemActionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPHELDU.getPacketId(), new ItemActionPacket());//Item on Item
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPHELD1.getPacketId(), new ItemActionPacket()); //ITEM_OPTION_ONE
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPHELD2.getPacketId(), new ItemActionPacket());//Item Wield
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPHELD3.getPacketId(), new PacketRetriever());//INTERFACE_ON_ITEM
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPHELD4.getPacketId(), new PacketRetriever());//ITEM_OPTION_TWO
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPHELD5.getPacketId(), new ItemActionPacket());//Drop Item
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPOBJ6.getPacketId(), new ExaminePacket());//Examine Object
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPNPC1.getPacketId(), new InteractionPacket());//InteractionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPNPC2.getPacketId(), new InteractionPacket());//InteractionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPNPC3.getPacketId(), new InteractionPacket());//InteractionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPNPC4.getPacketId(), new InteractionPacket());//InteractionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPNPC5.getPacketId(), new InteractionPacket());//InteractionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPNPC6.getPacketId(), new ExaminePacket());//Examine NPC
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPNPCT.getPacketId(), new InteractionPacket());//Examine NPC
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPNPCU.getPacketId(), new InteractionPacket());//Examine NPC
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPLOC1.getPacketId(), new InteractionPacket());//InteractionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPLOC2.getPacketId(), new InteractionPacket());//InteractionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPLOC3.getPacketId(), new PacketRetriever());//InteractionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPLOC4.getPacketId(), new PacketRetriever());//InteractionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPLOC5.getPacketId(), new PacketRetriever());//InteractionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPLOC6.getPacketId(), new ExaminePacket());//Examine OBJ
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPLOCT.getPacketId(), new PacketRetriever());//InteractionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPLOCU.getPacketId(), new InteractionPacket());//InteractionPacket
        CLIENT_PACKETS.put(ClientProt.ClientPackets.PING_STATISTICS.getPacketId(), new PingPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.SEND_SNAPSHOT.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.FRIENDLIST_ADD.getPacketId(), new InputPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IGNORELIST_ADD.getPacketId(), new InputPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPHELDD.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.UPDATE_APPEARANCE.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF1_BUTTON1.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF1_BUTTON2.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF1_BUTTON3.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF1_BUTTON4.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.IF1_BUTTON5.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPOBJ1.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPOBJ2.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPOBJ3.getPacketId(), new InteractionPacket()); // Pick up item
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPOBJ4.getPacketId(), new InteractionPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPOBJ5.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPOBJ6.getPacketId(), new InteractionPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPOBJT.getPacketId(), new PacketRetriever());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPOBJU.getPacketId(), new InteractionPacket()); // Item on ground item
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPPLAYER1.getPacketId(), new InteractionPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPPLAYER2.getPacketId(), new InteractionPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPPLAYER3.getPacketId(), new InteractionPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPPLAYER4.getPacketId(), new InteractionPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPPLAYER5.getPacketId(), new InteractionPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPPLAYER6.getPacketId(), new InteractionPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPPLAYER7.getPacketId(), new InteractionPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPPLAYER8.getPacketId(), new InteractionPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPPLAYERT.getPacketId(), new InteractionPacket());
        CLIENT_PACKETS.put(ClientProt.ClientPackets.OPPLAYERU.getPacketId(), new InteractionPacket());
    }

    /**
     * Sends a new packet.
     *
     * @param clazz   The class of the outgoing packet to send.
     * @param context The context.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void send(Class<? extends ServerPacket> clazz, Context context) {
        ServerPacket p = SERVER_PACKETS.get(clazz);
        if (p == null) {
            System.err.println("Invalid serverpacket [handler=" + clazz + ", context=" + context + "].");
            return;
        }
        p.send(context);
    }

    /**
     * Gets an incoming packet.
     *
     * @param opcode The opcode.
     * @return The incoming packet.
     */
    public static ClientPacket getClientPacket(int opcode) {
        return CLIENT_PACKETS.get(opcode);
    }
}