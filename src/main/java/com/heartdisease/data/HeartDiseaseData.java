package com.heartdisease.data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class HeartDiseaseData {
    public static List<CSVRecord> loadCSV(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            return csvParser.getRecords();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
