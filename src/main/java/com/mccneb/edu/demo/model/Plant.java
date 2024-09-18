package com.mccneb.edu.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "Plant")
public class Plant {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "plantid")
    private Integer plantId;

    @Column(name = "apiid")
    private Integer apiId;

    @Column(name = "plantname")
    private String plantName;

    @Column(name = "dimension")
    private String dimension;

    @Column(name = "type")
    private String type;

    @Column(name = "plantsunlight")
    private String plantSunlight;

    @Column(name = "plantwatering")
    private String plantWatering;

    @Column(name = "image")
    private String image;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "scientificname")
    private String scientificName;

    @Column(name = "origin")
    private String origin;

    @Column(name = "propagation")
    private String propagation;

    public Integer getPlantId() {
        return plantId;
    }

    public void setPlantId(Integer plantId) {
        this.plantId = plantId;
    }

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

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlantSunlight() {
        return plantSunlight;
    }

    public void setPlantSunlight(String plantSunlight) {
        this.plantSunlight = plantSunlight;
    }

    public String getPlantWatering() {
        return plantWatering;
    }

    public void setPlantWatering(String plantWatering) {
        this.plantWatering = plantWatering;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPropagation() {
        return propagation;
    }

    public void setPropagation(String propagation) {
        this.propagation = propagation;
    }

}



