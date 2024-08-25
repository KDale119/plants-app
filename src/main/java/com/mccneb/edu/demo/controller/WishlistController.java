package com.mccneb.edu.demo.controller;

import com.mccneb.edu.demo.model.AddToWishlistRequest;
import com.mccneb.edu.demo.model.Plant;
import com.mccneb.edu.demo.model.Wishlist;
import com.mccneb.edu.demo.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping
    public ResponseEntity<Wishlist> createWishlistEntry(@RequestBody AddToWishlistRequest wishlistRequest) {
        return ResponseEntity.ok(wishlistService.addToWishlist(wishlistRequest));
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<Plant>> getAllWishlistItemsForUser(@PathVariable String email) {
        return ResponseEntity.ok(wishlistService.getUsersWishlist(email));
    }

    @DeleteMapping("/{email}/{plantId}")
    public ResponseEntity<Void> deleteWishlistItem(@PathVariable String email, @PathVariable Integer plantId) {
        return wishlistService.deleteItem(email, plantId) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
