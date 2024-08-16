package com.mccneb.edu.demo.service;

import com.mccneb.edu.demo.client.PlantClient;
import com.mccneb.edu.demo.mapper.PlantMapper;
import com.mccneb.edu.demo.mapper.SpeciesMapper;
import com.mccneb.edu.demo.model.ApiDetailsResults;
import com.mccneb.edu.demo.model.ApiSpeciesResults;
import com.mccneb.edu.demo.model.Plant;
import com.mccneb.edu.demo.repository.PlantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    private final PlantRepository plantRepository;
    private final PlantClient plantClient;
    private final SpeciesMapper speciesMapper;
    private final PlantMapper plantMapper;


    public PlantService(PlantRepository plantRepository, PlantClient plantClient, SpeciesMapper speciesMapper, PlantMapper plantMapper) {
        this.plantRepository = plantRepository;
        this.plantClient = plantClient;
        this.speciesMapper = speciesMapper;
        this.plantMapper = plantMapper;
    }

    public ResponseEntity<List<Plant>> getAllPlants(String q) {
        ApiSpeciesResults results = plantClient.getSpecies(q);
        List<Plant> plants = new ArrayList<>();
        results.getData().forEach(data -> {
            plants.add(speciesMapper.mapSpecies(data));
        });
        return ResponseEntity.ok(plants);
    }

    public ResponseEntity<Plant> findPlantById(Integer plantId) {
        Optional<Plant> optionalPlant = plantRepository.findById(plantId);
        if (optionalPlant.isPresent()) {
            Plant plant = optionalPlant.get();
            ApiDetailsResults results = plantClient.getDetails(plant.getPlantId());
            Plant mappedPlant = plantMapper.mapDetails(results, plant);
            return ResponseEntity.ok(mappedPlant);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Plant> addPlant(Plant add) {
        add = plantRepository.save(add);
        return ResponseEntity.ok(add);
    }

    public ResponseEntity<Plant> plantUpdate(Integer plantId, Plant update) {
        Optional<Plant> updatedPlant = plantRepository.findById(plantId);
        if (updatedPlant.isPresent()) {
            update = plantRepository.save(update);
            return ResponseEntity.ok(updatedPlant.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Plant> deletePlant(Integer plantId) {
        Optional<Plant> deletedPlant = plantRepository.findById(plantId);
        if (deletedPlant.isPresent()) {
            plantRepository.delete(deletedPlant.get());
            return ResponseEntity.ok(deletedPlant.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
