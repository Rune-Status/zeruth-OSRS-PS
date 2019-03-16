package org.arcanium.game.node.entity.player.info.login;

import org.arcanium.ServerConstants;
import org.arcanium.game.component.Component;
import org.arcanium.game.component.data.VarpData;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.game.world.repository.Repository;
import org.arcanium.game.world.update.UpdateSequence;
import org.arcanium.game.world.update.flag.player.AppearanceFlag;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class WelcomeScreen {

    /**
     * Configures the lobby login.
     *
     * @param player The player.
     */
    public static void configureLobby(Player player) {
        player.getUpdateMasks().register(new AppearanceFlag(player));
        player.updateSceneGraph(true);
        Repository.getLobbyPlayers().add(player);
        RegionManager.move(player);
        player.getStateManager().init();
        UpdateSequence.getRenderablePlayers().add(player);
        sendLobbyScreen(player);
    }

    /**
     * Calculates the last login and returns the message to display on the login
     * screen.
     *
     * @param player The player.
     * @return The message to display.
     */
    public static String lastLogin(Player player) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        long time = player.getDetails().getLastLogin();
        long diffDays = -1;
        if (time != -1) {
            long currentTime = dateFormat.getCalendar().getTime().getTime();
            diffDays = (currentTime - time) / (24 * 60 * 60 * 1000);
        }
        player.getDetails().setLastLogin(dateFormat.getCalendar().getTime().getTime());
        if (diffDays < 0) {
            return "Welcome to " + GameWorld.getName() + "!";
        }
        if (diffDays == 0) {
            return "You last logged in <col=ff0000>earlier today.";
        }
        if (diffDays == 1) {
            return "You last logged in <col=ff0000>yesterday.";
        }
        if (diffDays >= 2) {
            return "You last logged in <col=ff0000>" + diffDays + " days ago.";
        }
        return null;
    }

    public static void sendInitialInterfaces(Player player) {
        player.getPacketDispatch().sendInterface(165, 1, 162, true);
        player.getPacketDispatch().sendInterface(165, 23, 163, true);
        player.getPacketDispatch().sendInterface(165, 24, 160, true);
        player.getPacketDispatch().sendInterface(165, 27, 378, false);
        player.getPacketDispatch().sendInterface(165, 9, 320, true);
        player.getPacketDispatch().sendInterface(165, 10, 399, true);
        player.getPacketDispatch().sendInterface(165, 11, 149, true);
        player.getPacketDispatch().sendInterface(165, 12, 387, true);
        player.getPacketDispatch().sendInterface(165, 13, 541, true);
        player.getPacketDispatch().sendInterface(165, 14, 218, true);
        player.getPacketDispatch().sendInterface(165, 16, 109, true);
        player.getPacketDispatch().sendInterface(165, 17, 429, true);
        player.getPacketDispatch().sendInterface(165, 18, 182, true);
        player.getPacketDispatch().sendInterface(165, 19, 261, true);
        player.getPacketDispatch().sendInterface(165, 20, 216, true);
        player.getPacketDispatch().sendInterface(165, 21, 239, true);
        player.getPacketDispatch().sendInterface(165, 15, 7, true);
        player.getPacketDispatch().sendInterface(165, 8, 593, true);
    }

    public static void sendInitialVarp(Player player) {
        player.getConfigManager().sendVarp(VarpData.LOGOUT_INTERFACE_STATE, 2);
    }

    public static void sendInitialCS2Scripts(Player player) {
        player.getPacketDispatch().sendCS2Script(2498, new Object[]{1, 1, 1});//i11
        player.getPacketDispatch().sendCS2Script(233, new Object[]{24772664, 11470, 0, 120, 114, 1873, 0, 900, 3220});//ImiiiiiiA
        player.getPacketDispatch().sendCS2Script(233, new Object[]{24772665, 11075, 0, 0, 132, 2044, 0, 1500, 3108});//ImiiiiiiA
        player.getPacketDispatch().sendCS2Script(1105, new Object[]{1});// 1
        player.getPacketDispatch().sendCS2Script(1080, new Object[]{});// s
        player.getPacketDispatch().sendCS2Script(828, new Object[]{1});// i
        player.getPacketDispatch().sendCS2Script(2014, new Object[]{0, 0, 0, 0, 0, 0});// iiiiii
        player.getPacketDispatch().sendCS2Script(2015, new Object[]{0});// i
    }

    /**
     * Sends the lobby interface-related packets.
     *
     * @param player The player.
     */
    public static void sendLobbyScreen(Player player) {
        player.sendMessage("Welcome to " + ServerConstants.SERVER_NAME + ".");
        player.getInterfaceManager().openWindowsPane(new Component(165));
        player.getConfigManager().sendVarpReset();
        sendInitialInterfaces(player);
        player.getPacketDispatch().sendString("You do not have a Bank PIN.<br>Please visit a bank if you would like one.", 378, 75);
        player.getPacketDispatch().sendString("WIP FAM!", 378, 7);
        sendInitialCS2Scripts(player);
        sendInitialVarp(player);
    }
}