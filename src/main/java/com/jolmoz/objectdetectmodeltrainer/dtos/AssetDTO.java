package com.jolmoz.objectdetectmodeltrainer.dtos;

import java.util.ArrayList;
import java.util.List;

import com.jolmoz.objectdetectmodeltrainer.model.Asset;
import com.jolmoz.objectdetectmodeltrainer.model.Region;

public class AssetDTO {
    private long id;
    private AssetDocumentDTO assetDocument;
    private List<RegionDTO> regions;
    private DataSetDTO dataSet;

    public AssetDTO() {

    }

    public AssetDTO(Asset asset) {
        this.assetDocument = new AssetDocumentDTO(asset.getAssetDocument());
        this.id = asset.getId();

        List<RegionDTO> regionDTOs = new ArrayList<>();
        for (Region region : asset.getRegions()) {
            RegionDTO regionDTO = new RegionDTO(region);
            regionDTOs.add(regionDTO);
        }

        this.regions = regionDTOs;
    }

    public AssetDocumentDTO getAssetDocument() {
        return assetDocument;
    }

    public void setAssetDocument(AssetDocumentDTO assetDocument) {
        this.assetDocument = assetDocument;
    }

    public List<RegionDTO> getRegions() {
        return regions;
    }

    public void setRegions(List<RegionDTO> regions) {
        this.regions = regions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DataSetDTO getDataSet() {
        return dataSet;
    }

    public void setDataSet(DataSetDTO dataSet) {
        this.dataSet = dataSet;
    }

}
