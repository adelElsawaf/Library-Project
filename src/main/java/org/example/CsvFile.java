package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFile {
    public File csvFileController;
    public String fullFileLocation;

    public CsvFile(String fullFileLocation) {
        csvFileController = new File(fullFileLocation);
        this.fullFileLocation = fullFileLocation;
    }

    public static List<String> read(String fileLocation) {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(fileLocation));
            List<String> rows = new ArrayList<>();
            while (true) {
                String rowInfo = csvReader.readLine();
                if (rowInfo == null) {
                    break;
                }
                rows.add(rowInfo);
            }
            return rows;
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }

    public void create() {
        try {
            csvFileController.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public boolean isExist() {
        return csvFileController.exists() && !csvFileController.isDirectory();
    }

    public void insert(List<String> rows) {
        try {
            FileWriter csvWriter = new FileWriter(csvFileController, true);
            for (String row : rows) {
                csvWriter.append(row).append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }
}
