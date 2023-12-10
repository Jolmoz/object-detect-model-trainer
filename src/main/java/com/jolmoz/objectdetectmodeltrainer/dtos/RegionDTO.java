package com.jolmoz.objectdetectmodeltrainer.dtos;

import com.jolmoz.objectdetectmodeltrainer.model.Region;

public class RegionDTO {
    private long id;
    private String type;
    private TagDTO tag;
    private BoundingBoxDTO boundingBox;

    public RegionDTO() {

    }

    public RegionDTO(Region region) {
        this.boundingBox = new BoundingBoxDTO(region.getBoundingBox());
        this.id = region.getId();
        this.tag = new TagDTO(region.getTag());
        this.type = region.getType();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BoundingBoxDTO getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBoxDTO boundingBox) {
        this.boundingBox = boundingBox;
    }

    public TagDTO getTag() {
        return tag;
    }

    public void setTag(TagDTO tag) {
        this.tag = tag;
    }
}
