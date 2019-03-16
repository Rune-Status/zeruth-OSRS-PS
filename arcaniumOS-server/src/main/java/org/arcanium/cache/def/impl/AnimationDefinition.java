package org.arcanium.cache.def.impl;

import org.arcanium.cache.Cache;
import org.arcanium.cache.misc.buffer.ByteBufferUtils;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents an animation's definitions.
 *
 * @author Emperor
 */
public final class AnimationDefinition {

    public int maxLoops;
    public int anInt2137;
    public int[] frameIDs;
    public int precedenceAnimating;
    public boolean aBoolean2141 = false;
    public int forcedPriority;
    public int rightHandItem;
    public int leftHandItem = -1;
    public int[][] handledSounds;
    public boolean[] interleaveLeave;
    public int[] anIntArray2151;
    public boolean stretches;
    public int[] frameLengths;
    public int replayMode;
    public boolean aBoolean2158;
    public boolean aBoolean2159;
    public int priority;
    public int frameStep;
    boolean newHeader;

    // added
    public int[] soundMinDelay;
    public int[] soundMaxDelay;
    public int[] anIntArray1362;
    public boolean effect2Sound;

    private static final Map<Integer, AnimationDefinition> animDefs = new HashMap<>();

    public static final AnimationDefinition forId(int emoteId) {
        try {
            AnimationDefinition defs = animDefs.get(emoteId);
            if (defs != null) {
                return defs;
            }
            byte[] data = Cache.getIndexes()[20].getFileData(emoteId >>> 7, emoteId & 0x7f);
            defs = new AnimationDefinition();
            if (data != null) {
                defs.readValueLoop(ByteBuffer.wrap(data));
            }
            defs.method2394();
            animDefs.put(emoteId, defs);
            return defs;
        } catch (Throwable t) {
            return null;
        }
    }

    private void readValueLoop(ByteBuffer buffer) {
        for (; ; ) {
            int opcode = buffer.get() & 0xFF;
            if (opcode == 0) {
                break;
            }
            readValues(buffer, opcode);
            if (replayMode != 2)
                System.out.println("Replay Mode: " + replayMode);
        }
    }

    /**
     * Gets the duration of this animation in milliseconds.
     *
     * @return The duration.
     */
    public int getDuration() {
        if (frameLengths == null) {
            return 0;
        }
        int duration = 0;
        for (int i : frameLengths) {
            if (i > 100) {
                continue;
            }
            duration += i * 20;
        }
        return duration;
    }

    /**
     * Gets the duration of this animation in (600ms) ticks.
     *
     * @return The duration in ticks.
     */
    public int getDurationTicks() {
        int ticks = getDuration() / 600;
        return ticks < 1 ? 1 : ticks;
    }

    private void readValues(ByteBuffer buffer, int opcode) {
        if (opcode == 1) {
            int length = buffer.getShort() & 0xFFFF;
            frameLengths = new int[length];
            for (int i = 0; i < length; i++) {
                frameLengths[i] = buffer.getShort() & 0xFFFF;
            }
            frameIDs = new int[length];
            for (int i = 0; i < length; i++) {
                frameIDs[i] = buffer.getShort() & 0xFFFF;
            }
            for (int i = 0; i < length; i++) {
                frameIDs[i] = ((buffer.getShort() & 0xFFFF << 16) + frameIDs[i]);
            }
        } else if (opcode != 2) {
            if (opcode != 3) {
                if (opcode == 4)
                    stretches = true;
                else if (opcode == 5)
                    forcedPriority = buffer.get() & 0xFF;
                else if (opcode != 6) {
                    if (opcode == 7)
                        rightHandItem = buffer.getShort() & 0xFFFF;
                    else if ((opcode ^ 0xffffffff) != -9) {
                        if (opcode != 9) {
                            if (opcode != 10) {
                                if (opcode == 11)
                                    replayMode = buffer.get() & 0xFF;
                                else if (opcode == 12) {
                                    int i = buffer.get() & 0xFF;
                                    anIntArray2151 = new int[i];
                                    for (int i_19_ = 0; ((i_19_ ^ 0xffffffff) > (i ^ 0xffffffff)); i_19_++)
                                        anIntArray2151[i_19_] = buffer.getShort() & 0xFFFF;
                                    for (int i_20_ = 0; i > i_20_; i_20_++)
                                        anIntArray2151[i_20_] = ((buffer.getShort() & 0xFFFF << 16) + anIntArray2151[i_20_]);
                                } else if (opcode == 13) {
                                    // opcode 13
                                    int i = buffer.getShort() & 0xFFFF;
                                    handledSounds = new int[i][];
                                    for (int i_21_ = 0; i_21_ < i; i_21_++) {
                                        int i_22_ = buffer.get() & 0xFF;
                                        if ((i_22_ ^ 0xffffffff) < -1) {
                                            handledSounds[i_21_] = new int[i_22_];
                                            handledSounds[i_21_][0] = ByteBufferUtils.getTriByte(buffer);
                                            for (int i_23_ = 1; ((i_22_ ^ 0xffffffff) < (i_23_ ^ 0xffffffff)); i_23_++) {
                                                handledSounds[i_21_][i_23_] = buffer.getShort() & 0xFFFF;
                                            }
                                        }
                                    }
                                } else if (opcode == 14) {
                                    aBoolean2141 = true;
                                } else {
                                    System.out.println("Unhandled animation opcode " + opcode);
                                }
                            } else
                                priority = buffer.get() & 0xFF;
                        } else
                            precedenceAnimating = buffer.get() & 0xFF;
                    } else
                        maxLoops = buffer.get() & 0xFF;
                } else
                    leftHandItem = buffer.getShort() & 0xFFFF;
            } else {
                interleaveLeave = new boolean[256];
                int length = buffer.get() & 0xFF;
                for (int i = 0; i < length; i++) {
                    interleaveLeave[buffer.get() & 0xFF] = true;
                }
            }
        } else
            frameStep = buffer.getShort() & 0xFFFF;
        if (replayMode != 2) {
            System.out.println("Replay Mode: " + replayMode);
        }
    }

    public void method2394() {
        if (precedenceAnimating == -1) {
            if (interleaveLeave == null)
                precedenceAnimating = 0;
            else
                precedenceAnimating = 2;
        }
        if (priority == -1) {
            if (interleaveLeave == null)
                priority = 0;
            else
                priority = 2;
        }
    }

    public AnimationDefinition() {
        maxLoops = 99;
        rightHandItem = -1;
        precedenceAnimating = -1;
        stretches = false;
        forcedPriority = 5;
        aBoolean2159 = false;
        frameStep = -1;
        replayMode = 2;
        aBoolean2158 = false;
        priority = -1;
    }
}