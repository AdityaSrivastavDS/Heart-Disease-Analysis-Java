package com.heartdisease.ml;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class ModelDeployment {
    public static void deployModel(String modelPath, String dataPath) throws Exception {
        Classifier classifier = (Classifier) weka.core.SerializationHelper.read(modelPath);
        DataSource dataSource = new DataSource(dataPath);
        Instances data = dataSource.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

        for (int i = 0; i < data.numInstances(); i++) {
            Instance instance = data.instance(i);
            double result = classifier.classifyInstance(instance);
            System.out.println("Prediction: " + result);
        }
    }
}
