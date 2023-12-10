package com.jolmoz.objectdetectmodeltrainer.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
public class ModelHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private String architecture;

    @Column(nullable = true)
    private String epochs;

    @Column(nullable = true)
    private int learningRate;

    @Column(nullable = true)
    private int batchSize;

    private int modelVersion;

    @ManyToMany
    private List<DataSet> dataSets;

    private long userAccessTrainerId;

    @ManyToOne
    private Model model;

    @OneToOne
    private TrainingResult trainingResult;

    @CreationTimestamp
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime trainingStartDate;

    @UpdateTimestamp
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime trainingFinishDate;

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

    public List<DataSet> getDataSets() {
        return dataSets;
    }

    public void setDataSets(List<DataSet> dataSets) {
        this.dataSets = dataSets;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
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

    public TrainingResult getTrainingResult() {
        return trainingResult;
    }

    public void setTrainingResult(TrainingResult trainingResult) {
        this.trainingResult = trainingResult;
    }

    public long getUserAccessTrainerId() {
        return userAccessTrainerId;
    }

    public void setUserAccessTrainerId(long userAccessTrainerId) {
        this.userAccessTrainerId = userAccessTrainerId;
    }

    
}
