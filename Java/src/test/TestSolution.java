package test;

import java.io.*;
import java.util.*;

public class TestSolution {

    private static final String CSV_1_PATH = "resources/1.csv";
    private static final String CSV_2_PATH = "resources/2.csv";
    private static final String OUTPUT_CSV_PATH = "resources/my_output.csv";

    public void combineFiles(File csv1, File csv2, File outputFile) throws Exception {
        Map<String, String[]> csv2Data = new HashMap<>();

        // Step 1: Read CSV2 into a map
        try (BufferedReader reader2 = new BufferedReader(new FileReader(csv2))) {
            String line;
            while ((line = reader2.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1) {
                    String key = parts[0];
                    String[] values = Arrays.copyOfRange(parts, 1, parts.length);
                    csv2Data.put(key, values);
                }
            }
        }

        // Step 2: Read CSV1, match with CSV2, and write combined lines to output
        try (
            BufferedReader reader1 = new BufferedReader(new FileReader(csv1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader1.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    String key = parts[0];
                    if (csv2Data.containsKey(key)) {
                        StringBuilder combined = new StringBuilder(line);
                        for (String val : csv2Data.get(key)) {
                            combined.append(",").append(val);
                        }
                        writer.write(combined.toString());
                        writer.newLine();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            File csv1 = new File(CSV_1_PATH);
            File csv2 = new File(CSV_2_PATH);
            File output = new File(OUTPUT_CSV_PATH);

            TestSolution solution = new TestSolution();
            solution.combineFiles(csv1, csv2, output);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
