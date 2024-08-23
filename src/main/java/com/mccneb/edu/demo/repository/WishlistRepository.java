package com.mccneb.edu.demo.repository;

import com.mccneb.edu.demo.model.Wishlist;
import com.mccneb.edu.demo.model.WishlistKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, WishlistKey> {
    List<Wishlist> findAllByIdUserEmail(String userEmail);
}
