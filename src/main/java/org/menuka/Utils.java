package org.menuka;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
    public static final String path = System.getProperty("user.dir");
    public static final String DATA_PATH = path + File.separator + "data";

    public static long[] getValuesOfFile(String operation, String set, String fileNumber) {
        long[] values = new long[0];
        // data/insert/set1/data_1.txt
        String filePath = DATA_PATH + File.separator + operation +
                File.separator + "set" + set +
                File.separator + "data_" + 1 + ".txt";
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
            String[] split = content.split(",");
            values = new long[split.length];
            for (int j = 0; j < split.length; j++) {
                values[j] = Long.parseLong(split[j].trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }

    public static long getDuration(long endTime, long startTime) {
        return (endTime - startTime) / 1000;
    }

    public static long getTime() {
        return System.nanoTime();
    }

    public static void printDuration(long duration, String operation, String set, String fileNUmber) {
        System.out.println(operation + " | set: " + set + " | data_" + fileNUmber + " | duration: " + duration);
        System.out.println("");
    }
}
