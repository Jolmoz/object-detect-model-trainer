package com.jolmoz.objectdetectmodeltrainer.dtos;

import com.jolmoz.objectdetectmodeltrainer.model.BoundingBox;

public class BoundingBoxDTO {

    private long id;
    private double height;
    private double width;
    private double left;
    private double top;

    public BoundingBoxDTO() {

    }

    public BoundingBoxDTO(BoundingBox boundingBox) {
        this.height = boundingBox.getHeight();
        this.id = boundingBox.getId();
        this.left = boundingBox.getLeft();
        this.top = boundingBox.getTop();
        this.width = boundingBox.getWidth();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double top) {
        this.top = top;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
