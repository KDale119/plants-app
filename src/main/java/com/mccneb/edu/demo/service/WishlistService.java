package com.mccneb.edu.demo.service;

import com.mccneb.edu.demo.model.AddToWishlistRequest;
import com.mccneb.edu.demo.model.Plant;
import com.mccneb.edu.demo.model.Wishlist;
import com.mccneb.edu.demo.model.WishlistKey;
import com.mccneb.edu.demo.repository.PlantRepository;
import com.mccneb.edu.demo.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {
    private final PlantRepository plantRepository;
    private final PlantService plantService;
    private final WishlistRepository wishlistRepository;

    public WishlistService(PlantRepository plantRepository, PlantService plantService, WishlistRepository wishlistRepository) {
        this.plantRepository = plantRepository;
        this.plantService = plantService;
        this.wishlistRepository = wishlistRepository;
    }

    public Wishlist addToWishlist(AddToWishlistRequest wishlistRequest){
        Optional<Plant> plantByExternalApiId = plantRepository.findByApiId(wishlistRequest.getPlantExternalApiId());
        Plant plant = null;

        if(plantByExternalApiId.isPresent()){
            plant = plantByExternalApiId.get();
        } else {
            plant = plantService.findPlantByApiId(wishlistRequest.getPlantExternalApiId());
            plant = plantRepository.save(plant);
        }

        Wishlist wishlist = new Wishlist();
        WishlistKey wishlistKey = new WishlistKey();
        wishlist.setId(wishlistKey.setPlantId(plant.getPlantId()).setUserEmail(wishlistRequest.getEmailAddress()));
        return wishlistRepository.save(wishlist);
    }

    public List<Plant> getUsersWishlist(String userEmail){
        List<Wishlist> wishlist = wishlistRepository.findAllByIdUserEmail(userEmail);
        List<Plant> plants = new ArrayList<>();

        wishlist.forEach(wishlistItem -> {
            Optional<Plant> plant = plantRepository.findById(wishlistItem.getId().getPlantId());
            plant.ifPresent(plants::add);
        });

        return plants;
    }

    public Boolean deleteItem(String userEmailAddress, Integer externalApiId){
        Optional<Plant> plantByExternalApiId = plantRepository.findByApiId(externalApiId);
        if(plantByExternalApiId.isPresent()){
            WishlistKey wishlistKey = new WishlistKey();
            wishlistKey.setUserEmail(userEmailAddress).setPlantId(plantByExternalApiId.get().getPlantId());
            Optional<Wishlist> item = wishlistRepository.findById(wishlistKey);
            if(item.isPresent()){
                wishlistRepository.deleteById(wishlistKey);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
