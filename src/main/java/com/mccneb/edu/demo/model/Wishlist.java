package com.mccneb.edu.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "Wishlist")
public class Wishlist {
    @EmbeddedId
    private WishlistKey id;

    public WishlistKey getId() {
        return id;
    }

    public Wishlist setId(WishlistKey id) {
        this.id = id;
        return this;
    }
}
