package com.heartdisease.eda;

import com.heartdisease.data.HeartDiseaseRecord;

import java.util.List;

public class EDA {
    public static void performEDA(List<HeartDiseaseRecord> records) {
        // Calculate mean, median, mode, and other statistics
        double averageAge = records.stream().mapToInt(HeartDiseaseRecord::getAge).average().orElse(0);
        System.out.println("Average Age: " + averageAge);

        // Calculate other statistics and correlations
    }
}
