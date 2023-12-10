package com.jolmoz.objectdetectmodeltrainer.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
public class Model {

    public enum ModelType {
        OBJECTS
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String modelName;

    @Column(nullable = false)
    private String modelPath;

    @Column(nullable = true)
    private String modelDescription;

    @Column(nullable = true)
    private String architecture;

    @Column(nullable = true)
    private String epochs;

    @Column(nullable = true)
    private int learningRate;

    @Column(nullable = true)
    private int batchSize;

    @Column(nullable = true)
    private int trainingProcess;

    @ManyToMany
    private List<DataSet> dataSets;

    @Column(name = "\"model_type\"")
    @Enumerated(EnumType.STRING)
    private ModelType modelType;

    private long userAccessCreatorId;

    private long userAccessLastEditorId;

    @CreationTimestamp
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime modifiedDate;

    private int version;

    @Transient
    private boolean unchangeVersion;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isUnchangeVersion() {
        return unchangeVersion;
    }

    public void setUnchangeVersion(boolean unchangeVersion) {
        this.unchangeVersion = unchangeVersion;
    }

    @PreUpdate
    public void changeVersion() {
        if (!this.isUnchangeVersion()) {
            this.setVersion(this.getVersion() + 1);
            this.setUnchangeVersion(true);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

    public int getTrainingProcess() {
        return trainingProcess;
    }

    public void setTrainingProcess(int trainingProcess) {
        this.trainingProcess = trainingProcess;
    }

    public ModelType getModelType() {
        return modelType;
    }

    public void setModelType(ModelType modelType) {
        this.modelType = modelType;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

    public List<DataSet> getDataSets() {
        return dataSets;
    }

    public void setDataSets(List<DataSet> dataSets) {
        this.dataSets = dataSets;
    }

    public long getUserAccessCreatorId() {
        return userAccessCreatorId;
    }

    public void setUserAccessCreatorId(long userAccessCreatorId) {
        this.userAccessCreatorId = userAccessCreatorId;
    }

    public long getUserAccessLastEditorId() {
        return userAccessLastEditorId;
    }

    public void setUserAccessLastEditorId(long userAccessLastEditorId) {
        this.userAccessLastEditorId = userAccessLastEditorId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
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

}
