package com.jolmoz.objectdetectmodeltrainer.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jolmoz.objectdetectmodeltrainer.model.DataSet;
import com.jolmoz.objectdetectmodeltrainer.model.Model;
import com.jolmoz.objectdetectmodeltrainer.model.Model.ModelType;

public class ModelDTO {
    private long id;
    private String modelName;
    private String modelPath;
    private String modelDescription;
    private String architecture;
    private String epochs;
    private int learningRate;
    private int batchSize;
    private int trainingProcess;
    private List<DataSetDTO> dataSets;
    private ModelType modelType;
    private UserAccessDTO userAccessCreator;
    private UserAccessDTO userAccessLastEditor;
    private LocalDateTime creationDate;
    private LocalDateTime modifiedDate;
    private int version;

    public ModelDTO() {

    }

    public ModelDTO(Model model) {
        this.id = model.getId();
        this.architecture = model.getArchitecture();
        this.batchSize = model.getBatchSize();
        this.creationDate = model.getCreationDate();
        this.modifiedDate = model.getModifiedDate();

        List<DataSetDTO> datasSetDTOs = new ArrayList<>();
        for (DataSet dataSet : model.getDataSets()) {
            DataSetDTO dataSetDTO = new DataSetDTO(dataSet);
            datasSetDTOs.add(dataSetDTO);
        }
        this.dataSets = datasSetDTOs;

        this.epochs = model.getEpochs();
        this.learningRate = model.getLearningRate();
        this.modelDescription = model.getModelDescription();
        this.modelName = model.getModelName();
        this.modelPath = model.getModelPath();
        this.modelType = model.getModelType();
        this.trainingProcess = model.getTrainingProcess();
        this.version = model.getVersion();
        
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

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
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

    public int getTrainingProcess() {
        return trainingProcess;
    }

    public void setTrainingProcess(int trainingProcess) {
        this.trainingProcess = trainingProcess;
    }

    public List<DataSetDTO> getDataSets() {
        return dataSets;
    }

    public void setDataSets(List<DataSetDTO> dataSets) {
        this.dataSets = dataSets;
    }

    public ModelType getModelType() {
        return modelType;
    }

    public void setModelType(ModelType modelType) {
        this.modelType = modelType;
    }

    public UserAccessDTO getUserAccessCreator() {
        return userAccessCreator;
    }

    public void setUserAccessCreator(UserAccessDTO userAccessCreator) {
        this.userAccessCreator = userAccessCreator;
    }

    public UserAccessDTO getUserAccessLastEditor() {
        return userAccessLastEditor;
    }

    public void setUserAccessLastEditor(UserAccessDTO userAccessLastEditor) {
        this.userAccessLastEditor = userAccessLastEditor;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
