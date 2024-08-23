package com.mccneb.edu.demo.model;

public class AddToWishlistRequest {
    private String emailAddress;
    private Integer plantExternalApiId;

    public String getEmailAddress() {
        return emailAddress;
    }

    public AddToWishlistRequest setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public Integer getPlantExternalApiId() {
        return plantExternalApiId;
    }

    public AddToWishlistRequest setPlantExternalApiId(Integer plantExternalApiId) {
        this.plantExternalApiId = plantExternalApiId;
        return this;
    }
}
