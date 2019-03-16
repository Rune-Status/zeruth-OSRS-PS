package org.arcanium.game.world.update.flag.player;

import org.arcanium.game.world.update.flag.UpdateFlag;
import org.arcanium.game.world.update.flag.context.ChatMessage;
import org.arcanium.net.packet.IoBuffer;
import org.arcanium.tools.StringUtils;

/**
 * Handles the chat flag.
 *
 * @author Emperor
 */
public class ChatFlag extends UpdateFlag<ChatMessage> {

    /**
     * Constructs a new {@code ChatFlag.java} {@code Object}.
     *
     * @param context The context.
     */
    public ChatFlag(ChatMessage context) {
        super(context);
    }

    @Override
    public void write(IoBuffer buffer) {
        byte[] chatStr = new byte[256];
        chatStr[0] = (byte) context.getText().length();
        int offset = 1 + StringUtils.encryptPlayerChat(chatStr, 0, 1, context.getText().length(), context.getText().getBytes());
        buffer.putShort128(context.getEffects()); //correct
        buffer.put(context.getPlayer().getDetails().getRights().ordinal()); //correct
        buffer.putN(0);
        buffer.put(offset + 1);
        buffer.putReverseA(chatStr, 0, offset);

    }

    @Override
    public int data() {
        return maskData();
    }

    @Override
    public int ordinal() {
        return 9;
    }

    /**
     * Gets the mask data of the chat update flag.
     *
     * @return The mask data.
     */
    public static int maskData() {
        return 16;
    }
}