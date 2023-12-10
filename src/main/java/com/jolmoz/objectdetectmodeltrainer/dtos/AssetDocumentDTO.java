package com.jolmoz.objectdetectmodeltrainer.dtos;

import com.jolmoz.objectdetectmodeltrainer.model.AssetDocument;

public class AssetDocumentDTO {
    private String format;
    private long id;
    private String name;
    private String path;
    private int width;
    private int height;
    private int state;
    private int type;

    public AssetDocumentDTO() {

    }

    public AssetDocumentDTO(AssetDocument assetDocument) {
        this.format = assetDocument.getFormat();
        this.height = assetDocument.getHeight();
        this.width = assetDocument.getWidth();
        this.id = assetDocument.getId();
        this.name = assetDocument.getName();
        this.path = assetDocument.getPath();
        this.state = assetDocument.getState();
        this.type = assetDocument.getType();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
