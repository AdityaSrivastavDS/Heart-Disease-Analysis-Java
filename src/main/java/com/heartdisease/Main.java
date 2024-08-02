package com.heartdisease;

import com.heartdisease.data.HeartDiseaseData;
import com.heartdisease.data.DataPreprocessing;
import com.heartdisease.eda.EDA;
import com.heartdisease.visualization.Visualization;
import com.heartdisease.ml.MLModel;
import com.heartdisease.ml.ModelDeployment;
import org.apache.commons.csv.CSVRecord;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Step 1: Load and Explore Data
        List<CSVRecord> csvRecords = HeartDiseaseData.loadCSV("src/resources/heart_disease_data.csv");

        // Step 2: Data Preprocessing
        List<HeartDiseaseRecord> records = DataPreprocessing.preprocess(csvRecords);

        // Step 3: Perform EDA
        EDA.performEDA(records);

        // Step 4: Create 3D Visualization
        Visualization.create3DScatterPlot(records);

        // Step 5: Build and Train Machine Learning Model
        try {
            MLModel.buildAndTrainModel("src/resources/heart_disease_data.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Step 6: Deploy the Model
        try {
            ModelDeployment.deployModel("heartDiseaseModel.model", "src/resources/heart_disease_data.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
