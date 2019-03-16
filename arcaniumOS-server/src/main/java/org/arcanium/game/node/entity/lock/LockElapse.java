package org.arcanium.game.node.entity.lock;

import org.arcanium.game.node.Node;

/**
 * Called after the expiration of a custom action lock.
 * @author Aero
 */
public interface LockElapse {

    /**
     * Called when a custom action lock has elapsed.
     * @param node The node.
     * @param lock The custom action lock.
     */
    public void elapse(Node node, Lock lock);

}