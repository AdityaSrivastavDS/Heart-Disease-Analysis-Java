package com.heartdisease.data;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVRecord;

public class DataPreprocessing {
    public static List<HeartDiseaseRecord> preprocess(List<CSVRecord> csvRecords) {
        return csvRecords.stream().map(record -> {
            int age = Integer.parseInt(record.get("age"));
            int sex = Integer.parseInt(record.get("sex"));
            // Parse other fields accordingly
            return new HeartDiseaseRecord(age, sex /*, other fields*/);
        }).collect(Collectors.toList());
    }
}
