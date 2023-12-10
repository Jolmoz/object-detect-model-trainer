package com.jolmoz.objectdetectmodeltrainer.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jolmoz.objectdetectmodeltrainer.model.Asset;
import com.jolmoz.objectdetectmodeltrainer.model.DataSet;
import com.jolmoz.objectdetectmodeltrainer.model.Tag;

public class DataSetDTO {
    private long id;
    private String dataSetName;
    private String dataSetDescription;
    private List<AssetDTO> assets;
    private List<TagDTO> tags;
    private UserAccessDTO userAccessCreator;
    private UserAccessDTO userAccessLastEditor;
    private LocalDateTime creationDate;
    private LocalDateTime modifiedDate;
    private int version;

    public DataSetDTO() {

    }

    public DataSetDTO(DataSet dataSet) {
        this.id = dataSet.getId();
        List<AssetDTO> assetDTOs = new ArrayList<>();

        for (Asset asset : dataSet.getAssets()) {
            AssetDTO assetDTO = new AssetDTO(asset);
            assetDTOs.add(assetDTO);
        }
        this.assets = assetDTOs;

        List<TagDTO> tagDTOs = new ArrayList<>();

        for (Tag tag : dataSet.getTags()) {
            TagDTO tagDTO = new TagDTO(tag);
            tagDTOs.add(tagDTO);
        }
        this.tags = tagDTOs;

        this.creationDate = dataSet.getCreationDate();
        this.modifiedDate = dataSet.getModifiedDate();
        this.dataSetDescription = dataSet.getDataSetDescription();
        this.dataSetName = dataSet.getDataSetName();
        this.version = dataSet.getVersion();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataSetName() {
        return dataSetName;
    }

    public void setDataSetName(String dataSetName) {
        this.dataSetName = dataSetName;
    }

    public String getDataSetDescription() {
        return dataSetDescription;
    }

    public void setDataSetDescription(String dataSetDescription) {
        this.dataSetDescription = dataSetDescription;
    }

    public List<AssetDTO> getAssets() {
        return assets;
    }

    public void setAssets(List<AssetDTO> assets) {
        this.assets = assets;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
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
