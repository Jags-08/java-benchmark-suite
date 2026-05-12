package com.benchmark.engine;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvExportHandler {
    public static void export(String algorithm, int n, long timeNs, String filename) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.printf("%s,%d,%d%n", algorithm, n, timeNs);
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}
