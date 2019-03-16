package org.arcanium.net.packet;

public class ClientProt {

    public enum ClientPackets {
        IF_BUTTON10(0, 8),
        OPNPC2(1, 3),
        OPHELDT(2, 14),
        OPLOC4(3, 7),
        field3846(4, -1),
        OPOBJ1(5, 7),
        OPOBJ3(6, 7),
        OPHELD4(7, 8),
        RESUME_P_STRINGDIALOG(8, -1),
        DETECT_MODIFIED_CLIENT(9, 4),
        OPLOC1(10, 7), //Object First Click
        PING_STATISTICS(11, 10),
        UPDATE_APPEARANCE(12, 13),
        CLAN_KICKUSER(13, -1),
        IF_BUTTON8(14, 8),
        CHAT_SETMODE(15, 3),
        BUG_REPORT(16, -2),
        RESUME_P_COUNTDIALOG(17, 4),
        OPOBJU(18, 15),
        IF_BUTTON4(19, 8),
        CLOSE_MODAL(20, 0),
        IF_BUTTON2(21, 8),
        NO_TIMEOUT(22, 0),
        OPNPCU(23, 11),
        OPOBJ6(24, 2),
        MESSAGE_PRIVATE(25, -2),
        IF1_BUTTON2(26, 8),
        OPPLAYER4(27, 3),
        IGNORELIST_DEL(28, -1),
        OPOBJ4(29, 7),
        OPNPC6(30, 2),
        OPNPC5(31, 3),
        IF1_BUTTON5(32, 8),
        OPNPC3(33, 3),
        EVENT_MOUSE_MOVE(34, -1),
        WINDOW_STATUS(35, 5),
        OPLOC6(36, 2),
        FREECAM_EXIT(37, 0),
        SEND_SNAPSHOT(38, -1),
        EVENT_CAMERA_POSITION(39, 4),
        IF_BUTTON5(40, 8),
        EVENT_MOUSE_CLICK(41, 6),
        RESUME_P_OBJDIALOG(42, 2),
        field3839(43, -1),
        OPLOCU(44, 15),
        field3818(45, 4),
        IF1_BUTTON1(46, 8),
        OPPLAYER1(47, 3),
        IF_BUTTON3(48, 8),
        EVENT_MOUSE_IDLE(49, 0),
        OPPLAYER8(50, 3),
        OPOBJ5(51, 7),
        MOVE_MINIMAPCLICK(52, -1),
        OPOBJT(53, 13),
        FRIENDLIST_DEL(54, -1),
        OPPLAYERT(55, 9),
        OPPLAYER2(56, 3),
        /**
         * Item dragging to another inventory slot
         */
        OPHELDD(57, 16),
        OPHELD5(58, 8),
        OPNPC4(59, 3),
        CLIENT_CHEAT(60, -1),
        TELEPORT(61, 9),
        OPPLAYER3(62, 3),
        OPHELDU(63, 16),
        IF1_BUTTON4(64, 8),
        IF1_BUTTON3(65, 8),
        IF_BUTTON6(66, 8),
        EVENT_KEYBOARD(67, -2),
        IF_BUTTON1(68, 8),
        field3865(69, 4),
        RESUME_PAUSEBUTTON(70, 6),
        OPNPC1(71, 3),
        OPHELD3(72, 8),
        EVENT_APPLET_FOCUS(73, 1),
        OPOBJ2(74, 7),
        OPPLAYER7(75, 3),
        MAP_BUILD_COMPLETE(76, 0),
        FRIEND_SETRANK(77, -1),
        CLAN_JOINCHAT_LEAVECHAT(78, -1),
        OPLOC2(79, 7),
        IF_BUTTOND(80, 9),
        OPPLAYERU(81, 11),
        IF_BUTTONT(82, 16),
        OPPLAYER5(83, 3),
        IF_BUTTON9(84, 8),
        IF_BUTTON7(85, 8),
        OPNPCT(86, 9),
        OPHELD1(87, 8), // need to update packet values
        FRIENDLIST_ADD(88, -1),
        OPLOC3(89, 7),
        IGNORELIST_ADD(90, -1),
        REFLECTION_CHECK_REPLY(91, -1),
        OPLOCT(92, 13),
        OPPLAYER6(93, 3),
        OPLOC5(94, 7),
        RESUME_P_NAMEDIALOG(95, -1),
        MOVE_GAMECLICK(96, -1),
        MESSAGE_PUBLIC(97, -1),
        OPHELD2(98, 8),
        field3895(99, 7);

        private int packetId, packetSize;

        public int getPacketId() {
            return packetId;
        }

        public int getPacketSize() {
            return packetSize;
        }

        ClientPackets(int packetId, int packetSize) {
            this.packetId = packetId;
            this.packetSize = packetSize;
        }
    }

}
