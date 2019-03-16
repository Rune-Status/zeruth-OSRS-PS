package org.arcanium.game.world.update.flag.player;

import org.arcanium.game.node.Node;
import org.arcanium.game.node.object.GameObject;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles the face coordinates update flag.
 * @author Emperor
 */
public class FaceLocationFlag extends UpdateFlag<Integer> {

    /**
     * Constructs a new {@code FaceLocationFlag} {@code Object}.
     * @param location The location to face.
     */
    public FaceLocationFlag(Location locationFrom, Location locationTo) {
	super((locationFrom != null && locationTo != null) ? (((int) (Math.atan2(locationFrom.getX() - locationTo.getX(), locationFrom.getY() - locationTo.getY()) * 325.9493234522016)) & 0x7ff) : 0);
    }

    /**
     * Gets the face location of the node.
     * @param n The facing node.
     * @param node The node to face.
     * @return The location.
     */
    public static Location getFaceLocation(Node n, Node node) {
	int x = node.size() >> 1;
	int y = node.size() >> 1;
	if (node instanceof GameObject) {
	    GameObject o = (GameObject) node;
	    x = o.getDefinition().sizeX >> 1;
	    y = o.getDefinition().sizeY >> 1;
	    if (o.getRotation() % 2 != 0) {
		x = y;
		y = o.getDefinition().sizeX >> 1;
	    }
	    if (n.getLocation().equals(o.getLocation()) && node.size() == 1) {
		switch (o.getRotation()) {
		case 0:
		    x -= 1;
		    break;
		case 1:
		    y += 1;
		    break;
		case 2:
		    x += 1;
		    break;
		case 3:
		    y -= 1;
		    break;
		}
	    }
	}
	return node.getLocation().transform(x, y, 0);
    }

    @Override
    public void write(IoBuffer buffer) {
	buffer.putShortLE(context.intValue());
	//problem with these is that data is required to be written, ill get to this in a min.
    }

    @Override
    public int data() {
	return 4;
    }

    @Override
    public int ordinal() {
	return getOrdinal();
    }

    /**
     * Gets the mask ordinal.
     * @return The ordinal.
     */
    public static int getOrdinal() {
	return 5;
    }

}