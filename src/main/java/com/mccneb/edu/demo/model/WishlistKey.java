package com.mccneb.edu.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class WishlistKey implements Serializable {

    @Column(name = "useremail")
    private String userEmail;

    @Column(name = "plantid")
    private Integer plantId;

    public String getUserEmail() {
        return userEmail;
    }

    public WishlistKey setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public Integer getPlantId() {
        return plantId;
    }

    public WishlistKey setPlantId(Integer plantId) {
        this.plantId = plantId;
        return this;
    }
}
