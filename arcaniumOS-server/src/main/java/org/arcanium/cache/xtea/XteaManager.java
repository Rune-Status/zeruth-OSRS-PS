package org.arcanium.cache.xtea;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

public class XteaManager {

    private static Map<Integer, int[]> mapKeys = new HashMap<Integer, int[]>();

    public static void init() {
        try {
            if (!loadPackedFile()) {
                loadUnpacked();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void loadUnpacked() throws IOException {
        File directory = new File(".repository/xtea/unpacked/");
        DataOutputStream output = new DataOutputStream(new FileOutputStream(".repository/xtea/packedKeys.bin"));
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    BufferedReader input = new BufferedReader(new FileReader(file));
                    int id = Integer.parseInt(file.getName().substring(0, file.getName().indexOf(".")));
                    int[] keys = new int[4];
                    output.writeShort(id);
                    for (int i = 0; i < 4; i++) {
                        String line = input.readLine();
                        if (line != null) {
                            keys[i] = Integer.parseInt(line);
                        } else {
                            System.err.println("Corrupted XTEA file : " + id + "; line: " + line);
                            keys[i] = 0;
                        }
                        output.writeInt(keys[i]);
                    }
                    input.close();
                    mapKeys.put(id, keys);
                }
            }
        }
    }

    public static boolean loadPackedFile() throws IOException {
        File file = new File("./data/xtea/packedKeys.bin");
        if (!file.exists()) {
            return false;
        }
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        ByteBuffer buffer = raf.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, raf.length());
        while (buffer.remaining() > 0) {
            int id = buffer.getShort() & 0xFFFF;
            int[] key = new int[4];
            for (int i2 = 0; i2 < 4; i2++) {
                key[i2] = buffer.getInt();
            }
            mapKeys.put(id, key);
        }
        return true;
    }

    private static final int[] defaultKeys = new int[4];

    public static int[] getKey(int region) {
        return mapKeys.getOrDefault(region, defaultKeys);
    }

    public static Map<Integer, int[]> getMapKeys() {
        return mapKeys;
    }

    /*
     * public static boolean loadPackedFile() throws IOException { File file =
     * new File("data/objects/mapdata/packed.dat"); if (!file.exists()) { return
     * false; } DataInputStream in = new DataInputStream(new
     * FileInputStream(file)); while(in.available() > 0) { int id =
     * in.readInt(); if(new File("data/objects/mapdata/unpacked/" + id +
     * ".txt").exists()) { for (int i2 = 0; i2 < 4; i2++) { in.readInt(); }
     * continue; } int[] key = new int[4]; for (int i2 = 0; i2 < 4; i2++) {
     * key[i2] = in.readInt(); } mapKeys.put(id, key); } return true; }
     */
}