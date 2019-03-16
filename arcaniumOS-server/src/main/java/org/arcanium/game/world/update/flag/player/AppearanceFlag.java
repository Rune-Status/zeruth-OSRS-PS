package org.arcanium.game.world.update.flag.player;

import org.arcanium.cache.misc.buffer.ByteBufferUtils;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.link.appearance.Appearance;
import org.arcanium.game.node.entity.player.link.appearance.BodyPart;
import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.net.packet.IoBuffer;

/**
 * Handles the appearance update flag.
 *
 * @author Emperor
 */
public final class AppearanceFlag extends UpdateFlag<Player> {

    /**
     * Constructs a new {@code AppearanceFlag} {@code Object}.
     *
     * @param player The player.
     */
    public AppearanceFlag(Player player) {
        super(player);
    }

    @Override
    public void write(IoBuffer buffer) {
        Appearance appearance = context.getAppearance();
        appearance.prepareBodyData(context);
        IoBuffer block = new IoBuffer();
        int settings = appearance.getGender().toByte();
        if (context.size() > 1) {
            settings |= (context.size() - 1) << 3;
        }
        block.put128Byte(settings); //settings hash.

        block.put(appearance.getSkullIcon()); //Skull icon
        block.put(appearance.getHeadIcon()); //Head icon

        int npcId = appearance.getNpcId();
        if (npcId == -1) {
            int[] parts = appearance.getBodyParts();
            for (int i = 0; i < 12; i++) {
                int value = parts[i];
                if (value == 0) {
                    block.put(0);
                } else {
                    block.putShort(value);
                }
            }
        } else {
            block.put(255).put(255).putShort(npcId);
        }
        //try running it. dont know if itll work lol.
        final BodyPart[] colors = new BodyPart[] {appearance.getHair(), appearance.getTorso(), appearance.getLegs(), appearance.getFeet(), appearance.getSkin()};
        for (int i = 0; i < colors.length; i++) {//colours
            block.put(colors[i].getColor());
        }

        block.putShort(appearance.getStandAnimation());
        block.putShort(appearance.getStandTurnAnimation());
        block.putShort(appearance.getWalkAnimation());
        block.putShort(appearance.getTurn180());
        block.putShort(appearance.getTurn90cw());
        block.putShort(appearance.getTurn90ccw());
        block.putShort(appearance.getRunAnimation());

        block.putString(context.getName(true));

        block.put(context.getProperties().getCombatLevel());
        block.putShort(0);
        block.put(0);//is hidden

        appearance.setMd5AppeareanceDataHash(ByteBufferUtils.encryptUsingMD5(block.array()));
        appearance.getPlayer().getRenderInfo().totalRenderDataSentLength = block.array().length;
        appearance.getPlayer().getRenderInfo().cachedAppearencesHashes[appearance.getPlayer().getIndex()] = appearance.getMD5AppeareanceDataHash();

		//these two in the bottom probably arent correct.
        buffer.put128Byte(block.toByteBuffer().position());
		buffer.putA(block);
		//System.err.println(Arrays.toString(block.array()));

        //System.out.println("appearance size: " + buffer.array().length);

    }

    @Override
    public int data() {
        return getData();
    }

    @Override
    public int ordinal() {
        return getOrdinal();
    }

    /**
     * Gets the ordinal for this flag.
     *
     * @return The flag ordinal.
     */
    public static int getOrdinal() {
        return 6;
    }

    /**
     * Gets the mask data.
     *
     * @return The mask data.
     */
    public static int getData() {
        return 1;
    }
}