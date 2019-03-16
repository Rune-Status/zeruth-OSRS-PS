package org.arcanium.game.node.entity.player.link;

import org.arcanium.game.component.Component;
import org.arcanium.game.node.entity.player.Player;

public class InterfaceSetManager {

    public static final int RESIZABLE_VERTICAL = 161;
    public static final int RESIZABLE_HORIZONTAL = 164;
    public static final int FIXED = 548;
    public static final int LOBBY = 165;

    public static void sendSets(Player player, int windowMode) {
        switch (windowMode) {
            /**
             * Fixed to resizable
             */
            case 1:
                System.out.println("case 1");
                player.getInterfaceManager().openWindowsPane(new Component(FIXED));
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 29, FIXED, 23);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 13, FIXED, 20);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 3, FIXED, 13);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 6, FIXED, 15);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 66, FIXED, 63);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 68, FIXED, 65);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 69, FIXED, 66);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 70, FIXED, 67);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 71, FIXED, 68);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 72, FIXED, 69);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 73, FIXED, 70);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 74, FIXED, 71);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 75, FIXED, 72);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 76, FIXED, 73);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 77, FIXED, 74);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 78, FIXED, 75);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 79, FIXED, 76);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 80, FIXED, 77);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 81, FIXED, 78);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 4, FIXED, 14);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 9, FIXED, 18);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 28, FIXED, 10);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 7, FIXED, 16);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 8, FIXED, 17);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 14, FIXED, 21);

				/*player.getPacketDispatch().sendInterfaceSet(161, 31,548, 24);
				player.getPacketDispatch().sendInterfaceSet(161, 7, 548, 17);
				player.getPacketDispatch().sendInterfaceSet(161, 9, 548, 19);
				player.getPacketDispatch().sendInterfaceSet(161, 28,548, 11);
				player.getPacketDispatch().sendInterfaceSet(161, 68,548, 66);
				player.getPacketDispatch().sendInterfaceSet(161, 69,548, 67);
				player.getPacketDispatch().sendInterfaceSet(161, 70,548, 68);
				player.getPacketDispatch().sendInterfaceSet(161, 71,548, 69);
				player.getPacketDispatch().sendInterfaceSet(161, 72,548, 70);
				player.getPacketDispatch().sendInterfaceSet(161, 73,548, 71);
				player.getPacketDispatch().sendInterfaceSet(161, 74,548, 72);
				player.getPacketDispatch().sendInterfaceSet(161, 75,548, 73);
				player.getPacketDispatch().sendInterfaceSet(161, 76,548, 74);
				player.getPacketDispatch().sendInterfaceSet(161, 77,548, 75);
				player.getPacketDispatch().sendInterfaceSet(161, 78,548, 76);
				player.getPacketDispatch().sendInterfaceSet(161, 79,548, 77);
				player.getPacketDispatch().sendInterfaceSet(161, 80,548, 78);
				player.getPacketDispatch().sendInterfaceSet(161, 81,548, 79);*/
                break;
            /**
             * Lobby to Fixed
             */
            case 2:
                System.out.println("case 2");
                player.getInterfaceManager().openWindowsPane(new Component(FIXED));
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 1, FIXED, 24);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 4, FIXED, 17);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 23, FIXED, 19);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 24, FIXED, 11);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 8, FIXED, 66);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 9, FIXED, 67);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 10, FIXED, 68);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 11, FIXED, 69);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 12, FIXED, 70);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 13, FIXED, 71);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 14, FIXED, 72);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 15, FIXED, 73);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 16, FIXED, 74);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 17, FIXED, 75);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 18, FIXED, 76);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 19, FIXED, 77);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 20, FIXED, 78);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 21, FIXED, 79);
                break;
            /**
             * Lobby to resizable
             */
            case 3://lobby to fixed gameframe
                System.out.println("case 3");
                player.getInterfaceManager().openWindowsPane(new Component(RESIZABLE_VERTICAL));
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 1, RESIZABLE_VERTICAL, 29);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 4, RESIZABLE_VERTICAL, 7);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 23, RESIZABLE_VERTICAL, 9);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 24, RESIZABLE_VERTICAL, 28);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 8, RESIZABLE_VERTICAL, 68);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 9, RESIZABLE_VERTICAL, 69);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 10, RESIZABLE_VERTICAL, 70);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 11, RESIZABLE_VERTICAL, 71);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 12, RESIZABLE_VERTICAL, 72);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 13, RESIZABLE_VERTICAL, 73);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 14, RESIZABLE_VERTICAL, 74);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 15, RESIZABLE_VERTICAL, 75);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 16, RESIZABLE_VERTICAL, 76);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 17, RESIZABLE_VERTICAL, 77);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 18, RESIZABLE_VERTICAL, 78);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 19, RESIZABLE_VERTICAL, 79);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 20, RESIZABLE_VERTICAL, 80);
                player.getPacketDispatch().sendInterfaceSet(LOBBY, 21, RESIZABLE_VERTICAL, 81);
                break;
            /**
             * Resizable to fixed
             */
            case 4:
                System.out.println("case 4");
                player.getInterfaceManager().openWindowsPane(new Component(548));
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 31, FIXED, 24);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 7, FIXED, 17);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 9, FIXED, 19);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 28, FIXED, 11);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 68, FIXED, 66);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 69, FIXED, 67);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 70, FIXED, 68);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 71, FIXED, 69);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 72, FIXED, 70);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 73, FIXED, 71);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 74, FIXED, 72);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 75, FIXED, 73);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 76, FIXED, 74);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 77, FIXED, 75);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 78, FIXED, 76);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 79, FIXED, 77);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 80, FIXED, 78);
                player.getPacketDispatch().sendInterfaceSet(RESIZABLE_VERTICAL, 81, FIXED, 79);
                break;
        }
    }

}
