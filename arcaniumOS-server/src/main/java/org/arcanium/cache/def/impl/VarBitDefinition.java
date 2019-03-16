package org.arcanium.cache.def.impl;

import org.arcanium.cache.Cache;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Vashmeed
 */
public class VarBitDefinition {

    public int varbitId;

    public int basevar;
    public int startbit;
    public int endbit;

    public int varDomain;

    /**
     * The definitions mapping.
     */
    private static final Map<Integer, VarBitDefinition> varBitDefinitions = new HashMap<>();

    /**
     *
     */
    public static final VarBitDefinition forId(int varBitId) {
        VarBitDefinition def = varBitDefinitions.get(varBitId);
        if (def != null) {
            return def;
        }
        byte[] data = Cache.getIndexes()[2].getFileData(14, varBitId);
        def = new VarBitDefinition();
        def.varbitId = varBitId;
        if (data != null) {
            def.readValueLoop(ByteBuffer.wrap(data));
        }
        varBitDefinitions.put(varBitId, def);
        return def;
    }

    /**
     * Reads and handles all data from the input stream.
     *
     * @param buffer The input stream.
     */
    private void readValueLoop(ByteBuffer buffer) {
        for (; ; ) {
            int opcode = buffer.get() & 0xFF;
            if (opcode == 0) {
                break;
            }
            decode(buffer, opcode);
        }
    }

    /**
     * Reads the opcode values from the input stream.
     *
     * @param buf    The input stream.
     * @param opcode The opcode to handle.
     */
    public void decode(ByteBuffer buf, int opcode) {
        if (opcode == 1) {
            this.basevar = buf.getShort() & 0xFFFF;
            this.startbit = buf.get() & 0xFF;
            this.endbit = buf.get() & 0xFF;
        }
    }

    public VarBitDefinition() {
        basevar = 0;
        startbit = 0;
        endbit = 0;
    }

    private String getVarDomainName() {
        switch (varDomain) {
            case 0:
                return "PLAYER";
            case 1:
                return "NPC";
            case 2:
                return "CLIENT";
            case 3:
                return "WORLD";
            case 4:
                return "REGION";
            case 5:
                return "OBJECT";
            case 6:
                return "CLAN";
            case 7:
                return "CLAN SETTING";
            default:
                return "UNKNOWN(" + varDomain + ")";
        }

    }
}
