package org.arcanium.net.packet;

public class ServerProt {

    public enum ServerPackets {
        REBUILD_NORMAL(0, -2),
        LOGOUT_FULL(1, 0),
        CAM_RESET(2, 0), //2, 1
        GAME_MESSAGE(3, -1),
        SET_VARP_LARGE(4, 6),
        IF_OPEN_SUBold(5, 4), //5, 4
        LOC_ADD_CHANGE(6, 4), //6, 7
        UPDATE_INV_CLEAR(7, 4),
        MAP_ANIM(8, 6), //8, -2
        IF_CLOSESUB(9, 4),
        MESSAGE_PRIVATE(10, -2), //10, 10
        MAP_PROJANIM(11, 15), //11, 15
        SOUND_AREA(12, 5), //12, 2
        LOC_DEL(13, 2), //13, 6
        OBJ_DEL(14, 3),
        OBJ_COUNT(15, 7), //15, 7
        field2133(16, 1),
        UPDATE_ZONE_PARTIAL_ENCLOSED(17, -2),
        URL_OPEN(18, -2),
        IF_SETTEXT(19, -2),
        IF_SETOBJECT(20, 10),
        IF_SETHIDE(21, 5),
        UPDATE_STAT(22, 6),
        MIDI_SONG(23, 2),
        IF_SETCOLOUR(24, 6),
        UPDATE_ZONE_FULL_FOLLOWS(25, 2),
        OBJ_ADD(26, 5),
        DYNAMIC_REGION(27, -2),
        RESET_ANIMS(28, 0),
        FRIENDLIST_LOADED(29, 0),
        IF_SETPLAYERHEAD(30, 4),
        IF_SETMODEL(31, 6),
        UPDATE_IGNORELIST(32, -2),
        NPC_INFO_SMALL(33, -2),
        field2174(34, 1),
        IF_SETNPCHEAD(35, 6),
        HINT_ARROW(36, 6),
        UPDATE_SITESETTINGS(37, -1),
        MESSAGE_PRIVATE_ECHO(38, -2),
        CAM_SHAKE(39, 4),
        MIDI_JINGLE(40, 5),
        field2163(41, 8),
        field2140(42, 14),
        UPDATE_FRIENDCHAT_CHANNEL_FULL(43, -2),
        UPDATE_INV_PARTIAL(44, -2),
        UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER (45, -1), //OBJ_DEL, 45, 3
        UPDATE_INV_STOP_TRANSMIT(46, 2),
        LOGOUT_TRANSFER(47, -1),
        IF_SETEVENTS(48, 12),
        LOC_ANIM(49, 4),
        IF_SETANGLE(50, 10),
        REBUILD_REGION(51, -2),
        TRIGGER_ONDIALOGABORT(52, 0),
        REFLECTION_CHECKER(53, -2),
        MESSAGE_FRIENDCHANNEL(54, -1),
        field2149(55, 20),
        field2150(56, -2),
        UPDATE_UID192(57, 28),
        UPDATE_FRIENDLIST(58, -2),
        IF_SETPOSITION(59, 8),
        UPDATE_RUNENERGY(60, 1),
        IF_SETANIM(61, 6),
        RUNCLIENTSCRIPT(62, -2),
        VARP_SMALL(63, 3),
        UPDATE_ZONE_PARTIAL_FOLLOWS(64, 2),
        SYNTH_SOUND(65, 5),
        SET_PLAYER_OP(66, -1),
        SET_MAP_FLAG(67, 2),
        CHAT_FILTER_SETTINGS_PRIVATECHAT(68, 1),
        PING_STATISTICS_REQUEST(69, 8),
        UPDATE_INV_FULL(70, -2),
        UPDATE_RUNWEIGHT(71, 2),
        UPDATE_REBOOT_TIMER(72, 2),
        SYNC_CLIENT_VARCACHE(73, 0),
        MINIMAP_TOGGLE(74, 1),
        CAM_MOVETO(75, 6),
        IF_SETSCROLLPOS(76, 6),
        IF_OPEN_SUB(77, 7),
        RESET_CLIENT_VARCACHE(78, 0),
        PLAYER_INFO(79, -2),
        CHAT_FILTER_SETTINGS(80, 2),
        NPC_INFO_LARGE(81, -2),
        IF_MOVESUB(82, 8),
        CAM_LOOKAT(83, 6), //83, -2
        IF_OPEN_TOP(84, 2);

        private int packetId, packetSize;

        public int getPacketId() {
            return packetId;
        }

        public int getPacketSize() {
            return packetSize;
        }

        ServerPackets(int packetId, int packetSize) {
            this.packetId = packetId;
            this.packetSize = packetSize;
        }
    }

}
