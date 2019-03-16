package org.arcanium;

import org.arcanium.game.system.SystemLogger;
import org.arcanium.game.system.SystemShutdownHook;
import org.arcanium.game.system.monitor.ExceptionLog;
import org.arcanium.game.system.mysql.SQLManager;
import org.arcanium.game.world.GameWorld;
import org.arcanium.net.NioReactor;
import org.arcanium.tools.TimeStamp;

/**
 * The main class, for those that are unable to read the class' name.
 *
 * @author Emperor
 * @author Vexia
 */
public final class Server {

    /**
     * The time stamp of when the server started running.
     */
    public static long startTime;

    /**
     * The NIO reactor.
     */
    public static NioReactor reactor;

    /**
     * The main method, in this method we load background utilities such as
     * cache and our world, then end with starting networking.
     *
     * @param args The arguments cast on runtime.
     * @throws Throwable When an exception occurs.
     */
    public static void main(String... args) throws Throwable {
        if (args.length > 0) {
            GameWorld.setSettings(GameSettings.parse(args));
        }
        System.setErr(new ExceptionLog("error.txt"));
        startTime = System.currentTimeMillis();
        final TimeStamp t = new TimeStamp();
        GameWorld.prompt(true);
		SQLManager.init();
        Runtime.getRuntime().addShutdownHook(new Thread(new SystemShutdownHook()));
        SystemLogger.log("Starting Network Reactor...");
        reactor = NioReactor.configure(NetworkConstants.PORT);
        reactor.start();
        SystemLogger.log(GameWorld.getName() + " flags " + GameWorld.getSettings().toString());
        SystemLogger.log(GameWorld.getName() + " started in " + t.duration(false, "") + " milliseconds.");
    }

    /**
     * Gets the startTime.
     *
     * @return the startTime
     */
    public static long getStartTime() {
        return startTime;
    }

    /**
     * Sets the bastartTime.
     *
     * @param startTime the startTime to set.
     */
    public static void setStartTime(long startTime) {
        Server.startTime = startTime;
    }
}