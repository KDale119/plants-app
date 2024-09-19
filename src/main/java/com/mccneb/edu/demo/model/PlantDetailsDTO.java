package com.mccneb.edu.demo.model;

import java.util.List;

public class PlantDetailsDTO {
    private Integer apiId;
    private String plantName;
    private String sunlight;
    private String watering;
    private String dimension;
    private List<String> propagation;
    private String image;

    // Constructor
    public PlantDetailsDTO(Integer apiId, String plantName, String sunlight, String watering, String dimension, List<String> propagation, String image) {
        this.apiId = apiId;
        this.plantName = plantName;
        this.sunlight = sunlight;
        this.watering = watering;
        this.dimension = dimension;
        this.propagation = propagation;
        this.image = image;
    }

    // Getters and Setters
    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getSunlight() {
        return sunlight;
    }

    public void setSunlight(String sunlight) {
        this.sunlight = sunlight;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public List<String> getPropagation() {
        return propagation;
    }

    public void setPropagation(List<String> propagation) {
        this.propagation = propagation;
    }

    public String getImage() {
        return image;
    }

    public PlantDetailsDTO setImage(String image) {
        this.image = image;
        return this;
    }
}
