package com.heartdisease.ml;

import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class MLModel {
    public static void buildAndTrainModel(String filePath) throws Exception {
        DataSource dataSource = new DataSource(filePath);
        Instances data = dataSource.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

        Classifier classifier = new J48();
        classifier.buildClassifier(data);

        // Save the model
        weka.core.SerializationHelper.write("heartDiseaseModel.model", classifier);
    }
}
