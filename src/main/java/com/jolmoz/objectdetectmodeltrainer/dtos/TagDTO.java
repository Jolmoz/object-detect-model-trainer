package com.jolmoz.objectdetectmodeltrainer.dtos;

import com.jolmoz.objectdetectmodeltrainer.model.Tag;

public class TagDTO {
    private long id;
    private String name;
    private String color;

    public TagDTO() {

    }

    public TagDTO(Tag tag) {
        this.color = tag.getColor();
        this.id = tag.getId();
        this.name = tag.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
