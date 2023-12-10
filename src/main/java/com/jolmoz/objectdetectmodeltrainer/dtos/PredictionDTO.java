package com.jolmoz.objectdetectmodeltrainer.dtos;

import java.util.List;

public class PredictionDTO {
    private String name;
    private long num_boxes;
    private List<Integer> scores;
    private List<BoundingBoxDTO> pred_boxes;
    private List<String> pred_classes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNum_boxes() {
        return num_boxes;
    }

    public void setNum_boxes(long num_boxes) {
        this.num_boxes = num_boxes;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public List<BoundingBoxDTO> getPred_boxes() {
        return pred_boxes;
    }

    public void setPred_boxes(List<BoundingBoxDTO> pred_boxes) {
        this.pred_boxes = pred_boxes;
    }

    public List<String> getPred_classes() {
        return pred_classes;
    }

    public void setPred_classes(List<String> pred_classes) {
        this.pred_classes = pred_classes;
    }
}
