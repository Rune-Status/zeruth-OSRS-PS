package org.arcanium.net.packet;

public class ZoneProt {

    public enum ZonePackets {

        ALTER_GROUND_ITEM(7),
        MAP_PROJANIM(15),
        field2318(14),
        MAP_ANIM(6),
        LOC_CUSTOMIZE(4),
        field2321(5),
        OBJECT_REMOVE(2),
        GROUND_ITEM_REMOVE(3),
        GROUND_ITEM_ADD(5),
        ADD_OBJECT(4);

        private int packetId;

        public int getPacketId() {
            return packetId;
        }

        ZonePackets(int packetId) {
            this.packetId = packetId;
        }
    }
}
