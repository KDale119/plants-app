package com.mccneb.edu.demo.repository;

import com.mccneb.edu.demo.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
    Optional<Plant> findByApiId(Integer apiId);
}
