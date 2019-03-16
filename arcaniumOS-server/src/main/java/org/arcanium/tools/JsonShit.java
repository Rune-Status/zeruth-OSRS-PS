package org.arcanium.tools;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class JsonShit implements Runnable {

    public static void main(String[] args) {
        JsonShit shit = new JsonShit();
        shit.run();
        shit.done();
    }


    @Override
    public void run() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("./data/opcodes.json")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(reader);
        if(element.isJsonArray()) {
            for(JsonElement e : element.getAsJsonArray()) {
                JsonObject o = e.getAsJsonObject();
                parse(o);
            }
        } else if(element.isJsonObject()) {
            parse(element.getAsJsonObject());
        }
    }

    public void parse(JsonObject o) {
        int opcode = o.get("opcode").getAsInt();
        int size = o.get("size").getAsInt();

        if (o.has("decoder")) {

        }
        sizes[opcode] = size;
    }

    public void done() {
        System.out.println(Arrays.toString(sizes));
    }

    int[] sizes = new int[257];

}
