package com.jolmoz.objectdetectmodeltrainer.control;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jolmoz.objectdetectmodeltrainer.dtos.AssetDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.AssetDocumentDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.DataSetDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.ModelDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.RegionDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.TagDTO;
import com.jolmoz.objectdetectmodeltrainer.model.Asset;
import com.jolmoz.objectdetectmodeltrainer.model.AssetDocument;
import com.jolmoz.objectdetectmodeltrainer.model.DataSet;
import com.jolmoz.objectdetectmodeltrainer.model.Model;
import com.jolmoz.objectdetectmodeltrainer.model.Region;
import com.jolmoz.objectdetectmodeltrainer.model.Tag;
import com.jolmoz.objectdetectmodeltrainer.repository.AssetDocumentRepository;
import com.jolmoz.objectdetectmodeltrainer.repository.AssetRepository;
import com.jolmoz.objectdetectmodeltrainer.repository.DataSetRepository;
import com.jolmoz.objectdetectmodeltrainer.repository.ModelRepository;
import com.jolmoz.objectdetectmodeltrainer.repository.RegionRepository;
import com.jolmoz.objectdetectmodeltrainer.repository.TagRepository;

@Service
public class ModelManagerControl {

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    DataSetRepository dataSetRepository;

    @Autowired
    AssetDocumentRepository assetDocumentRepository;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    DataIkDataControl dataIkDataControl;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ModelManagerControl() {
        modelMapper.getConfiguration().setSkipNullEnabled(true);
    }

    public ResponseEntity<List<ModelDTO>> getAllModels(String token) {
        List<Model> models = modelRepository.findAll();
        return dataIkDataControl.getModelDTOsWithUsers(token, models);
    }

    public ResponseEntity<ModelDTO> saveModel(ModelDTO modelDTO) {
        Model model = modelMapper.map(modelDTO, Model.class);
        ModelDTO modelToReturn = new ModelDTO(modelRepository.saveAndFlush(model));
        return new ResponseEntity<ModelDTO>(modelToReturn, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteModel(ModelDTO modelDTO) {
        Model model = modelRepository.findById(modelDTO.getId()).get();
        modelRepository.delete(model);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    public ResponseEntity<List<DataSetDTO>> getAllDataSets(String token) {
        List<DataSet> datasets = dataSetRepository.findAll();
        return dataIkDataControl.getDataSetDTOsWithUsers(token, datasets);
    }

    public ResponseEntity<DataSetDTO> saveDataSet(DataSetDTO dataSetDTO) {
        DataSet dataSet = modelMapper.map(dataSetDTO, DataSet.class);
        for (Tag tag : dataSet.getTags()) {
            tag.setDataSet(dataSet);
        }
        for (Asset asset : dataSet.getAssets()) {
            asset.setDataSet(dataSet);
        }
        DataSetDTO dataSetToReturn = new DataSetDTO(dataSetRepository.saveAndFlush(dataSet));
        return new ResponseEntity<DataSetDTO>(dataSetToReturn, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteDataSet(DataSetDTO dataSetDTO) {
        DataSet dataSet = dataSetRepository.findById(dataSetDTO.getId()).get();
        dataSetRepository.delete(dataSet);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    public ResponseEntity<List<AssetDocumentDTO>> getAllAssetDocumentDTOs() {
        List<AssetDocument> assetDocuments = assetDocumentRepository.findAll();
        List<AssetDocumentDTO> assetDocumentDTOs = new ArrayList<>();

        for (AssetDocument assetDocument : assetDocuments) {
            AssetDocumentDTO assetDocumentDTO = new AssetDocumentDTO(assetDocument);
            assetDocumentDTOs.add(assetDocumentDTO);
        }

        return new ResponseEntity<List<AssetDocumentDTO>>(assetDocumentDTOs, HttpStatus.OK);
    }

    public ResponseEntity<AssetDocumentDTO> saveAssetDocument(AssetDocumentDTO assetDocumentDTO) {
        AssetDocument assetDocument = modelMapper.map(assetDocumentDTO, AssetDocument.class);
        AssetDocumentDTO assetDocumentToReturn = new AssetDocumentDTO(
                assetDocumentRepository.saveAndFlush(assetDocument));
        return new ResponseEntity<AssetDocumentDTO>(assetDocumentToReturn, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteAssetDocument(AssetDocumentDTO assetDocumentDTO) {
        AssetDocument assetDocument = assetDocumentRepository.findById(assetDocumentDTO.getId()).get();
        assetDocumentRepository.delete(assetDocument);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    public ResponseEntity<List<AssetDTO>> getAllAssetDTOs() {
        List<Asset> assets = assetRepository.findAll();
        List<AssetDTO> assetDTOs = new ArrayList<>();

        for (Asset asset : assets) {
            AssetDTO assetDTO = new AssetDTO(asset);
            assetDTOs.add(assetDTO);
        }

        return new ResponseEntity<List<AssetDTO>>(assetDTOs, HttpStatus.OK);
    }

    public ResponseEntity<AssetDTO> saveAsset(AssetDTO assetDTO) {
        Asset asset = modelMapper.map(assetDTO, Asset.class);
        AssetDTO assetToReturn = new AssetDTO(
                assetRepository.saveAndFlush(asset));
        return new ResponseEntity<AssetDTO>(assetToReturn, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteAsset(AssetDTO assetDTO) {
        Asset asset = assetRepository.findById(assetDTO.getId()).get();
        assetRepository.delete(asset);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    public ResponseEntity<List<TagDTO>> getAllTagDTOs() {
        List<Tag> tags = tagRepository.findAll();
        List<TagDTO> tagDtos = new ArrayList<>();

        for (Tag tag : tags) {
            TagDTO tagDTO = new TagDTO(tag);
            tagDtos.add(tagDTO);
        }

        return new ResponseEntity<List<TagDTO>>(tagDtos, HttpStatus.OK);
    }

    public ResponseEntity<TagDTO> saveTag(TagDTO tagDTO) {
        Tag tag = modelMapper.map(tagDTO, Tag.class);
        TagDTO tagToReturn = new TagDTO(
                tagRepository.saveAndFlush(tag));
        return new ResponseEntity<TagDTO>(tagToReturn, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteTag(TagDTO tagDTO) {
        Tag tag = tagRepository.findById(tagDTO.getId()).get();
        tagRepository.delete(tag);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    public ResponseEntity<List<RegionDTO>> getAllRegionDTOs() {
        List<Region> regions = regionRepository.findAll();
        List<RegionDTO> regionDTOs = new ArrayList<>();

        for (Region region : regions) {
            RegionDTO regionDTO = new RegionDTO(region);
            regionDTOs.add(regionDTO);
        }

        return new ResponseEntity<List<RegionDTO>>(regionDTOs, HttpStatus.OK);
    }

    public ResponseEntity<RegionDTO> saveRegion(RegionDTO regionDTO) {
        Region region = modelMapper.map(regionDTO, Region.class);
        RegionDTO regionToReturn = new RegionDTO(
                regionRepository.saveAndFlush(region));
        return new ResponseEntity<RegionDTO>(regionToReturn, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteRegion(RegionDTO regionDTO) {
        Region tag = regionRepository.findById(regionDTO.getId()).get();
        regionRepository.delete(tag);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
