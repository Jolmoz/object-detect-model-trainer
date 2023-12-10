package com.jolmoz.objectdetectmodeltrainer.dtos;


public class TrainingResultDTO {
    private long id;
    private String accuracy;
    private String recall;
    private String f1Score;
    private long trainingTime;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAccuracy() {
        return accuracy;
    }
    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }
    public String getRecall() {
        return recall;
    }
    public void setRecall(String recall) {
        this.recall = recall;
    }
    public String getF1Score() {
        return f1Score;
    }
    public void setF1Score(String f1Score) {
        this.f1Score = f1Score;
    }
    public long getTrainingTime() {
        return trainingTime;
    }
    public void setTrainingTime(long trainingTime) {
        this.trainingTime = trainingTime;
    }

}
