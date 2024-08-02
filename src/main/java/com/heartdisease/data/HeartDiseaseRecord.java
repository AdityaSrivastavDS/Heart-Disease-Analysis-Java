package com.heartdisease.data;

public class HeartDiseaseRecord {
    int age;
    int sex;
    // other fields

    public HeartDiseaseRecord(int age, int sex /*, other fields*/) {
        this.age = age;
        this.sex = sex;
        // initialize other fields
    }

    // Getters and Setters
    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    // other getters and setters
}
