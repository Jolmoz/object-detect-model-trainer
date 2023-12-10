package com.jolmoz.objectdetectmodeltrainer.dtos;

import java.time.LocalDateTime;
import java.util.List;



public class ModelHistoryDTO {
    private long id;
    private String architecture;
    private String epochs;
    private int learningRate;
    private int batchSize;
    private int modelVersion;
    private List<DataSetDTO> dataSets;
    private UserAccessDTO userAccessTrainer;
    private ModelDTO model;
    private LocalDateTime trainingStartDate;
    private LocalDateTime trainingFinishDate;
    private TrainingResultDTO trainingResult;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getArchitecture() {
        return architecture;
    }
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }
    public String getEpochs() {
        return epochs;
    }
    public void setEpochs(String epochs) {
        this.epochs = epochs;
    }
    public int getLearningRate() {
        return learningRate;
    }
    public void setLearningRate(int learningRate) {
        this.learningRate = learningRate;
    }
    public int getBatchSize() {
        return batchSize;
    }
    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }
    public int getModelVersion() {
        return modelVersion;
    }
    public void setModelVersion(int modelVersion) {
        this.modelVersion = modelVersion;
    }
    public List<DataSetDTO> getDataSets() {
        return dataSets;
    }
    public void setDataSets(List<DataSetDTO> dataSets) {
        this.dataSets = dataSets;
    }
    public UserAccessDTO getUserAccessTrainer() {
        return userAccessTrainer;
    }
    public void setUserAccessTrainer(UserAccessDTO userAccessTrainer) {
        this.userAccessTrainer = userAccessTrainer;
    }
    public ModelDTO getModel() {
        return model;
    }
    public void setModel(ModelDTO model) {
        this.model = model;
    }
    public LocalDateTime getTrainingStartDate() {
        return trainingStartDate;
    }
    public void setTrainingStartDate(LocalDateTime trainingStartDate) {
        this.trainingStartDate = trainingStartDate;
    }
    public LocalDateTime getTrainingFinishDate() {
        return trainingFinishDate;
    }
    public void setTrainingFinishDate(LocalDateTime trainingFinishDate) {
        this.trainingFinishDate = trainingFinishDate;
    }
    public TrainingResultDTO getTrainingResult() {
        return trainingResult;
    }
    public void setTrainingResult(TrainingResultDTO trainingResult) {
        this.trainingResult = trainingResult;
    }

}
