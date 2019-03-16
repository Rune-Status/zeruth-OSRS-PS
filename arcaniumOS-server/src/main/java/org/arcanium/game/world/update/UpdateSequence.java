package org.arcanium.game.world.update;

import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.npc.NPC;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.GroundItemManager;
import org.arcanium.game.world.map.RegionManager;
import org.arcanium.game.world.repository.InitializingNodeList;
import org.arcanium.game.world.repository.Repository;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * The entity update sequence.
 *
 * @author Emperor
 */
public final class UpdateSequence {

    /**
     * The list of active players.
     */
    private static final InitializingNodeList<Player> RENDERABLE_PLAYERS = new InitializingNodeList<>();

    /**
     * The executor used.
     */
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * Constructs a new {@code ParallelUpdatingSequence} {@code Object}.
     */
    public UpdateSequence() {
    /*
	 * empty.
	 */
    }

    /**
     * Starts the update sequence.
     *
     * @return {@code True} if we should continue.
     */
    public void start() {
        for (Player p : Repository.getLobbyPlayers()) {
            //PacketRepository.send(ClearMinimapFlag.class, new PlayerContext(p));
        }
        for (Player p : getRenderablePlayers()) {
            try {
                p.tick();
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
        for (NPC n : Repository.getRenderableNpcs()) {
            try {
                n.tick();
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    /**
     * Runs the updating part of the sequence.
     */
    public void run() {
        final CountDownLatch latch = new CountDownLatch(getRenderablePlayers().size());
        for (final Player p : getRenderablePlayers()) {
            EXECUTOR.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        p.update();
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                    latch.countDown();
                }
            });
        }
        try {
            latch.await(1000l, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ends the sequence, calls the {@link Entity#reset()} method..
     */
    public void end() {
        for (Player p : getRenderablePlayers()) {
            p.reset();
        }
        for (NPC npc : Repository.getRenderableNpcs()) {
            npc.reset();
        }
        getRenderablePlayers().sync();
        RegionManager.pulse();
        GroundItemManager.pulse();
    }

    /**
     * Terminates the update sequence.
     */
    public final void terminate() {
        EXECUTOR.shutdown();
    }

    /**
     * Gets the renderablePlayers.
     *
     * @return The renderablePlayers.
     */
    public static InitializingNodeList<Player> getRenderablePlayers() {
        return RENDERABLE_PLAYERS;
    }
}
