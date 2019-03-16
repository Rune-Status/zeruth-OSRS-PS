package org.arcanium.cache.def.impl;

import org.arcanium.cache.Cache;
import org.arcanium.game.node.entity.player.Player;

public class VarBitManager {

    public static final int[] masklookup = new int[32];

    static {
        int i = 2;
        for (int i2 = 0; i2 < 32; i2++) {
            masklookup[i2] = i - 1;
            i += i;
        }
    }

    private int[] values;
    private Player player;

    public VarBitManager(Player player) {
        this.player = player;
        values = new int[Cache.getIndexes()[2].getFilesSize(14) + 1];
    }

    @Deprecated
    public void sendVarOld(int id, int value) {
        // sendVar(id, value, false);
    }

    public boolean sendVar(int id, int value) {
        return sendVar(id, value, false);
    }

    @Deprecated
    public void forceSendVarOld(int id, int value) {
        // sendVar(id, value, true);
    }

    public void forceSendVar(int id, int value) {
        sendVar(id, value, true);
    }

    private boolean sendVar(int id, int value, boolean force) {
        if (id < 0 || id >= values.length) // temporarly
            return false;
        if (!force && values[id] == value)
            return false;
        setVar(id, value);
        sendVarPacket(id);
        return true;
    }

    public void setVar(int id, int value) {
        values[id] = value;
    }

    public int getValue(int id) {
        return values[id];
    }

    @Deprecated
    public void forceSendVarBitOld(int id, int value) {
        // setVarBit(id, value, 0x1 | 0x2);
    }

    public void forceSendVarBit(int id, int value) {
        setVarBit(id, value, 0x1 | 0x2);
    }

    @Deprecated
    public void sendVarBitOld(int id, int value) {
        // setVarBit(id, value, 0x1);
    }

    public boolean sendVarBit(int id, int value) {
        return setVarBit(id, value, 0x1);
    }

    @Deprecated
    public void setVarBitOld(int id, int value) {
        setVarBit(id, value, 0);
    }

    public void setVarBit(int id, int value) {
        setVarBit(id, value, 0);
    }

    public int getBitValue(int id) {
        VarBitDefinition defs = VarBitDefinition.forId(id);
        return values[defs.basevar] >> defs.startbit & masklookup[defs.endbit - defs.startbit];
    }

    private boolean setVarBit(int id, int value, int flag) {
        VarBitDefinition defs = VarBitDefinition.forId(id);
        int mask = masklookup[defs.endbit - defs.startbit];
        if (value < 0 || value > mask)
            value = 0;
        mask <<= defs.startbit;
        int varpValue = (values[defs.basevar] & (mask ^ 0xffffffff) | value << defs.startbit & mask);
        if ((flag & 0x2) != 0 || varpValue != values[defs.basevar]) {
            setVar(defs.basevar, varpValue);
            if ((flag & 0x1) != 0)
                sendVarPacket(defs.basevar);
            return true;
        }
        return false;
    }

    @SuppressWarnings("deprecation")
    private void sendVarPacket(int id) {
        player.getPacketDispatch().sendVar(id, values[id]);
    }
}
