package org.example.write;

import java.io.*;
import java.util.Map;

public class ResultWriter {

    public void write(Map<String, Double> totals, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (Map.Entry<String, Double> entry : totals.entrySet()) {
                String company = entry.getKey();
                Double sum = entry.getValue();
                String line = company + " - " + String.format("%.2f", sum);
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи файла " + path, e);
        }
    }
}
