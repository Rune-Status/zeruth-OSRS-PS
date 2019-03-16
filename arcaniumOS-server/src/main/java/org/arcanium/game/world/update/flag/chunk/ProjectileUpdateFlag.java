package org.arcanium.game.world.update.flag.chunk;

import org.arcanium.game.node.entity.Entity;
import org.arcanium.game.node.entity.impl.Projectile;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles the projectile updating.
 *
 * @author Emperor
 */
public final class ProjectileUpdateFlag extends UpdateFlag<Projectile> {

    /**
     * Constructs a new {@code ProjectileUpdateFlag} {@code Object}.
     *
     * @param projectile The projectile.
     */
    public ProjectileUpdateFlag(Projectile projectile) {
        super(projectile);
    }

    @Override
    public void write(IoBuffer buffer) {
        Projectile p = context;
        Location start = p.getSourceLocation();
        Entity target = p.getVictim();
        Location end = p.isLocationBased() ? p.getEndLocation() : target.getLocation();
        buffer.put((byte) 188)
                // opcode
                .put((start.getChunkOffsetX() << 4) | (start.getChunkOffsetY() & 0x7)).put(end.getX() - start.getX()).put(end.getY() - start.getY()).putShort(target != null ? (target instanceof Player ? -(target.getIndex() + 1) : (target.getIndex() + 1)) : -1).putShort(p.getProjectileId()).put(p.getStartHeight()).put(p.getEndHeight()).putShort(p.getStartDelay()).putShort(p.getSpeed()).put(p.getAngle()).put(p.getDistance());

        // Second packet:
        // buffer.put((byte) 125); //opcode
        // buffer.put((start.getChunkOffsetX() << 4) | (start.getChunkOffsetY()
        // & 0x7))
        // .put((end.getX() - start.getX()) << 1)
        // .put((end.getY() - start.getY()) << 1);
        // buffer.putShort(p.getVictim() != null ? (p.getVictim() instanceof
        // Player ? -(p.getVictim().getIndex() + 1) : (p.getVictim().getIndex()
        // + 1)) : -1);
        // buffer.putShort(p.getProjectileId());
        // buffer.put(p.getStartHeight());
        // buffer.put(p.getEndHeight());
        // buffer.putShort(p.getStartDelay());
        // buffer.putShort(p.getSpeed());
        // buffer.put(p.getAngle());
        // buffer.put(p.getDistance());
    }

    @Override
    public int data() {
        return 0;
    }

    @Override
    public int ordinal() {
        return 2;
    }

}